package edu.ustb.sei.mde.xmu.resource.xmu.interpret.internal;

import java.util.ArrayList;
import java.util.List;

import edu.ustb.sei.mde.xmu.*;
import edu.ustb.sei.mde.xmu.resource.xmu.interpret.SafeType;
import edu.ustb.sei.mde.xmu.resource.xmu.interpret.XmuContext;
import edu.ustb.sei.mde.xmu.resource.xmu.interpret.XmuExpressionCheck;

public class StringPattern {
	private List<StringPatternElement> pattern;

	public List<StringPatternElement> getPattern() {
		if(pattern==null) 
			pattern = new ArrayList<StringPatternElement>();
		return pattern;
	}
	
	public boolean append(StringPatternElement elem) {
//		if(pattern==null) {
//			pattern = elem;
//			return true;
//		} else {
//			if(pattern instanceof StringCombination) {
//				
//			} else {
//				if(pattern instanceof StringConstant) {
//					if(elem instanceof StringConstant) {
//						
//					} else if(elem instanceof StringVariable) {
//						StringCombination sc = 
//					} else return false;
//				} else if(pattern instanceof StringVariable) {
//					
//				} else return false;
//			}
//		}
		
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
	
	

	static public StringPattern getStringPattern(AdditiveExpr expr, XmuContext context) {
		StringPattern pattern = new StringPattern();
		if(getPattern(expr,context,pattern)==false) return null;
		else return pattern;
	}
	
	static private boolean getPattern(Expr expr, XmuContext context, StringPattern pattern) {
		if(expr instanceof AdditiveExpr) {
			if(checkOperators(((AdditiveExpr) expr).getOperators())==false) 
				return false;
			//List<StringPatternElement> stringPattern = pattern.getPattern();
			
			for(Expr e : ((AdditiveExpr) expr).getOperands()) {
				if(e instanceof ParenExpr) {
					if(getPattern(e,context,pattern)==false) 
						return false;
				} else {
					SafeType v = XmuExpressionCheck.EXPRESSION_CHECK.interprete(e, context);
					if(v.isValue() || v.isNull()) {
						StringConstant sc = new StringConstant();
						sc.setConstant(v.getStringValue());
						int index = ((AdditiveExpr) expr).getOperands().indexOf(e);
						if(index==0 || ((AdditiveExpr)expr).getOperators().get(index-1)==AdditiveOperator.ADD)
							sc.setFirst(true);
						else sc.setFirst(false);
						
						if(pattern.append(sc)==false) 
							return false;
					} else if(v.isUndefined()) {
						if(e instanceof VariableExp) {
							StringVariable sv = new StringVariable();
							sv.setUndefined(e);
							if(pattern.append(sv)==false) 
								return false;
						} else 
							return false;
					} else if(v.isInvalid()) {
						return false;
					}
				}
			}
			return true;
		} else if(expr instanceof ParenExpr) {
			return getPattern(((ParenExpr) expr).getBody(),context,pattern);
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
