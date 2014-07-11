package devcpu.emulation;

import java.util.ArrayList;
import java.util.List;

import devcpu.managers.HardwareManager;

/**
 * Preliminary implementation of the SPED-3 3D Vector Display
 * @author Herobrine
 *
 *  The Mackapar Suspended Particle Exciter Display, Rev 3 ("the device") is a 3D
vector display unit. Straight lines are drawn between consecutive vertices in a
constant loop, with customizable colors per vertex. The effect is similar to a
free floating 3D model.
The area of the projected model is about 1x1x1 meters, and projection occurs
1.5 meters above the device.
The emitters are capable to rotate around the Z axis at 50 degrees per second,
allowing for easy animation of projected models.
Up to 128 lines may be projected, but the more lines are projected, the more
severe the flickering gets.  
 * 
 */
public class VirtualVectorDisplay extends DCPUHardware
{
	public static final char STATE_NO_DATA = 0x0000; //No vertices queued up, device is in stand-by   
	public static final char STATE_RUNNING = 0x0001; //The device is projecting lines
	public static final char STATE_TURNING = 0x0002; //The device is projecting lines and turning
	    
	public static final char ERROR_NONE = 0x0000; //There's been no error since the last poll.
	public static final char ERROR_BROKEN = 0xffff; //There's been some major software or hardware problem, try turning off and turning on the device again.
	
	public static final char BEHAVIOR_POLL_DEVICE = 0x0000; //Sets B to the current state (see below) and C to the last error since the last device poll.
	public static final char BEHAVIOR_MAP_REGION = 0x0001; //Map region. Sets the memory map offset to X, and the total number of vertices to render to Y. See below for the encoding information.
	public static final char BEHAVIOR_ROTATE_DEVICE = 0x0002; //Sets the target rotation for the device to X%360 degrees.
	
	private static final double rotation60Hz = 50d/60d;
	
	private char mapStart;
	private char mapLength;
	private boolean broken;
	protected double angle;
	private double targetDelta;
	protected List<Vertex> vertices = new ArrayList<Vertex>();
	
  public VirtualVectorDisplay(String id, HardwareManager manager) {
    super(0x42babf3c, 0x0003, 0x1eb37e91);
    this.id = id;
    this.manager = manager;
  }

  public VirtualVectorDisplay() {
  	this("SPED-3", null);
	}

	public void interrupt() {
    switch (dcpu.registers[0]) {
    case BEHAVIOR_POLL_DEVICE:
    	if (mapLength == 0) {
    		dcpu.registers[1] = STATE_NO_DATA;
    	} else if (targetDelta == 0) {
    		dcpu.registers[1] = STATE_RUNNING;
  		} else {
  			dcpu.registers[1] = STATE_TURNING;
  		}
    	dcpu.registers[2] = broken ? ERROR_BROKEN : ERROR_NONE;
    	break;
    case BEHAVIOR_MAP_REGION:
    	mapStart = dcpu.registers[3];
    	mapLength = dcpu.registers[4];
    	break;
    case BEHAVIOR_ROTATE_DEVICE:
    	targetDelta = (dcpu.registers[3] % 360) - angle;
    	if (targetDelta > 180) {
    		targetDelta -= 360;
    	} else if (targetDelta < -180) {
    		targetDelta += 360;
    	}
    }
	}

	public void tick60hz() {
		if (targetDelta < 0) {
			if (targetDelta > -rotation60Hz) {
				angle -= targetDelta;
				targetDelta = 0;
			} else {
				angle -= rotation60Hz;
				targetDelta += rotation60Hz; 
			}
			angle %= 360;
		} else if (targetDelta > 0) {
			if (targetDelta < rotation60Hz) {
				angle += targetDelta;
				targetDelta = 0;
			} else {
				angle += rotation60Hz;
				targetDelta -= rotation60Hz;
			}
			angle %= 360;
		}
		synchronized (vertices)
		{
			vertices.clear();
			for (int i = mapStart; i < mapStart + 2 * mapLength; i++) {
				char word = dcpu.ram[i++ & 0xFFFF];
				Vertex vertex = new Vertex();
				vertex.x = word & 0xFF;
				vertex.y = word >> 8;
				vertex.z = (word = dcpu.ram[i & 0xFFFF]) & 0xFF;
				vertex.color = (word >>= 8) & 0x3;
				vertex.intensity = (word & 0x4) == 0x4;
				vertices.add(vertex);
			}
		}
  }
	
	public List<Vertex> getVertices() {
		return vertices;
	}
	
	public class Vertex {
		public int x;
		public int y;
		public int z;
		public int color;
		public boolean intensity;
	}

	public double getAngle() {
		return angle;
	}

	@Override
	public void powerOff() {
		this.mapLength = 0;
		this.mapStart = 0;
		this.targetDelta = 0;
		this.vertices.clear();
	}
}
