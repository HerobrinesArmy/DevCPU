package devcpu.views.hex;

public class RowTextBox extends BinaryTextBox {
	public RowTextBox(final HexViewer hex, int bpr) {
		super(hex,bpr);
	}

	protected void calcPositions() {
		for (int i = 0; i < wordsPerRow; i++) {
			beforePos[i] = 0;
			afterPos[i] = 4;
		}	
		charsPerRow = afterPos[wordsPerRow - 1] + 1;		
	}

	public void appendRow(IDataProvider idp, int row, boolean isLastRow) {
		sbTemp.append(idp.getRowDescriptor(row));
		if (!isLastRow) {
			sbTemp.append('\n');
		}
	}
}
