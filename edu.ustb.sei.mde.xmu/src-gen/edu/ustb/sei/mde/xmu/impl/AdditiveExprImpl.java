/**
 */
package edu.ustb.sei.mde.xmu.impl;

import edu.ustb.sei.mde.xmu.AdditiveExpr;
import edu.ustb.sei.mde.xmu.AdditiveExprChild;
import edu.ustb.sei.mde.xmu.AdditiveOperator;
import edu.ustb.sei.mde.xmu.XmuPackage;
import java.util.Collection;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EDataTypeEList;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Additive Expr</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link edu.ustb.sei.mde.xmu.impl.AdditiveExprImpl#getOperands <em>Operands</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.xmu.impl.AdditiveExprImpl#getOperators <em>Operators</em>}</li>
 * </ul>
 *
 * @generated
 */
public class AdditiveExprImpl extends RelationalExprChildImpl implements AdditiveExpr {
	/**
	 * The cached value of the '{@link #getOperands() <em>Operands</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOperands()
	 * @generated
	 * @ordered
	 */
	protected EList<AdditiveExprChild> operands;

	/**
	 * The cached value of the '{@link #getOperators() <em>Operators</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOperators()
	 * @generated
	 * @ordered
	 */
	protected EList<AdditiveOperator> operators;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AdditiveExprImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return XmuPackage.Literals.ADDITIVE_EXPR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<AdditiveExprChild> getOperands() {
		if (operands == null) {
			operands = new EObjectContainmentEList<AdditiveExprChild>(AdditiveExprChild.class, this, XmuPackage.ADDITIVE_EXPR__OPERANDS);
		}
		return operands;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<AdditiveOperator> getOperators() {
		if (operators == null) {
			operators = new EDataTypeEList<AdditiveOperator>(AdditiveOperator.class, this, XmuPackage.ADDITIVE_EXPR__OPERATORS);
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
			case XmuPackage.ADDITIVE_EXPR__OPERANDS:
				return ((InternalEList<?>)getOperands()).basicRemove(otherEnd, msgs);
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
			case XmuPackage.ADDITIVE_EXPR__OPERANDS:
				return getOperands();
			case XmuPackage.ADDITIVE_EXPR__OPERATORS:
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
			case XmuPackage.ADDITIVE_EXPR__OPERANDS:
				getOperands().clear();
				getOperands().addAll((Collection<? extends AdditiveExprChild>)newValue);
				return;
			case XmuPackage.ADDITIVE_EXPR__OPERATORS:
				getOperators().clear();
				getOperators().addAll((Collection<? extends AdditiveOperator>)newValue);
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
			case XmuPackage.ADDITIVE_EXPR__OPERANDS:
				getOperands().clear();
				return;
			case XmuPackage.ADDITIVE_EXPR__OPERATORS:
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
			case XmuPackage.ADDITIVE_EXPR__OPERANDS:
				return operands != null && !operands.isEmpty();
			case XmuPackage.ADDITIVE_EXPR__OPERATORS:
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

} //AdditiveExprImpl
