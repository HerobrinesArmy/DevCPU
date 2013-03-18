package devcpu.assembler.exceptions;

import java.util.List;

import devcpu.assembler.expression.Register;
import devcpu.lexer.tokens.LexerToken;

public class TooManyRegistersInExpressionException extends Exception {
	private static final long serialVersionUID = 1L;
	private List<Register> registers;
	private LexerToken[] tokens;
	private String valueType;

	public TooManyRegistersInExpressionException(List<Register> registers, LexerToken[] tokens, String type) {
		this.registers = registers;
		this.tokens = tokens;
		this.valueType = type;
	}

	public List<Register> getRegisters() {
		return registers;
	}

	public LexerToken[] getTokens() {
		return tokens;
	}

	public String getValueType() {
		return valueType;
	}
}
