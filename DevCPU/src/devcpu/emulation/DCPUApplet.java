package devcpu.emulation;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.net.URL;

import devcpu.assembler.OldAssembler;

public class DCPUApplet extends Applet
  implements Runnable
{
	private static final long serialVersionUID = 1L;
	private VirtualMonitor display;
  private VirtualKeyboard keyboard;
  private boolean stop = false;

  public void start() {
    this.stop = false;
    Thread t = new Thread(this);
    t.start();
  }

  public void stop()
  {
    this.stop = true;
  }

  public void run() {
    DCPU cpu = new DCPU();
    this.display = ((VirtualMonitor)new VirtualMonitor().connectTo(cpu));
    this.keyboard = ((VirtualKeyboard)new VirtualKeyboard(new AWTKeyMapping()).connectTo(cpu));
    new VirtualClock().connectTo(cpu);
    new VirtualFloppyDrive().connectTo(cpu);
    new VirtualSleepChamber().connectTo(cpu);
    new VirtualVectorDisplay().connectTo(cpu);
    try {
    	new OldAssembler(cpu.ram).assemble(new URL(getParameter("source")));//getParameter("source"));
//      DCPU.load(cpu.ram);
    } catch (Exception e1) {
      e1.printStackTrace();
    }

    int SCALE = 3;
    try
    {
      setFocusable(true);
      addKeyListener(new KeyListener() {
        public void keyPressed(KeyEvent ke) {
          DCPUApplet.this.keyboard.keyPressed(ke.getKeyCode());
        }

        public void keyReleased(KeyEvent ke) {
          DCPUApplet.this.keyboard.keyReleased(ke.getKeyCode());
        }

        public void keyTyped(KeyEvent ke) {
          DCPUApplet.this.keyboard.keyTyped(ke.getKeyChar());
        }
      });
      BufferedImage img2 = new BufferedImage(160, 128, 2);
      BufferedImage img = new BufferedImage(128, 128, 2);
      int[] pixels = ((DataBufferInt)img.getRaster().getDataBuffer()).getData();
      this.display.setPixels(pixels);

      requestFocus();

      int khz = 100;

      long ops = 0L;
      int hz = khz * 1000;
      int cyclesPerFrame = hz / 60;

      long nsPerFrame = 16666666L;
      long nextTime = System.nanoTime();

      double tick = 0.0D;
      double total = 0.0D;

      long time = System.currentTimeMillis();
      while (!this.stop) {
        long a = System.nanoTime();
        while (System.nanoTime() < nextTime) {
          try {
            Thread.sleep(1L);
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
        }
        long b = System.nanoTime();
        while (cpu.cycles < cyclesPerFrame) {
          cpu.tick();
        }

        cpu.tickHardware();
        this.display.render();

        Graphics g = img2.getGraphics();
        g.setColor(new Color(pixels[12288]));
        g.fillRect(0, 0, 160, 128);
        g.drawImage(img, 16, 16, 128, 128, null);
        g.dispose();

        g = getGraphics();
        if (g != null) {
          g.drawImage(img2, 0, 0, 160 * SCALE, 128 * SCALE, null);
          g.dispose();
        }

        cpu.cycles -= cyclesPerFrame;
        long c = System.nanoTime();
        ops += cyclesPerFrame;
        nextTime += nsPerFrame;

        tick += (c - b) / 1000000000.0D;
        total += (c - a) / 1000000000.0D;

        while (System.currentTimeMillis() > time) {
          time += 1000L;
          System.out.println("1 DCPU at " + ops / 1000.0D + " khz, " + tick * 100.0D / total + "% cpu use");
          tick = total = ops = 0L;
        }
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}