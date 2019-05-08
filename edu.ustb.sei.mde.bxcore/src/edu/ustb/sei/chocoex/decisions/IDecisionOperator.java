package edu.ustb.sei.chocoex.decisions;

import org.chocosolver.solver.ICause;
import org.chocosolver.solver.exception.ContradictionException;
import org.chocosolver.solver.variables.Variable;

public interface IDecisionOperator<V extends Variable, D> {
	boolean apply(V var, D value, ICause cause) throws ContradictionException;

    boolean unapply(V var, D value, ICause cause) throws ContradictionException;

    IDecisionOperator<V,D> opposite();

    String toString();
}
