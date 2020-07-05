package edu.ustb.sei.mde.bxcore.tests;

import java.util.ArrayList;
import java.util.List;

import edu.ustb.sei.mde.bxcore.exceptions.NothingReturnedException;
import edu.ustb.sei.mde.graph.type.TypeGraph;
import edu.ustb.sei.mde.graph.typedGraph.BXMerge;
import edu.ustb.sei.mde.graph.typedGraph.TypedEdge;
import edu.ustb.sei.mde.graph.typedGraph.TypedGraph;
/**
 * 删除、交换序
 * @author 10242
 */
public class TestThreeOrder_5 {

	static TypedGraph baseGraph = null;
	static TypedGraph aGraph = null;
	static TypedGraph bGraph = null;
	static TypedGraph cGraph = null;
	static TypedGraph resultGraph = null;
	
	public static void main(String[] args){
		
		build_baseGraph();
		build_aGraph();
		build_bGraph();
		build_cGraph();
		
		try {
			resultGraph = BXMerge.merge(baseGraph, aGraph, bGraph, cGraph);
			System.out.println("resultGraph: ");
			print(resultGraph);
			
			//保证序关系
			System.out.println("###############################序处理##################################");			
			List<TypedEdge> merge = BXMerge.threeOrder3(baseGraph, resultGraph, aGraph, bGraph, cGraph);
			System.out.println("\n处理完序后，merge: " + merge);
			
			
		} catch (NothingReturnedException e) {
			e.printStackTrace();
		}
				
		
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
				+"c3:C;"
				+"d1:D;"
				+"d2:D;"
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
		
		//e4-e2-e3
		aGraph.remove(aGraph.getAllTypedEdges().get(0));	//删除用图的remove
		TypedEdge typedEdge = aGraph.getAllTypedEdges().get(2);
		aGraph.getAllTypedEdges().remove(2);	//交换序用列表的remove
		aGraph.getAllTypedEdges().add(0, typedEdge);	
		
		System.out.println("aGraph: ");
		print(aGraph);
		

	}
	
	private static void build_bGraph() {
		
		bGraph = baseGraph.getCopy();
		
		//e1-e4-e2-e3
		TypedEdge e4 = bGraph.getAllTypedEdges().get(3);
		bGraph.getAllTypedEdges().remove(e4);
		bGraph.getAllTypedEdges().add(1, e4);

		
		System.out.println("bGraph: ");
		print(bGraph);
	}
	
	private static void build_cGraph() {
		
		cGraph = baseGraph.getCopy();
		
		//e3-e1-e4-e2
		TypedEdge e3 = cGraph.getAllTypedEdges().get(2);
		TypedEdge e4 = cGraph.getAllTypedEdges().get(3);
		cGraph.getAllTypedEdges().remove(e3);
		cGraph.getAllTypedEdges().remove(e4);
		cGraph.getAllTypedEdges().add(0, e3);
		cGraph.getAllTypedEdges().add(2, e4);
	
		System.out.println("cGraph: ");
		print(cGraph);
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
