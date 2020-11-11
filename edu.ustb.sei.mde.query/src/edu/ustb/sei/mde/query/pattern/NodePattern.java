package edu.ustb.sei.mde.query.pattern;

public class NodePattern<CLASSIFIER> extends Variable implements Pattern {
	public NodePattern() {
		super();
	}

	protected CLASSIFIER type;
	protected Variable[] singleton = null;
	
	@Override
	public Variable[] getPorts() {
		if(singleton==null) {
			singleton = new Variable[] {this};
		}
		return singleton;
	}
	
	
	@SuppressWarnings("unchecked")
	static public <C> NodePattern<C>[] make(int size) {
		NodePattern<?>[] array = new NodePattern[size];
		for(int i=0;i<size;i++) array[i] = new NodePattern<C>();
		return (NodePattern<C>[]) array;
	}
	
	@Override
	public String toString() {
		return type.toString()+"("+getName()+")";
	}

	public CLASSIFIER getType() {
		return type;
	}

	public void setType(CLASSIFIER type) {
		this.type = type;
	}
}
