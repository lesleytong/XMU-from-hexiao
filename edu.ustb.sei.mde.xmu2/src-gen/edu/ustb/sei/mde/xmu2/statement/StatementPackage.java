/**
 */
package edu.ustb.sei.mde.xmu2.statement;

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
 * @see edu.ustb.sei.mde.xmu2.statement.StatementFactory
 * @model kind="package"
 * @generated
 */
public interface StatementPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "statement";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.ustb.edu.cn/sei/mde/xmu2/statement";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "statement";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	StatementPackage eINSTANCE = edu.ustb.sei.mde.xmu2.statement.impl.StatementPackageImpl.init();

	/**
	 * The meta object id for the '{@link edu.ustb.sei.mde.xmu2.statement.impl.StatementImpl <em>Statement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.ustb.sei.mde.xmu2.statement.impl.StatementImpl
	 * @see edu.ustb.sei.mde.xmu2.statement.impl.StatementPackageImpl#getStatement()
	 * @generated
	 */
	int STATEMENT = 0;

	/**
	 * The number of structural features of the '<em>Statement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATEMENT_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link edu.ustb.sei.mde.xmu2.statement.impl.BidirectionalStatementImpl <em>Bidirectional Statement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.ustb.sei.mde.xmu2.statement.impl.BidirectionalStatementImpl
	 * @see edu.ustb.sei.mde.xmu2.statement.impl.StatementPackageImpl#getBidirectionalStatement()
	 * @generated
	 */
	int BIDIRECTIONAL_STATEMENT = 10;

	/**
	 * The number of structural features of the '<em>Bidirectional Statement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BIDIRECTIONAL_STATEMENT_FEATURE_COUNT = STATEMENT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.ustb.sei.mde.xmu2.statement.impl.UpdateStatementImpl <em>Update Statement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.ustb.sei.mde.xmu2.statement.impl.UpdateStatementImpl
	 * @see edu.ustb.sei.mde.xmu2.statement.impl.StatementPackageImpl#getUpdateStatement()
	 * @generated
	 */
	int UPDATE_STATEMENT = 1;

	/**
	 * The feature id for the '<em><b>Source</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UPDATE_STATEMENT__SOURCE = BIDIRECTIONAL_STATEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>View</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UPDATE_STATEMENT__VIEW = BIDIRECTIONAL_STATEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Clauses</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UPDATE_STATEMENT__CLAUSES = BIDIRECTIONAL_STATEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Update Statement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UPDATE_STATEMENT_FEATURE_COUNT = BIDIRECTIONAL_STATEMENT_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link edu.ustb.sei.mde.xmu2.statement.impl.SwitchStatementImpl <em>Switch Statement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.ustb.sei.mde.xmu2.statement.impl.SwitchStatementImpl
	 * @see edu.ustb.sei.mde.xmu2.statement.impl.StatementPackageImpl#getSwitchStatement()
	 * @generated
	 */
	int SWITCH_STATEMENT = 2;

	/**
	 * The feature id for the '<em><b>Root</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SWITCH_STATEMENT__ROOT = BIDIRECTIONAL_STATEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Cases</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SWITCH_STATEMENT__CASES = BIDIRECTIONAL_STATEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Switch Statement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SWITCH_STATEMENT_FEATURE_COUNT = BIDIRECTIONAL_STATEMENT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link edu.ustb.sei.mde.xmu2.statement.impl.UpdateClauseImpl <em>Update Clause</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.ustb.sei.mde.xmu2.statement.impl.UpdateClauseImpl
	 * @see edu.ustb.sei.mde.xmu2.statement.impl.StatementPackageImpl#getUpdateClause()
	 * @generated
	 */
	int UPDATE_CLAUSE = 3;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UPDATE_CLAUSE__TYPE = 0;

	/**
	 * The feature id for the '<em><b>Statement</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UPDATE_CLAUSE__STATEMENT = 1;

	/**
	 * The number of structural features of the '<em>Update Clause</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UPDATE_CLAUSE_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link edu.ustb.sei.mde.xmu2.statement.impl.CaseClauseImpl <em>Case Clause</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.ustb.sei.mde.xmu2.statement.impl.CaseClauseImpl
	 * @see edu.ustb.sei.mde.xmu2.statement.impl.StatementPackageImpl#getCaseClause()
	 * @generated
	 */
	int CASE_CLAUSE = 4;

	/**
	 * The feature id for the '<em><b>Action</b></em>' containment reference.
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
	 * The meta object id for the '{@link edu.ustb.sei.mde.xmu2.statement.impl.PatternCaseClauseImpl <em>Pattern Case Clause</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.ustb.sei.mde.xmu2.statement.impl.PatternCaseClauseImpl
	 * @see edu.ustb.sei.mde.xmu2.statement.impl.StatementPackageImpl#getPatternCaseClause()
	 * @generated
	 */
	int PATTERN_CASE_CLAUSE = 5;

	/**
	 * The feature id for the '<em><b>Action</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN_CASE_CLAUSE__ACTION = CASE_CLAUSE__ACTION;

	/**
	 * The feature id for the '<em><b>Condition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN_CASE_CLAUSE__CONDITION = CASE_CLAUSE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Pattern Case Clause</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN_CASE_CLAUSE_FEATURE_COUNT = CASE_CLAUSE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link edu.ustb.sei.mde.xmu2.statement.impl.ExpressionCaseClauseImpl <em>Expression Case Clause</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.ustb.sei.mde.xmu2.statement.impl.ExpressionCaseClauseImpl
	 * @see edu.ustb.sei.mde.xmu2.statement.impl.StatementPackageImpl#getExpressionCaseClause()
	 * @generated
	 */
	int EXPRESSION_CASE_CLAUSE = 6;

	/**
	 * The feature id for the '<em><b>Action</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION_CASE_CLAUSE__ACTION = CASE_CLAUSE__ACTION;

	/**
	 * The feature id for the '<em><b>Condition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION_CASE_CLAUSE__CONDITION = CASE_CLAUSE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Expression Case Clause</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION_CASE_CLAUSE_FEATURE_COUNT = CASE_CLAUSE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link edu.ustb.sei.mde.xmu2.statement.impl.DefaultCaseClauseImpl <em>Default Case Clause</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.ustb.sei.mde.xmu2.statement.impl.DefaultCaseClauseImpl
	 * @see edu.ustb.sei.mde.xmu2.statement.impl.StatementPackageImpl#getDefaultCaseClause()
	 * @generated
	 */
	int DEFAULT_CASE_CLAUSE = 7;

	/**
	 * The feature id for the '<em><b>Action</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEFAULT_CASE_CLAUSE__ACTION = CASE_CLAUSE__ACTION;

	/**
	 * The number of structural features of the '<em>Default Case Clause</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEFAULT_CASE_CLAUSE_FEATURE_COUNT = CASE_CLAUSE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.ustb.sei.mde.xmu2.statement.impl.DefaultCaseStatementImpl <em>Default Case Statement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.ustb.sei.mde.xmu2.statement.impl.DefaultCaseStatementImpl
	 * @see edu.ustb.sei.mde.xmu2.statement.impl.StatementPackageImpl#getDefaultCaseStatement()
	 * @generated
	 */
	int DEFAULT_CASE_STATEMENT = 8;

	/**
	 * The feature id for the '<em><b>Action</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEFAULT_CASE_STATEMENT__ACTION = CASE_CLAUSE__ACTION;

	/**
	 * The number of structural features of the '<em>Default Case Statement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEFAULT_CASE_STATEMENT_FEATURE_COUNT = CASE_CLAUSE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.ustb.sei.mde.xmu2.statement.impl.UnidirectionalStatementImpl <em>Unidirectional Statement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.ustb.sei.mde.xmu2.statement.impl.UnidirectionalStatementImpl
	 * @see edu.ustb.sei.mde.xmu2.statement.impl.StatementPackageImpl#getUnidirectionalStatement()
	 * @generated
	 */
	int UNIDIRECTIONAL_STATEMENT = 9;

	/**
	 * The number of structural features of the '<em>Unidirectional Statement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIDIRECTIONAL_STATEMENT_FEATURE_COUNT = STATEMENT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.ustb.sei.mde.xmu2.statement.impl.EnforcePatternStatementImpl <em>Enforce Pattern Statement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.ustb.sei.mde.xmu2.statement.impl.EnforcePatternStatementImpl
	 * @see edu.ustb.sei.mde.xmu2.statement.impl.StatementPackageImpl#getEnforcePatternStatement()
	 * @generated
	 */
	int ENFORCE_PATTERN_STATEMENT = 11;

	/**
	 * The feature id for the '<em><b>Pattern</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENFORCE_PATTERN_STATEMENT__PATTERN = UNIDIRECTIONAL_STATEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Enforce Pattern Statement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENFORCE_PATTERN_STATEMENT_FEATURE_COUNT = UNIDIRECTIONAL_STATEMENT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link edu.ustb.sei.mde.xmu2.statement.impl.DeleteNodeStatementImpl <em>Delete Node Statement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.ustb.sei.mde.xmu2.statement.impl.DeleteNodeStatementImpl
	 * @see edu.ustb.sei.mde.xmu2.statement.impl.StatementPackageImpl#getDeleteNodeStatement()
	 * @generated
	 */
	int DELETE_NODE_STATEMENT = 12;

	/**
	 * The feature id for the '<em><b>Node</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DELETE_NODE_STATEMENT__NODE = UNIDIRECTIONAL_STATEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Delete Node Statement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DELETE_NODE_STATEMENT_FEATURE_COUNT = UNIDIRECTIONAL_STATEMENT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link edu.ustb.sei.mde.xmu2.statement.impl.DeleteLinkStatementImpl <em>Delete Link Statement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.ustb.sei.mde.xmu2.statement.impl.DeleteLinkStatementImpl
	 * @see edu.ustb.sei.mde.xmu2.statement.impl.StatementPackageImpl#getDeleteLinkStatement()
	 * @generated
	 */
	int DELETE_LINK_STATEMENT = 13;

	/**
	 * The feature id for the '<em><b>Source</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DELETE_LINK_STATEMENT__SOURCE = UNIDIRECTIONAL_STATEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Target</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DELETE_LINK_STATEMENT__TARGET = UNIDIRECTIONAL_STATEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Feature</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DELETE_LINK_STATEMENT__FEATURE = UNIDIRECTIONAL_STATEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Delete Link Statement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DELETE_LINK_STATEMENT_FEATURE_COUNT = UNIDIRECTIONAL_STATEMENT_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link edu.ustb.sei.mde.xmu2.statement.impl.ConcreteDeleteLinkStatementImpl <em>Concrete Delete Link Statement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.ustb.sei.mde.xmu2.statement.impl.ConcreteDeleteLinkStatementImpl
	 * @see edu.ustb.sei.mde.xmu2.statement.impl.StatementPackageImpl#getConcreteDeleteLinkStatement()
	 * @generated
	 */
	int CONCRETE_DELETE_LINK_STATEMENT = 14;

	/**
	 * The feature id for the '<em><b>Source</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCRETE_DELETE_LINK_STATEMENT__SOURCE = DELETE_LINK_STATEMENT__SOURCE;

	/**
	 * The feature id for the '<em><b>Target</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCRETE_DELETE_LINK_STATEMENT__TARGET = DELETE_LINK_STATEMENT__TARGET;

	/**
	 * The feature id for the '<em><b>Feature</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCRETE_DELETE_LINK_STATEMENT__FEATURE = DELETE_LINK_STATEMENT__FEATURE;

	/**
	 * The number of structural features of the '<em>Concrete Delete Link Statement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCRETE_DELETE_LINK_STATEMENT_FEATURE_COUNT = DELETE_LINK_STATEMENT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.ustb.sei.mde.xmu2.statement.impl.ReflectiveDeleteLinkStatementImpl <em>Reflective Delete Link Statement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.ustb.sei.mde.xmu2.statement.impl.ReflectiveDeleteLinkStatementImpl
	 * @see edu.ustb.sei.mde.xmu2.statement.impl.StatementPackageImpl#getReflectiveDeleteLinkStatement()
	 * @generated
	 */
	int REFLECTIVE_DELETE_LINK_STATEMENT = 15;

	/**
	 * The feature id for the '<em><b>Source</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFLECTIVE_DELETE_LINK_STATEMENT__SOURCE = DELETE_LINK_STATEMENT__SOURCE;

	/**
	 * The feature id for the '<em><b>Target</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFLECTIVE_DELETE_LINK_STATEMENT__TARGET = DELETE_LINK_STATEMENT__TARGET;

	/**
	 * The feature id for the '<em><b>Feature</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFLECTIVE_DELETE_LINK_STATEMENT__FEATURE = DELETE_LINK_STATEMENT__FEATURE;

	/**
	 * The feature id for the '<em><b>Reflective Identifier</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFLECTIVE_DELETE_LINK_STATEMENT__REFLECTIVE_IDENTIFIER = DELETE_LINK_STATEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Reflective Delete Link Statement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFLECTIVE_DELETE_LINK_STATEMENT_FEATURE_COUNT = DELETE_LINK_STATEMENT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link edu.ustb.sei.mde.xmu2.statement.impl.ForEachStatementImpl <em>For Each Statement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.ustb.sei.mde.xmu2.statement.impl.ForEachStatementImpl
	 * @see edu.ustb.sei.mde.xmu2.statement.impl.StatementPackageImpl#getForEachStatement()
	 * @generated
	 */
	int FOR_EACH_STATEMENT = 16;

	/**
	 * The feature id for the '<em><b>Pattern</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOR_EACH_STATEMENT__PATTERN = UNIDIRECTIONAL_STATEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Action</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOR_EACH_STATEMENT__ACTION = UNIDIRECTIONAL_STATEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>For Each Statement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOR_EACH_STATEMENT_FEATURE_COUNT = UNIDIRECTIONAL_STATEMENT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link edu.ustb.sei.mde.xmu2.statement.impl.BlockStatementImpl <em>Block Statement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.ustb.sei.mde.xmu2.statement.impl.BlockStatementImpl
	 * @see edu.ustb.sei.mde.xmu2.statement.impl.StatementPackageImpl#getBlockStatement()
	 * @generated
	 */
	int BLOCK_STATEMENT = 17;

	/**
	 * The feature id for the '<em><b>Body</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLOCK_STATEMENT__BODY = STATEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Block Statement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLOCK_STATEMENT_FEATURE_COUNT = STATEMENT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link edu.ustb.sei.mde.xmu2.statement.impl.RuleCallStatementImpl <em>Rule Call Statement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.ustb.sei.mde.xmu2.statement.impl.RuleCallStatementImpl
	 * @see edu.ustb.sei.mde.xmu2.statement.impl.StatementPackageImpl#getRuleCallStatement()
	 * @generated
	 */
	int RULE_CALL_STATEMENT = 18;

	/**
	 * The feature id for the '<em><b>Rule</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE_CALL_STATEMENT__RULE = BIDIRECTIONAL_STATEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE_CALL_STATEMENT__PARAMETERS = BIDIRECTIONAL_STATEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Rule Call Statement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE_CALL_STATEMENT_FEATURE_COUNT = BIDIRECTIONAL_STATEMENT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link edu.ustb.sei.mde.xmu2.statement.impl.PsesudoStatementImpl <em>Psesudo Statement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.ustb.sei.mde.xmu2.statement.impl.PsesudoStatementImpl
	 * @see edu.ustb.sei.mde.xmu2.statement.impl.StatementPackageImpl#getPsesudoStatement()
	 * @generated
	 */
	int PSESUDO_STATEMENT = 19;

	/**
	 * The number of structural features of the '<em>Psesudo Statement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PSESUDO_STATEMENT_FEATURE_COUNT = STATEMENT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.ustb.sei.mde.xmu2.statement.impl.FailImpl <em>Fail</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.ustb.sei.mde.xmu2.statement.impl.FailImpl
	 * @see edu.ustb.sei.mde.xmu2.statement.impl.StatementPackageImpl#getFail()
	 * @generated
	 */
	int FAIL = 20;

	/**
	 * The feature id for the '<em><b>Message</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FAIL__MESSAGE = PSESUDO_STATEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Fail</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FAIL_FEATURE_COUNT = PSESUDO_STATEMENT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link edu.ustb.sei.mde.xmu2.statement.impl.SkipImpl <em>Skip</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.ustb.sei.mde.xmu2.statement.impl.SkipImpl
	 * @see edu.ustb.sei.mde.xmu2.statement.impl.StatementPackageImpl#getSkip()
	 * @generated
	 */
	int SKIP = 21;

	/**
	 * The number of structural features of the '<em>Skip</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SKIP_FEATURE_COUNT = PSESUDO_STATEMENT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.ustb.sei.mde.xmu2.statement.impl.AssignStatementImpl <em>Assign Statement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.ustb.sei.mde.xmu2.statement.impl.AssignStatementImpl
	 * @see edu.ustb.sei.mde.xmu2.statement.impl.StatementPackageImpl#getAssignStatement()
	 * @generated
	 */
	int ASSIGN_STATEMENT = 22;

	/**
	 * The feature id for the '<em><b>Updated Variable</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSIGN_STATEMENT__UPDATED_VARIABLE = STATEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSIGN_STATEMENT__VALUE = STATEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Assign Statement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSIGN_STATEMENT_FEATURE_COUNT = STATEMENT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link edu.ustb.sei.mde.xmu2.statement.ActionType <em>Action Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.ustb.sei.mde.xmu2.statement.ActionType
	 * @see edu.ustb.sei.mde.xmu2.statement.impl.StatementPackageImpl#getActionType()
	 * @generated
	 */
	int ACTION_TYPE = 23;


	/**
	 * Returns the meta object for class '{@link edu.ustb.sei.mde.xmu2.statement.Statement <em>Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Statement</em>'.
	 * @see edu.ustb.sei.mde.xmu2.statement.Statement
	 * @generated
	 */
	EClass getStatement();

	/**
	 * Returns the meta object for class '{@link edu.ustb.sei.mde.xmu2.statement.UpdateStatement <em>Update Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Update Statement</em>'.
	 * @see edu.ustb.sei.mde.xmu2.statement.UpdateStatement
	 * @generated
	 */
	EClass getUpdateStatement();

	/**
	 * Returns the meta object for the containment reference '{@link edu.ustb.sei.mde.xmu2.statement.UpdateStatement#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Source</em>'.
	 * @see edu.ustb.sei.mde.xmu2.statement.UpdateStatement#getSource()
	 * @see #getUpdateStatement()
	 * @generated
	 */
	EReference getUpdateStatement_Source();

	/**
	 * Returns the meta object for the containment reference '{@link edu.ustb.sei.mde.xmu2.statement.UpdateStatement#getView <em>View</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>View</em>'.
	 * @see edu.ustb.sei.mde.xmu2.statement.UpdateStatement#getView()
	 * @see #getUpdateStatement()
	 * @generated
	 */
	EReference getUpdateStatement_View();

	/**
	 * Returns the meta object for the containment reference list '{@link edu.ustb.sei.mde.xmu2.statement.UpdateStatement#getClauses <em>Clauses</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Clauses</em>'.
	 * @see edu.ustb.sei.mde.xmu2.statement.UpdateStatement#getClauses()
	 * @see #getUpdateStatement()
	 * @generated
	 */
	EReference getUpdateStatement_Clauses();

	/**
	 * Returns the meta object for class '{@link edu.ustb.sei.mde.xmu2.statement.SwitchStatement <em>Switch Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Switch Statement</em>'.
	 * @see edu.ustb.sei.mde.xmu2.statement.SwitchStatement
	 * @generated
	 */
	EClass getSwitchStatement();

	/**
	 * Returns the meta object for the containment reference '{@link edu.ustb.sei.mde.xmu2.statement.SwitchStatement#getRoot <em>Root</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Root</em>'.
	 * @see edu.ustb.sei.mde.xmu2.statement.SwitchStatement#getRoot()
	 * @see #getSwitchStatement()
	 * @generated
	 */
	EReference getSwitchStatement_Root();

	/**
	 * Returns the meta object for the containment reference list '{@link edu.ustb.sei.mde.xmu2.statement.SwitchStatement#getCases <em>Cases</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Cases</em>'.
	 * @see edu.ustb.sei.mde.xmu2.statement.SwitchStatement#getCases()
	 * @see #getSwitchStatement()
	 * @generated
	 */
	EReference getSwitchStatement_Cases();

	/**
	 * Returns the meta object for class '{@link edu.ustb.sei.mde.xmu2.statement.UpdateClause <em>Update Clause</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Update Clause</em>'.
	 * @see edu.ustb.sei.mde.xmu2.statement.UpdateClause
	 * @generated
	 */
	EClass getUpdateClause();

	/**
	 * Returns the meta object for the attribute '{@link edu.ustb.sei.mde.xmu2.statement.UpdateClause#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see edu.ustb.sei.mde.xmu2.statement.UpdateClause#getType()
	 * @see #getUpdateClause()
	 * @generated
	 */
	EAttribute getUpdateClause_Type();

	/**
	 * Returns the meta object for the containment reference '{@link edu.ustb.sei.mde.xmu2.statement.UpdateClause#getStatement <em>Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Statement</em>'.
	 * @see edu.ustb.sei.mde.xmu2.statement.UpdateClause#getStatement()
	 * @see #getUpdateClause()
	 * @generated
	 */
	EReference getUpdateClause_Statement();

	/**
	 * Returns the meta object for class '{@link edu.ustb.sei.mde.xmu2.statement.CaseClause <em>Case Clause</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Case Clause</em>'.
	 * @see edu.ustb.sei.mde.xmu2.statement.CaseClause
	 * @generated
	 */
	EClass getCaseClause();

	/**
	 * Returns the meta object for the containment reference '{@link edu.ustb.sei.mde.xmu2.statement.CaseClause#getAction <em>Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Action</em>'.
	 * @see edu.ustb.sei.mde.xmu2.statement.CaseClause#getAction()
	 * @see #getCaseClause()
	 * @generated
	 */
	EReference getCaseClause_Action();

	/**
	 * Returns the meta object for class '{@link edu.ustb.sei.mde.xmu2.statement.PatternCaseClause <em>Pattern Case Clause</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Pattern Case Clause</em>'.
	 * @see edu.ustb.sei.mde.xmu2.statement.PatternCaseClause
	 * @generated
	 */
	EClass getPatternCaseClause();

	/**
	 * Returns the meta object for the containment reference '{@link edu.ustb.sei.mde.xmu2.statement.PatternCaseClause#getCondition <em>Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Condition</em>'.
	 * @see edu.ustb.sei.mde.xmu2.statement.PatternCaseClause#getCondition()
	 * @see #getPatternCaseClause()
	 * @generated
	 */
	EReference getPatternCaseClause_Condition();

	/**
	 * Returns the meta object for class '{@link edu.ustb.sei.mde.xmu2.statement.ExpressionCaseClause <em>Expression Case Clause</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Expression Case Clause</em>'.
	 * @see edu.ustb.sei.mde.xmu2.statement.ExpressionCaseClause
	 * @generated
	 */
	EClass getExpressionCaseClause();

	/**
	 * Returns the meta object for the containment reference '{@link edu.ustb.sei.mde.xmu2.statement.ExpressionCaseClause#getCondition <em>Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Condition</em>'.
	 * @see edu.ustb.sei.mde.xmu2.statement.ExpressionCaseClause#getCondition()
	 * @see #getExpressionCaseClause()
	 * @generated
	 */
	EReference getExpressionCaseClause_Condition();

	/**
	 * Returns the meta object for class '{@link edu.ustb.sei.mde.xmu2.statement.DefaultCaseClause <em>Default Case Clause</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Default Case Clause</em>'.
	 * @see edu.ustb.sei.mde.xmu2.statement.DefaultCaseClause
	 * @generated
	 */
	EClass getDefaultCaseClause();

	/**
	 * Returns the meta object for class '{@link edu.ustb.sei.mde.xmu2.statement.DefaultCaseStatement <em>Default Case Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Default Case Statement</em>'.
	 * @see edu.ustb.sei.mde.xmu2.statement.DefaultCaseStatement
	 * @generated
	 */
	EClass getDefaultCaseStatement();

	/**
	 * Returns the meta object for class '{@link edu.ustb.sei.mde.xmu2.statement.UnidirectionalStatement <em>Unidirectional Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Unidirectional Statement</em>'.
	 * @see edu.ustb.sei.mde.xmu2.statement.UnidirectionalStatement
	 * @generated
	 */
	EClass getUnidirectionalStatement();

	/**
	 * Returns the meta object for class '{@link edu.ustb.sei.mde.xmu2.statement.BidirectionalStatement <em>Bidirectional Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Bidirectional Statement</em>'.
	 * @see edu.ustb.sei.mde.xmu2.statement.BidirectionalStatement
	 * @generated
	 */
	EClass getBidirectionalStatement();

	/**
	 * Returns the meta object for class '{@link edu.ustb.sei.mde.xmu2.statement.EnforcePatternStatement <em>Enforce Pattern Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Enforce Pattern Statement</em>'.
	 * @see edu.ustb.sei.mde.xmu2.statement.EnforcePatternStatement
	 * @generated
	 */
	EClass getEnforcePatternStatement();

	/**
	 * Returns the meta object for the containment reference '{@link edu.ustb.sei.mde.xmu2.statement.EnforcePatternStatement#getPattern <em>Pattern</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Pattern</em>'.
	 * @see edu.ustb.sei.mde.xmu2.statement.EnforcePatternStatement#getPattern()
	 * @see #getEnforcePatternStatement()
	 * @generated
	 */
	EReference getEnforcePatternStatement_Pattern();

	/**
	 * Returns the meta object for class '{@link edu.ustb.sei.mde.xmu2.statement.DeleteNodeStatement <em>Delete Node Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Delete Node Statement</em>'.
	 * @see edu.ustb.sei.mde.xmu2.statement.DeleteNodeStatement
	 * @generated
	 */
	EClass getDeleteNodeStatement();

	/**
	 * Returns the meta object for the containment reference '{@link edu.ustb.sei.mde.xmu2.statement.DeleteNodeStatement#getNode <em>Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Node</em>'.
	 * @see edu.ustb.sei.mde.xmu2.statement.DeleteNodeStatement#getNode()
	 * @see #getDeleteNodeStatement()
	 * @generated
	 */
	EReference getDeleteNodeStatement_Node();

	/**
	 * Returns the meta object for class '{@link edu.ustb.sei.mde.xmu2.statement.DeleteLinkStatement <em>Delete Link Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Delete Link Statement</em>'.
	 * @see edu.ustb.sei.mde.xmu2.statement.DeleteLinkStatement
	 * @generated
	 */
	EClass getDeleteLinkStatement();

	/**
	 * Returns the meta object for the containment reference '{@link edu.ustb.sei.mde.xmu2.statement.DeleteLinkStatement#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Source</em>'.
	 * @see edu.ustb.sei.mde.xmu2.statement.DeleteLinkStatement#getSource()
	 * @see #getDeleteLinkStatement()
	 * @generated
	 */
	EReference getDeleteLinkStatement_Source();

	/**
	 * Returns the meta object for the containment reference '{@link edu.ustb.sei.mde.xmu2.statement.DeleteLinkStatement#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Target</em>'.
	 * @see edu.ustb.sei.mde.xmu2.statement.DeleteLinkStatement#getTarget()
	 * @see #getDeleteLinkStatement()
	 * @generated
	 */
	EReference getDeleteLinkStatement_Target();

	/**
	 * Returns the meta object for the attribute '{@link edu.ustb.sei.mde.xmu2.statement.DeleteLinkStatement#getFeature <em>Feature</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Feature</em>'.
	 * @see edu.ustb.sei.mde.xmu2.statement.DeleteLinkStatement#getFeature()
	 * @see #getDeleteLinkStatement()
	 * @generated
	 */
	EAttribute getDeleteLinkStatement_Feature();

	/**
	 * Returns the meta object for class '{@link edu.ustb.sei.mde.xmu2.statement.ConcreteDeleteLinkStatement <em>Concrete Delete Link Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Concrete Delete Link Statement</em>'.
	 * @see edu.ustb.sei.mde.xmu2.statement.ConcreteDeleteLinkStatement
	 * @generated
	 */
	EClass getConcreteDeleteLinkStatement();

	/**
	 * Returns the meta object for class '{@link edu.ustb.sei.mde.xmu2.statement.ReflectiveDeleteLinkStatement <em>Reflective Delete Link Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Reflective Delete Link Statement</em>'.
	 * @see edu.ustb.sei.mde.xmu2.statement.ReflectiveDeleteLinkStatement
	 * @generated
	 */
	EClass getReflectiveDeleteLinkStatement();

	/**
	 * Returns the meta object for class '{@link edu.ustb.sei.mde.xmu2.statement.ForEachStatement <em>For Each Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>For Each Statement</em>'.
	 * @see edu.ustb.sei.mde.xmu2.statement.ForEachStatement
	 * @generated
	 */
	EClass getForEachStatement();

	/**
	 * Returns the meta object for the containment reference '{@link edu.ustb.sei.mde.xmu2.statement.ForEachStatement#getPattern <em>Pattern</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Pattern</em>'.
	 * @see edu.ustb.sei.mde.xmu2.statement.ForEachStatement#getPattern()
	 * @see #getForEachStatement()
	 * @generated
	 */
	EReference getForEachStatement_Pattern();

	/**
	 * Returns the meta object for the containment reference '{@link edu.ustb.sei.mde.xmu2.statement.ForEachStatement#getAction <em>Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Action</em>'.
	 * @see edu.ustb.sei.mde.xmu2.statement.ForEachStatement#getAction()
	 * @see #getForEachStatement()
	 * @generated
	 */
	EReference getForEachStatement_Action();

	/**
	 * Returns the meta object for class '{@link edu.ustb.sei.mde.xmu2.statement.BlockStatement <em>Block Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Block Statement</em>'.
	 * @see edu.ustb.sei.mde.xmu2.statement.BlockStatement
	 * @generated
	 */
	EClass getBlockStatement();

	/**
	 * Returns the meta object for the containment reference list '{@link edu.ustb.sei.mde.xmu2.statement.BlockStatement#getBody <em>Body</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Body</em>'.
	 * @see edu.ustb.sei.mde.xmu2.statement.BlockStatement#getBody()
	 * @see #getBlockStatement()
	 * @generated
	 */
	EReference getBlockStatement_Body();

	/**
	 * Returns the meta object for class '{@link edu.ustb.sei.mde.xmu2.statement.RuleCallStatement <em>Rule Call Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Rule Call Statement</em>'.
	 * @see edu.ustb.sei.mde.xmu2.statement.RuleCallStatement
	 * @generated
	 */
	EClass getRuleCallStatement();

	/**
	 * Returns the meta object for the reference '{@link edu.ustb.sei.mde.xmu2.statement.RuleCallStatement#getRule <em>Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Rule</em>'.
	 * @see edu.ustb.sei.mde.xmu2.statement.RuleCallStatement#getRule()
	 * @see #getRuleCallStatement()
	 * @generated
	 */
	EReference getRuleCallStatement_Rule();

	/**
	 * Returns the meta object for the containment reference list '{@link edu.ustb.sei.mde.xmu2.statement.RuleCallStatement#getParameters <em>Parameters</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Parameters</em>'.
	 * @see edu.ustb.sei.mde.xmu2.statement.RuleCallStatement#getParameters()
	 * @see #getRuleCallStatement()
	 * @generated
	 */
	EReference getRuleCallStatement_Parameters();

	/**
	 * Returns the meta object for class '{@link edu.ustb.sei.mde.xmu2.statement.PsesudoStatement <em>Psesudo Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Psesudo Statement</em>'.
	 * @see edu.ustb.sei.mde.xmu2.statement.PsesudoStatement
	 * @generated
	 */
	EClass getPsesudoStatement();

	/**
	 * Returns the meta object for class '{@link edu.ustb.sei.mde.xmu2.statement.Fail <em>Fail</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Fail</em>'.
	 * @see edu.ustb.sei.mde.xmu2.statement.Fail
	 * @generated
	 */
	EClass getFail();

	/**
	 * Returns the meta object for the attribute '{@link edu.ustb.sei.mde.xmu2.statement.Fail#getMessage <em>Message</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Message</em>'.
	 * @see edu.ustb.sei.mde.xmu2.statement.Fail#getMessage()
	 * @see #getFail()
	 * @generated
	 */
	EAttribute getFail_Message();

	/**
	 * Returns the meta object for class '{@link edu.ustb.sei.mde.xmu2.statement.Skip <em>Skip</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Skip</em>'.
	 * @see edu.ustb.sei.mde.xmu2.statement.Skip
	 * @generated
	 */
	EClass getSkip();

	/**
	 * Returns the meta object for class '{@link edu.ustb.sei.mde.xmu2.statement.AssignStatement <em>Assign Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Assign Statement</em>'.
	 * @see edu.ustb.sei.mde.xmu2.statement.AssignStatement
	 * @generated
	 */
	EClass getAssignStatement();

	/**
	 * Returns the meta object for the containment reference '{@link edu.ustb.sei.mde.xmu2.statement.AssignStatement#getUpdatedVariable <em>Updated Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Updated Variable</em>'.
	 * @see edu.ustb.sei.mde.xmu2.statement.AssignStatement#getUpdatedVariable()
	 * @see #getAssignStatement()
	 * @generated
	 */
	EReference getAssignStatement_UpdatedVariable();

	/**
	 * Returns the meta object for the containment reference '{@link edu.ustb.sei.mde.xmu2.statement.AssignStatement#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Value</em>'.
	 * @see edu.ustb.sei.mde.xmu2.statement.AssignStatement#getValue()
	 * @see #getAssignStatement()
	 * @generated
	 */
	EReference getAssignStatement_Value();

	/**
	 * Returns the meta object for enum '{@link edu.ustb.sei.mde.xmu2.statement.ActionType <em>Action Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Action Type</em>'.
	 * @see edu.ustb.sei.mde.xmu2.statement.ActionType
	 * @generated
	 */
	EEnum getActionType();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	StatementFactory getStatementFactory();

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
		 * The meta object literal for the '{@link edu.ustb.sei.mde.xmu2.statement.impl.StatementImpl <em>Statement</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.ustb.sei.mde.xmu2.statement.impl.StatementImpl
		 * @see edu.ustb.sei.mde.xmu2.statement.impl.StatementPackageImpl#getStatement()
		 * @generated
		 */
		EClass STATEMENT = eINSTANCE.getStatement();

		/**
		 * The meta object literal for the '{@link edu.ustb.sei.mde.xmu2.statement.impl.UpdateStatementImpl <em>Update Statement</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.ustb.sei.mde.xmu2.statement.impl.UpdateStatementImpl
		 * @see edu.ustb.sei.mde.xmu2.statement.impl.StatementPackageImpl#getUpdateStatement()
		 * @generated
		 */
		EClass UPDATE_STATEMENT = eINSTANCE.getUpdateStatement();

		/**
		 * The meta object literal for the '<em><b>Source</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference UPDATE_STATEMENT__SOURCE = eINSTANCE.getUpdateStatement_Source();

		/**
		 * The meta object literal for the '<em><b>View</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference UPDATE_STATEMENT__VIEW = eINSTANCE.getUpdateStatement_View();

		/**
		 * The meta object literal for the '<em><b>Clauses</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference UPDATE_STATEMENT__CLAUSES = eINSTANCE.getUpdateStatement_Clauses();

		/**
		 * The meta object literal for the '{@link edu.ustb.sei.mde.xmu2.statement.impl.SwitchStatementImpl <em>Switch Statement</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.ustb.sei.mde.xmu2.statement.impl.SwitchStatementImpl
		 * @see edu.ustb.sei.mde.xmu2.statement.impl.StatementPackageImpl#getSwitchStatement()
		 * @generated
		 */
		EClass SWITCH_STATEMENT = eINSTANCE.getSwitchStatement();

		/**
		 * The meta object literal for the '<em><b>Root</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SWITCH_STATEMENT__ROOT = eINSTANCE.getSwitchStatement_Root();

		/**
		 * The meta object literal for the '<em><b>Cases</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SWITCH_STATEMENT__CASES = eINSTANCE.getSwitchStatement_Cases();

		/**
		 * The meta object literal for the '{@link edu.ustb.sei.mde.xmu2.statement.impl.UpdateClauseImpl <em>Update Clause</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.ustb.sei.mde.xmu2.statement.impl.UpdateClauseImpl
		 * @see edu.ustb.sei.mde.xmu2.statement.impl.StatementPackageImpl#getUpdateClause()
		 * @generated
		 */
		EClass UPDATE_CLAUSE = eINSTANCE.getUpdateClause();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute UPDATE_CLAUSE__TYPE = eINSTANCE.getUpdateClause_Type();

		/**
		 * The meta object literal for the '<em><b>Statement</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference UPDATE_CLAUSE__STATEMENT = eINSTANCE.getUpdateClause_Statement();

		/**
		 * The meta object literal for the '{@link edu.ustb.sei.mde.xmu2.statement.impl.CaseClauseImpl <em>Case Clause</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.ustb.sei.mde.xmu2.statement.impl.CaseClauseImpl
		 * @see edu.ustb.sei.mde.xmu2.statement.impl.StatementPackageImpl#getCaseClause()
		 * @generated
		 */
		EClass CASE_CLAUSE = eINSTANCE.getCaseClause();

		/**
		 * The meta object literal for the '<em><b>Action</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CASE_CLAUSE__ACTION = eINSTANCE.getCaseClause_Action();

		/**
		 * The meta object literal for the '{@link edu.ustb.sei.mde.xmu2.statement.impl.PatternCaseClauseImpl <em>Pattern Case Clause</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.ustb.sei.mde.xmu2.statement.impl.PatternCaseClauseImpl
		 * @see edu.ustb.sei.mde.xmu2.statement.impl.StatementPackageImpl#getPatternCaseClause()
		 * @generated
		 */
		EClass PATTERN_CASE_CLAUSE = eINSTANCE.getPatternCaseClause();

		/**
		 * The meta object literal for the '<em><b>Condition</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PATTERN_CASE_CLAUSE__CONDITION = eINSTANCE.getPatternCaseClause_Condition();

		/**
		 * The meta object literal for the '{@link edu.ustb.sei.mde.xmu2.statement.impl.ExpressionCaseClauseImpl <em>Expression Case Clause</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.ustb.sei.mde.xmu2.statement.impl.ExpressionCaseClauseImpl
		 * @see edu.ustb.sei.mde.xmu2.statement.impl.StatementPackageImpl#getExpressionCaseClause()
		 * @generated
		 */
		EClass EXPRESSION_CASE_CLAUSE = eINSTANCE.getExpressionCaseClause();

		/**
		 * The meta object literal for the '<em><b>Condition</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXPRESSION_CASE_CLAUSE__CONDITION = eINSTANCE.getExpressionCaseClause_Condition();

		/**
		 * The meta object literal for the '{@link edu.ustb.sei.mde.xmu2.statement.impl.DefaultCaseClauseImpl <em>Default Case Clause</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.ustb.sei.mde.xmu2.statement.impl.DefaultCaseClauseImpl
		 * @see edu.ustb.sei.mde.xmu2.statement.impl.StatementPackageImpl#getDefaultCaseClause()
		 * @generated
		 */
		EClass DEFAULT_CASE_CLAUSE = eINSTANCE.getDefaultCaseClause();

		/**
		 * The meta object literal for the '{@link edu.ustb.sei.mde.xmu2.statement.impl.DefaultCaseStatementImpl <em>Default Case Statement</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.ustb.sei.mde.xmu2.statement.impl.DefaultCaseStatementImpl
		 * @see edu.ustb.sei.mde.xmu2.statement.impl.StatementPackageImpl#getDefaultCaseStatement()
		 * @generated
		 */
		EClass DEFAULT_CASE_STATEMENT = eINSTANCE.getDefaultCaseStatement();

		/**
		 * The meta object literal for the '{@link edu.ustb.sei.mde.xmu2.statement.impl.UnidirectionalStatementImpl <em>Unidirectional Statement</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.ustb.sei.mde.xmu2.statement.impl.UnidirectionalStatementImpl
		 * @see edu.ustb.sei.mde.xmu2.statement.impl.StatementPackageImpl#getUnidirectionalStatement()
		 * @generated
		 */
		EClass UNIDIRECTIONAL_STATEMENT = eINSTANCE.getUnidirectionalStatement();

		/**
		 * The meta object literal for the '{@link edu.ustb.sei.mde.xmu2.statement.impl.BidirectionalStatementImpl <em>Bidirectional Statement</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.ustb.sei.mde.xmu2.statement.impl.BidirectionalStatementImpl
		 * @see edu.ustb.sei.mde.xmu2.statement.impl.StatementPackageImpl#getBidirectionalStatement()
		 * @generated
		 */
		EClass BIDIRECTIONAL_STATEMENT = eINSTANCE.getBidirectionalStatement();

		/**
		 * The meta object literal for the '{@link edu.ustb.sei.mde.xmu2.statement.impl.EnforcePatternStatementImpl <em>Enforce Pattern Statement</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.ustb.sei.mde.xmu2.statement.impl.EnforcePatternStatementImpl
		 * @see edu.ustb.sei.mde.xmu2.statement.impl.StatementPackageImpl#getEnforcePatternStatement()
		 * @generated
		 */
		EClass ENFORCE_PATTERN_STATEMENT = eINSTANCE.getEnforcePatternStatement();

		/**
		 * The meta object literal for the '<em><b>Pattern</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ENFORCE_PATTERN_STATEMENT__PATTERN = eINSTANCE.getEnforcePatternStatement_Pattern();

		/**
		 * The meta object literal for the '{@link edu.ustb.sei.mde.xmu2.statement.impl.DeleteNodeStatementImpl <em>Delete Node Statement</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.ustb.sei.mde.xmu2.statement.impl.DeleteNodeStatementImpl
		 * @see edu.ustb.sei.mde.xmu2.statement.impl.StatementPackageImpl#getDeleteNodeStatement()
		 * @generated
		 */
		EClass DELETE_NODE_STATEMENT = eINSTANCE.getDeleteNodeStatement();

		/**
		 * The meta object literal for the '<em><b>Node</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DELETE_NODE_STATEMENT__NODE = eINSTANCE.getDeleteNodeStatement_Node();

		/**
		 * The meta object literal for the '{@link edu.ustb.sei.mde.xmu2.statement.impl.DeleteLinkStatementImpl <em>Delete Link Statement</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.ustb.sei.mde.xmu2.statement.impl.DeleteLinkStatementImpl
		 * @see edu.ustb.sei.mde.xmu2.statement.impl.StatementPackageImpl#getDeleteLinkStatement()
		 * @generated
		 */
		EClass DELETE_LINK_STATEMENT = eINSTANCE.getDeleteLinkStatement();

		/**
		 * The meta object literal for the '<em><b>Source</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DELETE_LINK_STATEMENT__SOURCE = eINSTANCE.getDeleteLinkStatement_Source();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DELETE_LINK_STATEMENT__TARGET = eINSTANCE.getDeleteLinkStatement_Target();

		/**
		 * The meta object literal for the '<em><b>Feature</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DELETE_LINK_STATEMENT__FEATURE = eINSTANCE.getDeleteLinkStatement_Feature();

		/**
		 * The meta object literal for the '{@link edu.ustb.sei.mde.xmu2.statement.impl.ConcreteDeleteLinkStatementImpl <em>Concrete Delete Link Statement</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.ustb.sei.mde.xmu2.statement.impl.ConcreteDeleteLinkStatementImpl
		 * @see edu.ustb.sei.mde.xmu2.statement.impl.StatementPackageImpl#getConcreteDeleteLinkStatement()
		 * @generated
		 */
		EClass CONCRETE_DELETE_LINK_STATEMENT = eINSTANCE.getConcreteDeleteLinkStatement();

		/**
		 * The meta object literal for the '{@link edu.ustb.sei.mde.xmu2.statement.impl.ReflectiveDeleteLinkStatementImpl <em>Reflective Delete Link Statement</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.ustb.sei.mde.xmu2.statement.impl.ReflectiveDeleteLinkStatementImpl
		 * @see edu.ustb.sei.mde.xmu2.statement.impl.StatementPackageImpl#getReflectiveDeleteLinkStatement()
		 * @generated
		 */
		EClass REFLECTIVE_DELETE_LINK_STATEMENT = eINSTANCE.getReflectiveDeleteLinkStatement();

		/**
		 * The meta object literal for the '{@link edu.ustb.sei.mde.xmu2.statement.impl.ForEachStatementImpl <em>For Each Statement</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.ustb.sei.mde.xmu2.statement.impl.ForEachStatementImpl
		 * @see edu.ustb.sei.mde.xmu2.statement.impl.StatementPackageImpl#getForEachStatement()
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
		 * The meta object literal for the '<em><b>Action</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FOR_EACH_STATEMENT__ACTION = eINSTANCE.getForEachStatement_Action();

		/**
		 * The meta object literal for the '{@link edu.ustb.sei.mde.xmu2.statement.impl.BlockStatementImpl <em>Block Statement</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.ustb.sei.mde.xmu2.statement.impl.BlockStatementImpl
		 * @see edu.ustb.sei.mde.xmu2.statement.impl.StatementPackageImpl#getBlockStatement()
		 * @generated
		 */
		EClass BLOCK_STATEMENT = eINSTANCE.getBlockStatement();

		/**
		 * The meta object literal for the '<em><b>Body</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BLOCK_STATEMENT__BODY = eINSTANCE.getBlockStatement_Body();

		/**
		 * The meta object literal for the '{@link edu.ustb.sei.mde.xmu2.statement.impl.RuleCallStatementImpl <em>Rule Call Statement</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.ustb.sei.mde.xmu2.statement.impl.RuleCallStatementImpl
		 * @see edu.ustb.sei.mde.xmu2.statement.impl.StatementPackageImpl#getRuleCallStatement()
		 * @generated
		 */
		EClass RULE_CALL_STATEMENT = eINSTANCE.getRuleCallStatement();

		/**
		 * The meta object literal for the '<em><b>Rule</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RULE_CALL_STATEMENT__RULE = eINSTANCE.getRuleCallStatement_Rule();

		/**
		 * The meta object literal for the '<em><b>Parameters</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RULE_CALL_STATEMENT__PARAMETERS = eINSTANCE.getRuleCallStatement_Parameters();

		/**
		 * The meta object literal for the '{@link edu.ustb.sei.mde.xmu2.statement.impl.PsesudoStatementImpl <em>Psesudo Statement</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.ustb.sei.mde.xmu2.statement.impl.PsesudoStatementImpl
		 * @see edu.ustb.sei.mde.xmu2.statement.impl.StatementPackageImpl#getPsesudoStatement()
		 * @generated
		 */
		EClass PSESUDO_STATEMENT = eINSTANCE.getPsesudoStatement();

		/**
		 * The meta object literal for the '{@link edu.ustb.sei.mde.xmu2.statement.impl.FailImpl <em>Fail</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.ustb.sei.mde.xmu2.statement.impl.FailImpl
		 * @see edu.ustb.sei.mde.xmu2.statement.impl.StatementPackageImpl#getFail()
		 * @generated
		 */
		EClass FAIL = eINSTANCE.getFail();

		/**
		 * The meta object literal for the '<em><b>Message</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FAIL__MESSAGE = eINSTANCE.getFail_Message();

		/**
		 * The meta object literal for the '{@link edu.ustb.sei.mde.xmu2.statement.impl.SkipImpl <em>Skip</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.ustb.sei.mde.xmu2.statement.impl.SkipImpl
		 * @see edu.ustb.sei.mde.xmu2.statement.impl.StatementPackageImpl#getSkip()
		 * @generated
		 */
		EClass SKIP = eINSTANCE.getSkip();

		/**
		 * The meta object literal for the '{@link edu.ustb.sei.mde.xmu2.statement.impl.AssignStatementImpl <em>Assign Statement</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.ustb.sei.mde.xmu2.statement.impl.AssignStatementImpl
		 * @see edu.ustb.sei.mde.xmu2.statement.impl.StatementPackageImpl#getAssignStatement()
		 * @generated
		 */
		EClass ASSIGN_STATEMENT = eINSTANCE.getAssignStatement();

		/**
		 * The meta object literal for the '<em><b>Updated Variable</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ASSIGN_STATEMENT__UPDATED_VARIABLE = eINSTANCE.getAssignStatement_UpdatedVariable();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ASSIGN_STATEMENT__VALUE = eINSTANCE.getAssignStatement_Value();

		/**
		 * The meta object literal for the '{@link edu.ustb.sei.mde.xmu2.statement.ActionType <em>Action Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.ustb.sei.mde.xmu2.statement.ActionType
		 * @see edu.ustb.sei.mde.xmu2.statement.impl.StatementPackageImpl#getActionType()
		 * @generated
		 */
		EEnum ACTION_TYPE = eINSTANCE.getActionType();

	}

} //StatementPackage
