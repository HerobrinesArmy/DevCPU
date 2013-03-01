package devcpu.launch;

import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.model.DebugElement;
import org.eclipse.debug.core.model.IDebugTarget;
import org.eclipse.debug.core.model.IRegisterGroup;
import org.eclipse.debug.core.model.IStackFrame;
import org.eclipse.debug.core.model.IThread;
import org.eclipse.debug.core.model.IVariable;

public class DCPUStackFrame extends DebugElement implements IStackFrame {

	private DCPUThread fThread;
	private DCPURegisterGroup fRegisterGroup;
	private long timeStamp;
	private String fName;
	
	/**
	 * Constructs a DCPUStackFrame
	 * @param thread
	 * @param name
	 */
	public DCPUStackFrame(DCPUThread thread, String name)
	{
		super(thread.getDebugTarget());
		fThread = thread;
		fName = name;
		timeStamp = System.currentTimeMillis();
	}
	
	public IThread getThread() {
		return fThread;
	}

	public IVariable[] getVariables() throws DebugException {
		
		return new IVariable[]{new DCPUVariable(this, "sampleVariable")};
	}

	public boolean hasVariables() throws DebugException {
		return true;
	}

	public Object getAdapter(Class adapter) {
		if (adapter == ILaunch.class)
			return getLaunch();
		return super.getAdapter(adapter);
	}

	public int getLineNumber() throws DebugException {
		return 0;
	}

	public int getCharStart() throws DebugException {
		return 0;
	}

	public int getCharEnd() throws DebugException {
		return 0;
	}

	public String getName() throws DebugException {
		return "[Stackframe:] " + fName + " " + timeStamp;
	}

	public IRegisterGroup[] getRegisterGroups() throws DebugException {
		if (fRegisterGroup == null)
			fRegisterGroup = new DCPURegisterGroup(this);
		return new IRegisterGroup[] {fRegisterGroup};
	}

	public boolean hasRegisterGroups() throws DebugException {
		return true;
	}

	public String getModelIdentifier() {
		return fThread.getModelIdentifier();
	}

	public IDebugTarget getDebugTarget() {
		return fThread.getDebugTarget();
	}

	public ILaunch getLaunch() {
		return fThread.getDebugTarget().getLaunch();
	}

	public boolean canStepInto() {
		return false;
	}

	public boolean canStepOver() {
		return fThread.canStepOver();
	}

	public boolean canStepReturn() {
		return false;
	}

	public boolean isStepping() {
		return false;
	}

	public void stepInto() throws DebugException {

	}

	public void stepOver() throws DebugException {
		fThread.stepOver();
	}

	public void stepReturn() throws DebugException {

	}

	public boolean canResume() {
		return fThread.canResume();
	}

	public boolean canSuspend() {
		return fThread.canSuspend();
	}

	public boolean isSuspended() {
		return fThread.isSuspended();
	}

	public void resume() throws DebugException {
		fThread.resume();

	}

	public void suspend() throws DebugException {
		fThread.suspend();
	}

	public boolean canTerminate() {
		return fThread.canTerminate();
	}

	public boolean isTerminated() {
		return fThread.isTerminated();
	}

	public void terminate() throws DebugException {
		fThread.terminate();

	}
}
