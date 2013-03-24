package devcpu.assembler.exceptions;

import java.util.List;

import devcpu.assembler.Assembly;
import devcpu.assembler.LabelUse;

public class UndefinedLabelException extends AbstractAssemblyException {
	private static final long serialVersionUID = 1L;
	private String label;
	private List<LabelUse> uses;

	public UndefinedLabelException(Assembly assembly, String label, List<LabelUse> uses) {
		super(assembly);
		this.label = label;
		this.uses = uses;
	}

	public String getLabel() {
		return label;
	}

	public List<LabelUse> getUses() {
		return uses;
	}
}
