package devcpu.views.hex;

import org.eclipse.swt.*;
import org.eclipse.swt.widgets.*;
import org.eclipse.ui.part.ViewPart;

public class HexView extends ViewPart {
	
	private IDataProvider idp;
	private HexViewer hv;
		
	public HexView() {
		super();
		//idp = new FileDataProvider("C:\\Program Files\\Microsoft Visual Studio 8\\VSKnownIssues.htm");
		idp = new FileDataProvider("C:\\python24\\py.ico");		
	}
			
	/// creates all the widgets, and registers some events
	public void createPartControl(Composite parent) {
		hv = new HexViewer(parent,SWT.NONE,null,16);
	}

	public void setFocus() {
		hv.setDataProvider(idp);
	}	
}
