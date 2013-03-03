package devcpu.launch;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.ui.memory.IMemoryRendering;
import org.eclipse.debug.ui.memory.IMemoryRenderingType;

public class DCPUHexadecimalMemoryRenderingType implements IMemoryRenderingType {
	@Override
	public String getLabel() {
		System.out.println("HMRT getLabel");
		return "DCPU Hexadecimal Rendering";
	}

	@Override
	public String getId() {
		System.out.println("HMRT getId");
		return "devcpu.DCPUHexadecimalMemoryRenderingType";
	}

	@Override
	public IMemoryRendering createRendering() throws CoreException {
		System.out.println("HMRT createRendering");
		return new DCPUHexadecimalMemoryRendering("org.eclipse.debug.ui.rendering.hexint");
	}
}
