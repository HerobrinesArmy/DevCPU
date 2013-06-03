package devcpu.views.hex;

import java.util.ArrayList;

import org.eclipse.swt.custom.StyleRange;

public class NullDataProvider implements IDataProvider {
	@Override
	public void setWordsPerRow(int bpr) {
	}

	@Override
	public int getRowCount() {
		return 0;
	}

	@Override
	public int getDataSize() {
		return 0;
	}

	@Override
	public String getRowDescriptor(int rowNumber) {
		return "";
	}

	@Override
	public int getData(Character[] arr, int rowNumber) {
		return 0;
	}

	@Override
	public void frameUpdate(HexViewer hexViewer) {
	}

	@Override
	public void addStyles(ArrayList<StyleRange> styleRanges, int row, int offset) {
	}
}
