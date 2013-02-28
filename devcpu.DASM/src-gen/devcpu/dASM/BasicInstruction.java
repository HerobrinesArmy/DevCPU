/**
 */
package devcpu.dASM;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Basic Instruction</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link devcpu.dASM.BasicInstruction#getOpcode <em>Opcode</em>}</li>
 *   <li>{@link devcpu.dASM.BasicInstruction#getB <em>B</em>}</li>
 * </ul>
 * </p>
 *
 * @see devcpu.dASM.DASMPackage#getBasicInstruction()
 * @model
 * @generated
 */
public interface BasicInstruction extends Instruction
{
  /**
   * Returns the value of the '<em><b>Opcode</b></em>' attribute.
   * The literals are from the enumeration {@link devcpu.dASM.BasicOpcode}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Opcode</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Opcode</em>' attribute.
   * @see devcpu.dASM.BasicOpcode
   * @see #setOpcode(BasicOpcode)
   * @see devcpu.dASM.DASMPackage#getBasicInstruction_Opcode()
   * @model
   * @generated
   */
  BasicOpcode getOpcode();

  /**
   * Sets the value of the '{@link devcpu.dASM.BasicInstruction#getOpcode <em>Opcode</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Opcode</em>' attribute.
   * @see devcpu.dASM.BasicOpcode
   * @see #getOpcode()
   * @generated
   */
  void setOpcode(BasicOpcode value);

  /**
   * Returns the value of the '<em><b>B</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>B</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>B</em>' containment reference.
   * @see #setB(Value)
   * @see devcpu.dASM.DASMPackage#getBasicInstruction_B()
   * @model containment="true"
   * @generated
   */
  Value getB();

  /**
   * Sets the value of the '{@link devcpu.dASM.BasicInstruction#getB <em>B</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>B</em>' containment reference.
   * @see #getB()
   * @generated
   */
  void setB(Value value);

} // BasicInstruction
