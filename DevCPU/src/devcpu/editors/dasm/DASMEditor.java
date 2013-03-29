package devcpu.editors.dasm;

import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.jface.text.source.IVerticalRuler;
import org.eclipse.jface.text.source.SourceViewer;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.editors.text.TextEditor;
import org.eclipse.ui.editors.text.TextFileDocumentProvider;
import org.eclipse.ui.texteditor.IDocumentProvider;

public class DASMEditor extends TextEditor {

	private TextFileDocumentProvider documentProvider = new DASMFileDocumentProvider();

	@Override
	public IDocumentProvider getDocumentProvider() {
		return documentProvider;
	}
	
	@Override
	protected void initializeEditor() {
		super.initializeEditor();
		setSourceViewerConfiguration(new DASMSourceViewerConfiguration());
	}

	@Override
	protected ISourceViewer createSourceViewer(Composite parent, IVerticalRuler ruler, int styles) {
		ISourceViewer sourceViewer= new SourceViewer(parent, ruler, styles);
//		fSourceViewerDecorationSupport= new SourceViewerDecorationSupport(sourceViewer, fOverviewRuler, fAnnotationAccess, sharedColors);
//		configureSourceViewerDecorationSupport();
			
		return sourceViewer;
	}
	
//	protected void configureSourceViewerDecorationSupport() {
//
//		Iterator e= fAnnotationPreferences.getAnnotationPreferences().iterator();
//		while (e.hasNext())
//			fSourceViewerDecorationSupport.setAnnotationPreference((AnnotationPreference) e.next());
//		fSourceViewerDecorationSupport.setAnnotationPainterPreferenceKeys(DefaultMarkerAnnotationAccess.UNKNOWN, UNKNOWN_INDICATION_COLOR, UNKNOWN_INDICATION, UNKNOWN_INDICATION_IN_OVERVIEW_RULER, 0);
//			
//		fSourceViewerDecorationSupport.setCursorLinePainterPreferenceKeys(CURRENT_LINE, CURRENT_LINE_COLOR);
//		fSourceViewerDecorationSupport.setMarginPainterPreferenceKeys(PRINT_MARGIN, PRINT_MARGIN_COLOR, PRINT_MARGIN_COLUMN);
//		fSourceViewerDecorationSupport.setSymbolicFontName(getFontPropertyPreferenceKey());
//	}
}
