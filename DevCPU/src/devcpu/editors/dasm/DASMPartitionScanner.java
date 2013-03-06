package devcpu.editors.dasm;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.text.rules.EndOfLineRule;
import org.eclipse.jface.text.rules.ICharacterScanner;
import org.eclipse.jface.text.rules.IPartitionTokenScanner;
import org.eclipse.jface.text.rules.IPredicateRule;
import org.eclipse.jface.text.rules.IToken;
import org.eclipse.jface.text.rules.IWordDetector;
import org.eclipse.jface.text.rules.MultiLineRule;
import org.eclipse.jface.text.rules.RuleBasedPartitionScanner;
import org.eclipse.jface.text.rules.SingleLineRule;
import org.eclipse.jface.text.rules.Token;
import org.eclipse.jface.text.rules.WordRule;

public class DASMPartitionScanner extends RuleBasedPartitionScanner {

  public final static String JAVA_MULTILINE_COMMENT= "__java_multiline_comment"; //$NON-NLS-1$
  public final static String JAVA_DOC= "__java_javadoc"; //$NON-NLS-1$
  public final static String[] DASM_PARTITION_TYPES= new String[] { JAVA_MULTILINE_COMMENT, JAVA_DOC };
  private static DASMPartitionScanner scanner = new DASMPartitionScanner();
  
  /**
   * Detector for empty comments.
   */
  static class EmptyCommentDetector implements IWordDetector {

    /* (non-Javadoc)
    * Method declared on IWordDetector
     */
    public boolean isWordStart(char c) {
      return (c == '/');
    }

    /* (non-Javadoc)
    * Method declared on IWordDetector
     */
    public boolean isWordPart(char c) {
      return (c == '*' || c == '/');
    }
  }
  
  /**
   * 
   */
  static class WordPredicateRule extends WordRule implements IPredicateRule {
    
    private IToken fSuccessToken;
    
    public WordPredicateRule(IToken successToken) {
      super(new EmptyCommentDetector());
      fSuccessToken= successToken;
      addWord("/**/", fSuccessToken); //$NON-NLS-1$
    }
    
    /*
     * @see org.eclipse.jface.text.rules.IPredicateRule#evaluate(ICharacterScanner, boolean)
     */
    public IToken evaluate(ICharacterScanner scanner, boolean resume) {
      return super.evaluate(scanner);
    }

    /*
     * @see org.eclipse.jface.text.rules.IPredicateRule#getSuccessToken()
     */
    public IToken getSuccessToken() {
      return fSuccessToken;
    }
  }

  /**
   * Creates the partitioner and sets up the appropriate rules.
   */
  public DASMPartitionScanner() {
    super();

    IToken javaDoc= new Token(JAVA_DOC);
    IToken comment= new Token(JAVA_MULTILINE_COMMENT);

    List rules= new ArrayList();

    // Add rule for single line comments.
    rules.add(new EndOfLineRule("//", Token.UNDEFINED)); //$NON-NLS-1$

    // Add rule for strings and character constants.
    rules.add(new SingleLineRule("\"", "\"", Token.UNDEFINED, '\\')); //$NON-NLS-2$ //$NON-NLS-1$
    rules.add(new SingleLineRule("'", "'", Token.UNDEFINED, '\\')); //$NON-NLS-2$ //$NON-NLS-1$

    // Add special case word rule.
    rules.add(new WordPredicateRule(comment));

    // Add rules for multi-line comments and javadoc.
    rules.add(new MultiLineRule("/**", "*/", javaDoc, (char) 0, true)); //$NON-NLS-1$ //$NON-NLS-2$
    rules.add(new MultiLineRule("/*", "*/", comment, (char) 0, true)); //$NON-NLS-1$ //$NON-NLS-2$

    IPredicateRule[] result= new IPredicateRule[rules.size()];
    rules.toArray(result);
    setPredicateRules(result);
  }

	public static DASMPartitionScanner get() {
		return scanner;
	}
}