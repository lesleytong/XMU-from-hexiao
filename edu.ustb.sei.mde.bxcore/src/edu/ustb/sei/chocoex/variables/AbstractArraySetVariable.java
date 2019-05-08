package edu.ustb.sei.chocoex.variables;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.chocosolver.solver.ICause;
import org.chocosolver.solver.Model;
import org.chocosolver.solver.exception.ContradictionException;
import org.chocosolver.solver.variables.delta.SetDelta;
import org.chocosolver.solver.variables.events.IEventType;
import org.chocosolver.solver.variables.impl.AbstractVariable;
import org.chocosolver.util.objects.setDataStructures.ISet;
import org.chocosolver.util.objects.setDataStructures.ISetIterator;
import org.chocosolver.util.objects.setDataStructures.SetFactory;
import org.chocosolver.util.objects.setDataStructures.SetType;
import org.chocosolver.util.objects.setDataStructures.Set_ReadOnly;

import gnu.trove.set.hash.TIntHashSet;

public abstract class AbstractArraySetVariable<T> extends AbstractVariable {
	//***********************************************************************************
    // VARIABLES
    //***********************************************************************************
	protected final T[] VALUES;
	private final Map<T, Integer> V2I;
	
    protected final ISet lb, ub, lbReadOnly, ubReadOnly;
    protected SetDelta delta;
    
    protected boolean reactOnModification;
    
    
    private T[] removeDuplicate(T[] value) {
    	HashMap<T,Integer> map = new HashMap<>();
    	for(int i=0;i<value.length;i++) {
    		map.putIfAbsent(value[i], i);
    	}
    	
    	if(map.size()==value.length) return value.clone();
    	
    	T[] res = Arrays.copyOf(value, map.size());
    	for(int i=0, j=0;i<value.length;i++) {
    		T v = value[i];
    		int id = map.get(v);
    		if(id==i) {
    			res[j] = v;
    			j++;
    		}
    	}
    	return res;
    }
    
//    protected IntVar cardinality = null;

    //***********************************************************************************
    // CONSTRUCTORS
    //***********************************************************************************

	/**
	 * Creates a Set variable
	 *
	 * @param name		name of the variable
	 * @param ker		initial kernel domain
	 * @param kerType	data structure of the kernel
	 * @param env		initial envelope domain
	 * @param envType	data structure of the envelope
	 * @param model	solver of the variable.
	 */
	public AbstractArraySetVariable(String name, T[] ker, SetType kerType, T[] env, SetType envType, Model model) {
		super(name, model);
		
		ker = removeDuplicate(ker);
		env = removeDuplicate(env);
		
		VALUES = env;
		this.V2I = new HashMap<T,Integer>();
		for (int i = 0; i < VALUES.length; i++) {
            V2I.put(VALUES[i], i);
        }
		
		int[] iKer = new int[ker.length];
		for(int i=0;i<ker.length;i++) iKer[i] = V2I.get(ker[i]);
		
		int[] iEnv = new int[env.length];
		for(int i=0;i<env.length;i++) iEnv[i] = V2I.get(env[i]);
		
		iKer = new TIntHashSet(iKer).toArray();
		iEnv = new TIntHashSet(iEnv).toArray();
		
		
		int offSet = env.length>0?iEnv[0]:0;
		for(int i : iEnv){
			offSet = Math.min(offSet,i);
		}
		
		lb = SetFactory.makeStoredSet(kerType, offSet, model);
		ub = SetFactory.makeStoredSet(envType, offSet, model);
		
		lbReadOnly = new Set_ReadOnly(lb);
		ubReadOnly = new Set_ReadOnly(ub);
		
		for(int i : iEnv){
			ub.add(i);
		}
		for(int i : iKer){
			lb.add(i);
			if(!ub.contains(i)){
				throw new UnsupportedOperationException("Invalid SetVar domain definition : "
						+i+" is in the LB but not in the UB.");
			}
		}
	}

	public AbstractArraySetVariable(String name, T[] value, Model model) {
		super(name, model);
		
		value = removeDuplicate(value);
		
		VALUES = value;
		this.V2I = new HashMap<T,Integer>();
		for (int i = 0; i < VALUES.length; i++) {
            V2I.put(VALUES[i], i);
        }
		
		int[] iVal = new int[value.length];
		for(int i=0;i<value.length;i++) iVal[i] = V2I.get(value[i]);
		
		lb = SetFactory.makeConstantSet(new TIntHashSet(iVal).toArray());
		ub = lb;
		lbReadOnly = new Set_ReadOnly(lb);
		ubReadOnly = new Set_ReadOnly(ub);
	}

	//***********************************************************************************
    // METHODS
    //***********************************************************************************

