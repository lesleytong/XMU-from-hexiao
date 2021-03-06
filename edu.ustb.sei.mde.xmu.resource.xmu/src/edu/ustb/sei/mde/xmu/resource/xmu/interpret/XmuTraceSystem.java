package edu.ustb.sei.mde.xmu.resource.xmu.interpret;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcorePackage;

import edu.ustb.sei.commonutil.util.BidirectionalMap;
import edu.ustb.sei.commonutil.util.Pair;
import edu.ustb.sei.commonutil.util.PairHashMap;
import edu.ustb.sei.mde.xmu.Rule;

public class XmuTraceSystem {
	
	public XmuTraceSystem() {
		init();
	}
	
	protected void init() {

	}
	
	protected void put(Rule rule, XmuTraceTuple parameters, XmuTraceTuple result) {
		traces.put(rule, parameters, result);
	}
	
	public boolean put(Rule rule, List<? extends Object> param, List<? extends Object> res) {
		XmuTraceTuple paramTuple = XmuTraceTuple.createTuple(param);
		XmuTraceTuple resTuple = XmuTraceTuple.createTuple(res);
		
		traces.put(rule, paramTuple, resTuple);
		return true;
	}
	
	public boolean put(EObject s, EObject sp) {
		defaultMap.put(s, sp);
		return true;
	}
	
	public XmuTraceTuple get(Rule rule, List<? extends Object> param) {
		XmuTraceTuple paramTuple = XmuTraceTuple.createTuple(param);
		return traces.get(rule, paramTuple);
	}
	
	public EObject getSourcePost(EObject s) {
		return defaultMap.forward(s);
	}
	public EObject getSource(EObject sp) {
		return defaultMap.backward(sp);
	}

	
//	protected void put(Object first, Object second, Object third) {
//		XmuTraceTuple f = first==null ? XmuTraceTuple.ANY_TUPLE : XmuTraceTuple.createTupleFromArray(first);
//		XmuTraceTuple s = second==null ? XmuTraceTuple.ANY_TUPLE : XmuTraceTuple.createTupleFromArray(second);
//		XmuTraceTuple th = third==null ? XmuTraceTuple.ANY_TUPLE : XmuTraceTuple.createTupleFromArray(third);
//		
//		traces.put(f, s, th);
//	}
//	
//	
//	/*
//	 * when you try to put a full link from source,view to source@post
//	 * if sourcePost is created from empty, sources = NULL_TUPLE
//	 */
//	public boolean putBackward(List<? extends Object> sources, List<? extends Object> views, List<? extends Object> sourcePosts) {
//		XmuTraceTuple src = XmuTraceTuple.createTuple(sources);
//		XmuTraceTuple tar = XmuTraceTuple.createTuple(views);
//		XmuTraceTuple srcPost = XmuTraceTuple.createTuple(sourcePosts);
//
////		XmuTraceTuple any = XmuTraceTuple.ANY_TUPLE;		
////		XmuTraceTuple anySp = traces.get(src, any);
////		if(anySp!=null) {
////			if(anySp.equals(srcPost)) return true;
////			return false; // you have put a direct link for this source
////		}
//		
//		XmuTraceTuple sp = traces.get(src, tar);
//		
//		if(sp!=null){
//			if(sp.equals(sourcePosts)) return true;
//			else return false;
//		} else {
//			traces.put(src, tar, srcPost);
//			return true;
//		}
//	}
//	
//	public void removeBackward(List<? extends Object> sources) {
//		traces.remove(XmuTraceTuple.createTuple(sources));//you can only remove a default link
//	}
//	
//	/*
//	 * when you try to put a direct link from source to source@post
//	 * view = ANY_TUPLE
//	 */
//	public boolean putBackward(List<? extends Object> sources, List<? extends Object> sourcePosts) {
//		XmuTraceTuple src = XmuTraceTuple.createTuple(sources);
//		XmuTraceTuple tar = XmuTraceTuple.ANY_TUPLE;
//		
//		XmuTraceTuple srcPost = XmuTraceTuple.createTuple(sourcePosts);
//		
//		XmuTraceTuple sp = traces.get(src, tar);
//		
//		//I have to check if I have ever put any full link
//		//FIXME
//		//end
//		
//		if(sp!=null){
//			if(sp.equals(sourcePosts)) return true;
//			else return false;
//		} else {
//			traces.put(src, tar, srcPost);
//			return true;
//		}
//	}
//	
//	public XmuTraceTuple getBackward(List<? extends Object> sources, List<? extends Object> views) {
//		XmuTraceTuple src = XmuTraceTuple.createTuple(sources);
//		XmuTraceTuple tar = XmuTraceTuple.createTuple(views);
//		
//		return traces.get(src, tar);
//	}
//	
//	public XmuTraceTuple getBackward(List<? extends Object> sources) {
//		XmuTraceTuple src = XmuTraceTuple.createTuple(sources);
//		XmuTraceTuple tar = XmuTraceTuple.getAnyTuple();
//		
//		return traces.get(src, tar);
//	}
//	
//	public boolean putForward(List<? extends Object> sources, List<? extends Object> views) {
//		XmuTraceTuple src = XmuTraceTuple.createTuple(sources);
//		XmuTraceTuple any = XmuTraceTuple.ANY_TUPLE;
//		
//		XmuTraceTuple tar = XmuTraceTuple.createTuple(views);
//		
//		XmuTraceTuple oldTar = traces.get(src, any);
//		
//		if(oldTar!=null) {
//			if(oldTar.equals(tar)) return true;
//			else return false;
//		} else {
//			traces.put(src, any, tar);
//			return true;
//		}
//		
//	}
//	
//	public XmuTraceTuple getForward(List<? extends Object> sources) {
//		XmuTraceTuple src = XmuTraceTuple.createTuple(sources);
//		XmuTraceTuple any = XmuTraceTuple.ANY_TUPLE;
//		return traces.get(src, any);
//	}
	
	
	
	
	private BidirectionalMap<EObject,EObject> defaultMap = new BidirectionalMap<EObject,EObject>();
	
	/*
	 * the default link is created when initializing source post
	 */
//	public Map<EObject, EObject> getDefaultSource() {
//		return defaultSource;
//	}
	
	private PairHashMap<Rule, XmuTraceTuple, XmuTraceTuple> traces = new PairHashMap<Rule, XmuTraceTuple, XmuTraceTuple>(); 
}
