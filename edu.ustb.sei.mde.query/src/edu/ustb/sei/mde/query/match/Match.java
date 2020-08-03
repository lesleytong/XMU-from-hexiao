package edu.ustb.sei.mde.query.match;

import java.util.HashMap;
import java.util.Map;

import edu.ustb.sei.mde.query.pattern.Pattern;

public class Match implements Cloneable {
	protected Map<Object,Object> bindings;
	
	public Match() {
		bindings = new HashMap<Object, Object>(32);
	}
	
	public void put(Object k, Object v) {
		bindings.put(k, v);
	}
	
	@SuppressWarnings("unchecked")
	public <T> T get(Object k) {
		return (T)bindings.get(k);
	}
	
	public boolean contains(Object value) {
		return bindings.values().contains(value);
	}

	public void remove(Pattern pattern) {
	  bindings.remove(pattern);
	}
	
	@Override
	public Match clone() throws CloneNotSupportedException {
		Match clone = new Match();
		clone.bindings.putAll(this.bindings);
		return clone;
	}
	
	@Override
	public String toString() {
		StringBuilder builder= new StringBuilder();
		builder.append("====MATCH BEGIN====\n");
		bindings.forEach((k,v)->{
			builder.append(k);
			builder.append("\t:=\t");
			builder.append(v);
			builder.append("\n");
		});
		builder.append("====MATCH END======");
		return builder.toString();
	}
	
	public boolean isEmpty() {
		return bindings.isEmpty();
	}
}
