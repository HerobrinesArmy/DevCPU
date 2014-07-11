package devcpu.emulation;

import devcpu.managers.HardwareManager;

public interface IHardware extends Identifiable {
	public void setManager(HardwareManager manager);
}
