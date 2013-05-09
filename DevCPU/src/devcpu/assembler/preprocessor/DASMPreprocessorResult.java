package devcpu.assembler.preprocessor;

import java.util.List;

import devcpu.assembler.AssemblyLine;
import devcpu.assembler.RawLine;

public class DASMPreprocessorResult implements PreprocessorResult {
	private List<RawLine> rawLines;
	private List<PreprocessedLine> preprocessedLines;

	public DASMPreprocessorResult(List<RawLine> rawLines,	List<PreprocessedLine> preprocessedLines) {
		this.rawLines = rawLines;
		this.preprocessedLines = preprocessedLines;
	}

	@Override
	public List<RawLine> getRawLines() {
		return rawLines;
	}

	@Override
	public List<PreprocessedLine> getPreprocessedLines() {
		return preprocessedLines;
	}
}
