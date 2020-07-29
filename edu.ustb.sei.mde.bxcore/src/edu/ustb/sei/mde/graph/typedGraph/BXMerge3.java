package edu.ustb.sei.mde.graph.typedGraph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * 串行合并，
 * 逐步构建结果图，
 * 效率提高更多了。
 */

import edu.ustb.sei.mde.bxcore.exceptions.NothingReturnedException;
import edu.ustb.sei.mde.bxcore.structures.Index;
import edu.ustb.sei.mde.graph.type.PropertyEdge;
import edu.ustb.sei.mde.graph.type.TypeEdge;
import edu.ustb.sei.mde.graph.type.TypeNode;
import edu.ustb.sei.mde.structure.Tuple2;
import edu.ustb.sei.mde.structure.Tuple3;

public class BXMerge3 {

	/** 多路合并 */
		public static TypedGraph merge(TypedGraph baseGraph, TypedGraph... interSources) throws NothingReturnedException {
	
			TypedGraph resultGraph = new TypedGraph(baseGraph.getTypeGraph());
	
			// 新加TypedNodes
			Profiler.begin();
			for (TypedGraph image : interSources) {
				for (TypedNode n : image.allTypedNodes) { // 对于分支图中每个TypedNode类型的节点n
					try {
						// 根据n的索引查找基本图中有无相应的对象，如果有则不做处理
						baseGraph.getElementByIndexObject(n.getIndex());
					} catch (NothingReturnedException e) { // 如果在基本图中没有找到相应的对象
						TypedNode rn = null;
						try {
							// 根据n的索引查找result图中有无相应的对象，如果有就赋值给rn
							rn = resultGraph.getElementByIndexObject(n.getIndex());
						} catch (NothingReturnedException e1) { // 如果result图中无相应的对象，则将n对象添加到result图的List<TypedNode>，并且令rn=null
							resultGraph.addTypedNode(n);
							rn = null;
						} finally {
	
							if (rn != null) { // 如果rn!=null，说明根据n的索引找到了result图中相应的对象，且赋值给了rn
								TypeNode lt = rn.getType();
								TypeNode rt = n.getType();
								TypeNode ct = baseGraph.getTypeGraph().computeSubtype(lt, rt); // 最终的类型
	
								if (ct == TypeNode.NULL_TYPE) {
									throw new NothingReturnedException(); // incompatible
								} else {
									rn.setType(ct); // 若兼容，则rn的type设置为ct
									rn.mergeIndex(n);
									resultGraph.reindexing(rn); // lyt-修改
								}
							}
						}
					}
				}
			}
			System.out.println("*******串行新加TypedNodes：" + Profiler.end() + "ms");
	
			// 新加ValueNodes
			Profiler.begin();
			baseGraph.allValueNodes.forEach(v -> {
				resultGraph.addValueNode(v);
			});
			for (TypedGraph image : interSources) {
				image.allValueNodes.forEach(v -> {
					resultGraph.addValueNode(v);
				});
			}
			System.out.println("*******串行新加ValueNodes：" + Profiler.end() + "ms");
	
			// 将不变和修改的TypedNodes添加到结果图中
			Profiler.begin();
			TypeNode[] nodeImages = new TypeNode[interSources.length];
			for (TypedNode baseNode : baseGraph.allTypedNodes) { // 对于基本图中每一个TypedNode节点
	
				for (int i = 0; i < interSources.length; i++) {
					// 两个分支图先分别和基本图作比较，baseNode的情况分别存储在nodeImages[i]中。可能是NULL、ANY、修改后的类型
					nodeImages[i] = TypedGraph.computeImage(baseNode, baseGraph, interSources[i]);
				}
	
				try {
					// 再根据nodeImages[]中的情况，确定baseNode的finalType
					TypeNode finalType = TypedGraph.computeType(nodeImages, baseGraph.getTypeGraph());
	
					if (finalType != TypeNode.NULL_TYPE) {
						if (finalType == TypeNode.ANY_TYPE) {
							finalType = baseNode.getType();
						}
	
						TypedNode n = new TypedNode(); // 新申请的节点
						n.setType(finalType); // 设置新节点n的类型：和基本图中一样的类型或是修改后的类型
	
						for (TypedGraph image : interSources) {
							// 将新节点n和所有分支图中对应的baseNode的索引集合并
							n.mergeIndex(image.getElementByIndexObject(baseNode.getIndex()));
						}
	
						resultGraph.addTypedNode(n);
					}
	
				} catch (NothingReturnedException e) {
					throw e; // 捕捉到异常后抛出
				}
			}
			System.out.println("*******串行将不变和修改的TypedNodes添加到结果图中：" + Profiler.end() + "ms");
	
			// 将不变和修改的TypedEdges添加到结果图中
			Profiler.begin();
			long[] array = {0, 0, 0};
			long start;
			TypedEdge[] typedEdgeImages = new TypedEdge[interSources.length];
			for (TypedEdge baseEdge : baseGraph.allTypedEdges) { // 对于基本图中每一个TypedEdge类型的边baseEdge
				
				start = System.currentTimeMillis();
				// 多个分支图先分别和基本图作比较，baseEdge的情况分别存储在typedEdgeImages[i]中，可能是baseEdge、imageEdge、null
				for (int i = 0; i < interSources.length; i++) {
					typedEdgeImages[i] = TypedGraph.computeImage(baseEdge, baseGraph, interSources[i]);
				}
				array[0] += System.currentTimeMillis() - start;
	
				try {
					start = System.currentTimeMillis();
					// 再根据typedEdgeImages[]中的情况，确定finalEdgeInfo
					Tuple3<TypedNode, TypedNode, TypeEdge> finalEdgeInfo = TypedGraph.computeEdge(baseEdge,
							typedEdgeImages);
					array[1] += System.currentTimeMillis() - start;
	
					
					if (finalEdgeInfo != null) {
						TypedNode source = resultGraph.getElementByIndexObject(finalEdgeInfo.first.getIndex());
						TypedNode target = resultGraph.getElementByIndexObject(finalEdgeInfo.second.getIndex());
						TypedEdge edge = new TypedEdge(); // 新申请的对象edge
						edge.setSource(source);
						edge.setTarget(target);
						edge.setType(finalEdgeInfo.third);
	
						for (TypedGraph image : interSources) { // 合并所有分支图的索引集
							edge.mergeIndex(image.getElementByIndexObject(baseEdge.getIndex()));
						}
						start = System.currentTimeMillis();
						resultGraph.addTypedEdge(edge);
						array[2] += System.currentTimeMillis() - start;
					}
					
	
				} catch (NothingReturnedException e) {
					throw e; // 捕捉到异常后抛出
				}
			}
			System.out.println("*******串行将不变和修改的TypedEdges添加到结果图中：" + Profiler.end() + "ms");
			
			System.out.println("array[0]: " + array[0]);
			System.out.println("array[1]: " + array[1]);
			System.out.println("array[2]: " + array[2]);
			
	
			// 将不变和修改的ValueEdges添加到结果图中
			Profiler.begin();
			ValueEdge[] valueEdgeImages = new ValueEdge[interSources.length];
			for (ValueEdge baseEdge : baseGraph.allValueEdges) { // 对于基本图中每一个条ValueEdge类型的边
	
				// 两个分支图先和基本图作比较，baseEdge的情况分别存储在valueEdgeImages[]中，可能是null、baseEdge、imageEdge
				for (int i = 0; i < interSources.length; i++) {
					valueEdgeImages[i] = TypedGraph.computeImage(baseEdge, baseGraph, interSources[i]);
				}
	
				try {
					// 再根据valueEdgeImages[]中的情况，确定finalEdgeInfo
					Tuple3<TypedNode, ValueNode, PropertyEdge> finalEdgeInfo = TypedGraph.computeEdge(baseEdge,
							valueEdgeImages);
	
					if (finalEdgeInfo != null) {
						TypedNode source = resultGraph.getElementByIndexObject(finalEdgeInfo.first.getIndex());
						ValueNode target = finalEdgeInfo.second;
						ValueEdge edge = new ValueEdge();
						edge.setSource(source);
						edge.setTarget(target);
						edge.setType(finalEdgeInfo.third);
	
						for (TypedGraph image : interSources) {
							edge.mergeIndex(image.getElementByIndexObject(baseEdge.getIndex()));
						}
	
						resultGraph.addValueEdge(edge);
					}
	
				} catch (NothingReturnedException e) {
					throw e;
				}
			}
			System.out.println("*******串行将不变和修改的ValueEdges添加到结果图中：" + Profiler.end() + "ms");
	
			// 新加TypedEdges
			Profiler.begin();
			for (TypedGraph image : interSources) {
				for (TypedEdge e : image.allTypedEdges) { // 对于分支图中每一个TypedEdge边e
					try { // 根据e的索引查找基本图中有无相应的对象，如果有则不做处理
						baseGraph.getElementByIndexObject(e.getIndex());
					} catch (Exception ex) { // 基本图中没有找到相应的对象
						TypedEdge re = null;
						try {
							// 根据e的索引查找result图中有无相应的对象，如果有则赋值给re
							re = resultGraph.getElementByIndexObject(e.getIndex());
						} catch (Exception ex2) { // 根据e的索引没有找到result图中相应的对象，则应添加e到result图的List<TypedEdge>中
	
							TypedNode source = resultGraph.getElementByIndexObject(e.getSource().getIndex());
							TypedNode target = resultGraph.getElementByIndexObject(e.getTarget().getIndex());
	
							if (e.getSource() != source || e.getTarget() != target) { // 说明e的source和target是基本图中有的，result图合并过三个图的索引，但不是同一对象
								TypedEdge ne = new TypedEdge();
								ne.setSource(source);
								ne.setTarget(target);
								ne.setType(e.getType());
								ne.mergeIndex(e);
								resultGraph.addTypedEdge(ne);
							} else // 说明e的source和target是在分支图中新添加的TypedNode类型节点，所以在分支图和result图中是同一对象
								resultGraph.addTypedEdge(e);
	
							re = null;
	
						} finally {
	
							// 根据e的索引找到了result图中相应的对象，并赋值给了re
							// 说明多个分支图添加了相同的边
							if (re != null) {
								if (re.getType() != e.getType()
										|| !re.getSource().getIndex().equals(e.getSource().getIndex())
										|| !re.getTarget().getIndex().equals(e.getTarget().getIndex())) {
									throw new NothingReturnedException();
								} else {
									re.mergeIndex(e);
									resultGraph.reindexing(re); // lyt修改
								}
							}
						}
					}
				}
			}
			System.out.println("*******串行新加TypedEdges：" + Profiler.end() + "ms");
	
			// 新加ValueEdges
			Profiler.begin();
			for (TypedGraph image : interSources) {
				for (ValueEdge e : image.allValueEdges) { // 对于分支图中的每一个ValueEdge边e
					try {
						// 根据e的索引查找基本图中有无相应的对象，如果有则不处理
						baseGraph.getElementByIndexObject(e.getIndex());
					} catch (Exception ex) { // 如果基本图中没有相应的对象
						ValueEdge re = null;
						try {
							// 根据e的索引查找result图中有无相应的对象，如果有则赋值给re
							re = resultGraph.getElementByIndexObject(e.getIndex());
						} catch (Exception ex2) { // 根据e的索引没有找到result图中相应的对象，则需要添加e到图的List<ValueEdge>中
	
							TypedNode source = resultGraph.getElementByIndexObject(e.getSource().getIndex());
	
							if (e.getSource() != source) { // source是基本图中有的，result图合并过三个图的索引集，但不是同一对象
								ValueEdge ne = new ValueEdge();
								ne.setSource(source);
								ne.setTarget(e.getTarget());
								ne.setType(e.getType());
								ne.mergeIndex(e);
								resultGraph.addValueEdge(ne);
							} else // e的source和result图中是同一对象，说明是新添加的TypedNode对象
								resultGraph.addValueEdge(e);
	
							re = null;
						} finally {
	
							if (re != null) { // re!=null，说明result图中找到了相应的对象，并且赋值给了re
								if (re.getType() != e.getType()
										|| !re.getSource().getIndex().equals(e.getSource().getIndex())
										|| re.getTarget().equals(e.getTarget()) == false) {
									throw new NothingReturnedException();
								} else {
									re.mergeIndex(e);
									resultGraph.reindexing(re); // lyt修改
								}
							}
						}
					}
				}
			}
			System.out.println("*******串行新加ValueEdges：" + Profiler.end() + "ms");
	
	//			OrderInformation[] orders = new OrderInformation[interSources.length];
	//			for (int i = 0; i < interSources.length; i++)
	//				orders[i] = interSources[i].order;
	//			resultGraph.order.merge(orders); // 将orders[i]合并到result的order中
	
	//			// lyt-测试原来的序方法
	//			System.out.println("执行enforceOrder前： " + result.getAllTypedEdges());
	//			result.enforceOrder();
	//			System.out.println("执行enforceOrder后：" + result.getAllTypedEdges());
	
	//			List<GraphConstraint> cons = new ArrayList<>();
	//			cons.add(baseGraph.getConstraint());
	//			for (TypedGraph g : interSources) {
	//				cons.add(g.constraint);
	//			}
	//			resultGraph.constraint = GraphConstraint.and(cons);
	//			// check
	
			return resultGraph;
		}

