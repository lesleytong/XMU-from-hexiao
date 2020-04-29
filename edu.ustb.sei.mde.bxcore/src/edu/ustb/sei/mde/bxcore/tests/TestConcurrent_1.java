package edu.ustb.sei.mde.bxcore.tests;
/**
 * 3-way
 */
import edu.ustb.sei.mde.bxcore.exceptions.NothingReturnedException;
import edu.ustb.sei.mde.graph.type.ConcurrentTypeGraph;
import edu.ustb.sei.mde.graph.typedGraph.ConcurrentBXMerge;
import edu.ustb.sei.mde.graph.typedGraph.ConcurrentBXMergeLatch;
import edu.ustb.sei.mde.graph.typedGraph.ConcurrentTypedGraph;
import edu.ustb.sei.mde.graph.typedGraph.TypedEdge;
import edu.ustb.sei.mde.graph.typedGraph.TypedNode;

public class TestConcurrent_1 {

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
			resultGraph = ConcurrentBXMergeLatch.merge(baseGraph, aGraph, bGraph);
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
				 + "b1:B;"
				 + "a1-a2b->b1;"			//e1
				 
			 	 + "a2:A;" 
				 + "b2:B;" 
				 + "a2-a2b->b2;"
				
			 	 + "a3:A;" 
				 + "b3:B;" 
				 + "a3-a2b->b3;"
				 
			 	 + "a4:A;" 
				 + "b4:B;" 
				 + "a4-a2b->b4;"
				 
			 	 + "a5:A;" 
				 + "b5:B;" 
				 + "a5-a2b->b5;"
				 
			 	 + "a6:A;" 
				 + "b6:B;" 
				 + "a6-a2b->b6;"
				 
			 	 + "a7:A;" 
				 + "b7:B;" 
				 + "a7-a2b->b7;"
				 
			 	 + "a8:A;" 
				 + "b8:B;" 
				 + "a8-a2b->b8;"
				 
			 	 + "a9:A;" 
				 + "b9:B;" 
				 + "a9-a2b->b9;"
				 
			 	 + "a10:A;" 
				 + "b10:B;" 
				 + "a10-a2b->b10;"
				 
			 	 + "a11:A;" 
				 + "b11:B;" 
				 + "a11-a2b->b11;"
				 
			 	 + "a12:A;" 
				 + "b12:B;" 
				 + "a12-a2b->b12;"
				
			 	 + "a13:A;" 
				 + "b13:B;" 
				 + "a13-a2b->b13;"
				 
			 	 + "a14:A;" 
				 + "b14:B;" 
				 + "a14-a2b->b14;"
				 
			 	 + "a15:A;" 
				 + "b15:B;" 
				 + "a15-a2b->b15;"
				 
			 	 + "a16:A;" 
				 + "b16:B;" 
				 + "a16-a2b->b16;"
				 
			 	 + "a17:A;" 
				 + "b17:B;" 
				 + "a17-a2b->b17;"
				 
			 	 + "a18:A;" 
				 + "b18:B;" 
				 + "a18-a2b->b18;"
				 
			 	 + "a19:A;" 
				 + "b19:B;" 
				 + "a19-a2b->b19;"
				 
			 	 + "a20:A;" 
				 + "b20:B;" 
				 + "a20-a2b->b20;" 
				 
			 	 + "a21:A;" 
				 + "b21:B;" 
				 + "a21-a2b->b21;"
				 
			 	 + "a22:A;" 
				 + "b22:B;" 
				 + "a22-a2b->b22;"
				
			 	 + "a23:A;" 
				 + "b23:B;" 
				 + "a23-a2b->b23;"
				 
			 	 + "a24:A;" 
				 + "b24:B;" 
				 + "a24-a2b->b24;"
				 
			 	 + "a25:A;" 
				 + "b25:B;" 
				 + "a25-a2b->b25;"
				 
			 	 + "a26:A;" 
				 + "b26:B;" 
				 + "a26-a2b->b26;"
				 
			 	 + "a27:A;" 
				 + "b27:B;" 
				 + "a27-a2b->b27;"
				 
			 	 + "a28:A;" 
				 + "b28:B;" 
				 + "a28-a2b->b28;"
				 
			 	 + "a29:A;" 
				 + "b29:B;" 
				 + "a29-a2b->b29;"
				 
