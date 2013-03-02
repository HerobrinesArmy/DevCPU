package devcpu.emulation;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
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
		int i = 0;
		try {
			for (; i<data.length; i++) {
				data[i] = dis.readChar();
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			e.printStackTrace();
		} catch (IOException e) {
			for (; i<data.length; i++) {
				data[i] = 0;
			}
			dis.close();
		}	
	}

	public void save(File file) throws IOException {
		DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(file)));
		try {
			for (int i = 0; i < data.length; i++) {
				dos.writeChar(data[i]);
			}
		} catch (IOException e) {
			dos.close();
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