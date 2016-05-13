package edu.ustb.sei.mde.xmu.resource.xmu.interpret;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.UniqueEList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;

import edu.ustb.sei.commonutil.util.Pair;
import edu.ustb.sei.mde.xmu.*;
import edu.ustb.sei.mde.xmu.resource.xmu.analysis.Util;
import edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuRule;

public class ContextUtil {
	static public List<Pair<XmuContext,XmuContext>> align(List<XmuContext> srcMatches,List<XmuContext> tarMatches) {
		List<Pair<XmuContext,XmuContext>> alignment = new ArrayList<Pair<XmuContext,XmuContext>>();
		
		if(tarMatches==null) {
			Iterator<XmuContext> sit = srcMatches.iterator();
			while(sit.hasNext()) {
				XmuContext s = sit.next();
				alignment.add(new Pair<XmuContext,XmuContext>(s,s));
			}
		} else {
			Iterator<XmuContext> sit = null;//srcMatches.iterator();
			Iterator<XmuContext> tit = tarMatches.iterator();
			
			while(tit.hasNext()) {
				XmuContext t = tit.next();
				sit = srcMatches.iterator();
				boolean aligned = false;
				
				while(sit.hasNext()) {
					XmuContext s = sit.next();
					if(tryAlign(s,t)) {
						alignment.add(new Pair<XmuContext,XmuContext>(s,t));
						sit.remove();
						tit.remove();
						aligned = true;
						break;
					}
				}
				
				if(!aligned) {
					alignment.add(new Pair<XmuContext,XmuContext>(null, t));
				}
			}
			
			sit = srcMatches.iterator();
			while(sit.hasNext()) {
				alignment.add(new Pair<XmuContext,XmuContext>(sit.next(),null));
			}
			
//			tit = tarMatches.iterator();
//			while(tit.hasNext()) {
//				alignment.add(new Pair<XmuContext,XmuContext>(null, tit.next()));
//			}
		}
		
		
		return alignment;
	}
	
	static private boolean tryAlign(XmuContext s, XmuContext t) {
		HashMap<Variable,SafeType> smap = s.getBindings();
		HashMap<Variable,SafeType> tmap = t.getBindings();
		
		for(Entry<Variable,SafeType> e : smap.entrySet()) {
			SafeType sv = e.getValue();
			SafeType tv = tmap.get(e.getKey());
			if(sv.getValue()==tv.getValue()) continue;
			if((sv.isNull() || tv.isNull())&&sv.getValue()!=tv.getValue()) return false;
			if(sv.isUndefined()==false && tv.isUndefined()==false && sv.getValue().equals(tv.getValue())==false) 
				return false;
		}
		
		return true;
	}
	
	static public XmuContext merge(Pattern s, Pattern t, Pair<XmuContext, XmuContext> pair) {
		if(t==null) return pair.getFirst();
		
		XmuContext nc = null;
		if(pair.getFirst()!=null) nc = pair.getFirst().getCopy();
		else nc = pair.getSecond().getCopy();
		
		if(pair.getFirst()==null) {
			//nc is created by second.copy
			nilPattern(s,nc);
		} else {
			// nc is created by first.copy
			if(pair.getSecond()==null) {
				nilPattern(t,nc);
			} else {
				for(Entry<Variable,SafeType> e : pair.getSecond().getBindings().entrySet()) {
					if(nc.getSafeTypeValue(e.getKey()).isUndefined())
						nc.putValue(e.getKey(),e.getValue());
				}
			}			
		}
		return nc;
		
	}

	static private void nilPattern(Pattern s, XmuContext nc) {
		List<Variable> vars = collectVariables(s);
		for(Variable v : vars) {
			if(nc.getSafeTypeValue(v).isUndefined())
				nc.putValue(v, SafeType.getNull());
		}
	}

	static private List<Variable> collectVariables(Pattern s) {
		
		List<Variable> vars = new UniqueEList<Variable>();
		collectVariables(s.getRoot(),vars);
		return vars;
	}
	
	static public List<ObjectVariable> collectObjectVariables(Pattern pattern) {
		List<ObjectVariable> list = new ArrayList<ObjectVariable>();
		collectObjectVariables(pattern.getRoot(), list);
		return list;
	}
	
