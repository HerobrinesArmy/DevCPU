package devcpu.launch;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.sourcelookup.ISourceContainer;
import org.eclipse.debug.core.sourcelookup.ISourceContainerTypeDelegate;

public class DCPUSourceContainerTypeDelegate implements ISourceContainerTypeDelegate {
	@Override
	public ISourceContainer createSourceContainer(String memento) throws CoreException {
		// TODO Auto-generated method stub
System.out.println("DCPUSourceContainerTypeDelegate createSourceContainer");
		return null;
	}

	@Override
	public String getMemento(ISourceContainer container) throws CoreException {
		// TODO Auto-generated method stub
		System.out.println("DCPUSourceContainerTypeDelegate getMemento");
		return null;
	}
}
