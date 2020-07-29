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
 * ���кϲ���
 * �𲽹������ͼ��
 * Ч����߸����ˡ�
 */

import edu.ustb.sei.mde.bxcore.exceptions.NothingReturnedException;
import edu.ustb.sei.mde.bxcore.structures.Index;
import edu.ustb.sei.mde.graph.type.PropertyEdge;
import edu.ustb.sei.mde.graph.type.TypeEdge;
import edu.ustb.sei.mde.graph.type.TypeNode;
import edu.ustb.sei.mde.structure.Tuple2;
import edu.ustb.sei.mde.structure.Tuple3;

public class BXMerge3 {

	/** ��·�ϲ� */
		public static TypedGraph merge(TypedGraph baseGraph, TypedGraph... interSources) throws NothingReturnedException {
	
			TypedGraph resultGraph = new TypedGraph(baseGraph.getTypeGraph());
	
			// �¼�TypedNodes
			Profiler.begin();
			for (TypedGraph image : interSources) {
				for (TypedNode n : image.allTypedNodes) { // ���ڷ�֧ͼ��ÿ��TypedNode���͵Ľڵ�n
					try {
						// ����n���������һ���ͼ��������Ӧ�Ķ����������������
						baseGraph.getElementByIndexObject(n.getIndex());
					} catch (NothingReturnedException e) { // ����ڻ���ͼ��û���ҵ���Ӧ�Ķ���
						TypedNode rn = null;
						try {
							// ����n����������resultͼ��������Ӧ�Ķ�������о͸�ֵ��rn
							rn = resultGraph.getElementByIndexObject(n.getIndex());
						} catch (NothingReturnedException e1) { // ���resultͼ������Ӧ�Ķ�����n������ӵ�resultͼ��List<TypedNode>��������rn=null
							resultGraph.addTypedNode(n);
							rn = null;
						} finally {
	
							if (rn != null) { // ���rn!=null��˵������n�������ҵ���resultͼ����Ӧ�Ķ����Ҹ�ֵ����rn
								TypeNode lt = rn.getType();
								TypeNode rt = n.getType();
								TypeNode ct = baseGraph.getTypeGraph().computeSubtype(lt, rt); // ���յ�����
	
								if (ct == TypeNode.NULL_TYPE) {
									throw new NothingReturnedException(); // incompatible
								} else {
									rn.setType(ct); // �����ݣ���rn��type����Ϊct
									rn.mergeIndex(n);
									resultGraph.reindexing(rn); // lyt-�޸�
								}
							}
						}
					}
				}
			}
			System.out.println("*******�����¼�TypedNodes��" + Profiler.end() + "ms");
	
			// �¼�ValueNodes
			Profiler.begin();
			baseGraph.allValueNodes.forEach(v -> {
				resultGraph.addValueNode(v);
			});
			for (TypedGraph image : interSources) {
				image.allValueNodes.forEach(v -> {
					resultGraph.addValueNode(v);
				});
			}
			System.out.println("*******�����¼�ValueNodes��" + Profiler.end() + "ms");
	
			// ��������޸ĵ�TypedNodes��ӵ����ͼ��
			Profiler.begin();
			TypeNode[] nodeImages = new TypeNode[interSources.length];
			for (TypedNode baseNode : baseGraph.allTypedNodes) { // ���ڻ���ͼ��ÿһ��TypedNode�ڵ�
	
				for (int i = 0; i < interSources.length; i++) {
					// ������֧ͼ�ȷֱ�ͻ���ͼ���Ƚϣ�baseNode������ֱ�洢��nodeImages[i]�С�������NULL��ANY���޸ĺ������
					nodeImages[i] = TypedGraph.computeImage(baseNode, baseGraph, interSources[i]);
				}
	
				try {
					// �ٸ���nodeImages[]�е������ȷ��baseNode��finalType
					TypeNode finalType = TypedGraph.computeType(nodeImages, baseGraph.getTypeGraph());
	
					if (finalType != TypeNode.NULL_TYPE) {
						if (finalType == TypeNode.ANY_TYPE) {
							finalType = baseNode.getType();
						}
	
						TypedNode n = new TypedNode(); // ������Ľڵ�
						n.setType(finalType); // �����½ڵ�n�����ͣ��ͻ���ͼ��һ�������ͻ����޸ĺ������
	
						for (TypedGraph image : interSources) {
							// ���½ڵ�n�����з�֧ͼ�ж�Ӧ��baseNode���������ϲ�
							n.mergeIndex(image.getElementByIndexObject(baseNode.getIndex()));
						}
	
						resultGraph.addTypedNode(n);
					}
	
				} catch (NothingReturnedException e) {
					throw e; // ��׽���쳣���׳�
				}
			}
			System.out.println("*******���н�������޸ĵ�TypedNodes��ӵ����ͼ�У�" + Profiler.end() + "ms");
	
			// ��������޸ĵ�TypedEdges��ӵ����ͼ��
			Profiler.begin();
			long[] array = {0, 0, 0};
			long start;
			TypedEdge[] typedEdgeImages = new TypedEdge[interSources.length];
			for (TypedEdge baseEdge : baseGraph.allTypedEdges) { // ���ڻ���ͼ��ÿһ��TypedEdge���͵ı�baseEdge
				
				start = System.currentTimeMillis();
				// �����֧ͼ�ȷֱ�ͻ���ͼ���Ƚϣ�baseEdge������ֱ�洢��typedEdgeImages[i]�У�������baseEdge��imageEdge��null
				for (int i = 0; i < interSources.length; i++) {
					typedEdgeImages[i] = TypedGraph.computeImage(baseEdge, baseGraph, interSources[i]);
				}
				array[0] += System.currentTimeMillis() - start;
	
				try {
					start = System.currentTimeMillis();
					// �ٸ���typedEdgeImages[]�е������ȷ��finalEdgeInfo
					Tuple3<TypedNode, TypedNode, TypeEdge> finalEdgeInfo = TypedGraph.computeEdge(baseEdge,
							typedEdgeImages);
					array[1] += System.currentTimeMillis() - start;
	
					
					if (finalEdgeInfo != null) {
						TypedNode source = resultGraph.getElementByIndexObject(finalEdgeInfo.first.getIndex());
						TypedNode target = resultGraph.getElementByIndexObject(finalEdgeInfo.second.getIndex());
						TypedEdge edge = new TypedEdge(); // ������Ķ���edge
						edge.setSource(source);
						edge.setTarget(target);
						edge.setType(finalEdgeInfo.third);
	
						for (TypedGraph image : interSources) { // �ϲ����з�֧ͼ��������
							edge.mergeIndex(image.getElementByIndexObject(baseEdge.getIndex()));
						}
						start = System.currentTimeMillis();
						resultGraph.addTypedEdge(edge);
						array[2] += System.currentTimeMillis() - start;
					}
					
	
				} catch (NothingReturnedException e) {
					throw e; // ��׽���쳣���׳�
				}
			}
			System.out.println("*******���н�������޸ĵ�TypedEdges��ӵ����ͼ�У�" + Profiler.end() + "ms");
			
			System.out.println("array[0]: " + array[0]);
			System.out.println("array[1]: " + array[1]);
			System.out.println("array[2]: " + array[2]);
			
	
			// ��������޸ĵ�ValueEdges��ӵ����ͼ��
			Profiler.begin();
			ValueEdge[] valueEdgeImages = new ValueEdge[interSources.length];
			for (ValueEdge baseEdge : baseGraph.allValueEdges) { // ���ڻ���ͼ��ÿһ����ValueEdge���͵ı�
	
				// ������֧ͼ�Ⱥͻ���ͼ���Ƚϣ�baseEdge������ֱ�洢��valueEdgeImages[]�У�������null��baseEdge��imageEdge
				for (int i = 0; i < interSources.length; i++) {
					valueEdgeImages[i] = TypedGraph.computeImage(baseEdge, baseGraph, interSources[i]);
				}
	
				try {
					// �ٸ���valueEdgeImages[]�е������ȷ��finalEdgeInfo
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
			System.out.println("*******���н�������޸ĵ�ValueEdges��ӵ����ͼ�У�" + Profiler.end() + "ms");
	
			// �¼�TypedEdges
			Profiler.begin();
			for (TypedGraph image : interSources) {
				for (TypedEdge e : image.allTypedEdges) { // ���ڷ�֧ͼ��ÿһ��TypedEdge��e
					try { // ����e���������һ���ͼ��������Ӧ�Ķ����������������
						baseGraph.getElementByIndexObject(e.getIndex());
					} catch (Exception ex) { // ����ͼ��û���ҵ���Ӧ�Ķ���
						TypedEdge re = null;
						try {
							// ����e����������resultͼ��������Ӧ�Ķ����������ֵ��re
							re = resultGraph.getElementByIndexObject(e.getIndex());
						} catch (Exception ex2) { // ����e������û���ҵ�resultͼ����Ӧ�Ķ�����Ӧ���e��resultͼ��List<TypedEdge>��
	
							TypedNode source = resultGraph.getElementByIndexObject(e.getSource().getIndex());
							TypedNode target = resultGraph.getElementByIndexObject(e.getTarget().getIndex());
	
							if (e.getSource() != source || e.getTarget() != target) { // ˵��e��source��target�ǻ���ͼ���еģ�resultͼ�ϲ�������ͼ��������������ͬһ����
								TypedEdge ne = new TypedEdge();
								ne.setSource(source);
								ne.setTarget(target);
								ne.setType(e.getType());
								ne.mergeIndex(e);
								resultGraph.addTypedEdge(ne);
							} else // ˵��e��source��target���ڷ�֧ͼ������ӵ�TypedNode���ͽڵ㣬�����ڷ�֧ͼ��resultͼ����ͬһ����
								resultGraph.addTypedEdge(e);
	
							re = null;
	
						} finally {
	
							// ����e�������ҵ���resultͼ����Ӧ�Ķ��󣬲���ֵ����re
							// ˵�������֧ͼ�������ͬ�ı�
							if (re != null) {
								if (re.getType() != e.getType()
										|| !re.getSource().getIndex().equals(e.getSource().getIndex())
										|| !re.getTarget().getIndex().equals(e.getTarget().getIndex())) {
									throw new NothingReturnedException();
								} else {
									re.mergeIndex(e);
									resultGraph.reindexing(re); // lyt�޸�
								}
							}
						}
					}
				}
			}
			System.out.println("*******�����¼�TypedEdges��" + Profiler.end() + "ms");
	
			// �¼�ValueEdges
			Profiler.begin();
			for (TypedGraph image : interSources) {
				for (ValueEdge e : image.allValueEdges) { // ���ڷ�֧ͼ�е�ÿһ��ValueEdge��e
					try {
						// ����e���������һ���ͼ��������Ӧ�Ķ���������򲻴���
						baseGraph.getElementByIndexObject(e.getIndex());
					} catch (Exception ex) { // �������ͼ��û����Ӧ�Ķ���
						ValueEdge re = null;
						try {
							// ����e����������resultͼ��������Ӧ�Ķ����������ֵ��re
							re = resultGraph.getElementByIndexObject(e.getIndex());
						} catch (Exception ex2) { // ����e������û���ҵ�resultͼ����Ӧ�Ķ�������Ҫ���e��ͼ��List<ValueEdge>��
	
							TypedNode source = resultGraph.getElementByIndexObject(e.getSource().getIndex());
	
							if (e.getSource() != source) { // source�ǻ���ͼ���еģ�resultͼ�ϲ�������ͼ����������������ͬһ����
								ValueEdge ne = new ValueEdge();
								ne.setSource(source);
								ne.setTarget(e.getTarget());
								ne.setType(e.getType());
								ne.mergeIndex(e);
								resultGraph.addValueEdge(ne);
							} else // e��source��resultͼ����ͬһ����˵��������ӵ�TypedNode����
								resultGraph.addValueEdge(e);
	
							re = null;
						} finally {
	
							if (re != null) { // re!=null��˵��resultͼ���ҵ�����Ӧ�Ķ��󣬲��Ҹ�ֵ����re
								if (re.getType() != e.getType()
										|| !re.getSource().getIndex().equals(e.getSource().getIndex())
										|| re.getTarget().equals(e.getTarget()) == false) {
									throw new NothingReturnedException();
								} else {
									re.mergeIndex(e);
									resultGraph.reindexing(re); // lyt�޸�
								}
							}
						}
					}
				}
			}
			System.out.println("*******�����¼�ValueEdges��" + Profiler.end() + "ms");
	
	//			OrderInformation[] orders = new OrderInformation[interSources.length];
	//			for (int i = 0; i < interSources.length; i++)
	//				orders[i] = interSources[i].order;
	//			resultGraph.order.merge(orders); // ��orders[i]�ϲ���result��order��
	
	//			// lyt-����ԭ�����򷽷�
	//			System.out.println("ִ��enforceOrderǰ�� " + result.getAllTypedEdges());
	//			result.enforceOrder();
	//			System.out.println("ִ��enforceOrder��" + result.getAllTypedEdges());
	
	//			List<GraphConstraint> cons = new ArrayList<>();
	//			cons.add(baseGraph.getConstraint());
	//			for (TypedGraph g : interSources) {
	//				cons.add(g.constraint);
	//			}
	//			resultGraph.constraint = GraphConstraint.and(cons);
	//			// check
	
			return resultGraph;
		}

	/** ��·�ϲ� */
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
		
		// �¼�TypedNodes
		long start = System.currentTimeMillis();
		for (TypedGraph image : interSources) {
			image.allTypedNodes.parallelStream().forEach(n -> {
				try {
					// ����n���������һ���ͼ��������Ӧ�Ķ����������������
					baseGraph.getElementByIndexObject(n.getIndex());
				} catch (NothingReturnedException e) { // ����ڻ���ͼ��û���ҵ���Ӧ�Ķ���
					TypedNode rn = null;
					try {
						// ����n����������resultͼ��������Ӧ�Ķ�������о͸�ֵ��rn
						rn = resultGraph.getElementByIndexObject(n.getIndex());
					} catch (NothingReturnedException e1) { // ���resultͼ������Ӧ�Ķ�����n������ӵ�resultͼ��List<TypedNode>��������rn=null
						resultGraph.addTypedNode(n);
						rn = null;
					} finally {
	
						if (rn != null) { // ���rn!=null��˵������n�������ҵ���resultͼ����Ӧ�Ķ����Ҹ�ֵ����rn
							TypeNode lt = rn.getType();
							TypeNode rt = n.getType();
							TypeNode ct = baseGraph.getTypeGraph().computeSubtype(lt, rt); // ���յ�����
	
							if (ct == TypeNode.NULL_TYPE) {
	
								try {
									throw new NothingReturnedException(); // incompatible
								} catch (NothingReturnedException e2) {
									e2.printStackTrace();
								}
	
							} else {
								rn.setType(ct); // �����ݣ���rn��type����Ϊct
								rn.mergeIndex(n);
								resultGraph.reindexing(rn); // lyt-�޸�
							}
						}
					}
				}
			});
		}
		long end = System.currentTimeMillis();
		System.out.println("*******parallelStream�¼�TypedNodes��" + (end - start) + "ms");
		
		// �¼�ValueNodes
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
		System.out.println("*******parallelStream�¼�ValueNodes��" + (end - start) + "ms");
	
		// ��������޸ĵ�TypedNodes��ӵ����ͼ��
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
				// ������֧ͼ�ȷֱ�ͻ���ͼ���Ƚϣ�baseNode������ֱ�洢��nodeImages[i]�С�������NULL��ANY���޸ĺ������
				nodeImages[i] = TypedGraph.computeImage(baseNode, baseGraph, interSources[i]);
			}
	
			try {
				// �ٸ���nodeImages[]�е������ȷ��baseNode��finalType
				 TypeNode finalType = TypedGraph.computeType(nodeImages, baseGraph.getTypeGraph());
	
				if (finalType != TypeNode.NULL_TYPE) {
	
					if (finalType == TypeNode.ANY_TYPE) {
						finalType = baseNode.getType();
					}
	
					TypedNode n = new TypedNode(); // ������Ľڵ�
					n.setType(finalType); // �����½ڵ�n�����ͣ��ͻ���ͼ��һ�������ͻ����޸ĺ������
	
					for (TypedGraph image : interSources) {
						// ���½ڵ�n�����з�֧ͼ�ж�Ӧ��baseNode���������ϲ�
						n.mergeIndex(image.getElementByIndexObject(baseNode.getIndex()));
					}
	
					resultGraph.addTypedNode(n);
				}
	
			} catch (NothingReturnedException e) {
				e.printStackTrace();
			}
	
		});
		end = System.currentTimeMillis();
		System.out.println("*******parallelStream��������޸ĵ�TypedNodes��ӵ����ͼ�У�" + (end - start) + "ms");
	
		// ��������޸ĵ�TypedEdges��ӵ����ͼ��
		start = System.currentTimeMillis();
		ConcurrentHashMap<Thread, TypedEdge[]> map2 = new ConcurrentHashMap<>();
		baseGraph.allTypedEdges.parallelStream().forEach(baseEdge -> {
			
			TypedEdge[] typedEdgeImages;
			if((typedEdgeImages = map2.get(Thread.currentThread())) != null) {
				
			}else {
				typedEdgeImages = new TypedEdge[interSources.length];
				map2.put(Thread.currentThread(), typedEdgeImages);
			}
			
			// �����֧ͼ�ȷֱ�ͻ���ͼ���Ƚϣ�baseEdge������ֱ�洢��typedEdgeImages[i]�У�������baseEdge��imageEdge��null
			for (int i = 0; i < interSources.length; i++) {
				typedEdgeImages[i] = TypedGraph.computeImage(baseEdge, baseGraph, interSources[i]);
			}
	
			try {
				// �ٸ���typedEdgeImages[]�е������ȷ��finalEdgeInfo
				Tuple3<TypedNode, TypedNode, TypeEdge> finalEdgeInfo = TypedGraph.computeEdge(baseEdge,
						typedEdgeImages);
	
				if (finalEdgeInfo != null) {
					TypedNode source = resultGraph.getElementByIndexObject(finalEdgeInfo.first.getIndex());
					TypedNode target = resultGraph.getElementByIndexObject(finalEdgeInfo.second.getIndex());
					TypedEdge edge = new TypedEdge(); // ������Ķ���edge
					edge.setSource(source);
					edge.setTarget(target);
					edge.setType(finalEdgeInfo.third);
	
					for (TypedGraph image : interSources) { // �ϲ����з�֧ͼ��������
						edge.mergeIndex(image.getElementByIndexObject(baseEdge.getIndex()));
					}
					// �ⲿ�ֺ�ʱ���
					resultGraph.addTypedEdge(edge);	
				}
	
			} catch (NothingReturnedException e) {
				e.printStackTrace();
			}
		});
		end = System.currentTimeMillis();
		System.out.println("*******parallelStream��������޸ĵ�TypedEdges��ӵ����ͼ�У�" + (end - start) + "ms");
	
		// ��������޸ĵ�ValueEdges��ӵ����ͼ��
		start = System.currentTimeMillis();
		ConcurrentHashMap<Thread, ValueEdge[]> map3 = new ConcurrentHashMap<>();
		baseGraph.allValueEdges.parallelStream().forEach(baseEdge -> {
			
			ValueEdge[] valueEdgeImages;
			if((valueEdgeImages = map3.get(Thread.currentThread())) != null) {
				
			}else {
				valueEdgeImages = new ValueEdge[interSources.length];
				map3.put(Thread.currentThread(), valueEdgeImages);
			}
			
			// ������֧ͼ�Ⱥͻ���ͼ���Ƚϣ�baseEdge������ֱ�洢��valueEdgeImages[]�У�������null��baseEdge��imageEdge
			for (int i = 0; i < interSources.length; i++) {
				valueEdgeImages[i] = TypedGraph.computeImage(baseEdge, baseGraph, interSources[i]);
			}
	
			try {
				// �ٸ���valueEdgeImages[]�е������ȷ��finalEdgeInfo
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
		System.out.println("*******parallelStream��������޸ĵ�ValueEdges��ӵ����ͼ�У�" + (end - start) + "ms");
	
		
		resultGraph.allTypedEdges = allTypedEdges;
		// �¼�TypedEdges
		start = System.currentTimeMillis();
		for (TypedGraph image : interSources) {
			image.allTypedEdges.forEach(e -> {
				try { // ����e���������һ���ͼ��������Ӧ�Ķ����������������
					baseGraph.getElementByIndexObject(e.getIndex());
				} catch (Exception ex) { // ����ͼ��û���ҵ���Ӧ�Ķ���
					TypedEdge re = null;
					try {
						// ����e����������resultͼ��������Ӧ�Ķ����������ֵ��re
						re = resultGraph.getElementByIndexObject(e.getIndex());
					} catch (Exception ex2) { // ����e������û���ҵ�resultͼ����Ӧ�Ķ�����Ӧ���e��resultͼ��List<TypedEdge>��
	
						TypedNode source = null;
						TypedNode target = null;
						try {
							source = resultGraph.getElementByIndexObject(e.getSource().getIndex());
							target = resultGraph.getElementByIndexObject(e.getTarget().getIndex());
						} catch (NothingReturnedException e1) {
							e1.printStackTrace();
						}
	
						if (e.getSource() != source || e.getTarget() != target) { // ˵��e��source��target�ǻ���ͼ���еģ�resultͼ�ϲ�������ͼ��������������ͬһ����
							TypedEdge ne = new TypedEdge();
							ne.setSource(source);
							ne.setTarget(target);
							ne.setType(e.getType());
							ne.mergeIndex(e);
							resultGraph.addTypedEdge(ne);
						} else // ˵��e��source��target���ڷ�֧ͼ������ӵ�TypedNode���ͽڵ㣬�����ڷ�֧ͼ��resultͼ����ͬһ����
							resultGraph.addTypedEdge(e);
	
						re = null;
	
					} finally {
	
						// ����e�������ҵ���resultͼ����Ӧ�Ķ��󣬲���ֵ����re
						// ˵�������֧ͼ�������ͬ�ı�
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
								resultGraph.reindexing(re); // lyt�޸�
							}
						}
					}
				}
			});
		}
		end = System.currentTimeMillis();
		System.out.println("*******�¼�TypedEdges��" + (end - start) + "ms");
	
		resultGraph.allValueEdges = allValueEdges;
		// �¼�ValueEdges
		start = System.currentTimeMillis();
		for (TypedGraph image : interSources) {
			image.allValueEdges.forEach(e -> {
				try {
					// ����e���������һ���ͼ��������Ӧ�Ķ���������򲻴���
					baseGraph.getElementByIndexObject(e.getIndex());
				} catch (Exception ex) { // �������ͼ��û����Ӧ�Ķ���
					ValueEdge re = null;
					try {
						// ����e����������resultͼ��������Ӧ�Ķ����������ֵ��re
						re = resultGraph.getElementByIndexObject(e.getIndex());
					} catch (Exception ex2) { // ����e������û���ҵ�resultͼ����Ӧ�Ķ�������Ҫ���e��ͼ��List<ValueEdge>��
	
						TypedNode source = null;
						try {
							source = resultGraph.getElementByIndexObject(e.getSource().getIndex());
						} catch (NothingReturnedException e1) {
							e1.printStackTrace();
						}
	
						if (e.getSource() != source) { // source�ǻ���ͼ���еģ�resultͼ�ϲ�������ͼ����������������ͬһ����
							ValueEdge ne = new ValueEdge();
							ne.setSource(source);
							ne.setTarget(e.getTarget());
							ne.setType(e.getType());
							ne.mergeIndex(e);
							resultGraph.addValueEdge(ne);
						} else // e��source��resultͼ����ͬһ����˵��������ӵ�TypedNode����
							resultGraph.addValueEdge(e);
	
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
								resultGraph.reindexing(re); // lyt�޸�
							}
						}
					}
				}
			});
	
		}
		end = System.currentTimeMillis();
		System.out.println("*******�¼�ValueEdges��" + (end - start) + "ms");
	
		return resultGraph;
	}

	// ����computeOrd()
	public static List<TypedEdge> threeOrder(TypedGraph baseGraph, TypedGraph resultGraph,
			HashMap<TypedEdge, TypedEdge> forceOrd, TypedGraph... branchGraphs) {
	
		List<TypedEdge> resultList = resultGraph.getAllTypedEdges();
		List<TypedEdge> mergeList = new LinkedList<>(resultList);
		HashMap<TypedEdge, Integer> mergeFlag = new HashMap<>();
	
		for (int i = 0; i < resultList.size() - 1; i++) {
			TypedEdge ei = resultList.get(i);
			// ����mergeList��λ��ӳ��
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
				// ���ei��ej������ĳ����֧ͼ
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
					// ��ei��ej�������ڻ���ͼ
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
					} else if (t == 'S') { // o_k������o
						t = 'H';
						o = o_k;
					} else {
						throw new NothingReturnedException("@@@conflict");
					}
				} catch (NothingReturnedException e) {
					// ��ei��ej���Ƕ����ڻ���ͼ�����Է�֧ͼΪ׼
					t = t_k;
					o = o_k;
				}
			} catch (NothingReturnedException e) {
				// ���ei��ej���Ƕ�����ĳ����֧ͼ
			}
			ord_k.add(new Tuple2<Character, Character>(t, o));
		}
	
		// �ټ���ord
		Tuple2<Character, Character> t1 = ord_k.get(0);
		Tuple2<Character, Character> t2;
		// ����ei��ej��������
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
	
		// ringFlag�����ж����޻���ͻ
		HashMap<TypedEdge, TypedEdge> ringFlag = new HashMap<>();
		Iterator<Tuple2<TypedEdge, TypedEdge>> iterator = orders.iterator();
		while (iterator.hasNext()) {
			Tuple2<TypedEdge, TypedEdge> order = iterator.next();
			try {
				resultGraph.getElementByIndexObject(order.first.getIndex());
				resultGraph.getElementByIndexObject(order.second.getIndex());
				ringFlag.put(order.first, order.second);
			} catch (NothingReturnedException e) {
				// first��second�Ҳ����Ļ���ɾ����order
				iterator.remove();
			}
		}
		
		if (orders.size() == 0) {
			return orderMap;
		}
	
		// �ȼ������ϵ���ϵĺϷ���
		for (Tuple2<TypedEdge, TypedEdge> order : orders) {
	
			// ��⻷��ͻ
			// ���򣺲���ֱ��tmp = order������order������
			Tuple2<TypedEdge, TypedEdge> tmp = new Tuple2<>(order.first, order.second);
			while (ringFlag.get(tmp.second) != null) {
				if (ringFlag.get(tmp.second).equals(order.first)) {
					throw new NothingReturnedException("ǿ�������л���ͻ");
				}
				tmp.second = ringFlag.get(tmp.second);
			}
	
		}
	
		// ת��ΪHashMap
		for (Tuple2<TypedEdge, TypedEdge> order : orders) {
			orderMap.put(order.first, order.second);
		}
		return orderMap;
	}

}
