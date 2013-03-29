package devcpu.editors.dasm;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.widgets.Display;

public class DASMColorProvider {
	private static DASMColorProvider provider = new DASMColorProvider();
	
	protected Map<RGB, Color> fColorTable= new HashMap<RGB, Color>(10);

	public Color getColor(RGB rgb) {
    Color color= (Color) fColorTable.get(rgb);
    if (color == null) {
      color= new Color(Display.getCurrent(), rgb);
      fColorTable.put(rgb, color);
    }
    return color;
  }

	 public void dispose() {
	    Iterator<Color> e = fColorTable.values().iterator();
	    while (e.hasNext()) {
	       ((Color) e.next()).dispose();
	    }
	  }

	public static DASMColorProvider get() {
		return provider;
	}
}
