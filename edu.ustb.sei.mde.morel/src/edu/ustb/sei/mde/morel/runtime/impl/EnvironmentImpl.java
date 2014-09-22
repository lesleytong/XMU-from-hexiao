/**
 */
package edu.ustb.sei.mde.morel.runtime.impl;

import edu.ustb.sei.mde.morel.TypedModel;
import edu.ustb.sei.mde.morel.runtime.Context;
import edu.ustb.sei.mde.morel.runtime.Environment;
import edu.ustb.sei.mde.morel.runtime.RuntimeFactory;
import edu.ustb.sei.mde.morel.runtime.RuntimePackage;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Environment</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link edu.ustb.sei.mde.morel.runtime.impl.EnvironmentImpl#getModelSpaces <em>Model Spaces</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EnvironmentImpl extends MinimalEObjectImpl.Container implements Environment {
	/**
	 * The cached value of the '{@link #getModelSpaces() <em>Model Spaces</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getModelSpaces()
	 * @generated
	 * @ordered
	 */
	protected Map<TypedModel, Object> modelSpaces;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EnvironmentImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return RuntimePackage.Literals.ENVIRONMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Map<TypedModel, Object> getModelSpaces() {
		if(modelSpaces==null) {
			modelSpaces = new HashMap<TypedModel,Object>();
		}
		return modelSpaces;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setModelSpaces(Map<TypedModel, Object> newModelSpaces) {
		Map<TypedModel, Object> oldModelSpaces = modelSpaces;
		modelSpaces = newModelSpaces;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RuntimePackage.ENVIRONMENT__MODEL_SPACES, oldModelSpaces, modelSpaces));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Context createContext() {
		Context context = RuntimeFactory.eINSTANCE.createContext();
		context.setEnviroment(this);
		return context;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case RuntimePackage.ENVIRONMENT__MODEL_SPACES:
				return getModelSpaces();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case RuntimePackage.ENVIRONMENT__MODEL_SPACES:
				setModelSpaces((Map<TypedModel, Object>)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case RuntimePackage.ENVIRONMENT__MODEL_SPACES:
				setModelSpaces((Map<TypedModel, Object>)null);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case RuntimePackage.ENVIRONMENT__MODEL_SPACES:
				return modelSpaces != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case RuntimePackage.ENVIRONMENT___CREATE_CONTEXT:
				return createContext();
		}
		return super.eInvoke(operationID, arguments);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (modelSpaces: ");
		result.append(modelSpaces);
		result.append(')');
		return result.toString();
	}

} //EnvironmentImpl
