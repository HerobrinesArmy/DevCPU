package devcpu.ast;

public interface Instruction extends Node {
	public OpCode getOpCode();
	
	public Value getA();
}
