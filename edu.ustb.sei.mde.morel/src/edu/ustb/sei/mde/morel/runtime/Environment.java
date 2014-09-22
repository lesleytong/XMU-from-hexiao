/**
 */
package edu.ustb.sei.mde.morel.runtime;

import edu.ustb.sei.mde.morel.TypedModel;
import java.util.Map;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Environment</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link edu.ustb.sei.mde.morel.runtime.Environment#getModelSpaces <em>Model Spaces</em>}</li>
 * </ul>
 * </p>
 *
 * @see edu.ustb.sei.mde.morel.runtime.RuntimePackage#getEnvironment()
 * @model
 * @generated
 */
public interface Environment extends EObject {
	/**
	 * Returns the value of the '<em><b>Model Spaces</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Model Spaces</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Model Spaces</em>' attribute.
	 * @see #setModelSpaces(Map)
	 * @see edu.ustb.sei.mde.morel.runtime.RuntimePackage#getEnvironment_ModelSpaces()
	 * @model transient="true"
	 * @generated
	 */
	Map<TypedModel, Object> getModelSpaces();

	/**
	 * Sets the value of the '{@link edu.ustb.sei.mde.morel.runtime.Environment#getModelSpaces <em>Model Spaces</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Model Spaces</em>' attribute.
	 * @see #getModelSpaces()
	 * @generated
	 */
	void setModelSpaces(Map<TypedModel, Object> value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	Context createContext();

} // Environment
