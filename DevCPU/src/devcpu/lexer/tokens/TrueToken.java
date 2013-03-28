package devcpu.lexer.tokens;

public class TrueToken extends StandardLexerToken {

	public TrueToken(String text, int start, int end) {
		super(text, start, end);
	}

	@Override
	public String getType() {
		return "DASM_TRUE";
	}

	@Override
	public boolean isUndefined() {
		return true;
	}

	@Override
	public boolean isWhitespace() {
		return false;
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
		// TODO Auto-generated method stub
		return null;
	}
}
