package devcpu.launch;

import java.math.BigInteger;
import java.util.ArrayList;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.debug.core.model.IMemoryBlock;
import org.eclipse.debug.core.model.IValue;
import org.eclipse.debug.core.model.MemoryByte;
import org.eclipse.debug.ui.IDebugModelPresentation;
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
import org.eclipse.ui.progress.UIJob;

import devcpu.Activator;
import devcpu.editors.dasm.DASMColorProvider;

public class DCPUModelPresentation implements IDebugModelPresentation, IColorProvider, IMemoryBlockTablePresentation {

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
	}

	/* (non-Javadoc)
	 * @see org.eclipse.debug.ui.IDebugModelPresentation#computeDetail(org.eclipse.debug.core.model.IValue, org.eclipse.debug.ui.IValueDetailListener)
	 */
	public void computeDetail(IValue value, IValueDetailListener listener) {
		//TODO
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.viewers.IBaseLabelProvider#dispose()
	 */
	public void dispose() {
		//TODO
	}

	public Color getBackground(Object element) {
		return DASMColorProvider.get().getColor(new RGB(255, 127, 127));
	}

	/* (non-Javadoc)
	 * @see org.eclipse.debug.ui.ISourcePresentation#getEditorId(org.eclipse.ui.IEditorInput, java.lang.Object)
	 */
	public String getEditorId(IEditorInput input, Object element) {
		return null;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.debug.ui.ISourcePresentation#getEditorInput(java.lang.Object)
	 */
	public IEditorInput getEditorInput(Object element) {
		return null;
	}

	public Color getForeground(Object element) {

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
		return null;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.viewers.ILabelProvider#getText(java.lang.Object)
	 */
	public String getText(Object element) {
		return "TEXT";
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.viewers.IBaseLabelProvider#isLabelProperty(java.lang.Object, java.lang.String)
	 */
	public boolean isLabelProperty(Object element, String property) {
		//TODO
		return false;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.viewers.IBaseLabelProvider#removeListener(org.eclipse.jface.viewers.ILabelProviderListener)
	 */
	public void removeListener(ILabelProviderListener listener) {
		//TODO
	}

	/* (non-Javadoc)
	 * @see org.eclipse.debug.ui.IDebugModelPresentation#setAttribute(java.lang.String, java.lang.Object)
	 */
	public void setAttribute(String attribute, Object value) {
		//TODO
	}

	@Override
	public String[] getColumnLabels(IMemoryBlock blk, int bytesPerLine, int numColumns) {
		// TODO Auto-generated method stub
		ArrayList<String> labels = new ArrayList<String>();
		for (int i = 0; i < numColumns; i++) {
			labels.add("COLUMN");
		}
		return labels.toArray(new String[0]);
	}

	@Override
	public String getRowLabel(IMemoryBlock blk, BigInteger address) {
		// TODO Auto-generated method stub
		return "ROW";
	}
}
