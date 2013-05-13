package devcpu.emulation;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;

import devcpu.FocusManager;

public class KeyboardViewer {
	protected static final Font font = new Font("Arial", Font.BOLD, 24);
	protected static final Color BACKGROUND_COLOR = new Color(255, 255, 255);
	protected static final Color FOREGROUND_COLOR = new Color(0, 0, 0);
	
	public Canvas canvas = new Canvas();
	public VirtualKeyboard vk;
	protected boolean keepAlive = true;
	private boolean focus;
	
	public KeyboardViewer() {
		canvas.setMinimumSize(new Dimension(1, 1));
		canvas.setFocusable(true);
		canvas.addFocusListener(new FocusListener() {
			@Override
			public void focusLost(FocusEvent e) {
				focus = false;
				FocusManager.get().lostFocus(KeyboardViewer.this);
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				focus = true;
				FocusManager.get().gainedFocus(KeyboardViewer.this);
			}
		});
		Thread t = new Thread() {
			public void run() {
				try {
					canvas.requestFocus();
					while (keepAlive) {
						if (canvas.isDisplayable()) {
							if (canvas.getWidth() > 0 && canvas.getHeight() > 0) {
								BufferedImage img = new BufferedImage(canvas.getWidth(), canvas.getHeight(), 2);
								Graphics2D g2 = (Graphics2D) img.getGraphics();
								String draw = focus ? "ACTIVE" : "Inactive";
								g2.setFont(font);
								g2.setBackground(BACKGROUND_COLOR);
								g2.setColor(FOREGROUND_COLOR);
								Rectangle2D bounds = g2.getFontMetrics().getStringBounds(draw, g2);
								g2.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
								g2.drawString(draw, (int) (canvas.getWidth() / 2d - bounds.getCenterX()), (int) (canvas.getHeight() / 2d - bounds.getCenterY()));
								g2.dispose();
								Graphics2D g = (Graphics2D) canvas.getGraphics();
								if (g != null) {
									g.drawImage(img, 0, 0, img.getWidth(), img.getHeight(), null);
									g.dispose();
								}
							}
						}
						Thread.sleep(16L);
					}
				} catch (Exception e) {
					e.printStackTrace();
					try {
						Thread.sleep(16L);
					} catch (InterruptedException e1) {
						e1.printStackTrace();
					}
				}
			}
		};
		t.start();
	}
	
	public VirtualKeyboard attach(VirtualKeyboard vk) {
		if (this.vk != null) {
			detach();
		}
		this.vk = vk;
		return vk;
	}

	public VirtualKeyboard detach() {
		if (vk != null) {
			VirtualKeyboard vk = this.vk;
			this.vk = null;
			return vk;
		}
		return null;
	}
	
	public void die() {
		keepAlive = false;
	}

	public void setFocused(boolean focused) {
		this.focus = focused;
	}
}
