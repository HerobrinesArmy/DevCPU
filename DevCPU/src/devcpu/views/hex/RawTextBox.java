package devcpu.views.hex;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyleRange;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.Display;

class RawTextBox extends BinaryTextBox {
	char UNKNOWN_CHAR = '?';
	char NONPRINTABLE_CHAR = '.';
	public RawTextBox(HexViewer hex, int bpr) {
		super(hex, bpr);
	}

	protected void calcPositions() {
		int pos = 0;
		for (int i = 0; i < wordsPerRow; i++) {
			beforePos[i] = pos;
			pos += 1;
			afterPos[i] = pos;
			if (i % 8 == 7) {
				pos += 3;
			}
		}	
		charsPerRow = afterPos[wordsPerRow - 1] + 1;		
	}

	public void appendRow(IDataProvider idp, int row, boolean isLastRow) {
		int words = idp.getData(rowTemp,row);
		Color red = Display.getCurrent().getSystemColor(SWT.COLOR_RED);
		for (int i = 0; i < words; i++) {
			Character w = rowTemp[i];
			if (w == null) {			
				styleRanges.add(new StyleRange(sbTemp.length(),1,null,red));
				sbTemp.append(UNKNOWN_CHAR);
			} else {
				int x = w;
				if (x < 32 || x > 126) { //TODO
					// non-printable char
					sbTemp.append(NONPRINTABLE_CHAR);
				} else {
					sbTemp.append((char)x);
				}
			}

			if (i == wordsPerRow - 1) {
				// add new line, unless it is the last row
				if (!isLastRow) {
					sbTemp.append('\n');
				}
			} else if (i % 8 == 7) {
				// add a dash every 8 chars where needed
				sbTemp.append(" - ");
			}
		}
	}
}
