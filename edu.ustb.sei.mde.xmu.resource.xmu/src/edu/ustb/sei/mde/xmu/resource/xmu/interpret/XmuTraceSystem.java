package edu.ustb.sei.mde.xmu.resource.xmu.interpret;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcorePackage;

import edu.ustb.sei.commonutil.util.Pair;
import edu.ustb.sei.commonutil.util.PairHashMap;

public class XmuTraceSystem {
	private static final String DT_STRING = "String";
	private static final String DT_BOOLEAN = "boolean";
	private static final String DT_INT = "int";


	//private HashMap<EObject,XmuTraceLink> forwardLinkMap = null;
	//private HashMap<Pair<EObject,EObject>,XmuTraceLink> backwardLinkMap = null;
	
	public XmuTraceSystem() {
		init();
	}
	
	protected void init() {
		//init forward
		put(DT_STRING,null,EcorePackage.eINSTANCE.getEString());
		put(DT_BOOLEAN,null,EcorePackage.eINSTANCE.getEBoolean());
		put(DT_INT,null,EcorePackage.eINSTANCE.getEInt());
		
		//init backward
		put(DT_STRING,EcorePackage.eINSTANCE.getEString(),DT_STRING);
		put(DT_BOOLEAN,EcorePackage.eINSTANCE.getEBoolean(),DT_BOOLEAN);
		put(DT_INT,EcorePackage.eINSTANCE.getEInt(),DT_INT);
		
	}
	
	protected void put(Object first, Object second, Object third) {
		XmuTraceTuple f = first==null ? XmuTraceTuple.ANY_TUPLE : XmuTraceTuple.createTupleFromArray(first);
		XmuTraceTuple s = second==null ? XmuTraceTuple.ANY_TUPLE : XmuTraceTuple.createTupleFromArray(second);
		XmuTraceTuple th = third==null ? XmuTraceTuple.ANY_TUPLE : XmuTraceTuple.createTupleFromArray(third);
		
		traces.put(f, s, th);
	}
	
	private PairHashMap<XmuTraceTuple,XmuTraceTuple,XmuTraceTuple> traces = new PairHashMap<XmuTraceTuple,XmuTraceTuple,XmuTraceTuple>();
	
	/*
	 * when you try to put a full link from source,view to source@post
	 * if sourcePost is created from empty, sources = NULL_TUPLE
	 */
	public boolean putBackward(List<? extends Object> sources, List<? extends Object> views, List<? extends Object> sourcePosts) {
		XmuTraceTuple src = XmuTraceTuple.createTuple(sources);
		XmuTraceTuple tar = XmuTraceTuple.createTuple(views);
		XmuTraceTuple srcPost = XmuTraceTuple.createTuple(sourcePosts);

//		XmuTraceTuple any = XmuTraceTuple.ANY_TUPLE;		
//		XmuTraceTuple anySp = traces.get(src, any);
//		if(anySp!=null) {
//			if(anySp.equals(srcPost)) return true;
//			return false; // you have put a direct link for this source
//		}
		
		XmuTraceTuple sp = traces.get(src, tar);
		
		if(sp!=null){
			if(sp.equals(sourcePosts)) return true;
			else return false;
		} else {
			traces.put(src, tar, srcPost);
			return true;
		}
	}
	
	public void removeBackward(List<? extends Object> sources) {
		traces.remove(XmuTraceTuple.createTuple(sources));//you can only remove a default link
	}
	
	/*
	 * when you try to put a direct link from source to source@post
	 * view = ANY_TUPLE
	 */
	public boolean putBackward(List<? extends Object> sources, List<? extends Object> sourcePosts) {
		XmuTraceTuple src = XmuTraceTuple.createTuple(sources);
		XmuTraceTuple tar = XmuTraceTuple.ANY_TUPLE;
		
		XmuTraceTuple srcPost = XmuTraceTuple.createTuple(sourcePosts);
		
		XmuTraceTuple sp = traces.get(src, tar);
		
		//I have to check if I have ever put any full link
		//FIXME
		//end
		
		if(sp!=null){
			if(sp.equals(sourcePosts)) return true;
			else return false;
		} else {
			traces.put(src, tar, srcPost);
			return true;
		}
	}
	
	public XmuTraceTuple getBackward(List<? extends Object> sources, List<? extends Object> views) {
		XmuTraceTuple src = XmuTraceTuple.createTuple(sources);
		XmuTraceTuple tar = XmuTraceTuple.createTuple(views);
		
		return traces.get(src, tar);
	}
	
	public XmuTraceTuple getBackward(List<? extends Object> sources) {
		XmuTraceTuple src = XmuTraceTuple.createTuple(sources);
		XmuTraceTuple tar = XmuTraceTuple.getAnyTuple();
		
		return traces.get(src, tar);
	}
	
	public boolean putForward(List<? extends Object> sources, List<? extends Object> views) {
		XmuTraceTuple src = XmuTraceTuple.createTuple(sources);
		XmuTraceTuple any = XmuTraceTuple.ANY_TUPLE;
		
		XmuTraceTuple tar = XmuTraceTuple.createTuple(views);
		
		XmuTraceTuple oldTar = traces.get(src, any);
		
		if(oldTar!=null) {
			if(oldTar.equals(tar)) return true;
			else return false;
		} else {
			traces.put(src, any, tar);
			return true;
		}
		
	}
	
	public XmuTraceTuple getForward(List<? extends Object> sources) {
		XmuTraceTuple src = XmuTraceTuple.createTuple(sources);
		XmuTraceTuple any = XmuTraceTuple.ANY_TUPLE;
		return traces.get(src, any);
	}
	
	
	private Map<EObject,EObject> defaultSource = new HashMap<EObject,EObject>();
	
	/*
	 * the default link is created when initializing source post
	 */
	public Map<EObject, EObject> getDefaultSource() {
		return defaultSource;
	}

//	@Deprecated
//	private Map<EObject,EObject> viewCorresponding = new HashMap<EObject,EObject>();
//	@Deprecated
//	private Map<EObject,EObject> corresponding = new HashMap<EObject,EObject>();
//	
//	@Deprecated
//	public EObject getCorresponding(EObject o) {
//		if(o!=null)
//			return corresponding.get(o);
//		return null;
//	}
//	
//	@Deprecated
//	public EObject getViewCorresponding(EObject v) {
//		if(v!=null) return viewCorresponding.get(v);
//		return null;
//	}
	
//	@Deprecated
//	public boolean setCorresponding(EObject a, EObject b) {
//		if(a!=null) {
//			corresponding.put(a, b);
//			return true;
//		} else return false;
//	}
//
//	@Deprecated
//	public boolean setViewCorresponding(EObject a, EObject b) {
//		if(a!=null) {
//			viewCorresponding.put(a, b);
//			return true;
//		} else return false;
//	}
}
