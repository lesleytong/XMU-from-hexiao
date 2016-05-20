package edu.ustb.sei.mde.xmu2.runtime.executor;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

import edu.ustb.sei.mde.xmu2.runtime.exceptions.InvalidCalculationException;
import edu.ustb.sei.mde.xmu2.runtime.string.StringConstant;
import edu.ustb.sei.mde.xmu2.runtime.string.StringPattern;
import edu.ustb.sei.mde.xmu2.runtime.string.StringPatternElement;
import edu.ustb.sei.mde.xmu2.runtime.string.StringVariable;
import edu.ustb.sei.mde.xmu2.runtime.structures.Context;
import edu.ustb.sei.mde.xmu2.runtime.values.SafeType;
import edu.ustb.sei.mde.xmu2.util.Constants;
import edu.ustb.sei.mde.xmu2.util.ContextUtil;
import edu.ustb.sei.mde.xmu2.util.EvaluationUtil;
import edu.ustb.sei.mde.xmu2common.AdditiveOperator;
import edu.ustb.sei.mde.xmu2common.LoopOperator;
import edu.ustb.sei.mde.xmu2common.PositionOperator;
import edu.ustb.sei.mde.xmu2common.RelationalOperator;
import edu.ustb.sei.mde.xmu2common.UnaryOperator;
import edu.ustb.sei.mde.xmu2core.AdditiveExpression;
import edu.ustb.sei.mde.xmu2core.AtomicExpression;
import edu.ustb.sei.mde.xmu2core.BooleanAndExpression;
import edu.ustb.sei.mde.xmu2core.BooleanOrExpression;
import edu.ustb.sei.mde.xmu2core.CheckExpressionStatement;
import edu.ustb.sei.mde.xmu2core.Expression;
import edu.ustb.sei.mde.xmu2core.FeaturePath;
import edu.ustb.sei.mde.xmu2core.LoopPath;
import edu.ustb.sei.mde.xmu2core.MatchPattern;
import edu.ustb.sei.mde.xmu2core.Path;
//import edu.ustb.sei.mde.xmu2core.ParenExpression;
import edu.ustb.sei.mde.xmu2core.Pattern;
import edu.ustb.sei.mde.xmu2core.PositionPath;
import edu.ustb.sei.mde.xmu2core.RelationalExpression;
import edu.ustb.sei.mde.xmu2core.UnaryExpression;
import edu.ustb.sei.mde.xmu2core.Variable;
import edu.ustb.sei.mde.xmu2core.VariableExpression;

public class ModelCheckInterpreter extends ExpressionCheckInterpreter {

	public SafeType checkPattern(Pattern pat, Context c) {
		try {
			List<Context> smatches = ContextUtil.match(pat, c);
			if (smatches.size() > 0) {
				ContextUtil.merge(c, smatches.get(0));
				return Constants.TRUE;
			} else {
				return Constants.FALSE;
			}
		} catch (Exception e) {
			return Constants.FALSE;
		}
	}

