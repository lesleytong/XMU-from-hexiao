package edu.ustb.sei.mde.morel.resource.morel.execution;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

import edu.ustb.sei.mde.emg.library.BooleanLibrary;
import edu.ustb.sei.mde.emg.runtime.Context;
import edu.ustb.sei.mde.emg.runtime.Environment;
import edu.ustb.sei.mde.emg.runtime.datatype.OclUndefined;
import edu.ustb.sei.mde.modeling.ui.ConsoleUtil;
import edu.ustb.sei.mde.morel.Action;
import edu.ustb.sei.mde.morel.ActionElementType;
import edu.ustb.sei.mde.morel.ActionObjectVariable;
import edu.ustb.sei.mde.morel.ActionSimpleLinkConstraint;
import edu.ustb.sei.mde.morel.BXRewritingRule;
import edu.ustb.sei.mde.morel.BxModelAttribute;
import edu.ustb.sei.mde.morel.BxMorelModel;
import edu.ustb.sei.mde.morel.BxMorelRule;
import edu.ustb.sei.mde.morel.BxTypedModel;
import edu.ustb.sei.mde.morel.CaseBlock;
import edu.ustb.sei.mde.morel.CaseStatement;
import edu.ustb.sei.mde.morel.Clause;
import edu.ustb.sei.mde.morel.Expression;
import edu.ustb.sei.mde.morel.LinkConstraint;
import edu.ustb.sei.mde.morel.ObjectVariable;
import edu.ustb.sei.mde.morel.Pattern;
import edu.ustb.sei.mde.morel.RelationalExp;
import edu.ustb.sei.mde.morel.RelationalOperator;
import edu.ustb.sei.mde.morel.Statement;
import edu.ustb.sei.mde.morel.Variable;
import edu.ustb.sei.mde.morel.VariableExp;
import edu.ustb.sei.mde.morel.resource.morel.execution.primitives.Apply;
import edu.ustb.sei.mde.morel.resource.morel.execution.primitives.Match;
import edu.ustb.sei.mde.morel.resource.morel.execution.primitives.Update;

public class BxMorelPutInterpreter extends OclInterpreter {
	
	
	public BxMorelPutInterpreter() {
	}
	
	private List<Context> contextRecord = new ArrayList<Context>();
	
	public void clearRecord() {
		contextRecord.clear();
	}
	
	public void addRecord(Context c) {
		contextRecord.add(c);
	}
	
	public boolean checkExists(Context c) {
		for(Context ec : contextRecord) {
			if(checkPartial(c,ec))
				return true;
		}
		return false;
	}
	
	protected boolean checkPartial(Context c, Context nc) {
		if(c.getHost()!=nc.getHost()) return false;
		
		Set<Variable> vs = c.getBindingMap().keySet();
		for(Variable v : vs) {
			Object v1 = c.getValue(v);
			Object v2 = nc.getValue(v);
			if(OclUndefined.isOclUndefined(v1)) continue;
			if(v1.equals(v2)==false) return false;
		}
		return true;
	}
	
	
	
	
	@Override
	public Object interprete(EObject object, Context context) {
		// TODO Auto-generated method stub
		if(object instanceof BxMorelRule)
			return this.putRule((BxMorelRule) object, context);
		else if(object instanceof BxMorelModel)
			return this.interprete_edu_ustb_sei_mde_morel_BxMorelModel((BxMorelModel)object, context);
		else if(object instanceof Action)
			return this.putAction((Action) object, context);
		else if(object instanceof CaseStatement)
			return this.putCaseStatement((CaseStatement)object,context);
		else if(object instanceof RelationalExp)
			return this.putRelationalExp((RelationalExp)object,context);
		return super.interprete(object, context);
	}

	private Object putRelationalExp(RelationalExp object, Context context) {
		if(object.getOperator()==RelationalOperator.EQUAL && object.getRight()!=null) {
			
			
			if(object.getLeft() instanceof VariableExp) {
				VariableExp le = (VariableExp)object.getLeft();
				Variable referredVariable = le.getReferredVariable();
				
				if(referredVariable instanceof ObjectVariable) {
					BxTypedModel model = (BxTypedModel)(((ObjectVariable) referredVariable).getModel());
					if(model.getAttribute()==BxModelAttribute.SOURCE) {
						return this.enforceEqual(le, object.getRight(), context);
					}
				}
			}
			
			if(object.getRight() instanceof VariableExp) {
				VariableExp re = (VariableExp)object.getRight();
				Variable referredVariable = re.getReferredVariable();
				
				if(referredVariable instanceof ObjectVariable) {
					BxTypedModel model = (BxTypedModel)(((ObjectVariable) referredVariable).getModel());
					if(model.getAttribute()==BxModelAttribute.SOURCE) {
						return this.enforceEqual(re, object.getLeft(), context);
					}
				}
			}
		}
		
		return super.interprete_edu_ustb_sei_mde_morel_RelationalExp(object, context);
	}
	
