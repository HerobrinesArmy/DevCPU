package devcpu.emulation;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import devcpu.FloppyManager;

public class FloppyDisk implements Identifiable {
	private String id;
	public char[] data = new char[737280];

	private boolean writeProtected;
	private VirtualFloppyDrive drive;
	private FloppyManager manager;

//	public FloppyDisk(File file, boolean writeProtected) throws Exception {
//		this("Floppy", null);
//	}

	public FloppyDisk(String id, FloppyManager manager) {
		this.id = id;
		this.manager = manager;
	}
	
	public void load(File file) throws IOException {
		DataInputStream dis = new DataInputStream(new BufferedInputStream(new FileInputStream(file)));
		try {
			for (int i = 0;; i++) {
				data[i] = dis.readChar();
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			//TODO handle file too large for disk
		} catch (IOException e) {
			dis.close();
		}	
	}

	public boolean isWriteProtected() {
		return writeProtected;
	}

	public void setWriteProtected(boolean writeProtected) {
		this.writeProtected = writeProtected;
	}

	public String getID() {
		return id;
	}

	public void setID(String id) {
		this.id = id;
	}
	
	public void inserted(VirtualFloppyDrive drive)
	{
		this.drive = drive;
	}
	
	public void ejected() {
		this.drive = null;
	}

	public VirtualFloppyDrive getDriveUsing() {
		return drive;
	}
	
	public FloppyManager getManager() {
		return manager;
	}

	public void setManager(FloppyManager manager) {
		this.manager = manager;
	}
}