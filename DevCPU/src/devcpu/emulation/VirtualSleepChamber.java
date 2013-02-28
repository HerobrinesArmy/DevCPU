package devcpu.emulation;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

import devcpu.HardwareManager;

/**
 * Placeholder implementation of the SPC2000 Sleep Chamber
 * @author Herobrine
 *
 *  The SPC2000 is a deep sleep cell based on the ZEF882 time dilation field
    generator (available from Polytron Corporation Incorporated).
    It provides safe and nearly instantaneous time passage, making long journeys
    in space much easier on the passengers, and allowing cargo to reach its
    destination with minimal aging occurring.
    Due to the nature of the ZEF882, it affects the entire vessel (50 meter
    radius, and will only engage in a near vacuum. Once the SPC2000 is active,
    the vessel will be almost nowhere to an external observer, and detection of
    the vessel is beyond unlikely.
    Because of the strong extra-dimensional acceleration and non-linear temporal
    distortion that occurs, it's highly recommended that passengers are strapped
    in and asleep when triggering the SCP2000.
 * 
 */
public class VirtualSleepChamber extends DCPUHardware
{
	public static final int UNIT_MILLISECONDS = 0x0000;
	public static final int UNIT_MINUTES = 0x0001;
	public static final int UNIT_DAYS = 0x0002;
	public static final int UNIT_YEARS = 0x0003;
	
	public static final int STATUS_ZERO = 0x0000; //######################## - EVACUATE VESSEL IMMEDIATELY
	public static final int STATUS_NOT_IN_A_VACUUM = 0x0001;
	public static final int STATUS_NOT_ENOUGH_FUEL = 0x0002;
	public static final int STATUS_INHOMOGENEOUS_GRAVITATIONAL_FIELD = 0x0003;
	public static final int STATUS_TOO_MUCH_ANGULAR_MOMENTUM = 0x0004;
	public static final int STATUS_ONE_OR_MORE_CELL_DOORS_ARE_OPEN = 0x0005;
	public static final int STATUS_MECHANICAL_ERROR = 0x0006;
	public static final int STATUS_UNKNOWN_ERROR = 0xFFFF; //EVACUATE VESSEL IMMEDIATELY
	
	public static final int ACTION_GET_STATUS = 0;
	public static final int ACTION_SET_UNIT_TO_SKIP = 1;
	public static final int ACTION_TRIGGER_DEVICE = 2;
	public static final int ACTION_SET_SKIP_UNIT = 3;
	
	private static final double MAX_ACCEPTABLE_ANGULAR_MOMENTUM = 1; //TODO: Replace with actual max
	
	private long numberOfUnitsToSkip;
	private int unitToSkip;
	private HardwareManager manager;
	private String id;
	
  public VirtualSleepChamber(String id, HardwareManager manager) {
    super(0x40e41d9d, 0x005e, 0x1c6c8b36);
    this.id = id;
    this.manager = manager;
  }

  public VirtualSleepChamber() {
  	this("SPC200", null);
	}

	public void interrupt() {
    switch (dcpu.registers[0]) {
    case ACTION_GET_STATUS:
    	performGetStatus();
    	break;
    case ACTION_SET_SKIP_UNIT:
    	int b = dcpu.registers[1];
    	numberOfUnitsToSkip = ByteBuffer.allocate(8).order(ByteOrder.BIG_ENDIAN).putLong(
    			(dcpu.ram[b]<<48)|(dcpu.ram[b+1]<<32)|(dcpu.ram[b+2]<<16)|dcpu.ram[b+3])
    			.order(ByteOrder.LITTLE_ENDIAN).getLong(0);
    	break;
    case ACTION_TRIGGER_DEVICE:
    	performGetStatus();
    	if (dcpu.registers[2] == 1) {
    		trigger();
    	}
    	break;
    case ACTION_SET_UNIT_TO_SKIP:
    	unitToSkip = dcpu.registers[1] % 4;
    }
	}

	private void performGetStatus() {
		//TODO: Conditions for STATUS_ZERO and STATUS_UNKNOWN_ERROR
		if (!checkForVacuum()) {
			dcpu.registers[2] = 0; //Note: Specification doesn't state that this should be set to anything
			dcpu.registers[1] = STATUS_NOT_IN_A_VACUUM;
		} else if (!checkForFuel()) {
			dcpu.registers[2] = 0;
			dcpu.registers[1] = STATUS_NOT_ENOUGH_FUEL;			
		} else if (!checkForHomogeneousGravitaionalField()) {
			dcpu.registers[2] = 0;
			dcpu.registers[1] = STATUS_INHOMOGENEOUS_GRAVITATIONAL_FIELD;
		} else if (getAngularMomentum() > MAX_ACCEPTABLE_ANGULAR_MOMENTUM) {
			dcpu.registers[2] = 0;
			dcpu.registers[1] = STATUS_TOO_MUCH_ANGULAR_MOMENTUM;
		} else if (getNumberOfCellDoorsOpen() > 0) {
			dcpu.registers[2] = 0;
			dcpu.registers[1] = STATUS_ONE_OR_MORE_CELL_DOORS_ARE_OPEN;			
		} else if (!checkForMechanicalIntegrity()) {
			dcpu.registers[2] = 0;
			dcpu.registers[1] = STATUS_MECHANICAL_ERROR;			
		} else {
			dcpu.registers[2] = 1;
		}
	}
	
	private int getNumberOfCellDoorsOpen() {
		//TODO Get actual number of cell doors open
		return 0;
	}

	private boolean checkForMechanicalIntegrity() {
		//TODO Actual check
		return true;
	}

	private double getAngularMomentum() {
		//TODO Get actual angular momentum
		return 0;
	}

	private boolean checkForHomogeneousGravitaionalField() {
		//TODO Actual check
		return true;
	}

	private boolean checkForFuel() {
		//TODO Actual check
		return true;
	}

	private boolean checkForVacuum() {
		//TODO Actual check
		return true;
	}

	public void tick60hz() {
		//TODO Something while triggered, I suppose
  }
	

	private void trigger() {	
		//TODO Handle sleep chamber activation
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
}