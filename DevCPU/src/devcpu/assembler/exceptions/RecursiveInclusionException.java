package devcpu.assembler.exceptions;

import org.eclipse.core.resources.IFile;

import devcpu.assembler.Include;

public class RecursiveInclusionException extends AbstractDirectiveException {
	private static final long serialVersionUID = 1L;
	private Include include;
	private IFile file;

	public RecursiveInclusionException(Include include, IFile file) {
		super(include.getDirective());
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
