package edu.ustb.sei.mde.morel.resource.morel.execution.primitives;

import edu.ustb.sei.mde.morel.resource.morel.execution.constraints.PropEnclosureLinkS_T;

public class Initialize {
	static final public Initialize instance = new Initialize();
	public void initialize() {
		PropEnclosureLinkS_T.resetCache();
	}

}
