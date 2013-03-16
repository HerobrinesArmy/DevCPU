package devcpu.assembler;

import java.util.ArrayList;
import java.util.List;

import devcpu.lexer.tokens.LexerToken;

public class Group implements Operand {
	private ArrayList<Value> values = new ArrayList<Value>();
	
	public Group (LexerToken[] tokens, int i, Class terminator) {
		LexerToken token = null;
		while (!terminator.isInstance(token = tokens[++i])) {
			//TODO
//			if (token instanceof )
		}
	}
	
	public List<Value> getValues() {
		return values;
	}

	@Override
	public boolean containsRegister() {
		for (Value value : values) {
			if (value instanceof Operand) {
				if (((Operand)value).containsRegister()) {
					return true;
				}
			}
		}
		return false;
	}

	@Override
	public List<Register> getRegisters() {
		List<Register> list = new ArrayList<Register>();
		for (Value value : values) {
			
		}
		return null;
	}
}
