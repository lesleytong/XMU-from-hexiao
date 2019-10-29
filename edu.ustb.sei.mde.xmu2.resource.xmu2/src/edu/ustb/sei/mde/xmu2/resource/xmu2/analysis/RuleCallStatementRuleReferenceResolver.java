/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package edu.ustb.sei.mde.xmu2.resource.xmu2.analysis;

import edu.ustb.sei.mde.xmu2.resource.xmu2.analysis.util.ResolverUtil;
import edu.ustb.sei.mde.xmu2.AbstractRule;
import edu.ustb.sei.mde.xmu2.TransformationModel;
import edu.ustb.sei.mde.xmu2.Xmu2Package;

public class RuleCallStatementRuleReferenceResolver implements edu.ustb.sei.mde.xmu2.resource.xmu2.IXmu2ReferenceResolver<edu.ustb.sei.mde.xmu2.statement.RuleCallStatement, edu.ustb.sei.mde.xmu2.AbstractRule> {
	
	private edu.ustb.sei.mde.xmu2.resource.xmu2.analysis.Xmu2DefaultResolverDelegate<edu.ustb.sei.mde.xmu2.statement.RuleCallStatement, edu.ustb.sei.mde.xmu2.AbstractRule> delegate = new edu.ustb.sei.mde.xmu2.resource.xmu2.analysis.Xmu2DefaultResolverDelegate<edu.ustb.sei.mde.xmu2.statement.RuleCallStatement, edu.ustb.sei.mde.xmu2.AbstractRule>();
	
	public void resolve(String identifier, edu.ustb.sei.mde.xmu2.statement.RuleCallStatement container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, final edu.ustb.sei.mde.xmu2.resource.xmu2.IXmu2ReferenceResolveResult<edu.ustb.sei.mde.xmu2.AbstractRule> result) {
		TransformationModel model = (TransformationModel) ResolverUtil.getAncestor(container, Xmu2Package.eINSTANCE.getTransformationModel());
		if(model==null) return;
		if(resolveFuzzy) {
			for(AbstractRule r : model.getRules()) {
				if(ResolverUtil.identifierMatchFuzzy(identifier, r.getName())) {
					result.addMapping(ResolverUtil.keywordSafeString(r.getName()), r);
				}
			}
			return;
		} else {
			for(AbstractRule r : model.getRules()) {
				if(ResolverUtil.identifierMatch(identifier, r.getName())) {
					result.addMapping(identifier, r);
					return;
				}
			}
		}
	}
	
	public String deResolve(edu.ustb.sei.mde.xmu2.AbstractRule element, edu.ustb.sei.mde.xmu2.statement.RuleCallStatement container, org.eclipse.emf.ecore.EReference reference) {
		return ResolverUtil.keywordSafeString(element.getName());
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		// save options in a field or leave method empty if this resolver does not depend
		// on any option
	}
	
}
