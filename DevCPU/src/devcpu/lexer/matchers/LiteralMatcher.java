package devcpu.lexer.matchers;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import devcpu.lexer.Lexer;
import devcpu.lexer.MatcherResult;
import devcpu.lexer.StandardResult;
import devcpu.lexer.tokens.LexerToken;
import devcpu.lexer.tokens.LiteralToken;

public class LiteralMatcher implements LexerTokenMatcher {
	private static LiteralMatcher matcher = new LiteralMatcher();
	private List<Pattern> patterns = new ArrayList<Pattern>();
	{
		patterns.add(Pattern.compile("\\s*"+Lexer.REGEX_HEXADECIMAL_VALUE));
		patterns.add(Pattern.compile("\\s*"+Lexer.REGEX_DECIMAL_VALUE));
		patterns.add(Pattern.compile("\\s*"+Lexer.REGEX_BINARY_VALUE));
		patterns.add(Pattern.compile("\\s*"+Lexer.REGEX_CHARACTER_VALUE));
	}
	
	@Override
	public List<LexerTokenMatcher> getFollowTokenMatchers() {
		ArrayList<LexerTokenMatcher> followTokenMatchers = new ArrayList<LexerTokenMatcher>();
		followTokenMatchers.add(TrueMatcher.get());
		return followTokenMatchers;
	}

	@Override //TODO make this work
	public MatcherResult match(String text, int offset, int lineOffset) {
		String s = text.substring(offset);
		for (Pattern pattern : patterns) {
			Matcher m = pattern.matcher(s);
			if (m.find() && m.start() == 0) {
				String match = m.group();
				LiteralToken token = new LiteralToken(match, lineOffset + offset, lineOffset + offset + m.end());
				return new StandardResult(true, new LexerToken[]{token}, offset + m.end(), this);
			}
		}
		return new StandardResult(false, null, offset, this);
	}

	public static LiteralMatcher get() {
		return matcher ;
	}
}
