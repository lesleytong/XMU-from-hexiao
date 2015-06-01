package edu.ustb.sei.mde.xmu.postprocessor;

import java.util.Collections;
import java.util.Map;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;

import edu.ustb.sei.mde.xmu.resource.xmu.*;
import edu.ustb.sei.mde.xmu.resource.xmu.analysis.Util;
import edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuResource;
import edu.ustb.sei.mde.xmu.*;

public class ModelCleaner implements IXmuOptionProvider, 
	IXmuResourcePostProcessorProvider, 
	IXmuResourcePostProcessor {

	@Override
	public void process(XmuResource resource) {
		// TODO Auto-generated method stub
		flag = true;
		XMUModel model = (XMUModel)resource.getContents().get(0);
		resource.getErrors().clear();
		
		for(Rule rule : model.getRules()) {
			if(flag==false) return;
			try{
				Util.cleanVariable(rule);
			} catch(Exception e) {}
			try {
				check(rule,resource);
				checkUndefinedPrimitiveVariable(rule,resource);
			} catch(Exception e){}
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
	
	
	private void check(Rule rule,XmuResource resource) {
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
							if(((CasePatternStatement) s).getPattern().getRoot().getVariable()!=((SwitchStatement)s).getVar())
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
			}
		}
	}
	
	private boolean flag;
	@Override
	public void terminate() {
		// TODO Auto-generated method stub
		flag = false;
	}

	@Override
	public IXmuResourcePostProcessor getResourcePostProcessor() {
		return this;
	}

	@Override
	public Map<?, ?> getOptions() {
		return Collections.singletonMap( 
			      IXmuOptions.RESOURCE_POSTPROCESSOR_PROVIDER, 
			      this);
	}

}
