package devcpu.emulation;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Hashtable;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchConfigurationType;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.debug.core.ILaunchManager;
import org.eclipse.debug.core.model.MemoryByte;

import devcpu.Activator;
import devcpu.assembler.Assembly;
import devcpu.launch.DCPUDebugTarget;
import devcpu.launch.DCPUMemoryUnit;
import devcpu.managers.DCPUManager;

public class DefaultControllableDCPU extends DCPU implements Identifiable { //, IDebugTarget {
	public static final int RUN_MODE_OPTIMIZED = 1;
	public static final int RUN_MODE_DEBUG = 2;
	private int runMode = RUN_MODE_DEBUG;
	private boolean keepAlive;
	private String id = "DCPU";
	private DCPUManager manager;
	private Hashtable<Integer, DCPUMemoryUnit> memoryBlockTable;
	private String uid;
	private ILaunch launch;
//	private ArrayList<DCPUTickListener> tickListeners = new ArrayList<>();
	private Assembly assembly;
	private boolean suspend;
	private boolean suspended;
	private boolean step;
	private DCPUDebugTarget debugTarget;

	public DefaultControllableDCPU(String id, DCPUManager manager) {
		this.manager = manager;
		this.id = id;
		doInitDebugEnvironment();
	}

//	@SuppressWarnings("unused")
	private void doInitDebugEnvironment() {
			this.uid = Activator.getShip().getDCPUManager().assignUniqueID(this);
//			IWorkbenchPage page =  PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
//
//		  if (page != null)
//
//		  {
//
//		     try
//
//		     {
//
//		    	 IViewPart view = page.showView("org.eclipse.debug.ui.MemoryView"); 
//
//		        IMemoryRenderingSite memoryView = (IMemoryRenderingSite) view; 
//		        IMemoryBlockExtension mbe = new DCPUMemoryBlock(this); 
//		        DebugPlugin.getDefault().getMemoryBlockManager().addMemoryBlocks(new IMemoryBlock[] {mbe}); 
//
//		        IMemoryRenderingType renderingType = DebugUITools.getMemoryRenderingManager().getRenderingType("org.eclipse.debug.ui.rendering.hexint"); 
//		        IMemoryRendering rendering = renderingType.createRendering(); 
//
//		        IMemoryRenderingContainer container = memoryView.getContainer(DebugUIPlugin.getUniqueIdentifier() + ".MemoryView.RenderingViewPane.1"); 
//
//		        rendering.init(container, mbe);
//		        
//		        container.addMemoryRendering(rendering);	
//		       }
//		       catch (Exception e) {e.printStackTrace();}
//		  }

//			MemoryView view = (MemoryView) PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().showView("org.eclipse.debug.ui.MemoryView");;
//			DebugPlugin.getDefault().getMemoryBlockManager().addMemoryBlocks(new IMemoryBlock[] {new DCPUMemoryBlock(new DCPUDebugTarget(launch), "0", new BigInteger("0"))});
			
//		System.out.println(view.getMemoryRenderingContainers().length);
//		view.getMemoryRenderingContainers()[0].
//		MemoryRenderingManager mgr = (MemoryRenderingManager) MemoryRenderingManager.getDefault();
//		IMemoryRendering rendering = mgr.createRendering("org.eclipse.debug.ui.rendering.hexint");
	}

	@Override
	public void interrupt(char a) {
		if (keepAlive) {
			super.interrupt(a);
		}
	}
	
	public void run() {
		switch (runMode)
		{
		case RUN_MODE_OPTIMIZED:
			runOptimized();
			break;
		case RUN_MODE_DEBUG:
		default:
			runDebug();
		}
	}
	
