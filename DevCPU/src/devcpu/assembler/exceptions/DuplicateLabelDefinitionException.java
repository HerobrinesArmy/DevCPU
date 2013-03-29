package devcpu.assembler.exceptions;

import devcpu.assembler.Assembly;
import devcpu.assembler.LabelDefinition;

public class DuplicateLabelDefinitionException extends AbstractAssemblyException {
	private static final long serialVersionUID = 1L;
	private LabelDefinition originalDef;
	private LabelDefinition newDef;

	public DuplicateLabelDefinitionException(Assembly assembly, LabelDefinition originalDef, LabelDefinition newDef) {
		super(assembly);
		this.originalDef = originalDef;
		this.newDef = newDef;
	}

	public LabelDefinition getOriginalDefinition() {
		return originalDef;
	}

	public LabelDefinition getNewDefinition() {
		return newDef;
	}
}
