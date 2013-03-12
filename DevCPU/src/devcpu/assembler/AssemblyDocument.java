package devcpu.assembler;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import org.eclipse.core.resources.IFile;

import devcpu.lexer.Lexer;
import devcpu.lexer.tokens.DirectiveParametersToken;
import devcpu.lexer.tokens.DirectiveToken;
import devcpu.lexer.tokens.LabelDefinitionToken;
import devcpu.lexer.tokens.LabelToken;
import devcpu.lexer.tokens.LexerToken;

public class AssemblyDocument {
	private IFile file;
	private ArrayList<AssemblyLine> lines;
	private ArrayList<Directive> directives = new ArrayList<Directive>();
	private ArrayList<Directive> includes = new ArrayList<Directive>();
	private LinkedHashMap<String,LabelDefinition> labelDefs = new LinkedHashMap<String, LabelDefinition>();
	private LinkedHashMap<String,List<LabelUse>> labelUses = new LinkedHashMap<String, List<LabelUse>>();
	private Assembly assembly;

	public AssemblyDocument(IFile file, Assembly assembly) throws Exception {
		this.file = file;
		//TODO This setup sucks. Documents should be dumb and shouldn't need a reference to the assembly. Rework this in a later release.
		this.assembly = assembly;
		readLines();
	}

	private void readLines() throws Exception {
		//TODO prompt if unsync?
		BufferedReader isr = new BufferedReader(new InputStreamReader(file.getContents(true)));
		lines = new ArrayList<AssemblyLine>();
		String lineText = null;
		int n = 0;
		while((lineText=isr.readLine()) != null) {
			AssemblyLine line = new AssemblyLine(this, ++n, lineText, Lexer.get().generateTokens(lineText, true));
			Directive directive = null;
			for (LexerToken token : line.getTokens()) {
				if (token instanceof DirectiveToken) {
					directive = new Directive(line, (DirectiveToken) token);
				} else if (token instanceof DirectiveParametersToken) {
					directive.setParameters((DirectiveParametersToken)token);
					directives.add(directive);
					if (directive.isInclude()) {
						includes.add(directive);
					}
				} else if (token instanceof LabelDefinitionToken) {
					LabelDefinition labelDef = new LabelDefinition(line, (LabelDefinitionToken) token, assembly.isLabelsCaseSensitive());
					if (labelDefs.containsKey(labelDef.getLabelName())) {
						throw new DuplicateLabelDefinitionException(labelDefs.get(labelDef.getLabelName()),labelDef);
					}
					labelDefs.put(labelDef.getLabelName(), labelDef);
				} else if (token instanceof LabelToken) {
					LabelUse labelUse = new LabelUse(line, (LabelToken) token, assembly.isLabelsCaseSensitive());
					if (!labelUses.containsKey(labelUse.getLabelName())) {
						labelUses.put(labelUse.getLabelName(), new ArrayList<LabelUse>());
					}
					labelUses.get(labelUse.getLabelName()).add(labelUse);
				}
			}
			lines.add(line);
		}		
	}

	public IFile getFile() {
		return file;
	}
}
