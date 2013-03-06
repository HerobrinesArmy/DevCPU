package devcpu.lexer;

public abstract class StandardLexerToken extends LexerToken {
	private String text;
	private int start;
	private int end;
	private int length;
	
	public StandardLexerToken(String text, int start, int end) {
		this.text = text;
		this.length = text.length();
		this.start = start;
		this.end = end;
	}

	@Override
	public String getText() {
		return text;
	}

	@Override
	public int getStart() {
		return start;
	}

	@Override
	public int getEnd() {
		return end;
	}
	
	@Override
	public int getLength() {
		return length;
	}
	
	@Override
	public int getOffset() {
		return start;
	}
	
}
