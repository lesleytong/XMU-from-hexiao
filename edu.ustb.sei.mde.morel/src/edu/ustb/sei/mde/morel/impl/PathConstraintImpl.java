/**
 */
package edu.ustb.sei.mde.morel.impl;

import edu.ustb.sei.mde.morel.MorelPackage;
import edu.ustb.sei.mde.morel.PathConstraint;
import edu.ustb.sei.mde.morel.Variable;

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
 * An implementation of the model object '<em><b>Path Constraint</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link edu.ustb.sei.mde.morel.impl.PathConstraintImpl#getMinLength <em>Min Length</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.morel.impl.PathConstraintImpl#getMaxLength <em>Max Length</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.morel.impl.PathConstraintImpl#getPathVariable <em>Path Variable</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.morel.impl.PathConstraintImpl#getReferences <em>References</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.morel.impl.PathConstraintImpl#getTypes <em>Types</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PathConstraintImpl extends LinkConstraintImpl implements PathConstraint {
	/**
	 * The default value of the '{@link #getMinLength() <em>Min Length</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMinLength()
	 * @generated
	 * @ordered
	 */
	protected static final int MIN_LENGTH_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getMinLength() <em>Min Length</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMinLength()
	 * @generated
	 * @ordered
	 */
	protected int minLength = MIN_LENGTH_EDEFAULT;

	/**
	 * The default value of the '{@link #getMaxLength() <em>Max Length</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaxLength()
	 * @generated
	 * @ordered
	 */
	protected static final int MAX_LENGTH_EDEFAULT = -1;

	/**
	 * The cached value of the '{@link #getMaxLength() <em>Max Length</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaxLength()
	 * @generated
	 * @ordered
	 */
	protected int maxLength = MAX_LENGTH_EDEFAULT;

	/**
	 * The cached value of the '{@link #getPathVariable() <em>Path Variable</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPathVariable()
	 * @generated
	 * @ordered
	 */
	protected Variable pathVariable;

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
	protected PathConstraintImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MorelPackage.Literals.PATH_CONSTRAINT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getMinLength() {
		return minLength;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMinLength(int newMinLength) {
		int oldMinLength = minLength;
		minLength = newMinLength;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MorelPackage.PATH_CONSTRAINT__MIN_LENGTH, oldMinLength, minLength));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getMaxLength() {
		return maxLength;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMaxLength(int newMaxLength) {
		int oldMaxLength = maxLength;
		maxLength = newMaxLength;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MorelPackage.PATH_CONSTRAINT__MAX_LENGTH, oldMaxLength, maxLength));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Variable getPathVariable() {
		if (pathVariable != null && pathVariable.eIsProxy()) {
			InternalEObject oldPathVariable = (InternalEObject)pathVariable;
			pathVariable = (Variable)eResolveProxy(oldPathVariable);
			if (pathVariable != oldPathVariable) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, MorelPackage.PATH_CONSTRAINT__PATH_VARIABLE, oldPathVariable, pathVariable));
			}
		}
		return pathVariable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Variable basicGetPathVariable() {
		return pathVariable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPathVariable(Variable newPathVariable) {
		Variable oldPathVariable = pathVariable;
		pathVariable = newPathVariable;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MorelPackage.PATH_CONSTRAINT__PATH_VARIABLE, oldPathVariable, pathVariable));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<EReference> getReferences() {
		if (references == null) {
			references = new EObjectResolvingEList<EReference>(EReference.class, this, MorelPackage.PATH_CONSTRAINT__REFERENCES);
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
			types = new EObjectResolvingEList<EClass>(EClass.class, this, MorelPackage.PATH_CONSTRAINT__TYPES);
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
			case MorelPackage.PATH_CONSTRAINT__MIN_LENGTH:
				return getMinLength();
			case MorelPackage.PATH_CONSTRAINT__MAX_LENGTH:
				return getMaxLength();
			case MorelPackage.PATH_CONSTRAINT__PATH_VARIABLE:
				if (resolve) return getPathVariable();
				return basicGetPathVariable();
			case MorelPackage.PATH_CONSTRAINT__REFERENCES:
				return getReferences();
			case MorelPackage.PATH_CONSTRAINT__TYPES:
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
			case MorelPackage.PATH_CONSTRAINT__MIN_LENGTH:
				setMinLength((Integer)newValue);
				return;
			case MorelPackage.PATH_CONSTRAINT__MAX_LENGTH:
				setMaxLength((Integer)newValue);
				return;
			case MorelPackage.PATH_CONSTRAINT__PATH_VARIABLE:
				setPathVariable((Variable)newValue);
				return;
			case MorelPackage.PATH_CONSTRAINT__REFERENCES:
				getReferences().clear();
				getReferences().addAll((Collection<? extends EReference>)newValue);
				return;
			case MorelPackage.PATH_CONSTRAINT__TYPES:
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
			case MorelPackage.PATH_CONSTRAINT__MIN_LENGTH:
				setMinLength(MIN_LENGTH_EDEFAULT);
				return;
			case MorelPackage.PATH_CONSTRAINT__MAX_LENGTH:
				setMaxLength(MAX_LENGTH_EDEFAULT);
				return;
			case MorelPackage.PATH_CONSTRAINT__PATH_VARIABLE:
				setPathVariable((Variable)null);
				return;
			case MorelPackage.PATH_CONSTRAINT__REFERENCES:
				getReferences().clear();
				return;
			case MorelPackage.PATH_CONSTRAINT__TYPES:
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
			case MorelPackage.PATH_CONSTRAINT__MIN_LENGTH:
				return minLength != MIN_LENGTH_EDEFAULT;
			case MorelPackage.PATH_CONSTRAINT__MAX_LENGTH:
				return maxLength != MAX_LENGTH_EDEFAULT;
			case MorelPackage.PATH_CONSTRAINT__PATH_VARIABLE:
				return pathVariable != null;
			case MorelPackage.PATH_CONSTRAINT__REFERENCES:
				return references != null && !references.isEmpty();
			case MorelPackage.PATH_CONSTRAINT__TYPES:
				return types != null && !types.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (minLength: ");
		result.append(minLength);
		result.append(", maxLength: ");
		result.append(maxLength);
		result.append(')');
		return result.toString();
	}

} //PathConstraintImpl
