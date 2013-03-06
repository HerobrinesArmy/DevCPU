package devcpu.ast;

public class SpecialInstruction extends DefaultNode implements Instruction {
	private SpecialOpCode opcode;
	private Value a;

	public SpecialInstruction(String text, CodeLocator locator, SpecialOpCode opcode, Value a) {
		super(text, locator);
		this.opcode = opcode;
		this.a = a;
	}

	@Override
	public OpCode getOpCode() {
		return opcode;
	}

	@Override
	public Value getA() {
		return a;
	}
}
