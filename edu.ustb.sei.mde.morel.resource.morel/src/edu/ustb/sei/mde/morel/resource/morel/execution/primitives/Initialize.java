package edu.ustb.sei.mde.morel.resource.morel.execution.primitives;


public class Initialize {
	static final public Initialize instance = new Initialize();
	public void initialize() {
		Apply.resetCache();
		Match.resetCache();
	}

}
