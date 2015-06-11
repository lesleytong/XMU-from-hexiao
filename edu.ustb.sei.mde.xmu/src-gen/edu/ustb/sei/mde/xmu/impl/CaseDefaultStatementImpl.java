/**
 */
package edu.ustb.sei.mde.xmu.impl;

import edu.ustb.sei.mde.xmu.CaseDefaultStatement;
import edu.ustb.sei.mde.xmu.XmuPackage;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Case Default Statement</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class CaseDefaultStatementImpl extends CaseValueStatementImpl implements CaseDefaultStatement {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected CaseDefaultStatementImpl() {
		super();
		BooleanLiteralImpl impl = new BooleanLiteralImpl();
		impl.setValue(true);
		this.setExpression(impl);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return XmuPackage.Literals.CASE_DEFAULT_STATEMENT;
	}

} //CaseDefaultStatementImpl
