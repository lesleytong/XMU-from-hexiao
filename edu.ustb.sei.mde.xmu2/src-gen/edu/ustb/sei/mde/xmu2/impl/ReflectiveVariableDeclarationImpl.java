/**
 */
package edu.ustb.sei.mde.xmu2.impl;

import edu.ustb.sei.mde.xmu2.ReflectiveVariableDeclaration;
import edu.ustb.sei.mde.xmu2.Xmu2Package;
import edu.ustb.sei.mde.xmu2.util.Constants;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Reflective Variable Declaration</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public class ReflectiveVariableDeclarationImpl extends VariableDeclarationImpl implements ReflectiveVariableDeclaration {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected ReflectiveVariableDeclarationImpl() {
		super();
		// set the default object type to ReflectiveObject
		this.setType(Constants.REFLECTIVE_OBJECT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Xmu2Package.Literals.REFLECTIVE_VARIABLE_DECLARATION;
	}

} //ReflectiveVariableDeclarationImpl
