/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package edu.ustb.sei.mde.morel.resource.morel.analysis;

import org.eclipse.emf.ecore.EObject;

import edu.ustb.sei.mde.morel.TypedModel;
import edu.ustb.sei.mde.morel.Unit;

public class ObjectVariableModelReferenceResolver implements edu.ustb.sei.mde.morel.resource.morel.IMorelReferenceResolver<edu.ustb.sei.mde.morel.ObjectVariable, edu.ustb.sei.mde.morel.TypedModel> {
	
	private edu.ustb.sei.mde.morel.resource.morel.analysis.MorelDefaultResolverDelegate<edu.ustb.sei.mde.morel.ObjectVariable, edu.ustb.sei.mde.morel.TypedModel> delegate = new edu.ustb.sei.mde.morel.resource.morel.analysis.MorelDefaultResolverDelegate<edu.ustb.sei.mde.morel.ObjectVariable, edu.ustb.sei.mde.morel.TypedModel>();
	
	static private Unit getUnit(EObject container) {
		while(container instanceof EObject) {
			if(container instanceof Unit) {
				return (Unit) container;
			}
			container = container.eContainer();
			if(container==null) return null;
		}
		return null;
	}
	
	public void resolve(String identifier, edu.ustb.sei.mde.morel.ObjectVariable container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, final edu.ustb.sei.mde.morel.resource.morel.IMorelReferenceResolveResult<edu.ustb.sei.mde.morel.TypedModel> result) {
		if(resolveFuzzy) {
			Unit unit = getUnit(container);
			if(unit==null) {
				return;
			} else {
				for(TypedModel tm : unit.getModels()){
					result.addMapping(tm.getName(),tm);
				}
			}
		} else 
			delegate.resolve(identifier, container, reference, position, resolveFuzzy, result);
	}
	
	public String deResolve(edu.ustb.sei.mde.morel.TypedModel element, edu.ustb.sei.mde.morel.ObjectVariable container, org.eclipse.emf.ecore.EReference reference) {
		return delegate.deResolve(element, container, reference);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		// save options in a field or leave method empty if this resolver does not depend
		// on any option
	}
	
}
