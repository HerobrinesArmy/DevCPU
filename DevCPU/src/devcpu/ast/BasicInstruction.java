package devcpu.ast;

public class BasicInstruction extends DefaultNode implements Instruction {
	private BasicOpCode opcode;
	private Value b;
	private Value a;

	public BasicInstruction(String text, CodeLocator locator, BasicOpCode opcode, Value b, Value a) {
		super(text, locator);
		this.opcode = opcode;
		this.b = b;
		this.a = a;
	}

	@Override
	public OpCode getOpCode() {
		return opcode;
	}

	public Value getB() {
		return b;
	}
	
	@Override
	public Value getA() {
		return a;
	}
}
