package devcpu.editors.dasm;

import org.eclipse.jface.text.TextAttribute;
import org.eclipse.jface.text.rules.BufferedRuleBasedScanner;
import org.eclipse.jface.text.rules.Token;

public class SingleTokenScanner  extends BufferedRuleBasedScanner {
    public SingleTokenScanner(TextAttribute attribute){
      setDefaultReturnToken(new Token(attribute));
    }
  }