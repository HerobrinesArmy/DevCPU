package devcpu.launch;

import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.model.IRegister;
import org.eclipse.debug.core.model.IRegisterGroup;

public class DCPURegister extends DCPUVariable implements IRegister {
	private DCPURegisterGroup group;
	private DCPUDebugTarget target;
	private DCPUStackFrame frame;
	private String name;

	public DCPURegister(DCPUStackFrame frame, DCPURegisterGroup group, String name, DCPUDebugTarget target) {
		super(frame, name);
		this.frame = frame;
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

	public DCPUStackFrame getStackFrame() {
		return frame;
	}

	public String getName() {
		return name;
	}
	
	@Override
	public String getReferenceTypeName() throws DebugException {
		return "Register";
	}
}
