package devcpu.assembler.exceptions;

import devcpu.assembler.Directive;

public class DirectiveExpressionEvaluationException extends AbstractDirectiveException {
	private static final long serialVersionUID = 1L;

	public DirectiveExpressionEvaluationException(Directive directive) {
		super(directive);
	}
	
	@Override
	public String getMessage() {
		return "Error evaluating expression in directive (" + directive.getDirectiveName() + ") at " + directive.getLine().getDocument().getFile().getName() + ", Line " + directive.getLine().getLineNumber() + ": " + directive.getLine().getText();
	}
}
