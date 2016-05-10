/**
 */
package edu.ustb.sei.mde.xmu2.expression.impl;

import edu.ustb.sei.mde.xmu2.Xmu2Package;

import edu.ustb.sei.mde.xmu2.expression.AdditiveExpression;
import edu.ustb.sei.mde.xmu2.expression.AdditiveExpressionChild;
import edu.ustb.sei.mde.xmu2.expression.AtomicExpression;
import edu.ustb.sei.mde.xmu2.expression.BooleanAndExpression;
import edu.ustb.sei.mde.xmu2.expression.BooleanAndExpressionChild;
import edu.ustb.sei.mde.xmu2.expression.BooleanLiteralExpression;
import edu.ustb.sei.mde.xmu2.expression.BooleanOrExpression;
import edu.ustb.sei.mde.xmu2.expression.BooleanOrExpressionChild;
import edu.ustb.sei.mde.xmu2.expression.ConstantExpression;
import edu.ustb.sei.mde.xmu2.expression.EmptyExpression;
import edu.ustb.sei.mde.xmu2.expression.EmptyValueType;
import edu.ustb.sei.mde.xmu2.expression.EnumLiteralExpression;
import edu.ustb.sei.mde.xmu2.expression.Expression;
import edu.ustb.sei.mde.xmu2.expression.ExpressionFactory;
import edu.ustb.sei.mde.xmu2.expression.ExpressionPackage;
import edu.ustb.sei.mde.xmu2.expression.FeaturePath;
import edu.ustb.sei.mde.xmu2.expression.IntegerLiteralExpression;
import edu.ustb.sei.mde.xmu2.expression.LoopPath;
import edu.ustb.sei.mde.xmu2.expression.MultiplicativeExpression;
import edu.ustb.sei.mde.xmu2.expression.MultiplicativeExpressionChild;
import edu.ustb.sei.mde.xmu2.expression.ObjectURIExpression;
import edu.ustb.sei.mde.xmu2.expression.OperationPath;
import edu.ustb.sei.mde.xmu2.expression.ParenExpression;
import edu.ustb.sei.mde.xmu2.expression.Path;
import edu.ustb.sei.mde.xmu2.expression.PathExpression;
import edu.ustb.sei.mde.xmu2.expression.PositionPath;
import edu.ustb.sei.mde.xmu2.expression.RelationalExpression;
import edu.ustb.sei.mde.xmu2.expression.RelationalExpressionChild;
import edu.ustb.sei.mde.xmu2.expression.StringLiteralExpression;
import edu.ustb.sei.mde.xmu2.expression.UnaryExpression;
import edu.ustb.sei.mde.xmu2.expression.UnaryExpressionChild;
import edu.ustb.sei.mde.xmu2.expression.VariableExpression;

import edu.ustb.sei.mde.xmu2.impl.Xmu2PackageImpl;

import edu.ustb.sei.mde.xmu2.pattern.PatternPackage;

import edu.ustb.sei.mde.xmu2.pattern.impl.PatternPackageImpl;

import edu.ustb.sei.mde.xmu2.statement.StatementPackage;

import edu.ustb.sei.mde.xmu2.statement.impl.StatementPackageImpl;