	/** 多路合并 */
	public static TypedGraph merge_Con(TypedGraph baseGraph, TypedGraph... interSources)
			throws NothingReturnedException {
	
		TypedGraph resultGraph = new TypedGraph(baseGraph.getTypeGraph());
		
		List<TypedEdge> allTypedEdges = resultGraph.allTypedEdges;
		List<ValueEdge> allValueEdges = resultGraph.allValueEdges;
		
		resultGraph.allTypedNodes = Collections.synchronizedList(resultGraph.allTypedNodes);
		resultGraph.allTypedEdges = Collections.synchronizedList(resultGraph.allTypedEdges);
		resultGraph.allValueNodes = Collections.synchronizedList(resultGraph.allValueNodes);
		resultGraph.allValueEdges = Collections.synchronizedList(resultGraph.allValueEdges);
		resultGraph.indexToObjectMap  = new ConcurrentHashMap<>();
		
		// 新加TypedNodes
		long start = System.currentTimeMillis();
		for (TypedGraph image : interSources) {
			image.allTypedNodes.parallelStream().forEach(n -> {
				try {
					// 根据n的索引查找基本图中有无相应的对象，如果有则不做处理
					baseGraph.getElementByIndexObject(n.getIndex());
				} catch (NothingReturnedException e) { // 如果在基本图中没有找到相应的对象
					TypedNode rn = null;
					try {
						// 根据n的索引查找result图中有无相应的对象，如果有就赋值给rn
						rn = resultGraph.getElementByIndexObject(n.getIndex());
					} catch (NothingReturnedException e1) { // 如果result图中无相应的对象，则将n对象添加到result图的List<TypedNode>，并且令rn=null
						resultGraph.addTypedNode(n);
						rn = null;
					} finally {
	
						if (rn != null) { // 如果rn!=null，说明根据n的索引找到了result图中相应的对象，且赋值给了rn
							TypeNode lt = rn.getType();
							TypeNode rt = n.getType();
							TypeNode ct = baseGraph.getTypeGraph().computeSubtype(lt, rt); // 最终的类型
	
							if (ct == TypeNode.NULL_TYPE) {
	
								try {
									throw new NothingReturnedException(); // incompatible
								} catch (NothingReturnedException e2) {
									e2.printStackTrace();
								}
	
							} else {
								rn.setType(ct); // 若兼容，则rn的type设置为ct
								rn.mergeIndex(n);
								resultGraph.reindexing(rn); // lyt-修改
							}
						}
					}
				}
			});
		}
		long end = System.currentTimeMillis();
		System.out.println("*******parallelStream新加TypedNodes：" + (end - start) + "ms");
		
		// 新加ValueNodes
		start = System.currentTimeMillis();
		baseGraph.allValueNodes.parallelStream().forEach(v -> {
			resultGraph.addValueNode(v);
		});
		for (TypedGraph image : interSources) {
			image.allValueNodes.parallelStream().forEach(v -> {
				resultGraph.addValueNode(v);
			});
		}
		end = System.currentTimeMillis();
		System.out.println("*******parallelStream新加ValueNodes：" + (end - start) + "ms");
	
		// 将不变和修改的TypedNodes添加到结果图中
		start = System.currentTimeMillis();
		ConcurrentHashMap<Thread, TypeNode[]> map1 = new ConcurrentHashMap<>();
		baseGraph.allTypedNodes.parallelStream().forEach(baseNode -> {
			
			TypeNode[] nodeImages;
			if((nodeImages = map1.get(Thread.currentThread())) != null) {
				
			}else {
				nodeImages = new TypeNode[interSources.length];
				map1.put(Thread.currentThread(), nodeImages);
			}
	
			for (int i = 0; i < interSources.length; i++) {
				// 两个分支图先分别和基本图作比较，baseNode的情况分别存储在nodeImages[i]中。可能是NULL、ANY、修改后的类型
				nodeImages[i] = TypedGraph.computeImage(baseNode, baseGraph, interSources[i]);
			}
	
			try {
				// 再根据nodeImages[]中的情况，确定baseNode的finalType
				 TypeNode finalType = TypedGraph.computeType(nodeImages, baseGraph.getTypeGraph());
	
				if (finalType != TypeNode.NULL_TYPE) {
	
					if (finalType == TypeNode.ANY_TYPE) {
						finalType = baseNode.getType();
					}
	
					TypedNode n = new TypedNode(); // 新申请的节点
					n.setType(finalType); // 设置新节点n的类型：和基本图中一样的类型或是修改后的类型
	
					for (TypedGraph image : interSources) {
						// 将新节点n和所有分支图中对应的baseNode的索引集合并
						n.mergeIndex(image.getElementByIndexObject(baseNode.getIndex()));
					}
	
					resultGraph.addTypedNode(n);
				}
	
			} catch (NothingReturnedException e) {
				e.printStackTrace();
			}
	
		});
		end = System.currentTimeMillis();
		System.out.println("*******parallelStream将不变和修改的TypedNodes添加到结果图中：" + (end - start) + "ms");
	
		// 将不变和修改的TypedEdges添加到结果图中
		start = System.currentTimeMillis();
		ConcurrentHashMap<Thread, TypedEdge[]> map2 = new ConcurrentHashMap<>();
		baseGraph.allTypedEdges.parallelStream().forEach(baseEdge -> {
			
			TypedEdge[] typedEdgeImages;
			if((typedEdgeImages = map2.get(Thread.currentThread())) != null) {
				
			}else {
				typedEdgeImages = new TypedEdge[interSources.length];
				map2.put(Thread.currentThread(), typedEdgeImages);
			}
			
			// 多个分支图先分别和基本图作比较，baseEdge的情况分别存储在typedEdgeImages[i]中，可能是baseEdge、imageEdge、null
			for (int i = 0; i < interSources.length; i++) {
				typedEdgeImages[i] = TypedGraph.computeImage(baseEdge, baseGraph, interSources[i]);
			}
	
			try {
				// 再根据typedEdgeImages[]中的情况，确定finalEdgeInfo
				Tuple3<TypedNode, TypedNode, TypeEdge> finalEdgeInfo = TypedGraph.computeEdge(baseEdge,
						typedEdgeImages);
	
				if (finalEdgeInfo != null) {
					TypedNode source = resultGraph.getElementByIndexObject(finalEdgeInfo.first.getIndex());
					TypedNode target = resultGraph.getElementByIndexObject(finalEdgeInfo.second.getIndex());
					TypedEdge edge = new TypedEdge(); // 新申请的对象edge
					edge.setSource(source);
					edge.setTarget(target);
					edge.setType(finalEdgeInfo.third);
	
					for (TypedGraph image : interSources) { // 合并所有分支图的索引集
						edge.mergeIndex(image.getElementByIndexObject(baseEdge.getIndex()));
					}
					// 这部分耗时最多
					resultGraph.addTypedEdge(edge);	
				}
	
			} catch (NothingReturnedException e) {
				e.printStackTrace();
			}
		});
		end = System.currentTimeMillis();
		System.out.println("*******parallelStream将不变和修改的TypedEdges添加到结果图中：" + (end - start) + "ms");
	
		// 将不变和修改的ValueEdges添加到结果图中
		start = System.currentTimeMillis();
		ConcurrentHashMap<Thread, ValueEdge[]> map3 = new ConcurrentHashMap<>();
		baseGraph.allValueEdges.parallelStream().forEach(baseEdge -> {
			
			ValueEdge[] valueEdgeImages;
			if((valueEdgeImages = map3.get(Thread.currentThread())) != null) {
				
			}else {
				valueEdgeImages = new ValueEdge[interSources.length];
				map3.put(Thread.currentThread(), valueEdgeImages);
			}
			
			// 两个分支图先和基本图作比较，baseEdge的情况分别存储在valueEdgeImages[]中，可能是null、baseEdge、imageEdge
			for (int i = 0; i < interSources.length; i++) {
				valueEdgeImages[i] = TypedGraph.computeImage(baseEdge, baseGraph, interSources[i]);
			}
	
			try {
				// 再根据valueEdgeImages[]中的情况，确定finalEdgeInfo
				Tuple3<TypedNode, ValueNode, PropertyEdge> finalEdgeInfo = TypedGraph.computeEdge(baseEdge,
						valueEdgeImages);
	
				if (finalEdgeInfo != null) {
					TypedNode source = resultGraph.getElementByIndexObject(finalEdgeInfo.first.getIndex());
					ValueNode target = finalEdgeInfo.second;
					ValueEdge edge = new ValueEdge();
					edge.setSource(source);
					edge.setTarget(target);
					edge.setType(finalEdgeInfo.third);
	
					for (TypedGraph image : interSources) {
						edge.mergeIndex(image.getElementByIndexObject(baseEdge.getIndex()));
					}
	
					resultGraph.addValueEdge(edge);
				}
	
			} catch (NothingReturnedException e) {
				e.printStackTrace();
			}
		});
		end = System.currentTimeMillis();
		System.out.println("*******parallelStream将不变和修改的ValueEdges添加到结果图中：" + (end - start) + "ms");
	
		
		resultGraph.allTypedEdges = allTypedEdges;
		// 新加TypedEdges
		start = System.currentTimeMillis();
		for (TypedGraph image : interSources) {
			image.allTypedEdges.forEach(e -> {
				try { // 根据e的索引查找基本图中有无相应的对象，如果有则不做处理
					baseGraph.getElementByIndexObject(e.getIndex());
				} catch (Exception ex) { // 基本图中没有找到相应的对象
					TypedEdge re = null;
					try {
						// 根据e的索引查找result图中有无相应的对象，如果有则赋值给re
						re = resultGraph.getElementByIndexObject(e.getIndex());
					} catch (Exception ex2) { // 根据e的索引没有找到result图中相应的对象，则应添加e到result图的List<TypedEdge>中
	
						TypedNode source = null;
						TypedNode target = null;
						try {
							source = resultGraph.getElementByIndexObject(e.getSource().getIndex());
							target = resultGraph.getElementByIndexObject(e.getTarget().getIndex());
						} catch (NothingReturnedException e1) {
							e1.printStackTrace();
						}
	
						if (e.getSource() != source || e.getTarget() != target) { // 说明e的source和target是基本图中有的，result图合并过三个图的索引，但不是同一对象
							TypedEdge ne = new TypedEdge();
							ne.setSource(source);
							ne.setTarget(target);
							ne.setType(e.getType());
							ne.mergeIndex(e);
							resultGraph.addTypedEdge(ne);
						} else // 说明e的source和target是在分支图中新添加的TypedNode类型节点，所以在分支图和result图中是同一对象
							resultGraph.addTypedEdge(e);
	
						re = null;
	
					} finally {
	
						// 根据e的索引找到了result图中相应的对象，并赋值给了re
						// 说明多个分支图添加了相同的边
						if (re != null) {
							if (re.getType() != e.getType()
									|| !re.getSource().getIndex().equals(e.getSource().getIndex())
									|| !re.getTarget().getIndex().equals(e.getTarget().getIndex())) {
								try {
									throw new NothingReturnedException();
								} catch (NothingReturnedException e2) {
									e2.printStackTrace();
								}
	
							} else {
								re.mergeIndex(e);
								resultGraph.reindexing(re); // lyt修改
							}
						}
					}
				}
			});
		}
		end = System.currentTimeMillis();
		System.out.println("*******新加TypedEdges：" + (end - start) + "ms");
	
		resultGraph.allValueEdges = allValueEdges;
		// 新加ValueEdges
		start = System.currentTimeMillis();
		for (TypedGraph image : interSources) {
			image.allValueEdges.forEach(e -> {
				try {
					// 根据e的索引查找基本图中有无相应的对象，如果有则不处理
					baseGraph.getElementByIndexObject(e.getIndex());
				} catch (Exception ex) { // 如果基本图中没有相应的对象
					ValueEdge re = null;
					try {
						// 根据e的索引查找result图中有无相应的对象，如果有则赋值给re
						re = resultGraph.getElementByIndexObject(e.getIndex());
					} catch (Exception ex2) { // 根据e的索引没有找到result图中相应的对象，则需要添加e到图的List<ValueEdge>中
	
						TypedNode source = null;
						try {
							source = resultGraph.getElementByIndexObject(e.getSource().getIndex());
						} catch (NothingReturnedException e1) {
							e1.printStackTrace();
						}
	
						if (e.getSource() != source) { // source是基本图中有的，result图合并过三个图的索引集，但不是同一对象
							ValueEdge ne = new ValueEdge();
							ne.setSource(source);
							ne.setTarget(e.getTarget());
							ne.setType(e.getType());
							ne.mergeIndex(e);
							resultGraph.addValueEdge(ne);
						} else // e的source和result图中是同一对象，说明是新添加的TypedNode对象
							resultGraph.addValueEdge(e);
	
						re = null;
					} finally {
	
						if (re != null) { // re!=null，说明result图中找到了相应的对象，并且赋值给了re
							if (re.getType() != e.getType()
									|| !re.getSource().getIndex().equals(e.getSource().getIndex())
									|| re.getTarget().equals(e.getTarget()) == false) {
								try {
									throw new NothingReturnedException();
								} catch (NothingReturnedException e2) {
									e2.printStackTrace();
								}
							} else {
								re.mergeIndex(e);
								resultGraph.reindexing(re); // lyt修改
							}
						}
					}
				}
			});
	
		}
		end = System.currentTimeMillis();
		System.out.println("*******新加ValueEdges：" + (end - start) + "ms");
	
		return resultGraph;
	}

