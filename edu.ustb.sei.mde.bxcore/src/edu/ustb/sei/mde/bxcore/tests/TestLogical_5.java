package edu.ustb.sei.mde.bxcore.tests;

import edu.ustb.sei.mde.bxcore.exceptions.NothingReturnedException;
import edu.ustb.sei.mde.graph.type.TypeEdge;
import edu.ustb.sei.mde.graph.type.TypeGraph;
import edu.ustb.sei.mde.graph.typedGraph.BXMerge;
import edu.ustb.sei.mde.graph.typedGraph.BXMerge3;
import edu.ustb.sei.mde.graph.typedGraph.TypedEdge;
import edu.ustb.sei.mde.graph.typedGraph.TypedGraph;
import edu.ustb.sei.mde.graph.typedGraph.TypedNode;
/**
 * A-B*是isMany、isUnique
 * a分支和b分支添加“同样的”边
 * @author 10242
 *
 */
public class TestLogical_5 {

	static TypedGraph baseGraph = null;
	static TypedGraph aGraph = null;
	static TypedGraph bGraph = null;
	static TypedGraph resultGraph = null;
	
	public static void main(String[] args){
		
		build_baseGraph();
		build_aGraph();
		build_bGraph();
				
		try {
			
			resultGraph = BXMerge3.mergeSerial(baseGraph, aGraph, bGraph);
			System.out.println("resultGraph: ");
			print(resultGraph);
						
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
				+"a1.a2S=\"str1\";"
				+"a1.a2S=\"str2\";"
				+"a1.a2S=\"str3\";");	
		
	}
	
			
	private static void build_aGraph() {
		
		aGraph = baseGraph.getCopy();
		
		TypeEdge typeEdge = aGraph.getTypeGraph().getAllTypeEdges().get(0);
		System.out.println(typeEdge);
		
		TypedNode a1 = aGraph.getAllTypedNodes().get(0);
		TypedNode b1 = aGraph.getAllTypedNodes().get(1);
		
		TypedEdge e1 = new TypedEdge();
		e1.setType(typeEdge);
		e1.setSource(a1);
		e1.setTarget(b1);
				
		aGraph.addTypedEdge(e1);
		
		System.out.println(e1.getType().isMany());
		System.out.println(e1.getType().isUnique());
		
		System.out.println("aGraph: ");
		print(aGraph);
		
	}
	
	private static void build_bGraph() {
		
		bGraph = baseGraph.getCopy();
		
		bGraph.declare("b2:B;");
		
		TypeEdge typeEdge = bGraph.getTypeGraph().getAllTypeEdges().get(0);
		System.out.println(typeEdge);
		
		TypedNode a1 = bGraph.getAllTypedNodes().get(0);
		TypedNode b2 = bGraph.getAllTypedNodes().get(2);
		
		TypedEdge e1 = new TypedEdge();
		e1.setType(typeEdge);
		e1.setSource(a1);
		e1.setTarget(b2);
		
		bGraph.addTypedEdge(e1);
		
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
