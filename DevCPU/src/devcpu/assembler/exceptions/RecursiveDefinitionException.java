package devcpu.assembler.exceptions;

import devcpu.assembler.Directive;

public class RecursiveDefinitionException extends Exception {
	private static final long serialVersionUID = 1L;
	private Directive directive;

	public RecursiveDefinitionException(Directive directive) {
		this.directive = directive;
	}

	public Directive getDirective() {
		return directive;
	}
}
