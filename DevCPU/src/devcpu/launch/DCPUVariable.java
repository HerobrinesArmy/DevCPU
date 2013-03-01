package devcpu.launch;

import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.model.DebugElement;
import org.eclipse.debug.core.model.IDebugTarget;
import org.eclipse.debug.core.model.IValue;
import org.eclipse.debug.core.model.IVariable;

public class DCPUVariable extends DebugElement implements IVariable{

	private final DCPUStackFrame fFrame;
	private String fName;

	DCPUVariable(DCPUStackFrame frame, String name)
	{
		super(frame.getDebugTarget());
		fFrame = frame;
		fName = name;
	}

	public IValue getValue() throws DebugException {
		return new DCPUValue(this);
	}

	public String getName() throws DebugException {
		return fName;
	}

	public String getReferenceTypeName() throws DebugException {
		return "";
	}

	public boolean hasValueChanged() throws DebugException {
		return false;
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


	public void setValue(IValue value) throws DebugException {
		
	}
	public boolean supportsValueModification() {
		return false;
	}

	public boolean verifyValue(IValue value) throws DebugException {
		return false;
	}

	public void setValue(String expression) throws DebugException {
		
	}

	public boolean verifyValue(String expression) throws DebugException {
		return false;
	}
}