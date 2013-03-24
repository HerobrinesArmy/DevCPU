package devcpu.views.hex;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ControlEvent;
import org.eclipse.swt.events.ControlListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Slider;

public class HexViewer extends Composite {
	
	static Font fnt = new Font(Display.getCurrent(),"Courier New",10,0);	
	static Color defaultBack = new Color(Display.getDefault(),255,255,255);
	static Color defaultFore = new Color(Display.getDefault(),0,0,0);
	
	private RowTextBox rowText;
	private HexTextBox hexText;
	private RawTextBox rawText;
	private Slider sld;
	protected Color backcolor;
	protected Color forecolor;
	
	protected IDataProvider idp;
	private int rows; // number of rows in the data
	
	private int showStartRow; // first line shown in the text boxes
	private int maxShowStart; // maximal start row to show
	private int rowsInView; // number of rows fit in the text boxes
	private int selectStartWord; // selection start
	private int selectEndWord; // selection end
	private int wordsPerRow; // number of words in a row to show
	
	public HexViewer(Composite parent, int style, IDataProvider idp, int wordsPerRow) {
		super(parent,style);
		this.setLayout(new GridLayout(4,false));
		// create all widgest with a standard 4-columns grid-layout
		
		this.wordsPerRow = wordsPerRow;
		rowText = new RowTextBox(this,wordsPerRow);
		hexText = new HexTextBox(this,wordsPerRow);
		rawText = new RawTextBox(this,wordsPerRow);
		initSlider();
		setBackground(defaultBack);
		setForeground(defaultFore);
		
		this.idp = idp;		
		if (idp == null) {
			rows = 0;
		} else {
			idp.setWordsPerRow(wordsPerRow);
			rows = idp.getRowCount();
		}
		
		showStartRow = 0;
		selectStartWord = 0;
		selectEndWord = 0;
		this.addControlListener(new ControlListener() {
			public void controlMoved(ControlEvent e) {				
				doResizeCalc();
			}
			
			public void controlResized(ControlEvent e) {
				doResizeCalc();				
			}					
		});
		doResizeCalc();		
	}

	/// on resize, recalculate sizes, and draw what necessary.
	protected void doResizeCalc() {
		rowsInView = hexText.calcRowsInView();		
		rawText.setRowsInView(rowsInView);
		
		maxShowStart = rows - rowsInView;
		if (maxShowStart < 0) {
			maxShowStart = 0;
		}
		showStartRow = fix(showStartRow,maxShowStart);

		if (rows <= rowsInView) {
			// all rows will fit
			sld.setEnabled(false);
		} else {
			// minimum row start is 0
			// last row start is rows - rowsInView, but we use +1 in order to include the last row too
			sld.setEnabled(true);
			sld.setValues(showStartRow,0,maxShowStart + 1,1,1,rowsInView);
		}
		showData();
		showSelection();		
	}
	
	/// make sure a specific address is shown 
	protected void showCaret(int ca) {
		int row = ca / wordsPerRow;

		if (row >= rows) {
			// do not continue one line down, if it's the last word
			// and it's in the end of a line 
			row--;
		}
		if (showStartRow + rowsInView <= row) {
			// row is ahead
			showStartRow = row - rowsInView + 1;
			sld.setSelection(showStartRow);
			showData();
		} else if (row < showStartRow) {
			// row is behind
			showStartRow = row;
			sld.setSelection(showStartRow);
			showData();
		}
	}
	
	/// write all the needed data to the text-boxes
	protected void showData() {
		if (idp == null) {
			hexText.clearText();
			rawText.clearText();
			rowText.clearText();
			return;
		}
		
		// iterate over all shown rows
		int maxRow = showStartRow + rowsInView;
		if (maxRow > rows) {
			maxRow = rows;
		}
		hexText.initText();
		rawText.initText();
		rowText.initText();
		
		for (int r = showStartRow; r < maxRow; r++) {			
			// iterate over all words in the row
			boolean isLastRow = (r == maxRow - 1);
			hexText.appendRow(idp,r,isLastRow);
			rawText.appendRow(idp,r,isLastRow);
			rowText.appendRow(idp,r,isLastRow);
		}
		hexText.showText();
		rawText.showText();
		rowText.showText();
	}
		
	/// fix a selection position to fit in range [0,maxpos]
	static int fix(int pos, int maxpos) {
		if (pos < 0) {
			pos = 0;
		}
		if (pos > maxpos) {
			pos = maxpos;
		}
		return pos;
	}

	/// shows the current selection in both text boxes
	protected void showSelection() {
		hexText.showSelection(selectStartWord,selectEndWord);
		rawText.showSelection(selectStartWord,selectEndWord);
		rowText.showSelection(selectStartWord,selectEndWord);
	}

	/// initialize the vertical slider
	private void initSlider() {
		sld = new Slider(this,SWT.V_SCROLL);
		GridData gd = new GridData();
		gd.widthHint = 18;
		gd.verticalAlignment = SWT.FILL;
		gd.grabExcessVerticalSpace = true;
		sld.setLayoutData(gd);
		sld.addSelectionListener(new SelectionListener() {
			public void widgetSelected(SelectionEvent e) {				
				showStartRow = sld.getSelection();
				showData();
				showSelection();				
			}

			public void widgetDefaultSelected(SelectionEvent e) {				
				
			}			
		});
	}

	public void setSelectEnd(int ca) {
		selectEndWord = ca;
	}
	
	public int getSelectEnd() {
		return selectEndWord;
	}

	public void setSelectStart(int ca) {
		selectStartWord = ca;
	}
	
	public int getSelectStart() {
		return selectStartWord;
	}

	public void setShowStart(int i) {
		i = fix(i,maxShowStart);
		if (showStartRow != i) {
			showStartRow = i;
			sld.setSelection(showStartRow);
			showData();
			showSelection();
		}
	}
	
	public int getShowStart() {
		return showStartRow;
	}
	
	public int getWordsPerRow() {
		return wordsPerRow;
	}

	public int getDataSize() {
		if (idp == null) {
			return 0;
		}
		return idp.getDataSize();
	}

	public int getRowsInView() {
		return rowsInView;
	}
	
	public void setDataProvider(IDataProvider idp) {
		this.idp = idp;
		if (idp == null) {
			rows = 0;			
		} else {
			idp.setWordsPerRow(wordsPerRow);
			rows = idp.getRowCount();			
		}
		
		showStartRow = 0;
		selectStartWord = 0;
		selectEndWord = 0;
		doResizeCalc();
		showData();
		showSelection();
	}
	
	public void setBackground(Color color) {
		this.backcolor = color;
		rowText.setBackground(color);
		hexText.setBackground(color);
		rawText.setBackground(color);
	}
	
	public void setForeground(Color color) {
		this.forecolor = color;
		rowText.setForeground(color);
		hexText.setForeground(color);
		rawText.setForeground(color);
	}
	
	public Color getBackground() {
		return this.backcolor;
	}
	
	public Color getForeground() {
		return this.forecolor;
	}
}
