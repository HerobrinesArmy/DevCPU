package devcpu.lexer.matchers;

import devcpu.lexer.MatcherResult;

public interface BoundableLexerTokenMatcher extends LexerTokenMatcher {
	public MatcherResult match(String text, int startOffset, int endOffset, int lineOffset);
}
