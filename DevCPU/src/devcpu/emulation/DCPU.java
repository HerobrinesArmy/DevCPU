package devcpu.emulation;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Experimental 1.7 update to Notch's 1.4 emulator
 * @author Notch, Herobrine
 *
 */
public class DCPU
{
  private static final boolean DISASSEMBLE = false;
  public char[] ram = new char[65536];
  public char pc;
  public char sp;
  public char ex;
  public char ia;
  public char[] registers = new char[8];
  public int cycles;
  protected ArrayList<DCPUHardware> hardware = new ArrayList<DCPUHardware>();

  protected static volatile boolean stop = false;
  protected static final int khz = 100;
  boolean isSkipping = false;
  boolean isOnFire = false;
  boolean queueingEnabled = false; //TODO: Verify implementation
  char[] interrupts = new char[256];
  int ip;
  int iwp;
	public boolean disassemble = DISASSEMBLE;
//	public int[] opcounts = new int[64];

  public int getAddrB(int type)
  {
    switch (type & 0xF8) {
    case 0:
      return 65536 + (type & 0x7);
    case 8:
      return registers[type & 0x7];
    case 16:
      cycles += 1;
      return ram[pc++] + registers[type & 0x7] & 0xFFFF;
    case 24:
      switch (type & 0x7) {
      case 0:
        return (--sp) & 0xFFFF;
      case 1:
        return sp & 0xFFFF;
      case 2:
        cycles += 1;
        return ram[pc++] + sp & 0xFFFF;
      case 3:
        return 65544;
      case 4:
        return 65545;
      case 5:
        return 65552;
      case 6:
        cycles += 1;
        return ram[pc++];
      }
      cycles += 1;
      return 0x20000 | ram[pc++];
    }

    throw new IllegalStateException("Illegal a value type " + Integer.toHexString(type) + "! How did you manage that!?");
  }

  public String getStr(int type, boolean isA) {
    if (type >= 32) {
      return Integer.toHexString((type & 0x1F) + 65535 & 0xFFFF);
    }

    switch (type & 0xF8) {
    case 0:
      return ""+"ABCXYZIJ".charAt(type & 0x7);
    case 8:
      return "[" + "ABCXYZIJ".charAt(type & 0x7) + "]";
    case 16:
      return "[" + Integer.toHexString(ram[pc++]) + "+" + "ABCXYZIJ".charAt(type & 0x7) + "]";
    case 24:
      switch (type & 0x7) {
      case 0:
        return isA ? "POP" : "PUSH";
      case 1:
        return "PEEK";
      case 2:
        return "[" + Integer.toHexString(ram[pc++]) + "+SP]";
      case 3:
        return "SP";
      case 4:
        return "PC";
      case 5:
        return "EX";
      case 6:
        return "[" + Integer.toHexString(ram[pc++]) + "]";
      }
      return Integer.toHexString(ram[pc++]);
    }

    throw new IllegalStateException("Illegal value type " + Integer.toHexString(type) + "! How did you manage that!?");
  }

  public int getAddrA(int type) {
    if (type >= 32) {
      return 0x20000 | (type & 0x1F) + 65535 & 0xFFFF;
    }

    switch (type & 0xF8) {
    case 0:
      return 65536 + (type & 0x7);
    case 8:
      return registers[type & 0x7];
    case 16:
      cycles += 1;
      return ram[pc++] + registers[type & 0x7] & 0xFFFF;
    case 24:
      switch (type & 0x7) {
      case 0:
        return sp++ & 0xFFFF;
      case 1:
        return sp & 0xFFFF;
      case 2:
        cycles += 1;
        return ram[pc++] + sp & 0xFFFF;
      case 3:
        return 65544;
      case 4:
        return 65545;
      case 5:
        return 65552;
      case 6:
        cycles += 1;
        return ram[pc++];
      }
      cycles += 1;
      return 0x20000 | ram[pc++];
    }

    throw new IllegalStateException("Illegal a value type " + Integer.toHexString(type) + "! How did you manage that!?");
  }

  public char getValA(int type) {
    if (type >= 32) {
      return (char)((type & 0x1F) + 65535);
    }

    switch (type & 0xF8) {
    case 0:
      return registers[type & 0x7];
    case 8:
      return ram[registers[type & 0x7]];
    case 16:
      cycles += 1;
      return ram[ram[pc++] + registers[type & 0x7] & 0xFFFF];
    case 24:
      switch (type & 0x7) {
      case 0:
        return ram[sp++ & 0xFFFF];
      case 1:
        return ram[sp & 0xFFFF];
      case 2:
        cycles += 1;
        return ram[ram[pc++] + sp & 0xFFFF];
      case 3:
        return sp;
      case 4:
        return pc;
      case 5:
        return ex;
      case 6:
        cycles += 1;
        return ram[ram[pc++]];
      }
      cycles += 1;
      return ram[pc++];
    }

    throw new IllegalStateException("Illegal a value type " + Integer.toHexString(type) + "! How did you manage that!?");
  }

