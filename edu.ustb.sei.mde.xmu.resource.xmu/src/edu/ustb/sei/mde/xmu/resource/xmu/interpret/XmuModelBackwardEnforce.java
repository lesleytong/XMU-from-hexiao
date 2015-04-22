package edu.ustb.sei.mde.xmu.resource.xmu.interpret;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;

import edu.ustb.sei.commonutil.util.Pair;
import edu.ustb.sei.mde.xmu.*;
import edu.ustb.sei.mde.xmu.resource.xmu.analysis.Util;

public class XmuModelBackwardEnforce extends XmuModelEnforce {
	@Override
	public SafeType interprete_edu_ustb_sei_mde_xmu_ForStatement(
			ForStatement forStatement, XmuContext context) {
		// TODO Auto-generated method stub
		XmuContext sbase = context.getCopy();
		XmuContext vbase = context.getCopy();
		
		List<XmuContext> smatches = ContextUtil.match(forStatement.getSPattern(), sbase);
		List<XmuContext> vmatches = ContextUtil.match(forStatement.getVPattern(), vbase);
		List<Pair<XmuContext,XmuContext>> alignment = ContextUtil.align(smatches, vmatches);
		
		boolean flag = false;
		SafeType value = null;
		
		List<ObjectVariable> sVars = ContextUtil.collectObjectVariables(forStatement.getSPattern());
		
		for(Pair<XmuContext,XmuContext> p: alignment) {
			XmuContext merge = (ContextUtil.merge(forStatement.getSPattern(), forStatement.getVPattern(), p));
			
			for(UpdatedStatement u : forStatement.getWhen()) {
				SafeType ret = this.interprete(u, merge);
				if(ret.isInvalid()==false && ret.isObject()) {
					merge.putValue(merge.getVariable(u.getSVar().getName()+Util.POST_FLAG), ret);
				}
			}
			
			for(ObjectVariable s : sVars) {
				ObjectVariable sp = (ObjectVariable) merge.getVariable(s.getName()+Util.POST_FLAG);
				if(merge.getSafeTypeValue(sp).isUndefined()) {
					SafeType sv = merge.getSafeTypeValue(s);
					if(sv.isNull()) {
						//throw new RuntimeException("Source value is empty, while there is no updatedStatement for it.");
						// this sp should be created
						System.out.println("Source value is empty, while there is no updatedStatement for it.");
						System.out.println(merge);
					} else {
						EObject spv = merge.getEnvironment().getTrace().getCorresponding(sv.getObjectValue());
						merge.putValue(sp, SafeType.createFromValue(spv));
					}
				}
			}
			
			flag = false;
			
			if(p.getFirst()!=null && p.getSecond()!=null) {
				for(VStatement stmt : forStatement.getActions()) {
					if(stmt.getTag() == VStmtType.MATCH) {
						value = this.interprete(stmt.getStatement(), merge);
						flag = true;
					}
				}
			} else if(p.getFirst()!=null && p.getSecond()==null) {
				for(VStatement stmt : forStatement.getActions()) {
					if(stmt.getTag() == VStmtType.UNMATCHS) {
						value = this.interprete(stmt.getStatement(), merge);
						flag = true;
					}
				}
			} else if(p.getFirst()==null && p.getSecond()!=null) {
				for(VStatement stmt : forStatement.getActions()) {
					if(stmt.getTag() == VStmtType.UNMATCHV) {
						value = this.interprete(stmt.getStatement(), merge);
						flag = true;
					}
				}
			}
			
			if(flag==false) 
				throw new RuntimeException("No corresponding action!\n"+merge);
			else {
				if(value.isInvalid() || value==Just.FALSE) 
					throw new RuntimeException("model check fails\n"+merge);
			}
		}
		return Just.TRUE;
	}
	
	

	@Override
	public SafeType interprete_edu_ustb_sei_mde_xmu_UpdatedStatement(
			UpdatedStatement updatedStatement, XmuContext context) {
		// TODO Auto-generated method stub
		SafeType s = context.getSafeTypeValue(updatedStatement.getSVar());
		SafeType v = context.getSafeTypeValue(updatedStatement.getVVar());
		
		if(s.isInvalid() || v.isInvalid()) return SafeType.getInvalid();
		if(s.isNull() || s.isUndefined()) {
			if(v.isNull() || v.isUndefined()) {
				return SafeType.getInvalid();
			} else {
				EObject sp = context.getEnvironment().getTrace().getViewCorresponding(v.getObjectValue());
				if(sp==null) return SafeType.getUndefined();
				return SafeType.createFromValue(sp);
			}
		} else {
			EObject sp = context.getEnvironment().getTrace().getCorresponding(s.getObjectValue());
			if(sp==null) return SafeType.getUndefined();
			return SafeType.createFromValue(sp);
		}
	}



	@Override
	public SafeType interprete_edu_ustb_sei_mde_xmu_DeleteNode(
			DeleteNode deleteNode, XmuContext context) {
		ObjectVariable spv = deleteNode.getVariable();
		SafeType v = context.getSafeTypeValue(spv);
		if(v.isUndefined() || v.isNull()) return Just.TRUE;
		ObjectVariable vv = ContextUtil.lookupViewVariable(deleteNode, spv);
		return deleteNode(spv, vv, context);
	}

	protected SafeType deleteNode(
			ObjectVariable sourcePostVar, ObjectVariable defaultView,
			XmuContext context) {
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
			ObjectVariable view = ContextUtil.lookupViewVariable(node, (ObjectVariable) node.getVariable());
			SafeType vv = view==null ? SafeType.getNull() : context.getSafeTypeValue(view);
			
			EObject o = context.getEnvironment().createSourcePostElement(sv.getObjectValue(),vv.getObjectValue(),node.getType());
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
					ObjectVariable view = ContextUtil.lookupViewVariable(node, (ObjectVariable) node.getVariable());
					SafeType vv = view==null ? SafeType.getNull() : context.getSafeTypeValue(view);
					
					EObject o = context.getEnvironment().createSourcePostElement(sv.getObjectValue(),vv.getObjectValue(),node.getType());
					
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
}
