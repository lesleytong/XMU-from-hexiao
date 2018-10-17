package edu.ustb.sei.mde.bxcore.bigul;

import edu.ustb.sei.mde.bxcore.exceptions.InternalBidirectionalTransformationError;
import edu.ustb.sei.mde.bxcore.exceptions.NothingReturnedException;

public abstract class BidirectionalTransformation<S, V> {
	public abstract V forward(S s)  throws NothingReturnedException;
	public abstract S backward(S s, V v) throws NothingReturnedException;
	
	static public <T> T nothing() throws NothingReturnedException {
		throw new NothingReturnedException();
	}
	
	static public <T> T nothing(Exception e) throws NothingReturnedException {
		throw new NothingReturnedException(e);
	}
	
	static public <T> T internalError() throws InternalBidirectionalTransformationError {
		throw new InternalBidirectionalTransformationError();
	}
	
	static public <T> T internalError(Exception e) throws InternalBidirectionalTransformationError {
		throw new InternalBidirectionalTransformationError(e);
	}
}
