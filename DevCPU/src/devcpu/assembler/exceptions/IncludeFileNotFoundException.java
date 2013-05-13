package devcpu.assembler.exceptions;

import devcpu.assembler.RawLine;

public class IncludeFileNotFoundException extends Exception {
	private static final long serialVersionUID = 1L;
	private RawLine line;
	private String path;

	public IncludeFileNotFoundException(RawLine line, String path) {
		this.line = line;
		this.path = path;
	}

	public RawLine getLine() {
		return line;
	}
	
	public String getPath() {
		return path;
	}

	@Override
	public String getMessage() {
		return "Cannot locate file to include: \"" + path;// + "\" at " + directive.getLine().getDocument().getFile().getName() + ", Line " + directive.getLine().getLineNumber() + ": " + directive.getLine().getText();
	}
}
