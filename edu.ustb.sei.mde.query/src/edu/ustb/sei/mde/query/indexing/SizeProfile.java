package edu.ustb.sei.mde.query.indexing;

import java.util.HashMap;
import java.util.Map;


public class SizeProfile<DOMAIN,ET> implements Profile<DOMAIN> {
	
	private BitSet typeMask;
	private Map<ET,Integer> neighborEdgeSize;
	private Map<ET,Integer> boundaryEdgeSize;
	
	public SizeProfile() {
		neighborEdgeSize = new HashMap<ET, Integer>();
		boundaryEdgeSize = new HashMap<ET, Integer>();
	}

	@Override
	public boolean isCandidate(Profile<?> pattern) {
		assert pattern instanceof SizeProfile;
		@SuppressWarnings({ "unchecked" })
		SizeProfile<DOMAIN,ET> sPat = (SizeProfile<DOMAIN,ET>) pattern;
		
		if(!sPat.typeMask.intersects(this.typeMask)) return false; // may also use bsPat.typeMask.cover(this.typeMask)
		
		if(sPat.neighborEdgeSize.entrySet().stream().anyMatch(e->{
			int s = this.neighborEdgeSize.getOrDefault(e.getKey(), 0);
			return e.getValue()>s;
		})) return false;
		if(sPat.boundaryEdgeSize.entrySet().stream().anyMatch(e->{
			int s = this.boundaryEdgeSize.getOrDefault(e.getKey(), 0);
			return e.getValue()>s;
		})) return false;
		
		return true;
	}
	
	private DOMAIN referredObject;

	@Override
	public DOMAIN getReferredObject() {
		return referredObject;
	}

	@Override
	public void setReferredObject(DOMAIN o) {
		this.referredObject = o;
	}

}
