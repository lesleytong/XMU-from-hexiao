/**
 */
package edu.ustb.sei.mde.xmu2core;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Solve Constraint Statement</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.ustb.sei.mde.xmu2core.SolveConstraintStatement#getVariables <em>Variables</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.xmu2core.SolveConstraintStatement#getConstraint <em>Constraint</em>}</li>
 * </ul>
 *
 * @see edu.ustb.sei.mde.xmu2core.Xmu2corePackage#getSolveConstraintStatement()
 * @model
 * @generated
 */
public interface SolveConstraintStatement extends Statement {
	/**
	 * Returns the value of the '<em><b>Variables</b></em>' reference list.
	 * The list contents are of type {@link edu.ustb.sei.mde.xmu2core.Variable}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Variables</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Variables</em>' reference list.
	 * @see edu.ustb.sei.mde.xmu2core.Xmu2corePackage#getSolveConstraintStatement_Variables()
	 * @model
	 * @generated
	 */
	EList<Variable> getVariables();

	/**
	 * Returns the value of the '<em><b>Constraint</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Constraint</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Constraint</em>' containment reference.
	 * @see #setConstraint(Expression)
	 * @see edu.ustb.sei.mde.xmu2core.Xmu2corePackage#getSolveConstraintStatement_Constraint()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Expression getConstraint();

	/**
	 * Sets the value of the '{@link edu.ustb.sei.mde.xmu2core.SolveConstraintStatement#getConstraint <em>Constraint</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Constraint</em>' containment reference.
	 * @see #getConstraint()
	 * @generated
	 */
	void setConstraint(Expression value);

} // SolveConstraintStatement
