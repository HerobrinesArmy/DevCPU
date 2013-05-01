package devcpu.launch;

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.model.IBreakpoint;
import org.eclipse.debug.core.model.LineBreakpoint;

public class DCPUBreakpoint extends LineBreakpoint {
	public DCPUBreakpoint(IResource resource, int lineNumber) throws CoreException {
		System.out.println("DCPUBreakpoint DCPUBreakpoint");
    IMarker marker = resource.createMarker("org.eclipse.debug.examples.core.pda.lineBreakpoint.marker");
    setMarker(marker);
    setEnabled(true);
    ensureMarker().setAttribute(IMarker.LINE_NUMBER, lineNumber);
    ensureMarker().setAttribute(IBreakpoint.ID, DCPUModelPresentation.DEBUG_MODEL_ID);
 }

	@Override
	public String getModelIdentifier() {
		System.out.println("DCPUBreakpoint getModelIdentifier");
		return DCPUModelPresentation.DEBUG_MODEL_ID;
	}
}
