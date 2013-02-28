package devcpu.emulation;

import devcpu.HardwareManager;


/**
 * Experimental, untested implementation of the MF35D Floppy Drive
 * @author Herobrine
 *
 * The Mackapar 3.5" Floppy Drive is compatible with all standard 3.5" 1440 KB
 * floppy disks. The floppies need to be formatted in 16 bit mode, for a total of
 * 737,280 words of storage. Data is saved on 80 tracks with 18 sectors per track,
 * for a total of 1440 sectors containing 512 words each.
 * The M35FD works is asynchronous, and has a raw read/write speed of 30.7kw/s.
 * Track seeking time is about 2.4 ms per track.
 * 
 * TODO: Switch to coarser, 60hz time-keeping. Current time-keeping is a bit flawed.
 * TODO: Test this more.
 */
public class VirtualFloppyDrive extends DCPUHardware
{
	public static final char STATE_NO_MEDIA = 0x0000; //There's no floppy in the drive.
	public static final char STATE_READY = 0x0001; //The drive is ready to accept commands.
	public static final char STATE_READY_WP = 0x0002; //Same as ready, except the floppy is write protected.
	public static final char STATE_BUSY = 0x0003; //The drive is busy either reading or writing a sector.
	    
	public static final char ERROR_NONE = 0x0000; //There's been no error since the last poll.
	public static final char ERROR_BUSY = 0x0001; //Drive is busy performing an action
	public static final char ERROR_NO_MEDIA = 0x0002; //Attempted to read or write with no floppy inserted.
	public static final char ERROR_PROTECTED = 0x0003; //Attempted to write to write protected floppy.
	public static final char ERROR_EJECT = 0x0004; //The floppy was removed while reading or writing.
	public static final char ERROR_BAD_SECTOR = 0x0005; //The requested sector is broken, the data on it is lost.
	public static final char ERROR_BROKEN = 0xffff; //There's been some major software or hardware problem, try turning off and turning on the device again.
	
	public static final int TRACKS_PER_DISK = 80;
	public static final int SECTORS_PER_TRACK = 18;
	public static final int WORDS_PER_SECTOR = 512;
	public static final int MAX_SECTOR = 1439;
	
//	private static final int SEEK_NANOSECONDS_PER_TRACK = 2400000;
	private static final int SEEK_CYCLES_PER_TRACK = 240;
//	private static final int READ_NANOSECONDS_PER_SECTOR = 16677524;
	private static final int READ_CYCLES_PER_SECTOR = 1668;
//	private static final int WRITE_NANOSECONDS_PER_SECTOR = 16677524;
	private static final int WRITE_CYCLES_PER_SECTOR = 1668;
	
	private char state = STATE_NO_MEDIA;
	private char error = ERROR_NONE;
	private boolean interruptsEnabled;
	private char message;
	private int track;
	private FloppyDisk floppy;
	private FloppyOperation operation = new FloppyOperation(FloppyOperation.NONE, 0, 0, Integer.MAX_VALUE);
	private String id;
	private HardwareManager manager;
	
  public VirtualFloppyDrive(String id, HardwareManager manager) {
    super(0x4fd524c5, 0x000b, 0x1eb37e91);
    this.id = id;
    this.manager = manager;
  }

  public VirtualFloppyDrive() {
  	this("M35FD", null);
	}

	public void interrupt() {
    int a = dcpu.registers[0];
    if (a == 0) {
    	dcpu.registers[1] = state;
    	dcpu.registers[2] = error;
    	//It is unclear whether this should qualify as a change (interrupt-triggering)
    	error = ERROR_NONE;
    } else if (a == 1) {
    	if (dcpu.registers[3] == 0) {
    		interruptsEnabled = false;
    	} else {
    		interruptsEnabled = true;
    		message = dcpu.registers[3];
    	}
    } else if (a == 2) {
    	int sector = dcpu.registers[3];
    	if (sector <= MAX_SECTOR && (state == STATE_READY || state == STATE_READY_WP)) {
    		operation = new FloppyOperation(FloppyOperation.READ, sector, dcpu.registers[4], 
    				dcpu.cycles + READ_CYCLES_PER_SECTOR + SEEK_CYCLES_PER_TRACK
    				* Math.abs(track - (sector / SECTORS_PER_TRACK)));
    		dcpu.registers[1] = 1;
    		setState(STATE_BUSY);
    	} else {
    		dcpu.registers[1] = 0;
    		if (state == STATE_BUSY) {
    			setError(ERROR_BUSY);
    		} else if (state == STATE_NO_MEDIA) {
    			setError(ERROR_NO_MEDIA);
    		} else if (sector > MAX_SECTOR) {
    			setError(ERROR_BAD_SECTOR);
    		}
    	}
    } else if (a == 3) {
    	int sector = dcpu.registers[3];
    	if (sector <= MAX_SECTOR && state == STATE_READY) {
    		operation = new FloppyOperation(FloppyOperation.WRITE, sector, dcpu.registers[4], 
    				dcpu.cycles + WRITE_CYCLES_PER_SECTOR + SEEK_CYCLES_PER_TRACK 
    				* Math.abs(track - (sector / SECTORS_PER_TRACK)));
    		dcpu.registers[1] = 1;
    		setState(STATE_BUSY);
    	} else {
    		dcpu.registers[1] = 0;
    		if (state == STATE_BUSY) {
    			setError(ERROR_BUSY);
    		} else if (state == STATE_NO_MEDIA) {
    			setError(ERROR_NO_MEDIA);
    		} else if (state == STATE_READY_WP) {
    			setError(ERROR_PROTECTED);
    		} else if (sector > MAX_SECTOR) {
    			setError(ERROR_BAD_SECTOR);
    		}
    	}
    }
  }

