package edu.ustb.sei.chocoex.variables;

import org.chocosolver.solver.variables.events.IEventType;

public enum ValueEventType implements IEventType {
	
	VOID(0),
	
    REMOVE(1),

    BOUND(2),
    
    ADD_TO_KER(4),
    
	REMOVE_FROM_ENVELOPE(8),

    INSTANTIATE(16);
	
	ValueEventType(int m) {
		this.mask = m;
	}

	private final int mask;
	@Override
	public int getMask() {
		return mask;
	}

}
