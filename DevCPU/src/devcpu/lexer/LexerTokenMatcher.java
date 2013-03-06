package devcpu.lexer;

import java.util.List;

public interface LexerTokenMatcher {
	public List<LexerTokenMatcher> getFollowTokenMatchers(); 
	
	public MatcherResult match(String text, int offset, int lineOffset);
}
