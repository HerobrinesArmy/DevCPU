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
}
