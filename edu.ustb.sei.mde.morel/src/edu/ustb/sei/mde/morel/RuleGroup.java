/**
 */
package edu.ustb.sei.mde.morel;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Rule Group</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link edu.ustb.sei.mde.morel.RuleGroup#getRules <em>Rules</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.morel.RuleGroup#getScope <em>Scope</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.morel.RuleGroup#getScopeSize <em>Scope Size</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.morel.RuleGroup#getOrder <em>Order</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.morel.RuleGroup#getIteration <em>Iteration</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.morel.RuleGroup#getMaxIteration <em>Max Iteration</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.morel.RuleGroup#getRepetition <em>Repetition</em>}</li>
 * </ul>
 * </p>
 *
 * @see edu.ustb.sei.mde.morel.MorelPackage#getRuleGroup()
 * @model
 * @generated
 */
public interface RuleGroup extends RuleElement {
	/**
	 * Returns the value of the '<em><b>Rules</b></em>' containment reference list.
	 * The list contents are of type {@link edu.ustb.sei.mde.morel.Rule}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Rules</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Rules</em>' containment reference list.
	 * @see edu.ustb.sei.mde.morel.MorelPackage#getRuleGroup_Rules()
	 * @model containment="true"
	 * @generated
	 */
	EList<Rule> getRules();

	/**
	 * Returns the value of the '<em><b>Scope</b></em>' attribute.
	 * The default value is <code>"all"</code>.
	 * The literals are from the enumeration {@link edu.ustb.sei.mde.morel.ScopeType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Scope</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Scope</em>' attribute.
	 * @see edu.ustb.sei.mde.morel.ScopeType
	 * @see #setScope(ScopeType)
	 * @see edu.ustb.sei.mde.morel.MorelPackage#getRuleGroup_Scope()
	 * @model default="all"
	 * @generated
	 */
	ScopeType getScope();

	/**
	 * Sets the value of the '{@link edu.ustb.sei.mde.morel.RuleGroup#getScope <em>Scope</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Scope</em>' attribute.
	 * @see edu.ustb.sei.mde.morel.ScopeType
	 * @see #getScope()
	 * @generated
	 */
	void setScope(ScopeType value);

	/**
	 * Returns the value of the '<em><b>Scope Size</b></em>' attribute.
	 * The default value is <code>"0"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Scope Size</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Scope Size</em>' attribute.
	 * @see #setScopeSize(int)
	 * @see edu.ustb.sei.mde.morel.MorelPackage#getRuleGroup_ScopeSize()
	 * @model default="0"
	 * @generated
	 */
	int getScopeSize();

	/**
	 * Sets the value of the '{@link edu.ustb.sei.mde.morel.RuleGroup#getScopeSize <em>Scope Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Scope Size</em>' attribute.
	 * @see #getScopeSize()
	 * @generated
	 */
	void setScopeSize(int value);

	/**
	 * Returns the value of the '<em><b>Order</b></em>' attribute.
	 * The default value is <code>"default"</code>.
	 * The literals are from the enumeration {@link edu.ustb.sei.mde.morel.OrderType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Order</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Order</em>' attribute.
	 * @see edu.ustb.sei.mde.morel.OrderType
	 * @see #setOrder(OrderType)
	 * @see edu.ustb.sei.mde.morel.MorelPackage#getRuleGroup_Order()
	 * @model default="default"
	 * @generated
	 */
	OrderType getOrder();

	/**
	 * Sets the value of the '{@link edu.ustb.sei.mde.morel.RuleGroup#getOrder <em>Order</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Order</em>' attribute.
	 * @see edu.ustb.sei.mde.morel.OrderType
	 * @see #getOrder()
	 * @generated
	 */
	void setOrder(OrderType value);

	/**
	 * Returns the value of the '<em><b>Iteration</b></em>' attribute.
	 * The default value is <code>"default"</code>.
	 * The literals are from the enumeration {@link edu.ustb.sei.mde.morel.IterationType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Iteration</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Iteration</em>' attribute.
	 * @see edu.ustb.sei.mde.morel.IterationType
	 * @see #setIteration(IterationType)
	 * @see edu.ustb.sei.mde.morel.MorelPackage#getRuleGroup_Iteration()
	 * @model default="default"
	 * @generated
	 */
	IterationType getIteration();

	/**
	 * Sets the value of the '{@link edu.ustb.sei.mde.morel.RuleGroup#getIteration <em>Iteration</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Iteration</em>' attribute.
	 * @see edu.ustb.sei.mde.morel.IterationType
	 * @see #getIteration()
	 * @generated
	 */
	void setIteration(IterationType value);

	/**
	 * Returns the value of the '<em><b>Max Iteration</b></em>' attribute.
	 * The default value is <code>"0"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Max Iteration</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Max Iteration</em>' attribute.
	 * @see #setMaxIteration(int)
	 * @see edu.ustb.sei.mde.morel.MorelPackage#getRuleGroup_MaxIteration()
	 * @model default="0"
	 * @generated
	 */
	int getMaxIteration();

	/**
	 * Sets the value of the '{@link edu.ustb.sei.mde.morel.RuleGroup#getMaxIteration <em>Max Iteration</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Max Iteration</em>' attribute.
	 * @see #getMaxIteration()
	 * @generated
	 */
	void setMaxIteration(int value);

	/**
	 * Returns the value of the '<em><b>Repetition</b></em>' attribute.
	 * The default value is <code>"allMatches"</code>.
	 * The literals are from the enumeration {@link edu.ustb.sei.mde.morel.RepetitionType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Repetition</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Repetition</em>' attribute.
	 * @see edu.ustb.sei.mde.morel.RepetitionType
	 * @see #setRepetition(RepetitionType)
	 * @see edu.ustb.sei.mde.morel.MorelPackage#getRuleGroup_Repetition()
	 * @model default="allMatches"
	 * @generated
	 */
	RepetitionType getRepetition();

	/**
	 * Sets the value of the '{@link edu.ustb.sei.mde.morel.RuleGroup#getRepetition <em>Repetition</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Repetition</em>' attribute.
	 * @see edu.ustb.sei.mde.morel.RepetitionType
	 * @see #getRepetition()
	 * @generated
	 */
	void setRepetition(RepetitionType value);

} // RuleGroup