	static private void collectObjectVariables(PatternNode node, List<ObjectVariable> list) {
		list.add((ObjectVariable) (node.getVariable()));
		for(PatternExpr expr : node.getExpr()) {
			if(expr instanceof PatternReferenceExpr) {
				collectObjectVariables(((PatternReferenceExpr) expr).getNode(),list);
			} else if(expr instanceof PatternEqualExpr) {
				AtomicExpr value = ((PatternEqualExpr) expr).getValue();
				if(value instanceof VariableExp) {
					if(((VariableExp) value).getVar() instanceof ObjectVariable && ((VariableExp) value).getPath().isEmpty())
						list.add((ObjectVariable) (((VariableExp) value).getVar()));
				}
			}
		}
	}
	
	static private void collectVariables(EObject root, List<Variable> vars) {
		if(root instanceof PatternNode) {
			vars.add(((PatternNode) root).getVariable());
			for(PatternExpr e : ((PatternNode) root).getExpr()) 
				collectVariables(e,vars);
		} else if(root instanceof PatternExpr) {
			if(root instanceof PatternReferenceExpr) {
				collectVariables(((PatternReferenceExpr) root).getPos(),vars);
				collectVariables(((PatternReferenceExpr) root).getNode(), vars);
			} else if(root instanceof PatternEqualExpr){
				collectVariables(((PatternEqualExpr) root).getPos(),vars);
				collectVariables(((PatternEqualExpr) root).getValue(), vars);
			}
		} else if(root instanceof AtomicExpr) {
			if(root instanceof ParenExpr) {
				collectVariables(((ParenExpr) root).getBody(), vars);
			} else if(root instanceof VariableExp) {
				vars.add(((VariableExp) root).getVar());
			}
		} else if(root instanceof BooleanOrExpr) {
			for(BooleanOrExprChild c : ((BooleanOrExpr) root).getOperands())
				collectVariables(c, vars);
		} else if(root instanceof BooleanAndExpr) {
			for(BooleanAndExprChild c : ((BooleanAndExpr) root).getOperands())
				collectVariables(c, vars);
		} else if(root instanceof RelationalExpr) {
			collectVariables(((RelationalExpr) root).getLeft(),vars);
			collectVariables(((RelationalExpr) root).getRight(),vars);
		} else if(root instanceof AdditiveExpr) {
			for(AdditiveExprChild c : ((AdditiveExpr) root).getOperands()) {
				collectVariables(c,vars);
			}
		} else if(root instanceof MultiplicativeExpr) {
			for(MultiplicativeExprChild c : ((MultiplicativeExpr) root).getOperands()) {
				collectVariables(c,vars);
			}
		} else if(root instanceof UnaryExpr) {
			collectVariables(((UnaryExpr) root).getBody(), vars);
		}
	}
	
//	static private XmuContext resetPatternVariable(Pattern pattern, XmuContext base) {
//		
//	}
//	
//	static private List<Variable> collectResettablePatternVariable(Pattern pattern) {
//		if(pattern.getTag()!=VariableFlag.SOURCE) { // we can only reset source patterns
//			return Collections.EMPTY_LIST;
//		} else {
//			List<Variable> allVariables = new ArrayList<Variable>();
//			TreeIterator<EObject> it = pattern.eAllContents();
//			Rule rule = Util.getRule(pattern);
//			while(it.hasNext()) {
//				EObject o = it.next();
//				if(rule.getSVars().contains(o)) {
//					allVariables.add((Variable) o);
//				}
//			}
//			
//			VStatement vStmt = Util.getParentNodeByJavaType(pattern, VStatement.class);
//			if(vStmt==null 
//				|| vStmt.getTag()!=VStmtType.UNMATCHV) 
//				return Collections.EMPTY_LIST;
//			
//			ForStatement forStmt = (ForStatement) vStmt.eContainer();
//			it = forStmt.getSPattern().eAllContents();
//			
//			List<Variable> parentVariables = new ArrayList<Variable>();
//			
//			while(it.hasNext()) {
//				EObject o = it.next();
//				if(rule.getSVars().contains(o)) {
//					parentVariables.add((Variable) o);
//				}
//			}
//			
//			allVariables.retainAll(parentVariables);
//			allVariables
//			
//		}
//	}

