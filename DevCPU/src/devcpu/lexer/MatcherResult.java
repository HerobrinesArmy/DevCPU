package devcpu.lexer;

public interface MatcherResult {
	public boolean matched();
//	public String getRemainingText();
	public int getEndOffset();
	public LexerToken[] getTokens();
	public LexerTokenMatcher getMatcher();
}
