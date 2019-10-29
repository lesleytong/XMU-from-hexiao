/**
 */
package edu.ustb.sei.mde.xmu2;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see edu.ustb.sei.mde.xmu2.Xmu2Package
 * @generated
 */
public interface Xmu2Factory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	Xmu2Factory eINSTANCE = edu.ustb.sei.mde.xmu2.impl.Xmu2FactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Transformation Model</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Transformation Model</em>'.
	 * @generated
	 */
	TransformationModel createTransformationModel();

	/**
	 * Returns a new object of class '<em>Entry Point</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Entry Point</em>'.
	 * @generated
	 */
	EntryPoint createEntryPoint();

	/**
	 * Returns a new object of class '<em>Entry Data</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Entry Data</em>'.
	 * @generated
	 */
	EntryData createEntryData();

	/**
	 * Returns a new object of class '<em>Parameter</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Parameter</em>'.
	 * @generated
	 */
	Parameter createParameter();

	/**
	 * Returns a new object of class '<em>Model Rule</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Model Rule</em>'.
	 * @generated
	 */
	ModelRule createModelRule();

	/**
	 * Returns a new object of class '<em>Arithmetic Rule</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Arithmetic Rule</em>'.
	 * @generated
	 */
	ArithmeticRule createArithmeticRule();

	/**
	 * Returns a new object of class '<em>Concrete Variable Declaration</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Concrete Variable Declaration</em>'.
	 * @generated
	 */
	ConcreteVariableDeclaration createConcreteVariableDeclaration();

	/**
	 * Returns a new object of class '<em>Reflective Variable Declaration</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Reflective Variable Declaration</em>'.
	 * @generated
	 */
	ReflectiveVariableDeclaration createReflectiveVariableDeclaration();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	Xmu2Package getXmu2Package();

} //Xmu2Factory
