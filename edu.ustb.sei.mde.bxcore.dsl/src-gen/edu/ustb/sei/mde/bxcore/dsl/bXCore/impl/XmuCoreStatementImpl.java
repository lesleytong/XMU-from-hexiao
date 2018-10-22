/**
 * generated by Xtext 2.14.0
 */
package edu.ustb.sei.mde.bxcore.dsl.bXCore.impl;

import edu.ustb.sei.mde.bxcore.dsl.bXCore.BXCorePackage;
import edu.ustb.sei.mde.bxcore.dsl.bXCore.TypeIndicator;
import edu.ustb.sei.mde.bxcore.dsl.bXCore.XmuCoreStatement;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Xmu Core Statement</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link edu.ustb.sei.mde.bxcore.dsl.bXCore.impl.XmuCoreStatementImpl#getTypeIndicator <em>Type Indicator</em>}</li>
 * </ul>
 *
 * @generated
 */
public class XmuCoreStatementImpl extends MinimalEObjectImpl.Container implements XmuCoreStatement
{
  /**
   * The cached value of the '{@link #getTypeIndicator() <em>Type Indicator</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTypeIndicator()
   * @generated
   * @ordered
   */
  protected TypeIndicator typeIndicator;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected XmuCoreStatementImpl()
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
    return BXCorePackage.Literals.XMU_CORE_STATEMENT;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TypeIndicator getTypeIndicator()
  {
    return typeIndicator;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetTypeIndicator(TypeIndicator newTypeIndicator, NotificationChain msgs)
  {
    TypeIndicator oldTypeIndicator = typeIndicator;
    typeIndicator = newTypeIndicator;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, BXCorePackage.XMU_CORE_STATEMENT__TYPE_INDICATOR, oldTypeIndicator, newTypeIndicator);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setTypeIndicator(TypeIndicator newTypeIndicator)
  {
    if (newTypeIndicator != typeIndicator)
    {
      NotificationChain msgs = null;
      if (typeIndicator != null)
        msgs = ((InternalEObject)typeIndicator).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - BXCorePackage.XMU_CORE_STATEMENT__TYPE_INDICATOR, null, msgs);
      if (newTypeIndicator != null)
        msgs = ((InternalEObject)newTypeIndicator).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - BXCorePackage.XMU_CORE_STATEMENT__TYPE_INDICATOR, null, msgs);
      msgs = basicSetTypeIndicator(newTypeIndicator, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, BXCorePackage.XMU_CORE_STATEMENT__TYPE_INDICATOR, newTypeIndicator, newTypeIndicator));
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
      case BXCorePackage.XMU_CORE_STATEMENT__TYPE_INDICATOR:
        return basicSetTypeIndicator(null, msgs);
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
      case BXCorePackage.XMU_CORE_STATEMENT__TYPE_INDICATOR:
        return getTypeIndicator();
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
      case BXCorePackage.XMU_CORE_STATEMENT__TYPE_INDICATOR:
        setTypeIndicator((TypeIndicator)newValue);
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
      case BXCorePackage.XMU_CORE_STATEMENT__TYPE_INDICATOR:
        setTypeIndicator((TypeIndicator)null);
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
      case BXCorePackage.XMU_CORE_STATEMENT__TYPE_INDICATOR:
        return typeIndicator != null;
    }
    return super.eIsSet(featureID);
  }

} //XmuCoreStatementImpl
