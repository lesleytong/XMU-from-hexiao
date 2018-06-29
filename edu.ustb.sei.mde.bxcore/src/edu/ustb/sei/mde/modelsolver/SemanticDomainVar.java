package edu.ustb.sei.mde.modelsolver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.chocosolver.solver.ICause;
import org.chocosolver.solver.Model;
import org.chocosolver.solver.constraints.Propagator;
import org.chocosolver.solver.exception.ContradictionException;
import org.chocosolver.solver.variables.IVariableMonitor;
import org.chocosolver.solver.variables.IntVar;
import org.chocosolver.solver.variables.Variable;
import org.chocosolver.solver.variables.delta.IDelta;
import org.chocosolver.solver.variables.delta.IIntDeltaMonitor;
import org.chocosolver.solver.variables.events.IEventType;
import org.chocosolver.solver.variables.view.IView;
import org.chocosolver.util.iterators.DisposableRangeIterator;
import org.chocosolver.util.iterators.DisposableValueIterator;
import org.chocosolver.util.iterators.EvtScheduler;
import org.chocosolver.util.objects.setDataStructures.iterable.IntIterableSet;


public class SemanticDomainVar<T> implements IntVar {
	
	private IntVar internalIntVar;
	
	
	public IntVar internalIntVar() {
		return internalIntVar;
	}
	
	public int getId() {
		return internalIntVar.getId();
	}

	public Iterator<Integer> iterator() {
		return internalIntVar.iterator();
	}

	public boolean removeValue(int value, ICause cause) throws ContradictionException {
		return internalIntVar.removeValue(value, cause);
	}

	public boolean isInstantiated() {
		return internalIntVar.isInstantiated();
	}

	public String getName() {
		return internalIntVar.getName();
	}

	@SuppressWarnings("rawtypes")
	public Propagator[] getPropagators() {
		return internalIntVar.getPropagators();
	}

	@SuppressWarnings("rawtypes")
	public Propagator getPropagator(int idx) {
		return internalIntVar.getPropagator(idx);
	}

	public int getNbProps() {
		return internalIntVar.getNbProps();
	}

	public boolean removeValues(IntIterableSet values, ICause cause) throws ContradictionException {
		return internalIntVar.removeValues(values, cause);
	}

	public int[] getPIndices() {
		return internalIntVar.getPIndices();
	}

	public void setPIndice(int pos, int val) {
		internalIntVar.setPIndice(pos, val);
	}

	public int getDindex(int i) {
		return internalIntVar.getDindex(i);
	}

	public int getIndexInPropagator(int pidx) {
		return internalIntVar.getIndexInPropagator(pidx);
	}

	public boolean removeAllValuesBut(IntIterableSet values, ICause cause) throws ContradictionException {
		return internalIntVar.removeAllValuesBut(values, cause);
	}

	public int compareTo(Variable o) {
		return internalIntVar.compareTo(o);
	}

	@SuppressWarnings("rawtypes")
	public void addMonitor(IVariableMonitor monitor) {
		internalIntVar.addMonitor(monitor);
	}

	@SuppressWarnings("rawtypes")
	public void removeMonitor(IVariableMonitor monitor) {
		internalIntVar.removeMonitor(monitor);
	}

	public void subscribeView(IView view) {
		internalIntVar.subscribeView(view);
	}

	public IDelta getDelta() {
		return internalIntVar.getDelta();
	}

	public boolean removeInterval(int from, int to, ICause cause) throws ContradictionException {
		return internalIntVar.removeInterval(from, to, cause);
	}

	public void createDelta() {
		internalIntVar.createDelta();
	}

	@SuppressWarnings("rawtypes")
	public int link(Propagator propagator, int idxInProp) {
		return internalIntVar.link(propagator, idxInProp);
	}

	@SuppressWarnings("rawtypes")
	public void unlink(Propagator propagator, int idxInProp) {
		internalIntVar.unlink(propagator, idxInProp);
	}

	public void notifyPropagators(IEventType event, ICause cause) throws ContradictionException {
		internalIntVar.notifyPropagators(event, cause);
	}

