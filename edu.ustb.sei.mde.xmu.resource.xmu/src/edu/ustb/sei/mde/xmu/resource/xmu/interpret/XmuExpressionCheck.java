package edu.ustb.sei.mde.xmu.resource.xmu.interpret;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.*;
import org.eclipse.emf.ecore.util.EcoreUtil;

import edu.ustb.sei.mde.modeling.ui.ConsoleUtil;
import edu.ustb.sei.mde.xmu.*;
import edu.ustb.sei.mde.xmu.resource.xmu.analysis.Util;
import edu.ustb.sei.mde.xmu.resource.xmu.util.AbstractXmuInterpreter;

/**
 * Evaluate expressions when all the variables used are bound
 * @author hexiao
 * return Null: null value
 * return Invalid: some thing is wrong
 * return Undefined: the expression cannot be evaluated but it may be enforceable
 * return False: expression is unsatisfied
 * return True: all correct
 */
public class XmuExpressionCheck extends
		AbstractXmuInterpreter<SafeType, XmuContext> {
	
	static public XmuExpressionCheck EXPRESSION_CHECK = new XmuExpressionCheck();

	@Override
	public SafeType interprete_edu_ustb_sei_mde_xmu_Pattern(
			Pattern pattern, XmuContext context) {
		SafeType ret = this.interprete_edu_ustb_sei_mde_xmu_PatternNode(pattern.getRoot(), context);
		if(ret!=Just.TRUE) return ret;
		ret = this.interprete(pattern.getGuard(), context);
		return ret;
	}

	@Override
	public SafeType interprete_edu_ustb_sei_mde_xmu_ForStatement(
			ForStatement forStatement, XmuContext context) {
		// TODO Auto-generated method stub
		Pattern sp = forStatement.getSPattern();
		Pattern vp = forStatement.getVPattern();
		
		SafeType sr = this.interprete_edu_ustb_sei_mde_xmu_Pattern(sp, context);
		SafeType vr = vp == null ? Just.TRUE : this.interprete_edu_ustb_sei_mde_xmu_Pattern(vp,context);
		
		if(sr==Just.TRUE && vr == Just.TRUE) {
			//match
			for(VStatement stmt : forStatement.getActions()) {
				if(stmt.getTag() == VStmtType.MATCH) {
					return this.interprete(stmt.getStatement(), context);
				}
			}
			throw new RuntimeException("No match action");
		} else if(sr==Just.TRUE && vr != Just.TRUE) {
			//unmatch source
			for(VStatement stmt : forStatement.getActions()) {
				if(stmt.getTag() == VStmtType.UNMATCHS) {
					return this.interprete(stmt.getStatement(), context);
				}
			}
			throw new RuntimeException("No unmatchs action");
		} else if(sr!=Just.TRUE && vr == Just.TRUE) {
			//unmatch view
			for(VStatement stmt : forStatement.getActions()) {
				if(stmt.getTag() == VStmtType.UNMATCHV) {
					return this.interprete(stmt.getStatement(), context);
				}
			}
			throw new RuntimeException("No unmatchv action");
		} else {
			return SafeType.getInvalid();
		}
	}

	@Override
	public SafeType interprete_edu_ustb_sei_mde_xmu_DeleteNode(
			DeleteNode deleteNode, XmuContext context) {
		// TODO Auto-generated method stub
//		SafeType obj = context.getSafeTypeValue(deleteNode.getVariable());
//		if(obj.isValue() && !obj.isNull()) {
//			context.getEnvironment().removeElement((EObject)obj.getValue(), deleteNode.getVariable());
//			return Just.TRUE;
//		}
//		else 
//			return SafeType.getInvalid();
		return SafeType.getInvalid();// expression check won't change any thing
	}

	@Override
	public SafeType interprete_edu_ustb_sei_mde_xmu_DeleteLink(
			DeleteLink deleteLink, XmuContext context) {
		return SafeType.getInvalid();
	}

	@Override
	public SafeType interprete_edu_ustb_sei_mde_xmu_UpdatePattern(
			UpdatePattern updatePattern, XmuContext context) {
		return this.interprete_edu_ustb_sei_mde_xmu_Pattern(updatePattern, context);
	}

	@Override
	public SafeType interprete_edu_ustb_sei_mde_xmu_PatternNode(
			PatternNode patternNode, XmuContext context) {
		SafeType obj = context.getSafeTypeValue(patternNode.getVariable());
		if(obj.isUndefined()) return SafeType.getInvalid();
		if(obj.isNull()) return obj; // it means no match
		
		EObject eobj = (EObject) obj.getValue();
		EClass type = patternNode.getType();
		
		if(type.isInstance(eobj)==false) {
			return Just.FALSE;
		} else {
			for(PatternExpr r : patternNode.getExpr() ) {
				SafeType ret = this.interprete(r,context);
				if(ret.isInvalid() || ret.isUndefined()) 
					return SafeType.getInvalid();
				else if(ret.getValue()==Boolean.FALSE)
					return Just.FALSE;
			}
			return Just.TRUE;
		}
	}

	@Override
	public SafeType interprete_edu_ustb_sei_mde_xmu_PatternReferenceExpr(
			PatternReferenceExpr patternReferenceExpr, XmuContext context) {
		// TODO Auto-generated method stub
		EObject obj = (EObject) context.getValue(((PatternNode)patternReferenceExpr.eContainer()).getVariable());
		
		SafeType val = context.getSafeTypeValue(patternReferenceExpr.getNode().getVariable());
		if(val.isUndefined() || val.isInvalid()) return val;
		//if(val.isNull()) return SafeType.getUndefined();
		
		EReference ref = patternReferenceExpr.getReference();
		
		try {
			if(patternReferenceExpr.getPos()==null) {
				if(context.getEnvironment().containFeature(obj, ref, val.getValue())) {
					return this.interprete(patternReferenceExpr.getNode(),context);
				} else return Just.FALSE;
			} else {
				SafeType id = this.interprete(patternReferenceExpr.getPos(),context);
				if(id.isUndefined()) 
					return SafeType.getUndefined();
				if(id.isInvalid() || id.isNull()) 
					return SafeType.getInvalid();
				if(!(id.getValue() instanceof Integer))
					return SafeType.getInvalid();
				
				if(context.getEnvironment().containFeature(obj, ref, id.getIntegerValue(), val.getValue()))
					return this.interprete(patternReferenceExpr.getNode(),context);
				else return Just.FALSE;
			}
		} catch (Exception e) {
			return SafeType.getInvalid();
		}
	}

	@Override
	public SafeType interprete_edu_ustb_sei_mde_xmu_PatternEqualExpr(
			PatternEqualExpr patternEqualExpr, XmuContext context) {
		EObject obj = (EObject) context.getValue(((PatternNode)patternEqualExpr.eContainer()).getVariable());
		
		SafeType val = this.interprete(patternEqualExpr.getValue(), context); 
				
		if(val.isUndefined() || val.isInvalid()) return val;
		
		//if(val.isNull()) return SafeType.getUndefined();
		
		EStructuralFeature ref = patternEqualExpr.getFeature();
		
		try {
			if(patternEqualExpr.getPos()==null) {
				if(context.getEnvironment().containFeature(obj, ref, val.getValue())) {
					return Just.TRUE;
				} else return Just.FALSE;
			} else {
				SafeType id = this.interprete(patternEqualExpr.getPos(),context);
				if(id.isUndefined()) 
					return SafeType.getUndefined();
				if(id.isInvalid() || id.isNull()) 
					return SafeType.getInvalid();
				if(!(id.getValue() instanceof Integer))
					return SafeType.getInvalid();
				
				if(context.getEnvironment().containFeature(obj, ref, (Integer)id.getValue(), val.getValue()))
					return Just.TRUE;
				else return Just.FALSE;
			}
		} catch (Exception e) {
			return SafeType.getInvalid();
		}
	}

	@Override
	public SafeType interprete_edu_ustb_sei_mde_xmu_EmptyLiteral(
			EmptyLiteral emptyLiteral, XmuContext context) {
		switch(emptyLiteral.getValue()) {
		case NULL_VALUE:
			return SafeType.getNull();
		case EMPTY_VALUE:
			return SafeType.getUndefined();
		}
		return SafeType.getNull();
	}

	@Override
	public SafeType interprete_edu_ustb_sei_mde_xmu_StringLiteral(
			StringLiteral stringLiteral, XmuContext context) {
		return SafeType.createFromValue(stringLiteral.getValue());
	}

	@Override
	public SafeType interprete_edu_ustb_sei_mde_xmu_IntegerLiteral(
			IntegerLiteral integerLiteral, XmuContext context) {
		return SafeType.createFromValue(integerLiteral.getValue());
	}

	@Override
	public SafeType interprete_edu_ustb_sei_mde_xmu_BooleanLiteral(
			BooleanLiteral booleanLiteral, XmuContext context) {
		return SafeType.createFromValue(booleanLiteral.getValue());
	}

	@Override
	public SafeType interprete_edu_ustb_sei_mde_xmu_EnumLiteral(
			EnumLiteral enumLiteral, XmuContext context) {
		EEnum e = enumLiteral.getType();
		EEnumLiteral l = enumLiteral.getValue();
		
		return SafeType.createFromValue(EcoreUtil.createFromString(e, l.getName()));
	}

	@Override
	public SafeType interprete_edu_ustb_sei_mde_xmu_VStatement(
			VStatement vStatement, XmuContext context) {
		return this.interprete(vStatement.getStatement(), context);
	}

	@Override
	public SafeType interprete_edu_ustb_sei_mde_xmu_BlockStatement(
			BlockStatement blockStatement, XmuContext context) {
		for(Statement stmt : blockStatement.getStatements()) {
			SafeType res = this.interprete(stmt, context);
			if(res.isInvalid() || res.isUndefined()) return res;
			if(res.isBoolean()==false)
				return SafeType.getInvalid();
			else if(res==Just.FALSE)
				return Just.FALSE;
		}
		return Just.TRUE;
	}

	@Override
	public SafeType interprete_edu_ustb_sei_mde_xmu_SwitchStatement(
			SwitchStatement switchStatement, XmuContext context) {
		for(CaseSubStatement css : switchStatement.getCases()) {
			if(css instanceof CasePatternStatement) {
				SafeType c = this.interprete_edu_ustb_sei_mde_xmu_Pattern(((CasePatternStatement) css).getPattern(), context);
				if(c.getValue()==Boolean.TRUE)
					return this.interprete(css.getStatement(), context);
			} else if(css instanceof CaseValueStatement) {
				SafeType c = this.interprete(((CaseValueStatement) css).getExpression(), context);
				if(c.getValue()==Boolean.TRUE)
					return this.interprete(css.getStatement(), context);
			}
		}
		return SafeType.getInvalid();//do nothing?
	}

	@Override
	public SafeType interprete_edu_ustb_sei_mde_xmu_RuleCallStatement(
			RuleCallStatement ruleCallStatement, XmuContext context) {
		XmuContext newContext = new XmuContext(context.getEnvironment());
		Rule rule = ruleCallStatement.getRule();
		newContext.initFromRule(rule);
		
		int size = rule.getParameters().size();
		
		for(int i=0;i<size;i++) {
			Parameter fp = rule.getParameters().get(i);
			Expr ap = ruleCallStatement.getActualParameters().get(i);
			SafeType value = this.interprete(ap, context);
			if(value.isInvalid() || value.isUndefined()) return value;
			newContext.putValue(fp.getVariable(), value);
			
			if(fp.getTag()==VariableFlag.SOURCE) {
				if(!(ap instanceof VariableExp)) return SafeType.getInvalid(); // you are not allowed to pass a derived value to a source variable
				Variable spV = context.getVariable(((VariableExp)ap).getVar().getName()+Util.POST_FLAG);
				SafeType spValue = context.getSafeTypeValue(spV);
				Variable fspv = newContext.getVariable(fp.getVariable().getName()+Util.POST_FLAG);
				newContext.putValue(fspv, spValue);
			}
		}
		
		return this.interprete(rule.getStatement(),newContext);
	}

	@Override
	public SafeType interprete_edu_ustb_sei_mde_xmu_UpdatedStatement(
			UpdatedStatement updatedStatement, XmuContext context) {
		// TODO Auto-generated method stub
		// check the record of update
		throw new java.lang.UnsupportedOperationException("UndatedStatement");
//		return super.interprete_edu_ustb_sei_mde_xmu_UpdatedStatement(updatedStatement,
//				context);
	}

	@Override
	public SafeType interprete_edu_ustb_sei_mde_xmu_BooleanOrExpr(
			BooleanOrExpr booleanOrExpr, XmuContext context) {
		SafeType failure = Just.FALSE;
		for(BooleanOrExprChild b : booleanOrExpr.getOperands()) {
			SafeType res = this.interprete(b, context);
			if(res.getValue()==Boolean.TRUE) return Just.TRUE;
			if(res.isInvalid() || res.isNull()) failure = SafeType.getInvalid();
			else if(res.isUndefined() && failure==Just.FALSE) failure = res;
		}
		return failure;
	}

	@Override
	public SafeType interprete_edu_ustb_sei_mde_xmu_BooleanAndExpr(
			BooleanAndExpr booleanAndExpr, XmuContext context) {
		SafeType success = Just.TRUE;
		for(BooleanAndExprChild b : booleanAndExpr.getOperands()) {
			SafeType res = this.interprete(b, context);
			if(res.getValue()==Boolean.FALSE) return Just.FALSE;
			if(res.isInvalid() || res.isNull()) success = SafeType.getInvalid();
			else if(res.isUndefined() && success==Just.TRUE) success = res;
		}
		return success;
	}

	@Override
	public SafeType interprete_edu_ustb_sei_mde_xmu_RelationalExpr(
			RelationalExpr relationalExpr, XmuContext context) {
		// TODO Auto-generated method stub
		SafeType left = this.interprete(relationalExpr.getLeft(),context);
		SafeType right = this.interprete(relationalExpr.getRight(),context);
		
		
		switch(relationalExpr.getOperator()) {
		case EQUAL:
			if(left.isUndefined() && right.isUndefined()) return SafeType.getInvalid();
			else if(left.isUndefined() || right.isUndefined()) return SafeType.getUndefined();
			else if(left.isInvalid() || right.isInvalid()) return SafeType.getInvalid();
			if((left.isNull() && right.isNull()) || (!left.isNull() && left.getValue().equals(right.getValue())))
				return Just.TRUE;
			return Just.FALSE;
		case LESS:
			return EvaluationUtil.less(left, right);
		case LESS_EQUAL:
			return EvaluationUtil.lessOrEqual(left, right);
		case GREATER:
			return EvaluationUtil.greater(left, right);
		case GREATER_EQUAL:
			return EvaluationUtil.greaterOrEqual(left, right);
		}
		return SafeType.getInvalid();
	}

	@Override
	public SafeType interprete_edu_ustb_sei_mde_xmu_AdditiveExpr(
			AdditiveExpr additiveExpr, XmuContext context) {
		SafeType left = this.interprete(additiveExpr.getOperands().get(0),context);
		int size = additiveExpr.getOperators().size();
		
		for(int i=0;i<size;i++) {
			SafeType right = this.interprete(additiveExpr.getOperands().get(i+1),context);
			
			left = EvaluationUtil.additive(additiveExpr.getOperators().get(i), left, right);
		}
		
		return left;
	}

	@Override
	public SafeType interprete_edu_ustb_sei_mde_xmu_MultiplicativeExpr(
			MultiplicativeExpr multiplicativeExpr, XmuContext context) {
		SafeType left = this.interprete(multiplicativeExpr.getOperands().get(0),context);
		int size = multiplicativeExpr.getOperators().size();
		
		for(int i=0;i<size;i++) {
			SafeType right = this.interprete(multiplicativeExpr.getOperands().get(i+1),context);
			
			left = EvaluationUtil.mutiplicative(multiplicativeExpr.getOperators().get(i), left, right);
		}
		
		return left;
	}

	@Override
	public SafeType interprete_edu_ustb_sei_mde_xmu_UnaryExpr(
			UnaryExpr unaryExpr, XmuContext context) {
		SafeType o = this.interprete(unaryExpr.getBody(),context);
		
		switch(unaryExpr.getOperator()) {
		case MINUS:
			return EvaluationUtil.minus(o);
		case NOT:
			return EvaluationUtil.not(o);
		}
		return SafeType.getInvalid();
	}

	@Override
	public SafeType interprete_edu_ustb_sei_mde_xmu_ParenExpr(
			ParenExpr parenExpr, XmuContext context) {
		return this.interprete(parenExpr.getBody(),context);
	}

	@Override
	public SafeType interprete_edu_ustb_sei_mde_xmu_VariableExp(
			VariableExp variableExp, XmuContext context) {
		SafeType value  = context.getSafeTypeValue(variableExp.getVar());
		if(variableExp.getPath().isEmpty()) return value;
		else {
			for(Path path : variableExp.getPath()) {
				value = getFeaturePath(value,path,context);
			}
			return value;
		}
	}
	
	protected SafeType getFeaturePath(SafeType host, Path path, XmuContext context) {
		if(host.isUndefined() || host.isInvalid() || host.isNull()) return SafeType.getInvalid();
		
		if(host.isObject()) {
			EObject o  = host.getObjectValue();
			if(path instanceof FeaturePath) {
				EStructuralFeature feature = o.eClass().getEStructuralFeature(((FeaturePath) path).getFeature());
				if(feature==null) return SafeType.getInvalid();
				return SafeType.createFromValue(o.eGet(feature));
			} else {
				try {
					Method[] methods = o.getClass().getMethods();
					for(Method m : methods) {
						if(m.getName().equals(((OperationPath)path).getOperation())) {
							EList<Expr> parameters = ((OperationPath)path).getParameters();
							Object[] args = new Object[parameters.size()];
							for(int i=0;i<args.length;i++) {
								Expr e = parameters.get(i);
								SafeType pv =  XmuExpressionCheck.EXPRESSION_CHECK.interprete(e, context);
								if(pv.isUndefined() || pv.isInvalid()) return SafeType.getInvalid();
								args[i] = pv.getValue();
							}
							Object r = m.invoke(o, args);
							return SafeType.createFromValue(r);
						}
					}
					return SafeType.getInvalid();
				} catch(Exception e) {
					e.printStackTrace();
					return SafeType.getInvalid();
				}
			}
		} else {
			Object o = host.getValue();
			if(path instanceof FeaturePath) {
				try{
					Field field = o.getClass().getField(((FeaturePath) path).getFeature());
					if(field==null) return SafeType.getInvalid();
					return SafeType.createFromValue(field.get(o));
				} catch(Exception e) {
					e.printStackTrace();
					return SafeType.getInvalid();
				}
			} else {
				try {
					Method[] methods = o.getClass().getMethods();
					for(Method m : methods) {
						if(m.getName().equals(((OperationPath)path).getOperation())) {
							EList<Expr> parameters = ((OperationPath)path).getParameters();
							Object[] args = new Object[parameters.size()];
							for(int i=0;i<args.length;i++) {
								Expr e = parameters.get(i);
								SafeType pv =  XmuExpressionCheck.EXPRESSION_CHECK.interprete(e, context);
								if(pv.isUndefined() || pv.isInvalid()) return SafeType.getInvalid();
								args[i] = pv.getValue();
							}
							Object r = m.invoke(o, args);
							return SafeType.createFromValue(r);
						}
					}
					return SafeType.getInvalid();
				} catch(Exception e) {
					e.printStackTrace();
					return SafeType.getInvalid();
				}
			}
		}
	}

	@Override
	public SafeType interprete_edu_ustb_sei_mde_xmu_PrintStatement(
			PrintStatement printStatement, XmuContext context) {
		SafeType v = EXPRESSION_CHECK.interprete(printStatement.getExpr(),context);
		
		ConsoleUtil.printToConsole(Util.CONSOLE, v.toString(), "XMU", true);
		
		return Just.TRUE;
	}
	
	
}