/**
 */
package edu.ustb.sei.mde.xmu2core;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see edu.ustb.sei.mde.xmu2core.Xmu2corePackage
 * @generated
 */
public interface Xmu2coreFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	Xmu2coreFactory eINSTANCE = edu.ustb.sei.mde.xmu2core.impl.Xmu2coreFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Procedure</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Procedure</em>'.
	 * @generated
	 */
	Procedure createProcedure();

	/**
	 * Returns a new object of class '<em>Variable</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Variable</em>'.
	 * @generated
	 */
	Variable createVariable();

	/**
	 * Returns a new object of class '<em>Align Statement</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Align Statement</em>'.
	 * @generated
	 */
	AlignStatement createAlignStatement();

	/**
	 * Returns a new object of class '<em>Case Statement</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Case Statement</em>'.
	 * @generated
	 */
	CaseStatement createCaseStatement();

	/**
	 * Returns a new object of class '<em>Case Pattern Clause</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Case Pattern Clause</em>'.
	 * @generated
	 */
	CasePatternClause createCasePatternClause();

	/**
	 * Returns a new object of class '<em>Case Expression Clause</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Case Expression Clause</em>'.
	 * @generated
	 */
	CaseExpressionClause createCaseExpressionClause();

	/**
	 * Returns a new object of class '<em>Pattern</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Pattern</em>'.
	 * @generated
	 */
	Pattern createPattern();

	/**
	 * Returns a new object of class '<em>Pattern Node</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Pattern Node</em>'.
	 * @generated
	 */
	PatternNode createPatternNode();

	/**
	 * Returns a new object of class '<em>Object Pattern Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Object Pattern Expression</em>'.
	 * @generated
	 */
	ObjectPatternExpression createObjectPatternExpression();

	/**
	 * Returns a new object of class '<em>Property Pattern Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Property Pattern Expression</em>'.
	 * @generated
	 */
	PropertyPatternExpression createPropertyPatternExpression();

	/**
	 * Returns a new object of class '<em>Boolean Or Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Boolean Or Expression</em>'.
	 * @generated
	 */
	BooleanOrExpression createBooleanOrExpression();

	/**
	 * Returns a new object of class '<em>Boolean And Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Boolean And Expression</em>'.
	 * @generated
	 */
	BooleanAndExpression createBooleanAndExpression();

	/**
	 * Returns a new object of class '<em>Relational Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Relational Expression</em>'.
	 * @generated
	 */
	RelationalExpression createRelationalExpression();

	/**
	 * Returns a new object of class '<em>Additive Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Additive Expression</em>'.
	 * @generated
	 */
	AdditiveExpression createAdditiveExpression();

	/**
	 * Returns a new object of class '<em>Multiplicative Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Multiplicative Expression</em>'.
	 * @generated
	 */
	MultiplicativeExpression createMultiplicativeExpression();

	/**
	 * Returns a new object of class '<em>Unary Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Unary Expression</em>'.
	 * @generated
	 */
	UnaryExpression createUnaryExpression();

	/**
	 * Returns a new object of class '<em>Type Cast Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Type Cast Expression</em>'.
	 * @generated
	 */
	TypeCastExpression createTypeCastExpression();

	/**
	 * Returns a new object of class '<em>String Value Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>String Value Expression</em>'.
	 * @generated
	 */
	StringValueExpression createStringValueExpression();

	/**
	 * Returns a new object of class '<em>Boolean Value Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Boolean Value Expression</em>'.
	 * @generated
	 */
	BooleanValueExpression createBooleanValueExpression();

	/**
	 * Returns a new object of class '<em>Integer Value Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Integer Value Expression</em>'.
	 * @generated
	 */
	IntegerValueExpression createIntegerValueExpression();

	/**
	 * Returns a new object of class '<em>Enum Value Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Enum Value Expression</em>'.
	 * @generated
	 */
	EnumValueExpression createEnumValueExpression();

	/**
	 * Returns a new object of class '<em>Empty Value Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Empty Value Expression</em>'.
	 * @generated
	 */
	EmptyValueExpression createEmptyValueExpression();

	/**
	 * Returns a new object of class '<em>Object Value Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Object Value Expression</em>'.
	 * @generated
	 */
	ObjectValueExpression createObjectValueExpression();

	/**
	 * Returns a new object of class '<em>Variable Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Variable Expression</em>'.
	 * @generated
	 */
	VariableExpression createVariableExpression();

	/**
	 * Returns a new object of class '<em>Feature Path</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Feature Path</em>'.
	 * @generated
	 */
	FeaturePath createFeaturePath();

	/**
	 * Returns a new object of class '<em>Operation Path</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Operation Path</em>'.
	 * @generated
	 */
	OperationPath createOperationPath();

	/**
	 * Returns a new object of class '<em>Loop Path</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Loop Path</em>'.
	 * @generated
	 */
	LoopPath createLoopPath();

	/**
	 * Returns a new object of class '<em>Position Path</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Position Path</em>'.
	 * @generated
	 */
	PositionPath createPositionPath();

	/**
	 * Returns a new object of class '<em>Procedure Call Statement</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Procedure Call Statement</em>'.
	 * @generated
	 */
	ProcedureCallStatement createProcedureCallStatement();

	/**
	 * Returns a new object of class '<em>Transformation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Transformation</em>'.
	 * @generated
	 */
	Transformation createTransformation();

	/**
	 * Returns a new object of class '<em>Entry Rule Parameter</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Entry Rule Parameter</em>'.
	 * @generated
	 */
	EntryRuleParameter createEntryRuleParameter();

	/**
	 * Returns a new object of class '<em>For Each Statement</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>For Each Statement</em>'.
	 * @generated
	 */
	ForEachStatement createForEachStatement();

	/**
	 * Returns a new object of class '<em>Delete Node Statement</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Delete Node Statement</em>'.
	 * @generated
	 */
	DeleteNodeStatement createDeleteNodeStatement();

	/**
	 * Returns a new object of class '<em>Delete Link Statement</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Delete Link Statement</em>'.
	 * @generated
	 */
	DeleteLinkStatement createDeleteLinkStatement();

	/**
	 * Returns a new object of class '<em>Enforce Node Statement</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Enforce Node Statement</em>'.
	 * @generated
	 */
	EnforceNodeStatement createEnforceNodeStatement();

	/**
	 * Returns a new object of class '<em>Enforce Link Statement</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Enforce Link Statement</em>'.
	 * @generated
	 */
	EnforceLinkStatement createEnforceLinkStatement();

	/**
	 * Returns a new object of class '<em>Ocl Collection Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ocl Collection Type</em>'.
	 * @generated
	 */
	OclCollectionType createOclCollectionType();

	/**
	 * Returns a new object of class '<em>Match Pattern</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Match Pattern</em>'.
	 * @generated
	 */
	MatchPattern createMatchPattern();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	Xmu2corePackage getXmu2corePackage();

} //Xmu2coreFactory
