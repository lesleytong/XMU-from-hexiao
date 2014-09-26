package edu.ustb.sei.mde.emg.runtime.datatype;

public class OclUndefined {
	private String name;
	private OclUndefined(String name) {
		this.name = name;
	}
	final static public OclUndefined INVALIDED = new OclUndefined("invalid");
	final static public OclUndefined NULL = null;
	
	public static boolean isOclUndefined(Object self) {
		if(self==NULL || self==INVALIDED) return true;
		return false;
	}
	
	public String toString(){
		return name;
	}
}