	protected boolean enforceAdditiveExpression(AdditiveExpression invalid, Context context, SafeType expect) {
		// ...+undefined+... = expect

		if (expect.isNull() || expect.isUndefined()) {
			return false;
		} else {
			if (expect.isString()) {
				// collect String pattern
				// match pattern
				StringPattern pattern = StringPattern.getStringPattern(invalid, context);
				if (pattern == null)
					return false;
				if (enforceStringPattern(expect.getStringValue(), pattern, context) == false)
					return false;
				else
					return true;
			} else {
				// 数值型
				SafeType headValid = null;
				SafeType tailValid = SafeType.createFromValue(0);

				int index = 0;
				int invalidAt = 0;

				for (; index < invalid.getOperands().size(); index++) {
					Expression child = invalid.getOperands().get(index);
					SafeType value = EXPRESSION_CHECK.executeExpression(child, context);
					if (value.isUndefined()) {
						invalidAt = index;
						break;
					}
					if (headValid == null)
						headValid = value;
					else {
						AdditiveOperator op = invalid.getOperators().get(index - 1);
						headValid = EvaluationUtil.additive(op, headValid, value);
					}
				}

				index++;

				if (index == invalid.getOperands().size())
					tailValid = null;
				else {
					for (; index < invalid.getOperands().size(); index++) {
						Expression child = invalid.getOperands().get(index);
						SafeType value = EXPRESSION_CHECK.executeExpression(child, context);

						AdditiveOperator op = invalid.getOperators().get(index - 1);
						tailValid = EvaluationUtil.additive(op, tailValid, value);
					}
				}

				Expression invalidPart = invalid.getOperands().get(invalidAt);

				if (headValid == null && tailValid == null) {
					return enforceExpression(invalidPart, context, expect);
				} else if (headValid == null && tailValid != null) {
					if (tailValid.isString())
						return false;
					AdditiveOperator op = invalid.getOperators().get(invalidAt);
					SafeType realExpect = null;
					if (op == AdditiveOperator.ADD) {
						realExpect = EvaluationUtil.additive(AdditiveOperator.SUB, expect, tailValid);
					} else {
						realExpect = EvaluationUtil.additive(AdditiveOperator.ADD, expect, tailValid);
					}
					return enforceExpression(invalidPart, context, realExpect);

				} else if (headValid != null && tailValid == null) {
					if (headValid.isString())
						return false;
					AdditiveOperator op = invalid.getOperators().get(invalidAt - 1);
					SafeType realExpect = null;
					if (op == AdditiveOperator.ADD) {
						realExpect = EvaluationUtil.additive(AdditiveOperator.SUB, expect, headValid);
					} else {
						realExpect = EvaluationUtil.additive(AdditiveOperator.SUB, headValid, expect);
					}
					return enforceExpression(invalidPart, context, realExpect);
				} else {
					if (headValid.isString() || tailValid.isString())
						return false;
					AdditiveOperator op1 = invalid.getOperators().get(invalidAt - 1);
					AdditiveOperator op2 = invalid.getOperators().get(invalidAt);

					SafeType realExpect = null;

					if (op1 == AdditiveOperator.ADD && op2 == AdditiveOperator.ADD) {
						realExpect = EvaluationUtil.additive(AdditiveOperator.SUB, expect, headValid);
						realExpect = EvaluationUtil.additive(AdditiveOperator.SUB, realExpect, tailValid);
					} else if (op1 == AdditiveOperator.ADD && op2 == AdditiveOperator.SUB) {
						realExpect = EvaluationUtil.additive(AdditiveOperator.SUB, expect, headValid);
						realExpect = EvaluationUtil.additive(AdditiveOperator.ADD, realExpect, tailValid);
					} else if (op1 == AdditiveOperator.SUB && op2 == AdditiveOperator.ADD) {
						realExpect = EvaluationUtil.additive(AdditiveOperator.ADD, headValid, tailValid);
						realExpect = EvaluationUtil.additive(AdditiveOperator.SUB, realExpect, expect);
					} else if (op1 == AdditiveOperator.SUB && op2 == AdditiveOperator.SUB) {
						realExpect = EvaluationUtil.additive(AdditiveOperator.SUB, headValid, tailValid);
						realExpect = EvaluationUtil.additive(AdditiveOperator.SUB, realExpect, expect);
					} else {
						throw new InvalidCalculationException("invalid additive operator");
					}

					return enforceExpression(invalidPart, context, realExpect);
				}
			}
		}
	}

	protected boolean enforceAtomicExpression(AtomicExpression invalid, Context context, SafeType expect) {
		try {
			if (invalid instanceof VariableExpression) {
				VariableExpression exp = (VariableExpression) invalid;
				// if(exp.getVar() instanceof ObjectVariable) return false;

				// I can only support the following patterns:
				// v(.feature)? = value
				// v.feature(->select())?->first()/last()/at() = value
				// v.feature(->select())?->forAll()/exists() = value

				// 1. check the path pattern
				// 2. handle the pattern by calling one of the handling
				// operations

				if (isPatternA(exp))
					return enforceVariableExpressionPatternA(exp, context, expect);
				if (isPatternB(exp))
					return enforceVariableExpressionPatternB(exp, context, expect);
				if (isPatternC(exp))
					return enforceVariableExpressionPatternC(exp, context, expect);

				return false;

				// } else if(invalid instanceof ParenExpression) {
				// return enforceExpression(((ParenExpression)
				// invalid).getBody(),context,expect);
			}
			return false;
		} catch (Exception e) {
			return false;
		}
		// throw new InvalidCalculationException("cannot enforce atomic
		// expression "+invalid);
	}

