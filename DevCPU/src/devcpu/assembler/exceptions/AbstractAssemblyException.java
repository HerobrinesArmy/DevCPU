package devcpu.assembler.exceptions;

import devcpu.assembler.Assembly;
import devcpu.assembler.providers.AssemblyProvider;

public abstract class AbstractAssemblyException extends Exception implements AssemblyProvider {
	private static final long serialVersionUID = 1L;
	protected Assembly assembly;
	
	public AbstractAssemblyException(Assembly assembly) {
		this.assembly = assembly;
	}
	
	@Override
	public Assembly getAssembly() {
		return assembly;
	}
	
	@Override
	public String getMessage() {
		return "Assembly error: Something is wrong in one of the " + assembly.getLineCount() + " lines of your assembly. Too bad this particular error didn't include aaaaany information. Maybe you should go check to see if you have any labels spelled incorrectly or something. I don't know. What do I look like, a doctor?";
	}
}
