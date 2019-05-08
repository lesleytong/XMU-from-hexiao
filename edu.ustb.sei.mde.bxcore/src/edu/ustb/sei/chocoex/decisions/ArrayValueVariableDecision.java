package edu.ustb.sei.chocoex.decisions;

import org.chocosolver.solver.ICause;
import org.chocosolver.solver.exception.ContradictionException;
import org.chocosolver.util.PoolManager;

import edu.ustb.sei.chocoex.variables.AbstractArrayValueVariable;

public class ArrayValueVariableDecision<T> extends DecisionEx<AbstractArrayValueVariable<T>,T> {
	private static final long serialVersionUID = 5578018200280614403L;
	
	public ArrayValueVariableDecision(PoolManager<DecisionEx<AbstractArrayValueVariable<T>,T>> poolManager) {
		super(poolManager);
	}
	
	@SuppressWarnings("rawtypes")
	static public final ValueEqOperator eq = new ValueEqOperator();
	@SuppressWarnings("rawtypes")
	static public final ValueNeqOperator neq = new ValueNeqOperator();

	@Override
	protected DecisionEx<AbstractArrayValueVariable<T>, T> newDecisionEx(
			PoolManager<DecisionEx<AbstractArrayValueVariable<T>, T>> poolManager) {
		return new ArrayValueVariableDecision<>(poolManager);
	}
	

}

class ValueEqOperator<T> implements IDecisionOperator<AbstractArrayValueVariable<T>, T> {
	@Override
	public boolean apply(AbstractArrayValueVariable<T> var, T value, ICause cause) throws ContradictionException {
		return var.instantiateTo(value, cause);
	}
	
	@Override
	public boolean unapply(AbstractArrayValueVariable<T> var, T value, ICause cause) throws ContradictionException {
		return var.removeValue(value, cause);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public IDecisionOperator<AbstractArrayValueVariable<T>, T> opposite() {
		return ArrayValueVariableDecision.neq;
	}
	
}

class ValueNeqOperator<T> implements IDecisionOperator<AbstractArrayValueVariable<T>, T> {
	@Override
	public boolean apply(AbstractArrayValueVariable<T> var, T value, ICause cause) throws ContradictionException {
		return var.removeValue(value, cause);
	}
	
	@Override
	public boolean unapply(AbstractArrayValueVariable<T> var, T value, ICause cause) throws ContradictionException {
		return var.instantiateTo(value, cause);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public IDecisionOperator<AbstractArrayValueVariable<T>, T> opposite() {
		return ArrayValueVariableDecision.eq;
	}
	
}