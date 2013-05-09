package devcpu.assembler;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.Path;

import devcpu.assembler.exceptions.AbstractAssemblyException;
import devcpu.assembler.exceptions.IncludeFileNotFoundException;
import devcpu.assembler.exceptions.RecursiveInclusionException;

public class AssemblyDocument {
	private IFile file;
	private Assembly assembly;
	private AssemblyDocument parent;
	private ArrayList<AssemblyLine> lines = new ArrayList<AssemblyLine>();
	private LinkedHashMap<Directive,AssemblyDocument> children = new LinkedHashMap<Directive, AssemblyDocument>();

	public AssemblyDocument(IFile file, Assembly assembly, AssemblyDocument parent) {
		this.file = file;
		//TODO This setup sucks. Documents should be dumb and shouldn't need a reference to the assembly. Rework this in a later release?
		this.assembly = assembly;
		this.parent = parent;
	}

	public List<RawLine> readLines() throws IOException, CoreException, AbstractAssemblyException {
		return assembly.getLineLoader().readLines(this);
/*		//TODO Don't include in assembly time the time spent prompting user to save
		UIJob promptJob = new UIJob("Promp to save changes") {
			@Override
			public IStatus runInUIThread(IProgressMonitor monitor) {
				return IDE.saveAllEditors(new IResource[]{file}, true) ? Status.OK_STATUS : Status.CANCEL_STATUS;
			}
			@Override
			public boolean belongsTo(Object family) {
				return AssemblyDocument.this.equals(family);
			}
		};
		promptJob.schedule();
		try {
			UIJob.getJobManager().join(this, null);
		} catch (OperationCanceledException e) {
			//TODO
			e.printStackTrace();
		} catch (InterruptedException e) {
			//TODO
			e.printStackTrace();
		}
		
		CountingLineReader isr = new CountingLineReader(new InputStreamReader(file.getContents(true)));
		String lineText = null;
		int n = 0;
		while((lineText=isr.readLine()) != null) {
			AssemblyLine line = null;
			String text = lineText;
			++n;
//			boolean tokenize = true;
//			while (tokenize) {
				line = new AssemblyLine(this, n, text, isr.getLastLineOffset());
//				tokenize = false;
//				Directive directive = null;
//				for (LexerToken token : line.getTokens()) {
//					if (token instanceof DirectiveToken) {
//						directive = new Directive(line, (DirectiveToken) token);
//					} else if (token instanceof DirectiveParametersToken) {
//						directive.setParameters((DirectiveParametersToken)token);
//						line.setDirective(directive);
//						if (directive.isInclude()) {
//							AssemblyDocument doc = loadInclude(new Include(directive));
//							children.put(directive,doc);
//							doc.readLines();
//						} else if (directive.isDefine()) {
//							for (String key : assembly.defines.keySet()) {
//								//TODO Even this won't catch the bizarre case where the directive name itself is specified by an earlier define
//								//TODO This has slowed down the assembly. Consider switching it back and detecting the case in preprocssAndSize, and doing an additional preprocess=true pass if it happens.
//								//TODO Yeah, screw that. Just make a normal preprocessor and be done with it
//								Pattern pattern = Pattern.compile("\\b"+Pattern.quote(key)+"\\b");
//								if (pattern.matcher(text).find()) {
//									tokenize = true;
//									text = text.replaceAll(pattern.pattern(), assembly.defines.get(key).getValue());
//								}
//							}
//							if (tokenize) {
//								line.setProcessedTokens(Lexer.get().generateTokens(text, true));
//							} else {
//								Define define = new Define(directive);
//								assembly.defines.put(define.getKey(), define);
//							}
//						}
//					}
//				}
//			}
			lines.add(line); 
			assembly.lines.add(line);
		}
		isr.close();*/
	}

	public IFile getFile() {
		return file;
	}

	public ArrayList<AssemblyLine> getLines() {
		return lines;
	}

	public Assembly getAssembly() {
		return assembly;
	}
	
	public LinkedHashMap<Directive, AssemblyDocument> getChildren() {
		return children;
	}

	public boolean isRoot() {
		return parent == null;
	}
	
	public AssemblyDocument getParent() {
		return parent;
	}

	private AssemblyDocument loadInclude(Include include) throws AbstractAssemblyException, IOException, CoreException {
		IFile includeFile = locate(include);
		if (includeFile == null) {
			throw new IncludeFileNotFoundException(include);
		}
		if (checkForAncestor(includeFile)) {
			throw new RecursiveInclusionException(include, includeFile);
		}
		return new AssemblyDocument(includeFile, assembly, this);
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

	private IFile locate(Include include) {
		Path path = new Path(include.getPath());
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
