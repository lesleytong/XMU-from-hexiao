/**
 */
package edu.ustb.sei.mde.emg.runtime;

import edu.ustb.sei.mde.emg.graph.ModelSpace;
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
 *   <li>{@link edu.ustb.sei.mde.emg.runtime.Environment#getModelSpaces <em>Model Spaces</em>}</li>
 * </ul>
 * </p>
 *
 * @see edu.ustb.sei.mde.emg.runtime.RuntimePackage#getEnvironment()
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
	 * @see edu.ustb.sei.mde.emg.runtime.RuntimePackage#getEnvironment_ModelSpaces()
	 * @model transient="true"
	 * @generated
	 */
	Map<TypedModel, ModelSpace> getModelSpaces();

	/**
	 * Sets the value of the '{@link edu.ustb.sei.mde.emg.runtime.Environment#getModelSpaces <em>Model Spaces</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Model Spaces</em>' attribute.
	 * @see #getModelSpaces()
	 * @generated
	 */
	void setModelSpaces(Map<TypedModel, ModelSpace> value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	Context createContext();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void resetCache();

} // Environment