	private boolean enforceBooleanAndExpression(BooleanAndExpression invalid, Context context, SafeType expect) {
		if (expect != Constants.TRUE && expect != Constants.FALSE)
			return false;
		try {
			SafeType ret = AbstractInterpreter.EXPRESSION_CHECK.executeExpression(invalid, context);
			if (ret == expect) {
				return true;
			} else {
				if (expect == Constants.TRUE) {
					for (Expression e : invalid.getOperands()) {
						if (!enforceExpression(e, context, Constants.TRUE))
							return false;
					}
					return true;
				} else {
					for (Expression e : invalid.getOperands()) {
						if (enforceExpression(e, context, Constants.FALSE))
							return true;
					}
					return false;
				}
			}
		} catch (Exception e) {
			return false;
		}
	}

	private boolean enforceBooleanOrExpression(BooleanOrExpression invalid, Context context, SafeType expect) {
		if (expect != Constants.TRUE && expect != Constants.FALSE)
			return false;
		try {
			SafeType ret = AbstractInterpreter.EXPRESSION_CHECK.executeExpression(invalid, context);
			if (ret == expect) {
				return true;
			} else {
				if (expect == Constants.TRUE) {
					for (Expression e : invalid.getOperands()) {
						if (enforceExpression(e, context, Constants.TRUE))
							return true;
					}
					return false;
				} else {
					for (Expression e : invalid.getOperands()) {
						if (!enforceExpression(e, context, Constants.FALSE))
							return false;
					}
					return true;
				}
			}
		} catch (Exception e) {
			return false;
		}
	}

	private boolean enforceExists(List<?> list, LoopPath loop, SafeType expect, Context context) {

		if (expect == Constants.TRUE) {
			for (Object o : list) {
				Context inner = context.createInnerContext();
				inner.registerVariable(loop.getIterator());
				inner.put(loop.getIterator(), SafeType.createFromValue(o));
				if (this.enforceExpression(loop.getBody(), inner, Constants.TRUE))
					return true;
			}
			return false;
		} else {
			for (Object o : list) {
				Context inner = context.createInnerContext();
				inner.registerVariable(loop.getIterator());
				inner.put(loop.getIterator(), SafeType.createFromValue(o));
				if (this.enforceExpression(loop.getBody(), inner, Constants.FALSE) == false)
					return false;
			}
			return true;
		}
	}

	public boolean enforceExpression(Expression invalid, Context context, SafeType expect) {
		if (expect.isUndefined())
			return false;

		if (invalid instanceof BooleanOrExpression) {
			return enforceBooleanOrExpression((BooleanOrExpression) invalid, context, expect);
		}

		if (invalid instanceof BooleanAndExpression) {
			return enforceBooleanAndExpression((BooleanAndExpression) invalid, context, expect);
		}

		if (invalid instanceof RelationalExpression) {
			return enforceRelationalExpression((RelationalExpression) invalid, context, expect);
		}

		if (invalid instanceof AdditiveExpression) {
			return enforceAdditiveExpression((AdditiveExpression) invalid, context, expect);
		}

		if (invalid instanceof AtomicExpression)
			return enforceAtomicExpression((AtomicExpression) invalid, context, expect);

		if (invalid instanceof UnaryExpression)
			return enforceUnaryExpression((UnaryExpression) invalid, context, expect);

		return false;
	}

	protected boolean enforceFeatureLoop(SafeType host, EStructuralFeature fp, LoopPath loop, LoopPath pp,
			SafeType expect, Context context) {
		EObject obj = host.getObjectValue();
		List<?> list = context.getEnvironment().getFeatureAsFeatureList(obj, fp);

		if (loop != null) {
			list = (List<?>) this.handleLoopPath(list, loop, context).getValue();
		}

		if (pp.getOperator() == LoopOperator.FOR_ALL) {
			return enforceForAll(list, pp, expect, context);
		} else if (pp.getOperator() == LoopOperator.FOR_ALL) {
			return enforceExists(list, pp, expect, context);
		} else
			return false;
	}

