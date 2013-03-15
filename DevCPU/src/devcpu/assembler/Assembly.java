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
import devcpu.lexer.tokens.AValueEndToken;
import devcpu.lexer.tokens.AValueStartToken;
import devcpu.lexer.tokens.AddressEndToken;
import devcpu.lexer.tokens.AddressStartToken;
import devcpu.lexer.tokens.BValueEndToken;
import devcpu.lexer.tokens.BasicOpCodeToken;
import devcpu.lexer.tokens.DataToken;
import devcpu.lexer.tokens.DataValueEndToken;
import devcpu.lexer.tokens.DataValueStartToken;
import devcpu.lexer.tokens.LabelDefinitionToken;
import devcpu.lexer.tokens.LabelToken;
import devcpu.lexer.tokens.LexerToken;
import devcpu.lexer.tokens.LiteralToken;
import devcpu.lexer.tokens.RegisterToken;
import devcpu.lexer.tokens.SimpleStackAccessToken;
import devcpu.lexer.tokens.SpecialOpCodeToken;
import devcpu.lexer.tokens.StringToken;

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
		sizeAndLocateLines();
		Assembler assembler = new Assembler(dcpu.ram);
		//TODO
	}

	private void sizeAndLocateLines() {
		int o = 0;
		for (AssemblyLine line : lines) {
			if (line.isDirective()) {
				//TODO: Add origin directive (and other) handling here
				line.setOffset(-1);
			} else {
				line.setOffset(o);
				o += sizeLine(line);
//				System.out.println(line.getOffset() + ": (" + line.getSize() + ") " + line.getText());
			}
		}
	}

	private int sizeLine(AssemblyLine line) {
		//TODO Note: Rule for now is: Use of labels or expressions disables short form literal optimization
		//TODO: Handle the -1 case (unary operator token)
		//Also, after looking over how you've done sizing here, you might want to check yourself into hospital for evaluation
		int size = 0;
		LexerToken[] tokens = line.getProcessedTokens();
		for (int i = 0; i < tokens.length; i++) {// LexerToken token : line.getProcessedTokens()) {
			LexerToken token = tokens[i];
			if (token instanceof BasicOpCodeToken) {
				size++;
				//Check if the b Value is a simple stack accessor or register
				if (tokens[(i+=2)] instanceof LiteralToken) {
					size++;
				} else if (tokens[i] instanceof RegisterToken) {
					if (!(tokens[i+1] instanceof BValueEndToken)) {
						size++;
					}
				} else if (tokens[i] instanceof AddressStartToken) {
					if (tokens[++i] instanceof RegisterToken) {
						if (!(tokens[++i] instanceof AddressEndToken)) {
							size++;
						}
					} else {
						size++;
					}
				} else if (tokens[i] instanceof SimpleStackAccessToken) {
				} else {
					size++;
				}
				while (!(tokens[++i] instanceof AValueStartToken)) {}
				//Check the a Value (can also be a non-expression non-label literal and meet short literal requirements)
				if (tokens[++i] instanceof LiteralToken) {
					if (tokens[i+1] instanceof AValueEndToken) {
						char val = (char) (((LiteralToken)tokens[i]).getValue() & 0xFFFF);
						if (val >= 31 && val != 0xFFFF) {
							size++;
						}
					} else {
						size++;
					}
				} else if (tokens[i] instanceof RegisterToken) {
					if (!(tokens[i+1] instanceof AValueEndToken)) {
						size++;
					}
				} else if (tokens[i] instanceof AddressStartToken) {
					if (tokens[++i] instanceof RegisterToken) {
						if (!(tokens[++i] instanceof AddressEndToken)) {
							size++;
						}
					} else {
						size++;
					}
				} else if (tokens[i] instanceof SimpleStackAccessToken) {
				} else {
					size++;
				}
			} else if (token instanceof SpecialOpCodeToken) {
				size++;
				if (tokens[(i+=2)] instanceof LiteralToken) {
					if (tokens[i+1] instanceof AValueEndToken) {
						char val = (char) (((LiteralToken)tokens[i]).getValue() & 0xFFFF);
						if (val >= 31 && val != 0xFFFF) {
							size++;
						}
					} else {
						size++;
					}
				} else if (tokens[i] instanceof RegisterToken) {
					if (!(tokens[i+1] instanceof AValueEndToken)) {
						size++;
					}
				} else if (tokens[i] instanceof AddressStartToken) {
					if (tokens[++i] instanceof RegisterToken) {
						if (!(tokens[++i] instanceof AddressEndToken)) {
							size++;
						}
					} else {
						size++;
					}
				} else if (tokens[i] instanceof SimpleStackAccessToken) {
				} else {
					size++;
				}
			} else if (token instanceof DataToken) {
				i++;
				while (i < tokens.length && tokens[i] instanceof DataValueStartToken) {
					token = tokens[++i];
					if (!(tokens[i+1] instanceof DataValueEndToken)) {
						size++;
						while (!(tokens[++i] instanceof DataValueEndToken)) {}
					} else {
						if (token instanceof StringToken) {
							//TODO: Decide whether strings should default to packed or not (currently they are not, and non-ascii characters are allowed in the string)
							size += ((StringToken)token).getString().length();
						} else {
							//TODO: Do individual conditions for each possible value type?
							size++;
						}
						i++;
					}
					i++;
				}
			}
		}
		line.setSize(size);
		return size;
	}
}
