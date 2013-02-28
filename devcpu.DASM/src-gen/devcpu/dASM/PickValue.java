/**
 */
package devcpu.dASM;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Pick Value</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link devcpu.dASM.PickValue#getPickValue <em>Pick Value</em>}</li>
 * </ul>
 * </p>
 *
 * @see devcpu.dASM.DASMPackage#getPickValue()
 * @model
 * @generated
 */
public interface PickValue extends StackValue
{
  /**
   * Returns the value of the '<em><b>Pick Value</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Pick Value</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Pick Value</em>' containment reference.
   * @see #setPickValue(LiteralExpression)
   * @see devcpu.dASM.DASMPackage#getPickValue_PickValue()
   * @model containment="true"
   * @generated
   */
  LiteralExpression getPickValue();

  /**
   * Sets the value of the '{@link devcpu.dASM.PickValue#getPickValue <em>Pick Value</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Pick Value</em>' containment reference.
   * @see #getPickValue()
   * @generated
   */
  void setPickValue(LiteralExpression value);

} // PickValue
