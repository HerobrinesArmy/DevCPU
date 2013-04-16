package devcpu.views;

import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.Panel;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IMenuListener;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.awt.SWT_AWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.IPartListener;
import org.eclipse.ui.IPerspectiveDescriptor;
import org.eclipse.ui.IPerspectiveListener2;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchPartReference;

import devcpu.Activator;
import devcpu.emulation.DCPUHardware;
import devcpu.emulation.LEM1802Viewer;
import devcpu.emulation.VirtualMonitor;
import devcpu.util.Util;

public class LEM1802View extends MappedView<VirtualMonitor> {
	public static final String ID = "devcpu.views.LEM1802View";
	
	private Action detachAction;
	private LEM1802Viewer lv = new LEM1802Viewer();
	
	public void createPartControl(Composite parent) {
		setPartName("LEM1802 - Not Connected");
		Composite composite = new Composite(parent, SWT.EMBEDDED);
		getSite().getWorkbenchWindow().addPerspectiveListener(new IPerspectiveListener2() {
			@Override public void perspectiveActivated(IWorkbenchPage page, IPerspectiveDescriptor perspective){}
			@Override public void perspectiveChanged(IWorkbenchPage page, IPerspectiveDescriptor perspective, String changeId){}

			@Override
			public void perspectiveChanged(IWorkbenchPage page, IPerspectiveDescriptor perspective, IWorkbenchPartReference partRef, String changeId) {
				if (LEM1802View.this.equals(partRef.getPart(false)) && changeId == IWorkbenchPage.CHANGE_VIEW_HIDE) {
					lv.die();
				}
			}
		});
		this.getSite().getPage().addPartListener(new IPartListener() {
			@Override public void partOpened(IWorkbenchPart part){}
			@Override public void partClosed(IWorkbenchPart part){
				if (lv.vm != null) {
					unmap(lv.vm);
				}
			}
			@Override public void partBroughtToTop(IWorkbenchPart part){}
			@Override public void partDeactivated(IWorkbenchPart part){}
			@Override public void partActivated(IWorkbenchPart part){}
		});
		Frame frame = SWT_AWT.new_Frame(composite);
		Panel panel = new Panel();
		panel.setLayout(new BorderLayout()); 
		panel.add(lv.canvas, BorderLayout.CENTER);
		frame.add(panel);
		lv.canvas.setup();
		makeActions();
		contributeToActionBars();
	}

	public void setFocus() {
	}

	private void contributeToActionBars() {
		IActionBars bars = getViewSite().getActionBars();
		fillLocalPullDown(bars.getMenuManager());
	}

	private void fillLocalPullDown(IMenuManager manager) {
		final MenuManager attachSubmenu = new MenuManager("Attach LEM1802",Util.getImageDescriptor("icons/lem.png"),null);
		attachSubmenu.setRemoveAllWhenShown(true);
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