package devcpu.launch;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.model.IBreakpoint;
import org.eclipse.debug.core.model.LaunchConfigurationDelegate;

import devcpu.Activator;
import devcpu.emulation.DefaultControllableDCPU;

/**
 * DCPU Launch configuraiton delegate
 * For creating the debug target that supports IMemoryBlockExtension
 * */
public class DCPULaunchDelegate extends LaunchConfigurationDelegate {
	/* (non-Javadoc)
	 * @see org.eclipse.debug.core.model.ILaunchConfigurationDelegate#launch(org.eclipse.debug.core.ILaunchConfiguration, java.lang.String, org.eclipse.debug.core.ILaunch, org.eclipse.core.runtime.IProgressMonitor)
	 */
	public void launch(ILaunchConfiguration configuration, String mode, ILaunch launch, IProgressMonitor monitor) throws CoreException {
		String uid = (String) configuration.getAttributes().get("DCPU");
		DefaultControllableDCPU dcpu = Activator.getShip().getDCPUManager().getDCPUFromUniqueID(uid);
//		IDebugTarget target = dcpu;//new DCPUDebugTarget(launch, dcpu);
		DCPUDebugTarget target = new DCPUDebugTarget(launch, dcpu);
		launch.setSourceLocator(new DCPUSourceLocator(target)); //Can be removed
		launch.addDebugTarget(target);
	}
	
	@Override
	public boolean buildForLaunch(ILaunchConfiguration configuration, String mode, IProgressMonitor monitor) throws CoreException {
		// TODO Auto-generated method stub
		return super.buildForLaunch(configuration, mode, monitor);
	}
	
	@Override
	protected IBreakpoint[] getBreakpoints(ILaunchConfiguration configuration) {
		// TODO Auto-generated method stub
		return super.getBreakpoints(configuration);
	}
	
	@Override
	public ILaunch getLaunch(ILaunchConfiguration configuration, String mode) throws CoreException {
		// TODO Auto-generated method stub
		return super.getLaunch(configuration, mode);
	}
}
