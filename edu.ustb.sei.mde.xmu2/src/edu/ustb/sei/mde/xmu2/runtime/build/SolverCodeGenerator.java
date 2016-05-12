package edu.ustb.sei.mde.xmu2.runtime.build;

import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;
import java.util.List;

import org.chocosolver.solver.Solver;
import org.chocosolver.solver.constraints.Constraint;
import org.chocosolver.solver.constraints.ICF;
import org.chocosolver.solver.constraints.LCF;
import org.chocosolver.solver.constraints.real.Ibex;
import org.chocosolver.solver.constraints.real.RealConstraint;
import org.chocosolver.solver.variables.BoolVar;
import org.chocosolver.solver.variables.IntVar;
import org.chocosolver.solver.variables.RealVar;
import org.chocosolver.solver.variables.VF;
import org.chocosolver.solver.variables.Variable;
import org.chocosolver.util.tools.StringUtils;
import org.eclipse.emf.common.util.EList;

import edu.ustb.sei.commonutil.util.Pair;
import edu.ustb.sei.mde.xmu2.expression.ConstantExpression;
import edu.ustb.sei.mde.xmu2.expression.EmptyValueType;
import edu.ustb.sei.mde.xmu2.expression.Expression;
import edu.ustb.sei.mde.xmu2.expression.ParenExpression;
import edu.ustb.sei.mde.xmu2.expression.VariableExpression;
import edu.ustb.sei.mde.xmu2.runtime.exceptions.BuildException;
import edu.ustb.sei.mde.xmu2.statement.AssignStatement;
import edu.ustb.sei.mde.xmu2.util.AnalysisUtil;
import edu.ustb.sei.mde.xmu2common.AdditiveOperator;
import edu.ustb.sei.mde.xmu2common.MultiplicativeOperator;
import edu.ustb.sei.mde.xmu2common.RelationalOperator;
import edu.ustb.sei.mde.xmu2common.UnaryOperator;

public class SolverCodeGenerator {
	
	

	static public byte[] convertAssignStatement(AssignStatement stmt, List<edu.ustb.sei.mde.xmu2core.Variable> varList,
			VarMapStack varMap) {
		SolverMap map = new SolverMap("AssignStatement " + stmt.hashCode());
		for (edu.ustb.sei.mde.xmu2core.Variable v : varList) {
			map.createVariable(v);
		}
		Constraint c = convertAssignStatement(stmt,varMap,map);
		
		map.getSolver().post(c);
		
		System.out.println(map.getSolver());
		try {
			ByteArrayOutputStream stream = new ByteArrayOutputStream();
			ObjectOutputStream oos = new ObjectOutputStream(stream);
			oos.writeObject(map.getSolver());
			byte[] arr = stream.toByteArray();
			oos.close();
			stream.close();
			return arr;
		} catch(Exception e) {
			throw new BuildException(e);
		}
	}

	static public VariableExpression findUniqueVariableExpression(Expression root) {
		if (root instanceof VariableExpression)
			return (VariableExpression) root;
		else {
			if (root instanceof ParenExpression) {
				return findUniqueVariableExpression(((ParenExpression) root).getBody());
			} else
				return null;
		}
	}

	static public ConstantExpression findUniqueConstantExpression(Expression root) {
		if (root instanceof ConstantExpression)
			return (ConstantExpression) root;
		else {
			if (root instanceof ParenExpression) {
				return findUniqueConstantExpression(((ParenExpression) root).getBody());
			} else
				return null;
		}
	}

