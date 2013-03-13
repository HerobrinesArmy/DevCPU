package devcpu.assembler;

public class IncludeFileNotFoundException extends Exception {
	private static final long serialVersionUID = 1L;
	private Include include;

	public IncludeFileNotFoundException(Include include) {
		this.include = include;
	}

	public Include getInclude() {
		return include;
	}
}
