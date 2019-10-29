/**
 */
package edu.ustb.sei.mde.xmu2core;

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
 *   <li>{@link edu.ustb.sei.mde.xmu2core.LoopPath#getOperator <em>Operator</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.xmu2core.LoopPath#getIterator <em>Iterator</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.xmu2core.LoopPath#getBody <em>Body</em>}</li>
 * </ul>
 *
 * @see edu.ustb.sei.mde.xmu2core.Xmu2corePackage#getLoopPath()
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
	 * @see edu.ustb.sei.mde.xmu2core.Xmu2corePackage#getLoopPath_Operator()
	 * @model required="true"
	 * @generated
	 */
	LoopOperator getOperator();

	/**
	 * Sets the value of the '{@link edu.ustb.sei.mde.xmu2core.LoopPath#getOperator <em>Operator</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Operator</em>' attribute.
	 * @see edu.ustb.sei.mde.xmu2common.LoopOperator
	 * @see #getOperator()
	 * @generated
	 */
	void setOperator(LoopOperator value);

	/**
	 * Returns the value of the '<em><b>Iterator</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Iterator</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Iterator</em>' containment reference.
	 * @see #setIterator(Variable)
	 * @see edu.ustb.sei.mde.xmu2core.Xmu2corePackage#getLoopPath_Iterator()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Variable getIterator();

	/**
	 * Sets the value of the '{@link edu.ustb.sei.mde.xmu2core.LoopPath#getIterator <em>Iterator</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Iterator</em>' containment reference.
	 * @see #getIterator()
	 * @generated
	 */
	void setIterator(Variable value);

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
	 * @see edu.ustb.sei.mde.xmu2core.Xmu2corePackage#getLoopPath_Body()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Expression getBody();

	/**
	 * Sets the value of the '{@link edu.ustb.sei.mde.xmu2core.LoopPath#getBody <em>Body</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Body</em>' containment reference.
	 * @see #getBody()
	 * @generated
	 */
	void setBody(Expression value);

} // LoopPath
