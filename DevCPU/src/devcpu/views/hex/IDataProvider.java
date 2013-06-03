package devcpu.views.hex;

import java.util.ArrayList;

import org.eclipse.swt.custom.StyleRange;

public interface IDataProvider {
	public void setWordsPerRow(int bpr);
	public int getRowCount();
	public int getDataSize();
	public String getRowDescriptor(int rowNumber);
	public int getData(Character[] arr, int rowNumber);
	public void frameUpdate(HexViewer hexViewer);
	public void addStyles(ArrayList<StyleRange> styleRanges, int row, int offset);
}
