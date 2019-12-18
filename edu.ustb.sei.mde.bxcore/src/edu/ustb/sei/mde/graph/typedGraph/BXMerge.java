package edu.ustb.sei.mde.graph.typedGraph;

import java.util.ArrayList;
import java.util.List;

import edu.ustb.sei.mde.bxcore.exceptions.NothingReturnedException;
import edu.ustb.sei.mde.graph.type.PropertyEdge;
import edu.ustb.sei.mde.graph.type.TypeEdge;
import edu.ustb.sei.mde.graph.type.TypeNode;
import edu.ustb.sei.mde.graph.typedGraph.constraint.GraphConstraint;
import edu.ustb.sei.mde.structure.Tuple3;

public class BXMerge {
	
	/** ��ͼ�ϲ�  */
	public static TypedGraph additiveMerge(TypedGraph first, TypedGraph graph) {
		//�Ȱѵ�һ��ͼ������result�����ж��������һ��
		TypedGraph result = first.getCopy();	
		
		//���ڵڶ���ͼgraph�е�ÿ��TypedNode���͵Ľڵ�n
		graph.getAllTypedNodes().forEach(n->{ 
			try {
				//����n����������resultͼ���Ƿ�����Ӧ�Ķ�������ҵ����丳ֵ��nr
				TypedNode nr = result.getElementByIndexObject(n.getIndex());
				//���nr==n�������������nr!=n����nr�滻Ϊn
				if(nr!=n) {
					result.replaceWith(nr, n);
				}
			} catch (NothingReturnedException e) {
				//�������n��������resultͼ��û���ҵ���˵��n�ǵڶ���ͼgraph������ӵĽڵ㣬������ӵ�resultͼ��
				result.addTypedNode(n);
			}
		});
		
		//���ڵڶ���ͼgraph�е�ÿ��ValueNode���͵Ľڵ�n��ȫ����ӵ�result��
		graph.getAllValueNodes().forEach(n->{
			result.addValueNode(n);
		});
		
		//���ڵڶ���ͼgraph��ÿ��TypedEdge���͵ı�e
		graph.getAllTypedEdges().forEach(e->{
			try {
				//����e������������result�е�TypedEdge���͵ıߣ�����ҵ���ֵ��er
				TypedEdge er = result.getElementByIndexObject(e.getIndex());
				//���er==e�������������er!=e����er�滻Ϊe
				if(er!=e) {
					result.replaceWith(er, e);
				}
			} catch (NothingReturnedException ex) {
				//�������e������û���ҵ�resultͼ�еıߣ�˵��e��graphͼ������ӵģ�������ӵ�resultͼ��
				result.addTypedEdge(e);
			}
		});
		
		//���ڵڶ���ͼgraph��ÿ��ValueEdge���͵ı�e
		graph.getAllValueEdges().forEach(e->{
			try {
				//����e������������resultͼ�еıߣ�����ҵ���ֵ��er
				ValueEdge er = result.getElementByIndexObject(e.getIndex());
				//���er==e�������������er!=e����er�滻Ϊe
				if(er!=e) {
					result.replaceWith(er, e);
				}
			} catch (NothingReturnedException ex) {
				//�������e������û���ҵ�resultͼ�еıߣ�˵��e��graphͼ���¼ӵģ������e��resultͼ��
				result.addValueEdge(e);
			}
		});
		
		//�����result�е�λ����Ϣ?
		result.order.merge(graph.order);
		
		result.constraint = GraphConstraint.and(first.constraint, graph.constraint);
		// check 
		
		return result;
	}

	
	
	
	
	
	/** ��ͼ�ϲ� */
	public static TypedGraph merge(TypedGraph first, TypedGraph... interSources) throws NothingReturnedException {
		
		TypedGraph result = first.getCopy(); 
		
		//����TypedNode�ı�����
		TypeNode[] nodeImages = new TypeNode[interSources.length];	//����length=2
		for(TypedNode baseNode : first.getAllTypedNodes()) {	//���ڻ���ͼ��ÿһ��TypedNode�ڵ�
			
			for(int i=0;i<interSources.length;i++) {
				//������֧ͼ�ȷֱ�ͻ���ͼ���Ƚϣ�baseNode������ֱ�洢��nodeImages[i]�С�������NULL��ANY���޸ĺ������
				nodeImages[i] = TypedGraph.computeImage(baseNode, first, interSources[i]);	
			}
			
			try {
				//�ٸ���nodeImages[]�е������ȷ��baseNode��finalType
				TypeNode finalType = TypedGraph.computeType(nodeImages, first.getTypeGraph());	
				
				if(finalType==TypeNode.NULL_TYPE) { //��ĳһ��֧��ɾ����������֧��ɾ��������resultͼ��Ҳɾ��
					result.remove(baseNode);
				} else {
					
					if(finalType==TypeNode.ANY_TYPE)	//�˽ڵ���������֧ͼ�ͻ���ͼ�е�����һ��
						finalType = baseNode.getType();	
					
					TypedNode n = new TypedNode(); 
					n.setType(finalType);	//�����½ڵ�n�����ͣ��ͻ���ͼ��һ�������ͻ����滻�������
					
					for(TypedGraph image : interSources) {
						//���½ڵ�n��������֧ͼ�ж�Ӧ��baseNode���������ϲ�
						n.mergeIndex(image.getElementByIndexObject(baseNode.getIndex())); 
					}
					
					result.replaceWith(baseNode, n);	//��resultͼ�е�baseNode�滻Ϊn
				}
				
			} catch (NothingReturnedException e) {	
				throw e;	//��׽���쳣���׳�
			}
		}
		
		// ����ValueNode����֧ͼ�����е�ValueNodeȫ���ӽ�resultͼ��
		for(TypedGraph image : interSources) {
			image.getAllValueNodes().forEach(v->{result.addValueNode(v);});
		}
		
		// ����TypedEdge�ı�����
		TypedEdge[] typedEdgeImages = new TypedEdge[interSources.length];
		for(TypedEdge baseEdge : first.getAllTypedEdges()) {	//���ڻ���ͼ��ÿһ��TypedEdge���͵ı�baseEdge
			
			//������֧ͼ�ȷֱ�ͻ���ͼ���Ƚϣ�baseEdge������ֱ�洢��typedEdgeImages[i]�У�������baseEdge��imageEdge��null
			for(int i=0;i<interSources.length;i++) {
				typedEdgeImages[i] = TypedGraph.computeImage(baseEdge, first, interSources[i]);
			}
			
			try {
				//�ٸ���typedEdgeImages[]�е������ȷ��finalEdgeInfo
				Tuple3<TypedNode, TypedNode, TypeEdge> finalEdgeInfo = TypedGraph.computeEdge(baseEdge, typedEdgeImages);
				
				if(finalEdgeInfo==null) {	
					result.remove(baseEdge);
				} else {
					
					TypedNode source = result.getElementByIndexObject(finalEdgeInfo.first.getIndex());
					TypedNode target = result.getElementByIndexObject(finalEdgeInfo.second.getIndex());
					TypedEdge edge = new TypedEdge();	//������Ķ���
					edge.setSource(source);
					edge.setTarget(target);
					edge.setType(finalEdgeInfo.third);
					
					for(TypedGraph image : interSources) {
						edge.mergeIndex(image.getElementByIndexObject(baseEdge.getIndex()));
					}
					
					result.replaceWith(baseEdge, edge);
				}
			} catch (NothingReturnedException e) {
				throw e;	//��׽���쳣���׳�
			}
		}
		
		// ����ValueEdge�ı�����
		ValueEdge[] valueEdgeImages = new ValueEdge[interSources.length];
		for(ValueEdge baseEdge : first.getAllValueEdges()) {	//���ڻ���ͼ��ÿһ����ValueEdge���͵ı�
			
			//������֧ͼ�Ⱥͻ���ͼ���Ƚϣ�baseEdge������ֱ�洢��valueEdgeImages[]�У�������null��baseEdge��imageEdge
			for(int i=0;i<interSources.length;i++) {
				valueEdgeImages[i] = TypedGraph.computeImage(baseEdge, first, interSources[i]);
			}
			
			try {
				//�ٸ���valueEdgeImages[]�е������ȷ��finalEdgeInfo
				Tuple3<TypedNode, ValueNode, PropertyEdge> finalEdgeInfo = TypedGraph.computeEdge(baseEdge, valueEdgeImages);
				
				if(finalEdgeInfo==null) {
					result.remove(baseEdge);
				} else {
					TypedNode source = result.getElementByIndexObject(finalEdgeInfo.first.getIndex());
					ValueNode target = finalEdgeInfo.second;
					ValueEdge edge = new ValueEdge();
					edge.setSource(source);
					edge.setTarget(target);
					edge.setType(finalEdgeInfo.third);
					
					for(TypedGraph image : interSources) {
						edge.mergeIndex(image.getElementByIndexObject(baseEdge.getIndex()));
					}
					
					result.replaceWith(baseEdge, edge);
				}
			} catch (NothingReturnedException e) {
				throw e;
			}
		}
		
		// �����¼���ĵ�ͱ�
		for(TypedGraph image : interSources) {
			
			// TypedNode
			for(TypedNode n : image.allTypedNodes) {	//���ڷ�֧ͼ��ÿ��TypedNode���͵Ľڵ�n
				
				try {
					//����n���������һ���ͼ��������Ӧ�Ķ����������������
					first.getElementByIndexObject(n.getIndex());
				} catch (NothingReturnedException e) {	//����ڻ���ͼ��û���ҵ���Ӧ�Ķ���
					TypedNode rn = null;
					try {
						//����n����������resultͼ��������Ӧ�Ķ�������о͸�ֵ��rn
						rn = result.getElementByIndexObject(n.getIndex());
					} catch (NothingReturnedException e1) {	//���resultͼ������Ӧ�Ķ�����n������ӵ�resultͼ��List<TypedNode>��������rn=null
						result.addTypedNode(n);	
						rn = null;
					} finally {
						
						if(rn!=null) {	//���rn!=null��˵������n�������ҵ���resultͼ����Ӧ�Ķ����Ҹ�ֵ����rn
							TypeNode lt = rn.getType();
							TypeNode rt = n.getType();
							TypeNode ct = first.getTypeGraph().computeSubtype(lt, rt); //���յ�����
							
							if(ct==TypeNode.NULL_TYPE) {
								throw new NothingReturnedException();	// incompatible
							} else {								
								rn.setType(ct);	//�����ݣ���rn��type����Ϊct
								rn.mergeIndex(n);
								//���⣺����Ҫreindexing(rn)��--lyt��TypedGraph�����
								
							}
						}
					}
				}
			}
			
			// TypedEdge
			for(TypedEdge e : image.allTypedEdges) {	//���ڷ�֧ͼ��ÿһ��TypedEdge��e
				
				try {	//����e���������һ���ͼ��������Ӧ�Ķ����������������
					first.getElementByIndexObject(e.getIndex());
				} catch (Exception ex) {	//����ͼ��û���ҵ���Ӧ�Ķ���
					TypedEdge re = null;
					try {
						//����e����������resultͼ��������Ӧ�Ķ����������ֵ��re
						re = result.getElementByIndexObject(e.getIndex());	
					} catch (Exception ex2) {	//����e������û���ҵ�resultͼ����Ӧ�Ķ�����Ӧ���e��resultͼ��List<TypedEdge>��
						
						/*
						 * ��Ȼeû��resultͼ�У�����Ȼ���ڷ�֧ͼ���¼�e��˵��resultͼ��һ�����ڶ�Ӧ��source��target�ڵ㣿��
						 * ��������ڣ�˵���г�ͻ���ϲ��޷��������С�
						 * ��д��try�����˵��������
						 */
						TypedNode source = result.getElementByIndexObject(e.getSource().getIndex());
						TypedNode target = result.getElementByIndexObject(e.getTarget().getIndex());
						
						if(e.getSource()!=source || e.getTarget()!=target) {	//˵��e��source��target�ǻ���ͼ���еģ�resultͼ�ϲ�������ͼ��������������ͬһ����
							TypedEdge ne = new TypedEdge();
							ne.setSource(source);
							ne.setTarget(target);
							ne.setType(e.getType());
							ne.mergeIndex(e);
							result.addTypedEdge(ne);
						}
						else //˵��e��source��target���ڷ�֧ͼ������ӵ�TypedNode���ͽڵ㣬�����ڷ�֧ͼ��resultͼ����ͬһ����
							result.addTypedEdge(e);
						
						re = null;
						
					} finally {
						
						//����e�������ҵ���resultͼ����Ӧ�Ķ��󣬲���ֵ����re
						if(re!=null) {
							if(re.getType()!=e.getType()
									|| !re.getSource().getIndex().equals(e.getSource().getIndex())
									|| !re.getTarget().getIndex().equals(e.getTarget().getIndex())) {
								throw new NothingReturnedException();	
							} else {
								re.mergeIndex(e);
								//lyt--��TypedGraph�������reindexing(e)
							}
						}
					}
				}
			}
			
			// ValueEdge
			for(ValueEdge e : image.allValueEdges) {	//���ڷ�֧ͼ�е�ÿһ��ValueEdge��e
				try {
					//����e���������һ���ͼ��������Ӧ�Ķ���������򲻴���
					first.getElementByIndexObject(e.getIndex());	
				} catch (Exception ex) {	//�������ͼ��û����Ӧ�Ķ���
					ValueEdge re = null;
					try {
						//����e����������resultͼ��������Ӧ�Ķ����������ֵ��re
						re = result.getElementByIndexObject(e.getIndex());
					} catch (Exception ex2) {	//����e������û���ҵ�resultͼ����Ӧ�Ķ�������Ҫ���e��ͼ��List<ValueEdge>��
						
						/*
						 * result��û��ValueEdge���͵ı�e����һ������source�ڵ㣿��
						 * ��������ڣ�˵���г�ͻ���ϲ��޷�������
						 * ��д��try�����˵��������
						 */
						TypedNode source = result.getElementByIndexObject(e.getSource().getIndex());
//						ValueNode target = e.getTarget();
						
						if(e.getSource()!=source) {	//source�ǻ���ͼ���еģ�resultͼ�ϲ�������ͼ����������������ͬһ����
							ValueEdge ne = new ValueEdge();
							ne.setSource(source);
							ne.setTarget(e.getTarget());
							ne.setType(e.getType());
							ne.mergeIndex(e);
							result.addValueEdge(ne);
						} 
						else	//e��source��resultͼ����ͬһ����˵��������ӵ�TypedNode����
							result.addValueEdge(e);	
						
						re = null;
					} finally {
						
						if(re!=null) {	//re!=null��˵��resultͼ���ҵ�����Ӧ�Ķ��󣬲��Ҹ�ֵ����re
							if(re.getType()!=e.getType()
									|| !re.getSource().getIndex().equals(e.getSource().getIndex())	
									|| re.getTarget().equals(e.getTarget())==false) {
								throw new NothingReturnedException();
							} else {
								re.mergeIndex(e);
								//lyt��TypedGraph�������reindexing(re)
							}
						}
					}
				}
			}
			
		}
		
		OrderInformation[] orders = new OrderInformation[interSources.length];
		for(int i=0;i<interSources.length;i++)
			orders[i] = interSources[i].order;
		result.order.merge(orders);	//��orders[i]�ϲ���result��order��
		
		List<GraphConstraint> cons = new ArrayList<>();
		cons.add(first.getConstraint());
		for(TypedGraph g : interSources) {
			cons.add(g.constraint);
		}
		result.constraint = GraphConstraint.and(cons);
		// check
		
		return result;
	}
	

}



 