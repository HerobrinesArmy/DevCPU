package devcpu.assembler;

import devcpu.lexer.tokens.LexerToken;

public class AssemblyLine {
	private String text;
	private LexerToken[] tokens;
	private AssemblyDocument document;
	private int lineNumber;

	public AssemblyLine(AssemblyDocument document, int lineNumber, String lineText, LexerToken[] tokens) {
		this.document = document;
		this.lineNumber = lineNumber;
		this.text = lineText;
		this.tokens = tokens;
		
	}
	
	public String getText() {
		return text;
	}

	public LexerToken[] getTokens() {
		return tokens;
	}

	public AssemblyDocument getDocument() {
		return document;
	}

	public int getLineNumber() {
		return lineNumber;
	}
}
