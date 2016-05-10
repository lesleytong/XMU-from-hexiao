/**
 */
package edu.ustb.sei.mde.xmu2core;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Property Pattern Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.ustb.sei.mde.xmu2core.PropertyPatternExpression#getTarget <em>Target</em>}</li>
 * </ul>
 *
 * @see edu.ustb.sei.mde.xmu2core.Xmu2corePackage#getPropertyPatternExpression()
 * @model
 * @generated
 */
public interface PropertyPatternExpression extends PatternExpression {
	/**
	 * Returns the value of the '<em><b>Target</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target</em>' containment reference.
	 * @see #setTarget(Expression)
	 * @see edu.ustb.sei.mde.xmu2core.Xmu2corePackage#getPropertyPatternExpression_Target()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Expression getTarget();

	/**
	 * Sets the value of the '{@link edu.ustb.sei.mde.xmu2core.PropertyPatternExpression#getTarget <em>Target</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target</em>' containment reference.
	 * @see #getTarget()
	 * @generated
	 */
	void setTarget(Expression value);

} // PropertyPatternExpression
