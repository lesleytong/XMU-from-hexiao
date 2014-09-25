package edu.ustb.sei.mde.emg.runtime.datatype;

public class OclUndefined {
	private String name;
	private OclUndefined(String name) {
		this.name = name;
	}
	final static public OclUndefined INVALIDED = new OclUndefined("invalid");
	public static boolean isOclUndefined(Object self) {
		if(self==null || self==INVALIDED) return true;
		return false;
	}
	
	public String toString(){
		return name;
	}
}
