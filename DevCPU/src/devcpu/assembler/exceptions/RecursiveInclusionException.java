package devcpu.assembler.exceptions;

import org.eclipse.core.resources.IFile;

public class RecursiveInclusionException extends Exception {
	private static final long serialVersionUID = 1L;
	private IFile file;

	public RecursiveInclusionException(IFile file) {
		this.file = file;
	}

	public IFile getFile() {
		return file;
	}
	
	@Override
	public String getMessage() {
		return "Infinitely recursive inclusion error for " + file.getFullPath().toOSString();//at " + directive.getLine().getDocument().getFile().getName() + ", Line " + directive.getLine().getLineNumber() + ": " + directive.getLine().getText();
	}
}
