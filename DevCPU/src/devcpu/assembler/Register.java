package devcpu.assembler;

import java.util.ArrayList;
import java.util.List;

public class Register implements Operand {
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
}
