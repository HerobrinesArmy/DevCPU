package devcpu.assembler.exceptions;

import devcpu.assembler.Directive;

public class OriginBacktrackException extends AbstractDirectiveException {
	private static final long serialVersionUID = 1L;

	public OriginBacktrackException(Directive directive) {
		super(directive);
	}
}
