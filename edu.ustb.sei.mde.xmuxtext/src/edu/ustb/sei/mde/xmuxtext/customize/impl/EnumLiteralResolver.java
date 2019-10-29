package edu.ustb.sei.mde.xmuxtext.customize.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.resource.EObjectDescription;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.impl.SimpleScope;

import edu.ustb.sei.mde.xmu2.expression.EnumLiteralExpression;
import edu.ustb.sei.mde.xmuxtext.customize.common.IReferenceResolver;

public class EnumLiteralResolver implements IReferenceResolver {

	public EnumLiteralResolver() {
		// TODO Auto-generated constructor stub
	}

	
	@Override
	public IScope getScope(EObject context, EReference reference) {
		if(context instanceof EnumLiteralExpression) {
			EEnum e = ((EnumLiteralExpression) context).getType();
			if(e==null)
				return IScope.NULLSCOPE;
			else {
				return new SimpleScope(getLiterals(e));
			}
		}

		
		return IReferenceResolver.super.getScope(context, reference);
	}
	
	private Map<EEnum, List<IEObjectDescription>> literalsOfEnum = new HashMap<EEnum, List<IEObjectDescription>>();
	private List<IEObjectDescription> getLiterals(EEnum e) {
		List<IEObjectDescription> list = literalsOfEnum.get(e);
		if(list==null) {
			list = new ArrayList<IEObjectDescription>();
			for(EEnumLiteral el : e.getELiterals()) {
				IEObjectDescription ed = EObjectDescription.create(el.getName(), el);
				list.add(ed);
			}
			literalsOfEnum.put(e, list);
		}
		return list;
	}
	
}
