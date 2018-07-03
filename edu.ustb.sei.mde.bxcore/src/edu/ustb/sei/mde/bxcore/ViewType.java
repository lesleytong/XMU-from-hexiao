package edu.ustb.sei.mde.bxcore;

import edu.ustb.sei.mde.bxcore.structures.Context;
import edu.ustb.sei.mde.graph.typedGraph.TypedGraph;
import edu.ustb.sei.mde.structure.Tuple2;

public class ViewType extends Tuple2<TypedGraph, Context> {

	private ViewType(TypedGraph first, Context second) {
		super(first, second);
	}

	public static ViewType makeView(TypedGraph first, Context second) {
		return new ViewType(first, second);
	}

	public ViewType replaceFirst(TypedGraph f) {
		return ViewType.makeView(f, second);
	}
	
	public ViewType replaceSecond(Context s) {
		return ViewType.makeView(first, s);
	}
}
