/**
 */
package edu.ustb.sei.mde.morel.impl;

import edu.ustb.sei.mde.morel.EnclosureLinkConstraint;
import edu.ustb.sei.mde.morel.MorelPackage;

import java.util.Collection;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Enclosure Link Constraint</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link edu.ustb.sei.mde.morel.impl.EnclosureLinkConstraintImpl#getForward <em>Forward</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.morel.impl.EnclosureLinkConstraintImpl#getTypes <em>Types</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EnclosureLinkConstraintImpl extends LinkConstraintImpl implements EnclosureLinkConstraint {
	/**
	 * The cached value of the '{@link #getForward() <em>Forward</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getForward()
	 * @generated
	 * @ordered
	 */
	protected EList<EReference> forward;

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
	protected EnclosureLinkConstraintImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MorelPackage.Literals.ENCLOSURE_LINK_CONSTRAINT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<EReference> getForward() {
		if (forward == null) {
			forward = new EObjectResolvingEList<EReference>(EReference.class, this, MorelPackage.ENCLOSURE_LINK_CONSTRAINT__FORWARD);
		}
		return forward;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<EClass> getTypes() {
		if (types == null) {
			types = new EObjectResolvingEList<EClass>(EClass.class, this, MorelPackage.ENCLOSURE_LINK_CONSTRAINT__TYPES);
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
			case MorelPackage.ENCLOSURE_LINK_CONSTRAINT__FORWARD:
				return getForward();
			case MorelPackage.ENCLOSURE_LINK_CONSTRAINT__TYPES:
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
			case MorelPackage.ENCLOSURE_LINK_CONSTRAINT__FORWARD:
				getForward().clear();
				getForward().addAll((Collection<? extends EReference>)newValue);
				return;
			case MorelPackage.ENCLOSURE_LINK_CONSTRAINT__TYPES:
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
			case MorelPackage.ENCLOSURE_LINK_CONSTRAINT__FORWARD:
				getForward().clear();
				return;
			case MorelPackage.ENCLOSURE_LINK_CONSTRAINT__TYPES:
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
			case MorelPackage.ENCLOSURE_LINK_CONSTRAINT__FORWARD:
				return forward != null && !forward.isEmpty();
			case MorelPackage.ENCLOSURE_LINK_CONSTRAINT__TYPES:
				return types != null && !types.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	@Override
	public int hashCode() {
		final int prime = 65536;
		int result = 1;
		result = prime * result + ((source == null) ? 0 : source.hashCode());
		result = prime * result + ((target == null) ? 0 : target.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj instanceof EnclosureLinkConstraint) {
			EnclosureLinkConstraint elc = (EnclosureLinkConstraint)obj;
			if(source!=elc.getSource() || target!= elc.getTarget()) return false;
			if(!(getForward().containsAll(elc.getForward()) && elc.getForward().containsAll(getForward()))) return false;
			if(!(getTypes().containsAll(elc.getTypes())&&elc.getTypes().containsAll(getTypes()))) return false;
			return true;
		} else 
			return false;
	}
	
	

} //EnclosureLinkConstraintImpl
