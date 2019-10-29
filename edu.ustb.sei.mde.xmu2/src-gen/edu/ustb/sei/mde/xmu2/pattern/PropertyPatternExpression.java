/**
 */
package edu.ustb.sei.mde.xmu2.pattern;

import edu.ustb.sei.mde.xmu2.expression.Expression;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Property Pattern Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.ustb.sei.mde.xmu2.pattern.PropertyPatternExpression#getTargetExpression <em>Target Expression</em>}</li>
 * </ul>
 *
 * @see edu.ustb.sei.mde.xmu2.pattern.PatternPackage#getPropertyPatternExpression()
 * @model
 * @generated
 */
public interface PropertyPatternExpression extends PatternExpression {
	/**
	 * Returns the value of the '<em><b>Target Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target Expression</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target Expression</em>' containment reference.
	 * @see #setTargetExpression(Expression)
	 * @see edu.ustb.sei.mde.xmu2.pattern.PatternPackage#getPropertyPatternExpression_TargetExpression()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Expression getTargetExpression();

	/**
	 * Sets the value of the '{@link edu.ustb.sei.mde.xmu2.pattern.PropertyPatternExpression#getTargetExpression <em>Target Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target Expression</em>' containment reference.
	 * @see #getTargetExpression()
	 * @generated
	 */
	void setTargetExpression(Expression value);

} // PropertyPatternExpression
