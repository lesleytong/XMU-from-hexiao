/**
 */
package edu.ustb.sei.mde.xmu2core.impl;

import edu.ustb.sei.mde.xmu2common.DomainElement;
import edu.ustb.sei.mde.xmu2common.DomainTag;
import edu.ustb.sei.mde.xmu2common.Xmu2commonPackage;

import edu.ustb.sei.mde.xmu2core.EnforceNodeStatement;
import edu.ustb.sei.mde.xmu2core.Expression;
import edu.ustb.sei.mde.xmu2core.Nullable;
import edu.ustb.sei.mde.xmu2core.ReflectiveSupport;
import edu.ustb.sei.mde.xmu2core.Variable;
import edu.ustb.sei.mde.xmu2core.VariableExpression;
import edu.ustb.sei.mde.xmu2core.Xmu2corePackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Enforce Node Statement</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link edu.ustb.sei.mde.xmu2core.impl.EnforceNodeStatementImpl#getTag <em>Tag</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.xmu2core.impl.EnforceNodeStatementImpl#isNullable <em>Nullable</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.xmu2core.impl.EnforceNodeStatementImpl#getReflectiveIdentifier <em>Reflective Identifier</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.xmu2core.impl.EnforceNodeStatementImpl#isReflective <em>Reflective</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.xmu2core.impl.EnforceNodeStatementImpl#getNode <em>Node</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.xmu2core.impl.EnforceNodeStatementImpl#getType <em>Type</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.xmu2core.impl.EnforceNodeStatementImpl#getCandidate <em>Candidate</em>}</li>
 * </ul>
 *
 * @generated
 */
public class EnforceNodeStatementImpl extends StatementImpl implements EnforceNodeStatement {
	/**
	 * The default value of the '{@link #getTag() <em>Tag</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTag()
	 * @generated
	 * @ordered
	 */
	protected static final DomainTag TAG_EDEFAULT = DomainTag.NORMAL;

	/**
	 * The cached value of the '{@link #getTag() <em>Tag</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTag()
	 * @generated
	 * @ordered
	 */
	protected DomainTag tag = TAG_EDEFAULT;

	/**
	 * The default value of the '{@link #isNullable() <em>Nullable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isNullable()
	 * @generated
	 * @ordered
	 */
	protected static final boolean NULLABLE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isNullable() <em>Nullable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isNullable()
	 * @generated
	 * @ordered
	 */
	protected boolean nullable = NULLABLE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getReflectiveIdentifier() <em>Reflective Identifier</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReflectiveIdentifier()
	 * @generated
	 * @ordered
	 */
	protected Expression reflectiveIdentifier;

	/**
	 * The default value of the '{@link #isReflective() <em>Reflective</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isReflective()
	 * @generated
	 * @ordered
	 */
	protected static final boolean REFLECTIVE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isReflective() <em>Reflective</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isReflective()
	 * @generated
	 * @ordered
	 */
	protected boolean reflective = REFLECTIVE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getNode() <em>Node</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNode()
	 * @generated
	 * @ordered
	 */
	protected Variable node;

