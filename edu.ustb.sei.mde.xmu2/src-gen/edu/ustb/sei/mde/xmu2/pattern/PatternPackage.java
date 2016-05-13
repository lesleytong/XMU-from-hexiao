/**
 */
package edu.ustb.sei.mde.xmu2.pattern;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see edu.ustb.sei.mde.xmu2.pattern.PatternFactory
 * @model kind="package"
 * @generated
 */
public interface PatternPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "pattern";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.ustb.edu.cn/sei/mde/xmu2/pattern";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "pattern";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	PatternPackage eINSTANCE = edu.ustb.sei.mde.xmu2.pattern.impl.PatternPackageImpl.init();

	/**
	 * The meta object id for the '{@link edu.ustb.sei.mde.xmu2.pattern.impl.PatternImpl <em>Pattern</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.ustb.sei.mde.xmu2.pattern.impl.PatternImpl
	 * @see edu.ustb.sei.mde.xmu2.pattern.impl.PatternPackageImpl#getPattern()
	 * @generated
	 */
	int PATTERN = 0;

	/**
	 * The feature id for the '<em><b>Root</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN__ROOT = 0;

	/**
	 * The feature id for the '<em><b>Guard</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN__GUARD = 1;

	/**
	 * The number of structural features of the '<em>Pattern</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link edu.ustb.sei.mde.xmu2.pattern.impl.PatternNodeImpl <em>Node</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.ustb.sei.mde.xmu2.pattern.impl.PatternNodeImpl
	 * @see edu.ustb.sei.mde.xmu2.pattern.impl.PatternPackageImpl#getPatternNode()
	 * @generated
	 */
	int PATTERN_NODE = 1;

	/**
	 * The feature id for the '<em><b>Variable</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN_NODE__VARIABLE = 0;

	/**
	 * The feature id for the '<em><b>Expressions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN_NODE__EXPRESSIONS = 1;

	/**
	 * The number of structural features of the '<em>Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN_NODE_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link edu.ustb.sei.mde.xmu2.pattern.impl.PatternExpressionImpl <em>Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.ustb.sei.mde.xmu2.pattern.impl.PatternExpressionImpl
	 * @see edu.ustb.sei.mde.xmu2.pattern.impl.PatternPackageImpl#getPatternExpression()
	 * @generated
	 */
	int PATTERN_EXPRESSION = 2;

	/**
	 * The feature id for the '<em><b>Owner Node</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN_EXPRESSION__OWNER_NODE = 0;

	/**
	 * The feature id for the '<em><b>Feature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN_EXPRESSION__FEATURE = 1;

	/**
	 * The feature id for the '<em><b>Selector</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN_EXPRESSION__SELECTOR = 2;

	/**
	 * The feature id for the '<em><b>Position</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN_EXPRESSION__POSITION = 3;

	/**
	 * The feature id for the '<em><b>Nullable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN_EXPRESSION__NULLABLE = 4;

	/**
	 * The number of structural features of the '<em>Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN_EXPRESSION_FEATURE_COUNT = 5;

	/**
	 * The meta object id for the '{@link edu.ustb.sei.mde.xmu2.pattern.impl.ObjectPatternExpressionImpl <em>Object Pattern Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.ustb.sei.mde.xmu2.pattern.impl.ObjectPatternExpressionImpl
	 * @see edu.ustb.sei.mde.xmu2.pattern.impl.PatternPackageImpl#getObjectPatternExpression()
	 * @generated
	 */
	int OBJECT_PATTERN_EXPRESSION = 3;

	/**
	 * The feature id for the '<em><b>Owner Node</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_PATTERN_EXPRESSION__OWNER_NODE = PATTERN_EXPRESSION__OWNER_NODE;

	/**
	 * The feature id for the '<em><b>Feature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_PATTERN_EXPRESSION__FEATURE = PATTERN_EXPRESSION__FEATURE;

	/**
	 * The feature id for the '<em><b>Selector</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_PATTERN_EXPRESSION__SELECTOR = PATTERN_EXPRESSION__SELECTOR;

	/**
	 * The feature id for the '<em><b>Position</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_PATTERN_EXPRESSION__POSITION = PATTERN_EXPRESSION__POSITION;

	/**
	 * The feature id for the '<em><b>Nullable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_PATTERN_EXPRESSION__NULLABLE = PATTERN_EXPRESSION__NULLABLE;

	/**
	 * The feature id for the '<em><b>Target Node</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_PATTERN_EXPRESSION__TARGET_NODE = PATTERN_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Object Pattern Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_PATTERN_EXPRESSION_FEATURE_COUNT = PATTERN_EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link edu.ustb.sei.mde.xmu2.pattern.impl.PropertyPatternExpressionImpl <em>Property Pattern Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.ustb.sei.mde.xmu2.pattern.impl.PropertyPatternExpressionImpl
	 * @see edu.ustb.sei.mde.xmu2.pattern.impl.PatternPackageImpl#getPropertyPatternExpression()
	 * @generated
	 */
	int PROPERTY_PATTERN_EXPRESSION = 4;

	/**
	 * The feature id for the '<em><b>Owner Node</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_PATTERN_EXPRESSION__OWNER_NODE = PATTERN_EXPRESSION__OWNER_NODE;

	/**
	 * The feature id for the '<em><b>Feature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_PATTERN_EXPRESSION__FEATURE = PATTERN_EXPRESSION__FEATURE;

	/**
	 * The feature id for the '<em><b>Selector</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_PATTERN_EXPRESSION__SELECTOR = PATTERN_EXPRESSION__SELECTOR;

	/**
	 * The feature id for the '<em><b>Position</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_PATTERN_EXPRESSION__POSITION = PATTERN_EXPRESSION__POSITION;

	/**
	 * The feature id for the '<em><b>Nullable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_PATTERN_EXPRESSION__NULLABLE = PATTERN_EXPRESSION__NULLABLE;

	/**
	 * The feature id for the '<em><b>Target Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_PATTERN_EXPRESSION__TARGET_EXPRESSION = PATTERN_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Property Pattern Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_PATTERN_EXPRESSION_FEATURE_COUNT = PATTERN_EXPRESSION_FEATURE_COUNT + 1;


	/**
	 * Returns the meta object for class '{@link edu.ustb.sei.mde.xmu2.pattern.Pattern <em>Pattern</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Pattern</em>'.
	 * @see edu.ustb.sei.mde.xmu2.pattern.Pattern
	 * @generated
	 */
	EClass getPattern();

	/**
	 * Returns the meta object for the containment reference '{@link edu.ustb.sei.mde.xmu2.pattern.Pattern#getRoot <em>Root</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Root</em>'.
	 * @see edu.ustb.sei.mde.xmu2.pattern.Pattern#getRoot()
	 * @see #getPattern()
	 * @generated
	 */
	EReference getPattern_Root();

	/**
	 * Returns the meta object for the containment reference '{@link edu.ustb.sei.mde.xmu2.pattern.Pattern#getGuard <em>Guard</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Guard</em>'.
	 * @see edu.ustb.sei.mde.xmu2.pattern.Pattern#getGuard()
	 * @see #getPattern()
	 * @generated
	 */
	EReference getPattern_Guard();

	/**
	 * Returns the meta object for class '{@link edu.ustb.sei.mde.xmu2.pattern.PatternNode <em>Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Node</em>'.
	 * @see edu.ustb.sei.mde.xmu2.pattern.PatternNode
	 * @generated
	 */
	EClass getPatternNode();

	/**
	 * Returns the meta object for the containment reference '{@link edu.ustb.sei.mde.xmu2.pattern.PatternNode#getVariable <em>Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Variable</em>'.
	 * @see edu.ustb.sei.mde.xmu2.pattern.PatternNode#getVariable()
	 * @see #getPatternNode()
	 * @generated
	 */
	EReference getPatternNode_Variable();

	/**
	 * Returns the meta object for the containment reference list '{@link edu.ustb.sei.mde.xmu2.pattern.PatternNode#getExpressions <em>Expressions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Expressions</em>'.
	 * @see edu.ustb.sei.mde.xmu2.pattern.PatternNode#getExpressions()
	 * @see #getPatternNode()
	 * @generated
	 */
	EReference getPatternNode_Expressions();

	/**
	 * Returns the meta object for class '{@link edu.ustb.sei.mde.xmu2.pattern.PatternExpression <em>Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Expression</em>'.
	 * @see edu.ustb.sei.mde.xmu2.pattern.PatternExpression
	 * @generated
	 */
	EClass getPatternExpression();

	/**
	 * Returns the meta object for the container reference '{@link edu.ustb.sei.mde.xmu2.pattern.PatternExpression#getOwnerNode <em>Owner Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Owner Node</em>'.
	 * @see edu.ustb.sei.mde.xmu2.pattern.PatternExpression#getOwnerNode()
	 * @see #getPatternExpression()
	 * @generated
	 */
	EReference getPatternExpression_OwnerNode();

	/**
	 * Returns the meta object for the reference '{@link edu.ustb.sei.mde.xmu2.pattern.PatternExpression#getFeature <em>Feature</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Feature</em>'.
	 * @see edu.ustb.sei.mde.xmu2.pattern.PatternExpression#getFeature()
	 * @see #getPatternExpression()
	 * @generated
	 */
	EReference getPatternExpression_Feature();

	/**
	 * Returns the meta object for the containment reference '{@link edu.ustb.sei.mde.xmu2.pattern.PatternExpression#getSelector <em>Selector</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Selector</em>'.
	 * @see edu.ustb.sei.mde.xmu2.pattern.PatternExpression#getSelector()
	 * @see #getPatternExpression()
	 * @generated
	 */
	EReference getPatternExpression_Selector();

	/**
	 * Returns the meta object for the containment reference '{@link edu.ustb.sei.mde.xmu2.pattern.PatternExpression#getPosition <em>Position</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Position</em>'.
	 * @see edu.ustb.sei.mde.xmu2.pattern.PatternExpression#getPosition()
	 * @see #getPatternExpression()
	 * @generated
	 */
	EReference getPatternExpression_Position();

	/**
	 * Returns the meta object for the attribute '{@link edu.ustb.sei.mde.xmu2.pattern.PatternExpression#isNullable <em>Nullable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Nullable</em>'.
	 * @see edu.ustb.sei.mde.xmu2.pattern.PatternExpression#isNullable()
	 * @see #getPatternExpression()
	 * @generated
	 */
	EAttribute getPatternExpression_Nullable();

	/**
	 * Returns the meta object for class '{@link edu.ustb.sei.mde.xmu2.pattern.ObjectPatternExpression <em>Object Pattern Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Object Pattern Expression</em>'.
	 * @see edu.ustb.sei.mde.xmu2.pattern.ObjectPatternExpression
	 * @generated
	 */
	EClass getObjectPatternExpression();

	/**
	 * Returns the meta object for the containment reference '{@link edu.ustb.sei.mde.xmu2.pattern.ObjectPatternExpression#getTargetNode <em>Target Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Target Node</em>'.
	 * @see edu.ustb.sei.mde.xmu2.pattern.ObjectPatternExpression#getTargetNode()
	 * @see #getObjectPatternExpression()
	 * @generated
	 */
	EReference getObjectPatternExpression_TargetNode();

	/**
	 * Returns the meta object for class '{@link edu.ustb.sei.mde.xmu2.pattern.PropertyPatternExpression <em>Property Pattern Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Property Pattern Expression</em>'.
	 * @see edu.ustb.sei.mde.xmu2.pattern.PropertyPatternExpression
	 * @generated
	 */
	EClass getPropertyPatternExpression();

	/**
	 * Returns the meta object for the containment reference '{@link edu.ustb.sei.mde.xmu2.pattern.PropertyPatternExpression#getTargetExpression <em>Target Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Target Expression</em>'.
	 * @see edu.ustb.sei.mde.xmu2.pattern.PropertyPatternExpression#getTargetExpression()
	 * @see #getPropertyPatternExpression()
	 * @generated
	 */
	EReference getPropertyPatternExpression_TargetExpression();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	PatternFactory getPatternFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link edu.ustb.sei.mde.xmu2.pattern.impl.PatternImpl <em>Pattern</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.ustb.sei.mde.xmu2.pattern.impl.PatternImpl
		 * @see edu.ustb.sei.mde.xmu2.pattern.impl.PatternPackageImpl#getPattern()
		 * @generated
		 */
		EClass PATTERN = eINSTANCE.getPattern();

		/**
		 * The meta object literal for the '<em><b>Root</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PATTERN__ROOT = eINSTANCE.getPattern_Root();

		/**
		 * The meta object literal for the '<em><b>Guard</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PATTERN__GUARD = eINSTANCE.getPattern_Guard();

		/**
		 * The meta object literal for the '{@link edu.ustb.sei.mde.xmu2.pattern.impl.PatternNodeImpl <em>Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.ustb.sei.mde.xmu2.pattern.impl.PatternNodeImpl
		 * @see edu.ustb.sei.mde.xmu2.pattern.impl.PatternPackageImpl#getPatternNode()
		 * @generated
		 */
		EClass PATTERN_NODE = eINSTANCE.getPatternNode();

		/**
		 * The meta object literal for the '<em><b>Variable</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PATTERN_NODE__VARIABLE = eINSTANCE.getPatternNode_Variable();

		/**
		 * The meta object literal for the '<em><b>Expressions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PATTERN_NODE__EXPRESSIONS = eINSTANCE.getPatternNode_Expressions();

		/**
		 * The meta object literal for the '{@link edu.ustb.sei.mde.xmu2.pattern.impl.PatternExpressionImpl <em>Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.ustb.sei.mde.xmu2.pattern.impl.PatternExpressionImpl
		 * @see edu.ustb.sei.mde.xmu2.pattern.impl.PatternPackageImpl#getPatternExpression()
		 * @generated
		 */
		EClass PATTERN_EXPRESSION = eINSTANCE.getPatternExpression();

		/**
		 * The meta object literal for the '<em><b>Owner Node</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PATTERN_EXPRESSION__OWNER_NODE = eINSTANCE.getPatternExpression_OwnerNode();

		/**
		 * The meta object literal for the '<em><b>Feature</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PATTERN_EXPRESSION__FEATURE = eINSTANCE.getPatternExpression_Feature();

		/**
		 * The meta object literal for the '<em><b>Selector</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PATTERN_EXPRESSION__SELECTOR = eINSTANCE.getPatternExpression_Selector();

		/**
		 * The meta object literal for the '<em><b>Position</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PATTERN_EXPRESSION__POSITION = eINSTANCE.getPatternExpression_Position();

		/**
		 * The meta object literal for the '<em><b>Nullable</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PATTERN_EXPRESSION__NULLABLE = eINSTANCE.getPatternExpression_Nullable();

		/**
		 * The meta object literal for the '{@link edu.ustb.sei.mde.xmu2.pattern.impl.ObjectPatternExpressionImpl <em>Object Pattern Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.ustb.sei.mde.xmu2.pattern.impl.ObjectPatternExpressionImpl
		 * @see edu.ustb.sei.mde.xmu2.pattern.impl.PatternPackageImpl#getObjectPatternExpression()
		 * @generated
		 */
		EClass OBJECT_PATTERN_EXPRESSION = eINSTANCE.getObjectPatternExpression();

		/**
		 * The meta object literal for the '<em><b>Target Node</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OBJECT_PATTERN_EXPRESSION__TARGET_NODE = eINSTANCE.getObjectPatternExpression_TargetNode();

		/**
		 * The meta object literal for the '{@link edu.ustb.sei.mde.xmu2.pattern.impl.PropertyPatternExpressionImpl <em>Property Pattern Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.ustb.sei.mde.xmu2.pattern.impl.PropertyPatternExpressionImpl
		 * @see edu.ustb.sei.mde.xmu2.pattern.impl.PatternPackageImpl#getPropertyPatternExpression()
		 * @generated
		 */
		EClass PROPERTY_PATTERN_EXPRESSION = eINSTANCE.getPropertyPatternExpression();

		/**
		 * The meta object literal for the '<em><b>Target Expression</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROPERTY_PATTERN_EXPRESSION__TARGET_EXPRESSION = eINSTANCE.getPropertyPatternExpression_TargetExpression();

	}

} //PatternPackage
