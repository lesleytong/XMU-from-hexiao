/**
 */
package edu.ustb.sei.mde.xmu;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Tagged Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link edu.ustb.sei.mde.xmu.TaggedElement#getTag <em>Tag</em>}</li>
 * </ul>
 * </p>
 *
 * @see edu.ustb.sei.mde.xmu.XmuPackage#getTaggedElement()
 * @model abstract="true"
 * @generated
 */
public interface TaggedElement extends EObject {
	/**
	 * Returns the value of the '<em><b>Tag</b></em>' attribute.
	 * The literals are from the enumeration {@link edu.ustb.sei.mde.xmu.VariableFlag}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Tag</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Tag</em>' attribute.
	 * @see edu.ustb.sei.mde.xmu.VariableFlag
	 * @see #setTag(VariableFlag)
	 * @see edu.ustb.sei.mde.xmu.XmuPackage#getTaggedElement_Tag()
	 * @model required="true"
	 * @generated
	 */
	VariableFlag getTag();

	/**
	 * Sets the value of the '{@link edu.ustb.sei.mde.xmu.TaggedElement#getTag <em>Tag</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Tag</em>' attribute.
	 * @see edu.ustb.sei.mde.xmu.VariableFlag
	 * @see #getTag()
	 * @generated
	 */
	void setTag(VariableFlag value);

} // TaggedElement
