package devcpu.assembler;

public class Include {
	private Directive directive;
	private String path;
	private AssemblyLine line;

	public Include(Directive directive) {
		this.directive = directive;
		this.line = directive.getLine();
		this.path = directive.getParametersToken().getText().replaceAll("[\"\'\\<\\>]", "").trim();
	}
	
	public Directive getDirective() {
		return directive;
	}

	public String getPath() {
		return path;
	}

	public AssemblyLine getLine() {
		return line;
	}
}
