package edu.ustb.sei.mde.bxcore.tests;

import edu.ustb.sei.mde.bxcore.exceptions.NothingReturnedException;
import edu.ustb.sei.mde.graph.type.TypeGraph;
import edu.ustb.sei.mde.graph.typedGraph.BXMerge;
import edu.ustb.sei.mde.graph.typedGraph.TypedEdge;
import edu.ustb.sei.mde.graph.typedGraph.TypedGraph;
import edu.ustb.sei.mde.graph.typedGraph.TypedNode;
/**
 * 非isMany
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
			
			resultGraph = BXMerge.merge(baseGraph, aGraph, bGraph);
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
				 "b1:B;"
				+"c1:C;"
				+"b1-b2c->c1;"			//e0，为了用它的type
				);		
	}
				
	private static void build_aGraph() {
		
		aGraph = baseGraph.getCopy();
		
		TypedEdge e0 = aGraph.getAllTypedEdges().get(0);
		aGraph.remove(e0);
		
		TypedEdge e1 = new TypedEdge();
		e1.setType(e0.getType());
		e1.setSource(e0.getSource());
		e1.setTarget(e0.getTarget());
		aGraph.addTypedEdge(e1); 	// b1-c1
				
		System.out.println("aGraph: ");
		print(aGraph);
		
	}
	
	private static void build_bGraph() {
		
		bGraph = baseGraph.getCopy();
		
		bGraph.declare(	
				"c2:C;");
		
		TypedEdge e0 = bGraph.getAllTypedEdges().get(0);
		bGraph.remove(e0);
		
		TypedNode c2 = bGraph.getAllTypedNodes().get(2);
		
		TypedEdge e2 = new TypedEdge();
		e2.setType(e0.getType());
		e2.setSource(e0.getSource());
		e2.setTarget(c2);
		bGraph.addTypedEdge(e2); 	// b1-c2
		
		System.out.println("bGraph: ");
		print(bGraph);
		
		baseGraph.remove(e0);	// baseGraph也要删，e0在三图中对象引用一致
		System.out.println("baseGraph: ");
		print(baseGraph);
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
