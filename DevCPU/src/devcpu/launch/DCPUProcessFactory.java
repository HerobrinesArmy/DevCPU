package devcpu.launch;

import java.util.Map;

import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.IProcessFactory;
import org.eclipse.debug.core.model.IProcess;

public class DCPUProcessFactory implements IProcessFactory {
	@SuppressWarnings("rawtypes")
	@Override
	public IProcess newProcess(ILaunch launch, Process process, String label, Map attributes) {
		System.out.println("DCPUProcessFactory newProcess");
		// TODO Auto-generated method stub
		return null;
	}
}
