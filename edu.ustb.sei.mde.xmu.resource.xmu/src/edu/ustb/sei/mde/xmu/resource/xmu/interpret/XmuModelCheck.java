package edu.ustb.sei.mde.xmu.resource.xmu.interpret;

import java.util.ArrayList;
import java.util.List;

import javax.management.RuntimeErrorException;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;

import edu.ustb.sei.commonutil.util.BidirectionalMap;
import edu.ustb.sei.commonutil.util.Pair;
import edu.ustb.sei.mde.xmu.*;
import edu.ustb.sei.mde.xmu.resource.xmu.analysis.Util;
import edu.ustb.sei.mde.xmu.resource.xmu.interpret.internal.StringConstant;
import edu.ustb.sei.mde.xmu.resource.xmu.interpret.internal.StringPattern;
import edu.ustb.sei.mde.xmu.resource.xmu.interpret.internal.StringPatternElement;
import edu.ustb.sei.mde.xmu.resource.xmu.interpret.internal.StringVariable;

/**
 * Subclasses should be split for put and get respectively
 * @author hexiao
 *
 */
public class XmuModelCheck extends XmuExpressionCheck {
	
	public static XmuModelCheck MODEL_CHECK = new XmuModelCheck();
	
	@Override
	public SafeType interprete_edu_ustb_sei_mde_xmu_SwitchStatement(
			SwitchStatement switchStatement, XmuContext context) {
		for(CaseSubStatement css : switchStatement.getCases()) {//copy context for each iteration and merge at last
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
		return SafeType.getInvalid();
	}


	@Override
	public SafeType interprete_edu_ustb_sei_mde_xmu_Pattern(
			Pattern pattern, XmuContext context) {
		// TODO Auto-generated method stub
		List<XmuContext> smatches = ContextUtil.match(pattern, context);
		if(smatches.size()>0) {
			ContextUtil.merge(context,smatches.get(0));
			return Just.TRUE;
		} else {
			return Just.FALSE;
		}
	}

	@Override
	public SafeType interprete_edu_ustb_sei_mde_xmu_PatternEqualExpr(
			PatternEqualExpr patternEqualExpr, XmuContext context) {
		EObject obj = (EObject) context.getValue(((PatternNode)patternEqualExpr.eContainer()).getVariable());
		
		SafeType val = this.interprete(patternEqualExpr.getValue(), context); 
				
		if( val.isInvalid()) return SafeType.getInvalid();//should allow null value
		EStructuralFeature ref = patternEqualExpr.getFeature();
		
		try {
			if(val.isUndefined()) {
				// val undefined
				SafeType expect = null;
				if(patternEqualExpr.getPos()==null) {
					SafeType v = context.getEnvironment().getFeature(obj, ref);
					expect = v;
				} else {
					SafeType id = this.interprete(patternEqualExpr.getPos(), context);
					if(id.isUndefined() || id.isInvalid() || id.isNull() || id.isInteger()==false)
						return SafeType.getInvalid();
					
					SafeType v = context.getEnvironment().getFeatureAtIndex(obj, ref, id.getIntegerValue());
					if(v.isInvalid()) return SafeType.getInvalid();
					expect = v;
				}
				if(this.enforceAtomicExpr(patternEqualExpr.getValue(), context, expect))
					return Just.TRUE;
				else return SafeType.getInvalid();
			} else {
				if(patternEqualExpr.getPos()==null) {
					if(context.getEnvironment().containFeature(obj, ref, val.getValue())) {
						return Just.TRUE;
					} else return SafeType.getUndefined();
				} else {
					SafeType id = this.interprete(patternEqualExpr.getPos(),context);
					if(id.isUndefined()) {
						int idx = context.getEnvironment().getFeatureIndex(obj, ref, val.getValue());
						if(idx>=0) {
							if(this.enforceAtomicExpr(patternEqualExpr.getPos(), context, SafeType.createFromValue(idx)))
								return Just.TRUE;
							else return Just.FALSE;
							
						} else return SafeType.getInvalid();
					} else {
						if(id.isInvalid() || id.isNull()) 
							return SafeType.getInvalid();
						if(!(id.getValue() instanceof Integer))
							return SafeType.getInvalid();
						
						if(context.getEnvironment().containFeature(obj, ref, (Integer)id.getValue(), val.getValue()))
							return Just.TRUE;
						else return SafeType.getUndefined();
					}
				}
			}
		} catch (Exception e) {
			return SafeType.getUndefined();
		}
	}
	
	protected boolean enforceStringPattern(String expectString, StringPattern pattern, XmuContext context) {
		
		List<StringPatternElement> patternDef = pattern.getPattern();
		int fromIndex = 0;
		StringVariable lastUnsolved = null;
		
		for(int i=0;i<patternDef.size();i++) {
			StringPatternElement elem = patternDef.get(i);
			
			if(elem instanceof StringConstant) {
				int lastCount = 0;
				if(((StringConstant) elem).isFirst()==false) {
					for(int j=i;j<patternDef.size();j++) {
						StringPatternElement spe = patternDef.get(j);
						if(spe instanceof StringConstant) {
							if(((StringConstant) spe).getConstant().equals(((StringConstant) elem).getConstant()))
								lastCount++;
						}
					}
				}
				
				int id = getPosition(expectString,fromIndex,pattern,i,lastCount);
				if(id==-1) return false;// expected string does not match the pattern
				
				if(lastUnsolved==null) {
					if(fromIndex!=id)
						return false;// expected string does not match the pattern
				} else {
					String subStr = expectString.substring(fromIndex, id);
					if(enforceExpr(lastUnsolved.getUndefined(),context,SafeType.createFromValue(subStr))==false) 
						return false;
					lastUnsolved = null;
				}
				fromIndex = id + ((StringConstant) elem).getConstant().length();
			} else if(elem instanceof StringVariable)
				lastUnsolved = (StringVariable) elem;
			else return false;
		}
		
		if(lastUnsolved == null) {
			if(fromIndex!=expectString.length()) 
				return false;
		} else {
			String subStr = expectString.substring(fromIndex);
			if(enforceExpr(lastUnsolved.getUndefined(),context,SafeType.createFromValue(subStr))==false) 
				return false;
		}

		return true;
	}
	
	protected int getPosition(String expectString, int fromIndex, StringPattern pattern, int elemIndex, int lastCount) {
		StringConstant elem = (StringConstant) pattern.getPattern().get(elemIndex);
		
		if(lastCount==0) 
			return expectString.indexOf(elem.getConstant(),fromIndex);
		else {
			int id = 0;
			int endIndex = expectString.length();
			while(lastCount>0) {
				id = expectString.lastIndexOf(elem.getConstant(), endIndex);
				if(id==-1) break;
				endIndex = id;
				lastCount--;
			}
			return id;
		}
	}
	
	protected boolean enforceAdditiveExpr(AdditiveExpr expr, XmuContext context, SafeType expect) {
		// ...+undefined+... = expect
		SafeType headValid = null;
		SafeType tailValid = null;
		
		if(expect.isNull()) {
			return false;
		} else {
			if(expect.isString()) {
				// collect String pattern
				// match pattern
				
				StringPattern pattern = StringPattern.getStringPattern(expr, context);
				if(pattern==null) return false;
				if(enforceStringPattern(expect.getStringValue(), pattern, context)==false) return false;
				else return true;
				
//				int index = 0;
//				int invalidAt = 0;
//				
//				for(;index<expr.getOperands().size();index++) {
//					AdditiveExprChild child = expr.getOperands().get(index);
//					SafeType value = EXPRESSION_CHECK.interprete(child,context);
//					if(value.isUndefined()) {
//						invalidAt = index;
//						break;
//					}
//					if(headValid==null) headValid = value;
//					else {
//						AdditiveOperator op = expr.getOperators().get(index-1);
//						headValid = EvaluationUtil.additive(op, headValid, value);
//					}
//				}
//				
//				index ++;
//				
//				for(;index<expr.getOperands().size();index++) {
//					AdditiveExprChild child = expr.getOperands().get(index);
//					SafeType value = EXPRESSION_CHECK.interprete(child,context);
//					if(tailValid==null) tailValid = value;
//					else {
//						AdditiveOperator op = expr.getOperators().get(index-1);
//						tailValid = EvaluationUtil.additive(op, tailValid, value);
//					}
//				}
//				
//				AdditiveExprChild invalid = expr.getOperands().get(invalidAt);
//				
//				String wholeString = expect.getStringValue();
//				String headString = headValid == null ? null : headValid.getStringValue();
//				String tailString = tailValid == null ? null : tailValid.getStringValue();
//				
//				SafeType realExpect = null;
//				
//				if(headString == null && tailString == null) {
//					return enforceExpr(invalid,context,expect);
//				} else if(headString != null && tailString == null) {
//					if(wholeString.startsWith(headString))
//						realExpect = SafeType.createFromValue(wholeString.substring(headString.length()));
//				} else if(headString == null && tailString != null) {
//					if(wholeString.endsWith(tailString))
//						realExpect = SafeType.createFromValue(wholeString.substring(0,wholeString.length()-tailString.length()));
//				} else if(headString != null && tailString != null) {
//					if(wholeString.startsWith(headString) && wholeString.endsWith(tailString) && wholeString.length()>headString.length()+tailString.length())
//						realExpect = SafeType.createFromValue(wholeString.substring(headString.length(), wholeString.length()-tailString.length()));
//				} else {
//					throw new RuntimeErrorException(null, "Unexpected Control Flow");
//				}
//				
//				if(realExpect == null) return false;
//				return enforceExpr(invalid,context,realExpect);
				
			} else {
				//数值型
				int index = 0;
				int invalidAt = 0;
				
				for(;index<expr.getOperands().size();index++) {
					AdditiveExprChild child = expr.getOperands().get(index);
					SafeType value = EXPRESSION_CHECK.interprete(child,context);
					if(value.isUndefined()) {
						invalidAt = index;
						break;
					}
					if(headValid==null) headValid = value;
					else {
						AdditiveOperator op = expr.getOperators().get(index-1);
						headValid = EvaluationUtil.additive(op, headValid, value);
					}
				}
				
				index ++;
				
				for(;index<expr.getOperands().size();index++) {
					AdditiveExprChild child = expr.getOperands().get(index);
					SafeType value = EXPRESSION_CHECK.interprete(child,context);
					if(tailValid==null) tailValid = value;
					else {
						AdditiveOperator op = expr.getOperators().get(index-1);
						tailValid = EvaluationUtil.additive(op, tailValid, value);
					}
				}
				
				AdditiveExprChild invalid = expr.getOperands().get(invalidAt);
				
				if(headValid==null && tailValid==null) {
					return enforceExpr(invalid,context,expect);
				} else if(headValid==null && tailValid != null) {
					if(tailValid.isString()) return false;
					AdditiveOperator op2 = expr.getOperators().get(invalidAt);
					SafeType realExpect = null;
					if(op2 == AdditiveOperator.ADD) {
						realExpect = EvaluationUtil.additive(AdditiveOperator.SUB, expect, tailValid);
					} else {
						realExpect = EvaluationUtil.additive(AdditiveOperator.ADD, expect, tailValid);
					}
					return enforceExpr(invalid, context, realExpect);
					
				} else if(headValid!=null && tailValid == null) {
					if(headValid.isString()) return false;
					AdditiveOperator op1 = expr.getOperators().get(invalidAt-1);
					SafeType realExpect = null;
					if(op1 == AdditiveOperator.ADD) {
						realExpect = EvaluationUtil.additive(AdditiveOperator.SUB, expect, headValid);
					} else {
						realExpect = EvaluationUtil.additive(AdditiveOperator.SUB, headValid, expect);
					}
					return enforceExpr(invalid, context, realExpect);
				} else {
					if(headValid.isString() || tailValid.isString()) return false;
					AdditiveOperator op1 = expr.getOperators().get(invalidAt-1);
					AdditiveOperator op2 = expr.getOperators().get(invalidAt);
					
					SafeType realExpect = null;
					
					if(op1==AdditiveOperator.ADD && op2==AdditiveOperator.ADD) {
						realExpect = EvaluationUtil.additive(AdditiveOperator.SUB, expect, headValid);
						realExpect = EvaluationUtil.additive(AdditiveOperator.SUB, realExpect, tailValid);
					} else if(op1==AdditiveOperator.ADD && op2==AdditiveOperator.SUB) {
						realExpect = EvaluationUtil.additive(AdditiveOperator.SUB, expect, headValid);
						realExpect = EvaluationUtil.additive(AdditiveOperator.ADD, realExpect, tailValid);
					} else if(op1==AdditiveOperator.SUB && op2==AdditiveOperator.ADD) {
						realExpect = EvaluationUtil.additive(AdditiveOperator.ADD, headValid,tailValid);
						realExpect = EvaluationUtil.additive(AdditiveOperator.SUB, realExpect, expect);
					} else if(op1==AdditiveOperator.SUB && op2==AdditiveOperator.SUB) {
						realExpect = EvaluationUtil.additive(AdditiveOperator.SUB, headValid,tailValid);
						realExpect = EvaluationUtil.additive(AdditiveOperator.SUB, realExpect, expect);
					} else {
						throw new RuntimeErrorException(null, "Unknown additiveOperator");
					}
					
					return enforceExpr(invalid,context,realExpect);
				}
			}
		}
	}
	
	protected boolean enforceAtomicExpr(AtomicExpr invalid,XmuContext context, SafeType expect) {
		if(expect.isInvalid()) return false;
		
		if(invalid instanceof VariableExp) {
			VariableExp exp = (VariableExp)invalid;
			//if(exp.getVar() instanceof ObjectVariable) return false;
			
			if(exp.getPath().isEmpty()) {
				if(context.getSafeTypeValue(exp.getVar()).isUndefined()==false) 
					return false;
				//if(expect.isObject() && context.containValue(expect.getObjectValue())) return false;
				
				return context.putValue(((VariableExp) invalid).getVar(), expect);
			} else {
				// add support for helper mappings
				Object expV = expect.getValue();
				for(int i = exp.getPath().size()-1;i>=0;i--) {
					Path p = exp.getPath().get(i);
					if(p instanceof HelperPath) {
						BidirectionalMap<Object,Object> map = context.getEnvironment().getHelperMappings(((HelperPath) p).getHelper().getName());
						expV = map.backward(expV);
						if(expV==null) 
							return false;
					} else {
						return false;
					}
				}
				
				if(context.getSafeTypeValue(exp.getVar()).isUndefined()==false) 
					return false;
				
				return context.putValue(((VariableExp) invalid).getVar(), SafeType.createFromValue(expV));
			}
		} else if(invalid instanceof ParenExpr) {
			return enforceExpr(((ParenExpr) invalid).getBody(),context,expect);
		}
		return false;
	}
	
	protected boolean enforceUnaryExpr(UnaryExpr invalid, XmuContext context, SafeType expect) {
		if(invalid.getOperator() == UnaryOperator.MINUS) {
			expect = EvaluationUtil.minus(expect);
			return enforceExpr(invalid.getBody(),context,expect);
		} else {
			if(expect==Just.TRUE) {
				return enforceExpr(invalid.getBody(),context, Just.FALSE);
			} else if(expect == Just.FALSE) {
				return enforceExpr(invalid.getBody(),context, Just.TRUE);
			} else return false;
		}
	}
	
//	protected boolean enforceRelationalExpr(RelationalExpr invalid, XmuContext context, SafeType expect) {
//		if(expect.isBoolean()==false) return false;
//		
//		if(invalid.getOperator()==RelationalOperator.EQUAL) {
//			if(expect==Just.FALSE) return false;
//			
//			SafeType left = this.interprete(invalid.getLeft(),context);
//			SafeType right = this.interprete(invalid.getRight(),context);
//			
//			if(left.isUndefined() && right.isUndefined()) return false;
//			else if(left.isUndefined() || right.isUndefined()) {
//				if(left.isUndefined()) {
//					
//				} else {
//					// right.isUndefined()
//				}
//			} else if(left.isInvalid() || right.isInvalid()) {
//				return false;
//			}
//			
//			if((left.isNull() && right.isNull()) || (!left.isNull() && left.getValue().equals(right.getValue())))
//				return true;
//			else {
//				// model check do not change model elements
//				return false;
//			}
//			
//			
//		} else return false;
//	}
	
	
	

	protected boolean enforceExpr(Expr invalid, XmuContext context,
			SafeType expect) {
		if(expect.isInvalid()) return false;
		
		if(invalid instanceof AdditiveExpr) {
			return enforceAdditiveExpr((AdditiveExpr) invalid,context,expect);
		}
		
		if(invalid instanceof AtomicExpr)
			return enforceAtomicExpr((AtomicExpr) invalid,context,expect);
		
		if(invalid instanceof UnaryExpr)
			return enforceUnaryExpr((UnaryExpr)invalid,context,expect);
		
		return false;
	}

	@Override
	public SafeType interprete_edu_ustb_sei_mde_xmu_RelationalExpr(
			RelationalExpr relationalExpr, XmuContext context) {
		if(relationalExpr.getOperator()==RelationalOperator.EQUAL) {
			SafeType left = this.interprete(relationalExpr.getLeft(),context);
			SafeType right = this.interprete(relationalExpr.getRight(),context);
			
			if(left.isUndefined() && right.isUndefined()) return SafeType.getInvalid();
			else if((left.isUndefined() || right.isUndefined())
					||((left.isString() || right.isString()) && (left.isInvalid() || right.isInvalid()))) {
				if(left.isUndefined()) {
					if(enforceExpr(relationalExpr.getLeft(),context,right))
						return Just.TRUE;
					else return SafeType.getInvalid();
				} else {
					if(enforceExpr(relationalExpr.getRight(),context,left))
						return Just.TRUE;
					else return SafeType.getInvalid();
				}
			} else if(left.isInvalid() || right.isInvalid()) {
				return SafeType.getInvalid();
			}
			
			if((left.isNull() && right.isNull()) || (!left.isNull() && left.getValue().equals(right.getValue())))
				return Just.TRUE;
			else {
				// model check do not change model elements
				if(enforceExpr(relationalExpr.getLeft(),context,right))
					return Just.TRUE;
				else if(enforceExpr(relationalExpr.getRight(),context,left))
					return Just.TRUE;
				return Just.FALSE;
			}
		} else 
			return super.interprete_edu_ustb_sei_mde_xmu_RelationalExpr(relationalExpr, context);
	}


	@Override
	public SafeType interprete_edu_ustb_sei_mde_xmu_StartStatement(
			StartStatement startStatement, XmuContext context) {
		// TODO Auto-generated method stub
		
		Rule rule = startStatement.getRule();
		XmuEnvironment env = context.getEnvironment();
		
		XmuContext newContext = new XmuContext(context.getEnvironment());
		newContext.initFromRule(rule);
		
		
		int index = 0;
		
		for(StartRoot root : startStatement.getRoot()) {
			
			List<Resource> col = null;
			
			if(root.getTag()==VariableFlag.SOURCE) col = env.getSources();
			else col = env.getViews();
			
			Resource r = col.get(root.getId());
			
			EResource eRes = XmuFactory.eINSTANCE.createEResource();
			eRes.setResource(r);
			
			if(root.getTag()==VariableFlag.SOURCE) {
				newContext.putValue(rule.getParameters().get(index).getVariable(), SafeType.createFromValue(eRes));
				if(env.isForward()==false) {
					Variable spv = newContext.getVariable(rule.getParameters().get(index).getVariable().getName()+Util.POST_FLAG);
					EResource eResSP = XmuFactory.eINSTANCE.createEResource();
					eResSP.setResource(env.getSourcePosts().get(root.getId()));
					newContext.putValue(spv, SafeType.createFromValue(eResSP));
				}
			} else {
				newContext.putValue(rule.getParameters().get(index).getVariable(), SafeType.createFromValue(eRes));
			}
			
			index++;
		}
		
		return this.interprete(rule.getStatement(), newContext);
	}
	
	

}