  public char get(int addr) {
    if (addr < 65536)
      return ram[addr & 0xFFFF];
    if (addr < 65544)
      return registers[addr & 0x7];
    if (addr >= 131072)
      return (char)addr;
    if (addr == 65544)
      return sp;
    if (addr == 65545)
      return pc;
    if (addr == 65552) {
      return ex;
    }
    throw new IllegalStateException("Illegal address " + Integer.toHexString(addr) + "! How did you manage that!?");
  }

  public void set(int addr, char val) {
    if (addr < 65536)
      ram[addr & 0xFFFF] = val;
    else if (addr < 65544) {
//    	if (disassemble)
//    	{
//    		System.out.println("register[" + (int)(addr & 0x7) + "] = " + (int)val);
//    	}
      registers[addr & 0x7] = val;
    } else if (addr < 131072) {
      if (addr == 65544)
        sp = val;
      else if (addr == 65545)
        pc = val;
      else if (addr == 65552)
        ex = val;
      else
        throw new IllegalStateException("Illegal address " + Integer.toHexString(addr) + "! How did you manage that!?"); 
    }
  }

  public static int getInstructionLength(char opcode) {
    int len = 1;
    int cmd = opcode & 0x1F;
    if (cmd == 0) {
      cmd = opcode >> 5 & 0x1F;
      if (cmd > 0) {
        int atype = opcode >> 10 & 0x3F;
        if (((atype & 0xF8) == 16) || (atype == 31) || (atype == 30)) len++; 
      }
    }
    else {
      int atype = opcode >> 5 & 0x1F;
      int btype = opcode >> 10 & 0x3F;
      if (((atype & 0xF8) == 16) || (atype == 31) || (atype == 30)) len++;
      if (((btype & 0xF8) == 16) || (btype == 31) || (btype == 30)) len++;
    }
    return len;
  }

  public void skip() {
    isSkipping = true;
  }

