/**
 */
package devcpu.dASM;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Literal Address</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link devcpu.dASM.LiteralAddress#getNumber <em>Number</em>}</li>
 *   <li>{@link devcpu.dASM.LiteralAddress#getLabelName <em>Label Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see devcpu.dASM.DASMPackage#getLiteralAddress()
 * @model
 * @generated
 */
public interface LiteralAddress extends EObject
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
   * @see devcpu.dASM.DASMPackage#getLiteralAddress_Number()
   * @model
   * @generated
   */
  String getNumber();

  /**
   * Sets the value of the '{@link devcpu.dASM.LiteralAddress#getNumber <em>Number</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Number</em>' attribute.
   * @see #getNumber()
   * @generated
   */
  void setNumber(String value);

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
   * @see devcpu.dASM.DASMPackage#getLiteralAddress_LabelName()
   * @model
   * @generated
   */
  Label getLabelName();

  /**
   * Sets the value of the '{@link devcpu.dASM.LiteralAddress#getLabelName <em>Label Name</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Label Name</em>' reference.
   * @see #getLabelName()
   * @generated
   */
  void setLabelName(Label value);

} // LiteralAddress
