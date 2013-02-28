/**
 */
package devcpu.dASM.impl;

import devcpu.dASM.DASMPackage;
import devcpu.dASM.Label;
import devcpu.dASM.NonGroupOperand;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Non Group Operand</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link devcpu.dASM.impl.NonGroupOperandImpl#getLabelName <em>Label Name</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class NonGroupOperandImpl extends MinimalEObjectImpl.Container implements NonGroupOperand
{
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
  protected NonGroupOperandImpl()
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
    return DASMPackage.Literals.NON_GROUP_OPERAND;
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
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, DASMPackage.NON_GROUP_OPERAND__LABEL_NAME, oldLabelName, labelName));
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
      eNotify(new ENotificationImpl(this, Notification.SET, DASMPackage.NON_GROUP_OPERAND__LABEL_NAME, oldLabelName, labelName));
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
      case DASMPackage.NON_GROUP_OPERAND__LABEL_NAME:
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
      case DASMPackage.NON_GROUP_OPERAND__LABEL_NAME:
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
      case DASMPackage.NON_GROUP_OPERAND__LABEL_NAME:
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
      case DASMPackage.NON_GROUP_OPERAND__LABEL_NAME:
        return labelName != null;
    }
    return super.eIsSet(featureID);
  }

} //NonGroupOperandImpl
