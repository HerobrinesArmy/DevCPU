package devcpu.lexer.tokens;

import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.RGB;

import devcpu.editors.dasm.DASMColorProvider;

public class AValueEndToken extends StandardLexerToken{
	public static final Color FOREGROUND = DASMColorProvider.get().getColor(new RGB(0,0,0));
	public static final Color BACKGROUND = DASMColorProvider.get().getColor(new RGB(255, 255, 255));

	public AValueEndToken(String text, int start, int end) {
		super(text, start, end);
	}

	@Override
	public String getType() {
		return "DASM_A_VALUE_END";
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
