package devcpu.assembler.exceptions;

import devcpu.assembler.Assembly;
import devcpu.lexer.tokens.LexerToken;

public class BadValueException extends AbstractAssemblyException {
	private static final long serialVersionUID = 1L;
	private LexerToken[] tokens;
	private String msg;
	
	public BadValueException(Assembly assembly, LexerToken[] tokens, String msg) {
		super(assembly);
		this.tokens = tokens;
		this.msg = msg;
	}

	public LexerToken[] getTokens() {
		return tokens;
	}

	@Override
	public String getMessage() {
		return msg;
	}
}
