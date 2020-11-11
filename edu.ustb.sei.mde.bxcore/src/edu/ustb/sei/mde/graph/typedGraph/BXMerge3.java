package edu.ustb.sei.mde.graph.typedGraph;

import static org.junit.Assert.assertNotNull;

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

import org.chocosolver.solver.constraints.nary.cumulative.NRJCumulFilter;

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
import edu.ustb.sei.mde.graph.typedGraph.constraint.GraphConstraint;
import edu.ustb.sei.mde.structure.Tuple2;
import edu.ustb.sei.mde.structure.Tuple3;

public class BXMerge3 {
	
	/** 添加性合并 */
	public static TypedGraph additiveMerge(TypedGraph baseGraph, TypedGraph graph) {
		
		// result图为基本图的复制
		TypedGraph resultGraph = baseGraph.getCopy();
	
		// 对于第二个图graph中的新添加的ValueNode类型的节点n，直接扔到result图中
		long start = System.currentTimeMillis();
		graph.getAllValueNodes().forEach(n -> {
			resultGraph.addValueNode(n);
		});
		System.out.println("串行ValueNodes：" + (System.currentTimeMillis() - start));
	
		// 对于第二个图graph中的每个TypedNode类型的节点n
		start = System.currentTimeMillis();
		HashMap<TypedNode, TypedNode> changeTypedNodesMap = new HashMap<>();
		graph.getAllTypedNodes().forEach(n -> {
			try {
				// 根据n的索引查找result图中是否有相应的对象，如果找到则将其赋值给nr
				TypedNode nr = resultGraph.getElementByIndexObject(n.getIndex());
				// 如果nr==n，则不做处理
				// 如果nr!=n，则将nr替换为n。（说明节点被替换了，对象不同，但索引集合并了）
				if (nr != n) {
					resultGraph.replaceWith2(nr, n);
					changeTypedNodesMap.put(nr, n);
				}
			} catch (NothingReturnedException e) {
				// 如果根据n的索引在基本图中没有找到，说明n是第二个图graph中新添加的节点，则将其添加到result图中
				resultGraph.addTypedNode(n);
			}
		});
		System.out.println("串行TypedNodes: " + (System.currentTimeMillis() - start));
		
		
		// 把相邻边的处理拿到外面来
		start = System.currentTimeMillis();
		changeTypedNodesMap.forEach((nr, n) -> {
			if (nr != n) {
				TypeNode nodeType = n.getType();
				
				// 处理相邻的TypedEdge类型的边
				List<TypedEdge> removedTypedEdges = new ArrayList<TypedEdge>();
				resultGraph.allTypedEdges.replaceAll(e -> { // 对于result图中List<TypedEdge>的每个元素e
					TypeEdge edgeType = e.getType(); // 先获取e的type
					// 再根据edgeType可以获得sourceType和targetType
					TypeNode sourceType = edgeType.getSource();
					TypeNode targetType = edgeType.getTarget();

					if (e.getSource() == nr && e.getTarget() == nr) { // 1.如果e的source和target都是nr节点
						// 并且n的type(nodeType)是e的sourceType、targetType的子类型
						if (resultGraph.typeGraph.isSuperTypeOf(nodeType, sourceType)
								&& resultGraph.typeGraph.isSuperTypeOf(nodeType, targetType)) {
							TypedEdge res = new TypedEdge();
							res.setSource(n);
							res.setTarget(n);
							res.setType(edgeType);
							res.mergeIndex(e);
							resultGraph.reindexing(res);
							return res; // 将e替换为res
						} else { // 并且n的type不是e的sourceType |(&) targetType的子类型
							removedTypedEdges.add(e); // 将e添加到removedTypedEdges集合中
							resultGraph.clearIndex(e); // 将元素e的索引集和e的映射关系，从indexToObjectMap中清除
							return e; // 这里先暂时e->e
						}
					} else if (e.getSource() == nr) { // 2. 仅e的source是nr，e的target不是nr
						// 并且n的type(nodeType)是e的sourceType的子类型
						if (resultGraph.typeGraph.isSuperTypeOf(nodeType, sourceType)) {
							TypedEdge res = new TypedEdge();
							res.setSource(n);
							res.setTarget(e.getTarget());
							res.setType(edgeType);
							res.mergeIndex(e);
							resultGraph.reindexing(res);
							return res;
						} else { // 并且n的type不是e的sourceType的子类型
							removedTypedEdges.add(e);
							resultGraph.clearIndex(e);
							return e;
						}
					} else if (e.getTarget() == nr) { // 3. 仅e的target是nr，e的source不是nr
						// 并且n的type(nodeType)是e的targetType的子类型
						if (resultGraph.typeGraph.isSuperTypeOf(nodeType, targetType)) {
							TypedEdge res = new TypedEdge();
							res.setSource(e.getSource());
							res.setTarget(n);
							res.setType(edgeType);
							res.mergeIndex(e);
							resultGraph.reindexing(res);
							return res;
						} else { // 并且n的type(nodeType)不是e的targetType的子类型
							removedTypedEdges.add(e);
							resultGraph.clearIndex(e);
							return e;
						}
					} else // 4. e的source不是nr、target也不是nr
						return e;
				});
				resultGraph.allTypedEdges.removeAll(removedTypedEdges); // 集合操作removeAll()：A <- A-B，即从A集合中删除B集合
				
				
				
				// 处理相邻的ValueEdge类型的边
				List<ValueEdge> removedValueEdges = new ArrayList<ValueEdge>();
				resultGraph.allValueEdges.replaceAll(e -> { // 对于result图中List<ValueEdge>的每一个边e
					PropertyEdge edgeType = e.getType();
					TypeNode sourceType = edgeType.getSource();

					if (e.getSource() == nr) { // 如果e的source是nr
						// 并且n的type是e的sourceType的子类型，则将e替换为res
						if (resultGraph.typeGraph.isSuperTypeOf(nodeType, sourceType)) {
							ValueEdge res = new ValueEdge();
							res.setSource(n);
							res.setTarget(e.getTarget());
							res.setType(edgeType);
							res.mergeIndex(e);
							resultGraph.reindexing(res);
							return res;
						} else {
							// 并且n的type与nr的type不兼容，则删除e
							removedValueEdges.add(e);
							resultGraph.clearIndex(e);
							return e;
						}
					} else
						return e; // 如果e的source不是nr，则保留
				});
				resultGraph.allValueEdges.removeAll(removedValueEdges);
			}
		});
		System.out.println("串行处理相邻边: " + (System.currentTimeMillis() - start));
		
	
		// 对于第二个图graph中每个TypedEdge类型的边e
		start = System.currentTimeMillis();
		graph.getAllTypedEdges().forEach(e -> {
			try {
				// 根据e的索引，查找result图中的TypedEdge类型的边，如果找到则赋值给er
				TypedEdge er = resultGraph.getElementByIndexObject(e.getIndex());
				// 如果er==e，则不做处理；如果er!=e，则将er替换为e
				if (er != e) {
					resultGraph.replaceWith(er, e);
				}
			} catch (NothingReturnedException ex) {
				// 如果根据e的索引没有找到result图中的边，说明e是演化图中新添加的，则将其添加到result图中
				resultGraph.addTypedEdge(e);
			}
		});
		System.out.println("串行TypedEdges: " + (System.currentTimeMillis() - start));
		
	
		// 对于第二个图graph中每个ValueEdge类型的边e
		start = System.currentTimeMillis();
		graph.getAllValueEdges().forEach(e -> {
			try {
				// 根据e的索引，查找result图中的边，如果找到则赋值给er
				ValueEdge er = resultGraph.getElementByIndexObject(e.getIndex());
				// 如果er==e，则不做处理；如果er!=e，则将er替换为e
				if (er != e) {
					resultGraph.replaceWith(er, e);
				}
			} catch (NothingReturnedException ex) {
				// 如果根据e的索引没有找到result图中的边，说明e是graph图中新加的，则添加e到result图中
				resultGraph.addValueEdge(e);
			}
		});
		System.out.println("串行ValueEdges: " + (System.currentTimeMillis() - start));
	
		return resultGraph;
	}

