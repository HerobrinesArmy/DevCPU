package devcpu.launch;

import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.model.DebugElement;
import org.eclipse.debug.core.model.IDebugTarget;
import org.eclipse.debug.core.model.IValue;
import org.eclipse.debug.core.model.IVariable;

public class DCPUValue extends DebugElement implements IValue {

	private DCPUVariable fVariable;
	
	public DCPUValue(DCPUVariable variable)
	{
		super(variable.getDebugTarget());
		fVariable = variable;  
	}
	
	public String getReferenceTypeName() throws DebugException {
		return "";
	}

	public String getValueString() throws DebugException {
		return String.valueOf(System.currentTimeMillis());
	}

	public boolean isAllocated() throws DebugException {
		return false;
	}

	public IVariable[] getVariables() throws DebugException {
		return new IVariable[0];
	}

	public boolean hasVariables() throws DebugException {
		return false;
	}

	public String getModelIdentifier() {
		return fVariable.getModelIdentifier();
	}

	public IDebugTarget getDebugTarget() {
		return fVariable.getDebugTarget();
	}

	public ILaunch getLaunch() {
		return fVariable.getLaunch();
	}

}
