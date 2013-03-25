package devcpu.perspectives;

import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IPerspectiveFactory;

public class DCPUHybridPerspective implements IPerspectiveFactory {
	public void createInitialLayout(IPageLayout layout) {
		layout.addNewWizardShortcut("devcpu.dasmfilewizard");
	}
}
