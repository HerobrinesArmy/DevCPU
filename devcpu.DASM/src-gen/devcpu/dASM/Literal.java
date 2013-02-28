/**
 */
package devcpu.dASM;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Literal</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link devcpu.dASM.Literal#getNumber <em>Number</em>}</li>
 * </ul>
 * </p>
 *
 * @see devcpu.dASM.DASMPackage#getLiteral()
 * @model
 * @generated
 */
public interface Literal extends NonGroupOperand
{
  /**
   * Returns the value of the '<em><b>Number</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Number</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Number</em>' attribute.
   * @see #setNumber(String)
   * @see devcpu.dASM.DASMPackage#getLiteral_Number()
   * @model
   * @generated
   */
  String getNumber();

  /**
   * Sets the value of the '{@link devcpu.dASM.Literal#getNumber <em>Number</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Number</em>' attribute.
   * @see #getNumber()
   * @generated
   */
  void setNumber(String value);

} // Literal