			 	 + "a30:A;" 
				 + "b30:B;" 
				 + "a30-a2b->b30;" 
				
				+"a1.a2S=\"str1\";"
				+"a1.a2S=\"str2\";"
				+"a1.a2S=\"str3\";"
				
				);	
		
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
					 
					 + "c18:C;"
					 + "d18:D;"
					 + "c18-c2d->d18;"
					 
					 + "c19:C;"
					 + "d19:D;"
					 + "c19-c2d->d19;"
					 
					 + "c20:C;"
					 + "d20:D;"
					 + "c20-c2d->d20;"
					 
					 + "c21:C;"
					 + "d21:D;"
					 + "c21-c2d->d21;"
					 
					 + "c22:C;"
					 + "d22:D;"
					 + "c22-c2d->d22;"
					 
					 + "c23:C;"
					 + "d23:D;"
					 + "c23-c2d->d23;"
					 
					 + "c24:C;"
					 + "d24:D;"
					 + "c24-c2d->d24;"
					 
					 + "c25:C;"
					 + "d25:D;"
					 + "c25-c2d->d25;"
					 
					 + "c26:C;"
					 + "d26:D;"
					 + "c26-c2d->d26;"
					 
					 + "c27:C;"
					 + "d27:D;"
					 + "c27-c2d->d27;"
					 
					 + "c28:C;"
					 + "d28:D;"
					 + "c28-c2d->d28;"
					 
					 + "c29:C;"
					 + "d29:D;"
					 + "c29-c2d->d29;"
					 
					 + "c30:C;"
					 + "d30:D;"
					 + "c30-c2d->d30;"
					 
					 + "c31:C;"
					 + "d31:D;"
					 + "c31-c2d->d31;"
					 
					 + "c32:C;"
					 + "d32:D;"
					 + "c32-c2d->d32;"
					 
					 + "c33:C;"
					 + "d33:D;"
					 + "c33-c2d->d33;"
					 
					 + "c34:C;"
					 + "d34:D;"
					 + "c34-c2d->d34;"
					 
					 + "c35:C;"
					 + "d35:D;"
					 + "c35-c2d->d35;"
					 
					 + "c36:C;"
					 + "d36:D;"
					 + "c36-c2d->d36;"
					 
					 + "c37:C;"
					 + "d37:D;"
					 + "c37-c2d->d37;"
					 
					 + "c38:C;"
					 + "d38:D;"
					 + "c38-c2d->d38;"
					 
					 + "c39:C;"
					 + "d39:D;"
					 + "c39-c2d->d39;"
					 
					 + "c40:C;"
					 + "d40:D;"
					 + "c40-c2d->d40;"
					 
					);
		
		TypedEdge e2 = aGraph.getAllTypedEdges().get(1);
		TypedEdge e3 = aGraph.getAllTypedEdges().get(2);
		TypedEdge e4 = aGraph.getAllTypedEdges().get(3);
		TypedEdge e5 = aGraph.getAllTypedEdges().get(4);
		TypedEdge e6 = aGraph.getAllTypedEdges().get(5);
		
		aGraph.remove(e2);
		aGraph.remove(e3);
		aGraph.remove(e4);
		aGraph.remove(e5);
		aGraph.remove(e6);
		
		System.out.println("aGraph: ");
		print(aGraph);
		
	}
	
	
	private static void build_bGraph() {
		
		bGraph = baseGraph.getCopy();
				
		bGraph.declare( "c1:C;");
		
		TypedNode c1 = bGraph.getAllTypedNodes().get(60);
		bGraph.remove(c1);
		TypedNode a1 = bGraph.getAllTypedNodes().get(0);
		bGraph.replaceWith(a1, c1);
		
		TypedNode b7 = bGraph.getAllTypedNodes().get(13);
		TypedNode b8 = bGraph.getAllTypedNodes().get(15);
		TypedNode b9 = bGraph.getAllTypedNodes().get(17);
		TypedNode b10 = bGraph.getAllTypedNodes().get(19);
		TypedNode b11 = bGraph.getAllTypedNodes().get(21);
		
		bGraph.remove(b7);
		bGraph.remove(b8);
		bGraph.remove(b9);
		bGraph.remove(b10);
		bGraph.remove(b11);
		
		System.out.println("bGraph: ");
		print(bGraph);
		
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