	public boolean suspend() {
		if (runMode == RUN_MODE_DEBUG) {
			suspend = true;
			while (!suspended) {
        try {
          Thread.sleep(1L);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
			return true;
		} else {
			return false;
		}
	}
	
	public boolean resume() {
		if (runMode == RUN_MODE_DEBUG) {
			if (keepAlive) {
				suspend = false;
				while (suspended) {
	        try {
	          Thread.sleep(1L);
	        } catch (InterruptedException e) {
	          e.printStackTrace();
	        }
	      }
			} else {
				runDebug();
				while (!keepAlive) {
	        try {
	          Thread.sleep(1L);
	        } catch (InterruptedException e) {
	          e.printStackTrace();
	        }
	      }
			}
			return true;
		} else {
			if (keepAlive) {
				return false;
			} else {
				runOptimized();
				while (!keepAlive) {
	        try {
	          Thread.sleep(1L);
	        } catch (InterruptedException e) {
	          e.printStackTrace();
	        }
	      }
				return true;
			}
		}
	}

	public boolean step() {
		if (runMode == RUN_MODE_DEBUG) {
			step = true;
			while (step) {
        try {
          Thread.sleep(1L);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
			return true;
		} else {
			return false;
		}
	}
	
	private void runDebug() {
		ILaunchManager manager  = DebugPlugin.getDefault().getLaunchManager();
		ILaunchConfigurationType type = manager.getLaunchConfigurationType("devcpu.dcpulaunch");
		ILaunchConfigurationWorkingCopy workingCopy;
		try {
			workingCopy = type.newInstance(null, "devcpu.dcpulaunch");
			workingCopy.setAttribute("DCPU",uid);
			this.launch = workingCopy.launch(ILaunchManager.DEBUG_MODE, null);
		} catch (CoreException e) {
			e.printStackTrace();
		}

		keepAlive = true;
		(new Thread() {
			@Override
			public void run() {
				for (DCPUHardware hw : hardware) {
		    	hw.powerOn();
		    }
//				opcounts = new int[64];
		    int hz = 1000 * khz;
		    int cyclesPerFrame = hz / 60 + 1;
		    long nsPerFrame = 16666666L;
		    long nextTime = System.nanoTime();

		    while (keepAlive) {
		      while (System.nanoTime() < nextTime) {
		        try {
		          Thread.sleep(1L);
		        } catch (InterruptedException e) {
		          e.printStackTrace();
		        }
		      }
		      while (cycles < cyclesPerFrame) {
		      	step = false;
		      	if (suspend) {
		      		suspended = true;
		      		while (suspend) {
		      			try {
				          Thread.sleep(10L);
				        } catch (InterruptedException e) {
				          e.printStackTrace();
				        }
		      			if (step || !keepAlive) {
		      				break;
		      			}
		      		}
		      		if (!suspend) {
		      			suspended = false;
		      			nextTime = System.nanoTime() + nsPerFrame;
		      			//TODO analyze how this might affect hardware getting ticked at the correct time and consider alternet looping metric if there's a problem
		      		}
		      	}
		      	if (keepAlive) {
		      		tick();
		      	}
		      }
		      if (keepAlive) {
		      	tickHardware();
		      	cycles -= cyclesPerFrame;
		      	nextTime += nsPerFrame;
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

	private void runOptimized() {
		keepAlive = true;
		(new Thread() {
			@Override
			public void run() {
				for (DCPUHardware hw : hardware) {
		    	hw.powerOn();
		    }
//				opcounts = new int[64];
		    int hz = 1000 * khz;
		    int cyclesPerFrame = hz / 60 + 1;

		    long nsPerFrame = 16666666L;
		    long nextTime = System.nanoTime();

		    while (keepAlive) {
		      while (System.nanoTime() < nextTime) {
		        try {
		          Thread.sleep(1L);
		        } catch (InterruptedException e) {
		          e.printStackTrace();
		        }
		      }
		      while (cycles < cyclesPerFrame) {
		        tick();
		      }
		      tickHardware();
		      cycles -= cyclesPerFrame;
		      nextTime += nsPerFrame;
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
	
	public boolean isSuspended() {
		return suspended;
	}

	public void load(File file) throws IOException {
		DataInputStream dis = new DataInputStream(new BufferedInputStream(new FileInputStream(file)));
		int i = 0;
		try {
			for (; i<ram.length; i++) {
				ram[i] = dis.readChar();
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			e.printStackTrace();
		} catch (IOException e) {
			for (; i<ram.length; i++) {
				ram[i] = 0;
			}
			dis.close();
		}	
	}

	public void save(File file) throws IOException {
		DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(file)));
		try {
			for (int i = 0; i<ram.length; i++) {
				dos.writeChar(ram[i]);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		dos.close();
	}
	
	@Override
	public boolean addHardware(DCPUHardware hw) {
		boolean ret = super.addHardware(hw);
		if (ret && keepAlive) {
			hw.powerOn();
		}
		return ret;
	}
	
	@Override
	public boolean removeHardware(DCPUHardware hw) {
		synchronized (hardware) {
			hw.powerOff();
			return hardware.remove(hw);
		}
	}
	
//	public void addTickListener(DCPUTickListener listener) {
//		tickListeners.add(listener);
//	}
//
//	public void removeTickListener(DCPUTickListener listener) {
//		tickListeners.remove(listener);
//	}

//	@Override
//	public String getModelIdentifier() {
//		System.out.println("hit DCPU getMI");
//		return DCPUModelPresentation.DEBUG_MODEL_ID;
//	}
//
//	@Override
//	public IDebugTarget getDebugTarget() {
//		System.out.println("hit DCPU getDT");
//		return this;
//	}
//
//	@Override
	public ILaunch getLaunch() {
//		System.out.println("DefaultControllableDCPU getLaunch");
		return launch;
	}
//
//	@SuppressWarnings("rawtypes")
//	@Override
//	public Object getAdapter(Class adapter) {
////		if (adapter.equals(org.eclipse.core.resources.IResource.class)) {
////			return Platform.getLocation();
////		}
//		System.out.println("DefaultControllableDCPU adapt to " + adapter.getCanonicalName());
//		return null;
//	}
//
//	@Override
//	public boolean canTerminate() {
//		System.out.println("hit DCPU canTerm");
//		return false;
//	}
//
//	@Override
//	public boolean isTerminated() {
//		//TODO
//		System.out.println("hit DCPU isTerm");
//		return false;
//	}
//
//	@Override
//	public void terminate() throws DebugException {
//		// TODO Auto-generated method stub
//		System.out.println("hit DCPU term");
//			
//	}
//
//	@Override
//	public boolean canResume() {
//		// TODO Auto-generated method stub
//		System.out.println("hit DCPU canRes");
//		return false;
//	}
//
//	@Override
//	public boolean canSuspend() {
//		// TODO Auto-generated method stub
//		System.out.println("hit DCPU canSUs");
//		return false;
//	}
//
//	@Override
//	public boolean isSuspended() {
//		// TODO Auto-generated method stub
//		System.out.println("hit DCPUisSus");
//		return false;
//	}
//
//	@Override
//	public void resume() throws DebugException {
//		// TODO Auto-generated method stub
//		System.out.println("hit DCPU res");
//		
//	}
//
//	@Override
//	public void suspend() throws DebugException {
//		// TODO Auto-generated method stub
//		System.out.println("hit DCPU sus");
//		
//	}
//
//	@Override
//	public void breakpointAdded(IBreakpoint breakpoint) {
//		// TODO Auto-generated method stub
//		System.out.println("hit DCPU bpA");
//	}
//
//	@Override
//	public void breakpointRemoved(IBreakpoint breakpoint, IMarkerDelta delta) {
//		// TODO Auto-generated method stub
//		System.out.println("hit DCPU bpR");
//		
//	}
//
//	@Override
//	public void breakpointChanged(IBreakpoint breakpoint, IMarkerDelta delta) {
//		// TODO Auto-generated method stub
//		System.out.println("hit DCPU bpC");
//	}
//
//	@Override
//	public boolean canDisconnect() {
//		// TODO Auto-generated method stub
//		System.out.println("hit DCPU canDis");
//		return false;
//	}
//
//	@Override
//	public void disconnect() throws DebugException {
//		// TODO Auto-generated method stub
//		System.out.println("hit DCPU dis");
//		
//	}
//
//	@Override
//	public boolean isDisconnected() {
//		// TODO Auto-generated method stub
//		System.out.println("hit DCPU isDis");
//		return false;
//	}
//
//	@Override
//	public boolean supportsStorageRetrieval() {
//		// TODO Auto-generated method stub
//		System.out.println("hit DCPU supportsSR");
//		return true;
//	}
//
//	@Override
//	public IMemoryBlock getMemoryBlock(long startAddress, long length)
//			throws DebugException {
//		// TODO Auto-generated method stub
//		System.out.println("DefaultControllableDCPU getMemoryBlock");
//		return null;
//	}
//
//	@Override
//	public IProcess getProcess() {
//		System.out.println("DefaultControllableDCPU getProcess");
//		return null;
//	}
//
//	@Override
//	public IThread[] getThreads() throws DebugException {
//		System.out.println("DefaultControllableDCPU getThreads");
//		return new IThread[]{};
//	}
//
//	@Override
//	public boolean hasThreads() throws DebugException {
//		System.out.println("hit DCPU hasThreads");
//		return false;
//	}
//
//	@Override
//	public String getName() throws DebugException {
//		System.out.println("hit DCPU getName");
//		return id;
//	}
//
//	@Override
//	public boolean supportsBreakpoint(IBreakpoint breakpoint) {
//		// TODO Auto-generated method stub
//		System.out.println("hit DCPU supports Break");
//		return false;
//	}
//
	public MemoryByte[] getBytesFromAddress(int address, int length) {
		System.out.println("hit DCPU getBytesfromaddress " + address +", " + length);
		if (memoryBlockTable == null)
		{		
			// create new memoryBlock table
			memoryBlockTable = new Hashtable<Integer, DCPUMemoryUnit>();
			byte[] bytes = new byte[length*2];
			for(int i=0;i<length;i++) {
			   bytes[i*2] = (byte) (ram[address+i] >> 8);
			   bytes[i*2+1] = (byte) ram[address+i];
			}
			int addressKey = address;
						
			for (int i=0; i<bytes.length; i=i+2)
			{
				addressKey++;

				MemoryByte[] byteUnit = new MemoryByte[2];
				for (int j=0; j<2; j++)
				{
					MemoryByte oneByte = new MemoryByte(bytes[i+j]);
					oneByte.setBigEndian(true);
					oneByte.setWritable(true);
					oneByte.setReadable(true);
					byteUnit[j] = oneByte;
				}
				DCPUMemoryUnit unit = new DCPUMemoryUnit(byteUnit);
				memoryBlockTable.put(addressKey, unit);
			}
		}
			
		MemoryByte[] returnBytes = new MemoryByte[length * 2];	
		int addressKey;
		
		for (int i=0; i<returnBytes.length; i=i+2)
		{	
			addressKey = address + i/2;
			DCPUMemoryUnit temp = ((DCPUMemoryUnit)memoryBlockTable.get(addressKey));
			
			// if memoryBlock does not already exist in the table, generate a value
			if (temp == null)
			{
				byte[] x = new byte[2];
				x[i*2] = (byte) (ram[address+i] >> 8);
			  x[i*2+1] = (byte) ram[address+i];
				byte flag = 0;
				flag |= MemoryByte.READABLE;
				flag |= MemoryByte.ENDIANESS_KNOWN;
				flag |= MemoryByte.WRITABLE;
				
				MemoryByte[] byteUnit = new MemoryByte[2];
				for (int j=0; j<2; j++)
				{
					MemoryByte oneByte = new MemoryByte(x[j], flag);
					byteUnit[j] = oneByte;
					byteUnit[j].setBigEndian(true);
					byteUnit[j].setWritable(true);
					byteUnit[j].setReadable(true);
					returnBytes[i+j] = oneByte;
				}
				DCPUMemoryUnit unit = new DCPUMemoryUnit(byteUnit);
				memoryBlockTable.put(addressKey, unit);
				
			}
			else
			{
				MemoryByte[] bytes = temp.getBytes();
				for (int j=0; j<bytes.length; j++)
				{
					MemoryByte oneByte = new MemoryByte(bytes[j].getValue(), bytes[j].getFlags());
					returnBytes[i+j] = oneByte;
					returnBytes[i+j].setBigEndian(true);
					returnBytes[i+j].setWritable(true);
				}
			}
		}
		
		return returnBytes;
	}
	
	public void setAssembly(Assembly assembly) {
		this.assembly = assembly;
		if (keepAlive) {
			suspend = true;
		} else {
			suspend = true;
			run();
		}
	}

	public Assembly getAssembly() {
		return assembly;
	}

	public void setDebugTarget(DCPUDebugTarget target) {
		this.debugTarget = target;
	}
	
	public DCPUDebugTarget getDebugTarget() {
		return debugTarget;
	}
}
