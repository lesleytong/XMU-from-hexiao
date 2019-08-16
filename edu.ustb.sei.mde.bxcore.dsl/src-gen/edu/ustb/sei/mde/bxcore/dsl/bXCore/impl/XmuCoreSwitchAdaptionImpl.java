/**
 * generated by Xtext 2.18.0.M3
 */
package edu.ustb.sei.mde.bxcore.dsl.bXCore.impl;

import edu.ustb.sei.mde.bxcore.dsl.bXCore.BXCorePackage;
import edu.ustb.sei.mde.bxcore.dsl.bXCore.ContextAwareCondition;
import edu.ustb.sei.mde.bxcore.dsl.bXCore.ContextAwareUnidirectionalAction;
import edu.ustb.sei.mde.bxcore.dsl.bXCore.XmuCoreSwitchAdaption;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Xmu Core Switch Adaption</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link edu.ustb.sei.mde.bxcore.dsl.bXCore.impl.XmuCoreSwitchAdaptionImpl#getCondition <em>Condition</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.bxcore.dsl.bXCore.impl.XmuCoreSwitchAdaptionImpl#getAction <em>Action</em>}</li>
 * </ul>
 *
 * @generated
 */
public class XmuCoreSwitchAdaptionImpl extends MinimalEObjectImpl.Container implements XmuCoreSwitchAdaption
{
  /**
   * The cached value of the '{@link #getCondition() <em>Condition</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getCondition()
   * @generated
   * @ordered
   */
  protected ContextAwareCondition condition;

  /**
   * The cached value of the '{@link #getAction() <em>Action</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAction()
   * @generated
   * @ordered
   */
  protected ContextAwareUnidirectionalAction action;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected XmuCoreSwitchAdaptionImpl()
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
    return BXCorePackage.Literals.XMU_CORE_SWITCH_ADAPTION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public ContextAwareCondition getCondition()
  {
    return condition;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetCondition(ContextAwareCondition newCondition, NotificationChain msgs)
  {
    ContextAwareCondition oldCondition = condition;
    condition = newCondition;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, BXCorePackage.XMU_CORE_SWITCH_ADAPTION__CONDITION, oldCondition, newCondition);
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
  public void setCondition(ContextAwareCondition newCondition)
  {
    if (newCondition != condition)
    {
      NotificationChain msgs = null;
      if (condition != null)
        msgs = ((InternalEObject)condition).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - BXCorePackage.XMU_CORE_SWITCH_ADAPTION__CONDITION, null, msgs);
      if (newCondition != null)
        msgs = ((InternalEObject)newCondition).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - BXCorePackage.XMU_CORE_SWITCH_ADAPTION__CONDITION, null, msgs);
      msgs = basicSetCondition(newCondition, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, BXCorePackage.XMU_CORE_SWITCH_ADAPTION__CONDITION, newCondition, newCondition));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public ContextAwareUnidirectionalAction getAction()
  {
    return action;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetAction(ContextAwareUnidirectionalAction newAction, NotificationChain msgs)
  {
    ContextAwareUnidirectionalAction oldAction = action;
    action = newAction;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, BXCorePackage.XMU_CORE_SWITCH_ADAPTION__ACTION, oldAction, newAction);
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
  public void setAction(ContextAwareUnidirectionalAction newAction)
  {
    if (newAction != action)
    {
      NotificationChain msgs = null;
      if (action != null)
        msgs = ((InternalEObject)action).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - BXCorePackage.XMU_CORE_SWITCH_ADAPTION__ACTION, null, msgs);
      if (newAction != null)
        msgs = ((InternalEObject)newAction).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - BXCorePackage.XMU_CORE_SWITCH_ADAPTION__ACTION, null, msgs);
      msgs = basicSetAction(newAction, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, BXCorePackage.XMU_CORE_SWITCH_ADAPTION__ACTION, newAction, newAction));
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
      case BXCorePackage.XMU_CORE_SWITCH_ADAPTION__CONDITION:
        return basicSetCondition(null, msgs);
      case BXCorePackage.XMU_CORE_SWITCH_ADAPTION__ACTION:
        return basicSetAction(null, msgs);
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
      case BXCorePackage.XMU_CORE_SWITCH_ADAPTION__CONDITION:
        return getCondition();
      case BXCorePackage.XMU_CORE_SWITCH_ADAPTION__ACTION:
        return getAction();
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
      case BXCorePackage.XMU_CORE_SWITCH_ADAPTION__CONDITION:
        setCondition((ContextAwareCondition)newValue);
        return;
      case BXCorePackage.XMU_CORE_SWITCH_ADAPTION__ACTION:
        setAction((ContextAwareUnidirectionalAction)newValue);
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
      case BXCorePackage.XMU_CORE_SWITCH_ADAPTION__CONDITION:
        setCondition((ContextAwareCondition)null);
        return;
      case BXCorePackage.XMU_CORE_SWITCH_ADAPTION__ACTION:
        setAction((ContextAwareUnidirectionalAction)null);
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
      case BXCorePackage.XMU_CORE_SWITCH_ADAPTION__CONDITION:
        return condition != null;
      case BXCorePackage.XMU_CORE_SWITCH_ADAPTION__ACTION:
        return action != null;
    }
    return super.eIsSet(featureID);
  }

} //XmuCoreSwitchAdaptionImpl
