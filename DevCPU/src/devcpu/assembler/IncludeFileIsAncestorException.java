package devcpu.assembler;

import org.eclipse.core.resources.IFile;

public class IncludeFileIsAncestorException extends Exception {
	private static final long serialVersionUID = 1L;
	private Include include;
	private IFile file;

	public IncludeFileIsAncestorException(Include include, IFile file) {
		this.include = include;
		this.file = file;
	}

	public Include getInclude() {
		return include;
	}

	public IFile getFile() {
		return file;
	}
}
