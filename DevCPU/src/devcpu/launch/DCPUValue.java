package devcpu.launch;

import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.model.DebugElement;
import org.eclipse.debug.core.model.IDebugTarget;
import org.eclipse.debug.core.model.IValue;
import org.eclipse.debug.core.model.IVariable;

public class DCPUValue extends DebugElement implements IValue {
	private DCPUVariable variable;
	private boolean isRegister;
	
	public DCPUValue(DCPUVariable variable)
	{
		super(variable.getDebugTarget());
		this.variable = variable;
		this.isRegister = variable instanceof DCPURegister;
	}
	
	public String getReferenceTypeName() throws DebugException {
		return "Word";
	}

	public String getValueString() throws DebugException {
		if (isRegister) {
			char v = ((DCPUDebugTarget)variable.getDebugTarget()).getRegisterValue((DCPURegister)variable);
			return "0x" + (v < 0x1000 ? "0" : "") + (v < 0x100 ? "0" : "") + (v < 0x10 ? "0" : "") + Integer.toHexString(v);
		}
		return "?";
	}

	public boolean isAllocated() throws DebugException {
		return true;
	}

	public IVariable[] getVariables() throws DebugException {
		return new IVariable[0];
	}

	public boolean hasVariables() throws DebugException {
		return false;
	}

	public String getModelIdentifier() {
		return variable.getModelIdentifier();
	}

	public IDebugTarget getDebugTarget() {
		return variable.getDebugTarget();
	}

	public ILaunch getLaunch() {
		return variable.getLaunch();
	}
}
