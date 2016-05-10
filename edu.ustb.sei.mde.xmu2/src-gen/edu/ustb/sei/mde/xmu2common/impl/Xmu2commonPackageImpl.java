/**
 */
package edu.ustb.sei.mde.xmu2common.impl;

import edu.ustb.sei.mde.xmu2common.AdditiveOperator;
import edu.ustb.sei.mde.xmu2common.DomainElement;
import edu.ustb.sei.mde.xmu2common.DomainTag;
import edu.ustb.sei.mde.xmu2common.LoopOperator;
import edu.ustb.sei.mde.xmu2common.MultiplicativeOperator;
import edu.ustb.sei.mde.xmu2common.NamedElement;
import edu.ustb.sei.mde.xmu2common.PositionOperator;
import edu.ustb.sei.mde.xmu2common.RelationalOperator;
import edu.ustb.sei.mde.xmu2common.UnaryOperator;
import edu.ustb.sei.mde.xmu2common.Xmu2commonFactory;
import edu.ustb.sei.mde.xmu2common.Xmu2commonPackage;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class Xmu2commonPackageImpl extends EPackageImpl implements Xmu2commonPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass domainElementEClass = null;

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
	private EEnum domainTagEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum additiveOperatorEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum multiplicativeOperatorEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum relationalOperatorEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum unaryOperatorEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum loopOperatorEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum positionOperatorEEnum = null;

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
	 * @see edu.ustb.sei.mde.xmu2common.Xmu2commonPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private Xmu2commonPackageImpl() {
		super(eNS_URI, Xmu2commonFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link Xmu2commonPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static Xmu2commonPackage init() {
		if (isInited) return (Xmu2commonPackage)EPackage.Registry.INSTANCE.getEPackage(Xmu2commonPackage.eNS_URI);

		// Obtain or create and register package
		Xmu2commonPackageImpl theXmu2commonPackage = (Xmu2commonPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof Xmu2commonPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new Xmu2commonPackageImpl());

		isInited = true;

		// Create package meta-data objects
		theXmu2commonPackage.createPackageContents();

		// Initialize created meta-data
		theXmu2commonPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theXmu2commonPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(Xmu2commonPackage.eNS_URI, theXmu2commonPackage);
		return theXmu2commonPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDomainElement() {
		return domainElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDomainElement_Tag() {
		return (EAttribute)domainElementEClass.getEStructuralFeatures().get(0);
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
	public EEnum getDomainTag() {
		return domainTagEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getAdditiveOperator() {
		return additiveOperatorEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getMultiplicativeOperator() {
		return multiplicativeOperatorEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getRelationalOperator() {
		return relationalOperatorEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getUnaryOperator() {
		return unaryOperatorEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getLoopOperator() {
		return loopOperatorEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getPositionOperator() {
		return positionOperatorEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Xmu2commonFactory getXmu2commonFactory() {
		return (Xmu2commonFactory)getEFactoryInstance();
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
		domainElementEClass = createEClass(DOMAIN_ELEMENT);
		createEAttribute(domainElementEClass, DOMAIN_ELEMENT__TAG);

		namedElementEClass = createEClass(NAMED_ELEMENT);
		createEAttribute(namedElementEClass, NAMED_ELEMENT__NAME);

		// Create enums
		domainTagEEnum = createEEnum(DOMAIN_TAG);
		additiveOperatorEEnum = createEEnum(ADDITIVE_OPERATOR);
		multiplicativeOperatorEEnum = createEEnum(MULTIPLICATIVE_OPERATOR);
		relationalOperatorEEnum = createEEnum(RELATIONAL_OPERATOR);
		unaryOperatorEEnum = createEEnum(UNARY_OPERATOR);
		loopOperatorEEnum = createEEnum(LOOP_OPERATOR);
		positionOperatorEEnum = createEEnum(POSITION_OPERATOR);
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

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes

		// Initialize classes, features, and operations; add parameters
		initEClass(domainElementEClass, DomainElement.class, "DomainElement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDomainElement_Tag(), this.getDomainTag(), "tag", null, 0, 1, DomainElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(namedElementEClass, NamedElement.class, "NamedElement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getNamedElement_Name(), ecorePackage.getEString(), "name", null, 1, 1, NamedElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(domainTagEEnum, DomainTag.class, "DomainTag");
		addEEnumLiteral(domainTagEEnum, DomainTag.NORMAL);
		addEEnumLiteral(domainTagEEnum, DomainTag.SOURCE);
		addEEnumLiteral(domainTagEEnum, DomainTag.VIEW);
		addEEnumLiteral(domainTagEEnum, DomainTag.UPDATED_SOURCE);

		initEEnum(additiveOperatorEEnum, AdditiveOperator.class, "AdditiveOperator");
		addEEnumLiteral(additiveOperatorEEnum, AdditiveOperator.ADD);
		addEEnumLiteral(additiveOperatorEEnum, AdditiveOperator.SUB);
		addEEnumLiteral(additiveOperatorEEnum, AdditiveOperator.APPEND);

		initEEnum(multiplicativeOperatorEEnum, MultiplicativeOperator.class, "MultiplicativeOperator");
		addEEnumLiteral(multiplicativeOperatorEEnum, MultiplicativeOperator.MUL);
		addEEnumLiteral(multiplicativeOperatorEEnum, MultiplicativeOperator.DIV);

		initEEnum(relationalOperatorEEnum, RelationalOperator.class, "RelationalOperator");
		addEEnumLiteral(relationalOperatorEEnum, RelationalOperator.EQUAL);
		addEEnumLiteral(relationalOperatorEEnum, RelationalOperator.LESS);
		addEEnumLiteral(relationalOperatorEEnum, RelationalOperator.LESS_EQUAL);
		addEEnumLiteral(relationalOperatorEEnum, RelationalOperator.GREATER);
		addEEnumLiteral(relationalOperatorEEnum, RelationalOperator.GREATER_EQUAL);

		initEEnum(unaryOperatorEEnum, UnaryOperator.class, "UnaryOperator");
		addEEnumLiteral(unaryOperatorEEnum, UnaryOperator.NOT);
		addEEnumLiteral(unaryOperatorEEnum, UnaryOperator.MINUS);

		initEEnum(loopOperatorEEnum, LoopOperator.class, "LoopOperator");
		addEEnumLiteral(loopOperatorEEnum, LoopOperator.SELECT);
		addEEnumLiteral(loopOperatorEEnum, LoopOperator.FOR_ALL);
		addEEnumLiteral(loopOperatorEEnum, LoopOperator.EXISTS);

		initEEnum(positionOperatorEEnum, PositionOperator.class, "PositionOperator");
		addEEnumLiteral(positionOperatorEEnum, PositionOperator.FIRST);
		addEEnumLiteral(positionOperatorEEnum, PositionOperator.LAST);
		addEEnumLiteral(positionOperatorEEnum, PositionOperator.AT);

		// Create resource
		createResource(eNS_URI);
	}

} //Xmu2commonPackageImpl
