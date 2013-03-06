package devcpu.lexer;

import java.util.ArrayList;
import java.util.List;

public class TrueMatcher implements LexerTokenMatcher {
	private static TrueMatcher matcher = new TrueMatcher();
	
	@Override
	public List<LexerTokenMatcher> getFollowTokenMatchers() {	
		return new ArrayList<LexerTokenMatcher>();
	}

	@Override
	public MatcherResult match(String text, int offset, int lineOffset) {
		LexerToken token = new TrueToken("", lineOffset + offset, lineOffset + offset);
		return new StandardResult(true, new LexerToken[]{token}, offset, this);
	}
	
	public static TrueMatcher get() {
		return matcher ;
	}
}