	/**
	 * this method is intended to be overridden to support model enforcement
	 */
	protected boolean enforceFeatureSelector(SafeType host, EStructuralFeature fp, LoopPath loop, PositionPath position,
			SafeType val, Context context) {

		EObject obj = host.getObjectValue();
		List<?> list = context.getEnvironment().getFeatureAsFeatureList(obj, fp);

		if (loop != null) {
			list = (List<?>) this.handleLoopPath(list, loop, context).getValue();
		}

		if (position == null) {
			if (list.contains(val.getValue())) {
				return true;
			} else
				return false;
		} else {
			SafeType id = this.calculatePositionPath(position, context);

			if (id.isUndefined()) {
				int idx = list.indexOf(val.getValue());

				if (idx >= 0) {
					if (position.getOperator() != PositionOperator.AT) {
						return false;
					}

					if (this.enforceExpression(position.getValue(), context, SafeType.createFromValue(idx)))
						return true;
					else
						return false;
				} else
					// insert val into list
					return false;
			} else {
				if (id.isNull())
					return false;

				if (!id.isInteger())
					return false;

				// FIXME list[id] = val
				if (list.contains(val.getValue()))
					return true;
				else
					// insert val into list
					return false;
			}
		}
	}

	private boolean enforceForAll(List<?> list, LoopPath loop, SafeType expect, Context context) {
		if (expect == Constants.TRUE) {
			for (Object o : list) {
				Context inner = context.createInnerContext();
				inner.registerVariable(loop.getIterator());
				inner.put(loop.getIterator(), SafeType.createFromValue(o));
				if (this.enforceExpression(loop.getBody(), inner, Constants.TRUE) == false)
					return false;
			}
			return true;
		} else {
			for (Object o : list) {
				Context inner = context.createInnerContext();
				inner.registerVariable(loop.getIterator());
				inner.put(loop.getIterator(), SafeType.createFromValue(o));
				if (this.enforceExpression(loop.getBody(), inner, Constants.FALSE))
					return true;
			}

			return false;
		}
	}

	protected boolean enforceLink(Variable source, EStructuralFeature feature, LoopPath loop, PositionPath position,
			Expression target, Context context) {
		SafeType val = this.executeExpression(target, context);

		try {
			if (val.isUndefined()) {
				SafeType expect = this.getFeatureFromPropertyPatternExpression(source, feature, loop, position,
						context);

				if (expect.isUndefined())
					return false;

				List<?> list = (List<?>) expect.getValue();
				int size = list.size();
				if (size == 0) {
					expect = Constants.NULL;
				} else if (size >= 1) {
					expect = SafeType.createFromValue(list.get(0));
				}

				if (this.enforceExpression(target, context, expect))
					return true;
				else
					return false;
			} else {
				SafeType safeType = context.get(source);
				return this.enforceFeatureSelector(safeType, feature, loop, position, val, context);
			}
		} catch (Exception e) {
			throw new InvalidCalculationException("cannot enforce property pattern expression");
		}
	}

	private boolean enforceRelationalExpression(RelationalExpression invalid, Context context, SafeType expect) {
		if (expect != Constants.TRUE && expect != Constants.FALSE)
			return false;

		try {
			SafeType ret = AbstractInterpreter.EXPRESSION_CHECK.executeExpression(invalid, context);
			if (ret == expect) {
				return true;
			} else {
				if (invalid.getOperator() == RelationalOperator.EQUAL) {
					if (expect == Constants.TRUE) {
						SafeType leftValue = null;

						try {
							leftValue = AbstractInterpreter.EXPRESSION_CHECK.executeExpression(invalid.getLeft(),
									context);
						} catch (Exception e) {
							leftValue = null;
						}
						SafeType rightValue = null;

						try {
							rightValue = AbstractInterpreter.EXPRESSION_CHECK.executeExpression(invalid.getRight(),
									context);
						} catch (Exception e) {
							rightValue = null;
						}

						if (leftValue == null && rightValue == null)
							return false;
						else {
							if (leftValue != null && leftValue.isUndefined() == false) {
								if (enforceExpression(invalid.getRight(), context, leftValue))
									return true;
							}
							if (rightValue != null && rightValue.isUndefined() == false) {
								if (enforceExpression(invalid.getLeft(), context, rightValue))
									return true;
							}
							return false;
						}
					} else {
						return false;
					}
				} else
					return false;
			}
		} catch (Exception e) {
			return false;
		}
	}

