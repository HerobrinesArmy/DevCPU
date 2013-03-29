package devcpu.lexer.tokens;

import org.eclipse.jface.text.ITypedRegion;
import org.eclipse.jface.text.rules.IToken;

public abstract class LexerToken implements ITypedRegion, IToken {
	public abstract String getText();
	public abstract int getStart();
	public abstract int getEnd();
	public abstract int getLength();
}
