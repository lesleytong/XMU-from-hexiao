/**
 */
package edu.ustb.sei.mde.morel;

import org.eclipse.emf.ecore.EClassifier;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Type Literal Exp</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link edu.ustb.sei.mde.morel.TypeLiteralExp#getValue <em>Value</em>}</li>
 * </ul>
 * </p>
 *
 * @see edu.ustb.sei.mde.morel.MorelPackage#getTypeLiteralExp()
 * @model
 * @generated
 */
public interface TypeLiteralExp extends LiteralExp {
	/**
	 * Returns the value of the '<em><b>Value</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value</em>' reference.
	 * @see #setValue(EClassifier)
	 * @see edu.ustb.sei.mde.morel.MorelPackage#getTypeLiteralExp_Value()
	 * @model required="true"
	 * @generated
	 */
	EClassifier getValue();

	/**
	 * Sets the value of the '{@link edu.ustb.sei.mde.morel.TypeLiteralExp#getValue <em>Value</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' reference.
	 * @see #getValue()
	 * @generated
	 */
	void setValue(EClassifier value);

} // TypeLiteralExp
