package edu.ustb.sei.mde.xmu2.runtime.executor;

import java.util.List;

import edu.ustb.sei.mde.xmu2.runtime.exceptions.InvalidCalculationException;
import edu.ustb.sei.mde.xmu2.runtime.structures.Context;
import edu.ustb.sei.mde.xmu2.runtime.structures.Environment;
import edu.ustb.sei.mde.xmu2.runtime.values.SafeType;
import edu.ustb.sei.mde.xmu2.util.AnalysisUtil;
import edu.ustb.sei.mde.xmu2common.DomainTag;
import edu.ustb.sei.mde.xmu2core.AdditiveExpression;
import edu.ustb.sei.mde.xmu2core.AlignStatement;
import edu.ustb.sei.mde.xmu2core.BooleanAndExpression;
import edu.ustb.sei.mde.xmu2core.BooleanOrExpression;
import edu.ustb.sei.mde.xmu2core.BooleanValueExpression;
import edu.ustb.sei.mde.xmu2core.CaseStatement;
import edu.ustb.sei.mde.xmu2core.CheckExpressionStatement;
import edu.ustb.sei.mde.xmu2core.DeleteLinkStatement;
import edu.ustb.sei.mde.xmu2core.DeleteNodeStatement;
import edu.ustb.sei.mde.xmu2core.EmptyValueExpression;
import edu.ustb.sei.mde.xmu2core.EnforceExpressionStatement;
import edu.ustb.sei.mde.xmu2core.EnforceLinkStatement;
import edu.ustb.sei.mde.xmu2core.EnforceNodeStatement;
import edu.ustb.sei.mde.xmu2core.EntryRuleParameter;
import edu.ustb.sei.mde.xmu2core.EnumValueExpression;
import edu.ustb.sei.mde.xmu2core.Expression;
import edu.ustb.sei.mde.xmu2core.ForEachStatement;
import edu.ustb.sei.mde.xmu2core.IntegerValueExpression;
import edu.ustb.sei.mde.xmu2core.MatchPattern;
import edu.ustb.sei.mde.xmu2core.MultiplicativeExpression;
import edu.ustb.sei.mde.xmu2core.ObjectValueExpression;
import edu.ustb.sei.mde.xmu2core.Procedure;
import edu.ustb.sei.mde.xmu2core.ProcedureCallStatement;
import edu.ustb.sei.mde.xmu2core.RelationalExpression;
import edu.ustb.sei.mde.xmu2core.Statement;
import edu.ustb.sei.mde.xmu2core.StringValueExpression;
import edu.ustb.sei.mde.xmu2core.Transformation;
import edu.ustb.sei.mde.xmu2core.TypeCastExpression;
import edu.ustb.sei.mde.xmu2core.UnaryExpression;
import edu.ustb.sei.mde.xmu2core.Variable;
import edu.ustb.sei.mde.xmu2core.VariableExpression;

public abstract class AbstractInterpreter {
	
	final static public ExpressionCheckInterpreter EXPRESSION_CHECK = new ExpressionCheckInterpreter();
	final static public ModelCheckInterpreter MODEL_CHECK = new ModelCheckInterpreter();
	final static public ForwardModelEnforceInterpreter FORWARD_ENFORCE = new ForwardModelEnforceInterpreter();
	final static public ModelEnforceInterpreter BACKWARD_ENFORCE = new BackwardModelEnforceInterpreter();
	
	public void executeStatement(Statement o, Context context) {
		if(o instanceof AlignStatement)
			executeAlignStatement((AlignStatement)o, context);
		
		else if(o instanceof CaseStatement)
			executeCaseStatement((CaseStatement)o, context);
		
		else if(o instanceof ProcedureCallStatement)
			executeProcedureCallStatement((ProcedureCallStatement)o, context);
		
		else if(o instanceof ForEachStatement)
			executeForEachStatement((ForEachStatement)o, context);
		
		else if(o instanceof DeleteNodeStatement)
			executeDeleteNodeStatement((DeleteNodeStatement)o, context);
		
		else if(o instanceof DeleteLinkStatement)
			executeDeleteLinkStatement((DeleteLinkStatement)o, context);
		
		else if(o instanceof EnforceNodeStatement)
			executeEnforceNodeStatement((EnforceNodeStatement)o, context);
		
		else if(o instanceof EnforceLinkStatement)
			executeEnforceLinkStatement((EnforceLinkStatement)o, context);
		
		else if(o instanceof MatchPattern)
			executeMatchPatternStatement((MatchPattern)o,context);
		
		else if(o instanceof CheckExpressionStatement)
			executeCheckExpressionStatement((CheckExpressionStatement)o,context);
		
		else if(o instanceof EnforceExpressionStatement)
			executeEnforceExpressionStatement((EnforceExpressionStatement)o,context);
		
		else throw new InvalidCalculationException();
	}
	
	abstract public void executeMatchPatternStatement(MatchPattern o, Context context);
	abstract public void executeCheckExpressionStatement(CheckExpressionStatement o, Context context);
	abstract public void executeEnforceExpressionStatement(EnforceExpressionStatement o, Context context);

