package devcpu.editors.dasm;

import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.hyperlink.IHyperlinkDetector;
import org.eclipse.jface.text.presentation.IPresentationReconciler;
import org.eclipse.jface.text.presentation.PresentationReconciler;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.jface.text.source.SourceViewerConfiguration;

public class DASMSourceViewerConfiguration extends SourceViewerConfiguration {
	@Override
	public IPresentationReconciler getPresentationReconciler(ISourceViewer sourceViewer) {
//		DASMColorProvider provider = DASMColorProvider.get();
		PresentationReconciler reconciler = new PresentationReconciler();
		DASMDamagerRepairer dr = new devcpu.editors.dasm.DASMDamagerRepairer(); //DefaultDamagerRepairer(DASMInsaneCodeScanner.get());
		reconciler.setDamager(dr, IDocument.DEFAULT_CONTENT_TYPE);
		reconciler.setRepairer(dr, IDocument.DEFAULT_CONTENT_TYPE);
		return reconciler;
	}
	
	@Override
	public IHyperlinkDetector[] getHyperlinkDetectors(ISourceViewer sourceViewer) {
		return new IHyperlinkDetector[]{DASMHyperlinkDetector.get()};
	}
}
