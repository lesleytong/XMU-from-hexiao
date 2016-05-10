package edu.ustb.sei.mde.xmu2.runtime.executor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

import edu.ustb.sei.commonutil.util.Pair;
import edu.ustb.sei.mde.xmu2.runtime.exceptions.InvalidBackwardEnforcementException;
import edu.ustb.sei.mde.xmu2.runtime.structures.Context;
import edu.ustb.sei.mde.xmu2.runtime.values.SafeType;
import edu.ustb.sei.mde.xmu2.util.AnalysisUtil;
import edu.ustb.sei.mde.xmu2.util.Constants;
import edu.ustb.sei.mde.xmu2.util.ContextUtil;
import edu.ustb.sei.mde.xmu2.util.Tuple;
import edu.ustb.sei.mde.xmu2core.AlignStatement;
import edu.ustb.sei.mde.xmu2core.CaseClause;
import edu.ustb.sei.mde.xmu2core.CaseExpressionClause;
import edu.ustb.sei.mde.xmu2core.CasePatternClause;
import edu.ustb.sei.mde.xmu2core.CaseStatement;
import edu.ustb.sei.mde.xmu2core.DeleteLinkStatement;
import edu.ustb.sei.mde.xmu2core.DeleteNodeStatement;
import edu.ustb.sei.mde.xmu2common.*;
import edu.ustb.sei.mde.xmu2core.EnforceLinkStatement;
import edu.ustb.sei.mde.xmu2core.EnforceNodeStatement;
import edu.ustb.sei.mde.xmu2core.Expression;
import edu.ustb.sei.mde.xmu2core.ForEachStatement;
import edu.ustb.sei.mde.xmu2core.LoopPath;
import edu.ustb.sei.mde.xmu2core.PositionPath;
import edu.ustb.sei.mde.xmu2core.Procedure;
import edu.ustb.sei.mde.xmu2core.ProcedureCallStatement;
import edu.ustb.sei.mde.xmu2core.Statement;
import edu.ustb.sei.mde.xmu2core.Variable;
import edu.ustb.sei.mde.xmu2core.VariableExpression;

public class BackwardModelEnforceInterpreter extends ModelEnforceInterpreter {

	@Override
	public void executeAlignStatement(AlignStatement statement, Context context) {
		Context sbase = context.clone();
		Context vbase = context.clone();
		
		List<Context> smatches = ContextUtil.match(statement.getSource(), sbase);
		List<Context> vmatches = ContextUtil.match(statement.getView(), vbase);
		List<Pair<Context,Context>> alignment = ContextUtil.align(smatches, vmatches);
		
		List<Variable> sVars = ContextUtil.collectPatternVariables(statement.getSource());
		 
		for(Pair<Context,Context> p : alignment) {
			Context merge = ContextUtil.merge(statement.getSource(), statement.getView(), p);
			
			List<Statement> action = null;
			
			if(p.getFirst()!=null && p.getSecond()!=null) {
				action = statement.getMatch();
			} else if(p.getFirst()!=null && p.getSecond()==null) {
				action = statement.getUnmatchs();
			} else if(p.getFirst()==null && p.getSecond()!=null) {
				action = statement.getUnmatchv();
			}
			
			if(action!=null) {
				handleProcedureTrialCallStatements(this.collectRuleCallStatements(action,merge),sVars,merge);
				this.executeStatements(action,merge);
			} else {
				throw new InvalidBackwardEnforcementException("alignment statement lacks action");
			}
			
			mergeContext(context,merge);
		}
	}
	
	protected void handleProcedureTrialCallStatements(List<ProcedureCallStatement> collectRuleCallStatements,
			List<Variable> sVars, Context context) {
		for(ProcedureCallStatement u : collectRuleCallStatements) {
			this.trialRuleCall(u, context);
		}
		
		for(Variable s : sVars) {
			Variable sp = (Variable) context.getVariable(AnalysisUtil.getUpdatedSourceVariableName(s.getName()));
			if(context.get(sp).isUndefined()) {
				SafeType sv = context.get(s);
				if(sv.isNull()) {
					System.out.println("Source value is empty, while there is no updatedStatement for "+s.getName());
					System.out.println(context);
				} else {
					Object spv = context.getEnvironment().getDefaultUpdated(sv.getValue());
					context.put(sp, SafeType.createFromValue(spv));
				}
			}
		}
	}
	
