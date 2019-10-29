/**
 */
package edu.ustb.sei.mde.xmu2.impl;

import edu.ustb.sei.mde.xmu2.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class Xmu2FactoryImpl extends EFactoryImpl implements Xmu2Factory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static Xmu2Factory init() {
		try {
			Xmu2Factory theXmu2Factory = (Xmu2Factory)EPackage.Registry.INSTANCE.getEFactory(Xmu2Package.eNS_URI);
			if (theXmu2Factory != null) {
				return theXmu2Factory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new Xmu2FactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Xmu2FactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case Xmu2Package.TRANSFORMATION_MODEL: return createTransformationModel();
			case Xmu2Package.ENTRY_POINT: return createEntryPoint();
			case Xmu2Package.ENTRY_DATA: return createEntryData();
			case Xmu2Package.PARAMETER: return createParameter();
			case Xmu2Package.MODEL_RULE: return createModelRule();
			case Xmu2Package.ARITHMETIC_RULE: return createArithmeticRule();
			case Xmu2Package.CONCRETE_VARIABLE_DECLARATION: return createConcreteVariableDeclaration();
			case Xmu2Package.REFLECTIVE_VARIABLE_DECLARATION: return createReflectiveVariableDeclaration();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TransformationModel createTransformationModel() {
		TransformationModelImpl transformationModel = new TransformationModelImpl();
		return transformationModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EntryPoint createEntryPoint() {
		EntryPointImpl entryPoint = new EntryPointImpl();
		return entryPoint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EntryData createEntryData() {
		EntryDataImpl entryData = new EntryDataImpl();
		return entryData;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Parameter createParameter() {
		ParameterImpl parameter = new ParameterImpl();
		return parameter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModelRule createModelRule() {
		ModelRuleImpl modelRule = new ModelRuleImpl();
		return modelRule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ArithmeticRule createArithmeticRule() {
		ArithmeticRuleImpl arithmeticRule = new ArithmeticRuleImpl();
		return arithmeticRule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConcreteVariableDeclaration createConcreteVariableDeclaration() {
		ConcreteVariableDeclarationImpl concreteVariableDeclaration = new ConcreteVariableDeclarationImpl();
		return concreteVariableDeclaration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ReflectiveVariableDeclaration createReflectiveVariableDeclaration() {
		ReflectiveVariableDeclarationImpl reflectiveVariableDeclaration = new ReflectiveVariableDeclarationImpl();
		return reflectiveVariableDeclaration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Xmu2Package getXmu2Package() {
		return (Xmu2Package)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static Xmu2Package getPackage() {
		return Xmu2Package.eINSTANCE;
	}

} //Xmu2FactoryImpl