    @Override
    public boolean isInstantiated() {
        return ub.size() == lb.size();
    }
    
    public boolean containsInLB(T value) {
    	return lb.contains(V2I.getOrDefault(value, -1));
    }
    
    public boolean containsInUB(T value) {
    	return ub.contains(V2I.getOrDefault(value, -1));
    }
    
    public List<T> getLBValueList() {
    	List<T> res = new ArrayList<>();
    	this.lowerBoundIterator().forEachRemaining(v->{
    		res.add(v);
    	});
    	return res;
    }
    
    public Set<T> getLBValue() {
    	Set<T> res = new HashSet<>();
    	this.lowerBoundIterator().forEachRemaining(v->{
    		res.add(v);
    	});
    	return res;
    }

	public ISet getLB() {
		return lbReadOnly;
	}

	public ISet getUB() {
		return ubReadOnly;
	}

    public boolean force(T element, ICause cause) throws ContradictionException {
        assert cause != null;
        int index = V2I.get(element);
        if(index<0) return false;
        return force(index, cause);
    }

	public boolean force(int index, ICause cause) throws ContradictionException {
		if (!ub.contains(index)) {
            contradiction(cause, "");
            return true;
        }
        if (lb.add(index)) {
			if (reactOnModification) {
				delta.add(index, SetDelta.LB, cause);
			}
			ValueEventType e = ValueEventType.ADD_TO_KER;
			notifyPropagators(e, cause);
			return true;
		}
		return false;
	}


    public boolean remove(T value, ICause cause) throws ContradictionException {
        assert cause != null;
        int index = V2I.get(value);
        if(index<0) return false;
        return remove(index, cause);
    }

	public boolean remove(int index, ICause cause) throws ContradictionException {
		if (lb.contains(index)) {
            contradiction(cause, "");
            return true;
        }
		if (ub.remove(index)) {
			if (reactOnModification) {
				delta.add(index, SetDelta.UB, cause);
			}
			ValueEventType e = ValueEventType.REMOVE_FROM_ENVELOPE;
			notifyPropagators(e, cause);
			return true;
		}
        return false;
	}

    public boolean instantiateTo(T[] values, ICause cause) throws ContradictionException {
        boolean changed = !isInstantiated();
        for (T i : values) {
            force(i, cause);
        }
        if (lb.size() != values.length) {
            contradiction(cause, "");
        }
        if (ub.size() != values.length) {
            for (int i : getUB()) {
                if (!getLB().contains(i)) {
                    remove(i, cause);
                }
            }
        }
        ValueEventType e = ValueEventType.INSTANTIATE;
		notifyPropagators(e, cause);
        return changed;
    }

    public T getValue(int index) {
    	return VALUES[index];
    }
    @Override
    public SetDelta getDelta() {
        return delta;
    }

    @Override
    public String toString() {
		if(isInstantiated()){
			return getName()+" = "+getLB().toString();
		}else {
			return getName()+" = ["+getLB()+", "+getUB()+"]";
		}
    }

    @Override
    public void createDelta() {
        if (!reactOnModification) {
            reactOnModification = true;
            delta = new SetDelta(model.getEnvironment());
        }
    }

//    public SetDeltaMonitor monitorDelta(ICause propagator) {
//        createDelta();
//        return new SetDeltaMonitor(delta, propagator);
//    }

    @SuppressWarnings("unchecked")
	@Override
    public void notifyMonitors(IEventType event) throws ContradictionException {
        for (int i = mIdx - 1; i >= 0; i--) {
            monitors[i].onUpdate(this, event);
        }
    }
    
    private SetIterator lowerBoundIterator = null;
    public Iterator<T> lowerBoundIterator() {
    	if(lowerBoundIterator == null) {
    		lowerBoundIterator = new SetIterator(this, this.lb.iterator());
    	} else
    		lowerBoundIterator.reset();
    	return lowerBoundIterator;
    }
    
    private SetIterator upperBoundIterator = null;
    public Iterator<T> upperBoundIterator() {
    	if(upperBoundIterator == null) {
    		upperBoundIterator = new SetIterator(this, this.ub.iterator());
    	} else
    		upperBoundIterator.reset();
    	return upperBoundIterator;
    }
    
    class SetIterator implements Iterator<T> {
    	private AbstractArraySetVariable<T> var;
    	private ISetIterator iter;
    	public SetIterator(AbstractArraySetVariable<T> host, ISetIterator iter) {
    		this.var = host;
    		this.iter = iter;
    		reset();
    	}
    	
    	public void reset() {
    		iter.reset();
    	}

		@Override
		public boolean hasNext() {
			return iter.hasNext();
		}

		@Override
		public T next() {
			int next = iter.nextInt();
			return var.VALUES[next];
		}
    }

}
