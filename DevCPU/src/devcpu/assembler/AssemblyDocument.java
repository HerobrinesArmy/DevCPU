package devcpu.assembler;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.Path;

import devcpu.assembler.exceptions.AbstractAssemblyException;

public class AssemblyDocument {
	private IFile file;
	private Assembly assembly;
	private AssemblyDocument parent;
//	private ArrayList<AssemblyLine> lines = new ArrayList<AssemblyLine>();
	private ArrayList<AssemblyDocument> children = new ArrayList<AssemblyDocument>();

	public AssemblyDocument(IFile file, Assembly assembly, AssemblyDocument parent) {
		this.file = file;
		//TODO This setup sucks. Documents should be dumb and shouldn't need a reference to the assembly. Rework this in a later release?
		this.assembly = assembly;
		this.parent = parent;
	}

	public List<RawLine> readLines() throws IOException, CoreException, AbstractAssemblyException {
		return assembly.getLineLoader().readLines(this);
	}

	public IFile getFile() {
		return file;
	}

//	public ArrayList<AssemblyLine> getLines() {
//		return lines;
//	}

	public Assembly getAssembly() {
		return assembly;
	}
	
	public ArrayList<AssemblyDocument> getChildren() {
		return children;
	}

	public boolean isRoot() {
		return parent == null;
	}
	
	public AssemblyDocument getParent() {
		return parent;
	}

	public AssemblyDocument loadChild(String path) { // throws AbstractAssemblyException, IOException, CoreException {
		IFile includeFile = locate(path);
		if (includeFile == null) {
//			throw new IncludeFileNotFoundException(path);
			return null;
		}
		if (checkForAncestor(includeFile)) {
//			throw new RecursiveInclusionException(includeFile);
			return null;
		}
		AssemblyDocument doc = new AssemblyDocument(includeFile, assembly, this);
		children.add(doc);
		return doc;
	}

	private boolean checkForAncestor(IFile includeFile) {
		AssemblyDocument ancestor = this;
		while (ancestor != null) {
			if (ancestor.file.equals(includeFile)) {
				return true;
			}
			ancestor = ancestor.getParent();
		}
		return false;
	}

	private IFile locate(String includePath) {
		Path path = new Path(includePath);
		//First, treat as path relative to current file ("../" is supported)
    IFile located = file.getParent().getFile(path);
    if (located.exists()) {
    	return located;
    }
    //Second, treat as path relative to project root
    located = file.getProject().getFile(path);
    if (located.exists()) {
    	return located;
    }
    //Third, treat as path relative to workspace root
    located = ResourcesPlugin.getWorkspace().getRoot().getFile(path);
    if (located.exists()) {
    	return located;
    }
    //TODO: Check for local filesystem paths too?
    //TODO: Maybe even Internet URLs?
    return null;
	}
}
