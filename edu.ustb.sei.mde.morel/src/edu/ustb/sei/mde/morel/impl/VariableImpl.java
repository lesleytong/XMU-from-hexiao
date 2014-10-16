/**
 */
package edu.ustb.sei.mde.morel.impl;

import edu.ustb.sei.mde.morel.MorelPackage;
import edu.ustb.sei.mde.morel.Variable;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Variable</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public abstract class VariableImpl extends NamedElementImpl implements Variable {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected VariableImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MorelPackage.Literals.VARIABLE;
	}

	public boolean equals(Object o) {
		if(o==null || !(o instanceof Variable)) return false;
		if(this.getName()==null) return false;
		return this.getName().equals(((Variable)o).getName());		
	}
	
	public int hashCode() {
		if(getName()==null) return 0;
		return getName().hashCode();
	}
} //VariableImpl