	static public org.chocosolver.solver.constraints.Constraint convertBooleanExpression(Expression expression,
			VarMapStack varMap, SolverMap solverMap) {
		if (expression instanceof edu.ustb.sei.mde.xmu2.expression.BooleanOrExpression) {
			return convertBooleanOrExpression(expression, varMap, solverMap);
		} else if (expression instanceof edu.ustb.sei.mde.xmu2.expression.BooleanAndExpression) {
			return convertBooleanAndExpression(expression, varMap, solverMap);
		} else if (expression instanceof edu.ustb.sei.mde.xmu2.expression.RelationalExpression) {
			return convertRelationalExpression(expression, varMap, solverMap);
		} else if (expression instanceof edu.ustb.sei.mde.xmu2.expression.UnaryExpression) {
			if (((edu.ustb.sei.mde.xmu2.expression.UnaryExpression) expression).getOperator() == UnaryOperator.NOT) {
				return LCF.not(convertBooleanExpression(
						((edu.ustb.sei.mde.xmu2.expression.UnaryExpression) expression).getBody(), varMap, solverMap));
			}
			throw new BuildException();
		} else if (expression instanceof edu.ustb.sei.mde.xmu2.expression.ParenExpression) {
			return convertBooleanExpression(((edu.ustb.sei.mde.xmu2.expression.ParenExpression) expression).getBody(),
					varMap, solverMap);
		} else if (expression instanceof edu.ustb.sei.mde.xmu2.expression.VariableExpression) {
			String name = ((edu.ustb.sei.mde.xmu2.expression.VariableExpression) expression).getVariable();
			edu.ustb.sei.mde.xmu2core.Variable var = varMap.get(AnalysisUtil.getNonUpdatedSourceVariableName(name));

			if (AnalysisUtil.isType(var.getType(), boolean.class)) {
				BoolVar bv = (BoolVar) solverMap.getVariableByName(var.getName());
				return LCF.and(bv);
			}
			throw new BuildException();
		} else if (expression instanceof edu.ustb.sei.mde.xmu2.expression.ConstantExpression) {
			if (expression instanceof edu.ustb.sei.mde.xmu2.expression.BooleanLiteralExpression) {
				return LCF.and(
						VF.fixed(((edu.ustb.sei.mde.xmu2.expression.BooleanLiteralExpression) expression).isValue(),
								solverMap.getSolver()));
			}
			throw new BuildException();
			// } else if (expression instanceof
			// edu.ustb.sei.mde.xmu2.statement.AssignStatement) {
			// return convertAssignStatement(expression, varMap, solverMap);
			// } else if (expression instanceof
			// edu.ustb.sei.mde.xmu2.statement.SwitchStatement) {
			// return convertSwitchStatement(expression, varMap, solverMap);
			// } else if (expression instanceof
			// edu.ustb.sei.mde.xmu2.statement.BlockStatement) {
			// return convertBlockStatement(expression, varMap, solverMap);
		}
		throw new BuildException();

	}