	public Object enforceEqual(VariableExp leftValue, Expression rightValue,
			Context context) {
		Object v = checkInterpreter.interprete(rightValue, context);
		if(OclUndefined.isOclInvalid(v)) return false;
		
		VariableExp exp = leftValue;
		if(exp.getPath()==null) {
			context.putValue(exp.getReferredVariable(), v);
			return true;
		} else {
			Object s = context.getValue(exp.getReferredVariable());
			try{
				return super.interprete_edu_ustb_sei_mde_morel_CallPathExp(s, exp.getPath(), context,true,v);
			} catch(Exception e) {
				return false;
			}
		}
	}

	private Object putCaseStatement(CaseStatement object, Context context) {
		Match match = Match.instance;
		
		for(CaseBlock ce : object.getBlocks()) {
			Context nc = context.getCopy();// deep copy maybe?
			nc = nc.newScope();
			nc.setHost(ce.getCondition());
			nc.initWithHost();
			Match.resetCache();
			List<Context> result = match.match(ce.getCondition(), nc, this, nc.getEnviroment(), true);
			if(result.isEmpty()) continue;
			return this.interprete(ce.getAction(),nc);
		}
		return false;
	}

	@Override
	public Object interprete_edu_ustb_sei_mde_morel_BxMorelRule(
			BxMorelRule bxMorelRule, Context context) {
		return this.putRule(bxMorelRule, context);
	}

	protected boolean putRule(BxMorelRule bxMorelRule, Context context) {
		Match match = Match.instance;
		context.setHost(bxMorelRule);
		context.initWithHost();
		
		if(putFullMatch(bxMorelRule,context,match)==false){
			System.out.println("fails A");
		}
		if(putSourceMatch(bxMorelRule,context,match)==false){
			System.out.println("fails B");
		}
		if(putViewMatch(bxMorelRule,context,match)==false){
			System.out.println("fails C");
		}
		
		return true;
	}
	
	private boolean checkAlign(Pattern nView, Clause when, Context c, Match match) {
		List<Context> list = match.match(nView, c, this, c.getEnviroment());
		for(Context nc : list) {
			if(checkClause(when,nc)) return true;
		}
		return false;
	}
	
	public void delete(Pattern lhs, EList<String> parameters, Context context,
			Environment env) {
		// TODO Auto-generated method stub
		List<Variable> variablesToBeDeleted = lhs.getVariables();
		for(Variable v : variablesToBeDeleted) {
			if(!(v instanceof ObjectVariable)) continue;
			if(parameters.contains(v.getName())) continue;
			if(context.getValue(v)!=OclUndefined.INVALIDED) {
				EObject obj = (EObject) context.getValue(v);
				System.out.println("delete "+v.getName()+" = "+obj);
				env.getModelSpaces().get(((ObjectVariable)v).getModel()).deleteElement(obj);
			}
		}
	}
	
	protected boolean putSourceMatch(BxMorelRule bxMorelRule, Context context, Match match) {
		List<Pattern> lhs = new ArrayList<Pattern>();
		lhs.add(bxMorelRule.getSource());
				
		Match.resetCache();
		List<Context> lhsMatches = match.match(lhs, context, checkInterpreter, context.getEnviroment());
		Match.resetCache();
		
//		int available = 0;
		
		for(Context c : lhsMatches) {
			if(this.checkExists(c)==false) {
				if(recheckMatch(lhs, c)==false) continue;//view will not change. No need to check it.
				if(checkAlign(bxMorelRule.getView(),bxMorelRule.getWhen(),c,match)) continue;
				if(bxMorelRule.getUnmatchView()==null) {
					if(bxMorelRule.getSource()!=null)
						this.delete(bxMorelRule.getSource(), bxMorelRule.getParameters(), c, c.getEnviroment());
				} else
					this.putAction(bxMorelRule.getUnmatchView(), c);
				
				this.addRecord(c);
			}
//			available++;

		}
		return true;
	}
	
	protected boolean putViewMatch(BxMorelRule bxMorelRule, Context context, Match match) {
		List<Pattern> lhs = new ArrayList<Pattern>();
		if(bxMorelRule.getView()==null) return true;
		
		lhs.add(bxMorelRule.getView());
				
		Match.resetCache();
		List<Context> lhsMatches = match.match(lhs, context, checkInterpreter, context.getEnviroment());
		Match.resetCache();
		
//		int available = 0;
		
		for(Context c : lhsMatches) {
			if(this.checkExists(c)==false) {
				if(recheckMatch(lhs, c)==false) continue;//view will not change. No need to check it.
				if(checkAlign(bxMorelRule.getSource(),bxMorelRule.getWhen(),c,match)) continue;
				//if(checkClause(when,c)==false) continue;
				//Update.instance.updateClauses(bxMorelRule.getSource(), c, this, update);
				if(bxMorelRule.getUnmatchSrc()==null) {
					// create source;
					if(bxMorelRule.getSource()!=null)
						Apply.instance.apply(Collections.singletonList(bxMorelRule.getSource()), Collections.<Pattern>emptyList(), c, this, c.getEnviroment());
				} else {
					this.putAction(bxMorelRule.getUnmatchSrc(), c);					
				}
				
				this.putClause(bxMorelRule.getWhen(),c);
//				this.putAction(bxMorelRule.getMatch(),c,delayedLinkConstraints,delayedStatements);
				this.putAction(bxMorelRule.getMatch(),c);
				
				//FIX ME above
				// apply source and when again if there are incomplete structure
				// we need an mechanism to record delayed statements
				
				this.addRecord(c);
			}
//			available++;

		}
		return true;
	}
	
