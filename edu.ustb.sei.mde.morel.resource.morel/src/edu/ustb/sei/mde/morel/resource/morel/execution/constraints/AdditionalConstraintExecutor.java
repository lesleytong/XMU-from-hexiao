package edu.ustb.sei.mde.morel.resource.morel.execution.constraints;

import edu.ustb.sei.mde.emg.runtime.Context;
import edu.ustb.sei.mde.morel.AdditionalConstraint;

public abstract class AdditionalConstraintExecutor<T extends AdditionalConstraint> {
	protected T constraint;
	
	public AdditionalConstraintExecutor(T constraint) {
		super();
		this.constraint = constraint;
	}
	
	
	abstract public void reset();
	abstract public boolean evaluate(Context c);
}
