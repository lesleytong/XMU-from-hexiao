package edu.ustb.sei.mde.xmu2.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

import org.eclipse.emf.common.util.UniqueEList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

import edu.ustb.sei.commonutil.util.Pair;
import edu.ustb.sei.mde.xmu2.runtime.executor.AbstractInterpreter;
import edu.ustb.sei.mde.xmu2.runtime.structures.Context;
import edu.ustb.sei.mde.xmu2.runtime.values.SafeType;
import edu.ustb.sei.mde.xmu2common.PositionOperator;
import edu.ustb.sei.mde.xmu2core.AdditiveExpression;
import edu.ustb.sei.mde.xmu2core.AtomicExpression;
import edu.ustb.sei.mde.xmu2core.BooleanAndExpression;
import edu.ustb.sei.mde.xmu2core.BooleanOrExpression;
import edu.ustb.sei.mde.xmu2core.Expression;
import edu.ustb.sei.mde.xmu2core.LoopPath;
import edu.ustb.sei.mde.xmu2core.MultiplicativeExpression;
import edu.ustb.sei.mde.xmu2core.ObjectPatternExpression;
import edu.ustb.sei.mde.xmu2core.Pattern;
import edu.ustb.sei.mde.xmu2core.PatternExpression;
import edu.ustb.sei.mde.xmu2core.PatternNode;
import edu.ustb.sei.mde.xmu2core.PositionPath;
import edu.ustb.sei.mde.xmu2core.PropertyPatternExpression;
import edu.ustb.sei.mde.xmu2core.RelationalExpression;
import edu.ustb.sei.mde.xmu2core.UnaryExpression;
import edu.ustb.sei.mde.xmu2core.Variable;
import edu.ustb.sei.mde.xmu2core.VariableExpression;

@SuppressWarnings("unchecked")
public final class ContextUtil {
	static public List<Context> match(Pattern pattern, Context base) {
		if (pattern == null)
			return null;
		List<Context> contexts = matchNode(pattern.getRoot(), base);
		List<Context> result = new ArrayList<Context>();
		for (Context c : contexts) {
			try {
				SafeType r = pattern.getGuard() == null ? Constants.TRUE
						: AbstractInterpreter.MODEL_CHECK.executeExpression(pattern.getGuard(), c);
				if (r == Constants.TRUE) {
					result.add(c);
				}
			} catch (Exception e) {
			}
		}
		return result;
	}

