package devcpu.util;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Collections;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.internal.util.BundleUtility;
import org.osgi.framework.Bundle;

import devcpu.Activator;

@SuppressWarnings("restriction")
public class Util {
	public static int parseValue(String text) {
		int val = 0;
		if (text.startsWith("0x")) {
    	val = Integer.parseInt(text.substring(2), 16);
    } else if (text.startsWith("0b")) {
    	val = Integer.parseInt(text.substring(2), 2);
    } else if (text.startsWith("'") && text.endsWith("'") && text.length()==3) {
			val = text.charAt(1);
		} else {
    	val = Integer.parseInt(text);
    }
//    val &= 0xFFFF;
    return val;
	}

	public static String join(String[] array, char separator) {
		if (array == null) {
			return null;
		}
		int bufSize = array.length;
		if (bufSize <= 0) {
			return "";
		}

		bufSize *= ((array[0] == null ? 16 : array[0].toString().length()) + 1);
		StringBuffer buf = new StringBuffer(bufSize);

		for (int i = 0; i < array.length; i++) {
			if (i > 0) {
				buf.append(separator);
			}
			if (array[i] != null) {
				buf.append(array[i]);
			}
		}
		return buf.toString();
	}

	public static ImageDescriptor getImageDescriptor(String path) {
		Bundle bundle = Platform.getBundle(Activator.PLUGIN_ID);
		URL fullPathString = BundleUtility.find(bundle, path);
		return ImageDescriptor.createFromURL(fullPathString);
	}
	
	public static String loadResource(String filename) {
		URL url = FileLocator.find(Activator.getDefault().getBundle(), new org.eclipse.core.runtime.Path(filename), Collections.EMPTY_MAP);
		URL fileUrl = null;
		try {
		fileUrl = FileLocator.toFileURL(url);
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		try {
			return fileUrl.toURI().getRawPath();
		} catch (URISyntaxException e) {
			return null;
		}
	}
}
