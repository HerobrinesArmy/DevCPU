package devcpu.assembler;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.regex.Pattern;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;

import devcpu.assembler.exceptions.DuplicateLabelDefinitionException;
import devcpu.assembler.exceptions.IncludeFileNotFoundException;
import devcpu.assembler.exceptions.InvalidDefineFormatException;
import devcpu.assembler.exceptions.RecursiveDefinitionException;
import devcpu.assembler.exceptions.RecursiveInclusionException;
import devcpu.emulation.DefaultControllableDCPU;
import devcpu.lexer.Lexer;
import devcpu.lexer.tokens.LabelDefinitionToken;
import devcpu.lexer.tokens.LabelToken;
import devcpu.lexer.tokens.LexerToken;

public class Assembly {
	//Note: Defines will not be processed in directives
	public static final boolean DEFAULT_LABELS_CASE_SENSITIVE = true;
	private AssemblyDocument rootDocument;
	private ArrayList<AssemblyDocument> documents = new ArrayList<AssemblyDocument>();
	private boolean labelsCaseSensitive = DEFAULT_LABELS_CASE_SENSITIVE;
	
	public ArrayList<AssemblyLine> lines = new ArrayList<AssemblyLine>();
	public LinkedHashMap<String,String> defines = new LinkedHashMap<String, String>();
	public LinkedHashMap<String,LabelDefinition> labelDefs = new LinkedHashMap<String, LabelDefinition>();
	public LinkedHashMap<String,List<LabelUse>> labelUses = new LinkedHashMap<String, List<LabelUse>>();

	public Assembly(IFile file) throws IOException, DuplicateLabelDefinitionException, CoreException, IncludeFileNotFoundException, RecursiveInclusionException, InvalidDefineFormatException, RecursiveDefinitionException {
		rootDocument = new AssemblyDocument(file, this, null);
		documents.add(rootDocument);
		//TODO: Evaluate what should really be in the constructor and what should wait until assemble
		processDefinesAndCollectLabels();
		//TODO?
	}

	private void processDefinesAndCollectLabels() throws DuplicateLabelDefinitionException {
		//Note: Label collection can be done here now, but directives added later could necessitate
		//moving this until after all preprocessing is done.
		LinkedHashMap<Pattern,String> patterns = new LinkedHashMap<Pattern, String>();
		for (String key : defines.keySet()) {
			patterns.put(Pattern.compile("\\b"+Pattern.quote(key)+"\\b"), defines.get(key));
		}
		for (AssemblyLine line : lines) {
			if (!line.isDirective()) {
				boolean retokenize = false;
				String text = line.getText();
				for (Pattern pattern : patterns.keySet()) {
					if (pattern.matcher(text).find()) {
						retokenize = true;
						text = text.replaceAll(pattern.pattern(), patterns.get(pattern));
					}
				}
				if (retokenize) {
					line.setProcessedTokens(Lexer.get().generateTokens(text, true));
				}
				for (LexerToken token : line.getTokens()) {
					if (token instanceof LabelDefinitionToken) {
						LabelDefinition labelDef = new LabelDefinition(line, (LabelDefinitionToken) token, labelsCaseSensitive);
						if (labelDefs.containsKey(labelDef.getLabelName())) {
							throw new DuplicateLabelDefinitionException(labelDefs.get(labelDef.getLabelName()),labelDef);
						}
						labelDefs.put(labelDef.getLabelName(), labelDef);
					} else if (token instanceof LabelToken) {
						LabelUse labelUse = new LabelUse(line, (LabelToken) token, labelsCaseSensitive);
						if (!labelUses.containsKey(labelUse.getLabelName())) {
							labelUses.put(labelUse.getLabelName(), new ArrayList<LabelUse>());
						}
						labelUses.get(labelUse.getLabelName()).add(labelUse);
					}
				}
			}
			//TODO: Check for validity here?
		}
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
