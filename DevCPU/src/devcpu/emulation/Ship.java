package devcpu.emulation;

import devcpu.managers.DCPUManager;
import devcpu.managers.FloppyManager;
import devcpu.managers.HardwareManager;

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
