/**
 */
package edu.ustb.sei.mde.xmu2core;

import edu.ustb.sei.mde.xmu2common.NamedElement;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Procedure</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.ustb.sei.mde.xmu2core.Procedure#getVariables <em>Variables</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.xmu2core.Procedure#getParameters <em>Parameters</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.xmu2core.Procedure#getStatements <em>Statements</em>}</li>
 * </ul>
 *
 * @see edu.ustb.sei.mde.xmu2core.Xmu2corePackage#getProcedure()
 * @model
 * @generated
 */
public interface Procedure extends NamedElement {
	/**
	 * Returns the value of the '<em><b>Variables</b></em>' containment reference list.
	 * The list contents are of type {@link edu.ustb.sei.mde.xmu2core.Variable}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Variables</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Variables</em>' containment reference list.
	 * @see edu.ustb.sei.mde.xmu2core.Xmu2corePackage#getProcedure_Variables()
	 * @model containment="true"
	 * @generated
	 */
	EList<Variable> getVariables();

	/**
	 * Returns the value of the '<em><b>Parameters</b></em>' reference list.
	 * The list contents are of type {@link edu.ustb.sei.mde.xmu2core.Variable}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parameters</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parameters</em>' reference list.
	 * @see edu.ustb.sei.mde.xmu2core.Xmu2corePackage#getProcedure_Parameters()
	 * @model
	 * @generated
	 */
	EList<Variable> getParameters();

	/**
	 * Returns the value of the '<em><b>Statements</b></em>' containment reference list.
	 * The list contents are of type {@link edu.ustb.sei.mde.xmu2core.Statement}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Statements</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Statements</em>' containment reference list.
	 * @see edu.ustb.sei.mde.xmu2core.Xmu2corePackage#getProcedure_Statements()
	 * @model containment="true"
	 * @generated
	 */
	EList<Statement> getStatements();

} // Procedure
