package devcpu.editors.dasm;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IAdapterFactory;
import org.eclipse.debug.ui.actions.IToggleBreakpointsTarget;
import org.eclipse.ui.texteditor.ITextEditor;

public class DASMBreakpointAdaptorFactory implements IAdapterFactory {

	@SuppressWarnings("rawtypes")
	@Override
	public Object getAdapter(Object adaptableObject, Class adapterType) {
		System.out.println("DASMBreakpointAdaptorFactory getAdapter " + adaptableObject.getClass().getCanonicalName() + " " + adapterType.getCanonicalName());
		if (adaptableObject instanceof ITextEditor) {
			ITextEditor editorPart = (ITextEditor) adaptableObject;
			IResource resource = (IResource) editorPart.getEditorInput().getAdapter(IResource.class);
			if (resource != null) {
				String extension = resource.getFileExtension();
				if (extension != null && extension.equals("pda")) {
					return new DASMLineBreakpointAdapter();
				}
			}			
		}
		return null;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public Class[] getAdapterList() {
		System.out.println("DASMBreakpointAdaptorFactory getAdapterList ");
		return new Class[]{IToggleBreakpointsTarget.class};
	}

}