	public boolean instantiateTo(int value, ICause cause) throws ContradictionException {
		return internalIntVar.instantiateTo(value, cause);
	}

	public void notifyViews(IEventType event, ICause cause) throws ContradictionException {
		internalIntVar.notifyViews(event, cause);
	}

	public IView[] getViews() {
		return internalIntVar.getViews();
	}

	public void notifyMonitors(IEventType event) throws ContradictionException {
		internalIntVar.notifyMonitors(event);
	}

	public void contradiction(ICause cause, String message) throws ContradictionException {
		internalIntVar.contradiction(cause, message);
	}

	public boolean updateLowerBound(int value, ICause cause) throws ContradictionException {
		return internalIntVar.updateLowerBound(value, cause);
	}

	public Model getModel() {
		return internalIntVar.getModel();
	}

	public int getTypeAndKind() {
		return internalIntVar.getTypeAndKind();
	}

	public boolean updateUpperBound(int value, ICause cause) throws ContradictionException {
		return internalIntVar.updateUpperBound(value, cause);
	}

	public boolean isAConstant() {
		return internalIntVar.isAConstant();
	}

	public <E extends IEventType> EvtScheduler<E> _schedIter() {
		return internalIntVar._schedIter();
	}


	public boolean updateBounds(int lb, int ub, ICause cause) throws ContradictionException {
		return internalIntVar.updateBounds(lb, ub, cause);
	}



	public boolean contains(int value) {
		return internalIntVar.contains(value);
	}

	
	public boolean isInstantiatedTo(int value) {
		return internalIntVar.isInstantiatedTo(value);
	}


	public int getValue() {
		return internalIntVar.getValue();
	}

	public int getLB() {
		return internalIntVar.getLB();
	}


	public int getUB() {
		return internalIntVar.getUB();
	}

	public int getDomainSize() {
		return internalIntVar.getDomainSize();
	}

	public int getRange() {
		return internalIntVar.getRange();
	}

	public int nextValue(int v) {
		return internalIntVar.nextValue(v);
	}

	public int nextValueOut(int v) {
		return internalIntVar.nextValueOut(v);
	}

	public int previousValue(int v) {
		return internalIntVar.previousValue(v);
	}


	public int previousValueOut(int v) {
		return internalIntVar.previousValueOut(v);
	}

	public DisposableValueIterator getValueIterator(boolean bottomUp) {
		return internalIntVar.getValueIterator(bottomUp);
	}


	public DisposableRangeIterator getRangeIterator(boolean bottomUp) {
		return internalIntVar.getRangeIterator(bottomUp);
	}

	

	public boolean hasEnumeratedDomain() {
		return internalIntVar.hasEnumeratedDomain();
	}


	public IIntDeltaMonitor monitorDelta(ICause propagator) {
		return internalIntVar.monitorDelta(propagator);
	}

	public boolean isBool() {
		return internalIntVar.isBool();
	}


	protected Model model;
	private List<T> semanticalObjects;
	private Map<T, Integer> objToIdx;
	
	public SemanticDomainVar(String name, Collection<T> semanticalObjects, Model model) {
		this.semanticalObjects = new ArrayList<>(semanticalObjects);
		this.objToIdx = new HashMap<>();
		
		int i=0;
		for(T o : semanticalObjects) {
			objToIdx.put(o, i++);
		}
		
		internalIntVar = model.intVar(name, 0, this.semanticalObjects.size()-1);
		this.model = model;
	}
	
	public SemanticDomainVar(String name, T[] semanticalObjects, Model model) {
		this.semanticalObjects = Arrays.asList(semanticalObjects);
		this.objToIdx = new HashMap<>();
		
		int i=0;
		for(T o : semanticalObjects) {
			objToIdx.put(o, i++);
		}
		
		internalIntVar = model.intVar(name, 0, this.semanticalObjects.size()-1);
		this.model = model;
	}
	
	public int getSemanticObjectId(T o) {
		return objToIdx.getOrDefault(o, -1);
	}
	
	public T getSemanticObject(int i) {
		return this.semanticalObjects.get(i);
	}
	
	public T getSemanticObject() {
		int v = internalIntVar.getValue();
		return getSemanticObject(v);
	}
	
	

}
