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
 * 序合并后再执行强制序
 * 
 * @author 10242
 */
public class TestForceOrder_4 {

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
			
			// 三向合并
			resultGraph = BXMerge3.merge_Con(baseGraph, aGraph, bGraph);
			System.out.println("\n调用图合并算法后得到的resultGraph: ");
			print(resultGraph);

			HashMap<TypedEdge, TypedEdge> forceOrd = BXMerge3.checkForceOrd(resultGraph, orders);

			List<TypedEdge> mergeList = BXMerge3.threeOrder(baseGraph, resultGraph, forceOrd, aGraph, bGraph);
			System.out.println("排序后: ");
			System.out.println(mergeList);

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
		baseGraph.declare("a1:A;" + "b1:B;" + "c1:C;" + "c2:C;" + "d1:D;" + "d2:D;" + "a1-a2b->b1;" // e1-e2-e3-e4
				+ "b1-b2c->c1;"  + "c1-c2d->d1;" + "c2-c2d->d2;" + "a1.a2S=\"str1\";" + "a1.a2S=\"str2\";" + "a1.a2S=\"str3\";");

		System.out.println("baseGraph: ");
		print(baseGraph);

	}

	private static void build_aGraph() {

		aGraph = baseGraph.getCopy();
		
		// e1-e2-e3-e4
		System.out.println("aGraph: ");
		print(aGraph);

		// 添加<e1, e2>
		Tuple2<TypedEdge, TypedEdge> order1 = Tuple2.make(aGraph.getAllTypedEdges().get(0),
				aGraph.getAllTypedEdges().get(1));

		orders.add(order1);
		
		// 添加<e2, e3>
		Tuple2<TypedEdge, TypedEdge> order2 = Tuple2.make(aGraph.getAllTypedEdges().get(1),
				aGraph.getAllTypedEdges().get(2));

		orders.add(order2);
		
		// 添加<e3, e4>
		Tuple2<TypedEdge, TypedEdge> order3 = Tuple2.make(aGraph.getAllTypedEdges().get(2),
				aGraph.getAllTypedEdges().get(3));

		orders.add(order3);

	}

	private static void build_bGraph() {

		bGraph = baseGraph.getCopy();

		// e1-e2-e3-e4
		System.out.println("bGraph: ");
		print(bGraph);
		
		// 添加<e4, e1>
		Tuple2<TypedEdge, TypedEdge> order4 = Tuple2.make(bGraph.getAllTypedEdges().get(3),
				bGraph.getAllTypedEdges().get(0));

		orders.add(order4);

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
