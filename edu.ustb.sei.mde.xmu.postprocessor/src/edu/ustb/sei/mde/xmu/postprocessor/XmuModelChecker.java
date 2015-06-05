package edu.ustb.sei.mde.xmu.postprocessor;

import java.util.Map;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;

import edu.ustb.sei.mde.xmu.CasePatternStatement;
import edu.ustb.sei.mde.xmu.CaseSubStatement;
import edu.ustb.sei.mde.xmu.ForStatement;
import edu.ustb.sei.mde.xmu.Parameter;
import edu.ustb.sei.mde.xmu.PrimitiveVariable;
import edu.ustb.sei.mde.xmu.Rule;
import edu.ustb.sei.mde.xmu.RuleCallStatement;
import edu.ustb.sei.mde.xmu.SwitchStatement;
import edu.ustb.sei.mde.xmu.UpdatedStatement;
import edu.ustb.sei.mde.xmu.Variable;
import edu.ustb.sei.mde.xmu.VariableExp;
import edu.ustb.sei.mde.xmu.VariableFlag;
import edu.ustb.sei.mde.xmu.XMUModel;
import edu.ustb.sei.mde.xmu.resource.xmu.IXmuOptionProvider;
import edu.ustb.sei.mde.xmu.resource.xmu.IXmuResourcePostProcessor;
import edu.ustb.sei.mde.xmu.resource.xmu.IXmuResourcePostProcessorProvider;
import edu.ustb.sei.mde.xmu.resource.xmu.XmuEProblemType;
import edu.ustb.sei.mde.xmu.resource.xmu.analysis.Util;
import edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuResource;

public class XmuModelChecker extends AbstractXmuPostProcesser {

	@Override
	public void process(XmuResource resource) {
			setFlag(true);
			XMUModel model = (XMUModel)resource.getContents().get(0);
			resource.getErrors().clear();
			
			for(Rule rule : model.getRules()) {
				if(isFlag()==false) return;
				try {
					checkContent(rule,resource);
					checkUndefinedPrimitiveVariable(rule,resource);
				} catch(Exception e){
					e.printStackTrace();
				}
			}
			
	}

	private void checkUndefinedPrimitiveVariable(Rule rule,XmuResource resource) {
		for(Parameter param : rule.getParameters()) {
			if(param.getTag()==VariableFlag.NORMAL) {
				PrimitiveVariable pv = (PrimitiveVariable) param.getVariable();
				if(pv.getType()==null) {
					resource.addWarning("missing declaration", XmuEProblemType.ANALYSIS_PROBLEM, param);
				}
			}
		}
	}
	
	
	private void checkContent(Rule rule,XmuResource resource) {
		TreeIterator<EObject> it = rule.eAllContents();
		while(it.hasNext()) {
			EObject o = it.next();
			
			if(o instanceof RuleCallStatement) {
				if(((RuleCallStatement) o).getActualParameters().size()!=((RuleCallStatement)o).getRule().getParameters().size())
					resource.addError("The number of parameters is inconsistent with declaration", XmuEProblemType.ANALYSIS_PROBLEM,o);
			} else if(o instanceof SwitchStatement) {
				if(((SwitchStatement) o).getTag()==VariableFlag.SOURCE ||
						((SwitchStatement) o).getTag()==VariableFlag.VIEW ||
						((SwitchStatement) o).getTag()==VariableFlag.SOURCE_POST ) {
					for(CaseSubStatement s : ((SwitchStatement) o).getCases()) {
						if(s instanceof CasePatternStatement) {
							if(((CasePatternStatement) s).getPattern().getRoot().getVariable()!=((SwitchStatement)o).getVar())
								resource.addError("Case condition must start from the focused variable", XmuEProblemType.ANALYSIS_PROBLEM,s);
						} else {
							resource.addError("Case condition must be a pattern", XmuEProblemType.ANALYSIS_PROBLEM,s);
						}
					}
				} else {
					for(CaseSubStatement s : ((SwitchStatement) o).getCases()) {
						if(s instanceof CasePatternStatement) {
							resource.addError("Case condition must be an expression", XmuEProblemType.ANALYSIS_PROBLEM,s);
						}
					}
				}
			} else if(o instanceof UpdatedStatement) {
				for(Variable v : ((UpdatedStatement) o).getSVar()) {
					if(v instanceof PrimitiveVariable) {
						// v is a parameter
						// v is used in both source pattern and view pattern in a forstatement
						// v is used in a case statement
						
						if(isPrimitiveVariableNullable((PrimitiveVariable)v,o)) {
							resource.addWarning("Variable "+v.getName()+" may be null", XmuEProblemType.ANALYSIS_PROBLEM, o);
						}
					}
				}
			}
		}
	}
	
	private boolean isPrimitiveVariableNullable(PrimitiveVariable v,EObject o) {
		if(o==null) return true;
		else {
			if(o instanceof Rule) {
				for(Parameter p : ((Rule) o).getParameters()) {
					if(p.getVariable()==v) return false;
				}
			} else if(o instanceof ForStatement) {
				TreeIterator<EObject> it = null;
				boolean inSrc = false,inTar = false;
				
				it = ((ForStatement) o).getSPattern().eAllContents();
				while(it.hasNext()) {
					EObject co = it.next();
					if(co instanceof VariableExp) {
						if(((VariableExp) co).getVar()==v)  {
							inSrc = true; 
							break;
						}
					}
				}
				
				it = ((ForStatement) o).getVPattern().eAllContents();
				while(it.hasNext()) {
					EObject co = it.next();
					if(co instanceof VariableExp) {
						if(((VariableExp) co).getVar()==v)  {
							inTar = true; 
							break;
						}
					}
				}
				
				if(inSrc&&inTar) return false;
				
			} else if(o instanceof CasePatternStatement) {
				TreeIterator<EObject> it = ((CasePatternStatement) o).getPattern().eAllContents();
				while(it.hasNext()) {
					EObject co = it.next();
					if(co instanceof VariableExp) {
						if(((VariableExp) co).getVar()==v) return false;
					}
				}
			}
			return isPrimitiveVariableNullable(v, o.eContainer());
		}
	}
}
