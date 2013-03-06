package devcpu.lexer;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

public class Lexer {
	public static final String REGEX_IDENTIFIER = "\\b[a-zA-Z_][a-zA-Z_0-9]*\\b";
	public static final String REGEX_HEXADECIMAL_VALUE = "\\b0x[0-9A-Fa-f]{1,4}\\b";
	public static final String REGEX_BINARY_VALUE = "\\b0b[01]{1,16}\\b";
	public static final String REGEX_DECIMAL_VALUE = "\\b\\-?[0-9]{1,5}\\b";
	
	private static Lexer lexer = new Lexer();
	private ArrayList<LexerTokenMatcher> initialTokenMatchers = new ArrayList<LexerTokenMatcher>();
	{
		initialTokenMatchers.add(LabelDefinitionMatcher.get());
		initialTokenMatchers.add(CommentMatcher.get());
		initialTokenMatchers.add(EndOfLineMatcher.get());
		initialTokenMatchers.add(DirectiveMatcher.get());
		initialTokenMatchers.add(InstructionMatcher.get());
		initialTokenMatchers.add(DataLineMatcher.get());
	}
	
	public LexerToken[] generateTokens(String text) {
		ArrayList<LexerToken> tokens = new ArrayList<LexerToken>();
		String[] lines = text.split("\\n");
		int lineOffset = 0;
		for (String line : lines) {
			//TODO Just in case you turn stupid, don't forget that these offsets are currently reset per line
			ArrayList<LexerToken> lineTokens = getTokens(line, 0, lineOffset, initialTokenMatchers);
			if (lineTokens == null) {
				tokens.add(new ErrorToken(line, lineOffset, lineOffset + line.length()));
			} else {
				tokens.addAll(lineTokens);
			}
			lineOffset += line.length() + 1;
		}
		return tokens.toArray(new LexerToken[0]);
	}
	
	//TODO Depending on how you move forward with this, you may need to rewrite the recursion out of this
	//You also might want to write this a way that doesn't suck, but we'll see how well that goes.
	private ArrayList<LexerToken> getTokens(String text, int offset, int lineOffset, List<LexerTokenMatcher> matchers) {
		ArrayList<LexerToken> tokens = new ArrayList<LexerToken>();
		for (LexerTokenMatcher ltm : matchers) {
			MatcherResult result = ltm.match(text, offset, lineOffset);
			if (result.matched()) {
				for (LexerToken token : result.getTokens()) {
					tokens.add(token);
				}
				if (result.getEndOffset() == text.length() && tokens.get(tokens.size()-1) instanceof EndOfLineToken) {
					return tokens;
				} else {
					ArrayList<LexerToken> r = getTokens(text, result.getEndOffset(), lineOffset, result.getMatcher().getFollowTokenMatchers());
					if (r != null) {
						tokens.addAll(r);
						if (tokens.get(tokens.size()-1) instanceof EndOfLineToken) {
							return tokens;
						}
					}
				}
			}
			tokens.clear();
		}
		return null;
	}

	public static Lexer get() {
		return lexer ;
	}
	
	public String[] getLegalContentTypes() {
		LinkedHashSet<String> types = new LinkedHashSet<String>();
		//TODO
		return new String[]{"DASM_NOTHING", "DASM_ERROR", "DASM_COMMENT", "DASM_EOL", "DASM_LABEL_DEFINITION"};
	}
	
	
	
	public static void main(String[] args) {
		Lexer l = Lexer.get();
		LexerToken[] tokens = l.generateTokens(";My comment that starts the file\r\n\n :the_label  ;it has a comment too\nset x,0xF10d;MOAR COMMENTS");
		for (LexerToken token : tokens) {
			System.out.println(token.getClass().getSimpleName() + " (" + token.getText() + ") ");
		}
	}
}
