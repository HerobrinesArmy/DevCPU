package devcpu.assembler;

import devcpu.lexer.tokens.LabelToken;

public class LabelUse {
	private AssemblyLine line;
	private LabelToken token;
	private boolean caseSensitive;
	private String labelName;

	public LabelUse(AssemblyLine line, LabelToken token, boolean caseSensitive) {
		this.line = line;
		this.token = token;
		this.caseSensitive = caseSensitive;
		this.labelName = caseSensitive ? token.getText().replace(":", "") : token.getText().replace(":", "").toUpperCase();
	}

	public AssemblyLine getLine() {
		return line;
	}

	public LabelToken getToken() {
		return token;
	}

	public boolean isCaseSensitive() {
		return caseSensitive;
	}

	public String getLabelName() {
		return labelName;
	}
}
