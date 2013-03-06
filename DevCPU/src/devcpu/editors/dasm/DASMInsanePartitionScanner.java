package devcpu.editors.dasm;

import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.rules.IPartitionTokenScanner;
import org.eclipse.jface.text.rules.IToken;
import org.eclipse.jface.text.rules.Token;

public class DASMInsanePartitionScanner implements IPartitionTokenScanner {

//  public final static String JAVA_MULTILINE_COMMENT= "__java_multiline_comment"; //$NON-NLS-1$
//  public final static String JAVA_DOC= "__java_javadoc"; //$NON-NLS-1$
  public final static String[] DASM_PARTITION_TYPES= new String[] {};
  private static DASMInsanePartitionScanner scanner = new DASMInsanePartitionScanner();
	private IDocument document;
	private int offset;
	private int length;
  
  public DASMInsanePartitionScanner() {
  }

	public static DASMInsanePartitionScanner get() {
		return scanner;
	}

	@Override
	public void setRange(IDocument document, int offset, int length) {
		this.document = document;
		this.offset = offset;
		this.length = length;
	}

	@Override
	public IToken nextToken() {
		try {
			if (length > 0) {
				IToken token = new Token(document.get(offset, length));
				offset += length;
				length = 0;
				return token;
			} else {
				return Token.EOF;
			}
				
		} catch (BadLocationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int getTokenOffset() {
		// TODO Auto-generated method stub
		return offset;
	}

	@Override
	public int getTokenLength() {
		// TODO Auto-generated method stub
		return length;
	}

	@Override
	public void setPartialRange(IDocument document, int offset, int length,
			String contentType, int partitionOffset) {
		// TODO Auto-generated method stub
		
	}
}