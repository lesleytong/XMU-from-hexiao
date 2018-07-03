package edu.ustb.sei.mde.bxcore;

import edu.ustb.sei.mde.bxcore.structures.Context;
import edu.ustb.sei.mde.graph.typedGraph.TypedGraph;
import edu.ustb.sei.mde.structure.Tuple3;

public class SourceType extends Tuple3<TypedGraph, Context, TraceSystem> {

	private SourceType(TypedGraph first, Context second, TraceSystem ts) {
		super(first, second, ts);
	}

	public static SourceType makeSource(TypedGraph first, Context second, TraceSystem ts) {
		return new SourceType(first, second, ts);
	}
	
	public SourceType replaceFirst(TypedGraph g) {
		return SourceType.makeSource(g, second, third);
	}
	
	public SourceType replaceSecond(Context s) {
		return SourceType.makeSource(first, s, third);
	}
	
	public SourceType replaceThird(TraceSystem t) {
		return SourceType.makeSource(first, second, t);
	}

}
