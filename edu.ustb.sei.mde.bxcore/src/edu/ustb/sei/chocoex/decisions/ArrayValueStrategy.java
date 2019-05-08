package edu.ustb.sei.chocoex.decisions;

import org.chocosolver.solver.Model;

import edu.ustb.sei.chocoex.variables.AbstractArrayValueVariable;

public class ArrayValueStrategy<T> extends AbstractStrategyEx<AbstractArrayValueVariable<T>,T> {	
	@SuppressWarnings({ "unchecked" })
	public ArrayValueStrategy(Model model, AbstractArrayValueVariable<T>... variables) {
		super(model, new ValueSelector<AbstractArrayValueVariable<T>, T>() {
			@Override
			public T selectValue(AbstractArrayValueVariable<T> var) {
				return var.firstValue();
			}
		}, variables);
	}
	
	@SuppressWarnings("unchecked")
	protected ArrayValueVariableDecision<T> computeDecision(AbstractArrayValueVariable<T> variable) {
		if (variable == null || variable.isInstantiated()) {
            return null;
        }
        T value = valSelector.selectValue(variable);
        ArrayValueVariableDecision<T> dec = (ArrayValueVariableDecision<T>) poolManager.getE();
        if(dec==null)
        	dec = new ArrayValueVariableDecision<>(poolManager);
        dec.set(variable, value, ArrayValueVariableDecision.eq);
        return dec;
	}

}
