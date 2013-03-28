package devcpu.assembler.expression;

import devcpu.lexer.tokens.LexerToken;

public class Operator implements Value {
	private LexerToken token;

	public Operator(LexerToken token) {
		this.token = token;
	}

	public LexerToken getToken() {
		return token;
	}

	@Override
	public String getExpression() {
		return token.getText();
	}

	public String getOperator() {
		return token.getText();
	}	
}
