package devcpu.launch;

import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.model.DebugElement;
import org.eclipse.debug.core.model.IDebugTarget;
import org.eclipse.debug.core.model.IRegister;
import org.eclipse.debug.core.model.IRegisterGroup;

public class DCPURegisterGroup extends DebugElement implements IRegisterGroup {

	DCPURegister fRegister1;
	DCPURegister fRegister2;
	DCPUStackFrame fFrame;
	
	public DCPURegisterGroup(DCPUStackFrame frame)
	{
		super(frame.getDebugTarget());
		fFrame = frame;
	}
	
	public String getName() throws DebugException {
		return "Register Group";
	}

	public IRegister[] getRegisters() throws DebugException {
		if (fRegister1 == null)
			fRegister1 = new DCPURegister(fFrame, this, "eax");
		
		if (fRegister2 == null)
			fRegister2 = new DCPURegister(fFrame, this, "ebx");
		
		return new IRegister[] {fRegister1, fRegister2};
	}

	public boolean hasRegisters() throws DebugException {
		return true;
	}

	public String getModelIdentifier() {
		return fFrame.getModelIdentifier();
	}

	public IDebugTarget getDebugTarget() {
		return fFrame.getDebugTarget();
	}

	public ILaunch getLaunch() {
		return fFrame.getLaunch();
	}

}
