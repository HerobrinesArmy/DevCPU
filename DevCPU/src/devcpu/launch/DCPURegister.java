package devcpu.launch;

import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.model.IRegister;
import org.eclipse.debug.core.model.IRegisterGroup;

public class DCPURegister extends DCPUVariable implements IRegister {

	private DCPURegisterGroup fGroup;
	DCPURegister(DCPUStackFrame frame, DCPURegisterGroup group, String name) {
		super(frame, name);
		fGroup = group;
	}

	public IRegisterGroup getRegisterGroup() throws DebugException {
		return fGroup;
	}

}
