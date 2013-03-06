package devcpu.editors.dasm;
import org.eclipse.jface.text.rules.IWhitespaceDetector;

/**
 * A DASM aware white space detector.
 */
public class DASMWhitespaceDetector implements IWhitespaceDetector {
  public boolean isWhitespace(char character) {
    return Character.isWhitespace(character);
  }
}