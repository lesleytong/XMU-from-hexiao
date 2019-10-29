/**
 * generated by Xtext 2.18.0.M3
 */
package edu.ustb.sei.mde.bxcore.dsl.bXCore.impl;

import edu.ustb.sei.mde.bxcore.dsl.bXCore.BXCorePackage;
import edu.ustb.sei.mde.bxcore.dsl.bXCore.ImportSection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Import Section</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link edu.ustb.sei.mde.bxcore.dsl.bXCore.impl.ImportSectionImpl#getMetamodel <em>Metamodel</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.bxcore.dsl.bXCore.impl.ImportSectionImpl#getShortName <em>Short Name</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ImportSectionImpl extends MinimalEObjectImpl.Container implements ImportSection
{
  /**
   * The cached value of the '{@link #getMetamodel() <em>Metamodel</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getMetamodel()
   * @generated
   * @ordered
   */
  protected EPackage metamodel;

  /**
   * The default value of the '{@link #getShortName() <em>Short Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getShortName()
   * @generated
   * @ordered
   */
  protected static final String SHORT_NAME_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getShortName() <em>Short Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getShortName()
   * @generated
   * @ordered
   */
  protected String shortName = SHORT_NAME_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ImportSectionImpl()
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
    return BXCorePackage.Literals.IMPORT_SECTION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EPackage getMetamodel()
  {
    if (metamodel != null && metamodel.eIsProxy())
    {
      InternalEObject oldMetamodel = (InternalEObject)metamodel;
      metamodel = (EPackage)eResolveProxy(oldMetamodel);
      if (metamodel != oldMetamodel)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, BXCorePackage.IMPORT_SECTION__METAMODEL, oldMetamodel, metamodel));
      }
    }
    return metamodel;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EPackage basicGetMetamodel()
  {
    return metamodel;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setMetamodel(EPackage newMetamodel)
  {
    EPackage oldMetamodel = metamodel;
    metamodel = newMetamodel;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, BXCorePackage.IMPORT_SECTION__METAMODEL, oldMetamodel, metamodel));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String getShortName()
  {
    return shortName;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setShortName(String newShortName)
  {
    String oldShortName = shortName;
    shortName = newShortName;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, BXCorePackage.IMPORT_SECTION__SHORT_NAME, oldShortName, shortName));
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
      case BXCorePackage.IMPORT_SECTION__METAMODEL:
        if (resolve) return getMetamodel();
        return basicGetMetamodel();
      case BXCorePackage.IMPORT_SECTION__SHORT_NAME:
        return getShortName();
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
      case BXCorePackage.IMPORT_SECTION__METAMODEL:
        setMetamodel((EPackage)newValue);
        return;
      case BXCorePackage.IMPORT_SECTION__SHORT_NAME:
        setShortName((String)newValue);
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
      case BXCorePackage.IMPORT_SECTION__METAMODEL:
        setMetamodel((EPackage)null);
        return;
      case BXCorePackage.IMPORT_SECTION__SHORT_NAME:
        setShortName(SHORT_NAME_EDEFAULT);
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
      case BXCorePackage.IMPORT_SECTION__METAMODEL:
        return metamodel != null;
      case BXCorePackage.IMPORT_SECTION__SHORT_NAME:
        return SHORT_NAME_EDEFAULT == null ? shortName != null : !SHORT_NAME_EDEFAULT.equals(shortName);
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

    StringBuilder result = new StringBuilder(super.toString());
    result.append(" (shortName: ");
    result.append(shortName);
    result.append(')');
    return result.toString();
  }

} //ImportSectionImpl
