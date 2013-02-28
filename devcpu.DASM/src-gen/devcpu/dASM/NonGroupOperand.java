/**
 */
package devcpu.dASM;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Non Group Operand</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link devcpu.dASM.NonGroupOperand#getLabelName <em>Label Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see devcpu.dASM.DASMPackage#getNonGroupOperand()
 * @model
 * @generated
 */
public interface NonGroupOperand extends EObject
{
  /**
   * Returns the value of the '<em><b>Label Name</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Label Name</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Label Name</em>' reference.
   * @see #setLabelName(Label)
   * @see devcpu.dASM.DASMPackage#getNonGroupOperand_LabelName()
   * @model
   * @generated
   */
  Label getLabelName();

  /**
   * Sets the value of the '{@link devcpu.dASM.NonGroupOperand#getLabelName <em>Label Name</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Label Name</em>' reference.
   * @see #getLabelName()
   * @generated
   */
  void setLabelName(Label value);

} // NonGroupOperand
