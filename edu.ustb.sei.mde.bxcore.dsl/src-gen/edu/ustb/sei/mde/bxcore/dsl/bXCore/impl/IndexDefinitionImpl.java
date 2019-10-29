/**
 * generated by Xtext 2.18.0.M3
 */
package edu.ustb.sei.mde.bxcore.dsl.bXCore.impl;

import edu.ustb.sei.mde.bxcore.dsl.bXCore.BXCorePackage;
import edu.ustb.sei.mde.bxcore.dsl.bXCore.ContextTypeRef;
import edu.ustb.sei.mde.bxcore.dsl.bXCore.IndexDefinition;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Index Definition</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link edu.ustb.sei.mde.bxcore.dsl.bXCore.impl.IndexDefinitionImpl#getSourceType <em>Source Type</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.bxcore.dsl.bXCore.impl.IndexDefinitionImpl#getViewType <em>View Type</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IndexDefinitionImpl extends DefinitionImpl implements IndexDefinition
{
  /**
   * The cached value of the '{@link #getSourceType() <em>Source Type</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSourceType()
   * @generated
   * @ordered
   */
  protected ContextTypeRef sourceType;

  /**
   * The cached value of the '{@link #getViewType() <em>View Type</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getViewType()
   * @generated
   * @ordered
   */
  protected ContextTypeRef viewType;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected IndexDefinitionImpl()
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
    return BXCorePackage.Literals.INDEX_DEFINITION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public ContextTypeRef getSourceType()
  {
    return sourceType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetSourceType(ContextTypeRef newSourceType, NotificationChain msgs)
  {
    ContextTypeRef oldSourceType = sourceType;
    sourceType = newSourceType;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, BXCorePackage.INDEX_DEFINITION__SOURCE_TYPE, oldSourceType, newSourceType);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setSourceType(ContextTypeRef newSourceType)
  {
    if (newSourceType != sourceType)
    {
      NotificationChain msgs = null;
      if (sourceType != null)
        msgs = ((InternalEObject)sourceType).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - BXCorePackage.INDEX_DEFINITION__SOURCE_TYPE, null, msgs);
      if (newSourceType != null)
        msgs = ((InternalEObject)newSourceType).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - BXCorePackage.INDEX_DEFINITION__SOURCE_TYPE, null, msgs);
      msgs = basicSetSourceType(newSourceType, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, BXCorePackage.INDEX_DEFINITION__SOURCE_TYPE, newSourceType, newSourceType));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public ContextTypeRef getViewType()
  {
    return viewType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetViewType(ContextTypeRef newViewType, NotificationChain msgs)
  {
    ContextTypeRef oldViewType = viewType;
    viewType = newViewType;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, BXCorePackage.INDEX_DEFINITION__VIEW_TYPE, oldViewType, newViewType);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setViewType(ContextTypeRef newViewType)
  {
    if (newViewType != viewType)
    {
      NotificationChain msgs = null;
      if (viewType != null)
        msgs = ((InternalEObject)viewType).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - BXCorePackage.INDEX_DEFINITION__VIEW_TYPE, null, msgs);
      if (newViewType != null)
        msgs = ((InternalEObject)newViewType).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - BXCorePackage.INDEX_DEFINITION__VIEW_TYPE, null, msgs);
      msgs = basicSetViewType(newViewType, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, BXCorePackage.INDEX_DEFINITION__VIEW_TYPE, newViewType, newViewType));
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
      case BXCorePackage.INDEX_DEFINITION__SOURCE_TYPE:
        return basicSetSourceType(null, msgs);
      case BXCorePackage.INDEX_DEFINITION__VIEW_TYPE:
        return basicSetViewType(null, msgs);
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
      case BXCorePackage.INDEX_DEFINITION__SOURCE_TYPE:
        return getSourceType();
      case BXCorePackage.INDEX_DEFINITION__VIEW_TYPE:
        return getViewType();
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
      case BXCorePackage.INDEX_DEFINITION__SOURCE_TYPE:
        setSourceType((ContextTypeRef)newValue);
        return;
      case BXCorePackage.INDEX_DEFINITION__VIEW_TYPE:
        setViewType((ContextTypeRef)newValue);
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
      case BXCorePackage.INDEX_DEFINITION__SOURCE_TYPE:
        setSourceType((ContextTypeRef)null);
        return;
      case BXCorePackage.INDEX_DEFINITION__VIEW_TYPE:
        setViewType((ContextTypeRef)null);
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
      case BXCorePackage.INDEX_DEFINITION__SOURCE_TYPE:
        return sourceType != null;
      case BXCorePackage.INDEX_DEFINITION__VIEW_TYPE:
        return viewType != null;
    }
    return super.eIsSet(featureID);
  }

} //IndexDefinitionImpl
