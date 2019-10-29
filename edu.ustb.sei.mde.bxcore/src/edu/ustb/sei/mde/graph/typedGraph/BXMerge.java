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

	public static TypedGraph additiveMerge(TypedGraph finalView, TypedGraph graph) {
		
		TypedGraph result = finalView.getCopy();
		
		graph.getAllTypedNodes().forEach(n->{
			try {
				TypedNode nr = result.getElementByIndexObject(n.getIndex());
				if(nr!=n) {
					result.replaceWith(nr,n);
				}
			} catch (NothingReturnedException e) {
				result.addTypedNode(n);
			}
		});
		
		graph.getAllValueNodes().forEach(n->{
			result.addValueNode(n);
		});
		
		graph.getAllTypedEdges().forEach(e->{
			try {
				TypedEdge er = result.getElementByIndexObject(e.getIndex());
				if(er!=e) {
					result.replaceWith(er, e);
				}
			} catch (NothingReturnedException ex) {
				result.addTypedEdge(e);
			}
		});
		
		graph.getAllValueEdges().forEach(e->{
			try {
				ValueEdge er = result.getElementByIndexObject(e.getIndex());
				if(er!=e) {
					result.replaceWith(er, e);
				}
			} catch (NothingReturnedException ex) {
				result.addValueEdge(e);
			}
		});
		
		result.order.merge(graph.order);
		
		result.constraint=GraphConstraint.and(finalView.constraint, graph.constraint);
		// check 
		
		return result;
	}

	public static TypedGraph merge(TypedGraph first, TypedGraph... interSources) throws NothingReturnedException {
		
		TypedGraph result = first.getCopy();
		
		// each typed node n in result, collect images in interSources (null means deleted, Any means default, T means required to be changed to T type)
		//   if all the images of n are compatible, (1) delete or (2) change to the common sub-type
		
		TypeNode[] nodeImages = new TypeNode[interSources.length];
		for(TypedNode baseNode : first.getAllTypedNodes()) {
			for(int i=0;i<interSources.length;i++) {
				nodeImages[i] = TypedGraph.computeImage(baseNode, first, interSources[i]);	//需要加上TypedGraph.
			}
			
			try {
				TypeNode finalType = TypedGraph.computeType(nodeImages, first.getTypeGraph());
				
				if(finalType==TypeNode.NULL_TYPE) {
					result.remove(baseNode);
				} else {
					if(finalType==TypeNode.ANY_TYPE)
						finalType = baseNode.getType();
					
					TypedNode n = new TypedNode();
					n.setType(finalType);
					
					for(TypedGraph image : interSources) {
						n.mergeIndex(image.getElementByIndexObject(baseNode.getIndex()));
					}
					
					result.replaceWith(baseNode, n);
				}
				
			} catch (NothingReturnedException e) {
				throw e;
			}
		}
		
		for(TypedGraph image : interSources) {
			image.getAllValueNodes().forEach(v->{result.addValueNode(v);});
		}
		
		
		// each typed edge e in the result, collect images in interSources (null means deleted, Any means default, <s,t>:T means required)
		TypedEdge[] typedEdgeImages = new TypedEdge[interSources.length];
		for(TypedEdge baseEdge : first.getAllTypedEdges()) {
			for(int i=0;i<interSources.length;i++) {
				typedEdgeImages[i] = TypedGraph.computeImage(baseEdge, first, interSources[i]);
			}
			try {
				Tuple3<TypedNode, TypedNode, TypeEdge> finalEdgeInfo = TypedGraph.computeEdge(baseEdge, typedEdgeImages);
				if(finalEdgeInfo==null) {
					result.remove(baseEdge);
				} else {
					TypedNode source = result.getElementByIndexObject(finalEdgeInfo.first.getIndex());
					TypedNode target = result.getElementByIndexObject(finalEdgeInfo.second.getIndex());
					TypedEdge edge = new TypedEdge();
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
		
		// each typed edge e in the result, collect images in interSources (null means deleted, Any means default, <s,t>:T means required)
		ValueEdge[] valueEdgeImages = new ValueEdge[interSources.length];
		for(ValueEdge baseEdge : first.getAllValueEdges()) {
			for(int i=0;i<interSources.length;i++) {
				valueEdgeImages[i] = TypedGraph.computeImage(baseEdge, first, interSources[i]);
			}
			try {
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
		
		// add extra nodes and edges
		
		for(TypedGraph image : interSources) {
			for(TypedNode n : image.allTypedNodes) {
				try {
					first.getElementByIndexObject(n.getIndex());
				} catch (NothingReturnedException e) {
					TypedNode rn = null;
					try {
						rn = result.getElementByIndexObject(n.getIndex());
					} catch (NothingReturnedException e1) {
						result.addTypedNode(n);
						rn = null;
					} finally {
						if(rn!=null) {
							TypeNode lt = rn.getType();
							TypeNode rt = n.getType();
							TypeNode ct = first.getTypeGraph().computeSubtype(lt, rt);
							if(ct==TypeNode.NULL_TYPE) {
								// incompatible
								throw new NothingReturnedException();
							} else {
//								TypedNode res = new TypedNode();
//								res.setType(ct);;
//								res.mergeIndices(rn);
//								res.mergeIndices(n);
//								result.replaceWith(rn, res);
								rn.mergeIndex(n);
								rn.setType(ct);
							}
						}
					}
				}
			}
			
			for(TypedEdge e : image.allTypedEdges) {
				try {
					first.getElementByIndexObject(e.getIndex());
				} catch (Exception ex) {
					TypedEdge re = null;
					try {
						re = result.getElementByIndexObject(e.getIndex());
					} catch (Exception ex2) {
						TypedNode source = result.getElementByIndexObject(e.getSource().getIndex());
						TypedNode target = result.getElementByIndexObject(e.getTarget().getIndex());
						if(e.getSource()!=source || e.getTarget()!=target) {
							TypedEdge ne = new TypedEdge();
							ne.setSource(source);
							ne.setTarget(target);
							ne.setType(e.getType());
							ne.mergeIndex(e);
							result.addTypedEdge(ne);
						} else result.addTypedEdge(e);
						re = null;
					} finally {
						if(re!=null) {
							if(re.getType()!=e.getType()
									|| !re.getSource().getIndex().equals(e.getSource().getIndex())
									|| !re.getTarget().getIndex().equals(e.getTarget().getIndex())) {
								throw new NothingReturnedException();
							} else {
								re.mergeIndex(e);
							}
						}
					}
				}
			}
			
			for(ValueEdge e : image.allValueEdges) {
				try {
					first.getElementByIndexObject(e.getIndex());
				} catch (Exception ex) {
					ValueEdge re = null;
					try {
						re = result.getElementByIndexObject(e.getIndex());
					} catch (Exception ex2) {
						TypedNode source = result.getElementByIndexObject(e.getSource().getIndex());
//						ValueNode target = e.getTarget();
						if(e.getSource()!=source) {
							ValueEdge ne = new ValueEdge();
							ne.setSource(source);
							ne.setTarget(e.getTarget());
							ne.setType(e.getType());
							ne.mergeIndex(e);
							result.addValueEdge(ne);
						} else result.addValueEdge(e);
//						result.addValueEdge(e);
						re = null;
					} finally {
						if(re!=null) {
							if(re.getType()!=e.getType()
									|| !re.getSource().getIndex().equals(e.getSource().getIndex())
									|| re.getTarget().equals(e.getTarget())==false) {
								throw new NothingReturnedException();
							} else {
								re.mergeIndex(e);
							}
						}
					}
				}
			}
		}
		
		OrderInformation[] orders = new OrderInformation[interSources.length];
		for(int i=0;i<interSources.length;i++)
			orders[i] = interSources[i].order;
		result.order.merge(orders);
		
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



