package edu.ustb.sei.mde.graph.typedGraph;

/**
 * 串行合并，
 * 逐步构建结果图，
 * 效率提高更多了。
 */

import edu.ustb.sei.mde.bxcore.exceptions.NothingReturnedException;
import edu.ustb.sei.mde.graph.type.PropertyEdge;
import edu.ustb.sei.mde.graph.type.TypeEdge;
import edu.ustb.sei.mde.graph.type.TypeNode;
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
		TypedEdge[] typedEdgeImages = new TypedEdge[interSources.length];
		for (TypedEdge baseEdge : baseGraph.allTypedEdges) { // 对于基本图中每一个TypedEdge类型的边baseEdge

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
					resultGraph.addTypedEdge(edge);
				}

			} catch (NothingReturnedException e) {
				throw e; // 捕捉到异常后抛出
			}
		}
		System.out.println("*******串行将不变和修改的TypedEdges添加到结果图中：" + Profiler.end() + "ms");

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
			// 新加入的ValueEdge
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
						// ValueNode target = e.getTarget();

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

}
