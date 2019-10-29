/**
 * generated by Xtext 2.18.0.M3
 */
package edu.ustb.sei.mde.bxcore.dsl.bXCore.impl;

import edu.ustb.sei.mde.bxcore.dsl.bXCore.AbstractPatternEdge;
import edu.ustb.sei.mde.bxcore.dsl.bXCore.BXCorePackage;
import edu.ustb.sei.mde.bxcore.dsl.bXCore.ContextAwareCondition;
import edu.ustb.sei.mde.bxcore.dsl.bXCore.ImportSection;
import edu.ustb.sei.mde.bxcore.dsl.bXCore.PatternNode;
import edu.ustb.sei.mde.bxcore.dsl.bXCore.PatternTypeLiteral;
import edu.ustb.sei.mde.bxcore.dsl.bXCore.TypeVar;

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
 * An implementation of the model object '<em><b>Pattern Type Literal</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link edu.ustb.sei.mde.bxcore.dsl.bXCore.impl.PatternTypeLiteralImpl#getSource <em>Source</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.bxcore.dsl.bXCore.impl.PatternTypeLiteralImpl#getRoot <em>Root</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.bxcore.dsl.bXCore.impl.PatternTypeLiteralImpl#getAdditional <em>Additional</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.bxcore.dsl.bXCore.impl.PatternTypeLiteralImpl#getFilter <em>Filter</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.bxcore.dsl.bXCore.impl.PatternTypeLiteralImpl#getOrderBy <em>Order By</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.bxcore.dsl.bXCore.impl.PatternTypeLiteralImpl#getDirection <em>Direction</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.bxcore.dsl.bXCore.impl.PatternTypeLiteralImpl#getPivot <em>Pivot</em>}</li>
 * </ul>
 *
 * @generated
 */
public class PatternTypeLiteralImpl extends TypeLiteralImpl implements PatternTypeLiteral
{
  /**
   * The cached value of the '{@link #getSource() <em>Source</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSource()
   * @generated
   * @ordered
   */
  protected ImportSection source;

  /**
   * The cached value of the '{@link #getRoot() <em>Root</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRoot()
   * @generated
   * @ordered
   */
  protected PatternNode root;

  /**
   * The cached value of the '{@link #getAdditional() <em>Additional</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAdditional()
   * @generated
   * @ordered
   */
  protected EList<TypeVar> additional;

  /**
   * The cached value of the '{@link #getFilter() <em>Filter</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFilter()
   * @generated
   * @ordered
   */
  protected ContextAwareCondition filter;

  /**
   * The cached value of the '{@link #getOrderBy() <em>Order By</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOrderBy()
   * @generated
   * @ordered
   */
  protected AbstractPatternEdge orderBy;

  /**
   * The default value of the '{@link #getDirection() <em>Direction</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDirection()
   * @generated
   * @ordered
   */
  protected static final String DIRECTION_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getDirection() <em>Direction</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDirection()
   * @generated
   * @ordered
   */
  protected String direction = DIRECTION_EDEFAULT;

