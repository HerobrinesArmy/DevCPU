package devcpu.lexer;

public interface BoundableLexerTokenMatcher extends LexerTokenMatcher {
	public MatcherResult match(String text, int startOffset, int endOffset, int lineOffset);
}
