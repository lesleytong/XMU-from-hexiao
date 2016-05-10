package edu.ustb.sei.mde.xmu2.runtime.string;

import java.util.ArrayList;
import java.util.List;

import edu.ustb.sei.mde.xmu2.runtime.executor.AbstractInterpreter;
import edu.ustb.sei.mde.xmu2.runtime.structures.Context;
import edu.ustb.sei.mde.xmu2.runtime.values.SafeType;
import edu.ustb.sei.mde.xmu2common.AdditiveOperator;
import edu.ustb.sei.mde.xmu2core.AdditiveExpression;
import edu.ustb.sei.mde.xmu2core.Expression;
//import edu.ustb.sei.mde.xmu2core.ParenExpression;
import edu.ustb.sei.mde.xmu2core.VariableExpression;


public class StringPattern {
	private List<StringPatternElement> pattern;

	public List<StringPatternElement> getPattern() {
		if(pattern==null) 
			pattern = new ArrayList<StringPatternElement>();
		return pattern;
	}
	
	public boolean append(StringPatternElement elem) {
		List<StringPatternElement> pattern = this.getPattern();
		if(pattern.isEmpty()) {
			pattern.add(elem);
			return true;
		}
		else {
			StringPatternElement last = pattern.get(pattern.size()-1);
			if(elem instanceof StringVariable) {
				if(last instanceof StringVariable) return false;
				else {
					pattern.add(elem);
					return true;
				}
			} else if(elem instanceof StringConstant) {
				if(last instanceof StringConstant) {
					String cc = ((StringConstant) elem).getConstant();
					boolean cf = ((StringConstant) elem).isFirst();
					
					String lc = ((StringConstant) last).getConstant();
					boolean lf = ((StringConstant) last).isFirst();
					
					if(cf && lf) {
						((StringConstant) last).setConstant(lc+cc);
						((StringConstant) last).setFirst(true);						
					} else {
						pattern.add(elem);
					}
					
					return true;
				}
				else {
					pattern.add(elem);
					return true;
				}
			} else return false;
		}
	}
	
	

	static public StringPattern getStringPattern(AdditiveExpression expr, Context context) {
		StringPattern pattern = new StringPattern();
		if(getPattern(expr,context,pattern)==false) return null;
		else return pattern;
	}
	
	static private boolean getPattern(Expression expr, Context context, StringPattern pattern) {
		if(expr instanceof AdditiveExpression) {
			if(checkOperators(((AdditiveExpression) expr).getOperators())==false) 
				return false;
			
			for(Expression e : ((AdditiveExpression) expr).getOperands()) {
//				if(e instanceof ParenExpression) {
//					if(getPattern(e,context,pattern)==false) 
//						return false;
//				} else {
					SafeType v = AbstractInterpreter.EXPRESSION_CHECK.executeExpression(e, context);
					if(v.isUndefined()==false || v.isNull()) {
						StringConstant sc = new StringConstant();
						sc.setConstant(v.getStringValue());
						int index = ((AdditiveExpression) expr).getOperands().indexOf(e);
						if(index==0 || ((AdditiveExpression)expr).getOperators().get(index-1)==AdditiveOperator.ADD)
							sc.setFirst(true);
						else sc.setFirst(false);
						
						if(pattern.append(sc)==false) 
							return false;
					} else if(v.isUndefined()) {
						if(e instanceof VariableExpression) {
							StringVariable sv = new StringVariable();
							sv.setUndefined(e);
							if(pattern.append(sv)==false) 
								return false;
						} else 
							return false;
					}
//				}
			}
			return true;
//		} else if(expr instanceof ParenExpression) {
//			return getPattern(((ParenExpression) expr).getBody(),context,pattern);
		} else 
			return false;
	}
	
	static private boolean checkOperators(List<AdditiveOperator> operators) {
		for(AdditiveOperator op : operators) {
			if(op==AdditiveOperator.SUB) return false;
		}
		return true;
	}
}
