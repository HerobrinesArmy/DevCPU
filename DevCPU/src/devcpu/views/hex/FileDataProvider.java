package devcpu.views.hex;

import java.io.FileInputStream;

public class FileDataProvider extends AbstractDataProvider {

	public FileDataProvider(String filename) {
		try {
			FileInputStream fis = new FileInputStream(filename);
			size = fis.available();
			data = new char[size];
			//TODO FIXME XXX
//			fis.read(data);
			fis.close();
		} catch (Exception e) {
			data = new char[0];
			size = 0;			
		}
	}
}
