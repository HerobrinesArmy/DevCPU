package devcpu.assembler.preprocessor;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import devcpu.assembler.Assembly;
import devcpu.assembler.RawLine;

public class DASMPreprocessor implements Preprocessor {
//	private static String[] preprocessorDirectives = new String[]{
//		//IMPLEMENTED
//		"define", "equ", "def",
//		"include", "import",
//		//NOT IMPLEMENTED
//		"undef",
//		"ifdef",
//		"ifndef",
//		"if",
//		"elif", "elseif",
//		/*"el", */"else",
//		"endif"
//		};
//private Pattern preprocessorDirectivePattern = Pattern.compile("^\\s*[#\\.](define|(un|ifn?)?def|equ|include|import|el(se)?(if)?|(end)?if)\\b[\\s\\,]*([^;\\r\\n]*)$",Pattern.CASE_INSENSITIVE);
	private Pattern preprocessorDirectivePattern = Pattern.compile("^\\s*[#\\.](define|equ|def|include|import|undef|ifn?def|if|elif|elseif|else|endif)\\b[\\s\\,]*([^;\\r\\n]*)$",Pattern.CASE_INSENSITIVE);
	
//	private LinkedHashMap<String,Define> defines = new LinkedHashMap<String, Define>();
	
	private Assembly assembly;

	public DASMPreprocessor(Assembly assembly) {
		this.assembly = assembly;
	}
	
	public Assembly getAssembly()
	{
		return assembly;
	}

	@Override
	public PreprocessorResult preprocess(Assembly assembly) {
		List<RawLine> rawLines = assembly.getLineLoader().readLines(assembly.getRootDocument());
		List<PreprocessedLine> lines = new ArrayList<PreprocessedLine>();
		LinkedHashMap<Pattern,String> defines = new LinkedHashMap<Pattern, String>();
		LinkedHashMap<String,Pattern> patterns = new LinkedHashMap<String, Pattern>();
		//Decision: Preprocessor will not be iterative.		
		int currentlevel = 0;
		int scopedLevel = 0;
		for (RawLine raw : rawLines) {
			PreprocessedLine line = new PreprocessedLine(raw);
			//TODO Consider adding support for line splicing
			Matcher m = preprocessorDirectivePattern.matcher(line.getText());
			if (m.find() && m.start() == 0) {
				String name = m.group(1).toUpperCase();
				String params = m.group(2);
				if ("DEFINE".equals(name) || "EQU".equals(name) || "DEF".equals(name)) {
					//TODO Check to see if we're handling value(param)-less defines
//					line.preprocessorDirective = true;
					params = replaceMacros(params, defines);
					Matcher matcher = Define.pattern.matcher(params);
					if (matcher.find() && matcher.start() == 0) {
						String key = matcher.group(1);
						String value = matcher.group(2);
						Pattern pattern = Pattern.compile("\\b"+Pattern.quote(key)+"\\b");
						patterns.put(key, pattern);
						defines.put(pattern, value);
//						if (Pattern.matches("\\b"+Pattern.quote(key)+"\\b", value)) {
//							throw new RecursiveDefinitionException(directive);
//						}
					} else {
//						throw new InvalidDefineFormatException(directive);
					}
				} else if ("UNDEF".equals(name)) {
					Pattern pattern = patterns.get(params);
					if (pattern != null) {
						defines.remove(pattern);
					}
				} else if ("IFDEF".equals(name)) {
					//TODO
				} else if ("IFNDEF".equals(name)) {
					//TODO
				} else if ("IF".equals(name)) {
					//TODO
				} else if ("ELIF".equals(name) || "ELSEIF".equals(name)) {
					//TODO
				} else if ("ELSE".equals(name)) {
					//TODO
				} else if ("ENDIF".equals(name)) {
					//TODO
				} else if ("INCLUDE".equals(name) || "IMPORT".equals(name)) {
					//TODO
				} else {
					lines.add(line);
				}
			} else {
				lines.add(line);
			}
		}
		for (PreprocessedLine line : lines) {
			replaceMacros(line, defines);
			System.out.println(line.text);
		}
		return new DASMPreprocessorResult(rawLines, lines);
	}

	private void replaceMacros(PreprocessedLine line, LinkedHashMap<Pattern,String> defines) {
		for (Pattern pattern : defines.keySet()) {
			line.text = line.text.replaceAll(pattern.pattern(), defines.get(pattern));
		}
	}
	
	private String replaceMacros(String params, LinkedHashMap<Pattern,String> defines) {
		for (Pattern pattern : defines.keySet()) {
			params = params.replaceAll(pattern.pattern(), defines.get(pattern));
		}
		return params;
	}
}
