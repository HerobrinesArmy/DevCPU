package devcpu.assembler.expression;

import java.util.ArrayList;
import java.util.List;

import devcpu.lexer.tokens.LexerToken;
import devcpu.lexer.tokens.SimpleStackAccessToken;

public class SimpleStackAccessor implements Operand {
	private SimpleStackAccessToken token;
	private String accessor;

	public SimpleStackAccessor(SimpleStackAccessToken token) {
		this.token = token;
		this.accessor = token.getText().toUpperCase().replaceAll("\\s+", "");
	}

	@Override
	public boolean containsRegister() {
		return false;
	}

	@Override
	public List<Register> getRegisters() {
		return new ArrayList<Register>();
	}

	public LexerToken getToken() {
		return token;
	}

	@Override
	public String getExpression() {
		return "0";//NOT ALLOWED IN EXPRESSION
	}
	
	public String getAccessor() {
		return accessor;
	}
}
