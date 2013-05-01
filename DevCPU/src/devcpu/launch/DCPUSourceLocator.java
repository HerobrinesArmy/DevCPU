package devcpu.launch;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.model.IPersistableSourceLocator;
import org.eclipse.debug.core.model.IStackFrame;

public class DCPUSourceLocator implements IPersistableSourceLocator {
	private DCPUDebugTarget target;
	
	public DCPUSourceLocator() {
		System.out.println("DCPUSourceLocator DCPUSourceLocator ");
	}

	public DCPUSourceLocator(DCPUDebugTarget target) {
		System.out.println("DCPUSourceLocator DCPUSourceLocator " + target.getClass().getCanonicalName());
		this.target = target;
	}

	@Override
	public Object getSourceElement(IStackFrame stackFrame) {
		System.out.println("DCPUSourceLocator getSourceElement " + stackFrame.getClass().getCanonicalName());
		if (stackFrame instanceof DCPUDebugTarget) {
			return ((DCPUDebugTarget) stackFrame).getDCPU();
		}
		return null;
	}

	@Override
	public String getMemento() throws CoreException {
		System.out.println("DCPUSourceLocator getMemento ");
		// TODO Auto-generated method stub
		return null;
	}

	public DCPUDebugTarget getTarget() {
		System.out.println("DCPUSourceLocator getTarget ");
		return target;
	}

	@Override
	public void initializeFromMemento(String memento) throws CoreException {
		System.out.println("DCPUSourceLocator initializeFromMemento " + memento);
		// TODO Auto-generated method stub
	}

	@Override
	public void initializeDefaults(ILaunchConfiguration configuration) throws CoreException {
		System.out.println("DCPUSourceLocator initializeDefaults " + configuration.getClass().getCanonicalName());
		// TODO Auto-generated method stub
//XXX Hit
	}
}
