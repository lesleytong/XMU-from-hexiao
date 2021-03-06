package edu.ustb.sei.mde.xmu.resource.xmu.interpret;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;

import edu.ustb.sei.commonutil.util.Pair;
import edu.ustb.sei.mde.xmu.*;
import edu.ustb.sei.mde.xmu.resource.xmu.analysis.Util;

public class XmuModelBackwardEnforce extends XmuModelEnforce {
	
	private VStatement findActionStatement(ForStatement stmt, VStmtType type) {
		VStatement s = null;
		for(VStatement x : stmt.getActions()) {
			if(x.getTag()==type) {
				s = x;
			} else if(x.getTag()==VStmtType.DEFAULT) {
				if(s==null) s = x;
			}
		}
		return s;
	}
	
	
	@Override
	public SafeType interprete_edu_ustb_sei_mde_xmu_ForStatement(
			ForStatement forStatement, XmuContext context) {
		
		XmuContext sbase = context.getCopy();
		XmuContext vbase = context.getCopy();
		
		List<XmuContext> smatches = ContextUtil.match(forStatement.getSPattern(), sbase);
		List<XmuContext> vmatches = ContextUtil.match(forStatement.getVPattern(), vbase);
		List<Pair<XmuContext,XmuContext>> alignment = ContextUtil.align(smatches, vmatches);
		
		SafeType value = null;
		
		List<ObjectVariable> sVars = ContextUtil.collectObjectVariables(forStatement.getSPattern());
		
		for(Pair<XmuContext,XmuContext> p: alignment) {
			XmuContext merge = (ContextUtil.merge(forStatement.getSPattern(), forStatement.getVPattern(), p));

			VStatement vStmt = null;
			VStatement vStmt2 = null;
			
			if(p.getFirst()!=null && p.getSecond()!=null) {
				vStmt = findActionStatement(forStatement,VStmtType.MATCH);
			} else if(p.getFirst()!=null && p.getSecond()==null) {
				vStmt = findActionStatement(forStatement,VStmtType.UNMATCHS);
			} else if(p.getFirst()==null && p.getSecond()!=null) {
				vStmt = findActionStatement(forStatement,VStmtType.UNMATCHV);
//				vStmt2 = findActionStatement(forStatement,VStmtType.MATCH);
			}
			
			if(vStmt!=null) {
				handleUpdateStatements(this.collectRuleCallStatements(vStmt), sVars, merge);
				value = this.interprete(vStmt.getStatement(), merge);
			} else
				throw new RuntimeException("No corresponding action!\n"+merge);

			if(value.isInvalid() || value==Just.FALSE) 
				throw new RuntimeException("model check fails\n"+merge);
			
//			if(vStmt2!=null) {// for unmatchv case
//				handleUpdateStatements(vStmt2.getWhere(), sVars, merge);
//				value = this.interprete(vStmt2.getStatement(), merge);
//				if(value.isInvalid() || value==Just.FALSE) 
//					throw new RuntimeException("model check fails\n"+merge);
//			}
			
			mergeContext(context, merge);
		}
		return Just.TRUE;
	}


	protected void mergeContext(XmuContext outterContext, XmuContext mergeContext) {
		{//write back to parameter
			Rule rule = outterContext.getRule();
			for(Parameter fp : rule.getParameters()) {
				if(fp.getTag()==VariableFlag.SOURCE) {
					Variable v = fp.getVariable();
					Variable vp = outterContext.getVariable(v.getName()+Util.POST_FLAG);
					SafeType val = mergeContext.getSafeTypeValue(vp);
					outterContext.putValue(vp, val);
				} else if(fp.getTag()==VariableFlag.NORMAL) {
					Variable vp = fp.getVariable();
					SafeType val = mergeContext.getSafeTypeValue(vp);
					outterContext.putValue(vp, val);
				}
			}
		}
	}



