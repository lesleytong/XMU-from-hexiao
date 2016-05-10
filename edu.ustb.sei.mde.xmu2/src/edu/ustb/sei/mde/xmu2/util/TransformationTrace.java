package edu.ustb.sei.mde.xmu2.util;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;

import edu.ustb.sei.commonutil.util.BidirectionalMap;
import edu.ustb.sei.commonutil.util.PairHashMap;
import edu.ustb.sei.mde.xmu2core.Procedure;

public class TransformationTrace {
	private BidirectionalMap<EObject,EObject> defaultSourceToUpdatedSourceObjectMap = BidirectionalMap.createConsistentMap();
	private PairHashMap<Procedure,Tuple,Tuple> ruleTrace = new PairHashMap<Procedure,Tuple,Tuple>();
	
	public void putDefault(EObject s, EObject sp) {
		defaultSourceToUpdatedSourceObjectMap.put(s, sp);
	}
	
	public Object getDefaultUpdated(Object s) {
		if(s instanceof EObject) 
			return defaultSourceToUpdatedSourceObjectMap.forward((EObject)s);
		else 
			return s;
	}
	
	public Object getDefaultSource(Object sp) {
		if(sp instanceof EObject)
			return defaultSourceToUpdatedSourceObjectMap.backward((EObject)sp);
		else return sp;
	}
	
	public void putTrace(Procedure r, Tuple t1, Tuple t2) {
		ruleTrace.put(r, t1, t2);
	}
	
	public Tuple getTrace(Procedure r, Tuple t) {
		return ruleTrace.get(r, t);
	}
}
