/**
 */
package devcpu.dASM.impl;

import devcpu.dASM.DASMPackage;
import devcpu.dASM.Label;
import devcpu.dASM.LiteralAddress;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Literal Address</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link devcpu.dASM.impl.LiteralAddressImpl#getNumber <em>Number</em>}</li>
 *   <li>{@link devcpu.dASM.impl.LiteralAddressImpl#getLabelName <em>Label Name</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class LiteralAddressImpl extends MinimalEObjectImpl.Container implements LiteralAddress
{
  /**
   * The default value of the '{@link #getNumber() <em>Number</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getNumber()
   * @generated
   * @ordered
   */
  protected static final String NUMBER_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getNumber() <em>Number</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getNumber()
   * @generated
   * @ordered
   */
  protected String number = NUMBER_EDEFAULT;

  /**
   * The cached value of the '{@link #getLabelName() <em>Label Name</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getLabelName()
   * @generated
   * @ordered
   */
  protected Label labelName;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected LiteralAddressImpl()
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
    return DASMPackage.Literals.LITERAL_ADDRESS;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getNumber()
  {
    return number;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setNumber(String newNumber)
  {
    String oldNumber = number;
    number = newNumber;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, DASMPackage.LITERAL_ADDRESS__NUMBER, oldNumber, number));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Label getLabelName()
  {
    if (labelName != null && labelName.eIsProxy())
    {
      InternalEObject oldLabelName = (InternalEObject)labelName;
      labelName = (Label)eResolveProxy(oldLabelName);
      if (labelName != oldLabelName)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, DASMPackage.LITERAL_ADDRESS__LABEL_NAME, oldLabelName, labelName));
      }
    }
    return labelName;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Label basicGetLabelName()
  {
    return labelName;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setLabelName(Label newLabelName)
  {
    Label oldLabelName = labelName;
    labelName = newLabelName;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, DASMPackage.LITERAL_ADDRESS__LABEL_NAME, oldLabelName, labelName));
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
      case DASMPackage.LITERAL_ADDRESS__NUMBER:
        return getNumber();
      case DASMPackage.LITERAL_ADDRESS__LABEL_NAME:
        if (resolve) return getLabelName();
        return basicGetLabelName();
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
      case DASMPackage.LITERAL_ADDRESS__NUMBER:
        setNumber((String)newValue);
        return;
      case DASMPackage.LITERAL_ADDRESS__LABEL_NAME:
        setLabelName((Label)newValue);
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
      case DASMPackage.LITERAL_ADDRESS__NUMBER:
        setNumber(NUMBER_EDEFAULT);
        return;
      case DASMPackage.LITERAL_ADDRESS__LABEL_NAME:
        setLabelName((Label)null);
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
      case DASMPackage.LITERAL_ADDRESS__NUMBER:
        return NUMBER_EDEFAULT == null ? number != null : !NUMBER_EDEFAULT.equals(number);
      case DASMPackage.LITERAL_ADDRESS__LABEL_NAME:
        return labelName != null;
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
    result.append(" (number: ");
    result.append(number);
    result.append(')');
    return result.toString();
  }

} //LiteralAddressImpl
