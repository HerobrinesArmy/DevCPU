package devcpu.assembler.exceptions;

import devcpu.assembler.AssemblyLine;
import devcpu.assembler.expression.Group;

public class ValueResolutionException extends AbstractLineException {
	private static final long serialVersionUID = 1L;
	private Group value;

	public ValueResolutionException(AssemblyLine line, Group value) {
		super(line);
		this.value = value;
	}
	
	@Override
	public String getMessage() {
		return "Unable to resolve \"" + value.getExpression() + "\" to an assembleable value at " + line.getDocument().getFile().getName() + ", Line " + line.getLineNumber() + ": " + line.getText();
	}
}
