package devcpu.util;

public class Util {
	public static int parseValue(String text) {
		int val = 0;
		if (text.startsWith("0x")) {
    	val = Integer.parseInt(text.substring(2), 16);
    } else if (text.startsWith("0b")) {
    	val = Integer.parseInt(text.substring(2), 2);
    } else if (text.startsWith("'") && text.endsWith("'") && text.length()==3) {
			val = text.charAt(1);
		} else {
    	val = Integer.parseInt(text);
    }
//    val &= 0xFFFF;
    return val;
	}
}
