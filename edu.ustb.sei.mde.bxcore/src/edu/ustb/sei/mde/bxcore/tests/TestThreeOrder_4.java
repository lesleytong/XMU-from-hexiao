package edu.ustb.sei.mde.bxcore.tests;

import java.util.HashMap;

import edu.ustb.sei.mde.bxcore.exceptions.NothingReturnedException;
import edu.ustb.sei.mde.graph.type.TypeGraph;
import edu.ustb.sei.mde.graph.typedGraph.BXMerge3;
import edu.ustb.sei.mde.graph.typedGraph.TypedEdge;
import edu.ustb.sei.mde.graph.typedGraph.TypedGraph;
/**
 *  base: ABCDEF
 *     a: ACDEFBG
 *     b: ABDECHF
 * merge(threeOrder): ADECHFBG
 * 但按照拓扑排序的话，此例存在环（B, H, F）
 * @author 10242
 *
 */
public class TestThreeOrder_4 {

	static TypedGraph baseGraph = null;
	static TypedGraph aGraph = null;
	static TypedGraph bGraph = null;
	static TypedGraph resultGraph = null;
	static HashMap<TypedEdge, TypedEdge> forceOrd = new HashMap<>();

	public static void main(String[] args) {

		build_baseGraph();
		build_aGraph();
		build_bGraph();

		try {
			resultGraph = BXMerge3.mergeOrigin(baseGraph, aGraph, bGraph);
			System.out.println("resultGraph: ");
			print(resultGraph);
			
//			BXMerge3.threeOrder(baseGraph, resultGraph, forceOrd, aGraph, bGraph);
//			print(resultGraph);
			
			BXMerge3.topoOrder(baseGraph, resultGraph, forceOrd, "",aGraph, bGraph);
									
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
		typeGraph.declare("E");
		typeGraph.declare("F");
		typeGraph.declare("G");
		typeGraph.declare("H");
		typeGraph.declare("I");
		// add type edges
		typeGraph.declare("a2b:A->B"); 
		typeGraph.declare("b2c:B->C");
		typeGraph.declare("c2d:C->D");
		typeGraph.declare("d2e:D->E");
		typeGraph.declare("e2f:E->F");
		typeGraph.declare("f2g:F->G");
		typeGraph.declare("g2h:G->H");
		typeGraph.declare("h2i:H->I");

		baseGraph = new TypedGraph(typeGraph);
		baseGraph.declare(
				"a:A;" + "b:B;" + "c:C;" + "d:D;" + "e:E;" + "f:F;" + "g:G;"
				+ "a-a2b->b;" + "b-b2c->c;" + "c-c2d->d;" + "d-d2e->e;" + "e-e2f->f;" + "f-f2g->g;");

		System.out.println("baseGraph: ");
		print(baseGraph);

	}

	private static void build_aGraph() {

		aGraph = baseGraph.getCopy();
		
		aGraph.declare(
				"g:G;" + "h:H;"
				+ "g-g2h->h;");
		
		TypedEdge eB = aGraph.getAllTypedEdges().get(1);
		aGraph.getAllTypedEdges().remove(1);
		aGraph.getAllTypedEdges().add(5, eB);
		
		System.out.println("aGraph: ");
		print(aGraph);
		
	}

	private static void build_bGraph() {

		bGraph = baseGraph.getCopy();
		
		bGraph.declare(
				"h:H;" + "i:I;"
				+ "h-h2i->i;");
		
		TypedEdge eC = bGraph.getAllTypedEdges().get(2);
		bGraph.getAllTypedEdges().remove(2);
		bGraph.getAllTypedEdges().add(4, eC);
		
		TypedEdge eH = bGraph.getAllTypedEdges().get(6);
		bGraph.getAllTypedEdges().remove(6);
		bGraph.getAllTypedEdges().add(5, eH);
		
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