	protected boolean enforceStringPattern(String expectString, StringPattern pattern, Context context) {

		List<StringPatternElement> patternDef = pattern.getPattern();
		int fromIndex = 0;
		StringVariable lastUnsolved = null;

		for (int i = 0; i < patternDef.size(); i++) {
			StringPatternElement elem = patternDef.get(i);

			if (elem instanceof StringConstant) {
				int lastCount = 0;
				if (((StringConstant) elem).isFirst() == false) {
					for (int j = i; j < patternDef.size(); j++) {
						StringPatternElement spe = patternDef.get(j);
						if (spe instanceof StringConstant) {
							if (((StringConstant) spe).getConstant().equals(((StringConstant) elem).getConstant()))
								lastCount++;
						}
					}
				}

				int id = getPosition(expectString, fromIndex, pattern, i, lastCount);
				if (id == -1)
					return false;// expected string does not match the pattern

				if (lastUnsolved == null) {
					if (fromIndex != id)
						return false;// expected string does not match the
										// pattern
				} else {
					String subStr = expectString.substring(fromIndex, id);
					if (enforceExpression(lastUnsolved.getUndefined(), context,
							SafeType.createFromValue(subStr)) == false)
						return false;
					lastUnsolved = null;
				}
				fromIndex = id + ((StringConstant) elem).getConstant().length();
			} else if (elem instanceof StringVariable)
				lastUnsolved = (StringVariable) elem;
			else
				return false;
		}

		if (lastUnsolved == null) {
			if (fromIndex != expectString.length())
				return false;
		} else {
			String subStr = expectString.substring(fromIndex);
			if (enforceExpression(lastUnsolved.getUndefined(), context, SafeType.createFromValue(subStr)) == false)
				return false;
		}

		return true;
	}

	protected boolean enforceUnaryExpression(UnaryExpression invalid, Context context, SafeType expect) {
		if (invalid.getOperator() == UnaryOperator.MINUS) {
			expect = EvaluationUtil.minus(expect);
			return enforceExpression(invalid.getBody(), context, expect);
		} else {
			if (expect == Constants.TRUE) {
				return enforceExpression(invalid.getBody(), context, Constants.FALSE);
			} else if (expect == Constants.FALSE) {
				return enforceExpression(invalid.getBody(), context, Constants.TRUE);
			} else
				return false;
		}
	}

	private boolean enforceVariableExpressionPatternA(VariableExpression e, Context context, SafeType expect) {
		if (e.getPaths().isEmpty()) {
			VariableExpression exp = (VariableExpression) e;
			SafeType oldValue = context.get(exp.getVariable());
			if (oldValue.isUndefined() == false) {
				if (oldValue != expect && oldValue.getValue() != expect.getValue()
						&& oldValue.getValue().equals(expect.getValue()) == false)
					return false;
				else
					return true;
			} else {
				context.put(exp.getVariable(), expect);
				return true;
			}
		} else {
			FeaturePath path = (FeaturePath) e.getPaths().get(0);
			VariableExpression exp = e;

			SafeType host = context.get(exp.getVariable());

			if (host.isUndefined() || host.isNull())
				return false;
			else {
				EStructuralFeature feature = path.getFeature();
				
				// Reflective API
				if (path.isReflective()) {
					try {
						SafeType expectedFeature = this.resolveReflectiveFeature(host.getObjectValue().eClass(),
								((FeaturePath) path).getReflectiveIdentifier(), context);
						feature = (EStructuralFeature) expectedFeature.getValue();
					} catch (Exception exception) {
						throw new InvalidCalculationException("invalid dynamic feature path");
					}
				}
				
				return enforceFeatureSelector(host, feature , null, null, expect, context);
			}
		}
	}

