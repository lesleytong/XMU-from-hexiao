/**
 */
package edu.ustb.sei.mde.xmu2.util;

import edu.ustb.sei.mde.xmu2.*;

import edu.ustb.sei.mde.xmu2common.DomainElement;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see edu.ustb.sei.mde.xmu2.Xmu2Package
 * @generated
 */
public class Xmu2AdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static Xmu2Package modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Xmu2AdapterFactory() {
		if (modelPackage == null) {
			modelPackage = Xmu2Package.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Xmu2Switch<Adapter> modelSwitch =
		new Xmu2Switch<Adapter>() {
			@Override
			public Adapter caseNamedElement(NamedElement object) {
				return createNamedElementAdapter();
			}
			@Override
			public Adapter caseTransformationModel(TransformationModel object) {
				return createTransformationModelAdapter();
			}
			@Override
			public Adapter caseEntryPoint(EntryPoint object) {
				return createEntryPointAdapter();
			}
			@Override
			public Adapter caseEntryData(EntryData object) {
				return createEntryDataAdapter();
			}
			@Override
			public Adapter caseAbstractRule(AbstractRule object) {
				return createAbstractRuleAdapter();
			}
			@Override
			public Adapter caseParameter(Parameter object) {
				return createParameterAdapter();
			}
			@Override
			public Adapter caseModelRule(ModelRule object) {
				return createModelRuleAdapter();
			}
			@Override
			public Adapter caseArithmeticRule(ArithmeticRule object) {
				return createArithmeticRuleAdapter();
			}
			@Override
			public Adapter caseVariableDeclaration(VariableDeclaration object) {
				return createVariableDeclarationAdapter();
			}
			@Override
			public Adapter caseTypedElement(TypedElement object) {
				return createTypedElementAdapter();
			}
			@Override
			public Adapter caseXmu2common_NamedElement(edu.ustb.sei.mde.xmu2common.NamedElement object) {
				return createXmu2common_NamedElementAdapter();
			}
			@Override
			public Adapter caseDomainElement(DomainElement object) {
				return createDomainElementAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link edu.ustb.sei.mde.xmu2.NamedElement <em>Named Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see edu.ustb.sei.mde.xmu2.NamedElement
	 * @generated
	 */
	public Adapter createNamedElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link edu.ustb.sei.mde.xmu2.TransformationModel <em>Transformation Model</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see edu.ustb.sei.mde.xmu2.TransformationModel
	 * @generated
	 */
	public Adapter createTransformationModelAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link edu.ustb.sei.mde.xmu2.EntryPoint <em>Entry Point</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see edu.ustb.sei.mde.xmu2.EntryPoint
	 * @generated
	 */
	public Adapter createEntryPointAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link edu.ustb.sei.mde.xmu2.EntryData <em>Entry Data</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see edu.ustb.sei.mde.xmu2.EntryData
	 * @generated
	 */
	public Adapter createEntryDataAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link edu.ustb.sei.mde.xmu2.AbstractRule <em>Abstract Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see edu.ustb.sei.mde.xmu2.AbstractRule
	 * @generated
	 */
	public Adapter createAbstractRuleAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link edu.ustb.sei.mde.xmu2.Parameter <em>Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see edu.ustb.sei.mde.xmu2.Parameter
	 * @generated
	 */
	public Adapter createParameterAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link edu.ustb.sei.mde.xmu2.ModelRule <em>Model Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see edu.ustb.sei.mde.xmu2.ModelRule
	 * @generated
	 */
	public Adapter createModelRuleAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link edu.ustb.sei.mde.xmu2.ArithmeticRule <em>Arithmetic Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see edu.ustb.sei.mde.xmu2.ArithmeticRule
	 * @generated
	 */
	public Adapter createArithmeticRuleAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link edu.ustb.sei.mde.xmu2.VariableDeclaration <em>Variable Declaration</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see edu.ustb.sei.mde.xmu2.VariableDeclaration
	 * @generated
	 */
	public Adapter createVariableDeclarationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link edu.ustb.sei.mde.xmu2.TypedElement <em>Typed Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see edu.ustb.sei.mde.xmu2.TypedElement
	 * @generated
	 */
	public Adapter createTypedElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link edu.ustb.sei.mde.xmu2common.NamedElement <em>Named Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see edu.ustb.sei.mde.xmu2common.NamedElement
	 * @generated
	 */
	public Adapter createXmu2common_NamedElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link edu.ustb.sei.mde.xmu2common.DomainElement <em>Domain Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see edu.ustb.sei.mde.xmu2common.DomainElement
	 * @generated
	 */
	public Adapter createDomainElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //Xmu2AdapterFactory
