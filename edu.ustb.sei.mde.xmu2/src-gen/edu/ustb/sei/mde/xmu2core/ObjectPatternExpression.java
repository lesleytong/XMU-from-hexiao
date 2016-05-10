/**
 */
package edu.ustb.sei.mde.xmu2core;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Object Pattern Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.ustb.sei.mde.xmu2core.ObjectPatternExpression#getTarget <em>Target</em>}</li>
 * </ul>
 *
 * @see edu.ustb.sei.mde.xmu2core.Xmu2corePackage#getObjectPatternExpression()
 * @model
 * @generated
 */
public interface ObjectPatternExpression extends PatternExpression {
	/**
	 * Returns the value of the '<em><b>Target</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target</em>' containment reference.
	 * @see #setTarget(PatternNode)
	 * @see edu.ustb.sei.mde.xmu2core.Xmu2corePackage#getObjectPatternExpression_Target()
	 * @model containment="true" required="true"
	 * @generated
	 */
	PatternNode getTarget();

	/**
	 * Sets the value of the '{@link edu.ustb.sei.mde.xmu2core.ObjectPatternExpression#getTarget <em>Target</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target</em>' containment reference.
	 * @see #getTarget()
	 * @generated
	 */
	void setTarget(PatternNode value);

} // ObjectPatternExpression
