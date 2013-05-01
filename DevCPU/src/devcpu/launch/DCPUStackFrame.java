package devcpu.launch;

import java.util.ArrayList;

import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.model.DebugElement;
import org.eclipse.debug.core.model.IDebugTarget;
import org.eclipse.debug.core.model.IRegisterGroup;
import org.eclipse.debug.core.model.IStackFrame;
import org.eclipse.debug.core.model.IThread;
import org.eclipse.debug.core.model.IVariable;

import devcpu.assembler.Assembly;
import devcpu.assembler.AssemblyLine;
import devcpu.emulation.DefaultControllableDCPU;

public class DCPUStackFrame extends DebugElement implements IStackFrame {
	private DCPUThread thread;
	private DCPURegisterGroup registerGroup;
	private ArrayList<DCPUVariable> variables = new ArrayList<DCPUVariable>();
	private DCPUDebugTarget target;
	
	/**
	 * Constructs a DCPUStackFrame
	 * @param thread
	 */
	public DCPUStackFrame(DCPUThread thread)
	{
		super(thread.getDebugTarget());
		this.target = (DCPUDebugTarget)thread.getDebugTarget();
		this.thread = thread;
	}
	
	public IThread getThread() {
		return thread;
	}

	public IVariable[] getVariables() throws DebugException {
		return variables.toArray(new IVariable[0]);//new IVariable[]{new DCPUVariable(this, "sampleVariable")};
	}

	public boolean hasVariables() throws DebugException {
		return true;
	}

	@Override
	@SuppressWarnings("rawtypes")
	public Object getAdapter(Class adapter) {
		if (adapter == ILaunch.class) {
			return getLaunch();
		}
		return super.getAdapter(adapter);
	}

	public int getLineNumber() throws DebugException {
		System.out.println("DCPUStackFrame getLineNumber");
		//TODO Figure out what to do with this when we get multiple documents working
		 Assembly assembly = target.getDCPU().getAssembly();
		 if (assembly != null) {
			 AssemblyLine line = assembly.getLineFromOffset(target.getDCPU().pc);
			 return line.getLineNumber();
		 }
		 return 0;
	}

	public int getCharStart() throws DebugException {
		System.out.println("DCPUStackFrame getCharStart");
		//TODO Figure out what to do with this when we get multiple documents working
		 Assembly assembly = target.getDCPU().getAssembly();
		 if (assembly != null) {
			 AssemblyLine line = assembly.getLineFromOffset(target.getDCPU().pc);
			 return line.getDocumentStart();
		 }
		 return 0;
	}

	public int getCharEnd() throws DebugException {
		System.out.println("DCPUStackFrame getCharEnd");
		//TODO Figure out what to do with this when we get multiple documents working
		 Assembly assembly = target.getDCPU().getAssembly();
		 if (assembly != null) {
			 AssemblyLine line = assembly.getLineFromOffset(target.getDCPU().pc);
			 return line.getDocumentStart() + line.getText().length();
		 }
		 return 0;
	}

	public String getName() throws DebugException {
		return "Frame: " + target.getDCPU().getID();
	}

	public IRegisterGroup[] getRegisterGroups() throws DebugException {
		if (registerGroup == null) {
			registerGroup = new DCPURegisterGroup(target);
		}
		return new IRegisterGroup[] {registerGroup};
	}

	public boolean hasRegisterGroups() throws DebugException {
		return true;
	}

	public String getModelIdentifier() {
		return thread.getModelIdentifier();
	}

	public IDebugTarget getDebugTarget() {
		return thread.getDebugTarget();
	}

	public ILaunch getLaunch() {
		return thread.getDebugTarget().getLaunch();
	}

	public boolean canStepInto() {
		return thread.canStepInto();
	}

	public boolean canStepOver() {
		return thread.canStepOver();
	}

	public boolean canStepReturn() {
		return thread.canStepReturn();
	}

	public boolean isStepping() {
		return thread.isStepping();
	}

	public void stepInto() throws DebugException {
		thread.stepInto();
	}

	public void stepOver() throws DebugException {
		thread.stepOver();
	}

	public void stepReturn() throws DebugException {
		thread.stepReturn();
	}

	public boolean canResume() {
		return thread.canResume();
	}

	public boolean canSuspend() {
		return thread.canSuspend();
	}

	public boolean isSuspended() {
		return thread.isSuspended();
	}

	public void resume() throws DebugException {
		thread.resume();
	}

	public void suspend() throws DebugException {
		thread.suspend();
	}

	public boolean canTerminate() {
		return thread.canTerminate();
	}

	public boolean isTerminated() {
		return thread.isTerminated();
	}

	public void terminate() throws DebugException {
		thread.terminate();
	}
	
	public DefaultControllableDCPU getDCPU() {
		return target.getDCPU();
	}
}