	public static List<TypedEdge> twoOrder(TypedGraph baseGraph, TypedGraph aGraph, TypedGraph resultGraph) {
	
		List<TypedEdge> aList = aGraph.getAllTypedEdges();
		ArrayList<TypedEdge> mergeList = new ArrayList<>(aList); // 添加性合并中替换了也没有申请新对象
		List<TypedEdge> resultList = resultGraph.getAllTypedEdges();
		List<TypedEdge> baseList = baseGraph.getAllTypedEdges();
	
		// 删除merge中的不在result中的边（因为aList中存在的边不一定在resultList中）
		for (int i = 0; i < aList.size(); i++) {
			try {
				resultGraph.getElementByIndexObject(aList.get(i).getIndex());
			} catch (NothingReturnedException e) {
				mergeList.remove(aList.get(i));
			}
		}
	
		// 过滤后，如果merge.size() == result.size()，则直接返回merge
		if (mergeList.size() == resultList.size()) {
			return mergeList;
		}
	
		// 将baseList中原有的边添加进merge（即aList的删除操作无效）
		for (int i = 0; i < baseList.size(); i++) {
	
			try {
				aGraph.getElementByIndexObject(baseList.get(i).getIndex());
				// 能找到，跳过
				continue;
			} catch (NothingReturnedException e) {
				// 不能找到，说明要添加进aList
				int j = 0;
				for (j = 0; j < mergeList.size(); j++) {
					try {
						TypedEdge ebase = baseGraph.getElementByIndexObject(mergeList.get(j).getIndex());
						if (i - baseList.indexOf(ebase) > 0) {
							continue;
						} else {
							mergeList.add(j, baseList.get(i)); // 添加性合并中新加并没有申请新对象
							break;
						}
					} catch (NothingReturnedException e1) {
					}
				}
				// 若已经跑完mergeList，添加到mergeList队尾
				if (j == mergeList.size()) {
					mergeList.add(baseList.get(i));
				}
			}
		}
	
		return mergeList;
	}

