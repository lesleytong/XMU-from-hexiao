/**
 */
package edu.ustb.sei.mde.morel;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>BX Rewriting Rule</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link edu.ustb.sei.mde.morel.BXRewritingRule#getNac <em>Nac</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.morel.BXRewritingRule#getSource <em>Source</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.morel.BXRewritingRule#getView <em>View</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.morel.BXRewritingRule#getWhen <em>When</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.morel.BXRewritingRule#getUpdate <em>Update</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.morel.BXRewritingRule#getUnmatchSrc <em>Unmatch Src</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.morel.BXRewritingRule#getUnmatchView <em>Unmatch View</em>}</li>
 * </ul>
 * </p>
 *
 * @see edu.ustb.sei.mde.morel.MorelPackage#getBXRewritingRule()
 * @model
 * @generated
 */
public interface BXRewritingRule extends RuleElement {
	/**
	 * Returns the value of the '<em><b>Nac</b></em>' containment reference list.
	 * The list contents are of type {@link edu.ustb.sei.mde.morel.Pattern}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Nac</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Nac</em>' containment reference list.
	 * @see edu.ustb.sei.mde.morel.MorelPackage#getBXRewritingRule_Nac()
	 * @model containment="true"
	 * @generated
	 */
	EList<Pattern> getNac();

	/**
	 * Returns the value of the '<em><b>Source</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source</em>' containment reference.
	 * @see #setSource(Pattern)
	 * @see edu.ustb.sei.mde.morel.MorelPackage#getBXRewritingRule_Source()
	 * @model containment="true"
	 * @generated
	 */
	Pattern getSource();

	/**
	 * Sets the value of the '{@link edu.ustb.sei.mde.morel.BXRewritingRule#getSource <em>Source</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source</em>' containment reference.
	 * @see #getSource()
	 * @generated
	 */
	void setSource(Pattern value);

	/**
	 * Returns the value of the '<em><b>View</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>View</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>View</em>' containment reference.
	 * @see #setView(Pattern)
	 * @see edu.ustb.sei.mde.morel.MorelPackage#getBXRewritingRule_View()
	 * @model containment="true"
	 * @generated
	 */
	Pattern getView();

	/**
	 * Sets the value of the '{@link edu.ustb.sei.mde.morel.BXRewritingRule#getView <em>View</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>View</em>' containment reference.
	 * @see #getView()
	 * @generated
	 */
	void setView(Pattern value);

	/**
	 * Returns the value of the '<em><b>When</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>When</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>When</em>' containment reference.
	 * @see #setWhen(Clause)
	 * @see edu.ustb.sei.mde.morel.MorelPackage#getBXRewritingRule_When()
	 * @model containment="true"
	 * @generated
	 */
	Clause getWhen();

	/**
	 * Sets the value of the '{@link edu.ustb.sei.mde.morel.BXRewritingRule#getWhen <em>When</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>When</em>' containment reference.
	 * @see #getWhen()
	 * @generated
	 */
	void setWhen(Clause value);

	/**
	 * Returns the value of the '<em><b>Update</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Update</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Update</em>' containment reference.
	 * @see #setUpdate(Clause)
	 * @see edu.ustb.sei.mde.morel.MorelPackage#getBXRewritingRule_Update()
	 * @model containment="true"
	 * @generated
	 */
	Clause getUpdate();

	/**
	 * Sets the value of the '{@link edu.ustb.sei.mde.morel.BXRewritingRule#getUpdate <em>Update</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Update</em>' containment reference.
	 * @see #getUpdate()
	 * @generated
	 */
	void setUpdate(Clause value);

	/**
	 * Returns the value of the '<em><b>Unmatch Src</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Unmatch Src</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Unmatch Src</em>' containment reference.
	 * @see #setUnmatchSrc(Pattern)
	 * @see edu.ustb.sei.mde.morel.MorelPackage#getBXRewritingRule_UnmatchSrc()
	 * @model containment="true"
	 * @generated
	 */
	Pattern getUnmatchSrc();

	/**
	 * Sets the value of the '{@link edu.ustb.sei.mde.morel.BXRewritingRule#getUnmatchSrc <em>Unmatch Src</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Unmatch Src</em>' containment reference.
	 * @see #getUnmatchSrc()
	 * @generated
	 */
	void setUnmatchSrc(Pattern value);

	/**
	 * Returns the value of the '<em><b>Unmatch View</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Unmatch View</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Unmatch View</em>' containment reference.
	 * @see #setUnmatchView(Pattern)
	 * @see edu.ustb.sei.mde.morel.MorelPackage#getBXRewritingRule_UnmatchView()
	 * @model containment="true"
	 * @generated
	 */
	Pattern getUnmatchView();

	/**
	 * Sets the value of the '{@link edu.ustb.sei.mde.morel.BXRewritingRule#getUnmatchView <em>Unmatch View</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Unmatch View</em>' containment reference.
	 * @see #getUnmatchView()
	 * @generated
	 */
	void setUnmatchView(Pattern value);

} // BXRewritingRule
