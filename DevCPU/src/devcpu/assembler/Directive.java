package devcpu.assembler;

import devcpu.lexer.tokens.DirectiveParametersToken;
import devcpu.lexer.tokens.DirectiveToken;

//TODO: BETTER NAME
public class Directive {
	private AssemblyLine line;
	private DirectiveToken directiveToken;
	private String directiveName;
	private DirectiveParametersToken parametersToken;

	public Directive(AssemblyLine line, DirectiveToken directiveToken) {
		this.line = line;
		this.directiveToken = directiveToken;
		this.directiveName = directiveToken.getText().replaceAll("[\\.\\#]", "").toUpperCase();
	}

	public void setParameters(DirectiveParametersToken token) {
		this.parametersToken = token;
	}

	public AssemblyLine getLine() {
		return line;
	}

	public DirectiveToken getDirectiveToken() {
		return directiveToken;
	}

	public String getDirectiveName() {
		return directiveName;
	}

	public DirectiveParametersToken getParametersToken() {
		return parametersToken;
	}
 
	public boolean isInclude() {
		return "INCLUDE".equals(directiveName) || "IMPORT".equals(directiveName);
	}

	public boolean isDefine() {
		return "DEFINE".equals(directiveName);
	}
}