	public SafeType executeExpression(Expression o, Context context) {
		if (o instanceof BooleanOrExpression)
			return executeBooleanOrExpression((BooleanOrExpression) o, context);

		else if (o instanceof BooleanAndExpression)
			return executeBooleanAndExpression((BooleanAndExpression) o, context);

		else if (o instanceof RelationalExpression)
			return executeRelationalExpression((RelationalExpression) o, context);

		else if (o instanceof AdditiveExpression)
			return executeAdditiveExpression((AdditiveExpression) o, context);

		else if (o instanceof MultiplicativeExpression)
			return executeMultiplicativeExpression((MultiplicativeExpression) o, context);

		else if (o instanceof UnaryExpression)
			return executeUnaryExpression((UnaryExpression) o, context);

		// else if(o instanceof ParenExpression)
		// return executeParenExpression((ParenExpression)o, context);

		else if (o instanceof TypeCastExpression)
			return executeTypeCastExpression((TypeCastExpression) o, context);

		else if (o instanceof StringValueExpression)
			return executeStringValueExpression((StringValueExpression) o, context);

		else if (o instanceof BooleanValueExpression)
			return executeBooleanValueExpression((BooleanValueExpression) o, context);

		else if (o instanceof IntegerValueExpression)
			return executeIntegerValueExpression((IntegerValueExpression) o, context);

		else if (o instanceof EnumValueExpression)
			return executeEnumValueExpression((EnumValueExpression) o, context);

		else if (o instanceof EmptyValueExpression)
			return executeEmptyValueExpression((EmptyValueExpression) o, context);

		else if (o instanceof ObjectValueExpression)
			return executeObjectValueExpression((ObjectValueExpression) o, context);

		else if (o instanceof VariableExpression)
			return executeVariableExpression((VariableExpression) o, context);
		
		throw new InvalidCalculationException("cannot execute "+o);
	}
	
	public void executeStatements(List<Statement> statements, Context context) {
		for(Statement stmt : statements) {
			this.executeStatement(stmt, context);
		}
	}
	
	
	abstract public void executeAlignStatement(AlignStatement statement, Context context);
	abstract public void executeCaseStatement(CaseStatement statement, Context context);
	abstract public void executeProcedureCallStatement(ProcedureCallStatement statement, Context context);
	abstract public void executeForEachStatement(ForEachStatement statement, Context context);
	abstract public void executeDeleteNodeStatement(DeleteNodeStatement statement, Context context);
	abstract public void executeDeleteLinkStatement(DeleteLinkStatement statement, Context context);
	abstract public void executeEnforceNodeStatement(EnforceNodeStatement statement, Context context);
	abstract public void executeEnforceLinkStatement(EnforceLinkStatement statement, Context context);
	
	
	abstract public SafeType executeBooleanOrExpression(BooleanOrExpression expression, Context context);
	abstract public SafeType executeBooleanAndExpression(BooleanAndExpression expression, Context context);
	abstract public SafeType executeRelationalExpression(RelationalExpression expression, Context context);
	abstract public SafeType executeAdditiveExpression(AdditiveExpression expression, Context context);
	abstract public SafeType executeMultiplicativeExpression(MultiplicativeExpression expression, Context context);
	abstract public SafeType executeUnaryExpression(UnaryExpression expression, Context context);
	abstract public SafeType executeTypeCastExpression(TypeCastExpression expression, Context context);
	abstract public SafeType executeStringValueExpression(StringValueExpression expression, Context context);
	abstract public SafeType executeBooleanValueExpression(BooleanValueExpression expression, Context context);
	abstract public SafeType executeIntegerValueExpression(IntegerValueExpression expression, Context context);
	abstract public SafeType executeEnumValueExpression(EnumValueExpression expression, Context context);
	abstract public SafeType executeEmptyValueExpression(EmptyValueExpression expression, Context context);
	abstract public SafeType executeObjectValueExpression(ObjectValueExpression expression, Context context);
	abstract public SafeType executeVariableExpression(VariableExpression expression, Context context);
	
	public void executeTransformation(Transformation transformation, Environment environment) {
		List<ProcedureCallStatement> starts = transformation.getEntryRules();
		
		for(ProcedureCallStatement proc : starts) {
			Procedure p = proc.getProcedure();
			Context context = new Context(environment);
			context.initFromProcedure(p);
			
			for(int index = 0 ; index < p.getParameters().size() ; index ++) {
				Expression e = proc.getParameters().get(index);
				Variable v = p.getParameters().get(index);
				
				this.prepareEntryData(v,(EntryRuleParameter)e,context);
			}
			
			this.executeProcedure(p, context);
		}
	}

	private void prepareEntryData(Variable v, EntryRuleParameter e, Context context) {
		Environment env = context.getEnvironment();
		edu.ustb.sei.mde.xmu2.datatypes.Resource res = null;
		
		if(e.getTag()==DomainTag.SOURCE) {
			res = env.getSourceResourceList(e.getIndex());
		} else if(e.getTag()==DomainTag.VIEW) {
			res = env.getViewResourceList(e.getIndex());
		}
		
		context.put(v,SafeType.createFromValue(res));
		
		if(e.getTag()==DomainTag.SOURCE) {
			res = env.getUpdatedSourceResourceList(e.getIndex());
			Variable vp = context.getVariable(AnalysisUtil.getUpdatedSourceVariableName(v.getName()));
			context.put(vp, SafeType.createFromValue(res));
		}
	}

	private void executeProcedure(Procedure proc, Context c) {
		if(c.getEnvironment().isForward())
			this.executeStatements(proc.getForwardStatements(), c);
		else
			this.executeStatements(proc.getBackwardStatements(), c);
	}
}
