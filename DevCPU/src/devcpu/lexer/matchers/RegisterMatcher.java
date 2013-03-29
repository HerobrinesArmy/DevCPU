package devcpu.lexer.matchers;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import devcpu.lexer.MatcherResult;
import devcpu.lexer.StandardResult;
import devcpu.lexer.tokens.LexerToken;
import devcpu.lexer.tokens.RegisterToken;

public class RegisterMatcher implements LexerTokenMatcher {
	private static RegisterMatcher matcher = new RegisterMatcher();
	private Pattern pattern = Pattern.compile("\\s*([a-cijx-z]|sp|pc|ex)\\b",Pattern.CASE_INSENSITIVE);	
	@Override
	public List<LexerTokenMatcher> getFollowTokenMatchers() {
		//TODO Might need context tree
		ArrayList<LexerTokenMatcher> followTokenMatchers = new ArrayList<LexerTokenMatcher>();
		followTokenMatchers.add(TrueMatcher.get());
		return followTokenMatchers;
	}

	@Override
	public MatcherResult match(String text, int offset, int lineOffset) {
		String s = text.substring(offset);
		Matcher m = pattern.matcher(s);
		if (m.find() && m.start() == 0) {
			String match = m.group();
			RegisterToken token = new RegisterToken(match, lineOffset + offset, lineOffset + offset + m.end());
			return new StandardResult(true, new LexerToken[]{token}, offset + m.end(), this);
		}
		return new StandardResult(false, null, offset, this);
	}

	public static RegisterMatcher get() {
		return matcher ;
	}
}