	private boolean putClause(Clause when, Context c) {
		for(Statement stmt : when.getStatements()) {
			Object result = this.interprete(stmt, c);
			if(BooleanLibrary.isTrue(result)==false)
				return false;
		}
		return true;
	}

	protected boolean putFullMatch(BxMorelRule bxMorelRule, Context context, Match match) {
		List<Pattern> lhs = new ArrayList<Pattern>();
		lhs.add(bxMorelRule.getSource());
		lhs.add(bxMorelRule.getView());
		
		Clause when = bxMorelRule.getWhen();
		Action update = bxMorelRule.getMatch();
		
		Match.resetCache();
		List<Context> lhsMatches = match.match(lhs, context, checkInterpreter, context.getEnviroment());
		Match.resetCache();
		
//		int available = 0;
		
		for(Context c : lhsMatches) {
			if(this.checkExists(c)==false) {
				if(checkInterpreter.recheckMatch(lhs, c)==false) continue;//view will not change. No need to check it.
				
				if(checkClause(when,c)==false) continue;
				//Update.instance.updateClauses(bxMorelRule.getSource(), c, this, update);
				this.putAction(update, c);
				
				
				this.addRecord(c);
			}
//			available++;

		}
		return true;
	}
	
	protected boolean checkClause(Clause when, Context c) {
		if(when==null) return true;
		for(Statement statement : when.getStatements()){
			Object v = checkInterpreter.interprete(statement, c);
			if(!BooleanLibrary.isTrue(v)) return false;
		}
		return true;
	}

	@Override
	public Object interprete_edu_ustb_sei_mde_morel_Action(Action action,
			Context context) {
		// TODO Auto-generated method stub
		return putAction(action, context);
	}
	
	// Action is defined for source, so it wouldn't change view
	// we don't do match when put action
	// there should not be new variable (kept) in this part
	protected boolean putAction(Action action, Context c) {
		Context nc = c.newScope();
		nc.setHost(action);
		nc.initWithHost();
		
		for(Variable var :action.getVariables()) {
			if(var instanceof ActionObjectVariable) {
				switch(((ActionObjectVariable) var).getActionType().getValue()) {					
				case ActionElementType.CREATE_VALUE:
					Update.instance.createElement((ActionObjectVariable)var, nc, nc.getEnviroment());
					break;
				case ActionElementType.DELETE_VALUE:
					Update.instance.deleteElement((ActionObjectVariable)var, nc, nc.getEnviroment());
					break;
				case ActionElementType.KEEP_VALUE:
				default:
					break;
				}
			}
		}
		
		for(LinkConstraint link :action.getLinkConstraints()) {
			if(link instanceof ActionSimpleLinkConstraint) {
				switch(((ActionSimpleLinkConstraint) link).getActionType().getValue()) {					
				case ActionElementType.CREATE_VALUE:
					Update.instance.createRelationship((ActionSimpleLinkConstraint)link, nc, nc.getEnviroment(),this);
					break;
				case ActionElementType.DELETE_VALUE:
					Update.instance.deleteRelationship((ActionSimpleLinkConstraint)link, nc, nc.getEnviroment());
					break;
				case ActionElementType.KEEP_VALUE:
				default:
					break;
				}
			}
		}
		
		for(Statement s : action.getStatements()) {
			Object ret = this.interprete(s, c);
			if(BooleanLibrary.isTrue(ret)==false) 
				return false;
		}
		
		return true;
	}

	@Override
	public Object interprete_edu_ustb_sei_mde_morel_BxMorelModel(
			BxMorelModel bxMorelModel, Context context) {
		try {
			Context init = context.newScope();
			Environment env = context.getEnviroment();
			
			//do{
				ConsoleUtil.printToConsole("next iteration", MorelLaunchConfigurationHelper.MOREL_TITLE, true);
				env.getModelUniverse().resetChanged();
				
				for(BxMorelRule rule : bxMorelModel.getRules()) {
					if(terminated) return true;
					if(rule.isActive()==false) continue;
					
					if(rule instanceof BxMorelRule) {
						this.interprete_edu_ustb_sei_mde_morel_BxMorelRule(rule, init);
					}
//					else if(rule instanceof RuleGroup) {
//						this.interprete_edu_ustb_sei_mde_morel_RuleGroup((RuleGroup)rule, init);
//					}
				}
			//}
			//while(terminated==false&&env.getModelUniverse().isChanged());
			
			ConsoleUtil.printToConsole("Transformation is finished.", MorelLaunchConfigurationHelper.MOREL_TITLE, true);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return true;
	}
	 
	
	
}
