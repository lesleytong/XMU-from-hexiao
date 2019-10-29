/**
 */
package edu.ustb.sei.mde.xmu2.statement;

import edu.ustb.sei.mde.xmu2.pattern.Pattern;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>For Each Statement</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.ustb.sei.mde.xmu2.statement.ForEachStatement#getPattern <em>Pattern</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.xmu2.statement.ForEachStatement#getAction <em>Action</em>}</li>
 * </ul>
 *
 * @see edu.ustb.sei.mde.xmu2.statement.StatementPackage#getForEachStatement()
 * @model
 * @generated
 */
public interface ForEachStatement extends UnidirectionalStatement {
	/**
	 * Returns the value of the '<em><b>Pattern</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Pattern</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Pattern</em>' containment reference.
	 * @see #setPattern(Pattern)
	 * @see edu.ustb.sei.mde.xmu2.statement.StatementPackage#getForEachStatement_Pattern()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Pattern getPattern();

	/**
	 * Sets the value of the '{@link edu.ustb.sei.mde.xmu2.statement.ForEachStatement#getPattern <em>Pattern</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Pattern</em>' containment reference.
	 * @see #getPattern()
	 * @generated
	 */
	void setPattern(Pattern value);

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
	 * @see edu.ustb.sei.mde.xmu2.statement.StatementPackage#getForEachStatement_Action()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Statement getAction();

	/**
	 * Sets the value of the '{@link edu.ustb.sei.mde.xmu2.statement.ForEachStatement#getAction <em>Action</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Action</em>' containment reference.
	 * @see #getAction()
	 * @generated
	 */
	void setAction(Statement value);

} // ForEachStatement
