/**
 */
package edu.ustb.sei.mde.xmu2.statement;

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
 *   <li>{@link edu.ustb.sei.mde.xmu2.statement.CaseClause#getAction <em>Action</em>}</li>
 * </ul>
 *
 * @see edu.ustb.sei.mde.xmu2.statement.StatementPackage#getCaseClause()
 * @model abstract="true"
 * @generated
 */
public interface CaseClause extends EObject {
	/**
	 * Returns the value of the '<em><b>Action</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Action</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Action</em>' containment reference.
	 * @see #setAction(Statement)
	 * @see edu.ustb.sei.mde.xmu2.statement.StatementPackage#getCaseClause_Action()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Statement getAction();

	/**
	 * Sets the value of the '{@link edu.ustb.sei.mde.xmu2.statement.CaseClause#getAction <em>Action</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Action</em>' containment reference.
	 * @see #getAction()
	 * @generated
	 */
	void setAction(Statement value);

} // CaseClause
