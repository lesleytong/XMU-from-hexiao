/**
 */
package edu.ustb.sei.mde.xmu2.datatypes.impl;

import static edu.ustb.sei.mde.xmu2.datatypes.DatatypesPackage.RESOURCE;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.impl.EPackageImpl;

import edu.ustb.sei.mde.xmu2.datatypes.DatatypesFactory;
import edu.ustb.sei.mde.xmu2.datatypes.DatatypesPackage;
import edu.ustb.sei.mde.xmu2.datatypes.FeatureCollection;
import edu.ustb.sei.mde.xmu2.datatypes.OclCollection;
import edu.ustb.sei.mde.xmu2.datatypes.Resource;
import edu.ustb.sei.mde.xmu2common.Xmu2commonPackage;
import edu.ustb.sei.mde.xmu2common.impl.Xmu2commonPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class DatatypesPackageImpl extends EPackageImpl implements DatatypesPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass oclCollectionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass featureCollectionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass resourceEClass = null;

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
	 * @see edu.ustb.sei.mde.xmu2.datatypes.DatatypesPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private DatatypesPackageImpl() {
		super(eNS_URI, DatatypesFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link DatatypesPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static DatatypesPackage init() {
		if (isInited) return (DatatypesPackage)EPackage.Registry.INSTANCE.getEPackage(DatatypesPackage.eNS_URI);

		// Obtain or create and register package
		DatatypesPackageImpl theDatatypesPackage = (DatatypesPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof DatatypesPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new DatatypesPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		EcorePackage.eINSTANCE.eClass();

		// Obtain or create and register interdependencies
		Xmu2commonPackageImpl theXmu2commonPackage = (Xmu2commonPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(Xmu2commonPackage.eNS_URI) instanceof Xmu2commonPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(Xmu2commonPackage.eNS_URI) : Xmu2commonPackage.eINSTANCE);

		// Create package meta-data objects
		theDatatypesPackage.createPackageContents();
		theXmu2commonPackage.createPackageContents();

		// Initialize created meta-data
		theDatatypesPackage.initializePackageContents();
		theXmu2commonPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theDatatypesPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(DatatypesPackage.eNS_URI, theDatatypesPackage);
		return theDatatypesPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOclCollection() {
		return oclCollectionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getOclCollection_Elements() {
		return (EAttribute)oclCollectionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getOclCollection_Size() {
		return (EAttribute)oclCollectionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFeatureCollection() {
		return featureCollectionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFeatureCollection_SourceElement() {
		return (EReference)featureCollectionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFeatureCollection_SourceFeature() {
		return (EReference)featureCollectionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getResource() {
		return resourceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DatatypesFactory getDatatypesFactory() {
		return (DatatypesFactory)getEFactoryInstance();
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
		oclCollectionEClass = createEClass(OCL_COLLECTION);
		createEAttribute(oclCollectionEClass, OCL_COLLECTION__ELEMENTS);
		createEAttribute(oclCollectionEClass, OCL_COLLECTION__SIZE);

		featureCollectionEClass = createEClass(FEATURE_COLLECTION);
		createEReference(featureCollectionEClass, FEATURE_COLLECTION__SOURCE_ELEMENT);
		createEReference(featureCollectionEClass, FEATURE_COLLECTION__SOURCE_FEATURE);

		resourceEClass = createEClass(RESOURCE);
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
		EcorePackage theEcorePackage = (EcorePackage)EPackage.Registry.INSTANCE.getEPackage(EcorePackage.eNS_URI);
		Xmu2commonPackage theXmu2commonPackage = (Xmu2commonPackage)EPackage.Registry.INSTANCE.getEPackage(Xmu2commonPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		featureCollectionEClass.getESuperTypes().add(this.getOclCollection());
		resourceEClass.getESuperTypes().add(this.getOclCollection());
		resourceEClass.getESuperTypes().add(theXmu2commonPackage.getDomainElement());

		// Initialize classes, features, and operations; add parameters
		initEClass(oclCollectionEClass, OclCollection.class, "OclCollection", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getOclCollection_Elements(), ecorePackage.getEJavaObject(), "elements", null, 0, -1, OclCollection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getOclCollection_Size(), theEcorePackage.getEInt(), "size", null, 1, 1, OclCollection.class, !IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

		initEClass(featureCollectionEClass, FeatureCollection.class, "FeatureCollection", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getFeatureCollection_SourceElement(), theEcorePackage.getEObject(), null, "sourceElement", null, 1, 1, FeatureCollection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFeatureCollection_SourceFeature(), theEcorePackage.getEStructuralFeature(), null, "sourceFeature", null, 1, 1, FeatureCollection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(resourceEClass, Resource.class, "Resource", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);
	}

} //DatatypesPackageImpl