	// 利用computeOrd()
	public static List<TypedEdge> threeOrder(TypedGraph baseGraph, TypedGraph resultGraph,
			HashMap<TypedEdge, TypedEdge> forceOrd, TypedGraph... branchGraphs) {
	
		List<TypedEdge> resultList = resultGraph.getAllTypedEdges();
		List<TypedEdge> mergeList = new LinkedList<>(resultList);
		HashMap<TypedEdge, Integer> mergeFlag = new HashMap<>();
	
		for (int i = 0; i < resultList.size() - 1; i++) {
			TypedEdge ei = resultList.get(i);
			// 更新mergeList的位置映射
			int m = 0;
			for (TypedEdge typedEdge : mergeList) {
				mergeFlag.put(typedEdge, m++);
			}
			for (int j = i + 1; j < resultList.size(); j++) {
				TypedEdge ej = resultList.get(j);
				Tuple2<Character, Character> computeOrd = computeOrd(ei, ej, baseGraph, forceOrd, branchGraphs);
				if (computeOrd.second == 'n' || computeOrd.second == '<') {
					continue;
				} else {
					if (mergeFlag.get(ei) > mergeFlag.get(ej)) {
						continue;
					} else {
						mergeList.remove(ej);
						mergeList.add(mergeList.indexOf(ei), ej);
					}
				}
			}
		}
		return mergeList;
	}

