/**
 */
package edu.ustb.sei.mde.xmu2.pattern.util;

import edu.ustb.sei.mde.xmu2.ReflectiveAPI;
import edu.ustb.sei.mde.xmu2.pattern.*;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see edu.ustb.sei.mde.xmu2.pattern.PatternPackage
 * @generated
 */
public class PatternAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static PatternPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PatternAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = PatternPackage.eINSTANCE;
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
	protected PatternSwitch<Adapter> modelSwitch =
		new PatternSwitch<Adapter>() {
			@Override
			public Adapter casePattern(Pattern object) {
				return createPatternAdapter();
			}
			@Override
			public Adapter casePatternNode(PatternNode object) {
				return createPatternNodeAdapter();
			}
			@Override
			public Adapter casePatternExpression(PatternExpression object) {
				return createPatternExpressionAdapter();
			}
			@Override
			public Adapter caseObjectPatternExpression(ObjectPatternExpression object) {
				return createObjectPatternExpressionAdapter();
			}
			@Override
			public Adapter casePropertyPatternExpression(PropertyPatternExpression object) {
				return createPropertyPatternExpressionAdapter();
			}
			@Override
			public Adapter caseReflectivePatternNode(ReflectivePatternNode object) {
				return createReflectivePatternNodeAdapter();
			}
			@Override
			public Adapter caseReflectiveObjectPatternExpression(ReflectiveObjectPatternExpression object) {
				return createReflectiveObjectPatternExpressionAdapter();
			}
			@Override
			public Adapter caseReflectivePropertyPatternExpression(ReflectivePropertyPatternExpression object) {
				return createReflectivePropertyPatternExpressionAdapter();
			}
			@Override
			public Adapter caseReflectiveAPI(ReflectiveAPI object) {
				return createReflectiveAPIAdapter();
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
	 * Creates a new adapter for an object of class '{@link edu.ustb.sei.mde.xmu2.pattern.Pattern <em>Pattern</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see edu.ustb.sei.mde.xmu2.pattern.Pattern
	 * @generated
	 */
	public Adapter createPatternAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link edu.ustb.sei.mde.xmu2.pattern.PatternNode <em>Node</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see edu.ustb.sei.mde.xmu2.pattern.PatternNode
	 * @generated
	 */
	public Adapter createPatternNodeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link edu.ustb.sei.mde.xmu2.pattern.PatternExpression <em>Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see edu.ustb.sei.mde.xmu2.pattern.PatternExpression
	 * @generated
	 */
	public Adapter createPatternExpressionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link edu.ustb.sei.mde.xmu2.pattern.ObjectPatternExpression <em>Object Pattern Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see edu.ustb.sei.mde.xmu2.pattern.ObjectPatternExpression
	 * @generated
	 */
	public Adapter createObjectPatternExpressionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link edu.ustb.sei.mde.xmu2.pattern.PropertyPatternExpression <em>Property Pattern Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see edu.ustb.sei.mde.xmu2.pattern.PropertyPatternExpression
	 * @generated
	 */
	public Adapter createPropertyPatternExpressionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link edu.ustb.sei.mde.xmu2.pattern.ReflectivePatternNode <em>Reflective Pattern Node</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see edu.ustb.sei.mde.xmu2.pattern.ReflectivePatternNode
	 * @generated
	 */
	public Adapter createReflectivePatternNodeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link edu.ustb.sei.mde.xmu2.pattern.ReflectiveObjectPatternExpression <em>Reflective Object Pattern Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see edu.ustb.sei.mde.xmu2.pattern.ReflectiveObjectPatternExpression
	 * @generated
	 */
	public Adapter createReflectiveObjectPatternExpressionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link edu.ustb.sei.mde.xmu2.pattern.ReflectivePropertyPatternExpression <em>Reflective Property Pattern Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see edu.ustb.sei.mde.xmu2.pattern.ReflectivePropertyPatternExpression
	 * @generated
	 */
	public Adapter createReflectivePropertyPatternExpressionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link edu.ustb.sei.mde.xmu2.ReflectiveAPI <em>Reflective API</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see edu.ustb.sei.mde.xmu2.ReflectiveAPI
	 * @generated
	 */
	public Adapter createReflectiveAPIAdapter() {
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

} //PatternAdapterFactory
