package devcpu.lexer.tokens;

import org.eclipse.debug.internal.ui.ColorManager;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.RGB;

public class DataValueEndToken extends TrimmedLexerToken{
	public static final Color FOREGROUND = ColorManager.getDefault().getColor(new RGB(0,0,0));
	public static final Color BACKGROUND = ColorManager.getDefault().getColor(new RGB(255, 255, 255));

	public DataValueEndToken(String text, int start, int end) {
		super(text, start, end);
	}

	@Override
	public String getType() {
		return "DASM_DATA_VALUE_END";
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
