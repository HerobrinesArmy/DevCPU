package devcpu.assembler.expression;

import devcpu.lexer.tokens.LexerToken;

public class Address extends Group {
	public Address(LexerToken[] tokens, int i, Class<? extends LexerToken> terminator) {
		super(tokens, i, terminator);
	}
}
