package devcpu.views;

import java.awt.Frame;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IMenuListener;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.awt.SWT_AWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.IPartListener;
import org.eclipse.ui.IWorkbenchActionConstants;
import org.eclipse.ui.IWorkbenchPart;

import devcpu.Activator;
import devcpu.emulation.DCPUHardware;
import devcpu.emulation.KeyboardViewer;
import devcpu.emulation.VirtualKeyboard;
import devcpu.util.Util;

public class KeyboardView extends MappedView<VirtualKeyboard> {
	public static final String ID = "devcpu.views.KeyboardView";

	private Action detachAction;

	private KeyboardViewer kv = new KeyboardViewer();
	private Frame frame;

	public void createPartControl(Composite parent) {
		setPartName("Keyboard - Not Connected");
		Composite composite = new Composite(parent, SWT.EMBEDDED);
		this.getSite().getPage().addPartListener(new IPartListener() {
			@Override public void partOpened(IWorkbenchPart part){}
			@Override public void partClosed(IWorkbenchPart part){}
			@Override public void partBroughtToTop(IWorkbenchPart part){}

			@Override
			public void partDeactivated(IWorkbenchPart part) {
				if (part == KeyboardView.this) {
					kv.setFocused(false);
				}
			}

			@Override
			public void partActivated(IWorkbenchPart part) {
				if (part == KeyboardView.this) {
					kv.setFocused(true);
				}
			}
		});
		frame = SWT_AWT.new_Frame(composite);
		frame.add(kv.canvas);
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
				KeyboardView.this.fillContextMenu(manager);
			}
		});
	}

	private void contributeToActionBars() {
		IActionBars bars = getViewSite().getActionBars();
		fillLocalPullDown(bars.getMenuManager());
	}

	private void fillLocalPullDown(IMenuManager manager) {
		final MenuManager attachSubmenu = new MenuManager(
				"Attach Generic Keyboard",
				Util.getImageDescriptor("icons/keyboard.png"), null);
		attachSubmenu.add(new Action() {
		});
		attachSubmenu.addMenuListener(new IMenuListener() {
			@Override
			public void menuAboutToShow(IMenuManager manager) {
				attachSubmenu.removeAll();
				for (DCPUHardware h : Activator.getShip().getHardwareManager()
						.getDevices(VirtualKeyboard.class)) {
					final VirtualKeyboard vm = ((VirtualKeyboard) h);
					attachSubmenu.add(new Action(vm.getID()) {
						@Override
						public ImageDescriptor getImageDescriptor() {
							return Util.getImageDescriptor("icons/keyboard.png");
						}

						public void run() {
							map(vm);
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

	private void makeActions() {
		detachAction = new Action() {
			public void run() {
				mapTo(null);
			}
		};
		detachAction.setText("Detach Viewer");
		detachAction.setToolTipText("Detach the viewer from the Generic Keyboard");
	}

	@Override
	public boolean mapTo(VirtualKeyboard o) {
		if (kv.vk != null) {
			unmap(kv.vk);
		}
		kv.vk = o;
		if (o == null) {
			setPartName("Keyboard - Not Connected");
		} else {
			setPartName(o.getID());
		}
		return true;
	}

	@Override
	public VirtualKeyboard getMappedObject() {
		return kv.vk;
	}
}