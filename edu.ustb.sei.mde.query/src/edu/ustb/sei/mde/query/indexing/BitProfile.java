package edu.ustb.sei.mde.query.indexing;


public class BitProfile<DOMAIN> implements Profile<DOMAIN> {
	private BitSet typeMask;
	private BitSet neighborEdgeMask;
	private BitSet boundaryEdgeMask;
	
	private DOMAIN referredObject;
	
	public BitProfile() {
		this(0,0);
	}
	
	public BitProfile(int cSize, int eSize) {
		typeMask = new BitSet(cSize);
		neighborEdgeMask = new BitSet(eSize);
		boundaryEdgeMask = new BitSet(eSize);
	}
	
	public void setTypeMask(int id) {
		typeMask.set(id);
	}
	
	public void setNeighborEdgeMask(int id) {
		neighborEdgeMask.set(id);
	}
	
	public void setBoundaryEdgeMask(int id) {
		boundaryEdgeMask.set(id);
	}

	@Override
	public boolean isCandidate(Profile<?> pattern) {
		assert pattern instanceof BitProfile;
		BitProfile<?> bsPat = (BitProfile<?>) pattern;
		if(!bsPat.typeMask.intersects(this.typeMask)) return false; // may also use bsPat.typeMask.cover(this.typeMask)
		if(!this.neighborEdgeMask.cover(bsPat.neighborEdgeMask)) return false;
		if(!this.boundaryEdgeMask.cover(bsPat.boundaryEdgeMask)) return false;
		return true;
	}

	@Override
	public DOMAIN getReferredObject() {
		return referredObject;
	}

	@Override
	public void setReferredObject(DOMAIN o) {
		this.referredObject = o;
	}
}
