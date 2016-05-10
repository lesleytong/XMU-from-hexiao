/**
 */
package edu.ustb.sei.mde.xmu2core.impl;

import edu.ustb.sei.mde.xmu2common.impl.NamedElementImpl;

import edu.ustb.sei.mde.xmu2core.Procedure;
import edu.ustb.sei.mde.xmu2core.Statement;
import edu.ustb.sei.mde.xmu2core.Variable;
import edu.ustb.sei.mde.xmu2core.Xmu2corePackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Procedure</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link edu.ustb.sei.mde.xmu2core.impl.ProcedureImpl#getVariables <em>Variables</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.xmu2core.impl.ProcedureImpl#getParameters <em>Parameters</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.xmu2core.impl.ProcedureImpl#getStatements <em>Statements</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.xmu2core.impl.ProcedureImpl#getBackwardStatements <em>Backward Statements</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.xmu2core.impl.ProcedureImpl#getForwardStatements <em>Forward Statements</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ProcedureImpl extends NamedElementImpl implements Procedure {
	/**
	 * The cached value of the '{@link #getVariables() <em>Variables</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVariables()
	 * @generated
	 * @ordered
	 */
	protected EList<Variable> variables;

	/**
	 * The cached value of the '{@link #getParameters() <em>Parameters</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParameters()
	 * @generated
	 * @ordered
	 */
	protected EList<Variable> parameters;

	/**
	 * The cached value of the '{@link #getStatements() <em>Statements</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStatements()
	 * @generated
	 * @ordered
	 */
	protected EList<Statement> statements;

	/**
	 * The cached value of the '{@link #getBackwardStatements() <em>Backward Statements</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBackwardStatements()
	 * @generated
	 * @ordered
	 */
	protected EList<Statement> backwardStatements;

	/**
	 * The cached value of the '{@link #getForwardStatements() <em>Forward Statements</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getForwardStatements()
	 * @generated
	 * @ordered
	 */
	protected EList<Statement> forwardStatements;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ProcedureImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Xmu2corePackage.Literals.PROCEDURE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Variable> getVariables() {
		if (variables == null) {
			variables = new EObjectContainmentEList<Variable>(Variable.class, this, Xmu2corePackage.PROCEDURE__VARIABLES);
		}
		return variables;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Variable> getParameters() {
		if (parameters == null) {
			parameters = new EObjectResolvingEList<Variable>(Variable.class, this, Xmu2corePackage.PROCEDURE__PARAMETERS);
		}
		return parameters;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Statement> getStatements() {
		if (statements == null) {
			statements = new EObjectContainmentEList<Statement>(Statement.class, this, Xmu2corePackage.PROCEDURE__STATEMENTS);
		}
		return statements;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Statement> getBackwardStatements() {
		if (backwardStatements == null) {
			backwardStatements = new EObjectContainmentEList<Statement>(Statement.class, this, Xmu2corePackage.PROCEDURE__BACKWARD_STATEMENTS);
		}
		return backwardStatements;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Statement> getForwardStatements() {
		if (forwardStatements == null) {
			forwardStatements = new EObjectContainmentEList<Statement>(Statement.class, this, Xmu2corePackage.PROCEDURE__FORWARD_STATEMENTS);
		}
		return forwardStatements;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case Xmu2corePackage.PROCEDURE__VARIABLES:
				return ((InternalEList<?>)getVariables()).basicRemove(otherEnd, msgs);
			case Xmu2corePackage.PROCEDURE__STATEMENTS:
				return ((InternalEList<?>)getStatements()).basicRemove(otherEnd, msgs);
			case Xmu2corePackage.PROCEDURE__BACKWARD_STATEMENTS:
				return ((InternalEList<?>)getBackwardStatements()).basicRemove(otherEnd, msgs);
			case Xmu2corePackage.PROCEDURE__FORWARD_STATEMENTS:
				return ((InternalEList<?>)getForwardStatements()).basicRemove(otherEnd, msgs);
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
			case Xmu2corePackage.PROCEDURE__VARIABLES:
				return getVariables();
			case Xmu2corePackage.PROCEDURE__PARAMETERS:
				return getParameters();
			case Xmu2corePackage.PROCEDURE__STATEMENTS:
				return getStatements();
			case Xmu2corePackage.PROCEDURE__BACKWARD_STATEMENTS:
				return getBackwardStatements();
			case Xmu2corePackage.PROCEDURE__FORWARD_STATEMENTS:
				return getForwardStatements();
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
			case Xmu2corePackage.PROCEDURE__VARIABLES:
				getVariables().clear();
				getVariables().addAll((Collection<? extends Variable>)newValue);
				return;
			case Xmu2corePackage.PROCEDURE__PARAMETERS:
				getParameters().clear();
				getParameters().addAll((Collection<? extends Variable>)newValue);
				return;
			case Xmu2corePackage.PROCEDURE__STATEMENTS:
				getStatements().clear();
				getStatements().addAll((Collection<? extends Statement>)newValue);
				return;
			case Xmu2corePackage.PROCEDURE__BACKWARD_STATEMENTS:
				getBackwardStatements().clear();
				getBackwardStatements().addAll((Collection<? extends Statement>)newValue);
				return;
			case Xmu2corePackage.PROCEDURE__FORWARD_STATEMENTS:
				getForwardStatements().clear();
				getForwardStatements().addAll((Collection<? extends Statement>)newValue);
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
			case Xmu2corePackage.PROCEDURE__VARIABLES:
				getVariables().clear();
				return;
			case Xmu2corePackage.PROCEDURE__PARAMETERS:
				getParameters().clear();
				return;
			case Xmu2corePackage.PROCEDURE__STATEMENTS:
				getStatements().clear();
				return;
			case Xmu2corePackage.PROCEDURE__BACKWARD_STATEMENTS:
				getBackwardStatements().clear();
				return;
			case Xmu2corePackage.PROCEDURE__FORWARD_STATEMENTS:
				getForwardStatements().clear();
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
			case Xmu2corePackage.PROCEDURE__VARIABLES:
				return variables != null && !variables.isEmpty();
			case Xmu2corePackage.PROCEDURE__PARAMETERS:
				return parameters != null && !parameters.isEmpty();
			case Xmu2corePackage.PROCEDURE__STATEMENTS:
				return statements != null && !statements.isEmpty();
			case Xmu2corePackage.PROCEDURE__BACKWARD_STATEMENTS:
				return backwardStatements != null && !backwardStatements.isEmpty();
			case Xmu2corePackage.PROCEDURE__FORWARD_STATEMENTS:
				return forwardStatements != null && !forwardStatements.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //ProcedureImpl
