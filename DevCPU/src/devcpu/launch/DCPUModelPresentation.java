package devcpu.launch;

import java.math.BigInteger;
import java.util.ArrayList;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.debug.core.model.IDebugModelProvider;
import org.eclipse.debug.core.model.IMemoryBlock;
import org.eclipse.debug.core.model.IStackFrame;
import org.eclipse.debug.core.model.IThread;
import org.eclipse.debug.core.model.IValue;
import org.eclipse.debug.core.model.MemoryByte;
import org.eclipse.debug.ui.IDebugEditorPresentation;
import org.eclipse.debug.ui.IDebugModelPresentation;
import org.eclipse.debug.ui.IDebugModelPresentationExtension;
import org.eclipse.debug.ui.IValueDetailListener;
import org.eclipse.debug.ui.memory.IMemoryBlockTablePresentation;
import org.eclipse.debug.ui.memory.MemoryRenderingElement;
import org.eclipse.jface.viewers.IColorProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.part.FileEditorInput;
import org.eclipse.ui.progress.UIJob;

import devcpu.Activator;
import devcpu.assembler.Assembly;
import devcpu.editors.dasm.DASMColorProvider;
import devcpu.emulation.DefaultControllableDCPU;

public class DCPUModelPresentation implements IDebugModelPresentation, IDebugModelPresentationExtension, IDebugEditorPresentation, IColorProvider, IMemoryBlockTablePresentation, IDebugModelProvider {
	private static DCPUModelPresentation presentation;
	private static Color blue;

	public DCPUModelPresentation() {
		System.out.println("DCPUModelPresentation");// TODO Auto-generated constructor stub
	}
	
