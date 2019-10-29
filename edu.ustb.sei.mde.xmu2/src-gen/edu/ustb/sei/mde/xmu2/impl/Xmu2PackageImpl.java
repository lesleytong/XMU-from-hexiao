/**
 */
package edu.ustb.sei.mde.xmu2.impl;

import edu.ustb.sei.mde.xmu2.AbstractRule;
import edu.ustb.sei.mde.xmu2.ArithmeticRule;
import edu.ustb.sei.mde.xmu2.ConcreteVariableDeclaration;
import edu.ustb.sei.mde.xmu2.EntryData;
import edu.ustb.sei.mde.xmu2.EntryPoint;
import edu.ustb.sei.mde.xmu2.ModelRule;
import edu.ustb.sei.mde.xmu2.NamedElement;
import edu.ustb.sei.mde.xmu2.Parameter;
import edu.ustb.sei.mde.xmu2.ReflectiveAPI;
import edu.ustb.sei.mde.xmu2.ReflectiveVariableDeclaration;
import edu.ustb.sei.mde.xmu2.TransformationModel;
import edu.ustb.sei.mde.xmu2.TypedElement;
import edu.ustb.sei.mde.xmu2.VariableDeclaration;
import edu.ustb.sei.mde.xmu2.Xmu2Factory;
import edu.ustb.sei.mde.xmu2.Xmu2Package;

import edu.ustb.sei.mde.xmu2.expression.ExpressionPackage;

import edu.ustb.sei.mde.xmu2.expression.impl.ExpressionPackageImpl;

import edu.ustb.sei.mde.xmu2.pattern.PatternPackage;

