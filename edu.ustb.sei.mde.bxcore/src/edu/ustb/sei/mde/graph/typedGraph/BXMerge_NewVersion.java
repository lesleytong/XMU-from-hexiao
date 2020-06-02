package edu.ustb.sei.mde.graph.typedGraph;

import java.io.ObjectOutputStream.PutField;
/**
 * ����
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

	/** ����Ժϲ� */
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

	/** ��·�ϲ� */
	public static TypedGraph merge(TypedGraph baseGraph, TypedGraph... branchGraphs) throws NothingReturnedException {

		TypedGraph resultGraph = baseGraph.getCopy();

		Thread addTypedNodesThread = new Thread(new Runnable(){
			@Override
			public void run() {
				Profiler.begin();
				// �¼�TypedNodes
				for (TypedGraph branchGraph : branchGraphs) {
					for (TypedNode n : branchGraph.allTypedNodes) { // ���ڷ�֧ͼ��ÿ��TypedNode���͵Ľڵ�n
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
				// �¼�ValueNodes
				for (TypedGraph branch : branchGraphs) {
					branch.allValueNodes.forEach(v -> {
						resultGraph.addValueNode(v);
					});
				}
				System.out.println("*****addValueNodesThread: " + Profiler.end() + "ms");
			}
		});
		addValueNodesThread.start();
		
		
		
		// ���TypedEdges
		HashMap<TypedEdge, Tuple3<TypedNode, TypedNode, TypeEdge>> changeTypedEdgeMap = new HashMap<>();
		Thread deleteTypedEdgesThread = new Thread(new Runnable() {
			@Override
			public void run() {
				Profiler.begin();
				TypedEdge[] typedEdgeImages = new TypedEdge[branchGraphs.length];
				for (TypedEdge baseEdge : baseGraph.allTypedEdges) { // ���ڻ���ͼ��ÿһ��TypedEdge���͵ı�baseEdge

					// �����֧ͼ�ȷֱ�ͻ���ͼ���Ƚϣ�baseEdge������ֱ�洢��typedEdgeImages[i]�У�������baseEdge��imageEdge��null
					for (int i = 0; i < branchGraphs.length; i++) {
						typedEdgeImages[i] = TypedGraph.computeImage(baseEdge, baseGraph, branchGraphs[i]);
					}

					try {
						// �ٸ���typedEdgeImages[]�е������ȷ��finalEdgeInfo
						Tuple3<TypedNode, TypedNode, TypeEdge> finalEdgeInfo = TypedGraph.computeEdge(baseEdge,
								typedEdgeImages);

						if (finalEdgeInfo == null) {
							resultGraph.remove(baseEdge);
						} else {
							// ����ͼ�������֧ͼ��baseEdgeһ�£����߲�ͬ��֧ͼ�������޸ĵ��໥����
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
		
		// ��Ҫ���¼ӵ�TypedNodesִ���ꡢ�Լ��õ�changeTypedEdgeMap��
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
						TypedEdge edge = new TypedEdge(); // ������Ķ���edge
						edge.setSource(source);
						edge.setTarget(target);
						edge.setType(value.third);
						
						for (TypedGraph image : branchGraphs) { // �ϲ�������֧��������
							edge.mergeIndex(image.getElementByIndexObject(key.getIndex()));
						}
						
						resultGraph.replaceWith(key, edge); // ��baseEdge�滻Ϊedge
						
					} catch (NothingReturnedException e) {
						e.printStackTrace();
					}
				});
				System.out.println("*****changeTypedEdgesThread: " + Profiler.end() + "ms");
			}
		});
		changeTypedEdgesThread.start();
		
		
		
		// ���ValueEdges
		HashMap<ValueEdge, Tuple3<TypedNode, ValueNode, PropertyEdge>> changeValueEdgeMap = new HashMap<>();
		Thread deleteValueEdgesThread = new Thread(new Runnable() {
			@Override
			public void run() {
				Profiler.begin();
				ValueEdge[] valueEdgeImages = new ValueEdge[branchGraphs.length];
				for (ValueEdge baseEdge : baseGraph.allValueEdges) { // ���ڻ���ͼ��ÿһ����ValueEdge���͵ı�
					// ������֧ͼ�Ⱥͻ���ͼ���Ƚϣ�baseEdge������ֱ�洢��valueEdgeImages[]�У�������null��baseEdge��imageEdge
					for (int i = 0; i < branchGraphs.length; i++) {
						valueEdgeImages[i] = TypedGraph.computeImage(baseEdge, baseGraph, branchGraphs[i]);
					}

					try {
						// �ٸ���valueEdgeImages[]�е������ȷ��finalEdgeInfo
						Tuple3<TypedNode, ValueNode, PropertyEdge> finalEdgeInfo = TypedGraph.computeEdge(baseEdge,
								valueEdgeImages);

						if (finalEdgeInfo == null) {
							resultGraph.remove(baseEdge);
						} else {
							// ����ͼ�������֧ͼ��baseEdgeһ�£����߲�ͬ��֧ͼ�������޸ĵ��໥����
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
		
		// ��Ҫ���¼ӵ�TypedNodesִ���ꡢ�Լ��õ�changeValueEdgeMap��
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
		
		

	
		// ���TypedNodes��	��Ҫ���¼�TypedNodesִ����
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
				TypeNode[] nodeImages = new TypeNode[branchGraphs.length]; // ����length=2
				for (TypedNode baseNode : baseGraph.allTypedNodes) { // ���ڻ���ͼ��ÿһ��TypedNode�ڵ�

					for (int i = 0; i < branchGraphs.length; i++) {
						// ������֧ͼ�ȷֱ�ͻ���ͼ���Ƚϣ�baseNode������ֱ�洢��nodeImages[i]�С�������NULL��ANY���޸ĺ������
						nodeImages[i] = TypedGraph.computeImage(baseNode, baseGraph, branchGraphs[i]);
					}

					try {
						// �ٸ���nodeImages[]�е������ȷ��baseNode��finalType
						TypeNode finalType = TypedGraph.computeType(nodeImages, baseGraph.getTypeGraph());

						if (finalType == TypeNode.NULL_TYPE) { // ��ĳһ��֧��ɾ����������֧��ɾ��������resultͼ��Ҳɾ��
							deleteTypedNodesList.add(baseNode);
							resultGraph.remove2(baseNode);	// ��ʱֻɾ���ڵ㣬��δ�������ڱ�
						} else {

							if (finalType == TypeNode.ANY_TYPE) // �˽ڵ���������֧ͼ�ͻ���ͼ�е�����һ��
								finalType = baseNode.getType();

							TypedNode n = new TypedNode(); // ������Ľڵ�
							n.setType(finalType); // �����½ڵ�n�����ͣ��ͻ���ͼ��һ�������ͻ����滻�������
							for (TypedGraph branch : branchGraphs) {
								// ���½ڵ�n��������֧ͼ�ж�Ӧ��baseNode���������ϲ�
								n.mergeIndex(branch.getElementByIndexObject(baseNode.getIndex()));
							}
							// ��resultͼ�е�baseNode�滻Ϊn�����������resultͼ���滻��ɾ�����ڱ�
							resultGraph.replaceWith2(baseNode, n);	// ��ʱֻ�滻�ڵ㣬��δ�������ڱ�
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
		
		// �������ڵ�TypedEdge��
		// ��TypedEdge�޸��ꡢ�Լ��õ�deleteTypedNodesList��changeTypedNodesMap��
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
					// ����˽ڵ㻹��ĳ��TypedEdge���ͱ�e��source��target�˵㣬ɾ��������e
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
						// �������ڵ�TypedEdge���͵ı�
						List<TypedEdge> removedTypedEdges = new ArrayList<TypedEdge>();
						resultGraph.allTypedEdges.replaceAll(e -> { // ����resultͼ��List<TypedEdge>��ÿ��Ԫ��e
							TypeEdge edgeType = e.getType(); // �Ȼ�ȡe��type
							// �ٸ���edgeType���Ի��sourceType��targetType
							TypeNode sourceType = edgeType.getSource();
							TypeNode targetType = edgeType.getTarget();

							if (e.getSource() == nr && e.getTarget() == nr) { // 1.���e��source��target����nr�ڵ�
								// ����n��type(nodeType)��e��sourceType��targetType��������
								if (resultGraph.typeGraph.isSuperTypeOf(nodeType, sourceType)
										&& resultGraph.typeGraph.isSuperTypeOf(nodeType, targetType)) {
									TypedEdge res = new TypedEdge();
									res.setSource(n);
									res.setTarget(n);
									res.setType(edgeType);
									res.mergeIndex(e);
									resultGraph.reindexing(res);
									return res; // ��e�滻Ϊres
								} else { // ����n��type����e��sourceType |(&) targetType��������
									removedTypedEdges.add(e); // ��e��ӵ�removedTypedEdges������
									resultGraph.clearIndex(e); // ��Ԫ��e����������e��ӳ���ϵ����indexToObjectMap�����
									return e; // ��������ʱe->e
								}
							} else if (e.getSource() == nr) { // 2. ��e��source��nr��e��target����nr
								// ����n��type(nodeType)��e��sourceType��������
								if (resultGraph.typeGraph.isSuperTypeOf(nodeType, sourceType)) {
									TypedEdge res = new TypedEdge();
									res.setSource(n);
									res.setTarget(e.getTarget());
									res.setType(edgeType);
									res.mergeIndex(e);
									resultGraph.reindexing(res);
									return res;
								} else { // ����n��type����e��sourceType��������
									removedTypedEdges.add(e);
									resultGraph.clearIndex(e);
									return e;
								}
							} else if (e.getTarget() == nr) { // 3. ��e��target��nr��e��source����nr
								// ����n��type(nodeType)��e��targetType��������
								if (resultGraph.typeGraph.isSuperTypeOf(nodeType, targetType)) {
									TypedEdge res = new TypedEdge();
									res.setSource(e.getSource());
									res.setTarget(n);
									res.setType(edgeType);
									res.mergeIndex(e);
									resultGraph.reindexing(res);
									return res;
								} else { // ����n��type(nodeType)����e��targetType��������
									removedTypedEdges.add(e);
									resultGraph.clearIndex(e);
									return e;
								}
							} else // 4. e��source����nr��targetҲ����nr
								return e;
						});
						resultGraph.allTypedEdges.removeAll(removedTypedEdges); // ���ϲ���removeAll()��A <- A-B������A������ɾ��B����
					}
				});
				System.out.println("*****adjacentTypedEdgesThread: " + Profiler.end() + "ms");
			}
		});
		adjacentTypedEdgesThread.start();

		// �������ڵ�ValueEdge��
		// ��ValueEdge�޸��ꡢ�Լ��õ�deleteTypedNodesList��changeTypedNodesMap��
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
					// ����˽ڵ㻹��ĳ��ValueEdge���ͱ�e��source�˵㣬ɾ��������e
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
						// �������ڵ�ValueEdge���͵ı�
						List<ValueEdge> removedValueEdges = new ArrayList<ValueEdge>();
						resultGraph.allValueEdges.replaceAll(e -> { // ����resultͼ��List<ValueEdge>��ÿһ����e
							PropertyEdge edgeType = e.getType();
							TypeNode sourceType = edgeType.getSource();

							if (e.getSource() == nr) { // ���e��source��nr
								// ����n��type��e��sourceType�������ͣ���e�滻Ϊres
								if (resultGraph.typeGraph.isSuperTypeOf(nodeType, sourceType)) {
									ValueEdge res = new ValueEdge();
									res.setSource(n);
									res.setTarget(e.getTarget());
									res.setType(edgeType);
									res.mergeIndex(e);
									resultGraph.reindexing(res);
									return res;
								} else {
									// ����n��type��nr��type�����ݣ���ɾ��e
									removedValueEdges.add(e);
									resultGraph.clearIndex(e);
									return e;
								}
							} else
								return e; // ���e��source����nr������
						});
						resultGraph.allValueEdges.removeAll(removedValueEdges);
					}
				});
				System.out.println("*****adjacentValueEdgesThread: " + Profiler.end() + "ms");
			}
		});
		adjacentValueEdgesThread.start();
		
		
		
		// �¼�TypedEdges
		// ��TypedNode���¼ӡ�ɾ�����滻ִ���꣨����TypedEdge��Ҳ�������ˣ�
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
					for (TypedEdge e : image.allTypedEdges) { // ���ڷ�֧ͼ��ÿһ��TypedEdge��e
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
								
								if (e.getSource() != source || e.getTarget() != target) { // ˵��e��source����target�ǻ���ͼ���еģ�resultͼ�ϲ�������ͼ��������������ͬһ����
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
										}catch (NothingReturnedException e2) {
											e2.printStackTrace();
										}
									} else {
										re.mergeIndex(e);
										resultGraph.reindexing(re); // lyt�޸�
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
		
		
		
		// �¼�ValueEdges
		// ��TypedNode���¼ӡ�ɾ�����滻ִ���꣨���ڵ�ValueEdge�ߴ����꣩����ValueNode���¼�ִ����
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

								TypedNode source = null;
								try {
									source = resultGraph.getElementByIndexObject(e.getSource().getIndex());
								} catch (NothingReturnedException e1) {
									e1.printStackTrace();
								}
//										ValueNode target = e.getTarget();

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
					}
				}
				System.out.println("*****addValueEdgesThread: " + Profiler.end() + "ms");
			}
		});
		addValueEdgesThread.start();
		
		OrderInformation[] orders = new OrderInformation[branchGraphs.length];
		for (int i = 0; i < branchGraphs.length; i++)
			orders[i] = branchGraphs[i].order;
		resultGraph.order.merge(orders); // ��orders[i]�ϲ���result��order��

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

	public static ArrayList<TypedEdge> twoOrder(List<TypedEdge> baseList, List<TypedEdge> aList, List<TypedEdge> resultList) {

		HashMap<Index, Integer> resultFlag = new HashMap<>();
		for (int i = 0; i < resultList.size(); i++) {
			resultFlag.put(resultList.get(i).getIndex(), i);
		}

		ArrayList<TypedEdge> merge = new ArrayList<>(aList); // mergeList����aList

		// ɾ��merge�еĲ���result�еı�
		for (int i = 0; i < aList.size(); i++) {
			if (resultFlag.get(aList.get(i).getIndex()) != null) {
				continue;
			}
			merge.remove(aList.get(i));
		}

		// ���˺����merge.size() == result.size()����ֱ�ӷ���merge
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

		// ��baseList��ԭ�еı���ӽ�merge����aList��ɾ��������Ч��
		// ע�⣬����Ժϲ���resultList��û����������߶���ȥ�ϲ�������
		for (int i = 0; i < baseList.size(); i++) {

			// �������merge���ҵ���������
			if (mergeFlag.get(baseList.get(i).getIndex()) != null) {
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
					merge.add(j, baseList.get(i));
					break;
				} catch (NullPointerException e2) {
					// ���merge�е�Ԫ�ز�����base���ҵ���������
				}
			}

			// ���Ѿ�����mergeList����ӵ�merge��β
			if (j == merge.size()) {
				merge.add(baseList.get(i));
			}

		}

		return merge;
	}

	public static List<TypedEdge> twoOrder2(TypedGraph baseGraph, TypedGraph aGraph, TypedGraph resultGraph) {

		List<TypedEdge> aList = aGraph.getAllTypedEdges();
		ArrayList<TypedEdge> mergeList = new ArrayList<>(aList);	//����Ժϲ����滻��Ҳû�������¶���
		List<TypedEdge> resultList = resultGraph.getAllTypedEdges();
		List<TypedEdge> baseList = baseGraph.getAllTypedEdges();
		
		// ɾ��merge�еĲ���result�еıߣ���ΪaList�д��ڵı߲�һ����resultList�У�
		for (int i = 0; i < aList.size(); i++) {
			try {
				resultGraph.getElementByIndexObject(aList.get(i).getIndex());
			} catch (NothingReturnedException e) {
				mergeList.remove(aList.get(i));
			}
		}
		
		// ���˺����merge.size() == result.size()����ֱ�ӷ���merge
		if (mergeList.size() == resultList.size()) {
			return mergeList;
		}
		
		// ��baseList��ԭ�еı���ӽ�merge����aList��ɾ��������Ч��
		for (int i = 0; i < baseList.size(); i++) {
			
			try {
				aGraph.getElementByIndexObject(baseList.get(i).getIndex());
				// ���ҵ�������
				continue;
			} catch (NothingReturnedException e) {
				// �����ҵ���˵��Ҫ��ӽ�aList
				int j = 0;
				for (j = 0; j < mergeList.size(); j++) {
					try {
						TypedEdge ebase = baseGraph.getElementByIndexObject(mergeList.get(j).getIndex());
						if(i - baseList.indexOf(ebase) > 0) {
							continue;
						}else {
							mergeList.add(j, baseList.get(i)); // ����Ժϲ����¼Ӳ�û�������¶���
							break;
						}
					} catch (NothingReturnedException e1) {
					}
				}
				// ���Ѿ�����mergeList����ӵ�mergeList��β
				if (j == mergeList.size()) {
					mergeList.add(baseList.get(i));
				}
			}
		}
		
		return mergeList;
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

	// �����ڶ�ͼ�����ϵ
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
							// ʵ���ϣ�resultList������baseList������Ϣ
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
//								// �ڻ�ͼ�����ҵ����ӻ�ͼ���������
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
//								// �ڻ�ͼ�в����ҵ���˵�����¼ӵ�
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
						// ˵�����Ǵ˷�֧�¼ӵģ�����
						// ����һ������Ƿ�֧ͼֻ������Ԫ���Լ������Ԫ�ص�������
					}
				}
			}
		}
		return mergeList;
	}

	// ����ǿ�����ϵ
	public static List<TypedEdge> forceOrder(List<TypedEdge> mergeList, Set<Tuple2<Index, Index>> orders)
			throws NothingReturnedException {

		// helper�����ж�����������ͻ
		Map<Index, Integer> helper = new HashMap<>();
		for (int i = 0; i < mergeList.size(); i++) {
			helper.put(mergeList.get(i).getIndex(), 0);
		}

		// ringFlag�����ж����޻���ͻ
		HashMap<Index, Index> ringFlag = new HashMap<>();
		Iterator<Tuple2<Index, Index>> iterator = orders.iterator();
		while (iterator.hasNext()) {
			Tuple2<Index, Index> order = iterator.next();
			if (helper.get(order.first) != null && helper.get(order.second) != null) {
				ringFlag.put(order.first, order.second);
			} else {
				// first��second�Ҳ����Ļ���ɾ����order
				iterator.remove();
			}
		}

		// �ȼ������ϵ���ϵĺϷ���
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
			Tuple2<Index, Index> tmp = new Tuple2<>(order.first, order.second); // ���򣺲���ֱ��tmp = order������order������
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
			// ÿ��ѭ���ﶼҪ���¸���mergeFlag
			for (int i = 0; i < mergeList.size(); i++) {
				mergeFlag.put(mergeList.get(i).getIndex(), i);
			}

			// Index���hashCode()��equals()��д�ˣ�ֻҪIndex������ڲ��������н����������ҵ�
			int firstPosition = mergeFlag.get(order.first);
			int secondPosition = mergeFlag.get(order.second);

			// �д��жϣ��ɼ��ٲ���Ҫ����
			if (secondPosition == firstPosition + 1)
				continue;

			TypedEdge front = mergeList.get(firstPosition);
			TypedEdge back = mergeList.get(secondPosition);

			// ���helper��firstΪ1��secondΪ2����front������Ĭ�ϣ�
			// ���helper��firstΪ2��secondΪ2����frontҲ����
			if (helper.get(order.first) == 1 && helper.get(order.second) == 2
					|| helper.get(order.first) == 2 && helper.get(order.second) == 2) {
				mergeList.remove(back);
				mergeList.add(mergeList.indexOf(front) + 1, back);
			}
			// ���helper��firstΪ1��secondΪ1����back����
			else if (helper.get(order.first) == 1 && helper.get(order.second) == 1) {
				mergeList.remove(front);
				mergeList.add(mergeList.indexOf(back), front);
			}

			// ���helper��firstΪ2��secondΪ1����<back, back+1>����
			// ��<front-1, front>�Ƶ���ǰ��
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

	// ��getElementByIndexObject()
	public static List<TypedEdge> forceOrder2(List<TypedEdge> mergeList, Set<Tuple2<TypedEdge, TypedEdge>> orders,
			TypedGraph resultGraph) throws NothingReturnedException {

		// helper�����ж�����������ͻ
		Map<TypedEdge, Integer> helper = new HashMap<>();
		for (int i = 0; i < mergeList.size(); i++) {
			helper.put(mergeList.get(i), 0);
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

		// �ȼ������ϵ���ϵĺϷ���
		for (Tuple2<TypedEdge, TypedEdge> order : orders) {

			TypedEdge efirst = resultGraph.getElementByIndexObject(order.first.getIndex());
			TypedEdge esecond = resultGraph.getElementByIndexObject(order.second.getIndex());

			int firstHelper = helper.get(efirst);
			int secondHelper = helper.get(esecond);

			switch (firstHelper) {
			case 0:
				helper.replace(efirst, 1); // �ĳ�1
				break;
			case 1:
				throw new NothingReturnedException("ǿ��������<x, y>&&<x, z>��ͻ");
			default:
				// ��firstΪ2ʱ��������£�
				break;
			}

			switch (secondHelper) {
			case 0:
				helper.replace(esecond, 2); // �ĳ�2
				break;
			case 2:
				throw new NothingReturnedException("ǿ��������<y, x>&&<z, x>��ͻ");
			default:
				// ��secondΪ1ʱ��������£�
				break;
			}

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
		
		
		// �Ϸ�����ִ��ǿ����
		for (Tuple2<TypedEdge, TypedEdge> order : orders) {
	
			TypedEdge front = resultGraph.getElementByIndexObject(order.first.getIndex());
			TypedEdge back = resultGraph.getElementByIndexObject(order.second.getIndex());
			
			// mergeList�ڱ�
			int firstPosition = mergeList.indexOf(front);
			int secondPosition = mergeList.indexOf(back);

			// �д��жϣ��ɼ��ٲ���Ҫ����
			if (secondPosition == firstPosition + 1)
				continue;

			// ���helper��firstΪ1��secondΪ2����front������Ĭ�ϣ�
			// ���helper��firstΪ2��secondΪ2����frontҲ����
			if (helper.get(front) == 1 && helper.get(back) == 2
					|| helper.get(front) == 2 && helper.get(back) == 2) {
				mergeList.remove(back);
				mergeList.add(mergeList.indexOf(front) + 1, back);
			}
			// ���helper��firstΪ1��secondΪ1����back����
			else if (helper.get(front) == 1 && helper.get(back) == 1) {
				mergeList.remove(front);
				mergeList.add(mergeList.indexOf(back), front);
			}

			// ���helper��firstΪ2��secondΪ1����<back, back+1>����
			// ��<front-1, front>�Ƶ���ǰ��
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
