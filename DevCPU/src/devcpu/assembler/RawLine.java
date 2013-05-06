package devcpu.assembler;

public class RawLine {
	private AssemblyDocument document;
	private int lineNumber;
	private int documentOffset;
	private String text;
	
	public RawLine(AssemblyDocument document, int lineNumber, int documentOffset, String text) {
		this.document = document;
		this.lineNumber = lineNumber;
		this.documentOffset = documentOffset;
		this.text = text;
	}

	public AssemblyDocument getDocument() {
		return document;
	}

	public int getLineNumber() {
		return lineNumber;
	}

	public int getDocumentOffset() {
		return documentOffset;
	}

	public String getText() {
		return text;
	}
}
