package devcpu.assembler.preprocessor;

import java.util.ArrayList;
import java.util.List;

import devcpu.assembler.Assembly;
import devcpu.assembler.AssemblyLine;
import devcpu.assembler.RawLine;

public class DASMPreprocessor implements Preprocessor {
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
		/*
		 * Trigraph replacement: The preprocessor replaces trigraph sequences with the characters they represent.
			 Line splicing: Physical source lines that are continued with escaped newline sequences are spliced to form logical lines.
			 Tokenization: The preprocessor breaks the result into preprocessing tokens and whitespace. It replaces comments with whitespace.
			 Macro expansion and directive handling: Preprocessing directive lines, including file inclusion and conditional compilation, are executed. The preprocessor simultaneously expands macros and, in the 1999 version of the C standard, handles _Pragma operators.
		 */
		List<RawLine> rawLines = assembly.getLineLoader().readLines(assembly.getRootDocument());
		List<AssemblyLine> preprocessedLines = new ArrayList<AssemblyLine>();
		boolean didSomething;
		do {
			didSomething = false;
			for (RawLine line : rawLines) {
				
			}
		} while (didSomething);
		// TODO Auto-generated method stub
		return new DASMPreprocessorResult(rawLines, preprocessedLines);
	}
}
