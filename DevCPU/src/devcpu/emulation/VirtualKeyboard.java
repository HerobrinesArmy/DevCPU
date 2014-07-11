package devcpu.emulation;

import devcpu.managers.HardwareManager;

public class VirtualKeyboard extends DCPUHardware
{
  public static final int KEY_BACKSPACE = 16;
  public static final int KEY_RETURN = 17;
  public static final int KEY_INSERT = 18;
  public static final int KEY_DELETE = 19;
  public static final int KEY_UP = 128;
  public static final int KEY_DOWN = 129;
  public static final int KEY_LEFT = 130;
  public static final int KEY_RIGHT = 131;
  public static final int KEY_SHIFT = 144;
  public static final int KEY_CONTROL = 145;
  private KeyMapping keyMapping;
  private char[] keyBuffer = new char[64];
  private int krp;
  private int kwp;
  private boolean[] isDown = new boolean[256];
  private char interruptMessage;
  private boolean doInterrupt;
  private boolean powered;
  
  public VirtualKeyboard(String id, HardwareManager manager, KeyMapping keyMapping)
  {
    super(0x30cf7406, 0x1337, 0x1EB37E91);
    this.keyMapping = keyMapping;
    this.id = id;
    this.manager = manager;
  }

	public VirtualKeyboard(KeyMapping keyMapping) {
		this("Generic Keyboard", null, keyMapping);
	}
	
	public VirtualKeyboard() {
		this(new AWTKeyMapping(true)); //TODO support options
	}
	
	public boolean isPowered() {
		return powered;
	}

	public void keyTyped(int i) {
//		System.out.println("Type " + i);
		if (powered) {
	    if (i < 20 || i >= 127) return;
	    if (keyBuffer[kwp & 0x3F] == 0) {
	      keyBuffer[kwp++ & 0x3F] = (char)i;
	      doInterrupt = true;
	    }
		}
  }

  public void keyPressed(int key) {
//  	System.out.println("Press " + key);
  	if (powered) {
	    int i = keyMapping.getKey(key);
	    if (i < 0) return;
	    if ((i < 20 || i >= 127) && keyBuffer[kwp & 0x3F] == 0) {
	      keyBuffer[kwp++ & 0x3F] = (char)i;
	    }
	    isDown[i] = true;
	    doInterrupt = true;
  	}
  }

  public void keyReleased(int key) {
//  	System.out.println("Release " + key);
  	if (powered) {
	    int i = keyMapping.getKey(key);
	    if (i < 0) return;
	    isDown[i] = false;
	    doInterrupt = true;
  	}
  }

  public void interrupt() {
    int a = dcpu.registers[0];
    if (a == 0) {
      for (int i = 0; i < keyBuffer.length; i++) {
        keyBuffer[i] = 0;
      }
      krp = 0;
      kwp = 0;
    } else if (a == 1) {
      if ((dcpu.registers[2] = keyBuffer[(krp & 0x3F)]) != 0) {
        keyBuffer[(krp++ & 0x3F)] = 0;
      }
    }
    else if (a == 2) {
      int key = dcpu.registers[1];
      if ((key >= 0) && (key < 256))
        dcpu.registers[2] = (char)(isDown[key] ? 1 : 0);
      else
        dcpu.registers[2] = 0;
    }
    else if (a == 3) {
      interruptMessage = dcpu.registers[1];
    }
  }

  public void tick60hz() {
    if (doInterrupt) {
      if (interruptMessage != 0) dcpu.interrupt(interruptMessage);
      doInterrupt = false;
    }
  }
  
	@Override
	public void powerOff() {
		this.powered = false;
		this.keyBuffer = new char[64];
	  this.krp = 0;
	  this.kwp = 0;
	  this.isDown = new boolean[256];
	  this.interruptMessage = 0;
	  this.doInterrupt = false;
	}
	
	@Override
	public void powerOn() {
		this.powered = true;
	}
}
