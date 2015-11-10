/**
 */
package edu.ustb.sei.mde.xmu;

import org.eclipse.emf.ecore.EObject;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Object Path Expr</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.ustb.sei.mde.xmu.ObjectPathExpr#getObject <em>Object</em>}</li>
 * </ul>
 *
 * @see edu.ustb.sei.mde.xmu.XmuPackage#getObjectPathExpr()
 * @model
 * @generated
 */
public interface ObjectPathExpr extends Expr {
	/**
	 * Returns the value of the '<em><b>Object</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Object</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Object</em>' reference.
	 * @see #setObject(EObject)
	 * @see edu.ustb.sei.mde.xmu.XmuPackage#getObjectPathExpr_Object()
	 * @model required="true"
	 * @generated
	 */
	EObject getObject();

	/**
	 * Sets the value of the '{@link edu.ustb.sei.mde.xmu.ObjectPathExpr#getObject <em>Object</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Object</em>' reference.
	 * @see #getObject()
	 * @generated
	 */
	void setObject(EObject value);

} // ObjectPathExpr
