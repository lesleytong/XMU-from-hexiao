package edu.ustb.sei.mde.bxcore.bigul;

import edu.ustb.sei.mde.bxcore.exceptions.NothingReturnedException;

public abstract class BidirectionalTransformation<S, V> {
	public abstract V forward(S s)  throws NothingReturnedException;
	public abstract S backward(S s, V v) throws NothingReturnedException;
	
	public <T> T nothing() throws NothingReturnedException {
		throw new NothingReturnedException();
	}
	
	public <T> T nothing(Exception e) throws NothingReturnedException {
		throw new NothingReturnedException(e);
	}
}
