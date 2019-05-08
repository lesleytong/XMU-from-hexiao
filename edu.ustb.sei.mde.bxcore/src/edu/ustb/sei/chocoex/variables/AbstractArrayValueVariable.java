package edu.ustb.sei.chocoex.variables;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.chocosolver.memory.IEnvironment;
import org.chocosolver.memory.IStateBitSet;
import org.chocosolver.memory.IStateInt;
import org.chocosolver.solver.ICause;
import org.chocosolver.solver.Model;
import org.chocosolver.solver.exception.ContradictionException;
import org.chocosolver.solver.variables.delta.EnumDelta;
import org.chocosolver.solver.variables.delta.IDelta;
import org.chocosolver.solver.variables.delta.IEnumDelta;
import org.chocosolver.solver.variables.delta.NoDelta;
import org.chocosolver.solver.variables.events.IEventType;
import org.chocosolver.solver.variables.events.IntEventType;
import org.chocosolver.solver.variables.impl.AbstractVariable;
import org.chocosolver.util.iterators.EvtScheduler;


public abstract class AbstractArrayValueVariable<T> extends AbstractVariable implements Iterable<T> {
	private boolean reactOnRemoval = false;
	
	protected final T[] VALUES;
	private final IStateBitSet INDICES;
	private final Map<T, Integer> V2I;
	
	private IEnumDelta delta = NoDelta.singleton;
	private final IStateInt SIZE;

	public AbstractArrayValueVariable(String name, T[] values, Model model) {
		super(name, model);
		IEnvironment env = this.model.getEnvironment();
        this.VALUES = values.clone();
        this.V2I = new HashMap<T,Integer>();
        this.INDICES = env.makeBitSet(values.length);
        this.INDICES.set(0, values.length);
        for (int i = 0; i < VALUES.length; i++) {
            V2I.put(VALUES[i], i);
        }
        this.SIZE = env.makeInt(values.length);
        
        initEvtScheduler();
	}
	
	public boolean removeValue(T value, ICause cause) throws ContradictionException { 
		assert cause != null;
        int index = V2I.getOrDefault(value, -1);
        
        if(index>-1 && this.INDICES.get(index)) {
        	if(SIZE.get() == 1) {
        		this.contradiction(cause, MSG_REMOVE);
        	}
        	ValueEventType e = ValueEventType.REMOVE;
        	this.INDICES.clear(index);
        	this.SIZE.add(-1);
        	if(reactOnRemoval)
        		delta.add(index, cause);
        	assert !INDICES.isEmpty();
        	if (this.isInstantiated()) {
        		e = ValueEventType.INSTANTIATE;
        	}
        	this.notifyPropagators(e, cause);
        	return true;
        }
        else {
        	return false;
        }
	}
	
	
	public boolean removeValues(T[] values, ICause cause) throws ContradictionException {
		assert cause != null;
		int count = SIZE.get();
		boolean hasRemoved = false;;
		for(T value : values) {
			int index = V2I.getOrDefault(value, -1);
			if(index==-1) continue;
			else {
				if(index>-1 && this.INDICES.get(index)) {
					if(SIZE.get() == 1) {
						this.contradiction(cause, MSG_REMOVE);
					}
					count--;
					hasRemoved = true;
					this.INDICES.clear(index);
					if(reactOnRemoval)
						delta.add(index, cause);
				}
				else {
					continue;
				}
			}
		}
		if (hasRemoved) {
			notifyOnRemovals(count, cause);
		}
		
		return hasRemoved;
	}
	
	private void notifyOnRemovals(int count, ICause cause) throws ContradictionException {
		SIZE.set(count);
		IntEventType e = IntEventType.REMOVE;
		if (count == 1) {
			e = IntEventType.INSTANTIATE;
		}
		this.notifyPropagators(e, cause);
	}
	
	public boolean contains(T aValue) {
        int i = V2I.getOrDefault(aValue, -1);
        return i > -1 && INDICES.get(i);
    }
	
	public boolean instantiateTo(T value, ICause cause) throws ContradictionException {
        assert cause != null;
        if (!contains(value)) {
            this.contradiction(cause, MSG_INST);
        } else if(!isInstantiated()){
            int index = V2I.get(value);
            if(reactOnRemoval) {
            	for (int i = INDICES.nextSetBit(0); i >= 0; i = INDICES.nextSetBit(i + 1)) {
            		if (i != index) {
            			delta.add(i, cause);
            		}
            	}
            }
            this.INDICES.clear();
            this.INDICES.set(index);
            this.SIZE.set(1);
            assert !INDICES.isEmpty();
            this.notifyPropagators(IntEventType.INSTANTIATE, cause);
            return true;
        }
        return false;
    }
	
	public T getValue() {
        assert isInstantiated() : name + " not instantiated";
        int index = this.INDICES.nextSetBit(0);
        return VALUES[index];
	}
	
	public T firstValue() {
		int index = this.INDICES.nextSetBit(0);
		if(index>=0) return VALUES[index];
		else return null;
	}
	
	public T nextValue(T value) {
		int index = V2I.getOrDefault(value, -1);
		if(index>=0) {
			index = this.INDICES.nextSetBit(index + 1);
		} else {
			index = this.INDICES.nextSetBit(0);
		}
		if(index>=0) return VALUES[index];
		else return null;
	}
	

	@Override
	public boolean isInstantiated() {
		return this.SIZE.get()==1;
	}

	@Override
	public IDelta getDelta() {
		return delta;
	}

	@Override
	public void createDelta() {
		delta = new EnumDelta(model.getEnvironment());
        reactOnRemoval = true;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void notifyMonitors(IEventType event) throws ContradictionException {
		for (int i = mIdx - 1; i >= 0; i--) {
            monitors[i].onUpdate(this, event);
        }
	}
	
	
	private ValueIterator iterator;
	@Override
	public Iterator<T> iterator() {
		if(iterator==null) {
			iterator = new ValueIterator(this);
		} else
			iterator.reset();
		
		return iterator;
	}
	
	class ValueIterator implements Iterator<T> {
		public ValueIterator(AbstractArrayValueVariable<T> var) {
			super();
			this.var = var;
			reset();
		}

		private int cur = 0;
		private AbstractArrayValueVariable<T> var;
		
		public void reset() {
			cur = var.INDICES.nextSetBit(0);
		}
		

		@Override
		public boolean hasNext() {
			if(cur==-1) return false;
			return var.INDICES.get(cur);
		}

		@Override
		public T next() {
			T value = var.VALUES[cur];
			cur = var.INDICES.nextSetBit(cur + 1);
			return value;
		}
		
	}

	protected void initEvtScheduler() {
		Field f = null; //NoSuchFieldException
		try {
			AbstractVariable me = this;
			f = me.getClass().getSuperclass().getSuperclass().getDeclaredField("scheduler");
			f.setAccessible(true);
			f.set(me, createEvtScheduler());
		} catch (NoSuchFieldException | IllegalAccessException e) {
			e.printStackTrace();
		}
	}
	
	protected EvtScheduler<? extends IEventType> createEvtScheduler() {
		return new ArrayValueEventScheduler();
	}
}
