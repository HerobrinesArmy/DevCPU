package devcpu.emulation;

import java.io.IOException;

import javax.imageio.ImageIO;

import devcpu.HardwareManager;

public class VirtualMonitor extends DCPUHardware
{
  public static final int WIDTH_CHARS = 32;
  public static final int HEIGHT_CHARS = 12;
  public static final int WIDTH_PIXELS = 128;
  public static final int HEIGHT_PIXELS = 96;
  private static final int START_DURATION = 60;
  private int lightColor;
  private int[] palette = new int[16];
  private char[] font = new char[256];
  public int[] pixels = new int[16384];
  private int screenMemMap;
  private int fontMemMap;
  private int paletteMemMap;
  private int[] loadImage = new int[12288];

  private int borderColor = 0;
  private int startDelay = 0;
  
  private String id = "LEM1802";
	private HardwareManager manager;

  public VirtualMonitor(String id, HardwareManager manager) {
    super(0x7349f615, 0x1802, 0x1c6c8b36);
    this.manager = manager;
    this.id = id;
    resetPalette();
    resetFont();
    
    try {
			ImageIO.read(VirtualMonitor.class.getResource("/dcpu/hardware/lem/boot.png")).getRGB(0, 0, 128, 96, loadImage, 0, 128);
		} catch (IOException e) {
			e.printStackTrace();
		}
  }

  private void resetFont() {
  	int[] pixels = new int[4096];
    try {
      ImageIO.read(VirtualMonitor.class.getResource("/dcpu/hardware/lem/font.png")).getRGB(0, 0, 128, 32, pixels, 0, 128);
    } catch (IOException e) {
      e.printStackTrace();
    }

    for (int c = 0; c < 128; c++) {
      int ro = c * 2;
      int xo = c % 32 * 4;
      int yo = c / 32 * 8;
      for (int xx = 0; xx < 4; xx++) {
        int bb = 0;
        for (int yy = 0; yy < 8; yy++)
          if ((pixels[(xo + xx + (yo + yy) * 128)] & 0xFF) > 128)
            bb |= 1 << yy;
        font[ro + xx / 2] = (char)(font[ro + xx / 2] | bb << (xx + 1 & 0x1) * 8);
      }
    }
	}

	public VirtualMonitor() {
  	this("LEM1802", null);
	}

	private void resetPalette() {
    for (int i = 0; i < 16; i++) {
      int b = (i >> 0 & 0x1) * 170;
      int g = (i >> 1 & 0x1) * 170;
      int r = (i >> 2 & 0x1) * 170;
      if (i == 6) {
        g -= 85;
      } else if (i >= 8) {
        r += 85;
        g += 85;
        b += 85;
      }
      palette[i] = (0xFF000000 | r << 16 | g << 8 | b);
    }
  }

  private void loadPalette(char[] ram, int offset) {
    for (int i = 0; i < 16; i++) {
      char ch = ram[(offset + i)];
      int b = (ch >> '\000' & 0xF) * 17;
      int g = (ch >> '\004' & 0xF) * 17;
      int r = (ch >> '\b' & 0xF) * 17;
      palette[i] = (0xFF000000 | r << 16 | g << 8 | b);
    }
  }

  public void interrupt() {
    int a = dcpu.registers[0];
    if (a == 0) {
      if ((screenMemMap == 0) && (dcpu.registers[1] != 0)) {
        startDelay = 60;
      }
      screenMemMap = dcpu.registers[1];
    } else if (a == 1) {
      fontMemMap = dcpu.registers[1];
    } else if (a == 2) {
      paletteMemMap = dcpu.registers[1];
    } else if (a == 3) {
      borderColor = (dcpu.registers[1] & 0xF);
    } else if (a == 4) {
      int offs = dcpu.registers[1];
      for (int i = 0; i < font.length; i++) {
        dcpu.ram[(offs + i & 0xFFFF)] = font[i];
      }
      dcpu.cycles += 256;
    } else if (a == 5) {
      int offs = dcpu.registers[1];
      for (int i = 0; i < 16; i++) {
        int b = (i >> 0 & 0x1) * 10;
        int g = (i >> 1 & 0x1) * 10;
        int r = (i >> 2 & 0x1) * 10;
        if (i == 6) {
          g -= 5;
        } else if (i >= 8) {
          r += 5;
          g += 5;
          b += 5;
        }
        dcpu.ram[(offs + i & 0xFFFF)] = (char)(r << 8 | g << 4 | b);
      }
      dcpu.cycles += 16;
    }
  }

