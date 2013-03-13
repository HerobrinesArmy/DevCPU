package devcpu.assembler;

import java.io.IOException;
import java.util.ArrayList;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;

import devcpu.emulation.DefaultControllableDCPU;

public class Assembly {
	public static final boolean DEFAULT_LABELS_CASE_SENSITIVE = true;

	private AssemblyDocument rootDocument;
	private ArrayList<AssemblyDocument> documents = new ArrayList<AssemblyDocument>();
	private boolean labelsCaseSensitive = DEFAULT_LABELS_CASE_SENSITIVE;

	public Assembly(IFile file) throws IOException, DuplicateLabelDefinitionException, CoreException, IncludeFileNotFoundException, IncludeFileIsAncestorException {
		rootDocument = new AssemblyDocument(file, this, null);
		documents.add(rootDocument);
		loadIncludes(rootDocument);
	}

	private void loadIncludes(AssemblyDocument document) throws IncludeFileNotFoundException, IncludeFileIsAncestorException, IOException, DuplicateLabelDefinitionException, CoreException {
		for (Include include : document.getIncludes()) {
			//Why the hell are you doing this from here?
			documents.add(document.loadInclude(include));
		}		
	}

	public AssemblyDocument getRootDocument() {
		return rootDocument;
	}
	
	public IFile getFile() {
		return rootDocument.getFile();
	}

	public boolean isLabelsCaseSensitive() {
		return labelsCaseSensitive;
	}

	public void setLabelsCaseSensitive(boolean labelsCaseSensitive) {
		this.labelsCaseSensitive = labelsCaseSensitive;
	}

	public void assemble(DefaultControllableDCPU dcpu) {
		Assembler assembler = new Assembler(dcpu.ram);
		// TODO Auto-generated method stub
	}
}
