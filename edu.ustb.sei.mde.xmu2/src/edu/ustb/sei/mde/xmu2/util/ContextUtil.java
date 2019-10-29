package edu.ustb.sei.mde.xmu2.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

import org.eclipse.emf.common.util.UniqueEList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
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
import edu.ustb.sei.mde.xmu2core.EmptyValueExpression;
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
			EClass hostType = node.getType();
			
			// reflective support
			if(hostType==Constants.REFLECTIVE_OBJECT && node.isReflective()) {
				try {
					SafeType expectedType = AbstractInterpreter.EXPRESSION_CHECK.resolveReflectiveClassifier(node, base);
					if(expectedType!=Constants.UNDEFINED) {
						hostType = (EClass) expectedType.getValue();
					} else hostType = null;
				} catch(Exception e) {
					hostType = null;
				}
				
				if(hostType==null) {
					hostType = obj.getObjectValue().eClass();
					SafeType hostTypeIdentifier = AbstractInterpreter.EXPRESSION_CHECK.desolveReflectiveClassifier(hostType, node.isResolve());
					
					try {
						if(!AbstractInterpreter.MODEL_CHECK.enforceExpression(node.getReflectiveIdentifier(), base, hostTypeIdentifier)) {
							return Collections.emptyList();
						}
					} catch(Exception e) {
						return Collections.emptyList();
					}
				}
			}
			
			if (AnalysisUtil.isSuperTypeOf(hostType, obj.getObjectValue().eClass()) == false)
				return Collections.emptyList();

			List<Context> cur = new ArrayList<Context>();
			List<Context> res = new ArrayList<Context>();

			res.add(base);

			for (PatternExpression expr : node.getExpressions()) {
				cur.clear();
				cur.addAll(res);
				res.clear();

				for (Context current : cur) {
					boolean nullable = expr.isNullable();
					if (expr instanceof ObjectPatternExpression) {
						try {
							EStructuralFeature feature = expr.getFeature();
							PatternNode next = ((ObjectPatternExpression) expr).getTarget();
							PositionPath pos = expr.getPosition();
							LoopPath sel = expr.getSelector();
							
							if(expr.isReflective() && feature==Constants.DYNAMIC_FEATURE) {
								
								try {
									SafeType expectedFeature = AbstractInterpreter.EXPRESSION_CHECK.resolveReflectiveFeature(hostType, expr, current);
									if (expectedFeature != Constants.UNDEFINED) {
										feature = (EStructuralFeature) expectedFeature.getValue();
									} else {
										feature = null;
									}
								} catch (Exception e) {
									feature = null;
								}
								
								if(feature==null) {
									List<EReference> allReferences = hostType.getEAllReferences();
									for(EReference ref : allReferences) {
										SafeType featureIdentifier = AbstractInterpreter.EXPRESSION_CHECK.desolveReflectiveFeature(ref,expr.isResolve());
										Context nc = current.clone();
										
										try {
											if(AbstractInterpreter.MODEL_CHECK.enforceExpression(expr.getReflectiveIdentifier(), nc, featureIdentifier)) {
												feature = ref;
												matchObjectPatternExpression(obj, feature, sel, pos, nullable, next, nc, res);
											}
										} catch(Exception e) {
										}
									}
									
								} else // feature has been resolved successfully 
									matchObjectPatternExpression(obj, feature, sel, pos, nullable, next, current, res);
							} else // non-reflective case
								matchObjectPatternExpression(obj, feature, sel, pos, nullable, next, current, res);
						} catch (Exception e) {
						}
					} else if(expr instanceof PropertyPatternExpression){
						// pattern Equal
						try {
							EStructuralFeature feature = expr.getFeature();
							PositionPath pos = expr.getPosition();
							LoopPath sel = expr.getSelector();
							Expression right = ((PropertyPatternExpression) expr).getTarget();
							// NOTE ME
							if(expr.isReflective() && feature==Constants.DYNAMIC_FEATURE) {	
								try {
									SafeType expectedFeature = AbstractInterpreter.EXPRESSION_CHECK.resolveReflectiveFeature(hostType, expr, current);
									if (expectedFeature != Constants.UNDEFINED) {
										feature = (EStructuralFeature) expectedFeature.getValue();
									} else {
										feature = null;
									}
								} catch (Exception e) {
									feature = null;
								}
								
								if(feature==null) {
									List<EStructuralFeature> allFeatures = hostType.getEAllStructuralFeatures();
									for(EStructuralFeature ref : allFeatures) {
										SafeType featureIdentifier = AbstractInterpreter.EXPRESSION_CHECK.desolveReflectiveFeature(ref,expr.isResolve());
										Context nc = current.clone();
										try {
											if(AbstractInterpreter.MODEL_CHECK.enforceExpression(expr.getReflectiveIdentifier(), nc, featureIdentifier)) {
												feature = ref;
												matchPropertyPatternExpression(obj, feature, pos, sel, nullable, right, nc, res);
											}
										} catch(Exception e) {
										}
									}
									
								} else // feature has been resolved successfully 
									matchPropertyPatternExpression(obj, feature, pos, sel, nullable, right, current, res);
							} else // non-reflective case
								matchPropertyPatternExpression(obj, feature, pos, sel, nullable, right, current, res);
						} catch (Exception e) {
						}
					}
				}
			}

			return res;
		}
	}

	protected static void matchPropertyPatternExpression(SafeType hostObject, EStructuralFeature feature,
			PositionPath position, LoopPath filter, boolean nullable, Expression rightExpression,
			Context currentContext, List<Context> resultContexts) {
		SafeType nValue = null;
		try {
			nValue = AbstractInterpreter.EXPRESSION_CHECK.executeExpression(rightExpression, currentContext);
		} catch (Exception e) {
			if (AnalysisUtil.isType(feature.getEType(), String.class))
				nValue = SafeType.UNDEFINED; // String may be enforced, so give
												// it second chance
			else
				return;
		}

		List<Object> candidate = currentContext.getEnvironment()
				.getFeatureAsInternalCollection(hostObject.getObjectValue(), feature);

		if (filter != null) {
			candidate = (List<Object>) AbstractInterpreter.EXPRESSION_CHECK
					.handleLoopPath(candidate, filter, currentContext).getValue();
		}

		if (position == null) {
			if (nValue.isUndefined()) {
				if (candidate.size() != 0) {
					for (int i = 0; i < candidate.size(); i++) {
						try {
							Context nc = currentContext.clone();
							if (AbstractInterpreter.MODEL_CHECK.enforceExpression(rightExpression, nc,
									SafeType.createFromValue((candidate.get(i)))))
								resultContexts.add(nc);
							else
								continue;
						} catch (Exception e) {
						}
					}
				} else {
					// Context nc = current.clone();
					// I comment the following *if* because it seems that there
					// is no need to check the multiplicity of the feature
					// because it is a property pattern expression, set it to
					// null
					if (nullable) {
						if (AbstractInterpreter.MODEL_CHECK.enforceExpression(rightExpression, currentContext,
								Constants.NULL))
							resultContexts.add(currentContext);
					}

				}
			} else if (nValue.isNull()) {
				if (candidate.size() == 0 && (nullable || rightExpression instanceof EmptyValueExpression)) {
					resultContexts.add(currentContext);
				}
			} else {
				int id = candidate.indexOf(nValue.getValue());
				if (id == -1)
					return;
				else {
					resultContexts.add(currentContext);
				}
			}
		} else {
			SafeType posV = AbstractInterpreter.EXPRESSION_CHECK.calculatePositionPath(position, currentContext);
			if (posV.isNull())
				return; // invalid position
			else if (posV.isUndefined()) {
				if (nValue.isUndefined()) {
					for (int i = 0; i < candidate.size(); i++) {
						try {
							Context nc = currentContext.clone();
							if (AbstractInterpreter.MODEL_CHECK.enforceExpression(rightExpression, nc,
									SafeType.createFromValue((candidate.get(i))))) {
								if (AbstractInterpreter.MODEL_CHECK.enforceExpression(position.getValue(), nc,
										SafeType.createFromValue(i))) {
									resultContexts.add(nc);
								} else
									continue;
							} else
								continue;
						} catch (Exception e) {
						}
					}

				} else {
					// set pos
					int id = candidate.indexOf(nValue.getValue());
					if (id == -1)
						return;
					else {
						if (AbstractInterpreter.MODEL_CHECK.enforceExpression(position.getValue(), currentContext,
								SafeType.createFromValue(id))) {
							resultContexts.add(currentContext);
						} else
							return; // cannot enforce pos
					}
				}

			} else if (posV.isInteger()) {
				if (posV.getIntegerValue() == -1)
					posV = SafeType.createFromValue(candidate.size() - 1);

				if (candidate.size() > posV.getIntegerValue() && posV.getIntegerValue() >= 0) {
					Object cValue = candidate.get(posV.getIntegerValue());
					if (nValue.isUndefined()) {
						if (AbstractInterpreter.MODEL_CHECK.enforceExpression(rightExpression, currentContext,
								SafeType.createFromValue(cValue))) {
							resultContexts.add(currentContext);
						} else
							return;
					} else {
						if (cValue.equals(nValue.getValue()))
							resultContexts.add(currentContext);
						else
							return;
					}
				} else {
					// if candidate is empty and posV = 0, I should set right to
					// null
					if (posV.getIntegerValue() == 0 && candidate.isEmpty()
							&& (nullable || rightExpression instanceof EmptyValueExpression)) {
						if (AbstractInterpreter.MODEL_CHECK.enforceExpression(rightExpression, currentContext,
								Constants.NULL))
							resultContexts.add(currentContext);
					} else
						return; // out of bound
				}
			} else {
				System.out.println("posV is not an integer");// should I fail?
				return;
			}
		}
	}

	protected static void matchObjectPatternExpression(SafeType hostObject, EStructuralFeature feature, LoopPath filter,
			PositionPath position, boolean nullable, PatternNode next, Context currentContext,
			List<Context> resultContexts) {
		SafeType nValue = currentContext.get(next.getVariable());
		List<Object> candidate = currentContext.getEnvironment()
				.getFeatureAsInternalCollection(hostObject.getObjectValue(), feature);

		if (filter != null) {
			candidate = (List<Object>) AbstractInterpreter.EXPRESSION_CHECK
					.handleLoopPath(candidate, filter, currentContext).getValue();
		}

		if (position == null) {
			if (nValue.isUndefined()) {
				if (candidate.size() != 0) {
					for (int i = 0; i < candidate.size(); i++) {
						try {
							EObject v = (EObject) candidate.get(i);
							// the validity will be checked during matchNode
							Context nc = currentContext.clone();
							nc.put(next.getVariable(), SafeType.createFromValue(v));
							resultContexts.addAll(matchNode(next, nc));
						} catch (Exception e) {
						}
					}
				} else {
					if (next.getExpressions().isEmpty() && nullable) {
						currentContext.put(next.getVariable(), Constants.NULL);
						resultContexts.add(currentContext);
					}
				}
			} else if (nValue.isNull()) {
				if (candidate.size() == 0 && next.getExpressions().isEmpty() && nullable) {
					resultContexts.add(currentContext);
				}
			} else {
				int id = candidate.indexOf(nValue.getValue());
				if (id == -1)
					return;
				else {
					resultContexts.addAll(matchNode(next, currentContext));
				}
			}
		} else {
			SafeType posV = AbstractInterpreter.EXPRESSION_CHECK.calculatePositionPath(position, currentContext);
			if (posV.isNull()) {
			} // invalid position
			else if (posV.isUndefined()) {
				if (nValue.isUndefined()) {
					for (int i = 0; i < candidate.size(); i++) {
						try {
							Context nc = currentContext.clone();
							EObject v = (EObject) candidate.get(i);
							nc.put(next.getVariable(), SafeType.createFromValue(v));
							if (AbstractInterpreter.MODEL_CHECK.enforceExpression(position.getValue(), nc,
									SafeType.createFromValue(i))) {
								resultContexts.addAll(matchNode(next, nc));
							} else
								continue;
						} catch (Exception e) {
						}
					}
				} else if (nValue.isNull()) {
					// should I set the position to zero?
					// it seems that I shouldn't do it.
				} else {
					// set pos
					int id = candidate.indexOf(nValue.getValue());
					if (id == -1) {
					} else {
						if (AbstractInterpreter.MODEL_CHECK.enforceExpression(position.getValue(), currentContext,
								SafeType.createFromValue(id))) {
							resultContexts.addAll(matchNode(next, currentContext));
						} else
							return; // cannot enforce pos
					}
				}

			} else if (posV.isInteger()) {
				if (posV.getIntegerValue() == -1)
					posV = SafeType.createFromValue(candidate.size() - 1);

				if (candidate.size() > posV.getIntegerValue() && posV.getIntegerValue() >= 0) {
					EObject cValue = (EObject) candidate.get(posV.getIntegerValue());
					if (nValue.isUndefined()) {
						currentContext.put(next.getVariable(), SafeType.createFromValue(cValue));
						resultContexts.addAll(matchNode(next, currentContext));
					} else {
						if (nValue.getValue() == cValue)
							resultContexts.addAll(matchNode(next, currentContext));
						else
							return;
					}
				} else {
					// if candidate is empty and posV = 0, I should set right to
					// null
					if (posV.getIntegerValue() == 0 && candidate.isEmpty() && next.getExpressions().size() == 0
							&& nullable) {
						currentContext.put(next.getVariable(), Constants.NULL);
						resultContexts.add(currentContext);
					} else
						return; // out of bound
				}
			} else {
				// invalid posV, should I fail?
				return;
			}
		}
	}

	public static void merge(Context host, Context delta) {
		for (Entry<Variable, SafeType> e : host) {
			SafeType v = delta.get(e.getKey());
			if (e.getValue().isUndefined() && !v.isUndefined()) {
				e.setValue(v);
			}
		}
	}

	static public Context merge(Pattern s, Pattern t, Pair<Context, Context> pair) {
		if (t == null)
			return pair.getFirst();

		Context nc = null;
		if (pair.getFirst() != null)
			nc = pair.getFirst().clone();
		else
			nc = pair.getSecond().clone();

		if (pair.getFirst() == null) {
			// nc is created by second.copy
			nilPattern(s, nc);
		} else {
			// nc is created by first.copy
			if (pair.getSecond() == null) {
				nilPattern(t, nc);
			} else {
				for (Entry<Variable, SafeType> e : pair.getSecond()) {
					if (nc.get(e.getKey()).isUndefined())
						nc.put(e.getKey(), e.getValue());
				}
			}
		}
		return nc;

	}

	static private void nilPattern(Pattern s, Context nc) {
		List<Variable> vars = collectVariables(s);
		for (Variable v : vars) {
			if (nc.get(v).isUndefined())
				nc.put(v, SafeType.NULL);
		}
	}

	static private List<Variable> collectVariables(Pattern s) {

		List<Variable> vars = new UniqueEList<Variable>();
		collectVariables(s.getRoot(), vars);
		return vars;
	}

	static public List<Variable> collectPatternVariables(Pattern pattern) {
		List<Variable> list = new ArrayList<Variable>();
		collectObjectVariables(pattern.getRoot(), list);
		return list;
	}

	static private void collectObjectVariables(PatternNode node, List<Variable> list) {
		list.add((Variable) (node.getVariable()));
		for (PatternExpression expr : node.getExpressions()) {
			if (expr instanceof ObjectPatternExpression) {
				collectObjectVariables(((ObjectPatternExpression) expr).getTarget(), list);
			} else if (expr instanceof PropertyPatternExpression) {
				Expression value = ((PropertyPatternExpression) expr).getTarget();
				if (value instanceof VariableExpression) {
					if (((VariableExpression) value).getVariable().getType() instanceof EClass
							&& ((VariableExpression) value).getPaths().isEmpty())
						list.add((((VariableExpression) value).getVariable()));
				}
			}
		}
	}

	static private void collectVariables(EObject root, List<Variable> vars) {
		if (root == null)
			return;
		else if (root instanceof PatternNode) {
			vars.add(((PatternNode) root).getVariable());
			for (PatternExpression e : ((PatternNode) root).getExpressions())
				collectVariables(e, vars);
		} else if (root instanceof PatternExpression) {
			if (root instanceof ObjectPatternExpression) {
				collectVariables(((ObjectPatternExpression) root).getPosition(), vars);
				collectVariables(((ObjectPatternExpression) root).getTarget(), vars);
			} else if (root instanceof PropertyPatternExpression) {
				collectVariables(((PropertyPatternExpression) root).getPosition(), vars);
				collectVariables(((PropertyPatternExpression) root).getTarget(), vars);
			}
		} else if (root instanceof AtomicExpression) {
			// if(root instanceof ParenExpression) {
			// collectVariables(((ParenExpression) root).getBody(), vars);
			// } else
			if (root instanceof VariableExpression) {
				vars.add(((VariableExpression) root).getVariable());
			}
		} else if (root instanceof BooleanOrExpression) {
			for (Expression c : ((BooleanOrExpression) root).getOperands())
				collectVariables(c, vars);
		} else if (root instanceof BooleanAndExpression) {
			for (Expression c : ((BooleanAndExpression) root).getOperands())
				collectVariables(c, vars);
		} else if (root instanceof RelationalExpression) {
			collectVariables(((RelationalExpression) root).getLeft(), vars);
			collectVariables(((RelationalExpression) root).getRight(), vars);
		} else if (root instanceof AdditiveExpression) {
			for (Expression c : ((AdditiveExpression) root).getOperands()) {
				collectVariables(c, vars);
			}
		} else if (root instanceof MultiplicativeExpression) {
			for (Expression c : ((MultiplicativeExpression) root).getOperands()) {
				collectVariables(c, vars);
			}
		} else if (root instanceof UnaryExpression) {
			collectVariables(((UnaryExpression) root).getBody(), vars);
		} else if (root instanceof PositionPath) {
			if (((PositionPath) root).getOperator() == PositionOperator.AT)
				collectVariables(((PositionPath) root).getValue(), vars);
		}
	}

	static public List<Pair<Context, Context>> align(List<Context> srcMatches, List<Context> tarMatches) {
		List<Pair<Context, Context>> alignment = new ArrayList<Pair<Context, Context>>();

		if (tarMatches == null) {
			Iterator<Context> sit = srcMatches.iterator();
			while (sit.hasNext()) {
				Context s = sit.next();
				alignment.add(new Pair<Context, Context>(s, s));
			}
		} else {
			Iterator<Context> sit = null;// srcMatches.iterator();
			Iterator<Context> tit = tarMatches.iterator();

			while (tit.hasNext()) {
				Context t = tit.next();
				sit = srcMatches.iterator();
				boolean aligned = false;

				while (sit.hasNext()) {
					Context s = sit.next();
					if (tryAlign(s, t)) {
						alignment.add(new Pair<Context, Context>(s, t));
						sit.remove();
						tit.remove();
						aligned = true;
						break;
					}
				}

				if (!aligned) {
					alignment.add(new Pair<Context, Context>(null, t));
				}
			}

			sit = srcMatches.iterator();
			while (sit.hasNext()) {
				alignment.add(new Pair<Context, Context>(sit.next(), null));
			}

			// tit = tarMatches.iterator();
			// while(tit.hasNext()) {
			// alignment.add(new Pair<Context,Context>(null, tit.next()));
			// }
		}

		return alignment;
	}

	static private boolean tryAlign(Context s, Context t) {
		// Map<Variable,SafeType> smap = s.getVariableBindings();
		// Map<Variable,SafeType> tmap = t.getVariableBindings();

		for (Entry<Variable, SafeType> e : s) {
			SafeType sv = e.getValue();
			SafeType tv = t.get(e.getKey());
			if (sv.getValue() == tv.getValue())
				continue;
			if ((sv.isNull() || tv.isNull()) && sv.getValue() != tv.getValue())
				return false;
			if (sv.isUndefined() == false && tv.isUndefined() == false && sv.getValue().equals(tv.getValue()) == false)
				return false;
		}

		return true;
	}
}
