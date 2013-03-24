package devcpu.assembler.exceptions;

import java.util.List;

import devcpu.assembler.Assembly;
import devcpu.assembler.expression.Register;
import devcpu.lexer.tokens.LexerToken;

public class TooManyRegistersInExpressionException extends AbstractAssemblyException {
	private static final long serialVersionUID = 1L;
	private List<Register> registers;
	private LexerToken[] tokens;
	private String valueType;

	public TooManyRegistersInExpressionException(Assembly assembly, List<Register> registers, LexerToken[] tokens, String type) {
		super(assembly);
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
