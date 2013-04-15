package devcpu;

import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import java.awt.event.KeyEvent;

import devcpu.emulation.KeyboardViewer;

public class FocusManager implements KeyEventDispatcher {
	private static FocusManager manager;
	private KeyboardViewer focus;
	
	public static FocusManager get() {
		if (manager == null) {
			manager = new FocusManager();
		}
		return manager;
	}
	public void lostFocus(KeyboardViewer viewer) {
		if (focus == viewer) {
			focus = null;
		}
	}

	public void gainedFocus(KeyboardViewer viewer) {
		focus = viewer;
	}
	
	public FocusManager() {
		KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(this);
	}

	@Override
	public boolean dispatchKeyEvent(KeyEvent e) {
		if (focus != null && focus.vk != null) {
			if (e.getID() == KeyEvent.KEY_PRESSED) {
				focus.vk.keyPressed(e.getKeyCode());
			} else if (e.getID() == KeyEvent.KEY_RELEASED) {
				focus.vk.keyReleased(e.getKeyCode());
			} else if (e.getID() == KeyEvent.KEY_TYPED) {
				focus.vk.keyTyped(e.getKeyChar());
			}
		}
		return true;
	}
}
