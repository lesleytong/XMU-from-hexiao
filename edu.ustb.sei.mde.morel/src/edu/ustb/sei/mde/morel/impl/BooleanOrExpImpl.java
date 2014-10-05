/**
 */
package edu.ustb.sei.mde.morel.impl;

import edu.ustb.sei.mde.morel.BooleanOperator;
import edu.ustb.sei.mde.morel.BooleanOrExp;
import edu.ustb.sei.mde.morel.BooleanOrExpChild;
import edu.ustb.sei.mde.morel.MorelPackage;
import java.util.Collection;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Boolean Or Exp</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link edu.ustb.sei.mde.morel.impl.BooleanOrExpImpl#getChildren <em>Children</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.morel.impl.BooleanOrExpImpl#getOperators <em>Operators</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class BooleanOrExpImpl extends BooleanImpliesExpChildImpl implements BooleanOrExp {
	/**
	 * The cached value of the '{@link #getChildren() <em>Children</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getChildren()
	 * @generated
	 * @ordered
	 */
	protected EList<BooleanOrExpChild> children;

	/**
	 * The cached value of the '{@link #getOperators() <em>Operators</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOperators()
	 * @generated
	 * @ordered
	 */
	protected EList<BooleanOperator> operators;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BooleanOrExpImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MorelPackage.Literals.BOOLEAN_OR_EXP;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<BooleanOrExpChild> getChildren() {
		if (children == null) {
			children = new EObjectContainmentEList<BooleanOrExpChild>(BooleanOrExpChild.class, this, MorelPackage.BOOLEAN_OR_EXP__CHILDREN);
		}
		return children;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<BooleanOperator> getOperators() {
		if (operators == null) {
			operators = new EDataTypeUniqueEList<BooleanOperator>(BooleanOperator.class, this, MorelPackage.BOOLEAN_OR_EXP__OPERATORS);
		}
		return operators;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case MorelPackage.BOOLEAN_OR_EXP__CHILDREN:
				return ((InternalEList<?>)getChildren()).basicRemove(otherEnd, msgs);
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
			case MorelPackage.BOOLEAN_OR_EXP__CHILDREN:
				return getChildren();
			case MorelPackage.BOOLEAN_OR_EXP__OPERATORS:
				return getOperators();
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
			case MorelPackage.BOOLEAN_OR_EXP__CHILDREN:
				getChildren().clear();
				getChildren().addAll((Collection<? extends BooleanOrExpChild>)newValue);
				return;
			case MorelPackage.BOOLEAN_OR_EXP__OPERATORS:
				getOperators().clear();
				getOperators().addAll((Collection<? extends BooleanOperator>)newValue);
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
			case MorelPackage.BOOLEAN_OR_EXP__CHILDREN:
				getChildren().clear();
				return;
			case MorelPackage.BOOLEAN_OR_EXP__OPERATORS:
				getOperators().clear();
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
			case MorelPackage.BOOLEAN_OR_EXP__CHILDREN:
				return children != null && !children.isEmpty();
			case MorelPackage.BOOLEAN_OR_EXP__OPERATORS:
				return operators != null && !operators.isEmpty();
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
		result.append(" (operators: ");
		result.append(operators);
		result.append(')');
		return result.toString();
	}

} //BooleanOrExpImpl
