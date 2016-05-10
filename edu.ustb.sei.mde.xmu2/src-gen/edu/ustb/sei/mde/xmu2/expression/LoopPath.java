/**
 */
package edu.ustb.sei.mde.xmu2.expression;

import edu.ustb.sei.mde.xmu2.VariableDeclaration;

import edu.ustb.sei.mde.xmu2common.LoopOperator;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Loop Path</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.ustb.sei.mde.xmu2.expression.LoopPath#getOperator <em>Operator</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.xmu2.expression.LoopPath#getVariable <em>Variable</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.xmu2.expression.LoopPath#getBody <em>Body</em>}</li>
 * </ul>
 *
 * @see edu.ustb.sei.mde.xmu2.expression.ExpressionPackage#getLoopPath()
 * @model
 * @generated
 */
public interface LoopPath extends Path {
	/**
	 * Returns the value of the '<em><b>Operator</b></em>' attribute.
	 * The literals are from the enumeration {@link edu.ustb.sei.mde.xmu2common.LoopOperator}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Operator</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Operator</em>' attribute.
	 * @see edu.ustb.sei.mde.xmu2common.LoopOperator
	 * @see #setOperator(LoopOperator)
	 * @see edu.ustb.sei.mde.xmu2.expression.ExpressionPackage#getLoopPath_Operator()
	 * @model required="true"
	 * @generated
	 */
	LoopOperator getOperator();

	/**
	 * Sets the value of the '{@link edu.ustb.sei.mde.xmu2.expression.LoopPath#getOperator <em>Operator</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Operator</em>' attribute.
	 * @see edu.ustb.sei.mde.xmu2common.LoopOperator
	 * @see #getOperator()
	 * @generated
	 */
	void setOperator(LoopOperator value);

	/**
	 * Returns the value of the '<em><b>Variable</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Variable</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Variable</em>' containment reference.
	 * @see #setVariable(VariableDeclaration)
	 * @see edu.ustb.sei.mde.xmu2.expression.ExpressionPackage#getLoopPath_Variable()
	 * @model containment="true" required="true"
	 * @generated
	 */
	VariableDeclaration getVariable();

	/**
	 * Sets the value of the '{@link edu.ustb.sei.mde.xmu2.expression.LoopPath#getVariable <em>Variable</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Variable</em>' containment reference.
	 * @see #getVariable()
	 * @generated
	 */
	void setVariable(VariableDeclaration value);

	/**
	 * Returns the value of the '<em><b>Body</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Body</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Body</em>' containment reference.
	 * @see #setBody(Expression)
	 * @see edu.ustb.sei.mde.xmu2.expression.ExpressionPackage#getLoopPath_Body()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Expression getBody();

	/**
	 * Sets the value of the '{@link edu.ustb.sei.mde.xmu2.expression.LoopPath#getBody <em>Body</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Body</em>' containment reference.
	 * @see #getBody()
	 * @generated
	 */
	void setBody(Expression value);

} // LoopPath
