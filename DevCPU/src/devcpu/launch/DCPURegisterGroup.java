package devcpu.launch;

import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.model.DebugElement;
import org.eclipse.debug.core.model.IDebugTarget;
import org.eclipse.debug.core.model.IRegister;
import org.eclipse.debug.core.model.IRegisterGroup;

public class DCPURegisterGroup extends DebugElement implements IRegisterGroup {
	//TODO Collection instead
	DCPURegister a;
	DCPURegister b;
	DCPURegister c;
	DCPURegister x;
	DCPURegister y;
	DCPURegister z;
	DCPURegister i;
	DCPURegister j;
	DCPURegister pc;
	DCPURegister sp;
	DCPURegister ex;
	DCPURegister ia;
	DCPUStackFrame frame;
	private DCPUDebugTarget target;
	
	public DCPURegisterGroup(DCPUStackFrame frame, DCPUDebugTarget target)
	{
		super(frame.getDebugTarget());
		this.frame = frame;
		this.target = target;
		createRegisters();
	}
	
	private void createRegisters() {
		a = new DCPURegister(frame, this, "A", target);
		b = new DCPURegister(frame, this, "B", target);
		c = new DCPURegister(frame, this, "C", target);
		x = new DCPURegister(frame, this, "X", target);
		y = new DCPURegister(frame, this, "Y", target);
		z = new DCPURegister(frame, this, "Z", target);
		i = new DCPURegister(frame, this, "I", target);
		j = new DCPURegister(frame, this, "J", target);
		pc = new DCPURegister(frame, this, "PC", target);
		sp = new DCPURegister(frame, this, "SP", target);
		ex = new DCPURegister(frame, this, "EX", target);
		ia = new DCPURegister(frame, this, "IA", target);
	}

	public String getName() throws DebugException {
		return "Register Group";
	}

	public IRegister[] getRegisters() throws DebugException {
		return new IRegister[] {a, b, c, x, y, z, i, j, pc, sp, ex, ia};
	}

	public boolean hasRegisters() throws DebugException {
		return true;
	}

	public String getModelIdentifier() {
		return frame.getModelIdentifier();
	}

	public IDebugTarget getDebugTarget() {
		return frame.getDebugTarget();
	}

	public ILaunch getLaunch() {
		return frame.getLaunch();
	}
}
