package devcpu.lexer;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class ExpressionMatcher implements BoundableLexerTokenMatcher {
	private static ExpressionMatcher matcher = new ExpressionMatcher();

	private List<LexerTokenMatcher> operatorMatchers = new ArrayList<LexerTokenMatcher>();
	{
		operatorMatchers.add(OperatorMatcher.get());
	}
	
	private List<LexerTokenMatcher> unaryOperatorMatchers = new ArrayList<LexerTokenMatcher>();
	{
		//TODO Add unary operator matching before all operand matches
	}

	private List<LexerTokenMatcher> operandMatchers = new ArrayList<LexerTokenMatcher>();
	{
		operandMatchers.add(GroupMatcher.get());
		operandMatchers.add(LiteralMatcher.get());
		operandMatchers.add(RegisterMatcher.get());
		operandMatchers.add(LabelMatcher.get());
	}
	
	//TODO ternary conditional operator support

	@Override
	public List<LexerTokenMatcher> getFollowTokenMatchers() {
		ArrayList<LexerTokenMatcher> followTokenMatchers = new ArrayList<LexerTokenMatcher>();
		followTokenMatchers.add(TrueMatcher.get());
		return followTokenMatchers;
	}

	@Override
	public MatcherResult match(String originalText, int startOffset, int originalLineOffset) {
		ArrayList<LexerToken> tokens = new ArrayList<LexerToken>();
		int lineOffset = originalLineOffset + startOffset;
		String text = originalText.substring(startOffset);
		int offset = 0;
		boolean started = false;
		MatcherResult finalResult = null;
		MatcherResult result = matchUnaryOperator(text, offset, lineOffset);
		if (result != null) {
			for (LexerToken token : result.getTokens()) {
				tokens.add(token);
			}
			offset = result.getEndOffset();
		}
		for (LexerTokenMatcher matcher : operandMatchers) {
			result = matcher.match(text, offset, lineOffset);
			if (result.matched()) {
				finalResult = result;
				for (LexerToken token : result.getTokens()) {
					tokens.add(token);
				}
				offset = result.getEndOffset();
				started = true;
				break;
			}
		}
		if (started) {
			while (true) {
				result = matchOperator(text, offset, lineOffset);
				if (result == null) {
					break;
				}
				finalResult = result;
				for (LexerToken token : result.getTokens()) {
					tokens.add(token);
				}
				offset = result.getEndOffset();
				result = matchUnaryOperator(text, offset, lineOffset);
				if (result != null) {
					for (LexerToken token : result.getTokens()) {
						tokens.add(token);
					}
					offset = result.getEndOffset();
				}
				result = matchOperand(text, offset, lineOffset);
				if (result == null) {
					return new StandardResult(false, null, offset, this);
				}
				finalResult = result;
				for (LexerToken token : result.getTokens()) {
					tokens.add(token);
				}
				offset = result.getEndOffset();
			}
			return new StandardResult(true, tokens.toArray(new LexerToken[0]), startOffset + finalResult.getEndOffset(), this);	
		}
		return new StandardResult(false, null, offset, this);
	}

	@Override
	public MatcherResult match(String originalText, int startOffset, int endOffset, int originalLineOffset) {
		ArrayList<LexerToken> tokens = new ArrayList<LexerToken>();
		int lineOffset = originalLineOffset + startOffset;
		String text = originalText.substring(startOffset, endOffset);
		int offset = 0;
		boolean started = false;
		MatcherResult result = matchUnaryOperator(text, offset, lineOffset);
		if (result != null) {
			for (LexerToken token : result.getTokens()) {
				tokens.add(token);
			}
			offset = result.getEndOffset();
		}
		for (LexerTokenMatcher matcher : operandMatchers) {
			result = matcher.match(text, offset, lineOffset);
			if (result.matched()) {
				for (LexerToken token : result.getTokens()) {
					tokens.add(token);
				}
				offset = result.getEndOffset();
				started = true;
				break;
			}
		}
		if (started) {
			while (true) {
				result = matchOperator(text, offset, lineOffset);
				if (result == null) {
					break;
				}
				for (LexerToken token : result.getTokens()) {
					tokens.add(token);
				}
				offset = result.getEndOffset();
				result = matchUnaryOperator(text, offset, lineOffset);
				if (result != null) {
					for (LexerToken token : result.getTokens()) {
						tokens.add(token);
					}
					offset = result.getEndOffset();
				}
				result = matchOperand(text, offset, lineOffset);
				if (result == null) {
					return new StandardResult(false, null, offset, this);
				}
				for (LexerToken token : result.getTokens()) {
					tokens.add(token);
				}
				offset = result.getEndOffset();
			}
			//TODO check that there isn't leftover content in the group/address
			//On second thought, do this one level up
			//TODO consider using the endOffset of the last result instead
			return new StandardResult(true, tokens.toArray(new LexerToken[0]), startOffset + endOffset, this);
		}
		return new StandardResult(false, null, offset, this);
	}

	private MatcherResult matchOperator(String text, int offset, int lineOffset) {
		for (LexerTokenMatcher matcher : operatorMatchers) {
			MatcherResult result = matcher.match(text, offset, lineOffset);
			if (result.matched()) {
				return result;
			}
		}
		return null;
	}
	
	private MatcherResult matchOperand(String text, int offset, int lineOffset) {
		for (LexerTokenMatcher matcher : operandMatchers) {
			MatcherResult result = matcher.match(text, offset, lineOffset);
			if (result.matched()) {
				return result;
			}
		}
		return null;
	}
	
	private MatcherResult matchUnaryOperator(String text, int offset, int lineOffset) {
		for (LexerTokenMatcher matcher : unaryOperatorMatchers) {
			MatcherResult result = matcher.match(text, offset, lineOffset);
			if (result.matched()) {
				return result;
			}
		}
		return null;
	}

	public static ExpressionMatcher get() {
		return matcher;
	}
}
