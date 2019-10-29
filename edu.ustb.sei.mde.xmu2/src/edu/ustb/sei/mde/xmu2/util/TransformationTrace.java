package edu.ustb.sei.mde.xmu2.util;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.emf.ecore.EObject;

import edu.ustb.sei.commonutil.util.BidirectionalMap;
import edu.ustb.sei.commonutil.util.PairHashMap;
import edu.ustb.sei.mde.xmu2core.Procedure;

public class TransformationTrace {
	private BidirectionalMap<EObject, EObject> defaultSourceToUpdatedSourceObjectMap = BidirectionalMap
			.createConsistentMap();
	private PairHashMap<Procedure, Tuple, Tuple> ruleTrace = new PairHashMap<Procedure, Tuple, Tuple>();

	public void putDefault(EObject s, EObject sp) {
		defaultSourceToUpdatedSourceObjectMap.put(s, sp);
	}

	public Object getDefaultUpdated(Object s) {
		if (s instanceof EObject)
			return defaultSourceToUpdatedSourceObjectMap.forward((EObject) s);
		else
			return s;
	}

	public Object getDefaultSource(Object sp) {
		if (sp instanceof EObject)
			return defaultSourceToUpdatedSourceObjectMap.backward((EObject) sp);
		else
			return sp;
	}

	public void putTrace(Procedure r, Tuple t1, Tuple t2) {
		ruleTrace.put(r, t1, t2);
	}

	public Tuple getTrace(Procedure r, Tuple t) {
		return ruleTrace.get(r, t);
	}

	public void copyTo(TransformationTrace trace) {
		trace.defaultSourceToUpdatedSourceObjectMap = this.defaultSourceToUpdatedSourceObjectMap.clone();
		trace.ruleTrace = this.ruleTrace.clone();
	}

	public void mergeFrom(TransformationTrace from, TransformationTrace original) {
		mergeMap(this.defaultSourceToUpdatedSourceObjectMap.getForward(),
				from.defaultSourceToUpdatedSourceObjectMap.getForward(),
				original.defaultSourceToUpdatedSourceObjectMap.getForward());

		mergeMap(this.defaultSourceToUpdatedSourceObjectMap.getBackward(),
				from.defaultSourceToUpdatedSourceObjectMap.getBackward(),
				original.defaultSourceToUpdatedSourceObjectMap.getBackward());
		
		mergePairMap(this.ruleTrace, from.ruleTrace, original.ruleTrace);
	}

	static protected <F, S> void mergeMap(Map<F, S> to, Map<F, S> from, Map<F, S> original) {
		// for any <f,s> in "from", if <f,s'> in "original" or <f,_> in
		// "original", put <f,s> into "to"
		// an assumption is that the "to" will not change the entry that is
		// changed from "original" to "from"

		for (Entry<F, S> ef : from.entrySet()) {
			S originalValue = original.get(ef.getKey());
			if (ef.getValue() == null && originalValue != null) {
				to.remove(ef.getKey());
			} else {
				if (originalValue == null || !originalValue.equals(ef.getValue())) {
					to.put(ef.getKey(), ef.getValue());
				}
			}

		}
	}

	static protected <F, S, T> void mergePairMap(PairHashMap<F, S, T> to, PairHashMap<F, S, T> from,
			PairHashMap<F, S, T> original) {
		for (Entry<F, HashMap<S, T>> e : from.getMap().entrySet()) {
			if (e.getValue() == null) {
				HashMap<S, T> originalValueMap = original.getMap().get(e.getKey());
				if (originalValueMap != null) {
					to.getMap().remove(e.getKey());
				}
			} else {
				for (Entry<S, T> ie : e.getValue().entrySet()) {
					T originalValue = original.get(e.getKey(), ie.getKey());
					if (ie.getValue() == null && originalValue != null)
						to.put(e.getKey(), ie.getKey(), null);
					else {
						if (originalValue == null || !originalValue.equals(ie.getValue())) {
							to.put(e.getKey(), ie.getKey(), ie.getValue());
						}
					}
				}
			}
		}
	}
}
