/**
 */
package edu.ustb.sei.mde.xmu2.statement;

import edu.ustb.sei.mde.xmu2.pattern.Pattern;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Enforce Pattern Statement</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.ustb.sei.mde.xmu2.statement.EnforcePatternStatement#getPattern <em>Pattern</em>}</li>
 * </ul>
 *
 * @see edu.ustb.sei.mde.xmu2.statement.StatementPackage#getEnforcePatternStatement()
 * @model
 * @generated
 */
public interface EnforcePatternStatement extends UnidirectionalStatement {
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
	 * @see edu.ustb.sei.mde.xmu2.statement.StatementPackage#getEnforcePatternStatement_Pattern()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Pattern getPattern();

	/**
	 * Sets the value of the '{@link edu.ustb.sei.mde.xmu2.statement.EnforcePatternStatement#getPattern <em>Pattern</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Pattern</em>' containment reference.
	 * @see #getPattern()
	 * @generated
	 */
	void setPattern(Pattern value);

} // EnforcePatternStatement
