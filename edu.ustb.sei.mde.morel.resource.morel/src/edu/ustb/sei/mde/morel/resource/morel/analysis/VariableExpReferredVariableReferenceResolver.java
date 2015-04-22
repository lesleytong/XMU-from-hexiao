/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package edu.ustb.sei.mde.morel.resource.morel.analysis;

import java.util.List;

import org.eclipse.emf.common.util.UniqueEList;
import org.eclipse.emf.ecore.EObject;

//
//import edu.ustb.sei.mde.morel.Action;
//import edu.ustb.sei.mde.morel.BXRewritingRule;
//import edu.ustb.sei.mde.morel.BxMorelRule;
//import edu.ustb.sei.mde.morel.CaseBlock;
//import edu.ustb.sei.mde.morel.CaseStatement;
import edu.ustb.sei.mde.morel.Clause;
import edu.ustb.sei.mde.morel.Executable;
import edu.ustb.sei.mde.morel.ForStatement;
import edu.ustb.sei.mde.morel.IteratorPathExp;
import edu.ustb.sei.mde.morel.LetExp;
import edu.ustb.sei.mde.morel.Pattern;
import edu.ustb.sei.mde.morel.Unit;
import edu.ustb.sei.mde.morel.Variable;
import edu.ustb.sei.mde.morel.VariableExp;
import edu.ustb.sei.mde.morel.VariableWithInit;

public class VariableExpReferredVariableReferenceResolver implements edu.ustb.sei.mde.morel.resource.morel.IMorelReferenceResolver<edu.ustb.sei.mde.morel.VariableExp, edu.ustb.sei.mde.morel.Variable> {
	
	private edu.ustb.sei.mde.morel.resource.morel.analysis.MorelDefaultResolverDelegate<edu.ustb.sei.mde.morel.VariableExp, edu.ustb.sei.mde.morel.Variable> delegate = new edu.ustb.sei.mde.morel.resource.morel.analysis.MorelDefaultResolverDelegate<edu.ustb.sei.mde.morel.VariableExp, edu.ustb.sei.mde.morel.Variable>();
	
	public void resolve(String identifier, edu.ustb.sei.mde.morel.VariableExp container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, final edu.ustb.sei.mde.morel.resource.morel.IMorelReferenceResolveResult<edu.ustb.sei.mde.morel.Variable> result) {
		List<Variable> list = collectVariables(container);
		for(Variable v : list) {
			if(v.getName()==null) continue;
			if(v.getName().equals(identifier)) {
				result.addMapping(identifier, v);
				return;
			}
		}
		//delegate.resolve(identifier, container, reference, position, resolveFuzzy, result);
	}
	
	public List<Variable> collectVariables(VariableExp varExp) {
		UniqueEList<Variable> vars = new UniqueEList<Variable>();
		collectVariables(varExp,vars);
		return vars;
	}
	
	public void collectVariables(EObject current, List<Variable> vars) {
		if(current==null) return;
		
		if(current instanceof IteratorPathExp) {
			if(((IteratorPathExp) current).getFirstVar()!=null)
				vars.add(((IteratorPathExp) current).getFirstVar());
			if(((IteratorPathExp) current).getSecondVar()!=null)
				vars.add(((IteratorPathExp) current).getSecondVar());
		}
		
		//for let
		if(current instanceof LetExp) {
			vars.addAll(((LetExp) current).getVariables());
		}
		
//		if(current instanceof CaseBlock) {
//			vars.addAll(((CaseBlock) current).getCondition().getVariables());
//		}
		
		if(current instanceof Pattern) {
			vars.addAll(((Pattern) current).getVariables());
		}
		
		if(current instanceof Executable) {
			vars.addAll(((Executable) current).getPrimitiveVariables());
		}
		
//		if(current instanceof Action) {
//			EObject u = current.eContainer();
//			if(u instanceof BxMorelRule) {
//				BxMorelRule bxr = (BxMorelRule)u;
//				if(bxr.getSource()!=null)
//					vars.addAll(bxr.getSource().getVariables());
//				if(bxr.getView()!=null)
//					vars.addAll(bxr.getView().getVariables());
//			}
//		}
		
//		if(current instanceof Clause) {
//			EObject u = current.eContainer();
//			if(u instanceof BXRewritingRule) {
//				BXRewritingRule bxr = (BXRewritingRule)u;
//				
//				vars.addAll(bxr.getSource().getVariables());
//				vars.addAll(bxr.getView().getVariables());
//			}
//			else if(u instanceof BxMorelRule) {
//				BxMorelRule bxr = (BxMorelRule)u;
//				
//				if(bxr.getSource()!=null)
//					vars.addAll(bxr.getSource().getVariables());
//				
//				if(bxr.getView()!=null)
//					vars.addAll(bxr.getView().getVariables());
//			}
//		}
//		
		
		
		if(current instanceof ForStatement) {
			vars.add(((ForStatement)current).getIterator());
		}
		
		//for rule
		
		collectVariables(current.eContainer(),vars);
	}
	
	public String deResolve(edu.ustb.sei.mde.morel.Variable element, edu.ustb.sei.mde.morel.VariableExp container, org.eclipse.emf.ecore.EReference reference) {
		//return delegate.deResolve(element, container, reference);
		return element.getName();
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		// save options in a field or leave method empty if this resolver does not depend
		// on any option
	}
	
}