	protected void handleUpdateStatements(List<RuleCallStatement> updates,
			List<ObjectVariable> sVars, XmuContext context) {
		for(RuleCallStatement u : updates) {
			
			
			SafeType ret = this.trialRuleCall(u, context);
			if(ret.isInvalid()) {
				throw new RuntimeException();
			}
		}
		
		for(ObjectVariable s : sVars) {
			ObjectVariable sp = (ObjectVariable) context.getVariable(s.getName()+Util.POST_FLAG);
			if(context.getSafeTypeValue(sp).isUndefined()) {
				SafeType sv = context.getSafeTypeValue(s);
				if(sv.isNull()) {
					//throw new RuntimeException("Source value is empty, while there is no updatedStatement for it.");
					// this sp should be created
					System.out.println("Source value is empty, while there is no updatedStatement for "+s.getName());
					System.out.println(context);
				} else {
//						EObject spv = merge.getEnvironment().getTrace().getCorresponding(sv.getObjectValue());
					// try to get a direct link
					EObject spv = context.getEnvironment().getTrace().getSourcePost(sv.getObjectValue());
					context.putValue(sp, SafeType.createFromValue(spv));
				}
			}
		}
	}
	
	

//	@Override
//	public SafeType interprete_edu_ustb_sei_mde_xmu_UpdatedStatement(
//			UpdatedStatement updatedStatement, XmuContext context) {
//		
////		SafeType s = context.getSafeTypeValue(updatedStatement.getSVar());
////		SafeType v = context.getSafeTypeValue(updatedStatement.getVVar());
////		
////		if(s.isInvalid() || v.isInvalid()) return SafeType.getInvalid();
////		if(s.isNull() || s.isUndefined()) {
////			if(v.isNull() || v.isUndefined()) {
////				return SafeType.getInvalid();
////			} else {
//////				EObject sp = context.getEnvironment().getTrace().getViewCorresponding(v.getObjectValue());
////				// try to get a full link, where source=null
////				XmuTraceTuple backward = context.getEnvironment().getTrace().getBackward(
////						null, 
////						Collections.singletonList(v.getObjectValue()));
////				if(backward==null || backward.getElements().length==0) return SafeType.getUndefined();
////				Object sp = backward.get(0);
////				if(sp==null) return SafeType.getUndefined();
////				return SafeType.createFromValue(sp);
////			}
////		} else {
//////			EObject sp = context.getEnvironment().getTrace().getCorresponding(s.getObjectValue());
////			XmuTraceTuple backward = context.getEnvironment().getTrace().getBackward(
////					Collections.singletonList(s.getValue()),
////					Collections.singletonList(v.getValue()));
////			
////			if(backward==null || backward.getElements().length==0) return SafeType.getUndefined();
////			
////			Object sp = backward.get(0);
////			
////			if(sp==null) return SafeType.getUndefined();
////			
////			return SafeType.createFromValue(sp);
////		}
//		List<Object> sv = new ArrayList<Object>();
//		List<Object> vv = new ArrayList<Object>();
//		
//		for(Variable var : updatedStatement.getSVar()) {
//			SafeType val = context.getSafeTypeValue(var);
//			if(val.isInvalid() || val.isUndefined()) return SafeType.getInvalid();
//			sv.add(val.getValue());
//		}
//		
//		for(Variable var : updatedStatement.getVVar()) {
//			SafeType val = context.getSafeTypeValue(var);
//			if(val.isInvalid() || val.isUndefined()) return SafeType.getInvalid();
//			vv.add(val.getValue());
//		}
//		
//		XmuTraceTuple spv = context.getEnvironment().getTrace().getBackward(sv, vv);
//		if(spv==null) return SafeType.getUndefined();
//		else {
//			return SafeType.createFromValue(spv.getElements());
//		}
//	}
	
