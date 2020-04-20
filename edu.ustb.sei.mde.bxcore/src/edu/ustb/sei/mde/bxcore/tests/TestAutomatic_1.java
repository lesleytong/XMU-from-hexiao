package edu.ustb.sei.mde.bxcore.tests;

import edu.ustb.sei.mde.bxcore.exceptions.NothingReturnedException;
import edu.ustb.sei.mde.graph.type.TypeGraph;
import edu.ustb.sei.mde.graph.typedGraph.BXMerge;
import edu.ustb.sei.mde.graph.typedGraph.GraphChangeTool;
import edu.ustb.sei.mde.graph.typedGraph.TypedGraph;

public class TestAutomatic_1 {

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
			System.out.println("********************************合并后的resultGraph:");
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
		typeGraph.declare("E");
		// add data type nodes
		typeGraph.declare("String:java.lang.String");
		// add type edges
		typeGraph.declare("a2b:A->B*");
		typeGraph.declare("b2c:B->C");
		typeGraph.declare("c2d:C->D");
		typeGraph.declare("d2e:D->E");
		// add property edges
		typeGraph.declare("a2S:A->String#");
		typeGraph.declare("b2S:B->String#");
		typeGraph.declare("c2S:C->String#");
		typeGraph.declare("d2S:D->String#");
		
		baseGraph = new TypedGraph(typeGraph);
		baseGraph.declare(	
				 "a1:A;"
				+"a2:A;"
				+"a3:A;"		 
				+"a4:A;"
				+"a5:A;"
				+"a6:A;"
				
				+"b1:B;"
				+"b2:B;"
				+"b3:B;"
				+"b4:B;"
				+"b5:B;"
				+"b6:B;"
				
				+"c1:C;"
				+"c2:C;"
				+"c3:C;"
				+"c4:C;"
				+"c5:C;"
				+"c6:C;"
				+"c7:C;"
				+"c8:C;"
				+"c9:C;"
				+"c10:C;"
				+"c11:C;"
				+"c12:C;"
				
				+"d1:D;"
				+"d2:D;"
				+"d3:D;"
				+"d4:D;"
				+"d5:D;"
				+"d6:D;"
				+"d7:D;"
				+"d8:D;"
				+"d9:D;"
				+"d10:D;"
				+"d11:D;"
				+"d12:D;"
				
				+"a1-a2b->b1;"		
				+"a1-a2b->b2;"
				+"a2-a2b->b3;"
				+"a3-a2b->b4;"
				
				+"b1-b2c->c1;"
				+"b2-b2c->c2;"
				+"b4-b2c->c3;"
				
				+"c4-c2d->d4;"
				+"c5-c2d->d5;"
				+"c6-c2d->d6;"
				+"c7-c2d->d7;"
				+"c8-c2d->d8;"
				+"c9-c2d->d9;"
				+"c10-c2d->d10;"
				+"c11-c2d->d11;"
				+"c12-c2d->d12;"
				
				+"a4.a2S=\"str1\";"
				+"a4.a2S=\"str2\";"
				+"a4.a2S=\"str3\";"
				
				+"c1.c2S=\"str4\";"
				+"c1.c2S=\"str5\";"
				+"c1.c2S=\"str6\";"
				
				+"d1.d2S=\"str7\";"
				+"d1.d2S=\"str8\";"
				+"d1.d2S=\"str9\";"
				
				);	
		
