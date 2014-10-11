package edu.ustb.sei.mde.morel.resource.morel.execution.variable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import solver.ICause;
import solver.Solver;
import solver.exception.ContradictionException;
import solver.explanations.Explanation;
import solver.explanations.VariableState;
import solver.variables.EventType;
import solver.variables.Variable;
import solver.variables.delta.EnumDelta;
import solver.variables.delta.IDelta;
import solver.variables.delta.IEnumDelta;
import solver.variables.delta.NoDelta;
import solver.variables.impl.AbstractVariable;

public class SequenceVarImpl<T> extends AbstractVariable implements
		SequenceVar<T> {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4093859302090292268L;
	private T[] VALUES;
	private ArrayList<Element<T>> elements = new ArrayList<Element<T>>();
	
	
	protected SequenceVarImpl(String name, T[] values, Solver solver) {
		super(name, solver);
		VALUES = values;
	}

	@Override
	public boolean isInstantiated() {
		for(Element<T> e : elements) {
			if(e.isInstantiated()==false) return false;
		}
		return true;
	}

	@Override
	public void explain(VariableState what, Explanation to) {
		// TODO Auto-generated method stub

	}

	@Override
	public void explain(VariableState what, int val, Explanation to) {
		// TODO Auto-generated method stub

	}

	@Override
	public IDelta getDelta() {
		// TODO Auto-generated method stub
		return delta;
	}
	
	protected boolean reactOnRemoval = false;
	private IEnumDelta delta = NoDelta.singleton;

	@Override
	public void createDelta() {
		if (!reactOnRemoval) {
            delta = new EnumDelta(solver.getSearchLoop());
            reactOnRemoval = true;
        }
	}

	@Override
	public void notifyMonitors(EventType event) throws ContradictionException {
        for (int i = mIdx - 1; i >= 0; i--) {
            monitors[i].onUpdate(this, event);
        }
	}

	@Override
	public void contradiction(ICause cause, EventType event, String message)
			throws ContradictionException {
        assert cause != null;
//      records.forEach(onContradiction.set(this, event, cause));
      solver.getEngine().fails(cause, this, message);
	}

	@Override
	public int getTypeAndKind() {
		return VAR & SET;
	}

	@SuppressWarnings("unchecked")
	@Override
	public <V extends Variable> V duplicate() {
		SequenceVar<T> sv = new SequenceVarImpl<T>(name, VALUES, solver);
		for(Element<T> e : elements) {
			sv.getElements().add(e.duplicate(sv));
		}
		return (V)sv;
	}

	@Override
	public T[] getValues() {
		return VALUES;
		
	}

	@Override
	public T get(int i) {
		return elements.get(i).getValue();
	}

	@Override
	public T first() {
		// TODO Auto-generated method stub
		return elements.get(0).getValue();
	}

	@Override
	public List<Element<T>> getElements() {
		return elements;
	}

	@Override
	public void expand() {
		// TODO Auto-generated method stub
		ArrayList<T> domain = new ArrayList<T>();
		for(T e : VALUES) domain.add(e);
		
		elements.add(new Element<T>(this, domain));
	}
	
	public void expand(int i) {
		if(i<0) return;
		int size = elements.size();
		if(i<size) {
			ArrayList<T> domain = new ArrayList<T>();
			for(T e : VALUES) domain.add(e);
			elements.add(i, new Element<T>(this, domain));
			
		} else if(i>=size) {
			for(int j = size ; j<i;j++) {
				ArrayList<T> domain = new ArrayList<T>();
				for(T e : VALUES) domain.add(e);
				elements.add(i, new Element<T>(this, domain));
			}			
		}
	}

}


