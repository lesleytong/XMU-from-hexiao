package edu.ustb.sei.chocoex.decisions;

import org.chocosolver.solver.Model;
import org.chocosolver.solver.search.strategy.selectors.variables.InputOrder;
import org.chocosolver.solver.search.strategy.selectors.variables.VariableSelector;
import org.chocosolver.solver.search.strategy.strategy.AbstractStrategy;
import org.chocosolver.solver.variables.Variable;
import org.chocosolver.util.PoolManager;


public abstract class AbstractStrategyEx<V extends Variable, T> extends AbstractStrategy<V> {
	protected VariableSelector<V> varSelector;
	protected ValueSelector<V,T> valSelector;
	transient protected final PoolManager<DecisionEx<V, T>> poolManager;

	@SuppressWarnings("unchecked")
	public AbstractStrategyEx(Model model, ValueSelector<V,T> selector, V... variables) {
		super(variables);
		varSelector = new InputOrder<V>(model);
		poolManager = new PoolManager<>();
		valSelector = selector;
	}
	
	@Override
	public DecisionEx<V,T> getDecision() {
		V variable = varSelector.getVariable(vars);
        return computeDecision(variable);
	}
	
	abstract protected DecisionEx<V,T> computeDecision(V var);
}
