package devcpu.assembler.exceptions;

import devcpu.assembler.Directive;

public class InvalidDefineFormatException extends AbstractDirectiveException {
	private static final long serialVersionUID = 1L;

	public InvalidDefineFormatException(Directive directive) {
		super(directive);
	}
	
	@Override
	public String getMessage() {
		return "Invalid define format at " + directive.getLine().getDocument().getFile().getName() + ", Line " + directive.getLine().getLineNumber() + ": " + directive.getLine().getText();
	}
}
