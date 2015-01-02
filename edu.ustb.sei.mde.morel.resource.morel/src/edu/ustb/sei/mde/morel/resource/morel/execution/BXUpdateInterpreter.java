package edu.ustb.sei.mde.morel.resource.morel.execution;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;

import edu.ustb.sei.mde.emg.library.BooleanLibrary;
import edu.ustb.sei.mde.emg.runtime.Context;
import edu.ustb.sei.mde.emg.runtime.Environment;
import edu.ustb.sei.mde.emg.runtime.datatype.OclUndefined;
import edu.ustb.sei.mde.modeling.ui.ConsoleUtil;
import edu.ustb.sei.mde.morel.BXMode;
import edu.ustb.sei.mde.morel.BXRewritingModel;
import edu.ustb.sei.mde.morel.BXRewritingRule;
import edu.ustb.sei.mde.morel.BindExp;
import edu.ustb.sei.mde.morel.Clause;
import edu.ustb.sei.mde.morel.DeclarativeStatement;
import edu.ustb.sei.mde.morel.Expression;
import edu.ustb.sei.mde.morel.ImperativeStatement;
import edu.ustb.sei.mde.morel.Pattern;
import edu.ustb.sei.mde.morel.RelationalExp;
import edu.ustb.sei.mde.morel.RelationalOperator;
import edu.ustb.sei.mde.morel.Rule;
import edu.ustb.sei.mde.morel.RuleElement;
import edu.ustb.sei.mde.morel.RuleGroup;
import edu.ustb.sei.mde.morel.Statement;
import edu.ustb.sei.mde.morel.Variable;
import edu.ustb.sei.mde.morel.VariableExp;
import edu.ustb.sei.mde.morel.resource.morel.execution.primitives.Match;
import edu.ustb.sei.mde.morel.resource.morel.execution.primitives.Update;

public class BXUpdateInterpreter extends OclInterpreter {

