package edu.ustb.sei.chocoex.variables;

import java.lang.reflect.Field;

import org.chocosolver.solver.ICause;
import org.chocosolver.solver.Model;
import org.chocosolver.solver.exception.ContradictionException;
import org.chocosolver.solver.variables.events.IEventType;
import org.chocosolver.solver.variables.impl.AbstractVariable;
import org.chocosolver.util.iterators.EvtScheduler;

import edu.ustb.sei.chocoex.AbstractEnumDelta;
import edu.ustb.sei.chocoex.AbstractEnumDeltaMonitor;
import edu.ustb.sei.chocoex.AbstractStoredElement;

@Deprecated
public abstract class AbstractVariableEx<V extends AbstractStoredElement<D>, D> extends AbstractVariable {
	
	protected V VALUE;
	protected AbstractEnumDelta<D> delta;
	protected boolean reactOnModification;
	

	public AbstractVariableEx(String name, Model model) {
		super(name, model);
		reactOnModification = false;
		initEvtScheduler();
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
	
	protected abstract EvtScheduler<? extends IEventType> createEvtScheduler();

	@Override
	public AbstractEnumDelta<D> getDelta() {
		return delta;
	}

	@Override
	public void createDelta() {
		if(reactOnModification==false) {
			reactOnModification = true;
			delta = basicCreateDelta();
		}
	}

	protected abstract AbstractEnumDelta<D> basicCreateDelta();

	@SuppressWarnings("unchecked")
	@Override
	public void notifyMonitors(IEventType event) throws ContradictionException {
		for (int i = mIdx - 1; i >= 0; i--) {
			monitors[i].onUpdate(this, event);
		}
	}
	
	public AbstractEnumDeltaMonitor<D> monitorDelta(ICause propagator) {
		createDelta();
		return createDeltaMonitor(delta, propagator);
	}

	protected abstract AbstractEnumDeltaMonitor<D> createDeltaMonitor(AbstractEnumDelta<D> d, ICause propagator);
}
