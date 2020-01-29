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

	/** ��ͼ�ϲ� */
	public static TypedGraph additiveMerge(TypedGraph first, TypedGraph graph) {
		// �Ȱѵ�һ��ͼ������result�����ж��������һ��
		TypedGraph result = first.getCopy();

		// ���ڵڶ���ͼgraph�е�ÿ��TypedNode���͵Ľڵ�n
		graph.getAllTypedNodes().forEach(n -> {
			try {
				// ����n����������resultͼ���Ƿ�����Ӧ�Ķ�������ҵ����丳ֵ��nr
				TypedNode nr = result.getElementByIndexObject(n.getIndex());
				// ���nr==n�������������nr!=n����nr�滻Ϊn
				if (nr != n) {
					result.replaceWith(nr, n);
				}
			} catch (NothingReturnedException e) {
				// �������n��������resultͼ��û���ҵ���˵��n�ǵڶ���ͼgraph������ӵĽڵ㣬������ӵ�resultͼ��
				result.addTypedNode(n);
			}
		});

		// ���ڵڶ���ͼgraph�е�ÿ��ValueNode���͵Ľڵ�n��ȫ����ӵ�result��
		graph.getAllValueNodes().forEach(n -> {
			result.addValueNode(n);
		});

		// ���ڵڶ���ͼgraph��ÿ��TypedEdge���͵ı�e
		graph.getAllTypedEdges().forEach(e -> {
			try {
				// ����e������������result�е�TypedEdge���͵ıߣ�����ҵ���ֵ��er
				TypedEdge er = result.getElementByIndexObject(e.getIndex());
				// ���er==e�������������er!=e����er�滻Ϊe
				if (er != e) {
					result.replaceWith(er, e);
				}
			} catch (NothingReturnedException ex) {
				// �������e������û���ҵ�resultͼ�еıߣ�˵��e��graphͼ������ӵģ�������ӵ�resultͼ��
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

		// λ��Լ����ϵ
		result.order.merge(graph.order);

		result.constraint = GraphConstraint.and(first.constraint, graph.constraint);

		// check

		return result;
	}

	/** ��ͼ�ϲ� */
	public static TypedGraph merge(TypedGraph first, TypedGraph... interSources) throws NothingReturnedException {

		TypedGraph result = first.getCopy();

		// �����¼���ĵ�ͱ�
		for (TypedGraph image : interSources) {

			// �¼����TypedNode
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

						if (rn != null) { // ���rn!=null��˵������n�������ҵ���resultͼ����Ӧ�Ķ����Ҹ�ֵ����rn
							TypeNode lt = rn.getType();
							TypeNode rt = n.getType();
							TypeNode ct = first.getTypeGraph().computeSubtype(lt, rt); // ���յ�����

							if (ct == TypeNode.NULL_TYPE) {
								throw new NothingReturnedException(); // incompatible
							} else {
								rn.setType(ct); // �����ݣ���rn��type����Ϊct
								rn.mergeIndex(n);
								result.reindexing(rn); // lyt-�޸�
							}
						}
					}
				}
			}

			// �¼����TypedEdge
			for (TypedEdge e : image.allTypedEdges) { // ���ڷ�֧ͼ��ÿһ��TypedEdge��e

				try { // ����e���������һ���ͼ��������Ӧ�Ķ����������������
					first.getElementByIndexObject(e.getIndex());
				} catch (Exception ex) { // ����ͼ��û���ҵ���Ӧ�Ķ���
					TypedEdge re = null;
					try {
						// ����e����������resultͼ��������Ӧ�Ķ����������ֵ��re
						re = result.getElementByIndexObject(e.getIndex());
					} catch (Exception ex2) { // ����e������û���ҵ�resultͼ����Ӧ�Ķ�����Ӧ���e��resultͼ��List<TypedEdge>��

						/*
						 * ��Ȼeû��resultͼ�У�����Ȼ���ڷ�֧ͼ���¼�e��˵��resultͼ��һ�����ڶ�Ӧ��source��target�ڵ㣿��
						 * ��������ڣ�˵���г�ͻ���ϲ��޷��������С� ��д��try�����˵��������
						 */
						TypedNode source = result.getElementByIndexObject(e.getSource().getIndex());
						TypedNode target = result.getElementByIndexObject(e.getTarget().getIndex());

						if (e.getSource() != source || e.getTarget() != target) { // ˵��e��source��target�ǻ���ͼ���еģ�resultͼ�ϲ�������ͼ��������������ͬһ����
							TypedEdge ne = new TypedEdge();
							ne.setSource(source);
							ne.setTarget(target);
							ne.setType(e.getType());
							ne.mergeIndex(e);
							result.addTypedEdge(ne);
						} else // ˵��e��source��target���ڷ�֧ͼ������ӵ�TypedNode���ͽڵ㣬�����ڷ�֧ͼ��resultͼ����ͬһ����
							result.addTypedEdge(e);

						re = null;

					} finally {

						// ����e�������ҵ���resultͼ����Ӧ�Ķ��󣬲���ֵ����re
						if (re != null) {
							if (re.getType() != e.getType()
									|| !re.getSource().getIndex().equals(e.getSource().getIndex())
									|| !re.getTarget().getIndex().equals(e.getTarget().getIndex())) {
								throw new NothingReturnedException();
							} else {
								re.mergeIndex(e);
								result.reindexing(re); // lyt�޸�
							}
						}
					}
				}
			}

			// �¼����ValueEdge
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
						 * result��û��ValueEdge���͵ı�e����һ������source�ڵ㣿�� ��������ڣ�˵���г�ͻ���ϲ��޷������� ��д��try�����˵��������
						 */
						TypedNode source = result.getElementByIndexObject(e.getSource().getIndex());
//								ValueNode target = e.getTarget();

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
								throw new NothingReturnedException();
							} else {
								re.mergeIndex(e);
								result.reindexing(re); // lyt�޸�
							}
						}
					}
				}
			}

		}

		// ����TypedNode�ı�����
		TypeNode[] nodeImages = new TypeNode[interSources.length]; // ����length=2
		for (TypedNode baseNode : first.getAllTypedNodes()) { // ���ڻ���ͼ��ÿһ��TypedNode�ڵ�

			for (int i = 0; i < interSources.length; i++) {
				// ������֧ͼ�ȷֱ�ͻ���ͼ���Ƚϣ�baseNode������ֱ�洢��nodeImages[i]�С�������NULL��ANY���޸ĺ������
				nodeImages[i] = TypedGraph.computeImage(baseNode, first, interSources[i]);
			}

			try {
				// �ٸ���nodeImages[]�е������ȷ��baseNode��finalType
				TypeNode finalType = TypedGraph.computeType(nodeImages, first.getTypeGraph());

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
				throw e; // ��׽���쳣���׳�
			}
		}

		// ����ValueNode����֧ͼ�����е�ValueNodeȫ���ӽ�resultͼ��
		for (TypedGraph image : interSources) {
			image.getAllValueNodes().forEach(v -> {
				result.addValueNode(v);
			});
		}

		// ����TypedEdge�ı�����
		TypedEdge[] typedEdgeImages = new TypedEdge[interSources.length];
		for (TypedEdge baseEdge : first.getAllTypedEdges()) { // ���ڻ���ͼ��ÿһ��TypedEdge���͵ı�baseEdge

			// ������֧ͼ�ȷֱ�ͻ���ͼ���Ƚϣ�baseEdge������ֱ�洢��typedEdgeImages[i]�У�������baseEdge��imageEdge��null
			for (int i = 0; i < interSources.length; i++) {
				typedEdgeImages[i] = TypedGraph.computeImage(baseEdge, first, interSources[i]);
			}

			try {
				// �ٸ���typedEdgeImages[]�е������ȷ��finalEdgeInfo
				Tuple3<TypedNode, TypedNode, TypeEdge> finalEdgeInfo = TypedGraph.computeEdge(baseEdge,
						typedEdgeImages);

				if (finalEdgeInfo == null) {
					result.remove(baseEdge);
				} else {

					TypedNode source = result.getElementByIndexObject(finalEdgeInfo.first.getIndex());
					TypedNode target = result.getElementByIndexObject(finalEdgeInfo.second.getIndex());
					TypedEdge edge = new TypedEdge(); // ������Ķ���
					edge.setSource(source);
					edge.setTarget(target);
					edge.setType(finalEdgeInfo.third);

					for (TypedGraph image : interSources) {
						edge.mergeIndex(image.getElementByIndexObject(baseEdge.getIndex()));
					}

					result.replaceWith(baseEdge, edge);
				}
			} catch (NothingReturnedException e) {
				throw e; // ��׽���쳣���׳�
			}
		}

		// ����ValueEdge�ı�����
		ValueEdge[] valueEdgeImages = new ValueEdge[interSources.length];
		for (ValueEdge baseEdge : first.getAllValueEdges()) { // ���ڻ���ͼ��ÿһ����ValueEdge���͵ı�

			// ������֧ͼ�Ⱥͻ���ͼ���Ƚϣ�baseEdge������ֱ�洢��valueEdgeImages[]�У�������null��baseEdge��imageEdge
			for (int i = 0; i < interSources.length; i++) {
				valueEdgeImages[i] = TypedGraph.computeImage(baseEdge, first, interSources[i]);
			}

			try {
				// �ٸ���valueEdgeImages[]�е������ȷ��finalEdgeInfo
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
		result.order.merge(orders); // ��orders[i]�ϲ���result��order��

		List<GraphConstraint> cons = new ArrayList<>();
		cons.add(first.getConstraint());
		for (TypedGraph g : interSources) {
			cons.add(g.constraint);
		}
		result.constraint = GraphConstraint.and(cons);
		// check

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

		if (a.size() == result.size()) {
			System.out.println("**********a��result��size��ȣ����յ����ϵ����a�����ϵ��\n" + a);
			return a;
		} else {

			Map<TypedEdge, Integer> baseFlag = new HashMap<>();
			for (int i = 0; i < base.size(); i++) {
				baseFlag.put(base.get(i), i);
			}

			List<TypedEdge> merge = new ArrayList<>();
			merge.addAll(a);

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
							TypedEdge typedEdge = baseGraph.getElementByIndexObject(merge.get(j).getIndex());

							int tmp = baseFlag.get(base.get(i)) - baseFlag.get(typedEdge);

							if (tmp > 0) {
								continue;
							} else {
								merge.add(j, base.get(i));
								System.out.println("�غ�" + round++ + merge);
								break;
							}

						} catch (NothingReturnedException e2) {
							// �������merge(j)��������baseGraph��û�ҵ���������
//							continue;	//���Բ�дcontinue
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

	}

	/** ����ϲ����� */
	public static List<TypedEdge> twoOrder(TypedGraph baseGraph, TypedGraph aGraph, TypedGraph resultGraph) {

		List<TypedEdge> base = baseGraph.getAllTypedEdges();
		System.out.println("base: " + base);

		List<TypedEdge> a = aGraph.getAllTypedEdges();
		System.out.println("a: " + a);

		List<TypedEdge> result = resultGraph.getAllTypedEdges();
		System.out.println("result: " + result);

		int round = 1;

		List<TypedEdge> merge = new ArrayList<>();

		// ����a��Ԫ�أ������������������result���ҵ����򲻻���ӽ�merge
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

	/** ����front��back */
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
		int round = 1; // �غϼ���

		// ����base��ÿ��Ԫ��
		for (int i = 0; i < base.size(); i++) {

			try {
				// ����base.get(i)����������resultGraph������ҵ����򸳸�element
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

							if (aFlag.get(aGraph.getElementByIndexObject(base.get(j).getIndex())) == "back"
									&& bFlag.get(bGraph.getElementByIndexObject(base.get(j).getIndex())) == "back") {
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

							if (aFlag.get(aGraph.getElementByIndexObject(base.get(j).getIndex())) == "back"
									&& bFlag.get(bGraph.getElementByIndexObject(base.get(j).getIndex())) == "back") {
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

					// Ϊ���ҵ���Ԫ�صĲ���㣬aMap��������if����
					Map<TypedEdge, String> aMap = new HashMap<>();
					for (int j = 0; j < i; j++) {

						try {
							TypedEdge re = resultGraph.getElementByIndexObject(a.get(j).getIndex());
							aMap.put(re, "exist");
						} catch (NothingReturnedException e2) {
							// �������resultGraph�У�������
							continue;
						}

					}

					int k;
					for (k = 0; k < merge.size(); k++) {
						// aMap����if������������㣬˵������Ԫ�ػ�Ӧ���������
						if (aMap.get(merge.get(k)) == "exist") {
							continue;
						} else {
							merge.add(k, element);
							break;
						}
					}

					// �������aMap�У���elementӦ�ò��뵽merge�б����
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
			// �����aGraph�У���������Ϊ�˲��ظ���ӣ�
			try {
				// �����baseGraph�У�������
				baseGraph.getElementByIndexObject(b.get(i).getIndex());
				continue;

			} catch (NothingReturnedException e) {

				try {
					// �������baseGraph�е���aGraph�У���������Ϊ�˲��ظ���ӣ�
					aGraph.getElementByIndexObject(b.get(i).getIndex());
					continue;

				} catch (NothingReturnedException e1) {

					try {
						// �������baseGraph���ֲ���aGraph�У�����resultGraph�У��������²���
						TypedEdge element = resultGraph.getElementByIndexObject(b.get(i).getIndex()); // ����

						// Ϊ���ҵ���Ԫ�صĲ���㣬bMap��������if����
						Map<TypedEdge, String> bMap = new HashMap<>();
						for (int j = 0; j < i; j++) {

							try {
								TypedEdge re = resultGraph.getElementByIndexObject(b.get(j).getIndex());
								bMap.put(re, "exist");
							} catch (NothingReturnedException e3) {
								// �������resultGraph�У�������
								continue;
							}

						}

						int k;
						for (k = 0; k < merge.size(); k++) {

							// intermediate����if�ĵڶ���������a��֧��Ԫ������ӽ�merge�У�Ϊ�˷�ֹb��֧����Ԫ�ز��λ��
							if (bMap.get(merge.get(k)) == "exist" || !intermediate.contains(merge.get(k))) {
								continue;
							} else {
								merge.add(k, element);
								break;
							}

						}

						// �������bMap�У���elementӦ�ò��뵽merge�б����
						if (k == merge.size()) {
							merge.add(element);
						}

						System.out.println("����b��һ������ӵ�Ԫ�غ�merge: " + merge);

					} catch (NothingReturnedException e2) {
						// �������baseGraph���ֲ���aGraph�У��Ҳ���resultGraph�У�������
						continue;
					}

				}
			}

		}

		System.out.println("\n���������merge: " + merge);

		return merge;
	}

	/** ����HashMap<TypedEdge, Integer> */
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
		int round = 1; // �غϼ���

		Map<TypedEdge, Integer> aFlag = new HashMap<>();
		for (int i = 0; i < a.size(); i++) {
			aFlag.put(a.get(i), i);
		}

		Map<TypedEdge, Integer> bFlag = new HashMap<>();
		for (int i = 0; i < b.size(); i++) {
			bFlag.put(b.get(i), i);
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

							int aSubtract = aFlag.get(aGraph.getElementByIndexObject(base.get(j).getIndex()))
									- aFlag.get(aGraph.getElementByIndexObject(base.get(i).getIndex()));

							int bSubtract = bFlag.get(bGraph.getElementByIndexObject(base.get(j).getIndex()))
									- bFlag.get(bGraph.getElementByIndexObject(base.get(i).getIndex()));

							if (aSubtract > 0 && bSubtract > 0) {
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
			// �����aGraph�У���������Ϊ�˲��ظ���ӣ�
			try {
				// �����baseGraph�У�������
				baseGraph.getElementByIndexObject(b.get(i).getIndex());
				continue;

			} catch (NothingReturnedException e) {

				try {
					// �������baseGraph�е���aGraph�У���������Ϊ�˲��ظ���ӣ�
					aGraph.getElementByIndexObject(b.get(i).getIndex());
					continue;

				} catch (NothingReturnedException e1) {

					try {
						// �������baseGraph���ֲ���aGraph�У�����resultGraph�У��������²���
						TypedEdge element = resultGraph.getElementByIndexObject(b.get(i).getIndex()); // ����

						int k;
						for (k = 0; k < merge.size(); k++) {

							// intermediate����if�ĵڶ���������a��֧��Ԫ������ӽ�merge�У�Ϊ�˷�ֹb��֧����Ԫ�ز��λ��
							// ����bug: ����������ź����bFlagû�ҵ����ᴦ��b����һ��Ԫ��
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

						System.out.println("����b��һ������ӵ�Ԫ�غ�merge: " + merge);

					} catch (NothingReturnedException e2) {
						// �������baseGraph���ֲ���aGraph�У��Ҳ���resultGraph�У�������
						continue;
					}

				}
			}

		}

		System.out.println("\n���������merge: " + merge);

		return merge;
	}

	/** ����HashMap<Index, Integer> */
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
			// �����aGraph�У���������Ϊ�˲��ظ���ӣ�
			try {
				// �����baseGraph�У�������
				baseGraph.getElementByIndexObject(b.get(i).getIndex());
				continue;

			} catch (NothingReturnedException e) {

				try {
					// �������baseGraph�е���aGraph�У���������Ϊ�˲��ظ���ӣ�
					aGraph.getElementByIndexObject(b.get(i).getIndex());
					continue;

				} catch (NothingReturnedException e1) {

					try {
						// �������baseGraph���ֲ���aGraph�У�����resultGraph�У��������²���
						TypedEdge element = resultGraph.getElementByIndexObject(b.get(i).getIndex()); // ����

						int k;
						for (k = 0; k < merge.size(); k++) {

							// intermediate����if�ĵڶ���������a��֧��Ԫ������ӽ�merge�У�Ϊ�˷�ֹb��֧����Ԫ�ز��λ��
							// ����bug: �����һ��bFlagû�ҵ������׳��쳣
//							int tmp = bFlag.get(merge.get(k).getIndex()) - bFlag.get(b.get(i).getIndex());
//							if (tmp < 0 || !intermediate.contains(merge.get(k))) {
//								continue;
//							} else {
//								merge.add(k, element);
//								break;
//							}
							
							if(!intermediate.contains(merge.get(k))) {
								continue;	//˵����merge����ӽ���a��֧��Ԫ��
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

						System.out.println("����b��һ������ӵ�Ԫ�غ�merge: " + merge);

					} catch (NothingReturnedException e2) {
						// �������baseGraph���ֲ���aGraph�У��Ҳ���resultGraph�У�������
						continue;
					}

				}
			}

		}

		System.out.println("\n���������merge: " + merge);

		return merge;
	}

	// ����ǿ�����ϵ
	public static List<TypedEdge> forceOrder(List<TypedEdge> merge, Set<Tuple2<Index, Index>> orders) throws NothingReturnedException {

		Map<Index, Integer> mergeFlag = new HashMap<>();
		Map<Integer, Integer> helper = new HashMap<>();
		for (int i = 0; i < merge.size(); i++) {
			mergeFlag.put(merge.get(i).getIndex(), i);
			helper.put(i, 0);
		}

		for (Tuple2<Index, Index> order : orders) {
			
			try {
				
				// Index���hashCode()��equals()��д�ˣ�ֻҪIndex������ڲ��������н����������ҵ�
				int first = mergeFlag.get(order.first);
				int second = mergeFlag.get(order.second);
				
				if(helper.get(first)==2 && helper.get(second)==1) {
					throw new NothingReturnedException("ǿ�����й��ɻ���������ͻ");
				}
				
				if(helper.get(first)==1) {
					throw new NothingReturnedException("ǿ��������<x, y>&&<x, z>��ͻ");
				}
				if(helper.get(first)==0) {
					helper.replace(first, 1);	// �ĳ�1��ע��˳��
				}
			
				if(helper.get(second)==2) {
					throw new NothingReturnedException("ǿ��������<y, x>&&<z, x>��ͻ");
				}
				if(helper.get(second)==0) {
					helper.replace(second, 2);	//�ĳ�2
				}
				
				// �д��жϣ��ɼ��ٲ���Ҫ����
				if (second == first + 1)
					continue;

				TypedEdge front = merge.get(first);
				TypedEdge back = merge.get(second);
				merge.remove(back);
				merge.add(merge.indexOf(front)+1, back);
				
			} catch (NullPointerException e) {
				// first��second�Ҳ����Ļ���catch���ﲻ��������������order
			}			
		}

		System.out.println("������Լ����Ϣ��merge: " + merge);
		
		return merge;
	}

}
