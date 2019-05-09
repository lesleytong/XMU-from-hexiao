package edu.ustb.sei.chocoex.decisions;

import org.chocosolver.solver.exception.ContradictionException;
import org.chocosolver.solver.search.strategy.decision.Decision;
import org.chocosolver.solver.variables.Variable;
import org.chocosolver.util.PoolManager;


abstract public class DecisionEx<V extends Variable,T> extends Decision<V> {
	private static final long serialVersionUID = -5357952008023700822L;

	public DecisionEx(PoolManager<DecisionEx<V,T>> poolManager) {
		super(2);
		this.poolManager = poolManager;
	}

	protected V var;
	protected T value;
	protected IDecisionOperator<V, T> assignment;
	protected PoolManager<DecisionEx<V,T>> poolManager;

	public void set(V var, T value, IDecisionOperator<V,T> assignment) {
		this.var = var;
		this.value = value;
		this.assignment = assignment;
	}

	@Override
	public void apply() throws ContradictionException {
		if(this.branch==1)
			this.assignment.apply(var, value, this);
		else 
			this.assignment.unapply(var, value, this);
	}

	@Override
	public Object getDecisionValue() {
		return value;
	}

	@Override
	public void free() {
		poolManager.returnE(this);
	}
	
	abstract protected DecisionEx<V,T> newDecisionEx(PoolManager<DecisionEx<V,T>> poolManager);
	
	public Decision<V> duplicate() {
		DecisionEx<V,T> d = (DecisionEx<V, T>) poolManager.getE();
        if (d == null) {
            d = newDecisionEx(poolManager);
        }
        d.set(var, value, assignment);
//        d.branch = this.branch;
        return d;
	}

	@SuppressWarnings("rawtypes")
	public boolean isEquivalentTo(Decision dec) {
		if(dec instanceof DecisionEx) {
			DecisionEx sd = (DecisionEx) dec;
			return this.var == sd.var 
					&& this.value == sd.value
					&& this.branch == sd.branch
					&& this.assignment == sd.assignment;
		} else
			return false;
	}
	
	@Override
	public void reverse() {
		this.assignment = this.assignment.opposite();
	}

}
