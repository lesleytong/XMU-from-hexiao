/**
 */
package edu.ustb.sei.mde.xmu2.expression;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Path Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.ustb.sei.mde.xmu2.expression.PathExpression#getPath <em>Path</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.xmu2.expression.PathExpression#getHost <em>Host</em>}</li>
 * </ul>
 *
 * @see edu.ustb.sei.mde.xmu2.expression.ExpressionPackage#getPathExpression()
 * @model
 * @generated
 */
public interface PathExpression extends UnaryExpressionChild {
	/**
	 * Returns the value of the '<em><b>Path</b></em>' containment reference list.
	 * The list contents are of type {@link edu.ustb.sei.mde.xmu2.expression.Path}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Path</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Path</em>' containment reference list.
	 * @see edu.ustb.sei.mde.xmu2.expression.ExpressionPackage#getPathExpression_Path()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<Path> getPath();

	/**
	 * Returns the value of the '<em><b>Host</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Host</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Host</em>' containment reference.
	 * @see #setHost(AtomicExpression)
	 * @see edu.ustb.sei.mde.xmu2.expression.ExpressionPackage#getPathExpression_Host()
	 * @model containment="true" required="true"
	 * @generated
	 */
	AtomicExpression getHost();

	/**
	 * Sets the value of the '{@link edu.ustb.sei.mde.xmu2.expression.PathExpression#getHost <em>Host</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Host</em>' containment reference.
	 * @see #getHost()
	 * @generated
	 */
	void setHost(AtomicExpression value);

} // PathExpression
