/**
 */
package edu.ustb.sei.mde.xmu2core.util;

import edu.ustb.sei.mde.xmu2common.DomainElement;
import edu.ustb.sei.mde.xmu2common.NamedElement;

import edu.ustb.sei.mde.xmu2core.*;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see edu.ustb.sei.mde.xmu2core.Xmu2corePackage
 * @generated
 */
public class Xmu2coreAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static Xmu2corePackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Xmu2coreAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = Xmu2corePackage.eINSTANCE;
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
	protected Xmu2coreSwitch<Adapter> modelSwitch =
		new Xmu2coreSwitch<Adapter>() {
			@Override
			public Adapter caseTypedElement(TypedElement object) {
				return createTypedElementAdapter();
			}
			@Override
			public Adapter caseProcedure(Procedure object) {
				return createProcedureAdapter();
			}
			@Override
			public Adapter caseVariable(Variable object) {
				return createVariableAdapter();
			}
			@Override
			public Adapter caseStatement(Statement object) {
				return createStatementAdapter();
			}
			@Override
			public Adapter caseAlignStatement(AlignStatement object) {
				return createAlignStatementAdapter();
			}
			@Override
			public Adapter caseCaseStatement(CaseStatement object) {
				return createCaseStatementAdapter();
			}
			@Override
			public Adapter caseCaseClause(CaseClause object) {
				return createCaseClauseAdapter();
			}
			@Override
			public Adapter caseCasePatternClause(CasePatternClause object) {
				return createCasePatternClauseAdapter();
			}
			@Override
			public Adapter caseCaseExpressionClause(CaseExpressionClause object) {
				return createCaseExpressionClauseAdapter();
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
			public Adapter casePatternExpression(PatternExpression object) {
				return createPatternExpressionAdapter();
			}
			@Override
			public Adapter caseObjectPatternExpression(ObjectPatternExpression object) {
				return createObjectPatternExpressionAdapter();
			}
			@Override
			public Adapter casePropertyPatternExpression(PropertyPatternExpression object) {
				return createPropertyPatternExpressionAdapter();
			}
			@Override
			public Adapter caseExpression(Expression object) {
				return createExpressionAdapter();
			}
			@Override
			public Adapter caseBooleanOrExpression(BooleanOrExpression object) {
				return createBooleanOrExpressionAdapter();
			}
			@Override
			public Adapter caseBooleanAndExpression(BooleanAndExpression object) {
				return createBooleanAndExpressionAdapter();
			}
			@Override
			public Adapter caseRelationalExpression(RelationalExpression object) {
				return createRelationalExpressionAdapter();
			}
			@Override
			public Adapter caseAdditiveExpression(AdditiveExpression object) {
				return createAdditiveExpressionAdapter();
			}
			@Override
			public Adapter caseMultiplicativeExpression(MultiplicativeExpression object) {
				return createMultiplicativeExpressionAdapter();
			}
			@Override
			public Adapter caseUnaryExpression(UnaryExpression object) {
				return createUnaryExpressionAdapter();
			}
			@Override
			public Adapter caseAtomicExpression(AtomicExpression object) {
				return createAtomicExpressionAdapter();
			}
			@Override
			public Adapter caseTypeCastExpression(TypeCastExpression object) {
				return createTypeCastExpressionAdapter();
			}
			@Override
			public Adapter casePrimitiveValueExpression(PrimitiveValueExpression object) {
				return createPrimitiveValueExpressionAdapter();
			}
			@Override
			public Adapter caseStringValueExpression(StringValueExpression object) {
				return createStringValueExpressionAdapter();
			}
			@Override
			public Adapter caseBooleanValueExpression(BooleanValueExpression object) {
				return createBooleanValueExpressionAdapter();
			}
			@Override
			public Adapter caseIntegerValueExpression(IntegerValueExpression object) {
				return createIntegerValueExpressionAdapter();
			}
			@Override
			public Adapter caseEnumValueExpression(EnumValueExpression object) {
				return createEnumValueExpressionAdapter();
			}
			@Override
			public Adapter caseEmptyValueExpression(EmptyValueExpression object) {
				return createEmptyValueExpressionAdapter();
			}
			@Override
			public Adapter caseObjectValueExpression(ObjectValueExpression object) {
				return createObjectValueExpressionAdapter();
			}
			@Override
			public Adapter caseVariableExpression(VariableExpression object) {
				return createVariableExpressionAdapter();
			}
			@Override
			public Adapter casePath(Path object) {
				return createPathAdapter();
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
			public Adapter casePositionPath(PositionPath object) {
				return createPositionPathAdapter();
			}
			@Override
			public Adapter caseProcedureCallStatement(ProcedureCallStatement object) {
				return createProcedureCallStatementAdapter();
			}
			@Override
			public Adapter caseTransformation(Transformation object) {
				return createTransformationAdapter();
			}
			@Override
			public Adapter caseEntryRuleParameter(EntryRuleParameter object) {
				return createEntryRuleParameterAdapter();
			}
			@Override
			public Adapter caseForEachStatement(ForEachStatement object) {
				return createForEachStatementAdapter();
			}
			@Override
			public Adapter caseDeleteNodeStatement(DeleteNodeStatement object) {
				return createDeleteNodeStatementAdapter();
			}
			@Override
			public Adapter caseDeleteLinkStatement(DeleteLinkStatement object) {
				return createDeleteLinkStatementAdapter();
			}
			@Override
			public Adapter caseEnforceNodeStatement(EnforceNodeStatement object) {
				return createEnforceNodeStatementAdapter();
			}
			@Override
			public Adapter caseEnforceLinkStatement(EnforceLinkStatement object) {
				return createEnforceLinkStatementAdapter();
			}
			@Override
			public Adapter caseOclCollectionType(OclCollectionType object) {
				return createOclCollectionTypeAdapter();
			}
			@Override
			public Adapter caseOclCollection(OclCollection object) {
				return createOclCollectionAdapter();
			}
			@Override
			public Adapter caseMatchPattern(MatchPattern object) {
				return createMatchPatternAdapter();
			}
			@Override
			public Adapter caseNamedElement(NamedElement object) {
				return createNamedElementAdapter();
			}
			@Override
			public Adapter caseDomainElement(DomainElement object) {
				return createDomainElementAdapter();
			}
			@Override
			public Adapter caseEModelElement(EModelElement object) {
				return createEModelElementAdapter();
			}
			@Override
			public Adapter caseENamedElement(ENamedElement object) {
				return createENamedElementAdapter();
			}
			@Override
			public Adapter caseEClassifier(EClassifier object) {
				return createEClassifierAdapter();
			}
			@Override
			public Adapter caseEClass(EClass object) {
				return createEClassAdapter();
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
	 * Creates a new adapter for an object of class '{@link edu.ustb.sei.mde.xmu2core.TypedElement <em>Typed Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see edu.ustb.sei.mde.xmu2core.TypedElement
	 * @generated
	 */
	public Adapter createTypedElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link edu.ustb.sei.mde.xmu2core.Procedure <em>Procedure</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see edu.ustb.sei.mde.xmu2core.Procedure
	 * @generated
	 */
	public Adapter createProcedureAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link edu.ustb.sei.mde.xmu2core.Variable <em>Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see edu.ustb.sei.mde.xmu2core.Variable
	 * @generated
	 */
	public Adapter createVariableAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link edu.ustb.sei.mde.xmu2core.Statement <em>Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see edu.ustb.sei.mde.xmu2core.Statement
	 * @generated
	 */
	public Adapter createStatementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link edu.ustb.sei.mde.xmu2core.AlignStatement <em>Align Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see edu.ustb.sei.mde.xmu2core.AlignStatement
	 * @generated
	 */
	public Adapter createAlignStatementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link edu.ustb.sei.mde.xmu2core.CaseStatement <em>Case Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see edu.ustb.sei.mde.xmu2core.CaseStatement
	 * @generated
	 */
	public Adapter createCaseStatementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link edu.ustb.sei.mde.xmu2core.CaseClause <em>Case Clause</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see edu.ustb.sei.mde.xmu2core.CaseClause
	 * @generated
	 */
	public Adapter createCaseClauseAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link edu.ustb.sei.mde.xmu2core.CasePatternClause <em>Case Pattern Clause</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see edu.ustb.sei.mde.xmu2core.CasePatternClause
	 * @generated
	 */
	public Adapter createCasePatternClauseAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link edu.ustb.sei.mde.xmu2core.CaseExpressionClause <em>Case Expression Clause</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see edu.ustb.sei.mde.xmu2core.CaseExpressionClause
	 * @generated
	 */
	public Adapter createCaseExpressionClauseAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link edu.ustb.sei.mde.xmu2core.Pattern <em>Pattern</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see edu.ustb.sei.mde.xmu2core.Pattern
	 * @generated
	 */
	public Adapter createPatternAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link edu.ustb.sei.mde.xmu2core.PatternNode <em>Pattern Node</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see edu.ustb.sei.mde.xmu2core.PatternNode
	 * @generated
	 */
	public Adapter createPatternNodeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link edu.ustb.sei.mde.xmu2core.PatternExpression <em>Pattern Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see edu.ustb.sei.mde.xmu2core.PatternExpression
	 * @generated
	 */
	public Adapter createPatternExpressionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link edu.ustb.sei.mde.xmu2core.ObjectPatternExpression <em>Object Pattern Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see edu.ustb.sei.mde.xmu2core.ObjectPatternExpression
	 * @generated
	 */
	public Adapter createObjectPatternExpressionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link edu.ustb.sei.mde.xmu2core.PropertyPatternExpression <em>Property Pattern Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see edu.ustb.sei.mde.xmu2core.PropertyPatternExpression
	 * @generated
	 */
	public Adapter createPropertyPatternExpressionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link edu.ustb.sei.mde.xmu2core.Expression <em>Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see edu.ustb.sei.mde.xmu2core.Expression
	 * @generated
	 */
	public Adapter createExpressionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link edu.ustb.sei.mde.xmu2core.BooleanOrExpression <em>Boolean Or Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see edu.ustb.sei.mde.xmu2core.BooleanOrExpression
	 * @generated
	 */
	public Adapter createBooleanOrExpressionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link edu.ustb.sei.mde.xmu2core.BooleanAndExpression <em>Boolean And Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see edu.ustb.sei.mde.xmu2core.BooleanAndExpression
	 * @generated
	 */
	public Adapter createBooleanAndExpressionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link edu.ustb.sei.mde.xmu2core.RelationalExpression <em>Relational Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see edu.ustb.sei.mde.xmu2core.RelationalExpression
	 * @generated
	 */
	public Adapter createRelationalExpressionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link edu.ustb.sei.mde.xmu2core.AdditiveExpression <em>Additive Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see edu.ustb.sei.mde.xmu2core.AdditiveExpression
	 * @generated
	 */
	public Adapter createAdditiveExpressionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link edu.ustb.sei.mde.xmu2core.MultiplicativeExpression <em>Multiplicative Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see edu.ustb.sei.mde.xmu2core.MultiplicativeExpression
	 * @generated
	 */
	public Adapter createMultiplicativeExpressionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link edu.ustb.sei.mde.xmu2core.UnaryExpression <em>Unary Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see edu.ustb.sei.mde.xmu2core.UnaryExpression
	 * @generated
	 */
	public Adapter createUnaryExpressionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link edu.ustb.sei.mde.xmu2core.AtomicExpression <em>Atomic Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see edu.ustb.sei.mde.xmu2core.AtomicExpression
	 * @generated
	 */
	public Adapter createAtomicExpressionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link edu.ustb.sei.mde.xmu2core.TypeCastExpression <em>Type Cast Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see edu.ustb.sei.mde.xmu2core.TypeCastExpression
	 * @generated
	 */
	public Adapter createTypeCastExpressionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link edu.ustb.sei.mde.xmu2core.PrimitiveValueExpression <em>Primitive Value Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see edu.ustb.sei.mde.xmu2core.PrimitiveValueExpression
	 * @generated
	 */
	public Adapter createPrimitiveValueExpressionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link edu.ustb.sei.mde.xmu2core.StringValueExpression <em>String Value Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see edu.ustb.sei.mde.xmu2core.StringValueExpression
	 * @generated
	 */
	public Adapter createStringValueExpressionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link edu.ustb.sei.mde.xmu2core.BooleanValueExpression <em>Boolean Value Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see edu.ustb.sei.mde.xmu2core.BooleanValueExpression
	 * @generated
	 */
	public Adapter createBooleanValueExpressionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link edu.ustb.sei.mde.xmu2core.IntegerValueExpression <em>Integer Value Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see edu.ustb.sei.mde.xmu2core.IntegerValueExpression
	 * @generated
	 */
	public Adapter createIntegerValueExpressionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link edu.ustb.sei.mde.xmu2core.EnumValueExpression <em>Enum Value Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see edu.ustb.sei.mde.xmu2core.EnumValueExpression
	 * @generated
	 */
	public Adapter createEnumValueExpressionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link edu.ustb.sei.mde.xmu2core.EmptyValueExpression <em>Empty Value Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see edu.ustb.sei.mde.xmu2core.EmptyValueExpression
	 * @generated
	 */
	public Adapter createEmptyValueExpressionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link edu.ustb.sei.mde.xmu2core.ObjectValueExpression <em>Object Value Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see edu.ustb.sei.mde.xmu2core.ObjectValueExpression
	 * @generated
	 */
	public Adapter createObjectValueExpressionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link edu.ustb.sei.mde.xmu2core.VariableExpression <em>Variable Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see edu.ustb.sei.mde.xmu2core.VariableExpression
	 * @generated
	 */
	public Adapter createVariableExpressionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link edu.ustb.sei.mde.xmu2core.Path <em>Path</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see edu.ustb.sei.mde.xmu2core.Path
	 * @generated
	 */
	public Adapter createPathAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link edu.ustb.sei.mde.xmu2core.FeaturePath <em>Feature Path</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see edu.ustb.sei.mde.xmu2core.FeaturePath
	 * @generated
	 */
	public Adapter createFeaturePathAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link edu.ustb.sei.mde.xmu2core.OperationPath <em>Operation Path</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see edu.ustb.sei.mde.xmu2core.OperationPath
	 * @generated
	 */
	public Adapter createOperationPathAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link edu.ustb.sei.mde.xmu2core.LoopPath <em>Loop Path</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see edu.ustb.sei.mde.xmu2core.LoopPath
	 * @generated
	 */
	public Adapter createLoopPathAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link edu.ustb.sei.mde.xmu2core.PositionPath <em>Position Path</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see edu.ustb.sei.mde.xmu2core.PositionPath
	 * @generated
	 */
	public Adapter createPositionPathAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link edu.ustb.sei.mde.xmu2core.ProcedureCallStatement <em>Procedure Call Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see edu.ustb.sei.mde.xmu2core.ProcedureCallStatement
	 * @generated
	 */
	public Adapter createProcedureCallStatementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link edu.ustb.sei.mde.xmu2core.Transformation <em>Transformation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see edu.ustb.sei.mde.xmu2core.Transformation
	 * @generated
	 */
	public Adapter createTransformationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link edu.ustb.sei.mde.xmu2core.EntryRuleParameter <em>Entry Rule Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see edu.ustb.sei.mde.xmu2core.EntryRuleParameter
	 * @generated
	 */
	public Adapter createEntryRuleParameterAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link edu.ustb.sei.mde.xmu2core.ForEachStatement <em>For Each Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see edu.ustb.sei.mde.xmu2core.ForEachStatement
	 * @generated
	 */
	public Adapter createForEachStatementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link edu.ustb.sei.mde.xmu2core.DeleteNodeStatement <em>Delete Node Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see edu.ustb.sei.mde.xmu2core.DeleteNodeStatement
	 * @generated
	 */
	public Adapter createDeleteNodeStatementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link edu.ustb.sei.mde.xmu2core.DeleteLinkStatement <em>Delete Link Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see edu.ustb.sei.mde.xmu2core.DeleteLinkStatement
	 * @generated
	 */
	public Adapter createDeleteLinkStatementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link edu.ustb.sei.mde.xmu2core.EnforceNodeStatement <em>Enforce Node Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see edu.ustb.sei.mde.xmu2core.EnforceNodeStatement
	 * @generated
	 */
	public Adapter createEnforceNodeStatementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link edu.ustb.sei.mde.xmu2core.EnforceLinkStatement <em>Enforce Link Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see edu.ustb.sei.mde.xmu2core.EnforceLinkStatement
	 * @generated
	 */
	public Adapter createEnforceLinkStatementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link edu.ustb.sei.mde.xmu2core.OclCollectionType <em>Ocl Collection Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see edu.ustb.sei.mde.xmu2core.OclCollectionType
	 * @generated
	 */
	public Adapter createOclCollectionTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link edu.ustb.sei.mde.xmu2core.OclCollection <em>Ocl Collection</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see edu.ustb.sei.mde.xmu2core.OclCollection
	 * @generated
	 */
	public Adapter createOclCollectionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link edu.ustb.sei.mde.xmu2core.MatchPattern <em>Match Pattern</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see edu.ustb.sei.mde.xmu2core.MatchPattern
	 * @generated
	 */
	public Adapter createMatchPatternAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link edu.ustb.sei.mde.xmu2common.NamedElement <em>Named Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see edu.ustb.sei.mde.xmu2common.NamedElement
	 * @generated
	 */
	public Adapter createNamedElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link edu.ustb.sei.mde.xmu2common.DomainElement <em>Domain Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see edu.ustb.sei.mde.xmu2common.DomainElement
	 * @generated
	 */
	public Adapter createDomainElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.ecore.EModelElement <em>EModel Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.ecore.EModelElement
	 * @generated
	 */
	public Adapter createEModelElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.ecore.ENamedElement <em>ENamed Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.ecore.ENamedElement
	 * @generated
	 */
	public Adapter createENamedElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.ecore.EClassifier <em>EClassifier</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.ecore.EClassifier
	 * @generated
	 */
	public Adapter createEClassifierAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.ecore.EClass <em>EClass</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.ecore.EClass
	 * @generated
	 */
	public Adapter createEClassAdapter() {
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

} //Xmu2coreAdapterFactory
