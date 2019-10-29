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
 * </p>
 * <ul>
 *   <li>{@link edu.ustb.sei.mde.xmu.HelperMapping#getEntries <em>Entries</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.xmu.HelperMapping#isDefaultEqual <em>Default Equal</em>}</li>
 * </ul>
 *
 * @see edu.ustb.sei.mde.xmu.XmuPackage#getHelperMapping()
 * @model
 * @generated
 */
public interface HelperMapping extends NamedElement {
	/**
	 * Returns the value of the '<em><b>Entries</b></em>' containment reference list.
	 * The list contents are of type {@link edu.ustb.sei.mde.xmu.HelperMappingEntry}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Entries</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Entries</em>' containment reference list.
	 * @see edu.ustb.sei.mde.xmu.XmuPackage#getHelperMapping_Entries()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<HelperMappingEntry> getEntries();

	/**
	 * Returns the value of the '<em><b>Default Equal</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Default Equal</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Default Equal</em>' attribute.
	 * @see #setDefaultEqual(boolean)
	 * @see edu.ustb.sei.mde.xmu.XmuPackage#getHelperMapping_DefaultEqual()
	 * @model default="false"
	 * @generated
	 */
	boolean isDefaultEqual();

	/**
	 * Sets the value of the '{@link edu.ustb.sei.mde.xmu.HelperMapping#isDefaultEqual <em>Default Equal</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Default Equal</em>' attribute.
	 * @see #isDefaultEqual()
	 * @generated
	 */
	void setDefaultEqual(boolean value);

} // HelperMapping
