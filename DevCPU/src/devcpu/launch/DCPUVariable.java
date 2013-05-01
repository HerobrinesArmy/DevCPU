package devcpu.launch;

import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.model.DebugElement;
import org.eclipse.debug.core.model.IDebugTarget;
import org.eclipse.debug.core.model.IValue;
import org.eclipse.debug.core.model.IVariable;

public class DCPUVariable extends DebugElement implements IVariable{
	private final DCPUDebugTarget target;
	private String name;

	DCPUVariable(DCPUDebugTarget target, String name)
	{
		super(target);
		this.target = target;
		this.name = name;
	}

	public IValue getValue() throws DebugException {
		return new DCPUValue(this);
	}

	public String getName() throws DebugException {
		return name;
	}

	public String getReferenceTypeName() throws DebugException {
		return "Variable";
	}

	public boolean hasValueChanged() throws DebugException {
		//TODO
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

	public void setValue(IValue value) throws DebugException {
		//TODO
	}
	
	public boolean supportsValueModification() {
		return true;
	}

	public boolean verifyValue(IValue value) throws DebugException {
		//TODO
		return false;
	}

	public void setValue(String expression) throws DebugException {
		//TODO
	}

	public boolean verifyValue(String expression) throws DebugException {
		//TODO
		return false;
	}
}