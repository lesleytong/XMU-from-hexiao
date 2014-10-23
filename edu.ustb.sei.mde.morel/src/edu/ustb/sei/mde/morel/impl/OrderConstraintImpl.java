/**
 */
package edu.ustb.sei.mde.morel.impl;

import edu.ustb.sei.mde.morel.MorelPackage;
import edu.ustb.sei.mde.morel.ObjectVariable;
import edu.ustb.sei.mde.morel.OrderConstraint;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Order Constraint</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link edu.ustb.sei.mde.morel.impl.OrderConstraintImpl#getBase <em>Base</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.morel.impl.OrderConstraintImpl#getReferences <em>References</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.morel.impl.OrderConstraintImpl#getTypes <em>Types</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class OrderConstraintImpl extends AdditionalConstraintImpl implements OrderConstraint {
	/**
	 * The cached value of the '{@link #getBase() <em>Base</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBase()
	 * @generated
	 * @ordered
	 */
	protected ObjectVariable base;

	/**
	 * The cached value of the '{@link #getReferences() <em>References</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReferences()
	 * @generated
	 * @ordered
	 */
	protected EList<EReference> references;

	/**
	 * The cached value of the '{@link #getTypes() <em>Types</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTypes()
	 * @generated
	 * @ordered
	 */
	protected EList<EClass> types;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected OrderConstraintImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MorelPackage.Literals.ORDER_CONSTRAINT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ObjectVariable getBase() {
		if (base != null && base.eIsProxy()) {
			InternalEObject oldBase = (InternalEObject)base;
			base = (ObjectVariable)eResolveProxy(oldBase);
			if (base != oldBase) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, MorelPackage.ORDER_CONSTRAINT__BASE, oldBase, base));
			}
		}
		return base;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ObjectVariable basicGetBase() {
		return base;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBase(ObjectVariable newBase) {
		ObjectVariable oldBase = base;
		base = newBase;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MorelPackage.ORDER_CONSTRAINT__BASE, oldBase, base));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<EReference> getReferences() {
		if (references == null) {
			references = new EObjectResolvingEList<EReference>(EReference.class, this, MorelPackage.ORDER_CONSTRAINT__REFERENCES);
		}
		return references;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<EClass> getTypes() {
		if (types == null) {
			types = new EObjectResolvingEList<EClass>(EClass.class, this, MorelPackage.ORDER_CONSTRAINT__TYPES);
		}
		return types;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case MorelPackage.ORDER_CONSTRAINT__BASE:
				if (resolve) return getBase();
				return basicGetBase();
			case MorelPackage.ORDER_CONSTRAINT__REFERENCES:
				return getReferences();
			case MorelPackage.ORDER_CONSTRAINT__TYPES:
				return getTypes();
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
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case MorelPackage.ORDER_CONSTRAINT__BASE:
				setBase((ObjectVariable)newValue);
				return;
			case MorelPackage.ORDER_CONSTRAINT__REFERENCES:
				getReferences().clear();
				getReferences().addAll((Collection<? extends EReference>)newValue);
				return;
			case MorelPackage.ORDER_CONSTRAINT__TYPES:
				getTypes().clear();
				getTypes().addAll((Collection<? extends EClass>)newValue);
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
	public void eUnset(int featureID) {
		switch (featureID) {
			case MorelPackage.ORDER_CONSTRAINT__BASE:
				setBase((ObjectVariable)null);
				return;
			case MorelPackage.ORDER_CONSTRAINT__REFERENCES:
				getReferences().clear();
				return;
			case MorelPackage.ORDER_CONSTRAINT__TYPES:
				getTypes().clear();
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
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case MorelPackage.ORDER_CONSTRAINT__BASE:
				return base != null;
			case MorelPackage.ORDER_CONSTRAINT__REFERENCES:
				return references != null && !references.isEmpty();
			case MorelPackage.ORDER_CONSTRAINT__TYPES:
				return types != null && !types.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //OrderConstraintImpl
