/**
 */
package edu.ustb.sei.mde.xmu2.statement.impl;

import edu.ustb.sei.mde.xmu2.statement.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class StatementFactoryImpl extends EFactoryImpl implements StatementFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static StatementFactory init() {
		try {
			StatementFactory theStatementFactory = (StatementFactory)EPackage.Registry.INSTANCE.getEFactory(StatementPackage.eNS_URI);
			if (theStatementFactory != null) {
				return theStatementFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new StatementFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StatementFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case StatementPackage.UPDATE_STATEMENT: return createUpdateStatement();
			case StatementPackage.SWITCH_STATEMENT: return createSwitchStatement();
			case StatementPackage.UPDATE_CLAUSE: return createUpdateClause();
			case StatementPackage.PATTERN_CASE_CLAUSE: return createPatternCaseClause();
			case StatementPackage.EXPRESSION_CASE_CLAUSE: return createExpressionCaseClause();
			case StatementPackage.DEFAULT_CASE_CLAUSE: return createDefaultCaseClause();
			case StatementPackage.DEFAULT_CASE_STATEMENT: return createDefaultCaseStatement();
			case StatementPackage.ENFORCE_PATTERN_STATEMENT: return createEnforcePatternStatement();
			case StatementPackage.DELETE_NODE_STATEMENT: return createDeleteNodeStatement();
			case StatementPackage.DELETE_LINK_STATEMENT: return createDeleteLinkStatement();
			case StatementPackage.FOR_EACH_STATEMENT: return createForEachStatement();
			case StatementPackage.BLOCK_STATEMENT: return createBlockStatement();
			case StatementPackage.RULE_CALL_STATEMENT: return createRuleCallStatement();
			case StatementPackage.SKIP: return createSkip();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case StatementPackage.ACTION_TYPE:
				return createActionTypeFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case StatementPackage.ACTION_TYPE:
				return convertActionTypeToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UpdateStatement createUpdateStatement() {
		UpdateStatementImpl updateStatement = new UpdateStatementImpl();
		return updateStatement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SwitchStatement createSwitchStatement() {
		SwitchStatementImpl switchStatement = new SwitchStatementImpl();
		return switchStatement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UpdateClause createUpdateClause() {
		UpdateClauseImpl updateClause = new UpdateClauseImpl();
		return updateClause;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PatternCaseClause createPatternCaseClause() {
		PatternCaseClauseImpl patternCaseClause = new PatternCaseClauseImpl();
		return patternCaseClause;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExpressionCaseClause createExpressionCaseClause() {
		ExpressionCaseClauseImpl expressionCaseClause = new ExpressionCaseClauseImpl();
		return expressionCaseClause;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DefaultCaseClause createDefaultCaseClause() {
		DefaultCaseClauseImpl defaultCaseClause = new DefaultCaseClauseImpl();
		return defaultCaseClause;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DefaultCaseStatement createDefaultCaseStatement() {
		DefaultCaseStatementImpl defaultCaseStatement = new DefaultCaseStatementImpl();
		return defaultCaseStatement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EnforcePatternStatement createEnforcePatternStatement() {
		EnforcePatternStatementImpl enforcePatternStatement = new EnforcePatternStatementImpl();
		return enforcePatternStatement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DeleteNodeStatement createDeleteNodeStatement() {
		DeleteNodeStatementImpl deleteNodeStatement = new DeleteNodeStatementImpl();
		return deleteNodeStatement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DeleteLinkStatement createDeleteLinkStatement() {
		DeleteLinkStatementImpl deleteLinkStatement = new DeleteLinkStatementImpl();
		return deleteLinkStatement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ForEachStatement createForEachStatement() {
		ForEachStatementImpl forEachStatement = new ForEachStatementImpl();
		return forEachStatement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BlockStatement createBlockStatement() {
		BlockStatementImpl blockStatement = new BlockStatementImpl();
		return blockStatement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RuleCallStatement createRuleCallStatement() {
		RuleCallStatementImpl ruleCallStatement = new RuleCallStatementImpl();
		return ruleCallStatement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Skip createSkip() {
		SkipImpl skip = new SkipImpl();
		return skip;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ActionType createActionTypeFromString(EDataType eDataType, String initialValue) {
		ActionType result = ActionType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertActionTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StatementPackage getStatementPackage() {
		return (StatementPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static StatementPackage getPackage() {
		return StatementPackage.eINSTANCE;
	}

} //StatementFactoryImpl
