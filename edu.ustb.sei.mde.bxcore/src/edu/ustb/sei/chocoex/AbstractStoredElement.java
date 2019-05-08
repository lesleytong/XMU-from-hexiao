package edu.ustb.sei.chocoex;

import org.chocosolver.memory.IEnvironment;


@Deprecated
public abstract class AbstractStoredElement<T> {
	protected final IEnvironment environment;
	protected T currentValue;
	protected int timeStamp;
	protected final AbstractStoredElementTrail<T> myTrail;
	
	public AbstractStoredElement(AbstractEnvironmentEx env, T i) {
		environment = env;
		currentValue = i;
		timeStamp = environment.getWorldIndex();
		
		myTrail = env.getTrail(this.getClass());
		
		internalUpdate();
		
		if(env.fakeHistoryNeeded()){
            myTrail.buildFakeHistory(this, i, timeStamp);
        }
	}
	
	public final T get() {
		return currentValue;
	}
	
	public void set(T y) {
		if (y != currentValue) {
            final int wi = environment.getWorldIndex();
            if (this.timeStamp < wi) {
                myTrail.savePreviousState(this, currentValue, timeStamp);
                timeStamp = wi;
            }
            currentValue = y;
            internalUpdate();
        }
	}
	
	protected void internalUpdate() {
	}

	public void _set(final T y, final int wstamp) {
		currentValue = y;
		timeStamp = wstamp;
		internalUpdate();
	}
	
	public void overrideTimeStamp(int aTimeStamp) {
		this.timeStamp = aTimeStamp;
	}
	
	@Override
	public String toString() {
		return String.valueOf(currentValue);
	}
}
