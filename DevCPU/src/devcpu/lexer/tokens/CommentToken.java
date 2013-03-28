package devcpu.lexer.tokens;

import org.eclipse.jface.text.TextAttribute;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.RGB;

import devcpu.editors.dasm.DASMColorProvider;

public class CommentToken extends TrimmedLexerToken {
	public static final Color FOREGROUND = DASMColorProvider.get().getColor(new RGB(63, 127, 95));
	public static final Color BACKGROUND = DASMColorProvider.get().getColor(new RGB(255, 255, 255));

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
		return new TextAttribute(FOREGROUND, BACKGROUND, 0);
	}
}