	static public List<XmuContext> match(Pattern pattern, XmuContext base) {
		if(pattern==null) return null;
		SafeType v = base.getSafeTypeValue(pattern.getRoot().getVariable());
		List<XmuContext> contexts = matchNode(pattern.getRoot(),base);
		List<XmuContext> result = new ArrayList<XmuContext>();
		for(XmuContext c : contexts) {
			SafeType r = pattern.getGuard()==null ? Just.TRUE : XmuModelCheck.MODEL_CHECK.interprete(pattern.getGuard(), c);
			if(r==Just.TRUE) {
				result.add(c);
			} else {
				System.out.println("guard:"+r);
			}
		}
		return result;	
	}
	
	static protected List<XmuContext> matchNodeOnce(PatternNode node, XmuContext base) {
		SafeType obj = base.getSafeTypeValue(node.getVariable());
		
		if(obj.isUndefined() || obj.isNull()) {
			return Collections.emptyList();
		} else {
			if(node.getType().isInstance(obj.getValue())==false) 
				return Collections.emptyList();
			
			List<XmuContext> cur = null;
			List<XmuContext> res = Collections.singletonList(base);
			
			for(PatternExpr expr : node.getExpr()) {
				cur = res;
				res = new ArrayList<XmuContext>();
				
				for(XmuContext current : cur) {
					if(expr instanceof PatternReferenceExpr) {
						AtomicExpr pos = ((PatternReferenceExpr) expr).getPos();
						EReference ref = ((PatternReferenceExpr) expr).getReference();
						PatternNode next = ((PatternReferenceExpr) expr).getNode();
						SafeType nValue = current.getSafeTypeValue(next.getVariable());
						List<Object> candidate = current.getEnvironment().getFeatureAsCollection(obj.getObjectValue(), ref);
						
						if(pos==null) {
							if(nValue.isUndefined()) {
								for(int i = 0;i<candidate.size();i++) {
									XmuContext nc = current.getCopy();
									nc.putValue(next.getVariable(), SafeType.createFromValue((EObject)candidate.get(i)));
									res.add(nc);
								}
							} else {
								// set pos
								int id = candidate.indexOf(nValue.getValue());
								if(id==-1) continue;
								else {
									res.add(current);
								}
							}
						} else {
							SafeType posV = XmuExpressionCheck.EXPRESSION_CHECK.interprete(pos, current);
							if(posV.isInvalid() || posV.isNull()) continue; // invalid position
							else if(posV.isUndefined()) {
								if(nValue.isUndefined()) {
									for(int i = 0;i<candidate.size();i++) {
										XmuContext nc = current.getCopy();
										nc.putValue(next.getVariable(), SafeType.createFromValue((EObject)candidate.get(i)));
										if(XmuModelCheck.MODEL_CHECK.enforceAtomicExpr(pos, nc, SafeType.createFromValue(i))){
											res.add(current);
										} else continue;
									}

								} else {
									// set pos
									int id = candidate.indexOf(nValue.getValue());
									if(id==-1) continue;
									else {
										if(XmuModelCheck.MODEL_CHECK.enforceAtomicExpr(pos, current, SafeType.createFromValue(id))){
											res.add(current);
										} else continue;// cannot enforce pos
									}
								}
								
							} else if(posV.isInteger()) {
								if(candidate.size()<posV.getIntegerValue() && posV.getIntegerValue()>=0){
									EObject cValue = (EObject)candidate.get(posV.getIntegerValue());
									if(nValue.isUndefined()) {
										current.putValue(next.getVariable(), SafeType.createFromValue(cValue));
										res.add(current);
									} else {
										if(nValue.getValue()==cValue)
											res.add(current);
										else continue;
									}
								} else continue;//out of bound
							} else {
								System.out.println("posV is not an integer");
								continue;
							}
						}
					} else {
						//pattern Equal
						AtomicExpr pos = ((PatternEqualExpr)expr).getPos();
						AtomicExpr right = ((PatternEqualExpr)expr).getValue();
						EStructuralFeature feature = ((PatternEqualExpr)expr).getFeature();
						
						SafeType nValue = XmuExpressionCheck.EXPRESSION_CHECK.interprete(right, current);
						List<Object> candidate = current.getEnvironment().getFeatureAsCollection(obj.getObjectValue(), feature);
						
						if(pos==null) {
							if(nValue.isUndefined()) {
								for(int i = 0;i<candidate.size();i++) {
									XmuContext nc = current.getCopy();
									if(XmuModelCheck.MODEL_CHECK.enforceAtomicExpr(right, nc, SafeType.createFromValue(((EObject)candidate.get(i)))))
										res.add(nc);
									else continue;
								}
							} else {
								// set pos
								int id = candidate.indexOf(nValue.getValue());
								if(id==-1) continue;
								else {
									res.add(current);
								}
							}
						} else {
							SafeType posV = XmuExpressionCheck.EXPRESSION_CHECK.interprete(pos, current);
							if(posV.isInvalid() || posV.isNull()) continue; // invalid position
							else if(posV.isUndefined()) {
								if(nValue.isUndefined()) {
									for(int i = 0;i<candidate.size();i++) {
										XmuContext nc = current.getCopy();
										if(XmuModelCheck.MODEL_CHECK.enforceAtomicExpr(right, nc, SafeType.createFromValue(((EObject)candidate.get(i))))) {
											if(XmuModelCheck.MODEL_CHECK.enforceAtomicExpr(pos, nc, SafeType.createFromValue(i))){
												res.add(current);
											} else continue;
										} else continue;
										if(XmuModelCheck.MODEL_CHECK.enforceAtomicExpr(pos, nc, SafeType.createFromValue(i))){
											res.add(current);
										} else continue;
									}

								} else {
									// set pos
									int id = candidate.indexOf(nValue.getValue());
									if(id==-1) continue;
									else {
										if(XmuModelCheck.MODEL_CHECK.enforceAtomicExpr(pos, current, SafeType.createFromValue(id))){
											res.add(current);
										} else continue;// cannot enforce pos
									}
								}
								
							} else if(posV.isInteger()) {
								if(candidate.size()<posV.getIntegerValue() && posV.getIntegerValue()>=0){
									EObject cValue = (EObject)candidate.get(posV.getIntegerValue());
									if(nValue.isUndefined()) {
										if(XmuModelCheck.MODEL_CHECK.enforceAtomicExpr(right, current, SafeType.createFromValue(cValue))) {
											res.add(current);
										} else continue;
									} else {
										if(nValue.getValue()==cValue)
											res.add(current);
										else continue;
									}
								} else continue;//out of bound
							} else {
								System.out.println("posV is not an integer");
								continue;
							}
						}
					}
				}
			}
			
			return res;
		}		
	}
	
