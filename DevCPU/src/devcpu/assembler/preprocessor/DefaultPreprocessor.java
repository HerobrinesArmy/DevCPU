package devcpu.assembler.preprocessor;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import devcpu.assembler.Assembly;
import devcpu.assembler.AssemblyDocument;
import devcpu.assembler.RawLine;
import devcpu.lexer.Lexer;

public class DefaultPreprocessor implements Preprocessor {
//private Pattern preprocessorDirectivePattern = Pattern.compile("^\\s*[#\\.](define|(un|ifn?)?def|equ|include|import|el(se)?(if)?|(end)?if|macro)\\b[\\s\\,]*([^;\\r\\n]*?)\\s*(;.*)?$",Pattern.CASE_INSENSITIVE);
	private static final Pattern preprocessorDirectivePattern = Pattern.compile("^\\s*[#\\.](define|equ|def|include|import|undef|ifn?def|if|elif|elseif|else|endif|macro)\\b[\\s\\,]*([^;\\r\\n]*?)\\s*(;.*)?$",Pattern.CASE_INSENSITIVE);
	private static final Pattern definePattern = Pattern.compile("^\\s*(" + Lexer.REGEX_IDENTIFIER + ")\\s*([^;\\r\\n]*)");
	private static final Pattern macroPattern = Pattern.compile("^\\s*(" + Lexer.REGEX_IDENTIFIER + ")\\s*(\\(\\s*(" + Lexer.REGEX_IDENTIFIER + "(\\s*\\,\\s*" + Lexer.REGEX_IDENTIFIER + ")*)?\\))?\\s*\\{?$");
	
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
		List<RawLine> remainingLines = assembly.getLineLoader().readLines(assembly.getRootDocument());
		List<PreprocessedLine> lines = new ArrayList<PreprocessedLine>();
		ArrayList<PreprocessedLine> finalLines = new ArrayList<PreprocessedLine>();
		LinkedHashMap<Pattern,String> defines = new LinkedHashMap<Pattern, String>();
		LinkedHashMap<String,Pattern> patterns = new LinkedHashMap<String, Pattern>();
		LinkedHashMap<Pattern,Macro> macros = new LinkedHashMap<Pattern, Macro>();
		LinkedHashMap<String,Pattern> macroPatterns = new LinkedHashMap<String, Pattern>();
		//Decision: Preprocessor will not be iterative.		
		int currentLevel = 0;
		int scopedLevel = 0;
		boolean scopeAlive = true;
		Macro inMacro = null;
		//TODO Thoroughly test the bullshit 3-variable scope tracking system you came up with
		boolean workLines = true;
		while (workLines) {
			workLines = false;
			for (RawLine raw : new ArrayList<RawLine>(remainingLines)) {
				PreprocessedLine line = new PreprocessedLine(raw);
				remainingLines.remove(raw);
				//TODO Consider adding support for line splicing
				if (inMacro != null) {
					if (line.text.matches("^\\s*(\\}|[#\\.](?i:endmacro))\\s*(;.*)?$")) {
						inMacro = null;
					} else if (!line.text.matches("^\\s*\\{?\\s*(;.*)?$")) { //ignore useless lines
						inMacro.lines.add(line.text);
					}
				} else {
					Matcher m = preprocessorDirectivePattern.matcher(line.text);
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
								params = replaceDefines(params, defines);
								//TODO Currently, things like '#define def #define' and '#define in #include' will not work as a person may hope.
								//Rather than doing macro replacement on params, consider doing it on every line, and using negative lookbehinds
								//in the regexp to avoid replacing a previously defined macro in a re-define, ifdef, ifndef, or undef
								Matcher matcher = definePattern.matcher(params);
								if (matcher.find()) {
									String key = matcher.group(1);
									String value = matcher.group(2);
									Pattern pattern = Pattern.compile("\\b"+/*Pattern.quote(*/key/*)*/+"\\b");
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
								params = replaceDefines(params, defines); //Do this?
								params = params.replaceAll("\"", "").replaceAll("'", "").replaceAll("<", "").replaceAll(">", ""); //For now, none of those characters are allowed in paths, because I'm lazy
								AssemblyDocument child = raw.getDocument().loadChild(params);
								List<RawLine> newLines = assembly.getLineLoader().readLines(child);
								newLines.addAll(remainingLines);
								remainingLines = newLines;
								workLines = true;
								break;
							} else if ("MACRO".equals(name)) {
								Matcher matcher = macroPattern.matcher(params);
								if (matcher.find()) {
									String macroName = matcher.group(1);
									String macroParams = matcher.group(3);
									inMacro = new Macro(macroName, macroParams);
									String argMatch = "";
									if (inMacro.params.size() > 0) {
										argMatch += "\\s*\\(";
										boolean first = true;
										for (int i = 0; i < inMacro.params.size(); i++) {
											if (i == 0) {
												argMatch += "\\s*([^;\\,]*?)";
											} else {
												argMatch += "\\s*\\,\\s*([^;\\,]*?)";
											}
										}
										argMatch += "\\s*\\)";
									}
									Pattern pattern = Pattern.compile("\\b" + macroName + "\\b" + argMatch + "\\s*(;.*)?$");
									macroPatterns.put(macroName, pattern);
									macros.put(pattern, inMacro);
			//						if (Pattern.matches("\\b"+Pattern.quote(key)+"\\b", value)) {
			//							throw new RecursiveMacroException(directive);
			//						}
								} else {
			//						throw new InvalidMacroFormatException(directive);
								}
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
		}
		for (PreprocessedLine line : lines) {
			for (Pattern pattern : macros.keySet()) {
				Matcher matcher = pattern.matcher(line.text);
				if (matcher.find()) {
					Macro macro = macros.get(pattern);
					line.text = line.text.replaceAll(pattern.pattern(), "");
					replaceDefines(line, defines);
					finalLines.add(line);
					for (String l : macro.lines) {
						PreprocessedLine pl = new PreprocessedLine(line.getRawLine());
						pl.text = l;
						for (int i = 0; i < macro.params.size(); i++) {
							pl.text = pl.text.replaceAll("\\b"+macro.params.get(i)+"\\b", matcher.group(i+1));
						}
						replaceDefines(pl, defines);
						finalLines.add(pl);
					}
					continue;
				}
			}
			replaceDefines(line, defines);
			finalLines.add(line);
		}
//		for (PreprocessedLine l : finalLines) {
//			System.out.println(l.text);
//		}
		return new DefaultPreprocessorResult(/*rawLines, */finalLines);
	}

	private void replaceDefines(PreprocessedLine line, LinkedHashMap<Pattern,String> defines) {
		for (Pattern pattern : defines.keySet()) {
			line.text = line.text.replaceAll(pattern.pattern(), defines.get(pattern));
		}
	}
	
	private String replaceDefines(String params, LinkedHashMap<Pattern,String> defines) {
		for (Pattern pattern : defines.keySet()) {
			params = params.replaceAll(pattern.pattern(), defines.get(pattern));
		}
		return params;
	}
}
