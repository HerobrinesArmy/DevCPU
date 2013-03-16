package devcpu.assembler.exceptions;

import devcpu.assembler.Directive;

public class DirectiveExpressionEvaluationException extends Exception {
	private static final long serialVersionUID = 1L;
	private Directive directive;

	public DirectiveExpressionEvaluationException(Directive directive) {
		this.directive = directive;
	}

	public Directive getDirective() {
		return directive;
	}
}
