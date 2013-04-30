package devcpu.editors.dasm;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.debug.core.model.IBreakpoint;
import org.eclipse.debug.core.model.ILineBreakpoint;
import org.eclipse.debug.ui.actions.IToggleBreakpointsTarget;
import org.eclipse.jface.text.ITextSelection;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.texteditor.ITextEditor;

import devcpu.launch.DCPUBreakpoint;

public class DASMLineBreakpointAdapter implements IToggleBreakpointsTarget {
	@Override
	public void toggleLineBreakpoints(IWorkbenchPart part, ISelection selection) throws CoreException {
		System.out.println("DASMLineBreakpointAdapter toggleLineBreakpoints " + part.getClass().getCanonicalName() + " " + selection.getClass().getCanonicalName());
		ITextEditor textEditor = getEditor(part);
		if (textEditor != null) {
			IResource resource = (IResource) textEditor.getEditorInput().getAdapter(IResource.class);
			ITextSelection textSelection = (ITextSelection) selection;
			int lineNumber = textSelection.getStartLine();
			IBreakpoint[] breakpoints = DebugPlugin.getDefault().getBreakpointManager().getBreakpoints("devcpu.debugmodel");
			for (int i = 0; i < breakpoints.length; i++) {
				IBreakpoint breakpoint = breakpoints[i];
				if (resource.equals(breakpoint.getMarker().getResource())) {
					if (((ILineBreakpoint)breakpoint).getLineNumber() == (lineNumber + 1)) {
						// remove
						breakpoint.delete();
						return;
					}
				}
			}
			// create line breakpoint (doc line numbers start at 0)
			DCPUBreakpoint lineBreakpoint = new DCPUBreakpoint(resource, lineNumber + 1);
			DebugPlugin.getDefault().getBreakpointManager().addBreakpoint(lineBreakpoint);
		}
	}

	@Override
	public boolean canToggleLineBreakpoints(IWorkbenchPart part, ISelection selection) {
		System.out.println("DASMLineBreakpointAdapter canToggleLineBreakpoints " + part.getClass().getCanonicalName() + " " + selection.getClass().getCanonicalName());
		return getEditor(part) != null;
	}
	
	private ITextEditor getEditor(IWorkbenchPart part) {
		if (part instanceof ITextEditor) {
			ITextEditor editorPart = (ITextEditor) part;
			IResource resource = (IResource) editorPart.getEditorInput().getAdapter(IResource.class);
			if (resource != null) {
				String extension = resource.getFileExtension();
				if (extension != null && extension.equals("pda")) {
					return editorPart;
				}
			}
		}
		return null;		
	}

	@Override
	public void toggleMethodBreakpoints(IWorkbenchPart part, ISelection selection) throws CoreException {
		System.out.println("DASMLineBreakpointAdapter toggleMethodBreakpoints " + part.getClass().getCanonicalName() + " " + selection.getClass().getCanonicalName());
	}

	@Override
	public boolean canToggleMethodBreakpoints(IWorkbenchPart part, ISelection selection) {
		System.out.println("DASMLineBreakpointAdapter canToggleMethodBreakpoints " + part.getClass().getCanonicalName() + " " + selection.getClass().getCanonicalName());
		return false;
	}

	@Override
	public void toggleWatchpoints(IWorkbenchPart part, ISelection selection) throws CoreException {
		System.out.println("DASMLineBreakpointAdapter toggleWatchpoints " + part.getClass().getCanonicalName() + " " + selection.getClass().getCanonicalName());
	}

	@Override
	public boolean canToggleWatchpoints(IWorkbenchPart part, ISelection selection) {
		System.out.println("DASMLineBreakpointAdapter canToggleWatchpoints " + part.getClass().getCanonicalName() + " " + selection.getClass().getCanonicalName());
		return false;
	}
}
