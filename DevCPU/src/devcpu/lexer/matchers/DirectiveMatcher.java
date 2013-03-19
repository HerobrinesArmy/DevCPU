package devcpu.lexer.matchers;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import devcpu.lexer.Lexer;
import devcpu.lexer.MatcherResult;
import devcpu.lexer.StandardResult;
import devcpu.lexer.tokens.DirectiveToken;
import devcpu.lexer.tokens.LexerToken;

public class DirectiveMatcher implements LexerTokenMatcher {
	private static DirectiveMatcher matcher = new DirectiveMatcher();
	private Pattern pattern = Pattern.compile("\\s*[\\.#]("+ Lexer.REGEX_IDENTIFIER +")\\b[\\s\\,]*", Pattern.CASE_INSENSITIVE);
	private ArrayList<String> allowedDirectives = new ArrayList<String>();
	{
		allowedDirectives.add("include");
		allowedDirectives.add("import");
		allowedDirectives.add("define");
		allowedDirectives.add("origin");
		allowedDirectives.add("org");
		allowedDirectives.add("align");
		allowedDirectives.add("reserve");
		allowedDirectives.add("fill");
	}
	
	@Override
	public List<LexerTokenMatcher> getFollowTokenMatchers() {
		ArrayList<LexerTokenMatcher> followTokenMatchers = new ArrayList<LexerTokenMatcher>();
		followTokenMatchers.add(DirectiveParametersMatcher.get());
		return followTokenMatchers;
	}
	
	@Override
	public MatcherResult match(String text, int offset, int lineOffset) {
		String s = text.substring(offset);
		Matcher m = pattern.matcher(s);
		if (m.find() && m.start() == 0) {
			String match = m.group();
			String name = m.group(1);
			for (String allowed : allowedDirectives) {
				if (allowed.equalsIgnoreCase(name)) {
					LexerToken token = new DirectiveToken(match, lineOffset + offset, lineOffset + offset + m.end());
					return new StandardResult(true, new LexerToken[]{token}, offset + m.end(), this);
				}
			}
		}
		return new StandardResult(false, null, offset, this);
	}
	
	public static DirectiveMatcher get() {
		return matcher ;
	}
}
