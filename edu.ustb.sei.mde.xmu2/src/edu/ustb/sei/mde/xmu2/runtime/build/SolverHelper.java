package edu.ustb.sei.mde.xmu2.runtime.build;

import org.chocosolver.solver.Solver;
import org.chocosolver.solver.constraints.Constraint;
import org.chocosolver.solver.constraints.ICF;
import org.chocosolver.solver.constraints.LCF;
import org.chocosolver.solver.constraints.real.Ibex;
import org.chocosolver.solver.variables.BoolVar;
import org.chocosolver.solver.variables.IntVar;
import org.chocosolver.solver.variables.RealVar;
import org.chocosolver.solver.variables.VF;
import org.chocosolver.solver.variables.Variable;
import org.chocosolver.util.tools.StringUtils;
import org.eclipse.emf.common.util.EList;

import com.sun.media.sound.InvalidFormatException;

import edu.ustb.sei.mde.xmu2.runtime.exceptions.BuildException;
import edu.ustb.sei.mde.xmu2.runtime.exceptions.InvalidForwardEnforcementException;
import edu.ustb.sei.mde.xmu2.runtime.structures.Context;
import edu.ustb.sei.mde.xmu2.runtime.values.SafeType;
import edu.ustb.sei.mde.xmu2.util.AnalysisUtil;
import edu.ustb.sei.mde.xmu2common.AdditiveOperator;
import edu.ustb.sei.mde.xmu2common.DomainTag;
import edu.ustb.sei.mde.xmu2common.MultiplicativeOperator;
import edu.ustb.sei.mde.xmu2common.RelationalOperator;
import edu.ustb.sei.mde.xmu2common.UnaryOperator;
import edu.ustb.sei.mde.xmu2core.SolveConstraintStatement;

public class SolverHelper {

	static public void executeSolveConstraintStatement(SolveConstraintStatement stmt, Context context) {
		SolverMap map = new SolverMap("SolveConstraintStatement " + stmt.hashCode());
		
		for (edu.ustb.sei.mde.xmu2core.Variable v : stmt.getVariables()) {
			Variable var = map.createVariable(v);
			SafeType val = context.get(v);
			
			if(v.getTag()==DomainTag.VIEW) {
				if(val.isUndefined()==false) {
					map.setValue(var,val);
				}
			} else {
				map.setValue(var,val);
			}
		}
		Constraint c = convertBooleanExpression(stmt.getConstraint(),stmt, map);
		map.getSolver().post(c);
		
		if(map.getSolver().findSolution()==false) {
			throw new InvalidForwardEnforcementException("cannot find a solution");
		} else {
			for (edu.ustb.sei.mde.xmu2core.Variable v : stmt.getVariables()) {
				if(v.getTag()==DomainTag.VIEW) {
					Variable var = map.getVariableByName(v.getName());
					SafeType val = null;
					if(var instanceof BoolVar) {
						if(((BoolVar) var).getValue()==1) {
							val = SafeType.TRUE;
						} else {
							val = SafeType.FALSE;
						}
					} else if(var instanceof IntVar) {
						val = SafeType.createFromValue(((IntVar) var).getValue());
					} else
						throw new InvalidForwardEnforcementException();
					
					context.put(v, val);
				}
			}
		}
		
		return;
	}

	static public org.chocosolver.solver.constraints.Constraint convertBooleanExpression(edu.ustb.sei.mde.xmu2core.Expression expression,
			edu.ustb.sei.mde.xmu2core.SolveConstraintStatement stmt, SolverMap solverMap) {
		if (expression instanceof edu.ustb.sei.mde.xmu2core.BooleanOrExpression) {
			return convertBooleanOrExpression(expression, stmt, solverMap);
			
		} else if (expression instanceof edu.ustb.sei.mde.xmu2core.BooleanAndExpression) {
			return convertBooleanAndExpression(expression, stmt, solverMap);
			
		} else if (expression instanceof edu.ustb.sei.mde.xmu2core.RelationalExpression) {
			return convertRelationalExpression(expression, stmt, solverMap);
			
		} else if (expression instanceof edu.ustb.sei.mde.xmu2.expression.UnaryExpression) {
			if (((edu.ustb.sei.mde.xmu2core.UnaryExpression) expression).getOperator() == UnaryOperator.NOT) {
				return LCF.not(convertBooleanExpression(
						((edu.ustb.sei.mde.xmu2core.UnaryExpression) expression).getBody(), stmt, solverMap));
			}
			throw new BuildException();
			
		} else if (expression instanceof edu.ustb.sei.mde.xmu2core.VariableExpression) {
			edu.ustb.sei.mde.xmu2core.Variable var = ((edu.ustb.sei.mde.xmu2core.VariableExpression) expression).getVariable();
			if (AnalysisUtil.isType(var.getType(), boolean.class)) {
				BoolVar bv = (BoolVar) solverMap.getVariableByName(var.getName());
				return LCF.and(bv);
			}
			throw new BuildException();
		} else if (expression instanceof edu.ustb.sei.mde.xmu2core.PrimitiveValueExpression) {
			if (expression instanceof edu.ustb.sei.mde.xmu2core.BooleanValueExpression) {
				return LCF.and(
						VF.fixed(((edu.ustb.sei.mde.xmu2core.BooleanValueExpression) expression).isValue(),
								solverMap.getSolver()));
			}
			throw new BuildException();
		}
		throw new BuildException();

	}

