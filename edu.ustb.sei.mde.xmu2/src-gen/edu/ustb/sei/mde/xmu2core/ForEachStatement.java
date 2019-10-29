/**
 */
package edu.ustb.sei.mde.xmu2core;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>For Each Statement</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.ustb.sei.mde.xmu2core.ForEachStatement#getPattern <em>Pattern</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.xmu2core.ForEachStatement#getAction <em>Action</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.xmu2core.ForEachStatement#isDerived <em>Derived</em>}</li>
 * </ul>
 *
 * @see edu.ustb.sei.mde.xmu2core.Xmu2corePackage#getForEachStatement()
 * @model
 * @generated
 */
public interface ForEachStatement extends Statement {
	/**
	 * Returns the value of the '<em><b>Pattern</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Pattern</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Pattern</em>' containment reference.
	 * @see #setPattern(Pattern)
	 * @see edu.ustb.sei.mde.xmu2core.Xmu2corePackage#getForEachStatement_Pattern()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Pattern getPattern();

	/**
	 * Sets the value of the '{@link edu.ustb.sei.mde.xmu2core.ForEachStatement#getPattern <em>Pattern</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Pattern</em>' containment reference.
	 * @see #getPattern()
	 * @generated
	 */
	void setPattern(Pattern value);

	/**
	 * Returns the value of the '<em><b>Action</b></em>' containment reference list.
	 * The list contents are of type {@link edu.ustb.sei.mde.xmu2core.Statement}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Action</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Action</em>' containment reference list.
	 * @see edu.ustb.sei.mde.xmu2core.Xmu2corePackage#getForEachStatement_Action()
	 * @model containment="true"
	 * @generated
	 */
	EList<Statement> getAction();

	/**
	 * Returns the value of the '<em><b>Derived</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Derived</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Derived</em>' attribute.
	 * @see #setDerived(boolean)
	 * @see edu.ustb.sei.mde.xmu2core.Xmu2corePackage#getForEachStatement_Derived()
	 * @model default="false" required="true"
	 * @generated
	 */
	boolean isDerived();

	/**
	 * Sets the value of the '{@link edu.ustb.sei.mde.xmu2core.ForEachStatement#isDerived <em>Derived</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Derived</em>' attribute.
	 * @see #isDerived()
	 * @generated
	 */
	void setDerived(boolean value);

} // ForEachStatement
