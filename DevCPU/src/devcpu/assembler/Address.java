package devcpu.assembler;

import devcpu.lexer.tokens.LexerToken;

public class Address extends Group {
	public Address(LexerToken[] tokens, int i, Class terminator) {
		super(tokens, i, terminator);
	}
}