  public void tick() {
    cycles += 1;

    if (disassemble)
    {
    	System.out.println((pc < 0x1000 ? "0" : "") + (pc < 0x100 ? "0" : "") + Integer.toHexString(pc) + ": " + disassemble(ram, pc));
    }
    
    if (isOnFire) {
//      cycles += 10; //Disabled to match speed of crashing seen in livestreams
    	/* For Java 7+
    	int pos = ThreadLocalRandom.current().nextInt();
      char val = (char) (pos >> 16);//(char) ThreadLocalRandom.current().nextInt(65536);
      int len = (int)(1 / (ThreadLocalRandom.current().nextFloat() + 0.001f)) - 80;
      */
      int pos = (int)(Math.random() * 65536) & 0xFFFF;
      char val = (char) ((int)(Math.random() * 65536) & 0xFFFF);
      int len = (int)(1 / (Math.random() + 0.001f)) - 80;
      for (int i = 0; i < len; i++) {
        ram[(pos + i) & 0xFFFF] = val;
      }
    }

    if (isSkipping) {
      char opcode = ram[pc];
      int cmd = opcode & 0x1F;
      pc = (char)(pc + getInstructionLength(opcode));

      if ((cmd >= 16) && (cmd <= 23))
        isSkipping = true;
      else {
        isSkipping = false;
      }

      return;
    }

    if (!queueingEnabled) {
	    if (ip != iwp) {
	      char a = interrupts[ip = ip + 1 & 0xFF];
	      if (ia > 0) {
	      	queueingEnabled = true;
	        ram[--sp & 0xFFFF] = pc;
	        ram[--sp & 0xFFFF] = registers[0];
	        registers[0] = a;
	        pc = ia;
	      }	
	    }
    }

    char opcode = ram[pc++];

    int cmd = opcode & 0x1F;
    if (cmd == 0) {
      cmd = opcode >> 5 & 0x1F;
      if (cmd != 0)
      {
//      	opcounts[32+cmd]++;
        int atype = opcode >> 10 & 0x3F;
        int aaddr = getAddrA(atype);
        char a = get(aaddr);

        switch (cmd) {
        case 1: //JSR
          cycles += 2;
          ram[--sp & 0xFFFF] = pc;
          pc = a;
          break;
//        case 7: //HCF
//          cycles += 8;
//          isOnFire = true;
//          break;
        case 8: //INT
          cycles += 3;
          interrupt(a);
          break;
        case 9: //IAG
          set(aaddr, ia);
          break;
        case 10: //IAS
          ia = a;
          break;
        case 11: //RFI TODO: Verify implementation
        	cycles += 2;
        	//disables interrupt queueing, pops A from the stack, then pops PC from the stack
        	queueingEnabled = false;
        	registers[0] = ram[sp++ & 0xFFFF];
	        pc = ram[sp++ & 0xFFFF];
        	break;
        case 12: //IAQ TODO: Verify implementation
        	cycles += 1;
        	//if a is nonzero, interrupts will be added to the queue instead of triggered. if a is zero, interrupts will be triggered as normal again
        	if (a == 0) {
        		queueingEnabled = false;
        	} else {
        		queueingEnabled = true;
        	}
        	break;
        case 16: //HWN
          cycles += 1;
          set(aaddr, (char)hardware.size());
          break;
        case 17: //HWQ
          cycles += 3;
          synchronized (hardware) {
	          if ((a >= 0) && (a < hardware.size())) {
	          	((DCPUHardware)hardware.get(a)).query();
	          }
          }
          break;
        case 18: //HWI
          cycles += 3;
          synchronized (hardware) {
          	if ((a >= 0) && (a < hardware.size())) {
          		((DCPUHardware)hardware.get(a)).interrupt();
          	}
          }
          break;
        case 2:
        case 3:
        case 4:
        case 5:
        case 6:
        case 13:
        case 14:
        case 15:
        default:
          break;
        }
      }
    } else {
//    	opcounts[cmd]++;
      int atype = opcode >> 10 & 0x3F;

      char a = getValA(atype);

      int btype = opcode >> 5 & 0x1F;
      int baddr = getAddrB(btype);
      char b = get(baddr);

      switch (cmd) {
      case 1: //SET
        b = a;
        break;
      case 2:{ //ADD
        cycles += 1;
        int val = b + a;
        b = (char)val;
        ex = (char)(val >> 16);
        break;
      }case 3:{ //SUB
        cycles += 1;
        int val = b - a;
        b = (char)val;
        ex = (char)(val >> 16);
        break;
      }case 4:{ //MUL
        cycles += 1;
        int val = b * a;
        b = (char)val;
        ex = (char)(val >> 16);
        break;
      }case 5:{ //MLI
        cycles += 1;
        int val = (short)b * (short)a;
        b = (char)val;
        ex = (char)(val >> 16);
        break;
      }case 6:{ //DIV
        cycles += 2;
        if (a == 0) {
          b = ex = 0;
        } else {
          b /= a;
          ex = (char)((b << 16) / a);
        }
        break;
      }case 7:{ //DVI
        cycles += 2;
        if (a == 0) {
          b = ex = 0;
        } else {
          b = (char)((short)b / (short)a);
          ex = (char)(((short)b << 16) / (short)a);
        }
        break;
      }case 8: //MOD
        cycles += 2;
        if (a == 0)
          b = 0;
        else {
          b = (char)(b % a);
        }
        break;
      case 9: //MDI
      	cycles += 2;
        if (a == 0)
          b = 0;
        else {
          b = (char)((short)b % (short)a);
        }
      	break;
      case 10: //AND
        b = (char)(b & a);
        break;
      case 11: //BOR
        b = (char)(b | a);
        break;
      case 12: //XOR
        b = (char)(b ^ a);
        break;
      case 13: //SHR
        ex = (char)(b << 16 >> a);
        b = (char)(b >>> a);
        break;
      case 14: //ASR
        ex = (char)((short)b << 16 >>> a);
        b = (char)((short)b >> a);
        break;
      case 15: //SHL
        ex = (char)(b << a >> 16);
        b = (char)(b << a);
        break;
      case 16: //IFB
        cycles += 1;
        if ((b & a) == 0) skip();
        return;
      case 17: //IFC
        cycles += 1;
        if ((b & a) != 0) skip();
        return;
      case 18: //IFE
        cycles += 1;
        if (b != a) skip();
        return;
      case 19: //IFN
        cycles += 1;
        if (b == a) skip();
        return;
      case 20: //IFG
        cycles += 1;
        if (b <= a) skip();
        return;
      case 21: //IFA
        cycles += 1;
        if ((short)b <= (short)a) skip();
        return;
      case 22: //IFL
        cycles += 1;
        if (b >= a) skip();
        return;
      case 23: //IFU
        cycles += 1;
        if ((short)b >= (short)a) skip();
        return;
      case 26:{ //ADX
        cycles += 1;
        int val = b + a + ex;
        b = (char)val;
        ex = (char)(val >> 16);
        break;
      }case 27:{ //SBX
        cycles += 1;
        int val = b - a + ex;
        b = (char)val;
        ex = (char)(val >> 16);
        break;
      }case 30: //STI
        b = a;
        set(baddr, b);
        registers[6]++;
        registers[7]++;
        return;
      case 31: //STD
      	b = a;
      	set(baddr, b);
        registers[6]--;
        registers[7]--;
        return;
      case 24:
      case 25:
      }
      set(baddr, b);
    }
  }

