package devcpu.views;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IMenuListener;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.IWorkbenchActionConstants;
import org.eclipse.ui.PlatformUI;

import devcpu.Activator;
import devcpu.MappedView;
import devcpu.emulation.DefaultControllableDCPU;

public class DCPUView extends MappedView<DefaultControllableDCPU>/* implements DCPUTickListener*/ {

	public static final String ID = "devcpu.views.DCPUView";
	
	private Action detachAction;
	private Text txtA;
	private Text txtB;
	private Text txtC;
	private Text txtX;
	private Text txtY;
	private Text txtZ;
	private Text txtI;
	private Text txtJ;
	private Text txtPC;
	private Text txtSP;
	private Text txtEX;
	private Text txtIA;

	DefaultControllableDCPU dcpu;
	
	public void createPartControl(Composite parent) {
		setPartName("DCPU - Not Connected");
		Composite container = new Composite(parent, SWT.NONE);
		
		Group grpRegisters = new Group(container, SWT.NONE);
		grpRegisters.setFont(new Font(parent.getDisplay(), new FontData("Fixedsys", 10, SWT.NORMAL)));
		grpRegisters.setText("Registers");
		grpRegisters.setBounds(10, 10, 183, 183);
		
		makeRegisterLabel(" A", 0,   24, grpRegisters);
		makeRegisterLabel(" B", 0,   49, grpRegisters);
		makeRegisterLabel(" C", 0,   75, grpRegisters);
		makeRegisterLabel(" X", 0,  101, grpRegisters);
		makeRegisterLabel(" Y", 0,  127, grpRegisters);
		makeRegisterLabel(" Z", 0,  153, grpRegisters);

		makeRegisterLabel(" I", 98,  24, grpRegisters);
		makeRegisterLabel(" J", 98,  49, grpRegisters);
		makeRegisterLabel("PC", 98,  75, grpRegisters);
		makeRegisterLabel("SP", 98, 101, grpRegisters);
		makeRegisterLabel("EX", 98, 127, grpRegisters);
		makeRegisterLabel("IA", 98, 153, grpRegisters);
		
		txtA  = makeRegisterText(26,   24, grpRegisters);
		txtB  = makeRegisterText(26,   49, grpRegisters);
		txtC  = makeRegisterText(26,   75, grpRegisters);
		txtX  = makeRegisterText(26,  101, grpRegisters);
		txtY  = makeRegisterText(26,  127, grpRegisters);
		txtZ  = makeRegisterText(26,  153, grpRegisters);
		
		txtI  = makeRegisterText(124,  24, grpRegisters);
		txtJ  = makeRegisterText(124,  49, grpRegisters);
		txtPC = makeRegisterText(124,  75, grpRegisters);
		txtSP = makeRegisterText(124, 101, grpRegisters);
		txtEX = makeRegisterText(124, 127, grpRegisters);
		txtIA = makeRegisterText(124, 153, grpRegisters);
		
		makeActions();
		hookContextMenu();
//		hookDoubleClickAction();
		contributeToActionBars();
		final Display display = parent.getDisplay();
		Runnable timer = new Runnable() {
      public void run() {
      	if (dcpu != null) {
      		try {
	      		txtA.setText(toHexString((short) dcpu.registers[0]));
	      		txtB.setText(toHexString((short) dcpu.registers[1]));
	      		txtC.setText(toHexString((short) dcpu.registers[2]));
	      		txtX.setText(toHexString((short) dcpu.registers[3]));
	      		txtY.setText(toHexString((short) dcpu.registers[4]));
	      		txtZ.setText(toHexString((short) dcpu.registers[5]));
	      		txtI.setText(toHexString((short) dcpu.registers[6]));
	      		txtJ.setText(toHexString((short) dcpu.registers[7]));
	      		txtPC.setText(toHexString((short) dcpu.pc));
	      		txtSP.setText(toHexString((short) dcpu.sp));
	      		txtEX.setText(toHexString((short) dcpu.ex));
	      		txtIA.setText(toHexString((short) dcpu.ia));
      		} catch (Exception e){}
      	}
        display.timerExec(16, this);
      }
    };
    display.timerExec(16, timer);
	}

	public static char[] HEX_TABLE = {
    '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'
};
	
  static public String toHexString(short value) {
    StringBuilder buffer = new StringBuilder(4);
    appendHexString(buffer, value);
    return buffer.toString();
}

static public void appendHexString(StringBuilder buffer, short value) {
    int nibble = (value & 0xF000) >>> 12;
    buffer.append(HEX_TABLE[nibble]);
    nibble = (value & 0x0F00) >>> 8;
    buffer.append(HEX_TABLE[nibble]);
    nibble = (value & 0x00F0) >>> 4;
    buffer.append(HEX_TABLE[nibble]);
    nibble = (value & 0x000F);
    buffer.append(HEX_TABLE[nibble]);
}

