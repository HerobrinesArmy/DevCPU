package devcpu.views.hex;

import devcpu.emulation.DefaultControllableDCPU;

public class DCPUMemoryDataProvider extends AbstractDataProvider {
	private DefaultControllableDCPU dcpu;

	public DCPUMemoryDataProvider(DefaultControllableDCPU dcpu) {
		this.dcpu = dcpu;
		this.data = dcpu.ram;
		this.size = 65536;
		this.wordsPerRow = 8; 
	}

	public DefaultControllableDCPU getDcpu() {
		return dcpu;
	}

	public void setDcpu(DefaultControllableDCPU dcpu) {
		this.dcpu = dcpu;
	}
}
