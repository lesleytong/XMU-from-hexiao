/**
 */
package edu.ustb.sei.mde.xmu2.expression;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Operation Path</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.ustb.sei.mde.xmu2.expression.OperationPath#getOperation <em>Operation</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.xmu2.expression.OperationPath#getParameters <em>Parameters</em>}</li>
 * </ul>
 *
 * @see edu.ustb.sei.mde.xmu2.expression.ExpressionPackage#getOperationPath()
 * @model
 * @generated
 */
public interface OperationPath extends Path {
	/**
	 * Returns the value of the '<em><b>Operation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Operation</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Operation</em>' attribute.
	 * @see #setOperation(String)
	 * @see edu.ustb.sei.mde.xmu2.expression.ExpressionPackage#getOperationPath_Operation()
	 * @model required="true"
	 * @generated
	 */
	String getOperation();

	/**
	 * Sets the value of the '{@link edu.ustb.sei.mde.xmu2.expression.OperationPath#getOperation <em>Operation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Operation</em>' attribute.
	 * @see #getOperation()
	 * @generated
	 */
	void setOperation(String value);

	/**
	 * Returns the value of the '<em><b>Parameters</b></em>' containment reference list.
	 * The list contents are of type {@link edu.ustb.sei.mde.xmu2.expression.Expression}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parameters</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parameters</em>' containment reference list.
	 * @see edu.ustb.sei.mde.xmu2.expression.ExpressionPackage#getOperationPath_Parameters()
	 * @model containment="true"
	 * @generated
	 */
	EList<Expression> getParameters();

} // OperationPath