	// public static org.chocosolver.solver.constraints.Constraint
	// convertBlockStatement(EObject expression,
	// VarMapStack varMap, SolverMap solverMap) {
	// EList<Statement> body = ((edu.ustb.sei.mde.xmu2.statement.BlockStatement)
	// expression).getBody();
	// org.chocosolver.solver.constraints.Constraint[] steps = new
	// org.chocosolver.solver.constraints.Constraint[body
	// .size()];
	//
	// for (int i = 0; i < body.size(); i++) {
	// Statement cc = body.get(i);
	// steps[i] = convertBooleanExpression(cc, varMap, solverMap);
	// }
	// return LCF.and(steps);
	// }
	//
	// public static org.chocosolver.solver.constraints.Constraint
	// convertSwitchStatement(EObject expression,
	// VarMapStack varMap, SolverMap solverMap) {
	// EList<CaseClause> cases =
	// ((edu.ustb.sei.mde.xmu2.statement.SwitchStatement)
	// expression).getCases();
	// org.chocosolver.solver.constraints.Constraint[] branches = new
	// org.chocosolver.solver.constraints.Constraint[cases
	// .size()];
	//
	// for (int i = 0; i < cases.size(); i++) {
	// CaseClause cc = cases.get(i);
	// if (cc instanceof ExpressionCaseClause) {
	// branches[i] = LCF.and(
	// convertBooleanExpression(((ExpressionCaseClause) cc).getCondition(),
	// varMap, solverMap),
	// convertBooleanExpression(cc.getAction(), varMap, solverMap));
	// } else
	// throw new BuildException();
	// }
	// return LCF.or(branches);
	// }
	//
	public static org.chocosolver.solver.constraints.Constraint convertAssignStatement(
			edu.ustb.sei.mde.xmu2.statement.AssignStatement expression, VarMapStack varMap, SolverMap solverMap) {
		String leftVarName = expression.getUpdatedVariable().getVariable();
		leftVarName = AnalysisUtil.getUpdatedSourceVariableName(leftVarName);

		edu.ustb.sei.mde.xmu2.expression.Expression right = expression.getValue();

		edu.ustb.sei.mde.xmu2core.Variable leftVar = varMap.get(leftVarName);

		Variable leftValue = null;
		Pair<Variable, Constraint> rightValue = convertValue(right, varMap, solverMap);

		if (AnalysisUtil.isType(leftVar.getType(), int.class)) {
			leftValue = solverMap.getVariableByName(leftVarName);
		} else if (AnalysisUtil.isType(leftVar.getType(), boolean.class)) {
			leftValue = solverMap.getVariableByName(leftVarName);
		} else if (AnalysisUtil.isType(leftVar.getType(), double.class)) {
			leftValue = solverMap.getVariableByName(leftVarName);
		} else {
			throw new BuildException("I can only solve int, real, and boolean constraints");
		}

		org.chocosolver.solver.variables.Variable leftValueFinal = castType(leftValue, rightValue.getFirst(),
				solverMap);
		org.chocosolver.solver.variables.Variable rightValueFinal = castType(rightValue.getFirst(), leftValue,
				solverMap);

		if ((leftValueFinal instanceof BoolVar && rightValueFinal instanceof BoolVar)
				|| (leftValueFinal instanceof IntVar && rightValueFinal instanceof IntVar)) {
			return LCF.and(rightValue.getSecond(), ICF.arithm((IntVar) leftValueFinal, "=", (IntVar) rightValueFinal));
		} else if (leftValueFinal instanceof RealVar && rightValueFinal instanceof RealVar) {
			return LCF.and(rightValue.getSecond(), new org.chocosolver.solver.constraints.real.RealConstraint("",
					"{0}={1}", Ibex.HC4, (RealVar) leftValueFinal, (RealVar) rightValueFinal));
		}

		throw new BuildException("type inconsistent!");
	}

	public static org.chocosolver.solver.constraints.Constraint convertRelationalExpression(Expression expression,
			VarMapStack varMap, SolverMap solverMap) {
		edu.ustb.sei.mde.xmu2.expression.Expression left = ((edu.ustb.sei.mde.xmu2.expression.RelationalExpression) expression)
				.getLeft();
		edu.ustb.sei.mde.xmu2.expression.Expression right = ((edu.ustb.sei.mde.xmu2.expression.RelationalExpression) expression)
				.getRight();

		Pair<Variable, Constraint> leftVal = convertValue(left, varMap, solverMap);
		Pair<Variable, Constraint> rightVal = convertValue(right, varMap, solverMap);

		org.chocosolver.solver.variables.Variable leftValFinal = castType(leftVal.getFirst(), rightVal.getFirst(),
				solverMap);
		org.chocosolver.solver.variables.Variable rightValFinal = castType(rightVal.getFirst(), leftVal.getFirst(),
				solverMap);

		String op = "=";
		if (((edu.ustb.sei.mde.xmu2.expression.RelationalExpression) expression)
				.getOperator() == RelationalOperator.EQUAL) {
			op = "=";
		} else if (((edu.ustb.sei.mde.xmu2.expression.RelationalExpression) expression)
				.getOperator() == RelationalOperator.LESS) {
			op = "<";
		} else if (((edu.ustb.sei.mde.xmu2.expression.RelationalExpression) expression)
				.getOperator() == RelationalOperator.LESS_EQUAL) {
			op = "<=";
		} else if (((edu.ustb.sei.mde.xmu2.expression.RelationalExpression) expression)
				.getOperator() == RelationalOperator.GREATER) {
			op = ">";
		} else if (((edu.ustb.sei.mde.xmu2.expression.RelationalExpression) expression)
				.getOperator() == RelationalOperator.GREATER_EQUAL) {
			op = ">=";
		}

		if ((leftValFinal instanceof BoolVar && rightValFinal instanceof BoolVar)
				|| (leftValFinal instanceof IntVar && rightValFinal instanceof IntVar)) {
			return LCF.and(leftVal.getSecond(), rightVal.getSecond(),
					ICF.arithm((IntVar) leftValFinal, op, (IntVar) rightValFinal));
		} else if (leftValFinal instanceof RealVar && rightValFinal instanceof RealVar) {
			return LCF.and(leftVal.getSecond(), rightVal.getSecond(),
					new org.chocosolver.solver.constraints.real.RealConstraint("", "{0}" + op + "{1}", Ibex.HC4,
							(RealVar) leftValFinal, (RealVar) rightValFinal));
		}
		throw new BuildException();
	}

