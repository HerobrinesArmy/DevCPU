package devcpu.assembler.preprocessor;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import devcpu.assembler.Assembly;
import devcpu.assembler.AssemblyDocument;
import devcpu.assembler.RawLine;

public class DefaultPreprocessor implements Preprocessor {
//private Pattern preprocessorDirectivePattern = Pattern.compile("^\\s*[#\\.](define|(un|ifn?)?def|equ|include|import|el(se)?(if)?|(end)?if)\\b[\\s\\,]*([^;\\r\\n]*?)\\s*(;.*)?$",Pattern.CASE_INSENSITIVE);
	private static final Pattern preprocessorDirectivePattern = Pattern.compile("^\\s*[#\\.](define|equ|def|include|import|undef|ifn?def|if|elif|elseif|else|endif)\\b[\\s\\,]*([^;\\r\\n]*?)\\s*(;.*)?$",Pattern.CASE_INSENSITIVE);
//	private Pattern uselessLinePattern = Pattern.compile("^\\s*(;.*)?$");
	
	private Assembly assembly;

	public DefaultPreprocessor(Assembly assembly) {
		this.assembly = assembly;
	}
	
	public Assembly getAssembly()
	{
		return assembly;
	}

	@SuppressWarnings("unused")
	@Override
	public PreprocessorResult preprocess(Assembly assembly) {
		List<RawLine> /*rawLines*/remainingLines = assembly.getLineLoader().readLines(assembly.getRootDocument());
//		List<RawLine> remainingLines = new ArrayList<RawLine>(rawLines);
		List<PreprocessedLine> lines = new ArrayList<PreprocessedLine>();
		LinkedHashMap<Pattern,String> defines = new LinkedHashMap<Pattern, String>();
		LinkedHashMap<String,Pattern> patterns = new LinkedHashMap<String, Pattern>();
		//Decision: Preprocessor will not be iterative.		
		int currentLevel = 0;
		int scopedLevel = 0;
		boolean scopeAlive = true;
		//TODO Thoroughly test the bullshit 3-variable scope tracking system you came up with
		boolean workLines = true;
		while (workLines) {
			workLines = false;
			for (RawLine raw : new ArrayList<RawLine>(remainingLines)) {
				PreprocessedLine line = new PreprocessedLine(raw);
				remainingLines.remove(raw);
				//TODO Consider adding support for line splicing
				Matcher m = preprocessorDirectivePattern.matcher(line.getText());
				if (m.find() && m.start() == 0) {
					String name = m.group(1).toUpperCase();
					String params = m.group(2);
					if ("IFDEF".equals(name)) {
						if (currentLevel == scopedLevel) {
							if (patterns.containsKey(params)) {
								scopedLevel++;
							}
						}
						currentLevel++;
					} else if ("IFNDEF".equals(name)) {
						if (currentLevel == scopedLevel) {
							if (!patterns.containsKey(params)) {
								scopedLevel++;
							}
						}
						currentLevel++;
					} else if ("IF".equals(name)) {
						if (currentLevel == scopedLevel) {
							if (false) { //TODO write IF params check
								scopedLevel++;
							}
						}
					} else if ("ELIF".equals(name) || "ELSEIF".equals(name)) {
						if (currentLevel == scopedLevel) {
							scopeAlive = false;
							scopedLevel--;
						} else if (scopeAlive && currentLevel == scopedLevel + 1) {
							if (false) { //TODO write ELIF params check
								scopedLevel++;
							}
						}
					} else if ("ELSE".equals(name)) {
						//TODO check for invalid params?
						if (currentLevel == scopedLevel) {
							scopeAlive = false;
							scopedLevel--;
							//TODO Check for negative levels?
						} else if (scopeAlive && currentLevel == scopedLevel + 1) {
							scopedLevel++;
						}
					} else if ("ENDIF".equals(name)) {
						if (currentLevel == scopedLevel) {
							scopedLevel--;
							scopeAlive = true;
						}
						currentLevel--;
					} else if (scopedLevel == currentLevel) {
						if ("DEFINE".equals(name) || "EQU".equals(name) || "DEF".equals(name)) {
							//TODO Check to see if we're handling value(param)-less defines. 
							//The regex suggests that we are since the separator and the params group use *.
							params = replaceMacros(params, defines);
							//TODO Currently, things like '#define def #define' and '#define in #include' will not work as a person may hope.
							//Rather than doing macro replacement on params, consider doing it on every line, and using negative lookbehinds
							//in the regexp to avoid replacing a previously defined macro in a re-define, ifdef, ifndef, or undef
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
								patterns.remove(params);
							}
						} else if ("INCLUDE".equals(name) || "IMPORT".equals(name)) {
							params = replaceMacros(params, defines); //Do this?
							params = params.replaceAll("\"", "").replaceAll("'", "").replaceAll("<", "").replaceAll(">", ""); //For now, none of those characters are allowed in paths, because I'm lazy
							AssemblyDocument child = raw.getDocument().loadChild(params);
							List<RawLine> newLines = assembly.getLineLoader().readLines(child);
							newLines.addAll(remainingLines);
							remainingLines = newLines;
							workLines = true;
							break;
						} else {
							lines.add(line);
						}
					}
				} else {
					if (currentLevel == scopedLevel) {
						//We'll have the default preprocessor remove blank and comment lines to cut down on work for the tokenizer
						if (!line.text.matches("^\\s*(;.*)?$")) {
							lines.add(line);
						}
					}
				}
			}
		}
		for (PreprocessedLine line : lines) {
			replaceMacros(line, defines);
			//System.out.println(line.text);
		}
		return new DefaultPreprocessorResult(/*rawLines, */lines);
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
