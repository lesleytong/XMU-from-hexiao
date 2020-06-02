package edu.ustb.sei.mde.bxcore.tests;

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
 * 序关系保证后，
 * 强制序实现
 * @author 10242
 */
public class TestForceOrder_1 {

	static TypedGraph baseGraph = null;
	static TypedGraph aGraph = null;
	static TypedGraph bGraph = null;
	static TypedGraph resultGraph = null;
	static Set<Tuple2<Index, Index>> orders = new HashSet<>();
	
	public static void main(String[] args){
		
		build_baseGraph();
		build_aGraph();
		build_bGraph();
		
		try {
			// 三向合并
			resultGraph = BXMerge.merge(baseGraph, aGraph, bGraph);
			System.out.println("resultGraph: ");
			print(resultGraph);
			
			//保证序关系
			System.out.println("###############################序处理##################################");
//			List<TypedEdge> merge  = BXMerge.threeOrder(baseGraph.getAllTypedEdges(), aGraph.getAllTypedEdges(), 
//					bGraph.getAllTypedEdges(), resultGraph.getAllTypedEdges());
//			System.out.println("merge: " + merge);
			
			List<TypedEdge> merge = BXMerge.threeOrder2(baseGraph, resultGraph, aGraph, bGraph);
			System.out.println("merge: " + merge);
			
			// 强制序关系
			System.out.println("###############################强制序##################################");
			if(orders.size() != 0) {
				BXMerge.forceOrder(merge, orders);
				System.out.println("mergeUpdate: " + merge);
			}
			
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
				+"d1:D;"
				+"a1-a2b->b1;"		//e1-e2
				+"a1-a2b->b2;"
				+"a1.a2S=\"str1\";"
				+"a1.a2S=\"str2\";"
				+"a1.a2S=\"str3\";");	
		
		System.out.println("baseGraph: ");
		print(baseGraph);	
		
	}
	
			
	private static void build_aGraph() {
		
		aGraph = baseGraph.getCopy();
		
		//e1-e3-e2
		aGraph.declare("b3:B;" + "c1:C;" + "b3-b2c->c1;");
		TypedEdge e3 = aGraph.getAllTypedEdges().get(2);
		aGraph.getAllTypedEdges().remove(e3);
		aGraph.getAllTypedEdges().add(1, e3);
	
		System.out.println("aGraph: ");
		print(aGraph);
		
		// 添加<e1, e3>
		Tuple2<Index, Index> order1 = Tuple2.make(aGraph.getAllTypedEdges().get(0).getIndex(), 
				aGraph.getAllTypedEdges().get(1).getIndex());
		
		orders.add(order1);
		
		// 添加<e3, e2>
		Tuple2<Index, Index> order2 = Tuple2.make(aGraph.getAllTypedEdges().get(1).getIndex(), 
				aGraph.getAllTypedEdges().get(2).getIndex());
		
		orders.add(order2);
		
	}
	
	private static void build_bGraph() {
		
		bGraph = baseGraph.getCopy();
		
		//e4-e2-e1
		bGraph.declare("c2:C;" + "d1:D;" + "c2-c2d->d1;");
		TypedEdge e4 = bGraph.getAllTypedEdges().get(2);
		TypedEdge e1 = bGraph.getAllTypedEdges().get(0);
		bGraph.getAllTypedEdges().remove(e4);
		bGraph.getAllTypedEdges().remove(e1);
		bGraph.getAllTypedEdges().add(0, e4);
		bGraph.getAllTypedEdges().add(e1);
		
		// 添加<e2, e4>
		Tuple2<Index, Index> order1 = Tuple2.make(bGraph.getAllTypedEdges().get(1).getIndex(), 
				bGraph.getAllTypedEdges().get(0).getIndex());
		
		orders.add(order1);
		
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
