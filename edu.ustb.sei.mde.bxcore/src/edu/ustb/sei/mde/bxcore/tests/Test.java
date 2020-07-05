package edu.ustb.sei.mde.bxcore.tests;

import java.util.ArrayList;
import java.util.List;

import edu.ustb.sei.mde.bxcore.exceptions.NothingReturnedException;
import edu.ustb.sei.mde.graph.type.TypeGraph;
import edu.ustb.sei.mde.graph.typedGraph.BXMerge;
import edu.ustb.sei.mde.graph.typedGraph.BXMerge_Con;
import edu.ustb.sei.mde.graph.typedGraph.BXMerge_NewVersion;
import edu.ustb.sei.mde.graph.typedGraph.TypedEdge;
import edu.ustb.sei.mde.graph.typedGraph.TypedGraph;
import edu.ustb.sei.mde.graph.typedGraph.TypedNode;
/**
 * @author 10242
 */
public class Test {

	static TypedGraph baseGraph = null;
	static TypedGraph aGraph = null;
	static TypedGraph bGraph = null;
	static TypedGraph cGraph = null;
	static TypedGraph resultGraph = null;
	
	public static void main(String[] args){
		
		build_baseGraph();
		build_aGraph();
		build_bGraph();
		build_cGraph();
		
		try {
			resultGraph = BXMerge.merge(baseGraph, aGraph, bGraph, cGraph);
			System.out.println("\n执行图合并算法后的合并图G': ");
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
		typeGraph.declare("d2S:D->String#");
		
		baseGraph = new TypedGraph(typeGraph);
		baseGraph.declare(	
				"a1:A;"
				+"b1:B;"
				+"b2:B;"
				+"c1:C;"
				+"c2:C;"
				+"d1:D;"
				+"a1-a2b->b1;"		// e1-e2-e3-e4
				+"a1-a2b->b2;"
				+"b1-b2c->c1;"
				+"c2-c2d->d1;"
				+"d1.d2S=\"str1\";"
				+"d1.d2S=\"str2\";"
				+"d1.d2S=\"str3\";"
				);	
		
		System.out.println("基础图G: ");
		print(baseGraph);	
		
	}
	
			
	private static void build_aGraph() {
		
		aGraph = baseGraph.getCopy();
		
		// 删除b1
		TypedNode b1 = aGraph.getAllTypedNodes().get(1);
		aGraph.remove(b1);
		
		System.out.println("分支图G_1: ");
		print(aGraph);
	}
	
	private static void build_bGraph() {
		
		bGraph = baseGraph.getCopy();
		
		// 新增d2，替换c2-d1为c2-d2
		bGraph.declare("d2:D;");
		TypedNode d2 = bGraph.getAllTypedNodes().get(6);
		TypedEdge e = bGraph.getAllTypedEdges().get(3);
		
		TypedEdge enew = new TypedEdge();
		enew.setType(e.getType());
		enew.setSource(e.getSource());
		enew.setTarget(d2);
		
		bGraph.replaceWith(e, enew);
		
		System.out.println("分支图G_2: ");
		print(bGraph);
	}
	
	private static void build_cGraph() {
		
		cGraph = baseGraph.getCopy();
		
		// 替换b2为b3
		TypedNode b2 = cGraph.getAllTypedNodes().get(2);
		TypedNode b3 = new TypedNode();
		b3.setType(b2.getType());
		
		cGraph.replaceWith(b2, b3);
	
		System.out.println("分支图G_3: ");
		print(cGraph);
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
