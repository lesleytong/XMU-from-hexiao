/**
 */
package edu.ustb.sei.mde.xmu;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Empty Literal</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.ustb.sei.mde.xmu.EmptyLiteral#getValue <em>Value</em>}</li>
 * </ul>
 *
 * @see edu.ustb.sei.mde.xmu.XmuPackage#getEmptyLiteral()
 * @model
 * @generated
 */
public interface EmptyLiteral extends ConstantExpr {
	/**
	 * Returns the value of the '<em><b>Value</b></em>' attribute.
	 * The literals are from the enumeration {@link edu.ustb.sei.mde.xmu.EmptyType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value</em>' attribute.
	 * @see edu.ustb.sei.mde.xmu.EmptyType
	 * @see #setValue(EmptyType)
	 * @see edu.ustb.sei.mde.xmu.XmuPackage#getEmptyLiteral_Value()
	 * @model required="true"
	 * @generated
	 */
	EmptyType getValue();

	/**
	 * Sets the value of the '{@link edu.ustb.sei.mde.xmu.EmptyLiteral#getValue <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' attribute.
	 * @see edu.ustb.sei.mde.xmu.EmptyType
	 * @see #getValue()
	 * @generated
	 */
	void setValue(EmptyType value);

} // EmptyLiteral
