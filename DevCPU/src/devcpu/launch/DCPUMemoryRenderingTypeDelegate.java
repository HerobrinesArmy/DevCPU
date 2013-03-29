package devcpu.launch;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.ui.memory.IMemoryRendering;
import org.eclipse.debug.ui.memory.IMemoryRenderingTypeDelegate;

public class DCPUMemoryRenderingTypeDelegate implements IMemoryRenderingTypeDelegate {

	public DCPUMemoryRenderingTypeDelegate() {
		System.out.println("MRTD construct");
	}

	@Override
	public IMemoryRendering createRendering(String id) throws CoreException {
		return new DCPUHexadecimalMemoryRendering(id);
	}
}
