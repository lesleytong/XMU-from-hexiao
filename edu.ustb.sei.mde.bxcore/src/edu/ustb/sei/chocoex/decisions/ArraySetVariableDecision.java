package edu.ustb.sei.chocoex.decisions;

import org.chocosolver.solver.ICause;
import org.chocosolver.solver.exception.ContradictionException;
import org.chocosolver.util.PoolManager;

import edu.ustb.sei.chocoex.variables.AbstractArraySetVariable;

public class ArraySetVariableDecision<T> extends DecisionEx<AbstractArraySetVariable<T>,T> {
	private static final long serialVersionUID = -7396944580439750320L;
	
	@Override
	protected DecisionEx<AbstractArraySetVariable<T>, T> newDecisionEx(
			PoolManager<DecisionEx<AbstractArraySetVariable<T>, T>> poolManager) {
		return new ArraySetVariableDecision<>(poolManager);
	}
	
	public ArraySetVariableDecision(PoolManager<DecisionEx<AbstractArraySetVariable<T>,T>> poolManager) {
		super(poolManager);
	}
	
	@SuppressWarnings("rawtypes")
	static final public ValueForceOperator force = new ValueForceOperator();
	@SuppressWarnings("rawtypes")
	static final public ValueRemoveOperator remove = new ValueRemoveOperator();
}

class ValueForceOperator<T> implements IDecisionOperator<AbstractArraySetVariable<T>, T> {

	@Override
	public boolean apply(AbstractArraySetVariable<T> var, T value, ICause cause) throws ContradictionException {
		return var.force(value, cause);
	}

	@Override
	public boolean unapply(AbstractArraySetVariable<T> var, T value, ICause cause) throws ContradictionException {
		return var.remove(value, cause);
	}

	@SuppressWarnings("unchecked")
	@Override
	public IDecisionOperator<AbstractArraySetVariable<T>, T> opposite() {
		return ArraySetVariableDecision.remove;
	}
	
}


class ValueRemoveOperator<T> implements IDecisionOperator<AbstractArraySetVariable<T>, T> {

	@Override
	public boolean apply(AbstractArraySetVariable<T> var, T value, ICause cause) throws ContradictionException {
		return var.remove(value, cause);
	}

	@Override
	public boolean unapply(AbstractArraySetVariable<T> var, T value, ICause cause) throws ContradictionException {
		return var.force(value, cause);
	}

	@SuppressWarnings("unchecked")
	@Override
	public IDecisionOperator<AbstractArraySetVariable<T>, T> opposite() {
		return ArraySetVariableDecision.force;
	}
	
}