import edu.ustb.sei.mde.xmu2common.Xmu2commonPackage;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ExpressionPackageImpl extends EPackageImpl implements ExpressionPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass expressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass booleanOrExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass booleanOrExpressionChildEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass booleanAndExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass booleanAndExpressionChildEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass relationalExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass relationalExpressionChildEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass additiveExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass additiveExpressionChildEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass multiplicativeExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass multiplicativeExpressionChildEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass unaryExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass unaryExpressionChildEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass atomicExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass pathExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass variableExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass constantExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass emptyExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass stringLiteralExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass integerLiteralExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass booleanLiteralExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass enumLiteralExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass parenExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass objectURIExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass pathEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass featurePathEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass operationPathEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass loopPathEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass positionPathEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum emptyValueTypeEEnum = null;

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
	 * @see edu.ustb.sei.mde.xmu2.expression.ExpressionPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private ExpressionPackageImpl() {
		super(eNS_URI, ExpressionFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link ExpressionPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static ExpressionPackage init() {
		if (isInited) return (ExpressionPackage)EPackage.Registry.INSTANCE.getEPackage(ExpressionPackage.eNS_URI);

		// Obtain or create and register package
		ExpressionPackageImpl theExpressionPackage = (ExpressionPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof ExpressionPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new ExpressionPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		Xmu2commonPackage.eINSTANCE.eClass();

		// Obtain or create and register interdependencies
		Xmu2PackageImpl theXmu2Package = (Xmu2PackageImpl)(EPackage.Registry.INSTANCE.getEPackage(Xmu2Package.eNS_URI) instanceof Xmu2PackageImpl ? EPackage.Registry.INSTANCE.getEPackage(Xmu2Package.eNS_URI) : Xmu2Package.eINSTANCE);
		StatementPackageImpl theStatementPackage = (StatementPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(StatementPackage.eNS_URI) instanceof StatementPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(StatementPackage.eNS_URI) : StatementPackage.eINSTANCE);
		PatternPackageImpl thePatternPackage = (PatternPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(PatternPackage.eNS_URI) instanceof PatternPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(PatternPackage.eNS_URI) : PatternPackage.eINSTANCE);

		// Create package meta-data objects
		theExpressionPackage.createPackageContents();
		theXmu2Package.createPackageContents();
		theStatementPackage.createPackageContents();
		thePatternPackage.createPackageContents();

		// Initialize created meta-data
		theExpressionPackage.initializePackageContents();
		theXmu2Package.initializePackageContents();
		theStatementPackage.initializePackageContents();
		thePatternPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theExpressionPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(ExpressionPackage.eNS_URI, theExpressionPackage);
		return theExpressionPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getExpression() {
		return expressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBooleanOrExpression() {
		return booleanOrExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBooleanOrExpression_Operands() {
		return (EReference)booleanOrExpressionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBooleanOrExpressionChild() {
		return booleanOrExpressionChildEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBooleanAndExpression() {
		return booleanAndExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBooleanAndExpression_Operands() {
		return (EReference)booleanAndExpressionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBooleanAndExpressionChild() {
		return booleanAndExpressionChildEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRelationalExpression() {
		return relationalExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRelationalExpression_Operator() {
		return (EAttribute)relationalExpressionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRelationalExpression_Left() {
		return (EReference)relationalExpressionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRelationalExpression_Right() {
		return (EReference)relationalExpressionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRelationalExpressionChild() {
		return relationalExpressionChildEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAdditiveExpression() {
		return additiveExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAdditiveExpression_Operators() {
		return (EAttribute)additiveExpressionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAdditiveExpression_Operands() {
		return (EReference)additiveExpressionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAdditiveExpressionChild() {
		return additiveExpressionChildEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMultiplicativeExpression() {
		return multiplicativeExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMultiplicativeExpression_Operators() {
		return (EAttribute)multiplicativeExpressionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMultiplicativeExpression_Operands() {
		return (EReference)multiplicativeExpressionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMultiplicativeExpressionChild() {
		return multiplicativeExpressionChildEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getUnaryExpression() {
		return unaryExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getUnaryExpression_Operator() {
		return (EAttribute)unaryExpressionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getUnaryExpression_Body() {
		return (EReference)unaryExpressionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getUnaryExpressionChild() {
		return unaryExpressionChildEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAtomicExpression() {
		return atomicExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPathExpression() {
		return pathExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPathExpression_Path() {
		return (EReference)pathExpressionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPathExpression_Host() {
		return (EReference)pathExpressionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getVariableExpression() {
		return variableExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getVariableExpression_Variable() {
		return (EAttribute)variableExpressionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getConstantExpression() {
		return constantExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEmptyExpression() {
		return emptyExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEmptyExpression_Type() {
		return (EAttribute)emptyExpressionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStringLiteralExpression() {
		return stringLiteralExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStringLiteralExpression_Value() {
		return (EAttribute)stringLiteralExpressionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIntegerLiteralExpression() {
		return integerLiteralExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIntegerLiteralExpression_Value() {
		return (EAttribute)integerLiteralExpressionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBooleanLiteralExpression() {
		return booleanLiteralExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBooleanLiteralExpression_Value() {
		return (EAttribute)booleanLiteralExpressionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEnumLiteralExpression() {
		return enumLiteralExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEnumLiteralExpression_Type() {
		return (EReference)enumLiteralExpressionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEnumLiteralExpression_Value() {
		return (EReference)enumLiteralExpressionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getParenExpression() {
		return parenExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getParenExpression_Body() {
		return (EReference)parenExpressionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getObjectURIExpression() {
		return objectURIExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getObjectURIExpression_Object() {
		return (EReference)objectURIExpressionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPath() {
		return pathEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFeaturePath() {
		return featurePathEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFeaturePath_Feature() {
		return (EAttribute)featurePathEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOperationPath() {
		return operationPathEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getOperationPath_Operation() {
		return (EAttribute)operationPathEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOperationPath_Parameters() {
		return (EReference)operationPathEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLoopPath() {
		return loopPathEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLoopPath_Operator() {
		return (EAttribute)loopPathEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLoopPath_Variable() {
		return (EReference)loopPathEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLoopPath_Body() {
		return (EReference)loopPathEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPositionPath() {
		return positionPathEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPositionPath_Type() {
		return (EAttribute)positionPathEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPositionPath_Value() {
		return (EReference)positionPathEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getEmptyValueType() {
		return emptyValueTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExpressionFactory getExpressionFactory() {
		return (ExpressionFactory)getEFactoryInstance();
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
		expressionEClass = createEClass(EXPRESSION);

		booleanOrExpressionEClass = createEClass(BOOLEAN_OR_EXPRESSION);
		createEReference(booleanOrExpressionEClass, BOOLEAN_OR_EXPRESSION__OPERANDS);

		booleanOrExpressionChildEClass = createEClass(BOOLEAN_OR_EXPRESSION_CHILD);

		booleanAndExpressionEClass = createEClass(BOOLEAN_AND_EXPRESSION);
		createEReference(booleanAndExpressionEClass, BOOLEAN_AND_EXPRESSION__OPERANDS);

		booleanAndExpressionChildEClass = createEClass(BOOLEAN_AND_EXPRESSION_CHILD);

		relationalExpressionEClass = createEClass(RELATIONAL_EXPRESSION);
		createEAttribute(relationalExpressionEClass, RELATIONAL_EXPRESSION__OPERATOR);
		createEReference(relationalExpressionEClass, RELATIONAL_EXPRESSION__LEFT);
		createEReference(relationalExpressionEClass, RELATIONAL_EXPRESSION__RIGHT);

		relationalExpressionChildEClass = createEClass(RELATIONAL_EXPRESSION_CHILD);

		additiveExpressionEClass = createEClass(ADDITIVE_EXPRESSION);
		createEAttribute(additiveExpressionEClass, ADDITIVE_EXPRESSION__OPERATORS);
		createEReference(additiveExpressionEClass, ADDITIVE_EXPRESSION__OPERANDS);

		additiveExpressionChildEClass = createEClass(ADDITIVE_EXPRESSION_CHILD);

		multiplicativeExpressionEClass = createEClass(MULTIPLICATIVE_EXPRESSION);
		createEAttribute(multiplicativeExpressionEClass, MULTIPLICATIVE_EXPRESSION__OPERATORS);
		createEReference(multiplicativeExpressionEClass, MULTIPLICATIVE_EXPRESSION__OPERANDS);

		multiplicativeExpressionChildEClass = createEClass(MULTIPLICATIVE_EXPRESSION_CHILD);

		unaryExpressionEClass = createEClass(UNARY_EXPRESSION);
		createEAttribute(unaryExpressionEClass, UNARY_EXPRESSION__OPERATOR);
		createEReference(unaryExpressionEClass, UNARY_EXPRESSION__BODY);

		unaryExpressionChildEClass = createEClass(UNARY_EXPRESSION_CHILD);

		atomicExpressionEClass = createEClass(ATOMIC_EXPRESSION);

		pathExpressionEClass = createEClass(PATH_EXPRESSION);
		createEReference(pathExpressionEClass, PATH_EXPRESSION__PATH);
		createEReference(pathExpressionEClass, PATH_EXPRESSION__HOST);

		variableExpressionEClass = createEClass(VARIABLE_EXPRESSION);
		createEAttribute(variableExpressionEClass, VARIABLE_EXPRESSION__VARIABLE);

		constantExpressionEClass = createEClass(CONSTANT_EXPRESSION);

		emptyExpressionEClass = createEClass(EMPTY_EXPRESSION);
		createEAttribute(emptyExpressionEClass, EMPTY_EXPRESSION__TYPE);

		stringLiteralExpressionEClass = createEClass(STRING_LITERAL_EXPRESSION);
		createEAttribute(stringLiteralExpressionEClass, STRING_LITERAL_EXPRESSION__VALUE);

		integerLiteralExpressionEClass = createEClass(INTEGER_LITERAL_EXPRESSION);
		createEAttribute(integerLiteralExpressionEClass, INTEGER_LITERAL_EXPRESSION__VALUE);

		booleanLiteralExpressionEClass = createEClass(BOOLEAN_LITERAL_EXPRESSION);
		createEAttribute(booleanLiteralExpressionEClass, BOOLEAN_LITERAL_EXPRESSION__VALUE);

		enumLiteralExpressionEClass = createEClass(ENUM_LITERAL_EXPRESSION);
		createEReference(enumLiteralExpressionEClass, ENUM_LITERAL_EXPRESSION__TYPE);
		createEReference(enumLiteralExpressionEClass, ENUM_LITERAL_EXPRESSION__VALUE);

		parenExpressionEClass = createEClass(PAREN_EXPRESSION);
		createEReference(parenExpressionEClass, PAREN_EXPRESSION__BODY);

		objectURIExpressionEClass = createEClass(OBJECT_URI_EXPRESSION);
		createEReference(objectURIExpressionEClass, OBJECT_URI_EXPRESSION__OBJECT);

		pathEClass = createEClass(PATH);

		featurePathEClass = createEClass(FEATURE_PATH);
		createEAttribute(featurePathEClass, FEATURE_PATH__FEATURE);

		operationPathEClass = createEClass(OPERATION_PATH);
		createEAttribute(operationPathEClass, OPERATION_PATH__OPERATION);
		createEReference(operationPathEClass, OPERATION_PATH__PARAMETERS);

		loopPathEClass = createEClass(LOOP_PATH);
		createEAttribute(loopPathEClass, LOOP_PATH__OPERATOR);
		createEReference(loopPathEClass, LOOP_PATH__VARIABLE);
		createEReference(loopPathEClass, LOOP_PATH__BODY);

		positionPathEClass = createEClass(POSITION_PATH);
		createEAttribute(positionPathEClass, POSITION_PATH__TYPE);
		createEReference(positionPathEClass, POSITION_PATH__VALUE);

		// Create enums
		emptyValueTypeEEnum = createEEnum(EMPTY_VALUE_TYPE);
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
		Xmu2commonPackage theXmu2commonPackage = (Xmu2commonPackage)EPackage.Registry.INSTANCE.getEPackage(Xmu2commonPackage.eNS_URI);
		Xmu2Package theXmu2Package = (Xmu2Package)EPackage.Registry.INSTANCE.getEPackage(Xmu2Package.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		booleanOrExpressionEClass.getESuperTypes().add(this.getExpression());
		booleanOrExpressionChildEClass.getESuperTypes().add(this.getExpression());
		booleanAndExpressionEClass.getESuperTypes().add(this.getBooleanOrExpressionChild());
		booleanAndExpressionChildEClass.getESuperTypes().add(this.getBooleanOrExpressionChild());
		relationalExpressionEClass.getESuperTypes().add(this.getBooleanAndExpressionChild());
		relationalExpressionChildEClass.getESuperTypes().add(this.getBooleanAndExpressionChild());
		additiveExpressionEClass.getESuperTypes().add(this.getRelationalExpressionChild());
		additiveExpressionChildEClass.getESuperTypes().add(this.getRelationalExpressionChild());
		multiplicativeExpressionEClass.getESuperTypes().add(this.getAdditiveExpressionChild());
		multiplicativeExpressionChildEClass.getESuperTypes().add(this.getAdditiveExpressionChild());
		unaryExpressionEClass.getESuperTypes().add(this.getMultiplicativeExpressionChild());
		unaryExpressionChildEClass.getESuperTypes().add(this.getMultiplicativeExpressionChild());
		atomicExpressionEClass.getESuperTypes().add(this.getUnaryExpressionChild());
		pathExpressionEClass.getESuperTypes().add(this.getUnaryExpressionChild());
		variableExpressionEClass.getESuperTypes().add(this.getAtomicExpression());
		constantExpressionEClass.getESuperTypes().add(this.getAtomicExpression());
		emptyExpressionEClass.getESuperTypes().add(this.getConstantExpression());
		stringLiteralExpressionEClass.getESuperTypes().add(this.getConstantExpression());
		integerLiteralExpressionEClass.getESuperTypes().add(this.getConstantExpression());
		booleanLiteralExpressionEClass.getESuperTypes().add(this.getConstantExpression());
		enumLiteralExpressionEClass.getESuperTypes().add(this.getConstantExpression());
		parenExpressionEClass.getESuperTypes().add(this.getAtomicExpression());
		objectURIExpressionEClass.getESuperTypes().add(this.getConstantExpression());
		featurePathEClass.getESuperTypes().add(this.getPath());
		operationPathEClass.getESuperTypes().add(this.getPath());
		loopPathEClass.getESuperTypes().add(this.getPath());
		positionPathEClass.getESuperTypes().add(this.getPath());

		// Initialize classes and features; add operations and parameters
		initEClass(expressionEClass, Expression.class, "Expression", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(booleanOrExpressionEClass, BooleanOrExpression.class, "BooleanOrExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getBooleanOrExpression_Operands(), this.getBooleanOrExpressionChild(), null, "operands", null, 2, -1, BooleanOrExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(booleanOrExpressionChildEClass, BooleanOrExpressionChild.class, "BooleanOrExpressionChild", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(booleanAndExpressionEClass, BooleanAndExpression.class, "BooleanAndExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getBooleanAndExpression_Operands(), this.getBooleanAndExpressionChild(), null, "operands", null, 2, -1, BooleanAndExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(booleanAndExpressionChildEClass, BooleanAndExpressionChild.class, "BooleanAndExpressionChild", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(relationalExpressionEClass, RelationalExpression.class, "RelationalExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getRelationalExpression_Operator(), theXmu2commonPackage.getRelationalOperator(), "operator", null, 1, 1, RelationalExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRelationalExpression_Left(), this.getRelationalExpressionChild(), null, "left", null, 1, 1, RelationalExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRelationalExpression_Right(), this.getRelationalExpressionChild(), null, "right", null, 1, 1, RelationalExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(relationalExpressionChildEClass, RelationalExpressionChild.class, "RelationalExpressionChild", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(additiveExpressionEClass, AdditiveExpression.class, "AdditiveExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getAdditiveExpression_Operators(), theXmu2commonPackage.getAdditiveOperator(), "operators", null, 1, -1, AdditiveExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAdditiveExpression_Operands(), this.getAdditiveExpressionChild(), null, "operands", null, 2, -1, AdditiveExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(additiveExpressionChildEClass, AdditiveExpressionChild.class, "AdditiveExpressionChild", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(multiplicativeExpressionEClass, MultiplicativeExpression.class, "MultiplicativeExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getMultiplicativeExpression_Operators(), theXmu2commonPackage.getMultiplicativeOperator(), "operators", null, 1, -1, MultiplicativeExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMultiplicativeExpression_Operands(), this.getMultiplicativeExpressionChild(), null, "operands", null, 2, -1, MultiplicativeExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(multiplicativeExpressionChildEClass, MultiplicativeExpressionChild.class, "MultiplicativeExpressionChild", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(unaryExpressionEClass, UnaryExpression.class, "UnaryExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getUnaryExpression_Operator(), theXmu2commonPackage.getUnaryOperator(), "operator", null, 1, 1, UnaryExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getUnaryExpression_Body(), this.getUnaryExpressionChild(), null, "body", null, 1, 1, UnaryExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(unaryExpressionChildEClass, UnaryExpressionChild.class, "UnaryExpressionChild", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(atomicExpressionEClass, AtomicExpression.class, "AtomicExpression", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(pathExpressionEClass, PathExpression.class, "PathExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPathExpression_Path(), this.getPath(), null, "path", null, 1, -1, PathExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPathExpression_Host(), this.getAtomicExpression(), null, "host", null, 1, 1, PathExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(variableExpressionEClass, VariableExpression.class, "VariableExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getVariableExpression_Variable(), ecorePackage.getEString(), "variable", null, 1, 1, VariableExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(constantExpressionEClass, ConstantExpression.class, "ConstantExpression", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(emptyExpressionEClass, EmptyExpression.class, "EmptyExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getEmptyExpression_Type(), this.getEmptyValueType(), "type", null, 1, 1, EmptyExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(stringLiteralExpressionEClass, StringLiteralExpression.class, "StringLiteralExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getStringLiteralExpression_Value(), ecorePackage.getEString(), "value", null, 1, 1, StringLiteralExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(integerLiteralExpressionEClass, IntegerLiteralExpression.class, "IntegerLiteralExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getIntegerLiteralExpression_Value(), ecorePackage.getEInt(), "value", null, 1, 1, IntegerLiteralExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(booleanLiteralExpressionEClass, BooleanLiteralExpression.class, "BooleanLiteralExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getBooleanLiteralExpression_Value(), ecorePackage.getEBoolean(), "value", null, 1, 1, BooleanLiteralExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(enumLiteralExpressionEClass, EnumLiteralExpression.class, "EnumLiteralExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getEnumLiteralExpression_Type(), ecorePackage.getEEnum(), null, "type", null, 1, 1, EnumLiteralExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEnumLiteralExpression_Value(), ecorePackage.getEEnumLiteral(), null, "value", null, 1, 1, EnumLiteralExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(parenExpressionEClass, ParenExpression.class, "ParenExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getParenExpression_Body(), this.getExpression(), null, "body", null, 1, 1, ParenExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(objectURIExpressionEClass, ObjectURIExpression.class, "ObjectURIExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getObjectURIExpression_Object(), ecorePackage.getEObject(), null, "object", null, 1, 1, ObjectURIExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(pathEClass, Path.class, "Path", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(featurePathEClass, FeaturePath.class, "FeaturePath", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getFeaturePath_Feature(), ecorePackage.getEString(), "feature", null, 1, 1, FeaturePath.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(operationPathEClass, OperationPath.class, "OperationPath", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getOperationPath_Operation(), ecorePackage.getEString(), "operation", null, 1, 1, OperationPath.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getOperationPath_Parameters(), this.getExpression(), null, "parameters", null, 0, -1, OperationPath.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(loopPathEClass, LoopPath.class, "LoopPath", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getLoopPath_Operator(), theXmu2commonPackage.getLoopOperator(), "operator", null, 1, 1, LoopPath.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getLoopPath_Variable(), theXmu2Package.getVariableDeclaration(), null, "variable", null, 1, 1, LoopPath.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getLoopPath_Body(), this.getExpression(), null, "body", null, 1, 1, LoopPath.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(positionPathEClass, PositionPath.class, "PositionPath", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getPositionPath_Type(), theXmu2commonPackage.getPositionOperator(), "type", null, 1, 1, PositionPath.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPositionPath_Value(), this.getExpression(), null, "value", null, 0, 1, PositionPath.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(emptyValueTypeEEnum, EmptyValueType.class, "EmptyValueType");
		addEEnumLiteral(emptyValueTypeEEnum, EmptyValueType.NULL_VALUE);
		addEEnumLiteral(emptyValueTypeEEnum, EmptyValueType.EMPTY_VALUE);
	}

} //ExpressionPackageImpl
