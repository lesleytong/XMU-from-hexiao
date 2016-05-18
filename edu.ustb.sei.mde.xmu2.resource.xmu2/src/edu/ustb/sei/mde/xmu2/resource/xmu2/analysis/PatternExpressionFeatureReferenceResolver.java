/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package edu.ustb.sei.mde.xmu2.resource.xmu2.analysis;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;

import edu.ustb.sei.mde.xmu2.resource.xmu2.analysis.util.ResolverUtil;
import edu.ustb.sei.mde.xmu2.util.Constants;
import edu.ustb.sei.mde.xmu2.VariableDeclaration;
import edu.ustb.sei.mde.xmu2.pattern.PatternNode;

public class PatternExpressionFeatureReferenceResolver implements edu.ustb.sei.mde.xmu2.resource.xmu2.IXmu2ReferenceResolver<edu.ustb.sei.mde.xmu2.pattern.PatternExpression, org.eclipse.emf.ecore.EStructuralFeature> {
	
	private edu.ustb.sei.mde.xmu2.resource.xmu2.analysis.Xmu2DefaultResolverDelegate<edu.ustb.sei.mde.xmu2.pattern.PatternExpression, org.eclipse.emf.ecore.EStructuralFeature> delegate = new edu.ustb.sei.mde.xmu2.resource.xmu2.analysis.Xmu2DefaultResolverDelegate<edu.ustb.sei.mde.xmu2.pattern.PatternExpression, org.eclipse.emf.ecore.EStructuralFeature>();
	
	public void resolve(String identifier, edu.ustb.sei.mde.xmu2.pattern.PatternExpression container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, final edu.ustb.sei.mde.xmu2.resource.xmu2.IXmu2ReferenceResolveResult<org.eclipse.emf.ecore.EStructuralFeature> result) {
		if(container==null) return;
		PatternNode node = container.getOwnerNode();
		if(node==null) return;
		VariableDeclaration v = node.getVariable();
		if(v==null) return;
		
		if(v.getType() instanceof EClass) {
			if(resolveFuzzy) {
				for(EStructuralFeature f : Constants.REFLECTIVE_OBJECT.getEAllStructuralFeatures()) {
					if(ResolverUtil.identifierMatchFuzzy(identifier, f.getName())) {
						result.addMapping(ResolverUtil.keywordSafeString(f.getName()), f);
					}
				}
				
				EClass type = (EClass) v.getType();
				for(EStructuralFeature f : type.getEAllStructuralFeatures()) {
					if(ResolverUtil.identifierMatchFuzzy(identifier, f.getName())) {
						result.addMapping(ResolverUtil.keywordSafeString(f.getName()), f);
					}
				}
				return;
			} else {
				EClass type = (EClass) v.getType();
				EStructuralFeature f = ResolverUtil.getFeature(identifier, type);
				if(f!=null)
					result.addMapping(identifier, f);
			}
		}
		
//		delegate.resolve(identifier, container, reference, position, resolveFuzzy, result);
	}
	
	public String deResolve(org.eclipse.emf.ecore.EStructuralFeature element, edu.ustb.sei.mde.xmu2.pattern.PatternExpression container, org.eclipse.emf.ecore.EReference reference) {
		return ResolverUtil.keywordSafeString(element.getName());
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		// save options in a field or leave method empty if this resolver does not depend
		// on any option
	}
	
}