	private void trialRuleCall(ProcedureCallStatement ruleCallStatement, Context context) {
		try {
			List<Object> parameterList = new ArrayList<Object>();
			Procedure rule = ruleCallStatement.getProcedure();
			int size = rule.getParameters().size();
			
			for (int i = 0; i < size; i++) {
				Expression ap = ruleCallStatement.getParameters().get(i);
				try {
					SafeType value = this.executeExpression(ap, context);
					if (value.isUndefined())
						return;
					parameterList.add(value.getValue());

				} catch (Exception e) {
					return;
				}
			}

			Tuple ret = context.getEnvironment().getTrace(rule, parameterList);
			
			if (ret != null) {
				// write back
				for (int i = 0, j = 0; i < size; i++) {
					Variable fp = rule.getParameters().get(i);
					Expression uap = ruleCallStatement.getUpdatedParameters().get(i);

					if (fp.getTag() == DomainTag.SOURCE) {

						Object obj = ret.get(j);
						j++;

						if (!this.enforceExpression(uap, context, 
								SafeType.createFromValue(obj)))
							return;
					}
				}
				return;

			} else
				return;
		} catch (Exception e) {
		}
	}

	protected void mergeContext(Context mainContext, Context branchContext) {
		// FIXME:
		// ideally, I should write the value of the outer variable back to the mainContext
		// currently, I only merge the value of the parameter
		// an outer variable is a variable declared under the mainContext but uniquely bound in branchContext(s)
		// perhaps, I can change the signature to mergeContext(Context, List<Context>)
		
		Procedure rule = mainContext.getProcedure();

		for (Variable fp : rule.getParameters()) {
			if (fp.getTag() == DomainTag.SOURCE) {
				Variable v = fp;
				Variable vp = mainContext.getVariable(v.getName() + Constants.POST);
				SafeType val = branchContext.get(vp);
				mainContext.put(vp, val);
			} else if (fp.getTag() == DomainTag.NORMAL) {
				Variable vp = fp;
				SafeType val = branchContext.get(vp);
				mainContext.put(vp, val);
			}
		}
	}

	@Override
	public void executeCaseStatement(CaseStatement statement, Context context) {
		for(CaseClause css : statement.getClauses()) {//copy context for each iteration and merge at last
			if(css instanceof CasePatternClause) {
				// FIXME
				// if there is a unique match, the action can modify the match
				// otherwise, the action should not modify.
				// currently, I cannot check this. 
				
				SafeType c = this.checkPattern(((CasePatternClause) css).getCondition(), context);
				
				if(c.getValue()==Boolean.TRUE) {
					List<Variable> sVars = statement.getTag() == DomainTag.SOURCE 
							? ContextUtil.collectPatternVariables(((CasePatternClause) css).getCondition()) : Collections.EMPTY_LIST;
					if(sVars.size()!=0) {
						handleProcedureTrialCallStatements(this.collectRuleCallStatements(css.getAction(),context), sVars, context);
					}
					this.executeStatements(css.getAction(), context);
					return;
				}
			} else if(css instanceof CaseExpressionClause) {
				SafeType c = this.executeExpression(((CaseExpressionClause) css).getCondition(), context);
				if(c.getValue()==Boolean.TRUE) {
					this.executeStatements(css.getAction(), context);
					return;
				}
			}
		}
		throw new InvalidBackwardEnforcementException("no branch can be triggered in switch statement");
	}