	public static org.chocosolver.solver.constraints.Constraint convertBooleanAndExpression(Expression expression,
			VarMapStack varMap, SolverMap solverMap) {
		EList<? extends edu.ustb.sei.mde.xmu2.expression.Expression> ops = ((edu.ustb.sei.mde.xmu2.expression.BooleanAndExpression) expression)
				.getOperands();
		org.chocosolver.solver.constraints.Constraint[] operands = new org.chocosolver.solver.constraints.Constraint[ops
				.size()];
		for (int i = 0; i < operands.length; i++) {
			operands[i] = convertBooleanExpression(ops.get(i), varMap, solverMap);
		}
		return LCF.and(operands);
	}

	public static org.chocosolver.solver.constraints.Constraint convertBooleanOrExpression(Expression expression,
			VarMapStack varMap, SolverMap solverMap) {
		EList<? extends edu.ustb.sei.mde.xmu2.expression.Expression> ops = ((edu.ustb.sei.mde.xmu2.expression.BooleanOrExpression) expression)
				.getOperands();
		org.chocosolver.solver.constraints.Constraint[] operands = new org.chocosolver.solver.constraints.Constraint[ops
				.size()];
		for (int i = 0; i < operands.length; i++) {
			operands[i] = convertBooleanExpression(ops.get(i), varMap, solverMap);
		}
		return LCF.or(operands);
	}

	private static Variable castType(Variable leftVal, Variable rightVal, SolverMap solverMap) {
		if (leftVal instanceof IntVar && rightVal instanceof RealVar) {
			return solverMap.getRelatedRealVar(leftVal);
		} else if (leftVal instanceof RealVar && rightVal instanceof IntVar) {
			return leftVal;
		} else
			return leftVal;
	}

