//package devcpu.assembler;
//
//import java.util.regex.Matcher;
//import java.util.regex.Pattern;
//
//import devcpu.lexer.Lexer;
//
//public class zzz_SingleTokenizing_Define {
//	private static final Pattern extractPattern = Pattern.compile("\\s*[#\\.]" + Lexer.REGEX_IDENTIFIER + "\\s*" + Lexer.REGEX_IDENTIFIER + "\\s*([^;\\r\\n]*)");
//	private AssemblyLine line;
//	private String key;
//	private String value;
//
//	public zzz_SingleTokenizing_Define(AssemblyLine line, String key, String value) {
//		this.line = line;
//		this.key = key;
//		this.value = value;
//	}
//
//	public AssemblyLine getLine() {
//		return line;
//	}
//
//	public String getKey() {
//		return key;
//	}
//
//	public String getValue() {
//		return value;
//	}
//
//	public static String extractValue(String text) {
//		Matcher m = extractPattern.matcher(text);
//		if (m.find() && m.start() == 0) {
//			return m.group(1);
//		}
//		return null;
//	}
//
//	public void setValue(String value) {
//		this.value = value;
//	}
//}
