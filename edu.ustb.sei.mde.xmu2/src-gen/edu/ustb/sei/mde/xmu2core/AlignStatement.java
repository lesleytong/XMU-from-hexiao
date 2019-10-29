/**
 */
package edu.ustb.sei.mde.xmu2core;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Align Statement</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.ustb.sei.mde.xmu2core.AlignStatement#getSource <em>Source</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.xmu2core.AlignStatement#getView <em>View</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.xmu2core.AlignStatement#getMatch <em>Match</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.xmu2core.AlignStatement#getUnmatchv <em>Unmatchv</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.xmu2core.AlignStatement#getUnmatchs <em>Unmatchs</em>}</li>
 * </ul>
 *
 * @see edu.ustb.sei.mde.xmu2core.Xmu2corePackage#getAlignStatement()
 * @model
 * @generated
 */
public interface AlignStatement extends Statement {
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
	 * @see edu.ustb.sei.mde.xmu2core.Xmu2corePackage#getAlignStatement_Source()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Pattern getSource();

	/**
	 * Sets the value of the '{@link edu.ustb.sei.mde.xmu2core.AlignStatement#getSource <em>Source</em>}' containment reference.
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
	 * @see edu.ustb.sei.mde.xmu2core.Xmu2corePackage#getAlignStatement_View()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Pattern getView();

	/**
	 * Sets the value of the '{@link edu.ustb.sei.mde.xmu2core.AlignStatement#getView <em>View</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>View</em>' containment reference.
	 * @see #getView()
	 * @generated
	 */
	void setView(Pattern value);

	/**
	 * Returns the value of the '<em><b>Match</b></em>' containment reference list.
	 * The list contents are of type {@link edu.ustb.sei.mde.xmu2core.Statement}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Match</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Match</em>' containment reference list.
	 * @see edu.ustb.sei.mde.xmu2core.Xmu2corePackage#getAlignStatement_Match()
	 * @model containment="true"
	 * @generated
	 */
	EList<Statement> getMatch();

	/**
	 * Returns the value of the '<em><b>Unmatchv</b></em>' containment reference list.
	 * The list contents are of type {@link edu.ustb.sei.mde.xmu2core.Statement}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Unmatchv</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Unmatchv</em>' containment reference list.
	 * @see edu.ustb.sei.mde.xmu2core.Xmu2corePackage#getAlignStatement_Unmatchv()
	 * @model containment="true"
	 * @generated
	 */
	EList<Statement> getUnmatchv();

	/**
	 * Returns the value of the '<em><b>Unmatchs</b></em>' containment reference list.
	 * The list contents are of type {@link edu.ustb.sei.mde.xmu2core.Statement}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Unmatchs</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Unmatchs</em>' containment reference list.
	 * @see edu.ustb.sei.mde.xmu2core.Xmu2corePackage#getAlignStatement_Unmatchs()
	 * @model containment="true"
	 * @generated
	 */
	EList<Statement> getUnmatchs();

} // AlignStatement
