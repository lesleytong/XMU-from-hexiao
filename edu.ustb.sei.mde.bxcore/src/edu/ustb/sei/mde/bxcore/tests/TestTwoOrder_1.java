package edu.ustb.sei.mde.bxcore.tests;

import java.util.ArrayList;

import edu.ustb.sei.mde.graph.type.TypeGraph;
import edu.ustb.sei.mde.graph.typedGraph.BXMerge;
import edu.ustb.sei.mde.graph.typedGraph.TypedEdge;
import edu.ustb.sei.mde.graph.typedGraph.TypedGraph;
import edu.ustb.sei.mde.graph.typedGraph.TypedNode;
/**
 * 添加性合并
 * 测试TypedEdge的序
 * @author 10242
 */
public class TestTwoOrder_1 {

	static TypedGraph baseGraph = null;
	static TypedGraph aGraph = null;
	static TypedGraph resultGraph = null;
	
	public static void main(String[] args){
		
		build_baseGraph();
		build_aGraph();
		
		TypedGraph resultGraph = BXMerge.additiveMerge(baseGraph, aGraph);
		
//		BXMerge.twoOrder_origin(baseGraph, aGraph, resultGraph);
		ArrayList<TypedEdge> merge = BXMerge.twoOrder(baseGraph.getAllTypedEdges(), aGraph.getAllTypedEdges(), resultGraph.getAllTypedEdges());
		System.out.println("\n处理完序后，merge: " + merge);
		
	}
	

	private static void build_baseGraph() {
		
		TypeGraph typeGraph = new TypeGraph();
		// add type nodes
		typeGraph.declare("A");
		typeGraph.declare("B");
		typeGraph.declare("C");
		typeGraph.declare("D");
		// add data type nodes
		typeGraph.declare("String:java.lang.String");
		// add type edges
		typeGraph.declare("a2b:A->B*");
		typeGraph.declare("b2c:B->C");
		typeGraph.declare("c2d:C->D");
		// add property edges
		typeGraph.declare("a2S:A->String#");
		
		baseGraph = new TypedGraph(typeGraph);
		baseGraph.declare(	
				"a1:A;"
				+"b1:B;"
				+"b2:B;"
				+"b3:B;"
				+"c1:C;"
				+"c2:C;"
				+"d1:D;"
				+"a1-a2b->b1;"		//e1-e2-e3-e4
				+"a1-a2b->b2;"
				+"b3-b2c->c1;"
				+"c2-c2d->d1;"
				+"a1.a2S=\"str1\";"
				+"a1.a2S=\"str2\";"
				+"a1.a2S=\"str3\";");	
		
		System.out.println("baseGraph: ");
		print(baseGraph);	
		
	}
	
			
	private static void build_aGraph() {
		
		aGraph = baseGraph.getCopy();
		
		System.out.println("!!!!!!!!!!!!!c2: " + aGraph.getAllTypedNodes().get(5));
		TypedNode c2 = aGraph.getAllTypedNodes().get(5);
		
		aGraph.declare(
				    "c3:C;"		
				   +"d2:D;"
				   +"c3-c2d->d2;"
				   
				   +"c4:C;"		
				   +"d3:D;"
				   +"c4-c2d->d3;"
				   );
		
		// e3-e5-e1-e6
		TypedEdge e5 = aGraph.getAllTypedEdges().get(4);
		TypedEdge e6 = aGraph.getAllTypedEdges().get(5);
		aGraph.getAllTypedEdges().remove(e5);
		aGraph.remove(aGraph.getAllTypedEdges().get(3));
		aGraph.remove(aGraph.getAllTypedEdges().get(1));
		TypedEdge e3 = aGraph.getAllTypedEdges().get(1);
		aGraph.getAllTypedEdges().remove(e3);
		aGraph.getAllTypedEdges().add(0, e3);
		aGraph.getAllTypedEdges().add(1, e5);
				
		System.out.println("aGraph: ");
		print(aGraph);
		
	}
		
	private static void print(TypedGraph typedGraph) {
		
		System.out.println("TypedNodes: " + typedGraph.getAllTypedNodes().toString());
		System.out.println("ValueNodes: " + typedGraph.getAllValueNodes().toString());
		System.out.println("TypedEdges: " + typedGraph.getAllTypedEdges().toString());
		System.out.println("ValueEdges: " + typedGraph.getAllValueEdges().toString());
		System.out.println("*********************************************************************");
		System.out.println();
	}

}