  public void render() {
  	synchronized (this) {
  		if (pixels != null) {
		    if ((screenMemMap == 0) || (startDelay > 0)) {
		      int reds = 0;
		      int greens = 0;
		      int blues = 0;
		
		      if ((startDelay > 0) && (startDelay < 10)) {
		        for (int y = 0; y < 96; y++)
		          for (int x = 0; x < 128; x++) {
		            int col = palette[0];
		            pixels[(x + y * 128)] = col;
		            reds += (col & 0xFF0000);
		            greens += (col & 0xFF00);
		            blues += (col & 0xFF);
		          }
		      }
		      else {
		        for (int y = 0; y < 96; y++) {
		          for (int x = 0; x < 128; x++) {
		            int cc = loadImage[(x + y * 128)] & 0xFF;
		            int col = palette[1];
		            pixels[(x + y * 128)] = col;
		            reds += (col & 0xFF0000);
		            greens += (col & 0xFF00);
		            blues += (col & 0xFF);
		          }
		        }
		      }
		
		      int bgColor = 1;
		      if (startDelay < 26) {
		        bgColor = startDelay - 10;
		      }
		      if (bgColor < 0) bgColor = 0;
		      int color = palette[bgColor];
		      for (int y = 96; y < 128; y++) {
		        for (int x = 0; x < 128; x++) {
		          pixels[(x + y * 128)] = color;
		        }
		      }
		
		      int borderPixels = 100;
		      reds += (color & 0xFF0000) * borderPixels;
		      greens += (color & 0xFF00) * borderPixels;
		      blues += (color & 0xFF) * borderPixels;
		
		      reds = reds / (0x3000 + borderPixels) & 0xFF0000;
		      greens = greens / (0x3000 + borderPixels) & 0xFF00;
		      blues = blues / (0x3000 + borderPixels) & 0xFF;
		      lightColor = (reds | greens | blues);
		    } else {
		      long time = System.currentTimeMillis() / 16L;
		      boolean blink = time / 20L % 2L == 0L;
		      long reds = 0L;
		      long greens = 0L;
		      long blues = 0L;
		
		      char[] fontRam = font;
		      int charOffset = 0;
		      if (fontMemMap > 0) {
		        fontRam = dcpu.ram;
		        charOffset = fontMemMap;
		      }
		      if (paletteMemMap == 0)
		        resetPalette();
		      else {
		        loadPalette(dcpu.ram, paletteMemMap);
		      }
		
		      for (int y = 0; y < 12; y++) {
		        for (int x = 0; x < 32; x++) {
		          char dat = dcpu.ram[(screenMemMap + x + y * 32)];
		          int ch = dat & 0x7F;
		          int colorIndex = dat >> '\b' & 0xFF;
		          int co = charOffset + ch * 2;
		
		          int color = palette[(colorIndex & 0xF)];
		          int colorAdd = palette[(colorIndex >> 4 & 0xF)] - color;
		          if ((blink) && ((dat & 0x80) > 0)) colorAdd = 0;
		          int pixelOffs = x * 4 + y * 8 * 128;
		
		          for (int xx = 0; xx < 4; xx++) {
		            int bits = fontRam[(co + (xx >> 1))] >> (xx + 1 & 0x1) * 8 & 0xFF;
		            for (int yy = 0; yy < 8; yy++) {
		              int col = color + colorAdd * (bits >> yy & 0x1);
		              pixels[(pixelOffs + xx + yy * 128)] = col;
		              reds += (col & 0xFF0000);
		              greens += (col & 0xFF00);
		              blues += (col & 0xFF);
		            }
		          }
		        }
		      }
		
		      int color = palette[borderColor];
		      for (int y = 96; y < 128; y++) {
		        for (int x = 0; x < 128; x++) {
		          pixels[(x + y * 128)] = color;
		        }
		      }
		
		      int borderPixels = 100;
		      reds += (color & 0xFF0000) * borderPixels;
		      greens += (color & 0xFF00) * borderPixels;
		      blues += (color & 0xFF) * borderPixels;
		
		      reds = reds / (0x3000 + borderPixels) & 0xFF0000;
		      greens = greens / (0x3000 + borderPixels) & 0xFF00;
		      blues = blues / (0x3000 + borderPixels) & 0xFF;
		      lightColor = (int)(reds | greens | blues);
		    }
  		}
  	}
  }

  public void tick60hz() {
    if (startDelay > 0) startDelay -= 1; 
  }

  public void setPixels(int[] pixels)
  {
  	synchronized (this) {
  		this.pixels = pixels;
  	}
  }

  public int getLightColor() {
    return lightColor;
  }
  
	public String getID() {
		return id ;
	}
	
	public void setID(String id) {
		this.id = id;
	}

	public HardwareManager getManager() {
		return manager;
	}
	
	@Override
	public void powerOff() {
    resetPalette();
    resetFont();
    lightColor = 0;
    screenMemMap = 0;
    fontMemMap = 0;
    paletteMemMap = 0;
    borderColor = 0;
    startDelay = 0;   
	}
}