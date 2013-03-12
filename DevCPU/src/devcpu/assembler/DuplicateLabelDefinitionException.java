package devcpu.assembler;

public class DuplicateLabelDefinitionException extends Exception {
	private static final long serialVersionUID = 1L;
	private LabelDefinition originalDef;
	private LabelDefinition newDef;

	public DuplicateLabelDefinitionException(LabelDefinition originalDef, LabelDefinition newDef) {
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