  /**
   * The cached value of the '{@link #getPivot() <em>Pivot</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPivot()
   * @generated
   * @ordered
   */
  protected TypeVar pivot;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected PatternTypeLiteralImpl()
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
    return BXCorePackage.Literals.PATTERN_TYPE_LITERAL;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public ImportSection getSource()
  {
    if (source != null && source.eIsProxy())
    {
      InternalEObject oldSource = (InternalEObject)source;
      source = (ImportSection)eResolveProxy(oldSource);
      if (source != oldSource)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, BXCorePackage.PATTERN_TYPE_LITERAL__SOURCE, oldSource, source));
      }
    }
    return source;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ImportSection basicGetSource()
  {
    return source;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setSource(ImportSection newSource)
  {
    ImportSection oldSource = source;
    source = newSource;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, BXCorePackage.PATTERN_TYPE_LITERAL__SOURCE, oldSource, source));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public PatternNode getRoot()
  {
    return root;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetRoot(PatternNode newRoot, NotificationChain msgs)
  {
    PatternNode oldRoot = root;
    root = newRoot;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, BXCorePackage.PATTERN_TYPE_LITERAL__ROOT, oldRoot, newRoot);
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
  public void setRoot(PatternNode newRoot)
  {
    if (newRoot != root)
    {
      NotificationChain msgs = null;
      if (root != null)
        msgs = ((InternalEObject)root).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - BXCorePackage.PATTERN_TYPE_LITERAL__ROOT, null, msgs);
      if (newRoot != null)
        msgs = ((InternalEObject)newRoot).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - BXCorePackage.PATTERN_TYPE_LITERAL__ROOT, null, msgs);
      msgs = basicSetRoot(newRoot, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, BXCorePackage.PATTERN_TYPE_LITERAL__ROOT, newRoot, newRoot));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<TypeVar> getAdditional()
  {
    if (additional == null)
    {
      additional = new EObjectContainmentEList<TypeVar>(TypeVar.class, this, BXCorePackage.PATTERN_TYPE_LITERAL__ADDITIONAL);
    }
    return additional;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public ContextAwareCondition getFilter()
  {
    return filter;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetFilter(ContextAwareCondition newFilter, NotificationChain msgs)
  {
    ContextAwareCondition oldFilter = filter;
    filter = newFilter;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, BXCorePackage.PATTERN_TYPE_LITERAL__FILTER, oldFilter, newFilter);
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
  public void setFilter(ContextAwareCondition newFilter)
  {
    if (newFilter != filter)
    {
      NotificationChain msgs = null;
      if (filter != null)
        msgs = ((InternalEObject)filter).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - BXCorePackage.PATTERN_TYPE_LITERAL__FILTER, null, msgs);
      if (newFilter != null)
        msgs = ((InternalEObject)newFilter).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - BXCorePackage.PATTERN_TYPE_LITERAL__FILTER, null, msgs);
      msgs = basicSetFilter(newFilter, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, BXCorePackage.PATTERN_TYPE_LITERAL__FILTER, newFilter, newFilter));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public AbstractPatternEdge getOrderBy()
  {
    if (orderBy != null && orderBy.eIsProxy())
    {
      InternalEObject oldOrderBy = (InternalEObject)orderBy;
      orderBy = (AbstractPatternEdge)eResolveProxy(oldOrderBy);
      if (orderBy != oldOrderBy)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, BXCorePackage.PATTERN_TYPE_LITERAL__ORDER_BY, oldOrderBy, orderBy));
      }
    }
    return orderBy;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AbstractPatternEdge basicGetOrderBy()
  {
    return orderBy;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setOrderBy(AbstractPatternEdge newOrderBy)
  {
    AbstractPatternEdge oldOrderBy = orderBy;
    orderBy = newOrderBy;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, BXCorePackage.PATTERN_TYPE_LITERAL__ORDER_BY, oldOrderBy, orderBy));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String getDirection()
  {
    return direction;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setDirection(String newDirection)
  {
    String oldDirection = direction;
    direction = newDirection;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, BXCorePackage.PATTERN_TYPE_LITERAL__DIRECTION, oldDirection, direction));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public TypeVar getPivot()
  {
    if (pivot != null && pivot.eIsProxy())
    {
      InternalEObject oldPivot = (InternalEObject)pivot;
      pivot = (TypeVar)eResolveProxy(oldPivot);
      if (pivot != oldPivot)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, BXCorePackage.PATTERN_TYPE_LITERAL__PIVOT, oldPivot, pivot));
      }
    }
    return pivot;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TypeVar basicGetPivot()
  {
    return pivot;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setPivot(TypeVar newPivot)
  {
    TypeVar oldPivot = pivot;
    pivot = newPivot;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, BXCorePackage.PATTERN_TYPE_LITERAL__PIVOT, oldPivot, pivot));
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
      case BXCorePackage.PATTERN_TYPE_LITERAL__ROOT:
        return basicSetRoot(null, msgs);
      case BXCorePackage.PATTERN_TYPE_LITERAL__ADDITIONAL:
        return ((InternalEList<?>)getAdditional()).basicRemove(otherEnd, msgs);
      case BXCorePackage.PATTERN_TYPE_LITERAL__FILTER:
        return basicSetFilter(null, msgs);
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
      case BXCorePackage.PATTERN_TYPE_LITERAL__SOURCE:
        if (resolve) return getSource();
        return basicGetSource();
      case BXCorePackage.PATTERN_TYPE_LITERAL__ROOT:
        return getRoot();
      case BXCorePackage.PATTERN_TYPE_LITERAL__ADDITIONAL:
        return getAdditional();
      case BXCorePackage.PATTERN_TYPE_LITERAL__FILTER:
        return getFilter();
      case BXCorePackage.PATTERN_TYPE_LITERAL__ORDER_BY:
        if (resolve) return getOrderBy();
        return basicGetOrderBy();
      case BXCorePackage.PATTERN_TYPE_LITERAL__DIRECTION:
        return getDirection();
      case BXCorePackage.PATTERN_TYPE_LITERAL__PIVOT:
        if (resolve) return getPivot();
        return basicGetPivot();
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
      case BXCorePackage.PATTERN_TYPE_LITERAL__SOURCE:
        setSource((ImportSection)newValue);
        return;
      case BXCorePackage.PATTERN_TYPE_LITERAL__ROOT:
        setRoot((PatternNode)newValue);
        return;
      case BXCorePackage.PATTERN_TYPE_LITERAL__ADDITIONAL:
        getAdditional().clear();
        getAdditional().addAll((Collection<? extends TypeVar>)newValue);
        return;
      case BXCorePackage.PATTERN_TYPE_LITERAL__FILTER:
        setFilter((ContextAwareCondition)newValue);
        return;
      case BXCorePackage.PATTERN_TYPE_LITERAL__ORDER_BY:
        setOrderBy((AbstractPatternEdge)newValue);
        return;
      case BXCorePackage.PATTERN_TYPE_LITERAL__DIRECTION:
        setDirection((String)newValue);
        return;
      case BXCorePackage.PATTERN_TYPE_LITERAL__PIVOT:
        setPivot((TypeVar)newValue);
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
      case BXCorePackage.PATTERN_TYPE_LITERAL__SOURCE:
        setSource((ImportSection)null);
        return;
      case BXCorePackage.PATTERN_TYPE_LITERAL__ROOT:
        setRoot((PatternNode)null);
        return;
      case BXCorePackage.PATTERN_TYPE_LITERAL__ADDITIONAL:
        getAdditional().clear();
        return;
      case BXCorePackage.PATTERN_TYPE_LITERAL__FILTER:
        setFilter((ContextAwareCondition)null);
        return;
      case BXCorePackage.PATTERN_TYPE_LITERAL__ORDER_BY:
        setOrderBy((AbstractPatternEdge)null);
        return;
      case BXCorePackage.PATTERN_TYPE_LITERAL__DIRECTION:
        setDirection(DIRECTION_EDEFAULT);
        return;
      case BXCorePackage.PATTERN_TYPE_LITERAL__PIVOT:
        setPivot((TypeVar)null);
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
      case BXCorePackage.PATTERN_TYPE_LITERAL__SOURCE:
        return source != null;
      case BXCorePackage.PATTERN_TYPE_LITERAL__ROOT:
        return root != null;
      case BXCorePackage.PATTERN_TYPE_LITERAL__ADDITIONAL:
        return additional != null && !additional.isEmpty();
      case BXCorePackage.PATTERN_TYPE_LITERAL__FILTER:
        return filter != null;
      case BXCorePackage.PATTERN_TYPE_LITERAL__ORDER_BY:
        return orderBy != null;
      case BXCorePackage.PATTERN_TYPE_LITERAL__DIRECTION:
        return DIRECTION_EDEFAULT == null ? direction != null : !DIRECTION_EDEFAULT.equals(direction);
      case BXCorePackage.PATTERN_TYPE_LITERAL__PIVOT:
        return pivot != null;
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
    result.append(" (direction: ");
    result.append(direction);
    result.append(')');
    return result.toString();
  }

} //PatternTypeLiteralImpl
