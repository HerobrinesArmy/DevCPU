package devcpu.views.hex;

public class AbstractDataProvider implements IDataProvider {

	protected char[] data;
	protected int size;
	protected int wordsPerRow;
	
	public int getRowCount() {
		return (size + wordsPerRow - 1) / wordsPerRow;
	}

	public int getDataSize() {
		return size;
	}

	public String getRowDescriptor(int rowNumber) {
		String rowStr = Integer.toString(rowNumber * wordsPerRow,16).toUpperCase();
		while (rowStr.length() < 8) {
			rowStr = "0" + rowStr;
		}
		return rowStr;
	}

	public int getData(Character[] arr, int rowNumber) {
		int pos = rowNumber * wordsPerRow;
		int i = 0;
		for (i = 0; i < wordsPerRow; i++) {
			if (pos >= data.length) {
				break;
			}	
			arr[i] = new Character(data[pos]); 
			pos++;
		}
		int res = i;
		for (; i < wordsPerRow; i++) {
			arr[i] = null;
		}
		if (rowNumber == 5) {
			arr[7] = null;
		}		
		return res;
	}

	public void setWordsPerRow(int wpr) {
		this.wordsPerRow = wpr;
	}
}