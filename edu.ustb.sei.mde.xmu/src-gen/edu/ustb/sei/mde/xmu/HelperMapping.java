/**
 */
package edu.ustb.sei.mde.xmu;

import org.eclipse.emf.common.util.EList;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Helper Mapping</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link edu.ustb.sei.mde.xmu.HelperMapping#getLeft <em>Left</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.xmu.HelperMapping#getRight <em>Right</em>}</li>
 * </ul>
 * </p>
 *
 * @see edu.ustb.sei.mde.xmu.XmuPackage#getHelperMapping()
 * @model
 * @generated
 */
public interface HelperMapping extends NamedElement {
	/**
	 * Returns the value of the '<em><b>Left</b></em>' containment reference list.
	 * The list contents are of type {@link edu.ustb.sei.mde.xmu.Expr}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Left</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Left</em>' containment reference list.
	 * @see edu.ustb.sei.mde.xmu.XmuPackage#getHelperMapping_Left()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<Expr> getLeft();

	/**
	 * Returns the value of the '<em><b>Right</b></em>' containment reference list.
	 * The list contents are of type {@link edu.ustb.sei.mde.xmu.Expr}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Right</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Right</em>' containment reference list.
	 * @see edu.ustb.sei.mde.xmu.XmuPackage#getHelperMapping_Right()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<Expr> getRight();

} // HelperMapping
