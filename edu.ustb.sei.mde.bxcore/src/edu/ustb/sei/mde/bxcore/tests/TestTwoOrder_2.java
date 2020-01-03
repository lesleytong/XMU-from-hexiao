package edu.ustb.sei.mde.bxcore.tests;

import edu.ustb.sei.mde.bxcore.exceptions.NothingReturnedException;
import edu.ustb.sei.mde.graph.type.TypeGraph;
import edu.ustb.sei.mde.graph.typedGraph.BXMerge;
import edu.ustb.sei.mde.graph.typedGraph.TypedEdge;
import edu.ustb.sei.mde.graph.typedGraph.TypedGraph;
/**
 * 二向合并
 * 测试TypedEdge的序
 * @author 10242
 */
public class TestTwoOrder_2 {

	static TypedGraph baseGraph = null;
	static TypedGraph aGraph = null;
	static TypedGraph resultGraph = null;
	
	public static void main(String[] args){
		
		build_baseGraph();
		build_aGraph();
		
		TypedGraph resultGraph = BXMerge.additiveMerge(baseGraph, aGraph);
		
		BXMerge.twoOrder(baseGraph, aGraph, resultGraph);
		
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
				+"c1:C;"
				+"d1:D;"
				+"a1-a2b->b1;"		//e1-e2-e3
				+"a1-a2b->b2;"
				+"c1-c2d->d1;"
				+"a1.a2S=\"str1\";"
				+"a1.a2S=\"str2\";"
				+"a1.a2S=\"str3\";");	
		
		System.out.println("baseGraph: ");
		print(baseGraph);	
		
	}
	
			
	private static void build_aGraph() {
		
		aGraph = baseGraph.getCopy();
		
		aGraph.declare(
					"b3:B;"
				   +"c2:C;"
				   +"c3:C;"		
				   +"d2:D;"
				   +"b3-b2c->c3;"
				   +"c2-c2d->d2;"
				   );
		
		TypedEdge typedEdge = aGraph.getAllTypedEdges().get(4);
		aGraph.remove(typedEdge); 	//替换也用图的remove，之后的repalceWith会添加indexToObject
		aGraph.replaceWith(aGraph.getAllTypedEdges().get(2), typedEdge);
		TypedEdge e4 = aGraph.getAllTypedEdges().get(3);
		aGraph.getAllTypedEdges().remove(e4);	//交换序用列表的remove
		aGraph.getAllTypedEdges().add(0, e4); 	//e4-e1-e2-e3'
		TypedEdge e3 = aGraph.getAllTypedEdges().get(3);
		aGraph.getAllTypedEdges().remove(e3);	//交换序用列表的remove
		aGraph.getAllTypedEdges().add(2, e3);	//e4-e1-e3'-e2
		
		aGraph.remove(aGraph.getAllTypedEdges().get(3));	//e4-e1-e3'
		
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
