package devcpu.lexer.matchers;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import devcpu.lexer.MatcherResult;
import devcpu.lexer.StandardResult;
import devcpu.lexer.tokens.AddressEndToken;
import devcpu.lexer.tokens.AddressStartToken;
import devcpu.lexer.tokens.LexerToken;

public class AddressMatcher implements LexerTokenMatcher {
	private static AddressMatcher matcher = new AddressMatcher();
	private Pattern pattern = Pattern.compile("\\s*(\\[)\\s*([^\\];]+)\\s*(\\])");
	private List<BoundableLexerTokenMatcher> innerMatchers = new ArrayList<BoundableLexerTokenMatcher>();
	{
		innerMatchers.add(ExpressionMatcher.get());
	}
	
	@Override
	public List<LexerTokenMatcher> getFollowTokenMatchers() {
		//TODO Add other follow cases
		ArrayList<LexerTokenMatcher> followTokenMatchers = new ArrayList<LexerTokenMatcher>();
		followTokenMatchers.add(TrueMatcher.get());
		return followTokenMatchers;
	}

	@Override
	public MatcherResult match(String text, int offset, int lineOffset) {
		String s = text.substring(offset);
		Matcher m = pattern.matcher(s);
		if (m.find() && m.start() == 0) {
			int resultOffset = offset + m.end();
			String inner = m.group(2);
			ArrayList<LexerToken> tokens = new ArrayList<LexerToken>();
			tokens.add(new AddressStartToken(m.group(1), lineOffset + offset + m.start(1), lineOffset + offset + m.end(1)));
			AddressEndToken endToken = new AddressEndToken(m.group(3), lineOffset + offset + m.start(3), lineOffset + offset + m.end(3));
			//I heard comments help you remember how your code works, so here's a comment.
			for (BoundableLexerTokenMatcher matcher : innerMatchers) {
				MatcherResult result = matcher.match(text, offset+m.start(2), offset+m.end(2), lineOffset);
				if (result.matched()) {
					for (LexerToken token : result.getTokens()) {
						tokens.add(token);
					}
					//TODO check for anything between the end of the last token and the ']'
					//Fail if non-whitespace found
					tokens.add(endToken);
					return new StandardResult(true, tokens.toArray(new LexerToken[0]), resultOffset, this);
				}
			}
		}
		return new StandardResult(false, null, offset, this);
	}

	public static AddressMatcher get() {
		return matcher ;
	}
}
