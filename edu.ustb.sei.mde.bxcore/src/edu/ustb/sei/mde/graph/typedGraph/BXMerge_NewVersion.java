package edu.ustb.sei.mde.graph.typedGraph;

import java.io.ObjectOutputStream.PutField;
/**
 * 串行
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.naming.spi.DirStateFactory.Result;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter.DEFAULT;

import edu.ustb.sei.mde.bxcore.exceptions.NothingReturnedException;
import edu.ustb.sei.mde.bxcore.structures.Index;
import edu.ustb.sei.mde.graph.type.PropertyEdge;
import edu.ustb.sei.mde.graph.type.TypeEdge;
import edu.ustb.sei.mde.graph.type.TypeNode;
import edu.ustb.sei.mde.graph.typedGraph.constraint.GraphConstraint;
import edu.ustb.sei.mde.structure.Tuple2;
import edu.ustb.sei.mde.structure.Tuple3;

public class BXMerge_NewVersion {

	/** 添加性合并 */
	public static TypedGraph additiveMerge(TypedGraph first, TypedGraph graph) {
		// result图为基本图的复制
		TypedGraph result = first.getCopy();

		// 对于第二个图graph中的新添加的ValueNode类型的节点n，直接扔到result图中
		graph.getAllValueNodes().forEach(n -> {
			result.addValueNode(n);
		});

		// 对于第二个图graph中的每个TypedNode类型的节点n
		graph.getAllTypedNodes().forEach(n -> {
			try {
				// 根据n的索引查找result图中是否有相应的对象，如果找到则将其赋值给nr
				TypedNode nr = result.getElementByIndexObject(n.getIndex());
				// 如果nr==n，则不做处理
				// 如果nr!=n，则将nr替换为n。（说明节点被替换了，对象不同，但索引集合并了）
				if (nr != n) {
					result.replaceWith(nr, n);
				}
			} catch (NothingReturnedException e) {
				// 如果根据n的索引在基本图中没有找到，说明n是第二个图graph中新添加的节点，则将其添加到result图中
				result.addTypedNode(n);
			}
		});

		// 对于第二个图graph中每个TypedEdge类型的边e
		graph.getAllTypedEdges().forEach(e -> {
			try {
				// 根据e的索引，查找result图中的TypedEdge类型的边，如果找到则赋值给er
				TypedEdge er = result.getElementByIndexObject(e.getIndex());
				// 如果er==e，则不做处理；如果er!=e，则将er替换为e
				if (er != e) {
					result.replaceWith(er, e);
				}
			} catch (NothingReturnedException ex) {
				// 如果根据e的索引没有找到result图中的边，说明e是演化图中新添加的，则将其添加到result图中
				result.addTypedEdge(e);
			}
		});

		// 对于第二个图graph中每个ValueEdge类型的边e
		graph.getAllValueEdges().forEach(e -> {
			try {
				// 根据e的索引，查找result图中的边，如果找到则赋值给er
				ValueEdge er = result.getElementByIndexObject(e.getIndex());
				// 如果er==e，则不做处理；如果er!=e，则将er替换为e
				if (er != e) {
					result.replaceWith(er, e);
				}
			} catch (NothingReturnedException ex) {
				// 如果根据e的索引没有找到result图中的边，说明e是graph图中新加的，则添加e到result图中
				result.addValueEdge(e);
			}
		});

		result.order.merge(graph.order);

		result.constraint = GraphConstraint.and(first.constraint, graph.constraint);

		return result;
	}

	/** 多路合并 */
	public static TypedGraph merge(TypedGraph baseGraph, TypedGraph... branchGraphs) throws NothingReturnedException {

		TypedGraph resultGraph = baseGraph.getCopy();

		Thread addTypedNodesThread = new Thread(new Runnable(){
			@Override
			public void run() {
				Profiler.begin();
				// 新加TypedNodes
				for (TypedGraph branchGraph : branchGraphs) {
					for (TypedNode n : branchGraph.allTypedNodes) { // 对于分支图中每个TypedNode类型的节点n
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
					}
				}
				System.out.println("*****addTypedNodesThread: " + Profiler.end() + "ms");
			}
			
		});
		addTypedNodesThread.start();
		

		
		Thread addValueNodesThread = new Thread(new Runnable() {
			@Override
			public void run() {
				Profiler.begin();
				// 新加ValueNodes
				for (TypedGraph branch : branchGraphs) {
					branch.allValueNodes.forEach(v -> {
						resultGraph.addValueNode(v);
					});
				}
				System.out.println("*****addValueNodesThread: " + Profiler.end() + "ms");
			}
		});
		addValueNodesThread.start();
		
		
		
		// 变更TypedEdges
		HashMap<TypedEdge, Tuple3<TypedNode, TypedNode, TypeEdge>> changeTypedEdgeMap = new HashMap<>();
		Thread deleteTypedEdgesThread = new Thread(new Runnable() {
			@Override
			public void run() {
				Profiler.begin();
				TypedEdge[] typedEdgeImages = new TypedEdge[branchGraphs.length];
				for (TypedEdge baseEdge : baseGraph.allTypedEdges) { // 对于基本图中每一个TypedEdge类型的边baseEdge

					// 多个分支图先分别和基本图作比较，baseEdge的情况分别存储在typedEdgeImages[i]中，可能是baseEdge、imageEdge、null
					for (int i = 0; i < branchGraphs.length; i++) {
						typedEdgeImages[i] = TypedGraph.computeImage(baseEdge, baseGraph, branchGraphs[i]);
					}

					try {
						// 再根据typedEdgeImages[]中的情况，确定finalEdgeInfo
						Tuple3<TypedNode, TypedNode, TypeEdge> finalEdgeInfo = TypedGraph.computeEdge(baseEdge,
								typedEdgeImages);

						if (finalEdgeInfo == null) {
							resultGraph.remove(baseEdge);
						} else {
							// 基础图与各个分支图的baseEdge一致；或者不同分支图中做了修改但相互兼容
							changeTypedEdgeMap.put(baseEdge, finalEdgeInfo);
						}
					} catch (NothingReturnedException e) {
						e.printStackTrace();
					}
				}
				System.out.println("*****deleteTypedEdgesThread: " + Profiler.end() + "ms");
			}
		});
		deleteTypedEdgesThread.start();
		
		// 需要等新加的TypedNodes执行完、以及得到changeTypedEdgeMap后
		Thread changeTypedEdgesThread = new Thread(new Runnable() {
			@Override
			public void run() {
				Profiler.begin();
				try {
					addTypedNodesThread.join();
					deleteTypedEdgesThread.join();
				} catch (InterruptedException e1) {
				}
				changeTypedEdgeMap.forEach((key,value) -> {
					try {
						TypedNode source = resultGraph.getElementByIndexObject(value.first.getIndex());
						TypedNode target = resultGraph.getElementByIndexObject(value.second.getIndex());
						TypedEdge edge = new TypedEdge(); // 新申请的对象edge
						edge.setSource(source);
						edge.setTarget(target);
						edge.setType(value.third);
						
						for (TypedGraph image : branchGraphs) { // 合并两个分支的索引集
							edge.mergeIndex(image.getElementByIndexObject(key.getIndex()));
						}
						
						resultGraph.replaceWith(key, edge); // 将baseEdge替换为edge
						
					} catch (NothingReturnedException e) {
						e.printStackTrace();
					}
				});
				System.out.println("*****changeTypedEdgesThread: " + Profiler.end() + "ms");
			}
		});
		changeTypedEdgesThread.start();
		
		
		
		// 变更ValueEdges
		HashMap<ValueEdge, Tuple3<TypedNode, ValueNode, PropertyEdge>> changeValueEdgeMap = new HashMap<>();
		Thread deleteValueEdgesThread = new Thread(new Runnable() {
			@Override
			public void run() {
				Profiler.begin();
				ValueEdge[] valueEdgeImages = new ValueEdge[branchGraphs.length];
				for (ValueEdge baseEdge : baseGraph.allValueEdges) { // 对于基本图中每一个条ValueEdge类型的边
					// 两个分支图先和基本图作比较，baseEdge的情况分别存储在valueEdgeImages[]中，可能是null、baseEdge、imageEdge
					for (int i = 0; i < branchGraphs.length; i++) {
						valueEdgeImages[i] = TypedGraph.computeImage(baseEdge, baseGraph, branchGraphs[i]);
					}

					try {
						// 再根据valueEdgeImages[]中的情况，确定finalEdgeInfo
						Tuple3<TypedNode, ValueNode, PropertyEdge> finalEdgeInfo = TypedGraph.computeEdge(baseEdge,
								valueEdgeImages);

						if (finalEdgeInfo == null) {
							resultGraph.remove(baseEdge);
						} else {
							// 基础图与各个分支图的baseEdge一致；或者不同分支图中做了修改但相互兼容
							changeValueEdgeMap.put(baseEdge, finalEdgeInfo);
						}
					} catch (NothingReturnedException e) {
						e.printStackTrace();
					}
				}
				System.out.println("*****deleteValueEdgesThread: " + Profiler.end() + "ms");
			}
		});
		deleteValueEdgesThread.start();
		
		// 需要等新加的TypedNodes执行完、以及得到changeValueEdgeMap后
		Thread changeValueEdgesThread = new Thread(new Runnable() {
			@Override
			public void run() {
				Profiler.begin();
				try {
					addTypedNodesThread.join();
					deleteValueEdgesThread.join();
				} catch (InterruptedException e) {
				}
				changeValueEdgeMap.forEach((key, value) -> {
					try {
						TypedNode source = resultGraph.getElementByIndexObject(value.first.getIndex());
						ValueNode target = value.second;
						ValueEdge edge = new ValueEdge();
						edge.setSource(source);
						edge.setTarget(target);
						edge.setType(value.third);
			
						for (TypedGraph image : branchGraphs) {
							edge.mergeIndex(image.getElementByIndexObject(key.getIndex()));
						}
						resultGraph.replaceWith(key, edge);
					} catch (NothingReturnedException e) {
						e.printStackTrace();
					}
				});		
				System.out.println("*****changeValueEdgesThread: " + Profiler.end() + "ms");
			}
		});
		changeValueEdgesThread.start();
		
		

	
		// 变更TypedNodes，	需要等新加TypedNodes执行完
		HashMap<TypedNode, TypedNode> changeTypedNodesMap = new HashMap<>();
		ArrayList<TypedNode> deleteTypedNodesList = new ArrayList<>();
		Thread changeTypedNodesThread = new Thread(new Runnable() {
			@Override
			public void run() {
				Profiler.begin();
				try {
					addTypedNodesThread.join();
				} catch (InterruptedException e) {
				}
				TypeNode[] nodeImages = new TypeNode[branchGraphs.length]; // 比如length=2
				for (TypedNode baseNode : baseGraph.allTypedNodes) { // 对于基本图中每一个TypedNode节点

					for (int i = 0; i < branchGraphs.length; i++) {
						// 两个分支图先分别和基本图作比较，baseNode的情况分别存储在nodeImages[i]中。可能是NULL、ANY、修改后的类型
						nodeImages[i] = TypedGraph.computeImage(baseNode, baseGraph, branchGraphs[i]);
					}

					try {
						// 再根据nodeImages[]中的情况，确定baseNode的finalType
						TypeNode finalType = TypedGraph.computeType(nodeImages, baseGraph.getTypeGraph());

						if (finalType == TypeNode.NULL_TYPE) { // 在某一分支中删除或两个分支都删除，则在result图中也删除
							deleteTypedNodesList.add(baseNode);
							resultGraph.remove2(baseNode);	// 暂时只删除节点，还未处理相邻边
						} else {

							if (finalType == TypeNode.ANY_TYPE) // 此节点在两个分支图和基本图中的类型一致
								finalType = baseNode.getType();

							TypedNode n = new TypedNode(); // 新申请的节点
							n.setType(finalType); // 设置新节点n的类型：和基本图中一样的类型或是替换后的类型
							for (TypedGraph branch : branchGraphs) {
								// 将新节点n和两个分支图中对应的baseNode的索引集合并
								n.mergeIndex(branch.getElementByIndexObject(baseNode.getIndex()));
							}
							// 将result图中的baseNode替换为n；这里可能在result图中替换或删除相邻边
							resultGraph.replaceWith2(baseNode, n);	// 暂时只替换节点，还未处理相邻边
							changeTypedNodesMap.put(baseNode, n);
						}

					} catch (NothingReturnedException e) {
						e.printStackTrace();
					}
				}
				System.out.println("*****changeTypedNodesThread: " + Profiler.end() + "ms");
			}
		});
		changeTypedNodesThread.start();
		
		// 处理相邻的TypedEdge边
		// 等TypedEdge修改完、以及得到deleteTypedNodesList和changeTypedNodesMap后
		Thread adjacentTypedEdgesThread = new Thread(new Runnable() {
			@Override
			public void run() {
				Profiler.begin();
				try {
					changeTypedEdgesThread.join();
					changeTypedNodesThread.join();
				} catch (InterruptedException e) {
				}
				
				deleteTypedNodesList.forEach(n -> {
					// 如果此节点还是某条TypedEdge类型边e的source或target端点，删除这条边e
					for (int i = resultGraph.allTypedEdges.size() - 1; i >= 0; i--) {
						TypedEdge e = resultGraph.allTypedEdges.get(i);
						if (resultGraph.isEqual(e.getSource(), n) || resultGraph.isEqual(e.getTarget(), n)) {
							resultGraph.allTypedEdges.remove(i);
							resultGraph.clearIndex(e);
						}
					}
				});
				
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
					}
				});
				System.out.println("*****adjacentTypedEdgesThread: " + Profiler.end() + "ms");
			}
		});
		adjacentTypedEdgesThread.start();

		// 处理相邻的ValueEdge边
		// 等ValueEdge修改完、以及得到deleteTypedNodesList和changeTypedNodesMap后
		Thread adjacentValueEdgesThread = new Thread(new Runnable() {
			@Override
			public void run() {
				Profiler.begin();
				try {
					changeValueEdgesThread.join();
					changeTypedNodesThread.join();
				} catch (InterruptedException e) {
				}
				
				deleteTypedNodesList.forEach(n -> {
					// 如果此节点还是某条ValueEdge类型边e的source端点，删除这条边e
					for (int i = resultGraph.allValueEdges.size() - 1; i >= 0; i--) {
						ValueEdge e = resultGraph.allValueEdges.get(i);
						if (resultGraph.isEqual(e.getSource(), n)) {
							resultGraph.allValueEdges.remove(i);
							resultGraph.clearIndex(e);
						}
					}
				});
				
				changeTypedNodesMap.forEach((nr, n) -> {
					if(nr != n) {
						TypeNode nodeType = n.getType();
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
				System.out.println("*****adjacentValueEdgesThread: " + Profiler.end() + "ms");
			}
		});
		adjacentValueEdgesThread.start();
		
		
		
		// 新加TypedEdges
		// 等TypedNode的新加、删除、替换执行完（相邻TypedEdge边也处理完了）
		Thread addTypedEdgesThread = new Thread(new Runnable() {
			@Override
			public void run() {
				Profiler.begin();
				try {
					addTypedNodesThread.join();
					adjacentTypedEdgesThread.join();
				} catch (InterruptedException e) {
				}
				
				for (TypedGraph image : branchGraphs) {
					for (TypedEdge e : image.allTypedEdges) { // 对于分支图中每一个TypedEdge边e
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
								
								if (e.getSource() != source || e.getTarget() != target) { // 说明e的source或者target是基本图中有的，result图合并过三个图的索引，但不是同一对象
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
										}catch (NothingReturnedException e2) {
											e2.printStackTrace();
										}
									} else {
										re.mergeIndex(e);
										resultGraph.reindexing(re); // lyt修改
									}
								}
							}
						}
					}
				}
				System.out.println("*****addTypedEdgesThread: " + Profiler.end() + "ms");
			}
		});
		addTypedEdgesThread.start();
		
		
		
		// 新加ValueEdges
		// 等TypedNode的新加、删除、替换执行完（相邻的ValueEdge边处理完），等ValueNode的新加执行完
		Thread addValueEdgesThread = new Thread(new Runnable() {
			@Override
			public void run() {
				Profiler.begin();
				try {
					addTypedNodesThread.join();
					addValueNodesThread.join();
					adjacentValueEdgesThread.join();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				for (TypedGraph image : branchGraphs) {
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

								TypedNode source = null;
								try {
									source = resultGraph.getElementByIndexObject(e.getSource().getIndex());
								} catch (NothingReturnedException e1) {
									e1.printStackTrace();
								}
//										ValueNode target = e.getTarget();

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
					}
				}
				System.out.println("*****addValueEdgesThread: " + Profiler.end() + "ms");
			}
		});
		addValueEdgesThread.start();
		
		OrderInformation[] orders = new OrderInformation[branchGraphs.length];
		for (int i = 0; i < branchGraphs.length; i++)
			orders[i] = branchGraphs[i].order;
		resultGraph.order.merge(orders); // 将orders[i]合并到result的order中

		List<GraphConstraint> cons = new ArrayList<>();
		cons.add(baseGraph.getConstraint());
		for (TypedGraph g : branchGraphs) {
			cons.add(g.constraint);
		}
		resultGraph.constraint = GraphConstraint.and(cons);
		// check

		try {
			addTypedEdgesThread.join();
			addValueEdgesThread.join();
		} catch (InterruptedException e) {
		}
		
		return resultGraph;
	}

	/** 二向合并的序 */
	public static List<TypedEdge> twoOrder_origin(TypedGraph baseGraph, TypedGraph aGraph, TypedGraph resultGraph) {

		List<TypedEdge> base = baseGraph.getAllTypedEdges();
		System.out.println("base: " + base);

		List<TypedEdge> a = aGraph.getAllTypedEdges();
		System.out.println("a: " + a);

		List<TypedEdge> result = resultGraph.getAllTypedEdges();
		System.out.println("result: " + result);

		int round = 1;

		List<TypedEdge> merge = new ArrayList<>();

		// 遍历a中元素，如果根据索引不能在resultGraph中找到，则不会添加进merge
		for (int i = 0; i < a.size(); i++) {

			try {
				// merge以a初始化
				resultGraph.getElementByIndexObject(a.get(i).getIndex());
				merge.add(a.get(i));

			} catch (NothingReturnedException e) {

			}

		}

		Map<Index, Integer> baseFlag = new HashMap<>();
		for (int i = 0; i < base.size(); i++) {
			baseFlag.put(base.get(i).getIndex(), i);
		}

		// 遍历base中的每个元素
		for (int i = 0; i < base.size(); i++) {

			try {
				// 如果根据base.get(i)的索引能在aGraph中找到，则跳过
				aGraph.getElementByIndexObject(base.get(i).getIndex());
				continue;

			} catch (NothingReturnedException e) { // 如果在aGraph中不能找到，说明要添加到merge中

				int j;
				for (j = 0; j < merge.size(); j++) {

					try {
						// 如果根据merge(j)的索引在baseGraph中找到了，则有以下操作
						baseGraph.getElementByIndexObject(merge.get(j).getIndex());

						int tmp = baseFlag.get(merge.get(j).getIndex()) - baseFlag.get(base.get(i).getIndex());

						if (tmp < 0) {
							continue;
						} else {
							merge.add(j, base.get(i));
							System.out.println("回合" + round++ + merge);
							break;
						}

					} catch (NothingReturnedException e2) {
						// 如果根据merge(j)的索引在baseGraph中没找到，则跳过
						// continue; //可以不写
					}

				}

				if (j == merge.size()) {
					merge.add(j, base.get(i));
					System.out.println("回合" + round++ + merge);
				}

			}

		}

		System.out.println("*************最终的序: \n" + merge);
		return merge;

	}

	public static ArrayList<TypedEdge> twoOrder(List<TypedEdge> baseList, List<TypedEdge> aList, List<TypedEdge> resultList) {

		HashMap<Index, Integer> resultFlag = new HashMap<>();
		for (int i = 0; i < resultList.size(); i++) {
			resultFlag.put(resultList.get(i).getIndex(), i);
		}

		ArrayList<TypedEdge> merge = new ArrayList<>(aList); // mergeList复制aList

		// 删除merge中的不在result中的边
		for (int i = 0; i < aList.size(); i++) {
			if (resultFlag.get(aList.get(i).getIndex()) != null) {
				continue;
			}
			merge.remove(aList.get(i));
		}

		// 过滤后，如果merge.size() == result.size()，则直接返回merge
		if (merge.size() == resultList.size()) {
			return merge;
		}

		HashMap<Index, Integer> baseFlag = new HashMap<>();
		for (int i = 0; i < baseList.size(); i++) {
			baseFlag.put(baseList.get(i).getIndex(), i);
		}

		HashMap<Index, Integer> mergeFlag = new HashMap<>();
		for (int i = 0; i < merge.size(); i++) {
			mergeFlag.put(merge.get(i).getIndex(), i);
		}

		// 将baseList中原有的边添加进merge（即aList的删除操作无效）
		// 注意，添加性合并中resultList并没有重新申请边对象去合并索引集
		for (int i = 0; i < baseList.size(); i++) {

			// 如果能在merge中找到，则跳过
			if (mergeFlag.get(baseList.get(i).getIndex()) != null) {
				continue;
			}
			// 如果不能找到，说明要添加进merge
			int baseDistance = 0;
			int j;
			for (j = 0; j < merge.size(); j++) {
				try {
					baseDistance = i - baseFlag.get(merge.get(j).getIndex());
					// 如果能在base中找到，则根据baseDistance确定插入位置
					if (baseDistance > 0) {
						continue;
					}
					merge.add(j, baseList.get(i));
					break;
				} catch (NullPointerException e2) {
					// 如果merge中的元素不能在base中找到，则跳过
				}
			}

			// 若已经跑完mergeList，添加到merge队尾
			if (j == merge.size()) {
				merge.add(baseList.get(i));
			}

		}

		return merge;
	}

	public static List<TypedEdge> twoOrder2(TypedGraph baseGraph, TypedGraph aGraph, TypedGraph resultGraph) {

		List<TypedEdge> aList = aGraph.getAllTypedEdges();
		ArrayList<TypedEdge> mergeList = new ArrayList<>(aList);	//添加性合并中替换了也没有申请新对象
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
						if(i - baseList.indexOf(ebase) > 0) {
							continue;
						}else {
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

	/** 用了HashMap<Index, Integer> */
	public static List<TypedEdge> threeOrder_origin(TypedGraph baseGraph, TypedGraph aGraph, TypedGraph bGraph,
			TypedGraph resultGraph) {

		List<TypedEdge> base = baseGraph.getAllTypedEdges();
		System.out.println("base: " + base);

		List<TypedEdge> a = aGraph.getAllTypedEdges();
		System.out.println("a: " + a);

		List<TypedEdge> b = bGraph.getAllTypedEdges();
		System.out.println("b: " + b);

		List<TypedEdge> result = resultGraph.getAllTypedEdges();
		System.out.println("result: " + result);

		List<TypedEdge> merge = new ArrayList<>();
		boolean flag = true;
		int round = 1; // 回合计数

		Map<Index, Integer> aFlag = new HashMap<>();
		for (int i = 0; i < a.size(); i++) {
			aFlag.put(a.get(i).getIndex(), i);
		}

		Map<Index, Integer> bFlag = new HashMap<>();
		for (int i = 0; i < b.size(); i++) {
			bFlag.put(b.get(i).getIndex(), i);
		}

		// 对于base中每个元素
		for (int i = 0; i < base.size(); i++) {

			try {
				// 根据base.get(i)的索引查找resultGraph，如果找到，则赋给element
				TypedEdge element = resultGraph.getElementByIndexObject(base.get(i).getIndex());

				if (flag == false) { // 非第一次执行

					// 之后用于：如果根据base.get(j)的索引在mergeFlag中已经是front了，则不用动
					Map<TypedEdge, String> mergeFlag = new HashMap<>();
					int position = merge.indexOf(element);
					for (int k = 0; k < position; k++) {
						mergeFlag.put(merge.get(k), "front");
					}

					for (int j = i + 1; j < base.size(); j++) {

						try {
							// 根据base.get(j)索引在resultGraph中查找，如果找到则赋给re
							TypedEdge re = resultGraph.getElementByIndexObject(base.get(j).getIndex());

							int aSubtract = aFlag.get(base.get(i).getIndex()) - aFlag.get(base.get(j).getIndex());

							int bSubtract = bFlag.get(base.get(i).getIndex()) - bFlag.get(base.get(j).getIndex());

							if (aSubtract < 0 && bSubtract < 0) {
								continue;
							} else {

								if (mergeFlag.get(re) == "front") {
									continue;
								} else {
									System.out.println("****************remove前：" + merge);
									merge.remove(re);
									System.out.println("****************remove后：" + merge);
									merge.add(merge.indexOf(element), re);
									System.out.println("****************add后：" + merge);
								}

							}

						} catch (NothingReturnedException e) { // 如果根据base.get(j)的索引在resultGraph中没找到，则跳过
							continue;
						}

					}

				} else { // 第一次执行

					merge.add(element);
					flag = false;

					for (int j = i + 1; j < base.size(); j++) {

						try {
							// 根据base.get(j)索引在resultGraph中查找，如果找到则赋给re
							TypedEdge re = resultGraph.getElementByIndexObject(base.get(j).getIndex());

							int aSubtract = aFlag.get(base.get(i).getIndex()) - aFlag.get(base.get(j).getIndex());

							int bSubtract = bFlag.get(base.get(i).getIndex()) - bFlag.get(base.get(j).getIndex());

							if (aSubtract < 0 && bSubtract < 0) {
								merge.add(re);
							} else {
								merge.add(merge.indexOf(element), re);
							}

						} catch (NothingReturnedException e) { // 如果根据base.get(j)的索引在resultGraph中没找到，则跳过
							continue;
						}
					}

				}

			} catch (NothingReturnedException e) { // 如果根据base.get(i)索引在resultGraph中没找到，则跳过
				continue;
			}

			System.out.println("回合" + round++ + "merge: " + merge);

		}

		// 保留一下【此时】的merge，用于处理b分支新添加的元素的if条件
		// 是否可优化？？
		List<TypedEdge> intermediate = new ArrayList<>();
		intermediate.addAll(merge);

		// 处理a中新添加的元素
		for (int i = 0; i < a.size(); i++) {

			// 对于a中每个元素，如果不在baseGraph中但在resultGraph中，说明是新添加的元素
			try {
				// 如果在baseGraph中，则跳过
				baseGraph.getElementByIndexObject(a.get(i).getIndex());
				continue;
			} catch (NothingReturnedException e) { // 如果不在baseGraph中

				try {
					// 如果不在baseGraph中但在resultGraph中，则有以下操作
					TypedEdge element = resultGraph.getElementByIndexObject(a.get(i).getIndex());

					int k;
					for (k = 0; k < merge.size(); k++) {
						int tmp = aFlag.get(merge.get(k).getIndex()) - aFlag.get(a.get(i).getIndex());
						if (tmp < 0) {
							continue;
						} else {
							merge.add(k, element);
							break;
						}
					}

					if (k == merge.size()) {
						merge.add(element);
					}

					System.out.println("处理a中一个新添加的元素后，merge: " + merge);

				} catch (NothingReturnedException e1) {
					// 如果不在baseGraph中又不在resultGraph中，则跳过
					continue;
				}

			}

		}

		// 处理b中新添加的元素
		for (int i = 0; i < b.size(); i++) {

			// 对于b中每个元素，如果不在baseGraph中但在resultGraph中，说明是新添加的元素。
			try {
				baseGraph.getElementByIndexObject(b.get(i).getIndex());
				continue;
			} catch (NothingReturnedException e) {

				// 如果不在baseGraph中,但在resultGraph中，则有以下操作
				try {
					TypedEdge element = resultGraph.getElementByIndexObject(b.get(i).getIndex());
					int k;
					for (k = 0; k < merge.size(); k++) {

						if (!intermediate.contains(merge.get(k))) {
							continue; // 说明是merge中添加进的a分支中的新元素
						}

						int tmp = bFlag.get(merge.get(k).getIndex()) - bFlag.get(b.get(i).getIndex());
						if (tmp < 0) {
							continue;
						} else {
							merge.add(k, element);
							break;
						}
					}

					if (k == merge.size()) {
						merge.add(element);
					}

					System.out.println("处理b中一个新添加的元素后，merge: " + merge);

				} catch (NothingReturnedException e1) {
					continue;
				}
			}
		}

		System.out.println("\n处理完序后，merge: " + merge);

		return merge;
	}

	/* 输入不用传入TypedGraph了 */
	public static ArrayList<TypedEdge> threeOrder(List<TypedEdge> baseTypedEdges, List<TypedEdge> aTypedEdges,
			List<TypedEdge> bTypedEdges, List<TypedEdge> resultTypedEdges) {

		List<TypedEdge> base = baseTypedEdges;
		System.out.println("base: " + base);

		List<TypedEdge> a = aTypedEdges;
		System.out.println("a: " + a);

		List<TypedEdge> b = bTypedEdges;
		System.out.println("b: " + b);

		List<TypedEdge> result = resultTypedEdges;
		System.out.println("result: " + result);

//		ArrayList<TypedEdge> merge = (ArrayList<TypedEdge>) result.clone(); // 具有相同内容的不同对象
		ArrayList<TypedEdge> merge = new ArrayList<>(result);

		HashMap<Index, Integer> baseFlag = new HashMap<>();
		for (int i = 0; i < base.size(); i++) {
			baseFlag.put(base.get(i).getIndex(), i);
		}

		HashMap<Index, Integer> aFlag = new HashMap<>();
		for (int i = 0; i < a.size(); i++) {
			aFlag.put(a.get(i).getIndex(), i);
		}

		HashMap<Index, Integer> bFlag = new HashMap<>();
		for (int i = 0; i < b.size(); i++) {
			bFlag.put(b.get(i).getIndex(), i);
		}

		for (int i = 0; i < result.size() - 1; i++) {
			for (int j = i + 1; j < result.size(); j++) {
				int mergeDistance = 0; // 用于判断：如果已经是大于，则不用放到紧前
				int aDistance = 0;
				int bDistance = 0;
				int baseDistance = 0;
				try {
					mergeDistance = merge.indexOf(result.get(i)) - merge.indexOf(result.get(j));
					aDistance = aFlag.get(result.get(i).getIndex()) - aFlag.get(result.get(j).getIndex());
					bDistance = bFlag.get(result.get(i).getIndex()) - bFlag.get(result.get(j).getIndex());
					baseDistance = baseFlag.get(result.get(i).getIndex()) - baseFlag.get(result.get(j).getIndex());

					if ((aDistance < 0 && bDistance < 0) || (aDistance < 0 && bDistance > 0 && baseDistance > 0)
							|| (aDistance > 0 && bDistance < 0 && baseDistance > 0)) {
						continue;
					} else {
						// 最后merge中为<ej, ei>
						if (mergeDistance > 0) {
							continue;
						}
						TypedEdge re = result.get(j);
						merge.remove(re);
						merge.add(merge.indexOf(result.get(i)), re);
					}

				} catch (NullPointerException e) {
					if (aDistance == 0) {
						try {
							bDistance = bFlag.get(result.get(i).getIndex()) - bFlag.get(result.get(j).getIndex());
							if (bDistance < 0) {
								continue;
							}
							// 最后merge中为<ej, ei>
							if (mergeDistance > 0) {
								continue;
							}
							TypedEdge re = result.get(j);
							merge.remove(re);
							merge.add(merge.indexOf(result.get(i)), re);
						} catch (NullPointerException e2) {
							continue;
						}
					} else if (bDistance == 0) {
						if (aDistance < 0) {
							continue;
						}
						// 最后merge中为<ej, ei>
						if (mergeDistance > 0) {
							continue;
						}
						TypedEdge re = result.get(j);
						merge.remove(re);
						merge.add(merge.indexOf(result.get(i)), re);
					}
				}
			}
		}
		return merge;
	}

	// 适用于多图的序关系
	public static List<TypedEdge> threeOrder2(TypedGraph baseGraph, TypedGraph resultGraph,
			TypedGraph... branchGraphs) {

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

		List<TypedEdge> resultList = resultGraph.getAllTypedEdges();
		List<TypedEdge> mergeList = new ArrayList<>(resultList);

		for (int i = 0; i < resultList.size() - 1; i++) {
			for (int j = i + 1; j < resultList.size(); j++) {
				for (int k = 0; k < len; k++) {
					try {
						TypedEdge efirst = branchGraphs[k].getElementByIndexObject(resultList.get(i).getIndex());
						TypedEdge esecond = branchGraphs[k].getElementByIndexObject(resultList.get(j).getIndex());
						if (branchFlag[k].get(efirst) - branchFlag[k].get(esecond) < 0) {
							continue;
						} else {
							// 实际上，resultList隐含了baseList的序信息
							if (mergeList.indexOf(resultList.get(i)) > mergeList.indexOf(resultList.get(j))) {
							continue;
							} else {
								TypedEdge re = resultList.get(j);
								mergeList.remove(re);
								mergeList.add(mergeList.indexOf(resultList.get(i)), re);
								break;
							}
							
							
//							try {
//								TypedEdge efirstBase = baseGraph.getElementByIndexObject(resultList.get(i).getIndex());
//								TypedEdge esecondBase = baseGraph.getElementByIndexObject(resultList.get(j).getIndex());
//								// 在基图中能找到，视基图的情况而定
//								int first = baseFlag.get(efirstBase);
//								int second = baseFlag.get(esecondBase);
//								if (first - second < 0) {
//									if (mergeList.indexOf(resultList.get(i)) > mergeList.indexOf(resultList.get(j))) {
//										continue;
//									} else {
//										TypedEdge re = resultList.get(j);
//										mergeList.remove(re);
//										mergeList.add(mergeList.indexOf(resultList.get(i)), re);
//										break;
//									}
//								}
//							
//							} catch (NothingReturnedException e) {
//								// 在基图中不能找到，说明是新加的
//								if (mergeList.indexOf(resultList.get(i)) > mergeList.indexOf(resultList.get(j))) {
//									continue;
//								} else {
//									TypedEdge re = resultList.get(j);
//									mergeList.remove(re);
//									mergeList.add(mergeList.indexOf(resultList.get(i)), re);
//									break;
//								}
//							}
						}

					} catch (NothingReturnedException e) {
						// 说明不是此分支新加的，跳过
						// 还有一种情况是分支图只有新添元素自己，则此元素的序随意
					}
				}
			}
		}
		return mergeList;
	}

	// 处理强制序关系
	public static List<TypedEdge> forceOrder(List<TypedEdge> mergeList, Set<Tuple2<Index, Index>> orders)
			throws NothingReturnedException {

		// helper用于判断有无其它冲突
		Map<Index, Integer> helper = new HashMap<>();
		for (int i = 0; i < mergeList.size(); i++) {
			helper.put(mergeList.get(i).getIndex(), 0);
		}

		// ringFlag用于判断有无环冲突
		HashMap<Index, Index> ringFlag = new HashMap<>();
		Iterator<Tuple2<Index, Index>> iterator = orders.iterator();
		while (iterator.hasNext()) {
			Tuple2<Index, Index> order = iterator.next();
			if (helper.get(order.first) != null && helper.get(order.second) != null) {
				ringFlag.put(order.first, order.second);
			} else {
				// first或second找不到的话，删除此order
				iterator.remove();
			}
		}

		// 先检验序关系集合的合法性
		for (Tuple2<Index, Index> order : orders) {

			int firstHelper = helper.get(order.first);
			int secondHelper = helper.get(order.second);

			switch (firstHelper) {
			case 0:
				helper.replace(order.first, 1); // 改成1
				break;
			case 1:
				throw new NothingReturnedException("强制序中有<x, y>&&<x, z>冲突");
			default:
				// 当first为2时，不会更新！
				break;
			}

			switch (secondHelper) {
			case 0:
				helper.replace(order.second, 2); // 改成2
				break;
			case 2:
				throw new NothingReturnedException("强制序中有<y, x>&&<z, x>冲突");
			default:
				// 当second为1时，不会更新！
				break;
			}

			// 检测环冲突
			Tuple2<Index, Index> tmp = new Tuple2<>(order.first, order.second); // 错因：不能直接tmp = order，否则order都变了
			while (ringFlag.get(tmp.second) != null) {
				if (ringFlag.get(tmp.second).equals(order.first)) {
					throw new NothingReturnedException("强制序中有环冲突");
				}
				tmp.second = ringFlag.get(tmp.second);
			}

		}

		// 合法后，再执行强制序
		for (Tuple2<Index, Index> order : orders) {

			HashMap<Index, Integer> mergeFlag = new HashMap<>();
			// 每次循环里都要重新更新mergeFlag
			for (int i = 0; i < mergeList.size(); i++) {
				mergeFlag.put(mergeList.get(i).getIndex(), i);
			}

			// Index类的hashCode()和equals()重写了，只要Index对象的内部索引集有交集，就能找到
			int firstPosition = mergeFlag.get(order.first);
			int secondPosition = mergeFlag.get(order.second);

			// 有此判断，可减少不必要操作
			if (secondPosition == firstPosition + 1)
				continue;

			TypedEdge front = mergeList.get(firstPosition);
			TypedEdge back = mergeList.get(secondPosition);

			// 如果helper中first为1，second为2，则front不动（默认）
			// 如果helper中first为2，second为2，则front也不动
			if (helper.get(order.first) == 1 && helper.get(order.second) == 2
					|| helper.get(order.first) == 2 && helper.get(order.second) == 2) {
				mergeList.remove(back);
				mergeList.add(mergeList.indexOf(front) + 1, back);
			}
			// 如果helper中first为1，second为1，则back不动
			else if (helper.get(order.first) == 1 && helper.get(order.second) == 1) {
				mergeList.remove(front);
				mergeList.add(mergeList.indexOf(back), front);
			}

			// 如果helper中first为2，second为1，则<back, back+1>不动
			// 将<front-1, front>移到其前面
			else if (helper.get(order.first) == 2 && helper.get(order.second) == 1) {
				TypedEdge previousFront = mergeList.get(firstPosition - 1);
				mergeList.remove(previousFront);
				mergeList.remove(front);
				mergeList.add(mergeList.indexOf(back), previousFront);
				mergeList.add(mergeList.indexOf(back), front);
			}

		}

		return mergeList;
	}

	// 用getElementByIndexObject()
	public static List<TypedEdge> forceOrder2(List<TypedEdge> mergeList, Set<Tuple2<TypedEdge, TypedEdge>> orders,
			TypedGraph resultGraph) throws NothingReturnedException {

		// helper用于判断有无其它冲突
		Map<TypedEdge, Integer> helper = new HashMap<>();
		for (int i = 0; i < mergeList.size(); i++) {
			helper.put(mergeList.get(i), 0);
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

		// 先检验序关系集合的合法性
		for (Tuple2<TypedEdge, TypedEdge> order : orders) {

			TypedEdge efirst = resultGraph.getElementByIndexObject(order.first.getIndex());
			TypedEdge esecond = resultGraph.getElementByIndexObject(order.second.getIndex());

			int firstHelper = helper.get(efirst);
			int secondHelper = helper.get(esecond);

			switch (firstHelper) {
			case 0:
				helper.replace(efirst, 1); // 改成1
				break;
			case 1:
				throw new NothingReturnedException("强制序中有<x, y>&&<x, z>冲突");
			default:
				// 当first为2时，不会更新！
				break;
			}

			switch (secondHelper) {
			case 0:
				helper.replace(esecond, 2); // 改成2
				break;
			case 2:
				throw new NothingReturnedException("强制序中有<y, x>&&<z, x>冲突");
			default:
				// 当second为1时，不会更新！
				break;
			}

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
		
		
		// 合法后，再执行强制序
		for (Tuple2<TypedEdge, TypedEdge> order : orders) {
	
			TypedEdge front = resultGraph.getElementByIndexObject(order.first.getIndex());
			TypedEdge back = resultGraph.getElementByIndexObject(order.second.getIndex());
			
			// mergeList在变
			int firstPosition = mergeList.indexOf(front);
			int secondPosition = mergeList.indexOf(back);

			// 有此判断，可减少不必要操作
			if (secondPosition == firstPosition + 1)
				continue;

			// 如果helper中first为1，second为2，则front不动（默认）
			// 如果helper中first为2，second为2，则front也不动
			if (helper.get(front) == 1 && helper.get(back) == 2
					|| helper.get(front) == 2 && helper.get(back) == 2) {
				mergeList.remove(back);
				mergeList.add(mergeList.indexOf(front) + 1, back);
			}
			// 如果helper中first为1，second为1，则back不动
			else if (helper.get(front) == 1 && helper.get(back) == 1) {
				mergeList.remove(front);
				mergeList.add(mergeList.indexOf(back), front);
			}

			// 如果helper中first为2，second为1，则<back, back+1>不动
			// 将<front-1, front>移到其前面
			else if (helper.get(front) == 2 && helper.get(back) == 1) {
				TypedEdge previousFront = mergeList.get(firstPosition - 1);
				mergeList.remove(previousFront);
				mergeList.remove(front);
				mergeList.add(mergeList.indexOf(back), previousFront);
				mergeList.add(mergeList.indexOf(back), front);
			}

		}

		return mergeList;
	}

}
