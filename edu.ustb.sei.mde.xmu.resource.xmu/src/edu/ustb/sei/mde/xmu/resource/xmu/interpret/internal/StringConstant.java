package edu.ustb.sei.mde.xmu.resource.xmu.interpret.internal;

public class StringConstant extends StringPatternElement {
	private String constant;
	private boolean first;

	public String getConstant() {
		return constant;
	}

	public void setConstant(String constant) {
		this.constant = constant;
	}

	public boolean isFirst() {
		return first;
	}

	public void setFirst(boolean first) {
		this.first = first;
	}
}