import edu.ustb.sei.mde.xmu2.pattern.impl.PatternPackageImpl;

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
public class Xmu2PackageImpl extends EPackageImpl implements Xmu2Package {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass namedElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass transformationModelEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass entryPointEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass entryDataEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass abstractRuleEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass parameterEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass modelRuleEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass arithmeticRuleEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass variableDeclarationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass concreteVariableDeclarationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass reflectiveVariableDeclarationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass typedElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass reflectiveAPIEClass = null;

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
	 * @see edu.ustb.sei.mde.xmu2.Xmu2Package#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private Xmu2PackageImpl() {
		super(eNS_URI, Xmu2Factory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link Xmu2Package#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static Xmu2Package init() {
		if (isInited) return (Xmu2Package)EPackage.Registry.INSTANCE.getEPackage(Xmu2Package.eNS_URI);

		// Obtain or create and register package
		Xmu2PackageImpl theXmu2Package = (Xmu2PackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof Xmu2PackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new Xmu2PackageImpl());

		isInited = true;

		// Initialize simple dependencies
		Xmu2commonPackage.eINSTANCE.eClass();

		// Obtain or create and register interdependencies
		StatementPackageImpl theStatementPackage = (StatementPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(StatementPackage.eNS_URI) instanceof StatementPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(StatementPackage.eNS_URI) : StatementPackage.eINSTANCE);
		PatternPackageImpl thePatternPackage = (PatternPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(PatternPackage.eNS_URI) instanceof PatternPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(PatternPackage.eNS_URI) : PatternPackage.eINSTANCE);
		ExpressionPackageImpl theExpressionPackage = (ExpressionPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ExpressionPackage.eNS_URI) instanceof ExpressionPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ExpressionPackage.eNS_URI) : ExpressionPackage.eINSTANCE);

		// Create package meta-data objects
		theXmu2Package.createPackageContents();
		theStatementPackage.createPackageContents();
		thePatternPackage.createPackageContents();
		theExpressionPackage.createPackageContents();

		// Initialize created meta-data
		theXmu2Package.initializePackageContents();
		theStatementPackage.initializePackageContents();
		thePatternPackage.initializePackageContents();
		theExpressionPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theXmu2Package.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(Xmu2Package.eNS_URI, theXmu2Package);
		return theXmu2Package;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNamedElement() {
		return namedElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNamedElement_Name() {
		return (EAttribute)namedElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTransformationModel() {
		return transformationModelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTransformationModel_Packages() {
		return (EReference)transformationModelEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTransformationModel_EntryPoints() {
		return (EReference)transformationModelEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTransformationModel_Rules() {
		return (EReference)transformationModelEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEntryPoint() {
		return entryPointEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEntryPoint_Rule() {
		return (EReference)entryPointEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEntryPoint_Parameters() {
		return (EReference)entryPointEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEntryData() {
		return entryDataEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEntryData_Index() {
		return (EAttribute)entryDataEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEntryData_Fragment() {
		return (EAttribute)entryDataEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAbstractRule() {
		return abstractRuleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAbstractRule_Parameters() {
		return (EReference)abstractRuleEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getParameter() {
		return parameterEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getModelRule() {
		return modelRuleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getModelRule_VariableDeclarations() {
		return (EReference)modelRuleEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getModelRule_Statement() {
		return (EReference)modelRuleEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getArithmeticRule() {
		return arithmeticRuleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getArithmeticRule_Statements() {
		return (EReference)arithmeticRuleEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getVariableDeclaration() {
		return variableDeclarationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getConcreteVariableDeclaration() {
		return concreteVariableDeclarationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getReflectiveVariableDeclaration() {
		return reflectiveVariableDeclarationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTypedElement() {
		return typedElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTypedElement_Type() {
		return (EReference)typedElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getReflectiveAPI() {
		return reflectiveAPIEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getReflectiveAPI_ReflectiveIdentifier() {
		return (EReference)reflectiveAPIEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getReflectiveAPI_Resolve() {
		return (EAttribute)reflectiveAPIEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Xmu2Factory getXmu2Factory() {
		return (Xmu2Factory)getEFactoryInstance();
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
		namedElementEClass = createEClass(NAMED_ELEMENT);
		createEAttribute(namedElementEClass, NAMED_ELEMENT__NAME);

		transformationModelEClass = createEClass(TRANSFORMATION_MODEL);
		createEReference(transformationModelEClass, TRANSFORMATION_MODEL__PACKAGES);
		createEReference(transformationModelEClass, TRANSFORMATION_MODEL__ENTRY_POINTS);
		createEReference(transformationModelEClass, TRANSFORMATION_MODEL__RULES);

		entryPointEClass = createEClass(ENTRY_POINT);
		createEReference(entryPointEClass, ENTRY_POINT__RULE);
		createEReference(entryPointEClass, ENTRY_POINT__PARAMETERS);

		entryDataEClass = createEClass(ENTRY_DATA);
		createEAttribute(entryDataEClass, ENTRY_DATA__INDEX);
		createEAttribute(entryDataEClass, ENTRY_DATA__FRAGMENT);

		abstractRuleEClass = createEClass(ABSTRACT_RULE);
		createEReference(abstractRuleEClass, ABSTRACT_RULE__PARAMETERS);

		parameterEClass = createEClass(PARAMETER);

		modelRuleEClass = createEClass(MODEL_RULE);
		createEReference(modelRuleEClass, MODEL_RULE__VARIABLE_DECLARATIONS);
		createEReference(modelRuleEClass, MODEL_RULE__STATEMENT);

		arithmeticRuleEClass = createEClass(ARITHMETIC_RULE);
		createEReference(arithmeticRuleEClass, ARITHMETIC_RULE__STATEMENTS);

		variableDeclarationEClass = createEClass(VARIABLE_DECLARATION);

		concreteVariableDeclarationEClass = createEClass(CONCRETE_VARIABLE_DECLARATION);

		reflectiveVariableDeclarationEClass = createEClass(REFLECTIVE_VARIABLE_DECLARATION);

		typedElementEClass = createEClass(TYPED_ELEMENT);
		createEReference(typedElementEClass, TYPED_ELEMENT__TYPE);

		reflectiveAPIEClass = createEClass(REFLECTIVE_API);
		createEReference(reflectiveAPIEClass, REFLECTIVE_API__REFLECTIVE_IDENTIFIER);
		createEAttribute(reflectiveAPIEClass, REFLECTIVE_API__RESOLVE);
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
		StatementPackage theStatementPackage = (StatementPackage)EPackage.Registry.INSTANCE.getEPackage(StatementPackage.eNS_URI);
		PatternPackage thePatternPackage = (PatternPackage)EPackage.Registry.INSTANCE.getEPackage(PatternPackage.eNS_URI);
		ExpressionPackage theExpressionPackage = (ExpressionPackage)EPackage.Registry.INSTANCE.getEPackage(ExpressionPackage.eNS_URI);
		Xmu2commonPackage theXmu2commonPackage = (Xmu2commonPackage)EPackage.Registry.INSTANCE.getEPackage(Xmu2commonPackage.eNS_URI);

		// Add subpackages
		getESubpackages().add(theStatementPackage);
		getESubpackages().add(thePatternPackage);
		getESubpackages().add(theExpressionPackage);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		transformationModelEClass.getESuperTypes().add(theXmu2commonPackage.getNamedElement());
		entryDataEClass.getESuperTypes().add(theXmu2commonPackage.getDomainElement());
		abstractRuleEClass.getESuperTypes().add(theXmu2commonPackage.getNamedElement());
		parameterEClass.getESuperTypes().add(theXmu2commonPackage.getNamedElement());
		parameterEClass.getESuperTypes().add(theXmu2commonPackage.getDomainElement());
		parameterEClass.getESuperTypes().add(this.getTypedElement());
		modelRuleEClass.getESuperTypes().add(this.getAbstractRule());
		arithmeticRuleEClass.getESuperTypes().add(this.getAbstractRule());
		variableDeclarationEClass.getESuperTypes().add(theXmu2commonPackage.getNamedElement());
		variableDeclarationEClass.getESuperTypes().add(this.getTypedElement());
		concreteVariableDeclarationEClass.getESuperTypes().add(this.getVariableDeclaration());
		reflectiveVariableDeclarationEClass.getESuperTypes().add(this.getVariableDeclaration());

		// Initialize classes and features; add operations and parameters
		initEClass(namedElementEClass, NamedElement.class, "NamedElement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getNamedElement_Name(), ecorePackage.getEString(), "name", null, 1, 1, NamedElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(transformationModelEClass, TransformationModel.class, "TransformationModel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTransformationModel_Packages(), ecorePackage.getEPackage(), null, "packages", null, 0, -1, TransformationModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTransformationModel_EntryPoints(), this.getEntryPoint(), null, "entryPoints", null, 0, -1, TransformationModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTransformationModel_Rules(), this.getAbstractRule(), null, "rules", null, 0, -1, TransformationModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(entryPointEClass, EntryPoint.class, "EntryPoint", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getEntryPoint_Rule(), this.getModelRule(), null, "rule", null, 1, 1, EntryPoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEntryPoint_Parameters(), this.getEntryData(), null, "parameters", null, 1, -1, EntryPoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(entryDataEClass, EntryData.class, "EntryData", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getEntryData_Index(), ecorePackage.getEInt(), "index", null, 1, 1, EntryData.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEntryData_Fragment(), ecorePackage.getEString(), "fragment", null, 0, 1, EntryData.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(abstractRuleEClass, AbstractRule.class, "AbstractRule", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAbstractRule_Parameters(), this.getParameter(), null, "parameters", null, 0, -1, AbstractRule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(parameterEClass, Parameter.class, "Parameter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(modelRuleEClass, ModelRule.class, "ModelRule", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getModelRule_VariableDeclarations(), this.getVariableDeclaration(), null, "variableDeclarations", null, 0, -1, ModelRule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getModelRule_Statement(), theStatementPackage.getStatement(), null, "statement", null, 0, 1, ModelRule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(arithmeticRuleEClass, ArithmeticRule.class, "ArithmeticRule", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getArithmeticRule_Statements(), theStatementPackage.getStatement(), null, "statements", null, 0, -1, ArithmeticRule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(variableDeclarationEClass, VariableDeclaration.class, "VariableDeclaration", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(concreteVariableDeclarationEClass, ConcreteVariableDeclaration.class, "ConcreteVariableDeclaration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(reflectiveVariableDeclarationEClass, ReflectiveVariableDeclaration.class, "ReflectiveVariableDeclaration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(typedElementEClass, TypedElement.class, "TypedElement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTypedElement_Type(), ecorePackage.getEClassifier(), null, "type", null, 1, 1, TypedElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(reflectiveAPIEClass, ReflectiveAPI.class, "ReflectiveAPI", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getReflectiveAPI_ReflectiveIdentifier(), theExpressionPackage.getExpression(), null, "reflectiveIdentifier", null, 1, 1, ReflectiveAPI.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getReflectiveAPI_Resolve(), ecorePackage.getEBoolean(), "resolve", "true", 1, 1, ReflectiveAPI.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //Xmu2PackageImpl
