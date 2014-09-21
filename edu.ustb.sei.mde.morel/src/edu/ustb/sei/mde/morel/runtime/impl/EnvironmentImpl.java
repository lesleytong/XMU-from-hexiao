/**
 */
package edu.ustb.sei.mde.morel.runtime.impl;

import edu.ustb.sei.mde.morel.runtime.Context;
import edu.ustb.sei.mde.morel.runtime.Environment;
import edu.ustb.sei.mde.morel.runtime.RuntimeFactory;
import edu.ustb.sei.mde.morel.runtime.RuntimePackage;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Environment</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class EnvironmentImpl extends MinimalEObjectImpl.Container implements Environment {
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
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case RuntimePackage.ENVIRONMENT___CREATE_CONTEXT:
				return createContext();
		}
		return super.eInvoke(operationID, arguments);
	}

} //EnvironmentImpl
