package devcpu.emulation;

import devcpu.DCPUManager;
import devcpu.FloppyManager;
import devcpu.HardwareManager;

public class Ship {
	private String name = "Ship";
	private DCPUManager dcpuManager = new DCPUManager(this);
	private HardwareManager hardwareManager = new HardwareManager(this);
	private FloppyManager floppyManager = new FloppyManager(this);

	public String getName() {
		return name;
	}

	public DCPUManager getDCPUManager() {
		return dcpuManager;
	}

	public HardwareManager getHardwareManager() {
		return hardwareManager;
	}

	public FloppyManager getFloppyManager() {
		return floppyManager;
	}
}
