package devcpu;

import java.util.ArrayList;

import devcpu.emulation.DefaultControllableDCPU;
import devcpu.emulation.Ship;

public class DCPUManager {
	private ArrayList<DefaultControllableDCPU> dcpus = new ArrayList<DefaultControllableDCPU>();
	private int id;
	private Ship ship;
	
	public DCPUManager(Ship ship) {
		this.ship = ship;
	}

	public ArrayList<DefaultControllableDCPU> getDCPUs() {
		return new ArrayList<DefaultControllableDCPU>(dcpus);
	}

	public DefaultControllableDCPU createDCPU() {
		DefaultControllableDCPU dcpu = new DefaultControllableDCPU("DCPU " + id++, this);
		dcpus.add(dcpu);
		return dcpu;
	}

	public Ship getShip() {
		return ship;
	}
}
