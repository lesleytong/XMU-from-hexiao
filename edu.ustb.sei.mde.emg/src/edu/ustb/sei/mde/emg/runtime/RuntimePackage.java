/**
 */
package edu.ustb.sei.mde.emg.runtime;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see edu.ustb.sei.mde.emg.runtime.RuntimeFactory
 * @model kind="package"
 * @generated
 */
public interface RuntimePackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "runtime";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.ustb.edu.cn/sei/mde/emg/runtime";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "runtime";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	RuntimePackage eINSTANCE = edu.ustb.sei.mde.emg.runtime.impl.RuntimePackageImpl.init();

	/**
	 * The meta object id for the '{@link edu.ustb.sei.mde.emg.runtime.impl.ContextImpl <em>Context</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.ustb.sei.mde.emg.runtime.impl.ContextImpl
	 * @see edu.ustb.sei.mde.emg.runtime.impl.RuntimePackageImpl#getContext()
	 * @generated
	 */
	int CONTEXT = 0;

	/**
	 * The feature id for the '<em><b>Binding Map</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTEXT__BINDING_MAP = 0;

	/**
	 * The feature id for the '<em><b>Host</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTEXT__HOST = 1;

	/**
	 * The feature id for the '<em><b>Parent Context</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTEXT__PARENT_CONTEXT = 2;

	/**
	 * The feature id for the '<em><b>Parent Scope</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTEXT__PARENT_SCOPE = 3;

	/**
	 * The feature id for the '<em><b>Enviroment</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTEXT__ENVIROMENT = 4;

	/**
	 * The number of structural features of the '<em>Context</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTEXT_FEATURE_COUNT = 5;

	/**
	 * The operation id for the '<em>Init With Host</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTEXT___INIT_WITH_HOST = 0;

	/**
	 * The operation id for the '<em>New Scope</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTEXT___NEW_SCOPE = 1;

	/**
	 * The operation id for the '<em>Get Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTEXT___GET_VALUE__VARIABLE = 2;

	/**
	 * The operation id for the '<em>Get</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTEXT___GET__STRING = 3;

	/**
	 * The operation id for the '<em>Put Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTEXT___PUT_VALUE__VARIABLE_OBJECT = 4;

	/**
	 * The operation id for the '<em>Get Copy</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTEXT___GET_COPY = 5;

	/**
	 * The operation id for the '<em>Register Variable</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTEXT___REGISTER_VARIABLE__VARIABLE = 6;

	/**
	 * The operation id for the '<em>Contain Variable</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTEXT___CONTAIN_VARIABLE__VARIABLE = 7;

	/**
	 * The operation id for the '<em>Find Variable</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTEXT___FIND_VARIABLE__STRING = 8;

	/**
	 * The number of operations of the '<em>Context</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTEXT_OPERATION_COUNT = 9;

	/**
	 * The meta object id for the '{@link edu.ustb.sei.mde.emg.runtime.impl.EnvironmentImpl <em>Environment</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.ustb.sei.mde.emg.runtime.impl.EnvironmentImpl
	 * @see edu.ustb.sei.mde.emg.runtime.impl.RuntimePackageImpl#getEnvironment()
	 * @generated
	 */
	int ENVIRONMENT = 1;

	/**
	 * The feature id for the '<em><b>Model Spaces</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENVIRONMENT__MODEL_SPACES = 0;

	/**
	 * The feature id for the '<em><b>Model Universe</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENVIRONMENT__MODEL_UNIVERSE = 1;

	/**
	 * The number of structural features of the '<em>Environment</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENVIRONMENT_FEATURE_COUNT = 2;

	/**
	 * The operation id for the '<em>Create Context</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENVIRONMENT___CREATE_CONTEXT = 0;

	/**
	 * The operation id for the '<em>Reset Cache</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENVIRONMENT___RESET_CACHE = 1;

	/**
	 * The number of operations of the '<em>Environment</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENVIRONMENT_OPERATION_COUNT = 2;


	/**
	 * The meta object id for the '<em>Model Space</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.ustb.sei.mde.emg.graph.ModelSpace
	 * @see edu.ustb.sei.mde.emg.runtime.impl.RuntimePackageImpl#getModelSpace()
	 * @generated
	 */
	int MODEL_SPACE = 2;


	/**
	 * The meta object id for the '<em>Model Universe</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.ustb.sei.mde.emg.graph.ModelUniverse
	 * @see edu.ustb.sei.mde.emg.runtime.impl.RuntimePackageImpl#getModelUniverse()
	 * @generated
	 */
	int MODEL_UNIVERSE = 3;


	/**
	 * Returns the meta object for class '{@link edu.ustb.sei.mde.emg.runtime.Context <em>Context</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Context</em>'.
	 * @see edu.ustb.sei.mde.emg.runtime.Context
	 * @generated
	 */
	EClass getContext();

	/**
	 * Returns the meta object for the attribute '{@link edu.ustb.sei.mde.emg.runtime.Context#getBindingMap <em>Binding Map</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Binding Map</em>'.
	 * @see edu.ustb.sei.mde.emg.runtime.Context#getBindingMap()
	 * @see #getContext()
	 * @generated
	 */
	EAttribute getContext_BindingMap();

	/**
	 * Returns the meta object for the attribute '{@link edu.ustb.sei.mde.emg.runtime.Context#getHost <em>Host</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Host</em>'.
	 * @see edu.ustb.sei.mde.emg.runtime.Context#getHost()
	 * @see #getContext()
	 * @generated
	 */
	EAttribute getContext_Host();

	/**
	 * Returns the meta object for the reference '{@link edu.ustb.sei.mde.emg.runtime.Context#getParentContext <em>Parent Context</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Parent Context</em>'.
	 * @see edu.ustb.sei.mde.emg.runtime.Context#getParentContext()
	 * @see #getContext()
	 * @generated
	 */
	EReference getContext_ParentContext();

	/**
	 * Returns the meta object for the reference '{@link edu.ustb.sei.mde.emg.runtime.Context#getParentScope <em>Parent Scope</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Parent Scope</em>'.
	 * @see edu.ustb.sei.mde.emg.runtime.Context#getParentScope()
	 * @see #getContext()
	 * @generated
	 */
	EReference getContext_ParentScope();

	/**
	 * Returns the meta object for the reference '{@link edu.ustb.sei.mde.emg.runtime.Context#getEnviroment <em>Enviroment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Enviroment</em>'.
	 * @see edu.ustb.sei.mde.emg.runtime.Context#getEnviroment()
	 * @see #getContext()
	 * @generated
	 */
	EReference getContext_Enviroment();

	/**
	 * Returns the meta object for the '{@link edu.ustb.sei.mde.emg.runtime.Context#initWithHost() <em>Init With Host</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Init With Host</em>' operation.
	 * @see edu.ustb.sei.mde.emg.runtime.Context#initWithHost()
	 * @generated
	 */
	EOperation getContext__InitWithHost();

	/**
	 * Returns the meta object for the '{@link edu.ustb.sei.mde.emg.runtime.Context#newScope() <em>New Scope</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>New Scope</em>' operation.
	 * @see edu.ustb.sei.mde.emg.runtime.Context#newScope()
	 * @generated
	 */
	EOperation getContext__NewScope();

	/**
	 * Returns the meta object for the '{@link edu.ustb.sei.mde.emg.runtime.Context#getValue(edu.ustb.sei.mde.morel.Variable) <em>Get Value</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Value</em>' operation.
	 * @see edu.ustb.sei.mde.emg.runtime.Context#getValue(edu.ustb.sei.mde.morel.Variable)
	 * @generated
	 */
	EOperation getContext__GetValue__Variable();

	/**
	 * Returns the meta object for the '{@link edu.ustb.sei.mde.emg.runtime.Context#get(java.lang.String) <em>Get</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get</em>' operation.
	 * @see edu.ustb.sei.mde.emg.runtime.Context#get(java.lang.String)
	 * @generated
	 */
	EOperation getContext__Get__String();

	/**
	 * Returns the meta object for the '{@link edu.ustb.sei.mde.emg.runtime.Context#putValue(edu.ustb.sei.mde.morel.Variable, java.lang.Object) <em>Put Value</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Put Value</em>' operation.
	 * @see edu.ustb.sei.mde.emg.runtime.Context#putValue(edu.ustb.sei.mde.morel.Variable, java.lang.Object)
	 * @generated
	 */
	EOperation getContext__PutValue__Variable_Object();

	/**
	 * Returns the meta object for the '{@link edu.ustb.sei.mde.emg.runtime.Context#getCopy() <em>Get Copy</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Copy</em>' operation.
	 * @see edu.ustb.sei.mde.emg.runtime.Context#getCopy()
	 * @generated
	 */
	EOperation getContext__GetCopy();

	/**
	 * Returns the meta object for the '{@link edu.ustb.sei.mde.emg.runtime.Context#registerVariable(edu.ustb.sei.mde.morel.Variable) <em>Register Variable</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Register Variable</em>' operation.
	 * @see edu.ustb.sei.mde.emg.runtime.Context#registerVariable(edu.ustb.sei.mde.morel.Variable)
	 * @generated
	 */
	EOperation getContext__RegisterVariable__Variable();

	/**
	 * Returns the meta object for the '{@link edu.ustb.sei.mde.emg.runtime.Context#containVariable(edu.ustb.sei.mde.morel.Variable) <em>Contain Variable</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Contain Variable</em>' operation.
	 * @see edu.ustb.sei.mde.emg.runtime.Context#containVariable(edu.ustb.sei.mde.morel.Variable)
	 * @generated
	 */
	EOperation getContext__ContainVariable__Variable();

	/**
	 * Returns the meta object for the '{@link edu.ustb.sei.mde.emg.runtime.Context#findVariable(java.lang.String) <em>Find Variable</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Find Variable</em>' operation.
	 * @see edu.ustb.sei.mde.emg.runtime.Context#findVariable(java.lang.String)
	 * @generated
	 */
	EOperation getContext__FindVariable__String();

	/**
	 * Returns the meta object for class '{@link edu.ustb.sei.mde.emg.runtime.Environment <em>Environment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Environment</em>'.
	 * @see edu.ustb.sei.mde.emg.runtime.Environment
	 * @generated
	 */
	EClass getEnvironment();

	/**
	 * Returns the meta object for the attribute '{@link edu.ustb.sei.mde.emg.runtime.Environment#getModelSpaces <em>Model Spaces</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Model Spaces</em>'.
	 * @see edu.ustb.sei.mde.emg.runtime.Environment#getModelSpaces()
	 * @see #getEnvironment()
	 * @generated
	 */
	EAttribute getEnvironment_ModelSpaces();

	/**
	 * Returns the meta object for the attribute '{@link edu.ustb.sei.mde.emg.runtime.Environment#getModelUniverse <em>Model Universe</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Model Universe</em>'.
	 * @see edu.ustb.sei.mde.emg.runtime.Environment#getModelUniverse()
	 * @see #getEnvironment()
	 * @generated
	 */
	EAttribute getEnvironment_ModelUniverse();

	/**
	 * Returns the meta object for the '{@link edu.ustb.sei.mde.emg.runtime.Environment#createContext() <em>Create Context</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Create Context</em>' operation.
	 * @see edu.ustb.sei.mde.emg.runtime.Environment#createContext()
	 * @generated
	 */
	EOperation getEnvironment__CreateContext();

	/**
	 * Returns the meta object for the '{@link edu.ustb.sei.mde.emg.runtime.Environment#resetCache() <em>Reset Cache</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Reset Cache</em>' operation.
	 * @see edu.ustb.sei.mde.emg.runtime.Environment#resetCache()
	 * @generated
	 */
	EOperation getEnvironment__ResetCache();

	/**
	 * Returns the meta object for data type '{@link edu.ustb.sei.mde.emg.graph.ModelSpace <em>Model Space</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Model Space</em>'.
	 * @see edu.ustb.sei.mde.emg.graph.ModelSpace
	 * @model instanceClass="edu.ustb.sei.mde.emg.graph.ModelSpace"
	 * @generated
	 */
	EDataType getModelSpace();

	/**
	 * Returns the meta object for data type '{@link edu.ustb.sei.mde.emg.graph.ModelUniverse <em>Model Universe</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Model Universe</em>'.
	 * @see edu.ustb.sei.mde.emg.graph.ModelUniverse
	 * @model instanceClass="edu.ustb.sei.mde.emg.graph.ModelUniverse"
	 * @generated
	 */
	EDataType getModelUniverse();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	RuntimeFactory getRuntimeFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link edu.ustb.sei.mde.emg.runtime.impl.ContextImpl <em>Context</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.ustb.sei.mde.emg.runtime.impl.ContextImpl
		 * @see edu.ustb.sei.mde.emg.runtime.impl.RuntimePackageImpl#getContext()
		 * @generated
		 */
		EClass CONTEXT = eINSTANCE.getContext();

		/**
		 * The meta object literal for the '<em><b>Binding Map</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONTEXT__BINDING_MAP = eINSTANCE.getContext_BindingMap();

		/**
		 * The meta object literal for the '<em><b>Host</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONTEXT__HOST = eINSTANCE.getContext_Host();

		/**
		 * The meta object literal for the '<em><b>Parent Context</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONTEXT__PARENT_CONTEXT = eINSTANCE.getContext_ParentContext();

		/**
		 * The meta object literal for the '<em><b>Parent Scope</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONTEXT__PARENT_SCOPE = eINSTANCE.getContext_ParentScope();

		/**
		 * The meta object literal for the '<em><b>Enviroment</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONTEXT__ENVIROMENT = eINSTANCE.getContext_Enviroment();

		/**
		 * The meta object literal for the '<em><b>Init With Host</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation CONTEXT___INIT_WITH_HOST = eINSTANCE.getContext__InitWithHost();

		/**
		 * The meta object literal for the '<em><b>New Scope</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation CONTEXT___NEW_SCOPE = eINSTANCE.getContext__NewScope();

		/**
		 * The meta object literal for the '<em><b>Get Value</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation CONTEXT___GET_VALUE__VARIABLE = eINSTANCE.getContext__GetValue__Variable();

		/**
		 * The meta object literal for the '<em><b>Get</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation CONTEXT___GET__STRING = eINSTANCE.getContext__Get__String();

		/**
		 * The meta object literal for the '<em><b>Put Value</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation CONTEXT___PUT_VALUE__VARIABLE_OBJECT = eINSTANCE.getContext__PutValue__Variable_Object();

		/**
		 * The meta object literal for the '<em><b>Get Copy</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation CONTEXT___GET_COPY = eINSTANCE.getContext__GetCopy();

		/**
		 * The meta object literal for the '<em><b>Register Variable</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation CONTEXT___REGISTER_VARIABLE__VARIABLE = eINSTANCE.getContext__RegisterVariable__Variable();

		/**
		 * The meta object literal for the '<em><b>Contain Variable</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation CONTEXT___CONTAIN_VARIABLE__VARIABLE = eINSTANCE.getContext__ContainVariable__Variable();

		/**
		 * The meta object literal for the '<em><b>Find Variable</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation CONTEXT___FIND_VARIABLE__STRING = eINSTANCE.getContext__FindVariable__String();

		/**
		 * The meta object literal for the '{@link edu.ustb.sei.mde.emg.runtime.impl.EnvironmentImpl <em>Environment</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.ustb.sei.mde.emg.runtime.impl.EnvironmentImpl
		 * @see edu.ustb.sei.mde.emg.runtime.impl.RuntimePackageImpl#getEnvironment()
		 * @generated
		 */
		EClass ENVIRONMENT = eINSTANCE.getEnvironment();

		/**
		 * The meta object literal for the '<em><b>Model Spaces</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ENVIRONMENT__MODEL_SPACES = eINSTANCE.getEnvironment_ModelSpaces();

		/**
		 * The meta object literal for the '<em><b>Model Universe</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ENVIRONMENT__MODEL_UNIVERSE = eINSTANCE.getEnvironment_ModelUniverse();

		/**
		 * The meta object literal for the '<em><b>Create Context</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ENVIRONMENT___CREATE_CONTEXT = eINSTANCE.getEnvironment__CreateContext();

		/**
		 * The meta object literal for the '<em><b>Reset Cache</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ENVIRONMENT___RESET_CACHE = eINSTANCE.getEnvironment__ResetCache();

		/**
		 * The meta object literal for the '<em>Model Space</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.ustb.sei.mde.emg.graph.ModelSpace
		 * @see edu.ustb.sei.mde.emg.runtime.impl.RuntimePackageImpl#getModelSpace()
		 * @generated
		 */
		EDataType MODEL_SPACE = eINSTANCE.getModelSpace();

		/**
		 * The meta object literal for the '<em>Model Universe</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.ustb.sei.mde.emg.graph.ModelUniverse
		 * @see edu.ustb.sei.mde.emg.runtime.impl.RuntimePackageImpl#getModelUniverse()
		 * @generated
		 */
		EDataType MODEL_UNIVERSE = eINSTANCE.getModelUniverse();

	}

} //RuntimePackage
