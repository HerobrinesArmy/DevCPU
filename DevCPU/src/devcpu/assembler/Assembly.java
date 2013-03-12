package devcpu.assembler;

import org.eclipse.core.resources.IFile;

public class Assembly {
	public static final boolean DEFAULT_LABELS_CASE_SENSITIVE = true;

	private AssemblyDocument rootDocument;
	private boolean labelsCaseSensitive = DEFAULT_LABELS_CASE_SENSITIVE;

	public Assembly(IFile file) throws Exception {
		this.rootDocument = new AssemblyDocument(file, this);
	}

	public AssemblyDocument getRootDocument() {
		return rootDocument;
	}
	
	public IFile getFile() {
		return rootDocument.getFile();
	}

	public boolean isLabelsCaseSensitive() {
		return labelsCaseSensitive;
	}

	public void setLabelsCaseSensitive(boolean labelsCaseSensitive) {
		this.labelsCaseSensitive = labelsCaseSensitive;
	}
}
