package devcpu.views.hex;

import java.util.ArrayList;

import org.eclipse.swt.custom.StyleRange;

public abstract class AbstractDataProvider implements IDataProvider {
	protected char[] data;
	protected int size;
	protected int wordsPerRow;
	
	@Override
	public int getRowCount() {
		return (size + wordsPerRow - 1) / wordsPerRow;
	}

	@Override
	public int getDataSize() {
		return size;
	}

	@Override
	public String getRowDescriptor(int rowNumber) {
		String rowStr = Integer.toString(rowNumber * wordsPerRow,16).toUpperCase();
		while (rowStr.length() < 4) {
			rowStr = "0" + rowStr;
		}
		return rowStr;
	}

	@Override
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
		return res;
	}

	@Override
	public void setWordsPerRow(int wpr) {
		this.wordsPerRow = wpr;
	}
	
	@Override
	public void frameUpdate(HexViewer hexViewer) {
	}
	
	@Override
	public void addStyles(ArrayList<StyleRange> styleRanges, int row, int offset) {
	}
}