	public static Tuple2<Character, Character> computeOrd(TypedEdge ei, TypedEdge ej, TypedGraph baseGraph,
			HashMap<TypedEdge, TypedEdge> forceOrd, TypedGraph... branchGraphs) {
	
		HashMap<TypedEdge, Integer> baseFlag = new HashMap<>();
		List<TypedEdge> baseList = baseGraph.getAllTypedEdges();
		for (int i = 0; i < baseList.size(); i++) {
			baseFlag.put(baseList.get(i), i);
		}
	
		int len = branchGraphs.length;
		HashMap<TypedEdge, Integer>[] branchFlag = new HashMap[len];
		for (int i = 0; i < len; i++) {
			List<TypedEdge> branchList = branchGraphs[i].getAllTypedEdges();
			branchFlag[i] = new HashMap<>();
			for (int j = 0; j < branchList.size(); j++) {
				branchFlag[i].put(branchList.get(j), j);
			}
		}
	
		List<Tuple2<Character, Character>> ord_k = new ArrayList<>();
	
		boolean flag = true;
		TypedEdge ei_b = null;
		TypedEdge ej_b = null;
		for (int k = 0; k < len; k++) {
			char t = 'S';
			char o = 'n';
			try {
				TypedEdge ei_k = branchGraphs[k].getElementByIndexObject(ei.getIndex());
				TypedEdge ej_k = branchGraphs[k].getElementByIndexObject(ej.getIndex());
				// 如果ei和ej都属于某个分支图
				char t_k;
				char o_k;
				if (forceOrd.get(ei_k) == ej_k) {
					t_k = 'H';
					o_k = '<';
				} else if (forceOrd.get(ej_k) == ei_k) {
					t_k = 'H';
					o_k = '>';
				} else {
					t_k = 'S';
					int distance_k = branchFlag[k].get(ei_k) - branchFlag[k].get(ej_k);
					if (distance_k < 0) {
						o_k = '<';
					} else if (distance_k == 0) {
						o_k = '=';
					} else {
						o_k = '>';
					}
				}
				try {
					if(flag == true) {
						ei_b = baseGraph.getElementByIndexObject(ei.getIndex());
						ej_b = baseGraph.getElementByIndexObject(ej.getIndex());
						flag = false;
					}
					// 若ei和ej还都属于基础图
					if (forceOrd.get(ei_b) == ej_b) {
						t = 'H';
						o = '<';
					} else if (forceOrd.get(ej_b) == ei_b) {
						t = 'H';
						o = '>';
					} else {
						t = 'S';
						int distance_b = baseFlag.get(ei_b) - baseFlag.get(ej_b);
						if (distance_b < 0) {
							o = '<';
						} else if (distance_b == 0) {
							o = '=';
						} else {
							o = '>';
						}
					}
	
					if (o_k == o) {
						if (t_k == 'H' || t == 'H') {
							t = 'H';
						}
					} else if (t == 'S') { // o_k不等于o
						t = 'H';
						o = o_k;
					} else {
						throw new NothingReturnedException("@@@conflict");
					}
				} catch (NothingReturnedException e) {
					// 若ei和ej不是都属于基础图，则以分支图为准
					t = t_k;
					o = o_k;
				}
			} catch (NothingReturnedException e) {
				// 如果ei和ej不是都属于某个分支图
			}
			ord_k.add(new Tuple2<Character, Character>(t, o));
		}
	
		// 再计算ord
		Tuple2<Character, Character> t1 = ord_k.get(0);
		Tuple2<Character, Character> t2;
		// 计算ei和ej的最终序
		for (int p = 1; p < ord_k.size(); p++) {
			t2 = ord_k.get(p);
			try {
				t1 = mergeOrd(t1, t2);
			} catch (NothingReturnedException e) {
				e.printStackTrace();
			}
		}
		return t1;
	}

