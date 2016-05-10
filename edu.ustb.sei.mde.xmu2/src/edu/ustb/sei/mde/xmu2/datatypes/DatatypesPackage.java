/**
 */
package edu.ustb.sei.mde.xmu2.datatypes;

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
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see edu.ustb.sei.mde.xmu2.datatypes.DatatypesFactory
 * @model kind="package"
 * @generated
 */
public interface DatatypesPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "datatypes";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.ustb.edu.cn/sei/mde/datatypes";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "datatypes";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	DatatypesPackage eINSTANCE = edu.ustb.sei.mde.xmu2.datatypes.impl.DatatypesPackageImpl.init();

	/**
	 * The meta object id for the '{@link edu.ustb.sei.mde.xmu2.datatypes.OclCollection <em>Ocl Collection</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.ustb.sei.mde.xmu2.datatypes.OclCollection
	 * @see edu.ustb.sei.mde.xmu2.datatypes.impl.DatatypesPackageImpl#getOclCollection()
	 * @generated
	 */
	int OCL_COLLECTION = 0;

	/**
	 * The feature id for the '<em><b>Elements</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OCL_COLLECTION__ELEMENTS = 0;

	/**
	 * The feature id for the '<em><b>Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OCL_COLLECTION__SIZE = 1;

	/**
	 * The number of structural features of the '<em>Ocl Collection</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OCL_COLLECTION_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Ocl Collection</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OCL_COLLECTION_OPERATION_COUNT = 0;


	/**
	 * The meta object id for the '{@link edu.ustb.sei.mde.xmu2.datatypes.impl.FeatureCollectionImpl <em>Feature Collection</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.ustb.sei.mde.xmu2.datatypes.impl.FeatureCollectionImpl
	 * @see edu.ustb.sei.mde.xmu2.datatypes.impl.DatatypesPackageImpl#getFeatureCollection()
	 * @generated
	 */
	int FEATURE_COLLECTION = 1;

	/**
	 * The feature id for the '<em><b>Elements</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_COLLECTION__ELEMENTS = OCL_COLLECTION__ELEMENTS;

	/**
	 * The feature id for the '<em><b>Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_COLLECTION__SIZE = OCL_COLLECTION__SIZE;

	/**
	 * The feature id for the '<em><b>Source Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_COLLECTION__SOURCE_ELEMENT = OCL_COLLECTION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Source Feature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_COLLECTION__SOURCE_FEATURE = OCL_COLLECTION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Feature Collection</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_COLLECTION_FEATURE_COUNT = OCL_COLLECTION_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Feature Collection</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_COLLECTION_OPERATION_COUNT = OCL_COLLECTION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.ustb.sei.mde.xmu2.datatypes.impl.ResourceImpl <em>Resource</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.ustb.sei.mde.xmu2.datatypes.impl.ResourceImpl
	 * @see edu.ustb.sei.mde.xmu2.datatypes.impl.DatatypesPackageImpl#getResource()
	 * @generated
	 */
	int RESOURCE = 2;

	/**
	 * The feature id for the '<em><b>Elements</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE__ELEMENTS = OCL_COLLECTION__ELEMENTS;

	/**
	 * The feature id for the '<em><b>Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE__SIZE = OCL_COLLECTION__SIZE;

	/**
	 * The feature id for the '<em><b>Tag</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE__TAG = OCL_COLLECTION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Resource</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_FEATURE_COUNT = OCL_COLLECTION_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Resource</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_OPERATION_COUNT = OCL_COLLECTION_OPERATION_COUNT + 0;

	/**
	 * Returns the meta object for class '{@link edu.ustb.sei.mde.xmu2.datatypes.OclCollection <em>Ocl Collection</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Ocl Collection</em>'.
	 * @see edu.ustb.sei.mde.xmu2.datatypes.OclCollection
	 * @generated
	 */
	EClass getOclCollection();

	/**
	 * Returns the meta object for the attribute list '{@link edu.ustb.sei.mde.xmu2.datatypes.OclCollection#getElements <em>Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Elements</em>'.
	 * @see edu.ustb.sei.mde.xmu2.datatypes.OclCollection#getElements()
	 * @see #getOclCollection()
	 * @generated
	 */
	EAttribute getOclCollection_Elements();

	/**
	 * Returns the meta object for the attribute '{@link edu.ustb.sei.mde.xmu2.datatypes.OclCollection#getSize <em>Size</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Size</em>'.
	 * @see edu.ustb.sei.mde.xmu2.datatypes.OclCollection#getSize()
	 * @see #getOclCollection()
	 * @generated
	 */
	EAttribute getOclCollection_Size();

	/**
	 * Returns the meta object for class '{@link edu.ustb.sei.mde.xmu2.datatypes.FeatureCollection <em>Feature Collection</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Feature Collection</em>'.
	 * @see edu.ustb.sei.mde.xmu2.datatypes.FeatureCollection
	 * @generated
	 */
	EClass getFeatureCollection();

	/**
	 * Returns the meta object for the reference '{@link edu.ustb.sei.mde.xmu2.datatypes.FeatureCollection#getSourceElement <em>Source Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Source Element</em>'.
	 * @see edu.ustb.sei.mde.xmu2.datatypes.FeatureCollection#getSourceElement()
	 * @see #getFeatureCollection()
	 * @generated
	 */
	EReference getFeatureCollection_SourceElement();

	/**
	 * Returns the meta object for the reference '{@link edu.ustb.sei.mde.xmu2.datatypes.FeatureCollection#getSourceFeature <em>Source Feature</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Source Feature</em>'.
	 * @see edu.ustb.sei.mde.xmu2.datatypes.FeatureCollection#getSourceFeature()
	 * @see #getFeatureCollection()
	 * @generated
	 */
	EReference getFeatureCollection_SourceFeature();

	/**
	 * Returns the meta object for class '{@link edu.ustb.sei.mde.xmu2.datatypes.Resource <em>Resource</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Resource</em>'.
	 * @see edu.ustb.sei.mde.xmu2.datatypes.Resource
	 * @generated
	 */
	EClass getResource();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	DatatypesFactory getDatatypesFactory();

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
		 * The meta object literal for the '{@link edu.ustb.sei.mde.xmu2.datatypes.OclCollection <em>Ocl Collection</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.ustb.sei.mde.xmu2.datatypes.OclCollection
		 * @see edu.ustb.sei.mde.xmu2.datatypes.impl.DatatypesPackageImpl#getOclCollection()
		 * @generated
		 */
		EClass OCL_COLLECTION = eINSTANCE.getOclCollection();

		/**
		 * The meta object literal for the '<em><b>Elements</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OCL_COLLECTION__ELEMENTS = eINSTANCE.getOclCollection_Elements();

		/**
		 * The meta object literal for the '<em><b>Size</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OCL_COLLECTION__SIZE = eINSTANCE.getOclCollection_Size();

		/**
		 * The meta object literal for the '{@link edu.ustb.sei.mde.xmu2.datatypes.impl.FeatureCollectionImpl <em>Feature Collection</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.ustb.sei.mde.xmu2.datatypes.impl.FeatureCollectionImpl
		 * @see edu.ustb.sei.mde.xmu2.datatypes.impl.DatatypesPackageImpl#getFeatureCollection()
		 * @generated
		 */
		EClass FEATURE_COLLECTION = eINSTANCE.getFeatureCollection();

		/**
		 * The meta object literal for the '<em><b>Source Element</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FEATURE_COLLECTION__SOURCE_ELEMENT = eINSTANCE.getFeatureCollection_SourceElement();

		/**
		 * The meta object literal for the '<em><b>Source Feature</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FEATURE_COLLECTION__SOURCE_FEATURE = eINSTANCE.getFeatureCollection_SourceFeature();

		/**
		 * The meta object literal for the '{@link edu.ustb.sei.mde.xmu2.datatypes.impl.ResourceImpl <em>Resource</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.ustb.sei.mde.xmu2.datatypes.impl.ResourceImpl
		 * @see edu.ustb.sei.mde.xmu2.datatypes.impl.DatatypesPackageImpl#getResource()
		 * @generated
		 */
		EClass RESOURCE = eINSTANCE.getResource();

	}

} //DatatypesPackage
