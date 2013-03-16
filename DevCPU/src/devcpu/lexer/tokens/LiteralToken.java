package devcpu.lexer.tokens;

import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.RGB;

import devcpu.editors.dasm.DASMColorProvider;

public class LiteralToken extends TrimmedLexerToken{
	public static final Color FOREGROUND = DASMColorProvider.get().getColor(new RGB(64, 64, 64));
	public static final Color BACKGROUND = DASMColorProvider.get().getColor(new RGB(255, 255, 255));
	private int value; //TODO: Determine whether non-integer literals will be allowed in expressions

	public LiteralToken(String text, int start, int end) {
		super(text, start, end);
		value = parseValue(this.text);
	}

	@Override
	public String getType() {
		return "DASM_LITERAL";
	}

	@Override
	public boolean isUndefined() {
		return false;
	}

	@Override
	public boolean isWhitespace() {
		return false;
	}

	@Override
	public boolean isEOF() {
		return false;
	}

	@Override
	public boolean isOther() {
		return true;
	}

	@Override
	public Object getData() {
		return null;
	}

	public int getValue() {
		return value;
	}
	
	public static int parseValue(String text) {
		int val = 0;
		if (text.startsWith("'")) {
			val = text.charAt(1);
		} else if (text.startsWith("0x")) {
    	val = Integer.parseInt(text.substring(2), 16);
    } else if (text.startsWith("0b")) {
    	val = Integer.parseInt(text.substring(2), 2);
    } else {
    	val = Integer.parseInt(text);
    }
//    val &= 0xFFFF;
    return val;
	}
}