	private boolean enforceVariableExpressionPatternB(VariableExpression e, Context context, SafeType expect) {
		if (e.getPaths().size() == 2) {
			FeaturePath fp = (FeaturePath) e.getPaths().get(0);
			PositionPath pp = (PositionPath) e.getPaths().get(1);
			SafeType t = context.get(((VariableExpression) e).getVariable());
			EStructuralFeature feature = fp.getFeature();
			
			
			// Reflective API
			if (fp.isReflective()) {
				try {
					SafeType expectedFeature = this.resolveReflectiveFeature(t.getObjectValue().eClass(),
							((FeaturePath) fp).getReflectiveIdentifier(), context);
					feature = (EStructuralFeature) expectedFeature.getValue();
				} catch (Exception exception) {
					throw new InvalidCalculationException("invalid dynamic feature path");
				}
			}
			
			return this.enforceFeatureSelector(t, feature, null, pp, expect, context);
		} else {
			FeaturePath fp = (FeaturePath) e.getPaths().get(0);
			LoopPath lp = (LoopPath) e.getPaths().get(1);
			PositionPath pp = (PositionPath) e.getPaths().get(2);
			SafeType t = context.get(((VariableExpression) e).getVariable());
			
			EStructuralFeature feature = fp.getFeature();
			
			// Reflective API
			if (fp.isReflective()) {
				try {
					SafeType expectedFeature = this.resolveReflectiveFeature(t.getObjectValue().eClass(),
							((FeaturePath) fp).getReflectiveIdentifier(), context);
					feature = (EStructuralFeature) expectedFeature.getValue();
				} catch (Exception exception) {
					throw new InvalidCalculationException("invalid dynamic feature path");
				}
			}
			
			return this.enforceFeatureSelector(t, feature, lp, pp, expect, context);
		}
	}

	private boolean enforceVariableExpressionPatternC(VariableExpression e, Context context, SafeType expect) {
		if (e.getPaths().size() == 2) {
			FeaturePath fp = (FeaturePath) e.getPaths().get(0);
			LoopPath pp = (LoopPath) e.getPaths().get(1);
			SafeType t = context.get(((VariableExpression) e).getVariable());
			
			EStructuralFeature feature = fp.getFeature();
			
			// Reflective API
			if (fp.isReflective()) {
				try {
					SafeType expectedFeature = this.resolveReflectiveFeature(t.getObjectValue().eClass(),
							((FeaturePath) fp).getReflectiveIdentifier(), context);
					feature = (EStructuralFeature) expectedFeature.getValue();
				} catch (Exception exception) {
					throw new InvalidCalculationException("invalid dynamic feature path");
				}
			}
			
			return this.enforceFeatureLoop(t, feature, null, pp, expect, context);
		} else {
			FeaturePath fp = (FeaturePath) e.getPaths().get(0);
			LoopPath lp = (LoopPath) e.getPaths().get(1);
			LoopPath pp = (LoopPath) e.getPaths().get(2);
			SafeType t = context.get(((VariableExpression) e).getVariable());
			
			EStructuralFeature feature = fp.getFeature();
			
			// Reflective API
			if (fp.isReflective()) {
				try {
					SafeType expectedFeature = this.resolveReflectiveFeature(t.getObjectValue().eClass(),
							((FeaturePath) fp).getReflectiveIdentifier(), context);
					feature = (EStructuralFeature) expectedFeature.getValue();
				} catch (Exception exception) {
					throw new InvalidCalculationException("invalid dynamic feature path");
				}
			}
			return this.enforceFeatureLoop(t, feature, lp, pp, expect, context);
		}
	}

	@Override
	public void executeCheckExpressionStatement(CheckExpressionStatement o, Context context) {
		if (this.enforceExpression(o.getExpression(), context, Constants.TRUE) == false)
			throw new InvalidCalculationException("cannot check the epxression");
	}

	@Override
	public void executeMatchPatternStatement(MatchPattern o, Context context) {
		SafeType ret = this.checkPattern(o.getPattern(), context);
		if (ret != Constants.TRUE)
			throw new InvalidCalculationException("pattern matching failed");
	}

