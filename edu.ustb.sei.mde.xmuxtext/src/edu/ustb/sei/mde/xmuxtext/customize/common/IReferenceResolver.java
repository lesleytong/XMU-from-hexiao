package edu.ustb.sei.mde.xmuxtext.customize.common;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.naming.IQualifiedNameConverter;
import org.eclipse.xtext.naming.IQualifiedNameProvider;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;

public interface IReferenceResolver {
	default IScope getScope(EObject context, EReference reference) {
		return IScope.NULLSCOPE;
	}
	
	default EObject resolve(EObject context, EReference reference, String name, IQualifiedNameConverter qnc) {
		IScope scope = this.getScope(context, reference);
		QualifiedName qn = qnc.toQualifiedName(name);
		IEObjectDescription eobjDesc = scope.getSingleElement(qn);
		if(eobjDesc!=null)
			return eobjDesc.getEObjectOrProxy();
		else 
			return null;
	}
	
	default String desolve(EObject context, EReference reference, EObject target, IQualifiedNameConverter qnc) {
		IScope scope = this.getScope(context, reference);
		IEObjectDescription eobjDesc = scope.getSingleElement(target);
		if(eobjDesc!=null)
			return qnc.toString(eobjDesc.getName());
		else 
			return "";
	}
}
