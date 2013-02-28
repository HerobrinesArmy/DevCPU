/**
 */
package devcpu.dASM.impl;

import devcpu.dASM.DASMPackage;
import devcpu.dASM.Register;
import devcpu.dASM.SpecialRegister;
import devcpu.dASM.StandardRegister;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Register</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link devcpu.dASM.impl.RegisterImpl#getStandardRegister <em>Standard Register</em>}</li>
 *   <li>{@link devcpu.dASM.impl.RegisterImpl#getSpecialRegister <em>Special Register</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class RegisterImpl extends NonGroupOperandImpl implements Register
{
  /**
   * The default value of the '{@link #getStandardRegister() <em>Standard Register</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getStandardRegister()
   * @generated
   * @ordered
   */
  protected static final StandardRegister STANDARD_REGISTER_EDEFAULT = StandardRegister.A;

  /**
   * The cached value of the '{@link #getStandardRegister() <em>Standard Register</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getStandardRegister()
   * @generated
   * @ordered
   */
  protected StandardRegister standardRegister = STANDARD_REGISTER_EDEFAULT;

  /**
   * The default value of the '{@link #getSpecialRegister() <em>Special Register</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSpecialRegister()
   * @generated
   * @ordered
   */
  protected static final SpecialRegister SPECIAL_REGISTER_EDEFAULT = SpecialRegister.SP;

  /**
   * The cached value of the '{@link #getSpecialRegister() <em>Special Register</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSpecialRegister()
   * @generated
   * @ordered
   */
  protected SpecialRegister specialRegister = SPECIAL_REGISTER_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected RegisterImpl()
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
    return DASMPackage.Literals.REGISTER;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public StandardRegister getStandardRegister()
  {
    return standardRegister;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setStandardRegister(StandardRegister newStandardRegister)
  {
    StandardRegister oldStandardRegister = standardRegister;
    standardRegister = newStandardRegister == null ? STANDARD_REGISTER_EDEFAULT : newStandardRegister;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, DASMPackage.REGISTER__STANDARD_REGISTER, oldStandardRegister, standardRegister));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SpecialRegister getSpecialRegister()
  {
    return specialRegister;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setSpecialRegister(SpecialRegister newSpecialRegister)
  {
    SpecialRegister oldSpecialRegister = specialRegister;
    specialRegister = newSpecialRegister == null ? SPECIAL_REGISTER_EDEFAULT : newSpecialRegister;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, DASMPackage.REGISTER__SPECIAL_REGISTER, oldSpecialRegister, specialRegister));
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
      case DASMPackage.REGISTER__STANDARD_REGISTER:
        return getStandardRegister();
      case DASMPackage.REGISTER__SPECIAL_REGISTER:
        return getSpecialRegister();
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
      case DASMPackage.REGISTER__STANDARD_REGISTER:
        setStandardRegister((StandardRegister)newValue);
        return;
      case DASMPackage.REGISTER__SPECIAL_REGISTER:
        setSpecialRegister((SpecialRegister)newValue);
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
      case DASMPackage.REGISTER__STANDARD_REGISTER:
        setStandardRegister(STANDARD_REGISTER_EDEFAULT);
        return;
      case DASMPackage.REGISTER__SPECIAL_REGISTER:
        setSpecialRegister(SPECIAL_REGISTER_EDEFAULT);
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
      case DASMPackage.REGISTER__STANDARD_REGISTER:
        return standardRegister != STANDARD_REGISTER_EDEFAULT;
      case DASMPackage.REGISTER__SPECIAL_REGISTER:
        return specialRegister != SPECIAL_REGISTER_EDEFAULT;
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
    result.append(" (standardRegister: ");
    result.append(standardRegister);
    result.append(", specialRegister: ");
    result.append(specialRegister);
    result.append(')');
    return result.toString();
  }

} //RegisterImpl
