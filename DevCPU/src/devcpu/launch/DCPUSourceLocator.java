package devcpu.launch;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.model.IPersistableSourceLocator;
import org.eclipse.debug.core.model.IStackFrame;

public class DCPUSourceLocator implements IPersistableSourceLocator {
	@Override
	public Object getSourceElement(IStackFrame stackFrame) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getMemento() throws CoreException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void initializeFromMemento(String memento) throws CoreException {
		// TODO Auto-generated method stub

	}

	@Override
	public void initializeDefaults(ILaunchConfiguration configuration) throws CoreException {
		// TODO Auto-generated method stub
//XXX Hit
	}
}