	private SafeType trialRuleCall(RuleCallStatement ruleCallStatement, XmuContext context) {
		List<Object> parameterList = new ArrayList<Object>();
		
		XmuContext newContext = new XmuContext(context.getEnvironment());
		Rule rule = ruleCallStatement.getRule();
		newContext.initFromRule(rule);
		
		int size = rule.getParameters().size();
		
		for(int i=0;i<size;i++) {
			Parameter fp = rule.getParameters().get(i);
			Expr ap = ruleCallStatement.getActualParameters().get(i);
			SafeType value = this.interprete(ap, context);
			if((value.isInvalid() || value.isUndefined())) 
				return Just.FALSE;
			
			newContext.putValue(fp.getVariable(), value);
			
			if(fp.getTag()==VariableFlag.SOURCE) {
				if(!(ap instanceof VariableExp || ap instanceof AllInstanceExpr)) 
					return SafeType.getInvalid(); // you are not allowed to pass a derived value to a source variable
				Variable spV = context.getVariable(((VariableExp)ap).getVar().getName()+Util.POST_FLAG);
				SafeType spValue = context.getSafeTypeValue(spV);
				Variable fspv = newContext.getVariable(fp.getVariable().getName()+Util.POST_FLAG);
				newContext.putValue(fspv, spValue);
			}
			parameterList.add(value.getValue());
		}
		
		XmuTraceTuple ret = context.getEnvironment().getTrace().get(rule, parameterList);
		if(ret!=null) {
			//write back
			for(int i=0,j=0;i<size;i++) {
				Parameter fp = rule.getParameters().get(i);
				Expr ap = ruleCallStatement.getActualParameters().get(i);
				if(fp.getTag()==VariableFlag.SOURCE) {
					Object obj = ret.get(j);
					j++;
					
					Expr ap_sp = context.getEnvironment().getSourcePostExpression(ap);
					if(ap_sp!=null) {
						if(this.enforceExpr(ap_sp, context, SafeType.createFromValue(obj))==false)
							return SafeType.getInvalid();
					}
				}
			}
			
			return Just.TRUE;
			
		} else 
			return Just.FALSE;
	}



	@Override
	public SafeType interprete_edu_ustb_sei_mde_xmu_RuleCallStatement(RuleCallStatement ruleCallStatement,
			XmuContext context) {
		List<Object> parameterList = new ArrayList<Object>();
		
		XmuContext newContext = new XmuContext(context.getEnvironment());
		Rule rule = ruleCallStatement.getRule();
		newContext.initFromRule(rule);
		
		int size = rule.getParameters().size();
		
		for(int i=0;i<size;i++) {
			Parameter fp = rule.getParameters().get(i);
			Expr ap = ruleCallStatement.getActualParameters().get(i);
			SafeType value = this.interprete(ap, context);
			if((value.isInvalid() || value.isUndefined())) 
				return SafeType.getInvalid();
			
			newContext.putValue(fp.getVariable(), value);
			
			if(fp.getTag()==VariableFlag.SOURCE) {
				if(!(ap instanceof VariableExp || ap instanceof AllInstanceExpr)) return SafeType.getInvalid(); // you are not allowed to pass a derived value to a source variable
				Variable spV = context.getVariable(((VariableExp)ap).getVar().getName()+Util.POST_FLAG);
				SafeType spValue = context.getSafeTypeValue(spV);
				Variable fspv = newContext.getVariable(fp.getVariable().getName()+Util.POST_FLAG);
				newContext.putValue(fspv, spValue);
			}
			
			//if(fp.getTag()==VariableFlag.SOURCE || fp.getTag()==VariableFlag.NORMAL) {
				parameterList.add(value.getValue());
			//}
		}
		
		XmuTraceTuple ret = context.getEnvironment().getTrace().get(rule, parameterList);
		if(ret!=null) {
			//write back
			for(int i=0,j=0;i<size;i++) {
				Parameter fp = rule.getParameters().get(i);
				Expr ap = ruleCallStatement.getActualParameters().get(i);
				if(fp.getTag()==VariableFlag.SOURCE) {
					Object obj = ret.get(j);
					j++;
					
					Expr ap_sp = context.getEnvironment().getSourcePostExpression(ap);
					if(ap_sp!=null) {
						if(this.enforceExpr(ap_sp, context, SafeType.createFromValue(obj))==false)
							return SafeType.getInvalid();
					}
				}
			}
			
			return Just.TRUE;
			
		} else {
			SafeType t = this.interprete(rule.getStatement(),newContext);
			if(t.isInvalid() || t==Just.FALSE) 
				return t;
			
			List<Object> viewList = new ArrayList<Object>();
			//write back
			for(int i=0;i<size;i++) {
				Parameter fp = rule.getParameters().get(i);
				Expr ap = ruleCallStatement.getActualParameters().get(i);
				if(fp.getTag()==VariableFlag.SOURCE) {
					Variable sp = newContext.getVariable(fp.getVariable().getName()+Util.POST_FLAG);
					SafeType obj = newContext.getSafeTypeValue(sp);
					Expr ap_sp = context.getEnvironment().getSourcePostExpression(ap);
					if(ap_sp!=null) {
						if(this.enforceExpr(ap_sp, context, obj)==false)
							return SafeType.getInvalid();
					}
					viewList.add(obj.getValue());
				}
			}
			
			//record trace
			context.getEnvironment().getTrace().put(rule, parameterList, viewList);
			return t;
		}
	}



