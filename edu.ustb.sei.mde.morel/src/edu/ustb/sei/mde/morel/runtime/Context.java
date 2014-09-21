/**
 */
package edu.ustb.sei.mde.morel.runtime;

import edu.ustb.sei.mde.morel.Variable;

import java.util.Map;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Context</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link edu.ustb.sei.mde.morel.runtime.Context#getBindingMap <em>Binding Map</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.morel.runtime.Context#getHost <em>Host</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.morel.runtime.Context#getParentContext <em>Parent Context</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.morel.runtime.Context#getParentScope <em>Parent Scope</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.morel.runtime.Context#getEnviroment <em>Enviroment</em>}</li>
 * </ul>
 * </p>
 *
 * @see edu.ustb.sei.mde.morel.runtime.RuntimePackage#getContext()
 * @model
 * @generated
 */
public interface Context extends EObject {
	/**
	 * Returns the value of the '<em><b>Binding Map</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Binding Map</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Binding Map</em>' attribute.
	 * @see #setBindingMap(Map)
	 * @see edu.ustb.sei.mde.morel.runtime.RuntimePackage#getContext_BindingMap()
	 * @model transient="true"
	 * @generated
	 */
	Map<Variable, Object> getBindingMap();

	/**
	 * Sets the value of the '{@link edu.ustb.sei.mde.morel.runtime.Context#getBindingMap <em>Binding Map</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Binding Map</em>' attribute.
	 * @see #getBindingMap()
	 * @generated
	 */
	void setBindingMap(Map<Variable, Object> value);

	/**
	 * Returns the value of the '<em><b>Host</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Host</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Host</em>' attribute.
	 * @see #setHost(Object)
	 * @see edu.ustb.sei.mde.morel.runtime.RuntimePackage#getContext_Host()
	 * @model
	 * @generated
	 */
	Object getHost();

	/**
	 * Sets the value of the '{@link edu.ustb.sei.mde.morel.runtime.Context#getHost <em>Host</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Host</em>' attribute.
	 * @see #getHost()
	 * @generated
	 */
	void setHost(Object value);

	/**
	 * Returns the value of the '<em><b>Parent Context</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parent Context</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parent Context</em>' reference.
	 * @see #setParentContext(Context)
	 * @see edu.ustb.sei.mde.morel.runtime.RuntimePackage#getContext_ParentContext()
	 * @model
	 * @generated
	 */
	Context getParentContext();

	/**
	 * Sets the value of the '{@link edu.ustb.sei.mde.morel.runtime.Context#getParentContext <em>Parent Context</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parent Context</em>' reference.
	 * @see #getParentContext()
	 * @generated
	 */
	void setParentContext(Context value);

	/**
	 * Returns the value of the '<em><b>Parent Scope</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parent Scope</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parent Scope</em>' reference.
	 * @see #setParentScope(Context)
	 * @see edu.ustb.sei.mde.morel.runtime.RuntimePackage#getContext_ParentScope()
	 * @model
	 * @generated
	 */
	Context getParentScope();

	/**
	 * Sets the value of the '{@link edu.ustb.sei.mde.morel.runtime.Context#getParentScope <em>Parent Scope</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parent Scope</em>' reference.
	 * @see #getParentScope()
	 * @generated
	 */
	void setParentScope(Context value);

	/**
	 * Returns the value of the '<em><b>Enviroment</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Enviroment</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Enviroment</em>' reference.
	 * @see #setEnviroment(Environment)
	 * @see edu.ustb.sei.mde.morel.runtime.RuntimePackage#getContext_Enviroment()
	 * @model required="true"
	 * @generated
	 */
	Environment getEnviroment();

	/**
	 * Sets the value of the '{@link edu.ustb.sei.mde.morel.runtime.Context#getEnviroment <em>Enviroment</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Enviroment</em>' reference.
	 * @see #getEnviroment()
	 * @generated
	 */
	void setEnviroment(Environment value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void initWithHost();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	Context newScope();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	Object getValue(Variable var);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void putValue(Variable var, Object value);

} // Context
