/**
 * generated by Xtext 2.18.0.M3
 */
package edu.ustb.sei.mde.bxcore.dsl.bXCore.impl;

import edu.ustb.sei.mde.bxcore.dsl.bXCore.BXCorePackage;
import edu.ustb.sei.mde.bxcore.dsl.bXCore.Pattern;
import edu.ustb.sei.mde.bxcore.dsl.bXCore.VarMapping;
import edu.ustb.sei.mde.bxcore.dsl.bXCore.XmuCoreExpandView;
import edu.ustb.sei.mde.bxcore.dsl.bXCore.XmuCoreStatement;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Xmu Core Expand View</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link edu.ustb.sei.mde.bxcore.dsl.bXCore.impl.XmuCoreExpandViewImpl#getPattern <em>Pattern</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.bxcore.dsl.bXCore.impl.XmuCoreExpandViewImpl#getMappings <em>Mappings</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.bxcore.dsl.bXCore.impl.XmuCoreExpandViewImpl#getBody <em>Body</em>}</li>
 * </ul>
 *
 * @generated
 */
public class XmuCoreExpandViewImpl extends XmuCoreCompositionChildStatementImpl implements XmuCoreExpandView
{
  /**
   * The cached value of the '{@link #getPattern() <em>Pattern</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPattern()
   * @generated
   * @ordered
   */
  protected Pattern pattern;

  /**
   * The cached value of the '{@link #getMappings() <em>Mappings</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getMappings()
   * @generated
   * @ordered
   */
  protected EList<VarMapping> mappings;

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
  protected XmuCoreExpandViewImpl()
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
    return BXCorePackage.Literals.XMU_CORE_EXPAND_VIEW;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Pattern getPattern()
  {
    return pattern;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetPattern(Pattern newPattern, NotificationChain msgs)
  {
    Pattern oldPattern = pattern;
    pattern = newPattern;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, BXCorePackage.XMU_CORE_EXPAND_VIEW__PATTERN, oldPattern, newPattern);
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
  public void setPattern(Pattern newPattern)
  {
    if (newPattern != pattern)
    {
      NotificationChain msgs = null;
      if (pattern != null)
        msgs = ((InternalEObject)pattern).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - BXCorePackage.XMU_CORE_EXPAND_VIEW__PATTERN, null, msgs);
      if (newPattern != null)
        msgs = ((InternalEObject)newPattern).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - BXCorePackage.XMU_CORE_EXPAND_VIEW__PATTERN, null, msgs);
      msgs = basicSetPattern(newPattern, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, BXCorePackage.XMU_CORE_EXPAND_VIEW__PATTERN, newPattern, newPattern));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<VarMapping> getMappings()
  {
    if (mappings == null)
    {
      mappings = new EObjectContainmentEList<VarMapping>(VarMapping.class, this, BXCorePackage.XMU_CORE_EXPAND_VIEW__MAPPINGS);
    }
    return mappings;
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
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, BXCorePackage.XMU_CORE_EXPAND_VIEW__BODY, oldBody, newBody);
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
        msgs = ((InternalEObject)body).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - BXCorePackage.XMU_CORE_EXPAND_VIEW__BODY, null, msgs);
      if (newBody != null)
        msgs = ((InternalEObject)newBody).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - BXCorePackage.XMU_CORE_EXPAND_VIEW__BODY, null, msgs);
      msgs = basicSetBody(newBody, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, BXCorePackage.XMU_CORE_EXPAND_VIEW__BODY, newBody, newBody));
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
      case BXCorePackage.XMU_CORE_EXPAND_VIEW__PATTERN:
        return basicSetPattern(null, msgs);
      case BXCorePackage.XMU_CORE_EXPAND_VIEW__MAPPINGS:
        return ((InternalEList<?>)getMappings()).basicRemove(otherEnd, msgs);
      case BXCorePackage.XMU_CORE_EXPAND_VIEW__BODY:
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
      case BXCorePackage.XMU_CORE_EXPAND_VIEW__PATTERN:
        return getPattern();
      case BXCorePackage.XMU_CORE_EXPAND_VIEW__MAPPINGS:
        return getMappings();
      case BXCorePackage.XMU_CORE_EXPAND_VIEW__BODY:
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
      case BXCorePackage.XMU_CORE_EXPAND_VIEW__PATTERN:
        setPattern((Pattern)newValue);
        return;
      case BXCorePackage.XMU_CORE_EXPAND_VIEW__MAPPINGS:
        getMappings().clear();
        getMappings().addAll((Collection<? extends VarMapping>)newValue);
        return;
      case BXCorePackage.XMU_CORE_EXPAND_VIEW__BODY:
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
      case BXCorePackage.XMU_CORE_EXPAND_VIEW__PATTERN:
        setPattern((Pattern)null);
        return;
      case BXCorePackage.XMU_CORE_EXPAND_VIEW__MAPPINGS:
        getMappings().clear();
        return;
      case BXCorePackage.XMU_CORE_EXPAND_VIEW__BODY:
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
      case BXCorePackage.XMU_CORE_EXPAND_VIEW__PATTERN:
        return pattern != null;
      case BXCorePackage.XMU_CORE_EXPAND_VIEW__MAPPINGS:
        return mappings != null && !mappings.isEmpty();
      case BXCorePackage.XMU_CORE_EXPAND_VIEW__BODY:
        return body != null;
    }
    return super.eIsSet(featureID);
  }

} //XmuCoreExpandViewImpl
