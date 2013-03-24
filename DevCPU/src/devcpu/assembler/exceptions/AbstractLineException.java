package devcpu.assembler.exceptions;

import devcpu.assembler.AssemblyLine;

public abstract class AbstractLineException extends AbstractDocumentException implements ILineException {
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
