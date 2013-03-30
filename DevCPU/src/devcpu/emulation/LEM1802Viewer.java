package devcpu.emulation;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

public class LEM1802Viewer {
	public Canvas canvas = new Canvas();
	public VirtualMonitor vm;
  BufferedImage img2 = new BufferedImage(144, 112, 2);
  BufferedImage img = new BufferedImage(128, 112, 2);
	int[] pixels = ((DataBufferInt)img.getRaster().getDataBuffer()).getData();
	protected boolean keepAlive = true;
	
	public LEM1802Viewer() {
		canvas.setPreferredSize(new Dimension(144,112));
		canvas.setMinimumSize(new Dimension(144,112));
		canvas.setMaximumSize(new Dimension(144,112));
		canvas.setFocusable(true);
		Thread t = new Thread() {
      public void run() {
        try {
          canvas.requestFocus();
          while (keepAlive) {
          	if (canvas.isDisplayable()) {
          		if (vm != null) {
          			vm.setPixels(pixels);
		            vm.render();
		            Graphics2D g = (Graphics2D) img2.getGraphics();
		            if (g != null) {
		            	g.setColor(new Color(pixels[0x3000]));
		            	g.fillRect(0, 0, 144, 112);
		            	g.drawImage(img, 8, 8, 128, 112, null);
		            	g.dispose();
		            }
		            g = (Graphics2D) canvas.getGraphics();
		            if (g != null) {
		            	float scale;
		            	if ((float)canvas.getWidth() / (float)canvas.getHeight() > 144f/112f) {
		            		scale = (float)canvas.getHeight() / 112f;
		            	} else {
		            		scale = (float)canvas.getWidth() / 144f;
		            	}
		            	g.drawImage(img2, 0, 0, (int)(144 * scale), (int)(112 * scale), null);		            	
		            	g.dispose();
		            }
          		}
          	}
            Thread.sleep(1L);
          }
        } catch (Exception e) {
          e.printStackTrace();
          try {
						Thread.sleep(1L);
					} catch (InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
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
