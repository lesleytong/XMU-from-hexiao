/**
 */
package edu.ustb.sei.mde.emg.runtime.impl;

import edu.ustb.sei.mde.emg.runtime.Context;
import edu.ustb.sei.mde.emg.runtime.Environment;
import edu.ustb.sei.mde.emg.runtime.RuntimeFactory;
import edu.ustb.sei.mde.emg.runtime.RuntimePackage;
import edu.ustb.sei.mde.emg.runtime.datatype.OclUndefined;
import edu.ustb.sei.mde.morel.Pattern;
import edu.ustb.sei.mde.morel.Rule;
import edu.ustb.sei.mde.morel.SectionType;
import edu.ustb.sei.mde.morel.Variable;
import edu.ustb.sei.mde.morel.VariableWithInit;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Context</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link edu.ustb.sei.mde.emg.runtime.impl.ContextImpl#getBindingMap <em>Binding Map</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.emg.runtime.impl.ContextImpl#getHost <em>Host</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.emg.runtime.impl.ContextImpl#getParentContext <em>Parent Context</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.emg.runtime.impl.ContextImpl#getParentScope <em>Parent Scope</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.emg.runtime.impl.ContextImpl#getEnviroment <em>Enviroment</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.emg.runtime.impl.ContextImpl#getGlobal <em>Global</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ContextImpl extends MinimalEObjectImpl.Container implements Context {
	/**
	 * The cached value of the '{@link #getBindingMap() <em>Binding Map</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBindingMap()
	 * @generated
	 * @ordered
	 */
	protected Map<Variable, Object> bindingMap;

	/**
	 * The default value of the '{@link #getHost() <em>Host</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHost()
	 * @generated
	 * @ordered
	 */
	protected static final Object HOST_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getHost() <em>Host</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHost()
	 * @generated
	 * @ordered
	 */
	protected Object host = HOST_EDEFAULT;

	/**
	 * The cached value of the '{@link #getParentContext() <em>Parent Context</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParentContext()
	 * @generated
	 * @ordered
	 */
	protected Context parentContext;

	/**
	 * The cached value of the '{@link #getParentScope() <em>Parent Scope</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParentScope()
	 * @generated
	 * @ordered
	 */
	protected Context parentScope;

	/**
	 * The cached value of the '{@link #getEnviroment() <em>Enviroment</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEnviroment()
	 * @generated
	 * @ordered
	 */
	protected Environment enviroment;

	/**
	 * The cached value of the '{@link #getGlobal() <em>Global</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGlobal()
	 * @generated
	 * @ordered
	 */
	protected Context global;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ContextImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return RuntimePackage.Literals.CONTEXT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Map<Variable, Object> getBindingMap() {
		if(bindingMap==null){
			bindingMap = new HashMap<Variable,Object>();
		}
		return bindingMap;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBindingMap(Map<Variable, Object> newBindingMap) {
		Map<Variable, Object> oldBindingMap = bindingMap;
		bindingMap = newBindingMap;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RuntimePackage.CONTEXT__BINDING_MAP, oldBindingMap, bindingMap));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getHost() {
		return host;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setHost(Object newHost) {
		Object oldHost = host;
		host = newHost;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RuntimePackage.CONTEXT__HOST, oldHost, host));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Context getParentContext() {
		if (parentContext != null && parentContext.eIsProxy()) {
			InternalEObject oldParentContext = (InternalEObject)parentContext;
			parentContext = (Context)eResolveProxy(oldParentContext);
			if (parentContext != oldParentContext) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, RuntimePackage.CONTEXT__PARENT_CONTEXT, oldParentContext, parentContext));
			}
		}
		return parentContext;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Context basicGetParentContext() {
		return parentContext;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParentContext(Context newParentContext) {
		Context oldParentContext = parentContext;
		parentContext = newParentContext;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RuntimePackage.CONTEXT__PARENT_CONTEXT, oldParentContext, parentContext));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Context getParentScope() {
		if (parentScope != null && parentScope.eIsProxy()) {
			InternalEObject oldParentScope = (InternalEObject)parentScope;
			parentScope = (Context)eResolveProxy(oldParentScope);
			if (parentScope != oldParentScope) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, RuntimePackage.CONTEXT__PARENT_SCOPE, oldParentScope, parentScope));
			}
		}
		return parentScope;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Context basicGetParentScope() {
		return parentScope;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParentScope(Context newParentScope) {
		Context oldParentScope = parentScope;
		parentScope = newParentScope;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RuntimePackage.CONTEXT__PARENT_SCOPE, oldParentScope, parentScope));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Environment getEnviroment() {
		if (enviroment != null && enviroment.eIsProxy()) {
			InternalEObject oldEnviroment = (InternalEObject)enviroment;
			enviroment = (Environment)eResolveProxy(oldEnviroment);
			if (enviroment != oldEnviroment) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, RuntimePackage.CONTEXT__ENVIROMENT, oldEnviroment, enviroment));
			}
		}
		return enviroment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Environment basicGetEnviroment() {
		return enviroment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEnviroment(Environment newEnviroment) {
		Environment oldEnviroment = enviroment;
		enviroment = newEnviroment;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RuntimePackage.CONTEXT__ENVIROMENT, oldEnviroment, enviroment));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Context getGlobal() {
		if (global != null && global.eIsProxy()) {
			InternalEObject oldGlobal = (InternalEObject)global;
			global = (Context)eResolveProxy(oldGlobal);
			if (global != oldGlobal) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, RuntimePackage.CONTEXT__GLOBAL, oldGlobal, global));
			}
		}
		return global;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Context basicGetGlobal() {
		return global;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setGlobal(Context newGlobal) {
		Context oldGlobal = global;
		global = newGlobal;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RuntimePackage.CONTEXT__GLOBAL, oldGlobal, global));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void initWithHost() {
		Object host = getHost();
		
		if(host instanceof Pattern) {
			Pattern query = (Pattern)host;
			for(Variable v : query.getVariables()) {
				if(this.containVariable(v)) continue;
				else {
					if(v instanceof VariableWithInit) {
						Object value = OclUndefined.INVALIDED;
						this.registerVariable(v);
					} else 
						this.registerVariable(v);
						//map.put(v, OclUndefined.INVALIDED);
				}
			}
		} else if(host instanceof Rule) {
			Rule rule = (Rule)host;
			for(Pattern p : rule.getPatterns()) {
				if(p.getType()==SectionType.LHS || p.getType()==SectionType.RHS) {
					for(Variable v : p.getVariables()) {
						if(this.containVariable(v)) continue;
						else {
							if(v instanceof VariableWithInit) {
								Object value = OclUndefined.INVALIDED;
								this.registerVariable(v);
							} else 
								this.registerVariable(v);
						}
					}
				}
			}
		} 
//		else if(host instanceof BXRewritingRule) {
//			BXRewritingRule rule = (BXRewritingRule)host;
//			{
//				Pattern p = rule.getSource();
//				if(p!=null){
//					//if(p.getType()==SectionType.LHS || p.getType()==SectionType.RHS) {
//					for(Variable v : p.getVariables()) {
//						if(this.containVariable(v)) continue;
//						else {
//							if(v instanceof VariableWithInit) {
//								Object value = OclUndefined.INVALIDED;
//								this.registerVariable(v);
//							} else 
//								this.registerVariable(v);
//						}
//					}
//					//}
//				}
//			}
//			
//			{
//				Pattern p = rule.getView();
//				if(p!=null) {
//					//if(p.getType()==SectionType.LHS || p.getType()==SectionType.RHS) {
//					for(Variable v : p.getVariables()) {
//						if(this.containVariable(v)) continue;
//						else {
//							if(v instanceof VariableWithInit) {
//								Object value = OclUndefined.INVALIDED;
//								this.registerVariable(v);
//							} else 
//								this.registerVariable(v);
//						}
//						//}
//					}
//				}
//			}
//			
//			{
//				Pattern p = rule.getUnmatchSrc();
//				if(p!=null) {
//					//if(p.getType()==SectionType.LHS || p.getType()==SectionType.RHS) {
//					for(Variable v : p.getVariables()) {
//						if(this.containVariable(v)) continue;
//						else {
//							if(v instanceof VariableWithInit) {
//								Object value = OclUndefined.INVALIDED;
//								this.registerVariable(v);
//							} else 
//								this.registerVariable(v);
//						}
//					}
//					//}
//				}
//			}
//			
//			{
//				Pattern p = rule.getUnmatchView();
//				if(p!=null) {
//					//if(p.getType()==SectionType.LHS || p.getType()==SectionType.RHS) {
//					for(Variable v : p.getVariables()) {
//						if(this.containVariable(v)) continue;
//						else {
//							if(v instanceof VariableWithInit) {
//								Object value = OclUndefined.INVALIDED;
//								this.registerVariable(v);
//							} else 
//								this.registerVariable(v);
//						}
//					}
//					//}
//				}
//			}
//		} else if(host instanceof BxMorelRule) {
//			BxMorelRule rule = (BxMorelRule)host;
//			
//			{
//				Pattern p = rule.getSource();
//				if(p!=null){
//					//if(p.getType()==SectionType.LHS || p.getType()==SectionType.RHS) {
//					for(Variable v : p.getVariables()) {
//						if(this.containVariable(v)) continue;
//						else {
//							if(v instanceof VariableWithInit) {
//								Object value = OclUndefined.INVALIDED;
//								this.registerVariable(v);
//							} else 
//								this.registerVariable(v);
//						}
//					}
//					//}
//				}
//			}
//			
//			{
//				Pattern p = rule.getView();
//				if(p!=null) {
//					//if(p.getType()==SectionType.LHS || p.getType()==SectionType.RHS) {
//					for(Variable v : p.getVariables()) {
//						if(this.containVariable(v)) continue;
//						else {
//							if(v instanceof VariableWithInit) {
//								Object value = OclUndefined.INVALIDED;
//								this.registerVariable(v);
//							} else 
//								this.registerVariable(v);
//						}
//						//}
//					}
//				}
//			}
//		}
		
		reloadValue();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Context newScope() {
		Context context = instanceContext();
		context.setEnviroment(this.getEnviroment());
		context.setParentScope(this);
		context.setGlobal(getGlobal());
		return context;
	}

	protected Context instanceContext() {
		return RuntimeFactory.eINSTANCE.createContext();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Object getValue(Variable var) {
		Map<Variable, Object> map = this.getBindingMap();
		if(map.containsKey(var)){
			Object value = map.get(var);
			return value;
		} else {
			if(getParentScope()!=null)
				return getParentScope().getValue(var);
			else if(getGlobal()!=null)
				return getGlobal().getValue(var);
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Object get(String name) {
		if(name==null) return null;
		Variable v = this.findVariable(name);
		if(v==null)
			return null;
		return this.getValue(v);
	}
	
	

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void putValue(Variable var, Object value) {
		Map<Variable, Object> map = this.getBindingMap();
		if(map.containsKey(var)){
			map.put(var, value);
		} else {
			if(getParentScope()!=null)
				getParentScope().putValue(var, value);
			else if(getGlobal()!=null)
				getGlobal().putValue(var, value);
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Context getCopy() {
		Context copy = this.instanceContext();
		copy.setEnviroment(this.getEnviroment());
		copy.setParentContext(this.getParentContext());
		
		copy.setParentScope(this.getParentScope());
		
//		if(this.getParentScope()==null)
//			copy.setParentScope(null);
//		else copy.setParentScope(this.getParentScope().getCopy());
		
		copy.setParentScope(this.getParentScope());
		copy.setHost(this.getHost());
		copy.initWithHost();
		// because $this is not defined in host, this will cause the lose of $this
		copyBindings(copy);
		
		copy.setGlobal(getGlobal());
		
		return copy;
	}

	protected void copyBindings(Context copy) {
		for(Map.Entry<Variable, Object> entry : this.getBindingMap().entrySet()){
			copy.putValue(entry.getKey(), entry.getValue());
		}	
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void registerVariable(Variable var) {
		this.getBindingMap().put(var, OclUndefined.INVALIDED);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean containVariable(Variable var) {
		if(this.getBindingMap().containsKey(var))
			return true;
		else if(this.getParentScope()!=null&&this.getParentScope()!=this)
			return getParentScope().containVariable(var);
		else return false;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Variable findVariable(String name) {
		Map<Variable, Object> map = this.getBindingMap();
		for(Entry<Variable,Object> e : map.entrySet()) {
			if(e.getKey().getName().equals(name)) return e.getKey();
		}
		if(this.getParentScope()==null) {
			if(getGlobal()!=null)
				return getGlobal().findVariable(name);
			else
				return null;
		}
		else return this.getParentScope().findVariable(name);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case RuntimePackage.CONTEXT__BINDING_MAP:
				return getBindingMap();
			case RuntimePackage.CONTEXT__HOST:
				return getHost();
			case RuntimePackage.CONTEXT__PARENT_CONTEXT:
				if (resolve) return getParentContext();
				return basicGetParentContext();
			case RuntimePackage.CONTEXT__PARENT_SCOPE:
				if (resolve) return getParentScope();
				return basicGetParentScope();
			case RuntimePackage.CONTEXT__ENVIROMENT:
				if (resolve) return getEnviroment();
				return basicGetEnviroment();
			case RuntimePackage.CONTEXT__GLOBAL:
				if (resolve) return getGlobal();
				return basicGetGlobal();
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
			case RuntimePackage.CONTEXT__BINDING_MAP:
				setBindingMap((Map<Variable, Object>)newValue);
				return;
			case RuntimePackage.CONTEXT__HOST:
				setHost(newValue);
				return;
			case RuntimePackage.CONTEXT__PARENT_CONTEXT:
				setParentContext((Context)newValue);
				return;
			case RuntimePackage.CONTEXT__PARENT_SCOPE:
				setParentScope((Context)newValue);
				return;
			case RuntimePackage.CONTEXT__ENVIROMENT:
				setEnviroment((Environment)newValue);
				return;
			case RuntimePackage.CONTEXT__GLOBAL:
				setGlobal((Context)newValue);
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
			case RuntimePackage.CONTEXT__BINDING_MAP:
				setBindingMap((Map<Variable, Object>)null);
				return;
			case RuntimePackage.CONTEXT__HOST:
				setHost(HOST_EDEFAULT);
				return;
			case RuntimePackage.CONTEXT__PARENT_CONTEXT:
				setParentContext((Context)null);
				return;
			case RuntimePackage.CONTEXT__PARENT_SCOPE:
				setParentScope((Context)null);
				return;
			case RuntimePackage.CONTEXT__ENVIROMENT:
				setEnviroment((Environment)null);
				return;
			case RuntimePackage.CONTEXT__GLOBAL:
				setGlobal((Context)null);
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
			case RuntimePackage.CONTEXT__BINDING_MAP:
				return bindingMap != null;
			case RuntimePackage.CONTEXT__HOST:
				return HOST_EDEFAULT == null ? host != null : !HOST_EDEFAULT.equals(host);
			case RuntimePackage.CONTEXT__PARENT_CONTEXT:
				return parentContext != null;
			case RuntimePackage.CONTEXT__PARENT_SCOPE:
				return parentScope != null;
			case RuntimePackage.CONTEXT__ENVIROMENT:
				return enviroment != null;
			case RuntimePackage.CONTEXT__GLOBAL:
				return global != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case RuntimePackage.CONTEXT___INIT_WITH_HOST:
				initWithHost();
				return null;
			case RuntimePackage.CONTEXT___NEW_SCOPE:
				return newScope();
			case RuntimePackage.CONTEXT___GET_VALUE__VARIABLE:
				return getValue((Variable)arguments.get(0));
			case RuntimePackage.CONTEXT___GET__STRING:
				return get((String)arguments.get(0));
			case RuntimePackage.CONTEXT___PUT_VALUE__VARIABLE_OBJECT:
				putValue((Variable)arguments.get(0), arguments.get(1));
				return null;
			case RuntimePackage.CONTEXT___GET_COPY:
				return getCopy();
			case RuntimePackage.CONTEXT___REGISTER_VARIABLE__VARIABLE:
				registerVariable((Variable)arguments.get(0));
				return null;
			case RuntimePackage.CONTEXT___CONTAIN_VARIABLE__VARIABLE:
				return containVariable((Variable)arguments.get(0));
			case RuntimePackage.CONTEXT___FIND_VARIABLE__STRING:
				return findVariable((String)arguments.get(0));
		}
		return super.eInvoke(operationID, arguments);
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
		result.append(" (bindingMap: ");
		result.append(bindingMap);
		result.append(", host: ");
		result.append(host);
		result.append(')');
		return result.toString();
	}
	
	

	private Map<String, Object> map;
	@Override
	public void registerValueMap(Map<String,Object> map) {
		// TODO Auto-generated method stub
		this.map = map;
	}
	
	protected void reloadValue() {
		if(map==null) return;
		for(Entry<String,Object> entry : map.entrySet()) {
			Variable v = this.findVariable(entry.getKey());
			if(v!=null) {
				this.putValue(v, entry.getValue());
			}
		}
	}
} //ContextImpl
