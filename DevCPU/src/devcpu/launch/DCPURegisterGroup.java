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
	private DCPUDebugTarget target;
	
	public DCPURegisterGroup(DCPUDebugTarget target)
	{
		super(target);
		this.target = target;
		createRegisters();
	}
	
	private void createRegisters() {
		a = new DCPURegister(this, "A", target);
		b = new DCPURegister(this, "B", target);
		c = new DCPURegister(this, "C", target);
		x = new DCPURegister(this, "X", target);
		y = new DCPURegister(this, "Y", target);
		z = new DCPURegister(this, "Z", target);
		i = new DCPURegister(this, "I", target);
		j = new DCPURegister(this, "J", target);
		pc = new DCPURegister(this, "PC", target);
		sp = new DCPURegister(this, "SP", target);
		ex = new DCPURegister(this, "EX", target);
		ia = new DCPURegister(this, "IA", target);
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
		return target.getModelIdentifier();
	}

	public IDebugTarget getDebugTarget() {
		return target;
	}

	public ILaunch getLaunch() {
		return target.getLaunch();
	}
}
