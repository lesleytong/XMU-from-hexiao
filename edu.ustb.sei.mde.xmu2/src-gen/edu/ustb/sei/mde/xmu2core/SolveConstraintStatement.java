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
 *   <li>{@link edu.ustb.sei.mde.xmu2core.SolveConstraintStatement#getProblem <em>Problem</em>}</li>
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
	 * Returns the value of the '<em><b>Problem</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Problem</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Problem</em>' attribute.
	 * @see #setProblem(byte[])
	 * @see edu.ustb.sei.mde.xmu2core.Xmu2corePackage#getSolveConstraintStatement_Problem()
	 * @model required="true"
	 * @generated
	 */
	byte[] getProblem();

	/**
	 * Sets the value of the '{@link edu.ustb.sei.mde.xmu2core.SolveConstraintStatement#getProblem <em>Problem</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Problem</em>' attribute.
	 * @see #getProblem()
	 * @generated
	 */
	void setProblem(byte[] value);

} // SolveConstraintStatement