	private static List<Context> matchNode(PatternNode node, Context base) {
		SafeType obj = base.get(node.getVariable());

		if (obj.isUndefined() || obj.isNull()) {
			return Collections.emptyList();
		} else {
			if (node.getType().isSuperTypeOf(obj.getObjectValue().eClass()) == false)
				return Collections.emptyList();

			List<Context> cur = null;
			List<Context> res = Collections.singletonList(base);

			for (PatternExpression expr : node.getExpressions()) {
				cur = res;
				res = new ArrayList<Context>();

				for (Context current : cur) {
					if (expr instanceof ObjectPatternExpression) {
						try {
							EStructuralFeature feature = expr.getFeature();
							PatternNode next = ((ObjectPatternExpression) expr).getTarget();
							PositionPath pos = expr.getPosition();
							LoopPath sel = expr.getSelector();

							SafeType nValue = current.get(next.getVariable());
							List<Object> candidate = current.getEnvironment()
									.getFeatureAsInternalCollection(obj.getObjectValue(), feature);

							if (sel != null) {
								candidate = (List<Object>) AbstractInterpreter.EXPRESSION_CHECK
										.handleLoopPath(candidate, sel, current).getValue();
							}

							if (pos == null) {
								if (nValue.isUndefined()) {
									for (int i = 0; i < candidate.size(); i++) {
										try{
											EObject v = (EObject) candidate.get(i);
											if(((EClass)next.getVariable().getType()).isSuperTypeOf(v.eClass())) {
												Context nc = current.clone();
												nc.put(next.getVariable(), SafeType.createFromValue(v));
												res.addAll(matchNode(next, nc));
											}
										} catch(Exception e){
										}
									}
								} else {
									int id = candidate.indexOf(nValue.getValue());
									if (id == -1)
										continue;
									else {
										res.addAll(matchNode(next, current));
									}
								}
							} else {
								SafeType posV = AbstractInterpreter.EXPRESSION_CHECK.calculatePositionPath(pos,
										current);
								if (posV.isNull())
									continue; // invalid position
								else if (posV.isUndefined()) {
									if (nValue.isUndefined()) {
										for (int i = 0; i < candidate.size(); i++) {
											try {
												Context nc = current.clone();
												EObject v = (EObject) candidate.get(i);
												nc.put(next.getVariable(), SafeType.createFromValue(v));
												if (AbstractInterpreter.MODEL_CHECK.enforceExpression(pos.getValue(), nc,
														SafeType.createFromValue(i))) {
													res.addAll(matchNode(next, current));
												} else
													continue;
											} catch(Exception e) {
											}
										}
									} else {
										// set pos
										int id = candidate.indexOf(nValue.getValue());
										if (id == -1)
											continue;
										else {
											if (AbstractInterpreter.MODEL_CHECK.enforceExpression(pos.getValue(),
													current, SafeType.createFromValue(id))) {
												res.addAll(matchNode(next, current));
											} else
												continue;// cannot enforce pos
										}
									}

								} else if (posV.isInteger()) {
									if (posV.getIntegerValue() == -1)
										posV = SafeType.createFromValue(candidate.size() - 1);

									if (candidate.size() > posV.getIntegerValue() && posV.getIntegerValue() >= 0) {
										EObject cValue = (EObject) candidate.get(posV.getIntegerValue());
										if (nValue.isUndefined()) {
											current.put(next.getVariable(), SafeType.createFromValue(cValue));
											res.addAll(matchNode(next, current));
										} else {
											if (nValue.getValue() == cValue)
												res.addAll(matchNode(next, current));
											else
												continue;
										}
									} else
										continue;// out of bound
								} else {
									continue;
								}
							}
						} catch (Exception e) {
						}
					} else {
						// pattern Equal
						try {
							EStructuralFeature feature = expr.getFeature();
							PositionPath pos  = expr.getPosition();
							LoopPath sel = expr.getSelector();
							Expression right = ((PropertyPatternExpression)expr).getTarget();
							// NOTE ME
							SafeType nValue = null;
							try {
								nValue = AbstractInterpreter.EXPRESSION_CHECK.executeExpression(right, current);
							} catch (Exception e) {
								if(AnalysisUtil.isType(feature.getEType(), String.class))
									nValue = SafeType.UNDEFINED; //String may be enforced
								else 
									continue;
							}
							
							List<Object> candidate = current.getEnvironment().
									getFeatureAsInternalCollection(obj.getObjectValue(),feature);

							if (sel != null) {
								candidate = (List<Object>) AbstractInterpreter.EXPRESSION_CHECK
										.handleLoopPath(candidate, sel, current).getValue();
							}
							
							if (pos == null) {
								if (nValue.isUndefined()) {
									if (candidate.size() != 0) {
										for (int i = 0; i < candidate.size(); i++) {
											try {
												Context nc = current.clone();
												if (AbstractInterpreter.MODEL_CHECK.enforceExpression(right, nc,
														SafeType.createFromValue((candidate.get(i)))))
													res.add(nc);
												else
													continue;
											} catch(Exception e){
											}
										}
									} else {
										Context nc = current.clone();
										if (feature.isMany() == false) {
											if (AbstractInterpreter.MODEL_CHECK.enforceExpression(right, nc, SafeType.NULL))
												res.add(nc);
										}
									}
								} else {
									int id = candidate.indexOf(nValue.getValue());
									if (id == -1)
										continue;
									else {
										res.add(current);
									}
								}
							} else {
								SafeType posV = AbstractInterpreter.EXPRESSION_CHECK.calculatePositionPath(pos, current);
								if (posV.isNull())
									continue; // invalid position
								else if (posV.isUndefined()) {
									if (nValue.isUndefined()) {
										for (int i = 0; i < candidate.size(); i++) {
											try {
												Context nc = current.clone();
												if (AbstractInterpreter.MODEL_CHECK.enforceExpression(right, nc,
														SafeType.createFromValue((candidate.get(i))))) {
													if (AbstractInterpreter.MODEL_CHECK.enforceExpression(pos.getValue(), nc,
															SafeType.createFromValue(i))) {
														res.add(nc);
													} else
														continue;
												} else
													continue;
											} catch(Exception e) {
											}
										}

									} else {
										// set pos
										int id = candidate.indexOf(nValue.getValue());
										if (id == -1)
											continue;
										else {
											if (AbstractInterpreter.MODEL_CHECK.enforceExpression(pos.getValue(), current,
													SafeType.createFromValue(id))) {
												res.add(current);
											} else
												continue;// cannot enforce pos
										}
									}

								} else if (posV.isInteger()) {
									if(posV.getIntegerValue()==-1)
										posV = SafeType.createFromValue(candidate.size()-1);
									
									if (candidate.size() > posV.getIntegerValue() && posV.getIntegerValue() >= 0) {
										Object cValue = candidate.get(posV.getIntegerValue());
										if (nValue.isUndefined()) {
											if (AbstractInterpreter.MODEL_CHECK.enforceExpression(right, current,
													SafeType.createFromValue(cValue))) {
												res.add(current);
											} else
												continue;
										} else {
											if (cValue.equals(nValue.getValue()))
												res.add(current);
											else
												continue;
										}
									} else
										continue;// out of bound
								} else {
									System.out.println("posV is not an integer");
									continue;
								}
							}
						} catch (Exception e) {
						}
					}
				}
			}

			return res;
		}
	}

