package edu.ustb.sei.mde.xmu.resource.xmu.interpret.internal;
import edu.ustb.sei.mde.xmu.*;

public class StringVariable extends StringPatternElement {
	private Expr undefined;

	public Expr getUndefined() {
		return undefined;
	}

	public void setUndefined(Expr undefined) {
		this.undefined = undefined;
	}
}