	static protected List<XmuContext> matchNode(PatternNode node, XmuContext base) {
		SafeType obj = base.getSafeTypeValue(node.getVariable());
		
		if(obj.isUndefined() || obj.isNull()) {
			return Collections.emptyList();
		} else {
			if(node.getType().isInstance(obj.getValue())==false) 
				return Collections.emptyList();
			
			List<XmuContext> cur = null;
			List<XmuContext> res = Collections.singletonList(base);
			
			for(PatternExpr expr : node.getExpr()) {
				cur = res;
				res = new ArrayList<XmuContext>();
				
				for(XmuContext current : cur) {
					if(expr instanceof PatternReferenceExpr) {
						AtomicExpr pos = ((PatternReferenceExpr) expr).getPos();
						EReference ref = ((PatternReferenceExpr) expr).getReference();
						PatternNode next = ((PatternReferenceExpr) expr).getNode();
						SafeType nValue = current.getSafeTypeValue(next.getVariable());
						List<Object> candidate = current.getEnvironment().getFeatureAsCollection(obj.getObjectValue(), ref);
						
						if(pos==null) {
							if(nValue.isUndefined()) {
								for(int i = 0;i<candidate.size();i++) {
									XmuContext nc = current.getCopy();
									EObject v = (EObject)candidate.get(i);
									//if(nc.containValue(v)) continue;
									nc.putValue(next.getVariable(), SafeType.createFromValue(v));
									res.addAll(matchNode(next,nc));
								}
							} else {
								// set pos
								int id = candidate.indexOf(nValue.getValue());
								if(id==-1) continue;
								else {
									res.addAll(matchNode(next,current));
								}
							}
						} else {
							SafeType posV = XmuExpressionCheck.EXPRESSION_CHECK.interprete(pos, current);
							if(posV.isInvalid() || posV.isNull()) continue; // invalid position
							else if(posV.isUndefined()) {
								if(nValue.isUndefined()) {
									for(int i = 0;i<candidate.size();i++) {
										XmuContext nc = current.getCopy();
										EObject v = (EObject)candidate.get(i);
										nc.putValue(next.getVariable(), SafeType.createFromValue(v));
										if(XmuModelCheck.MODEL_CHECK.enforceAtomicExpr(pos, nc, SafeType.createFromValue(i))){
											res.addAll(matchNode(next,current));
										} else continue;
									}

								} else {
									// set pos
									int id = candidate.indexOf(nValue.getValue());
									if(id==-1) continue;
									else {
										if(XmuModelCheck.MODEL_CHECK.enforceAtomicExpr(pos, current, SafeType.createFromValue(id))){
											res.addAll(matchNode(next,current));
										} else continue;// cannot enforce pos
									}
								}
								
							} else if(posV.isInteger()) {
								if(candidate.size()>posV.getIntegerValue() && posV.getIntegerValue()>=0){
									EObject cValue = (EObject)candidate.get(posV.getIntegerValue());
									if(nValue.isUndefined()) {
										//if(current.containValue(cValue)) continue;
										current.putValue(next.getVariable(), SafeType.createFromValue(cValue));
										res.addAll(matchNode(next,current));
									} else {
										if(nValue.getValue()==cValue)
											res.addAll(matchNode(next,current));
										else continue;
									}
								} else continue;//out of bound
							} else {
								System.out.println("posV is not an integer");
								continue;
							}
						}
					} else {
						//pattern Equal
						AtomicExpr pos = ((PatternEqualExpr)expr).getPos();
						AtomicExpr right = ((PatternEqualExpr)expr).getValue();
						EStructuralFeature feature = ((PatternEqualExpr)expr).getFeature();
						// NOTE ME
						SafeType nValue = XmuExpressionCheck.EXPRESSION_CHECK.interprete(right, current);
						List<Object> candidate = current.getEnvironment().getFeatureAsCollection(obj.getObjectValue(), feature);
						
						if(pos==null) {
							if(nValue.isUndefined() || (nValue.isValue() == false && feature.getEType()==EcorePackage.eINSTANCE.getEString())) {
								if(candidate.size()!=0) {
									for(int i = 0;i<candidate.size();i++) {
										XmuContext nc = current.getCopy();
										if(XmuModelCheck.MODEL_CHECK.enforceAtomicExpr(right, nc, SafeType.createFromValue((candidate.get(i)))))
											res.add(nc);
										else continue;
									}
								} else {
									XmuContext nc = current.getCopy();
									if(feature.isMany()==false) {
										if(XmuModelCheck.MODEL_CHECK.enforceAtomicExpr(right, nc, SafeType.getNull()))
											res.add(nc);
									}
								}
							} else {
								// set pos
								int id = candidate.indexOf(nValue.getValue());
								if(id==-1) continue;
								else {
									res.add(current);
								}
							}
						} else {
							SafeType posV = XmuExpressionCheck.EXPRESSION_CHECK.interprete(pos, current);
							if(posV.isInvalid() || posV.isNull()) continue; // invalid position
							else if(posV.isUndefined()) {
								if(nValue.isUndefined()) {
									for(int i = 0;i<candidate.size();i++) {
										XmuContext nc = current.getCopy();
										if(XmuModelCheck.MODEL_CHECK.enforceAtomicExpr(right, nc, SafeType.createFromValue((candidate.get(i))))) {
											if(XmuModelCheck.MODEL_CHECK.enforceAtomicExpr(pos, nc, SafeType.createFromValue(i))){
												res.add(nc);
											} else continue;
										} else continue;
//										if(XmuModelCheck.MODEL_CHECK.enforceAtomicExpr(pos, nc, SafeType.createFromValue(i))){
//											res.add(nc);
//										} else continue;
									}

								} else {
									// set pos
									int id = candidate.indexOf(nValue.getValue());
									if(id==-1) continue;
									else {
										if(XmuModelCheck.MODEL_CHECK.enforceAtomicExpr(pos, current, SafeType.createFromValue(id))){
											res.add(current);
										} else continue;// cannot enforce pos
									}
								}
								
							} else if(posV.isInteger()) {
								if(candidate.size()>posV.getIntegerValue() && posV.getIntegerValue()>=0){
									Object cValue = candidate.get(posV.getIntegerValue());
									if(nValue.isUndefined()) {
										if(XmuModelCheck.MODEL_CHECK.enforceAtomicExpr(right, current, SafeType.createFromValue(cValue))) {
											res.add(current);
										} else continue;
									} else {
										if(cValue.equals(nValue.getValue()))
											res.add(current);
										else continue;
									}
								} else continue;//out of bound
							} else {
								System.out.println("posV is not an integer");
								continue;
							}
						}
					}
				}
			}
			
			return res;
		}		
	}
	
//	static public List<RuleCallStatement> lookupUpdatedStatementsFromSourcePost(EObject o, ObjectVariable sourcePost) {
//		List<RuleCallStatement> result = new ArrayList<RuleCallStatement>();
//		lookupUpdatedStatementsFromSourcePost(o,sourcePost,result);
//		//if(result.size()==0) return null;
//		return result;
//	}
	
//	static private void lookupUpdatedStatementsFromSourcePost(EObject o, ObjectVariable sourcePost, List<RuleCallStatement> result) {
//		if(o==null) return;
//		if(o instanceof VStatement) {
//			for(RuleCallStatement u : ((VStatement) o).getWhere()) {
//				if(isCorrelated(u,sourcePost)) {
//					result.add(u);
//				}
//			}
//		} else if(o instanceof CaseSubStatement) {
//			for(RuleCallStatement u : ((CaseSubStatement) o).getWhere()) {
//				if(isCorrelated(u,sourcePost)) {
//					result.add(u);
//				}
//			}
//		} 
//		lookupUpdatedStatementsFromSourcePost(o.eContainer(),sourcePost,result);
//	}
	
