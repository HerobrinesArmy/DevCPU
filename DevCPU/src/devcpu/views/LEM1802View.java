package devcpu.views;

import java.awt.Frame;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IMenuListener;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.awt.SWT_AWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.IWorkbenchActionConstants;

import devcpu.Activator;
import devcpu.emulation.DCPUHardware;
import devcpu.emulation.LEM1802Viewer;
import devcpu.emulation.VirtualMonitor;
import devcpu.util.Util;

public class LEM1802View extends MappedView<VirtualMonitor> {

	public static final String ID = "devcpu.views.LEM1802View";
	
	private Action detachAction;

	LEM1802Viewer lv = new LEM1802Viewer();
	private Frame frame;
	
	public void createPartControl(Composite parent) {
		setPartName("LEM1802 - Not Connected");
		Composite composite = new Composite(parent, SWT.EMBEDDED);
		frame = SWT_AWT.new_Frame(composite);
		frame.add(lv.canvas);
		makeActions();
		hookContextMenu();
		contributeToActionBars();
	}

	public void setFocus() {
	}

	private void hookContextMenu() {
		MenuManager menuMgr = new MenuManager("#PopupMenu");
		menuMgr.setRemoveAllWhenShown(true);
		menuMgr.addMenuListener(new IMenuListener() {
			public void menuAboutToShow(IMenuManager manager) {
				LEM1802View.this.fillContextMenu(manager);
			}
		});
	}

	private void contributeToActionBars() {
		IActionBars bars = getViewSite().getActionBars();
		fillLocalPullDown(bars.getMenuManager());
		fillLocalToolBar(bars.getToolBarManager());
	}

	private void fillLocalPullDown(IMenuManager manager) {
		final MenuManager attachSubmenu = new MenuManager("Attach LEM1802",Util.getImageDescriptor("icons/lem.png"),null);
		attachSubmenu.add(new Action(){});
		attachSubmenu.addMenuListener(new IMenuListener() {
			@Override
			public void menuAboutToShow(IMenuManager manager) {
				attachSubmenu.removeAll();
				for (DCPUHardware h : Activator.getShip().getHardwareManager().getDevices(VirtualMonitor.class)) {
					final VirtualMonitor vm = ((VirtualMonitor)h);
					attachSubmenu.add(new Action(vm.getID()) {
						@Override
  	    		public ImageDescriptor getImageDescriptor() {
  	    			return Util.getImageDescriptor("icons/lem.png");
  	    		}
  	    		public void run() {
							synchronized (lv) {
								map(vm);
							}
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
		// Other plug-ins can contribute there actions here
		manager.add(new Separator(IWorkbenchActionConstants.MB_ADDITIONS));
	}
	
	private void fillLocalToolBar(IToolBarManager manager) {
//		final MenuManager attachSubmenu = new MenuManager("Attach LEM1802");
//		attachSubmenu.addMenuListener(new IMenuListener() {
//			@Override
//			public void menuAboutToShow(IMenuManager manager) {
//				attachSubmenu.removeAll();
//				for (DCPUHardware h : Activator.getDefault().getShip().getDeviceManager().getDevices(VirtualMonitor.class)) {
//					final VirtualMonitor vm = ((VirtualMonitor)h);
//					attachSubmenu.add(new Action(vm.getID()) {
//						public void run() {
//							synchronized (lv) {
//								map(vm);
//							}
//						}
//					});
//				}
//			}
//		});
//		manager.add(attachSubmenu);
//		manager.add(detachAction);
	}

	private void makeActions() {
		detachAction = new Action() {
			public void run() {
				synchronized (lv) {
					mapTo(null);
				}
			}
		};
		detachAction.setText("Detach Viewer");
		detachAction.setToolTipText("Detach the viewer from the LEM1802");
	}

	@Override
	public boolean mapTo(VirtualMonitor o) {
		if (lv.vm != null) {
			unmap(lv.vm);
		}
		if (o == null) {
			lv.detach();
			setPartName("LEM1802 - Not Connected");
		} else {
			lv.attach(o);
			setPartName(o.getID());
		}
		return true;
	}

	@Override
	public VirtualMonitor getMappedObject() {
		return lv.vm;
	}
}