	private static Pair<Variable, Constraint> convertValue(Expression expression, VarMapStack varMap,
			SolverMap solverMap) {

		if (expression instanceof edu.ustb.sei.mde.xmu2.expression.BooleanOrExpression) {
			Constraint or = convertBooleanOrExpression(expression, varMap, solverMap);
			return new Pair<Variable, Constraint>(or.reif(), or);
		} else if (expression instanceof edu.ustb.sei.mde.xmu2.expression.BooleanAndExpression) {
			Constraint and = convertBooleanAndExpression(expression, varMap, solverMap);
			return new Pair<Variable, Constraint>(and.reif(), and);
		} else if (expression instanceof edu.ustb.sei.mde.xmu2.expression.RelationalExpression) {
			Constraint rel = convertRelationalExpression(expression, varMap, solverMap);
			return new Pair<Variable, Constraint>(rel.reif(), rel);
		} else if (expression instanceof edu.ustb.sei.mde.xmu2.expression.AdditiveExpression) {
			EList<AdditiveOperator> operators = ((edu.ustb.sei.mde.xmu2.expression.AdditiveExpression) expression)
					.getOperators();
			EList<? extends Expression> operands = ((edu.ustb.sei.mde.xmu2.expression.AdditiveExpression) expression)
					.getOperands();

			Pair<Variable, Constraint>[] vars = new Pair[operands.size()];

			// calc operands
			Class<?> varType = null;
			for (int i = 0; i < operands.size(); i++) {
				boolean minus = false;

				Expression o = operands.get(i);
				if (i != 0) {
					if (operators.get(i - 1) == AdditiveOperator.SUB)
						minus = true;
				}

				if (minus) {
					vars[i] = convertValue(o, varMap, solverMap);
					vars[i].setFirst(solverMap.getMinusVar(vars[i].getFirst()));
				} else {
					vars[i] = convertValue(o, varMap, solverMap);
				}

				if (varType == null)
					varType = vars[i].getClass();
				else {
					if (vars[i].getClass() == RealVar.class)
						varType = RealVar.class;
				}
			}

			// convert according to the largest type
			if (varType != RealVar.class) {
				IntVar sum = VF.bounded(StringUtils.randomName(), VF.MIN_INT_BOUND, VF.MAX_INT_BOUND,
						solverMap.getSolver());
				IntVar[] allVars = new IntVar[vars.length];
				Constraint[] allConstraints = new Constraint[vars.length];

				for (int i = 0; i < vars.length; i++) {
					allVars[i] = (IntVar) vars[i].getFirst();
					allConstraints[i] = vars[i].getSecond();
				}

				Constraint c = LCF.and(LCF.and(allConstraints), ICF.sum(allVars, sum));
				return new Pair<Variable, Constraint>(sum, c);
			} else {
				RealVar sum = VF.real(StringUtils.randomName(), VF.MIN_INT_BOUND, VF.MAX_INT_BOUND, SolverMap.PRECISION,
						solverMap.getSolver());
				RealVar[] allVars = new RealVar[vars.length + 1];
				allVars[0] = sum;

				StringBuilder realSum = new StringBuilder();
				realSum.append("{0}=");
				for (int i = 0; i < vars.length; i++) {
					if (i == 0)
						realSum.append("{" + (i + 1) + "}");
					else
						realSum.append("+{" + (i + 1) + "}");

					allVars[i + 1] = (RealVar) solverMap.getRelatedRealVar(vars[i].getFirst());
				}

				return new Pair<Variable, Constraint>(sum,
						new RealConstraint(StringUtils.randomName(), realSum.toString(), allVars));

			}
			// throw new BuildException();

		} else if (expression instanceof edu.ustb.sei.mde.xmu2.expression.MultiplicativeExpression) {
			EList<MultiplicativeOperator> operators = ((edu.ustb.sei.mde.xmu2.expression.MultiplicativeExpression) expression)
					.getOperators();
			EList<? extends Expression> operands = ((edu.ustb.sei.mde.xmu2.expression.MultiplicativeExpression) expression)
					.getOperands();
			Pair<Variable, Constraint>[] vars = new Pair[operands.size()];
			Constraint[] cons = new Constraint[operators.size() + operands.size()];

			Class<?> varType = null;
			for (int i = 0; i < operands.size(); i++) {
				Expression o = operands.get(i);
				vars[i] = convertValue(o, varMap, solverMap);

				if (varType == null)
					varType = vars[i].getFirst().getClass();
				else {
					if (vars[i].getFirst().getClass() == RealVar.class)
						varType = RealVar.class;
				}

				cons[i] = vars[i].getSecond();
			}

			if (varType != RealVar.class) {
				IntVar lastVar = (IntVar) vars[0].getFirst();

				for (int i = 0; i < operators.size(); i++) {
					IntVar sum = VF.bounded(StringUtils.randomName(), VF.MIN_INT_BOUND, VF.MAX_INT_BOUND,
							solverMap.getSolver());
					IntVar curVar = (IntVar) vars[i + 1].getFirst();

					if (operators.get(i) == MultiplicativeOperator.MUL) {
						cons[operands.size() + i] = ICF.times(lastVar, curVar, sum);
					} else {
						cons[operands.size() + i] = ICF.eucl_div(lastVar, curVar, sum);
					}
					lastVar = sum;
				}

				return new Pair<Variable, Constraint>(lastVar, LCF.and(cons));
			} else {
				RealVar lastVar = (RealVar) solverMap.getRelatedRealVar(vars[0].getFirst());

				for (int i = 0; i < operators.size(); i++) {
					RealVar sum = VF.real(StringUtils.randomName(), VF.MIN_INT_BOUND, VF.MAX_INT_BOUND,
							SolverMap.PRECISION, solverMap.getSolver());
					RealVar curVar = (RealVar) solverMap.getRelatedRealVar(vars[i + 1].getFirst());

					if (operators.get(i) == MultiplicativeOperator.MUL) {
						cons[operands.size() + i] = new RealConstraint("", "{0}*{1}={2}", lastVar, curVar, sum);
					} else {
						cons[operands.size() + i] = new RealConstraint("", "{0}/{1}={2}", lastVar, curVar, sum);
					}
					lastVar = sum;
				}

				return new Pair<Variable, Constraint>(lastVar, LCF.and(cons));

			}
		} else if (expression instanceof edu.ustb.sei.mde.xmu2.expression.UnaryExpression) {
			if (((edu.ustb.sei.mde.xmu2.expression.UnaryExpression) expression).getOperator() == UnaryOperator.NOT) {
				Constraint not = LCF.not(convertBooleanExpression(
						((edu.ustb.sei.mde.xmu2.expression.UnaryExpression) expression).getBody(), varMap, solverMap));
				return new Pair<Variable, Constraint>(not.reif(), not);
			} else if (((edu.ustb.sei.mde.xmu2.expression.UnaryExpression) expression)
					.getOperator() == UnaryOperator.MINUS) {
				Pair<Variable, Constraint> var = convertValue(
						((edu.ustb.sei.mde.xmu2.expression.UnaryExpression) expression).getBody(), varMap, solverMap);
				return new Pair<Variable, Constraint>(solverMap.getMinusVar(var.getFirst()), var.getSecond());
			}
			throw new BuildException();
		} else if (expression instanceof edu.ustb.sei.mde.xmu2.expression.ParenExpression) {
			return convertValue(((edu.ustb.sei.mde.xmu2.expression.ParenExpression) expression).getBody(), varMap,
					solverMap);
		} else if (expression instanceof edu.ustb.sei.mde.xmu2.expression.VariableExpression) {
			String name = ((edu.ustb.sei.mde.xmu2.expression.VariableExpression) expression).getVariable();
			edu.ustb.sei.mde.xmu2core.Variable var = varMap.get(AnalysisUtil.getNonUpdatedSourceVariableName(name));

			if (AnalysisUtil.isType(var.getType(), boolean.class) || AnalysisUtil.isType(var.getType(), int.class)
					|| AnalysisUtil.isType(var.getType(), double.class)) {
				return new Pair<Variable, Constraint>(solverMap.getVariableByName(var.getName()),
						LCF.and(ICF.TRUE(solverMap.getSolver())));
			} else {
				// string or object
				return new Pair<Variable, Constraint>(solverMap.getVariableByName(var.getName()),
						LCF.and(ICF.TRUE(solverMap.getSolver())));
			}
		} else if (expression instanceof edu.ustb.sei.mde.xmu2.expression.ConstantExpression) {
			if (expression instanceof edu.ustb.sei.mde.xmu2.expression.BooleanLiteralExpression) {
				return new Pair<Variable, Constraint>(
						VF.fixed(((edu.ustb.sei.mde.xmu2.expression.BooleanLiteralExpression) expression).isValue(),
								solverMap.getSolver()),
						LCF.and(ICF.TRUE(solverMap.getSolver())));
			} else if (expression instanceof edu.ustb.sei.mde.xmu2.expression.IntegerLiteralExpression) {
				return new Pair<Variable, Constraint>(
						VF.fixed(((edu.ustb.sei.mde.xmu2.expression.IntegerLiteralExpression) expression).getValue(),
								solverMap.getSolver()),
						LCF.and(ICF.TRUE(solverMap.getSolver())));
			} else if (expression instanceof edu.ustb.sei.mde.xmu2.expression.EnumLiteralExpression) {
				return new Pair<Variable, Constraint>(VF.fixed(
						((edu.ustb.sei.mde.xmu2.expression.EnumLiteralExpression) expression).getValue().getValue(),
						solverMap.getSolver()), LCF.and(ICF.TRUE(solverMap.getSolver())));
			} else if (expression instanceof edu.ustb.sei.mde.xmu2.expression.EmptyExpression) {
				EmptyValueType type = ((edu.ustb.sei.mde.xmu2.expression.EmptyExpression) expression).getType();
				if (type == EmptyValueType.NULL_VALUE) {
					return new Pair<Variable, Constraint>(VF.fixed(VF.MAX_INT_BOUND, solverMap.getSolver()),
							LCF.and(ICF.TRUE(solverMap.getSolver())));
				} else
					throw new BuildException();
			} else {
				if (expression instanceof edu.ustb.sei.mde.xmu2.expression.StringLiteralExpression)
					return new Pair<Variable, Constraint>(VF.fixed(
							getIntValue(
									((edu.ustb.sei.mde.xmu2.expression.StringLiteralExpression) expression).getValue()),
							solverMap.getSolver()), LCF.and(ICF.TRUE(solverMap.getSolver())));
				else if (expression instanceof edu.ustb.sei.mde.xmu2.expression.ObjectURIExpression)
					return new Pair<Variable, Constraint>(VF.fixed(
							getIntValue(
									((edu.ustb.sei.mde.xmu2.expression.ObjectURIExpression) expression).getObject()),
							solverMap.getSolver()), LCF.and(ICF.TRUE(solverMap.getSolver())));
			}
			throw new BuildException();
			// } else if (expression instanceof
			// edu.ustb.sei.mde.xmu2.statement.AssignStatement) {
			// Constraint c = convertAssignStatement(expression, varMap,
			// solverMap);
			// return new Pair<Variable,Constraint>(c.reif(),c);
			//
			// } else if (expression instanceof
			// edu.ustb.sei.mde.xmu2.statement.SwitchStatement) {
			// Constraint c = convertSwitchStatement(expression, varMap,
			// solverMap);
			// return new Pair<Variable,Constraint>(c.reif(),c);
			// } else if (expression instanceof
			// edu.ustb.sei.mde.xmu2.statement.BlockStatement) {
			// Constraint c = convertBlockStatement(expression, varMap,
			// solverMap);
			// return new Pair<Variable,Constraint>(c.reif(),c);
		}
		throw new BuildException();
	}

