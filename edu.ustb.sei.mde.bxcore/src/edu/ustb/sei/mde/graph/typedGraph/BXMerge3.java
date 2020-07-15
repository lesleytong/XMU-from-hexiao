package edu.ustb.sei.mde.graph.typedGraph;

/**
 * ���кϲ���
 * �𲽹������ͼ��
 * Ч����߸����ˡ�
 */

import edu.ustb.sei.mde.bxcore.exceptions.NothingReturnedException;
import edu.ustb.sei.mde.graph.type.PropertyEdge;
import edu.ustb.sei.mde.graph.type.TypeEdge;
import edu.ustb.sei.mde.graph.type.TypeNode;
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
		TypedEdge[] typedEdgeImages = new TypedEdge[interSources.length];
		for (TypedEdge baseEdge : baseGraph.allTypedEdges) { // ���ڻ���ͼ��ÿһ��TypedEdge���͵ı�baseEdge

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
					resultGraph.addTypedEdge(edge);
				}

			} catch (NothingReturnedException e) {
				throw e; // ��׽���쳣���׳�
			}
		}
		System.out.println("*******���н�������޸ĵ�TypedEdges��ӵ����ͼ�У�" + Profiler.end() + "ms");

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
			// �¼����ValueEdge
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
						// ValueNode target = e.getTarget();

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

}