	public static void merge(Context host, Context delta) {
		for(Entry<Variable,SafeType> e : host) {
			SafeType v = delta.get(e.getKey());
			if(e.getValue().isUndefined() && !v.isUndefined()) {
				e.setValue(v);
			}
		}
	}
	
	static public Context merge(Pattern s, Pattern t, Pair<Context, Context> pair) {
		if(t==null) return pair.getFirst();
		
		Context nc = null;
		if(pair.getFirst()!=null) nc = pair.getFirst().clone();
		else nc = pair.getSecond().clone();
		
		if(pair.getFirst()==null) {
			//nc is created by second.copy
			nilPattern(s,nc);
		} else {
			// nc is created by first.copy
			if(pair.getSecond()==null) {
				nilPattern(t,nc);
			} else {
				for(Entry<Variable,SafeType> e : pair.getSecond()) {
					if(nc.get(e.getKey()).isUndefined())
						nc.put(e.getKey(),e.getValue());
				}
			}			
		}
		return nc;
		
	}

	static private void nilPattern(Pattern s, Context nc) {
		List<Variable> vars = collectVariables(s);
		for(Variable v : vars) {
			if(nc.get(v).isUndefined())
				nc.put(v, SafeType.NULL);
		}
	}
	
	static private List<Variable> collectVariables(Pattern s) {
		// TODO Auto-generated method stub
		List<Variable> vars = new UniqueEList<Variable>();
		collectVariables(s.getRoot(),vars);
		return vars;
	}
	
	static public List<Variable> collectPatternVariables(Pattern pattern) {
		List<Variable> list = new ArrayList<Variable>();
		collectObjectVariables(pattern.getRoot(), list);
		return list;
	}
	
	static private void collectObjectVariables(PatternNode node, List<Variable> list) {
		list.add((Variable) (node.getVariable()));
		for(PatternExpression expr : node.getExpressions()) {
			if(expr instanceof ObjectPatternExpression) {
				collectObjectVariables(((ObjectPatternExpression) expr).getTarget(),list);
			} else if(expr instanceof PropertyPatternExpression) {
				Expression value = ((PropertyPatternExpression) expr).getTarget();
				if(value instanceof VariableExpression) {
					if(((VariableExpression) value).getVariable().getType() instanceof EClass 
							&& ((VariableExpression) value).getPaths().isEmpty())
						list.add((((VariableExpression) value).getVariable()));
				}
			}
		}
	}
	
