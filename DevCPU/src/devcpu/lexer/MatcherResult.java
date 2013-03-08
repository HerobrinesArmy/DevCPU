package devcpu.lexer;

import devcpu.lexer.matchers.LexerTokenMatcher;
import devcpu.lexer.tokens.LexerToken;

public interface MatcherResult {
	public boolean matched();
//	public String getRemainingText();
	public int getEndOffset();
	public LexerToken[] getTokens();
	public LexerTokenMatcher getMatcher();
}
