/**
 */
package devcpu.dASM;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Operation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link devcpu.dASM.Operation#getLeft <em>Left</em>}</li>
 *   <li>{@link devcpu.dASM.Operation#getRight <em>Right</em>}</li>
 *   <li>{@link devcpu.dASM.Operation#getOp <em>Op</em>}</li>
 * </ul>
 * </p>
 *
 * @see devcpu.dASM.DASMPackage#getOperation()
 * @model
 * @generated
 */
public interface Operation extends Model, LiteralExpression
{
  /**
   * Returns the value of the '<em><b>Left</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Left</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Left</em>' containment reference.
   * @see #setLeft(EObject)
   * @see devcpu.dASM.DASMPackage#getOperation_Left()
   * @model containment="true"
   * @generated
   */
  EObject getLeft();

  /**
   * Sets the value of the '{@link devcpu.dASM.Operation#getLeft <em>Left</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Left</em>' containment reference.
   * @see #getLeft()
   * @generated
   */
  void setLeft(EObject value);

  /**
   * Returns the value of the '<em><b>Right</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Right</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Right</em>' containment reference.
   * @see #setRight(EObject)
   * @see devcpu.dASM.DASMPackage#getOperation_Right()
   * @model containment="true"
   * @generated
   */
  EObject getRight();

  /**
   * Sets the value of the '{@link devcpu.dASM.Operation#getRight <em>Right</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Right</em>' containment reference.
   * @see #getRight()
   * @generated
   */
  void setRight(EObject value);

  /**
   * Returns the value of the '<em><b>Op</b></em>' attribute.
   * The literals are from the enumeration {@link devcpu.dASM.Operator}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Op</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Op</em>' attribute.
   * @see devcpu.dASM.Operator
   * @see #setOp(Operator)
   * @see devcpu.dASM.DASMPackage#getOperation_Op()
   * @model
   * @generated
   */
  Operator getOp();

  /**
   * Sets the value of the '{@link devcpu.dASM.Operation#getOp <em>Op</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Op</em>' attribute.
   * @see devcpu.dASM.Operator
   * @see #getOp()
   * @generated
   */
  void setOp(Operator value);

} // Operation
