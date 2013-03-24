package devcpu.editors.dasm;

import org.eclipse.jface.text.DocumentEvent;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.ITypedRegion;
import org.eclipse.jface.text.TextPresentation;
import org.eclipse.jface.text.presentation.IPresentationDamager;
import org.eclipse.jface.text.presentation.IPresentationRepairer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyleRange;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.RGB;

import devcpu.lexer.Lexer;
import devcpu.lexer.tokens.BasicOpCodeToken;
import devcpu.lexer.tokens.CommentToken;
import devcpu.lexer.tokens.DataToken;
import devcpu.lexer.tokens.DirectiveParametersToken;
import devcpu.lexer.tokens.DirectiveToken;
import devcpu.lexer.tokens.LabelDefinitionToken;
import devcpu.lexer.tokens.LexerToken;
import devcpu.lexer.tokens.LiteralToken;
import devcpu.lexer.tokens.OffsetStackAccessToken;
import devcpu.lexer.tokens.RegisterToken;
import devcpu.lexer.tokens.SimpleStackAccessToken;
import devcpu.lexer.tokens.SpecialOpCodeToken;
import devcpu.lexer.tokens.StringToken;


public class DASMDamagerRepairer implements IPresentationRepairer, IPresentationDamager {

	private static final Color DEFAULT_FOREGROUND = DASMColorProvider.get().getColor(new RGB(0, 0, 0));
	private static final Color DEFAULT_BACKGROUND = DASMColorProvider.get().getColor(new RGB(255, 255, 255));
	
	private IDocument document;

	@Override
	public IRegion getDamageRegion(ITypedRegion partition, DocumentEvent event, boolean documentPartitioningChanged) {
		// TODO Auto-generated method stub
		return partition;
	}

	@Override
	public void setDocument(IDocument document) {
		this.document = document;
	}

	@Override
	public void createPresentation(TextPresentation presentation, ITypedRegion damage) {
		//TODO read from preferences store
		LexerToken[] tokens = Lexer.get().generateTokens(document.get());
		for (LexerToken token : tokens) {
			if ("DASM_COMMENT".equals(token.getType())) {
				presentation.addStyleRange(new StyleRange(token.getOffset(), token.getLength(), CommentToken.FOREGROUND, CommentToken.BACKGROUND, SWT.NORMAL));	
			} else if ("DASM_LABEL_DEFINITION".equals(token.getType())) {
				presentation.addStyleRange(new StyleRange(token.getOffset(), token.getLength(), LabelDefinitionToken.FOREGROUND, LabelDefinitionToken.BACKGROUND, SWT.NORMAL));
			} else if ("DASM_SPECIAL_OPCODE".equals(token.getType())) {
				presentation.addStyleRange(new StyleRange(token.getOffset(), token.getLength(), SpecialOpCodeToken.FOREGROUND, SpecialOpCodeToken.BACKGROUND, SWT.BOLD));
			} else if ("DASM_BASIC_OPCODE".equals(token.getType())) {
				presentation.addStyleRange(new StyleRange(token.getOffset(), token.getLength(), BasicOpCodeToken.FOREGROUND, BasicOpCodeToken.BACKGROUND, SWT.BOLD));
			} else if ("DASM_LITERAL".equals(token.getType())) {
				presentation.addStyleRange(new StyleRange(token.getOffset(), token.getLength(), LiteralToken.FOREGROUND, LiteralToken.BACKGROUND, SWT.NORMAL));
			} else if ("DASM_REGISTER".equals(token.getType())) {
				presentation.addStyleRange(new StyleRange(token.getOffset(), token.getLength(), RegisterToken.FOREGROUND, RegisterToken.BACKGROUND, SWT.BOLD));
			} else if ("DASM_STRING".equals(token.getType())) {
				presentation.addStyleRange(new StyleRange(token.getOffset(), token.getLength(), StringToken.FOREGROUND, StringToken.BACKGROUND, SWT.NORMAL));
			} else if ("DASM_DATA".equals(token.getType())) {
				presentation.addStyleRange(new StyleRange(token.getOffset(), token.getLength(), DataToken.FOREGROUND, DataToken.BACKGROUND, SWT.BOLD));
			} else if ("DASM_DIRECTIVE".equals(token.getType())) {
				presentation.addStyleRange(new StyleRange(token.getOffset(), token.getLength(), DirectiveToken.FOREGROUND, DirectiveToken.BACKGROUND, SWT.BOLD));
			} else if ("DASM_DIRECTIVE_PARAMETERS".equals(token.getType())) {
				presentation.addStyleRange(new StyleRange(token.getOffset(), token.getLength(), DirectiveParametersToken.FOREGROUND, DirectiveParametersToken.BACKGROUND, SWT.NORMAL));
			} else if ("DASM_SIMPLE_STACK_ACCESS".equals(token.getType())) {
				presentation.addStyleRange(new StyleRange(token.getOffset(), token.getLength(), SimpleStackAccessToken.FOREGROUND, SimpleStackAccessToken.BACKGROUND, SWT.BOLD));
			} else if ("DASM_OFFSET_STACK_ACCESS".equals(token.getType())) {
				presentation.addStyleRange(new StyleRange(token.getOffset(), token.getLength(), OffsetStackAccessToken.FOREGROUND, OffsetStackAccessToken.BACKGROUND, SWT.BOLD));
			} else {
				presentation.addStyleRange(new StyleRange(token.getOffset(), token.getLength(), DEFAULT_FOREGROUND, DEFAULT_BACKGROUND, SWT.NORMAL));
			}
		}
	}
}
