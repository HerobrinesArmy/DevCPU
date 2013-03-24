package devcpu.assembler.exceptions;

import devcpu.assembler.Directive;

public class DirectiveExpressionEvaluationException extends AbstractDirectiveException {
	private static final long serialVersionUID = 1L;

	public DirectiveExpressionEvaluationException(Directive directive) {
		super(directive);
	}
}
