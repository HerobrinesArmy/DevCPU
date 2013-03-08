package devcpu.lexer.matchers;

import java.util.ArrayList;
import java.util.List;

import devcpu.lexer.MatcherResult;
import devcpu.lexer.StandardResult;

public class DataLineMatcher implements LexerTokenMatcher {
	private static DataLineMatcher matcher = new DataLineMatcher();
	
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
	
	public static DataLineMatcher get() {
		return matcher ;
	}
}
