package devcpu.lexer.matchers;

import java.util.List;

import devcpu.lexer.MatcherResult;

public interface LexerTokenMatcher {
	public List<LexerTokenMatcher> getFollowTokenMatchers(); 
	
	public MatcherResult match(String text, int offset, int lineOffset);
}