	@Override
	public SafeType interprete_edu_ustb_sei_mde_xmu_DeleteNode(
			DeleteNode deleteNode, XmuContext context) {
		ObjectVariable spv = deleteNode.getVariable();
		SafeType v = context.getSafeTypeValue(spv);
		if(v.isUndefined() || v.isNull()) return Just.TRUE;
		
		
		//ObjectVariable vv = ContextUtil.lookupViewVariable(deleteNode, spv);
		return deleteNode(spv, context);
	}

	protected SafeType deleteNode(ObjectVariable sourcePostVar, XmuContext context) {
		ObjectVariable sv = (ObjectVariable) context.getVariable(sourcePostVar.getName().substring(0,sourcePostVar.getName().length()-Util.POST_LENGTH));
		
		EObject s = context.getSafeTypeValue(sv).getObjectValue();
		EObject sp = context.getSafeTypeValue(sourcePostVar).getObjectValue();
		
		if(s==null || sp == null) return SafeType.getInvalid();
		
		SafeType ret = context.getEnvironment().removeSourcePostElement(s,sp);
		if(ret==Just.TRUE) {
			context.putValue(sourcePostVar, SafeType.getNull());
		}
		return ret;
	}
	
	@Override
	public SafeType interprete_edu_ustb_sei_mde_xmu_DeleteLink(
			DeleteLink deleteLink, XmuContext context) {
		ObjectVariable src = deleteLink.getSource();
		Variable tar = deleteLink.getTarget();
		EStructuralFeature f = deleteLink.getFeature();
		
		EObject sourcePost = context.getSafeTypeValue(src).getObjectValue();
		Object value = context.getSafeTypeValue(tar).getValue();
		
		if(sourcePost == null || value == null) 
			return Just.TRUE;
		if(context.getEnvironment().containFeature(sourcePost, f, value)==false) 
			return Just.TRUE;
		
		SafeType ret = context.getEnvironment().removeFeature(sourcePost, f, value);
		if(ret!=Just.TRUE) return SafeType.getInvalid();
		return Just.TRUE;
	}

	@Override
	public SafeType interprete_edu_ustb_sei_mde_xmu_UpdatePattern(
			UpdatePattern updatePattern, XmuContext context) {
		return this.enforceSourcePostPatternNode(updatePattern.getRoot(), context);
	}
	
	
	
