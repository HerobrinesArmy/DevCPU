package devcpu.lexer.tokens;

public abstract class TrimmedLexerToken extends LexerToken {
	protected String text;
	protected int start;
	protected int end;
	protected int length;
	
	public TrimmedLexerToken(String rawText, int startOffset, int endOffset) {
		this.text = rawText.trim();
		this.length = text.length();
		int offset = rawText.indexOf(text);
		this.start = startOffset + offset;
		this.end = start + length;
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
