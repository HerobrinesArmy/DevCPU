package devcpu.lexer;

import java.util.ArrayList;
import java.util.List;

public class InstructionMatcher implements LexerTokenMatcher {
	private static InstructionMatcher matcher = new InstructionMatcher();
	
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
	
	public static InstructionMatcher get() {
		return matcher ;
	}
}
