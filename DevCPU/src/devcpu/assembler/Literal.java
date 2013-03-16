package devcpu.assembler;

import java.util.ArrayList;
import java.util.List;

public class Literal implements Operand {
	@Override
	public boolean containsRegister() {
		return false;
	}

	@Override
	public List<Register> getRegisters() {
		return new ArrayList<Register>();
	}
}
