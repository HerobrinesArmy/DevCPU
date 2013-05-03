package devcpu.assembler.preprocessor;

import java.util.List;

import devcpu.assembler.AssemblyLine;
import devcpu.assembler.RawLine;

public class DASMPreprocessorResult implements PreprocessorResult {
	private List<RawLine> rawLines;
	private List<AssemblyLine> preprocessedLines;

	public DASMPreprocessorResult(List<RawLine> rawLines,	List<AssemblyLine> preprocessedLines) {
		this.rawLines = rawLines;
		this.preprocessedLines = preprocessedLines;
	}

	@Override
	public List<RawLine> getRawLines() {
		return rawLines;
	}

	@Override
	public List<AssemblyLine> getPreprocessedLines() {
		return preprocessedLines;
	}
}