	public static DCPUModelPresentation getDCPUModelPresentation()
	{
		if (presentation == null)
		{
			presentation = new DCPUModelPresentation();
		
			UIJob job = new UIJob("get colors"){
				public IStatus runInUIThread(IProgressMonitor monitor) {
					Display display = Activator.getDefault().getWorkbench().getDisplay();
					blue = display.getSystemColor(SWT.COLOR_BLUE);
					return Status.OK_STATUS;
				}};
			job.schedule();
		}
		
		return presentation;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.jface.viewers.IBaseLabelProvider#addListener(org.eclipse.jface.viewers.ILabelProviderListener)
	 */
	public void addListener(ILabelProviderListener listener) {
		//TODO
		System.out.println("DCPUModelPresentation addListener " + listener.getClass().getCanonicalName());
	}

	/* (non-Javadoc)
	 * @see org.eclipse.debug.ui.IDebugModelPresentation#computeDetail(org.eclipse.debug.core.model.IValue, org.eclipse.debug.ui.IValueDetailListener)
	 */
	public void computeDetail(IValue value, IValueDetailListener listener) {
		System.out.println("DCPUModelPresentation computeDetail " + value.getClass().getCanonicalName() + " " + listener.getClass().getCanonicalName());
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.viewers.IBaseLabelProvider#dispose()
	 */
	public void dispose() {
		System.out.println("DCPUModelPresentation dispose");
		//TODO
	}

	public Color getBackground(Object element) {
		System.out.println("DCPUModelPresentation getBackground " + element.getClass().getCanonicalName());
		return DASMColorProvider.get().getColor(new RGB(255, 127, 127));
	}

	/* (non-Javadoc)
	 * @see org.eclipse.debug.ui.ISourcePresentation#getEditorId(org.eclipse.ui.IEditorInput, java.lang.Object)
	 */
	public String getEditorId(IEditorInput input, Object element) {
		System.out.println("DCPUModelPresentation getEditorId " + input.getClass().getCanonicalName() + " " + element.getClass().getCanonicalName());
		if (element instanceof DefaultControllableDCPU) {
			if (((DefaultControllableDCPU) element).getAssembly() != null) {
				System.out.println("devcpu.dasmeditor");
				return "devcpu.dasmeditor";
			}
		}
		System.out.println("no editor id");
		return null;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.debug.ui.ISourcePresentation#getEditorInput(java.lang.Object)
	 */
	public IEditorInput getEditorInput(Object element) {
		System.out.println("DCPUModelPresentation getEditorInput " + element.getClass().getCanonicalName());
		if (element instanceof DefaultControllableDCPU) {
			DefaultControllableDCPU dcpu = (DefaultControllableDCPU) element;
			Assembly a = dcpu.getAssembly();
			if (a != null) {
				System.out.println("DefaultControllableDCPU element");
				System.out.println(a.getLineFromOffset(dcpu.pc).getDocument().getFile().getName());
				return new FileEditorInput(a.getLineFromOffset(dcpu.pc).getDocument().getFile());
			}
		}
		System.out.println("some other element");
		return null;
	}

	public Color getForeground(Object element) {
		System.out.println("DCPUModelPresentation getForeground " + element.getClass().getCanonicalName());
		if (element instanceof MemoryRenderingElement)
		{
			MemoryRenderingElement elm = (MemoryRenderingElement) element;
			MemoryByte[] bytes = elm.getBytes();
			if (!bytes[0].isWritable())
			{
				return blue;
			}
		}
		return null;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.viewers.ILabelProvider#getImage(java.lang.Object)
	 */
	public Image getImage(Object element) {
		System.out.println("DCPUModelPresentation getImage " + element.getClass().getCanonicalName());
		return null;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.viewers.ILabelProvider#getText(java.lang.Object)
	 */
	public String getText(Object element) {
		System.out.println("DCPUModelPresentation getText " + element.getClass().getCanonicalName());
		return "TEXT";
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.viewers.IBaseLabelProvider#isLabelProperty(java.lang.Object, java.lang.String)
	 */
	public boolean isLabelProperty(Object element, String property) {
		System.out.println("DCPUModelPresentation isLabelProperty " + element.getClass().getCanonicalName() + " " + property);
		//TODO
		return false;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.viewers.IBaseLabelProvider#removeListener(org.eclipse.jface.viewers.ILabelProviderListener)
	 */
	public void removeListener(ILabelProviderListener listener) {
		System.out.println("DCPUModelPresentation removeListener " + listener.getClass().getCanonicalName());
		//TODO
	}

	/* (non-Javadoc)
	 * @see org.eclipse.debug.ui.IDebugModelPresentation#setAttribute(java.lang.String, java.lang.Object)
	 */
	public void setAttribute(String attribute, Object value) {
		System.out.println("DCPUModelPresentation setAttribute " + attribute + " " + value.getClass().getCanonicalName());
		//TODO
	}

	@Override
	public String[] getColumnLabels(IMemoryBlock blk, int bytesPerLine, int numColumns) {
		System.out.println("DCPUModelPresentation getColumnLabels " + blk.getClass().getCanonicalName() + " " + bytesPerLine + " " + numColumns);
		// TODO Auto-generated method stub
		ArrayList<String> labels = new ArrayList<String>();
		for (int i = 0; i < numColumns; i++) {
			labels.add("COLUMN");
		}
		return labels.toArray(new String[0]);
	}

	@Override
	public String getRowLabel(IMemoryBlock blk, BigInteger address) {
		System.out.println("DCPUModelPresentation getRowLabel " + blk.getClass().getCanonicalName() + " " + address.getClass().getCanonicalName());
		// TODO Auto-generated method stub
		return "ROW";
	}

	@Override
	public boolean addAnnotations(IEditorPart editorPart, IStackFrame frame) {
		System.out.println("DCPUModelPresentation addAnnotations " + editorPart.getClass().getCanonicalName() + " " + frame.getClass().getCanonicalName());
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void removeAnnotations(IEditorPart editorPart, IThread thread) {
		System.out.println("DCPUModelPresentation removeAnnotations " + editorPart.getClass().getCanonicalName() + " " + thread.getClass().getCanonicalName());
		// TODO Auto-generated method stub
	}

	@Override
	public boolean requiresUIThread(Object element) {
		System.out.println("DCPUModelPresentation requiresUIThread " + element.getClass().getCanonicalName());
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String[] getModelIdentifiers() {
		System.out.println("DCPUModelPresentation getModelIdentifiers ");
		return new String[]{"devcpu.debugmodel"};
	}
}
