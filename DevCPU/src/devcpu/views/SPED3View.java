package devcpu.views;

import java.awt.Frame;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IMenuListener;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.swt.SWT;
import org.eclipse.swt.awt.SWT_AWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.IWorkbenchActionConstants;
import org.eclipse.ui.PlatformUI;

import devcpu.Activator;
import devcpu.MappedView;
import devcpu.emulation.DCPUHardware;
import devcpu.emulation.SPED3Viewer;
import devcpu.emulation.VirtualVectorDisplay;

public class SPED3View extends MappedView<VirtualVectorDisplay> {

	public static final String ID = "devcpu.views.SPED3View";
	public static SPED3View view;
	
	private Action detachAction;
	private boolean kill;

	public SPED3View() {
		if (view == null) {
			view = this;
		} else {
			view.setFocus();
			kill = true;
		}
	}

	SPED3Viewer s3v = new SPED3Viewer();
	private Frame frame;
	
	public void createPartControl(Composite parent) {
		if (kill) {
			parent.getDisplay().asyncExec(new Runnable(){public void run(){
				getSite().getPage().hideView(SPED3View.this);
				}});
			return;
		}
		this.setPartName("SPED-3 - Not Connected");
		Composite composite = new Composite(parent, SWT.EMBEDDED);
		frame = SWT_AWT.new_Frame(composite);
		frame.add(s3v.canvas);
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
				SPED3View.this.fillContextMenu(manager);
			}
		});
	}

	private void contributeToActionBars() {
		IActionBars bars = getViewSite().getActionBars();
		fillLocalPullDown(bars.getMenuManager());
		fillLocalToolBar(bars.getToolBarManager());
	}

	private void fillLocalPullDown(IMenuManager manager) {
		final MenuManager attachSubmenu = new MenuManager("Attach SPED-3");
		attachSubmenu.add(new Action(){});
		attachSubmenu.addMenuListener(new IMenuListener() {
			@Override
			public void menuAboutToShow(IMenuManager manager) {
				attachSubmenu.removeAll();
				for (DCPUHardware h : Activator.getDefault().getShip().getHardwareManager().getDevices(VirtualVectorDisplay.class)) {
					final VirtualVectorDisplay vvd = ((VirtualVectorDisplay)h);
					attachSubmenu.add(new Action(vvd.getID()) {
						public void run() {
							synchronized (s3v) {
								map(vvd);
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
		manager.add(new Separator(IWorkbenchActionConstants.MB_ADDITIONS));
	}
	
	private void fillLocalToolBar(IToolBarManager manager) {
//		final MenuManager attachSubmenu = new MenuManager("Attach SPED-3");
//		attachSubmenu.addMenuListener(new IMenuListener() {
//			@Override
//			public void menuAboutToShow(IMenuManager manager) {
//				attachSubmenu.removeAll();
//				System.out.println("safads");
//				for (DCPUHardware h : Activator.getDefault().getShip().getDeviceManager().getDevices(VirtualVectorDisplay.class)) {
//					final VirtualVectorDisplay vvd = ((VirtualVectorDisplay)h);
//					attachSubmenu.add(new Action(vvd.getID()) {
//						public void run() {
//							synchronized (s3v) {
//								map(vvd);
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
				synchronized (s3v) {
					mapTo(null);
				}
			}
		};
		detachAction.setText("Detach Viewer");
		detachAction.setToolTipText("Detach the viewer from the SPED-3");
		detachAction.setImageDescriptor(PlatformUI.getWorkbench().getSharedImages().
			getImageDescriptor(ISharedImages.IMG_OBJS_INFO_TSK));
	}

	@Override
	public void dispose() {
		super.dispose();
		if (view == this) {
			view = null;
		}
	}

	@Override
	public boolean mapTo(VirtualVectorDisplay o) {
		if (s3v.vvd != null) {
			unmap(s3v.vvd);
		}
		if (o == null) {
			s3v.vvd = null;
			setPartName("SPED-3 - Not Connected");
		} else {
			s3v.vvd = o;
			setPartName(o.getID());
		}
		return true;
	}

	@Override
	public VirtualVectorDisplay getMappedObject() {
		return s3v.vvd;
	}
}