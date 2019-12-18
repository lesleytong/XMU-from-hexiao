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
	
	/** 二图合并  */
	public static TypedGraph additiveMerge(TypedGraph first, TypedGraph graph) {
		//先把第一个图拷贝到result，所有对象的引用一致
		TypedGraph result = first.getCopy();	
		
		//对于第二个图graph中的每个TypedNode类型的节点n
		graph.getAllTypedNodes().forEach(n->{ 
			try {
				//根据n的索引查找result图中是否有相应的对象，如果找到则将其赋值给nr
				TypedNode nr = result.getElementByIndexObject(n.getIndex());
				//如果nr==n，则不做处理；如果nr!=n，则将nr替换为n
				if(nr!=n) {
					result.replaceWith(nr, n);
				}
			} catch (NothingReturnedException e) {
				//如果根据n的索引在result图中没有找到，说明n是第二个图graph中新添加的节点，则将其添加到result图中
				result.addTypedNode(n);
			}
		});
		
		//对于第二个图graph中的每个ValueNode类型的节点n，全部添加到result中
		graph.getAllValueNodes().forEach(n->{
			result.addValueNode(n);
		});
		
		//对于第二个图graph中每个TypedEdge类型的边e
		graph.getAllTypedEdges().forEach(e->{
			try {
				//根据e的索引，查找result中的TypedEdge类型的边，如果找到则赋值给er
				TypedEdge er = result.getElementByIndexObject(e.getIndex());
				//如果er==e，则不做处理；如果er!=e，则将er替换为e
				if(er!=e) {
					result.replaceWith(er, e);
				}
			} catch (NothingReturnedException ex) {
				//如果根据e的索引没有找到result图中的边，说明e是graph图中新添加的，则将其添加到result图中
				result.addTypedEdge(e);
			}
		});
		
		//对于第二个图graph中每个ValueEdge类型的边e
		graph.getAllValueEdges().forEach(e->{
			try {
				//根据e的索引，查找result图中的边，如果找到则赋值给er
				ValueEdge er = result.getElementByIndexObject(e.getIndex());
				//如果er==e，则不做处理；如果er!=e，则将er替换为e
				if(er!=e) {
					result.replaceWith(er, e);
				}
			} catch (NothingReturnedException ex) {
				//如果根据e的索引没有找到result图中的边，说明e是graph图中新加的，则添加e到result图中
				result.addValueEdge(e);
			}
		});
		
		//最后处理result中的位置信息?
		result.order.merge(graph.order);
		
		result.constraint = GraphConstraint.and(first.constraint, graph.constraint);
		// check 
		
		return result;
	}

	
	
	
	
	
	/** 多图合并 */
	public static TypedGraph merge(TypedGraph first, TypedGraph... interSources) throws NothingReturnedException {
		
		TypedGraph result = first.getCopy(); 
		
		//处理TypedNode的变更情况
		TypeNode[] nodeImages = new TypeNode[interSources.length];	//比如length=2
		for(TypedNode baseNode : first.getAllTypedNodes()) {	//对于基本图中每一个TypedNode节点
			
			for(int i=0;i<interSources.length;i++) {
				//两个分支图先分别和基本图作比较，baseNode的情况分别存储在nodeImages[i]中。可能是NULL、ANY、修改后的类型
				nodeImages[i] = TypedGraph.computeImage(baseNode, first, interSources[i]);	
			}
			
			try {
				//再根据nodeImages[]中的情况，确定baseNode的finalType
				TypeNode finalType = TypedGraph.computeType(nodeImages, first.getTypeGraph());	
				
				if(finalType==TypeNode.NULL_TYPE) { //在某一分支中删除或两个分支都删除，则在result图中也删除
					result.remove(baseNode);
				} else {
					
					if(finalType==TypeNode.ANY_TYPE)	//此节点在两个分支图和基本图中的类型一致
						finalType = baseNode.getType();	
					
					TypedNode n = new TypedNode(); 
					n.setType(finalType);	//设置新节点n的类型：和基本图中一样的类型或是替换后的类型
					
					for(TypedGraph image : interSources) {
						//将新节点n和两个分支图中对应的baseNode的索引集合并
						n.mergeIndex(image.getElementByIndexObject(baseNode.getIndex())); 
					}
					
					result.replaceWith(baseNode, n);	//将result图中的baseNode替换为n
				}
				
			} catch (NothingReturnedException e) {	
				throw e;	//捕捉到异常后抛出
			}
		}
		
		// 处理ValueNode：分支图中所有的ValueNode全部扔进result图中
		for(TypedGraph image : interSources) {
			image.getAllValueNodes().forEach(v->{result.addValueNode(v);});
		}
		
		// 处理TypedEdge的变更情况
		TypedEdge[] typedEdgeImages = new TypedEdge[interSources.length];
		for(TypedEdge baseEdge : first.getAllTypedEdges()) {	//对于基本图中每一个TypedEdge类型的边baseEdge
			
			//两个分支图先分别和基本图作比较，baseEdge的情况分别存储在typedEdgeImages[i]中，可能是baseEdge、imageEdge、null
			for(int i=0;i<interSources.length;i++) {
				typedEdgeImages[i] = TypedGraph.computeImage(baseEdge, first, interSources[i]);
			}
			
			try {
				//再根据typedEdgeImages[]中的情况，确定finalEdgeInfo
				Tuple3<TypedNode, TypedNode, TypeEdge> finalEdgeInfo = TypedGraph.computeEdge(baseEdge, typedEdgeImages);
				
				if(finalEdgeInfo==null) {	
					result.remove(baseEdge);
				} else {
					
					TypedNode source = result.getElementByIndexObject(finalEdgeInfo.first.getIndex());
					TypedNode target = result.getElementByIndexObject(finalEdgeInfo.second.getIndex());
					TypedEdge edge = new TypedEdge();	//新申请的对象
					edge.setSource(source);
					edge.setTarget(target);
					edge.setType(finalEdgeInfo.third);
					
					for(TypedGraph image : interSources) {
						edge.mergeIndex(image.getElementByIndexObject(baseEdge.getIndex()));
					}
					
					result.replaceWith(baseEdge, edge);
				}
			} catch (NothingReturnedException e) {
				throw e;	//捕捉到异常后抛出
			}
		}
		
		// 处理ValueEdge的变更情况
		ValueEdge[] valueEdgeImages = new ValueEdge[interSources.length];
		for(ValueEdge baseEdge : first.getAllValueEdges()) {	//对于基本图中每一个条ValueEdge类型的边
			
			//两个分支图先和基本图作比较，baseEdge的情况分别存储在valueEdgeImages[]中，可能是null、baseEdge、imageEdge
			for(int i=0;i<interSources.length;i++) {
				valueEdgeImages[i] = TypedGraph.computeImage(baseEdge, first, interSources[i]);
			}
			
			try {
				//再根据valueEdgeImages[]中的情况，确定finalEdgeInfo
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
		
		// 处理新加入的点和边
		for(TypedGraph image : interSources) {
			
			// TypedNode
			for(TypedNode n : image.allTypedNodes) {	//对于分支图中每个TypedNode类型的节点n
				
				try {
					//根据n的索引查找基本图中有无相应的对象，如果有则不做处理？
					first.getElementByIndexObject(n.getIndex());
				} catch (NothingReturnedException e) {	//如果在基本图中没有找到相应的对象
					TypedNode rn = null;
					try {
						//根据n的索引查找result图中有无相应的对象，如果有就赋值给rn
						rn = result.getElementByIndexObject(n.getIndex());
					} catch (NothingReturnedException e1) {	//如果result图中无相应的对象，则将n对象添加到result图的List<TypedNode>，并且令rn=null
						result.addTypedNode(n);	
						rn = null;
					} finally {
						
						if(rn!=null) {	//如果rn!=null，说明根据n的索引找到了result图中相应的对象，且赋值给了rn
							TypeNode lt = rn.getType();
							TypeNode rt = n.getType();
							TypeNode ct = first.getTypeGraph().computeSubtype(lt, rt); //最终的类型
							
							if(ct==TypeNode.NULL_TYPE) {
								throw new NothingReturnedException();	// incompatible
							} else {								
								rn.setType(ct);	//若兼容，则rn的type设置为ct
								rn.mergeIndex(n);
								//问题：不需要reindexing(rn)吗--lyt在TypedGraph添加了
								
							}
						}
					}
				}
			}
			
			// TypedEdge
			for(TypedEdge e : image.allTypedEdges) {	//对于分支图中每一个TypedEdge边e
				
				try {	//根据e的索引查找基本图中有无相应的对象，如果有则不做处理
					first.getElementByIndexObject(e.getIndex());
				} catch (Exception ex) {	//基本图中没有找到相应的对象
					TypedEdge re = null;
					try {
						//根据e的索引查找result图中有无相应的对象，如果有则赋值给re
						re = result.getElementByIndexObject(e.getIndex());	
					} catch (Exception ex2) {	//根据e的索引没有找到result图中相应的对象，则应添加e到result图的List<TypedEdge>中
						
						/*
						 * 虽然e没在result图中，但既然能在分支图中新加e，说明result图中一定存在对应的source和target节点？？
						 * 如果不存在，说明有冲突，合并无法继续进行。
						 * 不写在try语句块里，说明不处理。
						 */
						TypedNode source = result.getElementByIndexObject(e.getSource().getIndex());
						TypedNode target = result.getElementByIndexObject(e.getTarget().getIndex());
						
						if(e.getSource()!=source || e.getTarget()!=target) {	//说明e的source和target是基本图中有的，result图合并过三个图的索引，但不是同一对象
							TypedEdge ne = new TypedEdge();
							ne.setSource(source);
							ne.setTarget(target);
							ne.setType(e.getType());
							ne.mergeIndex(e);
							result.addTypedEdge(ne);
						}
						else //说明e的source和target是在分支图中新添加的TypedNode类型节点，所以在分支图和result图中是同一对象
							result.addTypedEdge(e);
						
						re = null;
						
					} finally {
						
						//根据e的索引找到了result图中相应的对象，并赋值给了re
						if(re!=null) {
							if(re.getType()!=e.getType()
									|| !re.getSource().getIndex().equals(e.getSource().getIndex())
									|| !re.getTarget().getIndex().equals(e.getTarget().getIndex())) {
								throw new NothingReturnedException();	
							} else {
								re.mergeIndex(e);
								//lyt--在TypedGraph中添加了reindexing(e)
							}
						}
					}
				}
			}
			
			// ValueEdge
			for(ValueEdge e : image.allValueEdges) {	//对于分支图中的每一个ValueEdge边e
				try {
					//根据e的索引查找基本图中有无相应的对象，如果有则不处理
					first.getElementByIndexObject(e.getIndex());	
				} catch (Exception ex) {	//如果基本图中没有相应的对象
					ValueEdge re = null;
					try {
						//根据e的索引查找result图中有无相应的对象，如果有则赋值给re
						re = result.getElementByIndexObject(e.getIndex());
					} catch (Exception ex2) {	//根据e的索引没有找到result图中相应的对象，则需要添加e到图的List<ValueEdge>中
						
						/*
						 * result中没有ValueEdge类型的边e，但一定存在source节点？？
						 * 如果不存在，说明有冲突，合并无法继续。
						 * 不写在try语句块里，说明不处理。
						 */
						TypedNode source = result.getElementByIndexObject(e.getSource().getIndex());
//						ValueNode target = e.getTarget();
						
						if(e.getSource()!=source) {	//source是基本图中有的，result图合并过三个图的索引集，但不是同一对象
							ValueEdge ne = new ValueEdge();
							ne.setSource(source);
							ne.setTarget(e.getTarget());
							ne.setType(e.getType());
							ne.mergeIndex(e);
							result.addValueEdge(ne);
						} 
						else	//e的source和result图中是同一对象，说明是新添加的TypedNode对象
							result.addValueEdge(e);	
						
						re = null;
					} finally {
						
						if(re!=null) {	//re!=null，说明result图中找到了相应的对象，并且赋值给了re
							if(re.getType()!=e.getType()
									|| !re.getSource().getIndex().equals(e.getSource().getIndex())	
									|| re.getTarget().equals(e.getTarget())==false) {
								throw new NothingReturnedException();
							} else {
								re.mergeIndex(e);
								//lyt在TypedGraph中添加了reindexing(re)
							}
						}
					}
				}
			}
			
		}
		
		OrderInformation[] orders = new OrderInformation[interSources.length];
		for(int i=0;i<interSources.length;i++)
			orders[i] = interSources[i].order;
		result.order.merge(orders);	//将orders[i]合并到result的order中
		
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



 