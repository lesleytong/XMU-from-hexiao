package edu.ustb.sei.mde.morel.resource.processer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.lang.model.type.PrimitiveType;

import org.eclipse.core.runtime.internal.adaptor.EclipseStorageHook;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.ETypeParameter;
import org.eclipse.emf.ecore.ETypedElement;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.osgi.framework.internal.reliablefile.ReliableFileOutputStream;

import edu.ustb.sei.mde.morel.AdditiveExp;
import edu.ustb.sei.mde.morel.AdditiveExpChild;
import edu.ustb.sei.mde.morel.AtomicExp;
import edu.ustb.sei.mde.morel.BindExp;
import edu.ustb.sei.mde.morel.BooleanAndExp;
import edu.ustb.sei.mde.morel.BooleanAndExpChild;
import edu.ustb.sei.mde.morel.BooleanImpliesExp;
import edu.ustb.sei.mde.morel.BooleanLiteralExp;
import edu.ustb.sei.mde.morel.BooleanOrExp;
import edu.ustb.sei.mde.morel.BooleanOrExpChild;
import edu.ustb.sei.mde.morel.CallPathExp;
import edu.ustb.sei.mde.morel.EnclosureLinkConstraint;
import edu.ustb.sei.mde.morel.Expression;
import edu.ustb.sei.mde.morel.FeaturePathExp;
import edu.ustb.sei.mde.morel.IntegerLiteralExp;
import edu.ustb.sei.mde.morel.LinkConstraint;
import edu.ustb.sei.mde.morel.LiteralExp;
import edu.ustb.sei.mde.morel.MultiplicativeExp;
import edu.ustb.sei.mde.morel.MultiplicativeExpChild;
import edu.ustb.sei.mde.morel.NestedExp;
import edu.ustb.sei.mde.morel.ObjectVariable;
import edu.ustb.sei.mde.morel.OperationPathExp;
import edu.ustb.sei.mde.morel.PathConstraint;
import edu.ustb.sei.mde.morel.Pattern;
import edu.ustb.sei.mde.morel.PrimitiveVariable;
import edu.ustb.sei.mde.morel.RealLiteralExp;
import edu.ustb.sei.mde.morel.RelationalExp;
import edu.ustb.sei.mde.morel.Rule;
import edu.ustb.sei.mde.morel.SimpleLinkConstraint;
import edu.ustb.sei.mde.morel.StringLiteralExp;
import edu.ustb.sei.mde.morel.UnaryExp;
import edu.ustb.sei.mde.morel.UnaryOperator;
import edu.ustb.sei.mde.morel.Variable;
import edu.ustb.sei.mde.morel.VariableExp;
import edu.ustb.sei.mde.morel.resource.morel.IMorelOptionProvider;
import edu.ustb.sei.mde.morel.resource.morel.IMorelOptions;
import edu.ustb.sei.mde.morel.resource.morel.IMorelResourcePostProcessor;
import edu.ustb.sei.mde.morel.resource.morel.IMorelResourcePostProcessorProvider;
import edu.ustb.sei.mde.morel.resource.morel.MorelEProblemSeverity;
import edu.ustb.sei.mde.morel.resource.morel.MorelEProblemType;
import edu.ustb.sei.mde.morel.resource.morel.analysis.TypeResolver;
import edu.ustb.sei.mde.morel.resource.morel.mopp.MorelProblem;
import edu.ustb.sei.mde.morel.resource.morel.mopp.MorelResource;

