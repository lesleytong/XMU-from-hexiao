package edu.ustb.sei.mde.graph.typedGraph;
/**
 * ��ͨThread + join
 * û�ò��м����࣬��Ϊûʹ�ö���߳�ͬʱ����һ��ArrayList��HashMap
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
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

public class BXMerge_Con {

	/** ��ͼ�ϲ� */
	public static TypedGraph additiveMerge(TypedGraph first, TypedGraph graph) {
		// resultͼΪ����ͼ�ĸ���
		TypedGraph result = first.getCopy();

		// ���ڵڶ���ͼgraph�е�����ӵ�ValueNode���͵Ľڵ�n��ֱ���ӵ�resultͼ��
		graph.getAllValueNodes().forEach(n -> {
			result.addValueNode(n);
		});

		// ���ڵڶ���ͼgraph�е�ÿ��TypedNode���͵Ľڵ�n
		graph.getAllTypedNodes().forEach(n -> {
			try {
				// ����n����������resultͼ���Ƿ�����Ӧ�Ķ�������ҵ����丳ֵ��nr
				TypedNode nr = result.getElementByIndexObject(n.getIndex());
				// ���nr==n����������
				// ���nr!=n����nr�滻Ϊn����˵���ڵ㱻�滻�ˣ�����ͬ�����������ϲ��ˣ�
				if (nr != n) {
					result.replaceWith(nr, n);
				}
			} catch (NothingReturnedException e) {
				// �������n�������ڻ���ͼ��û���ҵ���˵��n�ǵڶ���ͼgraph������ӵĽڵ㣬������ӵ�resultͼ��
				result.addTypedNode(n);
			}
		});

		// ���ڵڶ���ͼgraph��ÿ��TypedEdge���͵ı�e
		graph.getAllTypedEdges().forEach(e -> {
			try {
				// ����e������������resultͼ�е�TypedEdge���͵ıߣ�����ҵ���ֵ��er
				TypedEdge er = result.getElementByIndexObject(e.getIndex());
				// ���er==e�������������er!=e����er�滻Ϊe
				if (er != e) {
					result.replaceWith(er, e);
				}
			} catch (NothingReturnedException ex) {
				// �������e������û���ҵ�resultͼ�еıߣ�˵��e���ݻ�ͼ������ӵģ�������ӵ�resultͼ��
				result.addTypedEdge(e);
			}
		});

		// ���ڵڶ���ͼgraph��ÿ��ValueEdge���͵ı�e
		graph.getAllValueEdges().forEach(e -> {
			try {
				// ����e������������resultͼ�еıߣ�����ҵ���ֵ��er
				ValueEdge er = result.getElementByIndexObject(e.getIndex());
				// ���er==e�������������er!=e����er�滻Ϊe
				if (er != e) {
					result.replaceWith(er, e);
				}
			} catch (NothingReturnedException ex) {
				// �������e������û���ҵ�resultͼ�еıߣ�˵��e��graphͼ���¼ӵģ������e��resultͼ��
				result.addValueEdge(e);
			}
		});

		result.order.merge(graph.order);

		result.constraint = GraphConstraint.and(first.constraint, graph.constraint);

		return result;
	}

	/** ��ͼ�ϲ� */
	public static TypedGraph merge(TypedGraph first, TypedGraph... interSources) throws NothingReturnedException {

		TypedGraph result = first.getCopy();
		int len = interSources.length;
		
		// �¼�TypedNodes
		Thread addTypedNodesThread = new Thread(new Runnable(){
			@Override
			public void run() {
				Profiler.begin();
				// �¼����TypedNodes
				for (TypedGraph image : interSources) {
					for (TypedNode n : image.allTypedNodes) { // ���ڷ�֧ͼ��ÿ��TypedNode���͵Ľڵ�n
						try {
							// ����n���������һ���ͼ��������Ӧ�Ķ����������������
							first.getElementByIndexObject(n.getIndex());
						} catch (NothingReturnedException e) { // ����ڻ���ͼ��û���ҵ���Ӧ�Ķ���
							TypedNode rn = null;
							try {
								// ����n����������resultͼ��������Ӧ�Ķ�������о͸�ֵ��rn
								rn = result.getElementByIndexObject(n.getIndex());
							} catch (NothingReturnedException e1) { // ���resultͼ������Ӧ�Ķ�����n������ӵ�resultͼ��List<TypedNode>��������rn=null
								result.addTypedNode(n);
								rn = null;
							} finally {

								if (rn != null) { // ���rn!=null��˵��������֧ͼ���ͬһ��������TypedNode�ڵ�
									TypeNode lt = rn.getType();
									TypeNode rt = n.getType();
									TypeNode ct = first.getTypeGraph().computeSubtype(lt, rt); // ���յ�����

									if (ct == TypeNode.NULL_TYPE) {
										try {
											throw new NothingReturnedException(); // incompatible
										} catch (NothingReturnedException e2) {
											e2.printStackTrace();
										}
									} else {
										rn.setType(ct); // �����ݣ���rn��type����Ϊct
										rn.mergeIndex(n);
										result.reindexing(rn); // lyt-�޸�
									}
								}
							}
						}
					}
				}
				System.out.println("*****�����¼�TypedNodes: " + Profiler.end() + "ms");
			}
		}, "addTypedNodesThread");
		addTypedNodesThread.start();
		
		
		// �¼�ValueNodes
		Thread addValueNodesThread = new Thread(new Runnable(){
			@Override
			public void run() {
				Profiler.begin();
				for (TypedGraph image : interSources) {
					// ��֧ͼ����������ӵ�ValueNode���ͽڵ�ȫ���ӽ�resultͼ��
					image.getAllValueNodes().forEach(v -> {
						result.addValueNode(v);
					});
				}
				System.out.println("*****�����¼�ValueNodes: " + Profiler.end() + "ms");
			}
		}, "addValueNodesThread");
		addValueNodesThread.start();
		
		
		// ���TypedEdges
		Thread changeTypedEdgesThread = new Thread(new Runnable() {
			@Override
			public void run() {
				Profiler.begin();
				try {
					addTypedNodesThread.join();
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
				
				TypedEdge[] typedEdgeImages = new TypedEdge[len];
				for (TypedEdge baseEdge : first.getAllTypedEdges()) { // ���ڻ���ͼ��ÿһ��TypedEdge���͵ı�baseEdge

					// ������֧ͼ�ȷֱ�ͻ���ͼ���Ƚϣ�baseEdge������ֱ�洢��typedEdgeImages[i]�У�������baseEdge��imageEdge��null
					for (int i = 0; i < len; i++) {
						typedEdgeImages[i] = TypedGraph.computeImage(baseEdge, first, interSources[i]);
					}

					try {
						// �ٸ���typedEdgeImages[]�е������ȷ��finalEdgeInfo
						Tuple3<TypedNode, TypedNode, TypeEdge> finalEdgeInfo = TypedGraph
								.computeEdge(baseEdge, typedEdgeImages);

						if (finalEdgeInfo == null) {
							result.remove(baseEdge);
						} else {

							TypedNode source = result.getElementByIndexObject(finalEdgeInfo.first.getIndex());
							TypedNode target = result.getElementByIndexObject(finalEdgeInfo.second.getIndex());
							TypedEdge edge = new TypedEdge(); // ������Ķ���edge
							edge.setSource(source);
							edge.setTarget(target);
							edge.setType(finalEdgeInfo.third);

							for (TypedGraph image : interSources) { // �ϲ�������֧��������
								edge.mergeIndex(image.getElementByIndexObject(baseEdge.getIndex()));
							}

							result.replaceWith(baseEdge, edge); // ��baseEdge�滻Ϊedge
						}
					} catch (NothingReturnedException e) {
						e.printStackTrace();
					}
				}
				System.out.println("*****���б��TypedEdges: " + Profiler.end() + "ms");
			}
		}, "changeTypedEdgesThread");
		changeTypedEdgesThread.start();
		
		
		// ���ValueEdges
		Thread changeValueEdgesThread = new Thread(new Runnable(){
			@Override
			public void run() {
				Profiler.begin();
				try {
					addTypedNodesThread.join();
					addValueNodesThread.join();
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
				
				ValueEdge[] valueEdgeImages = new ValueEdge[len];
				for (ValueEdge baseEdge : first.getAllValueEdges()) { // ���ڻ���ͼ��ÿһ����ValueEdge���͵ı�

					// ������֧ͼ�Ⱥͻ���ͼ���Ƚϣ�baseEdge������ֱ�洢��valueEdgeImages[]�У�������null��baseEdge��imageEdge
					for (int i = 0; i < len; i++) {
						valueEdgeImages[i] = TypedGraph.computeImage(baseEdge, first, interSources[i]);
					}

					try {
						// �ٸ���valueEdgeImages[]�е������ȷ��finalEdgeInfo
						Tuple3<TypedNode, ValueNode, PropertyEdge> finalEdgeInfo = TypedGraph
								.computeEdge(baseEdge, valueEdgeImages);

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
						e.printStackTrace();
					}
				}
				System.out.println("*****���б��ValueEdges: " + Profiler.end() + "ms");
			}
		}, "changeValueEdgesThread");
		changeValueEdgesThread.start();
		
		
		// ���TypedNodes
		Thread changeTypedNodesThread = new Thread(new Runnable(){
			@Override
			public void run() {
				Profiler.begin();
				try {
					changeTypedEdgesThread.join();
					changeValueEdgesThread.join();
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
				
				TypeNode[] nodeImages = new TypeNode[len];
				for (TypedNode baseNode : first.getAllTypedNodes()) { // ���ڻ���ͼ��ÿһ��TypedNode�ڵ�

					for (int i = 0; i < len; i++) {
						// ������֧ͼ�ȷֱ�ͻ���ͼ���Ƚϣ�baseNode������ֱ�洢��nodeImages[i]�С�������NULL��ANY���޸ĺ������
						nodeImages[i] = TypedGraph.computeImage(baseNode, first, interSources[i]);
					}

					try {
						// �ٸ���nodeImages[]�е������ȷ��baseNode��finalType
						TypeNode finalType = TypedGraph.computeType(nodeImages,
								first.getTypeGraph());

						if (finalType == TypeNode.NULL_TYPE) { // ��ĳһ��֧��ɾ����������֧��ɾ��������resultͼ��Ҳɾ��
							result.remove(baseNode);
						} else {

							if (finalType == TypeNode.ANY_TYPE) // �˽ڵ���������֧ͼ�ͻ���ͼ�е�����һ��
								finalType = baseNode.getType();

							TypedNode n = new TypedNode();
							n.setType(finalType); // �����½ڵ�n�����ͣ��ͻ���ͼ��һ�������ͻ����滻�������

							for (TypedGraph image : interSources) {
								// ���½ڵ�n��������֧ͼ�ж�Ӧ��baseNode���������ϲ�
								n.mergeIndex(image.getElementByIndexObject(baseNode.getIndex()));
							}

							result.replaceWith(baseNode, n); // ��resultͼ�е�baseNode�滻Ϊn
						}

					} catch (NothingReturnedException e) {
						e.printStackTrace();
					}
				}
				System.out.println("*****���б��TypedNodes: " + Profiler.end() + "ms");
			}	
		}, "changeTypedNodesThread");
		changeTypedNodesThread.start();
		
		// �¼�TypedEdges
		Thread addTypedEdgesThread = new Thread(new Runnable() {
			@Override
			public void run() {
				Profiler.begin();
				try {
					changeTypedNodesThread.join();
				} catch (InterruptedException e3) {
					e3.printStackTrace();
				}

				for (TypedGraph image : interSources) {
					for (TypedEdge e : image.allTypedEdges) { // ���ڷ�֧ͼ��ÿһ��TypedEdge��e
						try { // ����e���������һ���ͼ��������Ӧ�Ķ����������������
							first.getElementByIndexObject(e.getIndex());
						} catch (Exception ex) { // ����ͼ��û���ҵ���Ӧ�Ķ���
							TypedEdge re = null;
							try {
								// ����e����������resultͼ��������Ӧ�Ķ����������ֵ��re������������֧ͼ�������ͬ������e
								re = result.getElementByIndexObject(e.getIndex());
							} catch (Exception ex2) { // ����e������û���ҵ�resultͼ����Ӧ�Ķ�����Ӧ���e��resultͼ��List<TypedEdge>��

								/*
								 * ��Ȼeû��resultͼ�У�����Ȼ���ڷ�֧ͼ���¼�e��˵��resultͼ��һ�����ڶ�Ӧ��source��target�ڵ�
								 * ��������ڣ�˵���г�ͻ���ϲ��޷��������С� ��д��try�����˵��������
								 */
								TypedNode source = null;
								TypedNode target = null;
								try {
									source = result.getElementByIndexObject(e.getSource().getIndex());
									target = result.getElementByIndexObject(e.getTarget().getIndex());
								} catch (NothingReturnedException e1) {
									e1.printStackTrace();
								}

								// e��source����target�ǻ���ͼ���е�
								if (e.getSource() != source || e.getTarget() != target) {
									TypedEdge ne = new TypedEdge();
									ne.setSource(source);
									ne.setTarget(target);
									ne.setType(e.getType());
									ne.mergeIndex(e);
									result.addTypedEdge(ne);
								} else // e��source��target���ڷ�֧ͼ������ӵ�TypedNode���ͽڵ�
									result.addTypedEdge(e);

								re = null;

							} finally {

								// ����֧ͼ�����������ͬ������e
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
//											result.reindexing(re); // lyt�޸�
									}
								}

							}
						}
					}
				}
				System.out.println("*****�����¼�TypedEdges: " + Profiler.end() + "ms");
			}
		}, "addTypedEdgesThread");
		addTypedEdgesThread.start();
		
		
		// �¼�ValueEdges
		Thread addValueEdgesThread = new Thread(new Runnable() {
			@Override
			public void run() {
				Profiler.begin();
				try {
					changeTypedNodesThread.join();
				} catch (InterruptedException e3) {
					e3.printStackTrace();
				}

				for (TypedGraph image : interSources) {
					for (ValueEdge e : image.allValueEdges) { // ���ڷ�֧ͼ�е�ÿһ��ValueEdge��e
						try {
							// ����e���������һ���ͼ��������Ӧ�Ķ���������򲻴���
							first.getElementByIndexObject(e.getIndex());
						} catch (Exception ex) { // �������ͼ��û����Ӧ�Ķ���
							ValueEdge re = null;
							try {
								// ����e����������resultͼ��������Ӧ�Ķ����������ֵ��re
								re = result.getElementByIndexObject(e.getIndex());
							} catch (Exception ex2) { // ����e������û���ҵ�resultͼ����Ӧ�Ķ�������Ҫ���e��ͼ��List<ValueEdge>��

								/*
								 * resultͼ��û��ValueEdge���͵ı�e����һ������source�ڵ㡣 ��������ڣ�˵���г�ͻ���ϲ��޷������� ��д��try�����˵��������
								 */
								TypedNode source = null;
								try {
									source = result.getElementByIndexObject(e.getSource().getIndex());
								} catch (NothingReturnedException e1) {
									e1.printStackTrace();
								}

								if (e.getSource() != source) { // source�ǻ���ͼ���еģ�resultͼ�ϲ�������ͼ����������������ͬһ����
									ValueEdge ne = new ValueEdge();
									ne.setSource(source);
									ne.setTarget(e.getTarget());
									ne.setType(e.getType());
									ne.mergeIndex(e);
									result.addValueEdge(ne);
								} else // e��source��resultͼ����ͬһ����˵��������ӵ�TypedNode����
									result.addValueEdge(e);

								re = null;
							} finally {

								if (re != null) { // re!=null��˵��resultͼ���ҵ�����Ӧ�Ķ��󣬲��Ҹ�ֵ����re
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
										result.reindexing(re); // lyt�޸�
									}
								}
							}
						}
					}
				}
				System.out.println("*****�����¼�ValueEdges: " + Profiler.end() + "ms");
			}
		}, "addValueEdgesThread");
		addValueEdgesThread.start();

		OrderInformation[] orders = new OrderInformation[interSources.length];
		for (int i = 0; i < interSources.length; i++)
			orders[i] = interSources[i].order;
		result.order.merge(orders); // ��orders[i]�ϲ���result��order��

		List<GraphConstraint> cons = new ArrayList<>();
		cons.add(first.getConstraint());
		for (TypedGraph g : interSources) {
			cons.add(g.constraint);
		}
		result.constraint = GraphConstraint.and(cons);
		// check
		
		try {
			addTypedEdgesThread.join();
			addValueEdgesThread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		return result;
	}

	/** ����ϲ����� */
	public static List<TypedEdge> twoOrder_origin(TypedGraph baseGraph, TypedGraph aGraph, TypedGraph resultGraph) {

		List<TypedEdge> base = baseGraph.getAllTypedEdges();
		System.out.println("base: " + base);

		List<TypedEdge> a = aGraph.getAllTypedEdges();
		System.out.println("a: " + a);

		List<TypedEdge> result = resultGraph.getAllTypedEdges();
		System.out.println("result: " + result);

		int round = 1;

		List<TypedEdge> merge = new ArrayList<>();

		// ����a��Ԫ�أ������������������resultGraph���ҵ����򲻻���ӽ�merge
		for (int i = 0; i < a.size(); i++) {

			try {
				// merge��a��ʼ��
				resultGraph.getElementByIndexObject(a.get(i).getIndex());
				merge.add(a.get(i));

			} catch (NothingReturnedException e) {

			}

		}

		Map<Index, Integer> baseFlag = new HashMap<>();
		for (int i = 0; i < base.size(); i++) {
			baseFlag.put(base.get(i).getIndex(), i);
		}

		// ����base�е�ÿ��Ԫ��
		for (int i = 0; i < base.size(); i++) {

			try {
				// �������base.get(i)����������aGraph���ҵ���������
				aGraph.getElementByIndexObject(base.get(i).getIndex());
				continue;

			} catch (NothingReturnedException e) { // �����aGraph�в����ҵ���˵��Ҫ��ӵ�merge��

				int j;
				for (j = 0; j < merge.size(); j++) {

					try {
						// �������merge(j)��������baseGraph���ҵ��ˣ��������²���
						baseGraph.getElementByIndexObject(merge.get(j).getIndex());

						int tmp = baseFlag.get(merge.get(j).getIndex()) - baseFlag.get(base.get(i).getIndex());

						if (tmp < 0) {
							continue;
						} else {
							merge.add(j, base.get(i));
							System.out.println("�غ�" + round++ + merge);
							break;
						}

					} catch (NothingReturnedException e2) {
						// �������merge(j)��������baseGraph��û�ҵ���������
						// continue; //���Բ�д
					}

				}

				if (j == merge.size()) {
					merge.add(j, base.get(i));
					System.out.println("�غ�" + round++ + merge);
				}

			}

		}

		System.out.println("*************���յ���: \n" + merge);
		return merge;

	}

	public static ArrayList<TypedEdge> twoOrder(List<TypedEdge> base, List<TypedEdge> a, List<TypedEdge> result) {

		HashMap<Index, Integer> resultFlag = new HashMap<>();
		for (int i = 0; i < result.size(); i++) {
			resultFlag.put(result.get(i).getIndex(), i);
		}

		ArrayList<TypedEdge> merge = new ArrayList<>(a); // mergeList����aList

		// ɾ��merge��Ĳ���result�еı�
		for (int i = 0; i < a.size(); i++) {
			if (resultFlag.get(a.get(i).getIndex()) != null) {
				continue;
			}
			merge.remove(a.get(i));
		}

		// ���˺����merge.size() == result.size()����ֱ�ӷ���merge
		if (merge.size() == result.size()) {
			return merge;
		}

		HashMap<Index, Integer> baseFlag = new HashMap<>();
		for (int i = 0; i < base.size(); i++) {
			baseFlag.put(base.get(i).getIndex(), i);
		}

		HashMap<Index, Integer> mergeFlag = new HashMap<>();
		for (int i = 0; i < merge.size(); i++) {
			mergeFlag.put(merge.get(i).getIndex(), i);
		}

		// ��base��ԭ�еı���ӽ�merge����a��ɾ��������Ч��
		for (int i = 0; i < base.size(); i++) {

			// �������merge���ҵ���������
			if (mergeFlag.get(base.get(i).getIndex()) != null) {
				continue;
			}
			// ��������ҵ���˵��Ҫ��ӽ�merge
			int baseDistance = 0;
			int j;
			for (j = 0; j < merge.size(); j++) {
				try {
					baseDistance = i - baseFlag.get(merge.get(j).getIndex());
					// �������base���ҵ��������baseDistanceȷ������λ��
					if (baseDistance > 0) {
						continue;
					}
					merge.add(j, base.get(i));
					break;
				} catch (NullPointerException e2) {
					// ���merge�е�Ԫ�ز�����base���ҵ���������
				}
			}

			// ��ӵ�merge��β
			if (j == merge.size()) {
				merge.add(base.get(i));
			}

		}

		return merge;
	}

	/** ����HashMap<Index, Integer> */
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
		int round = 1; // �غϼ���

		Map<Index, Integer> aFlag = new HashMap<>();
		for (int i = 0; i < a.size(); i++) {
			aFlag.put(a.get(i).getIndex(), i);
		}

		Map<Index, Integer> bFlag = new HashMap<>();
		for (int i = 0; i < b.size(); i++) {
			bFlag.put(b.get(i).getIndex(), i);
		}

		// ����base��ÿ��Ԫ��
		for (int i = 0; i < base.size(); i++) {

			try {
				// ����base.get(i)����������resultGraph������ҵ����򸳸�element
				TypedEdge element = resultGraph.getElementByIndexObject(base.get(i).getIndex());

				if (flag == false) { // �ǵ�һ��ִ��

					// ֮�����ڣ��������base.get(j)��������mergeFlag���Ѿ���front�ˣ����ö�
					Map<TypedEdge, String> mergeFlag = new HashMap<>();
					int position = merge.indexOf(element);
					for (int k = 0; k < position; k++) {
						mergeFlag.put(merge.get(k), "front");
					}

					for (int j = i + 1; j < base.size(); j++) {

						try {
							// ����base.get(j)������resultGraph�в��ң�����ҵ��򸳸�re
							TypedEdge re = resultGraph.getElementByIndexObject(base.get(j).getIndex());

							int aSubtract = aFlag.get(base.get(i).getIndex()) - aFlag.get(base.get(j).getIndex());

							int bSubtract = bFlag.get(base.get(i).getIndex()) - bFlag.get(base.get(j).getIndex());

							if (aSubtract < 0 && bSubtract < 0) {
								continue;
							} else {

								if (mergeFlag.get(re) == "front") {
									continue;
								} else {
									System.out.println("****************removeǰ��" + merge);
									merge.remove(re);
									System.out.println("****************remove��" + merge);
									merge.add(merge.indexOf(element), re);
									System.out.println("****************add��" + merge);
								}

							}

						} catch (NothingReturnedException e) { // �������base.get(j)��������resultGraph��û�ҵ���������
							continue;
						}

					}

				} else { // ��һ��ִ��

					merge.add(element);
					flag = false;

					for (int j = i + 1; j < base.size(); j++) {

						try {
							// ����base.get(j)������resultGraph�в��ң�����ҵ��򸳸�re
							TypedEdge re = resultGraph.getElementByIndexObject(base.get(j).getIndex());

							int aSubtract = aFlag.get(base.get(i).getIndex()) - aFlag.get(base.get(j).getIndex());

							int bSubtract = bFlag.get(base.get(i).getIndex()) - bFlag.get(base.get(j).getIndex());

							if (aSubtract < 0 && bSubtract < 0) {
								merge.add(re);
							} else {
								merge.add(merge.indexOf(element), re);
							}

						} catch (NothingReturnedException e) { // �������base.get(j)��������resultGraph��û�ҵ���������
							continue;
						}
					}

				}

			} catch (NothingReturnedException e) { // �������base.get(i)������resultGraph��û�ҵ���������
				continue;
			}

			System.out.println("�غ�" + round++ + "merge: " + merge);

		}

		// ����һ�¡���ʱ����merge�����ڴ���b��֧����ӵ�Ԫ�ص�if����
		// �Ƿ���Ż�����
		List<TypedEdge> intermediate = new ArrayList<>();
		intermediate.addAll(merge);

		// ����a������ӵ�Ԫ��
		for (int i = 0; i < a.size(); i++) {

			// ����a��ÿ��Ԫ�أ��������baseGraph�е���resultGraph�У�˵��������ӵ�Ԫ��
			try {
				// �����baseGraph�У�������
				baseGraph.getElementByIndexObject(a.get(i).getIndex());
				continue;
			} catch (NothingReturnedException e) { // �������baseGraph��

				try {
					// �������baseGraph�е���resultGraph�У��������²���
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

					System.out.println("����a��һ������ӵ�Ԫ�غ�merge: " + merge);

				} catch (NothingReturnedException e1) {
					// �������baseGraph���ֲ���resultGraph�У�������
					continue;
				}

			}

		}

		// ����b������ӵ�Ԫ��
		for (int i = 0; i < b.size(); i++) {

			// ����b��ÿ��Ԫ�أ��������baseGraph�е���resultGraph�У�˵��������ӵ�Ԫ�ء�
			try {
				baseGraph.getElementByIndexObject(b.get(i).getIndex());
				continue;
			} catch (NothingReturnedException e) {

				// �������baseGraph��,����resultGraph�У��������²���
				try {
					TypedEdge element = resultGraph.getElementByIndexObject(b.get(i).getIndex());
					int k;
					for (k = 0; k < merge.size(); k++) {

						if (!intermediate.contains(merge.get(k))) {
							continue; // ˵����merge����ӽ���a��֧�е���Ԫ��
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

					System.out.println("����b��һ������ӵ�Ԫ�غ�merge: " + merge);

				} catch (NothingReturnedException e1) {
					continue;
				}
			}
		}

		System.out.println("\n���������merge: " + merge);

		return merge;
	}

	/* ���벻�ô���TypedGraph�� */
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

//		ArrayList<TypedEdge> merge = (ArrayList<TypedEdge>) result.clone(); // ������ͬ���ݵĲ�ͬ����
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
				int mergeDistance = 0; // �����жϣ�����Ѿ��Ǵ��ڣ����÷ŵ���ǰ
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
						// ���merge��Ϊ<ej, ei>
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
							// ���merge��Ϊ<ej, ei>
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
						// ���merge��Ϊ<ej, ei>
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

	// ����ǿ�����ϵ
	public static List<TypedEdge> forceOrder(List<TypedEdge> merge, Set<Tuple2<Index, Index>> orders)
			throws NothingReturnedException {

		// helper�����ж�����������ͻ
		Map<Index, Integer> helper = new HashMap<>();
		for (int i = 0; i < merge.size(); i++) {
			helper.put(merge.get(i).getIndex(), 0);
		}

		// ringFlag�����ж����޻���ͻ
		HashMap<Index, Index> ringFlag = new HashMap<>();		
		Iterator<Tuple2<Index, Index>> iterator = orders.iterator();
		while(iterator.hasNext()) {
			Tuple2<Index, Index> order = iterator.next();
			if(helper.get(order.first) != null && helper.get(order.second) != null) {
				ringFlag.put(order.first, order.second);
			}else {
				// first��second�Ҳ����Ļ���ɾ����order
				iterator.remove();
			}
		}

		for (Tuple2<Index, Index> order : orders) {

			int firstHelper = helper.get(order.first);
			int secondHelper = helper.get(order.second);

			switch (firstHelper) {
			case 0:
				helper.replace(order.first, 1); // �ĳ�1
				break;
			case 1:
				throw new NothingReturnedException("ǿ��������<x, y>&&<x, z>��ͻ");
			default:
				// ��firstΪ2ʱ��������£�
				break;
			}

			switch (secondHelper) {
			case 0:
				helper.replace(order.second, 2); // �ĳ�2
				break;
			case 2:
				throw new NothingReturnedException("ǿ��������<y, x>&&<z, x>��ͻ");
			default:
				// ��secondΪ1ʱ��������£�
				break;
			}

			// ��⻷��ͻ
			Tuple2<Index, Index> tmp = new Tuple2<>(order.first, order.second); //���򣺲���ֱ��tmp = order������order������
			while (ringFlag.get(tmp.second) != null) {
				if (ringFlag.get(tmp.second).equals(order.first)) {
					throw new NothingReturnedException("ǿ�������л���ͻ");
				}
				tmp.second = ringFlag.get(tmp.second);
			}

		}

		// �Ϸ�����ִ��ǿ����
		for (Tuple2<Index, Index> order : orders) {

			HashMap<Index, Integer> mergeFlag = new HashMap<>();

			// ÿ��ѭ����Ҫ���¸���mergeFlag
			for (int i = 0; i < merge.size(); i++) {
				mergeFlag.put(merge.get(i).getIndex(), i);
			}

			// Index���hashCode()��equals()��д�ˣ�ֻҪIndex������ڲ��������н����������ҵ�
			int firstPosition = mergeFlag.get(order.first);
			int secondPosition = mergeFlag.get(order.second);

			// �д��жϣ��ɼ��ٲ���Ҫ����
			if (secondPosition == firstPosition + 1)
				continue;

			TypedEdge front = merge.get(firstPosition);
			TypedEdge back = merge.get(secondPosition);

			// ���helper��firstΪ1��secondΪ2����front������Ĭ�ϣ�
			// ���helper��firstΪ2��secondΪ2����frontҲ����
			if (helper.get(order.first) == 1 && helper.get(order.second) == 2
					|| helper.get(order.first) == 2 && helper.get(order.second) == 2) {
				merge.remove(back);
				merge.add(merge.indexOf(front) + 1, back);
			}
			// ���helper��firstΪ1��secondΪ1����back����
			else if (helper.get(order.first) == 1 && helper.get(order.second) == 1) {
				merge.remove(front);
				merge.add(merge.indexOf(back), front);
			}

			// ���helper��firstΪ2��secondΪ1����<back, back+1>����
			// ��<front-1, front>�Ƶ���ǰ��
			else if (helper.get(order.first) == 2 && helper.get(order.second) == 1) {
				TypedEdge previousFront = merge.get(firstPosition - 1);
				merge.remove(previousFront);
				merge.remove(front);
				merge.add(merge.indexOf(back), previousFront);
				merge.add(merge.indexOf(back), front);
			}

		}

		return merge;
	}

}
