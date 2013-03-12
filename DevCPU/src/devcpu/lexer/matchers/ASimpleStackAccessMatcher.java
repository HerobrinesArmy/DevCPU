package devcpu.lexer.matchers;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import devcpu.lexer.MatcherResult;
import devcpu.lexer.StandardResult;
import devcpu.lexer.tokens.LexerToken;
import devcpu.lexer.tokens.SimpleStackAccessToken;

public class ASimpleStackAccessMatcher implements LexerTokenMatcher {
	private Pattern pattern = Pattern.compile("\\s*(pop|peek|\\[\\s*(sp|\\-\\-\\s*sp)\\s*\\])",Pattern.CASE_INSENSITIVE);
	private static ASimpleStackAccessMatcher matcher = new ASimpleStackAccessMatcher();
	
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
			SimpleStackAccessToken token = new SimpleStackAccessToken(m.group(), lineOffset + offset, lineOffset + offset + m.end());
			return new StandardResult(true, new LexerToken[]{token}, offset + m.end(), this);
		}
		return new StandardResult(false, null, offset, this);
	}
	
	public static ASimpleStackAccessMatcher get() {
		return matcher ;
	}
}