	static private void collectVariables(EObject root, List<Variable> vars) {
		if(root == null) return ;
		else if(root instanceof PatternNode) {
			vars.add(((PatternNode) root).getVariable());
			for(PatternExpression e : ((PatternNode) root).getExpressions()) 
				collectVariables(e,vars);
		} else if(root instanceof PatternExpression) {
			if(root instanceof ObjectPatternExpression) {
				collectVariables(((ObjectPatternExpression) root).getPosition(),vars);
				collectVariables(((ObjectPatternExpression) root).getTarget(), vars);
			} else if(root instanceof PropertyPatternExpression){
				collectVariables(((PropertyPatternExpression) root).getPosition(),vars);
				collectVariables(((PropertyPatternExpression) root).getTarget(), vars);
			}
		} else if(root instanceof AtomicExpression) {
//			if(root instanceof ParenExpression) {
//				collectVariables(((ParenExpression) root).getBody(), vars);
//			} else 
				if(root instanceof VariableExpression) {
				vars.add(((VariableExpression) root).getVariable());
			}
		} else if(root instanceof BooleanOrExpression) {
			for(Expression c : ((BooleanOrExpression) root).getOperands())
				collectVariables(c, vars);
		} else if(root instanceof BooleanAndExpression) {
			for(Expression c : ((BooleanAndExpression) root).getOperands())
				collectVariables(c, vars);
		} else if(root instanceof RelationalExpression) {
			collectVariables(((RelationalExpression) root).getLeft(),vars);
			collectVariables(((RelationalExpression) root).getRight(),vars);
		} else if(root instanceof AdditiveExpression) {
			for(Expression c : ((AdditiveExpression) root).getOperands()) {
				collectVariables(c,vars);
			}
		} else if(root instanceof MultiplicativeExpression) {
			for(Expression c : ((MultiplicativeExpression) root).getOperands()) {
				collectVariables(c,vars);
			}
		} else if(root instanceof UnaryExpression) {
			collectVariables(((UnaryExpression) root).getBody(), vars);
		} else  if(root instanceof PositionPath) {
			if(((PositionPath) root).getOperator()==PositionOperator.AT)
				collectVariables(((PositionPath) root).getValue(), vars);
		}
	}
	
	static public List<Pair<Context,Context>> align(List<Context> srcMatches,List<Context> tarMatches) {
		List<Pair<Context,Context>> alignment = new ArrayList<Pair<Context,Context>>();
		
		if(tarMatches==null) {
			Iterator<Context> sit = srcMatches.iterator();
			while(sit.hasNext()) {
				Context s = sit.next();
				alignment.add(new Pair<Context,Context>(s,s));
			}
		} else {
			Iterator<Context> sit = null;//srcMatches.iterator();
			Iterator<Context> tit = tarMatches.iterator();
			
			while(tit.hasNext()) {
				Context t = tit.next();
				sit = srcMatches.iterator();
				boolean aligned = false;
				
				while(sit.hasNext()) {
					Context s = sit.next();
					if(tryAlign(s,t)) {
						alignment.add(new Pair<Context,Context>(s,t));
						sit.remove();
						tit.remove();
						aligned = true;
						break;
					}
				}
				
				if(!aligned) {
					alignment.add(new Pair<Context,Context>(null, t));
				}
			}
			
			sit = srcMatches.iterator();
			while(sit.hasNext()) {
				alignment.add(new Pair<Context,Context>(sit.next(),null));
			}
			
//			tit = tarMatches.iterator();
//			while(tit.hasNext()) {
//				alignment.add(new Pair<Context,Context>(null, tit.next()));
//			}
		}
		
		
		return alignment;
	}
	
	static private boolean tryAlign(Context s, Context t) {
//		Map<Variable,SafeType> smap = s.getVariableBindings();
//		Map<Variable,SafeType> tmap = t.getVariableBindings();
		
		for(Entry<Variable,SafeType> e : s) {
			SafeType sv = e.getValue();
			SafeType tv = t.get(e.getKey());
			if(sv.getValue()==tv.getValue()) continue;
			if((sv.isNull() || tv.isNull()) && sv.getValue()!=tv.getValue()) 
				return false;
			if(sv.isUndefined()==false && tv.isUndefined()==false && sv.getValue().equals(tv.getValue())==false) 
				return false;
		}
		
		return true;
	}
}
