/**
 */
package edu.ustb.sei.mde.bxmorel.bxmorel;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Entity</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link edu.ustb.sei.mde.bxmorel.bxmorel.Entity#isAbstract <em>Abstract</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.bxmorel.bxmorel.Entity#getFeatures <em>Features</em>}</li>
 * </ul>
 * </p>
 *
 * @see edu.ustb.sei.mde.bxmorel.bxmorel.BxmorelPackage#getEntity()
 * @model
 * @generated
 */
public interface Entity extends Type {
	/**
	 * Returns the value of the '<em><b>Abstract</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Abstract</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Abstract</em>' attribute.
	 * @see #setAbstract(boolean)
	 * @see edu.ustb.sei.mde.bxmorel.bxmorel.BxmorelPackage#getEntity_Abstract()
	 * @model required="true"
	 * @generated
	 */
	boolean isAbstract();

	/**
	 * Sets the value of the '{@link edu.ustb.sei.mde.bxmorel.bxmorel.Entity#isAbstract <em>Abstract</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Abstract</em>' attribute.
	 * @see #isAbstract()
	 * @generated
	 */
	void setAbstract(boolean value);

	/**
	 * Returns the value of the '<em><b>Features</b></em>' containment reference list.
	 * The list contents are of type {@link edu.ustb.sei.mde.bxmorel.bxmorel.Feature}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Features</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Features</em>' containment reference list.
	 * @see edu.ustb.sei.mde.bxmorel.bxmorel.BxmorelPackage#getEntity_Features()
	 * @model containment="true"
	 * @generated
	 */
	EList<Feature> getFeatures();

} // Entity
