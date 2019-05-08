package edu.ustb.sei.chocoex.decisions;

import org.chocosolver.solver.variables.Variable;

public interface ValueSelector<V extends Variable, T> {
	T selectValue(V var);
}
