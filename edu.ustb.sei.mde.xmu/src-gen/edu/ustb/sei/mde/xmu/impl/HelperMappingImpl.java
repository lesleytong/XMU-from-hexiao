/**
 */
package edu.ustb.sei.mde.xmu.impl;

import edu.ustb.sei.mde.xmu.Expr;
import edu.ustb.sei.mde.xmu.HelperMapping;
import edu.ustb.sei.mde.xmu.XmuPackage;
import java.util.Collection;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Helper Mapping</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link edu.ustb.sei.mde.xmu.impl.HelperMappingImpl#getLeft <em>Left</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.xmu.impl.HelperMappingImpl#getRight <em>Right</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class HelperMappingImpl extends NamedElementImpl implements HelperMapping {
	/**
	 * The cached value of the '{@link #getLeft() <em>Left</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLeft()
	 * @generated
	 * @ordered
	 */
	protected EList<Expr> left;

	/**
	 * The cached value of the '{@link #getRight() <em>Right</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRight()
	 * @generated
	 * @ordered
	 */
	protected EList<Expr> right;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected HelperMappingImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return XmuPackage.Literals.HELPER_MAPPING;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Expr> getLeft() {
		if (left == null) {
			left = new EObjectContainmentEList<Expr>(Expr.class, this, XmuPackage.HELPER_MAPPING__LEFT);
		}
		return left;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Expr> getRight() {
		if (right == null) {
			right = new EObjectContainmentEList<Expr>(Expr.class, this, XmuPackage.HELPER_MAPPING__RIGHT);
		}
		return right;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case XmuPackage.HELPER_MAPPING__LEFT:
				return ((InternalEList<?>)getLeft()).basicRemove(otherEnd, msgs);
			case XmuPackage.HELPER_MAPPING__RIGHT:
				return ((InternalEList<?>)getRight()).basicRemove(otherEnd, msgs);
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
			case XmuPackage.HELPER_MAPPING__LEFT:
				return getLeft();
			case XmuPackage.HELPER_MAPPING__RIGHT:
				return getRight();
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
			case XmuPackage.HELPER_MAPPING__LEFT:
				getLeft().clear();
				getLeft().addAll((Collection<? extends Expr>)newValue);
				return;
			case XmuPackage.HELPER_MAPPING__RIGHT:
				getRight().clear();
				getRight().addAll((Collection<? extends Expr>)newValue);
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
			case XmuPackage.HELPER_MAPPING__LEFT:
				getLeft().clear();
				return;
			case XmuPackage.HELPER_MAPPING__RIGHT:
				getRight().clear();
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
			case XmuPackage.HELPER_MAPPING__LEFT:
				return left != null && !left.isEmpty();
			case XmuPackage.HELPER_MAPPING__RIGHT:
				return right != null && !right.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //HelperMappingImpl
