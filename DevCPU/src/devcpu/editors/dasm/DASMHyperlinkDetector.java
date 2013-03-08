package devcpu.editors.dasm;

import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.hyperlink.AbstractHyperlinkDetector;
import org.eclipse.jface.text.hyperlink.IHyperlink;
import org.eclipse.jface.text.hyperlink.IHyperlinkDetector;

import devcpu.lexer.Lexer;
import devcpu.lexer.tokens.LexerToken;

public class DASMHyperlinkDetector extends AbstractHyperlinkDetector {
	private static final IHyperlinkDetector detector = new DASMHyperlinkDetector();

	@Override
	public IHyperlink[] detectHyperlinks(ITextViewer textViewer, IRegion region, boolean canShowMultipleHyperlinks) {
		LexerToken token = Lexer.get().getTokenAt(region.getOffset());
		//TODO
//		if (token instanceof LabelToken) {
//			System.out.println(token);
//			return new IHyperlink
//		}
		return null;
	}

	public static IHyperlinkDetector get() {
		return detector ;
	}
}
