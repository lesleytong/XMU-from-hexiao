package edu.ustb.sei.mde.bxcore.tests;

import edu.ustb.sei.mde.bxcore.exceptions.NothingReturnedException;
import edu.ustb.sei.mde.graph.type.ConcurrentTypeGraph;
import edu.ustb.sei.mde.graph.typedGraph.ConcurrentBXMerge;
import edu.ustb.sei.mde.graph.typedGraph.ConcurrentBXMerge;
import edu.ustb.sei.mde.graph.typedGraph.ConcurrentBXMergeJoin;
import edu.ustb.sei.mde.graph.typedGraph.ConcurrentTypedGraph;
import edu.ustb.sei.mde.graph.typedGraph.GraphChangeTool;
import edu.ustb.sei.mde.graph.typedGraph.GraphChangeTool_Con;
import edu.ustb.sei.mde.graph.typedGraph.Profiler;

public class TestAutomatic_1_Con {

	static ConcurrentTypedGraph baseGraph = null;
	static ConcurrentTypedGraph aGraph = null;
	static ConcurrentTypedGraph bGraph = null;
	static ConcurrentTypedGraph resultGraph = null;
	
	public static void main(String[] args){
		
		// ��ӡ����CPU����
//		int availableProcessors = Runtime.getRuntime() .availableProcessors();
//		System.out.println("********" + availableProcessors);	// ���8
		
		build_baseGraph();
		build_aGraph();
		build_bGraph();
		
		try {
			
			Profiler.begin();
			resultGraph = ConcurrentBXMerge.merge(baseGraph, aGraph, bGraph);
			System.out.println("���У�" + Profiler.end() + "ms");
			
			System.out.println("********************************�ϲ����resultGraph:");
			print(resultGraph);
			
		} catch (NothingReturnedException e) {
			e.printStackTrace();
		}
		
	}
	
	private static void build_baseGraph() {
		
		ConcurrentTypeGraph concurrentTypeGraph = new ConcurrentTypeGraph();
		
		// add type nodes
		concurrentTypeGraph.declare("A");
		concurrentTypeGraph.declare("B");
		concurrentTypeGraph.declare("C");
		concurrentTypeGraph.declare("D");
		// add data type nodes
		concurrentTypeGraph.declare("String:java.lang.String");
		// add type edges
		concurrentTypeGraph.declare("a2b:A->B*");
		concurrentTypeGraph.declare("b2c:B->C");
		concurrentTypeGraph.declare("c2d:C->D");
		// add property edges
		concurrentTypeGraph.declare("a2S:A->String#");
		concurrentTypeGraph.declare("b2S:B->String#");
		concurrentTypeGraph.declare("c2S:C->String#");
		concurrentTypeGraph.declare("d2S:D->String#");
		
		baseGraph = new ConcurrentTypedGraph(concurrentTypeGraph);
		
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
		
		for (int i = 0; i < 3000; i++) {
			String str = GraphChangeTool.getRandomString(5, true);
			baseGraph.declare(
					   "a1:A;" 
			         + "b1:B;" 
					 + "a1-a2b->b1;"
					 + "b1.b2S=\""+str+"\";"
					);
		}
		
		System.out.println("**************baseGraph: ");
		print(baseGraph);
				
	}
	
	private static void build_aGraph() {
		
		aGraph = baseGraph.getCopy();
		
		// add z TypedEdges and 2*z TypedNodes
		GraphChangeTool_Con.addTypedNodesAndTypedEdges(aGraph, 30);
		
		// add z ValueEdges and z TypedNodes and z ValueNodes
		GraphChangeTool_Con.addNodesAndValueEdges(aGraph, 40);
		
		// change TypedEdges
		// '��ʼ��'������±����1�ı߽�����ɾ��30����ע�⻹�滻��һ��
		GraphChangeTool_Con.changeTypedEdges(aGraph, 0, 100);		
		
		// change ValueEdges
		GraphChangeTool_Con.changeValueEdges(aGraph, 100); 		// ɾ��30��
		
		// change TypedNodes
		GraphChangeTool_Con.changeTypedNodes(aGraph, 100, 100);		// �滻10����ɾ��30��
		
	}
	
	private static void build_bGraph() {
		
		bGraph = baseGraph.getCopy();
		
		// add z TypedEdges and 2*z TypedNodes
		GraphChangeTool_Con.addTypedNodesAndTypedEdges(bGraph, 20);
		
		// add z ValueEdges and z TypedNodes and z ValueNodes
		GraphChangeTool_Con.addNodesAndValueEdges(bGraph, 20);
		
		// change TypedEdges
		// '��ʼ��'������±����1�ı߽�����ɾ��20����ע�⻹�滻��1��
		GraphChangeTool_Con.changeTypedEdges(bGraph, 0, 200);		
															
		// change ValueEdges
		GraphChangeTool_Con.changeValueEdges(bGraph, 200);		//ɾ��20��
		
		// change TypedNodes
		GraphChangeTool_Con.changeTypedNodes(bGraph, 200, 200); 	// �滻20����ɾ��20��	

	}
	
	private static void print(ConcurrentTypedGraph concurrentTypedGraph) {
		
		System.out.println("TypedNodes: " + concurrentTypedGraph.getAllTypedNodes().size());
		System.out.println("ValueNodes: " + concurrentTypedGraph.getAllValueNodes().size());
		System.out.println("TypedEdges: " + concurrentTypedGraph.getAllTypedEdges().size());
		System.out.println("ValueEdges: " + concurrentTypedGraph.getAllValueEdges().size());
		System.out.println("*********************************************************************");
		System.out.println();
	}
	
	
}