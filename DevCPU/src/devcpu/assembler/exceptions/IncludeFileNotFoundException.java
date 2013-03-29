package devcpu.assembler.exceptions;

import devcpu.assembler.Include;

public class IncludeFileNotFoundException extends AbstractDirectiveException {
	private static final long serialVersionUID = 1L;
	private Include include;

	public IncludeFileNotFoundException(Include include) {
		super(include.getDirective());
		this.include = include;
	}

	public Include getInclude() {
		return include;
	}
}