	static public boolean isCorrelated(RuleCallStatement rc, Variable sp) {
		for(Expr p : rc.getActualParameters()) {
			if(p instanceof VariableExp) {
				if(((VariableExp) p).getPath().size()==0) {
					String sn = ((VariableExp) p).getVar().getName();
					if(sp.getName().startsWith(sn) && sp.getName().length() == sn.length()+Util.POST_LENGTH) 
						return true;
				}
			}
		}
		return false;
	}
	
//	static public boolean isCorrelated(List<Variable> slist, Variable sp) {
//		for(Variable s : slist) {
//			if(sp.getName().startsWith(s.getName()) && sp.getName().length() == s.getName().length()+Util.POST_LENGTH) 
//				return true;			
//		}
//		return false;
//	}
	
//	static public List<UpdatedStatement> lookupUpdatedStatementsFromView(EObject o, Variable view) {
//		List<UpdatedStatement> result = new ArrayList<UpdatedStatement>();
//		lookupUpdatedStatementsFromView(o,view,result);
//		//if(result.size()==0) return null;
//		return result;
//	}
	
//	static private void lookupUpdatedStatementsFromView(EObject o, Variable view,List<UpdatedStatement> result) {
//		if(o==null) return;
//		if(o instanceof ForStatement) {
//			for(UpdatedStatement u : ((ForStatement) o).getWhen()) {
//				if(u.getVVar().contains(view)) {
//					result.add(u);
//				}
//			}
//			
////			if(((ForStatement) o).getVPattern()!=null) {
////				if(((ForStatement) o).getVPattern().getRoot().getVariable()==view) {
////					return (ObjectVariable) ((ForStatement) o).getSPattern().getRoot().getVariable();
////				}
////			}
//		} else if(o instanceof SwitchStatement) {
//			for(UpdatedStatement u : ((SwitchStatement) o).getWhen()) {
//				if(u.getVVar()==view) {
//					result.add(u);
//				}
//			}
//		} else if(o instanceof Rule) {
////			boolean flag = false;
////			
////			for(Parameter p : ((Rule) o).getParameters()) {
////				if(p.getTag()==VariableFlag.VIEW)
////					if(p.getVariable()==view) {
////						flag = true;
////						break;
////					}
////			}
////			
////			if(flag) {
////				for(Parameter p : ((Rule) o).getParameters()) {
////					if(p.getTag()==VariableFlag.SOURCE)
////						return (ObjectVariable) p.getVariable();
////				}
////			}
//		}
//		
//		lookupUpdatedStatementsFromView(o.eContainer(),view,result);
//	}
	
//	static public ObjectVariable lookupViewVariable(EObject o, ObjectVariable sourcePost) {
//		if(o==null) return null;
//		if(o instanceof ForStatement) {
//			for(UpdatedStatement u : ((ForStatement) o).getWhen()) {
//				if(isCorrelated(u.getSVar(),sourcePost)) {
//					return u.getVVar();
//				}
//			}
//			
////			if(isCorrelated(((ForStatement) o).getSPattern().getRoot().getVariable(),sourcePost)) {
////				return (ObjectVariable) ((ForStatement) o).getVPattern().getRoot();
////			}
//		} else if(o instanceof SwitchStatement) {
//			for(UpdatedStatement u : ((SwitchStatement) o).getWhen()) {
//				if(isCorrelated(u.getSVar(),sourcePost)) {
//					return u.getVVar();
//				}
//			}
//		} else if(o instanceof Rule) {
////			boolean flag = false;
////			
////			for(Parameter p : ((Rule) o).getParameters()) {
////				if(p.getTag()==VariableFlag.SOURCE)
////					if(isCorrelated(p.getVariable(),sourcePost)) {
////						flag = true;
////						break;
////					}
////			}
////			
////			if(flag) {
////				for(Parameter p : ((Rule) o).getParameters()) {
////					if(p.getTag()==VariableFlag.VIEW)
////						return (ObjectVariable) p.getVariable();
////				}
////			}
//		}
//		
//		return lookupViewVariable(o.eContainer(),sourcePost);
//	}
	
//	static public Variable lookupSourceVariable(EObject o, ObjectVariable view) {
//		if(o==null) return null;
//		if(o instanceof ForStatement) {
//			for(UpdatedStatement u : ((ForStatement) o).getWhen()) {
//				if(u.getVVar()==view) {
//					return u.getSVar();
//				}
//			}
//			
//			if(((ForStatement) o).getVPattern()!=null) {
//				if(((ForStatement) o).getVPattern().getRoot().getVariable()==view) {
//					return (ObjectVariable) ((ForStatement) o).getSPattern().getRoot().getVariable();
//				}
//			}
//		} else if(o instanceof SwitchStatement) {
//			for(UpdatedStatement u : ((SwitchStatement) o).getWhen()) {
//				if(u.getVVar()==view) {
//					return u.getSVar();
//				}
//			}
//		} else if(o instanceof Rule) {
//			boolean flag = false;
//			
//			for(Parameter p : ((Rule) o).getParameters()) {
//				if(p.getTag()==VariableFlag.VIEW)
//					if(p.getVariable()==view) {
//						flag = true;
//						break;
//					}
//			}
//			
//			if(flag) {
//				for(Parameter p : ((Rule) o).getParameters()) {
//					if(p.getTag()==VariableFlag.SOURCE)
//						return (ObjectVariable) p.getVariable();
//				}
//			}
//		}
//		
//		return lookupSourceVariable(o.eContainer(),view);
//	}
	
//	static public boolean isCorrelated(Variable s, Variable sp) {
//		return sp.getName().startsWith(s.getName()) && sp.getName().length() == s.getName().length()+5;
//	}

	public static void merge(XmuContext context, XmuContext xmuContext) {
		
		for(Entry<Variable,SafeType> e : context.getBindings().entrySet()) {
			SafeType v = xmuContext.getSafeTypeValue(e.getKey());
			if(e.getValue().isUndefined() && !v.isUndefined()) {
				e.setValue(v);
			}
		}
	}

//	static public ObjectVariable getDefaultView(EObject o) {
//		if(o==null) return null;
//		
//		if(o instanceof ForStatement) {
//			return (ObjectVariable) ((ForStatement) o).getVPattern().getRoot().getVariable();
//		} else if(o instanceof SwitchStatement) {
//			if(((SwitchStatement) o).getTag()==VariableFlag.VIEW) {
//				return (ObjectVariable) ((SwitchStatement) o).getVar();
//			}
//		} else if(o instanceof Rule) {
//			for(Parameter p : ((Rule) o).getParameters()) {
//				if(p.getTag()==VariableFlag.VIEW)
//					return (ObjectVariable) p.getVariable();
//			}
//		}
//		return getDefaultView(o.eContainer());
//	}

}
