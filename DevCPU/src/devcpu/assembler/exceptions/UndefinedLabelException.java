package devcpu.assembler.exceptions;

import java.util.List;

import devcpu.assembler.AssemblyLine;
import devcpu.assembler.LabelUse;

public class UndefinedLabelException extends AbstractLineException {
	private static final long serialVersionUID = 1L;
	private String label;
	private List<LabelUse> uses;

	public UndefinedLabelException(AssemblyLine line, String label, List<LabelUse> uses) {
		super(line);
		this.label = label;
		this.uses = uses;
	}

	public String getLabel() {
		return label;
	}

	public List<LabelUse> getUses() {
		return uses;
	}
	
	@Override
	public String getMessage() {
		if (uses.size() > 1) {
			return "Undefined label \"" + label + "\" at " + line.getDocument().getFile().getName() + ", Line " + line.getLineNumber() + " (one of " + uses.size() + " places): " + line.getText();
		}
		return "Undefined label \"" + label + "\" at " + line.getDocument().getFile().getName() + ", Line " + line.getLineNumber() + ": " + line.getText();
	}
}
