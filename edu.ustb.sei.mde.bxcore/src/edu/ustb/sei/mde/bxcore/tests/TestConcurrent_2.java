package edu.ustb.sei.mde.bxcore.tests;
/**
 * 2-way
 */
import edu.ustb.sei.mde.graph.type.ConcurrentTypeGraph;
import edu.ustb.sei.mde.graph.typedGraph.ConcurrentBXMerge;
import edu.ustb.sei.mde.graph.typedGraph.ConcurrentTypedGraph;

public class TestConcurrent_2 {

	static ConcurrentTypedGraph baseGraph = null;
	static ConcurrentTypedGraph aGraph = null;
	static ConcurrentTypedGraph resultGraph = null;
	
	
	public static void main(String[] args){
		
		build_baseGraph();
		build_aGraph();
		
		Profiler.begin();
		resultGraph = ConcurrentBXMerge.additiveMerge(baseGraph, aGraph);
		System.out.println("并行：" + Profiler.end() + "ms");
		
		System.out.println("merge后的resultGraph: ");
		print(resultGraph);
		

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
				+"a1-a2b->b1;"			//e1
				+"a1.a2S=\"str1\";"
				+"a1.a2S=\"str2\";"
				+"a1.a2S=\"str3\";");	
		
		System.out.println("baseGraph: ");
		print(baseGraph);	
		
	}
	
	private static void build_aGraph() {
		
		aGraph = baseGraph.getCopy();
		
		aGraph.declare("c1:C;" 
					 + "d1:D;" 
					 + "c1-c2d->d1;"
					 
					 + "c2:C;"
					 + "d2:D;"
					 + "c2-c2d->d2;"
					 
					 + "c3:C;"
					 + "d3:D;"
					 + "c3-c2d->d3;"
					 
					 + "c4:C;"
					 + "d4:D;"
					 + "c4-c2d->d4;"
					 
					 + "c5:C;"
					 + "d5:D;"
					 + "c5-c2d->d5;"
					 
					 + "c6:C;"
					 + "d6:D;"
					 + "c6-c2d->d6;"
					 
					 + "c7:C;"
					 + "d7:D;"
					 + "c7-c2d->d7;"
					 
					 + "c8:C;"
					 + "d8:D;"
					 + "c8-c2d->d8;"
					 
					 + "c9:C;"
					 + "d9:D;"
					 + "c9-c2d->d9;"
					 
					 + "c10:C;"
					 + "d10:D;"
					 + "c10-c2d->d10;"
					 
					 + "c11:C;"
					 + "d11:D;"
					 + "c11-c2d->d11;"
					 
					 + "c12:C;"
					 + "d12:D;"
					 + "c12-c2d->d12;"
					 
					 + "c13:C;"
					 + "d13:D;"
					 + "c13-c2d->d13;"
					 
					 + "c14:C;"
					 + "d14:D;"
					 + "c14-c2d->d14;"
					 
					 + "c15:C;"
					 + "d15:D;"
					 + "c15-c2d->d15;"
					 
					 + "c16:C;"
					 + "d16:D;"
					 + "c16-c2d->d16;"
					 
					 + "c17:C;"
					 + "d17:D;"
					 + "c17-c2d->d17;"
					 
					);
		
		System.out.println("aGraph: ");
		print(aGraph);
		
	}
	
	
	private static void print(ConcurrentTypedGraph concurrentTypedGraph) {
		
		System.out.println("TypedNodes: " + concurrentTypedGraph.getAllTypedNodes().size());
		System.out.println("ValueNodes: " + concurrentTypedGraph.getAllValueNodes().size());
		System.out.println("TypedEdges: " + concurrentTypedGraph.getAllTypedEdges().size());
		System.out.println("ValueEdges: " + concurrentTypedGraph.getAllValueEdges().size());
		System.out.println("*********************************************************************");
		System.out.println();
	}
	
	
}
