/**
 */
package edu.ustb.sei.mde.xmu;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
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
 * @see edu.ustb.sei.mde.xmu.XmuFactory
 * @model kind="package"
 * @generated
 */
public interface XmuPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "xmu";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.ustb.edu.cn/sei/mde/xmu";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "xmu";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	XmuPackage eINSTANCE = edu.ustb.sei.mde.xmu.impl.XmuPackageImpl.init();

	/**
	 * The meta object id for the '{@link edu.ustb.sei.mde.xmu.impl.NamedElementImpl <em>Named Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.ustb.sei.mde.xmu.impl.NamedElementImpl
	 * @see edu.ustb.sei.mde.xmu.impl.XmuPackageImpl#getNamedElement()
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
	 * The meta object id for the '{@link edu.ustb.sei.mde.xmu.impl.VariableImpl <em>Variable</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.ustb.sei.mde.xmu.impl.VariableImpl
	 * @see edu.ustb.sei.mde.xmu.impl.XmuPackageImpl#getVariable()
	 * @generated
	 */
	int VARIABLE = 1;

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
	 * The meta object id for the '{@link edu.ustb.sei.mde.xmu.impl.ObjectVariableImpl <em>Object Variable</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.ustb.sei.mde.xmu.impl.ObjectVariableImpl
	 * @see edu.ustb.sei.mde.xmu.impl.XmuPackageImpl#getObjectVariable()
	 * @generated
	 */
	int OBJECT_VARIABLE = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_VARIABLE__NAME = VARIABLE__NAME;

	/**
	 * The number of structural features of the '<em>Object Variable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_VARIABLE_FEATURE_COUNT = VARIABLE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Object Variable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_VARIABLE_OPERATION_COUNT = VARIABLE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.ustb.sei.mde.xmu.impl.PrimitiveVariableImpl <em>Primitive Variable</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.ustb.sei.mde.xmu.impl.PrimitiveVariableImpl
	 * @see edu.ustb.sei.mde.xmu.impl.XmuPackageImpl#getPrimitiveVariable()
	 * @generated
	 */
	int PRIMITIVE_VARIABLE = 3;

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
	 * The meta object id for the '{@link edu.ustb.sei.mde.xmu.impl.RuleImpl <em>Rule</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.ustb.sei.mde.xmu.impl.RuleImpl
	 * @see edu.ustb.sei.mde.xmu.impl.XmuPackageImpl#getRule()
	 * @generated
	 */
	int RULE = 4;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>NVars</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE__NVARS = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>SVars</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE__SVARS = NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Sp Vars</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE__SP_VARS = NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>VVars</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE__VVARS = NAMED_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Statement</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE__STATEMENT = NAMED_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE__PARAMETERS = NAMED_ELEMENT_FEATURE_COUNT + 5;

	/**
	 * The number of structural features of the '<em>Rule</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 6;

	/**
	 * The number of operations of the '<em>Rule</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE_OPERATION_COUNT = NAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.ustb.sei.mde.xmu.impl.StatementImpl <em>Statement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.ustb.sei.mde.xmu.impl.StatementImpl
	 * @see edu.ustb.sei.mde.xmu.impl.XmuPackageImpl#getStatement()
	 * @generated
	 */
	int STATEMENT = 5;

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
	 * The meta object id for the '{@link edu.ustb.sei.mde.xmu.impl.ForStatementImpl <em>For Statement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.ustb.sei.mde.xmu.impl.ForStatementImpl
	 * @see edu.ustb.sei.mde.xmu.impl.XmuPackageImpl#getForStatement()
	 * @generated
	 */
	int FOR_STATEMENT = 6;

	/**
	 * The feature id for the '<em><b>SPattern</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOR_STATEMENT__SPATTERN = STATEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>VPattern</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOR_STATEMENT__VPATTERN = STATEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Actions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOR_STATEMENT__ACTIONS = STATEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>When</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOR_STATEMENT__WHEN = STATEMENT_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>For Statement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOR_STATEMENT_FEATURE_COUNT = STATEMENT_FEATURE_COUNT + 4;

	/**
	 * The number of operations of the '<em>For Statement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOR_STATEMENT_OPERATION_COUNT = STATEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.ustb.sei.mde.xmu.impl.UpdateImpl <em>Update</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.ustb.sei.mde.xmu.impl.UpdateImpl
	 * @see edu.ustb.sei.mde.xmu.impl.XmuPackageImpl#getUpdate()
	 * @generated
	 */
	int UPDATE = 7;

	/**
	 * The number of structural features of the '<em>Update</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UPDATE_FEATURE_COUNT = STATEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Update</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UPDATE_OPERATION_COUNT = STATEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.ustb.sei.mde.xmu.impl.DeleteNodeImpl <em>Delete Node</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.ustb.sei.mde.xmu.impl.DeleteNodeImpl
	 * @see edu.ustb.sei.mde.xmu.impl.XmuPackageImpl#getDeleteNode()
	 * @generated
	 */
	int DELETE_NODE = 8;

	/**
	 * The feature id for the '<em><b>Variable</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DELETE_NODE__VARIABLE = UPDATE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Delete Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DELETE_NODE_FEATURE_COUNT = UPDATE_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Delete Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DELETE_NODE_OPERATION_COUNT = UPDATE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.ustb.sei.mde.xmu.impl.DeleteLinkImpl <em>Delete Link</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.ustb.sei.mde.xmu.impl.DeleteLinkImpl
	 * @see edu.ustb.sei.mde.xmu.impl.XmuPackageImpl#getDeleteLink()
	 * @generated
	 */
	int DELETE_LINK = 9;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DELETE_LINK__SOURCE = UPDATE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DELETE_LINK__TARGET = UPDATE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Feature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DELETE_LINK__FEATURE = UPDATE_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Delete Link</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DELETE_LINK_FEATURE_COUNT = UPDATE_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Delete Link</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DELETE_LINK_OPERATION_COUNT = UPDATE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.ustb.sei.mde.xmu.impl.TaggedElementImpl <em>Tagged Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.ustb.sei.mde.xmu.impl.TaggedElementImpl
	 * @see edu.ustb.sei.mde.xmu.impl.XmuPackageImpl#getTaggedElement()
	 * @generated
	 */
	int TAGGED_ELEMENT = 27;

	/**
	 * The feature id for the '<em><b>Tag</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAGGED_ELEMENT__TAG = 0;

	/**
	 * The number of structural features of the '<em>Tagged Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAGGED_ELEMENT_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Tagged Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAGGED_ELEMENT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link edu.ustb.sei.mde.xmu.impl.PatternImpl <em>Pattern</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.ustb.sei.mde.xmu.impl.PatternImpl
	 * @see edu.ustb.sei.mde.xmu.impl.XmuPackageImpl#getPattern()
	 * @generated
	 */
	int PATTERN = 11;

	/**
	 * The feature id for the '<em><b>Tag</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN__TAG = TAGGED_ELEMENT__TAG;

	/**
	 * The feature id for the '<em><b>Root</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN__ROOT = TAGGED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Guard</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN__GUARD = TAGGED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Pattern</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN_FEATURE_COUNT = TAGGED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Pattern</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN_OPERATION_COUNT = TAGGED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.ustb.sei.mde.xmu.impl.UpdatePatternImpl <em>Update Pattern</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.ustb.sei.mde.xmu.impl.UpdatePatternImpl
	 * @see edu.ustb.sei.mde.xmu.impl.XmuPackageImpl#getUpdatePattern()
	 * @generated
	 */
	int UPDATE_PATTERN = 10;

	/**
	 * The feature id for the '<em><b>Tag</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UPDATE_PATTERN__TAG = PATTERN__TAG;

	/**
	 * The feature id for the '<em><b>Root</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UPDATE_PATTERN__ROOT = PATTERN__ROOT;

	/**
	 * The feature id for the '<em><b>Guard</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UPDATE_PATTERN__GUARD = PATTERN__GUARD;

	/**
	 * The number of structural features of the '<em>Update Pattern</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UPDATE_PATTERN_FEATURE_COUNT = PATTERN_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Update Pattern</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UPDATE_PATTERN_OPERATION_COUNT = PATTERN_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.ustb.sei.mde.xmu.impl.PatternNodeImpl <em>Pattern Node</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.ustb.sei.mde.xmu.impl.PatternNodeImpl
	 * @see edu.ustb.sei.mde.xmu.impl.XmuPackageImpl#getPatternNode()
	 * @generated
	 */
	int PATTERN_NODE = 12;

	/**
	 * The feature id for the '<em><b>Variable</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN_NODE__VARIABLE = 0;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN_NODE__TYPE = 1;

	/**
	 * The feature id for the '<em><b>Expr</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN_NODE__EXPR = 2;

	/**
	 * The number of structural features of the '<em>Pattern Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN_NODE_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Pattern Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN_NODE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link edu.ustb.sei.mde.xmu.impl.PatternExprImpl <em>Pattern Expr</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.ustb.sei.mde.xmu.impl.PatternExprImpl
	 * @see edu.ustb.sei.mde.xmu.impl.XmuPackageImpl#getPatternExpr()
	 * @generated
	 */
	int PATTERN_EXPR = 13;

	/**
	 * The number of structural features of the '<em>Pattern Expr</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN_EXPR_FEATURE_COUNT = 0;

	/**
	 * The number of operations of the '<em>Pattern Expr</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN_EXPR_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link edu.ustb.sei.mde.xmu.impl.PatternReferenceExprImpl <em>Pattern Reference Expr</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.ustb.sei.mde.xmu.impl.PatternReferenceExprImpl
	 * @see edu.ustb.sei.mde.xmu.impl.XmuPackageImpl#getPatternReferenceExpr()
	 * @generated
	 */
	int PATTERN_REFERENCE_EXPR = 14;

	/**
	 * The feature id for the '<em><b>Reference</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN_REFERENCE_EXPR__REFERENCE = PATTERN_EXPR_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Node</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN_REFERENCE_EXPR__NODE = PATTERN_EXPR_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Pos</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN_REFERENCE_EXPR__POS = PATTERN_EXPR_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Pattern Reference Expr</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN_REFERENCE_EXPR_FEATURE_COUNT = PATTERN_EXPR_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Pattern Reference Expr</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN_REFERENCE_EXPR_OPERATION_COUNT = PATTERN_EXPR_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.ustb.sei.mde.xmu.impl.PatternEqualExprImpl <em>Pattern Equal Expr</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.ustb.sei.mde.xmu.impl.PatternEqualExprImpl
	 * @see edu.ustb.sei.mde.xmu.impl.XmuPackageImpl#getPatternEqualExpr()
	 * @generated
	 */
	int PATTERN_EQUAL_EXPR = 15;

	/**
	 * The feature id for the '<em><b>Feature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN_EQUAL_EXPR__FEATURE = PATTERN_EXPR_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN_EQUAL_EXPR__VALUE = PATTERN_EXPR_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Pos</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN_EQUAL_EXPR__POS = PATTERN_EXPR_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Pattern Equal Expr</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN_EQUAL_EXPR_FEATURE_COUNT = PATTERN_EXPR_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Pattern Equal Expr</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN_EQUAL_EXPR_OPERATION_COUNT = PATTERN_EXPR_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.ustb.sei.mde.xmu.impl.ExprImpl <em>Expr</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.ustb.sei.mde.xmu.impl.ExprImpl
	 * @see edu.ustb.sei.mde.xmu.impl.XmuPackageImpl#getExpr()
	 * @generated
	 */
	int EXPR = 16;

	/**
	 * The number of structural features of the '<em>Expr</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPR_FEATURE_COUNT = 0;

	/**
	 * The number of operations of the '<em>Expr</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPR_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link edu.ustb.sei.mde.xmu.impl.BooleanOrExprChildImpl <em>Boolean Or Expr Child</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.ustb.sei.mde.xmu.impl.BooleanOrExprChildImpl
	 * @see edu.ustb.sei.mde.xmu.impl.XmuPackageImpl#getBooleanOrExprChild()
	 * @generated
	 */
	int BOOLEAN_OR_EXPR_CHILD = 36;

	/**
	 * The number of structural features of the '<em>Boolean Or Expr Child</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_OR_EXPR_CHILD_FEATURE_COUNT = EXPR_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Boolean Or Expr Child</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_OR_EXPR_CHILD_OPERATION_COUNT = EXPR_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.ustb.sei.mde.xmu.impl.BooleanAndExprChildImpl <em>Boolean And Expr Child</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.ustb.sei.mde.xmu.impl.BooleanAndExprChildImpl
	 * @see edu.ustb.sei.mde.xmu.impl.XmuPackageImpl#getBooleanAndExprChild()
	 * @generated
	 */
	int BOOLEAN_AND_EXPR_CHILD = 38;

	/**
	 * The number of structural features of the '<em>Boolean And Expr Child</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_AND_EXPR_CHILD_FEATURE_COUNT = BOOLEAN_OR_EXPR_CHILD_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Boolean And Expr Child</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_AND_EXPR_CHILD_OPERATION_COUNT = BOOLEAN_OR_EXPR_CHILD_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.ustb.sei.mde.xmu.impl.RelationalExprChildImpl <em>Relational Expr Child</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.ustb.sei.mde.xmu.impl.RelationalExprChildImpl
	 * @see edu.ustb.sei.mde.xmu.impl.XmuPackageImpl#getRelationalExprChild()
	 * @generated
	 */
	int RELATIONAL_EXPR_CHILD = 40;

	/**
	 * The number of structural features of the '<em>Relational Expr Child</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATIONAL_EXPR_CHILD_FEATURE_COUNT = BOOLEAN_AND_EXPR_CHILD_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Relational Expr Child</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATIONAL_EXPR_CHILD_OPERATION_COUNT = BOOLEAN_AND_EXPR_CHILD_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.ustb.sei.mde.xmu.impl.AdditiveExprChildImpl <em>Additive Expr Child</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.ustb.sei.mde.xmu.impl.AdditiveExprChildImpl
	 * @see edu.ustb.sei.mde.xmu.impl.XmuPackageImpl#getAdditiveExprChild()
	 * @generated
	 */
	int ADDITIVE_EXPR_CHILD = 42;

	/**
	 * The number of structural features of the '<em>Additive Expr Child</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADDITIVE_EXPR_CHILD_FEATURE_COUNT = RELATIONAL_EXPR_CHILD_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Additive Expr Child</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADDITIVE_EXPR_CHILD_OPERATION_COUNT = RELATIONAL_EXPR_CHILD_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.ustb.sei.mde.xmu.impl.MultiplicativeExprChildImpl <em>Multiplicative Expr Child</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.ustb.sei.mde.xmu.impl.MultiplicativeExprChildImpl
	 * @see edu.ustb.sei.mde.xmu.impl.XmuPackageImpl#getMultiplicativeExprChild()
	 * @generated
	 */
	int MULTIPLICATIVE_EXPR_CHILD = 44;

	/**
	 * The number of structural features of the '<em>Multiplicative Expr Child</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTIPLICATIVE_EXPR_CHILD_FEATURE_COUNT = ADDITIVE_EXPR_CHILD_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Multiplicative Expr Child</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTIPLICATIVE_EXPR_CHILD_OPERATION_COUNT = ADDITIVE_EXPR_CHILD_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.ustb.sei.mde.xmu.impl.UnaryExprChildImpl <em>Unary Expr Child</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.ustb.sei.mde.xmu.impl.UnaryExprChildImpl
	 * @see edu.ustb.sei.mde.xmu.impl.XmuPackageImpl#getUnaryExprChild()
	 * @generated
	 */
	int UNARY_EXPR_CHILD = 46;

	/**
	 * The number of structural features of the '<em>Unary Expr Child</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNARY_EXPR_CHILD_FEATURE_COUNT = MULTIPLICATIVE_EXPR_CHILD_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Unary Expr Child</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNARY_EXPR_CHILD_OPERATION_COUNT = MULTIPLICATIVE_EXPR_CHILD_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.ustb.sei.mde.xmu.impl.AtomicExprImpl <em>Atomic Expr</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.ustb.sei.mde.xmu.impl.AtomicExprImpl
	 * @see edu.ustb.sei.mde.xmu.impl.XmuPackageImpl#getAtomicExpr()
	 * @generated
	 */
	int ATOMIC_EXPR = 47;

	/**
	 * The number of structural features of the '<em>Atomic Expr</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATOMIC_EXPR_FEATURE_COUNT = UNARY_EXPR_CHILD_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Atomic Expr</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATOMIC_EXPR_OPERATION_COUNT = UNARY_EXPR_CHILD_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.ustb.sei.mde.xmu.impl.VariableExpImpl <em>Variable Exp</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.ustb.sei.mde.xmu.impl.VariableExpImpl
	 * @see edu.ustb.sei.mde.xmu.impl.XmuPackageImpl#getVariableExp()
	 * @generated
	 */
	int VARIABLE_EXP = 17;

	/**
	 * The feature id for the '<em><b>Var</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_EXP__VAR = ATOMIC_EXPR_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Path</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_EXP__PATH = ATOMIC_EXPR_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Variable Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_EXP_FEATURE_COUNT = ATOMIC_EXPR_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Variable Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_EXP_OPERATION_COUNT = ATOMIC_EXPR_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.ustb.sei.mde.xmu.impl.ConstantExprImpl <em>Constant Expr</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.ustb.sei.mde.xmu.impl.ConstantExprImpl
	 * @see edu.ustb.sei.mde.xmu.impl.XmuPackageImpl#getConstantExpr()
	 * @generated
	 */
	int CONSTANT_EXPR = 18;

	/**
	 * The number of structural features of the '<em>Constant Expr</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTANT_EXPR_FEATURE_COUNT = ATOMIC_EXPR_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Constant Expr</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTANT_EXPR_OPERATION_COUNT = ATOMIC_EXPR_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.ustb.sei.mde.xmu.impl.EmptyLiteralImpl <em>Empty Literal</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.ustb.sei.mde.xmu.impl.EmptyLiteralImpl
	 * @see edu.ustb.sei.mde.xmu.impl.XmuPackageImpl#getEmptyLiteral()
	 * @generated
	 */
	int EMPTY_LITERAL = 19;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMPTY_LITERAL__VALUE = CONSTANT_EXPR_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Empty Literal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMPTY_LITERAL_FEATURE_COUNT = CONSTANT_EXPR_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Empty Literal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMPTY_LITERAL_OPERATION_COUNT = CONSTANT_EXPR_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.ustb.sei.mde.xmu.impl.StringLiteralImpl <em>String Literal</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.ustb.sei.mde.xmu.impl.StringLiteralImpl
	 * @see edu.ustb.sei.mde.xmu.impl.XmuPackageImpl#getStringLiteral()
	 * @generated
	 */
	int STRING_LITERAL = 20;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_LITERAL__VALUE = CONSTANT_EXPR_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>String Literal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_LITERAL_FEATURE_COUNT = CONSTANT_EXPR_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>String Literal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_LITERAL_OPERATION_COUNT = CONSTANT_EXPR_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.ustb.sei.mde.xmu.impl.IntegerLiteralImpl <em>Integer Literal</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.ustb.sei.mde.xmu.impl.IntegerLiteralImpl
	 * @see edu.ustb.sei.mde.xmu.impl.XmuPackageImpl#getIntegerLiteral()
	 * @generated
	 */
	int INTEGER_LITERAL = 21;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_LITERAL__VALUE = CONSTANT_EXPR_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Integer Literal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_LITERAL_FEATURE_COUNT = CONSTANT_EXPR_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Integer Literal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_LITERAL_OPERATION_COUNT = CONSTANT_EXPR_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.ustb.sei.mde.xmu.impl.BooleanLiteralImpl <em>Boolean Literal</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.ustb.sei.mde.xmu.impl.BooleanLiteralImpl
	 * @see edu.ustb.sei.mde.xmu.impl.XmuPackageImpl#getBooleanLiteral()
	 * @generated
	 */
	int BOOLEAN_LITERAL = 22;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_LITERAL__VALUE = CONSTANT_EXPR_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Boolean Literal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_LITERAL_FEATURE_COUNT = CONSTANT_EXPR_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Boolean Literal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_LITERAL_OPERATION_COUNT = CONSTANT_EXPR_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.ustb.sei.mde.xmu.impl.EnumLiteralImpl <em>Enum Literal</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.ustb.sei.mde.xmu.impl.EnumLiteralImpl
	 * @see edu.ustb.sei.mde.xmu.impl.XmuPackageImpl#getEnumLiteral()
	 * @generated
	 */
	int ENUM_LITERAL = 23;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUM_LITERAL__TYPE = CONSTANT_EXPR_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUM_LITERAL__VALUE = CONSTANT_EXPR_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Enum Literal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUM_LITERAL_FEATURE_COUNT = CONSTANT_EXPR_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Enum Literal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUM_LITERAL_OPERATION_COUNT = CONSTANT_EXPR_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.ustb.sei.mde.xmu.impl.VStatementImpl <em>VStatement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.ustb.sei.mde.xmu.impl.VStatementImpl
	 * @see edu.ustb.sei.mde.xmu.impl.XmuPackageImpl#getVStatement()
	 * @generated
	 */
	int VSTATEMENT = 24;

	/**
	 * The feature id for the '<em><b>Tag</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VSTATEMENT__TAG = 0;

	/**
	 * The feature id for the '<em><b>Statement</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VSTATEMENT__STATEMENT = 1;

	/**
	 * The number of structural features of the '<em>VStatement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VSTATEMENT_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>VStatement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VSTATEMENT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link edu.ustb.sei.mde.xmu.impl.BlockStatementImpl <em>Block Statement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.ustb.sei.mde.xmu.impl.BlockStatementImpl
	 * @see edu.ustb.sei.mde.xmu.impl.XmuPackageImpl#getBlockStatement()
	 * @generated
	 */
	int BLOCK_STATEMENT = 25;

	/**
	 * The feature id for the '<em><b>Statements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLOCK_STATEMENT__STATEMENTS = STATEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Block Statement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLOCK_STATEMENT_FEATURE_COUNT = STATEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Block Statement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLOCK_STATEMENT_OPERATION_COUNT = STATEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.ustb.sei.mde.xmu.impl.SwitchStatementImpl <em>Switch Statement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.ustb.sei.mde.xmu.impl.SwitchStatementImpl
	 * @see edu.ustb.sei.mde.xmu.impl.XmuPackageImpl#getSwitchStatement()
	 * @generated
	 */
	int SWITCH_STATEMENT = 26;

	/**
	 * The feature id for the '<em><b>Tag</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SWITCH_STATEMENT__TAG = STATEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Var</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SWITCH_STATEMENT__VAR = STATEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Cases</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SWITCH_STATEMENT__CASES = STATEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>When</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SWITCH_STATEMENT__WHEN = STATEMENT_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Switch Statement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SWITCH_STATEMENT_FEATURE_COUNT = STATEMENT_FEATURE_COUNT + 4;

	/**
	 * The number of operations of the '<em>Switch Statement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SWITCH_STATEMENT_OPERATION_COUNT = STATEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.ustb.sei.mde.xmu.impl.CaseSubStatementImpl <em>Case Sub Statement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.ustb.sei.mde.xmu.impl.CaseSubStatementImpl
	 * @see edu.ustb.sei.mde.xmu.impl.XmuPackageImpl#getCaseSubStatement()
	 * @generated
	 */
	int CASE_SUB_STATEMENT = 28;

	/**
	 * The feature id for the '<em><b>Statement</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CASE_SUB_STATEMENT__STATEMENT = 0;

	/**
	 * The number of structural features of the '<em>Case Sub Statement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CASE_SUB_STATEMENT_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Case Sub Statement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CASE_SUB_STATEMENT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link edu.ustb.sei.mde.xmu.impl.CasePatternStatementImpl <em>Case Pattern Statement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.ustb.sei.mde.xmu.impl.CasePatternStatementImpl
	 * @see edu.ustb.sei.mde.xmu.impl.XmuPackageImpl#getCasePatternStatement()
	 * @generated
	 */
	int CASE_PATTERN_STATEMENT = 29;

	/**
	 * The feature id for the '<em><b>Statement</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CASE_PATTERN_STATEMENT__STATEMENT = CASE_SUB_STATEMENT__STATEMENT;

	/**
	 * The feature id for the '<em><b>Pattern</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CASE_PATTERN_STATEMENT__PATTERN = CASE_SUB_STATEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Case Pattern Statement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CASE_PATTERN_STATEMENT_FEATURE_COUNT = CASE_SUB_STATEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Case Pattern Statement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CASE_PATTERN_STATEMENT_OPERATION_COUNT = CASE_SUB_STATEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.ustb.sei.mde.xmu.impl.CaseValueStatementImpl <em>Case Value Statement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.ustb.sei.mde.xmu.impl.CaseValueStatementImpl
	 * @see edu.ustb.sei.mde.xmu.impl.XmuPackageImpl#getCaseValueStatement()
	 * @generated
	 */
	int CASE_VALUE_STATEMENT = 30;

	/**
	 * The feature id for the '<em><b>Statement</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CASE_VALUE_STATEMENT__STATEMENT = CASE_SUB_STATEMENT__STATEMENT;

	/**
	 * The feature id for the '<em><b>Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CASE_VALUE_STATEMENT__EXPRESSION = CASE_SUB_STATEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Case Value Statement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CASE_VALUE_STATEMENT_FEATURE_COUNT = CASE_SUB_STATEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Case Value Statement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CASE_VALUE_STATEMENT_OPERATION_COUNT = CASE_SUB_STATEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.ustb.sei.mde.xmu.impl.XMUModelImpl <em>XMU Model</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.ustb.sei.mde.xmu.impl.XMUModelImpl
	 * @see edu.ustb.sei.mde.xmu.impl.XmuPackageImpl#getXMUModel()
	 * @generated
	 */
	int XMU_MODEL = 31;

	/**
	 * The feature id for the '<em><b>Rules</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XMU_MODEL__RULES = 0;

	/**
	 * The feature id for the '<em><b>Packages</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XMU_MODEL__PACKAGES = 1;

	/**
	 * The feature id for the '<em><b>Start</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XMU_MODEL__START = 2;

	/**
	 * The number of structural features of the '<em>XMU Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XMU_MODEL_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>XMU Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XMU_MODEL_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link edu.ustb.sei.mde.xmu.impl.ParameterImpl <em>Parameter</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.ustb.sei.mde.xmu.impl.ParameterImpl
	 * @see edu.ustb.sei.mde.xmu.impl.XmuPackageImpl#getParameter()
	 * @generated
	 */
	int PARAMETER = 32;

	/**
	 * The feature id for the '<em><b>Tag</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER__TAG = TAGGED_ELEMENT__TAG;

	/**
	 * The feature id for the '<em><b>Variable</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER__VARIABLE = TAGGED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Parameter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_FEATURE_COUNT = TAGGED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Parameter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_OPERATION_COUNT = TAGGED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.ustb.sei.mde.xmu.impl.RuleCallStatementImpl <em>Rule Call Statement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.ustb.sei.mde.xmu.impl.RuleCallStatementImpl
	 * @see edu.ustb.sei.mde.xmu.impl.XmuPackageImpl#getRuleCallStatement()
	 * @generated
	 */
	int RULE_CALL_STATEMENT = 33;

	/**
	 * The feature id for the '<em><b>Tag</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE_CALL_STATEMENT__TAG = STATEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Actual Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE_CALL_STATEMENT__ACTUAL_PARAMETERS = STATEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Rule</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE_CALL_STATEMENT__RULE = STATEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Rule Call Statement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE_CALL_STATEMENT_FEATURE_COUNT = STATEMENT_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Rule Call Statement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE_CALL_STATEMENT_OPERATION_COUNT = STATEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.ustb.sei.mde.xmu.impl.UpdatedStatementImpl <em>Updated Statement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.ustb.sei.mde.xmu.impl.UpdatedStatementImpl
	 * @see edu.ustb.sei.mde.xmu.impl.XmuPackageImpl#getUpdatedStatement()
	 * @generated
	 */
	int UPDATED_STATEMENT = 34;

	/**
	 * The feature id for the '<em><b>SVar</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UPDATED_STATEMENT__SVAR = STATEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>VVar</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UPDATED_STATEMENT__VVAR = STATEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Updated Statement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UPDATED_STATEMENT_FEATURE_COUNT = STATEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Updated Statement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UPDATED_STATEMENT_OPERATION_COUNT = STATEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.ustb.sei.mde.xmu.impl.BooleanOrExprImpl <em>Boolean Or Expr</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.ustb.sei.mde.xmu.impl.BooleanOrExprImpl
	 * @see edu.ustb.sei.mde.xmu.impl.XmuPackageImpl#getBooleanOrExpr()
	 * @generated
	 */
	int BOOLEAN_OR_EXPR = 35;

	/**
	 * The feature id for the '<em><b>Operands</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_OR_EXPR__OPERANDS = EXPR_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Boolean Or Expr</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_OR_EXPR_FEATURE_COUNT = EXPR_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Boolean Or Expr</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_OR_EXPR_OPERATION_COUNT = EXPR_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.ustb.sei.mde.xmu.impl.BooleanAndExprImpl <em>Boolean And Expr</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.ustb.sei.mde.xmu.impl.BooleanAndExprImpl
	 * @see edu.ustb.sei.mde.xmu.impl.XmuPackageImpl#getBooleanAndExpr()
	 * @generated
	 */
	int BOOLEAN_AND_EXPR = 37;

	/**
	 * The feature id for the '<em><b>Operands</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_AND_EXPR__OPERANDS = BOOLEAN_OR_EXPR_CHILD_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Boolean And Expr</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_AND_EXPR_FEATURE_COUNT = BOOLEAN_OR_EXPR_CHILD_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Boolean And Expr</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_AND_EXPR_OPERATION_COUNT = BOOLEAN_OR_EXPR_CHILD_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.ustb.sei.mde.xmu.impl.RelationalExprImpl <em>Relational Expr</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.ustb.sei.mde.xmu.impl.RelationalExprImpl
	 * @see edu.ustb.sei.mde.xmu.impl.XmuPackageImpl#getRelationalExpr()
	 * @generated
	 */
	int RELATIONAL_EXPR = 39;

	/**
	 * The feature id for the '<em><b>Left</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATIONAL_EXPR__LEFT = BOOLEAN_AND_EXPR_CHILD_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Right</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATIONAL_EXPR__RIGHT = BOOLEAN_AND_EXPR_CHILD_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Operator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATIONAL_EXPR__OPERATOR = BOOLEAN_AND_EXPR_CHILD_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Relational Expr</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATIONAL_EXPR_FEATURE_COUNT = BOOLEAN_AND_EXPR_CHILD_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Relational Expr</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATIONAL_EXPR_OPERATION_COUNT = BOOLEAN_AND_EXPR_CHILD_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.ustb.sei.mde.xmu.impl.AdditiveExprImpl <em>Additive Expr</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.ustb.sei.mde.xmu.impl.AdditiveExprImpl
	 * @see edu.ustb.sei.mde.xmu.impl.XmuPackageImpl#getAdditiveExpr()
	 * @generated
	 */
	int ADDITIVE_EXPR = 41;

	/**
	 * The feature id for the '<em><b>Operands</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADDITIVE_EXPR__OPERANDS = RELATIONAL_EXPR_CHILD_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Operators</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADDITIVE_EXPR__OPERATORS = RELATIONAL_EXPR_CHILD_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Additive Expr</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADDITIVE_EXPR_FEATURE_COUNT = RELATIONAL_EXPR_CHILD_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Additive Expr</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADDITIVE_EXPR_OPERATION_COUNT = RELATIONAL_EXPR_CHILD_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.ustb.sei.mde.xmu.impl.MultiplicativeExprImpl <em>Multiplicative Expr</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.ustb.sei.mde.xmu.impl.MultiplicativeExprImpl
	 * @see edu.ustb.sei.mde.xmu.impl.XmuPackageImpl#getMultiplicativeExpr()
	 * @generated
	 */
	int MULTIPLICATIVE_EXPR = 43;

	/**
	 * The feature id for the '<em><b>Operands</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTIPLICATIVE_EXPR__OPERANDS = ADDITIVE_EXPR_CHILD_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Operators</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTIPLICATIVE_EXPR__OPERATORS = ADDITIVE_EXPR_CHILD_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Multiplicative Expr</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTIPLICATIVE_EXPR_FEATURE_COUNT = ADDITIVE_EXPR_CHILD_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Multiplicative Expr</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTIPLICATIVE_EXPR_OPERATION_COUNT = ADDITIVE_EXPR_CHILD_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.ustb.sei.mde.xmu.impl.UnaryExprImpl <em>Unary Expr</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.ustb.sei.mde.xmu.impl.UnaryExprImpl
	 * @see edu.ustb.sei.mde.xmu.impl.XmuPackageImpl#getUnaryExpr()
	 * @generated
	 */
	int UNARY_EXPR = 45;

	/**
	 * The feature id for the '<em><b>Body</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNARY_EXPR__BODY = MULTIPLICATIVE_EXPR_CHILD_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Operator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNARY_EXPR__OPERATOR = MULTIPLICATIVE_EXPR_CHILD_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Unary Expr</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNARY_EXPR_FEATURE_COUNT = MULTIPLICATIVE_EXPR_CHILD_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Unary Expr</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNARY_EXPR_OPERATION_COUNT = MULTIPLICATIVE_EXPR_CHILD_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.ustb.sei.mde.xmu.impl.ParenExprImpl <em>Paren Expr</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.ustb.sei.mde.xmu.impl.ParenExprImpl
	 * @see edu.ustb.sei.mde.xmu.impl.XmuPackageImpl#getParenExpr()
	 * @generated
	 */
	int PAREN_EXPR = 48;

	/**
	 * The feature id for the '<em><b>Body</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAREN_EXPR__BODY = ATOMIC_EXPR_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Paren Expr</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAREN_EXPR_FEATURE_COUNT = ATOMIC_EXPR_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Paren Expr</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAREN_EXPR_OPERATION_COUNT = ATOMIC_EXPR_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.ustb.sei.mde.xmu.impl.PathImpl <em>Path</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.ustb.sei.mde.xmu.impl.PathImpl
	 * @see edu.ustb.sei.mde.xmu.impl.XmuPackageImpl#getPath()
	 * @generated
	 */
	int PATH = 49;

	/**
	 * The number of structural features of the '<em>Path</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATH_FEATURE_COUNT = 0;

	/**
	 * The number of operations of the '<em>Path</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATH_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link edu.ustb.sei.mde.xmu.impl.FeaturePathImpl <em>Feature Path</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.ustb.sei.mde.xmu.impl.FeaturePathImpl
	 * @see edu.ustb.sei.mde.xmu.impl.XmuPackageImpl#getFeaturePath()
	 * @generated
	 */
	int FEATURE_PATH = 50;

	/**
	 * The feature id for the '<em><b>Feature</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_PATH__FEATURE = PATH_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Feature Path</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_PATH_FEATURE_COUNT = PATH_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Feature Path</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_PATH_OPERATION_COUNT = PATH_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.ustb.sei.mde.xmu.impl.OperationPathImpl <em>Operation Path</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.ustb.sei.mde.xmu.impl.OperationPathImpl
	 * @see edu.ustb.sei.mde.xmu.impl.XmuPackageImpl#getOperationPath()
	 * @generated
	 */
	int OPERATION_PATH = 51;

	/**
	 * The feature id for the '<em><b>Operation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_PATH__OPERATION = PATH_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_PATH__PARAMETERS = PATH_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Operation Path</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_PATH_FEATURE_COUNT = PATH_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Operation Path</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_PATH_OPERATION_COUNT = PATH_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.ustb.sei.mde.xmu.impl.LoopPathImpl <em>Loop Path</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.ustb.sei.mde.xmu.impl.LoopPathImpl
	 * @see edu.ustb.sei.mde.xmu.impl.XmuPackageImpl#getLoopPath()
	 * @generated
	 */
	int LOOP_PATH = 52;

	/**
	 * The feature id for the '<em><b>Operator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOP_PATH__OPERATOR = PATH_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Variable</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOP_PATH__VARIABLE = PATH_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Body</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOP_PATH__BODY = PATH_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Loop Path</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOP_PATH_FEATURE_COUNT = PATH_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Loop Path</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOP_PATH_OPERATION_COUNT = PATH_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.ustb.sei.mde.xmu.impl.StartStatementImpl <em>Start Statement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.ustb.sei.mde.xmu.impl.StartStatementImpl
	 * @see edu.ustb.sei.mde.xmu.impl.XmuPackageImpl#getStartStatement()
	 * @generated
	 */
	int START_STATEMENT = 53;

	/**
	 * The feature id for the '<em><b>Rule</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int START_STATEMENT__RULE = 0;

	/**
	 * The feature id for the '<em><b>Root</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int START_STATEMENT__ROOT = 1;

	/**
	 * The number of structural features of the '<em>Start Statement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int START_STATEMENT_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Start Statement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int START_STATEMENT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link edu.ustb.sei.mde.xmu.impl.StartRootImpl <em>Start Root</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.ustb.sei.mde.xmu.impl.StartRootImpl
	 * @see edu.ustb.sei.mde.xmu.impl.XmuPackageImpl#getStartRoot()
	 * @generated
	 */
	int START_ROOT = 54;

	/**
	 * The feature id for the '<em><b>Tag</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int START_ROOT__TAG = TAGGED_ELEMENT__TAG;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int START_ROOT__ID = TAGGED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Start Root</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int START_ROOT_FEATURE_COUNT = TAGGED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Start Root</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int START_ROOT_OPERATION_COUNT = TAGGED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.ustb.sei.mde.xmu.impl.ESetImpl <em>ESet</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.ustb.sei.mde.xmu.impl.ESetImpl
	 * @see edu.ustb.sei.mde.xmu.impl.XmuPackageImpl#getESet()
	 * @generated
	 */
	int ESET = 58;

	/**
	 * The meta object id for the '{@link edu.ustb.sei.mde.xmu.impl.EResourceImpl <em>EResource</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.ustb.sei.mde.xmu.impl.EResourceImpl
	 * @see edu.ustb.sei.mde.xmu.impl.XmuPackageImpl#getEResource()
	 * @generated
	 */
	int ERESOURCE = 55;

	/**
	 * The feature id for the '<em><b>Content</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERESOURCE__CONTENT = 0;

	/**
	 * The number of structural features of the '<em>EResource</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERESOURCE_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>EResource</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERESOURCE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link edu.ustb.sei.mde.xmu.impl.PrintStatementImpl <em>Print Statement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.ustb.sei.mde.xmu.impl.PrintStatementImpl
	 * @see edu.ustb.sei.mde.xmu.impl.XmuPackageImpl#getPrintStatement()
	 * @generated
	 */
	int PRINT_STATEMENT = 56;

	/**
	 * The feature id for the '<em><b>Expr</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRINT_STATEMENT__EXPR = STATEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Print Statement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRINT_STATEMENT_FEATURE_COUNT = STATEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Print Statement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRINT_STATEMENT_OPERATION_COUNT = STATEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.ustb.sei.mde.xmu.impl.AllInstanceExprImpl <em>All Instance Expr</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.ustb.sei.mde.xmu.impl.AllInstanceExprImpl
	 * @see edu.ustb.sei.mde.xmu.impl.XmuPackageImpl#getAllInstanceExpr()
	 * @generated
	 */
	int ALL_INSTANCE_EXPR = 57;

	/**
	 * The feature id for the '<em><b>Root</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALL_INSTANCE_EXPR__ROOT = EXPR_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALL_INSTANCE_EXPR__TYPE = EXPR_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>All Instance Expr</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALL_INSTANCE_EXPR_FEATURE_COUNT = EXPR_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>All Instance Expr</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALL_INSTANCE_EXPR_OPERATION_COUNT = EXPR_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Content</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESET__CONTENT = 0;

	/**
	 * The number of structural features of the '<em>ESet</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESET_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>ESet</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESET_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link edu.ustb.sei.mde.xmu.VariableFlag <em>Variable Flag</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.ustb.sei.mde.xmu.VariableFlag
	 * @see edu.ustb.sei.mde.xmu.impl.XmuPackageImpl#getVariableFlag()
	 * @generated
	 */
	int VARIABLE_FLAG = 59;

	/**
	 * The meta object id for the '{@link edu.ustb.sei.mde.xmu.RelationalOperator <em>Relational Operator</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.ustb.sei.mde.xmu.RelationalOperator
	 * @see edu.ustb.sei.mde.xmu.impl.XmuPackageImpl#getRelationalOperator()
	 * @generated
	 */
	int RELATIONAL_OPERATOR = 60;

	/**
	 * The meta object id for the '{@link edu.ustb.sei.mde.xmu.EmptyType <em>Empty Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.ustb.sei.mde.xmu.EmptyType
	 * @see edu.ustb.sei.mde.xmu.impl.XmuPackageImpl#getEmptyType()
	 * @generated
	 */
	int EMPTY_TYPE = 61;

	/**
	 * The meta object id for the '{@link edu.ustb.sei.mde.xmu.VStmtType <em>VStmt Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.ustb.sei.mde.xmu.VStmtType
	 * @see edu.ustb.sei.mde.xmu.impl.XmuPackageImpl#getVStmtType()
	 * @generated
	 */
	int VSTMT_TYPE = 62;


	/**
	 * The meta object id for the '{@link edu.ustb.sei.mde.xmu.AdditiveOperator <em>Additive Operator</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.ustb.sei.mde.xmu.AdditiveOperator
	 * @see edu.ustb.sei.mde.xmu.impl.XmuPackageImpl#getAdditiveOperator()
	 * @generated
	 */
	int ADDITIVE_OPERATOR = 63;

	/**
	 * The meta object id for the '{@link edu.ustb.sei.mde.xmu.MultiplicativeOperator <em>Multiplicative Operator</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.ustb.sei.mde.xmu.MultiplicativeOperator
	 * @see edu.ustb.sei.mde.xmu.impl.XmuPackageImpl#getMultiplicativeOperator()
	 * @generated
	 */
	int MULTIPLICATIVE_OPERATOR = 64;


	/**
	 * The meta object id for the '{@link edu.ustb.sei.mde.xmu.UnaryOperator <em>Unary Operator</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.ustb.sei.mde.xmu.UnaryOperator
	 * @see edu.ustb.sei.mde.xmu.impl.XmuPackageImpl#getUnaryOperator()
	 * @generated
	 */
	int UNARY_OPERATOR = 65;


	/**
	 * The meta object id for the '{@link edu.ustb.sei.mde.xmu.LoopOperator <em>Loop Operator</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.ustb.sei.mde.xmu.LoopOperator
	 * @see edu.ustb.sei.mde.xmu.impl.XmuPackageImpl#getLoopOperator()
	 * @generated
	 */
	int LOOP_OPERATOR = 66;


	/**
	 * Returns the meta object for class '{@link edu.ustb.sei.mde.xmu.NamedElement <em>Named Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Named Element</em>'.
	 * @see edu.ustb.sei.mde.xmu.NamedElement
	 * @generated
	 */
	EClass getNamedElement();

	/**
	 * Returns the meta object for the attribute '{@link edu.ustb.sei.mde.xmu.NamedElement#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see edu.ustb.sei.mde.xmu.NamedElement#getName()
	 * @see #getNamedElement()
	 * @generated
	 */
	EAttribute getNamedElement_Name();

	/**
	 * Returns the meta object for class '{@link edu.ustb.sei.mde.xmu.Variable <em>Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Variable</em>'.
	 * @see edu.ustb.sei.mde.xmu.Variable
	 * @generated
	 */
	EClass getVariable();

	/**
	 * Returns the meta object for class '{@link edu.ustb.sei.mde.xmu.ObjectVariable <em>Object Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Object Variable</em>'.
	 * @see edu.ustb.sei.mde.xmu.ObjectVariable
	 * @generated
	 */
	EClass getObjectVariable();

	/**
	 * Returns the meta object for class '{@link edu.ustb.sei.mde.xmu.PrimitiveVariable <em>Primitive Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Primitive Variable</em>'.
	 * @see edu.ustb.sei.mde.xmu.PrimitiveVariable
	 * @generated
	 */
	EClass getPrimitiveVariable();

	/**
	 * Returns the meta object for the reference '{@link edu.ustb.sei.mde.xmu.PrimitiveVariable#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Type</em>'.
	 * @see edu.ustb.sei.mde.xmu.PrimitiveVariable#getType()
	 * @see #getPrimitiveVariable()
	 * @generated
	 */
	EReference getPrimitiveVariable_Type();

	/**
	 * Returns the meta object for class '{@link edu.ustb.sei.mde.xmu.Rule <em>Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Rule</em>'.
	 * @see edu.ustb.sei.mde.xmu.Rule
	 * @generated
	 */
	EClass getRule();

	/**
	 * Returns the meta object for the containment reference list '{@link edu.ustb.sei.mde.xmu.Rule#getNVars <em>NVars</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>NVars</em>'.
	 * @see edu.ustb.sei.mde.xmu.Rule#getNVars()
	 * @see #getRule()
	 * @generated
	 */
	EReference getRule_NVars();

	/**
	 * Returns the meta object for the containment reference list '{@link edu.ustb.sei.mde.xmu.Rule#getSVars <em>SVars</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>SVars</em>'.
	 * @see edu.ustb.sei.mde.xmu.Rule#getSVars()
	 * @see #getRule()
	 * @generated
	 */
	EReference getRule_SVars();

	/**
	 * Returns the meta object for the containment reference list '{@link edu.ustb.sei.mde.xmu.Rule#getSpVars <em>Sp Vars</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Sp Vars</em>'.
	 * @see edu.ustb.sei.mde.xmu.Rule#getSpVars()
	 * @see #getRule()
	 * @generated
	 */
	EReference getRule_SpVars();

	/**
	 * Returns the meta object for the containment reference list '{@link edu.ustb.sei.mde.xmu.Rule#getVVars <em>VVars</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>VVars</em>'.
	 * @see edu.ustb.sei.mde.xmu.Rule#getVVars()
	 * @see #getRule()
	 * @generated
	 */
	EReference getRule_VVars();

	/**
	 * Returns the meta object for the containment reference '{@link edu.ustb.sei.mde.xmu.Rule#getStatement <em>Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Statement</em>'.
	 * @see edu.ustb.sei.mde.xmu.Rule#getStatement()
	 * @see #getRule()
	 * @generated
	 */
	EReference getRule_Statement();

	/**
	 * Returns the meta object for the containment reference list '{@link edu.ustb.sei.mde.xmu.Rule#getParameters <em>Parameters</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Parameters</em>'.
	 * @see edu.ustb.sei.mde.xmu.Rule#getParameters()
	 * @see #getRule()
	 * @generated
	 */
	EReference getRule_Parameters();

	/**
	 * Returns the meta object for class '{@link edu.ustb.sei.mde.xmu.Statement <em>Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Statement</em>'.
	 * @see edu.ustb.sei.mde.xmu.Statement
	 * @generated
	 */
	EClass getStatement();

	/**
	 * Returns the meta object for class '{@link edu.ustb.sei.mde.xmu.ForStatement <em>For Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>For Statement</em>'.
	 * @see edu.ustb.sei.mde.xmu.ForStatement
	 * @generated
	 */
	EClass getForStatement();

	/**
	 * Returns the meta object for the containment reference '{@link edu.ustb.sei.mde.xmu.ForStatement#getSPattern <em>SPattern</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>SPattern</em>'.
	 * @see edu.ustb.sei.mde.xmu.ForStatement#getSPattern()
	 * @see #getForStatement()
	 * @generated
	 */
	EReference getForStatement_SPattern();

	/**
	 * Returns the meta object for the containment reference '{@link edu.ustb.sei.mde.xmu.ForStatement#getVPattern <em>VPattern</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>VPattern</em>'.
	 * @see edu.ustb.sei.mde.xmu.ForStatement#getVPattern()
	 * @see #getForStatement()
	 * @generated
	 */
	EReference getForStatement_VPattern();

	/**
	 * Returns the meta object for the containment reference list '{@link edu.ustb.sei.mde.xmu.ForStatement#getActions <em>Actions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Actions</em>'.
	 * @see edu.ustb.sei.mde.xmu.ForStatement#getActions()
	 * @see #getForStatement()
	 * @generated
	 */
	EReference getForStatement_Actions();

	/**
	 * Returns the meta object for the containment reference list '{@link edu.ustb.sei.mde.xmu.ForStatement#getWhen <em>When</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>When</em>'.
	 * @see edu.ustb.sei.mde.xmu.ForStatement#getWhen()
	 * @see #getForStatement()
	 * @generated
	 */
	EReference getForStatement_When();

	/**
	 * Returns the meta object for class '{@link edu.ustb.sei.mde.xmu.Update <em>Update</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Update</em>'.
	 * @see edu.ustb.sei.mde.xmu.Update
	 * @generated
	 */
	EClass getUpdate();

	/**
	 * Returns the meta object for class '{@link edu.ustb.sei.mde.xmu.DeleteNode <em>Delete Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Delete Node</em>'.
	 * @see edu.ustb.sei.mde.xmu.DeleteNode
	 * @generated
	 */
	EClass getDeleteNode();

	/**
	 * Returns the meta object for the reference '{@link edu.ustb.sei.mde.xmu.DeleteNode#getVariable <em>Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Variable</em>'.
	 * @see edu.ustb.sei.mde.xmu.DeleteNode#getVariable()
	 * @see #getDeleteNode()
	 * @generated
	 */
	EReference getDeleteNode_Variable();

	/**
	 * Returns the meta object for class '{@link edu.ustb.sei.mde.xmu.DeleteLink <em>Delete Link</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Delete Link</em>'.
	 * @see edu.ustb.sei.mde.xmu.DeleteLink
	 * @generated
	 */
	EClass getDeleteLink();

	/**
	 * Returns the meta object for the reference '{@link edu.ustb.sei.mde.xmu.DeleteLink#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Source</em>'.
	 * @see edu.ustb.sei.mde.xmu.DeleteLink#getSource()
	 * @see #getDeleteLink()
	 * @generated
	 */
	EReference getDeleteLink_Source();

	/**
	 * Returns the meta object for the reference '{@link edu.ustb.sei.mde.xmu.DeleteLink#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target</em>'.
	 * @see edu.ustb.sei.mde.xmu.DeleteLink#getTarget()
	 * @see #getDeleteLink()
	 * @generated
	 */
	EReference getDeleteLink_Target();

	/**
	 * Returns the meta object for the reference '{@link edu.ustb.sei.mde.xmu.DeleteLink#getFeature <em>Feature</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Feature</em>'.
	 * @see edu.ustb.sei.mde.xmu.DeleteLink#getFeature()
	 * @see #getDeleteLink()
	 * @generated
	 */
	EReference getDeleteLink_Feature();

	/**
	 * Returns the meta object for class '{@link edu.ustb.sei.mde.xmu.UpdatePattern <em>Update Pattern</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Update Pattern</em>'.
	 * @see edu.ustb.sei.mde.xmu.UpdatePattern
	 * @generated
	 */
	EClass getUpdatePattern();

	/**
	 * Returns the meta object for class '{@link edu.ustb.sei.mde.xmu.Pattern <em>Pattern</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Pattern</em>'.
	 * @see edu.ustb.sei.mde.xmu.Pattern
	 * @generated
	 */
	EClass getPattern();

	/**
	 * Returns the meta object for the containment reference '{@link edu.ustb.sei.mde.xmu.Pattern#getRoot <em>Root</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Root</em>'.
	 * @see edu.ustb.sei.mde.xmu.Pattern#getRoot()
	 * @see #getPattern()
	 * @generated
	 */
	EReference getPattern_Root();

	/**
	 * Returns the meta object for the containment reference '{@link edu.ustb.sei.mde.xmu.Pattern#getGuard <em>Guard</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Guard</em>'.
	 * @see edu.ustb.sei.mde.xmu.Pattern#getGuard()
	 * @see #getPattern()
	 * @generated
	 */
	EReference getPattern_Guard();

	/**
	 * Returns the meta object for class '{@link edu.ustb.sei.mde.xmu.PatternNode <em>Pattern Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Pattern Node</em>'.
	 * @see edu.ustb.sei.mde.xmu.PatternNode
	 * @generated
	 */
	EClass getPatternNode();

	/**
	 * Returns the meta object for the reference '{@link edu.ustb.sei.mde.xmu.PatternNode#getVariable <em>Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Variable</em>'.
	 * @see edu.ustb.sei.mde.xmu.PatternNode#getVariable()
	 * @see #getPatternNode()
	 * @generated
	 */
	EReference getPatternNode_Variable();

	/**
	 * Returns the meta object for the reference '{@link edu.ustb.sei.mde.xmu.PatternNode#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Type</em>'.
	 * @see edu.ustb.sei.mde.xmu.PatternNode#getType()
	 * @see #getPatternNode()
	 * @generated
	 */
	EReference getPatternNode_Type();

	/**
	 * Returns the meta object for the containment reference list '{@link edu.ustb.sei.mde.xmu.PatternNode#getExpr <em>Expr</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Expr</em>'.
	 * @see edu.ustb.sei.mde.xmu.PatternNode#getExpr()
	 * @see #getPatternNode()
	 * @generated
	 */
	EReference getPatternNode_Expr();

	/**
	 * Returns the meta object for class '{@link edu.ustb.sei.mde.xmu.PatternExpr <em>Pattern Expr</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Pattern Expr</em>'.
	 * @see edu.ustb.sei.mde.xmu.PatternExpr
	 * @generated
	 */
	EClass getPatternExpr();

	/**
	 * Returns the meta object for class '{@link edu.ustb.sei.mde.xmu.PatternReferenceExpr <em>Pattern Reference Expr</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Pattern Reference Expr</em>'.
	 * @see edu.ustb.sei.mde.xmu.PatternReferenceExpr
	 * @generated
	 */
	EClass getPatternReferenceExpr();

	/**
	 * Returns the meta object for the reference '{@link edu.ustb.sei.mde.xmu.PatternReferenceExpr#getReference <em>Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Reference</em>'.
	 * @see edu.ustb.sei.mde.xmu.PatternReferenceExpr#getReference()
	 * @see #getPatternReferenceExpr()
	 * @generated
	 */
	EReference getPatternReferenceExpr_Reference();

	/**
	 * Returns the meta object for the containment reference '{@link edu.ustb.sei.mde.xmu.PatternReferenceExpr#getNode <em>Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Node</em>'.
	 * @see edu.ustb.sei.mde.xmu.PatternReferenceExpr#getNode()
	 * @see #getPatternReferenceExpr()
	 * @generated
	 */
	EReference getPatternReferenceExpr_Node();

	/**
	 * Returns the meta object for the containment reference '{@link edu.ustb.sei.mde.xmu.PatternReferenceExpr#getPos <em>Pos</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Pos</em>'.
	 * @see edu.ustb.sei.mde.xmu.PatternReferenceExpr#getPos()
	 * @see #getPatternReferenceExpr()
	 * @generated
	 */
	EReference getPatternReferenceExpr_Pos();

	/**
	 * Returns the meta object for class '{@link edu.ustb.sei.mde.xmu.PatternEqualExpr <em>Pattern Equal Expr</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Pattern Equal Expr</em>'.
	 * @see edu.ustb.sei.mde.xmu.PatternEqualExpr
	 * @generated
	 */
	EClass getPatternEqualExpr();

	/**
	 * Returns the meta object for the reference '{@link edu.ustb.sei.mde.xmu.PatternEqualExpr#getFeature <em>Feature</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Feature</em>'.
	 * @see edu.ustb.sei.mde.xmu.PatternEqualExpr#getFeature()
	 * @see #getPatternEqualExpr()
	 * @generated
	 */
	EReference getPatternEqualExpr_Feature();

	/**
	 * Returns the meta object for the containment reference '{@link edu.ustb.sei.mde.xmu.PatternEqualExpr#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Value</em>'.
	 * @see edu.ustb.sei.mde.xmu.PatternEqualExpr#getValue()
	 * @see #getPatternEqualExpr()
	 * @generated
	 */
	EReference getPatternEqualExpr_Value();

	/**
	 * Returns the meta object for the containment reference '{@link edu.ustb.sei.mde.xmu.PatternEqualExpr#getPos <em>Pos</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Pos</em>'.
	 * @see edu.ustb.sei.mde.xmu.PatternEqualExpr#getPos()
	 * @see #getPatternEqualExpr()
	 * @generated
	 */
	EReference getPatternEqualExpr_Pos();

	/**
	 * Returns the meta object for class '{@link edu.ustb.sei.mde.xmu.Expr <em>Expr</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Expr</em>'.
	 * @see edu.ustb.sei.mde.xmu.Expr
	 * @generated
	 */
	EClass getExpr();

	/**
	 * Returns the meta object for class '{@link edu.ustb.sei.mde.xmu.VariableExp <em>Variable Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Variable Exp</em>'.
	 * @see edu.ustb.sei.mde.xmu.VariableExp
	 * @generated
	 */
	EClass getVariableExp();

	/**
	 * Returns the meta object for the reference '{@link edu.ustb.sei.mde.xmu.VariableExp#getVar <em>Var</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Var</em>'.
	 * @see edu.ustb.sei.mde.xmu.VariableExp#getVar()
	 * @see #getVariableExp()
	 * @generated
	 */
	EReference getVariableExp_Var();

	/**
	 * Returns the meta object for the containment reference list '{@link edu.ustb.sei.mde.xmu.VariableExp#getPath <em>Path</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Path</em>'.
	 * @see edu.ustb.sei.mde.xmu.VariableExp#getPath()
	 * @see #getVariableExp()
	 * @generated
	 */
	EReference getVariableExp_Path();

	/**
	 * Returns the meta object for class '{@link edu.ustb.sei.mde.xmu.ConstantExpr <em>Constant Expr</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Constant Expr</em>'.
	 * @see edu.ustb.sei.mde.xmu.ConstantExpr
	 * @generated
	 */
	EClass getConstantExpr();

	/**
	 * Returns the meta object for class '{@link edu.ustb.sei.mde.xmu.EmptyLiteral <em>Empty Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Empty Literal</em>'.
	 * @see edu.ustb.sei.mde.xmu.EmptyLiteral
	 * @generated
	 */
	EClass getEmptyLiteral();

	/**
	 * Returns the meta object for the attribute '{@link edu.ustb.sei.mde.xmu.EmptyLiteral#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see edu.ustb.sei.mde.xmu.EmptyLiteral#getValue()
	 * @see #getEmptyLiteral()
	 * @generated
	 */
	EAttribute getEmptyLiteral_Value();

	/**
	 * Returns the meta object for class '{@link edu.ustb.sei.mde.xmu.StringLiteral <em>String Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>String Literal</em>'.
	 * @see edu.ustb.sei.mde.xmu.StringLiteral
	 * @generated
	 */
	EClass getStringLiteral();

	/**
	 * Returns the meta object for the attribute '{@link edu.ustb.sei.mde.xmu.StringLiteral#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see edu.ustb.sei.mde.xmu.StringLiteral#getValue()
	 * @see #getStringLiteral()
	 * @generated
	 */
	EAttribute getStringLiteral_Value();

	/**
	 * Returns the meta object for class '{@link edu.ustb.sei.mde.xmu.IntegerLiteral <em>Integer Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Integer Literal</em>'.
	 * @see edu.ustb.sei.mde.xmu.IntegerLiteral
	 * @generated
	 */
	EClass getIntegerLiteral();

	/**
	 * Returns the meta object for the attribute '{@link edu.ustb.sei.mde.xmu.IntegerLiteral#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see edu.ustb.sei.mde.xmu.IntegerLiteral#getValue()
	 * @see #getIntegerLiteral()
	 * @generated
	 */
	EAttribute getIntegerLiteral_Value();

	/**
	 * Returns the meta object for class '{@link edu.ustb.sei.mde.xmu.BooleanLiteral <em>Boolean Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Boolean Literal</em>'.
	 * @see edu.ustb.sei.mde.xmu.BooleanLiteral
	 * @generated
	 */
	EClass getBooleanLiteral();

	/**
	 * Returns the meta object for the attribute '{@link edu.ustb.sei.mde.xmu.BooleanLiteral#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see edu.ustb.sei.mde.xmu.BooleanLiteral#getValue()
	 * @see #getBooleanLiteral()
	 * @generated
	 */
	EAttribute getBooleanLiteral_Value();

	/**
	 * Returns the meta object for class '{@link edu.ustb.sei.mde.xmu.EnumLiteral <em>Enum Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Enum Literal</em>'.
	 * @see edu.ustb.sei.mde.xmu.EnumLiteral
	 * @generated
	 */
	EClass getEnumLiteral();

	/**
	 * Returns the meta object for the reference '{@link edu.ustb.sei.mde.xmu.EnumLiteral#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Type</em>'.
	 * @see edu.ustb.sei.mde.xmu.EnumLiteral#getType()
	 * @see #getEnumLiteral()
	 * @generated
	 */
	EReference getEnumLiteral_Type();

	/**
	 * Returns the meta object for the reference '{@link edu.ustb.sei.mde.xmu.EnumLiteral#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Value</em>'.
	 * @see edu.ustb.sei.mde.xmu.EnumLiteral#getValue()
	 * @see #getEnumLiteral()
	 * @generated
	 */
	EReference getEnumLiteral_Value();

	/**
	 * Returns the meta object for class '{@link edu.ustb.sei.mde.xmu.VStatement <em>VStatement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>VStatement</em>'.
	 * @see edu.ustb.sei.mde.xmu.VStatement
	 * @generated
	 */
	EClass getVStatement();

	/**
	 * Returns the meta object for the attribute '{@link edu.ustb.sei.mde.xmu.VStatement#getTag <em>Tag</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Tag</em>'.
	 * @see edu.ustb.sei.mde.xmu.VStatement#getTag()
	 * @see #getVStatement()
	 * @generated
	 */
	EAttribute getVStatement_Tag();

	/**
	 * Returns the meta object for the containment reference '{@link edu.ustb.sei.mde.xmu.VStatement#getStatement <em>Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Statement</em>'.
	 * @see edu.ustb.sei.mde.xmu.VStatement#getStatement()
	 * @see #getVStatement()
	 * @generated
	 */
	EReference getVStatement_Statement();

	/**
	 * Returns the meta object for class '{@link edu.ustb.sei.mde.xmu.BlockStatement <em>Block Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Block Statement</em>'.
	 * @see edu.ustb.sei.mde.xmu.BlockStatement
	 * @generated
	 */
	EClass getBlockStatement();

	/**
	 * Returns the meta object for the containment reference list '{@link edu.ustb.sei.mde.xmu.BlockStatement#getStatements <em>Statements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Statements</em>'.
	 * @see edu.ustb.sei.mde.xmu.BlockStatement#getStatements()
	 * @see #getBlockStatement()
	 * @generated
	 */
	EReference getBlockStatement_Statements();

	/**
	 * Returns the meta object for class '{@link edu.ustb.sei.mde.xmu.SwitchStatement <em>Switch Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Switch Statement</em>'.
	 * @see edu.ustb.sei.mde.xmu.SwitchStatement
	 * @generated
	 */
	EClass getSwitchStatement();

	/**
	 * Returns the meta object for the reference '{@link edu.ustb.sei.mde.xmu.SwitchStatement#getVar <em>Var</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Var</em>'.
	 * @see edu.ustb.sei.mde.xmu.SwitchStatement#getVar()
	 * @see #getSwitchStatement()
	 * @generated
	 */
	EReference getSwitchStatement_Var();

	/**
	 * Returns the meta object for the containment reference list '{@link edu.ustb.sei.mde.xmu.SwitchStatement#getCases <em>Cases</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Cases</em>'.
	 * @see edu.ustb.sei.mde.xmu.SwitchStatement#getCases()
	 * @see #getSwitchStatement()
	 * @generated
	 */
	EReference getSwitchStatement_Cases();

	/**
	 * Returns the meta object for the containment reference list '{@link edu.ustb.sei.mde.xmu.SwitchStatement#getWhen <em>When</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>When</em>'.
	 * @see edu.ustb.sei.mde.xmu.SwitchStatement#getWhen()
	 * @see #getSwitchStatement()
	 * @generated
	 */
	EReference getSwitchStatement_When();

	/**
	 * Returns the meta object for class '{@link edu.ustb.sei.mde.xmu.TaggedElement <em>Tagged Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Tagged Element</em>'.
	 * @see edu.ustb.sei.mde.xmu.TaggedElement
	 * @generated
	 */
	EClass getTaggedElement();

	/**
	 * Returns the meta object for the attribute '{@link edu.ustb.sei.mde.xmu.TaggedElement#getTag <em>Tag</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Tag</em>'.
	 * @see edu.ustb.sei.mde.xmu.TaggedElement#getTag()
	 * @see #getTaggedElement()
	 * @generated
	 */
	EAttribute getTaggedElement_Tag();

	/**
	 * Returns the meta object for class '{@link edu.ustb.sei.mde.xmu.CaseSubStatement <em>Case Sub Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Case Sub Statement</em>'.
	 * @see edu.ustb.sei.mde.xmu.CaseSubStatement
	 * @generated
	 */
	EClass getCaseSubStatement();

	/**
	 * Returns the meta object for the containment reference '{@link edu.ustb.sei.mde.xmu.CaseSubStatement#getStatement <em>Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Statement</em>'.
	 * @see edu.ustb.sei.mde.xmu.CaseSubStatement#getStatement()
	 * @see #getCaseSubStatement()
	 * @generated
	 */
	EReference getCaseSubStatement_Statement();

	/**
	 * Returns the meta object for class '{@link edu.ustb.sei.mde.xmu.CasePatternStatement <em>Case Pattern Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Case Pattern Statement</em>'.
	 * @see edu.ustb.sei.mde.xmu.CasePatternStatement
	 * @generated
	 */
	EClass getCasePatternStatement();

	/**
	 * Returns the meta object for the containment reference '{@link edu.ustb.sei.mde.xmu.CasePatternStatement#getPattern <em>Pattern</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Pattern</em>'.
	 * @see edu.ustb.sei.mde.xmu.CasePatternStatement#getPattern()
	 * @see #getCasePatternStatement()
	 * @generated
	 */
	EReference getCasePatternStatement_Pattern();

	/**
	 * Returns the meta object for class '{@link edu.ustb.sei.mde.xmu.CaseValueStatement <em>Case Value Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Case Value Statement</em>'.
	 * @see edu.ustb.sei.mde.xmu.CaseValueStatement
	 * @generated
	 */
	EClass getCaseValueStatement();

	/**
	 * Returns the meta object for the containment reference '{@link edu.ustb.sei.mde.xmu.CaseValueStatement#getExpression <em>Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Expression</em>'.
	 * @see edu.ustb.sei.mde.xmu.CaseValueStatement#getExpression()
	 * @see #getCaseValueStatement()
	 * @generated
	 */
	EReference getCaseValueStatement_Expression();

	/**
	 * Returns the meta object for class '{@link edu.ustb.sei.mde.xmu.XMUModel <em>XMU Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>XMU Model</em>'.
	 * @see edu.ustb.sei.mde.xmu.XMUModel
	 * @generated
	 */
	EClass getXMUModel();

	/**
	 * Returns the meta object for the containment reference list '{@link edu.ustb.sei.mde.xmu.XMUModel#getRules <em>Rules</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Rules</em>'.
	 * @see edu.ustb.sei.mde.xmu.XMUModel#getRules()
	 * @see #getXMUModel()
	 * @generated
	 */
	EReference getXMUModel_Rules();

	/**
	 * Returns the meta object for the reference list '{@link edu.ustb.sei.mde.xmu.XMUModel#getPackages <em>Packages</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Packages</em>'.
	 * @see edu.ustb.sei.mde.xmu.XMUModel#getPackages()
	 * @see #getXMUModel()
	 * @generated
	 */
	EReference getXMUModel_Packages();

	/**
	 * Returns the meta object for the containment reference list '{@link edu.ustb.sei.mde.xmu.XMUModel#getStart <em>Start</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Start</em>'.
	 * @see edu.ustb.sei.mde.xmu.XMUModel#getStart()
	 * @see #getXMUModel()
	 * @generated
	 */
	EReference getXMUModel_Start();

	/**
	 * Returns the meta object for class '{@link edu.ustb.sei.mde.xmu.Parameter <em>Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Parameter</em>'.
	 * @see edu.ustb.sei.mde.xmu.Parameter
	 * @generated
	 */
	EClass getParameter();

	/**
	 * Returns the meta object for the reference '{@link edu.ustb.sei.mde.xmu.Parameter#getVariable <em>Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Variable</em>'.
	 * @see edu.ustb.sei.mde.xmu.Parameter#getVariable()
	 * @see #getParameter()
	 * @generated
	 */
	EReference getParameter_Variable();

	/**
	 * Returns the meta object for class '{@link edu.ustb.sei.mde.xmu.RuleCallStatement <em>Rule Call Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Rule Call Statement</em>'.
	 * @see edu.ustb.sei.mde.xmu.RuleCallStatement
	 * @generated
	 */
	EClass getRuleCallStatement();

	/**
	 * Returns the meta object for the containment reference list '{@link edu.ustb.sei.mde.xmu.RuleCallStatement#getActualParameters <em>Actual Parameters</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Actual Parameters</em>'.
	 * @see edu.ustb.sei.mde.xmu.RuleCallStatement#getActualParameters()
	 * @see #getRuleCallStatement()
	 * @generated
	 */
	EReference getRuleCallStatement_ActualParameters();

	/**
	 * Returns the meta object for the reference '{@link edu.ustb.sei.mde.xmu.RuleCallStatement#getRule <em>Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Rule</em>'.
	 * @see edu.ustb.sei.mde.xmu.RuleCallStatement#getRule()
	 * @see #getRuleCallStatement()
	 * @generated
	 */
	EReference getRuleCallStatement_Rule();

	/**
	 * Returns the meta object for class '{@link edu.ustb.sei.mde.xmu.UpdatedStatement <em>Updated Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Updated Statement</em>'.
	 * @see edu.ustb.sei.mde.xmu.UpdatedStatement
	 * @generated
	 */
	EClass getUpdatedStatement();

	/**
	 * Returns the meta object for the reference '{@link edu.ustb.sei.mde.xmu.UpdatedStatement#getSVar <em>SVar</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>SVar</em>'.
	 * @see edu.ustb.sei.mde.xmu.UpdatedStatement#getSVar()
	 * @see #getUpdatedStatement()
	 * @generated
	 */
	EReference getUpdatedStatement_SVar();

	/**
	 * Returns the meta object for the reference '{@link edu.ustb.sei.mde.xmu.UpdatedStatement#getVVar <em>VVar</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>VVar</em>'.
	 * @see edu.ustb.sei.mde.xmu.UpdatedStatement#getVVar()
	 * @see #getUpdatedStatement()
	 * @generated
	 */
	EReference getUpdatedStatement_VVar();

	/**
	 * Returns the meta object for class '{@link edu.ustb.sei.mde.xmu.BooleanOrExpr <em>Boolean Or Expr</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Boolean Or Expr</em>'.
	 * @see edu.ustb.sei.mde.xmu.BooleanOrExpr
	 * @generated
	 */
	EClass getBooleanOrExpr();

	/**
	 * Returns the meta object for the containment reference list '{@link edu.ustb.sei.mde.xmu.BooleanOrExpr#getOperands <em>Operands</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Operands</em>'.
	 * @see edu.ustb.sei.mde.xmu.BooleanOrExpr#getOperands()
	 * @see #getBooleanOrExpr()
	 * @generated
	 */
	EReference getBooleanOrExpr_Operands();

	/**
	 * Returns the meta object for class '{@link edu.ustb.sei.mde.xmu.BooleanOrExprChild <em>Boolean Or Expr Child</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Boolean Or Expr Child</em>'.
	 * @see edu.ustb.sei.mde.xmu.BooleanOrExprChild
	 * @generated
	 */
	EClass getBooleanOrExprChild();

	/**
	 * Returns the meta object for class '{@link edu.ustb.sei.mde.xmu.BooleanAndExpr <em>Boolean And Expr</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Boolean And Expr</em>'.
	 * @see edu.ustb.sei.mde.xmu.BooleanAndExpr
	 * @generated
	 */
	EClass getBooleanAndExpr();

	/**
	 * Returns the meta object for the containment reference list '{@link edu.ustb.sei.mde.xmu.BooleanAndExpr#getOperands <em>Operands</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Operands</em>'.
	 * @see edu.ustb.sei.mde.xmu.BooleanAndExpr#getOperands()
	 * @see #getBooleanAndExpr()
	 * @generated
	 */
	EReference getBooleanAndExpr_Operands();

	/**
	 * Returns the meta object for class '{@link edu.ustb.sei.mde.xmu.BooleanAndExprChild <em>Boolean And Expr Child</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Boolean And Expr Child</em>'.
	 * @see edu.ustb.sei.mde.xmu.BooleanAndExprChild
	 * @generated
	 */
	EClass getBooleanAndExprChild();

	/**
	 * Returns the meta object for class '{@link edu.ustb.sei.mde.xmu.RelationalExpr <em>Relational Expr</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Relational Expr</em>'.
	 * @see edu.ustb.sei.mde.xmu.RelationalExpr
	 * @generated
	 */
	EClass getRelationalExpr();

	/**
	 * Returns the meta object for the containment reference '{@link edu.ustb.sei.mde.xmu.RelationalExpr#getLeft <em>Left</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Left</em>'.
	 * @see edu.ustb.sei.mde.xmu.RelationalExpr#getLeft()
	 * @see #getRelationalExpr()
	 * @generated
	 */
	EReference getRelationalExpr_Left();

	/**
	 * Returns the meta object for the containment reference '{@link edu.ustb.sei.mde.xmu.RelationalExpr#getRight <em>Right</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Right</em>'.
	 * @see edu.ustb.sei.mde.xmu.RelationalExpr#getRight()
	 * @see #getRelationalExpr()
	 * @generated
	 */
	EReference getRelationalExpr_Right();

	/**
	 * Returns the meta object for the attribute '{@link edu.ustb.sei.mde.xmu.RelationalExpr#getOperator <em>Operator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Operator</em>'.
	 * @see edu.ustb.sei.mde.xmu.RelationalExpr#getOperator()
	 * @see #getRelationalExpr()
	 * @generated
	 */
	EAttribute getRelationalExpr_Operator();

	/**
	 * Returns the meta object for class '{@link edu.ustb.sei.mde.xmu.RelationalExprChild <em>Relational Expr Child</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Relational Expr Child</em>'.
	 * @see edu.ustb.sei.mde.xmu.RelationalExprChild
	 * @generated
	 */
	EClass getRelationalExprChild();

	/**
	 * Returns the meta object for class '{@link edu.ustb.sei.mde.xmu.AdditiveExpr <em>Additive Expr</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Additive Expr</em>'.
	 * @see edu.ustb.sei.mde.xmu.AdditiveExpr
	 * @generated
	 */
	EClass getAdditiveExpr();

	/**
	 * Returns the meta object for the containment reference list '{@link edu.ustb.sei.mde.xmu.AdditiveExpr#getOperands <em>Operands</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Operands</em>'.
	 * @see edu.ustb.sei.mde.xmu.AdditiveExpr#getOperands()
	 * @see #getAdditiveExpr()
	 * @generated
	 */
	EReference getAdditiveExpr_Operands();

	/**
	 * Returns the meta object for the attribute list '{@link edu.ustb.sei.mde.xmu.AdditiveExpr#getOperators <em>Operators</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Operators</em>'.
	 * @see edu.ustb.sei.mde.xmu.AdditiveExpr#getOperators()
	 * @see #getAdditiveExpr()
	 * @generated
	 */
	EAttribute getAdditiveExpr_Operators();

	/**
	 * Returns the meta object for class '{@link edu.ustb.sei.mde.xmu.AdditiveExprChild <em>Additive Expr Child</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Additive Expr Child</em>'.
	 * @see edu.ustb.sei.mde.xmu.AdditiveExprChild
	 * @generated
	 */
	EClass getAdditiveExprChild();

	/**
	 * Returns the meta object for class '{@link edu.ustb.sei.mde.xmu.MultiplicativeExpr <em>Multiplicative Expr</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Multiplicative Expr</em>'.
	 * @see edu.ustb.sei.mde.xmu.MultiplicativeExpr
	 * @generated
	 */
	EClass getMultiplicativeExpr();

	/**
	 * Returns the meta object for the containment reference list '{@link edu.ustb.sei.mde.xmu.MultiplicativeExpr#getOperands <em>Operands</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Operands</em>'.
	 * @see edu.ustb.sei.mde.xmu.MultiplicativeExpr#getOperands()
	 * @see #getMultiplicativeExpr()
	 * @generated
	 */
	EReference getMultiplicativeExpr_Operands();

	/**
	 * Returns the meta object for the attribute list '{@link edu.ustb.sei.mde.xmu.MultiplicativeExpr#getOperators <em>Operators</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Operators</em>'.
	 * @see edu.ustb.sei.mde.xmu.MultiplicativeExpr#getOperators()
	 * @see #getMultiplicativeExpr()
	 * @generated
	 */
	EAttribute getMultiplicativeExpr_Operators();

	/**
	 * Returns the meta object for class '{@link edu.ustb.sei.mde.xmu.MultiplicativeExprChild <em>Multiplicative Expr Child</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Multiplicative Expr Child</em>'.
	 * @see edu.ustb.sei.mde.xmu.MultiplicativeExprChild
	 * @generated
	 */
	EClass getMultiplicativeExprChild();

	/**
	 * Returns the meta object for class '{@link edu.ustb.sei.mde.xmu.UnaryExpr <em>Unary Expr</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Unary Expr</em>'.
	 * @see edu.ustb.sei.mde.xmu.UnaryExpr
	 * @generated
	 */
	EClass getUnaryExpr();

	/**
	 * Returns the meta object for the containment reference '{@link edu.ustb.sei.mde.xmu.UnaryExpr#getBody <em>Body</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Body</em>'.
	 * @see edu.ustb.sei.mde.xmu.UnaryExpr#getBody()
	 * @see #getUnaryExpr()
	 * @generated
	 */
	EReference getUnaryExpr_Body();

	/**
	 * Returns the meta object for the attribute '{@link edu.ustb.sei.mde.xmu.UnaryExpr#getOperator <em>Operator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Operator</em>'.
	 * @see edu.ustb.sei.mde.xmu.UnaryExpr#getOperator()
	 * @see #getUnaryExpr()
	 * @generated
	 */
	EAttribute getUnaryExpr_Operator();

	/**
	 * Returns the meta object for class '{@link edu.ustb.sei.mde.xmu.UnaryExprChild <em>Unary Expr Child</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Unary Expr Child</em>'.
	 * @see edu.ustb.sei.mde.xmu.UnaryExprChild
	 * @generated
	 */
	EClass getUnaryExprChild();

	/**
	 * Returns the meta object for class '{@link edu.ustb.sei.mde.xmu.AtomicExpr <em>Atomic Expr</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Atomic Expr</em>'.
	 * @see edu.ustb.sei.mde.xmu.AtomicExpr
	 * @generated
	 */
	EClass getAtomicExpr();

	/**
	 * Returns the meta object for class '{@link edu.ustb.sei.mde.xmu.ParenExpr <em>Paren Expr</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Paren Expr</em>'.
	 * @see edu.ustb.sei.mde.xmu.ParenExpr
	 * @generated
	 */
	EClass getParenExpr();

	/**
	 * Returns the meta object for the containment reference '{@link edu.ustb.sei.mde.xmu.ParenExpr#getBody <em>Body</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Body</em>'.
	 * @see edu.ustb.sei.mde.xmu.ParenExpr#getBody()
	 * @see #getParenExpr()
	 * @generated
	 */
	EReference getParenExpr_Body();

	/**
	 * Returns the meta object for class '{@link edu.ustb.sei.mde.xmu.Path <em>Path</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Path</em>'.
	 * @see edu.ustb.sei.mde.xmu.Path
	 * @generated
	 */
	EClass getPath();

	/**
	 * Returns the meta object for class '{@link edu.ustb.sei.mde.xmu.FeaturePath <em>Feature Path</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Feature Path</em>'.
	 * @see edu.ustb.sei.mde.xmu.FeaturePath
	 * @generated
	 */
	EClass getFeaturePath();

	/**
	 * Returns the meta object for the attribute '{@link edu.ustb.sei.mde.xmu.FeaturePath#getFeature <em>Feature</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Feature</em>'.
	 * @see edu.ustb.sei.mde.xmu.FeaturePath#getFeature()
	 * @see #getFeaturePath()
	 * @generated
	 */
	EAttribute getFeaturePath_Feature();

	/**
	 * Returns the meta object for class '{@link edu.ustb.sei.mde.xmu.OperationPath <em>Operation Path</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Operation Path</em>'.
	 * @see edu.ustb.sei.mde.xmu.OperationPath
	 * @generated
	 */
	EClass getOperationPath();

	/**
	 * Returns the meta object for the attribute '{@link edu.ustb.sei.mde.xmu.OperationPath#getOperation <em>Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Operation</em>'.
	 * @see edu.ustb.sei.mde.xmu.OperationPath#getOperation()
	 * @see #getOperationPath()
	 * @generated
	 */
	EAttribute getOperationPath_Operation();

	/**
	 * Returns the meta object for the containment reference list '{@link edu.ustb.sei.mde.xmu.OperationPath#getParameters <em>Parameters</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Parameters</em>'.
	 * @see edu.ustb.sei.mde.xmu.OperationPath#getParameters()
	 * @see #getOperationPath()
	 * @generated
	 */
	EReference getOperationPath_Parameters();

	/**
	 * Returns the meta object for class '{@link edu.ustb.sei.mde.xmu.LoopPath <em>Loop Path</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Loop Path</em>'.
	 * @see edu.ustb.sei.mde.xmu.LoopPath
	 * @generated
	 */
	EClass getLoopPath();

	/**
	 * Returns the meta object for the attribute '{@link edu.ustb.sei.mde.xmu.LoopPath#getOperator <em>Operator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Operator</em>'.
	 * @see edu.ustb.sei.mde.xmu.LoopPath#getOperator()
	 * @see #getLoopPath()
	 * @generated
	 */
	EAttribute getLoopPath_Operator();

	/**
	 * Returns the meta object for the containment reference '{@link edu.ustb.sei.mde.xmu.LoopPath#getVariable <em>Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Variable</em>'.
	 * @see edu.ustb.sei.mde.xmu.LoopPath#getVariable()
	 * @see #getLoopPath()
	 * @generated
	 */
	EReference getLoopPath_Variable();

	/**
	 * Returns the meta object for the containment reference '{@link edu.ustb.sei.mde.xmu.LoopPath#getBody <em>Body</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Body</em>'.
	 * @see edu.ustb.sei.mde.xmu.LoopPath#getBody()
	 * @see #getLoopPath()
	 * @generated
	 */
	EReference getLoopPath_Body();

	/**
	 * Returns the meta object for class '{@link edu.ustb.sei.mde.xmu.StartStatement <em>Start Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Start Statement</em>'.
	 * @see edu.ustb.sei.mde.xmu.StartStatement
	 * @generated
	 */
	EClass getStartStatement();

	/**
	 * Returns the meta object for the reference '{@link edu.ustb.sei.mde.xmu.StartStatement#getRule <em>Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Rule</em>'.
	 * @see edu.ustb.sei.mde.xmu.StartStatement#getRule()
	 * @see #getStartStatement()
	 * @generated
	 */
	EReference getStartStatement_Rule();

	/**
	 * Returns the meta object for the containment reference list '{@link edu.ustb.sei.mde.xmu.StartStatement#getRoot <em>Root</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Root</em>'.
	 * @see edu.ustb.sei.mde.xmu.StartStatement#getRoot()
	 * @see #getStartStatement()
	 * @generated
	 */
	EReference getStartStatement_Root();

	/**
	 * Returns the meta object for class '{@link edu.ustb.sei.mde.xmu.StartRoot <em>Start Root</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Start Root</em>'.
	 * @see edu.ustb.sei.mde.xmu.StartRoot
	 * @generated
	 */
	EClass getStartRoot();

	/**
	 * Returns the meta object for the attribute '{@link edu.ustb.sei.mde.xmu.StartRoot#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see edu.ustb.sei.mde.xmu.StartRoot#getId()
	 * @see #getStartRoot()
	 * @generated
	 */
	EAttribute getStartRoot_Id();

	/**
	 * Returns the meta object for class '{@link edu.ustb.sei.mde.xmu.EResource <em>EResource</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>EResource</em>'.
	 * @see edu.ustb.sei.mde.xmu.EResource
	 * @generated
	 */
	EClass getEResource();

	/**
	 * Returns the meta object for the reference list '{@link edu.ustb.sei.mde.xmu.EResource#getContent <em>Content</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Content</em>'.
	 * @see edu.ustb.sei.mde.xmu.EResource#getContent()
	 * @see #getEResource()
	 * @generated
	 */
	EReference getEResource_Content();

	/**
	 * Returns the meta object for class '{@link edu.ustb.sei.mde.xmu.PrintStatement <em>Print Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Print Statement</em>'.
	 * @see edu.ustb.sei.mde.xmu.PrintStatement
	 * @generated
	 */
	EClass getPrintStatement();

	/**
	 * Returns the meta object for the containment reference '{@link edu.ustb.sei.mde.xmu.PrintStatement#getExpr <em>Expr</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Expr</em>'.
	 * @see edu.ustb.sei.mde.xmu.PrintStatement#getExpr()
	 * @see #getPrintStatement()
	 * @generated
	 */
	EReference getPrintStatement_Expr();

	/**
	 * Returns the meta object for class '{@link edu.ustb.sei.mde.xmu.AllInstanceExpr <em>All Instance Expr</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>All Instance Expr</em>'.
	 * @see edu.ustb.sei.mde.xmu.AllInstanceExpr
	 * @generated
	 */
	EClass getAllInstanceExpr();

	/**
	 * Returns the meta object for the containment reference '{@link edu.ustb.sei.mde.xmu.AllInstanceExpr#getRoot <em>Root</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Root</em>'.
	 * @see edu.ustb.sei.mde.xmu.AllInstanceExpr#getRoot()
	 * @see #getAllInstanceExpr()
	 * @generated
	 */
	EReference getAllInstanceExpr_Root();

	/**
	 * Returns the meta object for the reference '{@link edu.ustb.sei.mde.xmu.AllInstanceExpr#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Type</em>'.
	 * @see edu.ustb.sei.mde.xmu.AllInstanceExpr#getType()
	 * @see #getAllInstanceExpr()
	 * @generated
	 */
	EReference getAllInstanceExpr_Type();

	/**
	 * Returns the meta object for class '{@link edu.ustb.sei.mde.xmu.ESet <em>ESet</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>ESet</em>'.
	 * @see edu.ustb.sei.mde.xmu.ESet
	 * @generated
	 */
	EClass getESet();

	/**
	 * Returns the meta object for the reference list '{@link edu.ustb.sei.mde.xmu.ESet#getContent <em>Content</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Content</em>'.
	 * @see edu.ustb.sei.mde.xmu.ESet#getContent()
	 * @see #getESet()
	 * @generated
	 */
	EReference getESet_Content();

	/**
	 * Returns the meta object for enum '{@link edu.ustb.sei.mde.xmu.VariableFlag <em>Variable Flag</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Variable Flag</em>'.
	 * @see edu.ustb.sei.mde.xmu.VariableFlag
	 * @generated
	 */
	EEnum getVariableFlag();

	/**
	 * Returns the meta object for enum '{@link edu.ustb.sei.mde.xmu.RelationalOperator <em>Relational Operator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Relational Operator</em>'.
	 * @see edu.ustb.sei.mde.xmu.RelationalOperator
	 * @generated
	 */
	EEnum getRelationalOperator();

	/**
	 * Returns the meta object for enum '{@link edu.ustb.sei.mde.xmu.EmptyType <em>Empty Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Empty Type</em>'.
	 * @see edu.ustb.sei.mde.xmu.EmptyType
	 * @generated
	 */
	EEnum getEmptyType();

	/**
	 * Returns the meta object for enum '{@link edu.ustb.sei.mde.xmu.VStmtType <em>VStmt Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>VStmt Type</em>'.
	 * @see edu.ustb.sei.mde.xmu.VStmtType
	 * @generated
	 */
	EEnum getVStmtType();

	/**
	 * Returns the meta object for enum '{@link edu.ustb.sei.mde.xmu.AdditiveOperator <em>Additive Operator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Additive Operator</em>'.
	 * @see edu.ustb.sei.mde.xmu.AdditiveOperator
	 * @generated
	 */
	EEnum getAdditiveOperator();

	/**
	 * Returns the meta object for enum '{@link edu.ustb.sei.mde.xmu.MultiplicativeOperator <em>Multiplicative Operator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Multiplicative Operator</em>'.
	 * @see edu.ustb.sei.mde.xmu.MultiplicativeOperator
	 * @generated
	 */
	EEnum getMultiplicativeOperator();

	/**
	 * Returns the meta object for enum '{@link edu.ustb.sei.mde.xmu.UnaryOperator <em>Unary Operator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Unary Operator</em>'.
	 * @see edu.ustb.sei.mde.xmu.UnaryOperator
	 * @generated
	 */
	EEnum getUnaryOperator();

	/**
	 * Returns the meta object for enum '{@link edu.ustb.sei.mde.xmu.LoopOperator <em>Loop Operator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Loop Operator</em>'.
	 * @see edu.ustb.sei.mde.xmu.LoopOperator
	 * @generated
	 */
	EEnum getLoopOperator();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	XmuFactory getXmuFactory();

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
		 * The meta object literal for the '{@link edu.ustb.sei.mde.xmu.impl.NamedElementImpl <em>Named Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.ustb.sei.mde.xmu.impl.NamedElementImpl
		 * @see edu.ustb.sei.mde.xmu.impl.XmuPackageImpl#getNamedElement()
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
		 * The meta object literal for the '{@link edu.ustb.sei.mde.xmu.impl.VariableImpl <em>Variable</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.ustb.sei.mde.xmu.impl.VariableImpl
		 * @see edu.ustb.sei.mde.xmu.impl.XmuPackageImpl#getVariable()
		 * @generated
		 */
		EClass VARIABLE = eINSTANCE.getVariable();

		/**
		 * The meta object literal for the '{@link edu.ustb.sei.mde.xmu.impl.ObjectVariableImpl <em>Object Variable</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.ustb.sei.mde.xmu.impl.ObjectVariableImpl
		 * @see edu.ustb.sei.mde.xmu.impl.XmuPackageImpl#getObjectVariable()
		 * @generated
		 */
		EClass OBJECT_VARIABLE = eINSTANCE.getObjectVariable();

		/**
		 * The meta object literal for the '{@link edu.ustb.sei.mde.xmu.impl.PrimitiveVariableImpl <em>Primitive Variable</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.ustb.sei.mde.xmu.impl.PrimitiveVariableImpl
		 * @see edu.ustb.sei.mde.xmu.impl.XmuPackageImpl#getPrimitiveVariable()
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
		 * The meta object literal for the '{@link edu.ustb.sei.mde.xmu.impl.RuleImpl <em>Rule</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.ustb.sei.mde.xmu.impl.RuleImpl
		 * @see edu.ustb.sei.mde.xmu.impl.XmuPackageImpl#getRule()
		 * @generated
		 */
		EClass RULE = eINSTANCE.getRule();

		/**
		 * The meta object literal for the '<em><b>NVars</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RULE__NVARS = eINSTANCE.getRule_NVars();

		/**
		 * The meta object literal for the '<em><b>SVars</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RULE__SVARS = eINSTANCE.getRule_SVars();

		/**
		 * The meta object literal for the '<em><b>Sp Vars</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RULE__SP_VARS = eINSTANCE.getRule_SpVars();

		/**
		 * The meta object literal for the '<em><b>VVars</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RULE__VVARS = eINSTANCE.getRule_VVars();

		/**
		 * The meta object literal for the '<em><b>Statement</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RULE__STATEMENT = eINSTANCE.getRule_Statement();

		/**
		 * The meta object literal for the '<em><b>Parameters</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RULE__PARAMETERS = eINSTANCE.getRule_Parameters();

		/**
		 * The meta object literal for the '{@link edu.ustb.sei.mde.xmu.impl.StatementImpl <em>Statement</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.ustb.sei.mde.xmu.impl.StatementImpl
		 * @see edu.ustb.sei.mde.xmu.impl.XmuPackageImpl#getStatement()
		 * @generated
		 */
		EClass STATEMENT = eINSTANCE.getStatement();

		/**
		 * The meta object literal for the '{@link edu.ustb.sei.mde.xmu.impl.ForStatementImpl <em>For Statement</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.ustb.sei.mde.xmu.impl.ForStatementImpl
		 * @see edu.ustb.sei.mde.xmu.impl.XmuPackageImpl#getForStatement()
		 * @generated
		 */
		EClass FOR_STATEMENT = eINSTANCE.getForStatement();

		/**
		 * The meta object literal for the '<em><b>SPattern</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FOR_STATEMENT__SPATTERN = eINSTANCE.getForStatement_SPattern();

		/**
		 * The meta object literal for the '<em><b>VPattern</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FOR_STATEMENT__VPATTERN = eINSTANCE.getForStatement_VPattern();

		/**
		 * The meta object literal for the '<em><b>Actions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FOR_STATEMENT__ACTIONS = eINSTANCE.getForStatement_Actions();

		/**
		 * The meta object literal for the '<em><b>When</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FOR_STATEMENT__WHEN = eINSTANCE.getForStatement_When();

		/**
		 * The meta object literal for the '{@link edu.ustb.sei.mde.xmu.impl.UpdateImpl <em>Update</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.ustb.sei.mde.xmu.impl.UpdateImpl
		 * @see edu.ustb.sei.mde.xmu.impl.XmuPackageImpl#getUpdate()
		 * @generated
		 */
		EClass UPDATE = eINSTANCE.getUpdate();

		/**
		 * The meta object literal for the '{@link edu.ustb.sei.mde.xmu.impl.DeleteNodeImpl <em>Delete Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.ustb.sei.mde.xmu.impl.DeleteNodeImpl
		 * @see edu.ustb.sei.mde.xmu.impl.XmuPackageImpl#getDeleteNode()
		 * @generated
		 */
		EClass DELETE_NODE = eINSTANCE.getDeleteNode();

		/**
		 * The meta object literal for the '<em><b>Variable</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DELETE_NODE__VARIABLE = eINSTANCE.getDeleteNode_Variable();

		/**
		 * The meta object literal for the '{@link edu.ustb.sei.mde.xmu.impl.DeleteLinkImpl <em>Delete Link</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.ustb.sei.mde.xmu.impl.DeleteLinkImpl
		 * @see edu.ustb.sei.mde.xmu.impl.XmuPackageImpl#getDeleteLink()
		 * @generated
		 */
		EClass DELETE_LINK = eINSTANCE.getDeleteLink();

		/**
		 * The meta object literal for the '<em><b>Source</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DELETE_LINK__SOURCE = eINSTANCE.getDeleteLink_Source();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DELETE_LINK__TARGET = eINSTANCE.getDeleteLink_Target();

		/**
		 * The meta object literal for the '<em><b>Feature</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DELETE_LINK__FEATURE = eINSTANCE.getDeleteLink_Feature();

		/**
		 * The meta object literal for the '{@link edu.ustb.sei.mde.xmu.impl.UpdatePatternImpl <em>Update Pattern</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.ustb.sei.mde.xmu.impl.UpdatePatternImpl
		 * @see edu.ustb.sei.mde.xmu.impl.XmuPackageImpl#getUpdatePattern()
		 * @generated
		 */
		EClass UPDATE_PATTERN = eINSTANCE.getUpdatePattern();

		/**
		 * The meta object literal for the '{@link edu.ustb.sei.mde.xmu.impl.PatternImpl <em>Pattern</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.ustb.sei.mde.xmu.impl.PatternImpl
		 * @see edu.ustb.sei.mde.xmu.impl.XmuPackageImpl#getPattern()
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
		 * The meta object literal for the '{@link edu.ustb.sei.mde.xmu.impl.PatternNodeImpl <em>Pattern Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.ustb.sei.mde.xmu.impl.PatternNodeImpl
		 * @see edu.ustb.sei.mde.xmu.impl.XmuPackageImpl#getPatternNode()
		 * @generated
		 */
		EClass PATTERN_NODE = eINSTANCE.getPatternNode();

		/**
		 * The meta object literal for the '<em><b>Variable</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PATTERN_NODE__VARIABLE = eINSTANCE.getPatternNode_Variable();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PATTERN_NODE__TYPE = eINSTANCE.getPatternNode_Type();

		/**
		 * The meta object literal for the '<em><b>Expr</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PATTERN_NODE__EXPR = eINSTANCE.getPatternNode_Expr();

		/**
		 * The meta object literal for the '{@link edu.ustb.sei.mde.xmu.impl.PatternExprImpl <em>Pattern Expr</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.ustb.sei.mde.xmu.impl.PatternExprImpl
		 * @see edu.ustb.sei.mde.xmu.impl.XmuPackageImpl#getPatternExpr()
		 * @generated
		 */
		EClass PATTERN_EXPR = eINSTANCE.getPatternExpr();

		/**
		 * The meta object literal for the '{@link edu.ustb.sei.mde.xmu.impl.PatternReferenceExprImpl <em>Pattern Reference Expr</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.ustb.sei.mde.xmu.impl.PatternReferenceExprImpl
		 * @see edu.ustb.sei.mde.xmu.impl.XmuPackageImpl#getPatternReferenceExpr()
		 * @generated
		 */
		EClass PATTERN_REFERENCE_EXPR = eINSTANCE.getPatternReferenceExpr();

		/**
		 * The meta object literal for the '<em><b>Reference</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PATTERN_REFERENCE_EXPR__REFERENCE = eINSTANCE.getPatternReferenceExpr_Reference();

		/**
		 * The meta object literal for the '<em><b>Node</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PATTERN_REFERENCE_EXPR__NODE = eINSTANCE.getPatternReferenceExpr_Node();

		/**
		 * The meta object literal for the '<em><b>Pos</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PATTERN_REFERENCE_EXPR__POS = eINSTANCE.getPatternReferenceExpr_Pos();

		/**
		 * The meta object literal for the '{@link edu.ustb.sei.mde.xmu.impl.PatternEqualExprImpl <em>Pattern Equal Expr</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.ustb.sei.mde.xmu.impl.PatternEqualExprImpl
		 * @see edu.ustb.sei.mde.xmu.impl.XmuPackageImpl#getPatternEqualExpr()
		 * @generated
		 */
		EClass PATTERN_EQUAL_EXPR = eINSTANCE.getPatternEqualExpr();

		/**
		 * The meta object literal for the '<em><b>Feature</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PATTERN_EQUAL_EXPR__FEATURE = eINSTANCE.getPatternEqualExpr_Feature();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PATTERN_EQUAL_EXPR__VALUE = eINSTANCE.getPatternEqualExpr_Value();

		/**
		 * The meta object literal for the '<em><b>Pos</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PATTERN_EQUAL_EXPR__POS = eINSTANCE.getPatternEqualExpr_Pos();

		/**
		 * The meta object literal for the '{@link edu.ustb.sei.mde.xmu.impl.ExprImpl <em>Expr</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.ustb.sei.mde.xmu.impl.ExprImpl
		 * @see edu.ustb.sei.mde.xmu.impl.XmuPackageImpl#getExpr()
		 * @generated
		 */
		EClass EXPR = eINSTANCE.getExpr();

		/**
		 * The meta object literal for the '{@link edu.ustb.sei.mde.xmu.impl.VariableExpImpl <em>Variable Exp</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.ustb.sei.mde.xmu.impl.VariableExpImpl
		 * @see edu.ustb.sei.mde.xmu.impl.XmuPackageImpl#getVariableExp()
		 * @generated
		 */
		EClass VARIABLE_EXP = eINSTANCE.getVariableExp();

		/**
		 * The meta object literal for the '<em><b>Var</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VARIABLE_EXP__VAR = eINSTANCE.getVariableExp_Var();

		/**
		 * The meta object literal for the '<em><b>Path</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VARIABLE_EXP__PATH = eINSTANCE.getVariableExp_Path();

		/**
		 * The meta object literal for the '{@link edu.ustb.sei.mde.xmu.impl.ConstantExprImpl <em>Constant Expr</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.ustb.sei.mde.xmu.impl.ConstantExprImpl
		 * @see edu.ustb.sei.mde.xmu.impl.XmuPackageImpl#getConstantExpr()
		 * @generated
		 */
		EClass CONSTANT_EXPR = eINSTANCE.getConstantExpr();

		/**
		 * The meta object literal for the '{@link edu.ustb.sei.mde.xmu.impl.EmptyLiteralImpl <em>Empty Literal</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.ustb.sei.mde.xmu.impl.EmptyLiteralImpl
		 * @see edu.ustb.sei.mde.xmu.impl.XmuPackageImpl#getEmptyLiteral()
		 * @generated
		 */
		EClass EMPTY_LITERAL = eINSTANCE.getEmptyLiteral();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EMPTY_LITERAL__VALUE = eINSTANCE.getEmptyLiteral_Value();

		/**
		 * The meta object literal for the '{@link edu.ustb.sei.mde.xmu.impl.StringLiteralImpl <em>String Literal</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.ustb.sei.mde.xmu.impl.StringLiteralImpl
		 * @see edu.ustb.sei.mde.xmu.impl.XmuPackageImpl#getStringLiteral()
		 * @generated
		 */
		EClass STRING_LITERAL = eINSTANCE.getStringLiteral();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STRING_LITERAL__VALUE = eINSTANCE.getStringLiteral_Value();

		/**
		 * The meta object literal for the '{@link edu.ustb.sei.mde.xmu.impl.IntegerLiteralImpl <em>Integer Literal</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.ustb.sei.mde.xmu.impl.IntegerLiteralImpl
		 * @see edu.ustb.sei.mde.xmu.impl.XmuPackageImpl#getIntegerLiteral()
		 * @generated
		 */
		EClass INTEGER_LITERAL = eINSTANCE.getIntegerLiteral();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INTEGER_LITERAL__VALUE = eINSTANCE.getIntegerLiteral_Value();

		/**
		 * The meta object literal for the '{@link edu.ustb.sei.mde.xmu.impl.BooleanLiteralImpl <em>Boolean Literal</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.ustb.sei.mde.xmu.impl.BooleanLiteralImpl
		 * @see edu.ustb.sei.mde.xmu.impl.XmuPackageImpl#getBooleanLiteral()
		 * @generated
		 */
		EClass BOOLEAN_LITERAL = eINSTANCE.getBooleanLiteral();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BOOLEAN_LITERAL__VALUE = eINSTANCE.getBooleanLiteral_Value();

		/**
		 * The meta object literal for the '{@link edu.ustb.sei.mde.xmu.impl.EnumLiteralImpl <em>Enum Literal</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.ustb.sei.mde.xmu.impl.EnumLiteralImpl
		 * @see edu.ustb.sei.mde.xmu.impl.XmuPackageImpl#getEnumLiteral()
		 * @generated
		 */
		EClass ENUM_LITERAL = eINSTANCE.getEnumLiteral();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ENUM_LITERAL__TYPE = eINSTANCE.getEnumLiteral_Type();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ENUM_LITERAL__VALUE = eINSTANCE.getEnumLiteral_Value();

		/**
		 * The meta object literal for the '{@link edu.ustb.sei.mde.xmu.impl.VStatementImpl <em>VStatement</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.ustb.sei.mde.xmu.impl.VStatementImpl
		 * @see edu.ustb.sei.mde.xmu.impl.XmuPackageImpl#getVStatement()
		 * @generated
		 */
		EClass VSTATEMENT = eINSTANCE.getVStatement();

		/**
		 * The meta object literal for the '<em><b>Tag</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VSTATEMENT__TAG = eINSTANCE.getVStatement_Tag();

		/**
		 * The meta object literal for the '<em><b>Statement</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VSTATEMENT__STATEMENT = eINSTANCE.getVStatement_Statement();

		/**
		 * The meta object literal for the '{@link edu.ustb.sei.mde.xmu.impl.BlockStatementImpl <em>Block Statement</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.ustb.sei.mde.xmu.impl.BlockStatementImpl
		 * @see edu.ustb.sei.mde.xmu.impl.XmuPackageImpl#getBlockStatement()
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
		 * The meta object literal for the '{@link edu.ustb.sei.mde.xmu.impl.SwitchStatementImpl <em>Switch Statement</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.ustb.sei.mde.xmu.impl.SwitchStatementImpl
		 * @see edu.ustb.sei.mde.xmu.impl.XmuPackageImpl#getSwitchStatement()
		 * @generated
		 */
		EClass SWITCH_STATEMENT = eINSTANCE.getSwitchStatement();

		/**
		 * The meta object literal for the '<em><b>Var</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SWITCH_STATEMENT__VAR = eINSTANCE.getSwitchStatement_Var();

		/**
		 * The meta object literal for the '<em><b>Cases</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SWITCH_STATEMENT__CASES = eINSTANCE.getSwitchStatement_Cases();

		/**
		 * The meta object literal for the '<em><b>When</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SWITCH_STATEMENT__WHEN = eINSTANCE.getSwitchStatement_When();

		/**
		 * The meta object literal for the '{@link edu.ustb.sei.mde.xmu.impl.TaggedElementImpl <em>Tagged Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.ustb.sei.mde.xmu.impl.TaggedElementImpl
		 * @see edu.ustb.sei.mde.xmu.impl.XmuPackageImpl#getTaggedElement()
		 * @generated
		 */
		EClass TAGGED_ELEMENT = eINSTANCE.getTaggedElement();

		/**
		 * The meta object literal for the '<em><b>Tag</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TAGGED_ELEMENT__TAG = eINSTANCE.getTaggedElement_Tag();

		/**
		 * The meta object literal for the '{@link edu.ustb.sei.mde.xmu.impl.CaseSubStatementImpl <em>Case Sub Statement</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.ustb.sei.mde.xmu.impl.CaseSubStatementImpl
		 * @see edu.ustb.sei.mde.xmu.impl.XmuPackageImpl#getCaseSubStatement()
		 * @generated
		 */
		EClass CASE_SUB_STATEMENT = eINSTANCE.getCaseSubStatement();

		/**
		 * The meta object literal for the '<em><b>Statement</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CASE_SUB_STATEMENT__STATEMENT = eINSTANCE.getCaseSubStatement_Statement();

		/**
		 * The meta object literal for the '{@link edu.ustb.sei.mde.xmu.impl.CasePatternStatementImpl <em>Case Pattern Statement</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.ustb.sei.mde.xmu.impl.CasePatternStatementImpl
		 * @see edu.ustb.sei.mde.xmu.impl.XmuPackageImpl#getCasePatternStatement()
		 * @generated
		 */
		EClass CASE_PATTERN_STATEMENT = eINSTANCE.getCasePatternStatement();

		/**
		 * The meta object literal for the '<em><b>Pattern</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CASE_PATTERN_STATEMENT__PATTERN = eINSTANCE.getCasePatternStatement_Pattern();

		/**
		 * The meta object literal for the '{@link edu.ustb.sei.mde.xmu.impl.CaseValueStatementImpl <em>Case Value Statement</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.ustb.sei.mde.xmu.impl.CaseValueStatementImpl
		 * @see edu.ustb.sei.mde.xmu.impl.XmuPackageImpl#getCaseValueStatement()
		 * @generated
		 */
		EClass CASE_VALUE_STATEMENT = eINSTANCE.getCaseValueStatement();

		/**
		 * The meta object literal for the '<em><b>Expression</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CASE_VALUE_STATEMENT__EXPRESSION = eINSTANCE.getCaseValueStatement_Expression();

		/**
		 * The meta object literal for the '{@link edu.ustb.sei.mde.xmu.impl.XMUModelImpl <em>XMU Model</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.ustb.sei.mde.xmu.impl.XMUModelImpl
		 * @see edu.ustb.sei.mde.xmu.impl.XmuPackageImpl#getXMUModel()
		 * @generated
		 */
		EClass XMU_MODEL = eINSTANCE.getXMUModel();

		/**
		 * The meta object literal for the '<em><b>Rules</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference XMU_MODEL__RULES = eINSTANCE.getXMUModel_Rules();

		/**
		 * The meta object literal for the '<em><b>Packages</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference XMU_MODEL__PACKAGES = eINSTANCE.getXMUModel_Packages();

		/**
		 * The meta object literal for the '<em><b>Start</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference XMU_MODEL__START = eINSTANCE.getXMUModel_Start();

		/**
		 * The meta object literal for the '{@link edu.ustb.sei.mde.xmu.impl.ParameterImpl <em>Parameter</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.ustb.sei.mde.xmu.impl.ParameterImpl
		 * @see edu.ustb.sei.mde.xmu.impl.XmuPackageImpl#getParameter()
		 * @generated
		 */
		EClass PARAMETER = eINSTANCE.getParameter();

		/**
		 * The meta object literal for the '<em><b>Variable</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PARAMETER__VARIABLE = eINSTANCE.getParameter_Variable();

		/**
		 * The meta object literal for the '{@link edu.ustb.sei.mde.xmu.impl.RuleCallStatementImpl <em>Rule Call Statement</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.ustb.sei.mde.xmu.impl.RuleCallStatementImpl
		 * @see edu.ustb.sei.mde.xmu.impl.XmuPackageImpl#getRuleCallStatement()
		 * @generated
		 */
		EClass RULE_CALL_STATEMENT = eINSTANCE.getRuleCallStatement();

		/**
		 * The meta object literal for the '<em><b>Actual Parameters</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RULE_CALL_STATEMENT__ACTUAL_PARAMETERS = eINSTANCE.getRuleCallStatement_ActualParameters();

		/**
		 * The meta object literal for the '<em><b>Rule</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RULE_CALL_STATEMENT__RULE = eINSTANCE.getRuleCallStatement_Rule();

		/**
		 * The meta object literal for the '{@link edu.ustb.sei.mde.xmu.impl.UpdatedStatementImpl <em>Updated Statement</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.ustb.sei.mde.xmu.impl.UpdatedStatementImpl
		 * @see edu.ustb.sei.mde.xmu.impl.XmuPackageImpl#getUpdatedStatement()
		 * @generated
		 */
		EClass UPDATED_STATEMENT = eINSTANCE.getUpdatedStatement();

		/**
		 * The meta object literal for the '<em><b>SVar</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference UPDATED_STATEMENT__SVAR = eINSTANCE.getUpdatedStatement_SVar();

		/**
		 * The meta object literal for the '<em><b>VVar</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference UPDATED_STATEMENT__VVAR = eINSTANCE.getUpdatedStatement_VVar();

		/**
		 * The meta object literal for the '{@link edu.ustb.sei.mde.xmu.impl.BooleanOrExprImpl <em>Boolean Or Expr</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.ustb.sei.mde.xmu.impl.BooleanOrExprImpl
		 * @see edu.ustb.sei.mde.xmu.impl.XmuPackageImpl#getBooleanOrExpr()
		 * @generated
		 */
		EClass BOOLEAN_OR_EXPR = eINSTANCE.getBooleanOrExpr();

		/**
		 * The meta object literal for the '<em><b>Operands</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BOOLEAN_OR_EXPR__OPERANDS = eINSTANCE.getBooleanOrExpr_Operands();

		/**
		 * The meta object literal for the '{@link edu.ustb.sei.mde.xmu.impl.BooleanOrExprChildImpl <em>Boolean Or Expr Child</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.ustb.sei.mde.xmu.impl.BooleanOrExprChildImpl
		 * @see edu.ustb.sei.mde.xmu.impl.XmuPackageImpl#getBooleanOrExprChild()
		 * @generated
		 */
		EClass BOOLEAN_OR_EXPR_CHILD = eINSTANCE.getBooleanOrExprChild();

		/**
		 * The meta object literal for the '{@link edu.ustb.sei.mde.xmu.impl.BooleanAndExprImpl <em>Boolean And Expr</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.ustb.sei.mde.xmu.impl.BooleanAndExprImpl
		 * @see edu.ustb.sei.mde.xmu.impl.XmuPackageImpl#getBooleanAndExpr()
		 * @generated
		 */
		EClass BOOLEAN_AND_EXPR = eINSTANCE.getBooleanAndExpr();

		/**
		 * The meta object literal for the '<em><b>Operands</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BOOLEAN_AND_EXPR__OPERANDS = eINSTANCE.getBooleanAndExpr_Operands();

		/**
		 * The meta object literal for the '{@link edu.ustb.sei.mde.xmu.impl.BooleanAndExprChildImpl <em>Boolean And Expr Child</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.ustb.sei.mde.xmu.impl.BooleanAndExprChildImpl
		 * @see edu.ustb.sei.mde.xmu.impl.XmuPackageImpl#getBooleanAndExprChild()
		 * @generated
		 */
		EClass BOOLEAN_AND_EXPR_CHILD = eINSTANCE.getBooleanAndExprChild();

		/**
		 * The meta object literal for the '{@link edu.ustb.sei.mde.xmu.impl.RelationalExprImpl <em>Relational Expr</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.ustb.sei.mde.xmu.impl.RelationalExprImpl
		 * @see edu.ustb.sei.mde.xmu.impl.XmuPackageImpl#getRelationalExpr()
		 * @generated
		 */
		EClass RELATIONAL_EXPR = eINSTANCE.getRelationalExpr();

		/**
		 * The meta object literal for the '<em><b>Left</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RELATIONAL_EXPR__LEFT = eINSTANCE.getRelationalExpr_Left();

		/**
		 * The meta object literal for the '<em><b>Right</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RELATIONAL_EXPR__RIGHT = eINSTANCE.getRelationalExpr_Right();

		/**
		 * The meta object literal for the '<em><b>Operator</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RELATIONAL_EXPR__OPERATOR = eINSTANCE.getRelationalExpr_Operator();

		/**
		 * The meta object literal for the '{@link edu.ustb.sei.mde.xmu.impl.RelationalExprChildImpl <em>Relational Expr Child</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.ustb.sei.mde.xmu.impl.RelationalExprChildImpl
		 * @see edu.ustb.sei.mde.xmu.impl.XmuPackageImpl#getRelationalExprChild()
		 * @generated
		 */
		EClass RELATIONAL_EXPR_CHILD = eINSTANCE.getRelationalExprChild();

		/**
		 * The meta object literal for the '{@link edu.ustb.sei.mde.xmu.impl.AdditiveExprImpl <em>Additive Expr</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.ustb.sei.mde.xmu.impl.AdditiveExprImpl
		 * @see edu.ustb.sei.mde.xmu.impl.XmuPackageImpl#getAdditiveExpr()
		 * @generated
		 */
		EClass ADDITIVE_EXPR = eINSTANCE.getAdditiveExpr();

		/**
		 * The meta object literal for the '<em><b>Operands</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ADDITIVE_EXPR__OPERANDS = eINSTANCE.getAdditiveExpr_Operands();

		/**
		 * The meta object literal for the '<em><b>Operators</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ADDITIVE_EXPR__OPERATORS = eINSTANCE.getAdditiveExpr_Operators();

		/**
		 * The meta object literal for the '{@link edu.ustb.sei.mde.xmu.impl.AdditiveExprChildImpl <em>Additive Expr Child</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.ustb.sei.mde.xmu.impl.AdditiveExprChildImpl
		 * @see edu.ustb.sei.mde.xmu.impl.XmuPackageImpl#getAdditiveExprChild()
		 * @generated
		 */
		EClass ADDITIVE_EXPR_CHILD = eINSTANCE.getAdditiveExprChild();

		/**
		 * The meta object literal for the '{@link edu.ustb.sei.mde.xmu.impl.MultiplicativeExprImpl <em>Multiplicative Expr</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.ustb.sei.mde.xmu.impl.MultiplicativeExprImpl
		 * @see edu.ustb.sei.mde.xmu.impl.XmuPackageImpl#getMultiplicativeExpr()
		 * @generated
		 */
		EClass MULTIPLICATIVE_EXPR = eINSTANCE.getMultiplicativeExpr();

		/**
		 * The meta object literal for the '<em><b>Operands</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MULTIPLICATIVE_EXPR__OPERANDS = eINSTANCE.getMultiplicativeExpr_Operands();

		/**
		 * The meta object literal for the '<em><b>Operators</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MULTIPLICATIVE_EXPR__OPERATORS = eINSTANCE.getMultiplicativeExpr_Operators();

		/**
		 * The meta object literal for the '{@link edu.ustb.sei.mde.xmu.impl.MultiplicativeExprChildImpl <em>Multiplicative Expr Child</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.ustb.sei.mde.xmu.impl.MultiplicativeExprChildImpl
		 * @see edu.ustb.sei.mde.xmu.impl.XmuPackageImpl#getMultiplicativeExprChild()
		 * @generated
		 */
		EClass MULTIPLICATIVE_EXPR_CHILD = eINSTANCE.getMultiplicativeExprChild();

		/**
		 * The meta object literal for the '{@link edu.ustb.sei.mde.xmu.impl.UnaryExprImpl <em>Unary Expr</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.ustb.sei.mde.xmu.impl.UnaryExprImpl
		 * @see edu.ustb.sei.mde.xmu.impl.XmuPackageImpl#getUnaryExpr()
		 * @generated
		 */
		EClass UNARY_EXPR = eINSTANCE.getUnaryExpr();

		/**
		 * The meta object literal for the '<em><b>Body</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference UNARY_EXPR__BODY = eINSTANCE.getUnaryExpr_Body();

		/**
		 * The meta object literal for the '<em><b>Operator</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute UNARY_EXPR__OPERATOR = eINSTANCE.getUnaryExpr_Operator();

		/**
		 * The meta object literal for the '{@link edu.ustb.sei.mde.xmu.impl.UnaryExprChildImpl <em>Unary Expr Child</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.ustb.sei.mde.xmu.impl.UnaryExprChildImpl
		 * @see edu.ustb.sei.mde.xmu.impl.XmuPackageImpl#getUnaryExprChild()
		 * @generated
		 */
		EClass UNARY_EXPR_CHILD = eINSTANCE.getUnaryExprChild();

		/**
		 * The meta object literal for the '{@link edu.ustb.sei.mde.xmu.impl.AtomicExprImpl <em>Atomic Expr</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.ustb.sei.mde.xmu.impl.AtomicExprImpl
		 * @see edu.ustb.sei.mde.xmu.impl.XmuPackageImpl#getAtomicExpr()
		 * @generated
		 */
		EClass ATOMIC_EXPR = eINSTANCE.getAtomicExpr();

		/**
		 * The meta object literal for the '{@link edu.ustb.sei.mde.xmu.impl.ParenExprImpl <em>Paren Expr</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.ustb.sei.mde.xmu.impl.ParenExprImpl
		 * @see edu.ustb.sei.mde.xmu.impl.XmuPackageImpl#getParenExpr()
		 * @generated
		 */
		EClass PAREN_EXPR = eINSTANCE.getParenExpr();

		/**
		 * The meta object literal for the '<em><b>Body</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PAREN_EXPR__BODY = eINSTANCE.getParenExpr_Body();

		/**
		 * The meta object literal for the '{@link edu.ustb.sei.mde.xmu.impl.PathImpl <em>Path</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.ustb.sei.mde.xmu.impl.PathImpl
		 * @see edu.ustb.sei.mde.xmu.impl.XmuPackageImpl#getPath()
		 * @generated
		 */
		EClass PATH = eINSTANCE.getPath();

		/**
		 * The meta object literal for the '{@link edu.ustb.sei.mde.xmu.impl.FeaturePathImpl <em>Feature Path</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.ustb.sei.mde.xmu.impl.FeaturePathImpl
		 * @see edu.ustb.sei.mde.xmu.impl.XmuPackageImpl#getFeaturePath()
		 * @generated
		 */
		EClass FEATURE_PATH = eINSTANCE.getFeaturePath();

		/**
		 * The meta object literal for the '<em><b>Feature</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FEATURE_PATH__FEATURE = eINSTANCE.getFeaturePath_Feature();

		/**
		 * The meta object literal for the '{@link edu.ustb.sei.mde.xmu.impl.OperationPathImpl <em>Operation Path</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.ustb.sei.mde.xmu.impl.OperationPathImpl
		 * @see edu.ustb.sei.mde.xmu.impl.XmuPackageImpl#getOperationPath()
		 * @generated
		 */
		EClass OPERATION_PATH = eINSTANCE.getOperationPath();

		/**
		 * The meta object literal for the '<em><b>Operation</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OPERATION_PATH__OPERATION = eINSTANCE.getOperationPath_Operation();

		/**
		 * The meta object literal for the '<em><b>Parameters</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPERATION_PATH__PARAMETERS = eINSTANCE.getOperationPath_Parameters();

		/**
		 * The meta object literal for the '{@link edu.ustb.sei.mde.xmu.impl.LoopPathImpl <em>Loop Path</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.ustb.sei.mde.xmu.impl.LoopPathImpl
		 * @see edu.ustb.sei.mde.xmu.impl.XmuPackageImpl#getLoopPath()
		 * @generated
		 */
		EClass LOOP_PATH = eINSTANCE.getLoopPath();

		/**
		 * The meta object literal for the '<em><b>Operator</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LOOP_PATH__OPERATOR = eINSTANCE.getLoopPath_Operator();

		/**
		 * The meta object literal for the '<em><b>Variable</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LOOP_PATH__VARIABLE = eINSTANCE.getLoopPath_Variable();

		/**
		 * The meta object literal for the '<em><b>Body</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LOOP_PATH__BODY = eINSTANCE.getLoopPath_Body();

		/**
		 * The meta object literal for the '{@link edu.ustb.sei.mde.xmu.impl.StartStatementImpl <em>Start Statement</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.ustb.sei.mde.xmu.impl.StartStatementImpl
		 * @see edu.ustb.sei.mde.xmu.impl.XmuPackageImpl#getStartStatement()
		 * @generated
		 */
		EClass START_STATEMENT = eINSTANCE.getStartStatement();

		/**
		 * The meta object literal for the '<em><b>Rule</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference START_STATEMENT__RULE = eINSTANCE.getStartStatement_Rule();

		/**
		 * The meta object literal for the '<em><b>Root</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference START_STATEMENT__ROOT = eINSTANCE.getStartStatement_Root();

		/**
		 * The meta object literal for the '{@link edu.ustb.sei.mde.xmu.impl.StartRootImpl <em>Start Root</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.ustb.sei.mde.xmu.impl.StartRootImpl
		 * @see edu.ustb.sei.mde.xmu.impl.XmuPackageImpl#getStartRoot()
		 * @generated
		 */
		EClass START_ROOT = eINSTANCE.getStartRoot();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute START_ROOT__ID = eINSTANCE.getStartRoot_Id();

		/**
		 * The meta object literal for the '{@link edu.ustb.sei.mde.xmu.impl.EResourceImpl <em>EResource</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.ustb.sei.mde.xmu.impl.EResourceImpl
		 * @see edu.ustb.sei.mde.xmu.impl.XmuPackageImpl#getEResource()
		 * @generated
		 */
		EClass ERESOURCE = eINSTANCE.getEResource();

		/**
		 * The meta object literal for the '<em><b>Content</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ERESOURCE__CONTENT = eINSTANCE.getEResource_Content();

		/**
		 * The meta object literal for the '{@link edu.ustb.sei.mde.xmu.impl.PrintStatementImpl <em>Print Statement</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.ustb.sei.mde.xmu.impl.PrintStatementImpl
		 * @see edu.ustb.sei.mde.xmu.impl.XmuPackageImpl#getPrintStatement()
		 * @generated
		 */
		EClass PRINT_STATEMENT = eINSTANCE.getPrintStatement();

		/**
		 * The meta object literal for the '<em><b>Expr</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PRINT_STATEMENT__EXPR = eINSTANCE.getPrintStatement_Expr();

		/**
		 * The meta object literal for the '{@link edu.ustb.sei.mde.xmu.impl.AllInstanceExprImpl <em>All Instance Expr</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.ustb.sei.mde.xmu.impl.AllInstanceExprImpl
		 * @see edu.ustb.sei.mde.xmu.impl.XmuPackageImpl#getAllInstanceExpr()
		 * @generated
		 */
		EClass ALL_INSTANCE_EXPR = eINSTANCE.getAllInstanceExpr();

		/**
		 * The meta object literal for the '<em><b>Root</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ALL_INSTANCE_EXPR__ROOT = eINSTANCE.getAllInstanceExpr_Root();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ALL_INSTANCE_EXPR__TYPE = eINSTANCE.getAllInstanceExpr_Type();

		/**
		 * The meta object literal for the '{@link edu.ustb.sei.mde.xmu.impl.ESetImpl <em>ESet</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.ustb.sei.mde.xmu.impl.ESetImpl
		 * @see edu.ustb.sei.mde.xmu.impl.XmuPackageImpl#getESet()
		 * @generated
		 */
		EClass ESET = eINSTANCE.getESet();

		/**
		 * The meta object literal for the '<em><b>Content</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ESET__CONTENT = eINSTANCE.getESet_Content();

		/**
		 * The meta object literal for the '{@link edu.ustb.sei.mde.xmu.VariableFlag <em>Variable Flag</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.ustb.sei.mde.xmu.VariableFlag
		 * @see edu.ustb.sei.mde.xmu.impl.XmuPackageImpl#getVariableFlag()
		 * @generated
		 */
		EEnum VARIABLE_FLAG = eINSTANCE.getVariableFlag();

		/**
		 * The meta object literal for the '{@link edu.ustb.sei.mde.xmu.RelationalOperator <em>Relational Operator</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.ustb.sei.mde.xmu.RelationalOperator
		 * @see edu.ustb.sei.mde.xmu.impl.XmuPackageImpl#getRelationalOperator()
		 * @generated
		 */
		EEnum RELATIONAL_OPERATOR = eINSTANCE.getRelationalOperator();

		/**
		 * The meta object literal for the '{@link edu.ustb.sei.mde.xmu.EmptyType <em>Empty Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.ustb.sei.mde.xmu.EmptyType
		 * @see edu.ustb.sei.mde.xmu.impl.XmuPackageImpl#getEmptyType()
		 * @generated
		 */
		EEnum EMPTY_TYPE = eINSTANCE.getEmptyType();

		/**
		 * The meta object literal for the '{@link edu.ustb.sei.mde.xmu.VStmtType <em>VStmt Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.ustb.sei.mde.xmu.VStmtType
		 * @see edu.ustb.sei.mde.xmu.impl.XmuPackageImpl#getVStmtType()
		 * @generated
		 */
		EEnum VSTMT_TYPE = eINSTANCE.getVStmtType();

		/**
		 * The meta object literal for the '{@link edu.ustb.sei.mde.xmu.AdditiveOperator <em>Additive Operator</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.ustb.sei.mde.xmu.AdditiveOperator
		 * @see edu.ustb.sei.mde.xmu.impl.XmuPackageImpl#getAdditiveOperator()
		 * @generated
		 */
		EEnum ADDITIVE_OPERATOR = eINSTANCE.getAdditiveOperator();

		/**
		 * The meta object literal for the '{@link edu.ustb.sei.mde.xmu.MultiplicativeOperator <em>Multiplicative Operator</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.ustb.sei.mde.xmu.MultiplicativeOperator
		 * @see edu.ustb.sei.mde.xmu.impl.XmuPackageImpl#getMultiplicativeOperator()
		 * @generated
		 */
		EEnum MULTIPLICATIVE_OPERATOR = eINSTANCE.getMultiplicativeOperator();

		/**
		 * The meta object literal for the '{@link edu.ustb.sei.mde.xmu.UnaryOperator <em>Unary Operator</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.ustb.sei.mde.xmu.UnaryOperator
		 * @see edu.ustb.sei.mde.xmu.impl.XmuPackageImpl#getUnaryOperator()
		 * @generated
		 */
		EEnum UNARY_OPERATOR = eINSTANCE.getUnaryOperator();

		/**
		 * The meta object literal for the '{@link edu.ustb.sei.mde.xmu.LoopOperator <em>Loop Operator</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.ustb.sei.mde.xmu.LoopOperator
		 * @see edu.ustb.sei.mde.xmu.impl.XmuPackageImpl#getLoopOperator()
		 * @generated
		 */
		EEnum LOOP_OPERATOR = eINSTANCE.getLoopOperator();

	}

} //XmuPackage
