/**
 */
package devcpu.dASM;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Line Definition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link devcpu.dASM.LineDefinition#getLabels <em>Labels</em>}</li>
 *   <li>{@link devcpu.dASM.LineDefinition#getContent <em>Content</em>}</li>
 *   <li>{@link devcpu.dASM.LineDefinition#getComment <em>Comment</em>}</li>
 * </ul>
 * </p>
 *
 * @see devcpu.dASM.DASMPackage#getLineDefinition()
 * @model
 * @generated
 */
public interface LineDefinition extends Model
{
  /**
   * Returns the value of the '<em><b>Labels</b></em>' containment reference list.
   * The list contents are of type {@link devcpu.dASM.Label}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Labels</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Labels</em>' containment reference list.
   * @see devcpu.dASM.DASMPackage#getLineDefinition_Labels()
   * @model containment="true"
   * @generated
   */
  EList<Label> getLabels();

  /**
   * Returns the value of the '<em><b>Content</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Content</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Content</em>' containment reference.
   * @see #setContent(LineContent)
   * @see devcpu.dASM.DASMPackage#getLineDefinition_Content()
   * @model containment="true"
   * @generated
   */
  LineContent getContent();

  /**
   * Sets the value of the '{@link devcpu.dASM.LineDefinition#getContent <em>Content</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Content</em>' containment reference.
   * @see #getContent()
   * @generated
   */
  void setContent(LineContent value);

  /**
   * Returns the value of the '<em><b>Comment</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Comment</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Comment</em>' attribute.
   * @see #setComment(String)
   * @see devcpu.dASM.DASMPackage#getLineDefinition_Comment()
   * @model
   * @generated
   */
  String getComment();

  /**
   * Sets the value of the '{@link devcpu.dASM.LineDefinition#getComment <em>Comment</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Comment</em>' attribute.
   * @see #getComment()
   * @generated
   */
  void setComment(String value);

} // LineDefinition
