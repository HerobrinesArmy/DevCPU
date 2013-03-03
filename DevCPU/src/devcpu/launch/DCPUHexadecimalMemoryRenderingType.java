package devcpu.launch;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.ui.memory.IMemoryRendering;
import org.eclipse.debug.ui.memory.IMemoryRenderingType;

public class DCPUHexadecimalMemoryRenderingType implements IMemoryRenderingType {
	@Override
	public String getLabel() {
		return "DCPU Hexadecimal Rendering";
	}

	@Override
	public String getId() {
		return "devcpu.DCPUHexadecimalMemoryRenderingType";
	}

	@Override
	public IMemoryRendering createRendering() throws CoreException {
		return new DCPUHexadecimalMemoryRendering("org.eclipse.debug.ui.rendering.hexint");
	}
}
