/**
 */
package edu.ustb.sei.mde.xmu2;

import edu.ustb.sei.mde.xmu2common.DomainElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Entry Data</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.ustb.sei.mde.xmu2.EntryData#getIndex <em>Index</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.xmu2.EntryData#getFragment <em>Fragment</em>}</li>
 * </ul>
 *
 * @see edu.ustb.sei.mde.xmu2.Xmu2Package#getEntryData()
 * @model
 * @generated
 */
public interface EntryData extends DomainElement {
	/**
	 * Returns the value of the '<em><b>Index</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Index</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Index</em>' attribute.
	 * @see #setIndex(int)
	 * @see edu.ustb.sei.mde.xmu2.Xmu2Package#getEntryData_Index()
	 * @model required="true"
	 * @generated
	 */
	int getIndex();

	/**
	 * Sets the value of the '{@link edu.ustb.sei.mde.xmu2.EntryData#getIndex <em>Index</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Index</em>' attribute.
	 * @see #getIndex()
	 * @generated
	 */
	void setIndex(int value);

	/**
	 * Returns the value of the '<em><b>Fragment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Fragment</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Fragment</em>' attribute.
	 * @see #setFragment(String)
	 * @see edu.ustb.sei.mde.xmu2.Xmu2Package#getEntryData_Fragment()
	 * @model
	 * @generated
	 */
	String getFragment();

	/**
	 * Sets the value of the '{@link edu.ustb.sei.mde.xmu2.EntryData#getFragment <em>Fragment</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Fragment</em>' attribute.
	 * @see #getFragment()
	 * @generated
	 */
	void setFragment(String value);

} // EntryData
