package devcpu.editors.dasm;
import org.eclipse.jface.text.rules.IWordDetector;

/**
 * A DASM aware word detector.
 */
public class JavaWordDetector implements IWordDetector {
  public boolean isWordPart(char character) {
    return Character.isJavaIdentifierPart(character);
  }
  
  public boolean isWordStart(char character) {
    return Character.isJavaIdentifierStart(character);
  }
}
