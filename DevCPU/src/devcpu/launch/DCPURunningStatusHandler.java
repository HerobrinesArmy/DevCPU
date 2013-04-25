package devcpu.launch;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.debug.core.IStatusHandler;

public class DCPURunningStatusHandler implements IStatusHandler {
	@Override
	public Object handleStatus(IStatus status, Object source) throws CoreException {
		System.out.println("DCPURunningStatusHandler handleStatus");
		// TODO Auto-generated method stub
		return null;
	}
}