	@Override
	public SafeType executeRelationalExpression(RelationalExpression expression, Context context) {

		if (expression.getOperator() == RelationalOperator.EQUAL) {
			SafeType left = null;
			SafeType right = null;

			try {
				left = this.executeExpression(expression.getLeft(), context);
			} catch (InvalidCalculationException e) {
				left = SafeType.UNDEFINED;
			}

			try {
				right = this.executeExpression(expression.getRight(), context);
			} catch (InvalidCalculationException e) {
				right = SafeType.UNDEFINED;
			}

			if (left.isUndefined() && right.isUndefined())
				throw new InvalidCalculationException("the two operands of relational operation are both undefined");
			else if ((left.isUndefined() || right.isUndefined())) {
				if (left.isUndefined()) {
					if (enforceExpression(expression.getLeft(), context, right))
						return Constants.TRUE;
					else
						throw new InvalidCalculationException("relational expression fails");
				} else {
					if (enforceExpression(expression.getRight(), context, left))
						return Constants.TRUE;
					else
						throw new InvalidCalculationException("relational expression fails");
				}
			}

			if ((left.isNull() && right.isNull()) || (!left.isNull() && left.getValue().equals(right.getValue())))
				return Constants.TRUE;
			else {
				// model check do not change model elements
				if (enforceExpression(expression.getLeft(), context, right))
					return Constants.TRUE;
				else if (enforceExpression(expression.getRight(), context, left))
					return Constants.TRUE;
				return Constants.FALSE;
			}

		} else
			return super.executeRelationalExpression(expression, context);
	}

	protected SafeType getFeatureFromPropertyPatternExpression(Variable var, EStructuralFeature feature, LoopPath loop,
			PositionPath position, Context context) {
		SafeType host = context.get(var);
		if (host.isObject() == false)
			throw new InvalidCalculationException("cannot get feature from a non-EObject");
		else {
			try {
				EObject hostObject = host.getObjectValue();
				List<?> rawFeatureValue = context.getEnvironment().getFeatureAsFeatureList(hostObject, feature);

				if (loop != null) {
					rawFeatureValue = (List<?>) this.handleLoopPath(rawFeatureValue, loop, context).getValue();
				}

				SafeType value = null;
				if (position != null) {
					value = this.handlePositionPath(rawFeatureValue, position, context);
				} else
					value = SafeType.createFromValue(rawFeatureValue);

				return value;
			} catch (Exception e) {
				throw new InvalidCalculationException("cannot get feature value");
			}
		}
	}

	protected int getPosition(String expectString, int fromIndex, StringPattern pattern, int elemIndex, int lastCount) {
		StringConstant elem = (StringConstant) pattern.getPattern().get(elemIndex);

		if (lastCount == 0)
			return expectString.indexOf(elem.getConstant(), fromIndex);
		else {
			int id = 0;
			int endIndex = expectString.length() - 1;
			while (lastCount > 0) {
				id = expectString.lastIndexOf(elem.getConstant(), endIndex);
				if (id == -1)
					break;
				endIndex = id - 1;// skip expectString[id]
				lastCount--;
			}
			return id;
		}
	}

	private boolean isPatternA(AtomicExpression e) {
		if (e.getPaths().size() != 0 && e.getPaths().size() != 1)
			return false;
		else {
			boolean shortForm = e.getPaths().isEmpty();

			Path p1 = shortForm ? null : e.getPaths().get(0);
			
			if(p1==null || p1 instanceof FeaturePath)
				return true;

			return false;
		}
	}

	private boolean isPatternB(AtomicExpression e) {
		if (e.getPaths().size() != 2 && e.getPaths().size() != 3)
			return false;
		else {
			boolean shortForm = e.getPaths().size() == 2;

			Path p1 = e.getPaths().get(0);
			Path p2 = shortForm ? null : e.getPaths().get(1);
			Path p3 = shortForm ? e.getPaths().get(1) : e.getPaths().get(2);

			if (p1 instanceof FeaturePath) {
				if (p3 instanceof PositionPath) {
					if (p2 == null)
						return true;

					if (p2 instanceof LoopPath && ((LoopPath) p2).getOperator() == LoopOperator.SELECT)
						return true;
				}
			}

			return false;
		}
	}

