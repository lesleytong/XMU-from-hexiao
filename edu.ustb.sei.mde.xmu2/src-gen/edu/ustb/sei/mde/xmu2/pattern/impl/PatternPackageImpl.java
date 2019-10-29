/**
 */
package edu.ustb.sei.mde.xmu2.pattern.impl;

import edu.ustb.sei.mde.xmu2.Xmu2Package;

import edu.ustb.sei.mde.xmu2.expression.ExpressionPackage;

import edu.ustb.sei.mde.xmu2.expression.impl.ExpressionPackageImpl;

import edu.ustb.sei.mde.xmu2.impl.Xmu2PackageImpl;

import edu.ustb.sei.mde.xmu2.pattern.ObjectPatternExpression;
import edu.ustb.sei.mde.xmu2.pattern.Pattern;
import edu.ustb.sei.mde.xmu2.pattern.PatternExpression;
import edu.ustb.sei.mde.xmu2.pattern.PatternFactory;
import edu.ustb.sei.mde.xmu2.pattern.PatternNode;
import edu.ustb.sei.mde.xmu2.pattern.PatternPackage;
import edu.ustb.sei.mde.xmu2.pattern.PropertyPatternExpression;

import edu.ustb.sei.mde.xmu2.pattern.ReflectiveObjectPatternExpression;
import edu.ustb.sei.mde.xmu2.pattern.ReflectivePatternNode;
import edu.ustb.sei.mde.xmu2.pattern.ReflectivePropertyPatternExpression;
import edu.ustb.sei.mde.xmu2.statement.StatementPackage;

import edu.ustb.sei.mde.xmu2.statement.impl.StatementPackageImpl;

