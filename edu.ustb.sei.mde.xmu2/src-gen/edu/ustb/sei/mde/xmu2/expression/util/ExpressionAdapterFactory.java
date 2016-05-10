/**
 */
package edu.ustb.sei.mde.xmu2.expression.util;

import edu.ustb.sei.mde.xmu2.expression.*;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see edu.ustb.sei.mde.xmu2.expression.ExpressionPackage
 * @generated
 */
public class ExpressionAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static ExpressionPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExpressionAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = ExpressionPackage.eINSTANCE;
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
	protected ExpressionSwitch<Adapter> modelSwitch =
		new ExpressionSwitch<Adapter>() {
			@Override
			public Adapter caseExpression(Expression object) {
				return createExpressionAdapter();
			}
			@Override
			public Adapter caseBooleanOrExpression(BooleanOrExpression object) {
				return createBooleanOrExpressionAdapter();
			}
			@Override
			public Adapter caseBooleanOrExpressionChild(BooleanOrExpressionChild object) {
				return createBooleanOrExpressionChildAdapter();
			}
			@Override
			public Adapter caseBooleanAndExpression(BooleanAndExpression object) {
				return createBooleanAndExpressionAdapter();
			}
			@Override
			public Adapter caseBooleanAndExpressionChild(BooleanAndExpressionChild object) {
				return createBooleanAndExpressionChildAdapter();
			}
			@Override
			public Adapter caseRelationalExpression(RelationalExpression object) {
				return createRelationalExpressionAdapter();
			}
			@Override
			public Adapter caseRelationalExpressionChild(RelationalExpressionChild object) {
				return createRelationalExpressionChildAdapter();
			}
			@Override
			public Adapter caseAdditiveExpression(AdditiveExpression object) {
				return createAdditiveExpressionAdapter();
			}
			@Override
			public Adapter caseAdditiveExpressionChild(AdditiveExpressionChild object) {
				return createAdditiveExpressionChildAdapter();
			}
			@Override
			public Adapter caseMultiplicativeExpression(MultiplicativeExpression object) {
				return createMultiplicativeExpressionAdapter();
			}
			@Override
			public Adapter caseMultiplicativeExpressionChild(MultiplicativeExpressionChild object) {
				return createMultiplicativeExpressionChildAdapter();
			}
			@Override
			public Adapter caseUnaryExpression(UnaryExpression object) {
				return createUnaryExpressionAdapter();
			}
			@Override
			public Adapter caseUnaryExpressionChild(UnaryExpressionChild object) {
				return createUnaryExpressionChildAdapter();
			}
			@Override
			public Adapter caseAtomicExpression(AtomicExpression object) {
				return createAtomicExpressionAdapter();
			}
			@Override
			public Adapter casePathExpression(PathExpression object) {
				return createPathExpressionAdapter();
			}
			@Override
			public Adapter caseVariableExpression(VariableExpression object) {
				return createVariableExpressionAdapter();
			}
			@Override
			public Adapter caseConstantExpression(ConstantExpression object) {
				return createConstantExpressionAdapter();
			}
			@Override
			public Adapter caseEmptyExpression(EmptyExpression object) {
				return createEmptyExpressionAdapter();
			}
			@Override
			public Adapter caseStringLiteralExpression(StringLiteralExpression object) {
				return createStringLiteralExpressionAdapter();
			}
			@Override
			public Adapter caseIntegerLiteralExpression(IntegerLiteralExpression object) {
				return createIntegerLiteralExpressionAdapter();
			}
			@Override
			public Adapter caseBooleanLiteralExpression(BooleanLiteralExpression object) {
				return createBooleanLiteralExpressionAdapter();
			}
			@Override
			public Adapter caseEnumLiteralExpression(EnumLiteralExpression object) {
				return createEnumLiteralExpressionAdapter();
			}
			@Override
			public Adapter caseParenExpression(ParenExpression object) {
				return createParenExpressionAdapter();
			}
			@Override
			public Adapter caseObjectURIExpression(ObjectURIExpression object) {
				return createObjectURIExpressionAdapter();
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
	 * Creates a new adapter for an object of class '{@link edu.ustb.sei.mde.xmu2.expression.Expression <em>Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see edu.ustb.sei.mde.xmu2.expression.Expression
	 * @generated
	 */
	public Adapter createExpressionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link edu.ustb.sei.mde.xmu2.expression.BooleanOrExpression <em>Boolean Or Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see edu.ustb.sei.mde.xmu2.expression.BooleanOrExpression
	 * @generated
	 */
	public Adapter createBooleanOrExpressionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link edu.ustb.sei.mde.xmu2.expression.BooleanOrExpressionChild <em>Boolean Or Expression Child</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see edu.ustb.sei.mde.xmu2.expression.BooleanOrExpressionChild
	 * @generated
	 */
	public Adapter createBooleanOrExpressionChildAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link edu.ustb.sei.mde.xmu2.expression.BooleanAndExpression <em>Boolean And Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see edu.ustb.sei.mde.xmu2.expression.BooleanAndExpression
	 * @generated
	 */
	public Adapter createBooleanAndExpressionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link edu.ustb.sei.mde.xmu2.expression.BooleanAndExpressionChild <em>Boolean And Expression Child</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see edu.ustb.sei.mde.xmu2.expression.BooleanAndExpressionChild
	 * @generated
	 */
	public Adapter createBooleanAndExpressionChildAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link edu.ustb.sei.mde.xmu2.expression.RelationalExpression <em>Relational Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see edu.ustb.sei.mde.xmu2.expression.RelationalExpression
	 * @generated
	 */
	public Adapter createRelationalExpressionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link edu.ustb.sei.mde.xmu2.expression.RelationalExpressionChild <em>Relational Expression Child</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see edu.ustb.sei.mde.xmu2.expression.RelationalExpressionChild
	 * @generated
	 */
	public Adapter createRelationalExpressionChildAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link edu.ustb.sei.mde.xmu2.expression.AdditiveExpression <em>Additive Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see edu.ustb.sei.mde.xmu2.expression.AdditiveExpression
	 * @generated
	 */
	public Adapter createAdditiveExpressionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link edu.ustb.sei.mde.xmu2.expression.AdditiveExpressionChild <em>Additive Expression Child</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see edu.ustb.sei.mde.xmu2.expression.AdditiveExpressionChild
	 * @generated
	 */
	public Adapter createAdditiveExpressionChildAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link edu.ustb.sei.mde.xmu2.expression.MultiplicativeExpression <em>Multiplicative Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see edu.ustb.sei.mde.xmu2.expression.MultiplicativeExpression
	 * @generated
	 */
	public Adapter createMultiplicativeExpressionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link edu.ustb.sei.mde.xmu2.expression.MultiplicativeExpressionChild <em>Multiplicative Expression Child</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see edu.ustb.sei.mde.xmu2.expression.MultiplicativeExpressionChild
	 * @generated
	 */
	public Adapter createMultiplicativeExpressionChildAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link edu.ustb.sei.mde.xmu2.expression.UnaryExpression <em>Unary Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see edu.ustb.sei.mde.xmu2.expression.UnaryExpression
	 * @generated
	 */
	public Adapter createUnaryExpressionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link edu.ustb.sei.mde.xmu2.expression.UnaryExpressionChild <em>Unary Expression Child</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see edu.ustb.sei.mde.xmu2.expression.UnaryExpressionChild
	 * @generated
	 */
	public Adapter createUnaryExpressionChildAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link edu.ustb.sei.mde.xmu2.expression.AtomicExpression <em>Atomic Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see edu.ustb.sei.mde.xmu2.expression.AtomicExpression
	 * @generated
	 */
	public Adapter createAtomicExpressionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link edu.ustb.sei.mde.xmu2.expression.PathExpression <em>Path Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see edu.ustb.sei.mde.xmu2.expression.PathExpression
	 * @generated
	 */
	public Adapter createPathExpressionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link edu.ustb.sei.mde.xmu2.expression.VariableExpression <em>Variable Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see edu.ustb.sei.mde.xmu2.expression.VariableExpression
	 * @generated
	 */
	public Adapter createVariableExpressionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link edu.ustb.sei.mde.xmu2.expression.ConstantExpression <em>Constant Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see edu.ustb.sei.mde.xmu2.expression.ConstantExpression
	 * @generated
	 */
	public Adapter createConstantExpressionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link edu.ustb.sei.mde.xmu2.expression.EmptyExpression <em>Empty Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see edu.ustb.sei.mde.xmu2.expression.EmptyExpression
	 * @generated
	 */
	public Adapter createEmptyExpressionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link edu.ustb.sei.mde.xmu2.expression.StringLiteralExpression <em>String Literal Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see edu.ustb.sei.mde.xmu2.expression.StringLiteralExpression
	 * @generated
	 */
	public Adapter createStringLiteralExpressionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link edu.ustb.sei.mde.xmu2.expression.IntegerLiteralExpression <em>Integer Literal Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see edu.ustb.sei.mde.xmu2.expression.IntegerLiteralExpression
	 * @generated
	 */
	public Adapter createIntegerLiteralExpressionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link edu.ustb.sei.mde.xmu2.expression.BooleanLiteralExpression <em>Boolean Literal Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see edu.ustb.sei.mde.xmu2.expression.BooleanLiteralExpression
	 * @generated
	 */
	public Adapter createBooleanLiteralExpressionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link edu.ustb.sei.mde.xmu2.expression.EnumLiteralExpression <em>Enum Literal Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see edu.ustb.sei.mde.xmu2.expression.EnumLiteralExpression
	 * @generated
	 */
	public Adapter createEnumLiteralExpressionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link edu.ustb.sei.mde.xmu2.expression.ParenExpression <em>Paren Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see edu.ustb.sei.mde.xmu2.expression.ParenExpression
	 * @generated
	 */
	public Adapter createParenExpressionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link edu.ustb.sei.mde.xmu2.expression.ObjectURIExpression <em>Object URI Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see edu.ustb.sei.mde.xmu2.expression.ObjectURIExpression
	 * @generated
	 */
	public Adapter createObjectURIExpressionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link edu.ustb.sei.mde.xmu2.expression.Path <em>Path</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see edu.ustb.sei.mde.xmu2.expression.Path
	 * @generated
	 */
	public Adapter createPathAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link edu.ustb.sei.mde.xmu2.expression.FeaturePath <em>Feature Path</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see edu.ustb.sei.mde.xmu2.expression.FeaturePath
	 * @generated
	 */
	public Adapter createFeaturePathAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link edu.ustb.sei.mde.xmu2.expression.OperationPath <em>Operation Path</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see edu.ustb.sei.mde.xmu2.expression.OperationPath
	 * @generated
	 */
	public Adapter createOperationPathAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link edu.ustb.sei.mde.xmu2.expression.LoopPath <em>Loop Path</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see edu.ustb.sei.mde.xmu2.expression.LoopPath
	 * @generated
	 */
	public Adapter createLoopPathAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link edu.ustb.sei.mde.xmu2.expression.PositionPath <em>Position Path</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see edu.ustb.sei.mde.xmu2.expression.PositionPath
	 * @generated
	 */
	public Adapter createPositionPathAdapter() {
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

} //ExpressionAdapterFactory
