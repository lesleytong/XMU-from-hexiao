/**
 */
package edu.ustb.sei.mde.xmu2.statement.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;

import edu.ustb.sei.mde.xmu2.Xmu2Package;
import edu.ustb.sei.mde.xmu2.expression.ExpressionPackage;
import edu.ustb.sei.mde.xmu2.expression.impl.ExpressionPackageImpl;
import edu.ustb.sei.mde.xmu2.impl.Xmu2PackageImpl;
import edu.ustb.sei.mde.xmu2.pattern.PatternPackage;
import edu.ustb.sei.mde.xmu2.pattern.impl.PatternPackageImpl;
import edu.ustb.sei.mde.xmu2.statement.ActionType;
import edu.ustb.sei.mde.xmu2.statement.AssignStatement;
import edu.ustb.sei.mde.xmu2.statement.BidirectionalStatement;
import edu.ustb.sei.mde.xmu2.statement.BlockStatement;
import edu.ustb.sei.mde.xmu2.statement.CaseClause;
import edu.ustb.sei.mde.xmu2.statement.ConcreteDeleteLinkStatement;
import edu.ustb.sei.mde.xmu2.statement.DefaultCaseClause;
import edu.ustb.sei.mde.xmu2.statement.DefaultCaseStatement;
import edu.ustb.sei.mde.xmu2.statement.DeleteLinkStatement;
import edu.ustb.sei.mde.xmu2.statement.DeleteNodeStatement;
import edu.ustb.sei.mde.xmu2.statement.EnforcePatternStatement;
import edu.ustb.sei.mde.xmu2.statement.ExpressionCaseClause;
import edu.ustb.sei.mde.xmu2.statement.Fail;
import edu.ustb.sei.mde.xmu2.statement.ForEachStatement;
import edu.ustb.sei.mde.xmu2.statement.PatternCaseClause;
import edu.ustb.sei.mde.xmu2.statement.PsesudoStatement;
import edu.ustb.sei.mde.xmu2.statement.ReflectiveDeleteLinkStatement;
import edu.ustb.sei.mde.xmu2.statement.RuleCallStatement;
import edu.ustb.sei.mde.xmu2.statement.Skip;
import edu.ustb.sei.mde.xmu2.statement.Statement;
import edu.ustb.sei.mde.xmu2.statement.StatementFactory;
import edu.ustb.sei.mde.xmu2.statement.StatementPackage;
import edu.ustb.sei.mde.xmu2.statement.SwitchStatement;
import edu.ustb.sei.mde.xmu2.statement.UnidirectionalStatement;
import edu.ustb.sei.mde.xmu2.statement.UpdateClause;
import edu.ustb.sei.mde.xmu2.statement.UpdateStatement;
import edu.ustb.sei.mde.xmu2common.Xmu2commonPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class StatementPackageImpl extends EPackageImpl implements StatementPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass statementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass updateStatementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass switchStatementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass updateClauseEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass caseClauseEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass patternCaseClauseEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass expressionCaseClauseEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass defaultCaseClauseEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass defaultCaseStatementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass unidirectionalStatementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass bidirectionalStatementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass enforcePatternStatementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass deleteNodeStatementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass deleteLinkStatementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass concreteDeleteLinkStatementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass reflectiveDeleteLinkStatementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass forEachStatementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass blockStatementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ruleCallStatementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass psesudoStatementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass failEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass skipEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass assignStatementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum actionTypeEEnum = null;

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
	 * @see edu.ustb.sei.mde.xmu2.statement.StatementPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private StatementPackageImpl() {
		super(eNS_URI, StatementFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link StatementPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static StatementPackage init() {
		if (isInited) return (StatementPackage)EPackage.Registry.INSTANCE.getEPackage(StatementPackage.eNS_URI);

		// Obtain or create and register package
		StatementPackageImpl theStatementPackage = (StatementPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof StatementPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new StatementPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		Xmu2commonPackage.eINSTANCE.eClass();

		// Obtain or create and register interdependencies
		Xmu2PackageImpl theXmu2Package = (Xmu2PackageImpl)(EPackage.Registry.INSTANCE.getEPackage(Xmu2Package.eNS_URI) instanceof Xmu2PackageImpl ? EPackage.Registry.INSTANCE.getEPackage(Xmu2Package.eNS_URI) : Xmu2Package.eINSTANCE);
		PatternPackageImpl thePatternPackage = (PatternPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(PatternPackage.eNS_URI) instanceof PatternPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(PatternPackage.eNS_URI) : PatternPackage.eINSTANCE);
		ExpressionPackageImpl theExpressionPackage = (ExpressionPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ExpressionPackage.eNS_URI) instanceof ExpressionPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ExpressionPackage.eNS_URI) : ExpressionPackage.eINSTANCE);

		// Create package meta-data objects
		theStatementPackage.createPackageContents();
		theXmu2Package.createPackageContents();
		thePatternPackage.createPackageContents();
		theExpressionPackage.createPackageContents();

		// Initialize created meta-data
		theStatementPackage.initializePackageContents();
		theXmu2Package.initializePackageContents();
		thePatternPackage.initializePackageContents();
		theExpressionPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theStatementPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(StatementPackage.eNS_URI, theStatementPackage);
		return theStatementPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStatement() {
		return statementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getUpdateStatement() {
		return updateStatementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getUpdateStatement_Source() {
		return (EReference)updateStatementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getUpdateStatement_View() {
		return (EReference)updateStatementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getUpdateStatement_Clauses() {
		return (EReference)updateStatementEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSwitchStatement() {
		return switchStatementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSwitchStatement_Root() {
		return (EReference)switchStatementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSwitchStatement_Cases() {
		return (EReference)switchStatementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getUpdateClause() {
		return updateClauseEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getUpdateClause_Type() {
		return (EAttribute)updateClauseEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getUpdateClause_Statement() {
		return (EReference)updateClauseEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCaseClause() {
		return caseClauseEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCaseClause_Action() {
		return (EReference)caseClauseEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPatternCaseClause() {
		return patternCaseClauseEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPatternCaseClause_Condition() {
		return (EReference)patternCaseClauseEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getExpressionCaseClause() {
		return expressionCaseClauseEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getExpressionCaseClause_Condition() {
		return (EReference)expressionCaseClauseEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDefaultCaseClause() {
		return defaultCaseClauseEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDefaultCaseStatement() {
		return defaultCaseStatementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getUnidirectionalStatement() {
		return unidirectionalStatementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBidirectionalStatement() {
		return bidirectionalStatementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEnforcePatternStatement() {
		return enforcePatternStatementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEnforcePatternStatement_Pattern() {
		return (EReference)enforcePatternStatementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDeleteNodeStatement() {
		return deleteNodeStatementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDeleteNodeStatement_Node() {
		return (EReference)deleteNodeStatementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDeleteLinkStatement() {
		return deleteLinkStatementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDeleteLinkStatement_Source() {
		return (EReference)deleteLinkStatementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDeleteLinkStatement_Target() {
		return (EReference)deleteLinkStatementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDeleteLinkStatement_Feature() {
		return (EAttribute)deleteLinkStatementEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getConcreteDeleteLinkStatement() {
		return concreteDeleteLinkStatementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getReflectiveDeleteLinkStatement() {
		return reflectiveDeleteLinkStatementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getForEachStatement() {
		return forEachStatementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getForEachStatement_Pattern() {
		return (EReference)forEachStatementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getForEachStatement_Action() {
		return (EReference)forEachStatementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBlockStatement() {
		return blockStatementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBlockStatement_Body() {
		return (EReference)blockStatementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRuleCallStatement() {
		return ruleCallStatementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRuleCallStatement_Rule() {
		return (EReference)ruleCallStatementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRuleCallStatement_Parameters() {
		return (EReference)ruleCallStatementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPsesudoStatement() {
		return psesudoStatementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFail() {
		return failEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFail_Message() {
		return (EAttribute)failEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSkip() {
		return skipEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAssignStatement() {
		return assignStatementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAssignStatement_UpdatedVariable() {
		return (EReference)assignStatementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAssignStatement_Value() {
		return (EReference)assignStatementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getActionType() {
		return actionTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StatementFactory getStatementFactory() {
		return (StatementFactory)getEFactoryInstance();
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
		statementEClass = createEClass(STATEMENT);

		updateStatementEClass = createEClass(UPDATE_STATEMENT);
		createEReference(updateStatementEClass, UPDATE_STATEMENT__SOURCE);
		createEReference(updateStatementEClass, UPDATE_STATEMENT__VIEW);
		createEReference(updateStatementEClass, UPDATE_STATEMENT__CLAUSES);

		switchStatementEClass = createEClass(SWITCH_STATEMENT);
		createEReference(switchStatementEClass, SWITCH_STATEMENT__ROOT);
		createEReference(switchStatementEClass, SWITCH_STATEMENT__CASES);

		updateClauseEClass = createEClass(UPDATE_CLAUSE);
		createEAttribute(updateClauseEClass, UPDATE_CLAUSE__TYPE);
		createEReference(updateClauseEClass, UPDATE_CLAUSE__STATEMENT);

		caseClauseEClass = createEClass(CASE_CLAUSE);
		createEReference(caseClauseEClass, CASE_CLAUSE__ACTION);

		patternCaseClauseEClass = createEClass(PATTERN_CASE_CLAUSE);
		createEReference(patternCaseClauseEClass, PATTERN_CASE_CLAUSE__CONDITION);

		expressionCaseClauseEClass = createEClass(EXPRESSION_CASE_CLAUSE);
		createEReference(expressionCaseClauseEClass, EXPRESSION_CASE_CLAUSE__CONDITION);

		defaultCaseClauseEClass = createEClass(DEFAULT_CASE_CLAUSE);

		defaultCaseStatementEClass = createEClass(DEFAULT_CASE_STATEMENT);

		unidirectionalStatementEClass = createEClass(UNIDIRECTIONAL_STATEMENT);

		bidirectionalStatementEClass = createEClass(BIDIRECTIONAL_STATEMENT);

		enforcePatternStatementEClass = createEClass(ENFORCE_PATTERN_STATEMENT);
		createEReference(enforcePatternStatementEClass, ENFORCE_PATTERN_STATEMENT__PATTERN);

		deleteNodeStatementEClass = createEClass(DELETE_NODE_STATEMENT);
		createEReference(deleteNodeStatementEClass, DELETE_NODE_STATEMENT__NODE);

		deleteLinkStatementEClass = createEClass(DELETE_LINK_STATEMENT);
		createEReference(deleteLinkStatementEClass, DELETE_LINK_STATEMENT__SOURCE);
		createEReference(deleteLinkStatementEClass, DELETE_LINK_STATEMENT__TARGET);
		createEAttribute(deleteLinkStatementEClass, DELETE_LINK_STATEMENT__FEATURE);

		concreteDeleteLinkStatementEClass = createEClass(CONCRETE_DELETE_LINK_STATEMENT);

		reflectiveDeleteLinkStatementEClass = createEClass(REFLECTIVE_DELETE_LINK_STATEMENT);

		forEachStatementEClass = createEClass(FOR_EACH_STATEMENT);
		createEReference(forEachStatementEClass, FOR_EACH_STATEMENT__PATTERN);
		createEReference(forEachStatementEClass, FOR_EACH_STATEMENT__ACTION);

		blockStatementEClass = createEClass(BLOCK_STATEMENT);
		createEReference(blockStatementEClass, BLOCK_STATEMENT__BODY);

		ruleCallStatementEClass = createEClass(RULE_CALL_STATEMENT);
		createEReference(ruleCallStatementEClass, RULE_CALL_STATEMENT__RULE);
		createEReference(ruleCallStatementEClass, RULE_CALL_STATEMENT__PARAMETERS);

		psesudoStatementEClass = createEClass(PSESUDO_STATEMENT);

		failEClass = createEClass(FAIL);
		createEAttribute(failEClass, FAIL__MESSAGE);

		skipEClass = createEClass(SKIP);

		assignStatementEClass = createEClass(ASSIGN_STATEMENT);
		createEReference(assignStatementEClass, ASSIGN_STATEMENT__UPDATED_VARIABLE);
		createEReference(assignStatementEClass, ASSIGN_STATEMENT__VALUE);

		// Create enums
		actionTypeEEnum = createEEnum(ACTION_TYPE);
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
		PatternPackage thePatternPackage = (PatternPackage)EPackage.Registry.INSTANCE.getEPackage(PatternPackage.eNS_URI);
		ExpressionPackage theExpressionPackage = (ExpressionPackage)EPackage.Registry.INSTANCE.getEPackage(ExpressionPackage.eNS_URI);
		Xmu2Package theXmu2Package = (Xmu2Package)EPackage.Registry.INSTANCE.getEPackage(Xmu2Package.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		updateStatementEClass.getESuperTypes().add(this.getBidirectionalStatement());
		switchStatementEClass.getESuperTypes().add(this.getBidirectionalStatement());
		patternCaseClauseEClass.getESuperTypes().add(this.getCaseClause());
		expressionCaseClauseEClass.getESuperTypes().add(this.getCaseClause());
		defaultCaseClauseEClass.getESuperTypes().add(this.getCaseClause());
		defaultCaseStatementEClass.getESuperTypes().add(this.getCaseClause());
		unidirectionalStatementEClass.getESuperTypes().add(this.getStatement());
		bidirectionalStatementEClass.getESuperTypes().add(this.getStatement());
		enforcePatternStatementEClass.getESuperTypes().add(this.getUnidirectionalStatement());
		deleteNodeStatementEClass.getESuperTypes().add(this.getUnidirectionalStatement());
		deleteLinkStatementEClass.getESuperTypes().add(this.getUnidirectionalStatement());
		concreteDeleteLinkStatementEClass.getESuperTypes().add(this.getDeleteLinkStatement());
		reflectiveDeleteLinkStatementEClass.getESuperTypes().add(this.getDeleteLinkStatement());
		reflectiveDeleteLinkStatementEClass.getESuperTypes().add(theXmu2Package.getReflectiveAPI());
		forEachStatementEClass.getESuperTypes().add(this.getUnidirectionalStatement());
		blockStatementEClass.getESuperTypes().add(this.getStatement());
		ruleCallStatementEClass.getESuperTypes().add(this.getBidirectionalStatement());
		psesudoStatementEClass.getESuperTypes().add(this.getStatement());
		failEClass.getESuperTypes().add(this.getPsesudoStatement());
		skipEClass.getESuperTypes().add(this.getPsesudoStatement());
		assignStatementEClass.getESuperTypes().add(this.getStatement());

		// Initialize classes and features; add operations and parameters
		initEClass(statementEClass, Statement.class, "Statement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(updateStatementEClass, UpdateStatement.class, "UpdateStatement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getUpdateStatement_Source(), thePatternPackage.getPattern(), null, "source", null, 1, 1, UpdateStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getUpdateStatement_View(), thePatternPackage.getPattern(), null, "view", null, 1, 1, UpdateStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getUpdateStatement_Clauses(), this.getUpdateClause(), null, "clauses", null, 1, -1, UpdateStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(switchStatementEClass, SwitchStatement.class, "SwitchStatement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSwitchStatement_Root(), theExpressionPackage.getVariableExpression(), null, "root", null, 1, 1, SwitchStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSwitchStatement_Cases(), this.getCaseClause(), null, "cases", null, 1, -1, SwitchStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(updateClauseEClass, UpdateClause.class, "UpdateClause", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getUpdateClause_Type(), this.getActionType(), "type", "default", 1, 1, UpdateClause.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getUpdateClause_Statement(), this.getStatement(), null, "statement", null, 1, 1, UpdateClause.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(caseClauseEClass, CaseClause.class, "CaseClause", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCaseClause_Action(), this.getStatement(), null, "action", null, 1, 1, CaseClause.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(patternCaseClauseEClass, PatternCaseClause.class, "PatternCaseClause", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPatternCaseClause_Condition(), thePatternPackage.getPattern(), null, "condition", null, 1, 1, PatternCaseClause.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(expressionCaseClauseEClass, ExpressionCaseClause.class, "ExpressionCaseClause", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getExpressionCaseClause_Condition(), theExpressionPackage.getExpression(), null, "condition", null, 1, 1, ExpressionCaseClause.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(defaultCaseClauseEClass, DefaultCaseClause.class, "DefaultCaseClause", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(defaultCaseStatementEClass, DefaultCaseStatement.class, "DefaultCaseStatement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(unidirectionalStatementEClass, UnidirectionalStatement.class, "UnidirectionalStatement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(bidirectionalStatementEClass, BidirectionalStatement.class, "BidirectionalStatement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(enforcePatternStatementEClass, EnforcePatternStatement.class, "EnforcePatternStatement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getEnforcePatternStatement_Pattern(), thePatternPackage.getPattern(), null, "pattern", null, 1, 1, EnforcePatternStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(deleteNodeStatementEClass, DeleteNodeStatement.class, "DeleteNodeStatement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDeleteNodeStatement_Node(), theExpressionPackage.getVariableExpression(), null, "node", null, 1, 1, DeleteNodeStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(deleteLinkStatementEClass, DeleteLinkStatement.class, "DeleteLinkStatement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDeleteLinkStatement_Source(), theExpressionPackage.getVariableExpression(), null, "source", null, 1, 1, DeleteLinkStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDeleteLinkStatement_Target(), theExpressionPackage.getExpression(), null, "target", null, 1, 1, DeleteLinkStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDeleteLinkStatement_Feature(), ecorePackage.getEString(), "feature", null, 1, 1, DeleteLinkStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(concreteDeleteLinkStatementEClass, ConcreteDeleteLinkStatement.class, "ConcreteDeleteLinkStatement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(reflectiveDeleteLinkStatementEClass, ReflectiveDeleteLinkStatement.class, "ReflectiveDeleteLinkStatement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(forEachStatementEClass, ForEachStatement.class, "ForEachStatement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getForEachStatement_Pattern(), thePatternPackage.getPattern(), null, "pattern", null, 1, 1, ForEachStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getForEachStatement_Action(), this.getStatement(), null, "action", null, 1, 1, ForEachStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(blockStatementEClass, BlockStatement.class, "BlockStatement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getBlockStatement_Body(), this.getStatement(), null, "body", null, 0, -1, BlockStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(ruleCallStatementEClass, RuleCallStatement.class, "RuleCallStatement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRuleCallStatement_Rule(), theXmu2Package.getAbstractRule(), null, "rule", null, 1, 1, RuleCallStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRuleCallStatement_Parameters(), theExpressionPackage.getExpression(), null, "parameters", null, 0, -1, RuleCallStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(psesudoStatementEClass, PsesudoStatement.class, "PsesudoStatement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(failEClass, Fail.class, "Fail", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getFail_Message(), ecorePackage.getEString(), "message", null, 0, 1, Fail.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(skipEClass, Skip.class, "Skip", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(assignStatementEClass, AssignStatement.class, "AssignStatement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAssignStatement_UpdatedVariable(), theExpressionPackage.getVariableExpression(), null, "updatedVariable", null, 1, 1, AssignStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAssignStatement_Value(), theExpressionPackage.getExpression(), null, "value", null, 1, 1, AssignStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(actionTypeEEnum, ActionType.class, "ActionType");
		addEEnumLiteral(actionTypeEEnum, ActionType.DEFAULT);
		addEEnumLiteral(actionTypeEEnum, ActionType.MATCH);
		addEEnumLiteral(actionTypeEEnum, ActionType.UNMATCHS);
		addEEnumLiteral(actionTypeEEnum, ActionType.UNMATCHV);
	}

} //StatementPackageImpl
