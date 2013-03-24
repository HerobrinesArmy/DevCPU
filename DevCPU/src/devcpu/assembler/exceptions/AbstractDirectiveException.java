package devcpu.assembler.exceptions;

import devcpu.assembler.Directive;
import devcpu.assembler.providers.DirectiveProvider;

public abstract class AbstractDirectiveException extends AbstractLineException implements DirectiveProvider {
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
