package devcpu.lexer.tokens;

public class EndOfLineToken extends TrimmedLexerToken {
	public EndOfLineToken(String text, int start, int end) {
		super(text, start, end);
	}

	@Override
	public String getType() {
		return "DASM_EOL";
	}

	@Override
	public boolean isUndefined() {
		return false;
	}

	@Override
	public boolean isWhitespace() {
		return true;
	}

	@Override
	public boolean isEOF() {
		return false;
	}

	@Override
	public boolean isOther() {
		return false;
	}

	@Override
	public Object getData() {
		return null;
	}
}
