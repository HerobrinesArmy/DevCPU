package devcpu.assembler.preprocessor;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import devcpu.assembler.Assembly;
import devcpu.assembler.AssemblyLine;
import devcpu.assembler.RawLine;

public class DASMPreprocessor implements Preprocessor {
	private static String[] preprocessorDirectives = new String[]{
		//IMPLEMENTED
		"define", "equ", "def",
		"include", "import",
		//NOT IMPLEMENTED
		"undef",
		"ifdef",
		"ifndef",
		"if",
		"elif", "elseif",
		/*"el", */"else",
		"endif"
		};
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
		List<AssemblyLine> preprocessedLines = new ArrayList<AssemblyLine>();
		LinkedHashMap<String,Define> defines = new LinkedHashMap<String, Define>();
		//Decision: Preprocessor will not be iterative.		
		int currentlevel = 0;
		int scopedLevel = 0;
		for (RawLine line : rawLines) {
			Matcher m = preprocessorDirectivePattern.matcher(line.getText());
			if (m.find() && m.start() == 0) {
				String name = m.group(1).toUpperCase();
				String params = m.group(2);
				if ("DEFINE".equals(name) || "EQU".equals(name) || "DEF".equals(name)) {
					Define define = new Define(line, params); 
					defines.put(define.getKey(), define);
				}
			}
			//TODO Consider adding support for line splicing
			replaceMacros(line);
			
		}
		return new DASMPreprocessorResult(rawLines, preprocessedLines);
	}

	private void replaceMacros(RawLine line) {
		// TODO Auto-generated method stub
		
	}
}
