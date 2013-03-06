package devcpu.lexer;

import org.eclipse.debug.internal.ui.ColorManager;
import org.eclipse.jface.text.TextAttribute;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.RGB;

public class CommentToken extends TrimmedLexerToken {
	private Color foreground = ColorManager.getDefault().getColor(new RGB(63, 127, 95));
	private Color background = ColorManager.getDefault().getColor(new RGB(255, 255, 255));

	public CommentToken(String text, int start, int end) {
		super(text, start, end);
	}

	@Override
	public String getType() {
		return "DASM_COMMENT";
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
		//TODO get these from preferences
		return new TextAttribute(foreground, background, 0);
	}
}
