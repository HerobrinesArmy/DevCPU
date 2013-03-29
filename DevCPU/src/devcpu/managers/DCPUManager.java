package devcpu.managers;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.UUID;

import devcpu.ViewMapper;
import devcpu.emulation.DCPUHardware;
import devcpu.emulation.DefaultControllableDCPU;
import devcpu.emulation.Ship;
import devcpu.views.MappedView;

public class DCPUManager {
	private ArrayList<DefaultControllableDCPU> dcpus = new ArrayList<DefaultControllableDCPU>();
	private LinkedHashMap<String,DefaultControllableDCPU> uidMap = new LinkedHashMap<String, DefaultControllableDCPU>();
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

	public void destroyDCPU(DefaultControllableDCPU dcpu) {
		dcpu.stop();
		for (DCPUHardware hardware : new ArrayList<DCPUHardware>(dcpu.hardware)){
			hardware.disconnect();
		}
		for (MappedView<DefaultControllableDCPU> view : ViewMapper.getAllViews(dcpu)) {
			view.mapTo(null);
		}
		dcpus.remove(dcpu);
	}

	public String assignUniqueID(DefaultControllableDCPU dcpu) {
		String uid = nextUniqueID();
		uidMap.put(uid, dcpu);
		return uid;
	}

	private String nextUniqueID() {
		return UUID.randomUUID().toString();
	}

	public DefaultControllableDCPU getDCPUFromUniqueID(String uid) {
		return uidMap.get(uid);
	}
}
