package devcpu.lexer.tokens;

import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.RGB;

import devcpu.editors.dasm.DASMColorProvider;

public class SpecialOpCodeToken extends TrimmedLexerToken{
	public static final Color FOREGROUND = DASMColorProvider.get().getColor(new RGB(127, 0, 85));
	public static final Color BACKGROUND = DASMColorProvider.get().getColor(new RGB(255, 255, 255));
	private boolean nextWordA;
	public String mnemonic;

	public SpecialOpCodeToken(String text, int start, int end) {
		super(text, start, end);
		mnemonic = this.text.toUpperCase();
	}

	@Override
	public String getType() {
		return "DASM_SPECIAL_OPCODE";
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

	public void setAValueNextWord(boolean nextWord) {
		this.nextWordA = nextWord;
	}
	
	public boolean isNextWordA() {
		return nextWordA;
	}
}
