package devcpu.assembler.exceptions;

import devcpu.assembler.AssemblyLine;
import devcpu.assembler.providers.LineProvider;

public abstract class AbstractLineException extends AbstractDocumentException implements LineProvider {
	private static final long serialVersionUID = 1L;
	protected AssemblyLine line;
	
	public AbstractLineException(AssemblyLine line) {
		super(line.getDocument());
		this.line = line;
	}
	
	@Override
	public AssemblyLine getLine() {
		return line;
	}
}
