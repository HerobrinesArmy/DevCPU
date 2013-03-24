package devcpu.assembler.exceptions;

import devcpu.assembler.Directive;

public abstract class AbstractDirectiveException extends AbstractLineException implements IDirectiveException {
	private static final long serialVersionUID = 1L;
	private Directive directive;

	public AbstractDirectiveException(Directive directive) {
		super(directive.getLine());
		this.directive = directive;
	}

	@Override
	public Directive getDirective() {
		return directive;
	}
}
