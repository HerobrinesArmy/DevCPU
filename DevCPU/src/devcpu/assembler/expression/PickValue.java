package devcpu.assembler.expression;

import devcpu.lexer.tokens.LexerToken;

public class PickValue extends Group {
	public PickValue(LexerToken[] tokens, int i, Class terminator) {
		super(tokens, i, terminator);
	}
}
