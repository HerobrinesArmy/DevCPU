package devcpu.lexer;

import devcpu.lexer.matchers.LexerTokenMatcher;
import devcpu.lexer.tokens.LexerToken;

public class StandardResult implements MatcherResult {
	private boolean matched;
//	private String remainingText;
	private LexerToken[] tokens;
	private LexerTokenMatcher matcher;
	private int endOffset;

	public StandardResult(boolean matched, LexerToken[] tokens, int endOffset, LexerTokenMatcher matcher) {
		this.matched = matched;
//		this.remainingText = remainingText;
		this.tokens = tokens;
		this.endOffset = endOffset;
		this.matcher = matcher;
	}

	@Override
	public boolean matched() {
		return matched;
	}

//	@Override
//	public String getRemainingText() {
//		return remainingText;
//	}

	@Override
	public LexerToken[] getTokens() {
		return tokens;
	}

	@Override
	public LexerTokenMatcher getMatcher() {
		return matcher;
	}

	@Override
	public int getEndOffset() {
		return endOffset;
	}
}