	@Override
	public void executeProcedureCallStatement(ProcedureCallStatement ruleCallStatement, Context context) {
		List<Object> parameterList = new ArrayList<Object>();
		Procedure rule = ruleCallStatement.getProcedure();
		int size = rule.getParameters().size();
		
		Context newContext = new Context(context.getEnvironment());
		newContext.setProcedure(rule);
		newContext.initFromProcedure(rule);
		
		
		for (int i = 0; i < size; i++) {
			Variable fp = rule.getParameters().get(i);
			Expression ap = ruleCallStatement.getParameters().get(i);

			SafeType value = this.executeExpression(ap, context);
			
			if (value.isUndefined())
				throw new InvalidBackwardEnforcementException("invalid parameter of rule call in backward transformation");
			parameterList.add(value.getValue());
			
			newContext.put(fp, value);
			if(fp.getTag()==DomainTag.SOURCE) {
				SafeType spValue = calculateDefaultUpdatedValue(ap,value,fp,context);
				Variable fspv = newContext.getVariable(AnalysisUtil.getUpdatedSourceVariableName(fp.getName()));
				newContext.put(fspv, spValue);
			}

		}

		Tuple ret = context.getEnvironment().getTrace(rule, parameterList);
		
		if (ret != null) {
			// write back
			for (int i = 0, j = 0; i < size; i++) {
				Variable fp = rule.getParameters().get(i);
				Expression uap = ruleCallStatement.getUpdatedParameters().get(i);

				if (fp.getTag() == DomainTag.SOURCE) {

					Object obj = ret.get(j);
					j++;

					if (!this.enforceExpression(uap, context, 
							SafeType.createFromValue(obj)))
						throw new InvalidBackwardEnforcementException("cannot putback updated source parameters");
				}
			}
			return;

		} else {
			this.executeStatements(rule.getStatements(),newContext);
			
			List<Object> updatedSourceList = new ArrayList<Object>();
			//write back
			for(int i=0;i<size;i++) {
				Variable fp = rule.getParameters().get(i);
//				Expression uap = ruleCallStatement.getUpdatedParameters().get(i);
				
				if(fp.getTag()==DomainTag.SOURCE) {
					Variable sp = newContext.getVariable(AnalysisUtil.getUpdatedSourceVariableName(fp.getName()));
					SafeType spv = newContext.get(sp);
					
//						if(this.enforceExpression(uap, context, spv)==false)
//							throw new InvalidBackwardEnforcementException("cannot putback updated source parameters");
						
					updatedSourceList.add(spv.getValue());
				}
			}
			
			//record trace
			context.getEnvironment().putTrace(rule, parameterList, updatedSourceList);
			
			return;
		}
	}

	private SafeType calculateDefaultUpdatedValue(Expression ap, SafeType apv, Variable fp, Context context) {
		if(ap instanceof VariableExpression) {
			if(((VariableExpression) ap).getPaths().size()==0) {
				Variable sv = ((VariableExpression) ap).getVariable();
				Variable spv = context.getVariable(AnalysisUtil.getUpdatedSourceVariableName(sv.getName()));
				if(spv==null) {
					throw new InvalidBackwardEnforcementException("invalid actual parameter: no corresponding updated source variable "+sv.getName());
				} else {
					return context.get(spv);
				}
			} else {
				if(!(fp.getType() instanceof EDataType))
					throw new InvalidBackwardEnforcementException("currently, I cannot calculate derived value");
			}
		}

		return SafeType.createFromValue(context.getEnvironment().getDefaultUpdated(apv.getValue()));
	}

	@Override
	public void executeDeleteNodeStatement(DeleteNodeStatement statement, Context context) {
		Variable spv = statement.getTarget();
		SafeType v = context.get(spv);
		if(v.isUndefined() || v.isNull()) 
			return;
		//ObjectVariable vv = ContextUtil.lookupViewVariable(deleteNode, spv);
		if(deleteNode(spv, context)!=Constants.TRUE)
			throw new InvalidBackwardEnforcementException("cannot delete node");
	}
	
	protected SafeType deleteNode(Variable sourcePostVar, Context context) {
		Variable sv = (Variable) context.getVariable(AnalysisUtil.getNonUpdatedSourceVariableName(sourcePostVar.getName()));
		
		Object s = context.get(sv).getValue();
		Object sp = context.get(sourcePostVar).getValue();
		
		if(s==null || sp == null) 
			throw new InvalidBackwardEnforcementException("error in node deletion: source/updated source element is missing");
		
		boolean ret = deleteUpdatedSourceElement(s,sp,context);
		if(ret) {
			context.put(sourcePostVar, SafeType.NULL);
		}
		return SafeType.createFromValue(ret);
	}

