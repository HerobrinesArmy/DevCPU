package devcpu.assembler.preprocessor;

import java.util.List;

import devcpu.assembler.RawLine;

public interface PreprocessorResult {
	public List<RawLine> getRawLines();
	public List<PreprocessedLine> getPreprocessedLines();
}
