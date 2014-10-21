/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package edu.ustb.sei.mde.morel.resource.morel.analysis;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;

import edu.ustb.sei.mde.morel.resource.morel.IMorelReferenceResolveResult;

public class EnclosureLinkConstraintForwardReferenceResolver implements edu.ustb.sei.mde.morel.resource.morel.IMorelReferenceResolver<edu.ustb.sei.mde.morel.EnclosureLinkConstraint, org.eclipse.emf.ecore.EReference> {
	
	private edu.ustb.sei.mde.morel.resource.morel.analysis.MorelDefaultResolverDelegate<edu.ustb.sei.mde.morel.EnclosureLinkConstraint, org.eclipse.emf.ecore.EReference> delegate = new edu.ustb.sei.mde.morel.resource.morel.analysis.MorelDefaultResolverDelegate<edu.ustb.sei.mde.morel.EnclosureLinkConstraint, org.eclipse.emf.ecore.EReference>();
	
	private void findFeature(String partial, EClass c, IMorelReferenceResolveResult<EReference> result) {
		List<EReference> refs = c.getEAllReferences();
		for(EReference ref : refs) {
			//if(ref.getName().indexOf(partial)==-1) continue;
			result.addMapping(ref.getName(), ref);
		}
	}
	
	public void resolve(String identifier, edu.ustb.sei.mde.morel.EnclosureLinkConstraint container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, final edu.ustb.sei.mde.morel.resource.morel.IMorelReferenceResolveResult<org.eclipse.emf.ecore.EReference> result) {
		if(resolveFuzzy) {
			if(container.getSource()!=null) {
				EClass c = container.getSource().getType();
				findFeature(identifier,c,result);
			}
			
			for(EReference r: container.getForward()) {
				EClass c = r.getEReferenceType();
				if(c==null) continue;
				findFeature(identifier,c,result);
			}
			
			for(EClass c : container.getTypes()) {
				if(c==null) continue;
				findFeature(identifier,c,result);
			}
		} else {
			if(container.getSource()!=null) {
				EClass c = container.getSource().getType();
				EStructuralFeature feature = (c.getEStructuralFeature(identifier));
				if(feature!=null && feature instanceof EReference) {
					result.addMapping(identifier, (EReference) feature);
					return;
				}
			}
			
			for(EReference r: container.getForward()) {
				EClass c = r.getEReferenceType();
				if(c==null) continue;
				EStructuralFeature feature = (c.getEStructuralFeature(identifier));
				if(feature!=null && feature instanceof EReference) {
					result.addMapping(identifier, (EReference) feature);
					return;
				}
			}
			
			for(EClass c : container.getTypes()) {
				if(c==null) continue;
				EStructuralFeature feature = (c.getEStructuralFeature(identifier));
				if(feature!=null && feature instanceof EReference) {
					result.addMapping(identifier, (EReference) feature);
					return;
				}
			}
		}
	}
	
	public String deResolve(org.eclipse.emf.ecore.EReference element, edu.ustb.sei.mde.morel.EnclosureLinkConstraint container, org.eclipse.emf.ecore.EReference reference) {
		return element.getName();
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		// save options in a field or leave method empty if this resolver does not depend
		// on any option
	}
	
}
