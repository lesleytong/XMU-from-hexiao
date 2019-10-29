/**
 */
package edu.ustb.sei.mde.xmu2.pattern.impl;

import edu.ustb.sei.mde.xmu2.pattern.*;

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
public class PatternFactoryImpl extends EFactoryImpl implements PatternFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static PatternFactory init() {
		try {
			PatternFactory thePatternFactory = (PatternFactory)EPackage.Registry.INSTANCE.getEFactory(PatternPackage.eNS_URI);
			if (thePatternFactory != null) {
				return thePatternFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new PatternFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PatternFactoryImpl() {
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
			case PatternPackage.PATTERN: return createPattern();
			case PatternPackage.PATTERN_NODE: return createPatternNode();
			case PatternPackage.OBJECT_PATTERN_EXPRESSION: return createObjectPatternExpression();
			case PatternPackage.PROPERTY_PATTERN_EXPRESSION: return createPropertyPatternExpression();
			case PatternPackage.REFLECTIVE_PATTERN_NODE: return createReflectivePatternNode();
			case PatternPackage.REFLECTIVE_OBJECT_PATTERN_EXPRESSION: return createReflectiveObjectPatternExpression();
			case PatternPackage.REFLECTIVE_PROPERTY_PATTERN_EXPRESSION: return createReflectivePropertyPatternExpression();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Pattern createPattern() {
		PatternImpl pattern = new PatternImpl();
		return pattern;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PatternNode createPatternNode() {
		PatternNodeImpl patternNode = new PatternNodeImpl();
		return patternNode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ObjectPatternExpression createObjectPatternExpression() {
		ObjectPatternExpressionImpl objectPatternExpression = new ObjectPatternExpressionImpl();
		return objectPatternExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PropertyPatternExpression createPropertyPatternExpression() {
		PropertyPatternExpressionImpl propertyPatternExpression = new PropertyPatternExpressionImpl();
		return propertyPatternExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ReflectivePatternNode createReflectivePatternNode() {
		ReflectivePatternNodeImpl reflectivePatternNode = new ReflectivePatternNodeImpl();
		return reflectivePatternNode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ReflectiveObjectPatternExpression createReflectiveObjectPatternExpression() {
		ReflectiveObjectPatternExpressionImpl reflectiveObjectPatternExpression = new ReflectiveObjectPatternExpressionImpl();
		return reflectiveObjectPatternExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ReflectivePropertyPatternExpression createReflectivePropertyPatternExpression() {
		ReflectivePropertyPatternExpressionImpl reflectivePropertyPatternExpression = new ReflectivePropertyPatternExpressionImpl();
		return reflectivePropertyPatternExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PatternPackage getPatternPackage() {
		return (PatternPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static PatternPackage getPackage() {
		return PatternPackage.eINSTANCE;
	}

} //PatternFactoryImpl
