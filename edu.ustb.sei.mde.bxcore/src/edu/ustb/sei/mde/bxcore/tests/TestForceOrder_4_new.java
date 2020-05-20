package edu.ustb.sei.mde.bxcore.tests;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import edu.ustb.sei.mde.bxcore.exceptions.NothingReturnedException;
import edu.ustb.sei.mde.bxcore.structures.Index;
import edu.ustb.sei.mde.graph.type.TypeGraph;
import edu.ustb.sei.mde.graph.typedGraph.BXMerge;
import edu.ustb.sei.mde.graph.typedGraph.TypedEdge;
import edu.ustb.sei.mde.graph.typedGraph.TypedGraph;
import edu.ustb.sei.mde.structure.Tuple2;

/**
 * ����<x, y>&<x, z>��ͻ �Լ�<y, x>&<z, x>��ͻ
 * 
 * @author 10242
 */
public class TestForceOrder_4_new {

	static TypedGraph baseGraph = null;
	static TypedGraph aGraph = null;
	static TypedGraph resultGraph = null;
	static Set<Tuple2<TypedEdge, TypedEdge>> orders = new HashSet<>();

	public static void main(String[] args){

		build_baseGraph();
		build_aGraph();

		// �����Ժϲ�
		resultGraph = BXMerge.additiveMerge(baseGraph, aGraph);
		System.out.println("resultGraph: ");
		print(resultGraph);

		// ��֤���ϵ
		System.out.println("###############################����##################################");
		List<TypedEdge> mergeList = BXMerge.twoOrder2(baseGraph, aGraph, resultGraph);
		System.out.println("mergeList: " + mergeList);

		// ǿ�����ϵ
		System.out.println("###############################ǿ����##################################");
		if (orders.size() != 0) {
			try {
				BXMerge.forceOrder2(mergeList, orders, resultGraph);
				System.out.println("���º��mergeList: ");
			} catch (NothingReturnedException e) {
				e.printStackTrace();
			}
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
		baseGraph.declare("a1:A;" + "b1:B;" + "b2:B;" + "b3:B;" + "c1:C;" + "a1-a2b->b1;" // e1-e2-e3
				+ "a1-a2b->b2;" + "b3-b2c->c1;" + "a1.a2S=\"str1\";" + "a1.a2S=\"str2\";" + "a1.a2S=\"str3\";");

		System.out.println("baseGraph: ");
		print(baseGraph);

	}

	private static void build_aGraph() {

		aGraph = baseGraph.getCopy();

		// e1-e4-e2-e3
		aGraph.declare("c2:C;" + "d1:D;" + "c2-c2d->d1;");
		TypedEdge e4 = aGraph.getAllTypedEdges().get(3);
		aGraph.getAllTypedEdges().remove(e4);
		aGraph.getAllTypedEdges().add(1, e4);

		System.out.println("aGraph: ");
		print(aGraph);

		// <e1, e4>
		Tuple2<TypedEdge, TypedEdge> order1 = Tuple2.make(aGraph.getAllTypedEdges().get(0),
				aGraph.getAllTypedEdges().get(1));
		orders.add(order1);

		// <e1, e2>
		Tuple2<TypedEdge, TypedEdge> order2 = Tuple2.make(aGraph.getAllTypedEdges().get(0),
				aGraph.getAllTypedEdges().get(2));
		orders.add(order2);

//		// <e4, e2>
//		Tuple2<Index, Index> order1 = Tuple2.make(aGraph.getAllTypedEdges().get(1).getIndex(), 
//				aGraph.getAllTypedEdges().get(2).getIndex());
//		orders.add(order1);
//		
//		// <e3, e2>
//		Tuple2<Index, Index> order2 = Tuple2.make(aGraph.getAllTypedEdges().get(3).getIndex(), 
//				aGraph.getAllTypedEdges().get(2).getIndex());
//		orders.add(order2);

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