	private boolean deleteUpdatedSourceElement(Object s, Object sp, Context context) {
		if(!(s instanceof EObject && sp instanceof EObject)) {
			//FIXME ideally, I should turn deletion of a primitive variable into delete link
			throw new InvalidBackwardEnforcementException("cannot delete primitive value");
		}
		else {
			try {
				context.getEnvironment().deleteObject((EObject)sp);
				context.getEnvironment().putDefault((EObject)s, null);
				return true;
			} catch(Exception e) {
				return false;
			}
		}
	}

	@Override
	public void executeDeleteLinkStatement(DeleteLinkStatement statement, Context context) {
		Variable src = statement.getSource();
		Expression tar = statement.getTarget();
		EStructuralFeature f = statement.getFeature();
		
		EObject sourcePost = context.get(src).getObjectValue();		
		SafeType value = this.executeExpression(tar, context);
		
		if(sourcePost == null || value.isNull() || value.isUndefined()) 
			return;
		
		if(context.getEnvironment().containFeature(sourcePost, f, value.getValue())==false) 
			return ;
		
		if(!context.getEnvironment().deleteLink(sourcePost, f, value.getValue()))
			throw new InvalidBackwardEnforcementException("cannot delete link");
	}

	@Override
	public void executeEnforceNodeStatement(EnforceNodeStatement statement, Context context) {
		Variable node = statement.getNode();
		EClass type = (EClass)statement.getType();
		Expression candidate = statement.getCandidate();

		SafeType oldValue = context.get(node);
		SafeType newValue = null;
		
		if(oldValue.isUndefined()) {
			try {
			if(candidate!=null) {
				oldValue = this.executeExpression(candidate, context);
				if(oldValue==Constants.NULL)
					oldValue = Constants.UNDEFINED;
			}
			} catch(Exception e) {
				oldValue = SafeType.UNDEFINED;
			}
		}
		
		boolean createNew = false;
		
		if(oldValue.isUndefined())
			createNew = true;
		else {
			if(!type.isSuperTypeOf(oldValue.getObjectValue().eClass()))
				createNew = true;
		}
		
		if(createNew) {
			Variable sNode = context.getVariable(AnalysisUtil.getNonUpdatedSourceVariableName(node.getName()));
			SafeType sv = context.get(sNode);
			if(sv==null) sv = SafeType.NULL;
			if(oldValue.isUndefined()==false)
				this.deleteUpdatedSourceElement(sv.getObjectValue(), oldValue.getValue(), context);
			newValue = SafeType.createFromValue(this.createUpdatedSourceElement(sv.getObjectValue(), type, context));
		} else {
			newValue = oldValue;
			context.getEnvironment().markAsUsed(newValue.getObjectValue());
		}
		
		context.put(node, newValue);
		
		return;
	}
	
	private EObject createUpdatedSourceElement(EObject sv, EClass type, Context context) {
		if(type.isAbstract()) {
			throw new InvalidBackwardEnforcementException("cannot create an instance of an abstract type");
		} else {
			EObject obj = context.getEnvironment().createObject(type);
			if(sv!=null)
				context.getEnvironment().putDefault(sv, obj);
			return obj;
		}
	}

	@Override
	public void executeEnforceLinkStatement(EnforceLinkStatement statement, Context context) {
		Variable source = statement.getSource();
		EStructuralFeature feature = statement.getFeature();
		LoopPath selector = statement.getSelector();
		PositionPath position = statement.getPosition();
		Expression target = statement.getTarget();
		
		if(this.enforceLink(source, feature, selector, position, target, context))
			return;
		else
			throw new InvalidBackwardEnforcementException("cannot enforce link");
		
		
		
	}

	@Override
	protected boolean isEnforceableVariable(Variable v) {
		return (v.getTag()==DomainTag.NORMAL || v.getTag()==DomainTag.UPDATED_SOURCE);
	}

	@Override
	public void executeForEachStatement(ForEachStatement statement, Context context) {
		List<Context> matches = ContextUtil.match(statement.getPattern(), context);
		List<Variable> sVars = ContextUtil.collectPatternVariables(statement.getPattern());
		for(Context m : matches) {
			this.handleProcedureTrialCallStatements(this.collectRuleCallStatements(statement.getAction(),m),sVars,m);
			this.executeStatements(statement.getAction(), m);
		}
	}
}
