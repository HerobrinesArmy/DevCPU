package devcpu.lexer.tokens;

import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.RGB;

import devcpu.assembler.LabelDefinition;
import devcpu.editors.dasm.DASMColorProvider;

public class LabelDefinitionToken extends TrimmedLexerToken{
	public static final Color FOREGROUND = DASMColorProvider.get().getColor(new RGB(0, 0, 127));
	public static final Color BACKGROUND = DASMColorProvider.get().getColor(new RGB(255, 255, 255));
	private String name;
	private boolean local;
	public LabelDefinition labelDef;

	public LabelDefinitionToken(String text, int start, int end) {
		super(text, start, end);
		if (this.text.startsWith(":")) {
			name = this.text.substring(1);
		} else {
			name = this.text.substring(0,this.text.length()-1);
		}
		if (name.startsWith(".")) {
			local = true;
		}
	}

	@Override
	public String getType() {
		return "DASM_LABEL_DEFINITION";
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
	
	public String getName() {
		return name;
	}
}
