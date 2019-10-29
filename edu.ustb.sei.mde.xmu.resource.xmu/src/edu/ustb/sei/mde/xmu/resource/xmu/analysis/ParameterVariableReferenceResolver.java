/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package edu.ustb.sei.mde.xmu.resource.xmu.analysis;

import edu.ustb.sei.mde.xmu.ObjectVariable;
import edu.ustb.sei.mde.xmu.PrimitiveVariable;
import edu.ustb.sei.mde.xmu.Rule;
import edu.ustb.sei.mde.xmu.Variable;
import edu.ustb.sei.mde.xmu.XmuFactory;

public class ParameterVariableReferenceResolver implements edu.ustb.sei.mde.xmu.resource.xmu.IXmuReferenceResolver<edu.ustb.sei.mde.xmu.Parameter, edu.ustb.sei.mde.xmu.Variable> {
	
	private edu.ustb.sei.mde.xmu.resource.xmu.analysis.XmuDefaultResolverDelegate<edu.ustb.sei.mde.xmu.Parameter, edu.ustb.sei.mde.xmu.Variable> delegate = new edu.ustb.sei.mde.xmu.resource.xmu.analysis.XmuDefaultResolverDelegate<edu.ustb.sei.mde.xmu.Parameter, edu.ustb.sei.mde.xmu.Variable>();
	
	public void resolve(String identifier, edu.ustb.sei.mde.xmu.Parameter container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, final edu.ustb.sei.mde.xmu.resource.xmu.IXmuReferenceResolveResult<edu.ustb.sei.mde.xmu.Variable> result) {
		if(identifier==null || container==null) return;
		Rule r = Util.getRule(container);
		Variable v = null;
		
		//Util.cleanVariable(r);
		
		switch(container.getTag()) {
		case SOURCE:
			v = Util.getVariable(identifier, r.getSVars());
			if(v==null) {
				v = XmuFactory.eINSTANCE.createObjectVariable();
				v.setName(identifier);
				r.getSVars().add((ObjectVariable) v);
				
				Variable spv = XmuFactory.eINSTANCE.createObjectVariable();
				spv.setName(identifier+Util.POST_FLAG);
				r.getSpVars().add((ObjectVariable) spv);
			}
			result.addMapping(identifier, v);
			
			break;
		case VIEW:
			v = Util.getVariable(identifier, r.getVVars());
			if(v==null) {
				v = XmuFactory.eINSTANCE.createObjectVariable();
				v.setName(identifier);
				r.getVVars().add((ObjectVariable) v);				
			}
			result.addMapping(identifier, v);
			break;
		case NORMAL:
			v = Util.getVariable(identifier, r.getNVars());
			if(v==null) {
				v = XmuFactory.eINSTANCE.createPrimitiveVariable();
				v.setName(identifier);
				r.getNVars().add((PrimitiveVariable) v);				
			}
			result.addMapping(identifier, v);
			break;
			default:
				break;
		}
	}
	
	public String deResolve(edu.ustb.sei.mde.xmu.Variable element, edu.ustb.sei.mde.xmu.Parameter container, org.eclipse.emf.ecore.EReference reference) {
		return delegate.deResolve(element, container, reference);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		// save options in a field or leave method empty if this resolver does not depend
		// on any option
	}
	
}
