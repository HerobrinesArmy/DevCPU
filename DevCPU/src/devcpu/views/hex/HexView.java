package devcpu.views.hex;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.part.ViewPart;

public class HexView extends ViewPart {
	public static final String VIEW_ID = "devcpu.hexview";
	private HexViewer hv;
		
	public HexView() {
		super();
		//idp = new DCPUMemoryDataProvider(Activator.getShip().getDCPUManager().getDCPUs().get(0));
	}
	
	public void createPartControl(Composite parent) {
		hv = new HexViewer(parent,SWT.NONE,null,8);
	}
	
	public void setDataProvider(IDataProvider dp)
	{
		hv.setDataProvider(dp);
	}

	public void setFocus() {
		hv.fullRefresh();
	}
}
