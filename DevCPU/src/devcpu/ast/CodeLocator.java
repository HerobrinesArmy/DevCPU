package devcpu.ast;

import org.eclipse.core.resources.IFile;

public class CodeLocator {
	private IFile file;
	private CodePosition start;
	private CodePosition end;

	public CodeLocator(IFile file, CodePosition start, CodePosition end) {
		this.file = file;
		this.start = start;
		this.end = end;
	}
	
	public IFile getFile() {
		return file;
	}
	
	public CodePosition getStart() {
		return start;
	}
	
	public CodePosition getEnd() {
		return end;
	}
}
