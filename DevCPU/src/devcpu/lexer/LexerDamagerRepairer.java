package devcpu.lexer;

import org.eclipse.debug.internal.ui.ColorManager;
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


public class LexerDamagerRepairer implements IPresentationRepairer, IPresentationDamager {

	private static final Color DEFAULT_FOREGROUND = ColorManager.getDefault().getColor(new RGB(0, 0, 0));
	private static final Color DEFAULT_BACKGROUND = ColorManager.getDefault().getColor(new RGB(255, 255, 255));
	
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
		Lexer lexer = new Lexer();
		//TODO
		LexerToken[] tokens = lexer.generateTokens(document.get());
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
			} else {
				presentation.addStyleRange(new StyleRange(token.getOffset(), token.getLength(), DEFAULT_FOREGROUND, DEFAULT_BACKGROUND, SWT.NORMAL));
			}
		}
	}
}