	public BXUpdateInterpreter() {
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
	
	public BXRewritingModel getRoot(RuleElement e) {
		EObject c = e;
		
		while(c!=null) {
			if(c instanceof BXRewritingModel) return (BXRewritingModel) c;
			c = c.eContainer();
		}
		
		return null;
	}

	@Override
	public Object interprete_edu_ustb_sei_mde_morel_BXRewritingRule(
			BXRewritingRule bXRewritingRule, Context context) {
		BXRewritingModel m = getRoot(bXRewritingRule);
		switch(m.getMode()){
		case GET:
			return getRule(bXRewritingRule,context);
		case PUT:
			return putRule(bXRewritingRule, context);
		default:
			return OclUndefined.INVALIDED;
		}
	}
	
	protected Object getRule(BXRewritingRule bXRewritingRule, Context context) {
		try {
			Match match = Match.instance;
			context.setHost(bXRewritingRule);
			context.initWithHost();
			
//			List<Pattern> lhs = new ArrayList<Pattern>();
//			lhs.add(bXRewritingRule.getSource());
//			List<Pattern> rhs = new ArrayList<Pattern>();
//			rhs.add(bXRewritingRule.getSource());
//			rhs.add(bXRewritingRule.getView());
			Pattern lhs = bXRewritingRule.getSource();
			Pattern rhs = bXRewritingRule.getView();
			Clause when = bXRewritingRule.getWhen();
			Clause update = bXRewritingRule.getUpdate();
			
			List<Context> lhsMatches = match.match(lhs, context, this, context.getEnviroment());
			List<Pattern> lhsST = Collections.singletonList(lhs);
			
			for(Context c : lhsMatches) {
				if(this.checkExists(c)) continue;
				if(recheckMatch(lhsST, c)==false) continue;
				Update.instance.create(rhs, bXRewritingRule.getParameters(), c, c.getEnviroment(), this);
				Update.instance.updateClauses(rhs, c, this, when,update);
				this.addRecord(c);
			}
			
			
		} catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	protected Object putRule(BXRewritingRule bXRewritingRule, Context context) {
		try {
			Match match = Match.instance;
			context.setHost(bXRewritingRule);
			context.initWithHost();
			
			// check match
			putMatch(bXRewritingRule,context,match);
			
			// check unmatched source
			putUnmatchedSource(bXRewritingRule,context,match);
			
			// check unmatched view
			putUnmatchedView(bXRewritingRule,context,match);
		} catch(Exception e) {
			return false;
		}
		return true;
	}

	private void putUnmatchedView(BXRewritingRule bXRewritingRule,
			Context context, Match match) {
		// TODO Auto-generated method stub
		Pattern lhs = bXRewritingRule.getView();
		Pattern nView = bXRewritingRule.getSource();

		Clause when = bXRewritingRule.getWhen();
		//Clause update = bXRewritingRule.getUpdate();

		//List<Pattern> nac = bXRewritingRule.getNac();
		
		Pattern rhs = bXRewritingRule.getUnmatchView();
		
		Match.resetCache();
		
		List<Context> lhsMatches = match.match(lhs, context, this, context.getEnviroment());
		
		//List<Context> successfulContexts = new ArrayList<Context>();
		
		List<Pattern> lhsST = Collections.singletonList(lhs);
		
		for(Context c : lhsMatches) {
			if(this.checkExists(c)) continue;
			if(recheckMatch(lhsST, c)==false) continue;
			if(checkAlign(nView,when,c,match)==false) {
				// update rhs
				if(rhs==null){
					Update.instance.create(lhs,bXRewritingRule.getParameters(),c,c.getEnviroment(),this);
				} else {
					Update.instance.create(rhs,bXRewritingRule.getParameters(),c,c.getEnviroment(),this);
				}
				
				// enforce when and update
				Update.instance.updateClauses(bXRewritingRule.getSource(), c, this, when);
				this.addRecord(c);
			}
		}
	}

	private void putUnmatchedSource(BXRewritingRule bXRewritingRule,
			Context context, Match match) {
		// TODO Auto-generated method stub
//		List<Pattern> lhs = new ArrayList<Pattern>();
//		lhs.add(bXRewritingRule.getSource());
		Pattern lhs = bXRewritingRule.getSource();
		Pattern nView = bXRewritingRule.getView();
		Clause when = bXRewritingRule.getWhen();
		Clause update = bXRewritingRule.getUpdate();
		
		//List<Pattern> nac = bXRewritingRule.getNac();
		
		Pattern rhs = bXRewritingRule.getUnmatchSrc();
		
		Match.resetCache();
		
		List<Context> lhsMatches = match.match(lhs, context, this, context.getEnviroment());
		
		//List<Context> successfulContexts = new ArrayList<Context>();
		
		List<Pattern> lhsST = Collections.singletonList(lhs);
		
		for(Context c : lhsMatches) {
			if(this.checkExists(c)) continue;
			if(recheckMatch(lhsST, c)==false) continue;
			if(checkAlign(nView,when,c,match)==false) {
				// update rhs
				if(rhs==null){
					Update.instance.delete(lhs,bXRewritingRule.getParameters(),c,c.getEnviroment(),this);
				} else {
					Update.instance.update(rhs,lhs,c,c.getEnviroment(),this);					
				}
				
				// enforce when and update
				//Update.instance.updateClauses(bXRewritingRule.getSource(), c, this, when,update);
				this.addRecord(c);
			}
		}
	}

	private boolean checkAlign(Pattern nView, Clause when, Context c, Match match) {
		List<Context> list = match.match(nView, c, this, c.getEnviroment());
		for(Context nc : list) {
			if(checkClause(when,nc)) return true;
		}
		return false;
	}

	private void putMatch(BXRewritingRule bXRewritingRule, Context context,
			Match match) {
		List<Pattern> lhs = new ArrayList<Pattern>();
		lhs.add(bXRewritingRule.getSource());
		lhs.add(bXRewritingRule.getView());
		
		List<Pattern> nac = bXRewritingRule.getNac();
		
		Clause when = bXRewritingRule.getWhen();
		Clause update = bXRewritingRule.getUpdate();
		
		Match.resetCache();
		
		List<Context> lhsMatches = match.match(lhs, context, this, context.getEnviroment());
		
		//List<Context> successfulContexts = new ArrayList<Context>();
		
		Match.resetCache();
		
		for(Context c : lhsMatches) {
			if(this.checkExists(c)) continue;
			if(recheckMatch(lhs, c)==false) continue;
			if(checkClause(when,c)==false) continue;
			if(checkNAC(c, nac, match)==false) continue;
			
			Update.instance.updateClauses(bXRewritingRule.getSource(), c, this, update);

			this.addRecord(c);
		}
		
		return;
		
	}

	protected boolean checkClause(Clause when, Context c) {
		for(Statement statement : when.getStatements()){
			Object v = interprete(statement, c);
			if(!BooleanLibrary.isTrue(v)) return false;
		}
		return true;
	}

	@Override
	public Object interprete_edu_ustb_sei_mde_morel_BXRewritingModel(
			BXRewritingModel bXRewritingModel, Context context) {
		try {
			Context init = context.newScope();
			Environment env = context.getEnviroment();
			
			do{
				ConsoleUtil.printToConsole("next iteration", MorelLaunchConfigurationHelper.MOREL_TITLE, true);
				env.getModelUniverse().resetChanged();
				
				for(BXRewritingRule rule : bXRewritingModel.getRules()) {
					if(terminated) return true;
					if(rule.isActive()==false) continue;
					
					if(rule instanceof BXRewritingRule) {
						this.interprete_edu_ustb_sei_mde_morel_BXRewritingRule(rule, init);
					}
//					else if(rule instanceof RuleGroup) {
//						this.interprete_edu_ustb_sei_mde_morel_RuleGroup((RuleGroup)rule, init);
//					}
				}
			}
			while(terminated==false&&env.getModelUniverse().isChanged());
			
			ConsoleUtil.printToConsole("Transformation is finished.", MorelLaunchConfigurationHelper.MOREL_TITLE, true);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return true;
	}

	public void updateStatement(Statement s, Context context) {
		if(s instanceof DeclarativeStatement) {
			this.interprete(s, context);
		} else if(s instanceof ImperativeStatement) {
			ConsoleUtil.printToConsole(MorelLaunchConfigurationHelper.MOREL_TITLE, "cannot update ImperativeStatement "+s, "update", true);
		}
	}

	@Override
	public Object interprete_edu_ustb_sei_mde_morel_RelationalExp(
			RelationalExp relationalExp, Context context) {
		Object direction = context.getValue(Update.DIRECTION);
		
		if(direction==null || relationalExp.getRight()==null) 
			return super.interprete_edu_ustb_sei_mde_morel_RelationalExp(relationalExp, context);
		else {
			if(relationalExp.getOperator()==RelationalOperator.EQUAL) {
				Expression left = relationalExp.getLeft();
				Expression right = relationalExp.getRight();
				
				if(left instanceof VariableExp) {
					if(contains(direction,((VariableExp) left).getReferredVariable())) {
						return this.enforceEqual((VariableExp) left,right, context);
					}
				}
				if(right instanceof VariableExp) {
					if(contains(direction,((VariableExp) right).getReferredVariable())) {
						return this.enforceEqual((VariableExp) right,left, context);
					}
				}
			}
			return super.interprete_edu_ustb_sei_mde_morel_RelationalExp(relationalExp, context);
			
		}
	}

	private boolean contains(Object direction, Variable referredVariable) {
		// TODO Auto-generated method stub
		if(direction instanceof Pattern) {
			return ((Pattern) direction).getVariables().contains(referredVariable);
		}
		return false;
	}
	
	public Object enforceEqual(VariableExp leftValue, Expression rightValue,
			Context context) {
		Object v = this.interprete(rightValue, context);
		VariableExp exp = leftValue;
		if(exp.getPath()==null) {
			context.putValue(exp.getReferredVariable(), v);
			return true;
		} else {
			Object s = context.getValue(exp.getReferredVariable());
			return this.interprete_edu_ustb_sei_mde_morel_CallPathExp(s, exp.getPath(), context,true,v);
		}
	}
	
}
