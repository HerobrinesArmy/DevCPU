package devcpu.assembler.expression;

import java.util.ArrayList;
import java.util.List;

import devcpu.lexer.tokens.LexerToken;

public class Literal implements Operand {
	private int value;
	private LexerToken token;

	public Literal(LexerToken token, int value) {
		this.value = value;
		this.token = token;
	}

	@Override
	public boolean containsRegister() {
		return false;
	}

	@Override
	public List<Register> getRegisters() {
		return new ArrayList<Register>();
	}

	public int getValue() {
		return value;
	}

	public LexerToken getToken() {
		return token;
	}

	@Override
	public String getExpression() {
		return ""+value;
	}
}
