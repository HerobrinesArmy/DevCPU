package devcpu;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;

import devcpu.util.Util;

public class IntroPart extends org.eclipse.ui.part.IntroPart {
	private Label label;

	@Override
	public void createPartControl(Composite container) {
    Composite outerContainer = new Composite(container, SWT.NONE);
    outerContainer.setBackground(new Color(Display.getDefault(), new RGB(190, 190, 190)));
    Composite innerContainer = new Composite(outerContainer, SWT.CENTER);
    FillLayout fillLayout = new FillLayout();
    innerContainer.setLayout(fillLayout);
    innerContainer.setSize(960, 540);
    innerContainer.setBackgroundImage(new Image(Display.getDefault(), Util.loadResource("icons/fade.png")));
    innerContainer.setBackgroundMode(SWT.INHERIT_DEFAULT);
    container.getShell().setBackgroundMode(SWT.INHERIT_DEFAULT);
    label = new Label(innerContainer, SWT.CENTER);
    label.setText("\n\n\n\n\nWelcome to DevCPU v.0.0.0 (Release 0 Update 0)\nThis version is undocumented and unsupported. API stability, at this point, is nonexistent.\nNote: There are not currently any debugging features. If you think you found some here, you're wrong.\n\nSo deal with it.\n\n\nClose this tab to load the workbench.");
//    GridData gd = new GridData(GridData.GRAB_HORIZONTAL | GridData.GRAB_VERTICAL);
//    gd.horizontalAlignment = GridData.CENTER;
//    gd.verticalAlignment = GridData.CENTER;
//    label.setLayoutData(gd);
	}

	@Override
	public void standbyStateChanged(boolean standby) {
		// TODO Auto-generated method stub
	}

	@Override
	public void setFocus() {
		// TODO Auto-generated method stub
	}
}
