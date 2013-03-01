package devcpu.launch;

import org.eclipse.debug.core.model.MemoryByte;

public class DCPUMemoryUnit {

	MemoryByte[] fBytes;
	
	public DCPUMemoryUnit(MemoryByte[] bytes)
	{
		fBytes = bytes;
	}
	
	public MemoryByte[] getBytes()
	{
		return fBytes;
	}
	
	public void setBytes(MemoryByte[] bytes)
	{
		fBytes = bytes;
	}

}
