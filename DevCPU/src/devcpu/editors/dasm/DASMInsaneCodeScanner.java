package devcpu.editors.dasm;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.TextAttribute;
import org.eclipse.jface.text.rules.EndOfLineRule;
import org.eclipse.jface.text.rules.IRule;
import org.eclipse.jface.text.rules.IToken;
import org.eclipse.jface.text.rules.ITokenScanner;
import org.eclipse.jface.text.rules.SingleLineRule;
import org.eclipse.jface.text.rules.Token;
import org.eclipse.jface.text.rules.WhitespaceRule;
import org.eclipse.jface.text.rules.WordRule;

public class DASMInsaneCodeScanner implements ITokenScanner {

	private static DASMInsaneCodeScanner scanner = new DASMInsaneCodeScanner(DASMColorProvider.get());

  /**
   * Creates a DASM code scanner with the given color provider.
   * 
   * @param provider the color provider
   */
  public DASMInsaneCodeScanner(DASMColorProvider provider) {
  }

	public static DASMInsaneCodeScanner get() {
		return scanner;
	}

	@Override
	public void setRange(IDocument document, int offset, int length) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public IToken nextToken() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getTokenOffset() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getTokenLength() {
		// TODO Auto-generated method stub
		return 0;
	}
}
