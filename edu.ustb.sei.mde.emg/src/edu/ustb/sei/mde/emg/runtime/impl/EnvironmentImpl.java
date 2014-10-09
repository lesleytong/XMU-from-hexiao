/**
 */
package edu.ustb.sei.mde.emg.runtime.impl;

import edu.ustb.sei.mde.emg.graph.ModelSpace;
import edu.ustb.sei.mde.emg.graph.ModelUniverse;
import edu.ustb.sei.mde.emg.runtime.Context;
import edu.ustb.sei.mde.emg.runtime.Environment;
import edu.ustb.sei.mde.emg.runtime.RuntimeFactory;
import edu.ustb.sei.mde.emg.runtime.RuntimePackage;
import edu.ustb.sei.mde.morel.TypedModel;

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
 *   <li>{@link edu.ustb.sei.mde.emg.runtime.impl.EnvironmentImpl#getModelSpaces <em>Model Spaces</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.emg.runtime.impl.EnvironmentImpl#getModelUniverse <em>Model Universe</em>}</li>
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
	protected Map<TypedModel, ModelSpace> modelSpaces;
	/**
	 * The default value of the '{@link #getModelUniverse() <em>Model Universe</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getModelUniverse()
	 * @generated
	 * @ordered
	 */
	protected static final ModelUniverse MODEL_UNIVERSE_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getModelUniverse() <em>Model Universe</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getModelUniverse()
	 * @generated
	 * @ordered
	 */
	protected ModelUniverse modelUniverse = MODEL_UNIVERSE_EDEFAULT;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected EnvironmentImpl() {
		super();
		modelUniverse = new ModelUniverse();
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
	public Map<TypedModel, ModelSpace> getModelSpaces() {
		if(modelSpaces==null) {
			modelSpaces = new HashMap<TypedModel,ModelSpace>();
		}
		return modelSpaces;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setModelSpaces(Map<TypedModel, ModelSpace> newModelSpaces) {
		Map<TypedModel, ModelSpace> oldModelSpaces = modelSpaces;
		modelSpaces = newModelSpaces;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RuntimePackage.ENVIRONMENT__MODEL_SPACES, oldModelSpaces, modelSpaces));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModelUniverse getModelUniverse() {
		return modelUniverse;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setModelUniverse(ModelUniverse newModelUniverse) {
		ModelUniverse oldModelUniverse = modelUniverse;
		modelUniverse = newModelUniverse;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RuntimePackage.ENVIRONMENT__MODEL_UNIVERSE, oldModelUniverse, modelUniverse));
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
	 * @generated NOT
	 */
	public void resetCache() {
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
			case RuntimePackage.ENVIRONMENT__MODEL_UNIVERSE:
				return getModelUniverse();
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
				setModelSpaces((Map<TypedModel, ModelSpace>)newValue);
				return;
			case RuntimePackage.ENVIRONMENT__MODEL_UNIVERSE:
				setModelUniverse((ModelUniverse)newValue);
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
				setModelSpaces((Map<TypedModel, ModelSpace>)null);
				return;
			case RuntimePackage.ENVIRONMENT__MODEL_UNIVERSE:
				setModelUniverse(MODEL_UNIVERSE_EDEFAULT);
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
			case RuntimePackage.ENVIRONMENT__MODEL_UNIVERSE:
				return MODEL_UNIVERSE_EDEFAULT == null ? modelUniverse != null : !MODEL_UNIVERSE_EDEFAULT.equals(modelUniverse);
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
			case RuntimePackage.ENVIRONMENT___RESET_CACHE:
				resetCache();
				return null;
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
		result.append(", modelUniverse: ");
		result.append(modelUniverse);
		result.append(')');
		return result.toString();
	}

} //EnvironmentImpl
