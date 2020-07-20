package edu.ustb.sei.mde.bxcore.tests;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import edu.ustb.sei.mde.bxcore.exceptions.NothingReturnedException;
import edu.ustb.sei.mde.graph.type.TypeGraph;
import edu.ustb.sei.mde.graph.typedGraph.BXMerge3;
import edu.ustb.sei.mde.graph.typedGraph.TypedEdge;
import edu.ustb.sei.mde.graph.typedGraph.TypedGraph;
import edu.ustb.sei.mde.structure.Tuple2;

/**
 * 新添
 * 
 * @author 10242
 */
public class TestThreeOrder_2 {

	static TypedGraph baseGraph = null;
	static TypedGraph aGraph = null;
	static TypedGraph bGraph = null;
	static TypedGraph resultGraph = null;
	static Set<Tuple2<TypedEdge, TypedEdge>> orders = new HashSet<>();

	public static void main(String[] args) {

		build_baseGraph();
		build_aGraph();
		build_bGraph();

		try {

			resultGraph = BXMerge3.merge_Con(baseGraph, aGraph, bGraph);
			System.out.println("resultGraph: ");
			print(resultGraph);

			HashMap<TypedEdge, TypedEdge> forceOrd = BXMerge3.checkForceOrd(resultGraph, orders);

			System.out.println("###############################序处理##################################");
			List<TypedEdge> merge = BXMerge3.threeOrder(baseGraph, resultGraph, forceOrd, aGraph, bGraph);
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
		baseGraph.declare("a1:A;" + "b1:B;" + "a1-a2b->b1;" // e1
				+ "a1.a2S=\"str1\";" + "a1.a2S=\"str2\";" + "a1.a2S=\"str3\";");

		System.out.println("baseGraph: ");
		print(baseGraph);

	}

	private static void build_aGraph() {

		aGraph = baseGraph.getCopy();

		// e1-e2
		aGraph.declare("c1:C;" + "d1:D;" + "c1-c2d->d1;");

		System.out.println("aGraph: ");
		print(aGraph);

	}

	private static void build_bGraph() {

		bGraph = baseGraph.getCopy();

		// e3-e1
		bGraph.declare("b2:B;" + "c2:C;" + "b2-b2c->c2;");
		TypedEdge typedEdge = bGraph.getAllTypedEdges().get(1);
		bGraph.getAllTypedEdges().remove(1); // 交换序用列表的remove
		bGraph.getAllTypedEdges().add(0, typedEdge);

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
