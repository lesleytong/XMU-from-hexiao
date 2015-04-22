package edu.ustb.sei.mde.xmu.resource.xmu.interpret;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;

import edu.ustb.sei.mde.xmu.*;
import edu.ustb.sei.mde.xmu.resource.xmu.util.AbstractXmuInterpreter;


public class XmuModelForwardEnforce extends XmuModelEnforce {

	@Override
	public SafeType interprete_edu_ustb_sei_mde_xmu_DeleteNode(
			DeleteNode deleteNode, XmuContext context) {
		Variable v = deleteNode.getVariable();
		SafeType value = context.getSafeTypeValue(v);
		if(value.isUndefined() || value.isNull()) {
			context.putValue(v, SafeType.getUndefined());//should it be null?
			return Just.TRUE;
		} else {
			System.out.println("trying to delete a non-empty variable");
			return Just.FALSE;
		}
	}

	@Override
	public SafeType interprete_edu_ustb_sei_mde_xmu_DeleteLink(
			DeleteLink deleteLink, XmuContext context) {
		ObjectVariable s = deleteLink.getSource();
		Variable t = deleteLink.getTarget();
		EStructuralFeature f = deleteLink.getFeature();
		
		EObject so = context.getSafeTypeValue(s).getObjectValue();
		Object to = context.getSafeTypeValue(t).getValue();
		
		if(so==null || to == null) return Just.TRUE;
		
		if(context.getEnvironment().containFeature(so, f, to))
			return Just.FALSE;
		return Just.TRUE;
	}

	@Override
	public SafeType interprete_edu_ustb_sei_mde_xmu_UpdatedStatement(
			UpdatedStatement updatedStatement, XmuContext context) {
		SafeType s = context.getSafeTypeValue(updatedStatement.getSVar());
		SafeType v = context.getSafeTypeValue(updatedStatement.getVVar());
		
		if(v.isUndefined() || v.isInvalid() || v.isNull()) {
			if(s.isUndefined() || s.isInvalid() || s.isNull()) return SafeType.getInvalid();
			EObject cv = context.getEnvironment().getTrace().getCorresponding(s.getObjectValue());
			if(cv==null) return SafeType.getInvalid();
			return SafeType.createFromValue(cv);
		} else 
			return v;
	}

	@Override
	public SafeType interprete_edu_ustb_sei_mde_xmu_ForStatement(
			ForStatement forStatement, XmuContext context) {
		List<XmuContext> smatches = ContextUtil.match(forStatement.getSPattern(), context);
		
		for(XmuContext c : smatches) {
			for(UpdatedStatement u : forStatement.getWhen()) {
				SafeType ret = this.interprete(u, c);
				if(ret.isInvalid()==false && ret.isObject()) {
					c.putValue(u.getVVar(), ret);
				}
			}
			List<PatternExpr> pending = new ArrayList<PatternExpr>();
			
			SafeType ret = Just.TRUE; 
			
			if(forStatement.getVPattern()!=null) 
				ret = this.enforcePattern(forStatement.getVPattern(), c,pending);
			
			if(ret==Just.TRUE) {
				// do matches
				boolean flag = false;
				SafeType value = null;
				
				boolean start = this.startRuleCallPending();
				for(VStatement stmt : forStatement.getActions()) {
					if(stmt.getTag() == VStmtType.MATCH) {
						value =  this.interprete(stmt.getStatement(), c);
						flag = true;
						break;
					}
				}
				List<RuleCallStatement> rcPending = null;
				if(start) 
					rcPending = this.closeRuleCallPending();
				
				if(flag==false) 
					throw new RuntimeException("No corresponding action!");
				else {
					if(value.isInvalid() || value==Just.FALSE) 
						throw new RuntimeException("model check fails");
					else {
						for(PatternExpr p : pending) {
							SafeType host = c.getSafeTypeValue(((PatternNode)(p.eContainer())).getVariable());
							if(host.isUndefined()) 
								throw new RuntimeException("host is undefined in pending");
							
							if(p instanceof PatternReferenceExpr) {
								ret = this.enforceViewPatternReferenceExpr((PatternReferenceExpr)p, host, c, null);
								if(ret!=Just.TRUE) return SafeType.getInvalid();
							} else if(p instanceof PatternEqualExpr) {
								ret = this.enforcePatternEqualExpr((PatternEqualExpr)p, host, c);
								if(ret!=Just.TRUE) return SafeType.getInvalid();
							}
						}
						
						if(start) {
							for(RuleCallStatement rc : rcPending) {
								ret = this.interprete_edu_ustb_sei_mde_xmu_RuleCallStatement(rc, c);
								if(ret!=Just.TRUE) return SafeType.getInvalid();
							}
						}
					}
				}
			}
		}
		
		return Just.TRUE;
		
	}