  public void interrupt(char a)
  {
    interrupts[iwp = iwp + 1 & 0xFF] = a;
    if (iwp == ip) isOnFire = true;
  }

  private String disassemble(char[] ram, char pcc)
  {
    char opc = pc;
    try {
      pc = pcc;
      char opcode = ram[pc++];
      int cmd = opcode & 0x1F;
      String str;
      if (cmd == 0) {
        cmd = opcode >> 5 & 0x1F;
        if (cmd != 0)
        {
          int atype = opcode >> 10 & 0x3F;
          if (OpCodes.special.getNames().contains(cmd)) {
          	str = OpCodes.special.getName(cmd) + " " + getStr(atype, true);
          } else {
          	str = "???";
          }
          return str;
        }
      } else {
      	String atype = getStr(opcode >> 10 & 0x3F, true);
      	String btype = getStr(opcode >> 5 & 0x1F, false);
      	if (OpCodes.basic.getNames().contains(cmd)) {
      		str = OpCodes.basic.getName(cmd) + " " + btype + ", " + atype;
      	} else {
      		str = "???";
      	}
      	return str;
      }
      return "!?!?!?";
    } finally {
      pc = opc;
    }//throw localObject;
  }

  public void tickHardware() {
  	synchronized (hardware) {
  		for (int i = 0; i < hardware.size(); i++) {
  			((DCPUHardware)hardware.get(i)).tick60hz();
  		}
  	}
  }

  public void dumpRegisters()
  {
    System.out.print("A: " + Integer.toHexString(registers[0]) + ", ");
    System.out.print("B: " + Integer.toHexString(registers[1]) + ", ");
    System.out.println("C: " + Integer.toHexString(registers[2]));
    System.out.print("X: " + Integer.toHexString(registers[3]) + ", ");
    System.out.print("Y: " + Integer.toHexString(registers[4]) + ", ");
    System.out.println("Z: " + Integer.toHexString(registers[5]));
    System.out.print("I: " + Integer.toHexString(registers[6]) + ", ");
    System.out.println("J: " + Integer.toHexString(registers[7]));
    System.out.print("PC: " + Integer.toHexString(pc) + ", ");
    System.out.print("SP: " + Integer.toHexString(sp) + ", ");
    System.out.println("EX: " + Integer.toHexString(ex));
  }
  
  public static void load(char[] ram) throws Exception {
    DataInputStream dis = new DataInputStream(DCPU.class.getResourceAsStream("testdump.dmp"));
    try {
      for (int i = 0; ; i++)
        ram[i] = dis.readChar();
    }
    catch (IOException e) {
      dis.close();
    }
  }

  public static void dump(char[] ram, int start, int len) throws Exception {
    DataOutputStream dos = new DataOutputStream(new FileOutputStream("mem.dmp"));
    for (int i = 0; i < len; i++) {
      dos.writeChar(ram[start + i]);
    }
    dos.close();
    for (int i = 0; i < len; )
    {
      String str = Integer.toHexString(i);
      while (str.length() < 4)
        str = "0" + str;

      for (int j = 0; (j < 8) && (i < len); i++) {
        str = Integer.toHexString(ram[i]);
        while (str.length() < 4)
          str = "0" + str;
        System.out.print(" " + str);

        j++;
      }

      System.out.println();
    }
  }

	public boolean addHardware(DCPUHardware hw) {
		synchronized (hardware) {
			return hardware.add(hw);
		}
	}
	
	public boolean removeHardware(DCPUHardware hw) {
		synchronized (hardware) {
			return hardware.remove(hw);
		}
	}
	
	public List<DCPUHardware> getHardware() {
		//TODO sync elsewhere
		synchronized (hardware) {
			return new ArrayList<DCPUHardware>(hardware);
		}
	}
}
