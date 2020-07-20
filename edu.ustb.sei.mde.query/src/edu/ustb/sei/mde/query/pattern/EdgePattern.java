package edu.ustb.sei.mde.query.pattern;

public class EdgePattern<FEATURE> implements Pattern {
	protected FEATURE type;
	protected NodePattern<?> source;
	protected NodePattern<?> target;
	
	protected Variable[] pair = null;
	
	static public <F> EdgePattern<F>[] make(int size) {
		@SuppressWarnings("unchecked")
		EdgePattern<F>[] edges = new EdgePattern[size];
		for(int i=0;i<size;i++) edges[i] = new EdgePattern<F>();
		return edges;
	}
	
	@Override
	public Variable[] getPorts() {
		if(pair==null) {
			pair = new Variable[] {source,target};
		}
		return pair;
	}

	public NodePattern<?> getSource() {
		return source;
	}

	public void setSource(NodePattern<?> source) {
		this.source = source;
	}

	public NodePattern<?> getTarget() {
		return target;
	}

	public void setTarget(NodePattern<?> target) {
		this.target = target;
	}
	
	
	public EdgePattern() {
		
	}
		
	@Override
	public String toString() {
		return type.toString()+"("+source.getName()+","+target.getName()+")";
	}

	public FEATURE getType() {
		return type;
	}

	public void setType(FEATURE type) {
		this.type = type;
	}
}
