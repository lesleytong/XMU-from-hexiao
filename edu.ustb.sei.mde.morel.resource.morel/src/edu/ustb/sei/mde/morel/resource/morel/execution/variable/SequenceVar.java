package edu.ustb.sei.mde.morel.resource.morel.execution.variable;

import java.util.ArrayList;
import java.util.List;

import solver.ICause;
import solver.exception.ContradictionException;
import solver.variables.EventType;
import solver.variables.Variable;
import solver.variables.impl.AbstractVariable;


public interface SequenceVar<T> extends Variable{
	T[] getValues();
	T get(int i);
	T first();
	List<Element<T>> getElements();
	void expand();
}

class Element<T> {
	 private SequenceVar<T> host;
	public Element(SequenceVar<T> host, ArrayList<T> domain) {
		super();
		this.host = host;
		this.domain = domain;
	}
	private ArrayList<T> domain;
	
	public Element<T> duplicate(SequenceVar<T> sv) {
		Element<T> d = new Element<T>(sv,domain);
		return d;
	}
	
	public T getValue() {
		if(isInstantiated()) return domain.get(0);
		return null;
	}
	
	public ArrayList<T> getDomain() {
		if(domain==null)
			domain = new ArrayList<T>();
		return domain;
	}
	
	public boolean isInstantiated() {
		return domain.size()==1;
	}
	
	public boolean instantiateTo(T value, ICause cause) throws ContradictionException {
		assert cause != null;
		if (this.isInstantiated()) {
			T cvalue = this.getValue();
			if (value != cvalue) {
				host.contradiction(cause, EventType.INSTANTIATE, AbstractVariable.MSG_INST);
			}
			return false;
		} else if (getDomain().contains(value)) {
			getDomain().clear();
			getDomain().add(value);
			return true;
		}
		return false;
	}
}