	/** 多路合并 */
		public static TypedGraph merge_origin(TypedGraph baseGraph, TypedGraph... interSources) throws NothingReturnedException {
	
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
						} catch (Exception ex2) { // 根据e的索引没有找到result图中相应的对象，则应添加e到result图的allTypedEdges中
	
							TypedNode source = resultGraph.getElementByIndexObject(e.getSource().getIndex());
							TypedNode target = resultGraph.getElementByIndexObject(e.getTarget().getIndex());
	
							if (e.getSource() != source || e.getTarget() != target) { // 说明e的source或者target是基本图中有的，result图合并过三个图的索引，但不是同一对象
								TypedEdge ne = new TypedEdge();
								ne.setSource(source);
								ne.setTarget(target);
								ne.setType(e.getType());
								ne.mergeIndex(e);
								resultGraph.addTypedEdge(ne);
							} else // 说明e的source和target都是在分支图中新添加的TypedNode类型节点，所以在分支图和result图中是同一对象
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
	
			return resultGraph;
		}

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
						// simply add: 1) edge exists in all versions 2) edge in all branch versions is syntactically correct.
						resultGraph.simAddTypedEdge(edge);
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
						// simply add
						resultGraph.simAddValueEdge(edge);
					}
	
				} catch (NothingReturnedException e) {
					throw e;
				}
			}
			System.out.println("*******串行将不变和修改的ValueEdges添加到结果图中：" + Profiler.end() + "ms");
	
			// 新加TypedEdges
			Profiler.begin();
			int typedEdgeSize = resultGraph.allTypedEdges.size();
			for (TypedGraph image : interSources) {
				for (TypedEdge e : image.allTypedEdges) { // 对于分支图中每一个TypedEdge边e
					try { // 根据e的索引查找基本图中有无相应的对象，如果有则不做处理
						baseGraph.getElementByIndexObject(e.getIndex());
					} catch (Exception ex) { // 基本图中没有找到相应的对象
						TypedEdge re = null;
						try {
							// 根据e的索引查找result图中有无相应的对象，如果有则赋值给re
							re = resultGraph.getElementByIndexObject(e.getIndex());
						} catch (Exception ex2) { // 根据e的索引没有找到result图中相应的对象，则应添加e到result图的allTypedEdges中
	
							TypedNode source = resultGraph.getElementByIndexObject(e.getSource().getIndex());
							TypedNode target = resultGraph.getElementByIndexObject(e.getTarget().getIndex());
	
							if (e.getSource() != source || e.getTarget() != target) { // 说明e的source或者target是基本图中有的，result图合并过三个图的索引，但不是同一对象
								TypedEdge ne = new TypedEdge();
								ne.setSource(source);
								ne.setTarget(target);
								ne.setType(e.getType());
								ne.mergeIndex(e);
								resultGraph.addTypedEdge(ne, typedEdgeSize);
							} else // 说明e的source和target都是在分支图中新添加的TypedNode类型节点，所以在分支图和result图中是同一对象
								resultGraph.addTypedEdge(e, typedEdgeSize);
							re = null;
	
						} finally {
							// 根据e的索引找到了result图中相应的对象，并赋值给了re
							// 说明多个分支图添加了相同索引的边
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
			int valueEdgeSize = resultGraph.allValueEdges.size();
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
								resultGraph.addValueEdge(ne, valueEdgeSize);
								
							} else // e的source和result图中是同一对象，说明是新添加的TypedNode对象
								resultGraph.addValueEdge(e, valueEdgeSize);
	
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
		
		// 基础图原有的、分支图新加的ValueNodes
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
				// 多个分支图先分别和基本图作比较，baseNode的情况分别存储在nodeImages[i]中。可能是NULL、ANY、修改后的类型
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
					// simply add
					resultGraph.simAddTypedEdge(edge);
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
					// simply add
					resultGraph.simAddValueEdge(edge);
				}
	
			} catch (NothingReturnedException e) {
				e.printStackTrace();
			}
		});
		end = System.currentTimeMillis();
		System.out.println("*******parallelStream将不变和修改的ValueEdges添加到结果图中：" + (end - start) + "ms");
	
		
		resultGraph.allTypedEdges = allTypedEdges;
		int typedEdgeSize = resultGraph.allTypedEdges.size();
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
							resultGraph.addTypedEdge(ne, typedEdgeSize);	// 新加时，就不是simplyAdd了
							
						} else // 说明e的source和target是在分支图中新添加的TypedNode类型节点，所以在分支图和result图中是同一对象
							resultGraph.addTypedEdge(e, typedEdgeSize);
	
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
		int valueEdgeSize = resultGraph.allValueEdges.size();
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
							resultGraph.addValueEdge(ne, valueEdgeSize);
						} else // e的source和result图中是同一对象，说明是新添加的TypedNode对象
							resultGraph.addValueEdge(e, valueEdgeSize);
	
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
