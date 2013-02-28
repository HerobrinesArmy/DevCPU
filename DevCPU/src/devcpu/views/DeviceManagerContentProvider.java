package devcpu.views;

import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;

import devcpu.Activator;
import devcpu.DCPUManager;
import devcpu.FloppyManager;
import devcpu.HardwareManager;
import devcpu.emulation.DCPUHardware;
import devcpu.emulation.DefaultControllableDCPU;
import devcpu.emulation.FloppyDisk;
import devcpu.emulation.Ship;
import devcpu.emulation.VirtualFloppyDrive;

public class DeviceManagerContentProvider implements ITreeContentProvider {
	private static Object[] EMPTY_ARRAY = new Object[0];
	private static final DeviceManagerContentProvider provider = new DeviceManagerContentProvider();
	private Viewer viewer;
	
	@Override
	public void dispose() {}

	@Override
	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		this.viewer = viewer;
	}

	@Override
	public Object[] getElements(Object o) {
		if (o instanceof Activator) {
			return new Object[]{Activator.getDefault().getShip()};
		} else {
			return getChildren(o);
		}
	}

	@Override
	public Object[] getChildren(Object o) {
		if (o instanceof Ship) {
			Ship ship = (Ship) o;
			return new Object[]{ship.getDCPUManager(), ship.getHardwareManager(), ship.getFloppyManager()};
		} else if (o instanceof DCPUManager) {
			return ((DCPUManager)o).getDCPUs().toArray();
		} else if (o instanceof HardwareManager) {
			return ((HardwareManager)o).getDisconnectedDevices().toArray();
		} else if (o instanceof FloppyManager) {
			return ((FloppyManager)o).getAvailableDisks().toArray();
		} else if (o instanceof DefaultControllableDCPU) {
			return ((DefaultControllableDCPU)o).hardware.toArray();
		} else if (o instanceof VirtualFloppyDrive) {
			if (((VirtualFloppyDrive)o).getDisk() != null) {
				return new Object[]{((VirtualFloppyDrive)o).getDisk()};
			}
		}
		return EMPTY_ARRAY;
	}

	@Override
	public Object getParent(Object o) {
		if (o instanceof DefaultControllableDCPU) {
			return ((DefaultControllableDCPU)o).getManager();
		} else if (o instanceof DCPUManager) {
			return ((DCPUManager)o).getShip();
		} else if (o instanceof HardwareManager) {
			return ((HardwareManager)o).getShip();
		} else if (o instanceof FloppyManager) {
			return ((FloppyManager)o).getShip();
		} else if (o instanceof FloppyDisk) {
			if (((FloppyDisk)o).getDriveUsing() == null) {
				return ((FloppyDisk)o).getManager();
			} else {
				return ((FloppyDisk)o).getDriveUsing();
			}
		} else if (o instanceof DCPUHardware) {
			if (((DCPUHardware) o).isConnected()) {
				return ((DCPUHardware) o).dcpu;
			} else {
				return Activator.getDefault().getShip().getHardwareManager();
			}
		}
		return null;
	}

	@Override
	public boolean hasChildren(Object o) {
		if (o instanceof Ship) {
			return true;
		} else if (o instanceof DCPUManager) {
			return (((DCPUManager) o).getDCPUs().size() > 0);
		} else if (o instanceof HardwareManager) {
			return (((HardwareManager) o).getDisconnectedDevices().size() > 0);
		} else if (o instanceof FloppyManager) {
			return (((FloppyManager) o).getAvailableDisks().size() > 0);
		} else if (o instanceof DefaultControllableDCPU) {
			return ((DefaultControllableDCPU) o).hardware.size() > 0;
		} else if (o instanceof VirtualFloppyDrive) {
			return ((VirtualFloppyDrive) o).getDisk() != null;
		}
		return false;
	}

	public void update() {
		viewer.refresh();
	}

	public static DeviceManagerContentProvider get() {
		return provider ;
	}
}
