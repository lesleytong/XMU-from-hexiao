package edu.ustb.sei.chocoex;

import org.chocosolver.memory.IEnvironment;
import org.chocosolver.solver.ICause;
import org.chocosolver.solver.search.loop.TimeStampedObject;
import org.chocosolver.solver.variables.delta.IDelta;

@Deprecated
public class AbstractEnumDelta<T> extends TimeStampedObject implements IDelta {
	private static final int SIZE = 32;

    private Object[] rem;
    private ICause[] causes;
    private int last;
    
	public AbstractEnumDelta(IEnvironment environment) {
		super(environment);
		rem = new Object[SIZE]; 
        causes = new ICause[SIZE];
	}
	
	@SuppressWarnings("unchecked")
	private void ensureCapacity() {
        if (last >= rem.length) {
            T[] tmp = (T[]) new Object[last * 3 / 2 + 1];
            ICause[] tmpc = new ICause[last * 3 / 2 + 1];
            System.arraycopy(rem, 0, tmp, 0, last);
            System.arraycopy(causes, 0, tmpc, 0, last);
            rem = tmp;
            causes = tmpc;
        }
    }

	@Override
    public void lazyClear() {
        if (needReset()) {
			last = 0;
			resetStamp();
        }
    }
	
    public void add(T value, ICause cause) {
		lazyClear();
        ensureCapacity();
        causes[last] = cause;
        rem[last++] = value;
    }

    @SuppressWarnings("unchecked")
	public T get(int idx) {
        return (T) rem[idx];
    }

    public ICause getCause(int idx) {
        return causes[idx];
    }

    public int size() {
        return last;
    }

}
