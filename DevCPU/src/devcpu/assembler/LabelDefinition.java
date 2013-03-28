package devcpu.assembler;

import devcpu.lexer.tokens.LabelDefinitionToken;

public class LabelDefinition {
	private AssemblyLine line;
	private LabelDefinitionToken token;
	private boolean caseSensitive;
	private String labelName;
	private boolean local;

	public LabelDefinition(AssemblyLine line, LabelDefinitionToken token, boolean caseSensitive, String lastDefinedGlobalLabel) {
		//TODO This is a stupid approach as well. You're assuming that case insensitive means everything should be forced to uppercase.
		//You know that, but someone else trying to talk to any of these objects isn't necessarily going to know that.
		//You're bizarrely making the LabelDefinition and LabelUse classes responsible for the enabling of case insensitive labels. 
		this.line = line;
		this.token = token;
		this.caseSensitive = caseSensitive;
		if (token.isLocal()) {
			local = true;
			//TODO Handle the case where lastDefined is null
			this.labelName = caseSensitive ? lastDefinedGlobalLabel + token.getName() : (lastDefinedGlobalLabel + token.getName()).toUpperCase();
		} else {
			this.labelName = caseSensitive ? token.getName() : token.getName().toUpperCase();
		}
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
	
	public boolean isLocal() {
		return local;
	}
}
