package devcpu;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

import devcpu.emulation.AWTKeyMapping;
import devcpu.emulation.Assembler;
import devcpu.emulation.DefaultControllableDCPU;
import devcpu.emulation.Ship;
import devcpu.emulation.VirtualClock;
import devcpu.emulation.VirtualKeyboard;
import devcpu.emulation.VirtualMonitor;
import devcpu.emulation.VirtualVectorDisplay;

/**
 * The activator class controls the plug-in life cycle
 */
public class Activator extends AbstractUIPlugin {

	// The plug-in ID
	public static final String PLUGIN_ID = "DevCPU"; //$NON-NLS-1$

	private static Ship ship = new Ship();
	
	// The shared instance
	private static Activator plugin;
	
	/**
	 * The constructor
	 */
	public Activator() {
	}
	
	public Ship getShip() {
		return ship;
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
//		DefaultControllableDCPU cpu = ship.getDCPUManager().createDCPU();
//		cpu.setID("Main Computer");
//		ship.getDeviceManager().createVirtualVectorDisplay("SPED-3").connectTo(cpu);
//		ship.getDeviceManager().createVirtualMonitor("Primary Monitor").connectTo(cpu);
//		ship.getDeviceManager().createVirtualClock("Clock").connectTo(cpu);
//		ship.getDeviceManager().createVirtualKeyboard("Keyboard").connectTo(cpu);
//		
//		new Assembler(cpu.ram).assemble("creepertest.txt");
//		cpu.run();
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext context) throws Exception {
		plugin = null;
		super.stop(context);
	}

	/**
	 * Returns the shared instance
	 *
	 * @return the shared instance
	 */
	public static Activator getDefault() {
		return plugin;
	}

	/**
	 * Returns an image descriptor for the image file at the given
	 * plug-in relative path
	 *
	 * @param path the path
	 * @return the image descriptor
	 */
	public static ImageDescriptor getImageDescriptor(String path) {
		return imageDescriptorFromPlugin(PLUGIN_ID, path);
	}
}
