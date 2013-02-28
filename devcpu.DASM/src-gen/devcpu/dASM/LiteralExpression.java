/**
 */
package devcpu.dASM;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Literal Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link devcpu.dASM.LiteralExpression#getValue <em>Value</em>}</li>
 * </ul>
 * </p>
 *
 * @see devcpu.dASM.DASMPackage#getLiteralExpression()
 * @model
 * @generated
 */
public interface LiteralExpression extends Value, AddressExpression
{
  /**
   * Returns the value of the '<em><b>Value</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Value</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Value</em>' containment reference.
   * @see #setValue(NonGroupOperand)
   * @see devcpu.dASM.DASMPackage#getLiteralExpression_Value()
   * @model containment="true"
   * @generated
   */
  NonGroupOperand getValue();

  /**
   * Sets the value of the '{@link devcpu.dASM.LiteralExpression#getValue <em>Value</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Value</em>' containment reference.
   * @see #getValue()
   * @generated
   */
  void setValue(NonGroupOperand value);

} // LiteralExpression