		System.out.println("**************************************baseGraph:");
		print(baseGraph);
				
	}
	
	private static void build_aGraph() {
		
		aGraph = baseGraph.getCopy();
		
		// change TypedEdges
		System.out.println("\naGraph当前TypedEdges的规模：" + aGraph.getAllTypedEdges().size());
		System.out.println(aGraph.getAllTypedEdges());
		GraphChangeTool.changeTypedEdges(aGraph, 1, 0);		// '起始点'与从其下标相差1的边交换；删除0个
		
		// change ValueEdges
		System.out.println("\naGraph当前ValueEdges的规模：" + aGraph.getAllValueEdges().size());
		System.out.println(aGraph.getAllValueEdges());
		GraphChangeTool.changeValueEdges(aGraph, 3); 		// 删除3个，但由于3> 9/4，实际上删了2个
		
		// change TypedNodes
		System.out.println("\naGraph当前TypedNodes的规模：" + aGraph.getAllTypedNodes().size());
		System.out.println(aGraph.getAllTypedNodes());
		GraphChangeTool.changeTypedNodes(aGraph, 2, 3);		// 替换2个；删除3个
		
//		---------------------------------------------------------------------------------------------
		
		// add z TypedEdges and 2*z TypedNodes
		System.out.println("\naGraph当前TypedEdges的规模：" + aGraph.getAllTypedEdges().size());
		System.out.println("aGraph当前TypedNodes的规模：" + aGraph.getAllTypedNodes().size());
		GraphChangeTool.addTypedNodesAndTypedEdges(aGraph, 5);
		
		// add z ValueEdges and z TypedNodes and z ValueNodes
		System.out.println("\naGraph当前ValueEdges的规模：" + aGraph.getAllValueEdges().size());
		System.out.println("aGraph当前TypedNodes的规模：" + aGraph.getAllTypedNodes().size());
		System.out.println("aGraph当前ValueNodes的规模：" + aGraph.getAllValueNodes().size());
		GraphChangeTool.addNodesAndValueEdges(aGraph, 5);
		
	}
	
	private static void build_bGraph() {
		
		bGraph = baseGraph.getCopy();
		
		// change TypedEdges
		System.out.println("base: " + baseGraph.getAllTypedEdges());
		System.out.println("\nbGraph当前TypedEdges的规模： " + bGraph.getAllTypedEdges().size());
		System.out.println(bGraph.getAllTypedEdges());
		// '起始点'与从其下标相差1的边交换；删除1个
		GraphChangeTool.changeTypedEdges(bGraph, 1, 1);	
															
		// change ValueEdges
		System.out.println("\nbGraph当前ValueEdges的规模： " + bGraph.getAllValueEdges().size());
		System.out.println(bGraph.getAllValueEdges());
		GraphChangeTool.changeValueEdges(bGraph, 1);		//删除1个
		
		// change TypedNodes
		System.out.println("\nbGraph当前TypedNodes的规模：" + bGraph.getAllTypedNodes().size());
		System.out.println(bGraph.getAllTypedNodes());
		GraphChangeTool.changeTypedNodes(bGraph, 0, 12); 	// 替换0个；删除12个（因为12+threeQuarterSize>allSize，实际上删了9个）
		
//		---------------------------------------------------------------------------------------------
				
		// add z TypedEdges and 2*z TypedNodes
		System.out.println("\nbGraph当前TypedEdges的规模：" + bGraph.getAllTypedEdges().size());
		System.out.println("bGraph当前TypedNodes的规模：" + bGraph.getAllTypedNodes().size());
		GraphChangeTool.addTypedNodesAndTypedEdges(bGraph, 5);
		
		// add z ValueEdges and z TypedNodes and z ValueNodes
		System.out.println("\nbGraph当前ValueEdges的规模：" + bGraph.getAllValueEdges().size());
		System.out.println("bGraph当前TypedNodes的规模：" + bGraph.getAllTypedNodes().size());
		System.out.println("bGraph当前ValueNodes的规模：" + bGraph.getAllValueNodes().size());
		GraphChangeTool.addNodesAndValueEdges(bGraph, 5);
		
	}
	
	private static void print(TypedGraph typedGraph) {
		System.out.println("TypedNodes: " + typedGraph.getAllTypedNodes().size() + typedGraph.getAllTypedNodes().toString());
		System.out.println("ValueNodes: " + typedGraph.getAllValueNodes().size() + typedGraph.getAllValueNodes().toString());
		System.out.println("TypedEdges: " + typedGraph.getAllTypedEdges().size() + typedGraph.getAllTypedEdges().toString());
		System.out.println("ValueEdges: " + typedGraph.getAllValueEdges().size() + typedGraph.getAllValueEdges().toString());
		System.out.println("*********************************************************************");
		System.out.println();
	}
	
	
}
