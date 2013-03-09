package devcpu.lexer.tokens;

import org.eclipse.debug.internal.ui.ColorManager;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.RGB;

public class DataToken extends TrimmedLexerToken{
	public static final Color FOREGROUND = ColorManager.getDefault().getColor(new RGB(127, 0, 85));
	public static final Color BACKGROUND = ColorManager.getDefault().getColor(new RGB(255, 255, 255));

	public DataToken(String text, int start, int end) {
		super(text, start, end);
	}

	@Override
	public String getType() {
		return "DASM_DATA";
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
