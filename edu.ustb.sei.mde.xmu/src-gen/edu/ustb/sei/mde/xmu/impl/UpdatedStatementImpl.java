/**
 */
package edu.ustb.sei.mde.xmu.impl;

import edu.ustb.sei.mde.xmu.UpdatedStatement;
import edu.ustb.sei.mde.xmu.Variable;
import edu.ustb.sei.mde.xmu.XmuPackage;
import java.util.Collection;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Updated Statement</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link edu.ustb.sei.mde.xmu.impl.UpdatedStatementImpl#getSVar <em>SVar</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.xmu.impl.UpdatedStatementImpl#getVVar <em>VVar</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class UpdatedStatementImpl extends StatementImpl implements UpdatedStatement {
	/**
	 * The cached value of the '{@link #getSVar() <em>SVar</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSVar()
	 * @generated
	 * @ordered
	 */
	protected EList<Variable> sVar;

	/**
	 * The cached value of the '{@link #getVVar() <em>VVar</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVVar()
	 * @generated
	 * @ordered
	 */
	protected EList<Variable> vVar;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected UpdatedStatementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return XmuPackage.Literals.UPDATED_STATEMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Variable> getSVar() {
		if (sVar == null) {
			sVar = new EObjectResolvingEList<Variable>(Variable.class, this, XmuPackage.UPDATED_STATEMENT__SVAR);
		}
		return sVar;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Variable> getVVar() {
		if (vVar == null) {
			vVar = new EObjectResolvingEList<Variable>(Variable.class, this, XmuPackage.UPDATED_STATEMENT__VVAR);
		}
		return vVar;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case XmuPackage.UPDATED_STATEMENT__SVAR:
				return getSVar();
			case XmuPackage.UPDATED_STATEMENT__VVAR:
				return getVVar();
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
			case XmuPackage.UPDATED_STATEMENT__SVAR:
				getSVar().clear();
				getSVar().addAll((Collection<? extends Variable>)newValue);
				return;
			case XmuPackage.UPDATED_STATEMENT__VVAR:
				getVVar().clear();
				getVVar().addAll((Collection<? extends Variable>)newValue);
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
			case XmuPackage.UPDATED_STATEMENT__SVAR:
				getSVar().clear();
				return;
			case XmuPackage.UPDATED_STATEMENT__VVAR:
				getVVar().clear();
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
			case XmuPackage.UPDATED_STATEMENT__SVAR:
				return sVar != null && !sVar.isEmpty();
			case XmuPackage.UPDATED_STATEMENT__VVAR:
				return vVar != null && !vVar.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //UpdatedStatementImpl
