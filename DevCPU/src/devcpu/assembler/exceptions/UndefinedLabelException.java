package devcpu.assembler.exceptions;

import java.util.List;

import devcpu.assembler.LabelUse;

public class UndefinedLabelException extends Exception {
	private static final long serialVersionUID = 1L;
	private String label;
	private List<LabelUse> uses;

	public UndefinedLabelException(String label, List<LabelUse> uses) {
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
