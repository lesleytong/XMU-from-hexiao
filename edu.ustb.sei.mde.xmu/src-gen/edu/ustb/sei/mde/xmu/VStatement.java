/**
 */
package edu.ustb.sei.mde.xmu;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>VStatement</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.ustb.sei.mde.xmu.VStatement#getTag <em>Tag</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.xmu.VStatement#getStatement <em>Statement</em>}</li>
 * </ul>
 *
 * @see edu.ustb.sei.mde.xmu.XmuPackage#getVStatement()
 * @model abstract="true"
 * @generated
 */
public interface VStatement extends EObject {
	/**
	 * Returns the value of the '<em><b>Tag</b></em>' attribute.
	 * The literals are from the enumeration {@link edu.ustb.sei.mde.xmu.VStmtType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Tag</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Tag</em>' attribute.
	 * @see edu.ustb.sei.mde.xmu.VStmtType
	 * @see #setTag(VStmtType)
	 * @see edu.ustb.sei.mde.xmu.XmuPackage#getVStatement_Tag()
	 * @model required="true"
	 * @generated
	 */
	VStmtType getTag();

	/**
	 * Sets the value of the '{@link edu.ustb.sei.mde.xmu.VStatement#getTag <em>Tag</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Tag</em>' attribute.
	 * @see edu.ustb.sei.mde.xmu.VStmtType
	 * @see #getTag()
	 * @generated
	 */
	void setTag(VStmtType value);

	/**
	 * Returns the value of the '<em><b>Statement</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Statement</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Statement</em>' containment reference.
	 * @see #setStatement(Statement)
	 * @see edu.ustb.sei.mde.xmu.XmuPackage#getVStatement_Statement()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Statement getStatement();

	/**
	 * Sets the value of the '{@link edu.ustb.sei.mde.xmu.VStatement#getStatement <em>Statement</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Statement</em>' containment reference.
	 * @see #getStatement()
	 * @generated
	 */
	void setStatement(Statement value);

} // VStatement
