/**
 */
package edu.ustb.sei.mde.morel.impl;

import edu.ustb.sei.mde.morel.AdditionalConstraint;
import edu.ustb.sei.mde.morel.LinkConstraint;
import edu.ustb.sei.mde.morel.MorelPackage;
import edu.ustb.sei.mde.morel.ObjectVariable;
import edu.ustb.sei.mde.morel.Pattern;
import edu.ustb.sei.mde.morel.Statement;
import java.util.Collection;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Pattern</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link edu.ustb.sei.mde.morel.impl.PatternImpl#getVariables <em>Variables</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.morel.impl.PatternImpl#getLinkConstraints <em>Link Constraints</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.morel.impl.PatternImpl#getStatements <em>Statements</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.morel.impl.PatternImpl#getAdditionalConstraints <em>Additional Constraints</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PatternImpl extends SectionImpl implements Pattern {
	/**
	 * The cached value of the '{@link #getVariables() <em>Variables</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVariables()
	 * @generated
	 * @ordered
	 */
	protected EList<ObjectVariable> variables;

	/**
	 * The cached value of the '{@link #getLinkConstraints() <em>Link Constraints</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLinkConstraints()
	 * @generated
	 * @ordered
	 */
	protected EList<LinkConstraint> linkConstraints;

	/**
	 * The cached value of the '{@link #getStatements() <em>Statements</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStatements()
	 * @generated
	 * @ordered
	 */
	protected EList<Statement> statements;

	/**
	 * The cached value of the '{@link #getAdditionalConstraints() <em>Additional Constraints</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAdditionalConstraints()
	 * @generated
	 * @ordered
	 */
	protected EList<AdditionalConstraint> additionalConstraints;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PatternImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MorelPackage.Literals.PATTERN;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ObjectVariable> getVariables() {
		if (variables == null) {
			variables = new EObjectContainmentEList<ObjectVariable>(ObjectVariable.class, this, MorelPackage.PATTERN__VARIABLES);
		}
		return variables;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<LinkConstraint> getLinkConstraints() {
		if (linkConstraints == null) {
			linkConstraints = new EObjectContainmentEList<LinkConstraint>(LinkConstraint.class, this, MorelPackage.PATTERN__LINK_CONSTRAINTS);
		}
		return linkConstraints;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Statement> getStatements() {
		if (statements == null) {
			statements = new EObjectContainmentEList<Statement>(Statement.class, this, MorelPackage.PATTERN__STATEMENTS);
		}
		return statements;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<AdditionalConstraint> getAdditionalConstraints() {
		if (additionalConstraints == null) {
			additionalConstraints = new EObjectContainmentEList<AdditionalConstraint>(AdditionalConstraint.class, this, MorelPackage.PATTERN__ADDITIONAL_CONSTRAINTS);
		}
		return additionalConstraints;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case MorelPackage.PATTERN__VARIABLES:
				return ((InternalEList<?>)getVariables()).basicRemove(otherEnd, msgs);
			case MorelPackage.PATTERN__LINK_CONSTRAINTS:
				return ((InternalEList<?>)getLinkConstraints()).basicRemove(otherEnd, msgs);
			case MorelPackage.PATTERN__STATEMENTS:
				return ((InternalEList<?>)getStatements()).basicRemove(otherEnd, msgs);
			case MorelPackage.PATTERN__ADDITIONAL_CONSTRAINTS:
				return ((InternalEList<?>)getAdditionalConstraints()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case MorelPackage.PATTERN__VARIABLES:
				return getVariables();
			case MorelPackage.PATTERN__LINK_CONSTRAINTS:
				return getLinkConstraints();
			case MorelPackage.PATTERN__STATEMENTS:
				return getStatements();
			case MorelPackage.PATTERN__ADDITIONAL_CONSTRAINTS:
				return getAdditionalConstraints();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case MorelPackage.PATTERN__VARIABLES:
				getVariables().clear();
				getVariables().addAll((Collection<? extends ObjectVariable>)newValue);
				return;
			case MorelPackage.PATTERN__LINK_CONSTRAINTS:
				getLinkConstraints().clear();
				getLinkConstraints().addAll((Collection<? extends LinkConstraint>)newValue);
				return;
			case MorelPackage.PATTERN__STATEMENTS:
				getStatements().clear();
				getStatements().addAll((Collection<? extends Statement>)newValue);
				return;
			case MorelPackage.PATTERN__ADDITIONAL_CONSTRAINTS:
				getAdditionalConstraints().clear();
				getAdditionalConstraints().addAll((Collection<? extends AdditionalConstraint>)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case MorelPackage.PATTERN__VARIABLES:
				getVariables().clear();
				return;
			case MorelPackage.PATTERN__LINK_CONSTRAINTS:
				getLinkConstraints().clear();
				return;
			case MorelPackage.PATTERN__STATEMENTS:
				getStatements().clear();
				return;
			case MorelPackage.PATTERN__ADDITIONAL_CONSTRAINTS:
				getAdditionalConstraints().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case MorelPackage.PATTERN__VARIABLES:
				return variables != null && !variables.isEmpty();
			case MorelPackage.PATTERN__LINK_CONSTRAINTS:
				return linkConstraints != null && !linkConstraints.isEmpty();
			case MorelPackage.PATTERN__STATEMENTS:
				return statements != null && !statements.isEmpty();
			case MorelPackage.PATTERN__ADDITIONAL_CONSTRAINTS:
				return additionalConstraints != null && !additionalConstraints.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //PatternImpl
