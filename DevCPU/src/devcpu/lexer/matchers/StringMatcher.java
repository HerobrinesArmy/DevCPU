package devcpu.lexer.matchers;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import devcpu.lexer.Lexer;
import devcpu.lexer.MatcherResult;
import devcpu.lexer.StandardResult;
import devcpu.lexer.tokens.LexerToken;
import devcpu.lexer.tokens.StringToken;

public class StringMatcher implements LexerTokenMatcher {
	private static StringMatcher matcher = new StringMatcher();
	private Pattern pattern = Pattern.compile(Lexer.REGEX_STRING);
	
	@Override
	public List<LexerTokenMatcher> getFollowTokenMatchers() {
		ArrayList<LexerTokenMatcher> followTokenMatchers = new ArrayList<LexerTokenMatcher>();
		followTokenMatchers.add(TrueMatcher.get());
		return followTokenMatchers;
	}

	@Override
	public MatcherResult match(String text, int offset, int lineOffset) {
		StandardResult result = null;
		Matcher m = pattern.matcher(text.substring(offset));
		if (m.find() && m.start() == 0) {
			LexerToken token = new StringToken(m.group(), lineOffset + offset, lineOffset + offset + m.end());
			result = new StandardResult(true, new LexerToken[]{token}, offset + m.end(), this);
		} else {
			result = new StandardResult(false, null, offset, this);
		}
		return result;
	}
	
	public static StringMatcher get() {
		return matcher ;
	}
}
