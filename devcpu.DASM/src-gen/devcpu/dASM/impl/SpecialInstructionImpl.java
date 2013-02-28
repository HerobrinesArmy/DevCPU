/**
 */
package devcpu.dASM.impl;

import devcpu.dASM.DASMPackage;
import devcpu.dASM.SpecialInstruction;
import devcpu.dASM.SpecialOpcode;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Special Instruction</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link devcpu.dASM.impl.SpecialInstructionImpl#getOpcode <em>Opcode</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SpecialInstructionImpl extends InstructionImpl implements SpecialInstruction
{
  /**
   * The default value of the '{@link #getOpcode() <em>Opcode</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOpcode()
   * @generated
   * @ordered
   */
  protected static final SpecialOpcode OPCODE_EDEFAULT = SpecialOpcode.JSR;

  /**
   * The cached value of the '{@link #getOpcode() <em>Opcode</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOpcode()
   * @generated
   * @ordered
   */
  protected SpecialOpcode opcode = OPCODE_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected SpecialInstructionImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass()
  {
    return DASMPackage.Literals.SPECIAL_INSTRUCTION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SpecialOpcode getOpcode()
  {
    return opcode;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setOpcode(SpecialOpcode newOpcode)
  {
    SpecialOpcode oldOpcode = opcode;
    opcode = newOpcode == null ? OPCODE_EDEFAULT : newOpcode;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, DASMPackage.SPECIAL_INSTRUCTION__OPCODE, oldOpcode, opcode));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType)
  {
    switch (featureID)
    {
      case DASMPackage.SPECIAL_INSTRUCTION__OPCODE:
        return getOpcode();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case DASMPackage.SPECIAL_INSTRUCTION__OPCODE:
        setOpcode((SpecialOpcode)newValue);
        return;
    }
    super.eSet(featureID, newValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eUnset(int featureID)
  {
    switch (featureID)
    {
      case DASMPackage.SPECIAL_INSTRUCTION__OPCODE:
        setOpcode(OPCODE_EDEFAULT);
        return;
    }
    super.eUnset(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean eIsSet(int featureID)
  {
    switch (featureID)
    {
      case DASMPackage.SPECIAL_INSTRUCTION__OPCODE:
        return opcode != OPCODE_EDEFAULT;
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String toString()
  {
    if (eIsProxy()) return super.toString();

    StringBuffer result = new StringBuffer(super.toString());
    result.append(" (opcode: ");
    result.append(opcode);
    result.append(')');
    return result.toString();
  }

} //SpecialInstructionImpl
