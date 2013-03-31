package devcpu.assembler.exceptions;

import devcpu.assembler.Directive;

public class OriginBacktrackException extends AbstractDirectiveException {
	private static final long serialVersionUID = 1L;

	public OriginBacktrackException(Directive directive) {
		super(directive);
	}
	
	@Override
	public String getMessage() {
		return "Directive (" + directive.getDirectiveName() + ") is trying to move the origin backwards at " + directive.getLine().getDocument().getFile().getName() + ", Line " + directive.getLine().getLineNumber() + ": " + directive.getLine().getText();
	}
}
