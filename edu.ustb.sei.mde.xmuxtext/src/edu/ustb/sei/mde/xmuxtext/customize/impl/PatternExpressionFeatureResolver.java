package edu.ustb.sei.mde.xmuxtext.customize.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.xtext.naming.IQualifiedNameConverter;
import org.eclipse.xtext.resource.EObjectDescription;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.Scopes;
import org.eclipse.xtext.scoping.impl.SimpleScope;

import edu.ustb.sei.mde.xmu2.expression.EnumLiteralExpression;
import edu.ustb.sei.mde.xmu2.pattern.PatternExpression;
import edu.ustb.sei.mde.xmu2.pattern.PatternNode;
import edu.ustb.sei.mde.xmuxtext.customize.common.IReferenceResolver;

public class PatternExpressionFeatureResolver implements IReferenceResolver {

	public PatternExpressionFeatureResolver() {
	}
	
	@Override
	public IScope getScope(EObject context, EReference reference) {
		if(context instanceof PatternExpression) {
			if(context==null || context.eContainer()==null  
					|| ((PatternNode)context.eContainer()).getVariable()==null)
				return IScope.NULLSCOPE;
			else {
				EClassifier c = ((PatternNode)context.eContainer()).getVariable().getType();
				if(c==null || !( c instanceof EClass) )
					return IScope.NULLSCOPE;
				else
					return new SimpleScope(IScope.NULLSCOPE, getFeatures((EClass)c));
			}
		}

		
		return IReferenceResolver.super.getScope(context, reference);
	}
	
	private Map<EClass, List<IEObjectDescription>> featuresOfClass = new HashMap<EClass, List<IEObjectDescription>>();
	private List<IEObjectDescription> getFeatures(EClass e) {
		List<IEObjectDescription> list = featuresOfClass.get(e);
		if(list==null) {
			list = new ArrayList<IEObjectDescription>();
			for(EStructuralFeature s : e.getEAllStructuralFeatures()) {
				IEObjectDescription ed = EObjectDescription.create(s.getName(), s);
				list.add(ed);
			}
			featuresOfClass.put(e, list);
		}
		return list;
	}
	
	@Override
	public EObject resolve(EObject context, EReference reference, String name, IQualifiedNameConverter qnc) {
		if(context!=null && name!=null) {
			PatternExpression e = (PatternExpression) context;
			PatternNode pn = (PatternNode) context.eContainer();
			if(pn!=null && pn.getVariable()!=null && pn.getVariable().getType()!=null) {
				EClassifier c = pn.getVariable().getType();
				
			} else 
				return null;
		}
		return IReferenceResolver.super.resolve(context, reference, name, qnc);
	}

	@Override
	public String desolve(EObject context, EReference reference, EObject target, IQualifiedNameConverter qnc) {
		if(target==null)
			return "";
		else {
			if(target instanceof EStructuralFeature)
				return ((EStructuralFeature) target).getName();
			else
				return "<error>";
		}

	}
}