	public static int getIntValue(Object value) {
		throw new BuildException();
	}
}

class SolverMap {

	public static final double PRECISION = 0.00001;
	private org.chocosolver.solver.Solver solver;

	public org.chocosolver.solver.Solver getSolver() {
		return solver;
	}

	public Variable getRelatedRealVar(Variable leftVal) {
		String rVar = "(real)" + leftVal.getName();
		org.chocosolver.solver.variables.Variable rv = getVariableByName(rVar);
		if (rv == null) {
			rv = VF.real((IntVar) leftVal, PRECISION);
		}
		return rv;
	}

	public org.chocosolver.solver.variables.Variable getVariableByName(String name) {
		for (org.chocosolver.solver.variables.Variable var : solver.getVars()) {
			if (name.equals(var.getName()))
				return var;
		}
		return null;
	}

	public org.chocosolver.solver.variables.Variable createVariable(edu.ustb.sei.mde.xmu2core.Variable v) {
		if (AnalysisUtil.isType(v.getType(), int.class)) {
			return VF.bounded(v.getName(), VF.MIN_INT_BOUND, VF.MAX_INT_BOUND, solver);
		} else if (AnalysisUtil.isType(v.getType(), boolean.class)) {
			return VF.bool(v.getName(), solver);
		} else if (AnalysisUtil.isType(v.getType(), double.class)) {
			return VF.real(v.getName(), (double) VF.MIN_INT_BOUND, (double) VF.MAX_INT_BOUND, PRECISION, solver);
		} else {
			// collect domain
			// return VF.enumeration
			throw new BuildException();
		}
	}

	public Variable getMinusVar(org.chocosolver.solver.variables.Variable var) {
		if (var instanceof IntVar) {
			return VF.minus((IntVar) var);
		} else if (var instanceof RealVar) {
			RealVar mv = VF.real(StringUtils.randomName(), -((RealVar) var).getUB(), -((RealVar) var).getLB(),
					SolverMap.PRECISION, solver);
			solver.post(new org.chocosolver.solver.constraints.real.RealConstraint("", "{0}=-{1}", Ibex.HC4, mv,
					(RealVar) var));
			return mv;
		} else
			throw new BuildException();
	}

	public SolverMap(String fnName) {
		solver = new Solver(fnName);
	}
}