/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package edu.ustb.sei.mde.xmu2.resource.xmu2.analysis;

import edu.ustb.sei.mde.xmu2.AbstractRule;
import edu.ustb.sei.mde.xmu2.ModelRule;
import edu.ustb.sei.mde.xmu2.TransformationModel;
import edu.ustb.sei.mde.xmu2.Xmu2Package;
import edu.ustb.sei.mde.xmu2.resource.xmu2.analysis.util.ResolverUtil;

public class EntryPointRuleReferenceResolver implements edu.ustb.sei.mde.xmu2.resource.xmu2.IXmu2ReferenceResolver<edu.ustb.sei.mde.xmu2.EntryPoint, edu.ustb.sei.mde.xmu2.ModelRule> {
	
	private edu.ustb.sei.mde.xmu2.resource.xmu2.analysis.Xmu2DefaultResolverDelegate<edu.ustb.sei.mde.xmu2.EntryPoint, edu.ustb.sei.mde.xmu2.ModelRule> delegate = new edu.ustb.sei.mde.xmu2.resource.xmu2.analysis.Xmu2DefaultResolverDelegate<edu.ustb.sei.mde.xmu2.EntryPoint, edu.ustb.sei.mde.xmu2.ModelRule>();
	
	public void resolve(String identifier, edu.ustb.sei.mde.xmu2.EntryPoint container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, final edu.ustb.sei.mde.xmu2.resource.xmu2.IXmu2ReferenceResolveResult<edu.ustb.sei.mde.xmu2.ModelRule> result) {
		TransformationModel model = (TransformationModel) ResolverUtil.getAncestor(container, Xmu2Package.eINSTANCE.getTransformationModel());
		if(model==null) return;
		if(resolveFuzzy) {
			for(AbstractRule r : model.getRules()) {
				if(r instanceof ModelRule && ResolverUtil.identifierMatchFuzzy(identifier, r.getName())) {
					result.addMapping(ResolverUtil.keywordSafeString(r.getName()), (ModelRule)r);
				}
			}
			return;
		} else {
			for(AbstractRule r : model.getRules()) {
				if(r instanceof ModelRule && ResolverUtil.identifierMatch(identifier, r.getName())) {
					result.addMapping(identifier, (ModelRule)r);
					return;
				}
			}
		}
	}
	
	public String deResolve(edu.ustb.sei.mde.xmu2.ModelRule element, edu.ustb.sei.mde.xmu2.EntryPoint container, org.eclipse.emf.ecore.EReference reference) {
		return element.getName();
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		// save options in a field or leave method empty if this resolver does not depend
		// on any option
	}
	
}
