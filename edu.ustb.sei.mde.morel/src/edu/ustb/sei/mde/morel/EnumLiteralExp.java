/**
 */
package edu.ustb.sei.mde.morel;

import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EEnumLiteral;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Enum Literal Exp</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link edu.ustb.sei.mde.morel.EnumLiteralExp#getEnumType <em>Enum Type</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.morel.EnumLiteralExp#getEnumSymbol <em>Enum Symbol</em>}</li>
 * </ul>
 * </p>
 *
 * @see edu.ustb.sei.mde.morel.MorelPackage#getEnumLiteralExp()
 * @model
 * @generated
 */
public interface EnumLiteralExp extends LiteralExp {
	/**
	 * Returns the value of the '<em><b>Enum Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Enum Type</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Enum Type</em>' reference.
	 * @see #setEnumType(EEnum)
	 * @see edu.ustb.sei.mde.morel.MorelPackage#getEnumLiteralExp_EnumType()
	 * @model required="true"
	 * @generated
	 */
	EEnum getEnumType();

	/**
	 * Sets the value of the '{@link edu.ustb.sei.mde.morel.EnumLiteralExp#getEnumType <em>Enum Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Enum Type</em>' reference.
	 * @see #getEnumType()
	 * @generated
	 */
	void setEnumType(EEnum value);

	/**
	 * Returns the value of the '<em><b>Enum Symbol</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Enum Symbol</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Enum Symbol</em>' reference.
	 * @see #setEnumSymbol(EEnumLiteral)
	 * @see edu.ustb.sei.mde.morel.MorelPackage#getEnumLiteralExp_EnumSymbol()
	 * @model required="true"
	 * @generated
	 */
	EEnumLiteral getEnumSymbol();

	/**
	 * Sets the value of the '{@link edu.ustb.sei.mde.morel.EnumLiteralExp#getEnumSymbol <em>Enum Symbol</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Enum Symbol</em>' reference.
	 * @see #getEnumSymbol()
	 * @generated
	 */
	void setEnumSymbol(EEnumLiteral value);

} // EnumLiteralExp
