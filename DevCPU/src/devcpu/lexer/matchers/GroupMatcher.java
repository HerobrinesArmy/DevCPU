package devcpu.lexer.matchers;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import devcpu.lexer.MatcherResult;
import devcpu.lexer.StandardResult;
import devcpu.lexer.tokens.GroupEndToken;
import devcpu.lexer.tokens.GroupStartToken;
import devcpu.lexer.tokens.LexerToken;

public class GroupMatcher implements LexerTokenMatcher {
	private static GroupMatcher matcher = new GroupMatcher();
	private Pattern pattern = Pattern.compile("\\s*(\\()\\s*([^;,]*)(\\))");
	
	@Override
	public List<LexerTokenMatcher> getFollowTokenMatchers() {
		//TODO Add other follow cases
		ArrayList<LexerTokenMatcher> followTokenMatchers = new ArrayList<LexerTokenMatcher>();
		followTokenMatchers.add(OperatorMatcher.get());
		followTokenMatchers.add(TrueMatcher.get());
		return followTokenMatchers;
	}

	@Override
	public MatcherResult match(String text, int offset, int lineOffset) {
		String s = text.substring(offset);
		Matcher m = pattern.matcher(s);
		if (m.find() && m.start() == 0) {
			int mend = getRealGroupEnd(s);
			if (mend > 1) {
				int resultOffset = offset + mend;
				ArrayList<LexerToken> tokens = new ArrayList<LexerToken>();
				tokens.add(new GroupStartToken(m.group(1), lineOffset + offset + m.start(1), lineOffset + offset + m.end(1)));
//				GroupEndToken endToken = new GroupEndToken(m.group(3), lineOffset + offset + mend - 1, lineOffset + offset + mend);
				//I heard comments help you remember how your code works, so here's a comment.
	//			for (BoundableLexerTokenMatcher matcher : innerMatchers) {
					MatcherResult result = ExpressionMatcher.get().match(text, offset + m.start(2), offset + mend - 1, lineOffset);
					if (result.matched()) {
						for (LexerToken token : result.getTokens()) {
							tokens.add(token);
						}
						s = text.substring(result.getEndOffset());
						m = Pattern.compile("\\s*\\)").matcher(s);
						if (m.find() && m.start() == 0) {
//						if (text.substring(result.getEndOffset(), mend-1).trim().length() == 0) {
							GroupEndToken endToken = new GroupEndToken(m.group(), lineOffset + result.getEndOffset(), lineOffset + result.getEndOffset() + m.end());
							tokens.add(endToken);
							return new StandardResult(true, tokens.toArray(new LexerToken[0]), resultOffset, this);
						}
					}
	//			}
			}
		}
		return new StandardResult(false, null, offset, this);
	}

	private int getRealGroupEnd(String s) {
		char[] chars = s.toCharArray();
		int j = 0;
		for (int i = 0; i < chars.length; i++) {
			if (chars[i] == '(') {
				j++;
			} else if (chars[i] ==')') {
				if (--j == 0) {
					return i+1;
				}
			}
		}
		return -1;
	}

	public static GroupMatcher get() {
		return matcher ;
	}
}
