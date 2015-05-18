/**
 */
package edu.ustb.sei.mde.xmu;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>All Instance Expr</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link edu.ustb.sei.mde.xmu.AllInstanceExpr#getRoot <em>Root</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.xmu.AllInstanceExpr#getType <em>Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see edu.ustb.sei.mde.xmu.XmuPackage#getAllInstanceExpr()
 * @model
 * @generated
 */
public interface AllInstanceExpr extends Expr {
	/**
	 * Returns the value of the '<em><b>Root</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Root</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Root</em>' containment reference.
	 * @see #setRoot(StartRoot)
	 * @see edu.ustb.sei.mde.xmu.XmuPackage#getAllInstanceExpr_Root()
	 * @model containment="true" required="true"
	 * @generated
	 */
	StartRoot getRoot();

	/**
	 * Sets the value of the '{@link edu.ustb.sei.mde.xmu.AllInstanceExpr#getRoot <em>Root</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Root</em>' containment reference.
	 * @see #getRoot()
	 * @generated
	 */
	void setRoot(StartRoot value);

	/**
	 * Returns the value of the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' reference.
	 * @see #setType(EClass)
	 * @see edu.ustb.sei.mde.xmu.XmuPackage#getAllInstanceExpr_Type()
	 * @model required="true"
	 * @generated
	 */
	EClass getType();

	/**
	 * Sets the value of the '{@link edu.ustb.sei.mde.xmu.AllInstanceExpr#getType <em>Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' reference.
	 * @see #getType()
	 * @generated
	 */
	void setType(EClass value);

} // AllInstanceExpr
