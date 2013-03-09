package devcpu.lexer.matchers;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import devcpu.lexer.Lexer;
import devcpu.lexer.MatcherResult;
import devcpu.lexer.StandardResult;
import devcpu.lexer.tokens.LabelDefinitionToken;
import devcpu.lexer.tokens.LexerToken;

public class LabelDefinitionMatcher implements LexerTokenMatcher {
	private static LabelDefinitionMatcher matcher = new LabelDefinitionMatcher();
	private Pattern pattern = Pattern.compile("\\s*(\\:("+Lexer.REGEX_IDENTIFIER+")|("+Lexer.REGEX_IDENTIFIER+")\\:)");
	
	@Override
	public List<LexerTokenMatcher> getFollowTokenMatchers() {	
		ArrayList<LexerTokenMatcher> followTokenMatchers = new ArrayList<LexerTokenMatcher>();
		followTokenMatchers.add(LabelDefinitionMatcher.get());
		followTokenMatchers.add(CommentMatcher.get());
		followTokenMatchers.add(EndOfLineMatcher.get());
		followTokenMatchers.add(SpecialOpCodeMatcher.get());
		followTokenMatchers.add(BasicOpCodeMatcher.get());
		followTokenMatchers.add(DataMatcher.get());
		return followTokenMatchers;
	}

	@Override
	public MatcherResult match(String text, int offset, int lineOffset) {
		StandardResult result = null;
		String s = text.substring(offset);
		Matcher m = pattern.matcher(s);
		if (m.find() && m.start() == 0) {
			String match = m.group(); //TODO check for label name group
			LabelDefinitionToken token = new LabelDefinitionToken(match, lineOffset + offset, lineOffset + offset + m.end());
			result = new StandardResult(true, new LexerToken[]{token}, offset + m.end(), this);
		} else {
			result = new StandardResult(false, null, offset, this);
		}
		return result;
	}

	public static LabelDefinitionMatcher get() {
		return matcher ;
	}
}
