package edu.ustb.sei.chocoex.variables;

import org.chocosolver.util.iterators.EvtScheduler;

public class ArrayValueEventScheduler implements EvtScheduler<ValueEventType> {

	public ArrayValueEventScheduler() {
	}

	private boolean done = true;

	@Override
	public int select(int mask) {
		return 0;
	}

	@Override
	public boolean hasNext() {
		return !done;
	}

	@Override
	public int next() {
		if (done) return 1;
		done = true;
		return 0;
	}

	@Override
	public void remove() {
		throw new UnsupportedOperationException();
	}

	@Override
	public void init(ValueEventType type) {
		done = false;
	}

}