  private void setState(char state) {
  	setState(state, error);
	}

	private void setError(char error) {
		setState(state, error);
	}
	
	private void setState(char state, char error) {
		if (this.state != state || this.error != error) {
			this.state = state;
			this.error = error;
	  	if (interruptsEnabled) {
	  		dcpu.interrupt(message);
	  	}
		}
	}

	public void tick60hz() {
		if ((operation.cycles -= 1667) <= 0) {
			switch (operation.type) {
	  	case FloppyOperation.READ:
	  		for (int i = 0; i < 512; i++) {
	  			dcpu.ram[operation.memory + i] = floppy.data[operation.sector * WORDS_PER_SECTOR + i];
	  		}
	  		track = operation.sector / SECTORS_PER_TRACK;
//	  		System.out.println("Read sector " + operation.sector + " in track " + track + " to 0x" +  Integer.toHexString(operation.memory));
	  		operation = new FloppyOperation(FloppyOperation.NONE, 0, 0, Integer.MAX_VALUE);
	  		setState(floppy.isWriteProtected() ? STATE_READY_WP : STATE_READY, ERROR_NONE);
	  		break;
	  	case FloppyOperation.WRITE:
	  		for (int i = 0; i < 512; i++) {
	  			floppy.data[operation.sector * WORDS_PER_SECTOR + i] = dcpu.ram[operation.memory + i];
	  		}
	  		track = operation.sector / SECTORS_PER_TRACK;
//	  		System.out.println("Wrote sector " + operation.sector + " in track " + track + " from 0x" +  Integer.toHexString(operation.memory));
	  		operation = new FloppyOperation(FloppyOperation.NONE, 0, 0, Integer.MAX_VALUE);
	  		setState(STATE_READY, ERROR_NONE);
	  		break;
	  	case FloppyOperation.NONE:
	  		new FloppyOperation(FloppyOperation.NONE, 0, 0, Integer.MAX_VALUE);
	  	}
		}
  }
	
	public void insert(FloppyDisk floppy) {
		this.floppy = floppy;
		if (floppy.isWriteProtected()) {
			setState(STATE_READY_WP);
		} else {
			setState(STATE_READY);
		}
		floppy.inserted(this);
	}
	
	public FloppyDisk eject() {
		FloppyDisk ejected = floppy;
		floppy = null;
		if (state == STATE_BUSY) {
			operation = new FloppyOperation(FloppyOperation.NONE, 0, 0, Integer.MAX_VALUE);
			setState(STATE_NO_MEDIA, ERROR_EJECT);
		} else {
			setState(STATE_NO_MEDIA);
		}
		ejected.ejected();
		return ejected;
	}
	
	private class FloppyOperation {
		private static final int NONE = 0;
		private static final int READ = 1;
		private static final int WRITE = 2;
		
		private int type;
		private int sector;
		private int memory;
		private int cycles;

		public FloppyOperation(int type, int sector, int memory, int cycles) {
			this.type = type;
			this.sector = sector;
			this.memory = memory;
			this.cycles = cycles;
		}
	}

	public FloppyDisk getDisk() {
		return floppy;
	}

	public String getID() {
		return id;
	}

	public void setID(String id) {
		this.id = id;
	}

	public HardwareManager getManager() {
		return manager;
	}
	
	@Override
	public void powerOff() {
		this.state = floppy == null ? STATE_NO_MEDIA : floppy.isWriteProtected() ? STATE_READY_WP : STATE_READY;
		this.error = ERROR_NONE;
		this.interruptsEnabled = false;
		this.message = 0;
		this.track = 0;
		this.operation = new FloppyOperation(FloppyOperation.NONE, 0, 0, Integer.MAX_VALUE);
	}
}