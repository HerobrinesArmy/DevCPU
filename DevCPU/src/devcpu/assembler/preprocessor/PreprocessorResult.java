package devcpu.assembler.preprocessor;

import java.util.List;

public interface PreprocessorResult {
	//public List<RawLine> getRawLines();
	public List<PreprocessedLine> getPreprocessedLines();
}
