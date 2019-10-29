package edu.ustb.sei.mde.xmu2.runtime.string;

import edu.ustb.sei.mde.xmu2core.Expression;

public class StringVariable extends StringPatternElement {
	private Expression undefined;

	public Expression getUndefined() {
		return undefined;
	}

	public void setUndefined(Expression undefined) {
		this.undefined = undefined;
	}
}
