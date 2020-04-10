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
 * 测试重复添加的强制序。
 * 集合判断是相同元素的方法是：Tuple2<a, b>==Tuple2<c, d>当且仅当a==b&&c==d。
 * 当然我的算法里是Tuple<Index, Index>，所以最后判断还是看Index的hashCode()和equals()方法。
 * 因此测试一下边被替换后，能否重复添加。---不能
 * @author 10242
 */
public class TestForceOrder_2 {

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
			resultGraph = BXMerge.merge(baseGraph, aGraph, bGraph);
			System.out.println("resultGraph: ");
			print(resultGraph);
			
			//保证序关系
			System.out.println("###############################序处理##################################");
			List<TypedEdge> merge = null;
			merge = BXMerge.threeOrder_origin(baseGraph, aGraph, bGraph, resultGraph);
					
			// 强制序关系
			if(orders.size() != 0) {
				BXMerge.forceOrder(merge, orders);
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
		
		// e1-e3-e2
		aGraph.declare("b3:B;" + "c1:C;" + "b3-b2c->c1;");
		TypedEdge e3 = aGraph.getAllTypedEdges().get(2);
		aGraph.getAllTypedEdges().remove(e3);
		aGraph.getAllTypedEdges().add(1, e3);
	
		// 添加<e2, e1>
		System.out.println(aGraph.getAllTypedEdges().get(2) + " " + aGraph.getAllTypedEdges().get(0));
		Tuple2<Index, Index> order1 = Tuple2.make(aGraph.getAllTypedEdges().get(2).getIndex(), 
				aGraph.getAllTypedEdges().get(0).getIndex());
		
		orders.add(order1);
		
		System.out.println("aGraph: ");
		print(aGraph);
				
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
		
		//e4-e2'-e1
		bGraph.declare("a2:A;" + "b4:B;" + "a2-a2b->b4;");
		TypedEdge e2 = bGraph.getAllTypedEdges().get(1);
		TypedEdge e = bGraph.getAllTypedEdges().get(3);
		bGraph.remove(e);
		bGraph.replaceWith(e2, e);
		
		// 添加<e2', e1>
		System.out.println(bGraph.getAllTypedEdges().get(1) + " " + bGraph.getAllTypedEdges().get(2));
		Tuple2<Index, Index> order2 = Tuple2.make(bGraph.getAllTypedEdges().get(1).getIndex(), 
				bGraph.getAllTypedEdges().get(2).getIndex());
		
		orders.add(order2);
		System.out.println(orders.size());	//输出是1！
											//因为e2'内部索引集包含了e2，Set<Index, Index>判断是相同的元素，不能重复添加！
		
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
