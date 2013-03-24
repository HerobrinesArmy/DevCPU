package devcpu.assembler.exceptions;

import devcpu.assembler.AssemblyDocument;

public class AbstractDocumentException extends AbstractAssemblyException implements IDocumentException{
	private static final long serialVersionUID = 1L;
	protected AssemblyDocument document;

	public AbstractDocumentException(AssemblyDocument document) {
		super(document.getAssembly());
		this.document = document;
	}

	@Override
	public AssemblyDocument getDocument() {
		return document;
	}
}
