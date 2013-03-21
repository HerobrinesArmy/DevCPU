package devcpu.launch;

import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.model.DebugElement;
import org.eclipse.debug.core.model.IDebugTarget;
import org.eclipse.debug.core.model.IValue;
import org.eclipse.debug.core.model.IVariable;

public class DCPUVariable extends DebugElement implements IVariable{
	private final DCPUStackFrame frame;
	private String name;

	DCPUVariable(DCPUStackFrame frame, String name)
	{
		super(frame.getDebugTarget());
		this.frame = frame;
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
		return frame.getModelIdentifier();
	}

	public IDebugTarget getDebugTarget() {
		return frame.getDebugTarget();
	}

	public ILaunch getLaunch() {
		return frame.getLaunch();
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