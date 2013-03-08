package devcpu.lexer.matchers;

import java.util.ArrayList;
import java.util.List;

import devcpu.lexer.MatcherResult;
import devcpu.lexer.StandardResult;

public class DirectiveMatcher implements LexerTokenMatcher {
	private static DirectiveMatcher matcher = new DirectiveMatcher();
	
	@Override
	public List<LexerTokenMatcher> getFollowTokenMatchers() {
		ArrayList<LexerTokenMatcher> followTokenMatchers = new ArrayList<LexerTokenMatcher>();
		followTokenMatchers.add(CommentMatcher.get());
		followTokenMatchers.add(EndOfLineMatcher.get());
		return followTokenMatchers;
	}

	@Override
	public MatcherResult match(String text, int offset, int lineOffset) {
		// TODO Auto-generated method stub
		return new StandardResult(false, null, offset, this);
	}
	
	public static DirectiveMatcher get() {
		return matcher ;
	}
}
