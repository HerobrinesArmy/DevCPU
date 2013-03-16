package devcpu.assembler;

import java.util.List;

public interface Operand extends Value {
	public boolean containsRegister();
	public List<Register> getRegisters();
}
