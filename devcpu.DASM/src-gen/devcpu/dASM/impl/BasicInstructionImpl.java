/**
 */
package devcpu.dASM.impl;

import devcpu.dASM.BasicInstruction;
import devcpu.dASM.BasicOpcode;
import devcpu.dASM.DASMPackage;
import devcpu.dASM.Value;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Basic Instruction</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link devcpu.dASM.impl.BasicInstructionImpl#getOpcode <em>Opcode</em>}</li>
 *   <li>{@link devcpu.dASM.impl.BasicInstructionImpl#getB <em>B</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class BasicInstructionImpl extends InstructionImpl implements BasicInstruction
{
  /**
   * The default value of the '{@link #getOpcode() <em>Opcode</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOpcode()
   * @generated
   * @ordered
   */
  protected static final BasicOpcode OPCODE_EDEFAULT = BasicOpcode.SET;

  /**
   * The cached value of the '{@link #getOpcode() <em>Opcode</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOpcode()
   * @generated
   * @ordered
   */
  protected BasicOpcode opcode = OPCODE_EDEFAULT;

  /**
   * The cached value of the '{@link #getB() <em>B</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getB()
   * @generated
   * @ordered
   */
  protected Value b;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected BasicInstructionImpl()
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
    return DASMPackage.Literals.BASIC_INSTRUCTION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public BasicOpcode getOpcode()
  {
    return opcode;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setOpcode(BasicOpcode newOpcode)
  {
    BasicOpcode oldOpcode = opcode;
    opcode = newOpcode == null ? OPCODE_EDEFAULT : newOpcode;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, DASMPackage.BASIC_INSTRUCTION__OPCODE, oldOpcode, opcode));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Value getB()
  {
    return b;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetB(Value newB, NotificationChain msgs)
  {
    Value oldB = b;
    b = newB;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DASMPackage.BASIC_INSTRUCTION__B, oldB, newB);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setB(Value newB)
  {
    if (newB != b)
    {
      NotificationChain msgs = null;
      if (b != null)
        msgs = ((InternalEObject)b).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DASMPackage.BASIC_INSTRUCTION__B, null, msgs);
      if (newB != null)
        msgs = ((InternalEObject)newB).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DASMPackage.BASIC_INSTRUCTION__B, null, msgs);
      msgs = basicSetB(newB, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, DASMPackage.BASIC_INSTRUCTION__B, newB, newB));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
    switch (featureID)
    {
      case DASMPackage.BASIC_INSTRUCTION__B:
        return basicSetB(null, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
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
      case DASMPackage.BASIC_INSTRUCTION__OPCODE:
        return getOpcode();
      case DASMPackage.BASIC_INSTRUCTION__B:
        return getB();
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
      case DASMPackage.BASIC_INSTRUCTION__OPCODE:
        setOpcode((BasicOpcode)newValue);
        return;
      case DASMPackage.BASIC_INSTRUCTION__B:
        setB((Value)newValue);
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
      case DASMPackage.BASIC_INSTRUCTION__OPCODE:
        setOpcode(OPCODE_EDEFAULT);
        return;
      case DASMPackage.BASIC_INSTRUCTION__B:
        setB((Value)null);
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
      case DASMPackage.BASIC_INSTRUCTION__OPCODE:
        return opcode != OPCODE_EDEFAULT;
      case DASMPackage.BASIC_INSTRUCTION__B:
        return b != null;
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

} //BasicInstructionImpl
