/**
 */
package edu.ustb.sei.mde.xmu2core;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Case Clause</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.ustb.sei.mde.xmu2core.CaseClause#getViewCreationStatements <em>View Creation Statements</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.xmu2core.CaseClause#getSourceCheckStatements <em>Source Check Statements</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.xmu2core.CaseClause#getAction <em>Action</em>}</li>
 * </ul>
 *
 * @see edu.ustb.sei.mde.xmu2core.Xmu2corePackage#getCaseClause()
 * @model abstract="true"
 * @generated
 */
public interface CaseClause extends EObject {
	/**
	 * Returns the value of the '<em><b>View Creation Statements</b></em>' containment reference list.
	 * The list contents are of type {@link edu.ustb.sei.mde.xmu2core.Statement}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>View Creation Statements</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>View Creation Statements</em>' containment reference list.
	 * @see edu.ustb.sei.mde.xmu2core.Xmu2corePackage#getCaseClause_ViewCreationStatements()
	 * @model containment="true"
	 * @generated
	 */
	EList<Statement> getViewCreationStatements();

	/**
	 * Returns the value of the '<em><b>Source Check Statements</b></em>' containment reference list.
	 * The list contents are of type {@link edu.ustb.sei.mde.xmu2core.Statement}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source Check Statements</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source Check Statements</em>' containment reference list.
	 * @see edu.ustb.sei.mde.xmu2core.Xmu2corePackage#getCaseClause_SourceCheckStatements()
	 * @model containment="true"
	 * @generated
	 */
	EList<Statement> getSourceCheckStatements();

	/**
	 * Returns the value of the '<em><b>Action</b></em>' containment reference list.
	 * The list contents are of type {@link edu.ustb.sei.mde.xmu2core.Statement}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Action</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Action</em>' containment reference list.
	 * @see edu.ustb.sei.mde.xmu2core.Xmu2corePackage#getCaseClause_Action()
	 * @model containment="true"
	 * @generated
	 */
	EList<Statement> getAction();

} // CaseClause
