/**
 */
package edu.ustb.sei.mde.morel;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Bx Typed Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link edu.ustb.sei.mde.morel.BxTypedModel#getAttribute <em>Attribute</em>}</li>
 * </ul>
 * </p>
 *
 * @see edu.ustb.sei.mde.morel.MorelPackage#getBxTypedModel()
 * @model
 * @generated
 */
public interface BxTypedModel extends TypedModel {
	/**
	 * Returns the value of the '<em><b>Attribute</b></em>' attribute.
	 * The literals are from the enumeration {@link edu.ustb.sei.mde.morel.BxModelAttribute}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Attribute</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Attribute</em>' attribute.
	 * @see edu.ustb.sei.mde.morel.BxModelAttribute
	 * @see #setAttribute(BxModelAttribute)
	 * @see edu.ustb.sei.mde.morel.MorelPackage#getBxTypedModel_Attribute()
	 * @model required="true"
	 * @generated
	 */
	BxModelAttribute getAttribute();

	/**
	 * Sets the value of the '{@link edu.ustb.sei.mde.morel.BxTypedModel#getAttribute <em>Attribute</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Attribute</em>' attribute.
	 * @see edu.ustb.sei.mde.morel.BxModelAttribute
	 * @see #getAttribute()
	 * @generated
	 */
	void setAttribute(BxModelAttribute value);

} // BxTypedModel
