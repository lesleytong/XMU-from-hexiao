/**
 */
package edu.ustb.sei.mde.xmu2core;

import org.eclipse.emf.ecore.EClassifier;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Type Cast Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.ustb.sei.mde.xmu2core.TypeCastExpression#getTargetType <em>Target Type</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.xmu2core.TypeCastExpression#getBody <em>Body</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.xmu2core.TypeCastExpression#getSourceType <em>Source Type</em>}</li>
 * </ul>
 *
 * @see edu.ustb.sei.mde.xmu2core.Xmu2corePackage#getTypeCastExpression()
 * @model
 * @generated
 */
public interface TypeCastExpression extends AtomicExpression {
	/**
	 * Returns the value of the '<em><b>Target Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target Type</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target Type</em>' reference.
	 * @see #setTargetType(EClassifier)
	 * @see edu.ustb.sei.mde.xmu2core.Xmu2corePackage#getTypeCastExpression_TargetType()
	 * @model required="true"
	 * @generated
	 */
	EClassifier getTargetType();

	/**
	 * Sets the value of the '{@link edu.ustb.sei.mde.xmu2core.TypeCastExpression#getTargetType <em>Target Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target Type</em>' reference.
	 * @see #getTargetType()
	 * @generated
	 */
	void setTargetType(EClassifier value);

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
	 * @see edu.ustb.sei.mde.xmu2core.Xmu2corePackage#getTypeCastExpression_Body()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Expression getBody();

	/**
	 * Sets the value of the '{@link edu.ustb.sei.mde.xmu2core.TypeCastExpression#getBody <em>Body</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Body</em>' containment reference.
	 * @see #getBody()
	 * @generated
	 */
	void setBody(Expression value);

	/**
	 * Returns the value of the '<em><b>Source Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source Type</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source Type</em>' reference.
	 * @see #setSourceType(EClassifier)
	 * @see edu.ustb.sei.mde.xmu2core.Xmu2corePackage#getTypeCastExpression_SourceType()
	 * @model required="true"
	 * @generated
	 */
	EClassifier getSourceType();

	/**
	 * Sets the value of the '{@link edu.ustb.sei.mde.xmu2core.TypeCastExpression#getSourceType <em>Source Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source Type</em>' reference.
	 * @see #getSourceType()
	 * @generated
	 */
	void setSourceType(EClassifier value);

} // TypeCastExpression
