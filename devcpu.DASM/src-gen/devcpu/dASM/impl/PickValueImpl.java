/**
 */
package devcpu.dASM.impl;

import devcpu.dASM.DASMPackage;
import devcpu.dASM.LiteralExpression;
import devcpu.dASM.PickValue;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Pick Value</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link devcpu.dASM.impl.PickValueImpl#getPickValue <em>Pick Value</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PickValueImpl extends StackValueImpl implements PickValue
{
  /**
   * The cached value of the '{@link #getPickValue() <em>Pick Value</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPickValue()
   * @generated
   * @ordered
   */
  protected LiteralExpression pickValue;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected PickValueImpl()
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
    return DASMPackage.Literals.PICK_VALUE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public LiteralExpression getPickValue()
  {
    return pickValue;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetPickValue(LiteralExpression newPickValue, NotificationChain msgs)
  {
    LiteralExpression oldPickValue = pickValue;
    pickValue = newPickValue;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DASMPackage.PICK_VALUE__PICK_VALUE, oldPickValue, newPickValue);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setPickValue(LiteralExpression newPickValue)
  {
    if (newPickValue != pickValue)
    {
      NotificationChain msgs = null;
      if (pickValue != null)
        msgs = ((InternalEObject)pickValue).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DASMPackage.PICK_VALUE__PICK_VALUE, null, msgs);
      if (newPickValue != null)
        msgs = ((InternalEObject)newPickValue).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DASMPackage.PICK_VALUE__PICK_VALUE, null, msgs);
      msgs = basicSetPickValue(newPickValue, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, DASMPackage.PICK_VALUE__PICK_VALUE, newPickValue, newPickValue));
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
      case DASMPackage.PICK_VALUE__PICK_VALUE:
        return basicSetPickValue(null, msgs);
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
      case DASMPackage.PICK_VALUE__PICK_VALUE:
        return getPickValue();
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
      case DASMPackage.PICK_VALUE__PICK_VALUE:
        setPickValue((LiteralExpression)newValue);
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
      case DASMPackage.PICK_VALUE__PICK_VALUE:
        setPickValue((LiteralExpression)null);
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
      case DASMPackage.PICK_VALUE__PICK_VALUE:
        return pickValue != null;
    }
    return super.eIsSet(featureID);
  }

} //PickValueImpl
