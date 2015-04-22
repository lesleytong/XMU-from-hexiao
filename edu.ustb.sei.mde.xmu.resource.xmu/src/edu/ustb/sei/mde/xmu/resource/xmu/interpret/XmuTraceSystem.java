package edu.ustb.sei.mde.xmu.resource.xmu.interpret;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;

import edu.ustb.sei.commonutil.util.Pair;

public class XmuTraceSystem {
	//private HashMap<EObject,XmuTraceLink> forwardLinkMap = null;
	//private HashMap<Pair<EObject,EObject>,XmuTraceLink> backwardLinkMap = null;
	
	private Map<EObject,EObject> corresponding = new HashMap<EObject,EObject>();
	private Map<EObject,EObject> defaultSource = new HashMap<EObject,EObject>();
	public Map<EObject, EObject> getDefaultSource() {
		return defaultSource;
	}

	private Map<EObject,EObject> viewCorresponding = new HashMap<EObject,EObject>();
	
	public EObject getCorresponding(EObject o) {
		if(o!=null)
			return corresponding.get(o);
		return null;
	}
	
	public EObject getViewCorresponding(EObject v) {
		if(v!=null) return viewCorresponding.get(v);
		return null;
	}
	
	public boolean setCorresponding(EObject a, EObject b) {
		if(a!=null) {
			corresponding.put(a, b);
			return true;
		} else return false;
	}

	public boolean setViewCorresponding(EObject a, EObject b) {
		if(a!=null) {
			viewCorresponding.put(a, b);
			return true;
		} else return false;
	}
	

//	private XmuTraceSystem() {
//	}
//	
//	public EObject forwardView(EObject s) {
//		XmuTraceLink l = forwardLinkMap.get(s);
//		if(l!=null) return l.getView();
//		return null;
//	}
//	
//	public boolean forwardLink(EObject s, EObject v) {
//		XmuTraceLink l = new XmuTraceLink(s,v,null);
//		forwardLinkMap.put(s, l);
//		return true;
//	}
//	
//	public void backwardDefaultLink(EObject s, EObject sp) {
//		XmuTraceLink l = new XmuTraceLink(s,sp);
//		forwardLinkMap.put(s,l);
//	}
//	
//	public boolean backwardSolidLink(EObject s,EObject v,EObject sp) {
//		XmuTraceLink l = forwardLinkMap.get(s);
//		if(l==null) return false;
//		if(backwardLinkMap.containsValue(l)) {
//			if(l.getSourcePost()==sp) return true;
//			else return false;
//		} else {
//			l.setSourcePost(v, sp);
//			backwardLinkMap.put(new Pair<EObject,EObject>(s,v), l);
//			return true;	
//		}
//	}
//	
//	public EObject backwardView(EObject s, EObject sp) {
//		XmuTraceLink l = forwardLinkMap.get(s);
//		if(l!=null && l.getSourcePost() == sp) return l.getView();
//		return null;
//	}
//	
//	public EObject backwardSourcePost(EObject s,EObject v) {
//		XmuTraceLink l = null;
//		if(v==null && s != null) {
//			l = forwardLinkMap.get(s);
//		} else if(v!=null) {
//			l = backwardLinkMap.get(new Pair<EObject,EObject>(s,v));
//		}
//		if(l==null) return null;
//		return l.getSourcePost();
//	}
//	
//	static public XmuTraceSystem createForwardTraceSystem() {
//		XmuTraceSystem x = new XmuTraceSystem();
//		x.forwardLinkMap = new HashMap<EObject,XmuTraceLink>();
//		return x;
//	}
//	
//	static public XmuTraceSystem createBackwardTraceSystem() {
//		XmuTraceSystem x = new XmuTraceSystem();
//		x.forwardLinkMap = new HashMap<EObject,XmuTraceLink>();
//		x.backwardLinkMap = new HashMap<Pair<EObject,EObject>,XmuTraceLink>();
//		return x;
//	}
}
