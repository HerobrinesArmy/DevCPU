package devcpu.assembler;

import devcpu.lexer.tokens.LabelDefinitionToken;

public class LabelDefinition {
	private AssemblyLine line;
	private LabelDefinitionToken token;
	private boolean caseSensitive;
	private String labelName;

	public LabelDefinition(AssemblyLine line, LabelDefinitionToken token, boolean caseSensitive) {
		//TODO This is a stupid approach as well. You're assuming that case insensitive means everything should be forced to uppercase.
		//You know that, but someone else trying to talk to any of these objects isn't necessarily going to know that.
		//You're bizarrely making the LabelDefinition and LabelUse classes responsible for the enabling of case insensitive labels. 
		this.line = line;
		this.token = token;
		this.caseSensitive = caseSensitive;
		this.labelName = caseSensitive ? token.getText().replace(":", "") : token.getText().replace(":", "").toUpperCase(); 
		
	}

	public AssemblyLine getLine() {
		return line;
	}

	public LabelDefinitionToken getToken() {
		return token;
	}

	public boolean isCaseSensitive() {
		return caseSensitive;
	}

	public String getLabelName() {
		return labelName;
	}
}
