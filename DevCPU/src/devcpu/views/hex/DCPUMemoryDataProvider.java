package devcpu.views.hex;

import java.util.ArrayList;

import org.eclipse.swt.custom.StyleRange;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.widgets.Display;

import devcpu.emulation.DefaultControllableDCPU;

public class DCPUMemoryDataProvider extends AbstractDataProvider {
	private static final Color PC_COLOR = new Color(Display.getDefault(), new RGB(255, 127, 127));
	private static final Color SP_COLOR = new Color(Display.getDefault(), new RGB(127, 255, 127));
	
	private DefaultControllableDCPU dcpu;

	public DCPUMemoryDataProvider(DefaultControllableDCPU dcpu) {
		this.dcpu = dcpu;
		this.data = dcpu.ram;
		this.size = 65536;
		this.wordsPerRow = 8; 
	}

	public DefaultControllableDCPU getDcpu() {
		return dcpu;
	}

	public void setDcpu(DefaultControllableDCPU dcpu) {
		this.dcpu = dcpu;
	}
	
	@Override
	public void frameUpdate(HexViewer hv) {
		hv.refresh();
	}
	
	@Override
	public void addStyles(ArrayList<StyleRange> styleRanges, int row, int offset) {
		if (dcpu.pc >= row * wordsPerRow && dcpu.pc < (row + 1) * wordsPerRow)
		{
			styleRanges.add(new StyleRange(offset + (dcpu.pc % wordsPerRow) * 5,4,null,PC_COLOR));
		}
		if (dcpu.sp >= row * wordsPerRow && dcpu.sp < (row + 1) * wordsPerRow)
		{
			styleRanges.add(new StyleRange(offset + (dcpu.sp % wordsPerRow) * 5,4,null,SP_COLOR));
		}
	}
}
