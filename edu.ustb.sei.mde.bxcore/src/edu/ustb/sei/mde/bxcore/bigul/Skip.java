package edu.ustb.sei.mde.bxcore.bigul;

import edu.ustb.sei.mde.bxcore.exceptions.NothingReturnedException;

public class Skip<S> extends BidirectionalTransformation<S, S>{

	@Override
	public S forward(S s) {
		return s;
	}

	@Override
	public S backward(S s, S v) throws NothingReturnedException {
		if((v==null && s==null) || (v!=null && v.equals(s)))
			return s;
		else throw new NothingReturnedException();
	}

}
