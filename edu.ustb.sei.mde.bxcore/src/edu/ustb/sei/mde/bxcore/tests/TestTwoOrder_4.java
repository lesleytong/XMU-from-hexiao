package edu.ustb.sei.mde.bxcore.tests;

import edu.ustb.sei.mde.bxcore.exceptions.NothingReturnedException;
import edu.ustb.sei.mde.graph.type.TypeEdge;
import edu.ustb.sei.mde.graph.type.TypeGraph;
import edu.ustb.sei.mde.graph.typedGraph.BXMerge;
import edu.ustb.sei.mde.graph.typedGraph.TypedEdge;
import edu.ustb.sei.mde.graph.typedGraph.TypedGraph;
import edu.ustb.sei.mde.graph.typedGraph.TypedNode;
/**
 * 二向合并
 * 测试TypedEdge的序
 * @author 10242
 */
public class TestTwoOrder_4 {

	static TypedGraph baseGraph = null;
	static TypedGraph aGraph = null;
	static TypedGraph resultGraph = null;
	
	public static void main(String[] args){
		
		build_baseGraph();
		build_aGraph();
		
		//发现：有循环包含冲突，并没有抛出异常。---待优化
		TypedGraph resultGraph = BXMerge.additiveMerge(baseGraph, aGraph);
		
		BXMerge.twoOrder(baseGraph, aGraph, resultGraph);
		
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
		typeGraph.declare("d2c:D->C");
		// add property edges
		typeGraph.declare("a2S:A->String#");
		
		baseGraph = new TypedGraph(typeGraph);
		baseGraph.declare(	
				"a1:A;"
				+"b1:B;"
				+"b2:B;"
				+"c1:C;"
				+"d1:D;"
				+"a1-a2b->b1;"		//e1-e2-e3
				+"a1-a2b->b2;"
				+"c1-c2d->d1;"
				+"a1.a2S=\"str1\";"
				+"a1.a2S=\"str2\";"
				+"a1.a2S=\"str3\";");	
		
		
		TypeEdge type = baseGraph.getAllTypedEdges().get(2).getType();
		System.out.println("isMany?" + type.isMany());	//true
		System.out.println("isContainment?" + type.isContainment());	//false
		System.out.println("isUnique?" + type.isUnique());	//true
			
		type.setContainment(true);
		
		//返回true
		System.out.println(baseGraph.getAllTypedEdges().get(2).getType().isContainment());
		
		System.out.println("baseGraph: ");
		print(baseGraph);	
		
		
		
	}
	
			
	private static void build_aGraph() {
		
		aGraph = baseGraph.getCopy();
		
		aGraph.declare(
				"d2:D;"
			   +"c2:C;"		
			   +"d2-d2c->c2;"
			   );
		
		TypeEdge type = aGraph.getAllTypedEdges().get(3).getType();	//d2c的type
		type.setContainment(true);
		
		TypedNode d1 = aGraph.getAllTypedNodes().get(4);
		TypedNode c1 = aGraph.getAllTypedNodes().get(3);
		
		TypedEdge e4 = new TypedEdge();
		e4.setType(type);	
		e4.setSource(d1);
		e4.setTarget(c1);
		aGraph.addTypedEdge(e4);	//此时：e1-e2-e3-e-e4
		
		//返回true
		System.out.println(aGraph.getAllTypedEdges().get(4).getType().isContainment());
		
		//e3-e4-e2
		aGraph.remove(aGraph.getAllTypedEdges().get(3));
		aGraph.remove(aGraph.getAllTypedEdges().get(0));
		TypedEdge e2 = aGraph.getAllTypedEdges().get(0);
		aGraph.getAllTypedEdges().remove(e2);
		aGraph.getAllTypedEdges().add(e2);
		
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
