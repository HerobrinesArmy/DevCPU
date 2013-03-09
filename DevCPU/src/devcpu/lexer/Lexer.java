package devcpu.lexer;

import java.util.ArrayList;
import java.util.List;

import devcpu.lexer.matchers.BasicOpCodeMatcher;
import devcpu.lexer.matchers.CommentMatcher;
import devcpu.lexer.matchers.DataMatcher;
import devcpu.lexer.matchers.DirectiveMatcher;
import devcpu.lexer.matchers.EndOfLineMatcher;
import devcpu.lexer.matchers.LabelDefinitionMatcher;
import devcpu.lexer.matchers.LexerTokenMatcher;
import devcpu.lexer.matchers.SpecialOpCodeMatcher;
import devcpu.lexer.tokens.AValueEndToken;
import devcpu.lexer.tokens.AValueStartToken;
import devcpu.lexer.tokens.BValueEndToken;
import devcpu.lexer.tokens.BValueStartToken;
import devcpu.lexer.tokens.DataValueEndToken;
import devcpu.lexer.tokens.DataValueStartToken;
import devcpu.lexer.tokens.EndOfLineToken;
import devcpu.lexer.tokens.ErrorToken;
import devcpu.lexer.tokens.LexerToken;
import devcpu.lexer.tokens.TrueToken;

public class Lexer {
	public static final String REGEX_IDENTIFIER = "\\b[a-zA-Z_][a-zA-Z_0-9]*\\b";
	public static final String REGEX_HEXADECIMAL_VALUE = "\\b0x[0-9A-Fa-f]{1,4}\\b";
	public static final String REGEX_BINARY_VALUE = "\\b0b[01]{1,16}\\b";
	public static final String REGEX_DECIMAL_VALUE = "\\-?[0-9]{1,5}\\b";
	public static final String REGEX_CHARACTER_VALUE = "'[^']'";
	public static final String REGEX_STRING = "\\\"(\\\\.|[^\\\"])*\\\"";
	
	private static Lexer lexer = new Lexer();
	
	private ArrayList<LexerToken> lastResult = new ArrayList<LexerToken>();
	
	private Lexer() {
	}
	
	private ArrayList<LexerTokenMatcher> initialTokenMatchers = new ArrayList<LexerTokenMatcher>();
	{
		initialTokenMatchers.add(LabelDefinitionMatcher.get());
		initialTokenMatchers.add(CommentMatcher.get());
		initialTokenMatchers.add(EndOfLineMatcher.get());
		initialTokenMatchers.add(SpecialOpCodeMatcher.get());
		initialTokenMatchers.add(BasicOpCodeMatcher.get());
		initialTokenMatchers.add(DataMatcher.get());
		initialTokenMatchers.add(DirectiveMatcher.get()); //TODO
	}
	
	public LexerToken[] generateTokens(String text) {
		return generateTokens(text, false);
	}
	
	public LexerToken[] generateTokens(String text, boolean includeZeroLength) {
		ArrayList<LexerToken> tokens = new ArrayList<LexerToken>();
		String[] lines = text.split("\\n");
		int lineOffset = 0;
		for (String line : lines) {
			ArrayList<LexerToken> lineTokens = getTokens(line, 0, lineOffset, initialTokenMatchers);
			if (lineTokens == null) {
				tokens.add(new ErrorToken(line, lineOffset, lineOffset + line.length()));
			} else {
				for (LexerToken token : lineTokens) {
					if (!(token instanceof TrueToken)) {
						System.out.println(token.getClass().getSimpleName() + " (" + token.getText() + ") ");
						if (includeZeroLength || !(token instanceof AValueStartToken || token instanceof AValueEndToken || token instanceof BValueStartToken || token instanceof BValueEndToken || token instanceof DataValueStartToken || token instanceof DataValueEndToken)) {
							tokens.add(token);
						}
					}
				}
			}
			lineOffset += line.length() + 1;
		}
		lastResult = tokens;
//		System.out.println("Storing " + lastResult.size() + " tokens");
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
//		LinkedHashSet<String> types = new LinkedHashSet<String>();
		//TODO
		return new String[]{
			"DASM_NOTHING",
			"DASM_ERROR",
			"DASM_COMMENT",
			"DASM_EOL",
			"DASM_LABEL_DEFINITION",
			"DASM_SPECIAL_OPCODE",
			"DASM_BASIC_OPCODE",
			"DASM_LITERAL",
			"DASM_REGISTER",
			"DASM_ADDRESS_START",
			"DASM_ADDRESS_END",
			"DASM_GROUP_START",
			"DASM_GROUP_END",
			"DASM_LABEL",
			"DASM_OPERATOR",
			"DASM_STRING",
			"DASM_DATA_VALUE_START",
			"DASM_DATA_VALUE_END",
			"DASM_DATA",
			"DASM_DIRECTIVE_PARAMETERS",
			"DASM_DIRECTIVE"
		};
	}

	public LexerToken getTokenAt(int offset) {
		for (LexerToken token : lastResult) {
			if (token.getEnd() > offset)
			{
				if (token.getStart() > offset) {
					return null;
				}
				return token;
			}
		}
		return null;
	}
}
