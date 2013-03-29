package devcpu.lexer.tokens;

import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.RGB;

import devcpu.assembler.Assembly;
import devcpu.assembler.AssemblyLine;
import devcpu.editors.dasm.DASMColorProvider;

public class LabelToken extends TrimmedLexerToken{
	public static final Color FOREGROUND = DASMColorProvider.get().getColor(new RGB(0, 0, 0));
	public static final Color BACKGROUND = DASMColorProvider.get().getColor(new RGB(255, 255, 255));
	private boolean local;
	public String labelName;
	public int value;
	public boolean valueSet;
	public AssemblyLine lineRef;

	public LabelToken(String text, int start, int end) {
		super(text, start, end);
		if (this.text.startsWith(".")) {
			local = true;
		}
		if (Assembly.labelsCaseSensitive) {
			this.labelName = this.text;
		} else {
			this.labelName = this.text.toUpperCase();
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

//	public void setValue(int value) {
//		this.value = value;
//	}
//	
//	public int getValue() {
//		return value;
//	}
}
