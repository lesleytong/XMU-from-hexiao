package edu.ustb.sei.chocoex.decisions;

import org.chocosolver.solver.Model;
import org.chocosolver.util.objects.setDataStructures.ISetIterator;

import edu.ustb.sei.chocoex.variables.AbstractArraySetVariable;

public class ArraySetStrategy<T>
		extends AbstractStrategyEx<AbstractArraySetVariable<T>, T> {

	public ArraySetStrategy(Model model, AbstractArraySetVariable<T>[] variables) {
		super(model, new ValueSelector<AbstractArraySetVariable<T>, T>() {
			@Override
			public T selectValue(AbstractArraySetVariable<T> var) {
				ISetIterator iter = var.getUB().iterator();
		        while (iter.hasNext()) {
		            int i = iter.nextInt();
		            if (!var.getLB().contains(i)) {
		                return var.getValue(i);
		            }
		        }
				return null;
			}
			
		}, variables);
	}

	@SuppressWarnings("unchecked")
	@Override
	protected DecisionEx<AbstractArraySetVariable<T>, T> computeDecision(AbstractArraySetVariable<T> var) {
		if (var == null) {
            return null;
        }
        assert !var.isInstantiated();
        T value = valSelector.selectValue(var);
        ArraySetVariableDecision<T> dec = (ArraySetVariableDecision<T>) poolManager.getE();
        if(dec==null)
        	dec = new ArraySetVariableDecision<>(poolManager);
        dec.set(var, value, ArraySetVariableDecision.force);
        return dec;
	}

}
