package edu.ustb.sei.mde.modelsolver.propagators;

import org.chocosolver.solver.constraints.Propagator;
import org.chocosolver.solver.constraints.PropagatorPriority;
import org.chocosolver.solver.exception.ContradictionException;
import org.chocosolver.solver.variables.IntVar;
import org.chocosolver.util.ESat;

import edu.ustb.sei.mde.graph.type.TypeGraph;
import edu.ustb.sei.mde.modelsolver.SemanticDomainVar;

abstract public class TypeFilterPropagator<V extends SemanticDomainVar<?>, T> extends Propagator<IntVar> {
	protected V var;
	protected T type;
	protected TypeGraph typeGraph;
	
	public TypeFilterPropagator(V v,T type, TypeGraph typeGraph) {
        super(new IntVar[]{v.internalIntVar()},PropagatorPriority.UNARY, false);
        this.var = v;
        this.type = type;
        this.typeGraph = typeGraph;
    }
	
	@Override
	public void propagate(int evtmask) throws ContradictionException {
		IntVar iv = removeValue();
		
        if (iv.hasEnumeratedDomain()) {
            setPassive();
        } else {
            int lb = iv.getLB();
            int ub = iv.getUB();
            
            while(lb <= ub ) {
            	if(shouldKeep(lb)==false) break;
            	lb++;
            }
            
            if(lb == ub){
                setPassive();
            }
        }
	}
	
	abstract protected boolean shouldKeep(int value);

	protected IntVar removeValue() throws ContradictionException {
		IntVar iv = var.internalIntVar();
		int ub = iv.getUB();
		
		for(int i=iv.getLB();i<=ub;i=iv.nextValue(i)) {
			if(shouldKeep(i)==false) 
        		iv.removeValue(i, this);
		}
		return iv;
	}

	@Override
	public ESat isEntailed() {
		IntVar iv = var.internalIntVar();
		int nb = 0;
        int ub = iv.getUB();
        for (int val = iv.getLB(); val <= ub; val = iv.nextValue(val)) {
            if (shouldKeep(val)) {
                nb++;
            }
        }
        if (nb == 0) return ESat.FALSE;
        else if (nb == iv.getDomainSize()) return ESat.TRUE;
        return ESat.UNDEFINED;
	}
}