public class TypeCheckingProcesser implements IMorelResourcePostProcessor,
		IMorelOptionProvider, IMorelResourcePostProcessorProvider {

	@Override
	public IMorelResourcePostProcessor getResourcePostProcessor() {
		return this;
	}

	@Override
	public Map<?, ?> getOptions() {
		return Collections.singletonMap(
				IMorelOptions.RESOURCE_POSTPROCESSOR_PROVIDER, this);
	}

	private boolean terminateFlag;

	@Override
	public void process(MorelResource resource) {
		terminateFlag = false;
		List<EObject> objs = resource.getContents();
		try {
			checkExprs(resource, objs);
		} catch (Exception e) {
		}

	}

	private void checkExprs(MorelResource resource, List<EObject> objs) {
		if (terminateFlag)
			return;
		for (EObject obj : objs) {
			if(obj instanceof Rule) {
				HashMap<String, Variable> vars = new HashMap<String, Variable>();
				for(Pattern p : ((Rule) obj).getPatterns()) {
					for(Variable v : p.getVariables()) {
						Variable ev = vars.get(v.getName());
						if(ev==null) {
							vars.put(v.getName(), v);
						} else {
							if(v instanceof ObjectVariable && ev instanceof ObjectVariable) {
								if(((ObjectVariable)v).getType()!=((ObjectVariable)ev).getType()){
									resource.addWarning(
											"The definition of this variable is different from the previous one.",
											MorelEProblemType.ANALYSIS_PROBLEM, v);
								}
							} else if(v instanceof PrimitiveVariable && ev instanceof PrimitiveVariable) {
								if(!((PrimitiveVariable)v).getType().equals(((PrimitiveVariable)ev).getType())){
									resource.addWarning(
											"The definition of this variable is different from the previous one.",
											MorelEProblemType.ANALYSIS_PROBLEM, v);
								}
							} else {
								resource.addWarning(
										"The definition of this variable is different from the previous one.",
										MorelEProblemType.ANALYSIS_PROBLEM, v);
							}
						}
					}
				}
				
			} 	
			
			if (!checkExp(obj)) {
				resource.addWarning(
						"The expression does not pass the type check",
						MorelEProblemType.ANALYSIS_PROBLEM, obj);
			}

			if (terminateFlag)
				return;

			checkExprs(resource, obj.eContents());
		}
	}

	private boolean checkExp(EObject obj) {
		if (isAtomicExp(obj)) {
			EClassifier cls = calculateExpType((Expression) obj);
			return cls != null;
		} else if (obj instanceof BindExp) {
			VariableExp source = ((BindExp) obj).getSource();
			EClassifier c = calculateExpType(source);
			Expression val = ((BindExp) obj).getValueExp();
			EClassifier cls = calculateExpType((Expression) val);
			if(cls == EcorePackage.eINSTANCE.getEObject())
				return true;
			if (c instanceof EDataType && cls instanceof EDataType) {
				return checkDataType(c, cls);
			} else if (c instanceof EClass && cls instanceof EClass) {
				if (((EClass) c).isSuperTypeOf((EClass)cls)) {
					return true;
				} else
					return false;
			}
			return false;

		}
		return true;
	}

	private boolean checkDataType(EClassifier c, EClassifier cls) {
			if((c.equals(EcorePackage.eINSTANCE.getEInt())&&cls.equals(EcorePackage.eINSTANCE.getEIntegerObject())) ||(c.equals(EcorePackage.eINSTANCE.getEIntegerObject())&&cls.equals(EcorePackage.eINSTANCE.getEInt()))){
				return true;
			}
			else if((c.equals(EcorePackage.eINSTANCE.getEDouble())&&cls.equals(EcorePackage.eINSTANCE.getEDoubleObject())) ||(c.equals(EcorePackage.eINSTANCE.getEDoubleObject())&&cls.equals(EcorePackage.eINSTANCE.getEDouble()))){
				
			}
			else if((c.equals(EcorePackage.eINSTANCE.getEDouble()) ||c.equals(EcorePackage.eINSTANCE.getEDoubleObject()))  && (cls.equals(EcorePackage.eINSTANCE.getEInt()) || cls.equals(EcorePackage.eINSTANCE.getEIntegerObject()))){
				return true;
			}else if((c.equals(EcorePackage.eINSTANCE.getEBoolean())&&cls.equals(EcorePackage.eINSTANCE.getEBooleanObject())) ||(c.equals(EcorePackage.eINSTANCE.getEBooleanObject())&&cls.equals(EcorePackage.eINSTANCE.getEBoolean())))
			   return true;
				return c.equals(cls);
	}

	/*
	 * 计算exp的类型，如果返回null表示类型错误，如果返回EObject，表示无法继续判断
	 */
	public EClassifier calculateExpType(Expression exp) {
	
     
		if (exp instanceof VariableExp) {
			Variable referredVariable = ((VariableExp) exp)
					.getReferredVariable();
			if (referredVariable instanceof ObjectVariable)
				return checkType(((ObjectVariable) referredVariable).getType(),
						((VariableExp) exp).getPath());
			else
				return ((PrimitiveVariable)referredVariable).getType();
		}

		else if (exp instanceof NestedExp) {
			Expression e = ((NestedExp) exp).getExpression();
			EClassifier type = calculateExpType(e);

			return checkType(type, ((NestedExp) exp).getPath());
		}
		else if(exp instanceof MultiplicativeExp){
			List<MultiplicativeExpChild> children = ((MultiplicativeExp) exp).getChildren();
			if(children.size()==1)
			return calculateExpType(children.get(0)); 
			else{
				//判断类型大的返回
			}
		}else if(exp instanceof LiteralExp){
			if(exp instanceof StringLiteralExp)
				return EcorePackage.eINSTANCE.getEString();
			else if(exp instanceof IntegerLiteralExp)
				return EcorePackage.eINSTANCE.getEIntegerObject();
			else if(exp instanceof RealLiteralExp)
				return EcorePackage.eINSTANCE.getEDoubleObject();
			else if(exp instanceof BooleanLiteralExp)
				return EcorePackage.eINSTANCE.getEBooleanObject();
		}else if(exp instanceof BooleanAndExp){
			EList<BooleanAndExpChild> children = ((BooleanAndExp) exp).getChildren();
			if(children.size()==1)
				return calculateExpType(children.get(0));
			else
				return EcorePackage.eINSTANCE.getEBooleanObject();
		}else if(exp instanceof BooleanOrExp){
			EList<BooleanOrExpChild> children=((BooleanOrExp) exp).getChildren();
			if(children.size()==1)
				return calculateExpType(children.get(0));
			else
				return EcorePackage.eINSTANCE.getEBooleanObject();
		}else if(exp instanceof RelationalExp){
			if(((RelationalExp) exp).getRight()==null)
				return calculateExpType(((RelationalExp) exp).getLeft());
			else
				return EcorePackage.eINSTANCE.getEBooleanObject();
		}else if(exp instanceof MultiplicativeExp){
			EList<MultiplicativeExpChild> children = ((MultiplicativeExp) exp).getChildren();
			//if(children.size()==1)
				return calculateExpType(children.get(0));
//			else
//			{
//				for(MultiplicativeExpChild mu:children)
//				{
//					if(calculateExpType(mu).equals(EcorePackage.eINSTANCE.getEDouble()) || (calculateExpType(mu).equals(EcorePackage.eINSTANCE.getEDoubleObject()))){
//						return EcorePackage.eINSTANCE.getEDoubleObject();
//					}
//				}
//				return EcorePackage.eINSTANCE.getEIntegerObject();
//			}
		}else if(exp instanceof AdditiveExp){
			EList<AdditiveExpChild> children = ((AdditiveExp) exp).getChildren();
			return calculateExpType(children.get(0));
		}else if(exp instanceof UnaryExp){
			return calculateExpType(((UnaryExp) exp).getChild());
		}
			
		
		return EcorePackage.eINSTANCE.getEObject();
	}

	/*
	 * 计算callPathExp类型是否正确，如果返回null，表示错误，如果返回EObject，表示无法继续计算
	 * cls不应为null且cls应该是EClass path可能为空
	 */
	public EClassifier checkType(EClassifier cls, CallPathExp path) {
		if (cls instanceof EDataType)
			return cls;
		if (path == null)
			return cls;

		if (path instanceof FeaturePathExp) {
			String s = ((FeaturePathExp) path).getFeature();
			EStructuralFeature eStructuralFeature = ((EClass) cls)
					.getEStructuralFeature(s);
			if (eStructuralFeature == null) {
				return null;
			} else
				return checkType(eStructuralFeature.getEType(), path.getNext());

		} else if (path instanceof OperationPathExp) {
			return EcorePackage.eINSTANCE.getEObject();// 此处为成功返回null;
		} else
			return null;
	}

	public boolean isAtomicExp(EObject o) {
		if (o instanceof AtomicExp) {
			return true;
		} else
			return false;
	}

	@Override
	public void terminate() {
		terminateFlag = true;
	}

}
