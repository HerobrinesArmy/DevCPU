package devcpu.assembler.exceptions;

import devcpu.assembler.AssemblyDocument;
import devcpu.assembler.providers.DocumentProvider;

public class AbstractDocumentException extends AbstractAssemblyException implements DocumentProvider{
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
