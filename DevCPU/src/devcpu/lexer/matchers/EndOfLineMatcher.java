package devcpu.lexer.matchers;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import devcpu.lexer.MatcherResult;
import devcpu.lexer.StandardResult;
import devcpu.lexer.tokens.EndOfLineToken;
import devcpu.lexer.tokens.LexerToken;

public class EndOfLineMatcher implements LexerTokenMatcher {
	private static EndOfLineMatcher matcher = new EndOfLineMatcher();
	private Pattern pattern = Pattern.compile("\\s*\\r?(\\n|\\z)");
	
	@Override
	public List<LexerTokenMatcher> getFollowTokenMatchers() {	
		return new ArrayList<LexerTokenMatcher>();
	}

	@Override
	public MatcherResult match(String text, int offset, int lineOffset) {
		StandardResult result = null;
		Matcher m = pattern.matcher(text.substring(offset));
		if (m.find() && m.start() == 0) {
			LexerToken token = new EndOfLineToken(m.group(), lineOffset + offset, lineOffset + offset + m.end());
			result = new StandardResult(true, new LexerToken[]{token}, offset + m.end(), this);
		} else {
			result = new StandardResult(false, null, offset, this);
		}
		return result;
	}
	
	public static EndOfLineMatcher get() {
		return matcher ;
	}
}
