package edu.ustb.sei.mde.graph.typedGraph;

/**
 * 针对SimpleAddressBook
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import edu.ustb.sei.mde.bxcore.exceptions.NothingReturnedException;
import edu.ustb.sei.mde.bxcore.structures.Index;
import edu.ustb.sei.mde.graph.type.DataTypeNode;
import edu.ustb.sei.mde.graph.type.PropertyEdge;
import edu.ustb.sei.mde.graph.type.TypeEdge;
import edu.ustb.sei.mde.graph.type.TypeNode;
import edu.ustb.sei.mde.graph.typedGraph.constraint.GraphConstraint;
import edu.ustb.sei.mde.structure.Tuple2;
import edu.ustb.sei.mde.structure.Tuple3;

public class ConcurrentBXMergePipeline {

	/** 多图合并 */
	public static ConcurrentTypedGraph merge(ConcurrentTypedGraph first, ConcurrentTypedGraph... interSources)
			throws NothingReturnedException {

		ConcurrentTypedGraph result = first.getCopy();

		ExecutorService executor = new ThreadPoolExecutor(6, 10, 0L, TimeUnit.MILLISECONDS,
				new LinkedBlockingQueue<Runnable>());

		ConcurrentTypedGraph left = interSources[0];
		ConcurrentTypedGraph right = interSources[1];

		List<TypeNode> allTypeNodes = first.getConcurrentTypeGraph().getAllTypeNodes();
		
		// TypedNodeA
		TypeNode typeNodeA = allTypeNodes.get(0);
		List<TypedNode> baseTypedNodeA = first.getAllTypedNodes().parallelStream()
				.filter(n -> n.getType()==typeNodeA).collect(Collectors.toList());
		
		List<TypedNode> leftTypedNodeA = left.getAllTypedNodes().parallelStream()
				.filter(n -> n.getType()==typeNodeA).collect(Collectors.toList());
		
		List<TypedNode> rightTypedNodeA = right.getAllTypedNodes().parallelStream()
				.filter(n -> n.getType()==typeNodeA).collect(Collectors.toList());
		
		// TypedNodeB
		TypeNode typeNodeB = allTypeNodes.get(1);
		List<TypedNode> baseTypedNodeB = first.getAllTypedNodes().parallelStream()
				.filter(n -> n.getType()==typeNodeB).collect(Collectors.toList());
		
		List<TypedNode> leftTypedNodeB = left.getAllTypedNodes().parallelStream()
				.filter(n -> n.getType()==typeNodeB).collect(Collectors.toList());
		
		List<TypedNode> rightTypedNodeB = right.getAllTypedNodes().parallelStream()
				.filter(n -> n.getType()==typeNodeB).collect(Collectors.toList());

		// TypedNodeC
		TypeNode typeNodeC = allTypeNodes.get(2);
		List<TypedNode> baseTypedNodeC = first.getAllTypedNodes().parallelStream()
				.filter(n -> n.getType()==typeNodeC).collect(Collectors.toList());
		
		List<TypedNode> leftTypedNodeC = left.getAllTypedNodes().parallelStream()
				.filter(n -> n.getType()==typeNodeC).collect(Collectors.toList());
		
		List<TypedNode> rightTypedNodeC = right.getAllTypedNodes().parallelStream()
				.filter(n -> n.getType()==typeNodeC).collect(Collectors.toList());
		
		// TypedNodeD
		TypeNode typeNodeD = allTypeNodes.get(3);
		List<TypedNode> baseTypedNodeD = first.getAllTypedNodes().parallelStream()
				.filter(n -> n.getType()==typeNodeD).collect(Collectors.toList());
		
		List<TypedNode> leftTypedNodeD = left.getAllTypedNodes().parallelStream()
				.filter(n -> n.getType()==typeNodeD).collect(Collectors.toList());
		
		List<TypedNode> rightTypedNodeD = right.getAllTypedNodes().parallelStream()
				.filter(n -> n.getType()==typeNodeD).collect(Collectors.toList());
		
		
		// TypedEdgeA2B
		List<TypedEdge> baseA2B = first.getAllTypedEdges().parallelStream()
				.filter(e -> e.getSource().getType()==typeNodeA).collect(Collectors.toList());
		// 写成HashMap通不过编译
		Map<Index, TypedEdge> baseA2BMap = baseA2B.stream()
				.collect(Collectors.toMap(TypedEdge::getIndex, e->e));
		
		List<TypedEdge> leftA2B = left.getAllTypedEdges().parallelStream()
				.filter(e -> e.getSource().getType()==typeNodeA).collect(Collectors.toList());
		Map<Index, TypedEdge> leftA2BMap = leftA2B.stream()
				.collect(Collectors.toMap(TypedEdge::getIndex, e->e));
		
		List<TypedEdge> rightA2B = right.getAllTypedEdges().parallelStream()
				.filter(e -> e.getSource().getType()==typeNodeA).collect(Collectors.toList());
		Map<Index, TypedEdge> rightA2BMap = rightA2B.stream()
				.collect(Collectors.toMap(TypedEdge::getIndex, e->e));
				
		// TypedEdgeB2C
		
		// TypedEdgeC2D
		
		
		
		// 变更的TypedEdgeA2B
		TypedEdge[] typedEdgeImages = new TypedEdge[2];
		for (TypedEdge baseEdge : baseA2B) {
			// 两个分支图先分别和基本图作比较，baseEdge的情况分别存储在typedEdgeImages[i]中，可能是baseEdge、imageEdge、null
			typedEdgeImages[0] = ConcurrentTypedGraph.computeImage(baseEdge, leftA2BMap);
			typedEdgeImages[1] = ConcurrentTypedGraph.computeImage(baseEdge, rightA2BMap);
			
			
			
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		

		return result;
	}

}
