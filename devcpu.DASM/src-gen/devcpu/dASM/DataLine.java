/**
 */
package devcpu.dASM;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Data Line</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link devcpu.dASM.DataLine#getDataElements <em>Data Elements</em>}</li>
 * </ul>
 * </p>
 *
 * @see devcpu.dASM.DASMPackage#getDataLine()
 * @model
 * @generated
 */
public interface DataLine extends LineContent
{
  /**
   * Returns the value of the '<em><b>Data Elements</b></em>' attribute list.
   * The list contents are of type {@link java.lang.String}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Data Elements</em>' attribute list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Data Elements</em>' attribute list.
   * @see devcpu.dASM.DASMPackage#getDataLine_DataElements()
   * @model unique="false"
   * @generated
   */
  EList<String> getDataElements();

} // DataLine
