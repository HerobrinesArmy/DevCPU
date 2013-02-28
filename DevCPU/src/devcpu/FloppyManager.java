package devcpu;

import java.util.ArrayList;

import devcpu.emulation.FloppyDisk;
import devcpu.emulation.Ship;

public class FloppyManager {
	private int id;
	private ArrayList<FloppyDisk> disks = new ArrayList<FloppyDisk>();
	private Ship ship;
	
	public FloppyManager(Ship ship) {
		this.ship = ship;
	}

	public ArrayList<FloppyDisk> getDisks() {
		return disks;
	}

	public Ship getShip() {
		return ship;
	}

	public ArrayList<FloppyDisk> getAvailableDisks() {
		ArrayList<FloppyDisk> avail = new ArrayList<>();
		for (FloppyDisk fd : disks) {
			if (fd.getDriveUsing() == null) {
				avail.add(fd);
			}
		}
		return avail;
	}
	
	public FloppyDisk createFloppyDisk() {
		FloppyDisk fd = new FloppyDisk("Floppy " + id++, this);
		disks.add(fd);
		return fd;
	}
}
