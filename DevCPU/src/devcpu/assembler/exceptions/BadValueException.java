package devcpu.assembler.exceptions;

import devcpu.lexer.tokens.LexerToken;

public class BadValueException extends Exception {
	private static final long serialVersionUID = 1L;
	private LexerToken[] tokens;
	private String msg;
	
	public BadValueException(LexerToken[] tokens, String msg) {
		this.tokens = tokens;
		this.msg = msg;
	}

	public LexerToken[] getTokens() {
		return tokens;
	}

	public String getMsg() {
		return msg;
	}
}
