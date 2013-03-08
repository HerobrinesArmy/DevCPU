package devcpu.lexer.matchers;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import devcpu.emulation.OpCodes;
import devcpu.lexer.MatcherResult;
import devcpu.lexer.StandardResult;
import devcpu.lexer.tokens.BasicOpCodeToken;
import devcpu.lexer.tokens.LexerToken;

public class BasicOpCodeMatcher implements LexerTokenMatcher {
	private Pattern pattern = Pattern.compile("\\s*[a-zA-Z]{3}\\b");
	private static BasicOpCodeMatcher matcher = new BasicOpCodeMatcher();
	
	@Override
	public List<LexerTokenMatcher> getFollowTokenMatchers() {
		ArrayList<LexerTokenMatcher> followTokenMatchers = new ArrayList<LexerTokenMatcher>();
		followTokenMatchers.add(BValueMatcher.get());
		return followTokenMatchers;
	}

	@Override
	public MatcherResult match(String text, int offset, int lineOffset) {
		String s = text.substring(offset);
		Matcher m = pattern.matcher(s);
		if (m.find() && m.start() == 0) {
			String match = m.group();
			String word = match.trim();
			for (String mnemonic : OpCodes.basic.getNames()) {
				if (mnemonic.equalsIgnoreCase(word)) {
					BasicOpCodeToken token = new BasicOpCodeToken(match, lineOffset + offset, lineOffset + offset + m.end());
					return new StandardResult(true, new LexerToken[]{token}, offset + m.end(), this);
				}
			}
		}
		return new StandardResult(false, null, offset, this);
	}
	
	public static BasicOpCodeMatcher get() {
		return matcher ;
	}
}