	protected SafeType enforceSourcePostPatternNode(PatternNode node,XmuContext context) {
		String name = node.getVariable().getName();
		ObjectVariable s = (ObjectVariable) context.getVariable(name.substring(0, name.length()-Util.POST_LENGTH));
		
		SafeType sv = s==null ? SafeType.getNull() : context.getSafeTypeValue(s);
		SafeType spv = context.getSafeTypeValue(node.getVariable());
		//SafeType vv = defaultView==null ? SafeType.getNull() : context.getSafeTypeValue(defaultView);
		
		if(spv.isUndefined()) {
//			ObjectVariable view = ContextUtil.lookupViewVariable(node, (ObjectVariable) node.getVariable());
//			SafeType vv = view==null ? SafeType.getNull() : context.getSafeTypeValue(view);
//			
//			EObject o = context.getEnvironment().createSourcePostElement(sv.getObjectValue(),vv.getObjectValue(),node.getType());
//			context.putValue(node.getVariable(), SafeType.createFromValue(o));
			EObject o = context.getEnvironment().createSourcePostElement((ObjectVariable)node.getVariable(),
					node.getType(),node, context);
			context.putValue(node.getVariable(), SafeType.createFromValue(o));

		} else {
			EObject oldValue = spv.getObjectValue();
			if(node.getType().isInstance(oldValue)==false) {
				// delete old
				// create new
				
				if(sv.isNull() || sv.isUndefined() || sv.isInvalid()) {
					// it means that spv is just created from view by unmatchV
					return SafeType.getInvalid();
				}
				
				SafeType ret = context.getEnvironment().removeSourcePostElement(sv.getObjectValue(), oldValue);
				if(ret==Just.TRUE) {
//					ObjectVariable view = ContextUtil.lookupViewVariable(node, (ObjectVariable) node.getVariable());
//					SafeType vv = view==null ? SafeType.getNull() : context.getSafeTypeValue(view);
//					
//					EObject o = context.getEnvironment().createSourcePostElement(sv.getObjectValue(),vv.getObjectValue(),node.getType());
//					
//					context.putValue(node.getVariable(), SafeType.createFromValue(o));	
					EObject o = context.getEnvironment().createSourcePostElement((ObjectVariable)node.getVariable(),
							node.getType(),node, context);
					context.putValue(node.getVariable(), SafeType.createFromValue(o));
				}
				else return ret;
			} else {
				context.getEnvironment().markUsed(oldValue);
			}
		}
		
		//enforce patternExpr
		spv = context.getSafeTypeValue(node.getVariable());
		
		for(PatternExpr expr : node.getExpr()) {
			if(expr instanceof PatternReferenceExpr) {
//				AtomicExpr pos = ((PatternReferenceExpr) expr).getPos();
//				SafeType ret = enforceSourcePostPatternNode(((PatternReferenceExpr) expr).getNode(),context);
//				if(ret==Just.TRUE) {
//					EObject tar = context.getSafeTypeValue(((PatternReferenceExpr) expr).getNode().getVariable()).getObjectValue();
//					
//					if(pos==null) {
//						SafeType v = context.getEnvironment().setFeature(spv.getObjectValue(),((PatternReferenceExpr) expr).getReference(),tar);
//						if(v!=Just.TRUE) 
//							return SafeType.getInvalid();
//					} else {
//						SafeType pv = this.interprete(pos, context);
//						if(pv.isInteger()) {
//							SafeType v = context.getEnvironment().setFeatureAtIndex(spv.getObjectValue(),((PatternReferenceExpr) expr).getReference(),tar,pv.getIntegerValue());
//							if(v!=Just.TRUE) 
//								return SafeType.getInvalid();
//						} else {
//							return SafeType.getInvalid();
//						}
//					}
//				} else return SafeType.getInvalid();
				SafeType ret = enforceSourcePostPatternReferenceExpr((PatternReferenceExpr)expr,spv,context);
				if(ret!=Just.TRUE)
					return SafeType.getInvalid();
			} else if(expr instanceof PatternEqualExpr) {
//				SafeType ret = XmuModelCheck.MODEL_CHECK.interprete_edu_ustb_sei_mde_xmu_PatternEqualExpr((PatternEqualExpr)expr, context);
//				if(ret==SafeType.getUndefined()) {
//					// try to enforce obj.ref
//					// pos==null || pos != invalid
//					AtomicExpr pos = ((PatternEqualExpr) expr).getPos();
//					SafeType val = this.interprete(((PatternEqualExpr) expr).getValue(), context);
//					if(pos==null) {
//						if(val.isUndefined() || val.isInvalid()) {
//							return SafeType.getInvalid();
//						}
//						if(val.isNull()) {
//							// FIX ME: nil list
//							return SafeType.getInvalid();
//						}
//						SafeType r = context.getEnvironment().setFeature(spv.getObjectValue(), ((PatternEqualExpr) expr).getFeature(), val.getValue());
//						if(r!=Just.TRUE)
//							return SafeType.getInvalid();
//					} else {
//						SafeType pv = this.interprete(pos, context);
//						
//						if(val.isUndefined() || val.isInvalid()) {
//							return SafeType.getInvalid();
//						}
//						if(val.isNull()) {
//							// FIX ME: nil list
//							return SafeType.getInvalid();
//						}
//						
//						if(pv.isInteger()) {
//							SafeType v = context.getEnvironment().setFeatureAtIndex(spv.getObjectValue(),((PatternEqualExpr) expr).getFeature(),val.getValue(),pv.getIntegerValue());
//							if(v!=Just.TRUE) 
//								return SafeType.getInvalid();
//						} else {
//							return SafeType.getInvalid();
//						}
//					}
//				}
				Expr value = ((PatternEqualExpr) expr).getValue();
				if(value instanceof VariableExp) {
					Variable v = ((VariableExp) value).getVar();
					if(v instanceof ObjectVariable) {
						EObject o = context.getSafeTypeValue(v).getObjectValue();
						if(o!=null) 
							context.getEnvironment().markUsed(o);
					}
				}
				
				SafeType ret = this.enforcePatternEqualExpr((PatternEqualExpr)expr, spv, context);
				if(ret!=Just.TRUE) return ret;
			}
		}
		return Just.TRUE;
	}
	