	// protected boolean enforcePropertyPatternExpression(
	// PropertyPatternExpression patternEqualExpr, Context context) {
	//
	//
	// Variable var =
	// ((PatternNode)patternEqualExpr.eContainer()).getVariable();
	// EStructuralFeature feature = patternEqualExpr.getFeature();
	// LoopPath loop = patternEqualExpr.getSelector();
	// PositionPath position = patternEqualExpr.getPosition();
	//
	// return
	// enforceLink(var,feature,loop,position,patternEqualExpr.getTarget(),context);
	//
	//// SafeType val = this.execute(patternEqualExpr.getTarget(), context);
	//// try {
	//// if(val.isUndefined()) {
	//// SafeType expect = this.getFeatureFromPropertyPatternExpression(var,
	// feature, loop, position, context);
	////
	//// if(expect.isUndefined())
	//// return false;
	////
	//// if(this.enforceExpression(patternEqualExpr.getTarget(), context,
	// expect))
	//// return true;
	//// else
	//// throw new InvalidCalculationException("cannot enforce property pattern
	// expression");
	//// } else {
	//// EObject obj = context.get(var).getObjectValue();
	//// List<?> list = context.getEnvironment().getFeatureAsFeatureList(obj,
	// feature);
	//// SafeType resList = SafeType.createFromValue(list);
	////
	//// if(loop!=null) {
	//// resList = this.handleLoopPath(resList, loop, context);
	//// }
	////
	////// if(loop!=null)
	////
	//// if(position==null) {
	//// if(list.contains(val.getValue())) {
	//// return true;
	//// } else
	//// // insert val into list
	//// throw new InvalidCalculationException("cannot enforce property pattern
	// expression");
	//// } else {
	//// SafeType id = this.calculatePositionPath(position, context);
	////
	//// if(id.isUndefined()) {
	//// int idx = list.indexOf(val.getValue());
	////
	//// if(idx>=0) {
	//// if(position.getOperator()!=PositionOperator.AT) {
	//// throw new InvalidCalculationException("cannot enforce first()/last()");
	//// }
	////
	//// if(this.enforceExpression(position.getValue(), context,
	// SafeType.createFromValue(idx)))
	//// return true;
	//// else
	//// throw new InvalidCalculationException("cannot enforce property pattern
	// expression");
	//// } else
	//// // insert val into list
	//// throw new InvalidCalculationException("cannot enforce property pattern
	// expression");
	//// } else {
	//// if(id.isNull())
	//// throw new InvalidCalculationException("invalid index NULL");
	////
	//// if(!id.isInteger())
	//// throw new InvalidCalculationException("invalid index non-integer");
	////
	//// if(list.contains(val.getValue()))
	//// return true;
	//// else
	//// //insert val into list
	//// throw new InvalidCalculationException("cannot enforce property pattern
	// expression");
	//// }
	//// }
	//// }
	//// } catch (Exception e) {
	//// throw new InvalidCalculationException("cannot enforce property pattern
	// expression");
	//// }
	// }

	private boolean isPatternC(AtomicExpression e) {
		if (e.getPaths().size() != 2 && e.getPaths().size() != 3)
			return false;
		else {
			boolean shortForm = e.getPaths().size() == 2;

			Path p1 = e.getPaths().get(0);
			Path p2 = shortForm ? null : e.getPaths().get(1);
			Path p3 = shortForm ? e.getPaths().get(1) : e.getPaths().get(2);

			if (p1 instanceof FeaturePath) {
				if (p3 instanceof LoopPath && ((LoopPath) p3).getOperator() != LoopOperator.SELECT) {
					if (p2 == null)
						return true;

					if (p2 instanceof LoopPath && ((LoopPath) p2).getOperator() == LoopOperator.SELECT)
						return true;
				}
			}

			return false;
		}
	}

	public SafeType matchPattern(Pattern pattern, Context context) {
		List<Context> smatches = ContextUtil.match(pattern, context);
		if (smatches.size() > 0) {
			ContextUtil.merge(context, smatches.get(0));
			return Constants.TRUE;
		} else {
			return Constants.FALSE;
		}
	}
}
