package edu.ustb.sei.mde.graph.type;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import edu.ustb.sei.mde.bxcore.structures.FieldDef;
import edu.ustb.sei.mde.bxcore.structures.GraphPath;
import edu.ustb.sei.mde.graph.IEdge;
import edu.ustb.sei.mde.graph.typedGraph.ITypedEdge;

public abstract class PathType implements IElementType {
	protected PathType container = null;
	protected PathType silbing = null;
	
	protected PathType[] moveToNext() {
		if(this.silbing!=null) return new PathType[] {this.silbing};
		else if(this.container!=null) return this.container.moveToNext();
		else return null;
	}
	

	static public PathType simple(IStructuralFeatureEdge edge) {
		SimplePath p = new SimplePath();
		p.setEdge(edge);
		return p;
	}
	
	static public PathType alt(PathType... paths) {
		if(paths.length==1) return paths[0];
		AltPath p = new AltPath();
		p.setPaths(paths);
		return p;
	}
	
	static public PathType seq(PathType... paths) {
		if(paths.length==1) return paths[0];
		SeqPath p = new SeqPath();
		p.setPaths(paths);
		return p;
	}
	
	static public RepPath rep(PathType path) {
		RepPath p = new RepPath();
		p.setPath(path);
		return p;
	}
	
	static final protected Class<?> edgeArrayType = FieldDef.EMPTY_PATH.getClass();
	
	@Override
	final public boolean isInstance(Object value) {
		if(value==null || !(value instanceof GraphPath)) return false;
		else {
			IEdge[] pathValue = ((GraphPath)value).getPathEdges();
			for(int i=0;i<pathValue.length - 1;i++) {
				IEdge pe = pathValue[i];
				IEdge ne = pathValue[i+1];
				if(pe.getTarget()!=ne.getSource()) return false;
			}
			
			return isInstanceFrom(pathValue, 0, new PathCheckCache());
		}
	}
	
	abstract protected boolean isInstanceFrom(IEdge[] values, int index, PathCheckCache cache);
}

class PathCheckCache {
	private Map<PathType,Map<Integer, Boolean>> cache = new HashMap<>();
	public Boolean check(PathType type, int index) {
		Map<Integer, Boolean> map = cache.getOrDefault(type, Collections.emptyMap());
		return map.get(index);
	}
	public void setCache(PathType type, int index, boolean value) {
		Map<Integer, Boolean> map = cache.get(type);
		if(map==null) {
			map = new HashMap<>();
			cache.put(type, map);
		}
		map.put(index, value);
	}
}

class SimplePath extends PathType {
	private IStructuralFeatureEdge edge;

	public IStructuralFeatureEdge getEdge() {
		return edge;
	}

	public void setEdge(IStructuralFeatureEdge edge) {
		this.edge = edge;
	}
	
	@Override
	public String getName() {
		return edge.getName();
	}
	
	@Override
	public Class<?> getJavaType() {
		return edge.getJavaType();
	}
	
	@Override
	protected boolean isInstanceFrom(IEdge[] values, int index, PathCheckCache cache) {
		Boolean flag = cache.check(this, index);
		if(flag!=null) return flag;
		
		if(values.length<=index) {
			cache.setCache(this, index, false);
			return false;
		}
		else if(edge.isInstance(values[index])) {
			PathType[] next = this.moveToNext();
			if(next==null) {
				boolean value = index + 1 == values.length;
				cache.setCache(this, index, value);
				return value;
			} else {
				for(PathType np : next) {
					if(np.isInstanceFrom(values, index + 1, cache)) {
						cache.setCache(this, index, true);
						return true;
					}
				}
				cache.setCache(this, index, false);
				return false;
			}
		} else {
			cache.setCache(this, index, false);
			return false;
		}
	}
}

class AltPath extends PathType {
	private PathType[] paths;

	public PathType[] getPaths() {
		return paths;
	}

	void setPaths(PathType[] paths) {
		this.paths = paths;
		for(PathType p : paths) {
			p.container = this;
		}
	}
	
	private String cachedName = null;
	@Override
	public String getName() {
		if(cachedName==null) {
			cachedName = "("+Arrays.stream(paths).reduce("", (s, p)->(s+"|"+p.getName()),(l,r)->(l+"|"+r))+")";
		}
		return cachedName;
	}
	
	
	@Override
	public Class<?> getJavaType() {
		if(Arrays.stream(paths).anyMatch(p->p.getJavaType()==edgeArrayType))
			return edgeArrayType;
		return ITypedEdge.class;
	}
	
	@Override
	protected boolean isInstanceFrom(IEdge[] values, int index, PathCheckCache cache) {
		Boolean flag = cache.check(this, index);
		if(flag!=null) return flag;
		
		for(PathType edge : paths) {
			if(edge.isInstanceFrom(values, index, cache)) {
				cache.setCache(this, index, true);
				return true;
			}
		}
		cache.setCache(this, index, false);
		return false;
	}
}

class SeqPath extends PathType {
	private PathType[] paths;
	public PathType[] getPaths() {
		return paths;
	}

	void setPaths(PathType[] paths) {
		this.paths = paths;
		for(int i=0;i<paths.length-1;i++) {
			paths[i].silbing = paths[i+1];
			paths[i].container = this;
		}
		paths[paths.length-1].container = this;
	}
	
	private String cachedName = null;
	@Override
	public String getName() {
		if(cachedName==null) {
			cachedName = Arrays.stream(paths).reduce("", (s, p)->(s+"."+p.getName()),(l,r)->(l+"."+r));
		}
		return cachedName;
	}
	
	@Override
	public Class<?> getJavaType() {
		return edgeArrayType;
	}
	
	@Override
	protected boolean isInstanceFrom(IEdge[] values, int index, PathCheckCache cache) {
		Boolean flag = cache.check(this, index);
		if(flag!=null) return flag;
		
		boolean value = paths[0].isInstanceFrom(values, index, cache);
		cache.setCache(this, index, value);
		return value;
	}
}

class RepPath extends PathType {
	private PathType path;
	private boolean maySkip = false;

	public PathType getPath() {
		return path;
	}

	public void setPath(PathType path) {
		this.path = path;
		path.container = this;
	}
	private String cachedName = null;
	@Override
	public String getName() {
		if(cachedName==null) {
			cachedName = "("+path.getName()+")*";
		}
		return cachedName;
	}
	
	@Override
	public Class<?> getJavaType() {
		return edgeArrayType;
	}
	
	@Override
	protected PathType[] moveToNext() {
		PathType[] oldNext = super.moveToNext();
		PathType[] newNext = new PathType[oldNext.length+1];
		for(int i=0;i<oldNext.length;i++) 
			newNext[i+1] = oldNext[i];
		
		newNext[0] = this;
		
		return newNext;
	}
	
	@Override
	protected boolean isInstanceFrom(IEdge[] values, int index, PathCheckCache cache) {
		Boolean flag = cache.check(this, index);
		if(flag!=null) return flag;
		
		if(maySkip) {
			PathType[] next = super.moveToNext();
			if(next==null) {
				boolean value = index == values.length;
				cache.setCache(this, index, value);
			}
			for(PathType np : next) {
				if(np.isInstanceFrom(values, index, cache)) {
					cache.setCache(this, index, true);
					return true;
				}
			}
		}
		boolean value = path.isInstanceFrom(values, index, cache);
		cache.setCache(this, index, value);
		return value;
	}
}