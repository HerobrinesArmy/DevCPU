package devcpu.views.hex;

import org.eclipse.swt.*;
import org.eclipse.swt.widgets.*;
import org.eclipse.ui.part.ViewPart;

import devcpu.Activator;

public class HexView extends ViewPart {
	
	private IDataProvider idp;
	private HexViewer hv;
		
	public HexView() {
		super();
		idp = new DCPUMemoryDataProvider(Activator.getShip().getDCPUManager().getDCPUs().get(0));
	}
			
	/// creates all the widgets, and registers some events
	public void createPartControl(Composite parent) {
		hv = new HexViewer(parent,SWT.NONE,idp,8);
	}

	public void setFocus() {
		hv.setDataProvider(idp);
	}	
}
