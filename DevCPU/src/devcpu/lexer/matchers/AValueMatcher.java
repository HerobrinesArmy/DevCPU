package devcpu.lexer.matchers;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import devcpu.lexer.MatcherResult;
import devcpu.lexer.StandardResult;
import devcpu.lexer.tokens.AValueEndToken;
import devcpu.lexer.tokens.AValueStartToken;
import devcpu.lexer.tokens.LexerToken;

public class AValueMatcher implements LexerTokenMatcher {
	private static AValueMatcher matcher = new AValueMatcher();
	private Pattern ignoredSeparators = Pattern.compile("[\\s\\,]*");
	private List<LexerTokenMatcher> matchers = new ArrayList<LexerTokenMatcher>();
	{
		matchers.add(ASimpleStackAccessMatcher.get());
		matchers.add(OffsetStackAccessMatcher.get());
		matchers.add(AddressMatcher.get());
		matchers.add(ExpressionMatcher.get());
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
		String s = text.substring(offset);
		Matcher m = ignoredSeparators.matcher(s);
		if (m.find() && m.start() == 0) {
			offset += m.end();
		}
		ArrayList<MatcherResult> results = getTokens(text, offset, lineOffset, matchers);
		if (results == null) {
			return new StandardResult(false, null, offset, this);
		} else {
			ArrayList<LexerToken> tokens = new ArrayList<LexerToken>();
			tokens.add(new AValueStartToken("", offset, offset));
			int endOffset = offset;
			for (MatcherResult r : results) {
				endOffset = r.getEndOffset();
				for (LexerToken token : r.getTokens()) {
					tokens.add(token);
				}
			}
			tokens.add(new AValueEndToken("", endOffset, endOffset));
			return new StandardResult(true, tokens.toArray(new LexerToken[0]), endOffset, this);
		}
	}
	
	//TODO super test
	private ArrayList<MatcherResult> getTokens(String text, int offset, int lineOffset, List<LexerTokenMatcher> matchers) {
		ArrayList<MatcherResult> matchResults = new ArrayList<MatcherResult>();
		for (LexerTokenMatcher ltm : matchers) {
			MatcherResult result = ltm.match(text, offset, lineOffset);
			if (result.matched()) {
				if (result.getMatcher() instanceof TrueMatcher) {
					matchResults.add(result);
					return matchResults;
				} else {
					ArrayList<MatcherResult> r = getTokens(text, result.getEndOffset(), lineOffset, result.getMatcher().getFollowTokenMatchers());
					if (r != null) {
						matchResults.add(result);
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
