package devcpu.lexer.matchers;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import devcpu.lexer.Lexer;
import devcpu.lexer.MatcherResult;
import devcpu.lexer.StandardResult;
import devcpu.lexer.tokens.LabelToken;
import devcpu.lexer.tokens.LexerToken;

public class LabelMatcher implements LexerTokenMatcher {
	private static LabelMatcher matcher = new LabelMatcher();
	private Pattern pattern = Pattern.compile("\\s*("+Lexer.REGEX_IDENTIFIER+"|\\."+Lexer.REGEX_IDENTIFIER+")");
	
	@Override
	public List<LexerTokenMatcher> getFollowTokenMatchers() {	
		ArrayList<LexerTokenMatcher> followTokenMatchers = new ArrayList<LexerTokenMatcher>();
		followTokenMatchers.add(TrueMatcher.get());
		return followTokenMatchers;
	}

	@Override
	public MatcherResult match(String text, int offset, int lineOffset) {
		StandardResult result = null;
		String s = text.substring(offset);
		Matcher m = pattern.matcher(s);
		if (m.find() && m.start() == 0) {
			String match = m.group(); //TODO check for label name group
			LabelToken token = new LabelToken(match, lineOffset + offset, lineOffset + offset + m.end());
			result = new StandardResult(true, new LexerToken[]{token}, offset + m.end(), this);
		} else {
			result = new StandardResult(false, null, offset, this);
		}
		return result;
	}

	public static LabelMatcher get() {
		return matcher ;
	}
}
