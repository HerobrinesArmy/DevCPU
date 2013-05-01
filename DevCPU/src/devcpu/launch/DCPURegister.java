package devcpu.launch;

import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.model.IRegister;
import org.eclipse.debug.core.model.IRegisterGroup;

public class DCPURegister extends DCPUVariable implements IRegister {
	private DCPURegisterGroup group;
	private DCPUDebugTarget target;
	private String name;

	public DCPURegister(DCPURegisterGroup group, String name, DCPUDebugTarget target) {
		super(target, name);
		this.group = group;
		this.name = name;
		this.target = target;
	}

	public IRegisterGroup getRegisterGroup() throws DebugException {
		return group;
	}

	public DCPUDebugTarget getDebugTarget() {
		return target;
	}

	public String getName() {
		return name;
	}
	
	@Override
	public String getReferenceTypeName() throws DebugException {
		return "Register";
	}
}
