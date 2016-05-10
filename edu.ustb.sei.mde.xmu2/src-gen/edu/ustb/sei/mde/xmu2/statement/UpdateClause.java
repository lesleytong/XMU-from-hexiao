/**
 */
package edu.ustb.sei.mde.xmu2.statement;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Update Clause</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.ustb.sei.mde.xmu2.statement.UpdateClause#getType <em>Type</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.xmu2.statement.UpdateClause#getStatement <em>Statement</em>}</li>
 * </ul>
 *
 * @see edu.ustb.sei.mde.xmu2.statement.StatementPackage#getUpdateClause()
 * @model
 * @generated
 */
public interface UpdateClause extends EObject {
	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * The default value is <code>"default"</code>.
	 * The literals are from the enumeration {@link edu.ustb.sei.mde.xmu2.statement.ActionType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see edu.ustb.sei.mde.xmu2.statement.ActionType
	 * @see #setType(ActionType)
	 * @see edu.ustb.sei.mde.xmu2.statement.StatementPackage#getUpdateClause_Type()
	 * @model default="default" required="true"
	 * @generated
	 */
	ActionType getType();

	/**
	 * Sets the value of the '{@link edu.ustb.sei.mde.xmu2.statement.UpdateClause#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see edu.ustb.sei.mde.xmu2.statement.ActionType
	 * @see #getType()
	 * @generated
	 */
	void setType(ActionType value);

	/**
	 * Returns the value of the '<em><b>Statement</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Statement</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Statement</em>' containment reference.
	 * @see #setStatement(Statement)
	 * @see edu.ustb.sei.mde.xmu2.statement.StatementPackage#getUpdateClause_Statement()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Statement getStatement();

	/**
	 * Sets the value of the '{@link edu.ustb.sei.mde.xmu2.statement.UpdateClause#getStatement <em>Statement</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Statement</em>' containment reference.
	 * @see #getStatement()
	 * @generated
	 */
	void setStatement(Statement value);

} // UpdateClause
