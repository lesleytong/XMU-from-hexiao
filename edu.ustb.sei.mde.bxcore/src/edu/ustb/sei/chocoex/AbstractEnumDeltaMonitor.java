package edu.ustb.sei.chocoex;

import org.chocosolver.solver.ICause;
import org.chocosolver.solver.search.loop.TimeStampedObject;
import org.chocosolver.solver.variables.delta.IDeltaMonitor;

@Deprecated
public abstract class AbstractEnumDeltaMonitor<T> extends TimeStampedObject implements IDeltaMonitor {

	protected final AbstractEnumDelta<T> delta;
	protected ICause propagator;
	
	protected int first;
	protected int last;
	protected int frozenFirst;
	protected int frozenLast;
	
	public AbstractEnumDeltaMonitor(AbstractEnumDelta<T> delta, ICause propagator) {
		super(delta.getEnvironment());
		this.delta = delta;
		this.propagator = propagator;
		
		this.first = 0;
        this.last = 0;
        this.frozenFirst = 0;
        this.frozenLast = 0;
	}
	
    @Override
    public void freeze() {
		if (needReset()) {
            delta.lazyClear();
			this.first = this.last = 0;
			resetStamp();
		}
        this.frozenFirst = first; // freeze indices
        this.frozenLast = last = delta.size();
    }
    
    @Override
    public void unfreeze() {
        //propagator is idempotent
        delta.lazyClear();    // fix 27/07/12
        resetStamp();
        this.first = this.last = delta.size();
    }
    
	public int sizeApproximation(){
		return frozenLast-frozenFirst;
	}
	
}
