package devcpu.assembler.preprocessor;

import java.util.List;

public class DefaultPreprocessorResult implements PreprocessorResult {
//	private List<RawLine> rawLines;
	private List<PreprocessedLine> preprocessedLines;

	public DefaultPreprocessorResult(/*List<RawLine> rawLines,	*/List<PreprocessedLine> preprocessedLines) {
//		this.rawLines = rawLines;
		this.preprocessedLines = preprocessedLines;
	}

//	@Override
//	public List<RawLine> getRawLines() {
//		return rawLines;
//	}

	@Override
	public List<PreprocessedLine> getPreprocessedLines() {
		return preprocessedLines;
	}
}
