/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package edu.ustb.sei.mde.xmu.resource.xmu.analysis;

import edu.ustb.sei.mde.xmu.Rule;
import edu.ustb.sei.mde.xmu.TaggedElement;
import edu.ustb.sei.mde.xmu.Variable;

public class VariableExpVarReferenceResolver implements edu.ustb.sei.mde.xmu.resource.xmu.IXmuReferenceResolver<edu.ustb.sei.mde.xmu.VariableExp, edu.ustb.sei.mde.xmu.Variable> {
	
	private edu.ustb.sei.mde.xmu.resource.xmu.analysis.XmuDefaultResolverDelegate<edu.ustb.sei.mde.xmu.VariableExp, edu.ustb.sei.mde.xmu.Variable> delegate = new edu.ustb.sei.mde.xmu.resource.xmu.analysis.XmuDefaultResolverDelegate<edu.ustb.sei.mde.xmu.VariableExp, edu.ustb.sei.mde.xmu.Variable>();
	
	public void resolve(String identifier, edu.ustb.sei.mde.xmu.VariableExp container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, final edu.ustb.sei.mde.xmu.resource.xmu.IXmuReferenceResolveResult<edu.ustb.sei.mde.xmu.Variable> result) {
		if(identifier==null || container==null) return;
		Rule r = Util.getRule(container);
		if(r==null) return;
		TaggedElement t = Util.getTaggedElement(container);
		Variable v = null;

		if(t==null) {
			v = Util.getVariable(identifier, r.getNVars());
			if(v==null) v = Util.getVariable(identifier, r.getSVars());
			if(v==null) v = Util.getVariable(identifier, r.getVVars());
			if(v==null) v = Util.getVariable(identifier, r.getSpVars());
			if(v!=null) {
				result.addMapping(identifier, v);
			}
			return;
		} else {
//			switch(t.getTag()) {
//			case NORMAL:
				v = Util.getVariable(identifier, r.getNVars());
				if(v==null) v = Util.getVariable(identifier, r.getSVars());
				if(v==null) v = Util.getVariable(identifier, r.getVVars());
				if(v==null) v = Util.getVariable(identifier, r.getSpVars());
//				break;
//			case SOURCE:
//				v = Util.getVariable(identifier, r.getNVars());
//				if(v==null) v = Util.getVariable(identifier, r.getSVars());
//				break;
//			case VIEW:
//				v = Util.getVariable(identifier, r.getNVars());
//				if(v==null) v = Util.getVariable(identifier, r.getVVars());
//				break;
//			case SOURCE_POST:
//				v = Util.getVariable(identifier, r.getNVars());
//				if(v==null) v = Util.getVariable(identifier, r.getSVars());
//				if(v==null) v = Util.getVariable(identifier, r.getSpVars());
//				break;
//			default:
//				break;
//			}
			
			if(v!=null) {
				result.addMapping(identifier, v);
			}
		}
		
	}
	
	public String deResolve(edu.ustb.sei.mde.xmu.Variable element, edu.ustb.sei.mde.xmu.VariableExp container, org.eclipse.emf.ecore.EReference reference) {
		return delegate.deResolve(element, container, reference);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		// save options in a field or leave method empty if this resolver does not depend
		// on any option
	}
	
}
