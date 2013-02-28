/**
 */
package devcpu.dASM;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Origin Directive</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link devcpu.dASM.OriginDirective#getValue <em>Value</em>}</li>
 * </ul>
 * </p>
 *
 * @see devcpu.dASM.DASMPackage#getOriginDirective()
 * @model
 * @generated
 */
public interface OriginDirective extends Directive
{
  /**
   * Returns the value of the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Value</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Value</em>' attribute.
   * @see #setValue(String)
   * @see devcpu.dASM.DASMPackage#getOriginDirective_Value()
   * @model
   * @generated
   */
  String getValue();

  /**
   * Sets the value of the '{@link devcpu.dASM.OriginDirective#getValue <em>Value</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Value</em>' attribute.
   * @see #getValue()
   * @generated
   */
  void setValue(String value);

} // OriginDirective
