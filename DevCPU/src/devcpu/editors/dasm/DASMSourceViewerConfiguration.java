package devcpu.editors.dasm;

import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.presentation.IPresentationReconciler;
import org.eclipse.jface.text.presentation.PresentationReconciler;
import org.eclipse.jface.text.rules.DefaultDamagerRepairer;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.jface.text.source.SourceViewerConfiguration;

import devcpu.lexer.LexerDamagerRepairer;

public class DASMSourceViewerConfiguration extends SourceViewerConfiguration {
	@Override
	public IPresentationReconciler getPresentationReconciler(ISourceViewer sourceViewer) {
		DASMColorProvider provider = DASMColorProvider.get();
		PresentationReconciler reconciler = new PresentationReconciler();
			
		LexerDamagerRepairer dr = new devcpu.lexer.LexerDamagerRepairer(); //DefaultDamagerRepairer(DASMInsaneCodeScanner.get());
		reconciler.setDamager(dr, IDocument.DEFAULT_CONTENT_TYPE);
		reconciler.setRepairer(dr, IDocument.DEFAULT_CONTENT_TYPE);

//		DefaultDamagerRepairer dr = new DefaultDamagerRepairer(new SingleTokenScanner(new TextAttribute(provider.getColor(DASMColorProvider.COMMENT))));
//		reconciler.setDamager(dr, DASMPartitionScanner.COMMENT);
//		reconciler.setRepairer(dr, DASMPartitionScanner.COMMENT);

//		dr= new DefaultDamagerRepairer(new SingleTokenScanner(new TextAttribute(provider.getColor(JavaColorProvider.MULTI_LINE_COMMENT))));
//		reconciler.setDamager(dr, JavaPartitionScanner.JAVA_MULTILINE_COMMENT);
//		reconciler.setRepairer(dr, JavaPartitionScanner.JAVA_MULTILINE_COMMENT);

		return reconciler;
	}
}
