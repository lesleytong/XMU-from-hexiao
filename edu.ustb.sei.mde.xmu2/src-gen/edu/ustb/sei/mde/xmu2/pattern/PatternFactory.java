/**
 */
package edu.ustb.sei.mde.xmu2.pattern;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see edu.ustb.sei.mde.xmu2.pattern.PatternPackage
 * @generated
 */
public interface PatternFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	PatternFactory eINSTANCE = edu.ustb.sei.mde.xmu2.pattern.impl.PatternFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Pattern</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Pattern</em>'.
	 * @generated
	 */
	Pattern createPattern();

	/**
	 * Returns a new object of class '<em>Node</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Node</em>'.
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
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	PatternPackage getPatternPackage();

} //PatternFactory
