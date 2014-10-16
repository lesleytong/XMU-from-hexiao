/**
 */
package edu.ustb.sei.mde.morel;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;

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
 * @see edu.ustb.sei.mde.morel.MorelFactory
 * @model kind="package"
 * @generated
 */
public interface MorelPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "morel";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.ustb.edu.cn/sei/mde/morel";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "morel";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	MorelPackage eINSTANCE = edu.ustb.sei.mde.morel.impl.MorelPackageImpl.init();

	/**
	 * The meta object id for the '{@link edu.ustb.sei.mde.morel.impl.NamedElementImpl <em>Named Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.ustb.sei.mde.morel.impl.NamedElementImpl
	 * @see edu.ustb.sei.mde.morel.impl.MorelPackageImpl#getNamedElement()
	 * @generated
	 */
	int NAMED_ELEMENT = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_ELEMENT__NAME = 0;

	/**
	 * The number of structural features of the '<em>Named Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_ELEMENT_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Named Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_ELEMENT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link edu.ustb.sei.mde.morel.impl.SectionImpl <em>Section</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.ustb.sei.mde.morel.impl.SectionImpl
	 * @see edu.ustb.sei.mde.morel.impl.MorelPackageImpl#getSection()
	 * @generated
	 */
	int SECTION = 1;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SECTION__TYPE = 0;

	/**
	 * The number of structural features of the '<em>Section</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SECTION_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Section</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SECTION_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link edu.ustb.sei.mde.morel.impl.PatternImpl <em>Pattern</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.ustb.sei.mde.morel.impl.PatternImpl
	 * @see edu.ustb.sei.mde.morel.impl.MorelPackageImpl#getPattern()
	 * @generated
	 */
	int PATTERN = 2;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN__TYPE = SECTION__TYPE;

	/**
	 * The feature id for the '<em><b>Variables</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN__VARIABLES = SECTION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Link Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN__LINK_CONSTRAINTS = SECTION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Statements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN__STATEMENTS = SECTION_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Pattern</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN_FEATURE_COUNT = SECTION_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Pattern</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN_OPERATION_COUNT = SECTION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.ustb.sei.mde.morel.impl.ClauseImpl <em>Clause</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.ustb.sei.mde.morel.impl.ClauseImpl
	 * @see edu.ustb.sei.mde.morel.impl.MorelPackageImpl#getClause()
	 * @generated
	 */
	int CLAUSE = 3;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLAUSE__TYPE = SECTION__TYPE;

	/**
	 * The number of structural features of the '<em>Clause</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLAUSE_FEATURE_COUNT = SECTION_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Clause</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLAUSE_OPERATION_COUNT = SECTION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.ustb.sei.mde.morel.impl.VariableImpl <em>Variable</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.ustb.sei.mde.morel.impl.VariableImpl
	 * @see edu.ustb.sei.mde.morel.impl.MorelPackageImpl#getVariable()
	 * @generated
	 */
	int VARIABLE = 4;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The number of structural features of the '<em>Variable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Variable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_OPERATION_COUNT = NAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.ustb.sei.mde.morel.impl.ObjectVariableImpl <em>Object Variable</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.ustb.sei.mde.morel.impl.ObjectVariableImpl
	 * @see edu.ustb.sei.mde.morel.impl.MorelPackageImpl#getObjectVariable()
	 * @generated
	 */
	int OBJECT_VARIABLE = 5;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_VARIABLE__NAME = VARIABLE__NAME;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_VARIABLE__TYPE = VARIABLE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Model</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_VARIABLE__MODEL = VARIABLE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Object Variable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_VARIABLE_FEATURE_COUNT = VARIABLE_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Object Variable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_VARIABLE_OPERATION_COUNT = VARIABLE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.ustb.sei.mde.morel.impl.PrimitiveVariableImpl <em>Primitive Variable</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.ustb.sei.mde.morel.impl.PrimitiveVariableImpl
	 * @see edu.ustb.sei.mde.morel.impl.MorelPackageImpl#getPrimitiveVariable()
	 * @generated
	 */
	int PRIMITIVE_VARIABLE = 6;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_VARIABLE__NAME = VARIABLE__NAME;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_VARIABLE__TYPE = VARIABLE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Primitive Variable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_VARIABLE_FEATURE_COUNT = VARIABLE_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Primitive Variable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_VARIABLE_OPERATION_COUNT = VARIABLE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.ustb.sei.mde.morel.impl.LinkConstraintImpl <em>Link Constraint</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.ustb.sei.mde.morel.impl.LinkConstraintImpl
	 * @see edu.ustb.sei.mde.morel.impl.MorelPackageImpl#getLinkConstraint()
	 * @generated
	 */
	int LINK_CONSTRAINT = 7;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK_CONSTRAINT__SOURCE = 0;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK_CONSTRAINT__TARGET = 1;

	/**
	 * The number of structural features of the '<em>Link Constraint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK_CONSTRAINT_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Link Constraint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK_CONSTRAINT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link edu.ustb.sei.mde.morel.impl.SimpleLinkConstraintImpl <em>Simple Link Constraint</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.ustb.sei.mde.morel.impl.SimpleLinkConstraintImpl
	 * @see edu.ustb.sei.mde.morel.impl.MorelPackageImpl#getSimpleLinkConstraint()
	 * @generated
	 */
	int SIMPLE_LINK_CONSTRAINT = 8;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_LINK_CONSTRAINT__SOURCE = LINK_CONSTRAINT__SOURCE;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_LINK_CONSTRAINT__TARGET = LINK_CONSTRAINT__TARGET;

	/**
	 * The feature id for the '<em><b>Id</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_LINK_CONSTRAINT__ID = LINK_CONSTRAINT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Reference</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_LINK_CONSTRAINT__REFERENCE = LINK_CONSTRAINT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Simple Link Constraint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_LINK_CONSTRAINT_FEATURE_COUNT = LINK_CONSTRAINT_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Simple Link Constraint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_LINK_CONSTRAINT_OPERATION_COUNT = LINK_CONSTRAINT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.ustb.sei.mde.morel.impl.EnclosureLinkConstraintImpl <em>Enclosure Link Constraint</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.ustb.sei.mde.morel.impl.EnclosureLinkConstraintImpl
	 * @see edu.ustb.sei.mde.morel.impl.MorelPackageImpl#getEnclosureLinkConstraint()
	 * @generated
	 */
	int ENCLOSURE_LINK_CONSTRAINT = 9;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENCLOSURE_LINK_CONSTRAINT__SOURCE = LINK_CONSTRAINT__SOURCE;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENCLOSURE_LINK_CONSTRAINT__TARGET = LINK_CONSTRAINT__TARGET;

	/**
	 * The feature id for the '<em><b>Forward</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENCLOSURE_LINK_CONSTRAINT__FORWARD = LINK_CONSTRAINT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Types</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENCLOSURE_LINK_CONSTRAINT__TYPES = LINK_CONSTRAINT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Enclosure Link Constraint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENCLOSURE_LINK_CONSTRAINT_FEATURE_COUNT = LINK_CONSTRAINT_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Enclosure Link Constraint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENCLOSURE_LINK_CONSTRAINT_OPERATION_COUNT = LINK_CONSTRAINT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.ustb.sei.mde.morel.impl.PathConstraintImpl <em>Path Constraint</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.ustb.sei.mde.morel.impl.PathConstraintImpl
	 * @see edu.ustb.sei.mde.morel.impl.MorelPackageImpl#getPathConstraint()
	 * @generated
	 */
	int PATH_CONSTRAINT = 10;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATH_CONSTRAINT__SOURCE = LINK_CONSTRAINT__SOURCE;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATH_CONSTRAINT__TARGET = LINK_CONSTRAINT__TARGET;

	/**
	 * The feature id for the '<em><b>Min Length</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATH_CONSTRAINT__MIN_LENGTH = LINK_CONSTRAINT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Max Length</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATH_CONSTRAINT__MAX_LENGTH = LINK_CONSTRAINT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Path Variable</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATH_CONSTRAINT__PATH_VARIABLE = LINK_CONSTRAINT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>References</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATH_CONSTRAINT__REFERENCES = LINK_CONSTRAINT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Types</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATH_CONSTRAINT__TYPES = LINK_CONSTRAINT_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Path Constraint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATH_CONSTRAINT_FEATURE_COUNT = LINK_CONSTRAINT_FEATURE_COUNT + 5;

	/**
	 * The number of operations of the '<em>Path Constraint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATH_CONSTRAINT_OPERATION_COUNT = LINK_CONSTRAINT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.ustb.sei.mde.morel.impl.UnitImpl <em>Unit</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.ustb.sei.mde.morel.impl.UnitImpl
	 * @see edu.ustb.sei.mde.morel.impl.MorelPackageImpl#getUnit()
	 * @generated
	 */
	int UNIT = 14;

	/**
	 * The feature id for the '<em><b>Models</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIT__MODELS = 0;

	/**
	 * The feature id for the '<em><b>Data Types</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIT__DATA_TYPES = 1;

	/**
	 * The number of structural features of the '<em>Unit</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIT_FEATURE_COUNT = 2;

	/**
	 * The operation id for the '<em>Get Typed Model</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIT___GET_TYPED_MODEL__STRING = 0;

	/**
	 * The number of operations of the '<em>Unit</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIT_OPERATION_COUNT = 1;

	/**
	 * The meta object id for the '{@link edu.ustb.sei.mde.morel.impl.QueryModelImpl <em>Query Model</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.ustb.sei.mde.morel.impl.QueryModelImpl
	 * @see edu.ustb.sei.mde.morel.impl.MorelPackageImpl#getQueryModel()
	 * @generated
	 */
	int QUERY_MODEL = 11;

	/**
	 * The feature id for the '<em><b>Models</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUERY_MODEL__MODELS = UNIT__MODELS;

	/**
	 * The feature id for the '<em><b>Data Types</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUERY_MODEL__DATA_TYPES = UNIT__DATA_TYPES;

	/**
	 * The feature id for the '<em><b>Queries</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUERY_MODEL__QUERIES = UNIT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Query Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUERY_MODEL_FEATURE_COUNT = UNIT_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Get Typed Model</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUERY_MODEL___GET_TYPED_MODEL__STRING = UNIT___GET_TYPED_MODEL__STRING;

	/**
	 * The number of operations of the '<em>Query Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUERY_MODEL_OPERATION_COUNT = UNIT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.ustb.sei.mde.morel.impl.TypedModelImpl <em>Typed Model</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.ustb.sei.mde.morel.impl.TypedModelImpl
	 * @see edu.ustb.sei.mde.morel.impl.MorelPackageImpl#getTypedModel()
	 * @generated
	 */
	int TYPED_MODEL = 12;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_MODEL__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Package</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_MODEL__PACKAGE = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Typed Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_MODEL_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Typed Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_MODEL_OPERATION_COUNT = NAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.ustb.sei.mde.morel.impl.QueryImpl <em>Query</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.ustb.sei.mde.morel.impl.QueryImpl
	 * @see edu.ustb.sei.mde.morel.impl.MorelPackageImpl#getQuery()
	 * @generated
	 */
	int QUERY = 13;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUERY__TYPE = PATTERN__TYPE;

	/**
	 * The feature id for the '<em><b>Variables</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUERY__VARIABLES = PATTERN__VARIABLES;

	/**
	 * The feature id for the '<em><b>Link Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUERY__LINK_CONSTRAINTS = PATTERN__LINK_CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Statements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUERY__STATEMENTS = PATTERN__STATEMENTS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUERY__NAME = PATTERN_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Query</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUERY_FEATURE_COUNT = PATTERN_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Query</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUERY_OPERATION_COUNT = PATTERN_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.ustb.sei.mde.morel.impl.ExpressionImpl <em>Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.ustb.sei.mde.morel.impl.ExpressionImpl
	 * @see edu.ustb.sei.mde.morel.impl.MorelPackageImpl#getExpression()
	 * @generated
	 */
	int EXPRESSION = 15;

	/**
	 * The number of structural features of the '<em>Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION_FEATURE_COUNT = 0;

	/**
	 * The number of operations of the '<em>Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link edu.ustb.sei.mde.morel.impl.BooleanImpliesExpChildImpl <em>Boolean Implies Exp Child</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.ustb.sei.mde.morel.impl.BooleanImpliesExpChildImpl
	 * @see edu.ustb.sei.mde.morel.impl.MorelPackageImpl#getBooleanImpliesExpChild()
	 * @generated
	 */
	int BOOLEAN_IMPLIES_EXP_CHILD = 40;

	/**
	 * The number of structural features of the '<em>Boolean Implies Exp Child</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_IMPLIES_EXP_CHILD_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Boolean Implies Exp Child</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_IMPLIES_EXP_CHILD_OPERATION_COUNT = EXPRESSION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.ustb.sei.mde.morel.impl.BooleanOrExpChildImpl <em>Boolean Or Exp Child</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.ustb.sei.mde.morel.impl.BooleanOrExpChildImpl
	 * @see edu.ustb.sei.mde.morel.impl.MorelPackageImpl#getBooleanOrExpChild()
	 * @generated
	 */
	int BOOLEAN_OR_EXP_CHILD = 42;

	/**
	 * The number of structural features of the '<em>Boolean Or Exp Child</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_OR_EXP_CHILD_FEATURE_COUNT = BOOLEAN_IMPLIES_EXP_CHILD_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Boolean Or Exp Child</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_OR_EXP_CHILD_OPERATION_COUNT = BOOLEAN_IMPLIES_EXP_CHILD_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.ustb.sei.mde.morel.impl.BooleanAndExpChildImpl <em>Boolean And Exp Child</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.ustb.sei.mde.morel.impl.BooleanAndExpChildImpl
	 * @see edu.ustb.sei.mde.morel.impl.MorelPackageImpl#getBooleanAndExpChild()
	 * @generated
	 */
	int BOOLEAN_AND_EXP_CHILD = 44;

	/**
	 * The number of structural features of the '<em>Boolean And Exp Child</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_AND_EXP_CHILD_FEATURE_COUNT = BOOLEAN_OR_EXP_CHILD_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Boolean And Exp Child</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_AND_EXP_CHILD_OPERATION_COUNT = BOOLEAN_OR_EXP_CHILD_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.ustb.sei.mde.morel.impl.RelationalExpChildImpl <em>Relational Exp Child</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.ustb.sei.mde.morel.impl.RelationalExpChildImpl
	 * @see edu.ustb.sei.mde.morel.impl.MorelPackageImpl#getRelationalExpChild()
	 * @generated
	 */
	int RELATIONAL_EXP_CHILD = 46;

	/**
	 * The number of structural features of the '<em>Relational Exp Child</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATIONAL_EXP_CHILD_FEATURE_COUNT = BOOLEAN_AND_EXP_CHILD_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Relational Exp Child</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATIONAL_EXP_CHILD_OPERATION_COUNT = BOOLEAN_AND_EXP_CHILD_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.ustb.sei.mde.morel.impl.AdditiveExpChildImpl <em>Additive Exp Child</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.ustb.sei.mde.morel.impl.AdditiveExpChildImpl
	 * @see edu.ustb.sei.mde.morel.impl.MorelPackageImpl#getAdditiveExpChild()
	 * @generated
	 */
	int ADDITIVE_EXP_CHILD = 48;

	/**
	 * The number of structural features of the '<em>Additive Exp Child</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADDITIVE_EXP_CHILD_FEATURE_COUNT = RELATIONAL_EXP_CHILD_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Additive Exp Child</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADDITIVE_EXP_CHILD_OPERATION_COUNT = RELATIONAL_EXP_CHILD_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.ustb.sei.mde.morel.impl.MultiplicativeExpChildImpl <em>Multiplicative Exp Child</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.ustb.sei.mde.morel.impl.MultiplicativeExpChildImpl
	 * @see edu.ustb.sei.mde.morel.impl.MorelPackageImpl#getMultiplicativeExpChild()
	 * @generated
	 */
	int MULTIPLICATIVE_EXP_CHILD = 50;

	/**
	 * The number of structural features of the '<em>Multiplicative Exp Child</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTIPLICATIVE_EXP_CHILD_FEATURE_COUNT = ADDITIVE_EXP_CHILD_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Multiplicative Exp Child</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTIPLICATIVE_EXP_CHILD_OPERATION_COUNT = ADDITIVE_EXP_CHILD_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.ustb.sei.mde.morel.impl.UnaryExpChildImpl <em>Unary Exp Child</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.ustb.sei.mde.morel.impl.UnaryExpChildImpl
	 * @see edu.ustb.sei.mde.morel.impl.MorelPackageImpl#getUnaryExpChild()
	 * @generated
	 */
	int UNARY_EXP_CHILD = 52;

	/**
	 * The number of structural features of the '<em>Unary Exp Child</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNARY_EXP_CHILD_FEATURE_COUNT = MULTIPLICATIVE_EXP_CHILD_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Unary Exp Child</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNARY_EXP_CHILD_OPERATION_COUNT = MULTIPLICATIVE_EXP_CHILD_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.ustb.sei.mde.morel.impl.AtomicExpImpl <em>Atomic Exp</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.ustb.sei.mde.morel.impl.AtomicExpImpl
	 * @see edu.ustb.sei.mde.morel.impl.MorelPackageImpl#getAtomicExp()
	 * @generated
	 */
	int ATOMIC_EXP = 16;

	/**
	 * The feature id for the '<em><b>Path</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATOMIC_EXP__PATH = UNARY_EXP_CHILD_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Atomic Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATOMIC_EXP_FEATURE_COUNT = UNARY_EXP_CHILD_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Atomic Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATOMIC_EXP_OPERATION_COUNT = UNARY_EXP_CHILD_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.ustb.sei.mde.morel.impl.LiteralExpImpl <em>Literal Exp</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.ustb.sei.mde.morel.impl.LiteralExpImpl
	 * @see edu.ustb.sei.mde.morel.impl.MorelPackageImpl#getLiteralExp()
	 * @generated
	 */
	int LITERAL_EXP = 17;

	/**
	 * The feature id for the '<em><b>Path</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_EXP__PATH = ATOMIC_EXP__PATH;

	/**
	 * The number of structural features of the '<em>Literal Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_EXP_FEATURE_COUNT = ATOMIC_EXP_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Literal Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_EXP_OPERATION_COUNT = ATOMIC_EXP_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.ustb.sei.mde.morel.impl.StringLiteralExpImpl <em>String Literal Exp</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.ustb.sei.mde.morel.impl.StringLiteralExpImpl
	 * @see edu.ustb.sei.mde.morel.impl.MorelPackageImpl#getStringLiteralExp()
	 * @generated
	 */
	int STRING_LITERAL_EXP = 18;

	/**
	 * The feature id for the '<em><b>Path</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_LITERAL_EXP__PATH = LITERAL_EXP__PATH;

	/**
	 * The feature id for the '<em><b>String Symbol</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_LITERAL_EXP__STRING_SYMBOL = LITERAL_EXP_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>String Literal Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_LITERAL_EXP_FEATURE_COUNT = LITERAL_EXP_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>String Literal Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_LITERAL_EXP_OPERATION_COUNT = LITERAL_EXP_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.ustb.sei.mde.morel.impl.IntegerLiteralExpImpl <em>Integer Literal Exp</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.ustb.sei.mde.morel.impl.IntegerLiteralExpImpl
	 * @see edu.ustb.sei.mde.morel.impl.MorelPackageImpl#getIntegerLiteralExp()
	 * @generated
	 */
	int INTEGER_LITERAL_EXP = 19;

	/**
	 * The feature id for the '<em><b>Path</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_LITERAL_EXP__PATH = LITERAL_EXP__PATH;

	/**
	 * The feature id for the '<em><b>Integer Symbol</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_LITERAL_EXP__INTEGER_SYMBOL = LITERAL_EXP_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Integer Literal Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_LITERAL_EXP_FEATURE_COUNT = LITERAL_EXP_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Integer Literal Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_LITERAL_EXP_OPERATION_COUNT = LITERAL_EXP_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.ustb.sei.mde.morel.impl.RealLiteralExpImpl <em>Real Literal Exp</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.ustb.sei.mde.morel.impl.RealLiteralExpImpl
	 * @see edu.ustb.sei.mde.morel.impl.MorelPackageImpl#getRealLiteralExp()
	 * @generated
	 */
	int REAL_LITERAL_EXP = 20;

	/**
	 * The feature id for the '<em><b>Path</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REAL_LITERAL_EXP__PATH = LITERAL_EXP__PATH;

	/**
	 * The feature id for the '<em><b>Real Symbol</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REAL_LITERAL_EXP__REAL_SYMBOL = LITERAL_EXP_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Real Literal Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REAL_LITERAL_EXP_FEATURE_COUNT = LITERAL_EXP_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Real Literal Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REAL_LITERAL_EXP_OPERATION_COUNT = LITERAL_EXP_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.ustb.sei.mde.morel.impl.BooleanLiteralExpImpl <em>Boolean Literal Exp</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.ustb.sei.mde.morel.impl.BooleanLiteralExpImpl
	 * @see edu.ustb.sei.mde.morel.impl.MorelPackageImpl#getBooleanLiteralExp()
	 * @generated
	 */
	int BOOLEAN_LITERAL_EXP = 21;

	/**
	 * The feature id for the '<em><b>Path</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_LITERAL_EXP__PATH = LITERAL_EXP__PATH;

	/**
	 * The feature id for the '<em><b>Bool Symbol</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_LITERAL_EXP__BOOL_SYMBOL = LITERAL_EXP_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Boolean Literal Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_LITERAL_EXP_FEATURE_COUNT = LITERAL_EXP_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Boolean Literal Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_LITERAL_EXP_OPERATION_COUNT = LITERAL_EXP_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.ustb.sei.mde.morel.impl.UndefinedLiteralExpImpl <em>Undefined Literal Exp</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.ustb.sei.mde.morel.impl.UndefinedLiteralExpImpl
	 * @see edu.ustb.sei.mde.morel.impl.MorelPackageImpl#getUndefinedLiteralExp()
	 * @generated
	 */
	int UNDEFINED_LITERAL_EXP = 22;

	/**
	 * The feature id for the '<em><b>Path</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNDEFINED_LITERAL_EXP__PATH = LITERAL_EXP__PATH;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNDEFINED_LITERAL_EXP__VALUE = LITERAL_EXP_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Undefined Literal Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNDEFINED_LITERAL_EXP_FEATURE_COUNT = LITERAL_EXP_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Undefined Literal Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNDEFINED_LITERAL_EXP_OPERATION_COUNT = LITERAL_EXP_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.ustb.sei.mde.morel.impl.CollectionLiteralExpImpl <em>Collection Literal Exp</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.ustb.sei.mde.morel.impl.CollectionLiteralExpImpl
	 * @see edu.ustb.sei.mde.morel.impl.MorelPackageImpl#getCollectionLiteralExp()
	 * @generated
	 */
	int COLLECTION_LITERAL_EXP = 23;

	/**
	 * The feature id for the '<em><b>Path</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_LITERAL_EXP__PATH = LITERAL_EXP__PATH;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_LITERAL_EXP__TYPE = LITERAL_EXP_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Literals</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_LITERAL_EXP__LITERALS = LITERAL_EXP_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Collection Literal Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_LITERAL_EXP_FEATURE_COUNT = LITERAL_EXP_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Collection Literal Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_LITERAL_EXP_OPERATION_COUNT = LITERAL_EXP_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.ustb.sei.mde.morel.impl.EnumLiteralExpImpl <em>Enum Literal Exp</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.ustb.sei.mde.morel.impl.EnumLiteralExpImpl
	 * @see edu.ustb.sei.mde.morel.impl.MorelPackageImpl#getEnumLiteralExp()
	 * @generated
	 */
	int ENUM_LITERAL_EXP = 24;

	/**
	 * The feature id for the '<em><b>Path</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUM_LITERAL_EXP__PATH = LITERAL_EXP__PATH;

	/**
	 * The feature id for the '<em><b>Enum Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUM_LITERAL_EXP__ENUM_TYPE = LITERAL_EXP_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Enum Symbol</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUM_LITERAL_EXP__ENUM_SYMBOL = LITERAL_EXP_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Enum Literal Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUM_LITERAL_EXP_FEATURE_COUNT = LITERAL_EXP_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Enum Literal Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUM_LITERAL_EXP_OPERATION_COUNT = LITERAL_EXP_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.ustb.sei.mde.morel.impl.TypeLiteralExpImpl <em>Type Literal Exp</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.ustb.sei.mde.morel.impl.TypeLiteralExpImpl
	 * @see edu.ustb.sei.mde.morel.impl.MorelPackageImpl#getTypeLiteralExp()
	 * @generated
	 */
	int TYPE_LITERAL_EXP = 25;

	/**
	 * The feature id for the '<em><b>Path</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_LITERAL_EXP__PATH = LITERAL_EXP__PATH;

	/**
	 * The feature id for the '<em><b>Value</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_LITERAL_EXP__VALUE = LITERAL_EXP_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Type Literal Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_LITERAL_EXP_FEATURE_COUNT = LITERAL_EXP_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Type Literal Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_LITERAL_EXP_OPERATION_COUNT = LITERAL_EXP_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.ustb.sei.mde.morel.impl.VariableExpImpl <em>Variable Exp</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.ustb.sei.mde.morel.impl.VariableExpImpl
	 * @see edu.ustb.sei.mde.morel.impl.MorelPackageImpl#getVariableExp()
	 * @generated
	 */
	int VARIABLE_EXP = 26;

	/**
	 * The feature id for the '<em><b>Path</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_EXP__PATH = ATOMIC_EXP__PATH;

	/**
	 * The feature id for the '<em><b>Referred Variable</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_EXP__REFERRED_VARIABLE = ATOMIC_EXP_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Variable Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_EXP_FEATURE_COUNT = ATOMIC_EXP_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Variable Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_EXP_OPERATION_COUNT = ATOMIC_EXP_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.ustb.sei.mde.morel.impl.PredefinedVariableExpImpl <em>Predefined Variable Exp</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.ustb.sei.mde.morel.impl.PredefinedVariableExpImpl
	 * @see edu.ustb.sei.mde.morel.impl.MorelPackageImpl#getPredefinedVariableExp()
	 * @generated
	 */
	int PREDEFINED_VARIABLE_EXP = 27;

	/**
	 * The feature id for the '<em><b>Path</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREDEFINED_VARIABLE_EXP__PATH = ATOMIC_EXP__PATH;

	/**
	 * The feature id for the '<em><b>Variable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREDEFINED_VARIABLE_EXP__VARIABLE = ATOMIC_EXP_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Predefined Variable Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREDEFINED_VARIABLE_EXP_FEATURE_COUNT = ATOMIC_EXP_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Predefined Variable Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREDEFINED_VARIABLE_EXP_OPERATION_COUNT = ATOMIC_EXP_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.ustb.sei.mde.morel.impl.NestedExpImpl <em>Nested Exp</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.ustb.sei.mde.morel.impl.NestedExpImpl
	 * @see edu.ustb.sei.mde.morel.impl.MorelPackageImpl#getNestedExp()
	 * @generated
	 */
	int NESTED_EXP = 28;

	/**
	 * The feature id for the '<em><b>Path</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NESTED_EXP__PATH = ATOMIC_EXP__PATH;

	/**
	 * The feature id for the '<em><b>Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NESTED_EXP__EXPRESSION = ATOMIC_EXP_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Nested Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NESTED_EXP_FEATURE_COUNT = ATOMIC_EXP_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Nested Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NESTED_EXP_OPERATION_COUNT = ATOMIC_EXP_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.ustb.sei.mde.morel.impl.CallPathExpImpl <em>Call Path Exp</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.ustb.sei.mde.morel.impl.CallPathExpImpl
	 * @see edu.ustb.sei.mde.morel.impl.MorelPackageImpl#getCallPathExp()
	 * @generated
	 */
	int CALL_PATH_EXP = 29;

	/**
	 * The feature id for the '<em><b>Next</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALL_PATH_EXP__NEXT = 0;

	/**
	 * The number of structural features of the '<em>Call Path Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALL_PATH_EXP_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Call Path Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALL_PATH_EXP_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link edu.ustb.sei.mde.morel.impl.FeaturePathExpImpl <em>Feature Path Exp</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.ustb.sei.mde.morel.impl.FeaturePathExpImpl
	 * @see edu.ustb.sei.mde.morel.impl.MorelPackageImpl#getFeaturePathExp()
	 * @generated
	 */
	int FEATURE_PATH_EXP = 30;

	/**
	 * The feature id for the '<em><b>Next</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_PATH_EXP__NEXT = CALL_PATH_EXP__NEXT;

	/**
	 * The feature id for the '<em><b>Feature</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_PATH_EXP__FEATURE = CALL_PATH_EXP_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Feature Path Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_PATH_EXP_FEATURE_COUNT = CALL_PATH_EXP_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Feature Path Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_PATH_EXP_OPERATION_COUNT = CALL_PATH_EXP_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.ustb.sei.mde.morel.impl.OperationPathExpImpl <em>Operation Path Exp</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.ustb.sei.mde.morel.impl.OperationPathExpImpl
	 * @see edu.ustb.sei.mde.morel.impl.MorelPackageImpl#getOperationPathExp()
	 * @generated
	 */
	int OPERATION_PATH_EXP = 31;

	/**
	 * The feature id for the '<em><b>Next</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_PATH_EXP__NEXT = CALL_PATH_EXP__NEXT;

	/**
	 * The feature id for the '<em><b>Separator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_PATH_EXP__SEPARATOR = CALL_PATH_EXP_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Operation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_PATH_EXP__OPERATION = CALL_PATH_EXP_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_PATH_EXP__PARAMETERS = CALL_PATH_EXP_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Operation Path Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_PATH_EXP_FEATURE_COUNT = CALL_PATH_EXP_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Operation Path Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_PATH_EXP_OPERATION_COUNT = CALL_PATH_EXP_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.ustb.sei.mde.morel.impl.LoopPathExpImpl <em>Loop Path Exp</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.ustb.sei.mde.morel.impl.LoopPathExpImpl
	 * @see edu.ustb.sei.mde.morel.impl.MorelPackageImpl#getLoopPathExp()
	 * @generated
	 */
	int LOOP_PATH_EXP = 32;

	/**
	 * The feature id for the '<em><b>Next</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOP_PATH_EXP__NEXT = CALL_PATH_EXP__NEXT;

	/**
	 * The number of structural features of the '<em>Loop Path Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOP_PATH_EXP_FEATURE_COUNT = CALL_PATH_EXP_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Loop Path Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOP_PATH_EXP_OPERATION_COUNT = CALL_PATH_EXP_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.ustb.sei.mde.morel.impl.IteratorPathExpImpl <em>Iterator Path Exp</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.ustb.sei.mde.morel.impl.IteratorPathExpImpl
	 * @see edu.ustb.sei.mde.morel.impl.MorelPackageImpl#getIteratorPathExp()
	 * @generated
	 */
	int ITERATOR_PATH_EXP = 33;

	/**
	 * The feature id for the '<em><b>Next</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATOR_PATH_EXP__NEXT = LOOP_PATH_EXP__NEXT;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATOR_PATH_EXP__TYPE = LOOP_PATH_EXP_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>First Var</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATOR_PATH_EXP__FIRST_VAR = LOOP_PATH_EXP_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Second Var</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATOR_PATH_EXP__SECOND_VAR = LOOP_PATH_EXP_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Body Exp</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATOR_PATH_EXP__BODY_EXP = LOOP_PATH_EXP_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Iterator Path Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATOR_PATH_EXP_FEATURE_COUNT = LOOP_PATH_EXP_FEATURE_COUNT + 4;

	/**
	 * The number of operations of the '<em>Iterator Path Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATOR_PATH_EXP_OPERATION_COUNT = LOOP_PATH_EXP_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.ustb.sei.mde.morel.impl.LetExpImpl <em>Let Exp</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.ustb.sei.mde.morel.impl.LetExpImpl
	 * @see edu.ustb.sei.mde.morel.impl.MorelPackageImpl#getLetExp()
	 * @generated
	 */
	int LET_EXP = 34;

	/**
	 * The feature id for the '<em><b>Variables</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LET_EXP__VARIABLES = EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>In Exp</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LET_EXP__IN_EXP = EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Let Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LET_EXP_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Let Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LET_EXP_OPERATION_COUNT = EXPRESSION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.ustb.sei.mde.morel.impl.VariableWithInitImpl <em>Variable With Init</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.ustb.sei.mde.morel.impl.VariableWithInitImpl
	 * @see edu.ustb.sei.mde.morel.impl.MorelPackageImpl#getVariableWithInit()
	 * @generated
	 */
	int VARIABLE_WITH_INIT = 35;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_WITH_INIT__NAME = VARIABLE__NAME;

	/**
	 * The feature id for the '<em><b>Init Exp</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_WITH_INIT__INIT_EXP = VARIABLE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Variable With Init</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_WITH_INIT_FEATURE_COUNT = VARIABLE_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Variable With Init</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_WITH_INIT_OPERATION_COUNT = VARIABLE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.ustb.sei.mde.morel.impl.ObjectVariableWithInitImpl <em>Object Variable With Init</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.ustb.sei.mde.morel.impl.ObjectVariableWithInitImpl
	 * @see edu.ustb.sei.mde.morel.impl.MorelPackageImpl#getObjectVariableWithInit()
	 * @generated
	 */
	int OBJECT_VARIABLE_WITH_INIT = 36;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_VARIABLE_WITH_INIT__NAME = OBJECT_VARIABLE__NAME;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_VARIABLE_WITH_INIT__TYPE = OBJECT_VARIABLE__TYPE;

	/**
	 * The feature id for the '<em><b>Model</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_VARIABLE_WITH_INIT__MODEL = OBJECT_VARIABLE__MODEL;

	/**
	 * The feature id for the '<em><b>Init Exp</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_VARIABLE_WITH_INIT__INIT_EXP = OBJECT_VARIABLE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Object Variable With Init</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_VARIABLE_WITH_INIT_FEATURE_COUNT = OBJECT_VARIABLE_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Object Variable With Init</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_VARIABLE_WITH_INIT_OPERATION_COUNT = OBJECT_VARIABLE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.ustb.sei.mde.morel.impl.PrimitiveVariableWithInitImpl <em>Primitive Variable With Init</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.ustb.sei.mde.morel.impl.PrimitiveVariableWithInitImpl
	 * @see edu.ustb.sei.mde.morel.impl.MorelPackageImpl#getPrimitiveVariableWithInit()
	 * @generated
	 */
	int PRIMITIVE_VARIABLE_WITH_INIT = 37;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_VARIABLE_WITH_INIT__NAME = PRIMITIVE_VARIABLE__NAME;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_VARIABLE_WITH_INIT__TYPE = PRIMITIVE_VARIABLE__TYPE;

	/**
	 * The feature id for the '<em><b>Init Exp</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_VARIABLE_WITH_INIT__INIT_EXP = PRIMITIVE_VARIABLE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Primitive Variable With Init</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_VARIABLE_WITH_INIT_FEATURE_COUNT = PRIMITIVE_VARIABLE_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Primitive Variable With Init</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_VARIABLE_WITH_INIT_OPERATION_COUNT = PRIMITIVE_VARIABLE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.ustb.sei.mde.morel.impl.ConditionExpImpl <em>Condition Exp</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.ustb.sei.mde.morel.impl.ConditionExpImpl
	 * @see edu.ustb.sei.mde.morel.impl.MorelPackageImpl#getConditionExp()
	 * @generated
	 */
	int CONDITION_EXP = 38;

	/**
	 * The feature id for the '<em><b>Condition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITION_EXP__CONDITION = EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Then Branch</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITION_EXP__THEN_BRANCH = EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Else Branch</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITION_EXP__ELSE_BRANCH = EXPRESSION_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Condition Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITION_EXP_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Condition Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITION_EXP_OPERATION_COUNT = EXPRESSION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.ustb.sei.mde.morel.impl.BooleanImpliesExpImpl <em>Boolean Implies Exp</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.ustb.sei.mde.morel.impl.BooleanImpliesExpImpl
	 * @see edu.ustb.sei.mde.morel.impl.MorelPackageImpl#getBooleanImpliesExp()
	 * @generated
	 */
	int BOOLEAN_IMPLIES_EXP = 39;

	/**
	 * The feature id for the '<em><b>Left</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_IMPLIES_EXP__LEFT = EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Right</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_IMPLIES_EXP__RIGHT = EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Operator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_IMPLIES_EXP__OPERATOR = EXPRESSION_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Boolean Implies Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_IMPLIES_EXP_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Boolean Implies Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_IMPLIES_EXP_OPERATION_COUNT = EXPRESSION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.ustb.sei.mde.morel.impl.BooleanOrExpImpl <em>Boolean Or Exp</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.ustb.sei.mde.morel.impl.BooleanOrExpImpl
	 * @see edu.ustb.sei.mde.morel.impl.MorelPackageImpl#getBooleanOrExp()
	 * @generated
	 */
	int BOOLEAN_OR_EXP = 41;

	/**
	 * The feature id for the '<em><b>Children</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_OR_EXP__CHILDREN = BOOLEAN_IMPLIES_EXP_CHILD_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Operators</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_OR_EXP__OPERATORS = BOOLEAN_IMPLIES_EXP_CHILD_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Boolean Or Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_OR_EXP_FEATURE_COUNT = BOOLEAN_IMPLIES_EXP_CHILD_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Boolean Or Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_OR_EXP_OPERATION_COUNT = BOOLEAN_IMPLIES_EXP_CHILD_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.ustb.sei.mde.morel.impl.BooleanAndExpImpl <em>Boolean And Exp</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.ustb.sei.mde.morel.impl.BooleanAndExpImpl
	 * @see edu.ustb.sei.mde.morel.impl.MorelPackageImpl#getBooleanAndExp()
	 * @generated
	 */
	int BOOLEAN_AND_EXP = 43;

	/**
	 * The feature id for the '<em><b>Children</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_AND_EXP__CHILDREN = BOOLEAN_OR_EXP_CHILD_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Operators</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_AND_EXP__OPERATORS = BOOLEAN_OR_EXP_CHILD_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Boolean And Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_AND_EXP_FEATURE_COUNT = BOOLEAN_OR_EXP_CHILD_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Boolean And Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_AND_EXP_OPERATION_COUNT = BOOLEAN_OR_EXP_CHILD_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.ustb.sei.mde.morel.impl.RelationalExpImpl <em>Relational Exp</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.ustb.sei.mde.morel.impl.RelationalExpImpl
	 * @see edu.ustb.sei.mde.morel.impl.MorelPackageImpl#getRelationalExp()
	 * @generated
	 */
	int RELATIONAL_EXP = 45;

	/**
	 * The feature id for the '<em><b>Left</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATIONAL_EXP__LEFT = BOOLEAN_AND_EXP_CHILD_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Right</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATIONAL_EXP__RIGHT = BOOLEAN_AND_EXP_CHILD_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Operator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATIONAL_EXP__OPERATOR = BOOLEAN_AND_EXP_CHILD_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Relational Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATIONAL_EXP_FEATURE_COUNT = BOOLEAN_AND_EXP_CHILD_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Relational Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATIONAL_EXP_OPERATION_COUNT = BOOLEAN_AND_EXP_CHILD_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.ustb.sei.mde.morel.impl.AdditiveExpImpl <em>Additive Exp</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.ustb.sei.mde.morel.impl.AdditiveExpImpl
	 * @see edu.ustb.sei.mde.morel.impl.MorelPackageImpl#getAdditiveExp()
	 * @generated
	 */
	int ADDITIVE_EXP = 47;

	/**
	 * The feature id for the '<em><b>Children</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADDITIVE_EXP__CHILDREN = RELATIONAL_EXP_CHILD_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Operators</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADDITIVE_EXP__OPERATORS = RELATIONAL_EXP_CHILD_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Additive Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADDITIVE_EXP_FEATURE_COUNT = RELATIONAL_EXP_CHILD_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Additive Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADDITIVE_EXP_OPERATION_COUNT = RELATIONAL_EXP_CHILD_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.ustb.sei.mde.morel.impl.MultiplicativeExpImpl <em>Multiplicative Exp</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.ustb.sei.mde.morel.impl.MultiplicativeExpImpl
	 * @see edu.ustb.sei.mde.morel.impl.MorelPackageImpl#getMultiplicativeExp()
	 * @generated
	 */
	int MULTIPLICATIVE_EXP = 49;

	/**
	 * The feature id for the '<em><b>Children</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTIPLICATIVE_EXP__CHILDREN = ADDITIVE_EXP_CHILD_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Operators</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTIPLICATIVE_EXP__OPERATORS = ADDITIVE_EXP_CHILD_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Multiplicative Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTIPLICATIVE_EXP_FEATURE_COUNT = ADDITIVE_EXP_CHILD_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Multiplicative Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTIPLICATIVE_EXP_OPERATION_COUNT = ADDITIVE_EXP_CHILD_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.ustb.sei.mde.morel.impl.UnaryExpImpl <em>Unary Exp</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.ustb.sei.mde.morel.impl.UnaryExpImpl
	 * @see edu.ustb.sei.mde.morel.impl.MorelPackageImpl#getUnaryExp()
	 * @generated
	 */
	int UNARY_EXP = 51;

	/**
	 * The feature id for the '<em><b>Operator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNARY_EXP__OPERATOR = MULTIPLICATIVE_EXP_CHILD_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Child</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNARY_EXP__CHILD = MULTIPLICATIVE_EXP_CHILD_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Unary Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNARY_EXP_FEATURE_COUNT = MULTIPLICATIVE_EXP_CHILD_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Unary Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNARY_EXP_OPERATION_COUNT = MULTIPLICATIVE_EXP_CHILD_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.ustb.sei.mde.morel.impl.CollectionTypeImpl <em>Collection Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.ustb.sei.mde.morel.impl.CollectionTypeImpl
	 * @see edu.ustb.sei.mde.morel.impl.MorelPackageImpl#getCollectionType()
	 * @generated
	 */
	int COLLECTION_TYPE = 53;

	/**
	 * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_TYPE__EANNOTATIONS = EcorePackage.EDATA_TYPE__EANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_TYPE__NAME = EcorePackage.EDATA_TYPE__NAME;

	/**
	 * The feature id for the '<em><b>Instance Class Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_TYPE__INSTANCE_CLASS_NAME = EcorePackage.EDATA_TYPE__INSTANCE_CLASS_NAME;

	/**
	 * The feature id for the '<em><b>Instance Class</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_TYPE__INSTANCE_CLASS = EcorePackage.EDATA_TYPE__INSTANCE_CLASS;

	/**
	 * The feature id for the '<em><b>Default Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_TYPE__DEFAULT_VALUE = EcorePackage.EDATA_TYPE__DEFAULT_VALUE;

	/**
	 * The feature id for the '<em><b>Instance Type Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_TYPE__INSTANCE_TYPE_NAME = EcorePackage.EDATA_TYPE__INSTANCE_TYPE_NAME;

	/**
	 * The feature id for the '<em><b>EPackage</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_TYPE__EPACKAGE = EcorePackage.EDATA_TYPE__EPACKAGE;

	/**
	 * The feature id for the '<em><b>EType Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_TYPE__ETYPE_PARAMETERS = EcorePackage.EDATA_TYPE__ETYPE_PARAMETERS;

	/**
	 * The feature id for the '<em><b>Serializable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_TYPE__SERIALIZABLE = EcorePackage.EDATA_TYPE__SERIALIZABLE;

	/**
	 * The feature id for the '<em><b>Element Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_TYPE__ELEMENT_TYPE = EcorePackage.EDATA_TYPE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Collection Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_TYPE_FEATURE_COUNT = EcorePackage.EDATA_TYPE_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Get EAnnotation</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_TYPE___GET_EANNOTATION__STRING = EcorePackage.EDATA_TYPE___GET_EANNOTATION__STRING;

	/**
	 * The operation id for the '<em>Is Instance</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_TYPE___IS_INSTANCE__OBJECT = EcorePackage.EDATA_TYPE___IS_INSTANCE__OBJECT;

	/**
	 * The operation id for the '<em>Get Classifier ID</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_TYPE___GET_CLASSIFIER_ID = EcorePackage.EDATA_TYPE___GET_CLASSIFIER_ID;

	/**
	 * The number of operations of the '<em>Collection Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_TYPE_OPERATION_COUNT = EcorePackage.EDATA_TYPE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.ustb.sei.mde.morel.impl.OrderedSetTypeImpl <em>Ordered Set Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.ustb.sei.mde.morel.impl.OrderedSetTypeImpl
	 * @see edu.ustb.sei.mde.morel.impl.MorelPackageImpl#getOrderedSetType()
	 * @generated
	 */
	int ORDERED_SET_TYPE = 54;

	/**
	 * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDERED_SET_TYPE__EANNOTATIONS = COLLECTION_TYPE__EANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDERED_SET_TYPE__NAME = COLLECTION_TYPE__NAME;

	/**
	 * The feature id for the '<em><b>Instance Class Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDERED_SET_TYPE__INSTANCE_CLASS_NAME = COLLECTION_TYPE__INSTANCE_CLASS_NAME;

	/**
	 * The feature id for the '<em><b>Instance Class</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDERED_SET_TYPE__INSTANCE_CLASS = COLLECTION_TYPE__INSTANCE_CLASS;

	/**
	 * The feature id for the '<em><b>Default Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDERED_SET_TYPE__DEFAULT_VALUE = COLLECTION_TYPE__DEFAULT_VALUE;

	/**
	 * The feature id for the '<em><b>Instance Type Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDERED_SET_TYPE__INSTANCE_TYPE_NAME = COLLECTION_TYPE__INSTANCE_TYPE_NAME;

	/**
	 * The feature id for the '<em><b>EPackage</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDERED_SET_TYPE__EPACKAGE = COLLECTION_TYPE__EPACKAGE;

	/**
	 * The feature id for the '<em><b>EType Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDERED_SET_TYPE__ETYPE_PARAMETERS = COLLECTION_TYPE__ETYPE_PARAMETERS;

	/**
	 * The feature id for the '<em><b>Serializable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDERED_SET_TYPE__SERIALIZABLE = COLLECTION_TYPE__SERIALIZABLE;

	/**
	 * The feature id for the '<em><b>Element Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDERED_SET_TYPE__ELEMENT_TYPE = COLLECTION_TYPE__ELEMENT_TYPE;

	/**
	 * The number of structural features of the '<em>Ordered Set Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDERED_SET_TYPE_FEATURE_COUNT = COLLECTION_TYPE_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Get EAnnotation</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDERED_SET_TYPE___GET_EANNOTATION__STRING = COLLECTION_TYPE___GET_EANNOTATION__STRING;

	/**
	 * The operation id for the '<em>Is Instance</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDERED_SET_TYPE___IS_INSTANCE__OBJECT = COLLECTION_TYPE___IS_INSTANCE__OBJECT;

	/**
	 * The operation id for the '<em>Get Classifier ID</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDERED_SET_TYPE___GET_CLASSIFIER_ID = COLLECTION_TYPE___GET_CLASSIFIER_ID;

	/**
	 * The number of operations of the '<em>Ordered Set Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDERED_SET_TYPE_OPERATION_COUNT = COLLECTION_TYPE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.ustb.sei.mde.morel.impl.SequenceTypeImpl <em>Sequence Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.ustb.sei.mde.morel.impl.SequenceTypeImpl
	 * @see edu.ustb.sei.mde.morel.impl.MorelPackageImpl#getSequenceType()
	 * @generated
	 */
	int SEQUENCE_TYPE = 55;

	/**
	 * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_TYPE__EANNOTATIONS = COLLECTION_TYPE__EANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_TYPE__NAME = COLLECTION_TYPE__NAME;

	/**
	 * The feature id for the '<em><b>Instance Class Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_TYPE__INSTANCE_CLASS_NAME = COLLECTION_TYPE__INSTANCE_CLASS_NAME;

	/**
	 * The feature id for the '<em><b>Instance Class</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_TYPE__INSTANCE_CLASS = COLLECTION_TYPE__INSTANCE_CLASS;

	/**
	 * The feature id for the '<em><b>Default Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_TYPE__DEFAULT_VALUE = COLLECTION_TYPE__DEFAULT_VALUE;

	/**
	 * The feature id for the '<em><b>Instance Type Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_TYPE__INSTANCE_TYPE_NAME = COLLECTION_TYPE__INSTANCE_TYPE_NAME;

	/**
	 * The feature id for the '<em><b>EPackage</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_TYPE__EPACKAGE = COLLECTION_TYPE__EPACKAGE;

	/**
	 * The feature id for the '<em><b>EType Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_TYPE__ETYPE_PARAMETERS = COLLECTION_TYPE__ETYPE_PARAMETERS;

	/**
	 * The feature id for the '<em><b>Serializable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_TYPE__SERIALIZABLE = COLLECTION_TYPE__SERIALIZABLE;

	/**
	 * The feature id for the '<em><b>Element Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_TYPE__ELEMENT_TYPE = COLLECTION_TYPE__ELEMENT_TYPE;

	/**
	 * The number of structural features of the '<em>Sequence Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_TYPE_FEATURE_COUNT = COLLECTION_TYPE_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Get EAnnotation</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_TYPE___GET_EANNOTATION__STRING = COLLECTION_TYPE___GET_EANNOTATION__STRING;

	/**
	 * The operation id for the '<em>Is Instance</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_TYPE___IS_INSTANCE__OBJECT = COLLECTION_TYPE___IS_INSTANCE__OBJECT;

	/**
	 * The operation id for the '<em>Get Classifier ID</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_TYPE___GET_CLASSIFIER_ID = COLLECTION_TYPE___GET_CLASSIFIER_ID;

	/**
	 * The number of operations of the '<em>Sequence Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_TYPE_OPERATION_COUNT = COLLECTION_TYPE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.ustb.sei.mde.morel.impl.SetTypeImpl <em>Set Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.ustb.sei.mde.morel.impl.SetTypeImpl
	 * @see edu.ustb.sei.mde.morel.impl.MorelPackageImpl#getSetType()
	 * @generated
	 */
	int SET_TYPE = 56;

	/**
	 * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_TYPE__EANNOTATIONS = COLLECTION_TYPE__EANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_TYPE__NAME = COLLECTION_TYPE__NAME;

	/**
	 * The feature id for the '<em><b>Instance Class Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_TYPE__INSTANCE_CLASS_NAME = COLLECTION_TYPE__INSTANCE_CLASS_NAME;

	/**
	 * The feature id for the '<em><b>Instance Class</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_TYPE__INSTANCE_CLASS = COLLECTION_TYPE__INSTANCE_CLASS;

	/**
	 * The feature id for the '<em><b>Default Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_TYPE__DEFAULT_VALUE = COLLECTION_TYPE__DEFAULT_VALUE;

	/**
	 * The feature id for the '<em><b>Instance Type Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_TYPE__INSTANCE_TYPE_NAME = COLLECTION_TYPE__INSTANCE_TYPE_NAME;

	/**
	 * The feature id for the '<em><b>EPackage</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_TYPE__EPACKAGE = COLLECTION_TYPE__EPACKAGE;

	/**
	 * The feature id for the '<em><b>EType Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_TYPE__ETYPE_PARAMETERS = COLLECTION_TYPE__ETYPE_PARAMETERS;

	/**
	 * The feature id for the '<em><b>Serializable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_TYPE__SERIALIZABLE = COLLECTION_TYPE__SERIALIZABLE;

	/**
	 * The feature id for the '<em><b>Element Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_TYPE__ELEMENT_TYPE = COLLECTION_TYPE__ELEMENT_TYPE;

	/**
	 * The number of structural features of the '<em>Set Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_TYPE_FEATURE_COUNT = COLLECTION_TYPE_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Get EAnnotation</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_TYPE___GET_EANNOTATION__STRING = COLLECTION_TYPE___GET_EANNOTATION__STRING;

	/**
	 * The operation id for the '<em>Is Instance</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_TYPE___IS_INSTANCE__OBJECT = COLLECTION_TYPE___IS_INSTANCE__OBJECT;

	/**
	 * The operation id for the '<em>Get Classifier ID</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_TYPE___GET_CLASSIFIER_ID = COLLECTION_TYPE___GET_CLASSIFIER_ID;

	/**
	 * The number of operations of the '<em>Set Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_TYPE_OPERATION_COUNT = COLLECTION_TYPE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.ustb.sei.mde.morel.impl.BagTypeImpl <em>Bag Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.ustb.sei.mde.morel.impl.BagTypeImpl
	 * @see edu.ustb.sei.mde.morel.impl.MorelPackageImpl#getBagType()
	 * @generated
	 */
	int BAG_TYPE = 57;

	/**
	 * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BAG_TYPE__EANNOTATIONS = COLLECTION_TYPE__EANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BAG_TYPE__NAME = COLLECTION_TYPE__NAME;

	/**
	 * The feature id for the '<em><b>Instance Class Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BAG_TYPE__INSTANCE_CLASS_NAME = COLLECTION_TYPE__INSTANCE_CLASS_NAME;

	/**
	 * The feature id for the '<em><b>Instance Class</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BAG_TYPE__INSTANCE_CLASS = COLLECTION_TYPE__INSTANCE_CLASS;

	/**
	 * The feature id for the '<em><b>Default Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BAG_TYPE__DEFAULT_VALUE = COLLECTION_TYPE__DEFAULT_VALUE;

	/**
	 * The feature id for the '<em><b>Instance Type Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BAG_TYPE__INSTANCE_TYPE_NAME = COLLECTION_TYPE__INSTANCE_TYPE_NAME;

	/**
	 * The feature id for the '<em><b>EPackage</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BAG_TYPE__EPACKAGE = COLLECTION_TYPE__EPACKAGE;

	/**
	 * The feature id for the '<em><b>EType Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BAG_TYPE__ETYPE_PARAMETERS = COLLECTION_TYPE__ETYPE_PARAMETERS;

	/**
	 * The feature id for the '<em><b>Serializable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BAG_TYPE__SERIALIZABLE = COLLECTION_TYPE__SERIALIZABLE;

	/**
	 * The feature id for the '<em><b>Element Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BAG_TYPE__ELEMENT_TYPE = COLLECTION_TYPE__ELEMENT_TYPE;

	/**
	 * The number of structural features of the '<em>Bag Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BAG_TYPE_FEATURE_COUNT = COLLECTION_TYPE_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Get EAnnotation</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BAG_TYPE___GET_EANNOTATION__STRING = COLLECTION_TYPE___GET_EANNOTATION__STRING;

	/**
	 * The operation id for the '<em>Is Instance</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BAG_TYPE___IS_INSTANCE__OBJECT = COLLECTION_TYPE___IS_INSTANCE__OBJECT;

	/**
	 * The operation id for the '<em>Get Classifier ID</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BAG_TYPE___GET_CLASSIFIER_ID = COLLECTION_TYPE___GET_CLASSIFIER_ID;

	/**
	 * The number of operations of the '<em>Bag Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BAG_TYPE_OPERATION_COUNT = COLLECTION_TYPE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.ustb.sei.mde.morel.impl.ImperativeExpImpl <em>Imperative Exp</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.ustb.sei.mde.morel.impl.ImperativeExpImpl
	 * @see edu.ustb.sei.mde.morel.impl.MorelPackageImpl#getImperativeExp()
	 * @generated
	 */
	int IMPERATIVE_EXP = 58;

	/**
	 * The number of structural features of the '<em>Imperative Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPERATIVE_EXP_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Imperative Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPERATIVE_EXP_OPERATION_COUNT = EXPRESSION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.ustb.sei.mde.morel.impl.BindExpImpl <em>Bind Exp</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.ustb.sei.mde.morel.impl.BindExpImpl
	 * @see edu.ustb.sei.mde.morel.impl.MorelPackageImpl#getBindExp()
	 * @generated
	 */
	int BIND_EXP = 59;

	/**
	 * The feature id for the '<em><b>Source</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BIND_EXP__SOURCE = IMPERATIVE_EXP_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Value Exp</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BIND_EXP__VALUE_EXP = IMPERATIVE_EXP_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Bind Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BIND_EXP_FEATURE_COUNT = IMPERATIVE_EXP_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Bind Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BIND_EXP_OPERATION_COUNT = IMPERATIVE_EXP_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.ustb.sei.mde.morel.impl.PredefinedBindExpImpl <em>Predefined Bind Exp</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.ustb.sei.mde.morel.impl.PredefinedBindExpImpl
	 * @see edu.ustb.sei.mde.morel.impl.MorelPackageImpl#getPredefinedBindExp()
	 * @generated
	 */
	int PREDEFINED_BIND_EXP = 60;

	/**
	 * The feature id for the '<em><b>Source</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREDEFINED_BIND_EXP__SOURCE = IMPERATIVE_EXP_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Value Exp</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREDEFINED_BIND_EXP__VALUE_EXP = IMPERATIVE_EXP_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Predefined Bind Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREDEFINED_BIND_EXP_FEATURE_COUNT = IMPERATIVE_EXP_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Predefined Bind Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREDEFINED_BIND_EXP_OPERATION_COUNT = IMPERATIVE_EXP_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.ustb.sei.mde.morel.impl.StatementImpl <em>Statement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.ustb.sei.mde.morel.impl.StatementImpl
	 * @see edu.ustb.sei.mde.morel.impl.MorelPackageImpl#getStatement()
	 * @generated
	 */
	int STATEMENT = 66;

	/**
	 * The number of structural features of the '<em>Statement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATEMENT_FEATURE_COUNT = 0;

	/**
	 * The number of operations of the '<em>Statement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATEMENT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link edu.ustb.sei.mde.morel.impl.ImperativeStatementImpl <em>Imperative Statement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.ustb.sei.mde.morel.impl.ImperativeStatementImpl
	 * @see edu.ustb.sei.mde.morel.impl.MorelPackageImpl#getImperativeStatement()
	 * @generated
	 */
	int IMPERATIVE_STATEMENT = 68;

	/**
	 * The number of structural features of the '<em>Imperative Statement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPERATIVE_STATEMENT_FEATURE_COUNT = STATEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Imperative Statement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPERATIVE_STATEMENT_OPERATION_COUNT = STATEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.ustb.sei.mde.morel.impl.IfStatementImpl <em>If Statement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.ustb.sei.mde.morel.impl.IfStatementImpl
	 * @see edu.ustb.sei.mde.morel.impl.MorelPackageImpl#getIfStatement()
	 * @generated
	 */
	int IF_STATEMENT = 61;

	/**
	 * The feature id for the '<em><b>Condition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF_STATEMENT__CONDITION = IMPERATIVE_STATEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Then Statement</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF_STATEMENT__THEN_STATEMENT = IMPERATIVE_STATEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Else Statement</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF_STATEMENT__ELSE_STATEMENT = IMPERATIVE_STATEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>If Statement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF_STATEMENT_FEATURE_COUNT = IMPERATIVE_STATEMENT_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>If Statement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF_STATEMENT_OPERATION_COUNT = IMPERATIVE_STATEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.ustb.sei.mde.morel.impl.ForStatementImpl <em>For Statement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.ustb.sei.mde.morel.impl.ForStatementImpl
	 * @see edu.ustb.sei.mde.morel.impl.MorelPackageImpl#getForStatement()
	 * @generated
	 */
	int FOR_STATEMENT = 62;

	/**
	 * The feature id for the '<em><b>Iterator</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOR_STATEMENT__ITERATOR = IMPERATIVE_STATEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Termination Exp</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOR_STATEMENT__TERMINATION_EXP = IMPERATIVE_STATEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Step Exp</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOR_STATEMENT__STEP_EXP = IMPERATIVE_STATEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Body Statement</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOR_STATEMENT__BODY_STATEMENT = IMPERATIVE_STATEMENT_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>For Statement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOR_STATEMENT_FEATURE_COUNT = IMPERATIVE_STATEMENT_FEATURE_COUNT + 4;

	/**
	 * The number of operations of the '<em>For Statement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOR_STATEMENT_OPERATION_COUNT = IMPERATIVE_STATEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.ustb.sei.mde.morel.impl.BlockStatementImpl <em>Block Statement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.ustb.sei.mde.morel.impl.BlockStatementImpl
	 * @see edu.ustb.sei.mde.morel.impl.MorelPackageImpl#getBlockStatement()
	 * @generated
	 */
	int BLOCK_STATEMENT = 63;

	/**
	 * The feature id for the '<em><b>Statements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLOCK_STATEMENT__STATEMENTS = IMPERATIVE_STATEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Block Statement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLOCK_STATEMENT_FEATURE_COUNT = IMPERATIVE_STATEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Block Statement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLOCK_STATEMENT_OPERATION_COUNT = IMPERATIVE_STATEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.ustb.sei.mde.morel.impl.TransformationModelImpl <em>Transformation Model</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.ustb.sei.mde.morel.impl.TransformationModelImpl
	 * @see edu.ustb.sei.mde.morel.impl.MorelPackageImpl#getTransformationModel()
	 * @generated
	 */
	int TRANSFORMATION_MODEL = 64;

	/**
	 * The feature id for the '<em><b>Models</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMATION_MODEL__MODELS = UNIT__MODELS;

	/**
	 * The feature id for the '<em><b>Data Types</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMATION_MODEL__DATA_TYPES = UNIT__DATA_TYPES;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMATION_MODEL__NAME = UNIT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Rules</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMATION_MODEL__RULES = UNIT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Transformation Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMATION_MODEL_FEATURE_COUNT = UNIT_FEATURE_COUNT + 2;

	/**
	 * The operation id for the '<em>Get Typed Model</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMATION_MODEL___GET_TYPED_MODEL__STRING = UNIT___GET_TYPED_MODEL__STRING;

	/**
	 * The number of operations of the '<em>Transformation Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMATION_MODEL_OPERATION_COUNT = UNIT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.ustb.sei.mde.morel.impl.RuleImpl <em>Rule</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.ustb.sei.mde.morel.impl.RuleImpl
	 * @see edu.ustb.sei.mde.morel.impl.MorelPackageImpl#getRule()
	 * @generated
	 */
	int RULE = 65;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Patterns</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE__PATTERNS = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Rule</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Rule</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE_OPERATION_COUNT = NAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.ustb.sei.mde.morel.impl.DeclarativeStatementImpl <em>Declarative Statement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.ustb.sei.mde.morel.impl.DeclarativeStatementImpl
	 * @see edu.ustb.sei.mde.morel.impl.MorelPackageImpl#getDeclarativeStatement()
	 * @generated
	 */
	int DECLARATIVE_STATEMENT = 67;

	/**
	 * The feature id for the '<em><b>Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DECLARATIVE_STATEMENT__EXPRESSION = STATEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Declarative Statement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DECLARATIVE_STATEMENT_FEATURE_COUNT = STATEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Declarative Statement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DECLARATIVE_STATEMENT_OPERATION_COUNT = STATEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.ustb.sei.mde.morel.SectionType <em>Section Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.ustb.sei.mde.morel.SectionType
	 * @see edu.ustb.sei.mde.morel.impl.MorelPackageImpl#getSectionType()
	 * @generated
	 */
	int SECTION_TYPE = 69;

	/**
	 * The meta object id for the '{@link edu.ustb.sei.mde.morel.UndefinedLiteral <em>Undefined Literal</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.ustb.sei.mde.morel.UndefinedLiteral
	 * @see edu.ustb.sei.mde.morel.impl.MorelPackageImpl#getUndefinedLiteral()
	 * @generated
	 */
	int UNDEFINED_LITERAL = 70;

	/**
	 * The meta object id for the '{@link edu.ustb.sei.mde.morel.PredefinedVariable <em>Predefined Variable</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.ustb.sei.mde.morel.PredefinedVariable
	 * @see edu.ustb.sei.mde.morel.impl.MorelPackageImpl#getPredefinedVariable()
	 * @generated
	 */
	int PREDEFINED_VARIABLE = 71;

	/**
	 * The meta object id for the '{@link edu.ustb.sei.mde.morel.OperationSeparator <em>Operation Separator</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.ustb.sei.mde.morel.OperationSeparator
	 * @see edu.ustb.sei.mde.morel.impl.MorelPackageImpl#getOperationSeparator()
	 * @generated
	 */
	int OPERATION_SEPARATOR = 72;

	/**
	 * The meta object id for the '{@link edu.ustb.sei.mde.morel.IteratorType <em>Iterator Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.ustb.sei.mde.morel.IteratorType
	 * @see edu.ustb.sei.mde.morel.impl.MorelPackageImpl#getIteratorType()
	 * @generated
	 */
	int ITERATOR_TYPE = 73;

	/**
	 * The meta object id for the '{@link edu.ustb.sei.mde.morel.BooleanOperator <em>Boolean Operator</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.ustb.sei.mde.morel.BooleanOperator
	 * @see edu.ustb.sei.mde.morel.impl.MorelPackageImpl#getBooleanOperator()
	 * @generated
	 */
	int BOOLEAN_OPERATOR = 74;

	/**
	 * The meta object id for the '{@link edu.ustb.sei.mde.morel.RelationalOperator <em>Relational Operator</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.ustb.sei.mde.morel.RelationalOperator
	 * @see edu.ustb.sei.mde.morel.impl.MorelPackageImpl#getRelationalOperator()
	 * @generated
	 */
	int RELATIONAL_OPERATOR = 75;

	/**
	 * The meta object id for the '{@link edu.ustb.sei.mde.morel.AdditiveOperator <em>Additive Operator</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.ustb.sei.mde.morel.AdditiveOperator
	 * @see edu.ustb.sei.mde.morel.impl.MorelPackageImpl#getAdditiveOperator()
	 * @generated
	 */
	int ADDITIVE_OPERATOR = 76;

	/**
	 * The meta object id for the '{@link edu.ustb.sei.mde.morel.MultiplicativeOperator <em>Multiplicative Operator</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.ustb.sei.mde.morel.MultiplicativeOperator
	 * @see edu.ustb.sei.mde.morel.impl.MorelPackageImpl#getMultiplicativeOperator()
	 * @generated
	 */
	int MULTIPLICATIVE_OPERATOR = 77;

	/**
	 * The meta object id for the '{@link edu.ustb.sei.mde.morel.UnaryOperator <em>Unary Operator</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.ustb.sei.mde.morel.UnaryOperator
	 * @see edu.ustb.sei.mde.morel.impl.MorelPackageImpl#getUnaryOperator()
	 * @generated
	 */
	int UNARY_OPERATOR = 78;


	/**
	 * Returns the meta object for class '{@link edu.ustb.sei.mde.morel.NamedElement <em>Named Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Named Element</em>'.
	 * @see edu.ustb.sei.mde.morel.NamedElement
	 * @generated
	 */
	EClass getNamedElement();

	/**
	 * Returns the meta object for the attribute '{@link edu.ustb.sei.mde.morel.NamedElement#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see edu.ustb.sei.mde.morel.NamedElement#getName()
	 * @see #getNamedElement()
	 * @generated
	 */
	EAttribute getNamedElement_Name();

	/**
	 * Returns the meta object for class '{@link edu.ustb.sei.mde.morel.Section <em>Section</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Section</em>'.
	 * @see edu.ustb.sei.mde.morel.Section
	 * @generated
	 */
	EClass getSection();

	/**
	 * Returns the meta object for the attribute '{@link edu.ustb.sei.mde.morel.Section#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see edu.ustb.sei.mde.morel.Section#getType()
	 * @see #getSection()
	 * @generated
	 */
	EAttribute getSection_Type();

	/**
	 * Returns the meta object for class '{@link edu.ustb.sei.mde.morel.Pattern <em>Pattern</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Pattern</em>'.
	 * @see edu.ustb.sei.mde.morel.Pattern
	 * @generated
	 */
	EClass getPattern();

	/**
	 * Returns the meta object for the containment reference list '{@link edu.ustb.sei.mde.morel.Pattern#getVariables <em>Variables</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Variables</em>'.
	 * @see edu.ustb.sei.mde.morel.Pattern#getVariables()
	 * @see #getPattern()
	 * @generated
	 */
	EReference getPattern_Variables();

	/**
	 * Returns the meta object for the containment reference list '{@link edu.ustb.sei.mde.morel.Pattern#getLinkConstraints <em>Link Constraints</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Link Constraints</em>'.
	 * @see edu.ustb.sei.mde.morel.Pattern#getLinkConstraints()
	 * @see #getPattern()
	 * @generated
	 */
	EReference getPattern_LinkConstraints();

	/**
	 * Returns the meta object for the containment reference list '{@link edu.ustb.sei.mde.morel.Pattern#getStatements <em>Statements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Statements</em>'.
	 * @see edu.ustb.sei.mde.morel.Pattern#getStatements()
	 * @see #getPattern()
	 * @generated
	 */
	EReference getPattern_Statements();

	/**
	 * Returns the meta object for class '{@link edu.ustb.sei.mde.morel.Clause <em>Clause</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Clause</em>'.
	 * @see edu.ustb.sei.mde.morel.Clause
	 * @generated
	 */
	EClass getClause();

	/**
	 * Returns the meta object for class '{@link edu.ustb.sei.mde.morel.Variable <em>Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Variable</em>'.
	 * @see edu.ustb.sei.mde.morel.Variable
	 * @generated
	 */
	EClass getVariable();

	/**
	 * Returns the meta object for class '{@link edu.ustb.sei.mde.morel.ObjectVariable <em>Object Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Object Variable</em>'.
	 * @see edu.ustb.sei.mde.morel.ObjectVariable
	 * @generated
	 */
	EClass getObjectVariable();

	/**
	 * Returns the meta object for the reference '{@link edu.ustb.sei.mde.morel.ObjectVariable#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Type</em>'.
	 * @see edu.ustb.sei.mde.morel.ObjectVariable#getType()
	 * @see #getObjectVariable()
	 * @generated
	 */
	EReference getObjectVariable_Type();

	/**
	 * Returns the meta object for the reference '{@link edu.ustb.sei.mde.morel.ObjectVariable#getModel <em>Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Model</em>'.
	 * @see edu.ustb.sei.mde.morel.ObjectVariable#getModel()
	 * @see #getObjectVariable()
	 * @generated
	 */
	EReference getObjectVariable_Model();

	/**
	 * Returns the meta object for class '{@link edu.ustb.sei.mde.morel.PrimitiveVariable <em>Primitive Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Primitive Variable</em>'.
	 * @see edu.ustb.sei.mde.morel.PrimitiveVariable
	 * @generated
	 */
	EClass getPrimitiveVariable();

	/**
	 * Returns the meta object for the reference '{@link edu.ustb.sei.mde.morel.PrimitiveVariable#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Type</em>'.
	 * @see edu.ustb.sei.mde.morel.PrimitiveVariable#getType()
	 * @see #getPrimitiveVariable()
	 * @generated
	 */
	EReference getPrimitiveVariable_Type();

	/**
	 * Returns the meta object for class '{@link edu.ustb.sei.mde.morel.LinkConstraint <em>Link Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Link Constraint</em>'.
	 * @see edu.ustb.sei.mde.morel.LinkConstraint
	 * @generated
	 */
	EClass getLinkConstraint();

	/**
	 * Returns the meta object for the reference '{@link edu.ustb.sei.mde.morel.LinkConstraint#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Source</em>'.
	 * @see edu.ustb.sei.mde.morel.LinkConstraint#getSource()
	 * @see #getLinkConstraint()
	 * @generated
	 */
	EReference getLinkConstraint_Source();

	/**
	 * Returns the meta object for the reference '{@link edu.ustb.sei.mde.morel.LinkConstraint#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target</em>'.
	 * @see edu.ustb.sei.mde.morel.LinkConstraint#getTarget()
	 * @see #getLinkConstraint()
	 * @generated
	 */
	EReference getLinkConstraint_Target();

	/**
	 * Returns the meta object for class '{@link edu.ustb.sei.mde.morel.SimpleLinkConstraint <em>Simple Link Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Simple Link Constraint</em>'.
	 * @see edu.ustb.sei.mde.morel.SimpleLinkConstraint
	 * @generated
	 */
	EClass getSimpleLinkConstraint();

	/**
	 * Returns the meta object for the containment reference '{@link edu.ustb.sei.mde.morel.SimpleLinkConstraint#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Id</em>'.
	 * @see edu.ustb.sei.mde.morel.SimpleLinkConstraint#getId()
	 * @see #getSimpleLinkConstraint()
	 * @generated
	 */
	EReference getSimpleLinkConstraint_Id();

	/**
	 * Returns the meta object for the reference '{@link edu.ustb.sei.mde.morel.SimpleLinkConstraint#getReference <em>Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Reference</em>'.
	 * @see edu.ustb.sei.mde.morel.SimpleLinkConstraint#getReference()
	 * @see #getSimpleLinkConstraint()
	 * @generated
	 */
	EReference getSimpleLinkConstraint_Reference();

	/**
	 * Returns the meta object for class '{@link edu.ustb.sei.mde.morel.EnclosureLinkConstraint <em>Enclosure Link Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Enclosure Link Constraint</em>'.
	 * @see edu.ustb.sei.mde.morel.EnclosureLinkConstraint
	 * @generated
	 */
	EClass getEnclosureLinkConstraint();

	/**
	 * Returns the meta object for the reference list '{@link edu.ustb.sei.mde.morel.EnclosureLinkConstraint#getForward <em>Forward</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Forward</em>'.
	 * @see edu.ustb.sei.mde.morel.EnclosureLinkConstraint#getForward()
	 * @see #getEnclosureLinkConstraint()
	 * @generated
	 */
	EReference getEnclosureLinkConstraint_Forward();

	/**
	 * Returns the meta object for the reference list '{@link edu.ustb.sei.mde.morel.EnclosureLinkConstraint#getTypes <em>Types</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Types</em>'.
	 * @see edu.ustb.sei.mde.morel.EnclosureLinkConstraint#getTypes()
	 * @see #getEnclosureLinkConstraint()
	 * @generated
	 */
	EReference getEnclosureLinkConstraint_Types();

	/**
	 * Returns the meta object for class '{@link edu.ustb.sei.mde.morel.PathConstraint <em>Path Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Path Constraint</em>'.
	 * @see edu.ustb.sei.mde.morel.PathConstraint
	 * @generated
	 */
	EClass getPathConstraint();

	/**
	 * Returns the meta object for the attribute '{@link edu.ustb.sei.mde.morel.PathConstraint#getMinLength <em>Min Length</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Min Length</em>'.
	 * @see edu.ustb.sei.mde.morel.PathConstraint#getMinLength()
	 * @see #getPathConstraint()
	 * @generated
	 */
	EAttribute getPathConstraint_MinLength();

	/**
	 * Returns the meta object for the attribute '{@link edu.ustb.sei.mde.morel.PathConstraint#getMaxLength <em>Max Length</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Max Length</em>'.
	 * @see edu.ustb.sei.mde.morel.PathConstraint#getMaxLength()
	 * @see #getPathConstraint()
	 * @generated
	 */
	EAttribute getPathConstraint_MaxLength();

	/**
	 * Returns the meta object for the reference '{@link edu.ustb.sei.mde.morel.PathConstraint#getPathVariable <em>Path Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Path Variable</em>'.
	 * @see edu.ustb.sei.mde.morel.PathConstraint#getPathVariable()
	 * @see #getPathConstraint()
	 * @generated
	 */
	EReference getPathConstraint_PathVariable();

	/**
	 * Returns the meta object for the reference list '{@link edu.ustb.sei.mde.morel.PathConstraint#getReferences <em>References</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>References</em>'.
	 * @see edu.ustb.sei.mde.morel.PathConstraint#getReferences()
	 * @see #getPathConstraint()
	 * @generated
	 */
	EReference getPathConstraint_References();

	/**
	 * Returns the meta object for the reference list '{@link edu.ustb.sei.mde.morel.PathConstraint#getTypes <em>Types</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Types</em>'.
	 * @see edu.ustb.sei.mde.morel.PathConstraint#getTypes()
	 * @see #getPathConstraint()
	 * @generated
	 */
	EReference getPathConstraint_Types();

	/**
	 * Returns the meta object for class '{@link edu.ustb.sei.mde.morel.QueryModel <em>Query Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Query Model</em>'.
	 * @see edu.ustb.sei.mde.morel.QueryModel
	 * @generated
	 */
	EClass getQueryModel();

	/**
	 * Returns the meta object for the containment reference list '{@link edu.ustb.sei.mde.morel.QueryModel#getQueries <em>Queries</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Queries</em>'.
	 * @see edu.ustb.sei.mde.morel.QueryModel#getQueries()
	 * @see #getQueryModel()
	 * @generated
	 */
	EReference getQueryModel_Queries();

	/**
	 * Returns the meta object for class '{@link edu.ustb.sei.mde.morel.TypedModel <em>Typed Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Typed Model</em>'.
	 * @see edu.ustb.sei.mde.morel.TypedModel
	 * @generated
	 */
	EClass getTypedModel();

	/**
	 * Returns the meta object for the reference '{@link edu.ustb.sei.mde.morel.TypedModel#getPackage <em>Package</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Package</em>'.
	 * @see edu.ustb.sei.mde.morel.TypedModel#getPackage()
	 * @see #getTypedModel()
	 * @generated
	 */
	EReference getTypedModel_Package();

	/**
	 * Returns the meta object for class '{@link edu.ustb.sei.mde.morel.Query <em>Query</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Query</em>'.
	 * @see edu.ustb.sei.mde.morel.Query
	 * @generated
	 */
	EClass getQuery();

	/**
	 * Returns the meta object for class '{@link edu.ustb.sei.mde.morel.Unit <em>Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Unit</em>'.
	 * @see edu.ustb.sei.mde.morel.Unit
	 * @generated
	 */
	EClass getUnit();

	/**
	 * Returns the meta object for the containment reference list '{@link edu.ustb.sei.mde.morel.Unit#getModels <em>Models</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Models</em>'.
	 * @see edu.ustb.sei.mde.morel.Unit#getModels()
	 * @see #getUnit()
	 * @generated
	 */
	EReference getUnit_Models();

	/**
	 * Returns the meta object for the containment reference list '{@link edu.ustb.sei.mde.morel.Unit#getDataTypes <em>Data Types</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Data Types</em>'.
	 * @see edu.ustb.sei.mde.morel.Unit#getDataTypes()
	 * @see #getUnit()
	 * @generated
	 */
	EReference getUnit_DataTypes();

	/**
	 * Returns the meta object for the '{@link edu.ustb.sei.mde.morel.Unit#getTypedModel(java.lang.String) <em>Get Typed Model</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Typed Model</em>' operation.
	 * @see edu.ustb.sei.mde.morel.Unit#getTypedModel(java.lang.String)
	 * @generated
	 */
	EOperation getUnit__GetTypedModel__String();

	/**
	 * Returns the meta object for class '{@link edu.ustb.sei.mde.morel.Expression <em>Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Expression</em>'.
	 * @see edu.ustb.sei.mde.morel.Expression
	 * @generated
	 */
	EClass getExpression();

	/**
	 * Returns the meta object for class '{@link edu.ustb.sei.mde.morel.AtomicExp <em>Atomic Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Atomic Exp</em>'.
	 * @see edu.ustb.sei.mde.morel.AtomicExp
	 * @generated
	 */
	EClass getAtomicExp();

	/**
	 * Returns the meta object for the containment reference '{@link edu.ustb.sei.mde.morel.AtomicExp#getPath <em>Path</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Path</em>'.
	 * @see edu.ustb.sei.mde.morel.AtomicExp#getPath()
	 * @see #getAtomicExp()
	 * @generated
	 */
	EReference getAtomicExp_Path();

	/**
	 * Returns the meta object for class '{@link edu.ustb.sei.mde.morel.LiteralExp <em>Literal Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Literal Exp</em>'.
	 * @see edu.ustb.sei.mde.morel.LiteralExp
	 * @generated
	 */
	EClass getLiteralExp();

	/**
	 * Returns the meta object for class '{@link edu.ustb.sei.mde.morel.StringLiteralExp <em>String Literal Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>String Literal Exp</em>'.
	 * @see edu.ustb.sei.mde.morel.StringLiteralExp
	 * @generated
	 */
	EClass getStringLiteralExp();

	/**
	 * Returns the meta object for the attribute '{@link edu.ustb.sei.mde.morel.StringLiteralExp#getStringSymbol <em>String Symbol</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>String Symbol</em>'.
	 * @see edu.ustb.sei.mde.morel.StringLiteralExp#getStringSymbol()
	 * @see #getStringLiteralExp()
	 * @generated
	 */
	EAttribute getStringLiteralExp_StringSymbol();

	/**
	 * Returns the meta object for class '{@link edu.ustb.sei.mde.morel.IntegerLiteralExp <em>Integer Literal Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Integer Literal Exp</em>'.
	 * @see edu.ustb.sei.mde.morel.IntegerLiteralExp
	 * @generated
	 */
	EClass getIntegerLiteralExp();

	/**
	 * Returns the meta object for the attribute '{@link edu.ustb.sei.mde.morel.IntegerLiteralExp#getIntegerSymbol <em>Integer Symbol</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Integer Symbol</em>'.
	 * @see edu.ustb.sei.mde.morel.IntegerLiteralExp#getIntegerSymbol()
	 * @see #getIntegerLiteralExp()
	 * @generated
	 */
	EAttribute getIntegerLiteralExp_IntegerSymbol();

	/**
	 * Returns the meta object for class '{@link edu.ustb.sei.mde.morel.RealLiteralExp <em>Real Literal Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Real Literal Exp</em>'.
	 * @see edu.ustb.sei.mde.morel.RealLiteralExp
	 * @generated
	 */
	EClass getRealLiteralExp();

	/**
	 * Returns the meta object for the attribute '{@link edu.ustb.sei.mde.morel.RealLiteralExp#getRealSymbol <em>Real Symbol</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Real Symbol</em>'.
	 * @see edu.ustb.sei.mde.morel.RealLiteralExp#getRealSymbol()
	 * @see #getRealLiteralExp()
	 * @generated
	 */
	EAttribute getRealLiteralExp_RealSymbol();

	/**
	 * Returns the meta object for class '{@link edu.ustb.sei.mde.morel.BooleanLiteralExp <em>Boolean Literal Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Boolean Literal Exp</em>'.
	 * @see edu.ustb.sei.mde.morel.BooleanLiteralExp
	 * @generated
	 */
	EClass getBooleanLiteralExp();

	/**
	 * Returns the meta object for the attribute '{@link edu.ustb.sei.mde.morel.BooleanLiteralExp#isBoolSymbol <em>Bool Symbol</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Bool Symbol</em>'.
	 * @see edu.ustb.sei.mde.morel.BooleanLiteralExp#isBoolSymbol()
	 * @see #getBooleanLiteralExp()
	 * @generated
	 */
	EAttribute getBooleanLiteralExp_BoolSymbol();

	/**
	 * Returns the meta object for class '{@link edu.ustb.sei.mde.morel.UndefinedLiteralExp <em>Undefined Literal Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Undefined Literal Exp</em>'.
	 * @see edu.ustb.sei.mde.morel.UndefinedLiteralExp
	 * @generated
	 */
	EClass getUndefinedLiteralExp();

	/**
	 * Returns the meta object for the attribute '{@link edu.ustb.sei.mde.morel.UndefinedLiteralExp#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see edu.ustb.sei.mde.morel.UndefinedLiteralExp#getValue()
	 * @see #getUndefinedLiteralExp()
	 * @generated
	 */
	EAttribute getUndefinedLiteralExp_Value();

	/**
	 * Returns the meta object for class '{@link edu.ustb.sei.mde.morel.CollectionLiteralExp <em>Collection Literal Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Collection Literal Exp</em>'.
	 * @see edu.ustb.sei.mde.morel.CollectionLiteralExp
	 * @generated
	 */
	EClass getCollectionLiteralExp();

	/**
	 * Returns the meta object for the attribute '{@link edu.ustb.sei.mde.morel.CollectionLiteralExp#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see edu.ustb.sei.mde.morel.CollectionLiteralExp#getType()
	 * @see #getCollectionLiteralExp()
	 * @generated
	 */
	EAttribute getCollectionLiteralExp_Type();

	/**
	 * Returns the meta object for the containment reference list '{@link edu.ustb.sei.mde.morel.CollectionLiteralExp#getLiterals <em>Literals</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Literals</em>'.
	 * @see edu.ustb.sei.mde.morel.CollectionLiteralExp#getLiterals()
	 * @see #getCollectionLiteralExp()
	 * @generated
	 */
	EReference getCollectionLiteralExp_Literals();

	/**
	 * Returns the meta object for class '{@link edu.ustb.sei.mde.morel.EnumLiteralExp <em>Enum Literal Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Enum Literal Exp</em>'.
	 * @see edu.ustb.sei.mde.morel.EnumLiteralExp
	 * @generated
	 */
	EClass getEnumLiteralExp();

	/**
	 * Returns the meta object for the reference '{@link edu.ustb.sei.mde.morel.EnumLiteralExp#getEnumType <em>Enum Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Enum Type</em>'.
	 * @see edu.ustb.sei.mde.morel.EnumLiteralExp#getEnumType()
	 * @see #getEnumLiteralExp()
	 * @generated
	 */
	EReference getEnumLiteralExp_EnumType();

	/**
	 * Returns the meta object for the reference '{@link edu.ustb.sei.mde.morel.EnumLiteralExp#getEnumSymbol <em>Enum Symbol</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Enum Symbol</em>'.
	 * @see edu.ustb.sei.mde.morel.EnumLiteralExp#getEnumSymbol()
	 * @see #getEnumLiteralExp()
	 * @generated
	 */
	EReference getEnumLiteralExp_EnumSymbol();

	/**
	 * Returns the meta object for class '{@link edu.ustb.sei.mde.morel.TypeLiteralExp <em>Type Literal Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Type Literal Exp</em>'.
	 * @see edu.ustb.sei.mde.morel.TypeLiteralExp
	 * @generated
	 */
	EClass getTypeLiteralExp();

	/**
	 * Returns the meta object for the reference '{@link edu.ustb.sei.mde.morel.TypeLiteralExp#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Value</em>'.
	 * @see edu.ustb.sei.mde.morel.TypeLiteralExp#getValue()
	 * @see #getTypeLiteralExp()
	 * @generated
	 */
	EReference getTypeLiteralExp_Value();

	/**
	 * Returns the meta object for class '{@link edu.ustb.sei.mde.morel.VariableExp <em>Variable Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Variable Exp</em>'.
	 * @see edu.ustb.sei.mde.morel.VariableExp
	 * @generated
	 */
	EClass getVariableExp();

	/**
	 * Returns the meta object for the reference '{@link edu.ustb.sei.mde.morel.VariableExp#getReferredVariable <em>Referred Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Referred Variable</em>'.
	 * @see edu.ustb.sei.mde.morel.VariableExp#getReferredVariable()
	 * @see #getVariableExp()
	 * @generated
	 */
	EReference getVariableExp_ReferredVariable();

	/**
	 * Returns the meta object for class '{@link edu.ustb.sei.mde.morel.PredefinedVariableExp <em>Predefined Variable Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Predefined Variable Exp</em>'.
	 * @see edu.ustb.sei.mde.morel.PredefinedVariableExp
	 * @generated
	 */
	EClass getPredefinedVariableExp();

	/**
	 * Returns the meta object for the attribute '{@link edu.ustb.sei.mde.morel.PredefinedVariableExp#getVariable <em>Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Variable</em>'.
	 * @see edu.ustb.sei.mde.morel.PredefinedVariableExp#getVariable()
	 * @see #getPredefinedVariableExp()
	 * @generated
	 */
	EAttribute getPredefinedVariableExp_Variable();

	/**
	 * Returns the meta object for class '{@link edu.ustb.sei.mde.morel.NestedExp <em>Nested Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Nested Exp</em>'.
	 * @see edu.ustb.sei.mde.morel.NestedExp
	 * @generated
	 */
	EClass getNestedExp();

	/**
	 * Returns the meta object for the containment reference '{@link edu.ustb.sei.mde.morel.NestedExp#getExpression <em>Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Expression</em>'.
	 * @see edu.ustb.sei.mde.morel.NestedExp#getExpression()
	 * @see #getNestedExp()
	 * @generated
	 */
	EReference getNestedExp_Expression();

	/**
	 * Returns the meta object for class '{@link edu.ustb.sei.mde.morel.CallPathExp <em>Call Path Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Call Path Exp</em>'.
	 * @see edu.ustb.sei.mde.morel.CallPathExp
	 * @generated
	 */
	EClass getCallPathExp();

	/**
	 * Returns the meta object for the containment reference '{@link edu.ustb.sei.mde.morel.CallPathExp#getNext <em>Next</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Next</em>'.
	 * @see edu.ustb.sei.mde.morel.CallPathExp#getNext()
	 * @see #getCallPathExp()
	 * @generated
	 */
	EReference getCallPathExp_Next();

	/**
	 * Returns the meta object for class '{@link edu.ustb.sei.mde.morel.FeaturePathExp <em>Feature Path Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Feature Path Exp</em>'.
	 * @see edu.ustb.sei.mde.morel.FeaturePathExp
	 * @generated
	 */
	EClass getFeaturePathExp();

	/**
	 * Returns the meta object for the attribute '{@link edu.ustb.sei.mde.morel.FeaturePathExp#getFeature <em>Feature</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Feature</em>'.
	 * @see edu.ustb.sei.mde.morel.FeaturePathExp#getFeature()
	 * @see #getFeaturePathExp()
	 * @generated
	 */
	EAttribute getFeaturePathExp_Feature();

	/**
	 * Returns the meta object for class '{@link edu.ustb.sei.mde.morel.OperationPathExp <em>Operation Path Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Operation Path Exp</em>'.
	 * @see edu.ustb.sei.mde.morel.OperationPathExp
	 * @generated
	 */
	EClass getOperationPathExp();

	/**
	 * Returns the meta object for the attribute '{@link edu.ustb.sei.mde.morel.OperationPathExp#getSeparator <em>Separator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Separator</em>'.
	 * @see edu.ustb.sei.mde.morel.OperationPathExp#getSeparator()
	 * @see #getOperationPathExp()
	 * @generated
	 */
	EAttribute getOperationPathExp_Separator();

	/**
	 * Returns the meta object for the attribute '{@link edu.ustb.sei.mde.morel.OperationPathExp#getOperation <em>Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Operation</em>'.
	 * @see edu.ustb.sei.mde.morel.OperationPathExp#getOperation()
	 * @see #getOperationPathExp()
	 * @generated
	 */
	EAttribute getOperationPathExp_Operation();

	/**
	 * Returns the meta object for the containment reference list '{@link edu.ustb.sei.mde.morel.OperationPathExp#getParameters <em>Parameters</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Parameters</em>'.
	 * @see edu.ustb.sei.mde.morel.OperationPathExp#getParameters()
	 * @see #getOperationPathExp()
	 * @generated
	 */
	EReference getOperationPathExp_Parameters();

	/**
	 * Returns the meta object for class '{@link edu.ustb.sei.mde.morel.LoopPathExp <em>Loop Path Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Loop Path Exp</em>'.
	 * @see edu.ustb.sei.mde.morel.LoopPathExp
	 * @generated
	 */
	EClass getLoopPathExp();

	/**
	 * Returns the meta object for class '{@link edu.ustb.sei.mde.morel.IteratorPathExp <em>Iterator Path Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Iterator Path Exp</em>'.
	 * @see edu.ustb.sei.mde.morel.IteratorPathExp
	 * @generated
	 */
	EClass getIteratorPathExp();

	/**
	 * Returns the meta object for the attribute '{@link edu.ustb.sei.mde.morel.IteratorPathExp#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see edu.ustb.sei.mde.morel.IteratorPathExp#getType()
	 * @see #getIteratorPathExp()
	 * @generated
	 */
	EAttribute getIteratorPathExp_Type();

	/**
	 * Returns the meta object for the containment reference '{@link edu.ustb.sei.mde.morel.IteratorPathExp#getFirstVar <em>First Var</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>First Var</em>'.
	 * @see edu.ustb.sei.mde.morel.IteratorPathExp#getFirstVar()
	 * @see #getIteratorPathExp()
	 * @generated
	 */
	EReference getIteratorPathExp_FirstVar();

	/**
	 * Returns the meta object for the containment reference '{@link edu.ustb.sei.mde.morel.IteratorPathExp#getSecondVar <em>Second Var</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Second Var</em>'.
	 * @see edu.ustb.sei.mde.morel.IteratorPathExp#getSecondVar()
	 * @see #getIteratorPathExp()
	 * @generated
	 */
	EReference getIteratorPathExp_SecondVar();

	/**
	 * Returns the meta object for the containment reference '{@link edu.ustb.sei.mde.morel.IteratorPathExp#getBodyExp <em>Body Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Body Exp</em>'.
	 * @see edu.ustb.sei.mde.morel.IteratorPathExp#getBodyExp()
	 * @see #getIteratorPathExp()
	 * @generated
	 */
	EReference getIteratorPathExp_BodyExp();

	/**
	 * Returns the meta object for class '{@link edu.ustb.sei.mde.morel.LetExp <em>Let Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Let Exp</em>'.
	 * @see edu.ustb.sei.mde.morel.LetExp
	 * @generated
	 */
	EClass getLetExp();

	/**
	 * Returns the meta object for the containment reference list '{@link edu.ustb.sei.mde.morel.LetExp#getVariables <em>Variables</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Variables</em>'.
	 * @see edu.ustb.sei.mde.morel.LetExp#getVariables()
	 * @see #getLetExp()
	 * @generated
	 */
	EReference getLetExp_Variables();

	/**
	 * Returns the meta object for the containment reference '{@link edu.ustb.sei.mde.morel.LetExp#getInExp <em>In Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>In Exp</em>'.
	 * @see edu.ustb.sei.mde.morel.LetExp#getInExp()
	 * @see #getLetExp()
	 * @generated
	 */
	EReference getLetExp_InExp();

	/**
	 * Returns the meta object for class '{@link edu.ustb.sei.mde.morel.VariableWithInit <em>Variable With Init</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Variable With Init</em>'.
	 * @see edu.ustb.sei.mde.morel.VariableWithInit
	 * @generated
	 */
	EClass getVariableWithInit();

	/**
	 * Returns the meta object for the containment reference '{@link edu.ustb.sei.mde.morel.VariableWithInit#getInitExp <em>Init Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Init Exp</em>'.
	 * @see edu.ustb.sei.mde.morel.VariableWithInit#getInitExp()
	 * @see #getVariableWithInit()
	 * @generated
	 */
	EReference getVariableWithInit_InitExp();

	/**
	 * Returns the meta object for class '{@link edu.ustb.sei.mde.morel.ObjectVariableWithInit <em>Object Variable With Init</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Object Variable With Init</em>'.
	 * @see edu.ustb.sei.mde.morel.ObjectVariableWithInit
	 * @generated
	 */
	EClass getObjectVariableWithInit();

	/**
	 * Returns the meta object for class '{@link edu.ustb.sei.mde.morel.PrimitiveVariableWithInit <em>Primitive Variable With Init</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Primitive Variable With Init</em>'.
	 * @see edu.ustb.sei.mde.morel.PrimitiveVariableWithInit
	 * @generated
	 */
	EClass getPrimitiveVariableWithInit();

	/**
	 * Returns the meta object for class '{@link edu.ustb.sei.mde.morel.ConditionExp <em>Condition Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Condition Exp</em>'.
	 * @see edu.ustb.sei.mde.morel.ConditionExp
	 * @generated
	 */
	EClass getConditionExp();

	/**
	 * Returns the meta object for the containment reference '{@link edu.ustb.sei.mde.morel.ConditionExp#getCondition <em>Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Condition</em>'.
	 * @see edu.ustb.sei.mde.morel.ConditionExp#getCondition()
	 * @see #getConditionExp()
	 * @generated
	 */
	EReference getConditionExp_Condition();

	/**
	 * Returns the meta object for the containment reference '{@link edu.ustb.sei.mde.morel.ConditionExp#getThenBranch <em>Then Branch</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Then Branch</em>'.
	 * @see edu.ustb.sei.mde.morel.ConditionExp#getThenBranch()
	 * @see #getConditionExp()
	 * @generated
	 */
	EReference getConditionExp_ThenBranch();

	/**
	 * Returns the meta object for the containment reference '{@link edu.ustb.sei.mde.morel.ConditionExp#getElseBranch <em>Else Branch</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Else Branch</em>'.
	 * @see edu.ustb.sei.mde.morel.ConditionExp#getElseBranch()
	 * @see #getConditionExp()
	 * @generated
	 */
	EReference getConditionExp_ElseBranch();

	/**
	 * Returns the meta object for class '{@link edu.ustb.sei.mde.morel.BooleanImpliesExp <em>Boolean Implies Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Boolean Implies Exp</em>'.
	 * @see edu.ustb.sei.mde.morel.BooleanImpliesExp
	 * @generated
	 */
	EClass getBooleanImpliesExp();

	/**
	 * Returns the meta object for the containment reference '{@link edu.ustb.sei.mde.morel.BooleanImpliesExp#getLeft <em>Left</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Left</em>'.
	 * @see edu.ustb.sei.mde.morel.BooleanImpliesExp#getLeft()
	 * @see #getBooleanImpliesExp()
	 * @generated
	 */
	EReference getBooleanImpliesExp_Left();

	/**
	 * Returns the meta object for the containment reference '{@link edu.ustb.sei.mde.morel.BooleanImpliesExp#getRight <em>Right</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Right</em>'.
	 * @see edu.ustb.sei.mde.morel.BooleanImpliesExp#getRight()
	 * @see #getBooleanImpliesExp()
	 * @generated
	 */
	EReference getBooleanImpliesExp_Right();

	/**
	 * Returns the meta object for the attribute '{@link edu.ustb.sei.mde.morel.BooleanImpliesExp#getOperator <em>Operator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Operator</em>'.
	 * @see edu.ustb.sei.mde.morel.BooleanImpliesExp#getOperator()
	 * @see #getBooleanImpliesExp()
	 * @generated
	 */
	EAttribute getBooleanImpliesExp_Operator();

	/**
	 * Returns the meta object for class '{@link edu.ustb.sei.mde.morel.BooleanImpliesExpChild <em>Boolean Implies Exp Child</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Boolean Implies Exp Child</em>'.
	 * @see edu.ustb.sei.mde.morel.BooleanImpliesExpChild
	 * @generated
	 */
	EClass getBooleanImpliesExpChild();

	/**
	 * Returns the meta object for class '{@link edu.ustb.sei.mde.morel.BooleanOrExp <em>Boolean Or Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Boolean Or Exp</em>'.
	 * @see edu.ustb.sei.mde.morel.BooleanOrExp
	 * @generated
	 */
	EClass getBooleanOrExp();

	/**
	 * Returns the meta object for the containment reference list '{@link edu.ustb.sei.mde.morel.BooleanOrExp#getChildren <em>Children</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Children</em>'.
	 * @see edu.ustb.sei.mde.morel.BooleanOrExp#getChildren()
	 * @see #getBooleanOrExp()
	 * @generated
	 */
	EReference getBooleanOrExp_Children();

	/**
	 * Returns the meta object for the attribute list '{@link edu.ustb.sei.mde.morel.BooleanOrExp#getOperators <em>Operators</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Operators</em>'.
	 * @see edu.ustb.sei.mde.morel.BooleanOrExp#getOperators()
	 * @see #getBooleanOrExp()
	 * @generated
	 */
	EAttribute getBooleanOrExp_Operators();

	/**
	 * Returns the meta object for class '{@link edu.ustb.sei.mde.morel.BooleanOrExpChild <em>Boolean Or Exp Child</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Boolean Or Exp Child</em>'.
	 * @see edu.ustb.sei.mde.morel.BooleanOrExpChild
	 * @generated
	 */
	EClass getBooleanOrExpChild();

	/**
	 * Returns the meta object for class '{@link edu.ustb.sei.mde.morel.BooleanAndExp <em>Boolean And Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Boolean And Exp</em>'.
	 * @see edu.ustb.sei.mde.morel.BooleanAndExp
	 * @generated
	 */
	EClass getBooleanAndExp();

	/**
	 * Returns the meta object for the containment reference list '{@link edu.ustb.sei.mde.morel.BooleanAndExp#getChildren <em>Children</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Children</em>'.
	 * @see edu.ustb.sei.mde.morel.BooleanAndExp#getChildren()
	 * @see #getBooleanAndExp()
	 * @generated
	 */
	EReference getBooleanAndExp_Children();

	/**
	 * Returns the meta object for the attribute list '{@link edu.ustb.sei.mde.morel.BooleanAndExp#getOperators <em>Operators</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Operators</em>'.
	 * @see edu.ustb.sei.mde.morel.BooleanAndExp#getOperators()
	 * @see #getBooleanAndExp()
	 * @generated
	 */
	EAttribute getBooleanAndExp_Operators();

	/**
	 * Returns the meta object for class '{@link edu.ustb.sei.mde.morel.BooleanAndExpChild <em>Boolean And Exp Child</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Boolean And Exp Child</em>'.
	 * @see edu.ustb.sei.mde.morel.BooleanAndExpChild
	 * @generated
	 */
	EClass getBooleanAndExpChild();

	/**
	 * Returns the meta object for class '{@link edu.ustb.sei.mde.morel.RelationalExp <em>Relational Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Relational Exp</em>'.
	 * @see edu.ustb.sei.mde.morel.RelationalExp
	 * @generated
	 */
	EClass getRelationalExp();

	/**
	 * Returns the meta object for the containment reference '{@link edu.ustb.sei.mde.morel.RelationalExp#getLeft <em>Left</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Left</em>'.
	 * @see edu.ustb.sei.mde.morel.RelationalExp#getLeft()
	 * @see #getRelationalExp()
	 * @generated
	 */
	EReference getRelationalExp_Left();

	/**
	 * Returns the meta object for the containment reference '{@link edu.ustb.sei.mde.morel.RelationalExp#getRight <em>Right</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Right</em>'.
	 * @see edu.ustb.sei.mde.morel.RelationalExp#getRight()
	 * @see #getRelationalExp()
	 * @generated
	 */
	EReference getRelationalExp_Right();

	/**
	 * Returns the meta object for the attribute '{@link edu.ustb.sei.mde.morel.RelationalExp#getOperator <em>Operator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Operator</em>'.
	 * @see edu.ustb.sei.mde.morel.RelationalExp#getOperator()
	 * @see #getRelationalExp()
	 * @generated
	 */
	EAttribute getRelationalExp_Operator();

	/**
	 * Returns the meta object for class '{@link edu.ustb.sei.mde.morel.RelationalExpChild <em>Relational Exp Child</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Relational Exp Child</em>'.
	 * @see edu.ustb.sei.mde.morel.RelationalExpChild
	 * @generated
	 */
	EClass getRelationalExpChild();

	/**
	 * Returns the meta object for class '{@link edu.ustb.sei.mde.morel.AdditiveExp <em>Additive Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Additive Exp</em>'.
	 * @see edu.ustb.sei.mde.morel.AdditiveExp
	 * @generated
	 */
	EClass getAdditiveExp();

	/**
	 * Returns the meta object for the containment reference list '{@link edu.ustb.sei.mde.morel.AdditiveExp#getChildren <em>Children</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Children</em>'.
	 * @see edu.ustb.sei.mde.morel.AdditiveExp#getChildren()
	 * @see #getAdditiveExp()
	 * @generated
	 */
	EReference getAdditiveExp_Children();

	/**
	 * Returns the meta object for the attribute list '{@link edu.ustb.sei.mde.morel.AdditiveExp#getOperators <em>Operators</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Operators</em>'.
	 * @see edu.ustb.sei.mde.morel.AdditiveExp#getOperators()
	 * @see #getAdditiveExp()
	 * @generated
	 */
	EAttribute getAdditiveExp_Operators();

	/**
	 * Returns the meta object for class '{@link edu.ustb.sei.mde.morel.AdditiveExpChild <em>Additive Exp Child</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Additive Exp Child</em>'.
	 * @see edu.ustb.sei.mde.morel.AdditiveExpChild
	 * @generated
	 */
	EClass getAdditiveExpChild();

	/**
	 * Returns the meta object for class '{@link edu.ustb.sei.mde.morel.MultiplicativeExp <em>Multiplicative Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Multiplicative Exp</em>'.
	 * @see edu.ustb.sei.mde.morel.MultiplicativeExp
	 * @generated
	 */
	EClass getMultiplicativeExp();

	/**
	 * Returns the meta object for the containment reference list '{@link edu.ustb.sei.mde.morel.MultiplicativeExp#getChildren <em>Children</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Children</em>'.
	 * @see edu.ustb.sei.mde.morel.MultiplicativeExp#getChildren()
	 * @see #getMultiplicativeExp()
	 * @generated
	 */
	EReference getMultiplicativeExp_Children();

	/**
	 * Returns the meta object for the attribute list '{@link edu.ustb.sei.mde.morel.MultiplicativeExp#getOperators <em>Operators</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Operators</em>'.
	 * @see edu.ustb.sei.mde.morel.MultiplicativeExp#getOperators()
	 * @see #getMultiplicativeExp()
	 * @generated
	 */
	EAttribute getMultiplicativeExp_Operators();

	/**
	 * Returns the meta object for class '{@link edu.ustb.sei.mde.morel.MultiplicativeExpChild <em>Multiplicative Exp Child</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Multiplicative Exp Child</em>'.
	 * @see edu.ustb.sei.mde.morel.MultiplicativeExpChild
	 * @generated
	 */
	EClass getMultiplicativeExpChild();

	/**
	 * Returns the meta object for class '{@link edu.ustb.sei.mde.morel.UnaryExp <em>Unary Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Unary Exp</em>'.
	 * @see edu.ustb.sei.mde.morel.UnaryExp
	 * @generated
	 */
	EClass getUnaryExp();

	/**
	 * Returns the meta object for the attribute '{@link edu.ustb.sei.mde.morel.UnaryExp#getOperator <em>Operator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Operator</em>'.
	 * @see edu.ustb.sei.mde.morel.UnaryExp#getOperator()
	 * @see #getUnaryExp()
	 * @generated
	 */
	EAttribute getUnaryExp_Operator();

	/**
	 * Returns the meta object for the containment reference '{@link edu.ustb.sei.mde.morel.UnaryExp#getChild <em>Child</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Child</em>'.
	 * @see edu.ustb.sei.mde.morel.UnaryExp#getChild()
	 * @see #getUnaryExp()
	 * @generated
	 */
	EReference getUnaryExp_Child();

	/**
	 * Returns the meta object for class '{@link edu.ustb.sei.mde.morel.UnaryExpChild <em>Unary Exp Child</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Unary Exp Child</em>'.
	 * @see edu.ustb.sei.mde.morel.UnaryExpChild
	 * @generated
	 */
	EClass getUnaryExpChild();

	/**
	 * Returns the meta object for class '{@link edu.ustb.sei.mde.morel.CollectionType <em>Collection Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Collection Type</em>'.
	 * @see edu.ustb.sei.mde.morel.CollectionType
	 * @generated
	 */
	EClass getCollectionType();

	/**
	 * Returns the meta object for the reference '{@link edu.ustb.sei.mde.morel.CollectionType#getElementType <em>Element Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Element Type</em>'.
	 * @see edu.ustb.sei.mde.morel.CollectionType#getElementType()
	 * @see #getCollectionType()
	 * @generated
	 */
	EReference getCollectionType_ElementType();

	/**
	 * Returns the meta object for class '{@link edu.ustb.sei.mde.morel.OrderedSetType <em>Ordered Set Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Ordered Set Type</em>'.
	 * @see edu.ustb.sei.mde.morel.OrderedSetType
	 * @generated
	 */
	EClass getOrderedSetType();

	/**
	 * Returns the meta object for class '{@link edu.ustb.sei.mde.morel.SequenceType <em>Sequence Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Sequence Type</em>'.
	 * @see edu.ustb.sei.mde.morel.SequenceType
	 * @generated
	 */
	EClass getSequenceType();

	/**
	 * Returns the meta object for class '{@link edu.ustb.sei.mde.morel.SetType <em>Set Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Set Type</em>'.
	 * @see edu.ustb.sei.mde.morel.SetType
	 * @generated
	 */
	EClass getSetType();

	/**
	 * Returns the meta object for class '{@link edu.ustb.sei.mde.morel.BagType <em>Bag Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Bag Type</em>'.
	 * @see edu.ustb.sei.mde.morel.BagType
	 * @generated
	 */
	EClass getBagType();

	/**
	 * Returns the meta object for class '{@link edu.ustb.sei.mde.morel.ImperativeExp <em>Imperative Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Imperative Exp</em>'.
	 * @see edu.ustb.sei.mde.morel.ImperativeExp
	 * @generated
	 */
	EClass getImperativeExp();

	/**
	 * Returns the meta object for class '{@link edu.ustb.sei.mde.morel.BindExp <em>Bind Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Bind Exp</em>'.
	 * @see edu.ustb.sei.mde.morel.BindExp
	 * @generated
	 */
	EClass getBindExp();

	/**
	 * Returns the meta object for the containment reference '{@link edu.ustb.sei.mde.morel.BindExp#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Source</em>'.
	 * @see edu.ustb.sei.mde.morel.BindExp#getSource()
	 * @see #getBindExp()
	 * @generated
	 */
	EReference getBindExp_Source();

	/**
	 * Returns the meta object for the containment reference '{@link edu.ustb.sei.mde.morel.BindExp#getValueExp <em>Value Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Value Exp</em>'.
	 * @see edu.ustb.sei.mde.morel.BindExp#getValueExp()
	 * @see #getBindExp()
	 * @generated
	 */
	EReference getBindExp_ValueExp();

	/**
	 * Returns the meta object for class '{@link edu.ustb.sei.mde.morel.PredefinedBindExp <em>Predefined Bind Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Predefined Bind Exp</em>'.
	 * @see edu.ustb.sei.mde.morel.PredefinedBindExp
	 * @generated
	 */
	EClass getPredefinedBindExp();

	/**
	 * Returns the meta object for the containment reference '{@link edu.ustb.sei.mde.morel.PredefinedBindExp#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Source</em>'.
	 * @see edu.ustb.sei.mde.morel.PredefinedBindExp#getSource()
	 * @see #getPredefinedBindExp()
	 * @generated
	 */
	EReference getPredefinedBindExp_Source();

	/**
	 * Returns the meta object for the containment reference '{@link edu.ustb.sei.mde.morel.PredefinedBindExp#getValueExp <em>Value Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Value Exp</em>'.
	 * @see edu.ustb.sei.mde.morel.PredefinedBindExp#getValueExp()
	 * @see #getPredefinedBindExp()
	 * @generated
	 */
	EReference getPredefinedBindExp_ValueExp();

	/**
	 * Returns the meta object for class '{@link edu.ustb.sei.mde.morel.IfStatement <em>If Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>If Statement</em>'.
	 * @see edu.ustb.sei.mde.morel.IfStatement
	 * @generated
	 */
	EClass getIfStatement();

	/**
	 * Returns the meta object for the containment reference '{@link edu.ustb.sei.mde.morel.IfStatement#getCondition <em>Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Condition</em>'.
	 * @see edu.ustb.sei.mde.morel.IfStatement#getCondition()
	 * @see #getIfStatement()
	 * @generated
	 */
	EReference getIfStatement_Condition();

	/**
	 * Returns the meta object for the containment reference '{@link edu.ustb.sei.mde.morel.IfStatement#getThenStatement <em>Then Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Then Statement</em>'.
	 * @see edu.ustb.sei.mde.morel.IfStatement#getThenStatement()
	 * @see #getIfStatement()
	 * @generated
	 */
	EReference getIfStatement_ThenStatement();

	/**
	 * Returns the meta object for the containment reference '{@link edu.ustb.sei.mde.morel.IfStatement#getElseStatement <em>Else Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Else Statement</em>'.
	 * @see edu.ustb.sei.mde.morel.IfStatement#getElseStatement()
	 * @see #getIfStatement()
	 * @generated
	 */
	EReference getIfStatement_ElseStatement();

	/**
	 * Returns the meta object for class '{@link edu.ustb.sei.mde.morel.ForStatement <em>For Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>For Statement</em>'.
	 * @see edu.ustb.sei.mde.morel.ForStatement
	 * @generated
	 */
	EClass getForStatement();

	/**
	 * Returns the meta object for the containment reference '{@link edu.ustb.sei.mde.morel.ForStatement#getIterator <em>Iterator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Iterator</em>'.
	 * @see edu.ustb.sei.mde.morel.ForStatement#getIterator()
	 * @see #getForStatement()
	 * @generated
	 */
	EReference getForStatement_Iterator();

	/**
	 * Returns the meta object for the containment reference '{@link edu.ustb.sei.mde.morel.ForStatement#getTerminationExp <em>Termination Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Termination Exp</em>'.
	 * @see edu.ustb.sei.mde.morel.ForStatement#getTerminationExp()
	 * @see #getForStatement()
	 * @generated
	 */
	EReference getForStatement_TerminationExp();

	/**
	 * Returns the meta object for the containment reference '{@link edu.ustb.sei.mde.morel.ForStatement#getStepExp <em>Step Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Step Exp</em>'.
	 * @see edu.ustb.sei.mde.morel.ForStatement#getStepExp()
	 * @see #getForStatement()
	 * @generated
	 */
	EReference getForStatement_StepExp();

	/**
	 * Returns the meta object for the containment reference '{@link edu.ustb.sei.mde.morel.ForStatement#getBodyStatement <em>Body Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Body Statement</em>'.
	 * @see edu.ustb.sei.mde.morel.ForStatement#getBodyStatement()
	 * @see #getForStatement()
	 * @generated
	 */
	EReference getForStatement_BodyStatement();

	/**
	 * Returns the meta object for class '{@link edu.ustb.sei.mde.morel.BlockStatement <em>Block Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Block Statement</em>'.
	 * @see edu.ustb.sei.mde.morel.BlockStatement
	 * @generated
	 */
	EClass getBlockStatement();

	/**
	 * Returns the meta object for the containment reference list '{@link edu.ustb.sei.mde.morel.BlockStatement#getStatements <em>Statements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Statements</em>'.
	 * @see edu.ustb.sei.mde.morel.BlockStatement#getStatements()
	 * @see #getBlockStatement()
	 * @generated
	 */
	EReference getBlockStatement_Statements();

	/**
	 * Returns the meta object for class '{@link edu.ustb.sei.mde.morel.TransformationModel <em>Transformation Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Transformation Model</em>'.
	 * @see edu.ustb.sei.mde.morel.TransformationModel
	 * @generated
	 */
	EClass getTransformationModel();

	/**
	 * Returns the meta object for the containment reference list '{@link edu.ustb.sei.mde.morel.TransformationModel#getRules <em>Rules</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Rules</em>'.
	 * @see edu.ustb.sei.mde.morel.TransformationModel#getRules()
	 * @see #getTransformationModel()
	 * @generated
	 */
	EReference getTransformationModel_Rules();

	/**
	 * Returns the meta object for class '{@link edu.ustb.sei.mde.morel.Rule <em>Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Rule</em>'.
	 * @see edu.ustb.sei.mde.morel.Rule
	 * @generated
	 */
	EClass getRule();

	/**
	 * Returns the meta object for the containment reference list '{@link edu.ustb.sei.mde.morel.Rule#getPatterns <em>Patterns</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Patterns</em>'.
	 * @see edu.ustb.sei.mde.morel.Rule#getPatterns()
	 * @see #getRule()
	 * @generated
	 */
	EReference getRule_Patterns();

	/**
	 * Returns the meta object for class '{@link edu.ustb.sei.mde.morel.Statement <em>Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Statement</em>'.
	 * @see edu.ustb.sei.mde.morel.Statement
	 * @generated
	 */
	EClass getStatement();

	/**
	 * Returns the meta object for class '{@link edu.ustb.sei.mde.morel.DeclarativeStatement <em>Declarative Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Declarative Statement</em>'.
	 * @see edu.ustb.sei.mde.morel.DeclarativeStatement
	 * @generated
	 */
	EClass getDeclarativeStatement();

	/**
	 * Returns the meta object for the containment reference '{@link edu.ustb.sei.mde.morel.DeclarativeStatement#getExpression <em>Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Expression</em>'.
	 * @see edu.ustb.sei.mde.morel.DeclarativeStatement#getExpression()
	 * @see #getDeclarativeStatement()
	 * @generated
	 */
	EReference getDeclarativeStatement_Expression();

	/**
	 * Returns the meta object for class '{@link edu.ustb.sei.mde.morel.ImperativeStatement <em>Imperative Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Imperative Statement</em>'.
	 * @see edu.ustb.sei.mde.morel.ImperativeStatement
	 * @generated
	 */
	EClass getImperativeStatement();

	/**
	 * Returns the meta object for enum '{@link edu.ustb.sei.mde.morel.SectionType <em>Section Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Section Type</em>'.
	 * @see edu.ustb.sei.mde.morel.SectionType
	 * @generated
	 */
	EEnum getSectionType();

	/**
	 * Returns the meta object for enum '{@link edu.ustb.sei.mde.morel.UndefinedLiteral <em>Undefined Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Undefined Literal</em>'.
	 * @see edu.ustb.sei.mde.morel.UndefinedLiteral
	 * @generated
	 */
	EEnum getUndefinedLiteral();

	/**
	 * Returns the meta object for enum '{@link edu.ustb.sei.mde.morel.PredefinedVariable <em>Predefined Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Predefined Variable</em>'.
	 * @see edu.ustb.sei.mde.morel.PredefinedVariable
	 * @generated
	 */
	EEnum getPredefinedVariable();

	/**
	 * Returns the meta object for enum '{@link edu.ustb.sei.mde.morel.OperationSeparator <em>Operation Separator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Operation Separator</em>'.
	 * @see edu.ustb.sei.mde.morel.OperationSeparator
	 * @generated
	 */
	EEnum getOperationSeparator();

	/**
	 * Returns the meta object for enum '{@link edu.ustb.sei.mde.morel.IteratorType <em>Iterator Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Iterator Type</em>'.
	 * @see edu.ustb.sei.mde.morel.IteratorType
	 * @generated
	 */
	EEnum getIteratorType();

	/**
	 * Returns the meta object for enum '{@link edu.ustb.sei.mde.morel.BooleanOperator <em>Boolean Operator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Boolean Operator</em>'.
	 * @see edu.ustb.sei.mde.morel.BooleanOperator
	 * @generated
	 */
	EEnum getBooleanOperator();

	/**
	 * Returns the meta object for enum '{@link edu.ustb.sei.mde.morel.RelationalOperator <em>Relational Operator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Relational Operator</em>'.
	 * @see edu.ustb.sei.mde.morel.RelationalOperator
	 * @generated
	 */
	EEnum getRelationalOperator();

	/**
	 * Returns the meta object for enum '{@link edu.ustb.sei.mde.morel.AdditiveOperator <em>Additive Operator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Additive Operator</em>'.
	 * @see edu.ustb.sei.mde.morel.AdditiveOperator
	 * @generated
	 */
	EEnum getAdditiveOperator();

	/**
	 * Returns the meta object for enum '{@link edu.ustb.sei.mde.morel.MultiplicativeOperator <em>Multiplicative Operator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Multiplicative Operator</em>'.
	 * @see edu.ustb.sei.mde.morel.MultiplicativeOperator
	 * @generated
	 */
	EEnum getMultiplicativeOperator();

	/**
	 * Returns the meta object for enum '{@link edu.ustb.sei.mde.morel.UnaryOperator <em>Unary Operator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Unary Operator</em>'.
	 * @see edu.ustb.sei.mde.morel.UnaryOperator
	 * @generated
	 */
	EEnum getUnaryOperator();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	MorelFactory getMorelFactory();

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
		 * The meta object literal for the '{@link edu.ustb.sei.mde.morel.impl.NamedElementImpl <em>Named Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.ustb.sei.mde.morel.impl.NamedElementImpl
		 * @see edu.ustb.sei.mde.morel.impl.MorelPackageImpl#getNamedElement()
		 * @generated
		 */
		EClass NAMED_ELEMENT = eINSTANCE.getNamedElement();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NAMED_ELEMENT__NAME = eINSTANCE.getNamedElement_Name();

		/**
		 * The meta object literal for the '{@link edu.ustb.sei.mde.morel.impl.SectionImpl <em>Section</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.ustb.sei.mde.morel.impl.SectionImpl
		 * @see edu.ustb.sei.mde.morel.impl.MorelPackageImpl#getSection()
		 * @generated
		 */
		EClass SECTION = eINSTANCE.getSection();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SECTION__TYPE = eINSTANCE.getSection_Type();

		/**
		 * The meta object literal for the '{@link edu.ustb.sei.mde.morel.impl.PatternImpl <em>Pattern</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.ustb.sei.mde.morel.impl.PatternImpl
		 * @see edu.ustb.sei.mde.morel.impl.MorelPackageImpl#getPattern()
		 * @generated
		 */
		EClass PATTERN = eINSTANCE.getPattern();

		/**
		 * The meta object literal for the '<em><b>Variables</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PATTERN__VARIABLES = eINSTANCE.getPattern_Variables();

		/**
		 * The meta object literal for the '<em><b>Link Constraints</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PATTERN__LINK_CONSTRAINTS = eINSTANCE.getPattern_LinkConstraints();

		/**
		 * The meta object literal for the '<em><b>Statements</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PATTERN__STATEMENTS = eINSTANCE.getPattern_Statements();

		/**
		 * The meta object literal for the '{@link edu.ustb.sei.mde.morel.impl.ClauseImpl <em>Clause</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.ustb.sei.mde.morel.impl.ClauseImpl
		 * @see edu.ustb.sei.mde.morel.impl.MorelPackageImpl#getClause()
		 * @generated
		 */
		EClass CLAUSE = eINSTANCE.getClause();

		/**
		 * The meta object literal for the '{@link edu.ustb.sei.mde.morel.impl.VariableImpl <em>Variable</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.ustb.sei.mde.morel.impl.VariableImpl
		 * @see edu.ustb.sei.mde.morel.impl.MorelPackageImpl#getVariable()
		 * @generated
		 */
		EClass VARIABLE = eINSTANCE.getVariable();

		/**
		 * The meta object literal for the '{@link edu.ustb.sei.mde.morel.impl.ObjectVariableImpl <em>Object Variable</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.ustb.sei.mde.morel.impl.ObjectVariableImpl
		 * @see edu.ustb.sei.mde.morel.impl.MorelPackageImpl#getObjectVariable()
		 * @generated
		 */
		EClass OBJECT_VARIABLE = eINSTANCE.getObjectVariable();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OBJECT_VARIABLE__TYPE = eINSTANCE.getObjectVariable_Type();

		/**
		 * The meta object literal for the '<em><b>Model</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OBJECT_VARIABLE__MODEL = eINSTANCE.getObjectVariable_Model();

		/**
		 * The meta object literal for the '{@link edu.ustb.sei.mde.morel.impl.PrimitiveVariableImpl <em>Primitive Variable</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.ustb.sei.mde.morel.impl.PrimitiveVariableImpl
		 * @see edu.ustb.sei.mde.morel.impl.MorelPackageImpl#getPrimitiveVariable()
		 * @generated
		 */
		EClass PRIMITIVE_VARIABLE = eINSTANCE.getPrimitiveVariable();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PRIMITIVE_VARIABLE__TYPE = eINSTANCE.getPrimitiveVariable_Type();

		/**
		 * The meta object literal for the '{@link edu.ustb.sei.mde.morel.impl.LinkConstraintImpl <em>Link Constraint</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.ustb.sei.mde.morel.impl.LinkConstraintImpl
		 * @see edu.ustb.sei.mde.morel.impl.MorelPackageImpl#getLinkConstraint()
		 * @generated
		 */
		EClass LINK_CONSTRAINT = eINSTANCE.getLinkConstraint();

		/**
		 * The meta object literal for the '<em><b>Source</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LINK_CONSTRAINT__SOURCE = eINSTANCE.getLinkConstraint_Source();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LINK_CONSTRAINT__TARGET = eINSTANCE.getLinkConstraint_Target();

		/**
		 * The meta object literal for the '{@link edu.ustb.sei.mde.morel.impl.SimpleLinkConstraintImpl <em>Simple Link Constraint</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.ustb.sei.mde.morel.impl.SimpleLinkConstraintImpl
		 * @see edu.ustb.sei.mde.morel.impl.MorelPackageImpl#getSimpleLinkConstraint()
		 * @generated
		 */
		EClass SIMPLE_LINK_CONSTRAINT = eINSTANCE.getSimpleLinkConstraint();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SIMPLE_LINK_CONSTRAINT__ID = eINSTANCE.getSimpleLinkConstraint_Id();

		/**
		 * The meta object literal for the '<em><b>Reference</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SIMPLE_LINK_CONSTRAINT__REFERENCE = eINSTANCE.getSimpleLinkConstraint_Reference();

		/**
		 * The meta object literal for the '{@link edu.ustb.sei.mde.morel.impl.EnclosureLinkConstraintImpl <em>Enclosure Link Constraint</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.ustb.sei.mde.morel.impl.EnclosureLinkConstraintImpl
		 * @see edu.ustb.sei.mde.morel.impl.MorelPackageImpl#getEnclosureLinkConstraint()
		 * @generated
		 */
		EClass ENCLOSURE_LINK_CONSTRAINT = eINSTANCE.getEnclosureLinkConstraint();

		/**
		 * The meta object literal for the '<em><b>Forward</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ENCLOSURE_LINK_CONSTRAINT__FORWARD = eINSTANCE.getEnclosureLinkConstraint_Forward();

		/**
		 * The meta object literal for the '<em><b>Types</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ENCLOSURE_LINK_CONSTRAINT__TYPES = eINSTANCE.getEnclosureLinkConstraint_Types();

		/**
		 * The meta object literal for the '{@link edu.ustb.sei.mde.morel.impl.PathConstraintImpl <em>Path Constraint</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.ustb.sei.mde.morel.impl.PathConstraintImpl
		 * @see edu.ustb.sei.mde.morel.impl.MorelPackageImpl#getPathConstraint()
		 * @generated
		 */
		EClass PATH_CONSTRAINT = eINSTANCE.getPathConstraint();

		/**
		 * The meta object literal for the '<em><b>Min Length</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PATH_CONSTRAINT__MIN_LENGTH = eINSTANCE.getPathConstraint_MinLength();

		/**
		 * The meta object literal for the '<em><b>Max Length</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PATH_CONSTRAINT__MAX_LENGTH = eINSTANCE.getPathConstraint_MaxLength();

		/**
		 * The meta object literal for the '<em><b>Path Variable</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PATH_CONSTRAINT__PATH_VARIABLE = eINSTANCE.getPathConstraint_PathVariable();

		/**
		 * The meta object literal for the '<em><b>References</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PATH_CONSTRAINT__REFERENCES = eINSTANCE.getPathConstraint_References();

		/**
		 * The meta object literal for the '<em><b>Types</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PATH_CONSTRAINT__TYPES = eINSTANCE.getPathConstraint_Types();

		/**
		 * The meta object literal for the '{@link edu.ustb.sei.mde.morel.impl.QueryModelImpl <em>Query Model</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.ustb.sei.mde.morel.impl.QueryModelImpl
		 * @see edu.ustb.sei.mde.morel.impl.MorelPackageImpl#getQueryModel()
		 * @generated
		 */
		EClass QUERY_MODEL = eINSTANCE.getQueryModel();

		/**
		 * The meta object literal for the '<em><b>Queries</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference QUERY_MODEL__QUERIES = eINSTANCE.getQueryModel_Queries();

		/**
		 * The meta object literal for the '{@link edu.ustb.sei.mde.morel.impl.TypedModelImpl <em>Typed Model</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.ustb.sei.mde.morel.impl.TypedModelImpl
		 * @see edu.ustb.sei.mde.morel.impl.MorelPackageImpl#getTypedModel()
		 * @generated
		 */
		EClass TYPED_MODEL = eINSTANCE.getTypedModel();

		/**
		 * The meta object literal for the '<em><b>Package</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TYPED_MODEL__PACKAGE = eINSTANCE.getTypedModel_Package();

		/**
		 * The meta object literal for the '{@link edu.ustb.sei.mde.morel.impl.QueryImpl <em>Query</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.ustb.sei.mde.morel.impl.QueryImpl
		 * @see edu.ustb.sei.mde.morel.impl.MorelPackageImpl#getQuery()
		 * @generated
		 */
		EClass QUERY = eINSTANCE.getQuery();

		/**
		 * The meta object literal for the '{@link edu.ustb.sei.mde.morel.impl.UnitImpl <em>Unit</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.ustb.sei.mde.morel.impl.UnitImpl
		 * @see edu.ustb.sei.mde.morel.impl.MorelPackageImpl#getUnit()
		 * @generated
		 */
		EClass UNIT = eINSTANCE.getUnit();

		/**
		 * The meta object literal for the '<em><b>Models</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference UNIT__MODELS = eINSTANCE.getUnit_Models();

		/**
		 * The meta object literal for the '<em><b>Data Types</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference UNIT__DATA_TYPES = eINSTANCE.getUnit_DataTypes();

		/**
		 * The meta object literal for the '<em><b>Get Typed Model</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation UNIT___GET_TYPED_MODEL__STRING = eINSTANCE.getUnit__GetTypedModel__String();

		/**
		 * The meta object literal for the '{@link edu.ustb.sei.mde.morel.impl.ExpressionImpl <em>Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.ustb.sei.mde.morel.impl.ExpressionImpl
		 * @see edu.ustb.sei.mde.morel.impl.MorelPackageImpl#getExpression()
		 * @generated
		 */
		EClass EXPRESSION = eINSTANCE.getExpression();

		/**
		 * The meta object literal for the '{@link edu.ustb.sei.mde.morel.impl.AtomicExpImpl <em>Atomic Exp</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.ustb.sei.mde.morel.impl.AtomicExpImpl
		 * @see edu.ustb.sei.mde.morel.impl.MorelPackageImpl#getAtomicExp()
		 * @generated
		 */
		EClass ATOMIC_EXP = eINSTANCE.getAtomicExp();

		/**
		 * The meta object literal for the '<em><b>Path</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ATOMIC_EXP__PATH = eINSTANCE.getAtomicExp_Path();

		/**
		 * The meta object literal for the '{@link edu.ustb.sei.mde.morel.impl.LiteralExpImpl <em>Literal Exp</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.ustb.sei.mde.morel.impl.LiteralExpImpl
		 * @see edu.ustb.sei.mde.morel.impl.MorelPackageImpl#getLiteralExp()
		 * @generated
		 */
		EClass LITERAL_EXP = eINSTANCE.getLiteralExp();

		/**
		 * The meta object literal for the '{@link edu.ustb.sei.mde.morel.impl.StringLiteralExpImpl <em>String Literal Exp</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.ustb.sei.mde.morel.impl.StringLiteralExpImpl
		 * @see edu.ustb.sei.mde.morel.impl.MorelPackageImpl#getStringLiteralExp()
		 * @generated
		 */
		EClass STRING_LITERAL_EXP = eINSTANCE.getStringLiteralExp();

		/**
		 * The meta object literal for the '<em><b>String Symbol</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STRING_LITERAL_EXP__STRING_SYMBOL = eINSTANCE.getStringLiteralExp_StringSymbol();

		/**
		 * The meta object literal for the '{@link edu.ustb.sei.mde.morel.impl.IntegerLiteralExpImpl <em>Integer Literal Exp</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.ustb.sei.mde.morel.impl.IntegerLiteralExpImpl
		 * @see edu.ustb.sei.mde.morel.impl.MorelPackageImpl#getIntegerLiteralExp()
		 * @generated
		 */
		EClass INTEGER_LITERAL_EXP = eINSTANCE.getIntegerLiteralExp();

		/**
		 * The meta object literal for the '<em><b>Integer Symbol</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INTEGER_LITERAL_EXP__INTEGER_SYMBOL = eINSTANCE.getIntegerLiteralExp_IntegerSymbol();

		/**
		 * The meta object literal for the '{@link edu.ustb.sei.mde.morel.impl.RealLiteralExpImpl <em>Real Literal Exp</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.ustb.sei.mde.morel.impl.RealLiteralExpImpl
		 * @see edu.ustb.sei.mde.morel.impl.MorelPackageImpl#getRealLiteralExp()
		 * @generated
		 */
		EClass REAL_LITERAL_EXP = eINSTANCE.getRealLiteralExp();

		/**
		 * The meta object literal for the '<em><b>Real Symbol</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REAL_LITERAL_EXP__REAL_SYMBOL = eINSTANCE.getRealLiteralExp_RealSymbol();

		/**
		 * The meta object literal for the '{@link edu.ustb.sei.mde.morel.impl.BooleanLiteralExpImpl <em>Boolean Literal Exp</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.ustb.sei.mde.morel.impl.BooleanLiteralExpImpl
		 * @see edu.ustb.sei.mde.morel.impl.MorelPackageImpl#getBooleanLiteralExp()
		 * @generated
		 */
		EClass BOOLEAN_LITERAL_EXP = eINSTANCE.getBooleanLiteralExp();

		/**
		 * The meta object literal for the '<em><b>Bool Symbol</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BOOLEAN_LITERAL_EXP__BOOL_SYMBOL = eINSTANCE.getBooleanLiteralExp_BoolSymbol();

		/**
		 * The meta object literal for the '{@link edu.ustb.sei.mde.morel.impl.UndefinedLiteralExpImpl <em>Undefined Literal Exp</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.ustb.sei.mde.morel.impl.UndefinedLiteralExpImpl
		 * @see edu.ustb.sei.mde.morel.impl.MorelPackageImpl#getUndefinedLiteralExp()
		 * @generated
		 */
		EClass UNDEFINED_LITERAL_EXP = eINSTANCE.getUndefinedLiteralExp();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute UNDEFINED_LITERAL_EXP__VALUE = eINSTANCE.getUndefinedLiteralExp_Value();

		/**
		 * The meta object literal for the '{@link edu.ustb.sei.mde.morel.impl.CollectionLiteralExpImpl <em>Collection Literal Exp</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.ustb.sei.mde.morel.impl.CollectionLiteralExpImpl
		 * @see edu.ustb.sei.mde.morel.impl.MorelPackageImpl#getCollectionLiteralExp()
		 * @generated
		 */
		EClass COLLECTION_LITERAL_EXP = eINSTANCE.getCollectionLiteralExp();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COLLECTION_LITERAL_EXP__TYPE = eINSTANCE.getCollectionLiteralExp_Type();

		/**
		 * The meta object literal for the '<em><b>Literals</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COLLECTION_LITERAL_EXP__LITERALS = eINSTANCE.getCollectionLiteralExp_Literals();

		/**
		 * The meta object literal for the '{@link edu.ustb.sei.mde.morel.impl.EnumLiteralExpImpl <em>Enum Literal Exp</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.ustb.sei.mde.morel.impl.EnumLiteralExpImpl
		 * @see edu.ustb.sei.mde.morel.impl.MorelPackageImpl#getEnumLiteralExp()
		 * @generated
		 */
		EClass ENUM_LITERAL_EXP = eINSTANCE.getEnumLiteralExp();

		/**
		 * The meta object literal for the '<em><b>Enum Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ENUM_LITERAL_EXP__ENUM_TYPE = eINSTANCE.getEnumLiteralExp_EnumType();

		/**
		 * The meta object literal for the '<em><b>Enum Symbol</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ENUM_LITERAL_EXP__ENUM_SYMBOL = eINSTANCE.getEnumLiteralExp_EnumSymbol();

		/**
		 * The meta object literal for the '{@link edu.ustb.sei.mde.morel.impl.TypeLiteralExpImpl <em>Type Literal Exp</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.ustb.sei.mde.morel.impl.TypeLiteralExpImpl
		 * @see edu.ustb.sei.mde.morel.impl.MorelPackageImpl#getTypeLiteralExp()
		 * @generated
		 */
		EClass TYPE_LITERAL_EXP = eINSTANCE.getTypeLiteralExp();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TYPE_LITERAL_EXP__VALUE = eINSTANCE.getTypeLiteralExp_Value();

		/**
		 * The meta object literal for the '{@link edu.ustb.sei.mde.morel.impl.VariableExpImpl <em>Variable Exp</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.ustb.sei.mde.morel.impl.VariableExpImpl
		 * @see edu.ustb.sei.mde.morel.impl.MorelPackageImpl#getVariableExp()
		 * @generated
		 */
		EClass VARIABLE_EXP = eINSTANCE.getVariableExp();

		/**
		 * The meta object literal for the '<em><b>Referred Variable</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VARIABLE_EXP__REFERRED_VARIABLE = eINSTANCE.getVariableExp_ReferredVariable();

		/**
		 * The meta object literal for the '{@link edu.ustb.sei.mde.morel.impl.PredefinedVariableExpImpl <em>Predefined Variable Exp</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.ustb.sei.mde.morel.impl.PredefinedVariableExpImpl
		 * @see edu.ustb.sei.mde.morel.impl.MorelPackageImpl#getPredefinedVariableExp()
		 * @generated
		 */
		EClass PREDEFINED_VARIABLE_EXP = eINSTANCE.getPredefinedVariableExp();

		/**
		 * The meta object literal for the '<em><b>Variable</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PREDEFINED_VARIABLE_EXP__VARIABLE = eINSTANCE.getPredefinedVariableExp_Variable();

		/**
		 * The meta object literal for the '{@link edu.ustb.sei.mde.morel.impl.NestedExpImpl <em>Nested Exp</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.ustb.sei.mde.morel.impl.NestedExpImpl
		 * @see edu.ustb.sei.mde.morel.impl.MorelPackageImpl#getNestedExp()
		 * @generated
		 */
		EClass NESTED_EXP = eINSTANCE.getNestedExp();

		/**
		 * The meta object literal for the '<em><b>Expression</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NESTED_EXP__EXPRESSION = eINSTANCE.getNestedExp_Expression();

		/**
		 * The meta object literal for the '{@link edu.ustb.sei.mde.morel.impl.CallPathExpImpl <em>Call Path Exp</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.ustb.sei.mde.morel.impl.CallPathExpImpl
		 * @see edu.ustb.sei.mde.morel.impl.MorelPackageImpl#getCallPathExp()
		 * @generated
		 */
		EClass CALL_PATH_EXP = eINSTANCE.getCallPathExp();

		/**
		 * The meta object literal for the '<em><b>Next</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CALL_PATH_EXP__NEXT = eINSTANCE.getCallPathExp_Next();

		/**
		 * The meta object literal for the '{@link edu.ustb.sei.mde.morel.impl.FeaturePathExpImpl <em>Feature Path Exp</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.ustb.sei.mde.morel.impl.FeaturePathExpImpl
		 * @see edu.ustb.sei.mde.morel.impl.MorelPackageImpl#getFeaturePathExp()
		 * @generated
		 */
		EClass FEATURE_PATH_EXP = eINSTANCE.getFeaturePathExp();

		/**
		 * The meta object literal for the '<em><b>Feature</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FEATURE_PATH_EXP__FEATURE = eINSTANCE.getFeaturePathExp_Feature();

		/**
		 * The meta object literal for the '{@link edu.ustb.sei.mde.morel.impl.OperationPathExpImpl <em>Operation Path Exp</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.ustb.sei.mde.morel.impl.OperationPathExpImpl
		 * @see edu.ustb.sei.mde.morel.impl.MorelPackageImpl#getOperationPathExp()
		 * @generated
		 */
		EClass OPERATION_PATH_EXP = eINSTANCE.getOperationPathExp();

		/**
		 * The meta object literal for the '<em><b>Separator</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OPERATION_PATH_EXP__SEPARATOR = eINSTANCE.getOperationPathExp_Separator();

		/**
		 * The meta object literal for the '<em><b>Operation</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OPERATION_PATH_EXP__OPERATION = eINSTANCE.getOperationPathExp_Operation();

		/**
		 * The meta object literal for the '<em><b>Parameters</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPERATION_PATH_EXP__PARAMETERS = eINSTANCE.getOperationPathExp_Parameters();

		/**
		 * The meta object literal for the '{@link edu.ustb.sei.mde.morel.impl.LoopPathExpImpl <em>Loop Path Exp</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.ustb.sei.mde.morel.impl.LoopPathExpImpl
		 * @see edu.ustb.sei.mde.morel.impl.MorelPackageImpl#getLoopPathExp()
		 * @generated
		 */
		EClass LOOP_PATH_EXP = eINSTANCE.getLoopPathExp();

		/**
		 * The meta object literal for the '{@link edu.ustb.sei.mde.morel.impl.IteratorPathExpImpl <em>Iterator Path Exp</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.ustb.sei.mde.morel.impl.IteratorPathExpImpl
		 * @see edu.ustb.sei.mde.morel.impl.MorelPackageImpl#getIteratorPathExp()
		 * @generated
		 */
		EClass ITERATOR_PATH_EXP = eINSTANCE.getIteratorPathExp();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ITERATOR_PATH_EXP__TYPE = eINSTANCE.getIteratorPathExp_Type();

		/**
		 * The meta object literal for the '<em><b>First Var</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ITERATOR_PATH_EXP__FIRST_VAR = eINSTANCE.getIteratorPathExp_FirstVar();

		/**
		 * The meta object literal for the '<em><b>Second Var</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ITERATOR_PATH_EXP__SECOND_VAR = eINSTANCE.getIteratorPathExp_SecondVar();

		/**
		 * The meta object literal for the '<em><b>Body Exp</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ITERATOR_PATH_EXP__BODY_EXP = eINSTANCE.getIteratorPathExp_BodyExp();

		/**
		 * The meta object literal for the '{@link edu.ustb.sei.mde.morel.impl.LetExpImpl <em>Let Exp</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.ustb.sei.mde.morel.impl.LetExpImpl
		 * @see edu.ustb.sei.mde.morel.impl.MorelPackageImpl#getLetExp()
		 * @generated
		 */
		EClass LET_EXP = eINSTANCE.getLetExp();

		/**
		 * The meta object literal for the '<em><b>Variables</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LET_EXP__VARIABLES = eINSTANCE.getLetExp_Variables();

		/**
		 * The meta object literal for the '<em><b>In Exp</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LET_EXP__IN_EXP = eINSTANCE.getLetExp_InExp();

		/**
		 * The meta object literal for the '{@link edu.ustb.sei.mde.morel.impl.VariableWithInitImpl <em>Variable With Init</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.ustb.sei.mde.morel.impl.VariableWithInitImpl
		 * @see edu.ustb.sei.mde.morel.impl.MorelPackageImpl#getVariableWithInit()
		 * @generated
		 */
		EClass VARIABLE_WITH_INIT = eINSTANCE.getVariableWithInit();

		/**
		 * The meta object literal for the '<em><b>Init Exp</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VARIABLE_WITH_INIT__INIT_EXP = eINSTANCE.getVariableWithInit_InitExp();

		/**
		 * The meta object literal for the '{@link edu.ustb.sei.mde.morel.impl.ObjectVariableWithInitImpl <em>Object Variable With Init</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.ustb.sei.mde.morel.impl.ObjectVariableWithInitImpl
		 * @see edu.ustb.sei.mde.morel.impl.MorelPackageImpl#getObjectVariableWithInit()
		 * @generated
		 */
		EClass OBJECT_VARIABLE_WITH_INIT = eINSTANCE.getObjectVariableWithInit();

		/**
		 * The meta object literal for the '{@link edu.ustb.sei.mde.morel.impl.PrimitiveVariableWithInitImpl <em>Primitive Variable With Init</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.ustb.sei.mde.morel.impl.PrimitiveVariableWithInitImpl
		 * @see edu.ustb.sei.mde.morel.impl.MorelPackageImpl#getPrimitiveVariableWithInit()
		 * @generated
		 */
		EClass PRIMITIVE_VARIABLE_WITH_INIT = eINSTANCE.getPrimitiveVariableWithInit();

		/**
		 * The meta object literal for the '{@link edu.ustb.sei.mde.morel.impl.ConditionExpImpl <em>Condition Exp</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.ustb.sei.mde.morel.impl.ConditionExpImpl
		 * @see edu.ustb.sei.mde.morel.impl.MorelPackageImpl#getConditionExp()
		 * @generated
		 */
		EClass CONDITION_EXP = eINSTANCE.getConditionExp();

		/**
		 * The meta object literal for the '<em><b>Condition</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONDITION_EXP__CONDITION = eINSTANCE.getConditionExp_Condition();

		/**
		 * The meta object literal for the '<em><b>Then Branch</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONDITION_EXP__THEN_BRANCH = eINSTANCE.getConditionExp_ThenBranch();

		/**
		 * The meta object literal for the '<em><b>Else Branch</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONDITION_EXP__ELSE_BRANCH = eINSTANCE.getConditionExp_ElseBranch();

		/**
		 * The meta object literal for the '{@link edu.ustb.sei.mde.morel.impl.BooleanImpliesExpImpl <em>Boolean Implies Exp</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.ustb.sei.mde.morel.impl.BooleanImpliesExpImpl
		 * @see edu.ustb.sei.mde.morel.impl.MorelPackageImpl#getBooleanImpliesExp()
		 * @generated
		 */
		EClass BOOLEAN_IMPLIES_EXP = eINSTANCE.getBooleanImpliesExp();

		/**
		 * The meta object literal for the '<em><b>Left</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BOOLEAN_IMPLIES_EXP__LEFT = eINSTANCE.getBooleanImpliesExp_Left();

		/**
		 * The meta object literal for the '<em><b>Right</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BOOLEAN_IMPLIES_EXP__RIGHT = eINSTANCE.getBooleanImpliesExp_Right();

		/**
		 * The meta object literal for the '<em><b>Operator</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BOOLEAN_IMPLIES_EXP__OPERATOR = eINSTANCE.getBooleanImpliesExp_Operator();

		/**
		 * The meta object literal for the '{@link edu.ustb.sei.mde.morel.impl.BooleanImpliesExpChildImpl <em>Boolean Implies Exp Child</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.ustb.sei.mde.morel.impl.BooleanImpliesExpChildImpl
		 * @see edu.ustb.sei.mde.morel.impl.MorelPackageImpl#getBooleanImpliesExpChild()
		 * @generated
		 */
		EClass BOOLEAN_IMPLIES_EXP_CHILD = eINSTANCE.getBooleanImpliesExpChild();

		/**
		 * The meta object literal for the '{@link edu.ustb.sei.mde.morel.impl.BooleanOrExpImpl <em>Boolean Or Exp</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.ustb.sei.mde.morel.impl.BooleanOrExpImpl
		 * @see edu.ustb.sei.mde.morel.impl.MorelPackageImpl#getBooleanOrExp()
		 * @generated
		 */
		EClass BOOLEAN_OR_EXP = eINSTANCE.getBooleanOrExp();

		/**
		 * The meta object literal for the '<em><b>Children</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BOOLEAN_OR_EXP__CHILDREN = eINSTANCE.getBooleanOrExp_Children();

		/**
		 * The meta object literal for the '<em><b>Operators</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BOOLEAN_OR_EXP__OPERATORS = eINSTANCE.getBooleanOrExp_Operators();

		/**
		 * The meta object literal for the '{@link edu.ustb.sei.mde.morel.impl.BooleanOrExpChildImpl <em>Boolean Or Exp Child</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.ustb.sei.mde.morel.impl.BooleanOrExpChildImpl
		 * @see edu.ustb.sei.mde.morel.impl.MorelPackageImpl#getBooleanOrExpChild()
		 * @generated
		 */
		EClass BOOLEAN_OR_EXP_CHILD = eINSTANCE.getBooleanOrExpChild();

		/**
		 * The meta object literal for the '{@link edu.ustb.sei.mde.morel.impl.BooleanAndExpImpl <em>Boolean And Exp</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.ustb.sei.mde.morel.impl.BooleanAndExpImpl
		 * @see edu.ustb.sei.mde.morel.impl.MorelPackageImpl#getBooleanAndExp()
		 * @generated
		 */
		EClass BOOLEAN_AND_EXP = eINSTANCE.getBooleanAndExp();

		/**
		 * The meta object literal for the '<em><b>Children</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BOOLEAN_AND_EXP__CHILDREN = eINSTANCE.getBooleanAndExp_Children();

		/**
		 * The meta object literal for the '<em><b>Operators</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BOOLEAN_AND_EXP__OPERATORS = eINSTANCE.getBooleanAndExp_Operators();

		/**
		 * The meta object literal for the '{@link edu.ustb.sei.mde.morel.impl.BooleanAndExpChildImpl <em>Boolean And Exp Child</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.ustb.sei.mde.morel.impl.BooleanAndExpChildImpl
		 * @see edu.ustb.sei.mde.morel.impl.MorelPackageImpl#getBooleanAndExpChild()
		 * @generated
		 */
		EClass BOOLEAN_AND_EXP_CHILD = eINSTANCE.getBooleanAndExpChild();

		/**
		 * The meta object literal for the '{@link edu.ustb.sei.mde.morel.impl.RelationalExpImpl <em>Relational Exp</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.ustb.sei.mde.morel.impl.RelationalExpImpl
		 * @see edu.ustb.sei.mde.morel.impl.MorelPackageImpl#getRelationalExp()
		 * @generated
		 */
		EClass RELATIONAL_EXP = eINSTANCE.getRelationalExp();

		/**
		 * The meta object literal for the '<em><b>Left</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RELATIONAL_EXP__LEFT = eINSTANCE.getRelationalExp_Left();

		/**
		 * The meta object literal for the '<em><b>Right</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RELATIONAL_EXP__RIGHT = eINSTANCE.getRelationalExp_Right();

		/**
		 * The meta object literal for the '<em><b>Operator</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RELATIONAL_EXP__OPERATOR = eINSTANCE.getRelationalExp_Operator();

		/**
		 * The meta object literal for the '{@link edu.ustb.sei.mde.morel.impl.RelationalExpChildImpl <em>Relational Exp Child</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.ustb.sei.mde.morel.impl.RelationalExpChildImpl
		 * @see edu.ustb.sei.mde.morel.impl.MorelPackageImpl#getRelationalExpChild()
		 * @generated
		 */
		EClass RELATIONAL_EXP_CHILD = eINSTANCE.getRelationalExpChild();

		/**
		 * The meta object literal for the '{@link edu.ustb.sei.mde.morel.impl.AdditiveExpImpl <em>Additive Exp</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.ustb.sei.mde.morel.impl.AdditiveExpImpl
		 * @see edu.ustb.sei.mde.morel.impl.MorelPackageImpl#getAdditiveExp()
		 * @generated
		 */
		EClass ADDITIVE_EXP = eINSTANCE.getAdditiveExp();

		/**
		 * The meta object literal for the '<em><b>Children</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ADDITIVE_EXP__CHILDREN = eINSTANCE.getAdditiveExp_Children();

		/**
		 * The meta object literal for the '<em><b>Operators</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ADDITIVE_EXP__OPERATORS = eINSTANCE.getAdditiveExp_Operators();

		/**
		 * The meta object literal for the '{@link edu.ustb.sei.mde.morel.impl.AdditiveExpChildImpl <em>Additive Exp Child</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.ustb.sei.mde.morel.impl.AdditiveExpChildImpl
		 * @see edu.ustb.sei.mde.morel.impl.MorelPackageImpl#getAdditiveExpChild()
		 * @generated
		 */
		EClass ADDITIVE_EXP_CHILD = eINSTANCE.getAdditiveExpChild();

		/**
		 * The meta object literal for the '{@link edu.ustb.sei.mde.morel.impl.MultiplicativeExpImpl <em>Multiplicative Exp</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.ustb.sei.mde.morel.impl.MultiplicativeExpImpl
		 * @see edu.ustb.sei.mde.morel.impl.MorelPackageImpl#getMultiplicativeExp()
		 * @generated
		 */
		EClass MULTIPLICATIVE_EXP = eINSTANCE.getMultiplicativeExp();

		/**
		 * The meta object literal for the '<em><b>Children</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MULTIPLICATIVE_EXP__CHILDREN = eINSTANCE.getMultiplicativeExp_Children();

		/**
		 * The meta object literal for the '<em><b>Operators</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MULTIPLICATIVE_EXP__OPERATORS = eINSTANCE.getMultiplicativeExp_Operators();

		/**
		 * The meta object literal for the '{@link edu.ustb.sei.mde.morel.impl.MultiplicativeExpChildImpl <em>Multiplicative Exp Child</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.ustb.sei.mde.morel.impl.MultiplicativeExpChildImpl
		 * @see edu.ustb.sei.mde.morel.impl.MorelPackageImpl#getMultiplicativeExpChild()
		 * @generated
		 */
		EClass MULTIPLICATIVE_EXP_CHILD = eINSTANCE.getMultiplicativeExpChild();

		/**
		 * The meta object literal for the '{@link edu.ustb.sei.mde.morel.impl.UnaryExpImpl <em>Unary Exp</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.ustb.sei.mde.morel.impl.UnaryExpImpl
		 * @see edu.ustb.sei.mde.morel.impl.MorelPackageImpl#getUnaryExp()
		 * @generated
		 */
		EClass UNARY_EXP = eINSTANCE.getUnaryExp();

		/**
		 * The meta object literal for the '<em><b>Operator</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute UNARY_EXP__OPERATOR = eINSTANCE.getUnaryExp_Operator();

		/**
		 * The meta object literal for the '<em><b>Child</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference UNARY_EXP__CHILD = eINSTANCE.getUnaryExp_Child();

		/**
		 * The meta object literal for the '{@link edu.ustb.sei.mde.morel.impl.UnaryExpChildImpl <em>Unary Exp Child</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.ustb.sei.mde.morel.impl.UnaryExpChildImpl
		 * @see edu.ustb.sei.mde.morel.impl.MorelPackageImpl#getUnaryExpChild()
		 * @generated
		 */
		EClass UNARY_EXP_CHILD = eINSTANCE.getUnaryExpChild();

		/**
		 * The meta object literal for the '{@link edu.ustb.sei.mde.morel.impl.CollectionTypeImpl <em>Collection Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.ustb.sei.mde.morel.impl.CollectionTypeImpl
		 * @see edu.ustb.sei.mde.morel.impl.MorelPackageImpl#getCollectionType()
		 * @generated
		 */
		EClass COLLECTION_TYPE = eINSTANCE.getCollectionType();

		/**
		 * The meta object literal for the '<em><b>Element Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COLLECTION_TYPE__ELEMENT_TYPE = eINSTANCE.getCollectionType_ElementType();

		/**
		 * The meta object literal for the '{@link edu.ustb.sei.mde.morel.impl.OrderedSetTypeImpl <em>Ordered Set Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.ustb.sei.mde.morel.impl.OrderedSetTypeImpl
		 * @see edu.ustb.sei.mde.morel.impl.MorelPackageImpl#getOrderedSetType()
		 * @generated
		 */
		EClass ORDERED_SET_TYPE = eINSTANCE.getOrderedSetType();

		/**
		 * The meta object literal for the '{@link edu.ustb.sei.mde.morel.impl.SequenceTypeImpl <em>Sequence Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.ustb.sei.mde.morel.impl.SequenceTypeImpl
		 * @see edu.ustb.sei.mde.morel.impl.MorelPackageImpl#getSequenceType()
		 * @generated
		 */
		EClass SEQUENCE_TYPE = eINSTANCE.getSequenceType();

		/**
		 * The meta object literal for the '{@link edu.ustb.sei.mde.morel.impl.SetTypeImpl <em>Set Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.ustb.sei.mde.morel.impl.SetTypeImpl
		 * @see edu.ustb.sei.mde.morel.impl.MorelPackageImpl#getSetType()
		 * @generated
		 */
		EClass SET_TYPE = eINSTANCE.getSetType();

		/**
		 * The meta object literal for the '{@link edu.ustb.sei.mde.morel.impl.BagTypeImpl <em>Bag Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.ustb.sei.mde.morel.impl.BagTypeImpl
		 * @see edu.ustb.sei.mde.morel.impl.MorelPackageImpl#getBagType()
		 * @generated
		 */
		EClass BAG_TYPE = eINSTANCE.getBagType();

		/**
		 * The meta object literal for the '{@link edu.ustb.sei.mde.morel.impl.ImperativeExpImpl <em>Imperative Exp</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.ustb.sei.mde.morel.impl.ImperativeExpImpl
		 * @see edu.ustb.sei.mde.morel.impl.MorelPackageImpl#getImperativeExp()
		 * @generated
		 */
		EClass IMPERATIVE_EXP = eINSTANCE.getImperativeExp();

		/**
		 * The meta object literal for the '{@link edu.ustb.sei.mde.morel.impl.BindExpImpl <em>Bind Exp</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.ustb.sei.mde.morel.impl.BindExpImpl
		 * @see edu.ustb.sei.mde.morel.impl.MorelPackageImpl#getBindExp()
		 * @generated
		 */
		EClass BIND_EXP = eINSTANCE.getBindExp();

		/**
		 * The meta object literal for the '<em><b>Source</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BIND_EXP__SOURCE = eINSTANCE.getBindExp_Source();

		/**
		 * The meta object literal for the '<em><b>Value Exp</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BIND_EXP__VALUE_EXP = eINSTANCE.getBindExp_ValueExp();

		/**
		 * The meta object literal for the '{@link edu.ustb.sei.mde.morel.impl.PredefinedBindExpImpl <em>Predefined Bind Exp</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.ustb.sei.mde.morel.impl.PredefinedBindExpImpl
		 * @see edu.ustb.sei.mde.morel.impl.MorelPackageImpl#getPredefinedBindExp()
		 * @generated
		 */
		EClass PREDEFINED_BIND_EXP = eINSTANCE.getPredefinedBindExp();

		/**
		 * The meta object literal for the '<em><b>Source</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PREDEFINED_BIND_EXP__SOURCE = eINSTANCE.getPredefinedBindExp_Source();

		/**
		 * The meta object literal for the '<em><b>Value Exp</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PREDEFINED_BIND_EXP__VALUE_EXP = eINSTANCE.getPredefinedBindExp_ValueExp();

		/**
		 * The meta object literal for the '{@link edu.ustb.sei.mde.morel.impl.IfStatementImpl <em>If Statement</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.ustb.sei.mde.morel.impl.IfStatementImpl
		 * @see edu.ustb.sei.mde.morel.impl.MorelPackageImpl#getIfStatement()
		 * @generated
		 */
		EClass IF_STATEMENT = eINSTANCE.getIfStatement();

		/**
		 * The meta object literal for the '<em><b>Condition</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IF_STATEMENT__CONDITION = eINSTANCE.getIfStatement_Condition();

		/**
		 * The meta object literal for the '<em><b>Then Statement</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IF_STATEMENT__THEN_STATEMENT = eINSTANCE.getIfStatement_ThenStatement();

		/**
		 * The meta object literal for the '<em><b>Else Statement</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IF_STATEMENT__ELSE_STATEMENT = eINSTANCE.getIfStatement_ElseStatement();

		/**
		 * The meta object literal for the '{@link edu.ustb.sei.mde.morel.impl.ForStatementImpl <em>For Statement</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.ustb.sei.mde.morel.impl.ForStatementImpl
		 * @see edu.ustb.sei.mde.morel.impl.MorelPackageImpl#getForStatement()
		 * @generated
		 */
		EClass FOR_STATEMENT = eINSTANCE.getForStatement();

		/**
		 * The meta object literal for the '<em><b>Iterator</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FOR_STATEMENT__ITERATOR = eINSTANCE.getForStatement_Iterator();

		/**
		 * The meta object literal for the '<em><b>Termination Exp</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FOR_STATEMENT__TERMINATION_EXP = eINSTANCE.getForStatement_TerminationExp();

		/**
		 * The meta object literal for the '<em><b>Step Exp</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FOR_STATEMENT__STEP_EXP = eINSTANCE.getForStatement_StepExp();

		/**
		 * The meta object literal for the '<em><b>Body Statement</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FOR_STATEMENT__BODY_STATEMENT = eINSTANCE.getForStatement_BodyStatement();

		/**
		 * The meta object literal for the '{@link edu.ustb.sei.mde.morel.impl.BlockStatementImpl <em>Block Statement</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.ustb.sei.mde.morel.impl.BlockStatementImpl
		 * @see edu.ustb.sei.mde.morel.impl.MorelPackageImpl#getBlockStatement()
		 * @generated
		 */
		EClass BLOCK_STATEMENT = eINSTANCE.getBlockStatement();

		/**
		 * The meta object literal for the '<em><b>Statements</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BLOCK_STATEMENT__STATEMENTS = eINSTANCE.getBlockStatement_Statements();

		/**
		 * The meta object literal for the '{@link edu.ustb.sei.mde.morel.impl.TransformationModelImpl <em>Transformation Model</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.ustb.sei.mde.morel.impl.TransformationModelImpl
		 * @see edu.ustb.sei.mde.morel.impl.MorelPackageImpl#getTransformationModel()
		 * @generated
		 */
		EClass TRANSFORMATION_MODEL = eINSTANCE.getTransformationModel();

		/**
		 * The meta object literal for the '<em><b>Rules</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRANSFORMATION_MODEL__RULES = eINSTANCE.getTransformationModel_Rules();

		/**
		 * The meta object literal for the '{@link edu.ustb.sei.mde.morel.impl.RuleImpl <em>Rule</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.ustb.sei.mde.morel.impl.RuleImpl
		 * @see edu.ustb.sei.mde.morel.impl.MorelPackageImpl#getRule()
		 * @generated
		 */
		EClass RULE = eINSTANCE.getRule();

		/**
		 * The meta object literal for the '<em><b>Patterns</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RULE__PATTERNS = eINSTANCE.getRule_Patterns();

		/**
		 * The meta object literal for the '{@link edu.ustb.sei.mde.morel.impl.StatementImpl <em>Statement</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.ustb.sei.mde.morel.impl.StatementImpl
		 * @see edu.ustb.sei.mde.morel.impl.MorelPackageImpl#getStatement()
		 * @generated
		 */
		EClass STATEMENT = eINSTANCE.getStatement();

		/**
		 * The meta object literal for the '{@link edu.ustb.sei.mde.morel.impl.DeclarativeStatementImpl <em>Declarative Statement</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.ustb.sei.mde.morel.impl.DeclarativeStatementImpl
		 * @see edu.ustb.sei.mde.morel.impl.MorelPackageImpl#getDeclarativeStatement()
		 * @generated
		 */
		EClass DECLARATIVE_STATEMENT = eINSTANCE.getDeclarativeStatement();

		/**
		 * The meta object literal for the '<em><b>Expression</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DECLARATIVE_STATEMENT__EXPRESSION = eINSTANCE.getDeclarativeStatement_Expression();

		/**
		 * The meta object literal for the '{@link edu.ustb.sei.mde.morel.impl.ImperativeStatementImpl <em>Imperative Statement</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.ustb.sei.mde.morel.impl.ImperativeStatementImpl
		 * @see edu.ustb.sei.mde.morel.impl.MorelPackageImpl#getImperativeStatement()
		 * @generated
		 */
		EClass IMPERATIVE_STATEMENT = eINSTANCE.getImperativeStatement();

		/**
		 * The meta object literal for the '{@link edu.ustb.sei.mde.morel.SectionType <em>Section Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.ustb.sei.mde.morel.SectionType
		 * @see edu.ustb.sei.mde.morel.impl.MorelPackageImpl#getSectionType()
		 * @generated
		 */
		EEnum SECTION_TYPE = eINSTANCE.getSectionType();

		/**
		 * The meta object literal for the '{@link edu.ustb.sei.mde.morel.UndefinedLiteral <em>Undefined Literal</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.ustb.sei.mde.morel.UndefinedLiteral
		 * @see edu.ustb.sei.mde.morel.impl.MorelPackageImpl#getUndefinedLiteral()
		 * @generated
		 */
		EEnum UNDEFINED_LITERAL = eINSTANCE.getUndefinedLiteral();

		/**
		 * The meta object literal for the '{@link edu.ustb.sei.mde.morel.PredefinedVariable <em>Predefined Variable</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.ustb.sei.mde.morel.PredefinedVariable
		 * @see edu.ustb.sei.mde.morel.impl.MorelPackageImpl#getPredefinedVariable()
		 * @generated
		 */
		EEnum PREDEFINED_VARIABLE = eINSTANCE.getPredefinedVariable();

		/**
		 * The meta object literal for the '{@link edu.ustb.sei.mde.morel.OperationSeparator <em>Operation Separator</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.ustb.sei.mde.morel.OperationSeparator
		 * @see edu.ustb.sei.mde.morel.impl.MorelPackageImpl#getOperationSeparator()
		 * @generated
		 */
		EEnum OPERATION_SEPARATOR = eINSTANCE.getOperationSeparator();

		/**
		 * The meta object literal for the '{@link edu.ustb.sei.mde.morel.IteratorType <em>Iterator Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.ustb.sei.mde.morel.IteratorType
		 * @see edu.ustb.sei.mde.morel.impl.MorelPackageImpl#getIteratorType()
		 * @generated
		 */
		EEnum ITERATOR_TYPE = eINSTANCE.getIteratorType();

		/**
		 * The meta object literal for the '{@link edu.ustb.sei.mde.morel.BooleanOperator <em>Boolean Operator</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.ustb.sei.mde.morel.BooleanOperator
		 * @see edu.ustb.sei.mde.morel.impl.MorelPackageImpl#getBooleanOperator()
		 * @generated
		 */
		EEnum BOOLEAN_OPERATOR = eINSTANCE.getBooleanOperator();

		/**
		 * The meta object literal for the '{@link edu.ustb.sei.mde.morel.RelationalOperator <em>Relational Operator</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.ustb.sei.mde.morel.RelationalOperator
		 * @see edu.ustb.sei.mde.morel.impl.MorelPackageImpl#getRelationalOperator()
		 * @generated
		 */
		EEnum RELATIONAL_OPERATOR = eINSTANCE.getRelationalOperator();

		/**
		 * The meta object literal for the '{@link edu.ustb.sei.mde.morel.AdditiveOperator <em>Additive Operator</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.ustb.sei.mde.morel.AdditiveOperator
		 * @see edu.ustb.sei.mde.morel.impl.MorelPackageImpl#getAdditiveOperator()
		 * @generated
		 */
		EEnum ADDITIVE_OPERATOR = eINSTANCE.getAdditiveOperator();

		/**
		 * The meta object literal for the '{@link edu.ustb.sei.mde.morel.MultiplicativeOperator <em>Multiplicative Operator</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.ustb.sei.mde.morel.MultiplicativeOperator
		 * @see edu.ustb.sei.mde.morel.impl.MorelPackageImpl#getMultiplicativeOperator()
		 * @generated
		 */
		EEnum MULTIPLICATIVE_OPERATOR = eINSTANCE.getMultiplicativeOperator();

		/**
		 * The meta object literal for the '{@link edu.ustb.sei.mde.morel.UnaryOperator <em>Unary Operator</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.ustb.sei.mde.morel.UnaryOperator
		 * @see edu.ustb.sei.mde.morel.impl.MorelPackageImpl#getUnaryOperator()
		 * @generated
		 */
		EEnum UNARY_OPERATOR = eINSTANCE.getUnaryOperator();

	}

} //MorelPackage
