package edu.ustb.sei.mde.morel.resource.morel.execution.constraints;

import gnu.trove.map.hash.THashMap;
import solver.ICause;
import solver.Solver;
import solver.exception.ContradictionException;
import solver.explanations.Explanation;
import solver.explanations.VariableState;
import solver.variables.Variable;
import solver.variables.delta.EnumDelta;
import solver.variables.delta.IDelta;
import solver.variables.events.IEventType;
import solver.variables.impl.AbstractVariable;
import solver.variables.impl.BitsetIntVarImpl;

public class PassiveValueVariableImpl<T> extends AbstractVariable implements
		PassiveValueVariable<T> {
	private static final long serialVersionUID = -1738111247850468819L;
	static public final Object UNDEFINED = new Object(){};
	
	private T value;

	public PassiveValueVariableImpl(String name, Solver solver) {
		super(name, solver);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean isInstantiated() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void explain(VariableState what, Explanation to) {
		throw new UnsupportedOperationException("PassiveValueVariable does not support explain");
	}

	@Override
	public void explain(VariableState what, int val, Explanation to) {
		throw new UnsupportedOperationException("PassiveValueVariable does not support explain");
	}

	@Override
	public IDelta getDelta() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void createDelta() {
	}

	@Override
	public void notifyMonitors(IEventType event) throws ContradictionException {
        for (int i = mIdx - 1; i >= 0; i--) {
            monitors[i].onUpdate(this, event);
        }
	}

	@Override
	public void contradiction(ICause cause, IEventType event, String message)
			throws ContradictionException {
		 assert cause != null;
       solver.getEngine().fails(cause, this, message);
	}

	@Override
	public int getTypeAndKind() {
		return VAR | INT;
	}

	@Override
	public <V extends Variable> V duplicate() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void duplicate(Solver solver, THashMap<Object, Object> identitymap) {
		if (!identitymap.containsKey(this)) {
            //BitsetIntVarImpl clone = new BitsetIntVarImpl(this.name, this.OFFSET, this.VALUES.copyToBitSet(), solver);
            //identitymap.put(this, clone);
        }
	}

}
