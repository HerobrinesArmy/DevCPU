package devcpu.lexer;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import devcpu.emulation.OpCodes;

public class SpecialOpCodeMatcher implements LexerTokenMatcher {
	private Pattern pattern = Pattern.compile("\\s*[a-zA-Z]{3}\\b");
	private static SpecialOpCodeMatcher matcher = new SpecialOpCodeMatcher();
	
	@Override
	public List<LexerTokenMatcher> getFollowTokenMatchers() {
		ArrayList<LexerTokenMatcher> followTokenMatchers = new ArrayList<LexerTokenMatcher>();
		followTokenMatchers.add(AValueMatcher.get());
		return followTokenMatchers;
	}

	@Override
	public MatcherResult match(String text, int offset, int lineOffset) {
		String s = text.substring(offset);
		Matcher m = pattern.matcher(s);
		if (m.find() && m.start() == 0) {
			String match = m.group();
			String word = match.trim();
			for (String mnemonic : OpCodes.special.getNames()) {
				if (mnemonic.equalsIgnoreCase(word)) {
					SpecialOpCodeToken token = new SpecialOpCodeToken(match, lineOffset + offset, lineOffset + offset + m.end());
					return new StandardResult(true, new LexerToken[]{token}, offset + m.end(), this);
				}
			}
		}
		return new StandardResult(false, null, offset, this);
	}
	
	public static SpecialOpCodeMatcher get() {
		return matcher ;
	}
}
