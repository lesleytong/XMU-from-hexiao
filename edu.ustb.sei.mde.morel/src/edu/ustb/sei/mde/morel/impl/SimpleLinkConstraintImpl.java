/**
 */
package edu.ustb.sei.mde.morel.impl;

import edu.ustb.sei.mde.morel.Expression;
import edu.ustb.sei.mde.morel.MorelPackage;
import edu.ustb.sei.mde.morel.SimpleLinkConstraint;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Simple Link Constraint</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link edu.ustb.sei.mde.morel.impl.SimpleLinkConstraintImpl#getId <em>Id</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.morel.impl.SimpleLinkConstraintImpl#getReference <em>Reference</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SimpleLinkConstraintImpl extends LinkConstraintImpl implements SimpleLinkConstraint {
	/**
	 * The cached value of the '{@link #getId() <em>Id</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected Expression id;

	/**
	 * The cached value of the '{@link #getReference() <em>Reference</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReference()
	 * @generated
	 * @ordered
	 */
	protected EReference reference;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SimpleLinkConstraintImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MorelPackage.Literals.SIMPLE_LINK_CONSTRAINT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Expression getId() {
		return id;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetId(Expression newId, NotificationChain msgs) {
		Expression oldId = id;
		id = newId;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MorelPackage.SIMPLE_LINK_CONSTRAINT__ID, oldId, newId);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setId(Expression newId) {
		if (newId != id) {
			NotificationChain msgs = null;
			if (id != null)
				msgs = ((InternalEObject)id).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MorelPackage.SIMPLE_LINK_CONSTRAINT__ID, null, msgs);
			if (newId != null)
				msgs = ((InternalEObject)newId).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MorelPackage.SIMPLE_LINK_CONSTRAINT__ID, null, msgs);
			msgs = basicSetId(newId, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MorelPackage.SIMPLE_LINK_CONSTRAINT__ID, newId, newId));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getReference() {
		if (reference != null && reference.eIsProxy()) {
			InternalEObject oldReference = (InternalEObject)reference;
			reference = (EReference)eResolveProxy(oldReference);
			if (reference != oldReference) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, MorelPackage.SIMPLE_LINK_CONSTRAINT__REFERENCE, oldReference, reference));
			}
		}
		return reference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference basicGetReference() {
		return reference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setReference(EReference newReference) {
		EReference oldReference = reference;
		reference = newReference;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MorelPackage.SIMPLE_LINK_CONSTRAINT__REFERENCE, oldReference, reference));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case MorelPackage.SIMPLE_LINK_CONSTRAINT__ID:
				return basicSetId(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case MorelPackage.SIMPLE_LINK_CONSTRAINT__ID:
				return getId();
			case MorelPackage.SIMPLE_LINK_CONSTRAINT__REFERENCE:
				if (resolve) return getReference();
				return basicGetReference();
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
			case MorelPackage.SIMPLE_LINK_CONSTRAINT__ID:
				setId((Expression)newValue);
				return;
			case MorelPackage.SIMPLE_LINK_CONSTRAINT__REFERENCE:
				setReference((EReference)newValue);
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
			case MorelPackage.SIMPLE_LINK_CONSTRAINT__ID:
				setId((Expression)null);
				return;
			case MorelPackage.SIMPLE_LINK_CONSTRAINT__REFERENCE:
				setReference((EReference)null);
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
			case MorelPackage.SIMPLE_LINK_CONSTRAINT__ID:
				return id != null;
			case MorelPackage.SIMPLE_LINK_CONSTRAINT__REFERENCE:
				return reference != null;
		}
		return super.eIsSet(featureID);
	}
	
	/**
	 * ���Ƚ�idԼ���ģ�
	 */
	public boolean equals(Object o){
		if(o==null || !(o instanceof SimpleLinkConstraint)) return false;
		SimpleLinkConstraint l = (SimpleLinkConstraint)o;
		try {
			if(l.getSource().equals(getSource()) && l.getTarget().equals(getTarget()) && l.getReference()==getReference()) return true;
			if(l.getSource().equals(getTarget()) && l.getTarget().equals(getSource()) && l.getReference().getEOpposite()==getReference()) return true;
		} catch (Exception e) {
			return false;
		}
		return false;
	}
	
	public int hashCode() {
		final int prime = 65536;
		int result = 1;
		result = prime * result + ((source == null) ? 0 : source.hashCode());
		result = prime * result + ((target == null) ? 0 : target.hashCode());
		return result;
	}

} //SimpleLinkConstraintImpl