	public static Tuple2<Character, Character> mergeOrd(Tuple2<Character, Character> c1,
			Tuple2<Character, Character> c2) throws NothingReturnedException {
	
		if (c1.first == 'H' && c2.first == 'S') {
			return new Tuple2<Character, Character>('H', c1.second);
		} else if (c1.first == 'S' && c2.first == 'H') {
			return new Tuple2<Character, Character>('H', c2.second);
		} else if (c1.first == 'H' && c2.first == 'H') {
			if (c1.second == c2.second) {
				return new Tuple2<Character, Character>('H', c1.second);
			} else {
				throw new NothingReturnedException("###conflict");
			}
		} else if (c1.first == 'S' && c2.first == 'S') {
			if (c1.second == 'n' && c2.second == 'n') {
				return new Tuple2<Character, Character>('S', c1.second);
			} else if (c1.second == 'n' && c2.second != 'n') {
				return new Tuple2<Character, Character>('S', c2.second);
			} else if (c1.second != 'n' && c2.second == 'n') {
				return new Tuple2<Character, Character>('S', c1.second);
			} else if (c1.second != 'n' && c2.second != 'n') {
				if (c1.second == c2.second) {
					return new Tuple2<Character, Character>('S', c1.second);
				} else {
					throw new NothingReturnedException("***conflict");
				}
			}
		} else {
			throw new NothingReturnedException("error");
		}
		return null;
	}

