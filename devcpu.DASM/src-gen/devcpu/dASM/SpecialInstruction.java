/**
 */
package devcpu.dASM;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Special Instruction</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link devcpu.dASM.SpecialInstruction#getOpcode <em>Opcode</em>}</li>
 * </ul>
 * </p>
 *
 * @see devcpu.dASM.DASMPackage#getSpecialInstruction()
 * @model
 * @generated
 */
public interface SpecialInstruction extends Instruction
{
  /**
   * Returns the value of the '<em><b>Opcode</b></em>' attribute.
   * The literals are from the enumeration {@link devcpu.dASM.SpecialOpcode}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Opcode</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Opcode</em>' attribute.
   * @see devcpu.dASM.SpecialOpcode
   * @see #setOpcode(SpecialOpcode)
   * @see devcpu.dASM.DASMPackage#getSpecialInstruction_Opcode()
   * @model
   * @generated
   */
  SpecialOpcode getOpcode();

  /**
   * Sets the value of the '{@link devcpu.dASM.SpecialInstruction#getOpcode <em>Opcode</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Opcode</em>' attribute.
   * @see devcpu.dASM.SpecialOpcode
   * @see #getOpcode()
   * @generated
   */
  void setOpcode(SpecialOpcode value);

} // SpecialInstruction