	public static org.chocosolver.solver.constraints.Constraint convertRelationalExpression(edu.ustb.sei.mde.xmu2core.Expression expression,
			SolveConstraintStatement stmt, SolverMap solverMap) {
		edu.ustb.sei.mde.xmu2core.Expression left = ((edu.ustb.sei.mde.xmu2core.RelationalExpression) expression)
				.getLeft();
		edu.ustb.sei.mde.xmu2core.Expression right = ((edu.ustb.sei.mde.xmu2core.RelationalExpression) expression)
				.getRight();

		Variable leftVal = convertValue(left, stmt, solverMap);
		Variable rightVal = convertValue(right, stmt, solverMap);


		String op = "=";
		if (((edu.ustb.sei.mde.xmu2core.RelationalExpression) expression)
				.getOperator() == RelationalOperator.EQUAL) {
			op = "=";
		} else if (((edu.ustb.sei.mde.xmu2core.RelationalExpression) expression)
				.getOperator() == RelationalOperator.LESS) {
			op = "<";
		} else if (((edu.ustb.sei.mde.xmu2core.RelationalExpression) expression)
				.getOperator() == RelationalOperator.LESS_EQUAL) {
			op = "<=";
		} else if (((edu.ustb.sei.mde.xmu2core.RelationalExpression) expression)
				.getOperator() == RelationalOperator.GREATER) {
			op = ">";
		} else if (((edu.ustb.sei.mde.xmu2core.RelationalExpression) expression)
				.getOperator() == RelationalOperator.GREATER_EQUAL) {
			op = ">=";
		}

		return solverMap.getRelationalConstraint(leftVal,op, rightVal);
	}

