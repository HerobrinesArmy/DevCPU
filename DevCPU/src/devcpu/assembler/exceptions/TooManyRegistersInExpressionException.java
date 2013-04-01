package devcpu.assembler.exceptions;

import java.util.ArrayList;
import java.util.List;

import devcpu.assembler.AssemblyLine;
import devcpu.lexer.tokens.LexerToken;

public class TooManyRegistersInExpressionException extends AbstractLineException {
	private static final long serialVersionUID = 1L;
	private List<String> registers;
	private LexerToken[] tokens;
	private String valueType;

	public TooManyRegistersInExpressionException(AssemblyLine line, ArrayList<String> registers, LexerToken[] tokens, String type) {
		super(line);
		this.registers = registers;
		this.tokens = tokens;
		this.valueType = type;
	}

	public List<String> getRegisters() {
		return registers;
	}

	public LexerToken[] getTokens() {
		return tokens;
	}

	public String getValueType() {
		return valueType;
	}
	
	@Override
	public String getMessage() {
		String rs = "";
		for (String r : registers) {
			if (rs.length() == 0) {
				rs = r;
			} else {
				rs += "," + r;
			}
		}
		return "Too many registers (" + rs + ") in expression for " + valueType + " value at " + line.getDocument().getFile().getName() + ", Line " + line.getLineNumber() + ": " + line.getText();
	}
}