import edu.ustb.sei.mde.xmu2common.Xmu2commonPackage;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class PatternPackageImpl extends EPackageImpl implements PatternPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass patternEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass patternNodeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass patternExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass objectPatternExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass propertyPatternExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass reflectivePatternNodeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass reflectiveObjectPatternExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass reflectivePropertyPatternExpressionEClass = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see edu.ustb.sei.mde.xmu2.pattern.PatternPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private PatternPackageImpl() {
		super(eNS_URI, PatternFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link PatternPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static PatternPackage init() {
		if (isInited) return (PatternPackage)EPackage.Registry.INSTANCE.getEPackage(PatternPackage.eNS_URI);

		// Obtain or create and register package
		PatternPackageImpl thePatternPackage = (PatternPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof PatternPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new PatternPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		Xmu2commonPackage.eINSTANCE.eClass();

		// Obtain or create and register interdependencies
		Xmu2PackageImpl theXmu2Package = (Xmu2PackageImpl)(EPackage.Registry.INSTANCE.getEPackage(Xmu2Package.eNS_URI) instanceof Xmu2PackageImpl ? EPackage.Registry.INSTANCE.getEPackage(Xmu2Package.eNS_URI) : Xmu2Package.eINSTANCE);
		StatementPackageImpl theStatementPackage = (StatementPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(StatementPackage.eNS_URI) instanceof StatementPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(StatementPackage.eNS_URI) : StatementPackage.eINSTANCE);
		ExpressionPackageImpl theExpressionPackage = (ExpressionPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ExpressionPackage.eNS_URI) instanceof ExpressionPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ExpressionPackage.eNS_URI) : ExpressionPackage.eINSTANCE);

		// Create package meta-data objects
		thePatternPackage.createPackageContents();
		theXmu2Package.createPackageContents();
		theStatementPackage.createPackageContents();
		theExpressionPackage.createPackageContents();

		// Initialize created meta-data
		thePatternPackage.initializePackageContents();
		theXmu2Package.initializePackageContents();
		theStatementPackage.initializePackageContents();
		theExpressionPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		thePatternPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(PatternPackage.eNS_URI, thePatternPackage);
		return thePatternPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPattern() {
		return patternEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPattern_Root() {
		return (EReference)patternEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPattern_Guard() {
		return (EReference)patternEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPatternNode() {
		return patternNodeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPatternNode_Variable() {
		return (EReference)patternNodeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPatternNode_Expressions() {
		return (EReference)patternNodeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPatternExpression() {
		return patternExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPatternExpression_OwnerNode() {
		return (EReference)patternExpressionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPatternExpression_Feature() {
		return (EReference)patternExpressionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPatternExpression_Selector() {
		return (EReference)patternExpressionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPatternExpression_Position() {
		return (EReference)patternExpressionEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPatternExpression_Nullable() {
		return (EAttribute)patternExpressionEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getObjectPatternExpression() {
		return objectPatternExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getObjectPatternExpression_TargetNode() {
		return (EReference)objectPatternExpressionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPropertyPatternExpression() {
		return propertyPatternExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPropertyPatternExpression_TargetExpression() {
		return (EReference)propertyPatternExpressionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getReflectivePatternNode() {
		return reflectivePatternNodeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getReflectiveObjectPatternExpression() {
		return reflectiveObjectPatternExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getReflectivePropertyPatternExpression() {
		return reflectivePropertyPatternExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PatternFactory getPatternFactory() {
		return (PatternFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		patternEClass = createEClass(PATTERN);
		createEReference(patternEClass, PATTERN__ROOT);
		createEReference(patternEClass, PATTERN__GUARD);

		patternNodeEClass = createEClass(PATTERN_NODE);
		createEReference(patternNodeEClass, PATTERN_NODE__VARIABLE);
		createEReference(patternNodeEClass, PATTERN_NODE__EXPRESSIONS);

		patternExpressionEClass = createEClass(PATTERN_EXPRESSION);
		createEReference(patternExpressionEClass, PATTERN_EXPRESSION__OWNER_NODE);
		createEReference(patternExpressionEClass, PATTERN_EXPRESSION__FEATURE);
		createEReference(patternExpressionEClass, PATTERN_EXPRESSION__SELECTOR);
		createEReference(patternExpressionEClass, PATTERN_EXPRESSION__POSITION);
		createEAttribute(patternExpressionEClass, PATTERN_EXPRESSION__NULLABLE);

		objectPatternExpressionEClass = createEClass(OBJECT_PATTERN_EXPRESSION);
		createEReference(objectPatternExpressionEClass, OBJECT_PATTERN_EXPRESSION__TARGET_NODE);

		propertyPatternExpressionEClass = createEClass(PROPERTY_PATTERN_EXPRESSION);
		createEReference(propertyPatternExpressionEClass, PROPERTY_PATTERN_EXPRESSION__TARGET_EXPRESSION);

		reflectivePatternNodeEClass = createEClass(REFLECTIVE_PATTERN_NODE);

		reflectiveObjectPatternExpressionEClass = createEClass(REFLECTIVE_OBJECT_PATTERN_EXPRESSION);

		reflectivePropertyPatternExpressionEClass = createEClass(REFLECTIVE_PROPERTY_PATTERN_EXPRESSION);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		ExpressionPackage theExpressionPackage = (ExpressionPackage)EPackage.Registry.INSTANCE.getEPackage(ExpressionPackage.eNS_URI);
		Xmu2Package theXmu2Package = (Xmu2Package)EPackage.Registry.INSTANCE.getEPackage(Xmu2Package.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		objectPatternExpressionEClass.getESuperTypes().add(this.getPatternExpression());
		propertyPatternExpressionEClass.getESuperTypes().add(this.getPatternExpression());
		reflectivePatternNodeEClass.getESuperTypes().add(this.getPatternNode());
		reflectivePatternNodeEClass.getESuperTypes().add(theXmu2Package.getReflectiveAPI());
		reflectiveObjectPatternExpressionEClass.getESuperTypes().add(this.getObjectPatternExpression());
		reflectiveObjectPatternExpressionEClass.getESuperTypes().add(theXmu2Package.getReflectiveAPI());
		reflectivePropertyPatternExpressionEClass.getESuperTypes().add(this.getPropertyPatternExpression());
		reflectivePropertyPatternExpressionEClass.getESuperTypes().add(theXmu2Package.getReflectiveAPI());

		// Initialize classes and features; add operations and parameters
		initEClass(patternEClass, Pattern.class, "Pattern", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPattern_Root(), this.getPatternNode(), null, "root", null, 1, 1, Pattern.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPattern_Guard(), theExpressionPackage.getExpression(), null, "guard", null, 0, 1, Pattern.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(patternNodeEClass, PatternNode.class, "PatternNode", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPatternNode_Variable(), theXmu2Package.getVariableDeclaration(), null, "variable", null, 1, 1, PatternNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPatternNode_Expressions(), this.getPatternExpression(), this.getPatternExpression_OwnerNode(), "expressions", null, 0, -1, PatternNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(patternExpressionEClass, PatternExpression.class, "PatternExpression", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPatternExpression_OwnerNode(), this.getPatternNode(), this.getPatternNode_Expressions(), "ownerNode", null, 1, 1, PatternExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPatternExpression_Feature(), ecorePackage.getEStructuralFeature(), null, "feature", null, 1, 1, PatternExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPatternExpression_Selector(), theExpressionPackage.getLoopPath(), null, "selector", null, 0, 1, PatternExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPatternExpression_Position(), theExpressionPackage.getPositionPath(), null, "position", null, 0, 1, PatternExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPatternExpression_Nullable(), ecorePackage.getEBoolean(), "nullable", "false", 1, 1, PatternExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(objectPatternExpressionEClass, ObjectPatternExpression.class, "ObjectPatternExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getObjectPatternExpression_TargetNode(), this.getPatternNode(), null, "targetNode", null, 1, 1, ObjectPatternExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(propertyPatternExpressionEClass, PropertyPatternExpression.class, "PropertyPatternExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPropertyPatternExpression_TargetExpression(), theExpressionPackage.getExpression(), null, "targetExpression", null, 1, 1, PropertyPatternExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(reflectivePatternNodeEClass, ReflectivePatternNode.class, "ReflectivePatternNode", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(reflectiveObjectPatternExpressionEClass, ReflectiveObjectPatternExpression.class, "ReflectiveObjectPatternExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(reflectivePropertyPatternExpressionEClass, ReflectivePropertyPatternExpression.class, "ReflectivePropertyPatternExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
	}

} //PatternPackageImpl
