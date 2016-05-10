/**
 */
package edu.ustb.sei.mde.xmu2.statement;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Block Statement</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.ustb.sei.mde.xmu2.statement.BlockStatement#getBody <em>Body</em>}</li>
 * </ul>
 *
 * @see edu.ustb.sei.mde.xmu2.statement.StatementPackage#getBlockStatement()
 * @model
 * @generated
 */
public interface BlockStatement extends Statement {
	/**
	 * Returns the value of the '<em><b>Body</b></em>' containment reference list.
	 * The list contents are of type {@link edu.ustb.sei.mde.xmu2.statement.Statement}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Body</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Body</em>' containment reference list.
	 * @see edu.ustb.sei.mde.xmu2.statement.StatementPackage#getBlockStatement_Body()
	 * @model containment="true"
	 * @generated
	 */
	EList<Statement> getBody();

} // BlockStatement
