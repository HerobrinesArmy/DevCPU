package devcpu.lexer.tokens;

import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.RGB;

import devcpu.editors.dasm.DASMColorProvider;

public class LabelToken extends TrimmedLexerToken{
	public static final Color FOREGROUND = DASMColorProvider.get().getColor(new RGB(0, 0, 0));
	public static final Color BACKGROUND = DASMColorProvider.get().getColor(new RGB(255, 255, 255));
	private boolean local;

	public LabelToken(String text, int start, int end) {
		super(text, start, end);
		if (this.text.startsWith(".")) {
			local = true;
		}
	}

	@Override
	public String getType() {
		return "DASM_LABEL";
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
	
	public boolean isLocal() {
		return local;
	}
}
