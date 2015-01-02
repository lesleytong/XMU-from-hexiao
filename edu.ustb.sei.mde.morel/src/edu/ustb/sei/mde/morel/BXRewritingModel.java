/**
 */
package edu.ustb.sei.mde.morel;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>BX Rewriting Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link edu.ustb.sei.mde.morel.BXRewritingModel#getRules <em>Rules</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.morel.BXRewritingModel#getMode <em>Mode</em>}</li>
 * </ul>
 * </p>
 *
 * @see edu.ustb.sei.mde.morel.MorelPackage#getBXRewritingModel()
 * @model
 * @generated
 */
public interface BXRewritingModel extends Unit, NamedElement {
	/**
	 * Returns the value of the '<em><b>Rules</b></em>' containment reference list.
	 * The list contents are of type {@link edu.ustb.sei.mde.morel.BXRewritingRule}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Rules</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Rules</em>' containment reference list.
	 * @see edu.ustb.sei.mde.morel.MorelPackage#getBXRewritingModel_Rules()
	 * @model containment="true"
	 * @generated
	 */
	EList<BXRewritingRule> getRules();

	/**
	 * Returns the value of the '<em><b>Mode</b></em>' attribute.
	 * The literals are from the enumeration {@link edu.ustb.sei.mde.morel.BXMode}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Mode</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mode</em>' attribute.
	 * @see edu.ustb.sei.mde.morel.BXMode
	 * @see #setMode(BXMode)
	 * @see edu.ustb.sei.mde.morel.MorelPackage#getBXRewritingModel_Mode()
	 * @model required="true"
	 * @generated
	 */
	BXMode getMode();

	/**
	 * Sets the value of the '{@link edu.ustb.sei.mde.morel.BXRewritingModel#getMode <em>Mode</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Mode</em>' attribute.
	 * @see edu.ustb.sei.mde.morel.BXMode
	 * @see #getMode()
	 * @generated
	 */
	void setMode(BXMode value);

} // BXRewritingModel