	public static HashMap<TypedEdge, TypedEdge> checkForceOrd(TypedGraph resultGraph,
			Set<Tuple2<TypedEdge, TypedEdge>> orders) throws NothingReturnedException {
	
		HashMap<TypedEdge, TypedEdge> orderMap = new HashMap<>();
	
		if (orders.size() == 0) {
			return orderMap;
		}
	
		// ringFlag用于判断有无环冲突
		HashMap<TypedEdge, TypedEdge> ringFlag = new HashMap<>();
		Iterator<Tuple2<TypedEdge, TypedEdge>> iterator = orders.iterator();
		while (iterator.hasNext()) {
			Tuple2<TypedEdge, TypedEdge> order = iterator.next();
			try {
				resultGraph.getElementByIndexObject(order.first.getIndex());
				resultGraph.getElementByIndexObject(order.second.getIndex());
				ringFlag.put(order.first, order.second);
			} catch (NothingReturnedException e) {
				// first或second找不到的话，删除此order
				iterator.remove();
			}
		}
		
		if (orders.size() == 0) {
			return orderMap;
		}
	
		// 先检验序关系集合的合法性
		for (Tuple2<TypedEdge, TypedEdge> order : orders) {
	
			// 检测环冲突
			// 错因：不能直接tmp = order，否则order都变了
			Tuple2<TypedEdge, TypedEdge> tmp = new Tuple2<>(order.first, order.second);
			while (ringFlag.get(tmp.second) != null) {
				if (ringFlag.get(tmp.second).equals(order.first)) {
					throw new NothingReturnedException("强制序中有环冲突");
				}
				tmp.second = ringFlag.get(tmp.second);
			}
	
		}
	
		// 转换为HashMap
		for (Tuple2<TypedEdge, TypedEdge> order : orders) {
			orderMap.put(order.first, order.second);
		}
		return orderMap;
	}

}
