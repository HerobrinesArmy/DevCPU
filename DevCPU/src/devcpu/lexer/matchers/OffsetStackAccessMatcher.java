package devcpu.lexer.matchers;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import devcpu.lexer.MatcherResult;
import devcpu.lexer.StandardResult;
import devcpu.lexer.tokens.LexerToken;
import devcpu.lexer.tokens.OffsetStackAccessToken;
import devcpu.lexer.tokens.PickValueEndToken;
import devcpu.lexer.tokens.PickValueStartToken;

public class OffsetStackAccessMatcher implements LexerTokenMatcher {
	//TODO Try somehow to catch [sp+literal] here too, in its many expression forms??
	//Otherwise, you'll need to look for it in values with address roots when you assemble.
	private Pattern pattern = Pattern.compile("\\s*pick\\b",Pattern.CASE_INSENSITIVE);
	private static OffsetStackAccessMatcher matcher = new OffsetStackAccessMatcher();
	private List<LexerTokenMatcher> matchers = new ArrayList<LexerTokenMatcher>();
	{
		matchers.add(ExpressionMatcher.get());
	}
	
	@Override
	public List<LexerTokenMatcher> getFollowTokenMatchers() {
		ArrayList<LexerTokenMatcher> followTokenMatchers = new ArrayList<LexerTokenMatcher>();
		followTokenMatchers.add(TrueMatcher.get());
		return followTokenMatchers;
	}

	@Override
	public MatcherResult match(String text, int offset, int lineOffset) {
		String s = text.substring(offset);
		Matcher m = pattern.matcher(s);
		if (m.find() && m.start() == 0) {
			ArrayList<LexerToken> tokens = new ArrayList<LexerToken>();
			tokens.add(new OffsetStackAccessToken(m.group(), lineOffset + offset, lineOffset + offset + m.end()));
			offset += m.end();
			ArrayList<MatcherResult> results = getTokens(text, offset, lineOffset, matchers);
			if (results == null) {
				return new StandardResult(false, null, offset, this);
			} else {
				tokens.add(new PickValueStartToken("", offset, offset));
				int endOffset = offset;
				for (MatcherResult r : results) {
					endOffset = r.getEndOffset();
					for (LexerToken token : r.getTokens()) {
						tokens.add(token);
					}
				}
				tokens.add(new PickValueEndToken("", endOffset, endOffset));
				return new StandardResult(true, tokens.toArray(new LexerToken[0]), endOffset, this);
			}
		}
		return new StandardResult(false, null, offset, this);
	}
	
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
	
	public static OffsetStackAccessMatcher get() {
		return matcher ;
	}
}
