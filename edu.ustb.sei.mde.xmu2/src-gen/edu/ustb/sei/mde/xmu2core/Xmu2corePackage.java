/**
 */
package edu.ustb.sei.mde.xmu2core;

import edu.ustb.sei.mde.xmu2common.Xmu2commonPackage;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
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
 * @see edu.ustb.sei.mde.xmu2core.Xmu2coreFactory
 * @model kind="package"
 * @generated
 */
public interface Xmu2corePackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "xmu2core";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.ustb.edu.cn/sei/mde/xmu2core";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "xmu2core";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	Xmu2corePackage eINSTANCE = edu.ustb.sei.mde.xmu2core.impl.Xmu2corePackageImpl.init();

	/**
	 * The meta object id for the '{@link edu.ustb.sei.mde.xmu2core.impl.TypedElementImpl <em>Typed Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.ustb.sei.mde.xmu2core.impl.TypedElementImpl
	 * @see edu.ustb.sei.mde.xmu2core.impl.Xmu2corePackageImpl#getTypedElement()
	 * @generated
	 */
	int TYPED_ELEMENT = 0;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_ELEMENT__TYPE = 0;

	/**
	 * The number of structural features of the '<em>Typed Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_ELEMENT_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Typed Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_ELEMENT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link edu.ustb.sei.mde.xmu2core.impl.NullableImpl <em>Nullable</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.ustb.sei.mde.xmu2core.impl.NullableImpl
	 * @see edu.ustb.sei.mde.xmu2core.impl.Xmu2corePackageImpl#getNullable()
	 * @generated
	 */
	int NULLABLE = 1;

	/**
	 * The feature id for the '<em><b>Nullable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NULLABLE__NULLABLE = 0;

	/**
	 * The number of structural features of the '<em>Nullable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NULLABLE_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Nullable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NULLABLE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link edu.ustb.sei.mde.xmu2core.impl.CallableImpl <em>Callable</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.ustb.sei.mde.xmu2core.impl.CallableImpl
	 * @see edu.ustb.sei.mde.xmu2core.impl.Xmu2corePackageImpl#getCallable()
	 * @generated
	 */
	int CALLABLE = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALLABLE__NAME = Xmu2commonPackage.NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Variables</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALLABLE__VARIABLES = Xmu2commonPackage.NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALLABLE__PARAMETERS = Xmu2commonPackage.NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Callable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALLABLE_FEATURE_COUNT = Xmu2commonPackage.NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Callable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALLABLE_OPERATION_COUNT = Xmu2commonPackage.NAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.ustb.sei.mde.xmu2core.impl.ProcedureImpl <em>Procedure</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.ustb.sei.mde.xmu2core.impl.ProcedureImpl
	 * @see edu.ustb.sei.mde.xmu2core.impl.Xmu2corePackageImpl#getProcedure()
	 * @generated
	 */
	int PROCEDURE = 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCEDURE__NAME = CALLABLE__NAME;

	/**
	 * The feature id for the '<em><b>Variables</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCEDURE__VARIABLES = CALLABLE__VARIABLES;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCEDURE__PARAMETERS = CALLABLE__PARAMETERS;

	/**
	 * The feature id for the '<em><b>Backward Statements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCEDURE__BACKWARD_STATEMENTS = CALLABLE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Forward Statements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCEDURE__FORWARD_STATEMENTS = CALLABLE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Procedure</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCEDURE_FEATURE_COUNT = CALLABLE_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Procedure</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCEDURE_OPERATION_COUNT = CALLABLE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.ustb.sei.mde.xmu2core.impl.VariableImpl <em>Variable</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.ustb.sei.mde.xmu2core.impl.VariableImpl
	 * @see edu.ustb.sei.mde.xmu2core.impl.Xmu2corePackageImpl#getVariable()
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
	int VARIABLE__NAME = Xmu2commonPackage.NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE__TYPE = Xmu2commonPackage.NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Tag</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE__TAG = Xmu2commonPackage.NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Variable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_FEATURE_COUNT = Xmu2commonPackage.NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Variable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_OPERATION_COUNT = Xmu2commonPackage.NAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.ustb.sei.mde.xmu2core.impl.StatementImpl <em>Statement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.ustb.sei.mde.xmu2core.impl.StatementImpl
	 * @see edu.ustb.sei.mde.xmu2core.impl.Xmu2corePackageImpl#getStatement()
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
	 * The meta object id for the '{@link edu.ustb.sei.mde.xmu2core.impl.AlignStatementImpl <em>Align Statement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.ustb.sei.mde.xmu2core.impl.AlignStatementImpl
	 * @see edu.ustb.sei.mde.xmu2core.impl.Xmu2corePackageImpl#getAlignStatement()
	 * @generated
	 */
	int ALIGN_STATEMENT = 6;

	/**
	 * The feature id for the '<em><b>Source</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALIGN_STATEMENT__SOURCE = STATEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>View</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALIGN_STATEMENT__VIEW = STATEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Match</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALIGN_STATEMENT__MATCH = STATEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Unmatchv</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALIGN_STATEMENT__UNMATCHV = STATEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Unmatchs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALIGN_STATEMENT__UNMATCHS = STATEMENT_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Align Statement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALIGN_STATEMENT_FEATURE_COUNT = STATEMENT_FEATURE_COUNT + 5;

	/**
	 * The number of operations of the '<em>Align Statement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALIGN_STATEMENT_OPERATION_COUNT = STATEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.ustb.sei.mde.xmu2core.impl.CaseStatementImpl <em>Case Statement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.ustb.sei.mde.xmu2core.impl.CaseStatementImpl
	 * @see edu.ustb.sei.mde.xmu2core.impl.Xmu2corePackageImpl#getCaseStatement()
	 * @generated
	 */
	int CASE_STATEMENT = 7;

	/**
	 * The feature id for the '<em><b>Tag</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CASE_STATEMENT__TAG = STATEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Clauses</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CASE_STATEMENT__CLAUSES = STATEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Case Statement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CASE_STATEMENT_FEATURE_COUNT = STATEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Case Statement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CASE_STATEMENT_OPERATION_COUNT = STATEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.ustb.sei.mde.xmu2core.impl.CaseClauseImpl <em>Case Clause</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.ustb.sei.mde.xmu2core.impl.CaseClauseImpl
	 * @see edu.ustb.sei.mde.xmu2core.impl.Xmu2corePackageImpl#getCaseClause()
	 * @generated
	 */
	int CASE_CLAUSE = 8;

	/**
	 * The feature id for the '<em><b>Action</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CASE_CLAUSE__ACTION = 0;

	/**
	 * The number of structural features of the '<em>Case Clause</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CASE_CLAUSE_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Case Clause</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CASE_CLAUSE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link edu.ustb.sei.mde.xmu2core.impl.CasePatternClauseImpl <em>Case Pattern Clause</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.ustb.sei.mde.xmu2core.impl.CasePatternClauseImpl
	 * @see edu.ustb.sei.mde.xmu2core.impl.Xmu2corePackageImpl#getCasePatternClause()
	 * @generated
	 */
	int CASE_PATTERN_CLAUSE = 9;

	/**
	 * The feature id for the '<em><b>Action</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CASE_PATTERN_CLAUSE__ACTION = CASE_CLAUSE__ACTION;

	/**
	 * The feature id for the '<em><b>Condition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CASE_PATTERN_CLAUSE__CONDITION = CASE_CLAUSE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Case Pattern Clause</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CASE_PATTERN_CLAUSE_FEATURE_COUNT = CASE_CLAUSE_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Case Pattern Clause</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CASE_PATTERN_CLAUSE_OPERATION_COUNT = CASE_CLAUSE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.ustb.sei.mde.xmu2core.impl.CaseExpressionClauseImpl <em>Case Expression Clause</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.ustb.sei.mde.xmu2core.impl.CaseExpressionClauseImpl
	 * @see edu.ustb.sei.mde.xmu2core.impl.Xmu2corePackageImpl#getCaseExpressionClause()
	 * @generated
	 */
	int CASE_EXPRESSION_CLAUSE = 10;

	/**
	 * The feature id for the '<em><b>Action</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CASE_EXPRESSION_CLAUSE__ACTION = CASE_CLAUSE__ACTION;

	/**
	 * The feature id for the '<em><b>Condition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CASE_EXPRESSION_CLAUSE__CONDITION = CASE_CLAUSE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Case Expression Clause</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CASE_EXPRESSION_CLAUSE_FEATURE_COUNT = CASE_CLAUSE_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Case Expression Clause</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CASE_EXPRESSION_CLAUSE_OPERATION_COUNT = CASE_CLAUSE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.ustb.sei.mde.xmu2core.impl.CaseStatementClauseImpl <em>Case Statement Clause</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.ustb.sei.mde.xmu2core.impl.CaseStatementClauseImpl
	 * @see edu.ustb.sei.mde.xmu2core.impl.Xmu2corePackageImpl#getCaseStatementClause()
	 * @generated
	 */
	int CASE_STATEMENT_CLAUSE = 11;

	/**
	 * The feature id for the '<em><b>Action</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CASE_STATEMENT_CLAUSE__ACTION = CASE_CLAUSE__ACTION;

	/**
	 * The feature id for the '<em><b>Condition</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CASE_STATEMENT_CLAUSE__CONDITION = CASE_CLAUSE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Case Statement Clause</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CASE_STATEMENT_CLAUSE_FEATURE_COUNT = CASE_CLAUSE_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Case Statement Clause</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CASE_STATEMENT_CLAUSE_OPERATION_COUNT = CASE_CLAUSE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.ustb.sei.mde.xmu2core.impl.PatternImpl <em>Pattern</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.ustb.sei.mde.xmu2core.impl.PatternImpl
	 * @see edu.ustb.sei.mde.xmu2core.impl.Xmu2corePackageImpl#getPattern()
	 * @generated
	 */
	int PATTERN = 12;

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
	 * The number of operations of the '<em>Pattern</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link edu.ustb.sei.mde.xmu2core.impl.ReflectiveSupportImpl <em>Reflective Support</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.ustb.sei.mde.xmu2core.impl.ReflectiveSupportImpl
	 * @see edu.ustb.sei.mde.xmu2core.impl.Xmu2corePackageImpl#getReflectiveSupport()
	 * @generated
	 */
	int REFLECTIVE_SUPPORT = 55;

	/**
	 * The feature id for the '<em><b>Reflective Identifier</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFLECTIVE_SUPPORT__REFLECTIVE_IDENTIFIER = 0;

	/**
	 * The feature id for the '<em><b>Reflective</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFLECTIVE_SUPPORT__REFLECTIVE = 1;

	/**
	 * The feature id for the '<em><b>Resolve</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFLECTIVE_SUPPORT__RESOLVE = 2;

	/**
	 * The number of structural features of the '<em>Reflective Support</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFLECTIVE_SUPPORT_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Reflective Support</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFLECTIVE_SUPPORT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link edu.ustb.sei.mde.xmu2core.impl.PatternNodeImpl <em>Pattern Node</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.ustb.sei.mde.xmu2core.impl.PatternNodeImpl
	 * @see edu.ustb.sei.mde.xmu2core.impl.Xmu2corePackageImpl#getPatternNode()
	 * @generated
	 */
	int PATTERN_NODE = 13;

	/**
	 * The feature id for the '<em><b>Reflective Identifier</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN_NODE__REFLECTIVE_IDENTIFIER = REFLECTIVE_SUPPORT__REFLECTIVE_IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Reflective</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN_NODE__REFLECTIVE = REFLECTIVE_SUPPORT__REFLECTIVE;

	/**
	 * The feature id for the '<em><b>Resolve</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN_NODE__RESOLVE = REFLECTIVE_SUPPORT__RESOLVE;

	/**
	 * The feature id for the '<em><b>Variable</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN_NODE__VARIABLE = REFLECTIVE_SUPPORT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN_NODE__TYPE = REFLECTIVE_SUPPORT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Expressions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN_NODE__EXPRESSIONS = REFLECTIVE_SUPPORT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Pattern Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN_NODE_FEATURE_COUNT = REFLECTIVE_SUPPORT_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Pattern Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN_NODE_OPERATION_COUNT = REFLECTIVE_SUPPORT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.ustb.sei.mde.xmu2core.impl.PatternExpressionImpl <em>Pattern Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.ustb.sei.mde.xmu2core.impl.PatternExpressionImpl
	 * @see edu.ustb.sei.mde.xmu2core.impl.Xmu2corePackageImpl#getPatternExpression()
	 * @generated
	 */
	int PATTERN_EXPRESSION = 14;

	/**
	 * The feature id for the '<em><b>Nullable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN_EXPRESSION__NULLABLE = NULLABLE__NULLABLE;

	/**
	 * The feature id for the '<em><b>Reflective Identifier</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN_EXPRESSION__REFLECTIVE_IDENTIFIER = NULLABLE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Reflective</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN_EXPRESSION__REFLECTIVE = NULLABLE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Resolve</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN_EXPRESSION__RESOLVE = NULLABLE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Feature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN_EXPRESSION__FEATURE = NULLABLE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Selector</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN_EXPRESSION__SELECTOR = NULLABLE_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Position</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN_EXPRESSION__POSITION = NULLABLE_FEATURE_COUNT + 5;

	/**
	 * The number of structural features of the '<em>Pattern Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN_EXPRESSION_FEATURE_COUNT = NULLABLE_FEATURE_COUNT + 6;

	/**
	 * The number of operations of the '<em>Pattern Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN_EXPRESSION_OPERATION_COUNT = NULLABLE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.ustb.sei.mde.xmu2core.impl.ObjectPatternExpressionImpl <em>Object Pattern Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.ustb.sei.mde.xmu2core.impl.ObjectPatternExpressionImpl
	 * @see edu.ustb.sei.mde.xmu2core.impl.Xmu2corePackageImpl#getObjectPatternExpression()
	 * @generated
	 */
	int OBJECT_PATTERN_EXPRESSION = 15;

	/**
	 * The feature id for the '<em><b>Nullable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_PATTERN_EXPRESSION__NULLABLE = PATTERN_EXPRESSION__NULLABLE;

	/**
	 * The feature id for the '<em><b>Reflective Identifier</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_PATTERN_EXPRESSION__REFLECTIVE_IDENTIFIER = PATTERN_EXPRESSION__REFLECTIVE_IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Reflective</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_PATTERN_EXPRESSION__REFLECTIVE = PATTERN_EXPRESSION__REFLECTIVE;

	/**
	 * The feature id for the '<em><b>Resolve</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_PATTERN_EXPRESSION__RESOLVE = PATTERN_EXPRESSION__RESOLVE;

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
	 * The feature id for the '<em><b>Target</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_PATTERN_EXPRESSION__TARGET = PATTERN_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Object Pattern Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_PATTERN_EXPRESSION_FEATURE_COUNT = PATTERN_EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Object Pattern Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_PATTERN_EXPRESSION_OPERATION_COUNT = PATTERN_EXPRESSION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.ustb.sei.mde.xmu2core.impl.PropertyPatternExpressionImpl <em>Property Pattern Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.ustb.sei.mde.xmu2core.impl.PropertyPatternExpressionImpl
	 * @see edu.ustb.sei.mde.xmu2core.impl.Xmu2corePackageImpl#getPropertyPatternExpression()
	 * @generated
	 */
	int PROPERTY_PATTERN_EXPRESSION = 16;

	/**
	 * The feature id for the '<em><b>Nullable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_PATTERN_EXPRESSION__NULLABLE = PATTERN_EXPRESSION__NULLABLE;

	/**
	 * The feature id for the '<em><b>Reflective Identifier</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_PATTERN_EXPRESSION__REFLECTIVE_IDENTIFIER = PATTERN_EXPRESSION__REFLECTIVE_IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Reflective</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_PATTERN_EXPRESSION__REFLECTIVE = PATTERN_EXPRESSION__REFLECTIVE;

	/**
	 * The feature id for the '<em><b>Resolve</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_PATTERN_EXPRESSION__RESOLVE = PATTERN_EXPRESSION__RESOLVE;

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
	 * The feature id for the '<em><b>Target</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_PATTERN_EXPRESSION__TARGET = PATTERN_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Property Pattern Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_PATTERN_EXPRESSION_FEATURE_COUNT = PATTERN_EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Property Pattern Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_PATTERN_EXPRESSION_OPERATION_COUNT = PATTERN_EXPRESSION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.ustb.sei.mde.xmu2core.impl.ExpressionImpl <em>Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.ustb.sei.mde.xmu2core.impl.ExpressionImpl
	 * @see edu.ustb.sei.mde.xmu2core.impl.Xmu2corePackageImpl#getExpression()
	 * @generated
	 */
	int EXPRESSION = 17;

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
	 * The meta object id for the '{@link edu.ustb.sei.mde.xmu2core.impl.BooleanOrExpressionImpl <em>Boolean Or Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.ustb.sei.mde.xmu2core.impl.BooleanOrExpressionImpl
	 * @see edu.ustb.sei.mde.xmu2core.impl.Xmu2corePackageImpl#getBooleanOrExpression()
	 * @generated
	 */
	int BOOLEAN_OR_EXPRESSION = 18;

	/**
	 * The feature id for the '<em><b>Operands</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_OR_EXPRESSION__OPERANDS = EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Boolean Or Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_OR_EXPRESSION_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Boolean Or Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_OR_EXPRESSION_OPERATION_COUNT = EXPRESSION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.ustb.sei.mde.xmu2core.impl.BooleanAndExpressionImpl <em>Boolean And Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.ustb.sei.mde.xmu2core.impl.BooleanAndExpressionImpl
	 * @see edu.ustb.sei.mde.xmu2core.impl.Xmu2corePackageImpl#getBooleanAndExpression()
	 * @generated
	 */
	int BOOLEAN_AND_EXPRESSION = 19;

	/**
	 * The feature id for the '<em><b>Operands</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_AND_EXPRESSION__OPERANDS = EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Boolean And Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_AND_EXPRESSION_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Boolean And Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_AND_EXPRESSION_OPERATION_COUNT = EXPRESSION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.ustb.sei.mde.xmu2core.impl.RelationalExpressionImpl <em>Relational Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.ustb.sei.mde.xmu2core.impl.RelationalExpressionImpl
	 * @see edu.ustb.sei.mde.xmu2core.impl.Xmu2corePackageImpl#getRelationalExpression()
	 * @generated
	 */
	int RELATIONAL_EXPRESSION = 20;

	/**
	 * The feature id for the '<em><b>Left</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATIONAL_EXPRESSION__LEFT = EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Right</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATIONAL_EXPRESSION__RIGHT = EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Operator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATIONAL_EXPRESSION__OPERATOR = EXPRESSION_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Relational Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATIONAL_EXPRESSION_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Relational Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATIONAL_EXPRESSION_OPERATION_COUNT = EXPRESSION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.ustb.sei.mde.xmu2core.impl.AdditiveExpressionImpl <em>Additive Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.ustb.sei.mde.xmu2core.impl.AdditiveExpressionImpl
	 * @see edu.ustb.sei.mde.xmu2core.impl.Xmu2corePackageImpl#getAdditiveExpression()
	 * @generated
	 */
	int ADDITIVE_EXPRESSION = 21;

	/**
	 * The feature id for the '<em><b>Operands</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADDITIVE_EXPRESSION__OPERANDS = EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Operators</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADDITIVE_EXPRESSION__OPERATORS = EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Additive Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADDITIVE_EXPRESSION_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Additive Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADDITIVE_EXPRESSION_OPERATION_COUNT = EXPRESSION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.ustb.sei.mde.xmu2core.impl.MultiplicativeExpressionImpl <em>Multiplicative Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.ustb.sei.mde.xmu2core.impl.MultiplicativeExpressionImpl
	 * @see edu.ustb.sei.mde.xmu2core.impl.Xmu2corePackageImpl#getMultiplicativeExpression()
	 * @generated
	 */
	int MULTIPLICATIVE_EXPRESSION = 22;

	/**
	 * The feature id for the '<em><b>Operands</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTIPLICATIVE_EXPRESSION__OPERANDS = EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Operators</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTIPLICATIVE_EXPRESSION__OPERATORS = EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Multiplicative Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTIPLICATIVE_EXPRESSION_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Multiplicative Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTIPLICATIVE_EXPRESSION_OPERATION_COUNT = EXPRESSION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.ustb.sei.mde.xmu2core.impl.UnaryExpressionImpl <em>Unary Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.ustb.sei.mde.xmu2core.impl.UnaryExpressionImpl
	 * @see edu.ustb.sei.mde.xmu2core.impl.Xmu2corePackageImpl#getUnaryExpression()
	 * @generated
	 */
	int UNARY_EXPRESSION = 23;

	/**
	 * The feature id for the '<em><b>Body</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNARY_EXPRESSION__BODY = EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Operator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNARY_EXPRESSION__OPERATOR = EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Unary Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNARY_EXPRESSION_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Unary Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNARY_EXPRESSION_OPERATION_COUNT = EXPRESSION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.ustb.sei.mde.xmu2core.impl.AtomicExpressionImpl <em>Atomic Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.ustb.sei.mde.xmu2core.impl.AtomicExpressionImpl
	 * @see edu.ustb.sei.mde.xmu2core.impl.Xmu2corePackageImpl#getAtomicExpression()
	 * @generated
	 */
	int ATOMIC_EXPRESSION = 24;

	/**
	 * The feature id for the '<em><b>Paths</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATOMIC_EXPRESSION__PATHS = EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Atomic Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATOMIC_EXPRESSION_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Atomic Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATOMIC_EXPRESSION_OPERATION_COUNT = EXPRESSION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.ustb.sei.mde.xmu2core.impl.TypeCastExpressionImpl <em>Type Cast Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.ustb.sei.mde.xmu2core.impl.TypeCastExpressionImpl
	 * @see edu.ustb.sei.mde.xmu2core.impl.Xmu2corePackageImpl#getTypeCastExpression()
	 * @generated
	 */
	int TYPE_CAST_EXPRESSION = 25;

	/**
	 * The feature id for the '<em><b>Paths</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_CAST_EXPRESSION__PATHS = ATOMIC_EXPRESSION__PATHS;

	/**
	 * The feature id for the '<em><b>Target Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_CAST_EXPRESSION__TARGET_TYPE = ATOMIC_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Body</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_CAST_EXPRESSION__BODY = ATOMIC_EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Source Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_CAST_EXPRESSION__SOURCE_TYPE = ATOMIC_EXPRESSION_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Type Cast Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_CAST_EXPRESSION_FEATURE_COUNT = ATOMIC_EXPRESSION_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Type Cast Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_CAST_EXPRESSION_OPERATION_COUNT = ATOMIC_EXPRESSION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.ustb.sei.mde.xmu2core.impl.PrimitiveValueExpressionImpl <em>Primitive Value Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.ustb.sei.mde.xmu2core.impl.PrimitiveValueExpressionImpl
	 * @see edu.ustb.sei.mde.xmu2core.impl.Xmu2corePackageImpl#getPrimitiveValueExpression()
	 * @generated
	 */
	int PRIMITIVE_VALUE_EXPRESSION = 26;

	/**
	 * The feature id for the '<em><b>Paths</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_VALUE_EXPRESSION__PATHS = ATOMIC_EXPRESSION__PATHS;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_VALUE_EXPRESSION__TYPE = ATOMIC_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Primitive Value Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_VALUE_EXPRESSION_FEATURE_COUNT = ATOMIC_EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Primitive Value Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_VALUE_EXPRESSION_OPERATION_COUNT = ATOMIC_EXPRESSION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.ustb.sei.mde.xmu2core.impl.StringValueExpressionImpl <em>String Value Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.ustb.sei.mde.xmu2core.impl.StringValueExpressionImpl
	 * @see edu.ustb.sei.mde.xmu2core.impl.Xmu2corePackageImpl#getStringValueExpression()
	 * @generated
	 */
	int STRING_VALUE_EXPRESSION = 27;

	/**
	 * The feature id for the '<em><b>Paths</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_VALUE_EXPRESSION__PATHS = PRIMITIVE_VALUE_EXPRESSION__PATHS;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_VALUE_EXPRESSION__TYPE = PRIMITIVE_VALUE_EXPRESSION__TYPE;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_VALUE_EXPRESSION__VALUE = PRIMITIVE_VALUE_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>String Value Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_VALUE_EXPRESSION_FEATURE_COUNT = PRIMITIVE_VALUE_EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>String Value Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_VALUE_EXPRESSION_OPERATION_COUNT = PRIMITIVE_VALUE_EXPRESSION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.ustb.sei.mde.xmu2core.impl.BooleanValueExpressionImpl <em>Boolean Value Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.ustb.sei.mde.xmu2core.impl.BooleanValueExpressionImpl
	 * @see edu.ustb.sei.mde.xmu2core.impl.Xmu2corePackageImpl#getBooleanValueExpression()
	 * @generated
	 */
	int BOOLEAN_VALUE_EXPRESSION = 28;

	/**
	 * The feature id for the '<em><b>Paths</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_VALUE_EXPRESSION__PATHS = PRIMITIVE_VALUE_EXPRESSION__PATHS;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_VALUE_EXPRESSION__TYPE = PRIMITIVE_VALUE_EXPRESSION__TYPE;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_VALUE_EXPRESSION__VALUE = PRIMITIVE_VALUE_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Boolean Value Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_VALUE_EXPRESSION_FEATURE_COUNT = PRIMITIVE_VALUE_EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Boolean Value Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_VALUE_EXPRESSION_OPERATION_COUNT = PRIMITIVE_VALUE_EXPRESSION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.ustb.sei.mde.xmu2core.impl.IntegerValueExpressionImpl <em>Integer Value Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.ustb.sei.mde.xmu2core.impl.IntegerValueExpressionImpl
	 * @see edu.ustb.sei.mde.xmu2core.impl.Xmu2corePackageImpl#getIntegerValueExpression()
	 * @generated
	 */
	int INTEGER_VALUE_EXPRESSION = 29;

	/**
	 * The feature id for the '<em><b>Paths</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_VALUE_EXPRESSION__PATHS = PRIMITIVE_VALUE_EXPRESSION__PATHS;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_VALUE_EXPRESSION__TYPE = PRIMITIVE_VALUE_EXPRESSION__TYPE;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_VALUE_EXPRESSION__VALUE = PRIMITIVE_VALUE_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Integer Value Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_VALUE_EXPRESSION_FEATURE_COUNT = PRIMITIVE_VALUE_EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Integer Value Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_VALUE_EXPRESSION_OPERATION_COUNT = PRIMITIVE_VALUE_EXPRESSION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.ustb.sei.mde.xmu2core.impl.EnumValueExpressionImpl <em>Enum Value Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.ustb.sei.mde.xmu2core.impl.EnumValueExpressionImpl
	 * @see edu.ustb.sei.mde.xmu2core.impl.Xmu2corePackageImpl#getEnumValueExpression()
	 * @generated
	 */
	int ENUM_VALUE_EXPRESSION = 30;

	/**
	 * The feature id for the '<em><b>Paths</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUM_VALUE_EXPRESSION__PATHS = PRIMITIVE_VALUE_EXPRESSION__PATHS;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUM_VALUE_EXPRESSION__TYPE = PRIMITIVE_VALUE_EXPRESSION__TYPE;

	/**
	 * The feature id for the '<em><b>Value</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUM_VALUE_EXPRESSION__VALUE = PRIMITIVE_VALUE_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Enum Value Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUM_VALUE_EXPRESSION_FEATURE_COUNT = PRIMITIVE_VALUE_EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Enum Value Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUM_VALUE_EXPRESSION_OPERATION_COUNT = PRIMITIVE_VALUE_EXPRESSION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.ustb.sei.mde.xmu2core.impl.EmptyValueExpressionImpl <em>Empty Value Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.ustb.sei.mde.xmu2core.impl.EmptyValueExpressionImpl
	 * @see edu.ustb.sei.mde.xmu2core.impl.Xmu2corePackageImpl#getEmptyValueExpression()
	 * @generated
	 */
	int EMPTY_VALUE_EXPRESSION = 31;

	/**
	 * The feature id for the '<em><b>Paths</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMPTY_VALUE_EXPRESSION__PATHS = PRIMITIVE_VALUE_EXPRESSION__PATHS;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMPTY_VALUE_EXPRESSION__TYPE = PRIMITIVE_VALUE_EXPRESSION__TYPE;

	/**
	 * The number of structural features of the '<em>Empty Value Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMPTY_VALUE_EXPRESSION_FEATURE_COUNT = PRIMITIVE_VALUE_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Empty Value Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMPTY_VALUE_EXPRESSION_OPERATION_COUNT = PRIMITIVE_VALUE_EXPRESSION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.ustb.sei.mde.xmu2core.impl.ObjectValueExpressionImpl <em>Object Value Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.ustb.sei.mde.xmu2core.impl.ObjectValueExpressionImpl
	 * @see edu.ustb.sei.mde.xmu2core.impl.Xmu2corePackageImpl#getObjectValueExpression()
	 * @generated
	 */
	int OBJECT_VALUE_EXPRESSION = 32;

	/**
	 * The feature id for the '<em><b>Paths</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_VALUE_EXPRESSION__PATHS = ATOMIC_EXPRESSION__PATHS;

	/**
	 * The feature id for the '<em><b>Value</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_VALUE_EXPRESSION__VALUE = ATOMIC_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Object Value Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_VALUE_EXPRESSION_FEATURE_COUNT = ATOMIC_EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Object Value Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_VALUE_EXPRESSION_OPERATION_COUNT = ATOMIC_EXPRESSION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.ustb.sei.mde.xmu2core.impl.VariableExpressionImpl <em>Variable Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.ustb.sei.mde.xmu2core.impl.VariableExpressionImpl
	 * @see edu.ustb.sei.mde.xmu2core.impl.Xmu2corePackageImpl#getVariableExpression()
	 * @generated
	 */
	int VARIABLE_EXPRESSION = 33;

	/**
	 * The feature id for the '<em><b>Paths</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_EXPRESSION__PATHS = ATOMIC_EXPRESSION__PATHS;

	/**
	 * The feature id for the '<em><b>Variable</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_EXPRESSION__VARIABLE = ATOMIC_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Variable Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_EXPRESSION_FEATURE_COUNT = ATOMIC_EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Variable Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_EXPRESSION_OPERATION_COUNT = ATOMIC_EXPRESSION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.ustb.sei.mde.xmu2core.impl.PathImpl <em>Path</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.ustb.sei.mde.xmu2core.impl.PathImpl
	 * @see edu.ustb.sei.mde.xmu2core.impl.Xmu2corePackageImpl#getPath()
	 * @generated
	 */
	int PATH = 34;

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
	 * The meta object id for the '{@link edu.ustb.sei.mde.xmu2core.impl.FeaturePathImpl <em>Feature Path</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.ustb.sei.mde.xmu2core.impl.FeaturePathImpl
	 * @see edu.ustb.sei.mde.xmu2core.impl.Xmu2corePackageImpl#getFeaturePath()
	 * @generated
	 */
	int FEATURE_PATH = 35;

	/**
	 * The feature id for the '<em><b>Reflective Identifier</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_PATH__REFLECTIVE_IDENTIFIER = PATH_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Reflective</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_PATH__REFLECTIVE = PATH_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Resolve</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_PATH__RESOLVE = PATH_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Feature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_PATH__FEATURE = PATH_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Feature Path</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_PATH_FEATURE_COUNT = PATH_FEATURE_COUNT + 4;

	/**
	 * The number of operations of the '<em>Feature Path</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_PATH_OPERATION_COUNT = PATH_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.ustb.sei.mde.xmu2core.impl.OperationPathImpl <em>Operation Path</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.ustb.sei.mde.xmu2core.impl.OperationPathImpl
	 * @see edu.ustb.sei.mde.xmu2core.impl.Xmu2corePackageImpl#getOperationPath()
	 * @generated
	 */
	int OPERATION_PATH = 36;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_PATH__PARAMETERS = PATH_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Operation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_PATH__OPERATION = PATH_FEATURE_COUNT + 1;

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
	 * The meta object id for the '{@link edu.ustb.sei.mde.xmu2core.impl.LoopPathImpl <em>Loop Path</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.ustb.sei.mde.xmu2core.impl.LoopPathImpl
	 * @see edu.ustb.sei.mde.xmu2core.impl.Xmu2corePackageImpl#getLoopPath()
	 * @generated
	 */
	int LOOP_PATH = 37;

	/**
	 * The feature id for the '<em><b>Operator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOP_PATH__OPERATOR = PATH_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Iterator</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOP_PATH__ITERATOR = PATH_FEATURE_COUNT + 1;

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
	 * The meta object id for the '{@link edu.ustb.sei.mde.xmu2core.impl.PositionPathImpl <em>Position Path</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.ustb.sei.mde.xmu2core.impl.PositionPathImpl
	 * @see edu.ustb.sei.mde.xmu2core.impl.Xmu2corePackageImpl#getPositionPath()
	 * @generated
	 */
	int POSITION_PATH = 38;

	/**
	 * The feature id for the '<em><b>Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POSITION_PATH__VALUE = PATH_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Operator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POSITION_PATH__OPERATOR = PATH_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Position Path</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POSITION_PATH_FEATURE_COUNT = PATH_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Position Path</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POSITION_PATH_OPERATION_COUNT = PATH_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.ustb.sei.mde.xmu2core.impl.CallStatementImpl <em>Call Statement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.ustb.sei.mde.xmu2core.impl.CallStatementImpl
	 * @see edu.ustb.sei.mde.xmu2core.impl.Xmu2corePackageImpl#getCallStatement()
	 * @generated
	 */
	int CALL_STATEMENT = 39;

	/**
	 * The feature id for the '<em><b>Callable</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALL_STATEMENT__CALLABLE = STATEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALL_STATEMENT__PARAMETERS = STATEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Updated Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALL_STATEMENT__UPDATED_PARAMETERS = STATEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Call Statement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALL_STATEMENT_FEATURE_COUNT = STATEMENT_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Call Statement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALL_STATEMENT_OPERATION_COUNT = STATEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.ustb.sei.mde.xmu2core.impl.TransformationImpl <em>Transformation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.ustb.sei.mde.xmu2core.impl.TransformationImpl
	 * @see edu.ustb.sei.mde.xmu2core.impl.Xmu2corePackageImpl#getTransformation()
	 * @generated
	 */
	int TRANSFORMATION = 40;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMATION__NAME = Xmu2commonPackage.NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Callables</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMATION__CALLABLES = Xmu2commonPackage.NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Declared Types</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMATION__DECLARED_TYPES = Xmu2commonPackage.NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Entry Rules</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMATION__ENTRY_RULES = Xmu2commonPackage.NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Packages</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMATION__PACKAGES = Xmu2commonPackage.NAMED_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Transformation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMATION_FEATURE_COUNT = Xmu2commonPackage.NAMED_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The number of operations of the '<em>Transformation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMATION_OPERATION_COUNT = Xmu2commonPackage.NAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.ustb.sei.mde.xmu2core.impl.EntryRuleParameterImpl <em>Entry Rule Parameter</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.ustb.sei.mde.xmu2core.impl.EntryRuleParameterImpl
	 * @see edu.ustb.sei.mde.xmu2core.impl.Xmu2corePackageImpl#getEntryRuleParameter()
	 * @generated
	 */
	int ENTRY_RULE_PARAMETER = 41;

	/**
	 * The feature id for the '<em><b>Tag</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTRY_RULE_PARAMETER__TAG = EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Index</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTRY_RULE_PARAMETER__INDEX = EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Fragment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTRY_RULE_PARAMETER__FRAGMENT = EXPRESSION_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Entry Rule Parameter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTRY_RULE_PARAMETER_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Entry Rule Parameter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTRY_RULE_PARAMETER_OPERATION_COUNT = EXPRESSION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.ustb.sei.mde.xmu2core.impl.ForEachStatementImpl <em>For Each Statement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.ustb.sei.mde.xmu2core.impl.ForEachStatementImpl
	 * @see edu.ustb.sei.mde.xmu2core.impl.Xmu2corePackageImpl#getForEachStatement()
	 * @generated
	 */
	int FOR_EACH_STATEMENT = 42;

	/**
	 * The feature id for the '<em><b>Pattern</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOR_EACH_STATEMENT__PATTERN = STATEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Action</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOR_EACH_STATEMENT__ACTION = STATEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Derived</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOR_EACH_STATEMENT__DERIVED = STATEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>For Each Statement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOR_EACH_STATEMENT_FEATURE_COUNT = STATEMENT_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>For Each Statement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOR_EACH_STATEMENT_OPERATION_COUNT = STATEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.ustb.sei.mde.xmu2core.impl.DeleteNodeStatementImpl <em>Delete Node Statement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.ustb.sei.mde.xmu2core.impl.DeleteNodeStatementImpl
	 * @see edu.ustb.sei.mde.xmu2core.impl.Xmu2corePackageImpl#getDeleteNodeStatement()
	 * @generated
	 */
	int DELETE_NODE_STATEMENT = 43;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DELETE_NODE_STATEMENT__TARGET = STATEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Delete Node Statement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DELETE_NODE_STATEMENT_FEATURE_COUNT = STATEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Delete Node Statement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DELETE_NODE_STATEMENT_OPERATION_COUNT = STATEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.ustb.sei.mde.xmu2core.impl.DeleteLinkStatementImpl <em>Delete Link Statement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.ustb.sei.mde.xmu2core.impl.DeleteLinkStatementImpl
	 * @see edu.ustb.sei.mde.xmu2core.impl.Xmu2corePackageImpl#getDeleteLinkStatement()
	 * @generated
	 */
	int DELETE_LINK_STATEMENT = 44;

	/**
	 * The feature id for the '<em><b>Reflective Identifier</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DELETE_LINK_STATEMENT__REFLECTIVE_IDENTIFIER = STATEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Reflective</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DELETE_LINK_STATEMENT__REFLECTIVE = STATEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Resolve</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DELETE_LINK_STATEMENT__RESOLVE = STATEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Target</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DELETE_LINK_STATEMENT__TARGET = STATEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DELETE_LINK_STATEMENT__SOURCE = STATEMENT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Feature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DELETE_LINK_STATEMENT__FEATURE = STATEMENT_FEATURE_COUNT + 5;

	/**
	 * The number of structural features of the '<em>Delete Link Statement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DELETE_LINK_STATEMENT_FEATURE_COUNT = STATEMENT_FEATURE_COUNT + 6;

	/**
	 * The number of operations of the '<em>Delete Link Statement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DELETE_LINK_STATEMENT_OPERATION_COUNT = STATEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.ustb.sei.mde.xmu2core.impl.EnforceNodeStatementImpl <em>Enforce Node Statement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.ustb.sei.mde.xmu2core.impl.EnforceNodeStatementImpl
	 * @see edu.ustb.sei.mde.xmu2core.impl.Xmu2corePackageImpl#getEnforceNodeStatement()
	 * @generated
	 */
	int ENFORCE_NODE_STATEMENT = 45;

	/**
	 * The feature id for the '<em><b>Tag</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENFORCE_NODE_STATEMENT__TAG = STATEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Nullable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENFORCE_NODE_STATEMENT__NULLABLE = STATEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Reflective Identifier</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENFORCE_NODE_STATEMENT__REFLECTIVE_IDENTIFIER = STATEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Reflective</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENFORCE_NODE_STATEMENT__REFLECTIVE = STATEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Resolve</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENFORCE_NODE_STATEMENT__RESOLVE = STATEMENT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Node</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENFORCE_NODE_STATEMENT__NODE = STATEMENT_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENFORCE_NODE_STATEMENT__TYPE = STATEMENT_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Candidate</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENFORCE_NODE_STATEMENT__CANDIDATE = STATEMENT_FEATURE_COUNT + 7;

	/**
	 * The number of structural features of the '<em>Enforce Node Statement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENFORCE_NODE_STATEMENT_FEATURE_COUNT = STATEMENT_FEATURE_COUNT + 8;

	/**
	 * The number of operations of the '<em>Enforce Node Statement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENFORCE_NODE_STATEMENT_OPERATION_COUNT = STATEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.ustb.sei.mde.xmu2core.impl.EnforceLinkStatementImpl <em>Enforce Link Statement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.ustb.sei.mde.xmu2core.impl.EnforceLinkStatementImpl
	 * @see edu.ustb.sei.mde.xmu2core.impl.Xmu2corePackageImpl#getEnforceLinkStatement()
	 * @generated
	 */
	int ENFORCE_LINK_STATEMENT = 46;

	/**
	 * The feature id for the '<em><b>Tag</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENFORCE_LINK_STATEMENT__TAG = STATEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Reflective Identifier</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENFORCE_LINK_STATEMENT__REFLECTIVE_IDENTIFIER = STATEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Reflective</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENFORCE_LINK_STATEMENT__REFLECTIVE = STATEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Resolve</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENFORCE_LINK_STATEMENT__RESOLVE = STATEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Target</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENFORCE_LINK_STATEMENT__TARGET = STATEMENT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENFORCE_LINK_STATEMENT__SOURCE = STATEMENT_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Feature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENFORCE_LINK_STATEMENT__FEATURE = STATEMENT_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Selector</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENFORCE_LINK_STATEMENT__SELECTOR = STATEMENT_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Position</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENFORCE_LINK_STATEMENT__POSITION = STATEMENT_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>Source Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENFORCE_LINK_STATEMENT__SOURCE_TYPE = STATEMENT_FEATURE_COUNT + 9;

	/**
	 * The number of structural features of the '<em>Enforce Link Statement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENFORCE_LINK_STATEMENT_FEATURE_COUNT = STATEMENT_FEATURE_COUNT + 10;

	/**
	 * The number of operations of the '<em>Enforce Link Statement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENFORCE_LINK_STATEMENT_OPERATION_COUNT = STATEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.ustb.sei.mde.xmu2core.impl.OclCollectionTypeImpl <em>Ocl Collection Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.ustb.sei.mde.xmu2core.impl.OclCollectionTypeImpl
	 * @see edu.ustb.sei.mde.xmu2core.impl.Xmu2corePackageImpl#getOclCollectionType()
	 * @generated
	 */
	int OCL_COLLECTION_TYPE = 47;

	/**
	 * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OCL_COLLECTION_TYPE__EANNOTATIONS = EcorePackage.ECLASS__EANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OCL_COLLECTION_TYPE__NAME = EcorePackage.ECLASS__NAME;

	/**
	 * The feature id for the '<em><b>Instance Class Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OCL_COLLECTION_TYPE__INSTANCE_CLASS_NAME = EcorePackage.ECLASS__INSTANCE_CLASS_NAME;

	/**
	 * The feature id for the '<em><b>Instance Class</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OCL_COLLECTION_TYPE__INSTANCE_CLASS = EcorePackage.ECLASS__INSTANCE_CLASS;

	/**
	 * The feature id for the '<em><b>Default Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OCL_COLLECTION_TYPE__DEFAULT_VALUE = EcorePackage.ECLASS__DEFAULT_VALUE;

	/**
	 * The feature id for the '<em><b>Instance Type Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OCL_COLLECTION_TYPE__INSTANCE_TYPE_NAME = EcorePackage.ECLASS__INSTANCE_TYPE_NAME;

	/**
	 * The feature id for the '<em><b>EPackage</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OCL_COLLECTION_TYPE__EPACKAGE = EcorePackage.ECLASS__EPACKAGE;

	/**
	 * The feature id for the '<em><b>EType Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OCL_COLLECTION_TYPE__ETYPE_PARAMETERS = EcorePackage.ECLASS__ETYPE_PARAMETERS;

	/**
	 * The feature id for the '<em><b>Abstract</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OCL_COLLECTION_TYPE__ABSTRACT = EcorePackage.ECLASS__ABSTRACT;

	/**
	 * The feature id for the '<em><b>Interface</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OCL_COLLECTION_TYPE__INTERFACE = EcorePackage.ECLASS__INTERFACE;

	/**
	 * The feature id for the '<em><b>ESuper Types</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OCL_COLLECTION_TYPE__ESUPER_TYPES = EcorePackage.ECLASS__ESUPER_TYPES;

	/**
	 * The feature id for the '<em><b>EOperations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OCL_COLLECTION_TYPE__EOPERATIONS = EcorePackage.ECLASS__EOPERATIONS;

	/**
	 * The feature id for the '<em><b>EAll Attributes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OCL_COLLECTION_TYPE__EALL_ATTRIBUTES = EcorePackage.ECLASS__EALL_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>EAll References</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OCL_COLLECTION_TYPE__EALL_REFERENCES = EcorePackage.ECLASS__EALL_REFERENCES;

	/**
	 * The feature id for the '<em><b>EReferences</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OCL_COLLECTION_TYPE__EREFERENCES = EcorePackage.ECLASS__EREFERENCES;

	/**
	 * The feature id for the '<em><b>EAttributes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OCL_COLLECTION_TYPE__EATTRIBUTES = EcorePackage.ECLASS__EATTRIBUTES;

	/**
	 * The feature id for the '<em><b>EAll Containments</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OCL_COLLECTION_TYPE__EALL_CONTAINMENTS = EcorePackage.ECLASS__EALL_CONTAINMENTS;

	/**
	 * The feature id for the '<em><b>EAll Operations</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OCL_COLLECTION_TYPE__EALL_OPERATIONS = EcorePackage.ECLASS__EALL_OPERATIONS;

	/**
	 * The feature id for the '<em><b>EAll Structural Features</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OCL_COLLECTION_TYPE__EALL_STRUCTURAL_FEATURES = EcorePackage.ECLASS__EALL_STRUCTURAL_FEATURES;

	/**
	 * The feature id for the '<em><b>EAll Super Types</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OCL_COLLECTION_TYPE__EALL_SUPER_TYPES = EcorePackage.ECLASS__EALL_SUPER_TYPES;

	/**
	 * The feature id for the '<em><b>EID Attribute</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OCL_COLLECTION_TYPE__EID_ATTRIBUTE = EcorePackage.ECLASS__EID_ATTRIBUTE;

	/**
	 * The feature id for the '<em><b>EStructural Features</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OCL_COLLECTION_TYPE__ESTRUCTURAL_FEATURES = EcorePackage.ECLASS__ESTRUCTURAL_FEATURES;

	/**
	 * The feature id for the '<em><b>EGeneric Super Types</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OCL_COLLECTION_TYPE__EGENERIC_SUPER_TYPES = EcorePackage.ECLASS__EGENERIC_SUPER_TYPES;

	/**
	 * The feature id for the '<em><b>EAll Generic Super Types</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OCL_COLLECTION_TYPE__EALL_GENERIC_SUPER_TYPES = EcorePackage.ECLASS__EALL_GENERIC_SUPER_TYPES;

	/**
	 * The feature id for the '<em><b>Elementtype</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OCL_COLLECTION_TYPE__ELEMENTTYPE = EcorePackage.ECLASS_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Ocl Collection Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OCL_COLLECTION_TYPE_FEATURE_COUNT = EcorePackage.ECLASS_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Get EAnnotation</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OCL_COLLECTION_TYPE___GET_EANNOTATION__STRING = EcorePackage.ECLASS___GET_EANNOTATION__STRING;

	/**
	 * The operation id for the '<em>Is Instance</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OCL_COLLECTION_TYPE___IS_INSTANCE__OBJECT = EcorePackage.ECLASS___IS_INSTANCE__OBJECT;

	/**
	 * The operation id for the '<em>Get Classifier ID</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OCL_COLLECTION_TYPE___GET_CLASSIFIER_ID = EcorePackage.ECLASS___GET_CLASSIFIER_ID;

	/**
	 * The operation id for the '<em>Is Super Type Of</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OCL_COLLECTION_TYPE___IS_SUPER_TYPE_OF__ECLASS = EcorePackage.ECLASS___IS_SUPER_TYPE_OF__ECLASS;

	/**
	 * The operation id for the '<em>Get Feature Count</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OCL_COLLECTION_TYPE___GET_FEATURE_COUNT = EcorePackage.ECLASS___GET_FEATURE_COUNT;

	/**
	 * The operation id for the '<em>Get EStructural Feature</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OCL_COLLECTION_TYPE___GET_ESTRUCTURAL_FEATURE__INT = EcorePackage.ECLASS___GET_ESTRUCTURAL_FEATURE__INT;

	/**
	 * The operation id for the '<em>Get Feature ID</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OCL_COLLECTION_TYPE___GET_FEATURE_ID__ESTRUCTURALFEATURE = EcorePackage.ECLASS___GET_FEATURE_ID__ESTRUCTURALFEATURE;

	/**
	 * The operation id for the '<em>Get EStructural Feature</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OCL_COLLECTION_TYPE___GET_ESTRUCTURAL_FEATURE__STRING = EcorePackage.ECLASS___GET_ESTRUCTURAL_FEATURE__STRING;

	/**
	 * The operation id for the '<em>Get Operation Count</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OCL_COLLECTION_TYPE___GET_OPERATION_COUNT = EcorePackage.ECLASS___GET_OPERATION_COUNT;

	/**
	 * The operation id for the '<em>Get EOperation</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OCL_COLLECTION_TYPE___GET_EOPERATION__INT = EcorePackage.ECLASS___GET_EOPERATION__INT;

	/**
	 * The operation id for the '<em>Get Operation ID</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OCL_COLLECTION_TYPE___GET_OPERATION_ID__EOPERATION = EcorePackage.ECLASS___GET_OPERATION_ID__EOPERATION;

	/**
	 * The operation id for the '<em>Get Override</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OCL_COLLECTION_TYPE___GET_OVERRIDE__EOPERATION = EcorePackage.ECLASS___GET_OVERRIDE__EOPERATION;

	/**
	 * The operation id for the '<em>Get Feature Type</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OCL_COLLECTION_TYPE___GET_FEATURE_TYPE__ESTRUCTURALFEATURE = EcorePackage.ECLASS___GET_FEATURE_TYPE__ESTRUCTURALFEATURE;

	/**
	 * The number of operations of the '<em>Ocl Collection Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OCL_COLLECTION_TYPE_OPERATION_COUNT = EcorePackage.ECLASS_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.ustb.sei.mde.xmu2core.impl.OclCollectionImpl <em>Ocl Collection</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.ustb.sei.mde.xmu2core.impl.OclCollectionImpl
	 * @see edu.ustb.sei.mde.xmu2core.impl.Xmu2corePackageImpl#getOclCollection()
	 * @generated
	 */
	int OCL_COLLECTION = 48;

	/**
	 * The feature id for the '<em><b>Element Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OCL_COLLECTION__ELEMENT_TYPE = 0;

	/**
	 * The number of structural features of the '<em>Ocl Collection</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OCL_COLLECTION_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Ocl Collection</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OCL_COLLECTION_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link edu.ustb.sei.mde.xmu2core.impl.MatchPatternImpl <em>Match Pattern</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.ustb.sei.mde.xmu2core.impl.MatchPatternImpl
	 * @see edu.ustb.sei.mde.xmu2core.impl.Xmu2corePackageImpl#getMatchPattern()
	 * @generated
	 */
	int MATCH_PATTERN = 49;

	/**
	 * The feature id for the '<em><b>Pattern</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MATCH_PATTERN__PATTERN = STATEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Match Pattern</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MATCH_PATTERN_FEATURE_COUNT = STATEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Match Pattern</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MATCH_PATTERN_OPERATION_COUNT = STATEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.ustb.sei.mde.xmu2core.impl.CheckExpressionStatementImpl <em>Check Expression Statement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.ustb.sei.mde.xmu2core.impl.CheckExpressionStatementImpl
	 * @see edu.ustb.sei.mde.xmu2core.impl.Xmu2corePackageImpl#getCheckExpressionStatement()
	 * @generated
	 */
	int CHECK_EXPRESSION_STATEMENT = 50;

	/**
	 * The feature id for the '<em><b>Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHECK_EXPRESSION_STATEMENT__EXPRESSION = STATEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Check Expression Statement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHECK_EXPRESSION_STATEMENT_FEATURE_COUNT = STATEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Check Expression Statement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHECK_EXPRESSION_STATEMENT_OPERATION_COUNT = STATEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.ustb.sei.mde.xmu2core.impl.EnforceExpressionStatementImpl <em>Enforce Expression Statement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.ustb.sei.mde.xmu2core.impl.EnforceExpressionStatementImpl
	 * @see edu.ustb.sei.mde.xmu2core.impl.Xmu2corePackageImpl#getEnforceExpressionStatement()
	 * @generated
	 */
	int ENFORCE_EXPRESSION_STATEMENT = 51;

	/**
	 * The feature id for the '<em><b>Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENFORCE_EXPRESSION_STATEMENT__EXPRESSION = STATEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Enforce Expression Statement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENFORCE_EXPRESSION_STATEMENT_FEATURE_COUNT = STATEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Enforce Expression Statement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENFORCE_EXPRESSION_STATEMENT_OPERATION_COUNT = STATEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.ustb.sei.mde.xmu2core.impl.FunctionImpl <em>Function</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.ustb.sei.mde.xmu2core.impl.FunctionImpl
	 * @see edu.ustb.sei.mde.xmu2core.impl.Xmu2corePackageImpl#getFunction()
	 * @generated
	 */
	int FUNCTION = 52;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION__NAME = CALLABLE__NAME;

	/**
	 * The feature id for the '<em><b>Variables</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION__VARIABLES = CALLABLE__VARIABLES;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION__PARAMETERS = CALLABLE__PARAMETERS;

	/**
	 * The feature id for the '<em><b>Backward Statements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION__BACKWARD_STATEMENTS = CALLABLE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Forward Statements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION__FORWARD_STATEMENTS = CALLABLE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Function</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION_FEATURE_COUNT = CALLABLE_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Function</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION_OPERATION_COUNT = CALLABLE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.ustb.sei.mde.xmu2core.impl.SolveConstraintStatementImpl <em>Solve Constraint Statement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.ustb.sei.mde.xmu2core.impl.SolveConstraintStatementImpl
	 * @see edu.ustb.sei.mde.xmu2core.impl.Xmu2corePackageImpl#getSolveConstraintStatement()
	 * @generated
	 */
	int SOLVE_CONSTRAINT_STATEMENT = 53;

	/**
	 * The feature id for the '<em><b>Variables</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOLVE_CONSTRAINT_STATEMENT__VARIABLES = STATEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Constraint</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOLVE_CONSTRAINT_STATEMENT__CONSTRAINT = STATEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Solve Constraint Statement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOLVE_CONSTRAINT_STATEMENT_FEATURE_COUNT = STATEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Solve Constraint Statement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOLVE_CONSTRAINT_STATEMENT_OPERATION_COUNT = STATEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.ustb.sei.mde.xmu2core.impl.CommandStatementImpl <em>Command Statement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.ustb.sei.mde.xmu2core.impl.CommandStatementImpl
	 * @see edu.ustb.sei.mde.xmu2core.impl.Xmu2corePackageImpl#getCommandStatement()
	 * @generated
	 */
	int COMMAND_STATEMENT = 54;

	/**
	 * The feature id for the '<em><b>Command</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMAND_STATEMENT__COMMAND = STATEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMAND_STATEMENT__PARAMETERS = STATEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Actions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMAND_STATEMENT__ACTIONS = STATEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Command Statement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMAND_STATEMENT_FEATURE_COUNT = STATEMENT_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Command Statement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMAND_STATEMENT_OPERATION_COUNT = STATEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.ustb.sei.mde.xmu2core.impl.TupleExpressionImpl <em>Tuple Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.ustb.sei.mde.xmu2core.impl.TupleExpressionImpl
	 * @see edu.ustb.sei.mde.xmu2core.impl.Xmu2corePackageImpl#getTupleExpression()
	 * @generated
	 */
	int TUPLE_EXPRESSION = 56;

	/**
	 * The feature id for the '<em><b>Tuples</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_EXPRESSION__TUPLES = EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Tuple Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_EXPRESSION_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Tuple Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_EXPRESSION_OPERATION_COUNT = EXPRESSION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '<em>Null</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.lang.Object
	 * @see edu.ustb.sei.mde.xmu2core.impl.Xmu2corePackageImpl#getNull()
	 * @generated
	 */
	int NULL = 57;

	/**
	 * The meta object id for the '<em>Undefined</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.lang.Object
	 * @see edu.ustb.sei.mde.xmu2core.impl.Xmu2corePackageImpl#getUndefined()
	 * @generated
	 */
	int UNDEFINED = 58;


	/**
	 * Returns the meta object for class '{@link edu.ustb.sei.mde.xmu2core.TypedElement <em>Typed Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Typed Element</em>'.
	 * @see edu.ustb.sei.mde.xmu2core.TypedElement
	 * @generated
	 */
	EClass getTypedElement();

	/**
	 * Returns the meta object for the reference '{@link edu.ustb.sei.mde.xmu2core.TypedElement#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Type</em>'.
	 * @see edu.ustb.sei.mde.xmu2core.TypedElement#getType()
	 * @see #getTypedElement()
	 * @generated
	 */
	EReference getTypedElement_Type();

	/**
	 * Returns the meta object for class '{@link edu.ustb.sei.mde.xmu2core.Nullable <em>Nullable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Nullable</em>'.
	 * @see edu.ustb.sei.mde.xmu2core.Nullable
	 * @generated
	 */
	EClass getNullable();

	/**
	 * Returns the meta object for the attribute '{@link edu.ustb.sei.mde.xmu2core.Nullable#isNullable <em>Nullable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Nullable</em>'.
	 * @see edu.ustb.sei.mde.xmu2core.Nullable#isNullable()
	 * @see #getNullable()
	 * @generated
	 */
	EAttribute getNullable_Nullable();

	/**
	 * Returns the meta object for class '{@link edu.ustb.sei.mde.xmu2core.Callable <em>Callable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Callable</em>'.
	 * @see edu.ustb.sei.mde.xmu2core.Callable
	 * @generated
	 */
	EClass getCallable();

	/**
	 * Returns the meta object for the containment reference list '{@link edu.ustb.sei.mde.xmu2core.Callable#getVariables <em>Variables</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Variables</em>'.
	 * @see edu.ustb.sei.mde.xmu2core.Callable#getVariables()
	 * @see #getCallable()
	 * @generated
	 */
	EReference getCallable_Variables();

	/**
	 * Returns the meta object for the reference list '{@link edu.ustb.sei.mde.xmu2core.Callable#getParameters <em>Parameters</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Parameters</em>'.
	 * @see edu.ustb.sei.mde.xmu2core.Callable#getParameters()
	 * @see #getCallable()
	 * @generated
	 */
	EReference getCallable_Parameters();

	/**
	 * Returns the meta object for class '{@link edu.ustb.sei.mde.xmu2core.Procedure <em>Procedure</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Procedure</em>'.
	 * @see edu.ustb.sei.mde.xmu2core.Procedure
	 * @generated
	 */
	EClass getProcedure();

	/**
	 * Returns the meta object for the containment reference list '{@link edu.ustb.sei.mde.xmu2core.Procedure#getBackwardStatements <em>Backward Statements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Backward Statements</em>'.
	 * @see edu.ustb.sei.mde.xmu2core.Procedure#getBackwardStatements()
	 * @see #getProcedure()
	 * @generated
	 */
	EReference getProcedure_BackwardStatements();

	/**
	 * Returns the meta object for the containment reference list '{@link edu.ustb.sei.mde.xmu2core.Procedure#getForwardStatements <em>Forward Statements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Forward Statements</em>'.
	 * @see edu.ustb.sei.mde.xmu2core.Procedure#getForwardStatements()
	 * @see #getProcedure()
	 * @generated
	 */
	EReference getProcedure_ForwardStatements();

	/**
	 * Returns the meta object for class '{@link edu.ustb.sei.mde.xmu2core.Variable <em>Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Variable</em>'.
	 * @see edu.ustb.sei.mde.xmu2core.Variable
	 * @generated
	 */
	EClass getVariable();

	/**
	 * Returns the meta object for class '{@link edu.ustb.sei.mde.xmu2core.Statement <em>Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Statement</em>'.
	 * @see edu.ustb.sei.mde.xmu2core.Statement
	 * @generated
	 */
	EClass getStatement();

	/**
	 * Returns the meta object for class '{@link edu.ustb.sei.mde.xmu2core.AlignStatement <em>Align Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Align Statement</em>'.
	 * @see edu.ustb.sei.mde.xmu2core.AlignStatement
	 * @generated
	 */
	EClass getAlignStatement();

	/**
	 * Returns the meta object for the containment reference '{@link edu.ustb.sei.mde.xmu2core.AlignStatement#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Source</em>'.
	 * @see edu.ustb.sei.mde.xmu2core.AlignStatement#getSource()
	 * @see #getAlignStatement()
	 * @generated
	 */
	EReference getAlignStatement_Source();

	/**
	 * Returns the meta object for the containment reference '{@link edu.ustb.sei.mde.xmu2core.AlignStatement#getView <em>View</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>View</em>'.
	 * @see edu.ustb.sei.mde.xmu2core.AlignStatement#getView()
	 * @see #getAlignStatement()
	 * @generated
	 */
	EReference getAlignStatement_View();

	/**
	 * Returns the meta object for the containment reference list '{@link edu.ustb.sei.mde.xmu2core.AlignStatement#getMatch <em>Match</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Match</em>'.
	 * @see edu.ustb.sei.mde.xmu2core.AlignStatement#getMatch()
	 * @see #getAlignStatement()
	 * @generated
	 */
	EReference getAlignStatement_Match();

	/**
	 * Returns the meta object for the containment reference list '{@link edu.ustb.sei.mde.xmu2core.AlignStatement#getUnmatchv <em>Unmatchv</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Unmatchv</em>'.
	 * @see edu.ustb.sei.mde.xmu2core.AlignStatement#getUnmatchv()
	 * @see #getAlignStatement()
	 * @generated
	 */
	EReference getAlignStatement_Unmatchv();

	/**
	 * Returns the meta object for the containment reference list '{@link edu.ustb.sei.mde.xmu2core.AlignStatement#getUnmatchs <em>Unmatchs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Unmatchs</em>'.
	 * @see edu.ustb.sei.mde.xmu2core.AlignStatement#getUnmatchs()
	 * @see #getAlignStatement()
	 * @generated
	 */
	EReference getAlignStatement_Unmatchs();

	/**
	 * Returns the meta object for class '{@link edu.ustb.sei.mde.xmu2core.CaseStatement <em>Case Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Case Statement</em>'.
	 * @see edu.ustb.sei.mde.xmu2core.CaseStatement
	 * @generated
	 */
	EClass getCaseStatement();

	/**
	 * Returns the meta object for the containment reference list '{@link edu.ustb.sei.mde.xmu2core.CaseStatement#getClauses <em>Clauses</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Clauses</em>'.
	 * @see edu.ustb.sei.mde.xmu2core.CaseStatement#getClauses()
	 * @see #getCaseStatement()
	 * @generated
	 */
	EReference getCaseStatement_Clauses();

	/**
	 * Returns the meta object for class '{@link edu.ustb.sei.mde.xmu2core.CaseClause <em>Case Clause</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Case Clause</em>'.
	 * @see edu.ustb.sei.mde.xmu2core.CaseClause
	 * @generated
	 */
	EClass getCaseClause();

	/**
	 * Returns the meta object for the containment reference list '{@link edu.ustb.sei.mde.xmu2core.CaseClause#getAction <em>Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Action</em>'.
	 * @see edu.ustb.sei.mde.xmu2core.CaseClause#getAction()
	 * @see #getCaseClause()
	 * @generated
	 */
	EReference getCaseClause_Action();

	/**
	 * Returns the meta object for class '{@link edu.ustb.sei.mde.xmu2core.CasePatternClause <em>Case Pattern Clause</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Case Pattern Clause</em>'.
	 * @see edu.ustb.sei.mde.xmu2core.CasePatternClause
	 * @generated
	 */
	EClass getCasePatternClause();

	/**
	 * Returns the meta object for the containment reference '{@link edu.ustb.sei.mde.xmu2core.CasePatternClause#getCondition <em>Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Condition</em>'.
	 * @see edu.ustb.sei.mde.xmu2core.CasePatternClause#getCondition()
	 * @see #getCasePatternClause()
	 * @generated
	 */
	EReference getCasePatternClause_Condition();

	/**
	 * Returns the meta object for class '{@link edu.ustb.sei.mde.xmu2core.CaseExpressionClause <em>Case Expression Clause</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Case Expression Clause</em>'.
	 * @see edu.ustb.sei.mde.xmu2core.CaseExpressionClause
	 * @generated
	 */
	EClass getCaseExpressionClause();

	/**
	 * Returns the meta object for the containment reference '{@link edu.ustb.sei.mde.xmu2core.CaseExpressionClause#getCondition <em>Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Condition</em>'.
	 * @see edu.ustb.sei.mde.xmu2core.CaseExpressionClause#getCondition()
	 * @see #getCaseExpressionClause()
	 * @generated
	 */
	EReference getCaseExpressionClause_Condition();

	/**
	 * Returns the meta object for class '{@link edu.ustb.sei.mde.xmu2core.CaseStatementClause <em>Case Statement Clause</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Case Statement Clause</em>'.
	 * @see edu.ustb.sei.mde.xmu2core.CaseStatementClause
	 * @generated
	 */
	EClass getCaseStatementClause();

	/**
	 * Returns the meta object for the containment reference list '{@link edu.ustb.sei.mde.xmu2core.CaseStatementClause#getCondition <em>Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Condition</em>'.
	 * @see edu.ustb.sei.mde.xmu2core.CaseStatementClause#getCondition()
	 * @see #getCaseStatementClause()
	 * @generated
	 */
	EReference getCaseStatementClause_Condition();

	/**
	 * Returns the meta object for class '{@link edu.ustb.sei.mde.xmu2core.Pattern <em>Pattern</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Pattern</em>'.
	 * @see edu.ustb.sei.mde.xmu2core.Pattern
	 * @generated
	 */
	EClass getPattern();

	/**
	 * Returns the meta object for the containment reference '{@link edu.ustb.sei.mde.xmu2core.Pattern#getRoot <em>Root</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Root</em>'.
	 * @see edu.ustb.sei.mde.xmu2core.Pattern#getRoot()
	 * @see #getPattern()
	 * @generated
	 */
	EReference getPattern_Root();

	/**
	 * Returns the meta object for the containment reference '{@link edu.ustb.sei.mde.xmu2core.Pattern#getGuard <em>Guard</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Guard</em>'.
	 * @see edu.ustb.sei.mde.xmu2core.Pattern#getGuard()
	 * @see #getPattern()
	 * @generated
	 */
	EReference getPattern_Guard();

	/**
	 * Returns the meta object for class '{@link edu.ustb.sei.mde.xmu2core.PatternNode <em>Pattern Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Pattern Node</em>'.
	 * @see edu.ustb.sei.mde.xmu2core.PatternNode
	 * @generated
	 */
	EClass getPatternNode();

	/**
	 * Returns the meta object for the reference '{@link edu.ustb.sei.mde.xmu2core.PatternNode#getVariable <em>Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Variable</em>'.
	 * @see edu.ustb.sei.mde.xmu2core.PatternNode#getVariable()
	 * @see #getPatternNode()
	 * @generated
	 */
	EReference getPatternNode_Variable();

	/**
	 * Returns the meta object for the reference '{@link edu.ustb.sei.mde.xmu2core.PatternNode#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Type</em>'.
	 * @see edu.ustb.sei.mde.xmu2core.PatternNode#getType()
	 * @see #getPatternNode()
	 * @generated
	 */
	EReference getPatternNode_Type();

	/**
	 * Returns the meta object for the containment reference list '{@link edu.ustb.sei.mde.xmu2core.PatternNode#getExpressions <em>Expressions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Expressions</em>'.
	 * @see edu.ustb.sei.mde.xmu2core.PatternNode#getExpressions()
	 * @see #getPatternNode()
	 * @generated
	 */
	EReference getPatternNode_Expressions();

	/**
	 * Returns the meta object for class '{@link edu.ustb.sei.mde.xmu2core.PatternExpression <em>Pattern Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Pattern Expression</em>'.
	 * @see edu.ustb.sei.mde.xmu2core.PatternExpression
	 * @generated
	 */
	EClass getPatternExpression();

	/**
	 * Returns the meta object for the reference '{@link edu.ustb.sei.mde.xmu2core.PatternExpression#getFeature <em>Feature</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Feature</em>'.
	 * @see edu.ustb.sei.mde.xmu2core.PatternExpression#getFeature()
	 * @see #getPatternExpression()
	 * @generated
	 */
	EReference getPatternExpression_Feature();

	/**
	 * Returns the meta object for the containment reference '{@link edu.ustb.sei.mde.xmu2core.PatternExpression#getSelector <em>Selector</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Selector</em>'.
	 * @see edu.ustb.sei.mde.xmu2core.PatternExpression#getSelector()
	 * @see #getPatternExpression()
	 * @generated
	 */
	EReference getPatternExpression_Selector();

	/**
	 * Returns the meta object for the containment reference '{@link edu.ustb.sei.mde.xmu2core.PatternExpression#getPosition <em>Position</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Position</em>'.
	 * @see edu.ustb.sei.mde.xmu2core.PatternExpression#getPosition()
	 * @see #getPatternExpression()
	 * @generated
	 */
	EReference getPatternExpression_Position();

	/**
	 * Returns the meta object for class '{@link edu.ustb.sei.mde.xmu2core.ObjectPatternExpression <em>Object Pattern Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Object Pattern Expression</em>'.
	 * @see edu.ustb.sei.mde.xmu2core.ObjectPatternExpression
	 * @generated
	 */
	EClass getObjectPatternExpression();

	/**
	 * Returns the meta object for the containment reference '{@link edu.ustb.sei.mde.xmu2core.ObjectPatternExpression#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Target</em>'.
	 * @see edu.ustb.sei.mde.xmu2core.ObjectPatternExpression#getTarget()
	 * @see #getObjectPatternExpression()
	 * @generated
	 */
	EReference getObjectPatternExpression_Target();

	/**
	 * Returns the meta object for class '{@link edu.ustb.sei.mde.xmu2core.PropertyPatternExpression <em>Property Pattern Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Property Pattern Expression</em>'.
	 * @see edu.ustb.sei.mde.xmu2core.PropertyPatternExpression
	 * @generated
	 */
	EClass getPropertyPatternExpression();

	/**
	 * Returns the meta object for the containment reference '{@link edu.ustb.sei.mde.xmu2core.PropertyPatternExpression#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Target</em>'.
	 * @see edu.ustb.sei.mde.xmu2core.PropertyPatternExpression#getTarget()
	 * @see #getPropertyPatternExpression()
	 * @generated
	 */
	EReference getPropertyPatternExpression_Target();

	/**
	 * Returns the meta object for class '{@link edu.ustb.sei.mde.xmu2core.Expression <em>Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Expression</em>'.
	 * @see edu.ustb.sei.mde.xmu2core.Expression
	 * @generated
	 */
	EClass getExpression();

	/**
	 * Returns the meta object for class '{@link edu.ustb.sei.mde.xmu2core.BooleanOrExpression <em>Boolean Or Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Boolean Or Expression</em>'.
	 * @see edu.ustb.sei.mde.xmu2core.BooleanOrExpression
	 * @generated
	 */
	EClass getBooleanOrExpression();

	/**
	 * Returns the meta object for the containment reference list '{@link edu.ustb.sei.mde.xmu2core.BooleanOrExpression#getOperands <em>Operands</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Operands</em>'.
	 * @see edu.ustb.sei.mde.xmu2core.BooleanOrExpression#getOperands()
	 * @see #getBooleanOrExpression()
	 * @generated
	 */
	EReference getBooleanOrExpression_Operands();

	/**
	 * Returns the meta object for class '{@link edu.ustb.sei.mde.xmu2core.BooleanAndExpression <em>Boolean And Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Boolean And Expression</em>'.
	 * @see edu.ustb.sei.mde.xmu2core.BooleanAndExpression
	 * @generated
	 */
	EClass getBooleanAndExpression();

	/**
	 * Returns the meta object for the containment reference list '{@link edu.ustb.sei.mde.xmu2core.BooleanAndExpression#getOperands <em>Operands</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Operands</em>'.
	 * @see edu.ustb.sei.mde.xmu2core.BooleanAndExpression#getOperands()
	 * @see #getBooleanAndExpression()
	 * @generated
	 */
	EReference getBooleanAndExpression_Operands();

	/**
	 * Returns the meta object for class '{@link edu.ustb.sei.mde.xmu2core.RelationalExpression <em>Relational Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Relational Expression</em>'.
	 * @see edu.ustb.sei.mde.xmu2core.RelationalExpression
	 * @generated
	 */
	EClass getRelationalExpression();

	/**
	 * Returns the meta object for the containment reference '{@link edu.ustb.sei.mde.xmu2core.RelationalExpression#getLeft <em>Left</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Left</em>'.
	 * @see edu.ustb.sei.mde.xmu2core.RelationalExpression#getLeft()
	 * @see #getRelationalExpression()
	 * @generated
	 */
	EReference getRelationalExpression_Left();

	/**
	 * Returns the meta object for the containment reference '{@link edu.ustb.sei.mde.xmu2core.RelationalExpression#getRight <em>Right</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Right</em>'.
	 * @see edu.ustb.sei.mde.xmu2core.RelationalExpression#getRight()
	 * @see #getRelationalExpression()
	 * @generated
	 */
	EReference getRelationalExpression_Right();

	/**
	 * Returns the meta object for the attribute '{@link edu.ustb.sei.mde.xmu2core.RelationalExpression#getOperator <em>Operator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Operator</em>'.
	 * @see edu.ustb.sei.mde.xmu2core.RelationalExpression#getOperator()
	 * @see #getRelationalExpression()
	 * @generated
	 */
	EAttribute getRelationalExpression_Operator();

	/**
	 * Returns the meta object for class '{@link edu.ustb.sei.mde.xmu2core.AdditiveExpression <em>Additive Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Additive Expression</em>'.
	 * @see edu.ustb.sei.mde.xmu2core.AdditiveExpression
	 * @generated
	 */
	EClass getAdditiveExpression();

	/**
	 * Returns the meta object for the containment reference list '{@link edu.ustb.sei.mde.xmu2core.AdditiveExpression#getOperands <em>Operands</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Operands</em>'.
	 * @see edu.ustb.sei.mde.xmu2core.AdditiveExpression#getOperands()
	 * @see #getAdditiveExpression()
	 * @generated
	 */
	EReference getAdditiveExpression_Operands();

	/**
	 * Returns the meta object for the attribute list '{@link edu.ustb.sei.mde.xmu2core.AdditiveExpression#getOperators <em>Operators</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Operators</em>'.
	 * @see edu.ustb.sei.mde.xmu2core.AdditiveExpression#getOperators()
	 * @see #getAdditiveExpression()
	 * @generated
	 */
	EAttribute getAdditiveExpression_Operators();

	/**
	 * Returns the meta object for class '{@link edu.ustb.sei.mde.xmu2core.MultiplicativeExpression <em>Multiplicative Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Multiplicative Expression</em>'.
	 * @see edu.ustb.sei.mde.xmu2core.MultiplicativeExpression
	 * @generated
	 */
	EClass getMultiplicativeExpression();

	/**
	 * Returns the meta object for the containment reference list '{@link edu.ustb.sei.mde.xmu2core.MultiplicativeExpression#getOperands <em>Operands</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Operands</em>'.
	 * @see edu.ustb.sei.mde.xmu2core.MultiplicativeExpression#getOperands()
	 * @see #getMultiplicativeExpression()
	 * @generated
	 */
	EReference getMultiplicativeExpression_Operands();

	/**
	 * Returns the meta object for the attribute list '{@link edu.ustb.sei.mde.xmu2core.MultiplicativeExpression#getOperators <em>Operators</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Operators</em>'.
	 * @see edu.ustb.sei.mde.xmu2core.MultiplicativeExpression#getOperators()
	 * @see #getMultiplicativeExpression()
	 * @generated
	 */
	EAttribute getMultiplicativeExpression_Operators();

	/**
	 * Returns the meta object for class '{@link edu.ustb.sei.mde.xmu2core.UnaryExpression <em>Unary Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Unary Expression</em>'.
	 * @see edu.ustb.sei.mde.xmu2core.UnaryExpression
	 * @generated
	 */
	EClass getUnaryExpression();

	/**
	 * Returns the meta object for the containment reference '{@link edu.ustb.sei.mde.xmu2core.UnaryExpression#getBody <em>Body</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Body</em>'.
	 * @see edu.ustb.sei.mde.xmu2core.UnaryExpression#getBody()
	 * @see #getUnaryExpression()
	 * @generated
	 */
	EReference getUnaryExpression_Body();

	/**
	 * Returns the meta object for the attribute '{@link edu.ustb.sei.mde.xmu2core.UnaryExpression#getOperator <em>Operator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Operator</em>'.
	 * @see edu.ustb.sei.mde.xmu2core.UnaryExpression#getOperator()
	 * @see #getUnaryExpression()
	 * @generated
	 */
	EAttribute getUnaryExpression_Operator();

	/**
	 * Returns the meta object for class '{@link edu.ustb.sei.mde.xmu2core.AtomicExpression <em>Atomic Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Atomic Expression</em>'.
	 * @see edu.ustb.sei.mde.xmu2core.AtomicExpression
	 * @generated
	 */
	EClass getAtomicExpression();

	/**
	 * Returns the meta object for the containment reference list '{@link edu.ustb.sei.mde.xmu2core.AtomicExpression#getPaths <em>Paths</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Paths</em>'.
	 * @see edu.ustb.sei.mde.xmu2core.AtomicExpression#getPaths()
	 * @see #getAtomicExpression()
	 * @generated
	 */
	EReference getAtomicExpression_Paths();

	/**
	 * Returns the meta object for class '{@link edu.ustb.sei.mde.xmu2core.TypeCastExpression <em>Type Cast Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Type Cast Expression</em>'.
	 * @see edu.ustb.sei.mde.xmu2core.TypeCastExpression
	 * @generated
	 */
	EClass getTypeCastExpression();

	/**
	 * Returns the meta object for the reference '{@link edu.ustb.sei.mde.xmu2core.TypeCastExpression#getTargetType <em>Target Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target Type</em>'.
	 * @see edu.ustb.sei.mde.xmu2core.TypeCastExpression#getTargetType()
	 * @see #getTypeCastExpression()
	 * @generated
	 */
	EReference getTypeCastExpression_TargetType();

	/**
	 * Returns the meta object for the containment reference '{@link edu.ustb.sei.mde.xmu2core.TypeCastExpression#getBody <em>Body</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Body</em>'.
	 * @see edu.ustb.sei.mde.xmu2core.TypeCastExpression#getBody()
	 * @see #getTypeCastExpression()
	 * @generated
	 */
	EReference getTypeCastExpression_Body();

	/**
	 * Returns the meta object for the reference '{@link edu.ustb.sei.mde.xmu2core.TypeCastExpression#getSourceType <em>Source Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Source Type</em>'.
	 * @see edu.ustb.sei.mde.xmu2core.TypeCastExpression#getSourceType()
	 * @see #getTypeCastExpression()
	 * @generated
	 */
	EReference getTypeCastExpression_SourceType();

	/**
	 * Returns the meta object for class '{@link edu.ustb.sei.mde.xmu2core.PrimitiveValueExpression <em>Primitive Value Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Primitive Value Expression</em>'.
	 * @see edu.ustb.sei.mde.xmu2core.PrimitiveValueExpression
	 * @generated
	 */
	EClass getPrimitiveValueExpression();

	/**
	 * Returns the meta object for the reference '{@link edu.ustb.sei.mde.xmu2core.PrimitiveValueExpression#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Type</em>'.
	 * @see edu.ustb.sei.mde.xmu2core.PrimitiveValueExpression#getType()
	 * @see #getPrimitiveValueExpression()
	 * @generated
	 */
	EReference getPrimitiveValueExpression_Type();

	/**
	 * Returns the meta object for class '{@link edu.ustb.sei.mde.xmu2core.StringValueExpression <em>String Value Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>String Value Expression</em>'.
	 * @see edu.ustb.sei.mde.xmu2core.StringValueExpression
	 * @generated
	 */
	EClass getStringValueExpression();

	/**
	 * Returns the meta object for the attribute '{@link edu.ustb.sei.mde.xmu2core.StringValueExpression#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see edu.ustb.sei.mde.xmu2core.StringValueExpression#getValue()
	 * @see #getStringValueExpression()
	 * @generated
	 */
	EAttribute getStringValueExpression_Value();

	/**
	 * Returns the meta object for class '{@link edu.ustb.sei.mde.xmu2core.BooleanValueExpression <em>Boolean Value Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Boolean Value Expression</em>'.
	 * @see edu.ustb.sei.mde.xmu2core.BooleanValueExpression
	 * @generated
	 */
	EClass getBooleanValueExpression();

	/**
	 * Returns the meta object for the attribute '{@link edu.ustb.sei.mde.xmu2core.BooleanValueExpression#isValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see edu.ustb.sei.mde.xmu2core.BooleanValueExpression#isValue()
	 * @see #getBooleanValueExpression()
	 * @generated
	 */
	EAttribute getBooleanValueExpression_Value();

	/**
	 * Returns the meta object for class '{@link edu.ustb.sei.mde.xmu2core.IntegerValueExpression <em>Integer Value Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Integer Value Expression</em>'.
	 * @see edu.ustb.sei.mde.xmu2core.IntegerValueExpression
	 * @generated
	 */
	EClass getIntegerValueExpression();

	/**
	 * Returns the meta object for the attribute '{@link edu.ustb.sei.mde.xmu2core.IntegerValueExpression#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see edu.ustb.sei.mde.xmu2core.IntegerValueExpression#getValue()
	 * @see #getIntegerValueExpression()
	 * @generated
	 */
	EAttribute getIntegerValueExpression_Value();

	/**
	 * Returns the meta object for class '{@link edu.ustb.sei.mde.xmu2core.EnumValueExpression <em>Enum Value Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Enum Value Expression</em>'.
	 * @see edu.ustb.sei.mde.xmu2core.EnumValueExpression
	 * @generated
	 */
	EClass getEnumValueExpression();

	/**
	 * Returns the meta object for the reference '{@link edu.ustb.sei.mde.xmu2core.EnumValueExpression#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Value</em>'.
	 * @see edu.ustb.sei.mde.xmu2core.EnumValueExpression#getValue()
	 * @see #getEnumValueExpression()
	 * @generated
	 */
	EReference getEnumValueExpression_Value();

	/**
	 * Returns the meta object for class '{@link edu.ustb.sei.mde.xmu2core.EmptyValueExpression <em>Empty Value Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Empty Value Expression</em>'.
	 * @see edu.ustb.sei.mde.xmu2core.EmptyValueExpression
	 * @generated
	 */
	EClass getEmptyValueExpression();

	/**
	 * Returns the meta object for class '{@link edu.ustb.sei.mde.xmu2core.ObjectValueExpression <em>Object Value Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Object Value Expression</em>'.
	 * @see edu.ustb.sei.mde.xmu2core.ObjectValueExpression
	 * @generated
	 */
	EClass getObjectValueExpression();

	/**
	 * Returns the meta object for the reference '{@link edu.ustb.sei.mde.xmu2core.ObjectValueExpression#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Value</em>'.
	 * @see edu.ustb.sei.mde.xmu2core.ObjectValueExpression#getValue()
	 * @see #getObjectValueExpression()
	 * @generated
	 */
	EReference getObjectValueExpression_Value();

	/**
	 * Returns the meta object for class '{@link edu.ustb.sei.mde.xmu2core.VariableExpression <em>Variable Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Variable Expression</em>'.
	 * @see edu.ustb.sei.mde.xmu2core.VariableExpression
	 * @generated
	 */
	EClass getVariableExpression();

	/**
	 * Returns the meta object for the reference '{@link edu.ustb.sei.mde.xmu2core.VariableExpression#getVariable <em>Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Variable</em>'.
	 * @see edu.ustb.sei.mde.xmu2core.VariableExpression#getVariable()
	 * @see #getVariableExpression()
	 * @generated
	 */
	EReference getVariableExpression_Variable();

	/**
	 * Returns the meta object for class '{@link edu.ustb.sei.mde.xmu2core.Path <em>Path</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Path</em>'.
	 * @see edu.ustb.sei.mde.xmu2core.Path
	 * @generated
	 */
	EClass getPath();

	/**
	 * Returns the meta object for class '{@link edu.ustb.sei.mde.xmu2core.FeaturePath <em>Feature Path</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Feature Path</em>'.
	 * @see edu.ustb.sei.mde.xmu2core.FeaturePath
	 * @generated
	 */
	EClass getFeaturePath();

	/**
	 * Returns the meta object for the reference '{@link edu.ustb.sei.mde.xmu2core.FeaturePath#getFeature <em>Feature</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Feature</em>'.
	 * @see edu.ustb.sei.mde.xmu2core.FeaturePath#getFeature()
	 * @see #getFeaturePath()
	 * @generated
	 */
	EReference getFeaturePath_Feature();

	/**
	 * Returns the meta object for class '{@link edu.ustb.sei.mde.xmu2core.OperationPath <em>Operation Path</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Operation Path</em>'.
	 * @see edu.ustb.sei.mde.xmu2core.OperationPath
	 * @generated
	 */
	EClass getOperationPath();

	/**
	 * Returns the meta object for the containment reference list '{@link edu.ustb.sei.mde.xmu2core.OperationPath#getParameters <em>Parameters</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Parameters</em>'.
	 * @see edu.ustb.sei.mde.xmu2core.OperationPath#getParameters()
	 * @see #getOperationPath()
	 * @generated
	 */
	EReference getOperationPath_Parameters();

	/**
	 * Returns the meta object for the attribute '{@link edu.ustb.sei.mde.xmu2core.OperationPath#getOperation <em>Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Operation</em>'.
	 * @see edu.ustb.sei.mde.xmu2core.OperationPath#getOperation()
	 * @see #getOperationPath()
	 * @generated
	 */
	EAttribute getOperationPath_Operation();

	/**
	 * Returns the meta object for class '{@link edu.ustb.sei.mde.xmu2core.LoopPath <em>Loop Path</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Loop Path</em>'.
	 * @see edu.ustb.sei.mde.xmu2core.LoopPath
	 * @generated
	 */
	EClass getLoopPath();

	/**
	 * Returns the meta object for the attribute '{@link edu.ustb.sei.mde.xmu2core.LoopPath#getOperator <em>Operator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Operator</em>'.
	 * @see edu.ustb.sei.mde.xmu2core.LoopPath#getOperator()
	 * @see #getLoopPath()
	 * @generated
	 */
	EAttribute getLoopPath_Operator();

	/**
	 * Returns the meta object for the containment reference '{@link edu.ustb.sei.mde.xmu2core.LoopPath#getIterator <em>Iterator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Iterator</em>'.
	 * @see edu.ustb.sei.mde.xmu2core.LoopPath#getIterator()
	 * @see #getLoopPath()
	 * @generated
	 */
	EReference getLoopPath_Iterator();

	/**
	 * Returns the meta object for the containment reference '{@link edu.ustb.sei.mde.xmu2core.LoopPath#getBody <em>Body</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Body</em>'.
	 * @see edu.ustb.sei.mde.xmu2core.LoopPath#getBody()
	 * @see #getLoopPath()
	 * @generated
	 */
	EReference getLoopPath_Body();

	/**
	 * Returns the meta object for class '{@link edu.ustb.sei.mde.xmu2core.PositionPath <em>Position Path</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Position Path</em>'.
	 * @see edu.ustb.sei.mde.xmu2core.PositionPath
	 * @generated
	 */
	EClass getPositionPath();

	/**
	 * Returns the meta object for the containment reference '{@link edu.ustb.sei.mde.xmu2core.PositionPath#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Value</em>'.
	 * @see edu.ustb.sei.mde.xmu2core.PositionPath#getValue()
	 * @see #getPositionPath()
	 * @generated
	 */
	EReference getPositionPath_Value();

	/**
	 * Returns the meta object for the attribute '{@link edu.ustb.sei.mde.xmu2core.PositionPath#getOperator <em>Operator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Operator</em>'.
	 * @see edu.ustb.sei.mde.xmu2core.PositionPath#getOperator()
	 * @see #getPositionPath()
	 * @generated
	 */
	EAttribute getPositionPath_Operator();

	/**
	 * Returns the meta object for class '{@link edu.ustb.sei.mde.xmu2core.CallStatement <em>Call Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Call Statement</em>'.
	 * @see edu.ustb.sei.mde.xmu2core.CallStatement
	 * @generated
	 */
	EClass getCallStatement();

	/**
	 * Returns the meta object for the reference '{@link edu.ustb.sei.mde.xmu2core.CallStatement#getCallable <em>Callable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Callable</em>'.
	 * @see edu.ustb.sei.mde.xmu2core.CallStatement#getCallable()
	 * @see #getCallStatement()
	 * @generated
	 */
	EReference getCallStatement_Callable();

	/**
	 * Returns the meta object for the containment reference list '{@link edu.ustb.sei.mde.xmu2core.CallStatement#getParameters <em>Parameters</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Parameters</em>'.
	 * @see edu.ustb.sei.mde.xmu2core.CallStatement#getParameters()
	 * @see #getCallStatement()
	 * @generated
	 */
	EReference getCallStatement_Parameters();

	/**
	 * Returns the meta object for the containment reference list '{@link edu.ustb.sei.mde.xmu2core.CallStatement#getUpdatedParameters <em>Updated Parameters</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Updated Parameters</em>'.
	 * @see edu.ustb.sei.mde.xmu2core.CallStatement#getUpdatedParameters()
	 * @see #getCallStatement()
	 * @generated
	 */
	EReference getCallStatement_UpdatedParameters();

	/**
	 * Returns the meta object for class '{@link edu.ustb.sei.mde.xmu2core.Transformation <em>Transformation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Transformation</em>'.
	 * @see edu.ustb.sei.mde.xmu2core.Transformation
	 * @generated
	 */
	EClass getTransformation();

	/**
	 * Returns the meta object for the containment reference list '{@link edu.ustb.sei.mde.xmu2core.Transformation#getCallables <em>Callables</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Callables</em>'.
	 * @see edu.ustb.sei.mde.xmu2core.Transformation#getCallables()
	 * @see #getTransformation()
	 * @generated
	 */
	EReference getTransformation_Callables();

	/**
	 * Returns the meta object for the containment reference list '{@link edu.ustb.sei.mde.xmu2core.Transformation#getDeclaredTypes <em>Declared Types</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Declared Types</em>'.
	 * @see edu.ustb.sei.mde.xmu2core.Transformation#getDeclaredTypes()
	 * @see #getTransformation()
	 * @generated
	 */
	EReference getTransformation_DeclaredTypes();

	/**
	 * Returns the meta object for the containment reference list '{@link edu.ustb.sei.mde.xmu2core.Transformation#getEntryRules <em>Entry Rules</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Entry Rules</em>'.
	 * @see edu.ustb.sei.mde.xmu2core.Transformation#getEntryRules()
	 * @see #getTransformation()
	 * @generated
	 */
	EReference getTransformation_EntryRules();

	/**
	 * Returns the meta object for the reference list '{@link edu.ustb.sei.mde.xmu2core.Transformation#getPackages <em>Packages</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Packages</em>'.
	 * @see edu.ustb.sei.mde.xmu2core.Transformation#getPackages()
	 * @see #getTransformation()
	 * @generated
	 */
	EReference getTransformation_Packages();

	/**
	 * Returns the meta object for class '{@link edu.ustb.sei.mde.xmu2core.EntryRuleParameter <em>Entry Rule Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Entry Rule Parameter</em>'.
	 * @see edu.ustb.sei.mde.xmu2core.EntryRuleParameter
	 * @generated
	 */
	EClass getEntryRuleParameter();

	/**
	 * Returns the meta object for the attribute '{@link edu.ustb.sei.mde.xmu2core.EntryRuleParameter#getIndex <em>Index</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Index</em>'.
	 * @see edu.ustb.sei.mde.xmu2core.EntryRuleParameter#getIndex()
	 * @see #getEntryRuleParameter()
	 * @generated
	 */
	EAttribute getEntryRuleParameter_Index();

	/**
	 * Returns the meta object for the attribute '{@link edu.ustb.sei.mde.xmu2core.EntryRuleParameter#getFragment <em>Fragment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Fragment</em>'.
	 * @see edu.ustb.sei.mde.xmu2core.EntryRuleParameter#getFragment()
	 * @see #getEntryRuleParameter()
	 * @generated
	 */
	EAttribute getEntryRuleParameter_Fragment();

	/**
	 * Returns the meta object for class '{@link edu.ustb.sei.mde.xmu2core.ForEachStatement <em>For Each Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>For Each Statement</em>'.
	 * @see edu.ustb.sei.mde.xmu2core.ForEachStatement
	 * @generated
	 */
	EClass getForEachStatement();

	/**
	 * Returns the meta object for the containment reference '{@link edu.ustb.sei.mde.xmu2core.ForEachStatement#getPattern <em>Pattern</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Pattern</em>'.
	 * @see edu.ustb.sei.mde.xmu2core.ForEachStatement#getPattern()
	 * @see #getForEachStatement()
	 * @generated
	 */
	EReference getForEachStatement_Pattern();

	/**
	 * Returns the meta object for the containment reference list '{@link edu.ustb.sei.mde.xmu2core.ForEachStatement#getAction <em>Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Action</em>'.
	 * @see edu.ustb.sei.mde.xmu2core.ForEachStatement#getAction()
	 * @see #getForEachStatement()
	 * @generated
	 */
	EReference getForEachStatement_Action();

	/**
	 * Returns the meta object for the attribute '{@link edu.ustb.sei.mde.xmu2core.ForEachStatement#isDerived <em>Derived</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Derived</em>'.
	 * @see edu.ustb.sei.mde.xmu2core.ForEachStatement#isDerived()
	 * @see #getForEachStatement()
	 * @generated
	 */
	EAttribute getForEachStatement_Derived();

	/**
	 * Returns the meta object for class '{@link edu.ustb.sei.mde.xmu2core.DeleteNodeStatement <em>Delete Node Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Delete Node Statement</em>'.
	 * @see edu.ustb.sei.mde.xmu2core.DeleteNodeStatement
	 * @generated
	 */
	EClass getDeleteNodeStatement();

	/**
	 * Returns the meta object for the reference '{@link edu.ustb.sei.mde.xmu2core.DeleteNodeStatement#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target</em>'.
	 * @see edu.ustb.sei.mde.xmu2core.DeleteNodeStatement#getTarget()
	 * @see #getDeleteNodeStatement()
	 * @generated
	 */
	EReference getDeleteNodeStatement_Target();

	/**
	 * Returns the meta object for class '{@link edu.ustb.sei.mde.xmu2core.DeleteLinkStatement <em>Delete Link Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Delete Link Statement</em>'.
	 * @see edu.ustb.sei.mde.xmu2core.DeleteLinkStatement
	 * @generated
	 */
	EClass getDeleteLinkStatement();

	/**
	 * Returns the meta object for the containment reference '{@link edu.ustb.sei.mde.xmu2core.DeleteLinkStatement#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Target</em>'.
	 * @see edu.ustb.sei.mde.xmu2core.DeleteLinkStatement#getTarget()
	 * @see #getDeleteLinkStatement()
	 * @generated
	 */
	EReference getDeleteLinkStatement_Target();

	/**
	 * Returns the meta object for the reference '{@link edu.ustb.sei.mde.xmu2core.DeleteLinkStatement#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Source</em>'.
	 * @see edu.ustb.sei.mde.xmu2core.DeleteLinkStatement#getSource()
	 * @see #getDeleteLinkStatement()
	 * @generated
	 */
	EReference getDeleteLinkStatement_Source();

	/**
	 * Returns the meta object for the reference '{@link edu.ustb.sei.mde.xmu2core.DeleteLinkStatement#getFeature <em>Feature</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Feature</em>'.
	 * @see edu.ustb.sei.mde.xmu2core.DeleteLinkStatement#getFeature()
	 * @see #getDeleteLinkStatement()
	 * @generated
	 */
	EReference getDeleteLinkStatement_Feature();

	/**
	 * Returns the meta object for class '{@link edu.ustb.sei.mde.xmu2core.EnforceNodeStatement <em>Enforce Node Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Enforce Node Statement</em>'.
	 * @see edu.ustb.sei.mde.xmu2core.EnforceNodeStatement
	 * @generated
	 */
	EClass getEnforceNodeStatement();

	/**
	 * Returns the meta object for the reference '{@link edu.ustb.sei.mde.xmu2core.EnforceNodeStatement#getNode <em>Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Node</em>'.
	 * @see edu.ustb.sei.mde.xmu2core.EnforceNodeStatement#getNode()
	 * @see #getEnforceNodeStatement()
	 * @generated
	 */
	EReference getEnforceNodeStatement_Node();

	/**
	 * Returns the meta object for the reference '{@link edu.ustb.sei.mde.xmu2core.EnforceNodeStatement#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Type</em>'.
	 * @see edu.ustb.sei.mde.xmu2core.EnforceNodeStatement#getType()
	 * @see #getEnforceNodeStatement()
	 * @generated
	 */
	EReference getEnforceNodeStatement_Type();

	/**
	 * Returns the meta object for the containment reference '{@link edu.ustb.sei.mde.xmu2core.EnforceNodeStatement#getCandidate <em>Candidate</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Candidate</em>'.
	 * @see edu.ustb.sei.mde.xmu2core.EnforceNodeStatement#getCandidate()
	 * @see #getEnforceNodeStatement()
	 * @generated
	 */
	EReference getEnforceNodeStatement_Candidate();

	/**
	 * Returns the meta object for class '{@link edu.ustb.sei.mde.xmu2core.EnforceLinkStatement <em>Enforce Link Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Enforce Link Statement</em>'.
	 * @see edu.ustb.sei.mde.xmu2core.EnforceLinkStatement
	 * @generated
	 */
	EClass getEnforceLinkStatement();

	/**
	 * Returns the meta object for the containment reference '{@link edu.ustb.sei.mde.xmu2core.EnforceLinkStatement#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Target</em>'.
	 * @see edu.ustb.sei.mde.xmu2core.EnforceLinkStatement#getTarget()
	 * @see #getEnforceLinkStatement()
	 * @generated
	 */
	EReference getEnforceLinkStatement_Target();

	/**
	 * Returns the meta object for the reference '{@link edu.ustb.sei.mde.xmu2core.EnforceLinkStatement#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Source</em>'.
	 * @see edu.ustb.sei.mde.xmu2core.EnforceLinkStatement#getSource()
	 * @see #getEnforceLinkStatement()
	 * @generated
	 */
	EReference getEnforceLinkStatement_Source();

	/**
	 * Returns the meta object for the reference '{@link edu.ustb.sei.mde.xmu2core.EnforceLinkStatement#getFeature <em>Feature</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Feature</em>'.
	 * @see edu.ustb.sei.mde.xmu2core.EnforceLinkStatement#getFeature()
	 * @see #getEnforceLinkStatement()
	 * @generated
	 */
	EReference getEnforceLinkStatement_Feature();

	/**
	 * Returns the meta object for the containment reference '{@link edu.ustb.sei.mde.xmu2core.EnforceLinkStatement#getSelector <em>Selector</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Selector</em>'.
	 * @see edu.ustb.sei.mde.xmu2core.EnforceLinkStatement#getSelector()
	 * @see #getEnforceLinkStatement()
	 * @generated
	 */
	EReference getEnforceLinkStatement_Selector();

	/**
	 * Returns the meta object for the containment reference '{@link edu.ustb.sei.mde.xmu2core.EnforceLinkStatement#getPosition <em>Position</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Position</em>'.
	 * @see edu.ustb.sei.mde.xmu2core.EnforceLinkStatement#getPosition()
	 * @see #getEnforceLinkStatement()
	 * @generated
	 */
	EReference getEnforceLinkStatement_Position();

	/**
	 * Returns the meta object for the reference '{@link edu.ustb.sei.mde.xmu2core.EnforceLinkStatement#getSourceType <em>Source Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Source Type</em>'.
	 * @see edu.ustb.sei.mde.xmu2core.EnforceLinkStatement#getSourceType()
	 * @see #getEnforceLinkStatement()
	 * @generated
	 */
	EReference getEnforceLinkStatement_SourceType();

	/**
	 * Returns the meta object for class '{@link edu.ustb.sei.mde.xmu2core.OclCollectionType <em>Ocl Collection Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Ocl Collection Type</em>'.
	 * @see edu.ustb.sei.mde.xmu2core.OclCollectionType
	 * @generated
	 */
	EClass getOclCollectionType();

	/**
	 * Returns the meta object for the reference '{@link edu.ustb.sei.mde.xmu2core.OclCollectionType#getElementtype <em>Elementtype</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Elementtype</em>'.
	 * @see edu.ustb.sei.mde.xmu2core.OclCollectionType#getElementtype()
	 * @see #getOclCollectionType()
	 * @generated
	 */
	EReference getOclCollectionType_Elementtype();

	/**
	 * Returns the meta object for class '{@link edu.ustb.sei.mde.xmu2core.OclCollection <em>Ocl Collection</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Ocl Collection</em>'.
	 * @see edu.ustb.sei.mde.xmu2core.OclCollection
	 * @generated
	 */
	EClass getOclCollection();

	/**
	 * Returns the meta object for the reference '{@link edu.ustb.sei.mde.xmu2core.OclCollection#getElementType <em>Element Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Element Type</em>'.
	 * @see edu.ustb.sei.mde.xmu2core.OclCollection#getElementType()
	 * @see #getOclCollection()
	 * @generated
	 */
	EReference getOclCollection_ElementType();

	/**
	 * Returns the meta object for class '{@link edu.ustb.sei.mde.xmu2core.MatchPattern <em>Match Pattern</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Match Pattern</em>'.
	 * @see edu.ustb.sei.mde.xmu2core.MatchPattern
	 * @generated
	 */
	EClass getMatchPattern();

	/**
	 * Returns the meta object for the containment reference '{@link edu.ustb.sei.mde.xmu2core.MatchPattern#getPattern <em>Pattern</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Pattern</em>'.
	 * @see edu.ustb.sei.mde.xmu2core.MatchPattern#getPattern()
	 * @see #getMatchPattern()
	 * @generated
	 */
	EReference getMatchPattern_Pattern();

	/**
	 * Returns the meta object for class '{@link edu.ustb.sei.mde.xmu2core.CheckExpressionStatement <em>Check Expression Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Check Expression Statement</em>'.
	 * @see edu.ustb.sei.mde.xmu2core.CheckExpressionStatement
	 * @generated
	 */
	EClass getCheckExpressionStatement();

	/**
	 * Returns the meta object for the containment reference '{@link edu.ustb.sei.mde.xmu2core.CheckExpressionStatement#getExpression <em>Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Expression</em>'.
	 * @see edu.ustb.sei.mde.xmu2core.CheckExpressionStatement#getExpression()
	 * @see #getCheckExpressionStatement()
	 * @generated
	 */
	EReference getCheckExpressionStatement_Expression();

	/**
	 * Returns the meta object for class '{@link edu.ustb.sei.mde.xmu2core.EnforceExpressionStatement <em>Enforce Expression Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Enforce Expression Statement</em>'.
	 * @see edu.ustb.sei.mde.xmu2core.EnforceExpressionStatement
	 * @generated
	 */
	EClass getEnforceExpressionStatement();

	/**
	 * Returns the meta object for the containment reference '{@link edu.ustb.sei.mde.xmu2core.EnforceExpressionStatement#getExpression <em>Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Expression</em>'.
	 * @see edu.ustb.sei.mde.xmu2core.EnforceExpressionStatement#getExpression()
	 * @see #getEnforceExpressionStatement()
	 * @generated
	 */
	EReference getEnforceExpressionStatement_Expression();

	/**
	 * Returns the meta object for class '{@link edu.ustb.sei.mde.xmu2core.Function <em>Function</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Function</em>'.
	 * @see edu.ustb.sei.mde.xmu2core.Function
	 * @generated
	 */
	EClass getFunction();

	/**
	 * Returns the meta object for the containment reference list '{@link edu.ustb.sei.mde.xmu2core.Function#getBackwardStatements <em>Backward Statements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Backward Statements</em>'.
	 * @see edu.ustb.sei.mde.xmu2core.Function#getBackwardStatements()
	 * @see #getFunction()
	 * @generated
	 */
	EReference getFunction_BackwardStatements();

	/**
	 * Returns the meta object for the containment reference list '{@link edu.ustb.sei.mde.xmu2core.Function#getForwardStatements <em>Forward Statements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Forward Statements</em>'.
	 * @see edu.ustb.sei.mde.xmu2core.Function#getForwardStatements()
	 * @see #getFunction()
	 * @generated
	 */
	EReference getFunction_ForwardStatements();

	/**
	 * Returns the meta object for class '{@link edu.ustb.sei.mde.xmu2core.SolveConstraintStatement <em>Solve Constraint Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Solve Constraint Statement</em>'.
	 * @see edu.ustb.sei.mde.xmu2core.SolveConstraintStatement
	 * @generated
	 */
	EClass getSolveConstraintStatement();

	/**
	 * Returns the meta object for the reference list '{@link edu.ustb.sei.mde.xmu2core.SolveConstraintStatement#getVariables <em>Variables</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Variables</em>'.
	 * @see edu.ustb.sei.mde.xmu2core.SolveConstraintStatement#getVariables()
	 * @see #getSolveConstraintStatement()
	 * @generated
	 */
	EReference getSolveConstraintStatement_Variables();

	/**
	 * Returns the meta object for the containment reference '{@link edu.ustb.sei.mde.xmu2core.SolveConstraintStatement#getConstraint <em>Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Constraint</em>'.
	 * @see edu.ustb.sei.mde.xmu2core.SolveConstraintStatement#getConstraint()
	 * @see #getSolveConstraintStatement()
	 * @generated
	 */
	EReference getSolveConstraintStatement_Constraint();

	/**
	 * Returns the meta object for class '{@link edu.ustb.sei.mde.xmu2core.CommandStatement <em>Command Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Command Statement</em>'.
	 * @see edu.ustb.sei.mde.xmu2core.CommandStatement
	 * @generated
	 */
	EClass getCommandStatement();

	/**
	 * Returns the meta object for the containment reference list '{@link edu.ustb.sei.mde.xmu2core.CommandStatement#getParameters <em>Parameters</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Parameters</em>'.
	 * @see edu.ustb.sei.mde.xmu2core.CommandStatement#getParameters()
	 * @see #getCommandStatement()
	 * @generated
	 */
	EReference getCommandStatement_Parameters();

	/**
	 * Returns the meta object for the containment reference list '{@link edu.ustb.sei.mde.xmu2core.CommandStatement#getActions <em>Actions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Actions</em>'.
	 * @see edu.ustb.sei.mde.xmu2core.CommandStatement#getActions()
	 * @see #getCommandStatement()
	 * @generated
	 */
	EReference getCommandStatement_Actions();

	/**
	 * Returns the meta object for the attribute '{@link edu.ustb.sei.mde.xmu2core.CommandStatement#getCommand <em>Command</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Command</em>'.
	 * @see edu.ustb.sei.mde.xmu2core.CommandStatement#getCommand()
	 * @see #getCommandStatement()
	 * @generated
	 */
	EAttribute getCommandStatement_Command();

	/**
	 * Returns the meta object for class '{@link edu.ustb.sei.mde.xmu2core.ReflectiveSupport <em>Reflective Support</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Reflective Support</em>'.
	 * @see edu.ustb.sei.mde.xmu2core.ReflectiveSupport
	 * @generated
	 */
	EClass getReflectiveSupport();

	/**
	 * Returns the meta object for the containment reference '{@link edu.ustb.sei.mde.xmu2core.ReflectiveSupport#getReflectiveIdentifier <em>Reflective Identifier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Reflective Identifier</em>'.
	 * @see edu.ustb.sei.mde.xmu2core.ReflectiveSupport#getReflectiveIdentifier()
	 * @see #getReflectiveSupport()
	 * @generated
	 */
	EReference getReflectiveSupport_ReflectiveIdentifier();

	/**
	 * Returns the meta object for the attribute '{@link edu.ustb.sei.mde.xmu2core.ReflectiveSupport#isReflective <em>Reflective</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Reflective</em>'.
	 * @see edu.ustb.sei.mde.xmu2core.ReflectiveSupport#isReflective()
	 * @see #getReflectiveSupport()
	 * @generated
	 */
	EAttribute getReflectiveSupport_Reflective();

	/**
	 * Returns the meta object for the attribute '{@link edu.ustb.sei.mde.xmu2core.ReflectiveSupport#isResolve <em>Resolve</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Resolve</em>'.
	 * @see edu.ustb.sei.mde.xmu2core.ReflectiveSupport#isResolve()
	 * @see #getReflectiveSupport()
	 * @generated
	 */
	EAttribute getReflectiveSupport_Resolve();

	/**
	 * Returns the meta object for class '{@link edu.ustb.sei.mde.xmu2core.TupleExpression <em>Tuple Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Tuple Expression</em>'.
	 * @see edu.ustb.sei.mde.xmu2core.TupleExpression
	 * @generated
	 */
	EClass getTupleExpression();

	/**
	 * Returns the meta object for the containment reference list '{@link edu.ustb.sei.mde.xmu2core.TupleExpression#getTuples <em>Tuples</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Tuples</em>'.
	 * @see edu.ustb.sei.mde.xmu2core.TupleExpression#getTuples()
	 * @see #getTupleExpression()
	 * @generated
	 */
	EReference getTupleExpression_Tuples();

	/**
	 * Returns the meta object for data type '{@link java.lang.Object <em>Null</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Null</em>'.
	 * @see java.lang.Object
	 * @model instanceClass="java.lang.Object"
	 * @generated
	 */
	EDataType getNull();

	/**
	 * Returns the meta object for data type '{@link java.lang.Object <em>Undefined</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Undefined</em>'.
	 * @see java.lang.Object
	 * @model instanceClass="java.lang.Object"
	 * @generated
	 */
	EDataType getUndefined();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	Xmu2coreFactory getXmu2coreFactory();

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
		 * The meta object literal for the '{@link edu.ustb.sei.mde.xmu2core.impl.TypedElementImpl <em>Typed Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.ustb.sei.mde.xmu2core.impl.TypedElementImpl
		 * @see edu.ustb.sei.mde.xmu2core.impl.Xmu2corePackageImpl#getTypedElement()
		 * @generated
		 */
		EClass TYPED_ELEMENT = eINSTANCE.getTypedElement();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TYPED_ELEMENT__TYPE = eINSTANCE.getTypedElement_Type();

		/**
		 * The meta object literal for the '{@link edu.ustb.sei.mde.xmu2core.impl.NullableImpl <em>Nullable</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.ustb.sei.mde.xmu2core.impl.NullableImpl
		 * @see edu.ustb.sei.mde.xmu2core.impl.Xmu2corePackageImpl#getNullable()
		 * @generated
		 */
		EClass NULLABLE = eINSTANCE.getNullable();

		/**
		 * The meta object literal for the '<em><b>Nullable</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NULLABLE__NULLABLE = eINSTANCE.getNullable_Nullable();

		/**
		 * The meta object literal for the '{@link edu.ustb.sei.mde.xmu2core.impl.CallableImpl <em>Callable</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.ustb.sei.mde.xmu2core.impl.CallableImpl
		 * @see edu.ustb.sei.mde.xmu2core.impl.Xmu2corePackageImpl#getCallable()
		 * @generated
		 */
		EClass CALLABLE = eINSTANCE.getCallable();

		/**
		 * The meta object literal for the '<em><b>Variables</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CALLABLE__VARIABLES = eINSTANCE.getCallable_Variables();

		/**
		 * The meta object literal for the '<em><b>Parameters</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CALLABLE__PARAMETERS = eINSTANCE.getCallable_Parameters();

		/**
		 * The meta object literal for the '{@link edu.ustb.sei.mde.xmu2core.impl.ProcedureImpl <em>Procedure</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.ustb.sei.mde.xmu2core.impl.ProcedureImpl
		 * @see edu.ustb.sei.mde.xmu2core.impl.Xmu2corePackageImpl#getProcedure()
		 * @generated
		 */
		EClass PROCEDURE = eINSTANCE.getProcedure();

		/**
		 * The meta object literal for the '<em><b>Backward Statements</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROCEDURE__BACKWARD_STATEMENTS = eINSTANCE.getProcedure_BackwardStatements();

		/**
		 * The meta object literal for the '<em><b>Forward Statements</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROCEDURE__FORWARD_STATEMENTS = eINSTANCE.getProcedure_ForwardStatements();

		/**
		 * The meta object literal for the '{@link edu.ustb.sei.mde.xmu2core.impl.VariableImpl <em>Variable</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.ustb.sei.mde.xmu2core.impl.VariableImpl
		 * @see edu.ustb.sei.mde.xmu2core.impl.Xmu2corePackageImpl#getVariable()
		 * @generated
		 */
		EClass VARIABLE = eINSTANCE.getVariable();

		/**
		 * The meta object literal for the '{@link edu.ustb.sei.mde.xmu2core.impl.StatementImpl <em>Statement</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.ustb.sei.mde.xmu2core.impl.StatementImpl
		 * @see edu.ustb.sei.mde.xmu2core.impl.Xmu2corePackageImpl#getStatement()
		 * @generated
		 */
		EClass STATEMENT = eINSTANCE.getStatement();

		/**
		 * The meta object literal for the '{@link edu.ustb.sei.mde.xmu2core.impl.AlignStatementImpl <em>Align Statement</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.ustb.sei.mde.xmu2core.impl.AlignStatementImpl
		 * @see edu.ustb.sei.mde.xmu2core.impl.Xmu2corePackageImpl#getAlignStatement()
		 * @generated
		 */
		EClass ALIGN_STATEMENT = eINSTANCE.getAlignStatement();

		/**
		 * The meta object literal for the '<em><b>Source</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ALIGN_STATEMENT__SOURCE = eINSTANCE.getAlignStatement_Source();

		/**
		 * The meta object literal for the '<em><b>View</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ALIGN_STATEMENT__VIEW = eINSTANCE.getAlignStatement_View();

		/**
		 * The meta object literal for the '<em><b>Match</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ALIGN_STATEMENT__MATCH = eINSTANCE.getAlignStatement_Match();

		/**
		 * The meta object literal for the '<em><b>Unmatchv</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ALIGN_STATEMENT__UNMATCHV = eINSTANCE.getAlignStatement_Unmatchv();

		/**
		 * The meta object literal for the '<em><b>Unmatchs</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ALIGN_STATEMENT__UNMATCHS = eINSTANCE.getAlignStatement_Unmatchs();

		/**
		 * The meta object literal for the '{@link edu.ustb.sei.mde.xmu2core.impl.CaseStatementImpl <em>Case Statement</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.ustb.sei.mde.xmu2core.impl.CaseStatementImpl
		 * @see edu.ustb.sei.mde.xmu2core.impl.Xmu2corePackageImpl#getCaseStatement()
		 * @generated
		 */
		EClass CASE_STATEMENT = eINSTANCE.getCaseStatement();

		/**
		 * The meta object literal for the '<em><b>Clauses</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CASE_STATEMENT__CLAUSES = eINSTANCE.getCaseStatement_Clauses();

		/**
		 * The meta object literal for the '{@link edu.ustb.sei.mde.xmu2core.impl.CaseClauseImpl <em>Case Clause</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.ustb.sei.mde.xmu2core.impl.CaseClauseImpl
		 * @see edu.ustb.sei.mde.xmu2core.impl.Xmu2corePackageImpl#getCaseClause()
		 * @generated
		 */
		EClass CASE_CLAUSE = eINSTANCE.getCaseClause();

		/**
		 * The meta object literal for the '<em><b>Action</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CASE_CLAUSE__ACTION = eINSTANCE.getCaseClause_Action();

		/**
		 * The meta object literal for the '{@link edu.ustb.sei.mde.xmu2core.impl.CasePatternClauseImpl <em>Case Pattern Clause</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.ustb.sei.mde.xmu2core.impl.CasePatternClauseImpl
		 * @see edu.ustb.sei.mde.xmu2core.impl.Xmu2corePackageImpl#getCasePatternClause()
		 * @generated
		 */
		EClass CASE_PATTERN_CLAUSE = eINSTANCE.getCasePatternClause();

		/**
		 * The meta object literal for the '<em><b>Condition</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CASE_PATTERN_CLAUSE__CONDITION = eINSTANCE.getCasePatternClause_Condition();

		/**
		 * The meta object literal for the '{@link edu.ustb.sei.mde.xmu2core.impl.CaseExpressionClauseImpl <em>Case Expression Clause</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.ustb.sei.mde.xmu2core.impl.CaseExpressionClauseImpl
		 * @see edu.ustb.sei.mde.xmu2core.impl.Xmu2corePackageImpl#getCaseExpressionClause()
		 * @generated
		 */
		EClass CASE_EXPRESSION_CLAUSE = eINSTANCE.getCaseExpressionClause();

		/**
		 * The meta object literal for the '<em><b>Condition</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CASE_EXPRESSION_CLAUSE__CONDITION = eINSTANCE.getCaseExpressionClause_Condition();

		/**
		 * The meta object literal for the '{@link edu.ustb.sei.mde.xmu2core.impl.CaseStatementClauseImpl <em>Case Statement Clause</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.ustb.sei.mde.xmu2core.impl.CaseStatementClauseImpl
		 * @see edu.ustb.sei.mde.xmu2core.impl.Xmu2corePackageImpl#getCaseStatementClause()
		 * @generated
		 */
		EClass CASE_STATEMENT_CLAUSE = eINSTANCE.getCaseStatementClause();

		/**
		 * The meta object literal for the '<em><b>Condition</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CASE_STATEMENT_CLAUSE__CONDITION = eINSTANCE.getCaseStatementClause_Condition();

		/**
		 * The meta object literal for the '{@link edu.ustb.sei.mde.xmu2core.impl.PatternImpl <em>Pattern</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.ustb.sei.mde.xmu2core.impl.PatternImpl
		 * @see edu.ustb.sei.mde.xmu2core.impl.Xmu2corePackageImpl#getPattern()
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
		 * The meta object literal for the '{@link edu.ustb.sei.mde.xmu2core.impl.PatternNodeImpl <em>Pattern Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.ustb.sei.mde.xmu2core.impl.PatternNodeImpl
		 * @see edu.ustb.sei.mde.xmu2core.impl.Xmu2corePackageImpl#getPatternNode()
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
		 * The meta object literal for the '<em><b>Expressions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PATTERN_NODE__EXPRESSIONS = eINSTANCE.getPatternNode_Expressions();

		/**
		 * The meta object literal for the '{@link edu.ustb.sei.mde.xmu2core.impl.PatternExpressionImpl <em>Pattern Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.ustb.sei.mde.xmu2core.impl.PatternExpressionImpl
		 * @see edu.ustb.sei.mde.xmu2core.impl.Xmu2corePackageImpl#getPatternExpression()
		 * @generated
		 */
		EClass PATTERN_EXPRESSION = eINSTANCE.getPatternExpression();

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
		 * The meta object literal for the '{@link edu.ustb.sei.mde.xmu2core.impl.ObjectPatternExpressionImpl <em>Object Pattern Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.ustb.sei.mde.xmu2core.impl.ObjectPatternExpressionImpl
		 * @see edu.ustb.sei.mde.xmu2core.impl.Xmu2corePackageImpl#getObjectPatternExpression()
		 * @generated
		 */
		EClass OBJECT_PATTERN_EXPRESSION = eINSTANCE.getObjectPatternExpression();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OBJECT_PATTERN_EXPRESSION__TARGET = eINSTANCE.getObjectPatternExpression_Target();

		/**
		 * The meta object literal for the '{@link edu.ustb.sei.mde.xmu2core.impl.PropertyPatternExpressionImpl <em>Property Pattern Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.ustb.sei.mde.xmu2core.impl.PropertyPatternExpressionImpl
		 * @see edu.ustb.sei.mde.xmu2core.impl.Xmu2corePackageImpl#getPropertyPatternExpression()
		 * @generated
		 */
		EClass PROPERTY_PATTERN_EXPRESSION = eINSTANCE.getPropertyPatternExpression();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROPERTY_PATTERN_EXPRESSION__TARGET = eINSTANCE.getPropertyPatternExpression_Target();

		/**
		 * The meta object literal for the '{@link edu.ustb.sei.mde.xmu2core.impl.ExpressionImpl <em>Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.ustb.sei.mde.xmu2core.impl.ExpressionImpl
		 * @see edu.ustb.sei.mde.xmu2core.impl.Xmu2corePackageImpl#getExpression()
		 * @generated
		 */
		EClass EXPRESSION = eINSTANCE.getExpression();

		/**
		 * The meta object literal for the '{@link edu.ustb.sei.mde.xmu2core.impl.BooleanOrExpressionImpl <em>Boolean Or Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.ustb.sei.mde.xmu2core.impl.BooleanOrExpressionImpl
		 * @see edu.ustb.sei.mde.xmu2core.impl.Xmu2corePackageImpl#getBooleanOrExpression()
		 * @generated
		 */
		EClass BOOLEAN_OR_EXPRESSION = eINSTANCE.getBooleanOrExpression();

		/**
		 * The meta object literal for the '<em><b>Operands</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BOOLEAN_OR_EXPRESSION__OPERANDS = eINSTANCE.getBooleanOrExpression_Operands();

		/**
		 * The meta object literal for the '{@link edu.ustb.sei.mde.xmu2core.impl.BooleanAndExpressionImpl <em>Boolean And Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.ustb.sei.mde.xmu2core.impl.BooleanAndExpressionImpl
		 * @see edu.ustb.sei.mde.xmu2core.impl.Xmu2corePackageImpl#getBooleanAndExpression()
		 * @generated
		 */
		EClass BOOLEAN_AND_EXPRESSION = eINSTANCE.getBooleanAndExpression();

		/**
		 * The meta object literal for the '<em><b>Operands</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BOOLEAN_AND_EXPRESSION__OPERANDS = eINSTANCE.getBooleanAndExpression_Operands();

		/**
		 * The meta object literal for the '{@link edu.ustb.sei.mde.xmu2core.impl.RelationalExpressionImpl <em>Relational Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.ustb.sei.mde.xmu2core.impl.RelationalExpressionImpl
		 * @see edu.ustb.sei.mde.xmu2core.impl.Xmu2corePackageImpl#getRelationalExpression()
		 * @generated
		 */
		EClass RELATIONAL_EXPRESSION = eINSTANCE.getRelationalExpression();

		/**
		 * The meta object literal for the '<em><b>Left</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RELATIONAL_EXPRESSION__LEFT = eINSTANCE.getRelationalExpression_Left();

		/**
		 * The meta object literal for the '<em><b>Right</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RELATIONAL_EXPRESSION__RIGHT = eINSTANCE.getRelationalExpression_Right();

		/**
		 * The meta object literal for the '<em><b>Operator</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RELATIONAL_EXPRESSION__OPERATOR = eINSTANCE.getRelationalExpression_Operator();

		/**
		 * The meta object literal for the '{@link edu.ustb.sei.mde.xmu2core.impl.AdditiveExpressionImpl <em>Additive Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.ustb.sei.mde.xmu2core.impl.AdditiveExpressionImpl
		 * @see edu.ustb.sei.mde.xmu2core.impl.Xmu2corePackageImpl#getAdditiveExpression()
		 * @generated
		 */
		EClass ADDITIVE_EXPRESSION = eINSTANCE.getAdditiveExpression();

		/**
		 * The meta object literal for the '<em><b>Operands</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ADDITIVE_EXPRESSION__OPERANDS = eINSTANCE.getAdditiveExpression_Operands();

		/**
		 * The meta object literal for the '<em><b>Operators</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ADDITIVE_EXPRESSION__OPERATORS = eINSTANCE.getAdditiveExpression_Operators();

		/**
		 * The meta object literal for the '{@link edu.ustb.sei.mde.xmu2core.impl.MultiplicativeExpressionImpl <em>Multiplicative Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.ustb.sei.mde.xmu2core.impl.MultiplicativeExpressionImpl
		 * @see edu.ustb.sei.mde.xmu2core.impl.Xmu2corePackageImpl#getMultiplicativeExpression()
		 * @generated
		 */
		EClass MULTIPLICATIVE_EXPRESSION = eINSTANCE.getMultiplicativeExpression();

		/**
		 * The meta object literal for the '<em><b>Operands</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MULTIPLICATIVE_EXPRESSION__OPERANDS = eINSTANCE.getMultiplicativeExpression_Operands();

		/**
		 * The meta object literal for the '<em><b>Operators</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MULTIPLICATIVE_EXPRESSION__OPERATORS = eINSTANCE.getMultiplicativeExpression_Operators();

		/**
		 * The meta object literal for the '{@link edu.ustb.sei.mde.xmu2core.impl.UnaryExpressionImpl <em>Unary Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.ustb.sei.mde.xmu2core.impl.UnaryExpressionImpl
		 * @see edu.ustb.sei.mde.xmu2core.impl.Xmu2corePackageImpl#getUnaryExpression()
		 * @generated
		 */
		EClass UNARY_EXPRESSION = eINSTANCE.getUnaryExpression();

		/**
		 * The meta object literal for the '<em><b>Body</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference UNARY_EXPRESSION__BODY = eINSTANCE.getUnaryExpression_Body();

		/**
		 * The meta object literal for the '<em><b>Operator</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute UNARY_EXPRESSION__OPERATOR = eINSTANCE.getUnaryExpression_Operator();

		/**
		 * The meta object literal for the '{@link edu.ustb.sei.mde.xmu2core.impl.AtomicExpressionImpl <em>Atomic Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.ustb.sei.mde.xmu2core.impl.AtomicExpressionImpl
		 * @see edu.ustb.sei.mde.xmu2core.impl.Xmu2corePackageImpl#getAtomicExpression()
		 * @generated
		 */
		EClass ATOMIC_EXPRESSION = eINSTANCE.getAtomicExpression();

		/**
		 * The meta object literal for the '<em><b>Paths</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ATOMIC_EXPRESSION__PATHS = eINSTANCE.getAtomicExpression_Paths();

		/**
		 * The meta object literal for the '{@link edu.ustb.sei.mde.xmu2core.impl.TypeCastExpressionImpl <em>Type Cast Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.ustb.sei.mde.xmu2core.impl.TypeCastExpressionImpl
		 * @see edu.ustb.sei.mde.xmu2core.impl.Xmu2corePackageImpl#getTypeCastExpression()
		 * @generated
		 */
		EClass TYPE_CAST_EXPRESSION = eINSTANCE.getTypeCastExpression();

		/**
		 * The meta object literal for the '<em><b>Target Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TYPE_CAST_EXPRESSION__TARGET_TYPE = eINSTANCE.getTypeCastExpression_TargetType();

		/**
		 * The meta object literal for the '<em><b>Body</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TYPE_CAST_EXPRESSION__BODY = eINSTANCE.getTypeCastExpression_Body();

		/**
		 * The meta object literal for the '<em><b>Source Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TYPE_CAST_EXPRESSION__SOURCE_TYPE = eINSTANCE.getTypeCastExpression_SourceType();

		/**
		 * The meta object literal for the '{@link edu.ustb.sei.mde.xmu2core.impl.PrimitiveValueExpressionImpl <em>Primitive Value Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.ustb.sei.mde.xmu2core.impl.PrimitiveValueExpressionImpl
		 * @see edu.ustb.sei.mde.xmu2core.impl.Xmu2corePackageImpl#getPrimitiveValueExpression()
		 * @generated
		 */
		EClass PRIMITIVE_VALUE_EXPRESSION = eINSTANCE.getPrimitiveValueExpression();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PRIMITIVE_VALUE_EXPRESSION__TYPE = eINSTANCE.getPrimitiveValueExpression_Type();

		/**
		 * The meta object literal for the '{@link edu.ustb.sei.mde.xmu2core.impl.StringValueExpressionImpl <em>String Value Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.ustb.sei.mde.xmu2core.impl.StringValueExpressionImpl
		 * @see edu.ustb.sei.mde.xmu2core.impl.Xmu2corePackageImpl#getStringValueExpression()
		 * @generated
		 */
		EClass STRING_VALUE_EXPRESSION = eINSTANCE.getStringValueExpression();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STRING_VALUE_EXPRESSION__VALUE = eINSTANCE.getStringValueExpression_Value();

		/**
		 * The meta object literal for the '{@link edu.ustb.sei.mde.xmu2core.impl.BooleanValueExpressionImpl <em>Boolean Value Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.ustb.sei.mde.xmu2core.impl.BooleanValueExpressionImpl
		 * @see edu.ustb.sei.mde.xmu2core.impl.Xmu2corePackageImpl#getBooleanValueExpression()
		 * @generated
		 */
		EClass BOOLEAN_VALUE_EXPRESSION = eINSTANCE.getBooleanValueExpression();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BOOLEAN_VALUE_EXPRESSION__VALUE = eINSTANCE.getBooleanValueExpression_Value();

		/**
		 * The meta object literal for the '{@link edu.ustb.sei.mde.xmu2core.impl.IntegerValueExpressionImpl <em>Integer Value Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.ustb.sei.mde.xmu2core.impl.IntegerValueExpressionImpl
		 * @see edu.ustb.sei.mde.xmu2core.impl.Xmu2corePackageImpl#getIntegerValueExpression()
		 * @generated
		 */
		EClass INTEGER_VALUE_EXPRESSION = eINSTANCE.getIntegerValueExpression();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INTEGER_VALUE_EXPRESSION__VALUE = eINSTANCE.getIntegerValueExpression_Value();

		/**
		 * The meta object literal for the '{@link edu.ustb.sei.mde.xmu2core.impl.EnumValueExpressionImpl <em>Enum Value Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.ustb.sei.mde.xmu2core.impl.EnumValueExpressionImpl
		 * @see edu.ustb.sei.mde.xmu2core.impl.Xmu2corePackageImpl#getEnumValueExpression()
		 * @generated
		 */
		EClass ENUM_VALUE_EXPRESSION = eINSTANCE.getEnumValueExpression();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ENUM_VALUE_EXPRESSION__VALUE = eINSTANCE.getEnumValueExpression_Value();

		/**
		 * The meta object literal for the '{@link edu.ustb.sei.mde.xmu2core.impl.EmptyValueExpressionImpl <em>Empty Value Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.ustb.sei.mde.xmu2core.impl.EmptyValueExpressionImpl
		 * @see edu.ustb.sei.mde.xmu2core.impl.Xmu2corePackageImpl#getEmptyValueExpression()
		 * @generated
		 */
		EClass EMPTY_VALUE_EXPRESSION = eINSTANCE.getEmptyValueExpression();

		/**
		 * The meta object literal for the '{@link edu.ustb.sei.mde.xmu2core.impl.ObjectValueExpressionImpl <em>Object Value Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.ustb.sei.mde.xmu2core.impl.ObjectValueExpressionImpl
		 * @see edu.ustb.sei.mde.xmu2core.impl.Xmu2corePackageImpl#getObjectValueExpression()
		 * @generated
		 */
		EClass OBJECT_VALUE_EXPRESSION = eINSTANCE.getObjectValueExpression();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OBJECT_VALUE_EXPRESSION__VALUE = eINSTANCE.getObjectValueExpression_Value();

		/**
		 * The meta object literal for the '{@link edu.ustb.sei.mde.xmu2core.impl.VariableExpressionImpl <em>Variable Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.ustb.sei.mde.xmu2core.impl.VariableExpressionImpl
		 * @see edu.ustb.sei.mde.xmu2core.impl.Xmu2corePackageImpl#getVariableExpression()
		 * @generated
		 */
		EClass VARIABLE_EXPRESSION = eINSTANCE.getVariableExpression();

		/**
		 * The meta object literal for the '<em><b>Variable</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VARIABLE_EXPRESSION__VARIABLE = eINSTANCE.getVariableExpression_Variable();

		/**
		 * The meta object literal for the '{@link edu.ustb.sei.mde.xmu2core.impl.PathImpl <em>Path</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.ustb.sei.mde.xmu2core.impl.PathImpl
		 * @see edu.ustb.sei.mde.xmu2core.impl.Xmu2corePackageImpl#getPath()
		 * @generated
		 */
		EClass PATH = eINSTANCE.getPath();

		/**
		 * The meta object literal for the '{@link edu.ustb.sei.mde.xmu2core.impl.FeaturePathImpl <em>Feature Path</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.ustb.sei.mde.xmu2core.impl.FeaturePathImpl
		 * @see edu.ustb.sei.mde.xmu2core.impl.Xmu2corePackageImpl#getFeaturePath()
		 * @generated
		 */
		EClass FEATURE_PATH = eINSTANCE.getFeaturePath();

		/**
		 * The meta object literal for the '<em><b>Feature</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FEATURE_PATH__FEATURE = eINSTANCE.getFeaturePath_Feature();

		/**
		 * The meta object literal for the '{@link edu.ustb.sei.mde.xmu2core.impl.OperationPathImpl <em>Operation Path</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.ustb.sei.mde.xmu2core.impl.OperationPathImpl
		 * @see edu.ustb.sei.mde.xmu2core.impl.Xmu2corePackageImpl#getOperationPath()
		 * @generated
		 */
		EClass OPERATION_PATH = eINSTANCE.getOperationPath();

		/**
		 * The meta object literal for the '<em><b>Parameters</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPERATION_PATH__PARAMETERS = eINSTANCE.getOperationPath_Parameters();

		/**
		 * The meta object literal for the '<em><b>Operation</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OPERATION_PATH__OPERATION = eINSTANCE.getOperationPath_Operation();

		/**
		 * The meta object literal for the '{@link edu.ustb.sei.mde.xmu2core.impl.LoopPathImpl <em>Loop Path</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.ustb.sei.mde.xmu2core.impl.LoopPathImpl
		 * @see edu.ustb.sei.mde.xmu2core.impl.Xmu2corePackageImpl#getLoopPath()
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
		 * The meta object literal for the '<em><b>Iterator</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LOOP_PATH__ITERATOR = eINSTANCE.getLoopPath_Iterator();

		/**
		 * The meta object literal for the '<em><b>Body</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LOOP_PATH__BODY = eINSTANCE.getLoopPath_Body();

		/**
		 * The meta object literal for the '{@link edu.ustb.sei.mde.xmu2core.impl.PositionPathImpl <em>Position Path</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.ustb.sei.mde.xmu2core.impl.PositionPathImpl
		 * @see edu.ustb.sei.mde.xmu2core.impl.Xmu2corePackageImpl#getPositionPath()
		 * @generated
		 */
		EClass POSITION_PATH = eINSTANCE.getPositionPath();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference POSITION_PATH__VALUE = eINSTANCE.getPositionPath_Value();

		/**
		 * The meta object literal for the '<em><b>Operator</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute POSITION_PATH__OPERATOR = eINSTANCE.getPositionPath_Operator();

		/**
		 * The meta object literal for the '{@link edu.ustb.sei.mde.xmu2core.impl.CallStatementImpl <em>Call Statement</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.ustb.sei.mde.xmu2core.impl.CallStatementImpl
		 * @see edu.ustb.sei.mde.xmu2core.impl.Xmu2corePackageImpl#getCallStatement()
		 * @generated
		 */
		EClass CALL_STATEMENT = eINSTANCE.getCallStatement();

		/**
		 * The meta object literal for the '<em><b>Callable</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CALL_STATEMENT__CALLABLE = eINSTANCE.getCallStatement_Callable();

		/**
		 * The meta object literal for the '<em><b>Parameters</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CALL_STATEMENT__PARAMETERS = eINSTANCE.getCallStatement_Parameters();

		/**
		 * The meta object literal for the '<em><b>Updated Parameters</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CALL_STATEMENT__UPDATED_PARAMETERS = eINSTANCE.getCallStatement_UpdatedParameters();

		/**
		 * The meta object literal for the '{@link edu.ustb.sei.mde.xmu2core.impl.TransformationImpl <em>Transformation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.ustb.sei.mde.xmu2core.impl.TransformationImpl
		 * @see edu.ustb.sei.mde.xmu2core.impl.Xmu2corePackageImpl#getTransformation()
		 * @generated
		 */
		EClass TRANSFORMATION = eINSTANCE.getTransformation();

		/**
		 * The meta object literal for the '<em><b>Callables</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRANSFORMATION__CALLABLES = eINSTANCE.getTransformation_Callables();

		/**
		 * The meta object literal for the '<em><b>Declared Types</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRANSFORMATION__DECLARED_TYPES = eINSTANCE.getTransformation_DeclaredTypes();

		/**
		 * The meta object literal for the '<em><b>Entry Rules</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRANSFORMATION__ENTRY_RULES = eINSTANCE.getTransformation_EntryRules();

		/**
		 * The meta object literal for the '<em><b>Packages</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRANSFORMATION__PACKAGES = eINSTANCE.getTransformation_Packages();

		/**
		 * The meta object literal for the '{@link edu.ustb.sei.mde.xmu2core.impl.EntryRuleParameterImpl <em>Entry Rule Parameter</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.ustb.sei.mde.xmu2core.impl.EntryRuleParameterImpl
		 * @see edu.ustb.sei.mde.xmu2core.impl.Xmu2corePackageImpl#getEntryRuleParameter()
		 * @generated
		 */
		EClass ENTRY_RULE_PARAMETER = eINSTANCE.getEntryRuleParameter();

		/**
		 * The meta object literal for the '<em><b>Index</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ENTRY_RULE_PARAMETER__INDEX = eINSTANCE.getEntryRuleParameter_Index();

		/**
		 * The meta object literal for the '<em><b>Fragment</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ENTRY_RULE_PARAMETER__FRAGMENT = eINSTANCE.getEntryRuleParameter_Fragment();

		/**
		 * The meta object literal for the '{@link edu.ustb.sei.mde.xmu2core.impl.ForEachStatementImpl <em>For Each Statement</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.ustb.sei.mde.xmu2core.impl.ForEachStatementImpl
		 * @see edu.ustb.sei.mde.xmu2core.impl.Xmu2corePackageImpl#getForEachStatement()
		 * @generated
		 */
		EClass FOR_EACH_STATEMENT = eINSTANCE.getForEachStatement();

		/**
		 * The meta object literal for the '<em><b>Pattern</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FOR_EACH_STATEMENT__PATTERN = eINSTANCE.getForEachStatement_Pattern();

		/**
		 * The meta object literal for the '<em><b>Action</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FOR_EACH_STATEMENT__ACTION = eINSTANCE.getForEachStatement_Action();

		/**
		 * The meta object literal for the '<em><b>Derived</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FOR_EACH_STATEMENT__DERIVED = eINSTANCE.getForEachStatement_Derived();

		/**
		 * The meta object literal for the '{@link edu.ustb.sei.mde.xmu2core.impl.DeleteNodeStatementImpl <em>Delete Node Statement</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.ustb.sei.mde.xmu2core.impl.DeleteNodeStatementImpl
		 * @see edu.ustb.sei.mde.xmu2core.impl.Xmu2corePackageImpl#getDeleteNodeStatement()
		 * @generated
		 */
		EClass DELETE_NODE_STATEMENT = eINSTANCE.getDeleteNodeStatement();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DELETE_NODE_STATEMENT__TARGET = eINSTANCE.getDeleteNodeStatement_Target();

		/**
		 * The meta object literal for the '{@link edu.ustb.sei.mde.xmu2core.impl.DeleteLinkStatementImpl <em>Delete Link Statement</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.ustb.sei.mde.xmu2core.impl.DeleteLinkStatementImpl
		 * @see edu.ustb.sei.mde.xmu2core.impl.Xmu2corePackageImpl#getDeleteLinkStatement()
		 * @generated
		 */
		EClass DELETE_LINK_STATEMENT = eINSTANCE.getDeleteLinkStatement();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DELETE_LINK_STATEMENT__TARGET = eINSTANCE.getDeleteLinkStatement_Target();

		/**
		 * The meta object literal for the '<em><b>Source</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DELETE_LINK_STATEMENT__SOURCE = eINSTANCE.getDeleteLinkStatement_Source();

		/**
		 * The meta object literal for the '<em><b>Feature</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DELETE_LINK_STATEMENT__FEATURE = eINSTANCE.getDeleteLinkStatement_Feature();

		/**
		 * The meta object literal for the '{@link edu.ustb.sei.mde.xmu2core.impl.EnforceNodeStatementImpl <em>Enforce Node Statement</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.ustb.sei.mde.xmu2core.impl.EnforceNodeStatementImpl
		 * @see edu.ustb.sei.mde.xmu2core.impl.Xmu2corePackageImpl#getEnforceNodeStatement()
		 * @generated
		 */
		EClass ENFORCE_NODE_STATEMENT = eINSTANCE.getEnforceNodeStatement();

		/**
		 * The meta object literal for the '<em><b>Node</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ENFORCE_NODE_STATEMENT__NODE = eINSTANCE.getEnforceNodeStatement_Node();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ENFORCE_NODE_STATEMENT__TYPE = eINSTANCE.getEnforceNodeStatement_Type();

		/**
		 * The meta object literal for the '<em><b>Candidate</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ENFORCE_NODE_STATEMENT__CANDIDATE = eINSTANCE.getEnforceNodeStatement_Candidate();

		/**
		 * The meta object literal for the '{@link edu.ustb.sei.mde.xmu2core.impl.EnforceLinkStatementImpl <em>Enforce Link Statement</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.ustb.sei.mde.xmu2core.impl.EnforceLinkStatementImpl
		 * @see edu.ustb.sei.mde.xmu2core.impl.Xmu2corePackageImpl#getEnforceLinkStatement()
		 * @generated
		 */
		EClass ENFORCE_LINK_STATEMENT = eINSTANCE.getEnforceLinkStatement();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ENFORCE_LINK_STATEMENT__TARGET = eINSTANCE.getEnforceLinkStatement_Target();

		/**
		 * The meta object literal for the '<em><b>Source</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ENFORCE_LINK_STATEMENT__SOURCE = eINSTANCE.getEnforceLinkStatement_Source();

		/**
		 * The meta object literal for the '<em><b>Feature</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ENFORCE_LINK_STATEMENT__FEATURE = eINSTANCE.getEnforceLinkStatement_Feature();

		/**
		 * The meta object literal for the '<em><b>Selector</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ENFORCE_LINK_STATEMENT__SELECTOR = eINSTANCE.getEnforceLinkStatement_Selector();

		/**
		 * The meta object literal for the '<em><b>Position</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ENFORCE_LINK_STATEMENT__POSITION = eINSTANCE.getEnforceLinkStatement_Position();

		/**
		 * The meta object literal for the '<em><b>Source Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ENFORCE_LINK_STATEMENT__SOURCE_TYPE = eINSTANCE.getEnforceLinkStatement_SourceType();

		/**
		 * The meta object literal for the '{@link edu.ustb.sei.mde.xmu2core.impl.OclCollectionTypeImpl <em>Ocl Collection Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.ustb.sei.mde.xmu2core.impl.OclCollectionTypeImpl
		 * @see edu.ustb.sei.mde.xmu2core.impl.Xmu2corePackageImpl#getOclCollectionType()
		 * @generated
		 */
		EClass OCL_COLLECTION_TYPE = eINSTANCE.getOclCollectionType();

		/**
		 * The meta object literal for the '<em><b>Elementtype</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OCL_COLLECTION_TYPE__ELEMENTTYPE = eINSTANCE.getOclCollectionType_Elementtype();

		/**
		 * The meta object literal for the '{@link edu.ustb.sei.mde.xmu2core.impl.OclCollectionImpl <em>Ocl Collection</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.ustb.sei.mde.xmu2core.impl.OclCollectionImpl
		 * @see edu.ustb.sei.mde.xmu2core.impl.Xmu2corePackageImpl#getOclCollection()
		 * @generated
		 */
		EClass OCL_COLLECTION = eINSTANCE.getOclCollection();

		/**
		 * The meta object literal for the '<em><b>Element Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OCL_COLLECTION__ELEMENT_TYPE = eINSTANCE.getOclCollection_ElementType();

		/**
		 * The meta object literal for the '{@link edu.ustb.sei.mde.xmu2core.impl.MatchPatternImpl <em>Match Pattern</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.ustb.sei.mde.xmu2core.impl.MatchPatternImpl
		 * @see edu.ustb.sei.mde.xmu2core.impl.Xmu2corePackageImpl#getMatchPattern()
		 * @generated
		 */
		EClass MATCH_PATTERN = eINSTANCE.getMatchPattern();

		/**
		 * The meta object literal for the '<em><b>Pattern</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MATCH_PATTERN__PATTERN = eINSTANCE.getMatchPattern_Pattern();

		/**
		 * The meta object literal for the '{@link edu.ustb.sei.mde.xmu2core.impl.CheckExpressionStatementImpl <em>Check Expression Statement</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.ustb.sei.mde.xmu2core.impl.CheckExpressionStatementImpl
		 * @see edu.ustb.sei.mde.xmu2core.impl.Xmu2corePackageImpl#getCheckExpressionStatement()
		 * @generated
		 */
		EClass CHECK_EXPRESSION_STATEMENT = eINSTANCE.getCheckExpressionStatement();

		/**
		 * The meta object literal for the '<em><b>Expression</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CHECK_EXPRESSION_STATEMENT__EXPRESSION = eINSTANCE.getCheckExpressionStatement_Expression();

		/**
		 * The meta object literal for the '{@link edu.ustb.sei.mde.xmu2core.impl.EnforceExpressionStatementImpl <em>Enforce Expression Statement</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.ustb.sei.mde.xmu2core.impl.EnforceExpressionStatementImpl
		 * @see edu.ustb.sei.mde.xmu2core.impl.Xmu2corePackageImpl#getEnforceExpressionStatement()
		 * @generated
		 */
		EClass ENFORCE_EXPRESSION_STATEMENT = eINSTANCE.getEnforceExpressionStatement();

		/**
		 * The meta object literal for the '<em><b>Expression</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ENFORCE_EXPRESSION_STATEMENT__EXPRESSION = eINSTANCE.getEnforceExpressionStatement_Expression();

		/**
		 * The meta object literal for the '{@link edu.ustb.sei.mde.xmu2core.impl.FunctionImpl <em>Function</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.ustb.sei.mde.xmu2core.impl.FunctionImpl
		 * @see edu.ustb.sei.mde.xmu2core.impl.Xmu2corePackageImpl#getFunction()
		 * @generated
		 */
		EClass FUNCTION = eINSTANCE.getFunction();

		/**
		 * The meta object literal for the '<em><b>Backward Statements</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FUNCTION__BACKWARD_STATEMENTS = eINSTANCE.getFunction_BackwardStatements();

		/**
		 * The meta object literal for the '<em><b>Forward Statements</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FUNCTION__FORWARD_STATEMENTS = eINSTANCE.getFunction_ForwardStatements();

		/**
		 * The meta object literal for the '{@link edu.ustb.sei.mde.xmu2core.impl.SolveConstraintStatementImpl <em>Solve Constraint Statement</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.ustb.sei.mde.xmu2core.impl.SolveConstraintStatementImpl
		 * @see edu.ustb.sei.mde.xmu2core.impl.Xmu2corePackageImpl#getSolveConstraintStatement()
		 * @generated
		 */
		EClass SOLVE_CONSTRAINT_STATEMENT = eINSTANCE.getSolveConstraintStatement();

		/**
		 * The meta object literal for the '<em><b>Variables</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SOLVE_CONSTRAINT_STATEMENT__VARIABLES = eINSTANCE.getSolveConstraintStatement_Variables();

		/**
		 * The meta object literal for the '<em><b>Constraint</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SOLVE_CONSTRAINT_STATEMENT__CONSTRAINT = eINSTANCE.getSolveConstraintStatement_Constraint();

		/**
		 * The meta object literal for the '{@link edu.ustb.sei.mde.xmu2core.impl.CommandStatementImpl <em>Command Statement</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.ustb.sei.mde.xmu2core.impl.CommandStatementImpl
		 * @see edu.ustb.sei.mde.xmu2core.impl.Xmu2corePackageImpl#getCommandStatement()
		 * @generated
		 */
		EClass COMMAND_STATEMENT = eINSTANCE.getCommandStatement();

		/**
		 * The meta object literal for the '<em><b>Parameters</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMMAND_STATEMENT__PARAMETERS = eINSTANCE.getCommandStatement_Parameters();

		/**
		 * The meta object literal for the '<em><b>Actions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMMAND_STATEMENT__ACTIONS = eINSTANCE.getCommandStatement_Actions();

		/**
		 * The meta object literal for the '<em><b>Command</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COMMAND_STATEMENT__COMMAND = eINSTANCE.getCommandStatement_Command();

		/**
		 * The meta object literal for the '{@link edu.ustb.sei.mde.xmu2core.impl.ReflectiveSupportImpl <em>Reflective Support</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.ustb.sei.mde.xmu2core.impl.ReflectiveSupportImpl
		 * @see edu.ustb.sei.mde.xmu2core.impl.Xmu2corePackageImpl#getReflectiveSupport()
		 * @generated
		 */
		EClass REFLECTIVE_SUPPORT = eINSTANCE.getReflectiveSupport();

		/**
		 * The meta object literal for the '<em><b>Reflective Identifier</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REFLECTIVE_SUPPORT__REFLECTIVE_IDENTIFIER = eINSTANCE.getReflectiveSupport_ReflectiveIdentifier();

		/**
		 * The meta object literal for the '<em><b>Reflective</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REFLECTIVE_SUPPORT__REFLECTIVE = eINSTANCE.getReflectiveSupport_Reflective();

		/**
		 * The meta object literal for the '<em><b>Resolve</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REFLECTIVE_SUPPORT__RESOLVE = eINSTANCE.getReflectiveSupport_Resolve();

		/**
		 * The meta object literal for the '{@link edu.ustb.sei.mde.xmu2core.impl.TupleExpressionImpl <em>Tuple Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.ustb.sei.mde.xmu2core.impl.TupleExpressionImpl
		 * @see edu.ustb.sei.mde.xmu2core.impl.Xmu2corePackageImpl#getTupleExpression()
		 * @generated
		 */
		EClass TUPLE_EXPRESSION = eINSTANCE.getTupleExpression();

		/**
		 * The meta object literal for the '<em><b>Tuples</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TUPLE_EXPRESSION__TUPLES = eINSTANCE.getTupleExpression_Tuples();

		/**
		 * The meta object literal for the '<em>Null</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.lang.Object
		 * @see edu.ustb.sei.mde.xmu2core.impl.Xmu2corePackageImpl#getNull()
		 * @generated
		 */
		EDataType NULL = eINSTANCE.getNull();

		/**
		 * The meta object literal for the '<em>Undefined</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.lang.Object
		 * @see edu.ustb.sei.mde.xmu2core.impl.Xmu2corePackageImpl#getUndefined()
		 * @generated
		 */
		EDataType UNDEFINED = eINSTANCE.getUndefined();

	}

} //Xmu2corePackage
