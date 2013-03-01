package devcpu;

import java.util.ArrayList;

import devcpu.emulation.AWTKeyMapping;
import devcpu.emulation.DCPUHardware;
import devcpu.emulation.Ship;
import devcpu.emulation.VirtualClock;
import devcpu.emulation.VirtualFloppyDrive;
import devcpu.emulation.VirtualKeyboard;
import devcpu.emulation.VirtualMonitor;
import devcpu.emulation.VirtualSleepChamber;
import devcpu.emulation.VirtualVectorDisplay;

public class HardwareManager {
	private ArrayList<DCPUHardware> devices = new ArrayList<DCPUHardware>();
	private int id;
	private Ship ship;
	
	public HardwareManager(Ship ship) {
		this.ship = ship;
	}

	public ArrayList<DCPUHardware> getDevices() {
		return devices;
	}
	
	public ArrayList<DCPUHardware> getDevices(Class<? extends DCPUHardware> type) {
		ArrayList<DCPUHardware> results = new ArrayList<DCPUHardware>();
		for (DCPUHardware device : devices) {
			if (type.isInstance(device)) {
				results.add(device);
			}
		}
		return results;
	}

	public Ship getShip() {
		return ship;
	}

	public VirtualMonitor createVirtualMonitor() {
		return createVirtualMonitor("LEM1802 " + id++);
	}
	
	public VirtualMonitor createVirtualMonitor(String id) {
		VirtualMonitor vm = new VirtualMonitor(id, this);
		devices.add(vm);
		return vm;
	}

	public VirtualVectorDisplay createVirtualVectorDisplay() {
		return createVirtualVectorDisplay("SPED-3 " + id++);
	}

	public VirtualVectorDisplay createVirtualVectorDisplay(String id) {
		VirtualVectorDisplay vvd = new VirtualVectorDisplay(id, this);
		devices.add(vvd);
		return vvd;
	}

	public VirtualSleepChamber createVirtualSleepChamber() {
		return createVirtualSleepChamber("SPC2000 " + id++);
	}

	public VirtualSleepChamber createVirtualSleepChamber(String id) {
		VirtualSleepChamber vsc = new VirtualSleepChamber(id, this);
		devices.add(vsc);
		return vsc;
	}

	public VirtualFloppyDrive createVirtualFloppyDrive() {
		return createVirtualFloppyDrive("M35FD " + id++);
	}

	public VirtualFloppyDrive createVirtualFloppyDrive(String id) {
		VirtualFloppyDrive vfd = new VirtualFloppyDrive(id, this);
		devices.add(vfd);
		return vfd;
	}

	public VirtualClock createVirtualClock() {
		return createVirtualClock("Generic Clock " + id++);
	}

	public VirtualClock createVirtualClock(String id) {
		VirtualClock vc = new VirtualClock(id, this);
		devices.add(vc);
		return vc;
	}

	public VirtualKeyboard createVirtualKeyboard() {
		return createVirtualKeyboard("Generic Keyboard " + id++);
	}

	public VirtualKeyboard createVirtualKeyboard(String id) {
		VirtualKeyboard vk = new VirtualKeyboard(id, this, new AWTKeyMapping());
		devices.add(vk);
		return vk;
	}

	public ArrayList<DCPUHardware> getDisconnectedDevices() {
		ArrayList<DCPUHardware> ret = new ArrayList<DCPUHardware>();
		for (DCPUHardware hw : devices) {
			if (!hw.isConnected()) {
				ret.add(hw);
			}
		}
		return ret;
	}

	public void destroyDevice(DCPUHardware hardware) {
		hardware.onDestroy();
		if (hardware.isConnected()) {
			hardware.disconnect();
		}
		for (MappedView<DCPUHardware> view : ViewMapper.getAllViews(hardware)) {
			view.mapTo(null);
		}
		devices.remove(hardware);
	}
}
