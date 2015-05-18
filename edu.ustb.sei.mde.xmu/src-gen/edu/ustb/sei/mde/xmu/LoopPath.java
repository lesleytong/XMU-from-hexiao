/**
 */
package edu.ustb.sei.mde.xmu;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Loop Path</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link edu.ustb.sei.mde.xmu.LoopPath#getOperator <em>Operator</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.xmu.LoopPath#getVariable <em>Variable</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.xmu.LoopPath#getBody <em>Body</em>}</li>
 * </ul>
 * </p>
 *
 * @see edu.ustb.sei.mde.xmu.XmuPackage#getLoopPath()
 * @model
 * @generated
 */
public interface LoopPath extends Path {
	/**
	 * Returns the value of the '<em><b>Operator</b></em>' attribute.
	 * The literals are from the enumeration {@link edu.ustb.sei.mde.xmu.LoopOperator}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Operator</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Operator</em>' attribute.
	 * @see edu.ustb.sei.mde.xmu.LoopOperator
	 * @see #setOperator(LoopOperator)
	 * @see edu.ustb.sei.mde.xmu.XmuPackage#getLoopPath_Operator()
	 * @model required="true"
	 * @generated
	 */
	LoopOperator getOperator();

	/**
	 * Sets the value of the '{@link edu.ustb.sei.mde.xmu.LoopPath#getOperator <em>Operator</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Operator</em>' attribute.
	 * @see edu.ustb.sei.mde.xmu.LoopOperator
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
	 * @see #setVariable(Variable)
	 * @see edu.ustb.sei.mde.xmu.XmuPackage#getLoopPath_Variable()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Variable getVariable();

	/**
	 * Sets the value of the '{@link edu.ustb.sei.mde.xmu.LoopPath#getVariable <em>Variable</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Variable</em>' containment reference.
	 * @see #getVariable()
	 * @generated
	 */
	void setVariable(Variable value);

	/**
	 * Returns the value of the '<em><b>Body</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Body</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Body</em>' containment reference.
	 * @see #setBody(Expr)
	 * @see edu.ustb.sei.mde.xmu.XmuPackage#getLoopPath_Body()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Expr getBody();

	/**
	 * Sets the value of the '{@link edu.ustb.sei.mde.xmu.LoopPath#getBody <em>Body</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Body</em>' containment reference.
	 * @see #getBody()
	 * @generated
	 */
	void setBody(Expr value);

} // LoopPath
