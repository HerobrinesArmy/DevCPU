package devcpu.emulation;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.debug.core.ILaunchConfigurationType;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.debug.core.ILaunchManager;

import devcpu.DCPUManager;

public class DefaultControllableDCPU extends DCPU implements Identifiable {
	private boolean keepAlive;
	private String id = "DCPU";
	private DCPUManager manager;
//	private ArrayList<DCPUTickListener> tickListeners = new ArrayList<>();

	public DefaultControllableDCPU(String id, DCPUManager manager) {
		this.manager = manager;
		this.id = id;
		doInitDebugEnvironment();
	}

	private void doInitDebugEnvironment() {
		try { //TODO
			ILaunchManager manager = DebugPlugin.getDefault().getLaunchManager();
			ILaunchConfigurationType type = manager.getLaunchConfigurationType("devcpu.dcpulaunch");
			ILaunchConfigurationWorkingCopy workingCopy = type.newInstance(null, "devcpu.dcpulaunch");
			workingCopy.launch(ILaunchManager.DEBUG_MODE, null);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void interrupt(char a) {
		if (keepAlive) {
			super.interrupt(a);
		}
	}
	
	public void run() {
		keepAlive = true;
		(new Thread() {
			@Override
			public void run() {
				final DefaultControllableDCPU dcpu = DefaultControllableDCPU.this;
//				opcounts = new int[64];
				long ops = 0L;
		    int hz = 1000 * khz;
		    int cyclesPerFrame = hz / 60 + 1;

		    long nsPerFrame = 16666666L;
		    long nextTime = System.nanoTime();

		    double tick = 0;
		    double total = 0;

		    long time = System.currentTimeMillis();
		    while (keepAlive) {
		      long a = System.nanoTime();
		      while (System.nanoTime() < nextTime) {
		        try {
		          Thread.sleep(1L);
		        } catch (InterruptedException e) {
		          e.printStackTrace();
		        }
		      }
		      long b = System.nanoTime();
		      while (cycles < cyclesPerFrame) {
		        tick();
//		        for (DCPUTickListener l : tickListeners) {
//		        	l.tick(dcpu);
//		        }
		      }

		      tickHardware();
		      cycles -= cyclesPerFrame;
		      long c = System.nanoTime();
		      ops += cyclesPerFrame;
		      nextTime += nsPerFrame;

		      tick += (c - b) / 1000000000.0;
		      total += (c - a) / 1000000000.0;

		      while (System.currentTimeMillis() > time) {
		        time += 1000L;
//		        System.out.println("1 DCPU at " + ops / 1000.0 + " khz, " + tick * 100.0 / total + "% cpu use");
		        tick = total = ops = 0L;
		      }
		    }
		    pc = 0;
		    sp = 0;
		    ex = 0;
		    ia = 0;
		    registers = new char[8];
		    cycles = 0;
		    stop = false;
		    isSkipping = false;
		    isOnFire = false;
		    queueingEnabled = false;
		    interrupts = new char[256];
		    ip = 0;
		    iwp = 0;
		    for (DCPUHardware hw : hardware) {
		    	hw.powerOff();
		    }
			}
		}).start();
	}
	
	public void stop() {
		keepAlive = false;
//		System.out.flush();
//		System.out.println("OpCodes used:");
//		for (int i = 0; i < 64; i++) {
//			if (opcounts[i] > 0) {
//				if (i > 31) {
//					System.out.println(OpCodes.special.getName(i-32));
//				} else {
//					System.out.println(OpCodes.basic.getName(i));
//				}
//			} else {
//				System.out.println();
//			}
//		}
	}

	public String getID() {
		return id ;
	}

	public void setID(String id) {
		this.id = id;
	}

	public DCPUManager getManager() {
		return manager;
	}

	public boolean isRunning() {
		return keepAlive;
	}

	public void load(File file) throws IOException {
		DataInputStream dis = new DataInputStream(new BufferedInputStream(new FileInputStream(file)));
		try {
			for (int i = 0;; i++) {
				ram[i] = dis.readChar();
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			//TODO handle file too large for disk
		} catch (IOException e) {
			dis.close();
		}	
	}

//	public void addTickListener(DCPUTickListener listener) {
//		tickListeners.add(listener);
//	}
//
//	public void removeTickListener(DCPUTickListener listener) {
//		tickListeners.remove(listener);
//	}
}