	@Override
	public SafeType interprete_edu_ustb_sei_mde_xmu_SwitchStatement(
			SwitchStatement switchStatement, XmuContext context) {
		if(switchStatement.getTag()==VariableFlag.SOURCE || switchStatement.getTag()==VariableFlag.SOURCE_POST || switchStatement.getTag()==VariableFlag.NORMAL) {
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
			return SafeType.getInvalid();
		} else {
			//
			for(CaseSubStatement css : switchStatement.getCases()) {
				XmuContext nc = context.getCopy();
				if(css instanceof CasePatternStatement) {
					boolean start = this.startRuleCallPending();
					SafeType c = this.interprete(css.getStatement(), nc);
					List<RuleCallStatement> pending = null;
					if(start) 
						pending = this.closeRuleCallPending();
					
					if(c.getValue()==Boolean.TRUE) {
						ContextUtil.merge(context, nc);
						SafeType ret = this.enforcePattern(((CasePatternStatement) css).getPattern(),context,null);
						if(ret==Just.TRUE) {
							if(start){
								for(RuleCallStatement rc : pending) {
									ret = this.interprete_edu_ustb_sei_mde_xmu_RuleCallStatement(rc, context);
									if(ret==Just.TRUE) continue;
									return ret;
								}
							}
							return Just.TRUE;
						}
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
	
	protected List<RuleCallStatement> ruleCallPending = null;
	
	protected boolean startRuleCallPending() {
		if(ruleCallPending==null) {
			ruleCallPending = new ArrayList<RuleCallStatement>();
			return true;
		}
		return false;
	}
	
	protected List<RuleCallStatement> closeRuleCallPending() {
		List<RuleCallStatement> ret = ruleCallPending;
		ruleCallPending = null;
		return ret;
	}

	protected SafeType enforcePattern(Pattern pattern,
			XmuContext context,List<PatternExpr> pending) {
		// TODO Auto-generated method stub
		if(pattern.getTag()!=VariableFlag.VIEW) return SafeType.getInvalid();
		
		SafeType ret = enforceViewPatternNode(pattern.getRoot(),context,pending);
		
		
		return ret;
	}
	
	

	protected SafeType enforceViewPatternNode(PatternNode node,XmuContext context, List<PatternExpr> pending) {
		//String name = node.getVariable();
		//ObjectVariable s = (ObjectVariable) context.getVariable(name.substring(0, name.length()-5));
		
		SafeType vv = context.getSafeTypeValue(node.getVariable());
		//SafeType spv = context.getSafeTypeValue(node.getVariable());
		//SafeType vv = defaultView==null ? SafeType.getNull() : context.getSafeTypeValue(defaultView);
		ObjectVariable source = ContextUtil.lookupSourceVariable(node, (ObjectVariable) (node.getVariable()));
		SafeType sv = source==null ? SafeType.getNull() : context.getSafeTypeValue(source);
		
		if(vv.isUndefined()) {
			EObject o = context.getEnvironment().createViewElement(sv.getObjectValue(),node.getType());
			if(o==null) {
				//pending
			} else {
				context.putValue(node.getVariable(), SafeType.createFromValue(o));
			}
		} else {
			EObject oldValue = vv.getObjectValue();
			if(node.getType().isInstance(oldValue)==false) {
				//can we replace it with new value?
				return SafeType.getInvalid();
			}
		}
		
		//enforce patternExpr
		vv = context.getSafeTypeValue(node.getVariable());
		
		for(PatternExpr expr : node.getExpr()) {
			if(expr instanceof PatternReferenceExpr) {
				if(vv.isUndefined()) {
					if(pending==null) return SafeType.getInvalid();
					pending.add(expr);
					SafeType ret = enforceViewPatternNode(((PatternReferenceExpr) expr).getNode(),context,pending);
					if(ret==SafeType.getInvalid()) return ret;
				} else {
//					AtomicExpr pos = ((PatternReferenceExpr) expr).getPos();
//					SafeType ret = enforceViewPatternNode(((PatternReferenceExpr) expr).getNode(),context,pending);
//					if(ret==Just.TRUE) {
//						EObject tar = context.getSafeTypeValue(((PatternReferenceExpr) expr).getNode().getVariable()).getObjectValue();
//						
//						if(pos==null) {
//							SafeType v = context.getEnvironment().setFeature(vv.getObjectValue(),((PatternReferenceExpr) expr).getReference(),tar);
//							if(v!=Just.TRUE) 
//								return SafeType.getInvalid();
//						} else {
//							SafeType pv = this.interprete(pos, context);
//							if(pv.isInteger()) {
//								SafeType v = context.getEnvironment().setFeatureAtIndex(vv.getObjectValue(),((PatternReferenceExpr) expr).getReference(),tar,pv.getIntegerValue());
//								if(v!=Just.TRUE) 
//									return SafeType.getInvalid();
//							} else {
//								return SafeType.getInvalid();
//							}
//						}
//					} else return SafeType.getInvalid();
					SafeType ret = enforceViewPatternReferenceExpr((PatternReferenceExpr)expr,vv,context,pending);
					if(ret!=Just.TRUE)
						return ret;
				}
				
			} else if(expr instanceof PatternEqualExpr) {
				if(vv.isUndefined()) {
					if(pending==null) return SafeType.getInvalid();
					pending.add(expr);
				} else {
//					SafeType ret = XmuModelCheck.MODEL_CHECK.interprete_edu_ustb_sei_mde_xmu_PatternEqualExpr((PatternEqualExpr)expr, context);
//					if(ret==SafeType.getUndefined()) {
//						// try to enforce obj.ref
//						// pos==null || pos != invalid
//						AtomicExpr pos = ((PatternEqualExpr) expr).getPos();
//						SafeType val = this.interprete(((PatternEqualExpr) expr).getValue(), context);
//						if(pos==null) {
//							if(val.isUndefined() || val.isInvalid()) {
//								return SafeType.getInvalid();
//							}
//							if(val.isNull()) {
//								// FIX ME: nil list
//								return SafeType.getInvalid();
//							}
//							SafeType r = context.getEnvironment().setFeature(vv.getObjectValue(), ((PatternEqualExpr) expr).getFeature(), val.getValue());
//							if(r==Just.TRUE) return Just.TRUE;
//							return SafeType.getInvalid();
//						} else {
//							SafeType pv = this.interprete(pos, context);
//							
//							if(val.isUndefined() || val.isInvalid()) {
//								return SafeType.getInvalid();
//							}
//							if(val.isNull()) {
//								// FIX ME: nil list
//								return SafeType.getInvalid();
//							}
//							
//							if(pv.isInteger()) {
//								SafeType v = context.getEnvironment().setFeatureAtIndex(vv.getObjectValue(),((PatternEqualExpr) expr).getFeature(),val.getValue(),pv.getIntegerValue());
//								if(v!=Just.TRUE) 
//									return SafeType.getInvalid();
//							} else {
//								return SafeType.getInvalid();
//							}
//						}
//					}
					
					Expr right = ((PatternEqualExpr) expr).getValue();
					if(right instanceof VariableExp 
//							&& ((VariableExp)right).getVar() instanceof ObjectVariable
							) {
						if(context.getSafeTypeValue(((VariableExp)right).getVar()).isUndefined()) {
							if(pending==null) return SafeType.getInvalid();
							pending.add(expr);
						} else {
							SafeType ret = this.enforcePatternEqualExpr((PatternEqualExpr)expr, vv, context);
							if(ret!=Just.TRUE)
								return ret;
						}
					} else {
						SafeType ret = this.enforcePatternEqualExpr((PatternEqualExpr)expr, vv, context);
						if(ret!=Just.TRUE)
							return ret;						
					}
					
					
				}
			}
		}
		return Just.TRUE;
	}
	
	
	
	@Override
	public SafeType interprete_edu_ustb_sei_mde_xmu_RuleCallStatement(
			RuleCallStatement ruleCallStatement, XmuContext context) {
		if(ruleCallPending!=null) {
			ruleCallPending.add(ruleCallStatement);
			return Just.TRUE;//maybe unknown
		} else {
			return super.interprete_edu_ustb_sei_mde_xmu_RuleCallStatement(
					ruleCallStatement, context);			
		}
	}

	protected SafeType enforceViewPatternReferenceExpr(PatternReferenceExpr expr,SafeType host, XmuContext context, List<PatternExpr> pending) {
		
		SafeType tar = context.getSafeTypeValue(expr.getNode().getVariable());
		if(tar.isUndefined()) {
			if(expr.getReference().isMany()==false) {
				tar = context.getEnvironment().getFeature(host.getObjectValue(), expr.getReference());
				if(tar.isNull()) 
					tar = SafeType.getUndefined();
				else {
					context.putValue(expr.getNode().getVariable(), tar);
				}
			}
		}
		SafeType ret = enforceViewPatternNode(expr.getNode(),context,pending);
		if(ret==SafeType.getInvalid()) return ret;
		
		tar = context.getSafeTypeValue(expr.getNode().getVariable());
		
		if(tar.isUndefined()) {			
			if(pending==null) 
				return SafeType.getUndefined();
			pending.add(expr);				
		} else {
			AtomicExpr pos = expr.getPos();
			if(ret==Just.TRUE) {
				if(pos==null) {
					SafeType v = context.getEnvironment().setFeature(host.getObjectValue(),expr.getReference(),tar.getObjectValue());
					if(v!=Just.TRUE) 
						return SafeType.getInvalid();
				} else {
					SafeType pv = this.interprete(pos, context);
					if(pv.isInteger()) {
						SafeType v = context.getEnvironment().setFeatureAtIndex(host.getObjectValue(),expr.getReference(),tar.getObjectValue(),pv.getIntegerValue());
						if(v!=Just.TRUE) 
							return SafeType.getInvalid();
					} else {
						return SafeType.getInvalid();
					}
				}
			} else return SafeType.getInvalid();
		}
		return Just.TRUE;		
	}
	
	
}
