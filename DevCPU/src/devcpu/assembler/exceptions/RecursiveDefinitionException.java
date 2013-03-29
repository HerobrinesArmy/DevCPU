package devcpu.assembler.exceptions;

import devcpu.assembler.Directive;

public class RecursiveDefinitionException extends AbstractDirectiveException {
	private static final long serialVersionUID = 1L;

	public RecursiveDefinitionException(Directive directive) {
		super(directive);
	}
}
