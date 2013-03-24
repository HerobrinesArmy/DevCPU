package devcpu.views;

import java.awt.Font;
import java.awt.Frame;
import java.awt.GridBagLayout;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JLabel;

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
import org.eclipse.ui.IWorkbenchActionConstants;

import devcpu.Activator;
import devcpu.MappedView;
import devcpu.emulation.DCPUHardware;
import devcpu.emulation.VirtualKeyboard;

public class KeyboardView extends MappedView<VirtualKeyboard> {

	public static final String ID = "devcpu.views.KeyboardView";
	
	private Action detachAction;

	VirtualKeyboard vk;
	private Frame frame;

	private JLabel label;
	
	public void createPartControl(Composite parent) {
		setPartName("Keyboard - Not Connected");
		Composite composite = new Composite(parent, SWT.EMBEDDED);
		frame = SWT_AWT.new_Frame(composite);
		frame.addFocusListener(new FocusListener() {
			@Override
			public void focusLost(FocusEvent arg0) {
				label.setText("Inactive");
			}
			
			@Override
			public void focusGained(FocusEvent arg0) {
				label.setText("ACTIVE");
			}
		});
		frame.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (vk != null) {
					vk.keyTyped(e.getKeyChar());
				}
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				if (vk != null) {
					vk.keyReleased(e.getKeyCode());
				}				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				if (vk != null) {
					vk.keyPressed(e.getKeyCode());
				}
			}
		});
		label = new JLabel("Inactive");
		label.setAlignmentX(JLabel.CENTER_ALIGNMENT);
		label.setAlignmentY(JLabel.CENTER_ALIGNMENT);
		label.setFont(new Font("Arial", Font.BOLD, 24));
		frame.setLayout(new GridBagLayout());
		frame.add(label);
		
		makeActions();
		hookContextMenu();
//		hookDoubleClickAction();
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
		fillLocalToolBar(bars.getToolBarManager());
	}

	private void fillLocalPullDown(IMenuManager manager) {
		final MenuManager attachSubmenu = new MenuManager("Attach Generic Keyboard");
		attachSubmenu.add(new Action(){});
		attachSubmenu.addMenuListener(new IMenuListener() {
			@Override
			public void menuAboutToShow(IMenuManager manager) {
				attachSubmenu.removeAll();
				for (DCPUHardware h : Activator.getShip().getHardwareManager().getDevices(VirtualKeyboard.class)) {
					final VirtualKeyboard vm = ((VirtualKeyboard)h);
					attachSubmenu.add(new Action(vm.getID()) {
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
	
	private void fillLocalToolBar(IToolBarManager manager) {
//		final MenuManager attachSubmenu = new MenuManager("Attach Generic Keyboard");
//		attachSubmenu.addMenuListener(new IMenuListener() {
//			@Override
//			public void menuAboutToShow(IMenuManager manager) {
//				attachSubmenu.removeAll();
//				for (DCPUHardware h : Activator.getDefault().getShip().getDeviceManager().getDevices(VirtualKeyboard.class)) {
//					final VirtualKeyboard vm = ((VirtualKeyboard)h);
//					attachSubmenu.add(new Action(vm.getID()) {
//						public void run() {
//							map(vm);
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
				mapTo(null);
			}
		};
		detachAction.setText("Detach Viewer");
		detachAction.setToolTipText("Detach the viewer from the Generic Keyboard");
	}

	@Override
	public boolean mapTo(VirtualKeyboard o) {
		if (vk != null) {
			unmap(vk);
		}
		vk = o;
		if (o == null) {
			setPartName("Keyboard - Not Connected");
		} else {
			setPartName(o.getID());
		}
		return true;
	}

	@Override
	public VirtualKeyboard getMappedObject() {
		return vk;
	}
}