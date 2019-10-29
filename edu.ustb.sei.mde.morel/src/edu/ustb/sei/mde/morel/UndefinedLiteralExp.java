/**
 */
package edu.ustb.sei.mde.morel;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Undefined Literal Exp</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link edu.ustb.sei.mde.morel.UndefinedLiteralExp#getValue <em>Value</em>}</li>
 * </ul>
 * </p>
 *
 * @see edu.ustb.sei.mde.morel.MorelPackage#getUndefinedLiteralExp()
 * @model
 * @generated
 */
public interface UndefinedLiteralExp extends LiteralExp {
	/**
	 * Returns the value of the '<em><b>Value</b></em>' attribute.
	 * The literals are from the enumeration {@link edu.ustb.sei.mde.morel.UndefinedLiteral}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value</em>' attribute.
	 * @see edu.ustb.sei.mde.morel.UndefinedLiteral
	 * @see #setValue(UndefinedLiteral)
	 * @see edu.ustb.sei.mde.morel.MorelPackage#getUndefinedLiteralExp_Value()
	 * @model required="true"
	 * @generated
	 */
	UndefinedLiteral getValue();

	/**
	 * Sets the value of the '{@link edu.ustb.sei.mde.morel.UndefinedLiteralExp#getValue <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' attribute.
	 * @see edu.ustb.sei.mde.morel.UndefinedLiteral
	 * @see #getValue()
	 * @generated
	 */
	void setValue(UndefinedLiteral value);

} // UndefinedLiteralExp
