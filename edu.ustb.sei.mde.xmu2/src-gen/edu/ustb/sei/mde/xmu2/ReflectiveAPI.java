/**
 */
package edu.ustb.sei.mde.xmu2;

import edu.ustb.sei.mde.xmu2.expression.Expression;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Reflective API</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.ustb.sei.mde.xmu2.ReflectiveAPI#getReflectiveIdentifier <em>Reflective Identifier</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.xmu2.ReflectiveAPI#isResolve <em>Resolve</em>}</li>
 * </ul>
 *
 * @see edu.ustb.sei.mde.xmu2.Xmu2Package#getReflectiveAPI()
 * @model abstract="true"
 * @generated
 */
public interface ReflectiveAPI extends EObject {
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
	 * @see edu.ustb.sei.mde.xmu2.Xmu2Package#getReflectiveAPI_ReflectiveIdentifier()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Expression getReflectiveIdentifier();

	/**
	 * Sets the value of the '{@link edu.ustb.sei.mde.xmu2.ReflectiveAPI#getReflectiveIdentifier <em>Reflective Identifier</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Reflective Identifier</em>' containment reference.
	 * @see #getReflectiveIdentifier()
	 * @generated
	 */
	void setReflectiveIdentifier(Expression value);

	/**
	 * Returns the value of the '<em><b>Resolve</b></em>' attribute.
	 * The default value is <code>"true"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Resolve</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Resolve</em>' attribute.
	 * @see #setResolve(boolean)
	 * @see edu.ustb.sei.mde.xmu2.Xmu2Package#getReflectiveAPI_Resolve()
	 * @model default="true" required="true"
	 * @generated
	 */
	boolean isResolve();

	/**
	 * Sets the value of the '{@link edu.ustb.sei.mde.xmu2.ReflectiveAPI#isResolve <em>Resolve</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Resolve</em>' attribute.
	 * @see #isResolve()
	 * @generated
	 */
	void setResolve(boolean value);

} // ReflectiveAPI
