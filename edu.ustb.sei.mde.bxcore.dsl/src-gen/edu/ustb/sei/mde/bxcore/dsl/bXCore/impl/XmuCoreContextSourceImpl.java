/**
 * generated by Xtext 2.14.0
 */
package edu.ustb.sei.mde.bxcore.dsl.bXCore.impl;

import edu.ustb.sei.mde.bxcore.dsl.bXCore.BXCorePackage;
import edu.ustb.sei.mde.bxcore.dsl.bXCore.OrderedTupleTypeLiteral;
import edu.ustb.sei.mde.bxcore.dsl.bXCore.XmuCoreContextSource;
import edu.ustb.sei.mde.bxcore.dsl.bXCore.XmuCoreStatement;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Xmu Core Context Source</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link edu.ustb.sei.mde.bxcore.dsl.bXCore.impl.XmuCoreContextSourceImpl#getMappingSource <em>Mapping Source</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.bxcore.dsl.bXCore.impl.XmuCoreContextSourceImpl#getMappingView <em>Mapping View</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.bxcore.dsl.bXCore.impl.XmuCoreContextSourceImpl#getBody <em>Body</em>}</li>
 * </ul>
 *
 * @generated
 */
public class XmuCoreContextSourceImpl extends XmuCoreCompositionChildStatementImpl implements XmuCoreContextSource
{
  /**
   * The cached value of the '{@link #getMappingSource() <em>Mapping Source</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getMappingSource()
   * @generated
   * @ordered
   */
  protected OrderedTupleTypeLiteral mappingSource;

  /**
   * The cached value of the '{@link #getMappingView() <em>Mapping View</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getMappingView()
   * @generated
   * @ordered
   */
  protected OrderedTupleTypeLiteral mappingView;

  /**
   * The cached value of the '{@link #getBody() <em>Body</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getBody()
   * @generated
   * @ordered
   */
  protected XmuCoreStatement body;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected XmuCoreContextSourceImpl()
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
    return BXCorePackage.Literals.XMU_CORE_CONTEXT_SOURCE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public OrderedTupleTypeLiteral getMappingSource()
  {
    return mappingSource;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetMappingSource(OrderedTupleTypeLiteral newMappingSource, NotificationChain msgs)
  {
    OrderedTupleTypeLiteral oldMappingSource = mappingSource;
    mappingSource = newMappingSource;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, BXCorePackage.XMU_CORE_CONTEXT_SOURCE__MAPPING_SOURCE, oldMappingSource, newMappingSource);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setMappingSource(OrderedTupleTypeLiteral newMappingSource)
  {
    if (newMappingSource != mappingSource)
    {
      NotificationChain msgs = null;
      if (mappingSource != null)
        msgs = ((InternalEObject)mappingSource).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - BXCorePackage.XMU_CORE_CONTEXT_SOURCE__MAPPING_SOURCE, null, msgs);
      if (newMappingSource != null)
        msgs = ((InternalEObject)newMappingSource).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - BXCorePackage.XMU_CORE_CONTEXT_SOURCE__MAPPING_SOURCE, null, msgs);
      msgs = basicSetMappingSource(newMappingSource, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, BXCorePackage.XMU_CORE_CONTEXT_SOURCE__MAPPING_SOURCE, newMappingSource, newMappingSource));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public OrderedTupleTypeLiteral getMappingView()
  {
    return mappingView;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetMappingView(OrderedTupleTypeLiteral newMappingView, NotificationChain msgs)
  {
    OrderedTupleTypeLiteral oldMappingView = mappingView;
    mappingView = newMappingView;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, BXCorePackage.XMU_CORE_CONTEXT_SOURCE__MAPPING_VIEW, oldMappingView, newMappingView);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setMappingView(OrderedTupleTypeLiteral newMappingView)
  {
    if (newMappingView != mappingView)
    {
      NotificationChain msgs = null;
      if (mappingView != null)
        msgs = ((InternalEObject)mappingView).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - BXCorePackage.XMU_CORE_CONTEXT_SOURCE__MAPPING_VIEW, null, msgs);
      if (newMappingView != null)
        msgs = ((InternalEObject)newMappingView).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - BXCorePackage.XMU_CORE_CONTEXT_SOURCE__MAPPING_VIEW, null, msgs);
      msgs = basicSetMappingView(newMappingView, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, BXCorePackage.XMU_CORE_CONTEXT_SOURCE__MAPPING_VIEW, newMappingView, newMappingView));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public XmuCoreStatement getBody()
  {
    return body;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetBody(XmuCoreStatement newBody, NotificationChain msgs)
  {
    XmuCoreStatement oldBody = body;
    body = newBody;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, BXCorePackage.XMU_CORE_CONTEXT_SOURCE__BODY, oldBody, newBody);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setBody(XmuCoreStatement newBody)
  {
    if (newBody != body)
    {
      NotificationChain msgs = null;
      if (body != null)
        msgs = ((InternalEObject)body).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - BXCorePackage.XMU_CORE_CONTEXT_SOURCE__BODY, null, msgs);
      if (newBody != null)
        msgs = ((InternalEObject)newBody).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - BXCorePackage.XMU_CORE_CONTEXT_SOURCE__BODY, null, msgs);
      msgs = basicSetBody(newBody, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, BXCorePackage.XMU_CORE_CONTEXT_SOURCE__BODY, newBody, newBody));
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
      case BXCorePackage.XMU_CORE_CONTEXT_SOURCE__MAPPING_SOURCE:
        return basicSetMappingSource(null, msgs);
      case BXCorePackage.XMU_CORE_CONTEXT_SOURCE__MAPPING_VIEW:
        return basicSetMappingView(null, msgs);
      case BXCorePackage.XMU_CORE_CONTEXT_SOURCE__BODY:
        return basicSetBody(null, msgs);
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
      case BXCorePackage.XMU_CORE_CONTEXT_SOURCE__MAPPING_SOURCE:
        return getMappingSource();
      case BXCorePackage.XMU_CORE_CONTEXT_SOURCE__MAPPING_VIEW:
        return getMappingView();
      case BXCorePackage.XMU_CORE_CONTEXT_SOURCE__BODY:
        return getBody();
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
      case BXCorePackage.XMU_CORE_CONTEXT_SOURCE__MAPPING_SOURCE:
        setMappingSource((OrderedTupleTypeLiteral)newValue);
        return;
      case BXCorePackage.XMU_CORE_CONTEXT_SOURCE__MAPPING_VIEW:
        setMappingView((OrderedTupleTypeLiteral)newValue);
        return;
      case BXCorePackage.XMU_CORE_CONTEXT_SOURCE__BODY:
        setBody((XmuCoreStatement)newValue);
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
      case BXCorePackage.XMU_CORE_CONTEXT_SOURCE__MAPPING_SOURCE:
        setMappingSource((OrderedTupleTypeLiteral)null);
        return;
      case BXCorePackage.XMU_CORE_CONTEXT_SOURCE__MAPPING_VIEW:
        setMappingView((OrderedTupleTypeLiteral)null);
        return;
      case BXCorePackage.XMU_CORE_CONTEXT_SOURCE__BODY:
        setBody((XmuCoreStatement)null);
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
      case BXCorePackage.XMU_CORE_CONTEXT_SOURCE__MAPPING_SOURCE:
        return mappingSource != null;
      case BXCorePackage.XMU_CORE_CONTEXT_SOURCE__MAPPING_VIEW:
        return mappingView != null;
      case BXCorePackage.XMU_CORE_CONTEXT_SOURCE__BODY:
        return body != null;
    }
    return super.eIsSet(featureID);
  }

} //XmuCoreContextSourceImpl