	/**
	 * The cached value of the '{@link #getType() <em>Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected EClassifier type;

	/**
	 * The cached value of the '{@link #getCandidate() <em>Candidate</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCandidate()
	 * @generated
	 * @ordered
	 */
	protected VariableExpression candidate;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EnforceNodeStatementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Xmu2corePackage.Literals.ENFORCE_NODE_STATEMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DomainTag getTag() {
		return tag;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTag(DomainTag newTag) {
		DomainTag oldTag = tag;
		tag = newTag == null ? TAG_EDEFAULT : newTag;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Xmu2corePackage.ENFORCE_NODE_STATEMENT__TAG, oldTag, tag));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isNullable() {
		return nullable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNullable(boolean newNullable) {
		boolean oldNullable = nullable;
		nullable = newNullable;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Xmu2corePackage.ENFORCE_NODE_STATEMENT__NULLABLE, oldNullable, nullable));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Expression getReflectiveIdentifier() {
		return reflectiveIdentifier;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetReflectiveIdentifier(Expression newReflectiveIdentifier, NotificationChain msgs) {
		Expression oldReflectiveIdentifier = reflectiveIdentifier;
		reflectiveIdentifier = newReflectiveIdentifier;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, Xmu2corePackage.ENFORCE_NODE_STATEMENT__REFLECTIVE_IDENTIFIER, oldReflectiveIdentifier, newReflectiveIdentifier);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setReflectiveIdentifier(Expression newReflectiveIdentifier) {
		if (newReflectiveIdentifier != reflectiveIdentifier) {
			NotificationChain msgs = null;
			if (reflectiveIdentifier != null)
				msgs = ((InternalEObject)reflectiveIdentifier).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - Xmu2corePackage.ENFORCE_NODE_STATEMENT__REFLECTIVE_IDENTIFIER, null, msgs);
			if (newReflectiveIdentifier != null)
				msgs = ((InternalEObject)newReflectiveIdentifier).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - Xmu2corePackage.ENFORCE_NODE_STATEMENT__REFLECTIVE_IDENTIFIER, null, msgs);
			msgs = basicSetReflectiveIdentifier(newReflectiveIdentifier, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Xmu2corePackage.ENFORCE_NODE_STATEMENT__REFLECTIVE_IDENTIFIER, newReflectiveIdentifier, newReflectiveIdentifier));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isReflective() {
		return reflective;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setReflective(boolean newReflective) {
		boolean oldReflective = reflective;
		reflective = newReflective;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Xmu2corePackage.ENFORCE_NODE_STATEMENT__REFLECTIVE, oldReflective, reflective));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Variable getNode() {
		if (node != null && node.eIsProxy()) {
			InternalEObject oldNode = (InternalEObject)node;
			node = (Variable)eResolveProxy(oldNode);
			if (node != oldNode) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, Xmu2corePackage.ENFORCE_NODE_STATEMENT__NODE, oldNode, node));
			}
		}
		return node;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Variable basicGetNode() {
		return node;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNode(Variable newNode) {
		Variable oldNode = node;
		node = newNode;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Xmu2corePackage.ENFORCE_NODE_STATEMENT__NODE, oldNode, node));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClassifier getType() {
		if (type != null && type.eIsProxy()) {
			InternalEObject oldType = (InternalEObject)type;
			type = (EClassifier)eResolveProxy(oldType);
			if (type != oldType) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, Xmu2corePackage.ENFORCE_NODE_STATEMENT__TYPE, oldType, type));
			}
		}
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClassifier basicGetType() {
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setType(EClassifier newType) {
		EClassifier oldType = type;
		type = newType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Xmu2corePackage.ENFORCE_NODE_STATEMENT__TYPE, oldType, type));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VariableExpression getCandidate() {
		return candidate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCandidate(VariableExpression newCandidate, NotificationChain msgs) {
		VariableExpression oldCandidate = candidate;
		candidate = newCandidate;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, Xmu2corePackage.ENFORCE_NODE_STATEMENT__CANDIDATE, oldCandidate, newCandidate);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCandidate(VariableExpression newCandidate) {
		if (newCandidate != candidate) {
			NotificationChain msgs = null;
			if (candidate != null)
				msgs = ((InternalEObject)candidate).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - Xmu2corePackage.ENFORCE_NODE_STATEMENT__CANDIDATE, null, msgs);
			if (newCandidate != null)
				msgs = ((InternalEObject)newCandidate).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - Xmu2corePackage.ENFORCE_NODE_STATEMENT__CANDIDATE, null, msgs);
			msgs = basicSetCandidate(newCandidate, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Xmu2corePackage.ENFORCE_NODE_STATEMENT__CANDIDATE, newCandidate, newCandidate));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case Xmu2corePackage.ENFORCE_NODE_STATEMENT__REFLECTIVE_IDENTIFIER:
				return basicSetReflectiveIdentifier(null, msgs);
			case Xmu2corePackage.ENFORCE_NODE_STATEMENT__CANDIDATE:
				return basicSetCandidate(null, msgs);
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
			case Xmu2corePackage.ENFORCE_NODE_STATEMENT__TAG:
				return getTag();
			case Xmu2corePackage.ENFORCE_NODE_STATEMENT__NULLABLE:
				return isNullable();
			case Xmu2corePackage.ENFORCE_NODE_STATEMENT__REFLECTIVE_IDENTIFIER:
				return getReflectiveIdentifier();
			case Xmu2corePackage.ENFORCE_NODE_STATEMENT__REFLECTIVE:
				return isReflective();
			case Xmu2corePackage.ENFORCE_NODE_STATEMENT__NODE:
				if (resolve) return getNode();
				return basicGetNode();
			case Xmu2corePackage.ENFORCE_NODE_STATEMENT__TYPE:
				if (resolve) return getType();
				return basicGetType();
			case Xmu2corePackage.ENFORCE_NODE_STATEMENT__CANDIDATE:
				return getCandidate();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case Xmu2corePackage.ENFORCE_NODE_STATEMENT__TAG:
				setTag((DomainTag)newValue);
				return;
			case Xmu2corePackage.ENFORCE_NODE_STATEMENT__NULLABLE:
				setNullable((Boolean)newValue);
				return;
			case Xmu2corePackage.ENFORCE_NODE_STATEMENT__REFLECTIVE_IDENTIFIER:
				setReflectiveIdentifier((Expression)newValue);
				return;
			case Xmu2corePackage.ENFORCE_NODE_STATEMENT__REFLECTIVE:
				setReflective((Boolean)newValue);
				return;
			case Xmu2corePackage.ENFORCE_NODE_STATEMENT__NODE:
				setNode((Variable)newValue);
				return;
			case Xmu2corePackage.ENFORCE_NODE_STATEMENT__TYPE:
				setType((EClassifier)newValue);
				return;
			case Xmu2corePackage.ENFORCE_NODE_STATEMENT__CANDIDATE:
				setCandidate((VariableExpression)newValue);
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
			case Xmu2corePackage.ENFORCE_NODE_STATEMENT__TAG:
				setTag(TAG_EDEFAULT);
				return;
			case Xmu2corePackage.ENFORCE_NODE_STATEMENT__NULLABLE:
				setNullable(NULLABLE_EDEFAULT);
				return;
			case Xmu2corePackage.ENFORCE_NODE_STATEMENT__REFLECTIVE_IDENTIFIER:
				setReflectiveIdentifier((Expression)null);
				return;
			case Xmu2corePackage.ENFORCE_NODE_STATEMENT__REFLECTIVE:
				setReflective(REFLECTIVE_EDEFAULT);
				return;
			case Xmu2corePackage.ENFORCE_NODE_STATEMENT__NODE:
				setNode((Variable)null);
				return;
			case Xmu2corePackage.ENFORCE_NODE_STATEMENT__TYPE:
				setType((EClassifier)null);
				return;
			case Xmu2corePackage.ENFORCE_NODE_STATEMENT__CANDIDATE:
				setCandidate((VariableExpression)null);
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
			case Xmu2corePackage.ENFORCE_NODE_STATEMENT__TAG:
				return tag != TAG_EDEFAULT;
			case Xmu2corePackage.ENFORCE_NODE_STATEMENT__NULLABLE:
				return nullable != NULLABLE_EDEFAULT;
			case Xmu2corePackage.ENFORCE_NODE_STATEMENT__REFLECTIVE_IDENTIFIER:
				return reflectiveIdentifier != null;
			case Xmu2corePackage.ENFORCE_NODE_STATEMENT__REFLECTIVE:
				return reflective != REFLECTIVE_EDEFAULT;
			case Xmu2corePackage.ENFORCE_NODE_STATEMENT__NODE:
				return node != null;
			case Xmu2corePackage.ENFORCE_NODE_STATEMENT__TYPE:
				return type != null;
			case Xmu2corePackage.ENFORCE_NODE_STATEMENT__CANDIDATE:
				return candidate != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == DomainElement.class) {
			switch (derivedFeatureID) {
				case Xmu2corePackage.ENFORCE_NODE_STATEMENT__TAG: return Xmu2commonPackage.DOMAIN_ELEMENT__TAG;
				default: return -1;
			}
		}
		if (baseClass == Nullable.class) {
			switch (derivedFeatureID) {
				case Xmu2corePackage.ENFORCE_NODE_STATEMENT__NULLABLE: return Xmu2corePackage.NULLABLE__NULLABLE;
				default: return -1;
			}
		}
		if (baseClass == ReflectiveSupport.class) {
			switch (derivedFeatureID) {
				case Xmu2corePackage.ENFORCE_NODE_STATEMENT__REFLECTIVE_IDENTIFIER: return Xmu2corePackage.REFLECTIVE_SUPPORT__REFLECTIVE_IDENTIFIER;
				case Xmu2corePackage.ENFORCE_NODE_STATEMENT__REFLECTIVE: return Xmu2corePackage.REFLECTIVE_SUPPORT__REFLECTIVE;
				default: return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
		if (baseClass == DomainElement.class) {
			switch (baseFeatureID) {
				case Xmu2commonPackage.DOMAIN_ELEMENT__TAG: return Xmu2corePackage.ENFORCE_NODE_STATEMENT__TAG;
				default: return -1;
			}
		}
		if (baseClass == Nullable.class) {
			switch (baseFeatureID) {
				case Xmu2corePackage.NULLABLE__NULLABLE: return Xmu2corePackage.ENFORCE_NODE_STATEMENT__NULLABLE;
				default: return -1;
			}
		}
		if (baseClass == ReflectiveSupport.class) {
			switch (baseFeatureID) {
				case Xmu2corePackage.REFLECTIVE_SUPPORT__REFLECTIVE_IDENTIFIER: return Xmu2corePackage.ENFORCE_NODE_STATEMENT__REFLECTIVE_IDENTIFIER;
				case Xmu2corePackage.REFLECTIVE_SUPPORT__REFLECTIVE: return Xmu2corePackage.ENFORCE_NODE_STATEMENT__REFLECTIVE;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (tag: ");
		result.append(tag);
		result.append(", nullable: ");
		result.append(nullable);
		result.append(", reflective: ");
		result.append(reflective);
		result.append(')');
		return result.toString();
	}

} //EnforceNodeStatementImpl
