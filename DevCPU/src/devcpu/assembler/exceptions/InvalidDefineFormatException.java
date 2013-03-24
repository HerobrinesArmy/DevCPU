package devcpu.assembler.exceptions;

import devcpu.assembler.Directive;

public class InvalidDefineFormatException extends AbstractDirectiveException {
	private static final long serialVersionUID = 1L;

	public InvalidDefineFormatException(Directive directive) {
		super(directive);
	}
}
