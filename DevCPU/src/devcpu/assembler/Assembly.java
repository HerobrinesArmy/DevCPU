package devcpu.assembler;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;

import devcpu.assembler.exceptions.DuplicateLabelDefinitionException;
import devcpu.assembler.exceptions.IncludeFileNotFoundException;
import devcpu.assembler.exceptions.InvalidDefineFormatException;
import devcpu.assembler.exceptions.RecursiveInclusionException;
import devcpu.emulation.DefaultControllableDCPU;

public class Assembly {
	public static final boolean DEFAULT_LABELS_CASE_SENSITIVE = true;
	private AssemblyDocument rootDocument;
	private ArrayList<AssemblyDocument> documents = new ArrayList<AssemblyDocument>();
	private boolean labelsCaseSensitive = DEFAULT_LABELS_CASE_SENSITIVE;
	
	public ArrayList<AssemblyLine> lines = new ArrayList<AssemblyLine>();
	public LinkedHashMap<String,String> defines = new LinkedHashMap<String, String>();
	public LinkedHashMap<String,LabelDefinition> labelDefs = new LinkedHashMap<String, LabelDefinition>();
	public LinkedHashMap<String,List<LabelUse>> labelUses = new LinkedHashMap<String, List<LabelUse>>();

	public Assembly(IFile file) throws IOException, DuplicateLabelDefinitionException, CoreException, IncludeFileNotFoundException, RecursiveInclusionException, InvalidDefineFormatException {
		rootDocument = new AssemblyDocument(file, this, null);
		documents.add(rootDocument);
		//TODO?
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

	public void assemble(DefaultControllableDCPU dcpu) {
		Assembler assembler = new Assembler(dcpu.ram);
		// TODO Auto-generated method stub
	}
}
