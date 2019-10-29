/**
 */
package edu.ustb.sei.mde.morel;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Collection Literal Exp</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link edu.ustb.sei.mde.morel.CollectionLiteralExp#getType <em>Type</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.morel.CollectionLiteralExp#getLiterals <em>Literals</em>}</li>
 * </ul>
 * </p>
 *
 * @see edu.ustb.sei.mde.morel.MorelPackage#getCollectionLiteralExp()
 * @model
 * @generated
 */
public interface CollectionLiteralExp extends LiteralExp {
	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see #setType(String)
	 * @see edu.ustb.sei.mde.morel.MorelPackage#getCollectionLiteralExp_Type()
	 * @model required="true"
	 * @generated
	 */
	String getType();

	/**
	 * Sets the value of the '{@link edu.ustb.sei.mde.morel.CollectionLiteralExp#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see #getType()
	 * @generated
	 */
	void setType(String value);

	/**
	 * Returns the value of the '<em><b>Literals</b></em>' containment reference list.
	 * The list contents are of type {@link edu.ustb.sei.mde.morel.Expression}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Literals</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Literals</em>' containment reference list.
	 * @see edu.ustb.sei.mde.morel.MorelPackage#getCollectionLiteralExp_Literals()
	 * @model containment="true"
	 * @generated
	 */
	EList<Expression> getLiterals();

} // CollectionLiteralExp
