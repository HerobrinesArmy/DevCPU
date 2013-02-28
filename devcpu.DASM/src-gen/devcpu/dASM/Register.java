/**
 */
package devcpu.dASM;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Register</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link devcpu.dASM.Register#getStandardRegister <em>Standard Register</em>}</li>
 *   <li>{@link devcpu.dASM.Register#getSpecialRegister <em>Special Register</em>}</li>
 * </ul>
 * </p>
 *
 * @see devcpu.dASM.DASMPackage#getRegister()
 * @model
 * @generated
 */
public interface Register extends NonGroupOperand
{
  /**
   * Returns the value of the '<em><b>Standard Register</b></em>' attribute.
   * The literals are from the enumeration {@link devcpu.dASM.StandardRegister}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Standard Register</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Standard Register</em>' attribute.
   * @see devcpu.dASM.StandardRegister
   * @see #setStandardRegister(StandardRegister)
   * @see devcpu.dASM.DASMPackage#getRegister_StandardRegister()
   * @model
   * @generated
   */
  StandardRegister getStandardRegister();

  /**
   * Sets the value of the '{@link devcpu.dASM.Register#getStandardRegister <em>Standard Register</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Standard Register</em>' attribute.
   * @see devcpu.dASM.StandardRegister
   * @see #getStandardRegister()
   * @generated
   */
  void setStandardRegister(StandardRegister value);

  /**
   * Returns the value of the '<em><b>Special Register</b></em>' attribute.
   * The literals are from the enumeration {@link devcpu.dASM.SpecialRegister}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Special Register</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Special Register</em>' attribute.
   * @see devcpu.dASM.SpecialRegister
   * @see #setSpecialRegister(SpecialRegister)
   * @see devcpu.dASM.DASMPackage#getRegister_SpecialRegister()
   * @model
   * @generated
   */
  SpecialRegister getSpecialRegister();

  /**
   * Sets the value of the '{@link devcpu.dASM.Register#getSpecialRegister <em>Special Register</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Special Register</em>' attribute.
   * @see devcpu.dASM.SpecialRegister
   * @see #getSpecialRegister()
   * @generated
   */
  void setSpecialRegister(SpecialRegister value);

} // Register
