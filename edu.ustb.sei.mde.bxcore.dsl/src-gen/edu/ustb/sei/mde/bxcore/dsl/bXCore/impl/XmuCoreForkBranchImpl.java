/**
 * generated by Xtext 2.18.0.M3
 */
package edu.ustb.sei.mde.bxcore.dsl.bXCore.impl;

import edu.ustb.sei.mde.bxcore.dsl.bXCore.BXCorePackage;
import edu.ustb.sei.mde.bxcore.dsl.bXCore.VarMapping;
import edu.ustb.sei.mde.bxcore.dsl.bXCore.XmuCoreForkBranch;
import edu.ustb.sei.mde.bxcore.dsl.bXCore.XmuCoreStatement;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Xmu Core Fork Branch</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link edu.ustb.sei.mde.bxcore.dsl.bXCore.impl.XmuCoreForkBranchImpl#getSourceMappings <em>Source Mappings</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.bxcore.dsl.bXCore.impl.XmuCoreForkBranchImpl#getViewMappings <em>View Mappings</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.bxcore.dsl.bXCore.impl.XmuCoreForkBranchImpl#getBody <em>Body</em>}</li>
 * </ul>
 *
 * @generated
 */
public class XmuCoreForkBranchImpl extends MinimalEObjectImpl.Container implements XmuCoreForkBranch
{
  /**
   * The cached value of the '{@link #getSourceMappings() <em>Source Mappings</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSourceMappings()
   * @generated
   * @ordered
   */
  protected EList<VarMapping> sourceMappings;

  /**
   * The cached value of the '{@link #getViewMappings() <em>View Mappings</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getViewMappings()
   * @generated
   * @ordered
   */
  protected EList<VarMapping> viewMappings;

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
  protected XmuCoreForkBranchImpl()
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
    return BXCorePackage.Literals.XMU_CORE_FORK_BRANCH;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<VarMapping> getSourceMappings()
  {
    if (sourceMappings == null)
    {
      sourceMappings = new EObjectContainmentEList<VarMapping>(VarMapping.class, this, BXCorePackage.XMU_CORE_FORK_BRANCH__SOURCE_MAPPINGS);
    }
    return sourceMappings;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<VarMapping> getViewMappings()
  {
    if (viewMappings == null)
    {
      viewMappings = new EObjectContainmentEList<VarMapping>(VarMapping.class, this, BXCorePackage.XMU_CORE_FORK_BRANCH__VIEW_MAPPINGS);
    }
    return viewMappings;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
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
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, BXCorePackage.XMU_CORE_FORK_BRANCH__BODY, oldBody, newBody);
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
  public void setBody(XmuCoreStatement newBody)
  {
    if (newBody != body)
    {
      NotificationChain msgs = null;
      if (body != null)
        msgs = ((InternalEObject)body).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - BXCorePackage.XMU_CORE_FORK_BRANCH__BODY, null, msgs);
      if (newBody != null)
        msgs = ((InternalEObject)newBody).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - BXCorePackage.XMU_CORE_FORK_BRANCH__BODY, null, msgs);
      msgs = basicSetBody(newBody, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, BXCorePackage.XMU_CORE_FORK_BRANCH__BODY, newBody, newBody));
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
      case BXCorePackage.XMU_CORE_FORK_BRANCH__SOURCE_MAPPINGS:
        return ((InternalEList<?>)getSourceMappings()).basicRemove(otherEnd, msgs);
      case BXCorePackage.XMU_CORE_FORK_BRANCH__VIEW_MAPPINGS:
        return ((InternalEList<?>)getViewMappings()).basicRemove(otherEnd, msgs);
      case BXCorePackage.XMU_CORE_FORK_BRANCH__BODY:
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
      case BXCorePackage.XMU_CORE_FORK_BRANCH__SOURCE_MAPPINGS:
        return getSourceMappings();
      case BXCorePackage.XMU_CORE_FORK_BRANCH__VIEW_MAPPINGS:
        return getViewMappings();
      case BXCorePackage.XMU_CORE_FORK_BRANCH__BODY:
        return getBody();
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
      case BXCorePackage.XMU_CORE_FORK_BRANCH__SOURCE_MAPPINGS:
        getSourceMappings().clear();
        getSourceMappings().addAll((Collection<? extends VarMapping>)newValue);
        return;
      case BXCorePackage.XMU_CORE_FORK_BRANCH__VIEW_MAPPINGS:
        getViewMappings().clear();
        getViewMappings().addAll((Collection<? extends VarMapping>)newValue);
        return;
      case BXCorePackage.XMU_CORE_FORK_BRANCH__BODY:
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
      case BXCorePackage.XMU_CORE_FORK_BRANCH__SOURCE_MAPPINGS:
        getSourceMappings().clear();
        return;
      case BXCorePackage.XMU_CORE_FORK_BRANCH__VIEW_MAPPINGS:
        getViewMappings().clear();
        return;
      case BXCorePackage.XMU_CORE_FORK_BRANCH__BODY:
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
      case BXCorePackage.XMU_CORE_FORK_BRANCH__SOURCE_MAPPINGS:
        return sourceMappings != null && !sourceMappings.isEmpty();
      case BXCorePackage.XMU_CORE_FORK_BRANCH__VIEW_MAPPINGS:
        return viewMappings != null && !viewMappings.isEmpty();
      case BXCorePackage.XMU_CORE_FORK_BRANCH__BODY:
        return body != null;
    }
    return super.eIsSet(featureID);
  }

} //XmuCoreForkBranchImpl
