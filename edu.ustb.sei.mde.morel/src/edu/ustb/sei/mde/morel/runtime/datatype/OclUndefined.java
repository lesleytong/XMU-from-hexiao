package edu.ustb.sei.mde.morel.runtime.datatype;

public class OclUndefined {
	private String name;
	private OclUndefined(String name) {
		this.name = name;
	}
	final static public OclUndefined INVALIDED = new OclUndefined("invalid");
}
