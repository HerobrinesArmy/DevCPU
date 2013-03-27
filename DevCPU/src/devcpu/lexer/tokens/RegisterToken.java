package devcpu.lexer.tokens;

import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.RGB;

import devcpu.editors.dasm.DASMColorProvider;

public class RegisterToken extends TrimmedLexerToken{
	public static final Color FOREGROUND = DASMColorProvider.get().getColor(new RGB(196, 128, 0));;
	public static final Color BACKGROUND = DASMColorProvider.get().getColor(new RGB(255, 255, 255));
	private String register;

	public RegisterToken(String text, int start, int end) {
		super(text, start, end);
		register = this.text.toUpperCase();
	}

	@Override
	public String getType() {
		return "DASM_REGISTER";
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
	
	public String getRegister() {
		return register;
	}
}
