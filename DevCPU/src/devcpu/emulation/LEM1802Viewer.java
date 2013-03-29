package devcpu.emulation;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

public class LEM1802Viewer {
//	private static final int SCALE = 3;
	
	public Canvas canvas = new Canvas();
	public VirtualMonitor vm;
  BufferedImage img2 = new BufferedImage(160, 128, 2);
  BufferedImage img = new BufferedImage(128, 128, 2);
	int[] pixels = ((DataBufferInt)img.getRaster().getDataBuffer()).getData();
	protected boolean keepAlive = true;
	
	public LEM1802Viewer() {
		canvas.setPreferredSize(new Dimension(160,128));// * SCALE, 128 * SCALE));
		canvas.setMinimumSize(new Dimension(160,128));// * SCALE, 128 * SCALE));
		canvas.setMaximumSize(new Dimension(160,128));// * SCALE, 128 * SCALE));
		canvas.setFocusable(true);
//		canvas.addComponentListener(new ComponentListener() {
//			@Override public void componentShown(ComponentEvent arg0) {}
//			@Override public void componentResized(ComponentEvent arg0) {
//				synchronized (LEM1802Viewer.this) {
////					img
//				}
//			}
//			@Override public void componentMoved(ComponentEvent arg0) {}
//			@Override public void componentHidden(ComponentEvent arg0) {}
//		});
		Thread t = new Thread() {
      public void run() {
        try {
          canvas.requestFocus();
          while (keepAlive) {
          	if (canvas.isDisplayable()) {
          		if (vm != null) {
//          			System.out.println("render");
          			vm.setPixels(pixels);
		            vm.render();
		            Graphics2D g = (Graphics2D) img2.getGraphics();
		            if (g != null) {
		            	g.setColor(new Color(pixels[0x3000]));
		            	g.fillRect(0, 0, 160, 128);
		            	g.drawImage(img, 16, 16, 128, 128, null);
		            	g.dispose();
		            }
//		            System.out.println(pixels[0x3000]);
		            g = (Graphics2D) canvas.getGraphics();
		            if (g != null) {
		            	float scale;
		            	if ((float)canvas.getWidth() / (float)canvas.getHeight() > 160f/128f) {
		            		scale = (float)canvas.getHeight() / 128f;
		            	} else {
		            		scale = (float)canvas.getWidth() / 160f;
		            	}
//		            	System.out.println(scale);
		            	g.drawImage(img2, 0, 0, (int)(160 * scale), (int)(128 * scale), null);		            	
		            	g.dispose();
		            }
          		}
          	}
            Thread.sleep(1L);
          }
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    };
    t.start();
	}
	
	public VirtualMonitor attach(VirtualMonitor vm) {
		if (this.vm != null) {
			detach();
		}
		this.vm = vm;
		return vm;
	}

	public VirtualMonitor detach() {
		if (vm != null) {
			VirtualMonitor vm = this.vm;
			vm.setPixels(null);
			this.vm = null;
			return vm;
		}
		return null;
	}
	
	public void die() {
		keepAlive = false;
	}
}
