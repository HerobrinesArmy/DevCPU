package devcpu.lexer;

import org.eclipse.debug.internal.ui.ColorManager;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.RGB;

public class BValueEndToken extends TrimmedLexerToken{
	public static final Color FOREGROUND = ColorManager.getDefault().getColor(new RGB(0,0,0));
	public static final Color BACKGROUND = ColorManager.getDefault().getColor(new RGB(255, 255, 255));

	public BValueEndToken(String text, int start, int end) {
		super(text, start, end);
	}

	@Override
	public String getType() {
		return "DASM_B_VALUE_END";
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
}
