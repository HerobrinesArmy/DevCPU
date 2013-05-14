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
		//TODO Consider using different tokens for Assembler vs Preprocessor directives.
		//That way, you can give them different visual styles to encourage people to think
		//about the distinction. It would also make it possible to lex them differently
		//depending on what's using the lexer (code editor vs assembler). Example Scenario:
		//Assembler doesn't use the "PreprocessorDirectiveMatcher", making it slightly
		//faster and allowing it to error differently, not having to check for unknown
		//directives while assembling.
		
		//Preprocessor
		allowedDirectives.add("include");
		allowedDirectives.add("import");
		allowedDirectives.add("macro");
		allowedDirectives.add("define");
		allowedDirectives.add("def");
		allowedDirectives.add("equ");
		allowedDirectives.add("undef");
		allowedDirectives.add("ifdef");
		allowedDirectives.add("ifndef");
//		allowedDirectives.add("if");
//		allowedDirectives.add("elif");
//		allowedDirectives.add("elseif");
		allowedDirectives.add("else");
		allowedDirectives.add("endif");
		
		//Assembler
		allowedDirectives.add("origin");
		allowedDirectives.add("org");
		allowedDirectives.add("align");
		allowedDirectives.add("reserve");
		allowedDirectives.add("fill");
		allowedDirectives.add("pad");
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
		return matcher;
	}
}
