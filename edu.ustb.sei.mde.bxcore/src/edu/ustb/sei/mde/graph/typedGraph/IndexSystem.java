package edu.ustb.sei.mde.graph.typedGraph;

import java.util.HashMap;
import java.util.Map;

import edu.ustb.sei.mde.bxcore.Trace;
import edu.ustb.sei.mde.bxcore.TraceSystem;
import edu.ustb.sei.mde.bxcore.XmuCoreUtils;
import edu.ustb.sei.mde.bxcore.exceptions.NothingReturnedException;
import edu.ustb.sei.mde.bxcore.exceptions.UninitializedException;
import edu.ustb.sei.mde.bxcore.structures.Context;
import edu.ustb.sei.mde.bxcore.structures.FieldDef;
import edu.ustb.sei.mde.bxcore.structures.Index;

public class IndexSystem {
	final static public Index INITIAL_INDEX = IndexSystem.generateFreshIndex();	
	final static public Index TERMINAL_INDEX = IndexSystem.generateFreshIndex();
	
	protected Map<Object,IndexableElement> indexToObjectMap;
	
	public IndexSystem() {
		this.indexToObjectMap = new HashMap<>();
	}
	
	public void addIndex(Object index, IndexableElement obj) throws NothingReturnedException {
		if(index instanceof Index) {
			for(Object o : ((Index) index).internalIndices()) {
				addIndex(o, obj);
			}
		} else {
			registerIndex(index, obj);
			obj.appendIndexValue(index);
		}
//		Set<Object> indices = obj.getIndices();
//		indices.add(index);
	}

	/** 将索引集和对象的对应关系，添加到indexToObjectMap中 */
	public void registerIndex(Object index, IndexableElement obj) throws NothingReturnedException {
		Object prev = this.indexToObjectMap.put(index, obj);	//put的返回类型是Value的类型（即IndexableElement）
		
		if((prev!=null && prev!=obj) || obj.isIndexable()==false) 
			throw new NothingReturnedException("You are trying to map an index onto two elements");
	}
	
	/** 将元素e的索引集从indexToObjectMap中清除 */
	protected void clearIndex(IndexableElement e) {
		e.foreach(i->{
			this.indexToObjectMap.remove(i);
		});
	}
	
	/** 根据Index获取对象 */
	@SuppressWarnings("unchecked")
	public <T> T getElementByIndexObject(Index index) throws NothingReturnedException {
		T res = null;
		for(Object i : index.internalIndices()) {
			if((res=(T) this.indexToObjectMap.get(i)) != null) {	//根据键获取值
				return res;
			}
		}
		
		XmuCoreUtils.warning("No element is associated with this index");
		throw new NothingReturnedException();
	}
	
	static protected Object generateUUID() {
		return java.util.UUID.randomUUID();
	}
	
	static public Index generateFreshIndex() {
		return Index.freshIndex(generateUUID());
	}
	
	static public Index generateFreshViewIndex(String tkey, Context source, FieldDef<?> vkey, TraceSystem traceSys) {
		for(Trace trace : traceSys.allTraces()) {
			FieldDef<?> downKey = trace.view.getDownKeyFromUpstreamKey(vkey);
			if(downKey==null) continue;
			if((tkey==null && trace.source.isDownstreamOf(source))
					|| (tkey!=null &&tkey.equals(trace.key) && trace.source.equals(source))) {
				try {
					return trace.view.getIndexValue(downKey);
				} catch (UninitializedException | NothingReturnedException e) {
					XmuCoreUtils.warning("A fresh new view index is generated while a traced index is expected", e);
					return generateFreshIndex();
				}
			}
		}
		return generateFreshIndex();
	}
	
	static public Index generateFreshSourceIndex(String tkey, Context source, Context view, FieldDef<?> skey, TraceSystem traceSys) {
		for(Trace trace : traceSys.allTraces()) {
			FieldDef<?> downKey = trace.sourcePost.getDownKeyFromUpstreamKey(skey);
			if(downKey==null) continue;
			if((tkey==null && trace.source.isDownstreamOf(source) && trace.view.isDownstreamOf(view))
					|| (tkey!=null && (tkey==XmuCoreUtils.ANY_INDEX || tkey.equals(trace.key)) && trace.source.equals(source) && trace.view.equals(view))) {
				try {
					return trace.sourcePost.getIndexValue(downKey);
				} catch (UninitializedException | NothingReturnedException e) {
					XmuCoreUtils.warning("A fresh new source index is generated while a traced index is expected", e);
					return generateFreshIndex();
				}
			}
		}
		return generateFreshIndex();
	}

}


