/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package edu.ustb.sei.mde.morel.resource.morel.analysis;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;

import edu.ustb.sei.mde.morel.ObjectVariable;
import edu.ustb.sei.mde.morel.Variable;
import edu.ustb.sei.mde.morel.VariableExp;

public class LinkConstraintReferenceReferenceResolver implements edu.ustb.sei.mde.morel.resource.morel.IMorelReferenceResolver<edu.ustb.sei.mde.morel.LinkConstraint, org.eclipse.emf.ecore.EReference> {
	
	private edu.ustb.sei.mde.morel.resource.morel.analysis.MorelDefaultResolverDelegate<edu.ustb.sei.mde.morel.LinkConstraint, org.eclipse.emf.ecore.EReference> delegate = new edu.ustb.sei.mde.morel.resource.morel.analysis.MorelDefaultResolverDelegate<edu.ustb.sei.mde.morel.LinkConstraint, org.eclipse.emf.ecore.EReference>();
	
	public void resolve(String identifier, edu.ustb.sei.mde.morel.LinkConstraint container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, final edu.ustb.sei.mde.morel.resource.morel.IMorelReferenceResolveResult<org.eclipse.emf.ecore.EReference> result) {
		ObjectVariable source = container.getSource();
		if(source==null) return;
		EClass srcType = source.getType();
		if(srcType==null) return;
		List<EReference> list = srcType.getEAllReferences();
		for(EReference ref : list) {
			if(ref.getName().equals(identifier)) {
				ObjectVariable target = container.getTarget();
				if(target==null||target.getType()==null) {
					result.addMapping(identifier, ref);
				} else {
					if(ref.getEReferenceType().isSuperTypeOf(target.getType()))
						result.addMapping(identifier, ref);
				}
			}
		}
	}
	
	public String deResolve(org.eclipse.emf.ecore.EReference element, edu.ustb.sei.mde.morel.LinkConstraint container, org.eclipse.emf.ecore.EReference reference) {
		//return delegate.deResolve(element, container, reference);
		return reference.getName();
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		// save options in a field or leave method empty if this resolver does not depend
		// on any option
	}
	
}
