/**
 */
package edu.ustb.sei.mde.morel;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Bx Morel Rule</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link edu.ustb.sei.mde.morel.BxMorelRule#getSource <em>Source</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.morel.BxMorelRule#getView <em>View</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.morel.BxMorelRule#getWhen <em>When</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.morel.BxMorelRule#getMatch <em>Match</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.morel.BxMorelRule#getUnmatchSrc <em>Unmatch Src</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.morel.BxMorelRule#getUnmatchView <em>Unmatch View</em>}</li>
 * </ul>
 * </p>
 *
 * @see edu.ustb.sei.mde.morel.MorelPackage#getBxMorelRule()
 * @model
 * @generated
 */
public interface BxMorelRule extends RuleElement {
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
	 * @see edu.ustb.sei.mde.morel.MorelPackage#getBxMorelRule_Source()
	 * @model containment="true"
	 * @generated
	 */
	Pattern getSource();

	/**
	 * Sets the value of the '{@link edu.ustb.sei.mde.morel.BxMorelRule#getSource <em>Source</em>}' containment reference.
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
	 * @see edu.ustb.sei.mde.morel.MorelPackage#getBxMorelRule_View()
	 * @model containment="true"
	 * @generated
	 */
	Pattern getView();

	/**
	 * Sets the value of the '{@link edu.ustb.sei.mde.morel.BxMorelRule#getView <em>View</em>}' containment reference.
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
	 * @see edu.ustb.sei.mde.morel.MorelPackage#getBxMorelRule_When()
	 * @model containment="true"
	 * @generated
	 */
	Clause getWhen();

	/**
	 * Sets the value of the '{@link edu.ustb.sei.mde.morel.BxMorelRule#getWhen <em>When</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>When</em>' containment reference.
	 * @see #getWhen()
	 * @generated
	 */
	void setWhen(Clause value);

	/**
	 * Returns the value of the '<em><b>Match</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Match</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Match</em>' containment reference.
	 * @see #setMatch(Action)
	 * @see edu.ustb.sei.mde.morel.MorelPackage#getBxMorelRule_Match()
	 * @model containment="true"
	 * @generated
	 */
	Action getMatch();

	/**
	 * Sets the value of the '{@link edu.ustb.sei.mde.morel.BxMorelRule#getMatch <em>Match</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Match</em>' containment reference.
	 * @see #getMatch()
	 * @generated
	 */
	void setMatch(Action value);

	/**
	 * Returns the value of the '<em><b>Unmatch Src</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Unmatch Src</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Unmatch Src</em>' containment reference.
	 * @see #setUnmatchSrc(Action)
	 * @see edu.ustb.sei.mde.morel.MorelPackage#getBxMorelRule_UnmatchSrc()
	 * @model containment="true"
	 * @generated
	 */
	Action getUnmatchSrc();

	/**
	 * Sets the value of the '{@link edu.ustb.sei.mde.morel.BxMorelRule#getUnmatchSrc <em>Unmatch Src</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Unmatch Src</em>' containment reference.
	 * @see #getUnmatchSrc()
	 * @generated
	 */
	void setUnmatchSrc(Action value);

	/**
	 * Returns the value of the '<em><b>Unmatch View</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Unmatch View</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Unmatch View</em>' containment reference.
	 * @see #setUnmatchView(Action)
	 * @see edu.ustb.sei.mde.morel.MorelPackage#getBxMorelRule_UnmatchView()
	 * @model containment="true"
	 * @generated
	 */
	Action getUnmatchView();

	/**
	 * Sets the value of the '{@link edu.ustb.sei.mde.morel.BxMorelRule#getUnmatchView <em>Unmatch View</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Unmatch View</em>' containment reference.
	 * @see #getUnmatchView()
	 * @generated
	 */
	void setUnmatchView(Action value);

} // BxMorelRule
