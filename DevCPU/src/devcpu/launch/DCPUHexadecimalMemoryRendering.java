package devcpu.launch;

import org.eclipse.debug.internal.ui.views.memory.renderings.HexIntegerRendering;

@SuppressWarnings("restriction")
public class DCPUHexadecimalMemoryRendering extends HexIntegerRendering {
	public DCPUHexadecimalMemoryRendering(String renderingId) {
		super(renderingId);
		System.out.println("HMR construct");
	}
}
