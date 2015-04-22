/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package edu.ustb.sei.mde.xmu.resource.xmu.analysis;

import edu.ustb.sei.mde.xmu.ObjectVariable;
import edu.ustb.sei.mde.xmu.Pattern;
import edu.ustb.sei.mde.xmu.PatternNode;
import edu.ustb.sei.mde.xmu.PrimitiveVariable;
import edu.ustb.sei.mde.xmu.Rule;
import edu.ustb.sei.mde.xmu.Statement;
import edu.ustb.sei.mde.xmu.SwitchStatement;
import edu.ustb.sei.mde.xmu.UpdatePattern;
import edu.ustb.sei.mde.xmu.Variable;
import edu.ustb.sei.mde.xmu.VariableFlag;
import edu.ustb.sei.mde.xmu.XmuFactory;
import edu.ustb.sei.mde.xmu.XmuPackage;

public class PatternNodeVariableReferenceResolver implements edu.ustb.sei.mde.xmu.resource.xmu.IXmuReferenceResolver<edu.ustb.sei.mde.xmu.PatternNode, edu.ustb.sei.mde.xmu.Variable> {
	
	private edu.ustb.sei.mde.xmu.resource.xmu.analysis.XmuDefaultResolverDelegate<edu.ustb.sei.mde.xmu.PatternNode, edu.ustb.sei.mde.xmu.Variable> delegate = new edu.ustb.sei.mde.xmu.resource.xmu.analysis.XmuDefaultResolverDelegate<edu.ustb.sei.mde.xmu.PatternNode, edu.ustb.sei.mde.xmu.Variable>();
	
	public void resolve(String identifier, edu.ustb.sei.mde.xmu.PatternNode container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, final edu.ustb.sei.mde.xmu.resource.xmu.IXmuReferenceResolveResult<edu.ustb.sei.mde.xmu.Variable> result) {
		if(identifier==null || container==null) return;
		Rule rule = Util.getRule(container);
		if(rule==null) return;
		
		//Util.cleanVariable(rule);
		
		Pattern pat = Util.getPattern(container);
		if(pat==null) return;
		
		if(pat instanceof UpdatePattern) {
			handleUpdatePattern(identifier, pat, rule, result);
		} else {
			handleNormalPattern(identifier, container, pat, rule, result);
		}
		
	}

	private void handleUpdatePattern(
			String identifier,
			Pattern pat, Rule rule,
			final edu.ustb.sei.mde.xmu.resource.xmu.IXmuReferenceResolveResult<edu.ustb.sei.mde.xmu.Variable> result) {
		pat.setTag(VariableFlag.SOURCE_POST);
		Variable v;
		v = Util.getVariable(identifier, rule.getSpVars());
		if(v==null) {
			if(identifier.endsWith(Util.POST_FLAG)) {
				v = XmuFactory.eINSTANCE.createObjectVariable();
				v.setName(identifier);
				rule.getSpVars().add((ObjectVariable)v);
				
				ObjectVariable sv = XmuFactory.eINSTANCE.createObjectVariable();
				sv.setName(identifier.substring(0,identifier.length()-Util.POST_LENGTH));
				rule.getSVars().add(sv);				
			} else {
				identifier = identifier.concat(Util.POST_FLAG);
				handleUpdatePattern(identifier,pat,rule,result);
				return;
			}
			
		}
		result.addMapping(identifier, v);
	}

