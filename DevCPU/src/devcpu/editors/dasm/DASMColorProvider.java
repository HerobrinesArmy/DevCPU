package devcpu.editors.dasm;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.widgets.Display;

public class DASMColorProvider {

  public static final RGB MULTI_LINE_COMMENT= new RGB(128, 0, 0);
  public static final RGB COMMENT= new RGB(128, 128, 0);
  public static final RGB KEYWORD= new RGB(0, 0, 128);
  public static final RGB TYPE= new RGB(0, 0, 128);
  public static final RGB STRING= new RGB(0, 128, 0);
  public static final RGB DEFAULT= new RGB(0, 0, 0);
  public static final RGB JAVADOC_KEYWORD= new RGB(0, 128, 0);
  public static final RGB JAVADOC_TAG= new RGB(128, 128, 128);
  public static final RGB JAVADOC_LINK= new RGB(128, 128, 128);
  public static final RGB JAVADOC_DEFAULT= new RGB(0, 128, 128);
	private static DASMColorProvider provider = new DASMColorProvider();
	
	protected Map fColorTable= new HashMap(10);

	public Color getColor(RGB rgb) {
    Color color= (Color) fColorTable.get(rgb);
    if (color == null) {
      color= new Color(Display.getCurrent(), rgb);
      fColorTable.put(rgb, color);
    }
    return color;
  }

	 public void dispose() {
	    Iterator e= fColorTable.values().iterator();
	    while (e.hasNext())
	       ((Color) e.next()).dispose();
	  }

	public static DASMColorProvider get() {
		return provider;
	}
}
