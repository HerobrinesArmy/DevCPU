package devcpu.launch;

import org.eclipse.debug.core.model.IMemoryBlock;
import org.eclipse.debug.ui.memory.IMemoryRenderingBindingsListener;
import org.eclipse.debug.ui.memory.IMemoryRenderingBindingsProvider;
import org.eclipse.debug.ui.memory.IMemoryRenderingType;

public class DCPUMemoryRenderingBinding implements IMemoryRenderingBindingsProvider {
	private DCPUHexadecimalMemoryRenderingType renderingType = new DCPUHexadecimalMemoryRenderingType();
	@Override
	public IMemoryRenderingType[] getRenderingTypes(IMemoryBlock block) {
		return new IMemoryRenderingType[]{renderingType};
	}

	@Override
	public IMemoryRenderingType[] getDefaultRenderingTypes(IMemoryBlock block) {
		return new IMemoryRenderingType[]{renderingType};
	}

	@Override
	public IMemoryRenderingType getPrimaryRenderingType(IMemoryBlock block) {
		return renderingType;
	}

	@Override
	public void addListener(IMemoryRenderingBindingsListener listener) {
		// TODO Auto-generated method stub
	}

	@Override
	public void removeListener(IMemoryRenderingBindingsListener listener) {
		// TODO Auto-generated method stub
	}
}
