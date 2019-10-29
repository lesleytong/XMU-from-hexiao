/**
 * generated by Xtext 2.18.0.M3
 */
package edu.ustb.sei.mde.bxcore.dsl.bXCore.impl;

import edu.ustb.sei.mde.bxcore.dsl.bXCore.BXCorePackage;
import edu.ustb.sei.mde.bxcore.dsl.bXCore.ImportSection;
import edu.ustb.sei.mde.bxcore.dsl.bXCore.OrderedTupleTypeLiteral;
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
 * An implementation of the model object '<em><b>Ordered Tuple Type Literal</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link edu.ustb.sei.mde.bxcore.dsl.bXCore.impl.OrderedTupleTypeLiteralImpl#getSource <em>Source</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.bxcore.dsl.bXCore.impl.OrderedTupleTypeLiteralImpl#getElements <em>Elements</em>}</li>
 * </ul>
 *
 * @generated
 */
public class OrderedTupleTypeLiteralImpl extends TupleTypeLiteralImpl implements OrderedTupleTypeLiteral
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
   * The cached value of the '{@link #getElements() <em>Elements</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getElements()
   * @generated
   * @ordered
   */
  protected EList<TypeVar> elements;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected OrderedTupleTypeLiteralImpl()
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
    return BXCorePackage.Literals.ORDERED_TUPLE_TYPE_LITERAL;
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
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, BXCorePackage.ORDERED_TUPLE_TYPE_LITERAL__SOURCE, oldSource, source));
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
      eNotify(new ENotificationImpl(this, Notification.SET, BXCorePackage.ORDERED_TUPLE_TYPE_LITERAL__SOURCE, oldSource, source));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<TypeVar> getElements()
  {
    if (elements == null)
    {
      elements = new EObjectContainmentEList<TypeVar>(TypeVar.class, this, BXCorePackage.ORDERED_TUPLE_TYPE_LITERAL__ELEMENTS);
    }
    return elements;
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
      case BXCorePackage.ORDERED_TUPLE_TYPE_LITERAL__ELEMENTS:
        return ((InternalEList<?>)getElements()).basicRemove(otherEnd, msgs);
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
      case BXCorePackage.ORDERED_TUPLE_TYPE_LITERAL__SOURCE:
        if (resolve) return getSource();
        return basicGetSource();
      case BXCorePackage.ORDERED_TUPLE_TYPE_LITERAL__ELEMENTS:
        return getElements();
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
      case BXCorePackage.ORDERED_TUPLE_TYPE_LITERAL__SOURCE:
        setSource((ImportSection)newValue);
        return;
      case BXCorePackage.ORDERED_TUPLE_TYPE_LITERAL__ELEMENTS:
        getElements().clear();
        getElements().addAll((Collection<? extends TypeVar>)newValue);
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
      case BXCorePackage.ORDERED_TUPLE_TYPE_LITERAL__SOURCE:
        setSource((ImportSection)null);
        return;
      case BXCorePackage.ORDERED_TUPLE_TYPE_LITERAL__ELEMENTS:
        getElements().clear();
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
      case BXCorePackage.ORDERED_TUPLE_TYPE_LITERAL__SOURCE:
        return source != null;
      case BXCorePackage.ORDERED_TUPLE_TYPE_LITERAL__ELEMENTS:
        return elements != null && !elements.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //OrderedTupleTypeLiteralImpl
