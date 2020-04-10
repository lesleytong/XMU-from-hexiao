package edu.ustb.sei.mde.bxcore.tests;

import edu.ustb.sei.mde.bxcore.exceptions.NothingReturnedException;
import edu.ustb.sei.mde.graph.type.ConcurrentTypeGraph;
import edu.ustb.sei.mde.graph.type.TypeGraph;
import edu.ustb.sei.mde.graph.typedGraph.BXMerge;
import edu.ustb.sei.mde.graph.typedGraph.ConcurrentBXMerge;
import edu.ustb.sei.mde.graph.typedGraph.ConcurrentTypedGraph;
import edu.ustb.sei.mde.graph.typedGraph.TypedEdge;
import edu.ustb.sei.mde.graph.typedGraph.TypedGraph;
import edu.ustb.sei.mde.graph.typedGraph.TypedNode;

public class TestLogical_3_Concurrent {

	static ConcurrentTypedGraph baseGraph = null;
	static ConcurrentTypedGraph aGraph = null;
	static ConcurrentTypedGraph bGraph = null;
	static ConcurrentTypedGraph resultGraph = null;
	
	
	public static void main(String[] args){
		
		build_baseGraph();
		build_aGraph();
		build_bGraph();
		
		try {
			
			Profiler.begin();
			resultGraph = ConcurrentBXMerge.merge(baseGraph, aGraph, bGraph);
			System.out.println("并行：" + Profiler.end() + "ms");
			
			System.out.println("merge后的resultGraph: ");
			print(resultGraph);
			
		} catch (NothingReturnedException e) {
			e.printStackTrace();
		}

	}
	
	private static void build_baseGraph() {
		
		ConcurrentTypeGraph concurrentTypeGraph = new ConcurrentTypeGraph();
		
		// add type nodes
		concurrentTypeGraph.declare("A");
		concurrentTypeGraph.declare("B");
		concurrentTypeGraph.declare("C");
		concurrentTypeGraph.declare("D");
		// add data type nodes
		concurrentTypeGraph.declare("String:java.lang.String");
		// add type edges
		concurrentTypeGraph.declare("a2b:A->B*");
		concurrentTypeGraph.declare("b2c:B->C");
		concurrentTypeGraph.declare("c2d:C->D");
		// add property edges
		concurrentTypeGraph.declare("a2S:A->String#");
		
		baseGraph = new ConcurrentTypedGraph(concurrentTypeGraph);
		
		baseGraph.declare(	
				"a1:A;"
				+"b1:B;"
				+"c1:C;"
				+"a1-a2b->b1;"		// e1	
				+"b1-b2c->c1;");
		
//		System.out.println("baseGraph: ");
//		print(baseGraph);
		
	}
	
	private static void build_aGraph() {
		
		aGraph = baseGraph.getCopy();
		
		// 删除b1
		TypedNode b1 = aGraph.getAllTypedNodes().get(1);
		aGraph.remove(b1);
		
		TypedNode c1 = aGraph.getAllTypedNodes().get(1);
		aGraph.remove(c1);
		
		System.out.println("aGraph: ");
		print(aGraph);
		
	}
	
	private static void build_bGraph() {
		
		bGraph = baseGraph.getCopy();
		
		TypedNode c1 = baseGraph.getAllTypedNodes().get(2);
		baseGraph.remove(c1);
		System.out.println("baseGraph: ");
		print(baseGraph);
		
		System.out.println("bGraph: ");
		print(bGraph);
		
	}
	
	private static void print(ConcurrentTypedGraph concurrentTypedGraph) {
		
		System.out.println("TypedNodes: " + concurrentTypedGraph.getAllTypedNodes().toString());
		System.out.println("ValueNodes: " + concurrentTypedGraph.getAllValueNodes().toString());
		System.out.println("TypedEdges: " + concurrentTypedGraph.getAllTypedEdges().toString());
		System.out.println("ValueEdges: " + concurrentTypedGraph.getAllValueEdges().toString());
		System.out.println("*********************************************************************");
		System.out.println();
	}
	
	
}
