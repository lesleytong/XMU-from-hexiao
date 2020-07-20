package edu.ustb.sei.mde.query.indexing;


public interface Profile<DOMAIN> {
	
	/**
	 * 
	 * @param pattern
	 * @return <code>true</code> if this index is a candidate of pattern
	 */
	boolean isCandidate(Profile<?> pattern);
	DOMAIN getReferredObject();
	void setReferredObject(DOMAIN o);
}