	private static Variable convertValue(edu.ustb.sei.mde.xmu2core.Expression expression, SolveConstraintStatement stmt,
			SolverMap solverMap) {
		if (expression instanceof edu.ustb.sei.mde.xmu2core.BooleanOrExpression) {
			Constraint or = convertBooleanOrExpression(expression, stmt, solverMap);
			BoolVar res = VF.bool(StringUtils.randomName("OR"), solverMap.getSolver());
			LCF.reification(res, or);
			return res;
			
		} else if (expression instanceof edu.ustb.sei.mde.xmu2core.BooleanAndExpression) {
			Constraint and = convertBooleanAndExpression(expression, stmt, solverMap);
			BoolVar res = VF.bool(StringUtils.randomName("AND"), solverMap.getSolver());
			LCF.reification(res, and);
			return res;
			
		} else if (expression instanceof edu.ustb.sei.mde.xmu2core.RelationalExpression) {
			Constraint rel = convertRelationalExpression(expression, stmt, solverMap);
			BoolVar res = VF.bool(StringUtils.randomName("REL"), solverMap.getSolver());
			LCF.reification(res, rel);
			return res;
			
		} else if (expression instanceof edu.ustb.sei.mde.xmu2core.AdditiveExpression) {
			EList<AdditiveOperator> operators = ((edu.ustb.sei.mde.xmu2core.AdditiveExpression) expression)
					.getOperators();
			EList<edu.ustb.sei.mde.xmu2core.Expression> operands = ((edu.ustb.sei.mde.xmu2core.AdditiveExpression) expression)
					.getOperands();

			Variable res = null;
			for (int i = 0; i < operands.size(); i++) {
				edu.ustb.sei.mde.xmu2core.Expression exp = operands.get(i);
				if(res==null)
					res = convertValue(exp,stmt,solverMap);
				else {
					edu.ustb.sei.mde.xmu2common.AdditiveOperator op = operators.get(i-1);
					Variable ope = convertValue(exp,stmt,solverMap);
					if(op==AdditiveOperator.ADD)
						res = solverMap.getSumVar(res, ope);
					else if(op==AdditiveOperator.SUB)
						res = solverMap.getSubVar(res, ope);
					else throw new BuildException();
				}
			}

			return res;

		} else if (expression instanceof edu.ustb.sei.mde.xmu2core.MultiplicativeExpression) {
			EList<MultiplicativeOperator> operators = ((edu.ustb.sei.mde.xmu2core.MultiplicativeExpression) expression)
					.getOperators();
			EList<edu.ustb.sei.mde.xmu2core.Expression> operands = ((edu.ustb.sei.mde.xmu2core.MultiplicativeExpression) expression)
					.getOperands();

			Variable res = null;
			for (int i = 0; i < operands.size(); i++) {
				edu.ustb.sei.mde.xmu2core.Expression exp = operands.get(i);
				if(res==null)
					res = convertValue(exp,stmt,solverMap);
				else {
					edu.ustb.sei.mde.xmu2common.MultiplicativeOperator op = operators.get(i-1);
					Variable ope = convertValue(exp,stmt,solverMap);
					if(op==MultiplicativeOperator.MUL)
						res = solverMap.getMulVar(res, ope);
					else if(op==MultiplicativeOperator.DIV)
						res = solverMap.getDivVar(res, ope);
					else throw new BuildException();
				}
			}

			return res;
		} else if (expression instanceof edu.ustb.sei.mde.xmu2core.UnaryExpression) {
			if (((edu.ustb.sei.mde.xmu2core.UnaryExpression) expression).getOperator() == UnaryOperator.NOT) {
				Constraint not = LCF.not(convertBooleanExpression(
						((edu.ustb.sei.mde.xmu2core.UnaryExpression) expression).getBody(), stmt, solverMap));
				BoolVar notV = VF.bool(StringUtils.randomName("NOT"), solverMap.getSolver());
				LCF.reification_reifiable(notV, not);
				return notV;
				
			} else if (((edu.ustb.sei.mde.xmu2core.UnaryExpression) expression)
					.getOperator() == UnaryOperator.MINUS) {
				Variable v = convertValue(expression, stmt, solverMap);
				return solverMap.getMinusVar(v);
			}
			throw new BuildException();
		} else if (expression instanceof edu.ustb.sei.mde.xmu2core.VariableExpression) {
			edu.ustb.sei.mde.xmu2core.Variable var = ((edu.ustb.sei.mde.xmu2core.VariableExpression) expression).getVariable();

			if (AnalysisUtil.isType(var.getType(), boolean.class) || AnalysisUtil.isType(var.getType(), int.class)
					|| AnalysisUtil.isType(var.getType(), double.class)) {
				return solverMap.getVariableByName(var.getName());
			} else {
				throw new BuildException();
			}
		} else if (expression instanceof edu.ustb.sei.mde.xmu2core.PrimitiveValueExpression) {
			if (expression instanceof edu.ustb.sei.mde.xmu2core.BooleanValueExpression) {
				return VF.fixed(((edu.ustb.sei.mde.xmu2core.BooleanValueExpression) expression).isValue(), 
						solverMap.getSolver());
				
			} else if (expression instanceof edu.ustb.sei.mde.xmu2core.IntegerValueExpression) {
				return VF.fixed(((edu.ustb.sei.mde.xmu2core.IntegerValueExpression) expression).getValue(),
								solverMap.getSolver());
				
			} else if (expression instanceof edu.ustb.sei.mde.xmu2core.EnumValueExpression) {
				throw new BuildException();
				
			} else if (expression instanceof edu.ustb.sei.mde.xmu2.expression.EmptyExpression) {
				throw new BuildException();
				
			} else {
				throw new BuildException();
				
			}
		}
		throw new BuildException();
	}

	public static org.chocosolver.solver.constraints.Constraint convertBooleanAndExpression(edu.ustb.sei.mde.xmu2core.Expression expression,
			SolveConstraintStatement stmt, SolverMap solverMap) {
		EList<? extends edu.ustb.sei.mde.xmu2core.Expression> ops = ((edu.ustb.sei.mde.xmu2core.BooleanAndExpression) expression)
				.getOperands();
		org.chocosolver.solver.constraints.Constraint[] operands = new org.chocosolver.solver.constraints.Constraint[ops
				.size()];
		for (int i = 0; i < operands.length; i++) {
			operands[i] = convertBooleanExpression(ops.get(i), stmt, solverMap);
		}
		return solverMap.getAndConstraint(operands);
	}

