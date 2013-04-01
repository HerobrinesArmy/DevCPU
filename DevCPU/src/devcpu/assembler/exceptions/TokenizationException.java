package devcpu.assembler.exceptions;

import devcpu.assembler.AssemblyLine;

public class TokenizationException extends AbstractLineException {
	private static final long serialVersionUID = 1L;
	
	public TokenizationException(AssemblyLine line) {
		super(line);
	}
	
	@Override
	public String getMessage() {
		return "Lexer's branching matcher sets could not find a syntactically valid way to tokenize " + line.getDocument().getFile().getName() + ", Line " + line.getLineNumber() + ": \"" + line.getText() + "\". Check the line for errors.";
	}
}
