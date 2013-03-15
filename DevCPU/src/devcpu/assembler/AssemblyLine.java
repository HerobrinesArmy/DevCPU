package devcpu.assembler;

import devcpu.lexer.tokens.LexerToken;

public class AssemblyLine {
	private String text;
	private LexerToken[] sourceTokens;
	private LexerToken[] processedTokens;
	private AssemblyDocument document;
	private int lineNumber;
	private Directive directive;
	private int offset;
	private int size;

	public AssemblyLine(AssemblyDocument document, int lineNumber, String lineText, LexerToken[] tokens) {
		this.document = document;
		this.lineNumber = lineNumber;
		this.text = lineText;
		this.processedTokens = this.sourceTokens = tokens;
	}
	
	public String getText() {
		return text;
	}

	public LexerToken[] getTokens() {
		return sourceTokens;
	}

	public LexerToken[] getProcessedTokens() {
		return processedTokens;
	}

	public void setProcessedTokens(LexerToken[] processedTokens) {
		this.processedTokens = processedTokens;
	}

	public AssemblyDocument getDocument() {
		return document;
	}

	public int getLineNumber() {
		return lineNumber;
	}

	public void setDirective(Directive directive) {
		this.directive = directive;
	}

	public Directive getDirective() {
		return directive;
	}
	
	public boolean isDirective() {
		return directive != null;
	}

	public void setOffset(int offset) {
		this.offset = offset;
	}

	public int getOffset() {
		return offset;
	}

	public void setSize(int size) {
		this.size = size;
	}
	
	public int getSize() {
		return size;
	}
}
