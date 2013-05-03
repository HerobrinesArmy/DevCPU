package devcpu.assembler.preprocessor;

import devcpu.assembler.Assembly;

public interface Preprocessor {
	public PreprocessorResult preprocess(Assembly assembly);
}