	private void handleNormalPattern(
			String identifier,
			edu.ustb.sei.mde.xmu.PatternNode container,
			Pattern pat,
			Rule rule, final edu.ustb.sei.mde.xmu.resource.xmu.IXmuReferenceResolveResult<edu.ustb.sei.mde.xmu.Variable> result) {
		Variable v;
		if(pat.getRoot()==container) {//第一个节点
			if(pat.eContainmentFeature()==XmuPackage.eINSTANCE.getForStatement_SPattern()) {//update s for v
				v = Util.getVariable(identifier, rule.getSVars());
				if(v!=null) {
					pat.setTag(VariableFlag.SOURCE);
					result.addMapping(identifier, v);
					return;
				} else {
					if(identifier.endsWith(Util.POST_FLAG) || checkNameConflict(identifier,rule)) return;
					
					v = XmuFactory.eINSTANCE.createObjectVariable();
					v.setName(identifier);
					pat.setTag(VariableFlag.SOURCE);
					result.addMapping(identifier, v);
					rule.getSVars().add((ObjectVariable) v);
					
					v = XmuFactory.eINSTANCE.createObjectVariable();
					v.setName(identifier+Util.POST_FLAG);
					rule.getSpVars().add((ObjectVariable)v);
					System.out.println(rule.getSpVars());
					return;
				}
			} else if(pat.eContainingFeature()==XmuPackage.eINSTANCE.getForStatement_VPattern()) {
				v = Util.getVariable(identifier, rule.getVVars());
				if(v!=null) {
					pat.setTag(VariableFlag.VIEW);
					result.addMapping(identifier, v);
					return;
				} else {
					if(identifier.endsWith(Util.POST_FLAG) || checkNameConflict(identifier,rule)) return;
					
					v = XmuFactory.eINSTANCE.createObjectVariable();
					v.setName(identifier);
					pat.setTag(VariableFlag.VIEW);
					result.addMapping(identifier, v);
					rule.getVVars().add((ObjectVariable) v);
					return;
				}
			} else if(pat.eContainingFeature()==XmuPackage.eINSTANCE.getCasePatternStatement_Pattern()) {// switch case
				SwitchStatement ss = (SwitchStatement)pat.eContainer().eContainer();
				
				if(ss.getTag()==VariableFlag.SOURCE) {
					v = Util.getVariable(identifier, rule.getSVars());
					if(v!=null) {
						pat.setTag(VariableFlag.SOURCE);
						result.addMapping(identifier, v);
						return;
					}
				}
				else if(ss.getTag()==VariableFlag.VIEW) {
					v = Util.getVariable(identifier, rule.getVVars());
					if(v!=null) {
						pat.setTag(VariableFlag.VIEW);
						result.addMapping(identifier, v);
						return;
					}
				}
				else if(ss.getTag()==VariableFlag.SOURCE_POST) {
					v = Util.getVariable(identifier, rule.getSpVars());
					if(v!=null) {
						pat.setTag(VariableFlag.SOURCE_POST);
						result.addMapping(identifier, v);
						return;
					}
				}
			}
		} else {//后面的节点
			switch(pat.getTag()) {
			case SOURCE:
				v = Util.getVariable(identifier, rule.getSVars());
				if(v!=null){
					result.addMapping(identifier, v);
					return;
				} else {
					if(identifier.endsWith(Util.POST_FLAG) || checkNameConflict(identifier,rule)) return;
					
					v = XmuFactory.eINSTANCE.createObjectVariable();
					v.setName(identifier);;
					rule.getSVars().add((ObjectVariable) v);
					result.addMapping(identifier, v);
					
					v = XmuFactory.eINSTANCE.createObjectVariable();
					v.setName(identifier+Util.POST_FLAG);
					rule.getSpVars().add((ObjectVariable)v);
					return;
				}
			case VIEW:
				v = Util.getVariable(identifier, rule.getVVars());
				if(v!=null) {
					result.addMapping(identifier, v);
					return;
				} else {
					if(identifier.endsWith(Util.POST_FLAG) || checkNameConflict(identifier,rule)) return;
					
					v = XmuFactory.eINSTANCE.createObjectVariable();
					v.setName(identifier);;
					rule.getVVars().add((ObjectVariable) v);
					result.addMapping(identifier, v);
					return;
				}
			case SOURCE_POST:
				v = Util.getVariable(identifier, rule.getSpVars());
				if(v!=null) {
					result.addMapping(identifier, v);
					return;
				}
			default:
				break;
			}
			return;
		}
	}
	
	public boolean checkNameConflict(String identifier, Rule rule) {
		for(Variable v : rule.getNVars()) {
			if(identifier.equals(v.getName())) return true;
		}
		for(Variable v : rule.getSVars()) {
			if(identifier.equals(v.getName())) return true;
		}
		for(Variable v : rule.getVVars()) {
			if(identifier.equals(v.getName())) return true;
		}
		for(Variable v : rule.getSpVars()) {
			if(identifier.equals(v.getName())) return true;
		}
		return false;
	}
	
	public boolean checkSource(Variable v, PatternNode root) {
		if(root==null) return false;
		if(root.getVariable()==null) return false;
		if(root.getVariable().eContainmentFeature()==v.eContainmentFeature()) return true;
		return false;
	}
	
	public String deResolve(edu.ustb.sei.mde.xmu.Variable element, edu.ustb.sei.mde.xmu.PatternNode container, org.eclipse.emf.ecore.EReference reference) {
		return delegate.deResolve(element, container, reference);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		// save options in a field or leave method empty if this resolver does not depend
		// on any option
	}
	
}
