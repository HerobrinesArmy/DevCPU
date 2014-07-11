package devcpu.managers;

import java.util.Collection;
import java.util.LinkedHashMap;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtension;
import org.eclipse.core.runtime.IExtensionPoint;
import org.eclipse.core.runtime.InvalidRegistryObjectException;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.internal.util.BundleUtility;

import devcpu.emulation.DCPUHardware;

@SuppressWarnings("restriction")
public class HardwareRegistry {
	private static HardwareRegistry instance;
	private LinkedHashMap<String,DeviceRegistration> devices = new LinkedHashMap<String,DeviceRegistration>();
	private LinkedHashMap<Class<?>,DeviceRegistration> devicesByClass = new LinkedHashMap<Class<?>,DeviceRegistration>();
	
	private HardwareRegistry()
	{
		initHardwareRegistry();
	}
	
	@SuppressWarnings("unchecked")
	private void initHardwareRegistry() {
		IExtensionPoint hep = Platform.getExtensionRegistry().getExtensionPoint("devcpu.hardware");
  	for (IExtension extension : hep.getExtensions())
  	{
    	for (final IConfigurationElement element : extension.getConfigurationElements())
    	{
    		if ("device".equals(element.getName()))
    		{
    			String id = element.getAttribute("id");
    			String name = element.getAttribute("name");
    			Class<? extends DCPUHardware> clazz = null;
    			try {
						clazz = (Class<? extends DCPUHardware>) Class.forName(element.getAttribute("class"));
					} catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (InvalidRegistryObjectException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
    			String iconPath = element.getAttribute("icon");
    			ImageDescriptor iconDescriptor = null;
					if (iconPath != null && iconPath.length() > 0)
					{
						iconDescriptor = ImageDescriptor.createFromURL(BundleUtility.find(Platform.getBundle(element.getDeclaringExtension().getNamespaceIdentifier()), iconPath));
					}
					DeviceRegistration dr = new DeviceRegistration(id, name, clazz, iconDescriptor, element);
					devices.put(id, dr);
					devicesByClass.put(clazz, dr);
					//TODO: check for and add views and anything else you add later
    		}
    	}
  	}
	}

	private static HardwareRegistry get()
	{
		if (instance == null)
		{
			instance = new HardwareRegistry();
		}
		return instance;
	}
	
	public static Collection<DeviceRegistration> getDevices()
	{
		return get().devices.values();
	}
	
	public static DeviceRegistration getDeviceByClass(Class<?> clazz)
	{
		return get().devicesByClass.get(clazz);
	}
	//TODO handle bundle changes?
}
