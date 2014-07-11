package devcpu.managers;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.jface.resource.ImageDescriptor;

import devcpu.emulation.DCPUHardware;

public class DeviceRegistration {
	private String id;
	private String name;
	private Class<? extends DCPUHardware> clazz;
	private ImageDescriptor iconDescriptor;
//	private IConfigurationElement element;

	public DeviceRegistration(String id, String name, Class<? extends DCPUHardware> clazz, ImageDescriptor iconDescriptor, IConfigurationElement element) {
		this.id = id;
		this.name = name;
		this.clazz = clazz;
		this.iconDescriptor = iconDescriptor;
//		this.element = element;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public ImageDescriptor getIconDescriptor() {
		return iconDescriptor;
	}
	
	public DCPUHardware createInstance() throws InstantiationException, IllegalAccessException
	{
		return clazz.newInstance();
	}
}
