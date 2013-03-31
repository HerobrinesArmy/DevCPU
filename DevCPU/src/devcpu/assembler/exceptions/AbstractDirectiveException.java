package devcpu.assembler.exceptions;

import devcpu.assembler.Directive;
import devcpu.assembler.providers.DirectiveProvider;

public abstract class AbstractDirectiveException extends AbstractLineException implements DirectiveProvider {
	private static final long serialVersionUID = 1L;
	protected Directive directive;

	public AbstractDirectiveException(Directive directive) {
		super(directive.getLine());
		this.directive = directive;
	}

	@Override
	public Directive getDirective() {
		return directive;
	}
	
	@Override
	public String getMessage() {
		return "Directive error (" + directive.getDirectiveName() + ") at " + directive.getLine().getDocument().getFile().getName() + ", Line " + directive.getLine().getLineNumber() + ": " + directive.getLine().getText();
	}
}
