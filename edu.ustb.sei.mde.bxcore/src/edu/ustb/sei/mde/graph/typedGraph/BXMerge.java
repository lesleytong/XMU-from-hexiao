package edu.ustb.sei.mde.graph.typedGraph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.naming.spi.DirStateFactory.Result;

import edu.ustb.sei.mde.bxcore.exceptions.NothingReturnedException;
import edu.ustb.sei.mde.bxcore.structures.Index;
import edu.ustb.sei.mde.graph.type.PropertyEdge;
import edu.ustb.sei.mde.graph.type.TypeEdge;
import edu.ustb.sei.mde.graph.type.TypeNode;
import edu.ustb.sei.mde.graph.typedGraph.constraint.GraphConstraint;
import edu.ustb.sei.mde.structure.Tuple2;
import edu.ustb.sei.mde.structure.Tuple3;

public class BXMerge {

	/** 二图合并 */
	public static TypedGraph additiveMerge(TypedGraph first, TypedGraph graph) {
		// 先把第一个图拷贝到result，所有对象的引用一致
		TypedGraph result = first.getCopy();

		// 对于第二个图graph中的每个TypedNode类型的节点n
		graph.getAllTypedNodes().forEach(n -> {
			try {
				// 根据n的索引查找result图中是否有相应的对象，如果找到则将其赋值给nr
				TypedNode nr = result.getElementByIndexObject(n.getIndex());
				// 如果nr==n，则不做处理；如果nr!=n，则将nr替换为n
				if (nr != n) {
					result.replaceWith(nr, n);
				}
			} catch (NothingReturnedException e) {
				// 如果根据n的索引在result图中没有找到，说明n是第二个图graph中新添加的节点，则将其添加到result图中
				result.addTypedNode(n);
			}
		});

		// 对于第二个图graph中的每个ValueNode类型的节点n，全部添加到result中
		graph.getAllValueNodes().forEach(n -> {
			result.addValueNode(n);
		});

		// 对于第二个图graph中每个TypedEdge类型的边e
		graph.getAllTypedEdges().forEach(e -> {
			try {
				// 根据e的索引，查找result中的TypedEdge类型的边，如果找到则赋值给er
				TypedEdge er = result.getElementByIndexObject(e.getIndex());
				// 如果er==e，则不做处理；如果er!=e，则将er替换为e
				if (er != e) {
					result.replaceWith(er, e);
				}
			} catch (NothingReturnedException ex) {
				// 如果根据e的索引没有找到result图中的边，说明e是graph图中新添加的，则将其添加到result图中
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

		// 位置约束关系
		result.order.merge(graph.order);

		result.constraint = GraphConstraint.and(first.constraint, graph.constraint);

		// check

		return result;
	}

	/** 多图合并 */
	public static TypedGraph merge(TypedGraph first, TypedGraph... interSources) throws NothingReturnedException {

		TypedGraph result = first.getCopy();

		// 处理新加入的点和边
		for (TypedGraph image : interSources) {

			// 新加入的TypedNode
			for (TypedNode n : image.allTypedNodes) { // 对于分支图中每个TypedNode类型的节点n

				try {
					// 根据n的索引查找基本图中有无相应的对象，如果有则不做处理
					first.getElementByIndexObject(n.getIndex());
				} catch (NothingReturnedException e) { // 如果在基本图中没有找到相应的对象
					TypedNode rn = null;
					try {
						// 根据n的索引查找result图中有无相应的对象，如果有就赋值给rn
						rn = result.getElementByIndexObject(n.getIndex());
					} catch (NothingReturnedException e1) { // 如果result图中无相应的对象，则将n对象添加到result图的List<TypedNode>，并且令rn=null
						result.addTypedNode(n);
						rn = null;
					} finally {

						if (rn != null) { // 如果rn!=null，说明根据n的索引找到了result图中相应的对象，且赋值给了rn
							TypeNode lt = rn.getType();
							TypeNode rt = n.getType();
							TypeNode ct = first.getTypeGraph().computeSubtype(lt, rt); // 最终的类型

							if (ct == TypeNode.NULL_TYPE) {
								throw new NothingReturnedException(); // incompatible
							} else {
								rn.setType(ct); // 若兼容，则rn的type设置为ct
								rn.mergeIndex(n);
								result.reindexing(rn); // lyt-修改
							}
						}
					}
				}
			}

			// 新加入的TypedEdge
			for (TypedEdge e : image.allTypedEdges) { // 对于分支图中每一个TypedEdge边e

				try { // 根据e的索引查找基本图中有无相应的对象，如果有则不做处理
					first.getElementByIndexObject(e.getIndex());
				} catch (Exception ex) { // 基本图中没有找到相应的对象
					TypedEdge re = null;
					try {
						// 根据e的索引查找result图中有无相应的对象，如果有则赋值给re
						re = result.getElementByIndexObject(e.getIndex());
					} catch (Exception ex2) { // 根据e的索引没有找到result图中相应的对象，则应添加e到result图的List<TypedEdge>中

						/*
						 * 虽然e没在result图中，但既然能在分支图中新加e，说明result图中一定存在对应的source和target节点？？
						 * 如果不存在，说明有冲突，合并无法继续进行。 不写在try语句块里，说明不处理。
						 */
						TypedNode source = result.getElementByIndexObject(e.getSource().getIndex());
						TypedNode target = result.getElementByIndexObject(e.getTarget().getIndex());

						if (e.getSource() != source || e.getTarget() != target) { // 说明e的source和target是基本图中有的，result图合并过三个图的索引，但不是同一对象
							TypedEdge ne = new TypedEdge();
							ne.setSource(source);
							ne.setTarget(target);
							ne.setType(e.getType());
							ne.mergeIndex(e);
							result.addTypedEdge(ne);
						} else // 说明e的source和target是在分支图中新添加的TypedNode类型节点，所以在分支图和result图中是同一对象
							result.addTypedEdge(e);

						re = null;

					} finally {

						// 根据e的索引找到了result图中相应的对象，并赋值给了re
						if (re != null) {
							if (re.getType() != e.getType()
									|| !re.getSource().getIndex().equals(e.getSource().getIndex())
									|| !re.getTarget().getIndex().equals(e.getTarget().getIndex())) {
								throw new NothingReturnedException();
							} else {
								re.mergeIndex(e);
								result.reindexing(re); // lyt修改
							}
						}
					}
				}
			}

			// 新加入的ValueEdge
			for (ValueEdge e : image.allValueEdges) { // 对于分支图中的每一个ValueEdge边e
				try {
					// 根据e的索引查找基本图中有无相应的对象，如果有则不处理
					first.getElementByIndexObject(e.getIndex());
				} catch (Exception ex) { // 如果基本图中没有相应的对象
					ValueEdge re = null;
					try {
						// 根据e的索引查找result图中有无相应的对象，如果有则赋值给re
						re = result.getElementByIndexObject(e.getIndex());
					} catch (Exception ex2) { // 根据e的索引没有找到result图中相应的对象，则需要添加e到图的List<ValueEdge>中

						/*
						 * result中没有ValueEdge类型的边e，但一定存在source节点？？ 如果不存在，说明有冲突，合并无法继续。 不写在try语句块里，说明不处理。
						 */
						TypedNode source = result.getElementByIndexObject(e.getSource().getIndex());
//								ValueNode target = e.getTarget();

						if (e.getSource() != source) { // source是基本图中有的，result图合并过三个图的索引集，但不是同一对象
							ValueEdge ne = new ValueEdge();
							ne.setSource(source);
							ne.setTarget(e.getTarget());
							ne.setType(e.getType());
							ne.mergeIndex(e);
							result.addValueEdge(ne);
						} else // e的source和result图中是同一对象，说明是新添加的TypedNode对象
							result.addValueEdge(e);

						re = null;
					} finally {

						if (re != null) { // re!=null，说明result图中找到了相应的对象，并且赋值给了re
							if (re.getType() != e.getType()
									|| !re.getSource().getIndex().equals(e.getSource().getIndex())
									|| re.getTarget().equals(e.getTarget()) == false) {
								throw new NothingReturnedException();
							} else {
								re.mergeIndex(e);
								result.reindexing(re); // lyt修改
							}
						}
					}
				}
			}

		}

		// 处理TypedNode的变更情况
		TypeNode[] nodeImages = new TypeNode[interSources.length]; // 比如length=2
		for (TypedNode baseNode : first.getAllTypedNodes()) { // 对于基本图中每一个TypedNode节点

			for (int i = 0; i < interSources.length; i++) {
				// 两个分支图先分别和基本图作比较，baseNode的情况分别存储在nodeImages[i]中。可能是NULL、ANY、修改后的类型
				nodeImages[i] = TypedGraph.computeImage(baseNode, first, interSources[i]);
			}

			try {
				// 再根据nodeImages[]中的情况，确定baseNode的finalType
				TypeNode finalType = TypedGraph.computeType(nodeImages, first.getTypeGraph());

				if (finalType == TypeNode.NULL_TYPE) { // 在某一分支中删除或两个分支都删除，则在result图中也删除
					result.remove(baseNode);
				} else {

					if (finalType == TypeNode.ANY_TYPE) // 此节点在两个分支图和基本图中的类型一致
						finalType = baseNode.getType();

					TypedNode n = new TypedNode();
					n.setType(finalType); // 设置新节点n的类型：和基本图中一样的类型或是替换后的类型

					for (TypedGraph image : interSources) {
						// 将新节点n和两个分支图中对应的baseNode的索引集合并
						n.mergeIndex(image.getElementByIndexObject(baseNode.getIndex()));
					}

					result.replaceWith(baseNode, n); // 将result图中的baseNode替换为n
				}

			} catch (NothingReturnedException e) {
				throw e; // 捕捉到异常后抛出
			}
		}

		// 处理ValueNode：分支图中所有的ValueNode全部扔进result图中
		for (TypedGraph image : interSources) {
			image.getAllValueNodes().forEach(v -> {
				result.addValueNode(v);
			});
		}

		// 处理TypedEdge的变更情况
		TypedEdge[] typedEdgeImages = new TypedEdge[interSources.length];
		for (TypedEdge baseEdge : first.getAllTypedEdges()) { // 对于基本图中每一个TypedEdge类型的边baseEdge

			// 两个分支图先分别和基本图作比较，baseEdge的情况分别存储在typedEdgeImages[i]中，可能是baseEdge、imageEdge、null
			for (int i = 0; i < interSources.length; i++) {
				typedEdgeImages[i] = TypedGraph.computeImage(baseEdge, first, interSources[i]);
			}

			try {
				// 再根据typedEdgeImages[]中的情况，确定finalEdgeInfo
				Tuple3<TypedNode, TypedNode, TypeEdge> finalEdgeInfo = TypedGraph.computeEdge(baseEdge,
						typedEdgeImages);

				if (finalEdgeInfo == null) {
					result.remove(baseEdge);
				} else {

					TypedNode source = result.getElementByIndexObject(finalEdgeInfo.first.getIndex());
					TypedNode target = result.getElementByIndexObject(finalEdgeInfo.second.getIndex());
					TypedEdge edge = new TypedEdge(); // 新申请的对象
					edge.setSource(source);
					edge.setTarget(target);
					edge.setType(finalEdgeInfo.third);

					for (TypedGraph image : interSources) {
						edge.mergeIndex(image.getElementByIndexObject(baseEdge.getIndex()));
					}

					result.replaceWith(baseEdge, edge);
				}
			} catch (NothingReturnedException e) {
				throw e; // 捕捉到异常后抛出
			}
		}

		// 处理ValueEdge的变更情况
		ValueEdge[] valueEdgeImages = new ValueEdge[interSources.length];
		for (ValueEdge baseEdge : first.getAllValueEdges()) { // 对于基本图中每一个条ValueEdge类型的边

			// 两个分支图先和基本图作比较，baseEdge的情况分别存储在valueEdgeImages[]中，可能是null、baseEdge、imageEdge
			for (int i = 0; i < interSources.length; i++) {
				valueEdgeImages[i] = TypedGraph.computeImage(baseEdge, first, interSources[i]);
			}

			try {
				// 再根据valueEdgeImages[]中的情况，确定finalEdgeInfo
				Tuple3<TypedNode, ValueNode, PropertyEdge> finalEdgeInfo = TypedGraph.computeEdge(baseEdge,
						valueEdgeImages);

				if (finalEdgeInfo == null) {
					result.remove(baseEdge);
				} else {
					TypedNode source = result.getElementByIndexObject(finalEdgeInfo.first.getIndex());
					ValueNode target = finalEdgeInfo.second;
					ValueEdge edge = new ValueEdge();
					edge.setSource(source);
					edge.setTarget(target);
					edge.setType(finalEdgeInfo.third);

					for (TypedGraph image : interSources) {
						edge.mergeIndex(image.getElementByIndexObject(baseEdge.getIndex()));
					}

					result.replaceWith(baseEdge, edge);
				}
			} catch (NothingReturnedException e) {
				throw e;
			}
		}

		OrderInformation[] orders = new OrderInformation[interSources.length];
		for (int i = 0; i < interSources.length; i++)
			orders[i] = interSources[i].order;
		result.order.merge(orders); // 将orders[i]合并到result的order中

		List<GraphConstraint> cons = new ArrayList<>();
		cons.add(first.getConstraint());
		for (TypedGraph g : interSources) {
			cons.add(g.constraint);
		}
		result.constraint = GraphConstraint.and(cons);
		// check

		return result;
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

		if (a.size() == result.size()) {
			System.out.println("**********a和result的size相等，最终的序关系就是a的序关系：\n" + a);
			return a;
		} else {

			Map<TypedEdge, Integer> baseFlag = new HashMap<>();
			for (int i = 0; i < base.size(); i++) {
				baseFlag.put(base.get(i), i);
			}

			List<TypedEdge> merge = new ArrayList<>();
			merge.addAll(a);

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
							TypedEdge typedEdge = baseGraph.getElementByIndexObject(merge.get(j).getIndex());

							int tmp = baseFlag.get(base.get(i)) - baseFlag.get(typedEdge);

							if (tmp > 0) {
								continue;
							} else {
								merge.add(j, base.get(i));
								System.out.println("回合" + round++ + merge);
								break;
							}

						} catch (NothingReturnedException e2) {
							// 如果根据merge(j)的索引在baseGraph中没找到，则跳过
//							continue;	//可以不写continue
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

	}

	/** 二向合并的序 */
	public static List<TypedEdge> twoOrder(TypedGraph baseGraph, TypedGraph aGraph, TypedGraph resultGraph) {

		List<TypedEdge> base = baseGraph.getAllTypedEdges();
		System.out.println("base: " + base);

		List<TypedEdge> a = aGraph.getAllTypedEdges();
		System.out.println("a: " + a);

		List<TypedEdge> result = resultGraph.getAllTypedEdges();
		System.out.println("result: " + result);

		int round = 1;

		List<TypedEdge> merge = new ArrayList<>();

		// 遍历a中元素，如果根据索引不能在result中找到，则不会添加进merge
		for (int i = 0; i < a.size(); i++) {

			try {

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

	/** 用了front和back */
	public static List<TypedEdge> threeOrder_1(TypedGraph baseGraph, TypedGraph aGraph, TypedGraph bGraph,
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

		// 对于base中每个元素
		for (int i = 0; i < base.size(); i++) {

			try {
				// 根据base.get(i)的索引查找resultGraph，如果找到，则赋给element
				TypedEdge element = resultGraph.getElementByIndexObject(base.get(i).getIndex());

				Map<TypedEdge, String> aFlag = new HashMap<>();
				int aPosition = a.indexOf(aGraph.getElementByIndexObject(base.get(i).getIndex()));
				for (int k = 0; k < aPosition; k++) {
					aFlag.put(a.get(k), "front");
				}
				for (int k = aPosition + 1; k < a.size(); k++) {
					aFlag.put(a.get(k), "back");
				}

				Map<TypedEdge, String> bFlag = new HashMap<>();
				int bPosition = b.indexOf(bGraph.getElementByIndexObject(base.get(i).getIndex()));
				for (int k = 0; k < bPosition; k++) {
					bFlag.put(b.get(k), "front");
				}
				for (int k = bPosition + 1; k < b.size(); k++) {
					bFlag.put(b.get(k), "back");
				}

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

							if (aFlag.get(aGraph.getElementByIndexObject(base.get(j).getIndex())) == "back"
									&& bFlag.get(bGraph.getElementByIndexObject(base.get(j).getIndex())) == "back") {
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

							if (aFlag.get(aGraph.getElementByIndexObject(base.get(j).getIndex())) == "back"
									&& bFlag.get(bGraph.getElementByIndexObject(base.get(j).getIndex())) == "back") {
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

					// 为了找到新元素的插入点，aMap用于下面if条件
					Map<TypedEdge, String> aMap = new HashMap<>();
					for (int j = 0; j < i; j++) {

						try {
							TypedEdge re = resultGraph.getElementByIndexObject(a.get(j).getIndex());
							aMap.put(re, "exist");
						} catch (NothingReturnedException e2) {
							// 如果不在resultGraph中，则跳过
							continue;
						}

					}

					int k;
					for (k = 0; k < merge.size(); k++) {
						// aMap用于if条件：如果满足，说明新添元素还应再往后插入
						if (aMap.get(merge.get(k)) == "exist") {
							continue;
						} else {
							merge.add(k, element);
							break;
						}
					}

					// 如果都在aMap中，则element应该插入到merge列表最后
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
			// 如果在aGraph中，则跳过（为了不重复添加）
			try {
				// 如果在baseGraph中，则跳过
				baseGraph.getElementByIndexObject(b.get(i).getIndex());
				continue;

			} catch (NothingReturnedException e) {

				try {
					// 如果不在baseGraph中但在aGraph中，则跳过（为了不重复添加）
					aGraph.getElementByIndexObject(b.get(i).getIndex());
					continue;

				} catch (NothingReturnedException e1) {

					try {
						// 如果不在baseGraph中又不在aGraph中，但在resultGraph中，则有以下操作
						TypedEdge element = resultGraph.getElementByIndexObject(b.get(i).getIndex()); // 错因

						// 为了找到新元素的插入点，bMap用于下面if条件
						Map<TypedEdge, String> bMap = new HashMap<>();
						for (int j = 0; j < i; j++) {

							try {
								TypedEdge re = resultGraph.getElementByIndexObject(b.get(j).getIndex());
								bMap.put(re, "exist");
							} catch (NothingReturnedException e3) {
								// 如果不在resultGraph中，则跳过
								continue;
							}

						}

						int k;
						for (k = 0; k < merge.size(); k++) {

							// intermediate用于if的第二个条件：a分支新元素已添加进merge中，为了防止b分支的新元素插错位置
							if (bMap.get(merge.get(k)) == "exist" || !intermediate.contains(merge.get(k))) {
								continue;
							} else {
								merge.add(k, element);
								break;
							}

						}

						// 如果都在bMap中，则element应该插入到merge列表最后
						if (k == merge.size()) {
							merge.add(element);
						}

						System.out.println("处理b中一个新添加的元素后，merge: " + merge);

					} catch (NothingReturnedException e2) {
						// 如果不在baseGraph中又不在aGraph中，且不在resultGraph中，则跳过
						continue;
					}

				}
			}

		}

		System.out.println("\n处理完序后，merge: " + merge);

		return merge;
	}

	/** 用了HashMap<TypedEdge, Integer> */
	public static List<TypedEdge> threeOrder_2(TypedGraph baseGraph, TypedGraph aGraph, TypedGraph bGraph,
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

		Map<TypedEdge, Integer> aFlag = new HashMap<>();
		for (int i = 0; i < a.size(); i++) {
			aFlag.put(a.get(i), i);
		}

		Map<TypedEdge, Integer> bFlag = new HashMap<>();
		for (int i = 0; i < b.size(); i++) {
			bFlag.put(b.get(i), i);
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

							int aSubtract = aFlag.get(aGraph.getElementByIndexObject(base.get(j).getIndex()))
									- aFlag.get(aGraph.getElementByIndexObject(base.get(i).getIndex()));

							int bSubtract = bFlag.get(bGraph.getElementByIndexObject(base.get(j).getIndex()))
									- bFlag.get(bGraph.getElementByIndexObject(base.get(i).getIndex()));

							if (aSubtract > 0 && bSubtract > 0) {
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

							int aSubtract = aFlag.get(aGraph.getElementByIndexObject(base.get(j).getIndex()))
									- aFlag.get(aGraph.getElementByIndexObject(base.get(i).getIndex()));

							int bSubtract = bFlag.get(bGraph.getElementByIndexObject(base.get(j).getIndex()))
									- bFlag.get(bGraph.getElementByIndexObject(base.get(i).getIndex()));

							if (aSubtract > 0 && bSubtract > 0) {
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
						int tmp = aFlag.get(a.get(i))
								- aFlag.get(aGraph.getElementByIndexObject(merge.get(k).getIndex()));
						if (tmp > 0) {
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
			// 如果在aGraph中，则跳过（为了不重复添加）
			try {
				// 如果在baseGraph中，则跳过
				baseGraph.getElementByIndexObject(b.get(i).getIndex());
				continue;

			} catch (NothingReturnedException e) {

				try {
					// 如果不在baseGraph中但在aGraph中，则跳过（为了不重复添加）
					aGraph.getElementByIndexObject(b.get(i).getIndex());
					continue;

				} catch (NothingReturnedException e1) {

					try {
						// 如果不在baseGraph中又不在aGraph中，但在resultGraph中，则有以下操作
						TypedEdge element = resultGraph.getElementByIndexObject(b.get(i).getIndex()); // 错因

						int k;
						for (k = 0; k < merge.size(); k++) {

							// intermediate用于if的第二个条件：a分支新元素已添加进merge中，为了防止b分支的新元素插错位置
							// 出现bug: 这里如果减号后面的bFlag没找到，会处理b的下一个元素
//							int tmp = bFlag.get(b.get(i))
//									- bFlag.get(bGraph.getElementByIndexObject(merge.get(k).getIndex()));
//							
//							if (tmp > 0 || !intermediate.contains(merge.get(k))) {
//								continue;
//							} else {
//								merge.add(k, element);
//								break;
//							}
							
							if(!intermediate.contains(merge.get(k))) {
								continue;
							}
							
							int tmp = bFlag.get(b.get(i))
									- bFlag.get(bGraph.getElementByIndexObject(merge.get(k).getIndex()));
							
							if(tmp > 0) {
								continue;
							}else {
								merge.add(k, element);
								break;
							}
							

						}

						if (k == merge.size()) {
							merge.add(element);
						}

						System.out.println("处理b中一个新添加的元素后，merge: " + merge);

					} catch (NothingReturnedException e2) {
						// 如果不在baseGraph中又不在aGraph中，且不在resultGraph中，则跳过
						continue;
					}

				}
			}

		}

		System.out.println("\n处理完序后，merge: " + merge);

		return merge;
	}

	/** 用了HashMap<Index, Integer> */
	public static List<TypedEdge> threeOrder(TypedGraph baseGraph, TypedGraph aGraph, TypedGraph bGraph,
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
			// 如果在aGraph中，则跳过（为了不重复添加）
			try {
				// 如果在baseGraph中，则跳过
				baseGraph.getElementByIndexObject(b.get(i).getIndex());
				continue;

			} catch (NothingReturnedException e) {

				try {
					// 如果不在baseGraph中但在aGraph中，则跳过（为了不重复添加）
					aGraph.getElementByIndexObject(b.get(i).getIndex());
					continue;

				} catch (NothingReturnedException e1) {

					try {
						// 如果不在baseGraph中又不在aGraph中，但在resultGraph中，则有以下操作
						TypedEdge element = resultGraph.getElementByIndexObject(b.get(i).getIndex()); // 错因

						int k;
						for (k = 0; k < merge.size(); k++) {

							// intermediate用于if的第二个条件：a分支新元素已添加进merge中，为了防止b分支的新元素插错位置
							// 出现bug: 如果第一个bFlag没找到，会抛出异常
//							int tmp = bFlag.get(merge.get(k).getIndex()) - bFlag.get(b.get(i).getIndex());
//							if (tmp < 0 || !intermediate.contains(merge.get(k))) {
//								continue;
//							} else {
//								merge.add(k, element);
//								break;
//							}
							
							if(!intermediate.contains(merge.get(k))) {
								continue;	//说明是merge中添加进的a分支新元素
							}
							
							int tmp = bFlag.get(merge.get(k).getIndex()) - bFlag.get(b.get(i).getIndex());
							if(tmp < 0) {
								continue;
							}else {
								merge.add(k, element);
								break;
							}
							

						}

						if (k == merge.size()) {
							merge.add(element);
						}

						System.out.println("处理b中一个新添加的元素后，merge: " + merge);

					} catch (NothingReturnedException e2) {
						// 如果不在baseGraph中又不在aGraph中，且不在resultGraph中，则跳过
						continue;
					}

				}
			}

		}

		System.out.println("\n处理完序后，merge: " + merge);

		return merge;
	}

	// 处理强制序关系
	public static List<TypedEdge> forceOrder(List<TypedEdge> merge, Set<Tuple2<Index, Index>> orders) throws NothingReturnedException {

		Map<Index, Integer> mergeFlag = new HashMap<>();
		Map<Integer, Integer> helper = new HashMap<>();
		for (int i = 0; i < merge.size(); i++) {
			mergeFlag.put(merge.get(i).getIndex(), i);
			helper.put(i, 0);
		}

		for (Tuple2<Index, Index> order : orders) {
			
			try {
				
				// Index类的hashCode()和equals()重写了，只要Index对象的内部索引集有交集，就能找到
				int first = mergeFlag.get(order.first);
				int second = mergeFlag.get(order.second);
				
				if(helper.get(first)==2 && helper.get(second)==1) {
					throw new NothingReturnedException("强制序中构成环，产生冲突");
				}
				
				if(helper.get(first)==1) {
					throw new NothingReturnedException("强制序中有<x, y>&&<x, z>冲突");
				}
				if(helper.get(first)==0) {
					helper.replace(first, 1);	// 改成1，注意顺序
				}
			
				if(helper.get(second)==2) {
					throw new NothingReturnedException("强制序中有<y, x>&&<z, x>冲突");
				}
				if(helper.get(second)==0) {
					helper.replace(second, 2);	//改成2
				}
				
				// 有此判断，可减少不必要操作
				if (second == first + 1)
					continue;

				TypedEdge front = merge.get(first);
				TypedEdge back = merge.get(second);
				merge.remove(back);
				merge.add(merge.indexOf(front)+1, back);
				
			} catch (NullPointerException e) {
				// first或second找不到的话，catch这里不作处理，会跳过此order
			}			
		}

		System.out.println("处理完约束信息后，merge: " + merge);
		
		return merge;
	}

}
