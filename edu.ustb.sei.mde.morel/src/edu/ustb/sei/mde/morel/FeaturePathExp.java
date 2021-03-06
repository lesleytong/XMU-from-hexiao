/**
 */
package edu.ustb.sei.mde.morel;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Feature Path Exp</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link edu.ustb.sei.mde.morel.FeaturePathExp#getFeature <em>Feature</em>}</li>
 * </ul>
 * </p>
 *
 * @see edu.ustb.sei.mde.morel.MorelPackage#getFeaturePathExp()
 * @model
 * @generated
 */
public interface FeaturePathExp extends CallPathExp {
	/**
	 * Returns the value of the '<em><b>Feature</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Feature</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Feature</em>' attribute.
	 * @see #setFeature(String)
	 * @see edu.ustb.sei.mde.morel.MorelPackage#getFeaturePathExp_Feature()
	 * @model required="true"
	 * @generated
	 */
	String getFeature();

	/**
	 * Sets the value of the '{@link edu.ustb.sei.mde.morel.FeaturePathExp#getFeature <em>Feature</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Feature</em>' attribute.
	 * @see #getFeature()
	 * @generated
	 */
	void setFeature(String value);

} // FeaturePathExp