	public static org.chocosolver.solver.constraints.Constraint convertBooleanOrExpression(edu.ustb.sei.mde.xmu2core.Expression expression,
			SolveConstraintStatement stmt, SolverMap solverMap) {
		EList<? extends edu.ustb.sei.mde.xmu2core.Expression> ops = ((edu.ustb.sei.mde.xmu2core.BooleanOrExpression) expression)
				.getOperands();
		org.chocosolver.solver.constraints.Constraint[] operands = new org.chocosolver.solver.constraints.Constraint[ops
				.size()];
		for (int i = 0; i < operands.length; i++) {
			operands[i] = convertBooleanExpression(ops.get(i), stmt, solverMap);
		}
		return solverMap.getOrConstraint(operands);
	}

	private static Variable castType(Variable leftVal, Variable rightVal, SolverMap solverMap) {
		if (leftVal instanceof IntVar && rightVal instanceof RealVar) {
			return solverMap.getRelatedRealVar(leftVal);
		} else if (leftVal instanceof RealVar && rightVal instanceof IntVar) {
			return leftVal;
		} else
			return leftVal;
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

	public void setValue(Variable var, SafeType val) {
		if(val.isBoolean()) {
			if(val.getBooleanValue()) {
				solver.post(LCF.and((BoolVar)var));
			} else {
				solver.post(LCF.not(LCF.and((BoolVar)var)));
			}
		} else if(val.isInteger()) {
			solver.post(ICF.arithm((IntVar)var, "=", 
					val.getIntegerValue()));
		} else {
			throw new BuildException();
		}
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
	
	public Variable getMulVar(org.chocosolver.solver.variables.Variable left, org.chocosolver.solver.variables.Variable right) {
		if(left instanceof IntVar && right instanceof IntVar) {
			IntVar sum = VF.bounded(StringUtils.randomName("SUM"), VF.MIN_INT_BOUND, VF.MAX_INT_BOUND, solver);
			solver.post(ICF.times((IntVar)left, (IntVar)right, sum));
			return sum;
		} else if(left instanceof RealVar && right instanceof RealVar) {
			throw new BuildException();
		} else {
			throw new BuildException();
		}
	}
	
	public Variable getDivVar(org.chocosolver.solver.variables.Variable left, org.chocosolver.solver.variables.Variable right) {
		if(left instanceof IntVar && right instanceof IntVar) {
			IntVar sum = VF.bounded(StringUtils.randomName("SUM"), VF.MIN_INT_BOUND, VF.MAX_INT_BOUND, solver);
			solver.post(ICF.eucl_div((IntVar)left, (IntVar)right, sum));
			return sum;
		} else if(left instanceof RealVar && right instanceof RealVar) {
			throw new BuildException();
		} else {
			throw new BuildException();
		}
	}
	
	public Variable getSubVar(org.chocosolver.solver.variables.Variable left, org.chocosolver.solver.variables.Variable right) {
		if(left instanceof IntVar && right instanceof IntVar) {
			IntVar sum = VF.bounded(StringUtils.randomName("SUM"), VF.MIN_INT_BOUND, VF.MAX_INT_BOUND, solver);
			solver.post(ICF.sum(new IntVar[]{(IntVar)left,(IntVar)getMinusVar(right)}, sum));
			return sum;
		} else if(left instanceof RealVar && right instanceof RealVar) {
			throw new BuildException();
		} else {
			throw new BuildException();
		}
	}
	
	public Variable getSumVar(org.chocosolver.solver.variables.Variable left, org.chocosolver.solver.variables.Variable right) {
		if(left instanceof IntVar && right instanceof IntVar) {
			IntVar sum = VF.bounded(StringUtils.randomName("SUM"), VF.MIN_INT_BOUND, VF.MAX_INT_BOUND, solver);
			solver.post(ICF.sum(new IntVar[]{(IntVar)left,(IntVar)right}, sum));
			return sum;
		} else if(left instanceof RealVar && right instanceof RealVar) {
			throw new BuildException();
		} else {
			throw new BuildException();
		}
	}
	
	public Constraint getRelationalConstraint(org.chocosolver.solver.variables.Variable left,String op, org.chocosolver.solver.variables.Variable right) {
		if(left instanceof IntVar && right instanceof IntVar) {
			return ICF.arithm((IntVar)left, op, (IntVar)right);
		} else if(left instanceof RealVar && right instanceof RealVar) {
			throw new BuildException();
		} else {
			throw new BuildException();
		}
	}
	
	public Constraint getNotConstraint(Constraint cons) {
		return LCF.not(cons);
	}
	
	public Constraint getAndConstraint(Constraint... cons) {
		return LCF.and(cons);
	}
	
	public Constraint getOrConstraint(Constraint... cons) {
		return LCF.or(cons);
	}

	public SolverMap(String fnName) {
		solver = new Solver(fnName);
	}
}