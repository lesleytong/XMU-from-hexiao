package edu.ustb.sei.mde.graph.typedGraph.constraint;

import java.util.List;

import edu.ustb.sei.mde.bxcore.structures.Context;
import edu.ustb.sei.mde.graph.typedGraph.TypedGraph;

@FunctionalInterface
public interface GraphConstraint {
	public boolean check(TypedGraph sourceGraph, Context sourceContext, TypedGraph viewGraph, Context viewContext);
	
	static GraphConstraint and(GraphConstraint... cons) {
		return (gs,cs, gv, cv)-> {
			for(GraphConstraint cc : cons) {
				if(cc.check(gs,cs, gv, cv)==false) return false;
			}
			return true;
		};
	}
	
	static GraphConstraint and(List<GraphConstraint> cons) {
		return (gs,cs, gv, cv)->{
			return cons.stream().allMatch(cc->cc.check(gs,cs, gv, cv));
		};
	}
	
	static GraphConstraint TRUE = (gs,cs, gv, cv)->true;
	static GraphConstraint FALSE = (gs,cs, gv, cv)->false;
}


