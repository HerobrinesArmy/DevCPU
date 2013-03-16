package devcpu.assembler;

import devcpu.lexer.tokens.LabelToken;

public class LabelUse {
	private AssemblyLine line;
	private LabelToken token;
	private boolean caseSensitive;
	private String labelName;
	private boolean local;

	public LabelUse(AssemblyLine line, LabelToken token, boolean caseSensitive, String lastDefinedGlobalLabel) {
		this.line = line;
		this.token = token;
		this.caseSensitive = caseSensitive;
		if (token.isLocal()) {
			local = true;
			//TODO Handle the case where lastDefined is null
			this.labelName = caseSensitive ? lastDefinedGlobalLabel + token.getText() : (lastDefinedGlobalLabel + token.getText()).toUpperCase();
		} else {
			this.labelName = caseSensitive ? token.getText() : token.getText().toUpperCase();
		}
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
	
	public boolean isLocal() {
		return local;
	}
}