	protected SafeType enforceSourcePostPatternReferenceExpr(PatternReferenceExpr expr,SafeType host, XmuContext context) {
		SafeType tarV = context.getSafeTypeValue(expr.getNode().getVariable());
		if(tarV.isUndefined()) {
			if(expr.getReference().isMany()==false) {
				tarV = context.getEnvironment().getFeature(host.getObjectValue(), expr.getReference());
				if(tarV.isNull()) 
					tarV = SafeType.getUndefined();
				else {
					context.putValue(expr.getNode().getVariable(), tarV);
				}
			}
		}
		
		AtomicExpr pos = expr.getPos();
		SafeType ret = enforceSourcePostPatternNode(expr.getNode(),context);
		if(ret==Just.TRUE) {
			EObject tar = context.getSafeTypeValue(expr.getNode().getVariable()).getObjectValue();
			
			if(pos==null) {
				SafeType v = context.getEnvironment().setFeature(host.getObjectValue(),expr.getReference(),tar);
				if(v!=Just.TRUE) 
					return SafeType.getInvalid();
			} else {
				SafeType pv = this.interprete(pos, context);
				if(pv.isInteger()) {
					SafeType v = context.getEnvironment().setFeatureAtIndex(host.getObjectValue(),expr.getReference(),tar,pv.getIntegerValue());
					if(v!=Just.TRUE) 
						return SafeType.getInvalid();
				} else {
					return SafeType.getInvalid();
				}
			}
		} else return SafeType.getInvalid();
		return Just.TRUE;
	}
	
	@Override
	public SafeType interprete_edu_ustb_sei_mde_xmu_InitialMappingStatement(
			InitialMappingStatement initialMappingStatement, XmuContext context) {
//		
//		
//		List<Object> src = new ArrayList<Object>();
////		List<Object> nilSrc = new ArrayList<Object>();
//		
//		for(Expr e : initialMappingStatement.getSource()) {
//			SafeType sv = XmuExpressionCheck.EXPRESSION_CHECK.interprete(e,context);
//			src.add(sv.getValue());
//		}
//		
//		SafeType tv = XmuExpressionCheck.EXPRESSION_CHECK.interprete(initialMappingStatement.getTarget(),context);
//		List<Object> tar = Collections.singletonList(tv.getValue());
//		
//		context.getEnvironment().getTrace().putBackward(src, tar, src);
////		context.getEnvironment().getTrace().putBackward(sources, tar, src);
//		
//		return Just.TRUE;
		throw new UnsupportedOperationException();
	}


	@Override
	public SafeType interprete_edu_ustb_sei_mde_xmu_SwitchStatement(
			SwitchStatement switchStatement, XmuContext context) {
		for(CaseSubStatement css : switchStatement.getCases()) {//copy context for each iteration and merge at last
			if(css instanceof CasePatternStatement) {
				SafeType c = this.interprete_edu_ustb_sei_mde_xmu_Pattern(((CasePatternStatement) css).getPattern(), context);
				if(c.getValue()==Boolean.TRUE) {
					List<ObjectVariable> sVars = ContextUtil.collectObjectVariables(((CasePatternStatement) css).getPattern());
					if(sVars.size()!=0) {
						handleUpdateStatements(this.collectRuleCallStatements(css), sVars, context);
					}
					return this.interprete(css.getStatement(), context);
				}
			} else if(css instanceof CaseValueStatement) {
				SafeType c = this.interprete(((CaseValueStatement) css).getExpression(), context);
				if(c.getValue()==Boolean.TRUE)
					return this.interprete(css.getStatement(), context);
			}
		}
		return SafeType.getInvalid();
	}
	
	
}
