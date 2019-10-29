/**
 */
package edu.ustb.sei.mde.xmu2.pattern;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Object Pattern Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.ustb.sei.mde.xmu2.pattern.ObjectPatternExpression#getTargetNode <em>Target Node</em>}</li>
 * </ul>
 *
 * @see edu.ustb.sei.mde.xmu2.pattern.PatternPackage#getObjectPatternExpression()
 * @model
 * @generated
 */
public interface ObjectPatternExpression extends PatternExpression {
	/**
	 * Returns the value of the '<em><b>Target Node</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target Node</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target Node</em>' containment reference.
	 * @see #setTargetNode(PatternNode)
	 * @see edu.ustb.sei.mde.xmu2.pattern.PatternPackage#getObjectPatternExpression_TargetNode()
	 * @model containment="true" required="true"
	 * @generated
	 */
	PatternNode getTargetNode();

	/**
	 * Sets the value of the '{@link edu.ustb.sei.mde.xmu2.pattern.ObjectPatternExpression#getTargetNode <em>Target Node</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target Node</em>' containment reference.
	 * @see #getTargetNode()
	 * @generated
	 */
	void setTargetNode(PatternNode value);

} // ObjectPatternExpression
