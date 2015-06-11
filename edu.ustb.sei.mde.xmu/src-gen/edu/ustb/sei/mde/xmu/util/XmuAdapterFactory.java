/**
 */
package edu.ustb.sei.mde.xmu.util;

import edu.ustb.sei.mde.xmu.*;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see edu.ustb.sei.mde.xmu.XmuPackage
 * @generated
 */
public class XmuAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static XmuPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XmuAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = XmuPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected XmuSwitch<Adapter> modelSwitch =
		new XmuSwitch<Adapter>() {
			@Override
			public Adapter caseNamedElement(NamedElement object) {
				return createNamedElementAdapter();
			}
			@Override
			public Adapter caseVariable(Variable object) {
				return createVariableAdapter();
			}
			@Override
			public Adapter caseObjectVariable(ObjectVariable object) {
				return createObjectVariableAdapter();
			}
			@Override
			public Adapter casePrimitiveVariable(PrimitiveVariable object) {
				return createPrimitiveVariableAdapter();
			}
			@Override
			public Adapter caseRule(Rule object) {
				return createRuleAdapter();
			}
			@Override
			public Adapter caseStatement(Statement object) {
				return createStatementAdapter();
			}
			@Override
			public Adapter caseForStatement(ForStatement object) {
				return createForStatementAdapter();
			}
			@Override
			public Adapter caseUpdate(Update object) {
				return createUpdateAdapter();
			}
			@Override
			public Adapter caseDeleteNode(DeleteNode object) {
				return createDeleteNodeAdapter();
			}
			@Override
			public Adapter caseDeleteLink(DeleteLink object) {
				return createDeleteLinkAdapter();
			}
			@Override
			public Adapter caseUpdatePattern(UpdatePattern object) {
				return createUpdatePatternAdapter();
			}
			@Override
			public Adapter casePattern(Pattern object) {
				return createPatternAdapter();
			}
			@Override
			public Adapter casePatternNode(PatternNode object) {
				return createPatternNodeAdapter();
			}
			@Override
			public Adapter casePatternExpr(PatternExpr object) {
				return createPatternExprAdapter();
			}
			@Override
			public Adapter casePatternReferenceExpr(PatternReferenceExpr object) {
				return createPatternReferenceExprAdapter();
			}
			@Override
			public Adapter casePatternEqualExpr(PatternEqualExpr object) {
				return createPatternEqualExprAdapter();
			}
			@Override
			public Adapter caseExpr(Expr object) {
				return createExprAdapter();
			}
			@Override
			public Adapter caseVariableExp(VariableExp object) {
				return createVariableExpAdapter();
			}
			@Override
			public Adapter caseConstantExpr(ConstantExpr object) {
				return createConstantExprAdapter();
			}
			@Override
			public Adapter caseEmptyLiteral(EmptyLiteral object) {
				return createEmptyLiteralAdapter();
			}
			@Override
			public Adapter caseStringLiteral(StringLiteral object) {
				return createStringLiteralAdapter();
			}
			@Override
			public Adapter caseIntegerLiteral(IntegerLiteral object) {
				return createIntegerLiteralAdapter();
			}
			@Override
			public Adapter caseBooleanLiteral(BooleanLiteral object) {
				return createBooleanLiteralAdapter();
			}
			@Override
			public Adapter caseEnumLiteral(EnumLiteral object) {
				return createEnumLiteralAdapter();
			}
			@Override
			public Adapter caseVStatement(VStatement object) {
				return createVStatementAdapter();
			}
			@Override
			public Adapter caseBlockStatement(BlockStatement object) {
				return createBlockStatementAdapter();
			}
			@Override
			public Adapter caseSwitchStatement(SwitchStatement object) {
				return createSwitchStatementAdapter();
			}
			@Override
			public Adapter caseTaggedElement(TaggedElement object) {
				return createTaggedElementAdapter();
			}
			@Override
			public Adapter caseCaseSubStatement(CaseSubStatement object) {
				return createCaseSubStatementAdapter();
			}
			@Override
			public Adapter caseCasePatternStatement(CasePatternStatement object) {
				return createCasePatternStatementAdapter();
			}
			@Override
			public Adapter caseCaseValueStatement(CaseValueStatement object) {
				return createCaseValueStatementAdapter();
			}
			@Override
			public Adapter caseCaseDefaultStatement(CaseDefaultStatement object) {
				return createCaseDefaultStatementAdapter();
			}
			@Override
			public Adapter caseXMUModel(XMUModel object) {
				return createXMUModelAdapter();
			}
			@Override
			public Adapter caseParameter(Parameter object) {
				return createParameterAdapter();
			}
			@Override
			public Adapter caseRuleCallStatement(RuleCallStatement object) {
				return createRuleCallStatementAdapter();
			}
			@Override
			public Adapter caseUpdatedStatement(UpdatedStatement object) {
				return createUpdatedStatementAdapter();
			}
			@Override
			public Adapter caseBooleanOrExpr(BooleanOrExpr object) {
				return createBooleanOrExprAdapter();
			}
			@Override
			public Adapter caseBooleanOrExprChild(BooleanOrExprChild object) {
				return createBooleanOrExprChildAdapter();
			}
			@Override
			public Adapter caseBooleanAndExpr(BooleanAndExpr object) {
				return createBooleanAndExprAdapter();
			}
			@Override
			public Adapter caseBooleanAndExprChild(BooleanAndExprChild object) {
				return createBooleanAndExprChildAdapter();
			}
			@Override
			public Adapter caseRelationalExpr(RelationalExpr object) {
				return createRelationalExprAdapter();
			}
			@Override
			public Adapter caseRelationalExprChild(RelationalExprChild object) {
				return createRelationalExprChildAdapter();
			}
			@Override
			public Adapter caseAdditiveExpr(AdditiveExpr object) {
				return createAdditiveExprAdapter();
			}
			@Override
			public Adapter caseAdditiveExprChild(AdditiveExprChild object) {
				return createAdditiveExprChildAdapter();
			}
			@Override
			public Adapter caseMultiplicativeExpr(MultiplicativeExpr object) {
				return createMultiplicativeExprAdapter();
			}
			@Override
			public Adapter caseMultiplicativeExprChild(MultiplicativeExprChild object) {
				return createMultiplicativeExprChildAdapter();
			}
			@Override
			public Adapter caseUnaryExpr(UnaryExpr object) {
				return createUnaryExprAdapter();
			}
			@Override
			public Adapter caseUnaryExprChild(UnaryExprChild object) {
				return createUnaryExprChildAdapter();
			}
			@Override
			public Adapter caseAtomicExpr(AtomicExpr object) {
				return createAtomicExprAdapter();
			}
			@Override
			public Adapter caseParenExpr(ParenExpr object) {
				return createParenExprAdapter();
			}
			@Override
			public Adapter casePath(Path object) {
				return createPathAdapter();
			}
			@Override
			public Adapter caseHelperPath(HelperPath object) {
				return createHelperPathAdapter();
			}
			@Override
			public Adapter caseFeaturePath(FeaturePath object) {
				return createFeaturePathAdapter();
			}
			@Override
			public Adapter caseOperationPath(OperationPath object) {
				return createOperationPathAdapter();
			}
			@Override
			public Adapter caseLoopPath(LoopPath object) {
				return createLoopPathAdapter();
			}
			@Override
			public Adapter caseStartStatement(StartStatement object) {
				return createStartStatementAdapter();
			}
			@Override
			public Adapter caseStartRoot(StartRoot object) {
				return createStartRootAdapter();
			}
			@Override
			public Adapter caseEResource(EResource object) {
				return createEResourceAdapter();
			}
			@Override
			public Adapter casePrintStatement(PrintStatement object) {
				return createPrintStatementAdapter();
			}
			@Override
			public Adapter caseAllInstanceExpr(AllInstanceExpr object) {
				return createAllInstanceExprAdapter();
			}
			@Override
			public Adapter caseESet(ESet object) {
				return createESetAdapter();
			}
			@Override
			public Adapter caseObjectPathExpr(ObjectPathExpr object) {
				return createObjectPathExprAdapter();
			}
			@Override
			public Adapter caseInitialMappingStatement(InitialMappingStatement object) {
				return createInitialMappingStatementAdapter();
			}
			@Override
			public Adapter caseHelperMapping(HelperMapping object) {
				return createHelperMappingAdapter();
			}
			@Override
			public Adapter caseHelperMappingEntry(HelperMappingEntry object) {
				return createHelperMappingEntryAdapter();
			}
			@Override
			public Adapter casePseudoUpdate(PseudoUpdate object) {
				return createPseudoUpdateAdapter();
			}
			@Override
			public Adapter caseSkip(Skip object) {
				return createSkipAdapter();
			}
			@Override
			public Adapter caseFail(Fail object) {
				return createFailAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link edu.ustb.sei.mde.xmu.NamedElement <em>Named Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see edu.ustb.sei.mde.xmu.NamedElement
	 * @generated
	 */
	public Adapter createNamedElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link edu.ustb.sei.mde.xmu.Variable <em>Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see edu.ustb.sei.mde.xmu.Variable
	 * @generated
	 */
	public Adapter createVariableAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link edu.ustb.sei.mde.xmu.ObjectVariable <em>Object Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see edu.ustb.sei.mde.xmu.ObjectVariable
	 * @generated
	 */
	public Adapter createObjectVariableAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link edu.ustb.sei.mde.xmu.PrimitiveVariable <em>Primitive Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see edu.ustb.sei.mde.xmu.PrimitiveVariable
	 * @generated
	 */
	public Adapter createPrimitiveVariableAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link edu.ustb.sei.mde.xmu.Rule <em>Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see edu.ustb.sei.mde.xmu.Rule
	 * @generated
	 */
	public Adapter createRuleAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link edu.ustb.sei.mde.xmu.Statement <em>Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see edu.ustb.sei.mde.xmu.Statement
	 * @generated
	 */
	public Adapter createStatementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link edu.ustb.sei.mde.xmu.ForStatement <em>For Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see edu.ustb.sei.mde.xmu.ForStatement
	 * @generated
	 */
	public Adapter createForStatementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link edu.ustb.sei.mde.xmu.Update <em>Update</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see edu.ustb.sei.mde.xmu.Update
	 * @generated
	 */
	public Adapter createUpdateAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link edu.ustb.sei.mde.xmu.DeleteNode <em>Delete Node</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see edu.ustb.sei.mde.xmu.DeleteNode
	 * @generated
	 */
	public Adapter createDeleteNodeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link edu.ustb.sei.mde.xmu.DeleteLink <em>Delete Link</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see edu.ustb.sei.mde.xmu.DeleteLink
	 * @generated
	 */
	public Adapter createDeleteLinkAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link edu.ustb.sei.mde.xmu.UpdatePattern <em>Update Pattern</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see edu.ustb.sei.mde.xmu.UpdatePattern
	 * @generated
	 */
	public Adapter createUpdatePatternAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link edu.ustb.sei.mde.xmu.Pattern <em>Pattern</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see edu.ustb.sei.mde.xmu.Pattern
	 * @generated
	 */
	public Adapter createPatternAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link edu.ustb.sei.mde.xmu.PatternNode <em>Pattern Node</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see edu.ustb.sei.mde.xmu.PatternNode
	 * @generated
	 */
	public Adapter createPatternNodeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link edu.ustb.sei.mde.xmu.PatternExpr <em>Pattern Expr</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see edu.ustb.sei.mde.xmu.PatternExpr
	 * @generated
	 */
	public Adapter createPatternExprAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link edu.ustb.sei.mde.xmu.PatternReferenceExpr <em>Pattern Reference Expr</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see edu.ustb.sei.mde.xmu.PatternReferenceExpr
	 * @generated
	 */
	public Adapter createPatternReferenceExprAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link edu.ustb.sei.mde.xmu.PatternEqualExpr <em>Pattern Equal Expr</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see edu.ustb.sei.mde.xmu.PatternEqualExpr
	 * @generated
	 */
	public Adapter createPatternEqualExprAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link edu.ustb.sei.mde.xmu.Expr <em>Expr</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see edu.ustb.sei.mde.xmu.Expr
	 * @generated
	 */
	public Adapter createExprAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link edu.ustb.sei.mde.xmu.VariableExp <em>Variable Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see edu.ustb.sei.mde.xmu.VariableExp
	 * @generated
	 */
	public Adapter createVariableExpAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link edu.ustb.sei.mde.xmu.ConstantExpr <em>Constant Expr</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see edu.ustb.sei.mde.xmu.ConstantExpr
	 * @generated
	 */
	public Adapter createConstantExprAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link edu.ustb.sei.mde.xmu.EmptyLiteral <em>Empty Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see edu.ustb.sei.mde.xmu.EmptyLiteral
	 * @generated
	 */
	public Adapter createEmptyLiteralAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link edu.ustb.sei.mde.xmu.StringLiteral <em>String Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see edu.ustb.sei.mde.xmu.StringLiteral
	 * @generated
	 */
	public Adapter createStringLiteralAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link edu.ustb.sei.mde.xmu.IntegerLiteral <em>Integer Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see edu.ustb.sei.mde.xmu.IntegerLiteral
	 * @generated
	 */
	public Adapter createIntegerLiteralAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link edu.ustb.sei.mde.xmu.BooleanLiteral <em>Boolean Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see edu.ustb.sei.mde.xmu.BooleanLiteral
	 * @generated
	 */
	public Adapter createBooleanLiteralAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link edu.ustb.sei.mde.xmu.EnumLiteral <em>Enum Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see edu.ustb.sei.mde.xmu.EnumLiteral
	 * @generated
	 */
	public Adapter createEnumLiteralAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link edu.ustb.sei.mde.xmu.VStatement <em>VStatement</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see edu.ustb.sei.mde.xmu.VStatement
	 * @generated
	 */
	public Adapter createVStatementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link edu.ustb.sei.mde.xmu.BlockStatement <em>Block Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see edu.ustb.sei.mde.xmu.BlockStatement
	 * @generated
	 */
	public Adapter createBlockStatementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link edu.ustb.sei.mde.xmu.SwitchStatement <em>Switch Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see edu.ustb.sei.mde.xmu.SwitchStatement
	 * @generated
	 */
	public Adapter createSwitchStatementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link edu.ustb.sei.mde.xmu.TaggedElement <em>Tagged Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see edu.ustb.sei.mde.xmu.TaggedElement
	 * @generated
	 */
	public Adapter createTaggedElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link edu.ustb.sei.mde.xmu.CaseSubStatement <em>Case Sub Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see edu.ustb.sei.mde.xmu.CaseSubStatement
	 * @generated
	 */
	public Adapter createCaseSubStatementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link edu.ustb.sei.mde.xmu.CasePatternStatement <em>Case Pattern Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see edu.ustb.sei.mde.xmu.CasePatternStatement
	 * @generated
	 */
	public Adapter createCasePatternStatementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link edu.ustb.sei.mde.xmu.CaseValueStatement <em>Case Value Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see edu.ustb.sei.mde.xmu.CaseValueStatement
	 * @generated
	 */
	public Adapter createCaseValueStatementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link edu.ustb.sei.mde.xmu.CaseDefaultStatement <em>Case Default Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see edu.ustb.sei.mde.xmu.CaseDefaultStatement
	 * @generated
	 */
	public Adapter createCaseDefaultStatementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link edu.ustb.sei.mde.xmu.XMUModel <em>XMU Model</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see edu.ustb.sei.mde.xmu.XMUModel
	 * @generated
	 */
	public Adapter createXMUModelAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link edu.ustb.sei.mde.xmu.Parameter <em>Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see edu.ustb.sei.mde.xmu.Parameter
	 * @generated
	 */
	public Adapter createParameterAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link edu.ustb.sei.mde.xmu.RuleCallStatement <em>Rule Call Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see edu.ustb.sei.mde.xmu.RuleCallStatement
	 * @generated
	 */
	public Adapter createRuleCallStatementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link edu.ustb.sei.mde.xmu.UpdatedStatement <em>Updated Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see edu.ustb.sei.mde.xmu.UpdatedStatement
	 * @generated
	 */
	public Adapter createUpdatedStatementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link edu.ustb.sei.mde.xmu.BooleanOrExpr <em>Boolean Or Expr</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see edu.ustb.sei.mde.xmu.BooleanOrExpr
	 * @generated
	 */
	public Adapter createBooleanOrExprAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link edu.ustb.sei.mde.xmu.BooleanOrExprChild <em>Boolean Or Expr Child</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see edu.ustb.sei.mde.xmu.BooleanOrExprChild
	 * @generated
	 */
	public Adapter createBooleanOrExprChildAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link edu.ustb.sei.mde.xmu.BooleanAndExpr <em>Boolean And Expr</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see edu.ustb.sei.mde.xmu.BooleanAndExpr
	 * @generated
	 */
	public Adapter createBooleanAndExprAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link edu.ustb.sei.mde.xmu.BooleanAndExprChild <em>Boolean And Expr Child</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see edu.ustb.sei.mde.xmu.BooleanAndExprChild
	 * @generated
	 */
	public Adapter createBooleanAndExprChildAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link edu.ustb.sei.mde.xmu.RelationalExpr <em>Relational Expr</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see edu.ustb.sei.mde.xmu.RelationalExpr
	 * @generated
	 */
	public Adapter createRelationalExprAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link edu.ustb.sei.mde.xmu.RelationalExprChild <em>Relational Expr Child</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see edu.ustb.sei.mde.xmu.RelationalExprChild
	 * @generated
	 */
	public Adapter createRelationalExprChildAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link edu.ustb.sei.mde.xmu.AdditiveExpr <em>Additive Expr</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see edu.ustb.sei.mde.xmu.AdditiveExpr
	 * @generated
	 */
	public Adapter createAdditiveExprAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link edu.ustb.sei.mde.xmu.AdditiveExprChild <em>Additive Expr Child</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see edu.ustb.sei.mde.xmu.AdditiveExprChild
	 * @generated
	 */
	public Adapter createAdditiveExprChildAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link edu.ustb.sei.mde.xmu.MultiplicativeExpr <em>Multiplicative Expr</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see edu.ustb.sei.mde.xmu.MultiplicativeExpr
	 * @generated
	 */
	public Adapter createMultiplicativeExprAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link edu.ustb.sei.mde.xmu.MultiplicativeExprChild <em>Multiplicative Expr Child</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see edu.ustb.sei.mde.xmu.MultiplicativeExprChild
	 * @generated
	 */
	public Adapter createMultiplicativeExprChildAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link edu.ustb.sei.mde.xmu.UnaryExpr <em>Unary Expr</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see edu.ustb.sei.mde.xmu.UnaryExpr
	 * @generated
	 */
	public Adapter createUnaryExprAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link edu.ustb.sei.mde.xmu.UnaryExprChild <em>Unary Expr Child</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see edu.ustb.sei.mde.xmu.UnaryExprChild
	 * @generated
	 */
	public Adapter createUnaryExprChildAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link edu.ustb.sei.mde.xmu.AtomicExpr <em>Atomic Expr</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see edu.ustb.sei.mde.xmu.AtomicExpr
	 * @generated
	 */
	public Adapter createAtomicExprAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link edu.ustb.sei.mde.xmu.ParenExpr <em>Paren Expr</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see edu.ustb.sei.mde.xmu.ParenExpr
	 * @generated
	 */
	public Adapter createParenExprAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link edu.ustb.sei.mde.xmu.Path <em>Path</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see edu.ustb.sei.mde.xmu.Path
	 * @generated
	 */
	public Adapter createPathAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link edu.ustb.sei.mde.xmu.HelperPath <em>Helper Path</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see edu.ustb.sei.mde.xmu.HelperPath
	 * @generated
	 */
	public Adapter createHelperPathAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link edu.ustb.sei.mde.xmu.FeaturePath <em>Feature Path</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see edu.ustb.sei.mde.xmu.FeaturePath
	 * @generated
	 */
	public Adapter createFeaturePathAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link edu.ustb.sei.mde.xmu.OperationPath <em>Operation Path</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see edu.ustb.sei.mde.xmu.OperationPath
	 * @generated
	 */
	public Adapter createOperationPathAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link edu.ustb.sei.mde.xmu.LoopPath <em>Loop Path</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see edu.ustb.sei.mde.xmu.LoopPath
	 * @generated
	 */
	public Adapter createLoopPathAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link edu.ustb.sei.mde.xmu.StartStatement <em>Start Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see edu.ustb.sei.mde.xmu.StartStatement
	 * @generated
	 */
	public Adapter createStartStatementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link edu.ustb.sei.mde.xmu.StartRoot <em>Start Root</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see edu.ustb.sei.mde.xmu.StartRoot
	 * @generated
	 */
	public Adapter createStartRootAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link edu.ustb.sei.mde.xmu.EResource <em>EResource</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see edu.ustb.sei.mde.xmu.EResource
	 * @generated
	 */
	public Adapter createEResourceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link edu.ustb.sei.mde.xmu.PrintStatement <em>Print Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see edu.ustb.sei.mde.xmu.PrintStatement
	 * @generated
	 */
	public Adapter createPrintStatementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link edu.ustb.sei.mde.xmu.AllInstanceExpr <em>All Instance Expr</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see edu.ustb.sei.mde.xmu.AllInstanceExpr
	 * @generated
	 */
	public Adapter createAllInstanceExprAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link edu.ustb.sei.mde.xmu.ESet <em>ESet</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see edu.ustb.sei.mde.xmu.ESet
	 * @generated
	 */
	public Adapter createESetAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link edu.ustb.sei.mde.xmu.ObjectPathExpr <em>Object Path Expr</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see edu.ustb.sei.mde.xmu.ObjectPathExpr
	 * @generated
	 */
	public Adapter createObjectPathExprAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link edu.ustb.sei.mde.xmu.InitialMappingStatement <em>Initial Mapping Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see edu.ustb.sei.mde.xmu.InitialMappingStatement
	 * @generated
	 */
	public Adapter createInitialMappingStatementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link edu.ustb.sei.mde.xmu.HelperMapping <em>Helper Mapping</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see edu.ustb.sei.mde.xmu.HelperMapping
	 * @generated
	 */
	public Adapter createHelperMappingAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link edu.ustb.sei.mde.xmu.HelperMappingEntry <em>Helper Mapping Entry</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see edu.ustb.sei.mde.xmu.HelperMappingEntry
	 * @generated
	 */
	public Adapter createHelperMappingEntryAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link edu.ustb.sei.mde.xmu.PseudoUpdate <em>Pseudo Update</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see edu.ustb.sei.mde.xmu.PseudoUpdate
	 * @generated
	 */
	public Adapter createPseudoUpdateAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link edu.ustb.sei.mde.xmu.Skip <em>Skip</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see edu.ustb.sei.mde.xmu.Skip
	 * @generated
	 */
	public Adapter createSkipAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link edu.ustb.sei.mde.xmu.Fail <em>Fail</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see edu.ustb.sei.mde.xmu.Fail
	 * @generated
	 */
	public Adapter createFailAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //XmuAdapterFactory
