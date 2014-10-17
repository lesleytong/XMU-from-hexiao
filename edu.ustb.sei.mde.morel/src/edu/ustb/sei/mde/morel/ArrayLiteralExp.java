/**
 */
package edu.ustb.sei.mde.morel;

import org.eclipse.emf.common.util.EList;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Array Literal Exp</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link edu.ustb.sei.mde.morel.ArrayLiteralExp#getElements <em>Elements</em>}</li>
 * </ul>
 * </p>
 *
 * @see edu.ustb.sei.mde.morel.MorelPackage#getArrayLiteralExp()
 * @model
 * @generated
 */
public interface ArrayLiteralExp extends LiteralExp {

	/**
	 * Returns the value of the '<em><b>Elements</b></em>' containment reference list.
	 * The list contents are of type {@link edu.ustb.sei.mde.morel.Expression}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Elements</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Elements</em>' containment reference list.
	 * @see edu.ustb.sei.mde.morel.MorelPackage#getArrayLiteralExp_Elements()
	 * @model containment="true"
	 * @generated
	 */
	EList<Expression> getElements();
} // ArrayLiteralExp
