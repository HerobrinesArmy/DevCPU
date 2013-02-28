/**
 */
package devcpu.dASM.impl;

import devcpu.dASM.DASMPackage;
import devcpu.dASM.DataLine;

import java.util.Collection;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.util.EDataTypeEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Data Line</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link devcpu.dASM.impl.DataLineImpl#getDataElements <em>Data Elements</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DataLineImpl extends LineContentImpl implements DataLine
{
  /**
   * The cached value of the '{@link #getDataElements() <em>Data Elements</em>}' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDataElements()
   * @generated
   * @ordered
   */
  protected EList<String> dataElements;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected DataLineImpl()
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
    return DASMPackage.Literals.DATA_LINE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<String> getDataElements()
  {
    if (dataElements == null)
    {
      dataElements = new EDataTypeEList<String>(String.class, this, DASMPackage.DATA_LINE__DATA_ELEMENTS);
    }
    return dataElements;
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
      case DASMPackage.DATA_LINE__DATA_ELEMENTS:
        return getDataElements();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @SuppressWarnings("unchecked")
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case DASMPackage.DATA_LINE__DATA_ELEMENTS:
        getDataElements().clear();
        getDataElements().addAll((Collection<? extends String>)newValue);
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
      case DASMPackage.DATA_LINE__DATA_ELEMENTS:
        getDataElements().clear();
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
      case DASMPackage.DATA_LINE__DATA_ELEMENTS:
        return dataElements != null && !dataElements.isEmpty();
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
    result.append(" (dataElements: ");
    result.append(dataElements);
    result.append(')');
    return result.toString();
  }

} //DataLineImpl
