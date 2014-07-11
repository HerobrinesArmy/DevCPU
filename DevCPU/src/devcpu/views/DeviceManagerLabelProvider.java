package devcpu.views;

import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;

import devcpu.assembler.Assembly;
import devcpu.emulation.DCPUHardware;
import devcpu.emulation.DefaultControllableDCPU;
import devcpu.emulation.FloppyDisk;
import devcpu.emulation.Identifiable;
import devcpu.emulation.Ship;
import devcpu.managers.DCPUManager;
import devcpu.managers.FloppyManager;
import devcpu.managers.HardwareManager;
import devcpu.managers.HardwareRegistry;
import devcpu.util.Util;

public class DeviceManagerLabelProvider extends LabelProvider {
	private static final DeviceManagerLabelProvider instance = new DeviceManagerLabelProvider();
	
	private DeviceManagerLabelProvider() {
	}
	
	public static DeviceManagerLabelProvider get() {
		return instance;
	}
	
	@Override
	public String getText(Object o) {
		if (o instanceof Ship) {
			return ((Ship)o).getName();
		} else if (o instanceof DCPUManager) {
			return "DCPUs";
		} else if (o instanceof HardwareManager) {
			return "Hardware";
		} else if (o instanceof FloppyManager) {
			return "Floppies";
		} else if (o instanceof DefaultControllableDCPU) {
			DefaultControllableDCPU dcpu = (DefaultControllableDCPU) o;
			Assembly assembly = dcpu.getAssembly();
			if (assembly != null) {
				return dcpu.getID() + ": " + dcpu.getAssembly().getRootDocument().getFile().getName();
			} else {
				return dcpu.getID();				
			}
		} else if (o instanceof Identifiable) {
			return ((Identifiable)o).getID();
		} else {
			return "Unknown";
		}
	}
	
	@Override
	public Image getImage(Object o) {
		if (o instanceof DefaultControllableDCPU)
		{
			return new Image(Display.getDefault(), Util.loadResource("icons/dcpu.png"));
		} else if (o instanceof DCPUHardware)
		{
			return HardwareRegistry.getDeviceByClass(o.getClass()).getIconDescriptor().createImage();
		} else if (o instanceof FloppyDisk)
		{
			if (((FloppyDisk) o).isWriteProtected()) {
				return new Image(Display.getDefault(), Util.loadResource("icons/protecteddisk.png"));
			} else {
				return new Image(Display.getDefault(), Util.loadResource("icons/disk.png"));
			}
		} else if (o instanceof FloppyManager)
		{
			return new Image(Display.getDefault(), Util.loadResource("icons/disk.png"));
		} else if (o instanceof DCPUManager)
		{
			return new Image(Display.getDefault(), Util.loadResource("icons/dcpu.png"));
		} else if (o instanceof HardwareManager)
		{
			return new Image(Display.getDefault(), Util.loadResource("icons/hw.png"));
		} else if (o instanceof Ship)
		{
			return new Image(Display.getDefault(), Util.loadResource("icons/ship.png"));
		}
		return super.getImage(o);
	}
}
