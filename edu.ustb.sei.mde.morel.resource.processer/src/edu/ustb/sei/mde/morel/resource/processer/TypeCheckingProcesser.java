package edu.ustb.sei.mde.morel.resource.processer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import javax.lang.model.type.PrimitiveType;

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

import edu.ustb.sei.mde.morel.AdditiveExp;
import edu.ustb.sei.mde.morel.AtomicExp;
import edu.ustb.sei.mde.morel.BooleanAndExp;
import edu.ustb.sei.mde.morel.BooleanImpliesExp;
import edu.ustb.sei.mde.morel.BooleanOrExp;
import edu.ustb.sei.mde.morel.CallPathExp;
import edu.ustb.sei.mde.morel.EnclosureLinkConstraint;
import edu.ustb.sei.mde.morel.Expression;
import edu.ustb.sei.mde.morel.FeaturePathExp;
import edu.ustb.sei.mde.morel.LinkConstraint;
import edu.ustb.sei.mde.morel.LiteralExp;
import edu.ustb.sei.mde.morel.MultiplicativeExp;
import edu.ustb.sei.mde.morel.NestedExp;
import edu.ustb.sei.mde.morel.ObjectVariable;
import edu.ustb.sei.mde.morel.OperationPathExp;
import edu.ustb.sei.mde.morel.PathConstraint;
import edu.ustb.sei.mde.morel.PrimitiveVariable;
import edu.ustb.sei.mde.morel.RelationalExp;
import edu.ustb.sei.mde.morel.SimpleLinkConstraint;
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
		if(terminateFlag) return;
		for (EObject obj : objs) {
			if(!checkExp(obj)) {
				resource.addWarning("The expression does not pass the type check", MorelEProblemType.ANALYSIS_PROBLEM, obj);
			}
			
			if(terminateFlag) return;
			
			checkExprs(resource, obj.eContents());
		}
	}

	private boolean checkExp(EObject obj) {
		if (isAtomicExp(obj)) {
			EClassifier cls = calculateExpType((Expression) obj);
			return cls!=null;
		}
		return true;
	}

	/*
	 * 计算exp的类型，如果返回null表示类型错误，如果返回EObject，表示无法继续判断
	 */
	public EClassifier calculateExpType(Expression exp){
		
		if(exp instanceof VariableExp)
		{
			Variable referredVariable = ((VariableExp) exp)
					.getReferredVariable();
			if (referredVariable instanceof ObjectVariable)
				return checkType(((ObjectVariable) referredVariable).getType(),((VariableExp) exp).getPath());
			else
				return EcorePackage.eINSTANCE.getEObject();// 表示成功
		}

		else if(exp instanceof NestedExp)
		{
			Expression e=((NestedExp) exp).getExpression();
			EClassifier type=calculateExpType(e);
			
			return checkType(type,((NestedExp) exp).getPath());
		}
		return EcorePackage.eINSTANCE.getEObject();
	}
	
	/*
	 * 计算callPathExp类型是否正确，如果返回null，表示错误，如果返回EObject，表示无法继续计算
	 * cls不应为null且cls应该是EClass
	 * path可能为空
	 */
	public EClassifier checkType(EClassifier cls,CallPathExp path)
	{
		if(cls instanceof EDataType) return EcorePackage.eINSTANCE.getEObject();
		if(path==null) return cls;
		
		if(path instanceof FeaturePathExp) {
			String s = ((FeaturePathExp) path).getFeature();
			EStructuralFeature eStructuralFeature = ((EClass) cls)
					.getEStructuralFeature(s);
			if (eStructuralFeature == null) {
				return null;
			} else 
				return checkType(eStructuralFeature.getEType(),path.getNext());
			
		} else if(path instanceof OperationPathExp) {
			return EcorePackage.eINSTANCE.getEObject();//此处为成功返回null;
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
