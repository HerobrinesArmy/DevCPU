package devcpu.assembler.expression;

import java.util.ArrayList;
import java.util.List;

import devcpu.lexer.tokens.RegisterToken;

public class Register implements Operand {
	private RegisterToken token;
	private String register;

	public Register(RegisterToken token) {
		this.token = token;
		this.register = token.getText().toUpperCase();
	}

	@Override
	public boolean containsRegister() {
		return true;
	}

	@Override
	public List<Register> getRegisters() {
		//This whole thing is stupid and I hate it.
		ArrayList<Register> list = new ArrayList<Register>();
		list.add(this);
		return list;
	}

	public RegisterToken getToken() {
		return token;
	}

	public String getRegister() {
		return register;
	}

	@Override
	public String getExpression() {
		return "0";
	}
}
