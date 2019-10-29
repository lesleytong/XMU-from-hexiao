/**
 */
package edu.ustb.sei.mde.xmu2.statement;

import edu.ustb.sei.mde.xmu2.pattern.Pattern;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Update Statement</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.ustb.sei.mde.xmu2.statement.UpdateStatement#getSource <em>Source</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.xmu2.statement.UpdateStatement#getView <em>View</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.xmu2.statement.UpdateStatement#getClauses <em>Clauses</em>}</li>
 * </ul>
 *
 * @see edu.ustb.sei.mde.xmu2.statement.StatementPackage#getUpdateStatement()
 * @model
 * @generated
 */
public interface UpdateStatement extends BidirectionalStatement {
	/**
	 * Returns the value of the '<em><b>Source</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source</em>' containment reference.
	 * @see #setSource(Pattern)
	 * @see edu.ustb.sei.mde.xmu2.statement.StatementPackage#getUpdateStatement_Source()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Pattern getSource();

	/**
	 * Sets the value of the '{@link edu.ustb.sei.mde.xmu2.statement.UpdateStatement#getSource <em>Source</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source</em>' containment reference.
	 * @see #getSource()
	 * @generated
	 */
	void setSource(Pattern value);

	/**
	 * Returns the value of the '<em><b>View</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>View</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>View</em>' containment reference.
	 * @see #setView(Pattern)
	 * @see edu.ustb.sei.mde.xmu2.statement.StatementPackage#getUpdateStatement_View()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Pattern getView();

	/**
	 * Sets the value of the '{@link edu.ustb.sei.mde.xmu2.statement.UpdateStatement#getView <em>View</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>View</em>' containment reference.
	 * @see #getView()
	 * @generated
	 */
	void setView(Pattern value);

	/**
	 * Returns the value of the '<em><b>Clauses</b></em>' containment reference list.
	 * The list contents are of type {@link edu.ustb.sei.mde.xmu2.statement.UpdateClause}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Clauses</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Clauses</em>' containment reference list.
	 * @see edu.ustb.sei.mde.xmu2.statement.StatementPackage#getUpdateStatement_Clauses()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<UpdateClause> getClauses();

} // UpdateStatement
