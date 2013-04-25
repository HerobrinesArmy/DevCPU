package devcpu.launch;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.sourcelookup.ISourceContainer;
import org.eclipse.debug.core.sourcelookup.ISourcePathComputerDelegate;

public class DCPUSourcePathComputerDelegate implements ISourcePathComputerDelegate {
	@Override
	public ISourceContainer[] computeSourceContainers(ILaunchConfiguration configuration, IProgressMonitor monitor) throws CoreException {
		System.out.println("DCPUSourcePathComputerDelegate computeSourceContainers");
		// TODO Auto-generated method stub
		return null;
	}
}
