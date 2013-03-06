package devcpu.lexer;

import java.util.ArrayList;

import org.eclipse.jface.text.DocumentEvent;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IDocumentPartitioner;
import org.eclipse.jface.text.ITypedRegion;
import org.eclipse.jface.text.TypedRegion;

public class LexerPartitioner implements IDocumentPartitioner {
	private IDocument document;
	private Lexer lexer = Lexer.get();
	private LexerToken[] tokens;

	@Override
	public void connect(IDocument document) {
		this.document = document;
	}

	@Override
	public void disconnect() {
		this.document = null;
	}

	@Override
	public void documentAboutToBeChanged(DocumentEvent event) {
		// TODO Auto-generated method stub
	}

	@Override
	public boolean documentChanged(DocumentEvent event) {
		String fullText = event.fDocument.get();
		this.tokens = lexer.generateTokens(fullText);
		return true;
	}

	@Override
	public String[] getLegalContentTypes() {
		return lexer.getLegalContentTypes();
	}

	@Override
	public String getContentType(int offset) {
		for (LexerToken token : tokens) {
			if (token.getStart() > offset) {
				return "DASM_NOTHING";
			}
			if (token.getEnd() > offset) {
				return token.getType();
			}
		}
		return "DASM_NOTHING";
	}

	@Override
	public ITypedRegion[] computePartitioning(int offset, int length) {
		ArrayList<ITypedRegion> regions = new ArrayList<ITypedRegion>();
		for (LexerToken token : tokens) {
			if (token.getStart() >= offset || token.getEnd() < offset + length || (token.getStart() < offset && token.getEnd() >= offset + length)) {
				regions.add(token);
			} else if (token.getStart() >= offset + length) {
				break;
			}
		}
		return (ITypedRegion[]) regions.toArray();
	}

	@Override
	public ITypedRegion getPartition(int offset) {
		int lastEnd = 0;
		for (LexerToken token : tokens) {
			if (token.getStart() > offset) {
				return new TypedRegion(lastEnd, token.getStart()-lastEnd, "DASM_NOTHING");
			}
			lastEnd = token.getEnd();
		}
		return new TypedRegion(lastEnd, document.getLength()-offset-1, "DASM_NOTHING");
	}
}
