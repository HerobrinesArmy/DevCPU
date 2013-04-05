package devcpu.views.hex;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyleRange;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.Display;

class HexTextBox extends BinaryTextBox {
	static String HEX_VALS = "0123456789ABCDEF";
	static String[] WORD_2_STR = null;
	
	public HexTextBox(HexViewer hex, int bpr) {
		super(hex,bpr);
		if (WORD_2_STR == null) {
			WORD_2_STR = new String[65536];
			char[] arr = new char[4];
			for (int i = 0; i < 65536; i++) {
				arr[0] = HEX_VALS.charAt((i >> 12) & 0x0F);
				arr[1] = HEX_VALS.charAt((i >> 8) & 0x0F);
				arr[2] = HEX_VALS.charAt((i >> 4) & 0x0F);
				arr[3] = HEX_VALS.charAt(i & 0x0F);
				WORD_2_STR[i] = String.copyValueOf(arr);
			}
		}
	}

	protected void calcPositions() {
		int pos = 0;
		for (int i = 0; i < wordsPerRow; i++) {
			beforePos[i] = pos;
			pos += 4;
			afterPos[i] = pos;
			pos++;
//			if (i % 8 == 7) {
//				pos += 4;
//			}
		}	
		charsPerRow = afterPos[wordsPerRow - 1] + 1;
	}

	public void appendRow(IDataProvider idp, int row, boolean isLastRow) {
		int words = idp.getData(rowTemp,row);
		Color red = Display.getDefault().getSystemColor(SWT.COLOR_RED);
		for (int i = 0; i < words; i++) {
			Character w = rowTemp[i];
			if (w == null) {
				styleRanges.add(new StyleRange(sbTemp.length(),2,null,red));
				sbTemp.append("??");
			} else {
				sbTemp.append(WORD_2_STR[w & 0xFFFF]);
			}
			if (i == wordsPerRow - 1) {
				// add new line, unless it is the last row
				if (!isLastRow) {
					sbTemp.append('\n');
				}
			} else if (i != words - 1) {
				sbTemp.append(' ');
			}
		}	
	}
}
