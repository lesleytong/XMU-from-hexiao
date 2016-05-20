/**
 */
package edu.ustb.sei.mde.xmu2core;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Reflective Support</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.ustb.sei.mde.xmu2core.ReflectiveSupport#getReflectiveIdentifier <em>Reflective Identifier</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.xmu2core.ReflectiveSupport#isReflective <em>Reflective</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.xmu2core.ReflectiveSupport#isResolve <em>Resolve</em>}</li>
 * </ul>
 *
 * @see edu.ustb.sei.mde.xmu2core.Xmu2corePackage#getReflectiveSupport()
 * @model abstract="true"
 * @generated
 */
public interface ReflectiveSupport extends EObject {
	/**
	 * Returns the value of the '<em><b>Reflective Identifier</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Reflective Identifier</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Reflective Identifier</em>' containment reference.
	 * @see #setReflectiveIdentifier(Expression)
	 * @see edu.ustb.sei.mde.xmu2core.Xmu2corePackage#getReflectiveSupport_ReflectiveIdentifier()
	 * @model containment="true"
	 * @generated
	 */
	Expression getReflectiveIdentifier();

	/**
	 * Sets the value of the '{@link edu.ustb.sei.mde.xmu2core.ReflectiveSupport#getReflectiveIdentifier <em>Reflective Identifier</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Reflective Identifier</em>' containment reference.
	 * @see #getReflectiveIdentifier()
	 * @generated
	 */
	void setReflectiveIdentifier(Expression value);

	/**
	 * Returns the value of the '<em><b>Reflective</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Reflective</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Reflective</em>' attribute.
	 * @see #setReflective(boolean)
	 * @see edu.ustb.sei.mde.xmu2core.Xmu2corePackage#getReflectiveSupport_Reflective()
	 * @model default="false"
	 * @generated
	 */
	boolean isReflective();

	/**
	 * Sets the value of the '{@link edu.ustb.sei.mde.xmu2core.ReflectiveSupport#isReflective <em>Reflective</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Reflective</em>' attribute.
	 * @see #isReflective()
	 * @generated
	 */
	void setReflective(boolean value);

	/**
	 * Returns the value of the '<em><b>Resolve</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Resolve</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Resolve</em>' attribute.
	 * @see #setResolve(boolean)
	 * @see edu.ustb.sei.mde.xmu2core.Xmu2corePackage#getReflectiveSupport_Resolve()
	 * @model required="true"
	 * @generated
	 */
	boolean isResolve();

	/**
	 * Sets the value of the '{@link edu.ustb.sei.mde.xmu2core.ReflectiveSupport#isResolve <em>Resolve</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Resolve</em>' attribute.
	 * @see #isResolve()
	 * @generated
	 */
	void setResolve(boolean value);

} // ReflectiveSupport
