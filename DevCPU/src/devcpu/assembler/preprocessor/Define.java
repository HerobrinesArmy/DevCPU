package devcpu.assembler.preprocessor;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import devcpu.assembler.RawLine;
import devcpu.assembler.exceptions.AbstractDirectiveException;
import devcpu.lexer.Lexer;

public class Define {
	private static final Pattern pattern = Pattern.compile("\\s*(" + Lexer.REGEX_IDENTIFIER + ")\\s*([^;\\r\\n]*)");
	private static final Pattern extractPattern = Pattern.compile("\\s*[#\\.]" + Lexer.REGEX_IDENTIFIER + "\\s*" + Lexer.REGEX_IDENTIFIER + "\\s*([^;\\r\\n]*)");
	private String key;
	private String value;
	private RawLine line;

	public Define(RawLine line, String params) { //throws AbstractDirectiveException {
		this.line = line;
		Matcher m = pattern.matcher(params);
		if (m.find() && m.start() == 0) {
			this.key = m.group(1);
			this.value = m.group(2);
			/*if (Pattern.matches("\\b"+Pattern.quote(key)+"\\b", value)) {
				throw new RecursiveDefinitionException(directive);
			}*/
		} else {
//			throw new InvalidDefineFormatException(directive);
		}
	}

	public RawLine getLine() {
		return line;
	}

	public String getKey() {
		return key;
	}

	public String getValue() {
		return value;
	}

	public static String extractValue(String text) {
		Matcher m = extractPattern.matcher(text);
		if (m.find() && m.start() == 0) {
			return m.group(1);
		}
		return null;
	}

	public void setValue(String value) {
		this.value = value;
	}
}