	private Text makeRegisterText(int x, int y, Group grp) {
		Text txt = new Text(grp, SWT.NONE);
		txt.setFont(new Font(grp.getDisplay(), new FontData("Fixedsys", 10, SWT.NORMAL)));
		txt.setText("0000");
		txt.setBounds(x, y, 48, 20);
		return txt;
	}

	private void makeRegisterLabel(String txt, int x, int y, Group grp) {
		Label lblB = new Label(grp, SWT.NONE);
		lblB.setText(txt);
		lblB.setFont(new Font(grp.getDisplay(), new FontData("Fixedsys", 10, SWT.NORMAL)));
		lblB.setAlignment(SWT.RIGHT);
		lblB.setBounds(x, y, 20, 20);		
	}

	public void setFocus() {
	}

	private void hookContextMenu() {
		MenuManager menuMgr = new MenuManager("#PopupMenu");
		menuMgr.setRemoveAllWhenShown(true);
		menuMgr.addMenuListener(new IMenuListener() {
			public void menuAboutToShow(IMenuManager manager) {
				DCPUView.this.fillContextMenu(manager);
			}
		});
	}

	private void contributeToActionBars() {
		IActionBars bars = getViewSite().getActionBars();
		fillLocalPullDown(bars.getMenuManager());
		fillLocalToolBar(bars.getToolBarManager());
	}

	private void fillLocalPullDown(IMenuManager manager) {
		final MenuManager attachSubmenu = new MenuManager("Attach DCPU");
		attachSubmenu.add(new Action(){});
		attachSubmenu.addMenuListener(new IMenuListener() {
			@Override
			public void menuAboutToShow(IMenuManager manager) {
				attachSubmenu.removeAll();
				for (final DefaultControllableDCPU d : Activator.getDefault().getShip().getDCPUManager().getDCPUs()) {
					attachSubmenu.add(new Action(d.getID()) {
						public void run() {
							connect(d);
						}
					});
				}
			}
		});
		manager.add(attachSubmenu);
		manager.add(detachAction);
	}

	private void fillContextMenu(IMenuManager manager) {
		manager.add(detachAction);
		manager.add(new Separator(IWorkbenchActionConstants.MB_ADDITIONS));
	}
	
	private void fillLocalToolBar(IToolBarManager manager) {
//		final MenuManager attachSubmenu = new MenuManager("Attach DCPU");
//		attachSubmenu.addMenuListener(new IMenuListener() {
//			@Override
//			public void menuAboutToShow(IMenuManager manager) {
//				attachSubmenu.removeAll();
//				for (final DefaultControllableDCPU d : Activator.getDefault().getShip().getDCPUManager().getDCPUs()) {
//					attachSubmenu.add(new Action(d.getID()) {
//						public void run() {
//							connect(d);
//						}
//					});
//				}
//			}
//		});
//		manager.add(attachSubmenu);
//		manager.add(detachAction);
	}

	private void connect(DefaultControllableDCPU d) {
		map(d);
	}
	
	private void disconnect() {
		mapTo(null);
	}
	
	private void makeActions() {
		detachAction = new Action() {
			public void run() {
				if (dcpu != null) {
					disconnect();
				}
			}
		};
		detachAction.setText("Detach Viewer");
		detachAction.setToolTipText("Detach the viewer from the DCPU");
		detachAction.setImageDescriptor(PlatformUI.getWorkbench().getSharedImages().
			getImageDescriptor(ISharedImages.IMG_OBJS_INFO_TSK));
		
	}

	@Override
	public boolean mapTo(DefaultControllableDCPU o) {
		if (dcpu != null) {
			unmap(dcpu);
		}
		dcpu = o;
		if (o == null) {
			setPartName("DCPU - Not Connected");
		} else {
			setPartName(o.getID());
		}
		return true;
	}

	@Override
	public DefaultControllableDCPU getMappedObject() {
		return dcpu;
	}

//	@Override
//	public void tick(DefaultControllableDCPU dcpu) {
//		txtA.setText(toHexString((short) dcpu.registers[0]));
//		txtB.setText(toHexString((short) dcpu.registers[1]));
//		txtC.setText(toHexString((short) dcpu.registers[2]));
//		txtX.setText(toHexString((short) dcpu.registers[3]));
//		txtY.setText(toHexString((short) dcpu.registers[4]));
//		txtZ.setText(toHexString((short) dcpu.registers[5]));
//		txtI.setText(toHexString((short) dcpu.registers[6]));
//		txtJ.setText(toHexString((short) dcpu.registers[7]));
//		txtPC.setText(toHexString((short) dcpu.pc));
//		txtSP.setText(toHexString((short) dcpu.sp));
//		txtEX.setText(toHexString((short) dcpu.ex));
//		txtIA.setText(toHexString((short) dcpu.ia));
//	}
}