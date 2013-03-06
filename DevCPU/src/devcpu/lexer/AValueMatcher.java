package devcpu.lexer;

import java.util.ArrayList;
import java.util.List;

public class AValueMatcher implements LexerTokenMatcher {
	private static AValueMatcher matcher = new AValueMatcher();
	private static List<LexerTokenMatcher> matchers = new ArrayList<LexerTokenMatcher>();
	{
		matchers.add(LiteralMatcher.get());
	}
	
	@Override
	public List<LexerTokenMatcher> getFollowTokenMatchers() {
		ArrayList<LexerTokenMatcher> followTokenMatchers = new ArrayList<LexerTokenMatcher>();
		//TODO
		followTokenMatchers.add(CommentMatcher.get());
		followTokenMatchers.add(EndOfLineMatcher.get());
		return followTokenMatchers;
	}

	@Override
	public MatcherResult match(String text, int offset, int lineOffset) {
		ArrayList<MatcherResult> results = getTokens(text, offset, lineOffset, matchers);
		if (results == null) {
			return new StandardResult(false, null, offset, this);
		} else {
			ArrayList<LexerToken> tokens = new ArrayList<LexerToken>();
			int endOffset = offset;
			for (MatcherResult r : results) {
				endOffset = r.getEndOffset();
				for (LexerToken token : r.getTokens()) {
					tokens.add(token);
				}
			}
			return new StandardResult(true, (LexerToken[]) tokens.toArray(), endOffset, this);
		}
	}
	
	//TODO super test
	private ArrayList<MatcherResult> getTokens(String text, int offset, int lineOffset, List<LexerTokenMatcher> matchers) {
		ArrayList<MatcherResult> matchResults = new ArrayList<MatcherResult>();
		for (LexerTokenMatcher ltm : matchers) {
			MatcherResult result = ltm.match(text, offset, lineOffset);
			if (result.matched()) {
				if (result.getEndOffset() == text.length() && matchResults.get(matchResults.size()-1).getMatcher() instanceof TrueMatcher) {
					matchResults.add(result);
					return matchResults;
				} else {
					ArrayList<MatcherResult> r = getTokens(text, result.getEndOffset(), lineOffset, result.getMatcher().getFollowTokenMatchers());
					if (r != null) {
						matchResults.addAll(r);
						if (matchResults.get(matchResults.size()-1).getMatcher() instanceof TrueMatcher) {
							return matchResults;
						}
					}
				}
			}
			matchResults.clear();
		}
		return null;
	}
	public static AValueMatcher get() {
		return matcher ;
	}
}
