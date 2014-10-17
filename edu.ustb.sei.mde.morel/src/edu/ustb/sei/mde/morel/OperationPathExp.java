/**
 */
package edu.ustb.sei.mde.morel;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Operation Path Exp</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link edu.ustb.sei.mde.morel.OperationPathExp#getSeparator <em>Separator</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.morel.OperationPathExp#getOperation <em>Operation</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.morel.OperationPathExp#getParameters <em>Parameters</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.morel.OperationPathExp#getMode <em>Mode</em>}</li>
 * </ul>
 * </p>
 *
 * @see edu.ustb.sei.mde.morel.MorelPackage#getOperationPathExp()
 * @model
 * @generated
 */
public interface OperationPathExp extends CallPathExp {
	/**
	 * Returns the value of the '<em><b>Separator</b></em>' attribute.
	 * The literals are from the enumeration {@link edu.ustb.sei.mde.morel.OperationSeparator}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Separator</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Separator</em>' attribute.
	 * @see edu.ustb.sei.mde.morel.OperationSeparator
	 * @see #setSeparator(OperationSeparator)
	 * @see edu.ustb.sei.mde.morel.MorelPackage#getOperationPathExp_Separator()
	 * @model required="true"
	 * @generated
	 */
	OperationSeparator getSeparator();

	/**
	 * Sets the value of the '{@link edu.ustb.sei.mde.morel.OperationPathExp#getSeparator <em>Separator</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Separator</em>' attribute.
	 * @see edu.ustb.sei.mde.morel.OperationSeparator
	 * @see #getSeparator()
	 * @generated
	 */
	void setSeparator(OperationSeparator value);

	/**
	 * Returns the value of the '<em><b>Operation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Operation</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Operation</em>' attribute.
	 * @see #setOperation(String)
	 * @see edu.ustb.sei.mde.morel.MorelPackage#getOperationPathExp_Operation()
	 * @model required="true"
	 * @generated
	 */
	String getOperation();

	/**
	 * Sets the value of the '{@link edu.ustb.sei.mde.morel.OperationPathExp#getOperation <em>Operation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Operation</em>' attribute.
	 * @see #getOperation()
	 * @generated
	 */
	void setOperation(String value);

	/**
	 * Returns the value of the '<em><b>Parameters</b></em>' containment reference list.
	 * The list contents are of type {@link edu.ustb.sei.mde.morel.Expression}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parameters</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parameters</em>' containment reference list.
	 * @see edu.ustb.sei.mde.morel.MorelPackage#getOperationPathExp_Parameters()
	 * @model containment="true"
	 * @generated
	 */
	EList<Expression> getParameters();

	/**
	 * Returns the value of the '<em><b>Mode</b></em>' attribute.
	 * The default value is <code>"default"</code>.
	 * The literals are from the enumeration {@link edu.ustb.sei.mde.morel.ExecutionMode}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Mode</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mode</em>' attribute.
	 * @see edu.ustb.sei.mde.morel.ExecutionMode
	 * @see #setMode(ExecutionMode)
	 * @see edu.ustb.sei.mde.morel.MorelPackage#getOperationPathExp_Mode()
	 * @model default="default"
	 * @generated
	 */
	ExecutionMode getMode();

	/**
	 * Sets the value of the '{@link edu.ustb.sei.mde.morel.OperationPathExp#getMode <em>Mode</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Mode</em>' attribute.
	 * @see edu.ustb.sei.mde.morel.ExecutionMode
	 * @see #getMode()
	 * @generated
	 */
	void setMode(ExecutionMode value);

} // OperationPathExp
