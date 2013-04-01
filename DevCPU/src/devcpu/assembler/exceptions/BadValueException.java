package devcpu.assembler.exceptions;

import devcpu.assembler.AssemblyLine;
import devcpu.lexer.tokens.LexerToken;

public class BadValueException extends AbstractLineException {
	private static final long serialVersionUID = 1L;
	private LexerToken[] tokens;
	private String msg;
	
	public BadValueException(AssemblyLine line, LexerToken[] tokens, String msg) {
		super(line);
		this.tokens = tokens;
		this.msg = msg;
	}

	public LexerToken[] getTokens() {
		return tokens;
	}

	@Override
	public String getMessage() {
		return msg + " At " + line.getDocument().getFile().getName() + ", Line " + line.getLineNumber() + ": " + line.getText();
	}
}
