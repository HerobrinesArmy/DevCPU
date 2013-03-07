package devcpu.lexer;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class OperatorMatcher implements LexerTokenMatcher {
	//TODO Add more operators
	private Pattern pattern = Pattern.compile("\\s*(\\+|\\-|\\/|\\*)");
	private static OperatorMatcher matcher = new OperatorMatcher();
	
	@Override
	public List<LexerTokenMatcher> getFollowTokenMatchers() {
		ArrayList<LexerTokenMatcher> followTokenMatchers = new ArrayList<LexerTokenMatcher>();
		//TODO?
		return followTokenMatchers;
	}

	@Override
	public MatcherResult match(String text, int offset, int lineOffset) {
		String s = text.substring(offset);
		Matcher m = pattern.matcher(s);
		if (m.find() && m.start() == 0) {
			String match = m.group();
			OperatorToken token = new OperatorToken(match, lineOffset + offset, lineOffset + offset + m.end());
			return new StandardResult(true, new LexerToken[]{token}, offset + m.end(), this);
		}
		return new StandardResult(false, null, offset, this);
	}
	
	public static OperatorMatcher get() {
		return matcher ;
	}
}
