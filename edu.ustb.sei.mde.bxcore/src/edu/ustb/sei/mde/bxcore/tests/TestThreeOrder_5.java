package edu.ustb.sei.mde.bxcore.tests;

import org.hamcrest.core.IsEqual;

import edu.ustb.sei.mde.bxcore.exceptions.NothingReturnedException;
import edu.ustb.sei.mde.graph.type.TypeEdge;
import edu.ustb.sei.mde.graph.type.TypeGraph;
import edu.ustb.sei.mde.graph.typedGraph.BXMerge;
import edu.ustb.sei.mde.graph.typedGraph.TypedEdge;
import edu.ustb.sei.mde.graph.typedGraph.TypedGraph;
/**
 * 测试TypedEdge的序
 * @author 10242
 */
public class TestThreeOrder_5 {

	static TypedGraph baseGraph = null;
	static TypedGraph aGraph = null;
	static TypedGraph bGraph = null;
	static TypedGraph resultGraph = null;
	
	public static void main(String[] args){
		
		build_baseGraph(); 
		build_aGraph();	
		build_bGraph();	
		
		try {
			
			resultGraph = BXMerge.merge(baseGraph, aGraph, bGraph);
			System.out.println("resultGraph: ");
			print(resultGraph);
			
			//处理序关系
			System.out.println("###############################序处理##################################");
			BXMerge.threeOrder(baseGraph, aGraph, bGraph, resultGraph);
			
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
				+"c1:C;"
				+"c2:C;"
				+"d1:D;"
				+"a1-a2b->b1;"		// e1-e2-e3
				+"b2-b2c->c1;"		
				+"c2-c2d->d1;"
				+"a1.a2S=\"str1\";"
				+"a1.a2S=\"str2\";"
				+"a1.a2S=\"str3\";");	

		System.out.println("baseGraph: ");
		print(baseGraph);
		
	}
	
	private static void build_aGraph() {
		
		aGraph = baseGraph.getCopy();
				
		aGraph.declare("b3:B;"
					   +"c3:C;"
					   +"b3-b2c->c3;");
		
		//e1-e2-e4
		aGraph.remove(aGraph.getAllTypedEdges().get(2));
		
		System.out.println("aGraph: ");
		print(aGraph);
			
	}
	
	private static void build_bGraph() {
		
		bGraph = baseGraph.getCopy();
		
		bGraph.declare("c4:C;"
				       +"d2:D;"
				       +"c4-c2d->d2;");

		//e5-e2-e1-e3
		TypedEdge e5 = bGraph.getAllTypedEdges().get(3);
		bGraph.getAllTypedEdges().remove(e5);
		TypedEdge e1 = bGraph.getAllTypedEdges().get(0);
		bGraph.getAllTypedEdges().remove(e1);
		bGraph.getAllTypedEdges().add(1, e1);
		bGraph.getAllTypedEdges().add(0, e5);
		
		System.out.println("bGraph: ");
		print(bGraph);
		
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
