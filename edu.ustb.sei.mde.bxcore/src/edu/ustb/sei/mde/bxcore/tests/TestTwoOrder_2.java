package edu.ustb.sei.mde.bxcore.tests;

import java.util.List;

import edu.ustb.sei.mde.graph.type.TypeGraph;
import edu.ustb.sei.mde.graph.typedGraph.BXMerge3;
import edu.ustb.sei.mde.graph.typedGraph.TypedEdge;
import edu.ustb.sei.mde.graph.typedGraph.TypedGraph;
import edu.ustb.sei.mde.graph.typedGraph.TypedNode;
/**
 * 添加性合并
 * 替换
 * @author 10242
 */
public class TestTwoOrder_2 {

	static TypedGraph baseGraph = null;
	static TypedGraph aGraph = null;
	static TypedGraph resultGraph = null;
	
	public static void main(String[] args){
		
		build_baseGraph();
		build_aGraph();
		
		TypedGraph resultGraph = BXMerge3.additiveMerge(baseGraph, aGraph);
		System.out.println("resultGraph: ");
		print(resultGraph);
		
		System.out.println("###############################序处理##################################");
		List<TypedEdge> mergeList = BXMerge3.twoOrder(baseGraph, aGraph, resultGraph);
		System.out.println("\n处理完序后，mergeList: " + mergeList);
		
//		// 验证mergeList和resultList中对象一致
//		List<TypedEdge> resultList = resultGraph.getAllTypedEdges();
//		for(int i=0; i<mergeList.size(); i++) {
//			boolean contains = resultList.contains(mergeList.get(i));
//			System.out.println(contains);
//		}
		
		
		
		
		
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
				+"d1:D;"
				+"d2:D;"
				+"a1-a2b->b1;"		//e1-e2-e3
				+"b1-b2c->c1;"
				+"c1-c2d->d1;"
				+"a1.a2S=\"str1\";"
				+"a1.a2S=\"str2\";"
				+"a1.a2S=\"str3\";");	
		
		TypedEdge e1 = baseGraph.getAllTypedEdges().get(0);
		baseGraph.getAllTypedEdges().remove(e1); // 交换序用列表的remove
		baseGraph.getAllTypedEdges().add(e1);
		
		System.out.println("baseGraph: ");
		print(baseGraph);	
			
	}
	
			
	private static void build_aGraph() {
		
		aGraph = baseGraph.getCopy();
		
		aGraph.declare(
					"b3:B;"
				   +"c3:C;"
				   +"b3-b2c->c3;"
				   );
		
		// e4-e1-e3'
		TypedEdge e1 = aGraph.getAllTypedEdges().get(0);
		TypedEdge e3base = baseGraph.getAllTypedEdges().get(2);
		TypedEdge e4 = aGraph.getAllTypedEdges().get(3);
		
		aGraph.getAllTypedEdges().remove(e4);	// 交换序用列表的remove
		aGraph.getAllTypedEdges().add(0, e4);
		
		aGraph.remove(e1);	// 删除用图的remove
		
		TypedNode d2 = aGraph.getAllTypedNodes().get(5);
		TypedEdge e = new TypedEdge();
		e.setType(e3base.getType());
		e.setSource(e3base.getSource());
		e.setTarget(d2);
		aGraph.replaceWith(e3base, e);
		
		System.out.println("aGraph: ");
		print(aGraph);
		
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
