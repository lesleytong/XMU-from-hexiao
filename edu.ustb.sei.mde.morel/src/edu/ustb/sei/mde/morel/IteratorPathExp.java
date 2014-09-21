/**
 */
package edu.ustb.sei.mde.morel;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Iterator Path Exp</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link edu.ustb.sei.mde.morel.IteratorPathExp#getType <em>Type</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.morel.IteratorPathExp#getFirstVar <em>First Var</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.morel.IteratorPathExp#getSecondVar <em>Second Var</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.morel.IteratorPathExp#getBodyExp <em>Body Exp</em>}</li>
 * </ul>
 * </p>
 *
 * @see edu.ustb.sei.mde.morel.MorelPackage#getIteratorPathExp()
 * @model
 * @generated
 */
public interface IteratorPathExp extends LoopPathExp {
	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * The literals are from the enumeration {@link edu.ustb.sei.mde.morel.IteratorType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see edu.ustb.sei.mde.morel.IteratorType
	 * @see #setType(IteratorType)
	 * @see edu.ustb.sei.mde.morel.MorelPackage#getIteratorPathExp_Type()
	 * @model required="true"
	 * @generated
	 */
	IteratorType getType();

	/**
	 * Sets the value of the '{@link edu.ustb.sei.mde.morel.IteratorPathExp#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see edu.ustb.sei.mde.morel.IteratorType
	 * @see #getType()
	 * @generated
	 */
	void setType(IteratorType value);

	/**
	 * Returns the value of the '<em><b>First Var</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>First Var</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>First Var</em>' containment reference.
	 * @see #setFirstVar(Variable)
	 * @see edu.ustb.sei.mde.morel.MorelPackage#getIteratorPathExp_FirstVar()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Variable getFirstVar();

	/**
	 * Sets the value of the '{@link edu.ustb.sei.mde.morel.IteratorPathExp#getFirstVar <em>First Var</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>First Var</em>' containment reference.
	 * @see #getFirstVar()
	 * @generated
	 */
	void setFirstVar(Variable value);

	/**
	 * Returns the value of the '<em><b>Second Var</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Second Var</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Second Var</em>' containment reference.
	 * @see #setSecondVar(Variable)
	 * @see edu.ustb.sei.mde.morel.MorelPackage#getIteratorPathExp_SecondVar()
	 * @model containment="true"
	 * @generated
	 */
	Variable getSecondVar();

	/**
	 * Sets the value of the '{@link edu.ustb.sei.mde.morel.IteratorPathExp#getSecondVar <em>Second Var</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Second Var</em>' containment reference.
	 * @see #getSecondVar()
	 * @generated
	 */
	void setSecondVar(Variable value);

	/**
	 * Returns the value of the '<em><b>Body Exp</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Body Exp</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Body Exp</em>' containment reference.
	 * @see #setBodyExp(Expression)
	 * @see edu.ustb.sei.mde.morel.MorelPackage#getIteratorPathExp_BodyExp()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Expression getBodyExp();

	/**
	 * Sets the value of the '{@link edu.ustb.sei.mde.morel.IteratorPathExp#getBodyExp <em>Body Exp</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Body Exp</em>' containment reference.
	 * @see #getBodyExp()
	 * @generated
	 */
	void setBodyExp(Expression value);

} // IteratorPathExp
