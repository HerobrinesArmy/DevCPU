package devcpu.views.hex;

import java.util.ArrayList;
import java.util.Iterator;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyleRange;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.events.MouseMoveListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;

abstract class BinaryTextBox {
	protected StyledText txt;
	protected HexViewer hex;
	
	protected int rowsInView;
	protected int wordsPerRow;
	protected int charsPerRow;
	protected int beforePos[];
	protected int afterPos[];
	
	protected Character rowTemp[];
	protected StringBuilder sbTemp;
	protected ArrayList<StyleRange> styleRanges;
	
	static int CHAR_HEIGHT = 17; // the number of pixels a char actually takes
	static int CHAR_WIDTH = 10; // the number of pixels a char actually takes
	
	public BinaryTextBox(final HexViewer hex, int bpr) {		
		this.hex = hex;		
		this.wordsPerRow = bpr;
		beforePos = new int[bpr];
		afterPos = new int[bpr];
		rowTemp = new Character[bpr];
		calcPositions();		
		
		txt = new StyledText(hex,SWT.BORDER | SWT.READ_ONLY | SWT.MULTI);
		txt.setFont(HexViewer.fnt);
		GridData gd = new GridData();
		gd.widthHint = getWidth();
		gd.verticalAlignment = SWT.FILL;
		gd.grabExcessVerticalSpace = true;
		txt.setLayoutData(gd);
		txt.addMouseListener(new MouseListener() {
			public void mouseDoubleClick(MouseEvent e) {
 
			}

			public void mouseDown(MouseEvent e) {
				int ca = getAddressByPos(getCaretPos(e.x,e.y));				
				hex.setSelectEnd(ca);
				if ((e.stateMask & SWT.SHIFT) == 0) {
					hex.setSelectStart(ca);
				}
				hex.showSelection();
				txt.setFocus();
			}

			public void mouseUp(MouseEvent e) {				
				int ca = getAddressByPos(getCaretPos(e.x,e.y));
				hex.setSelectEnd(ca);
				hex.showSelection();
				txt.setFocus();
			}
		});
		txt.addMouseMoveListener(new MouseMoveListener() {
			public void mouseMove(MouseEvent e) {
				if ((e.stateMask & SWT.BUTTON1) != 0) {
					int ca = getAddressByPos(getCaretPos(e.x,e.y));
					hex.setSelectEnd(ca);					
					// scroll if out of bounds
					if (e.y < 0) {
						hex.setShowStart(hex.getShowStart() - 1);
					} else if (e.y > txt.getSize().y) {
						hex.setShowStart(hex.getShowStart() + 1);
					}
					hex.showSelection();
					txt.setFocus();
				}
			}
		});
		txt.addListener(SWT.MouseWheel,new Listener() {
			public void handleEvent(Event event) {
				hex.setShowStart(hex.getShowStart() - event.count);
				txt.setFocus();
			}			
		});
		txt.addKeyListener(new KeyListener() {
			public void keyPressed(KeyEvent e) {
				// abort all traversal keys
				e.doit = false;
				int caretAddress = hex.getSelectEnd();
				// move the caret according to key
				if (e.keyCode == SWT.ARROW_DOWN) {
					caretAddress = caretAddress + wordsPerRow;					
				} else if (e.keyCode == SWT.ARROW_UP) {
					caretAddress = caretAddress - wordsPerRow;
				} else if (e.keyCode == SWT.ARROW_RIGHT) {
					caretAddress = caretAddress + 1;					
				} else if (e.keyCode == SWT.ARROW_LEFT) {
					caretAddress = caretAddress - 1;
				} else if (e.keyCode == SWT.PAGE_DOWN) {
					caretAddress = caretAddress + wordsPerRow * rowsInView;
				} else if (e.keyCode == SWT.PAGE_UP) {
					caretAddress = caretAddress - wordsPerRow * rowsInView;
				} else if (e.keyCode == SWT.HOME) {
					caretAddress = 0;
				} else if (e.keyCode == SWT.END) {
					caretAddress = hex.getDataSize();
				} else {
					// no traversal key
					return;
				}
				caretAddress = HexViewer.fix(caretAddress,hex.getDataSize());
				
				hex.setSelectEnd(caretAddress);
				if ((e.stateMask & SWT.SHIFT) == 0) {
					// if shift is not pressed, change both selection end and start
					hex.setSelectStart(caretAddress);
				}
				hex.showCaret(hex.getSelectEnd());
				hex.showSelection();
				txt.setFocus();
			}

			public void keyReleased(KeyEvent e) {

			}
		});
	}
	
	protected int getCaretPos(int x, int y) {
		int row = y / CHAR_HEIGHT;
		int col = x / CHAR_WIDTH;
		return row * charsPerRow + col;
	}
	
	protected int getAddressByPos(int pos) {
		int row = pos / charsPerRow;
		int col = pos % charsPerRow;
		int addr = (hex.getShowStart() + row) * wordsPerRow;
		// simulate the printing method, and count position		
		for (int i = 0; i < wordsPerRow; i++) {
			if (afterPos[i] > col) {
				break;
			}			
			addr++;
		}
		return addr;
	}
	
	protected int getPosByAddress(int address, boolean isForward) {
		int row = address / wordsPerRow;
		int col = address % wordsPerRow;
		int pos = (row - hex.getShowStart()) * charsPerRow;
		if (isForward) {
			pos += afterPos[col];
		} else {
			pos += beforePos[col];
		}
		return pos;
	}
	
	public abstract void appendRow(IDataProvider idp, int row, boolean isLastRow);
	
	public void initText() {
		sbTemp = new StringBuilder();
		styleRanges = new ArrayList<StyleRange>();
	}
	
	public void showText() {
		txt.setText(sbTemp.toString());
		for (Iterator<StyleRange> iter = styleRanges.iterator(); iter.hasNext();) {
			StyleRange style = iter.next();
			txt.setStyleRange(style);			
		}
	}
	
	public void clearText() {
		txt.setText("");
	}
	
	protected abstract void calcPositions();
	
	public void setBackground(Color color) {
		txt.setBackground(color);
	}
	
	public void setForeground(Color color) {
		txt.setForeground(color);
	}
	
	public void showSelection(int startWord, int endWord) {
		if (startWord == endWord) {
			int pos = getPosByAddress(startWord,false);	
			pos = HexViewer.fix(pos,txt.getText().length());
			txt.setSelection(pos);
			return;
		}
		int startPos;
		int endPos;
		if (startWord < endWord) {
			startPos = getPosByAddress(startWord,false);
			endPos = getPosByAddress(endWord - 1,true);
		} else {
			startPos = getPosByAddress(startWord - 1,true);
			endPos = getPosByAddress(endWord,false);
		}
		startPos = HexViewer.fix(startPos,txt.getText().length());
		endPos = HexViewer.fix(endPos,txt.getText().length());
		txt.setSelection(startPos,endPos);
	}

	public int calcRowsInView() {
		// use -10 due to border width, and some extra spacing
		rowsInView = (txt.getSize().y - 10) / CHAR_HEIGHT; 
		return rowsInView;
	}	
	
	public void setRowsInView(int rows) {
		this.rowsInView = rows;
	}
	
	private int getWidth() {
		if (afterPos == null) {
			return 0;
		}
		return afterPos[wordsPerRow - 1] * CHAR_WIDTH + 5;
	}
}
