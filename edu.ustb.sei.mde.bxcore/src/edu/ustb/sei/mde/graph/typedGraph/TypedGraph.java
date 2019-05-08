package edu.ustb.sei.mde.graph.typedGraph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import com.beust.jcommander.internal.Lists;

import edu.ustb.sei.mde.bxcore.XmuCoreUtils;
import edu.ustb.sei.mde.bxcore.exceptions.NothingReturnedException;
import edu.ustb.sei.mde.bxcore.structures.Index;
import edu.ustb.sei.mde.graph.Derived;
import edu.ustb.sei.mde.graph.IEdge;
import edu.ustb.sei.mde.graph.IGraph;
import edu.ustb.sei.mde.graph.INode;
import edu.ustb.sei.mde.graph.type.DataTypeNode;
import edu.ustb.sei.mde.graph.type.IStructuralFeatureEdge;
import edu.ustb.sei.mde.graph.type.PropertyEdge;
import edu.ustb.sei.mde.graph.type.TypeEdge;
import edu.ustb.sei.mde.graph.type.TypeGraph;
import edu.ustb.sei.mde.graph.type.TypeNode;
import edu.ustb.sei.mde.graph.typedGraph.constraint.GraphConstraint;
import edu.ustb.sei.mde.structure.PairMap;
import edu.ustb.sei.mde.structure.Tuple3;

public class TypedGraph extends IndexSystem implements IGraph {
	
	public void init() {
		allTypedNodes = new ArrayList<TypedNode>();
		allValueNodes = new ArrayList<ValueNode>();
		allTypedEdges = new ArrayList<TypedEdge>();
		allValueEdges = new ArrayList<ValueEdge>();
		valueEdgeMap = new HashMap<TypedNode,List<ValueEdge>>();
		incomingEdgeMap = new HashMap<TypedNode,List<TypedEdge>>();
		outgoingEdgeMap = new HashMap<TypedNode,List<TypedEdge>>();
		
		order = new OrderInformation();
		
		constraint = GraphConstraint.TRUE;
	}
	
	public OrderInformation getOrder() {
		return order;
	}
	
	private OrderInformation order;
	
	private GraphConstraint constraint;
	
//	private Environment environment;
//	
//	public Environment getEnvironment() {
//		return environment;
//	}
//
//	public void setEnvironment(Environment environment) {
//		this.environment = environment;
//	}

	@Override
	@Derived
	public List<INode> getNodes() {
		List<INode> nodes = new ArrayList<INode>(allTypedNodes.size()+allValueNodes.size());
		nodes.addAll(allTypedNodes);
		nodes.addAll(allValueNodes);
		return nodes;
	}

	@Override
	public List<IEdge> getEdges() {
		List<IEdge> edges = new ArrayList<IEdge>(allTypedEdges.size()+allValueEdges.size());
		edges.addAll(allTypedEdges);
		edges.addAll(allValueEdges);
		return edges;
	}
	
	
	public void addTypedNode(TypedNode n) {
		allTypedNodes.add(n);
		
		indexing(n);
	}
	
	public void addValueNode(ValueNode n) {
		if(allValueNodes.contains(n)==false)
			allValueNodes.add(n);
		
		indexing(n);
	}
	
	public void moveTypedEdgeTo(int n, int i) {
		moveEdgeTo(allTypedEdges, n, i);
	}
	
	public void moveValueEdgeTo(int n, int i) {
		moveEdgeTo(allValueEdges, n, i);
	}
	
	public <T> void moveEdgeTo(List<T> edges, int cur, int i) {
		T n = edges.get(cur);
		
		if(cur==i || cur==-1) return;
		else {
			if(cur<i) {
				for(int j=cur;j<i;j++) {
					edges.set(j, edges.get(j+1));
				}
			} else {
				for(int j=cur;j>i;j--) {
					edges.set(j, edges.get(j-1));
				}
			}
			edges.set(i, n);
		}
	}
	
//	public <T> void moveEdgeTo(List<T> edges, List<Integer> cur, int i) {
//		if(cur.isEmpty()) return;
//		Collections.sort(cur);
//		
//		if(cur.get(0)>i) {
//			
//		} else if(cur.get(cur.size()-1)<i) {
//			
//		}
//	}
	
	public int indexOf(List<? extends Object> list, Object o) {
		for(int i=0;i<list.size();i++) {
			if(list.get(i)==o) return i;
		}
		return -1;
	}
	
	public void addTypedEdge(TypedEdge n) {
		if(n.getType().isMany()) {
			if(n.getType().isUnique()) {
				TypedEdge err = null;
				try {
					err = allTypedEdges.stream().filter(er->{
						return er.getType()==n.getType() 
								&& er.getSource().getIndex().equals(n.getSource().getIndex())
								&& er.getTarget().getIndex().equals(n.getTarget().getIndex());
					}).findAny().get();
				} catch (Exception ex2) {
					allTypedEdges.add(n);
					indexing(n);
				}
				if(err!=null) replaceWith(err, n);
			} else {
				allTypedEdges.add(n);
				indexing(n);			
			}
		} else {
			boolean replaced = false;
			
			for(int i=0;i<allTypedEdges.size();i++) {
				TypedEdge e = allTypedEdges.get(i);
				if(e.getSource()==n.getSource() 
						&& e.getType() == n.getType()) {
					
					n.mergeIndex(e);
					reindexing(n);
					
					if(replaced) { // reduce redundant
						allTypedEdges.remove(i);
						i--;
						XmuCoreUtils.failure("Redundant edges "+e);
					} else {
						allTypedEdges.set(i, n);
						replaced=true;
					}
				}
			}
			if(!replaced) {
				allTypedEdges.add(n);
				indexing(n);
			}
		}
		this.outgoingEdgeMap.remove(n.getSource());
		this.incomingEdgeMap.remove(n.getTarget());
	}

	private <T extends IndexableElement> void indexing(T n) {
		if(n.isIndexable()==false) 
			return;
		
		try {
			if(n.getIndex().isEmpty()) {
				n.appendIndexValue(IndexSystem.generateUUID());
				XmuCoreUtils.warning("An object without index was found");
			}
		} catch (Exception e) {
			XmuCoreUtils.failure("Unknown error", e);
			return;
		}
			
		n.foreach(i->{
			try {
				this.registerIndex(i, n);
			} catch (NothingReturnedException e) {
				java.util.logging.Logger.getLogger(XmuCoreUtils.COMPONENT_NAME).log(Level.SEVERE, "Two objects are mapped onto the same index", e);
			}
		});
			
	}
	
	private void reindexing(IndexableElement n) {
		n.foreach(i->{
			this.indexToObjectMap.put(i, n);
		});
	}
	
	public void addValueEdge(ValueEdge n) {
		if(n.getType().isMany()) {
			if(n.getType().isUnique()) {
				ValueEdge err = null;
				try {
					err = allValueEdges.stream().filter(er->{
						return er.getType()==n.getType() 
								&& er.getSource().getIndex().equals(n.getSource().getIndex())
								&& er.getTarget().equals(n.getTarget());
					}).findAny().get();
				} catch (Exception ex2) {
					allValueEdges.add(n);
					indexing(n);
				}
				if(err!=null) replaceWith(err, n);
			} else {
				allValueEdges.add(n);
				indexing(n);
			}
		} else {
			boolean replaced = false;
			
			for(int i=0;i<allValueEdges.size();i++) {
				ValueEdge e = allValueEdges.get(i);
				if(e.getSource()==n.getSource() 
						&& e.getType() == n.getType()) {
					
					n.mergeIndex(e);
					reindexing(n);
					
					if(replaced) { // reduce redundant
						allValueEdges.remove(i);
						i--;
						XmuCoreUtils.failure("Redundant edges "+e);
					} else {
						allValueEdges.set(i, n);
						replaced=true;
					}
				}
			}
			if(!replaced) {
				allValueEdges.add(n);
				indexing(n);
			}
		}
		
		this.valueEdgeMap.remove(n.getSource());
	}
	
	public TypedGraph(TypeGraph typeGraph) {
		super();
		this.typeGraph = typeGraph;
		init();
	}

	private TypeGraph typeGraph;
	public TypeGraph getTypeGraph() {
		return this.typeGraph;
	}
	
	private List<TypedNode> allTypedNodes;
	public List<TypedNode> getAllTypedNodes() {
		return allTypedNodes;
	}
	
	public TypedNode[] getTypedNodesOf(TypeNode type) {
		TypeGraph typeGraph = this.getTypeGraph();
		return allTypedNodes.stream().filter(n->{
			return typeGraph.isSuperTypeOf(n.getType(), type);
		}).toArray(i->new TypedNode[i]);
	}
	
	public ValueNode[] getValueNodesOf(DataTypeNode type) {
		TypeGraph typeGraph = this.getTypeGraph();
		return allValueNodes.stream().filter(n->{
			return typeGraph.isSuperTypeOf(n.getType(), type);
		}).toArray(i->new ValueNode[i]);
	}
	
	public TypedEdge[] getTypedEdgesOf(TypeEdge type) {
		return allTypedEdges.stream().filter(n->{
			return n.getType()==type;
		}).toArray(i->new TypedEdge[i]);
	}
	
	public ValueEdge[] getValueEdgesOf(PropertyEdge type) {
		return allValueEdges.stream().filter(n->{
			return n.getType()==type;
		}).toArray(i->new ValueEdge[i]);
	}
	
	
	private List<ValueNode> allValueNodes;
	public List<ValueNode> getAllValueNodes() {
		return allValueNodes;
	}
	
	private List<TypedEdge> allTypedEdges;
	public List<TypedEdge> getAllTypedEdges() {
		return allTypedEdges;
	}
	
	private List<ValueEdge> allValueEdges;
	public List<ValueEdge> getAllValueEdges() {
		return allValueEdges;
	}
	
	@Derived private HashMap<TypedNode,List<TypedEdge>> outgoingEdgeMap;
	@Derived
	public  List<TypedEdge> getOutgoingEdges(TypedNode source) {
		List<TypedEdge> result = this.outgoingEdgeMap.get(source);
		if(result==null) {
			result = new ArrayList<TypedEdge>();
			this.outgoingEdgeMap.put(source, result);
			
			for(TypedEdge e : this.getAllTypedEdges()) {
				if(e.getSource()==source) {
					result.add(e);
				}
			}
		}
		
		return result;
	}
	
	@Derived 
	public List<TypedEdge> getOutgoingEdges(TypedNode source, TypeEdge feature) {
		List<TypedEdge> result = new ArrayList<TypedEdge>();
		
		for(TypedEdge e : this.getOutgoingEdges(source)) {
			if(e.getType()==feature) {
				result.add(e);
			}
		}
		return result;
	}
	
	@Derived private HashMap<TypedNode,List<TypedEdge>> incomingEdgeMap;
	@Derived
	public  List<TypedEdge> getIncomingEdges(TypedNode target) {
		List<TypedEdge> result = this.incomingEdgeMap.get(target);
		if(result==null) {
			result = new ArrayList<TypedEdge>();
			this.incomingEdgeMap.put(target, result);
			
			for(TypedEdge e : this.getAllTypedEdges()) {
				if(e.getTarget()==target) {
					result.add(e);
				}
			}
		}
		
		return result;
	}
	
	@Derived 
	public List<TypedEdge> getIncomingEdges(TypedNode target, TypeEdge feature) {
		List<TypedEdge> result = new ArrayList<TypedEdge>();
		
		for(TypedEdge e : this.getIncomingEdges(target)) {
			if(e.getType()==feature) {
				result.add(e);
			}
		}
		return result;
	}
	
	
	@Derived private HashMap<TypedNode,List<ValueEdge>> valueEdgeMap;
	@Derived
	public  List<ValueEdge> getValueEdges(TypedNode source) {
		List<ValueEdge> result = this.valueEdgeMap.get(source);
		if(result==null) {
			result = new ArrayList<ValueEdge>();
			this.valueEdgeMap.put(source, result);
			
			for(ValueEdge e : this.getAllValueEdges()) {
				if(e.getSource() == source) {
					result.add(e);
				}
			}
		}
		
		return result;
	}
	
	@Derived 
	public List<ValueEdge> getValueEdges(TypedNode source, PropertyEdge feature) {
		List<ValueEdge> result = new ArrayList<ValueEdge>();
		
		for(ValueEdge e : this.getValueEdges(source)) {
			if(e.getType()==feature) {
				result.add(e);
			}
		}
		return result;
	}
	
	@Derived List<? extends ITypedEdge> getFeature(TypedNode source, IStructuralFeatureEdge type) {
		if(type instanceof TypeEdge) {
			return this.getOutgoingEdges(source, (TypeEdge) type);
		} else if(type instanceof PropertyEdge) {
			return this.getValueEdges(source, (PropertyEdge) type);
		} else {
			return Collections.emptyList();
		}
	}
	
	public String printGraph() {
		StringBuilder builder = new StringBuilder();
		
		List<TypedNode> allTypedNodes = this.getAllTypedNodes();
		allTypedNodes.forEach(n->{
			builder.append(n.toString());
			builder.append("{");
			this.getValueEdges(n).forEach(v->{
				builder.append(v.toString());
				builder.append(",");
			});
			builder.append("}");
			builder.append("\n");
		});
		
		this.getAllTypedEdges().forEach(e->{
			builder.append(e.toString());
			builder.append("\n");
		});
		
		return builder.toString();
	}
	
	public boolean conformanceCheck() {
		PairMap<ITypedNode, IStructuralFeatureEdge, Integer> counts = new PairMap<>();
		
		for(TypedNode n : this.getAllTypedNodes()) {
			if(n.getType().isAbstract()) return false;
			if(!this.getTypeGraph().getAllTypeNodes().contains(n.getType()))
				return false;
		}
		
		for(ValueNode n : this.getAllValueNodes()) {
			if(!this.getTypeGraph().getAllDataTypeNodes().contains(n.getType()))
				return false;
		}
		
		for(TypedEdge e : this.getAllTypedEdges()) {
			TypeEdge type = e.getType();
			if(!this.getTypeGraph().getAllTypeEdges().contains(type)) return false;
			if(!this.getTypeGraph().isSuperTypeOf(e.getSource().getType(),type.getSource())) return false;
			if(!this.getTypeGraph().isSuperTypeOf(e.getTarget().getType(),type.getTarget())) return false;
			
			Integer i = counts.get(e.getSource(), type);
			if(i==null) i = 0;
			counts.put(e.getSource(), type, i++);
			if(i>1 && !type.isMany()) return false;
		}
		
		for(ValueEdge e : this.getAllValueEdges()) {
			PropertyEdge type = e.getType();
			if(!this.getTypeGraph().getAllPropertyEdges().contains(type)) return false;
			if(!this.getTypeGraph().isSuperTypeOf(e.getSource().getType(),type.getSource())) return false;
			if(!this.getTypeGraph().isSuperTypeOf(e.getTarget().getType(),type.getTarget())) return false;
			
			Integer i = counts.get(e.getSource(), type);
			if(i==null) i = 0;
			counts.put(e.getSource(), type, i++);
			if(i>1 && !type.isMany()) return false;
		}
		
		return true;
	}

	public TypedGraph getCopy() {
		TypedGraph copy = new TypedGraph(this.typeGraph);
		
		copy.getAllTypedNodes().addAll(this.getAllTypedNodes());
		copy.getAllTypedEdges().addAll(this.getAllTypedEdges());
		copy.getAllValueNodes().addAll(this.getAllValueNodes());
		copy.getAllValueEdges().addAll(this.getAllValueEdges());
		
		copy.indexToObjectMap.putAll(this.indexToObjectMap);
		
		copy.order = this.order.getCopy();
		
		copy.constraint=this.constraint;
		
		return copy;
	}
	
	public TypedGraph additiveMerge(TypedGraph graph) {
		TypedGraph result = this.getCopy();
		
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
		
		result.constraint=GraphConstraint.and(this.constraint, graph.constraint);
		// check 
		
		return result;
	}
	
	static boolean isEqual(IndexableElement l, IndexableElement r) {
		return l==r || (l!=null && l.isIndexable() && r.isIndexable() &&
				l.getIndex().equals(r.getIndex()));
	}
	
	public void remove(TypedNode n) {
		this.allTypedNodes.removeIf(x->isEqual(x,n));
		this.clearIndex(n);
		
		for(int i = this.allTypedEdges.size()-1;i>=0;i--) {
			TypedEdge e = this.allTypedEdges.get(i);
			if(isEqual(e.getSource(), n) || isEqual(e.getTarget(), n)) {
				this.allTypedEdges.remove(i);
				this.clearIndex(e);
			}
		}
		
		for(int i = this.allValueEdges.size()-1;i>=0;i--) {
			ValueEdge e = this.allValueEdges.get(i);
			if(isEqual(e.getSource(), n)) {
				this.allValueEdges.remove(i);
				this.clearIndex(e);
			}
		}
	}
	
	private void replaceWith(ValueEdge er, ValueEdge e) {
		this.allValueEdges.replaceAll(x->isEqual(x,er) ? e : x);
		e.mergeIndex(er);
		reindexing(e);
	}

	private void replaceWith(TypedEdge er, TypedEdge e) {
		this.allTypedEdges.replaceAll(x->isEqual(x,er) ? e : x);
		e.mergeIndex(er);
		reindexing(e);
	}

	private void replaceWith(TypedNode nr, TypedNode n) {
		// replace in node list
		this.allTypedNodes.replaceAll(e->isEqual(e,nr) ? n : e);
		
		//merge indices
		n.mergeIndex(nr);
		
		// re-map
		reindexing(n);
		
		// change edge ends
		if(nr!=n) {
			TypeNode nodeType = n.getType();
			
			List<TypedEdge> removedTypedEdges = new ArrayList<TypedEdge>();
			this.allTypedEdges.replaceAll(e->{
				TypeEdge edgeType = e.getType();
				TypeNode sourceType = edgeType.getSource();
				TypeNode targetType = edgeType.getTarget();
				
				if(e.getSource()==nr && e.getTarget()==nr) {
					if(this.typeGraph.isSuperTypeOf(nodeType, sourceType) && this.typeGraph.isSuperTypeOf(nodeType, targetType)) {
						TypedEdge res = new TypedEdge();
						res.setSource(n);
						res.setTarget(n);
						res.setType(edgeType);
						res.mergeIndex(e);
						reindexing(res);
						return res;
					} else {
						removedTypedEdges.add(e);
						clearIndex(e);
						return e;
					}
				} else if(e.getSource()==nr) {
					if(this.typeGraph.isSuperTypeOf(nodeType, sourceType)) {
						TypedEdge res = new TypedEdge();
						res.setSource(n);
						res.setTarget(e.getTarget());
						res.setType(edgeType);
						res.mergeIndex(e);
						reindexing(res);
						return res;
					} else {
						removedTypedEdges.add(e);
						clearIndex(e);
						return e;
					}
				} else if(e.getTarget()==nr) {
					if(this.typeGraph.isSuperTypeOf(nodeType, targetType)) {
						TypedEdge res = new TypedEdge();
						res.setSource(e.getSource());
						res.setTarget(n);
						res.setType(edgeType);
						res.mergeIndex(e);
						reindexing(res);
						return res;
					} else {
						removedTypedEdges.add(e);
						clearIndex(e);
						return e;
					}
				} else 
					return e;
			});
			this.allTypedEdges.removeAll(removedTypedEdges);
			
			List<ValueEdge> removedValueEdges = new ArrayList<ValueEdge>();
			this.allValueEdges.replaceAll(e->{
				PropertyEdge edgeType = e.getType();
				TypeNode sourceType = edgeType.getSource();
				
				if(e.getSource()==nr) {
					if(this.typeGraph.isSuperTypeOf(nodeType, sourceType)) {
						ValueEdge res = new ValueEdge();
						res.setSource(n);
						res.setTarget(e.getTarget());
						res.setType(edgeType);
						res.mergeIndex(e);
						reindexing(res);
						return res;
					} else {
						removedValueEdges.add(e);
						clearIndex(e);
						return e;
					}
				} else return e;
			});
			this.allValueEdges.removeAll(removedValueEdges);
			
		}
		
	}
	
//	static public boolean isIdentifical(TypedGraph left, TypedGraph right) {
//		return false;
//	}

	public TypedGraph merge(TypedGraph... interSources) throws NothingReturnedException {
		TypedGraph result = this.getCopy();
		
		// each typed node n in result, collect images in interSources (null means deleted, Any means default, T means required to be changed to T type)
		//   if all the images of n are compatible, (1) delete or (2) change to the common sub-type
		
		TypeNode[] nodeImages = new TypeNode[interSources.length];
		for(TypedNode baseNode : this.getAllTypedNodes()) {
			for(int i=0;i<interSources.length;i++) {
				nodeImages[i] = computeImage(baseNode, this, interSources[i]);
			}
			
			try {
				TypeNode finalType = computeType(nodeImages, this.getTypeGraph());
				
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
		for(TypedEdge baseEdge : this.getAllTypedEdges()) {
			for(int i=0;i<interSources.length;i++) {
				typedEdgeImages[i] = computeImage(baseEdge, this, interSources[i]);
			}
			try {
				Tuple3<TypedNode, TypedNode, TypeEdge> finalEdgeInfo = computeEdge(baseEdge, typedEdgeImages);
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
		for(ValueEdge baseEdge : this.getAllValueEdges()) {
			for(int i=0;i<interSources.length;i++) {
				valueEdgeImages[i] = computeImage(baseEdge, this, interSources[i]);
			}
			try {
				Tuple3<TypedNode, ValueNode, PropertyEdge> finalEdgeInfo = computeEdge(baseEdge, valueEdgeImages);
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
					this.getElementByIndexObject(n.getIndex());
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
							TypeNode ct = this.getTypeGraph().computeSubtype(lt, rt);
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
					this.getElementByIndexObject(e.getIndex());
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
					this.getElementByIndexObject(e.getIndex());
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
		cons.add(this.getConstraint());
		for(TypedGraph g : interSources) {
			cons.add(g.constraint);
		}
		result.constraint = GraphConstraint.and(cons);
		// check
		
		return result;
	}
	
	private Tuple3<TypedNode, ValueNode, PropertyEdge> computeEdge(ValueEdge base, ValueEdge[] valueEdgeImages) throws NothingReturnedException {
		Tuple3<TypedNode, ValueNode, PropertyEdge> any = new Tuple3<TypedNode, ValueNode, PropertyEdge>(base.getSource(), base.getTarget(), base.getType());
		Tuple3<TypedNode, ValueNode, PropertyEdge> tuple = any;
		
		for(ValueEdge e : valueEdgeImages) {
			if(e==base) continue;
			else if(e==null) {
				if(tuple==null 
						|| isImage(tuple, base))
					tuple = null;
				else
					throw new NothingReturnedException(); // incompatible
			} else {
				if(tuple==null) 
					throw new NothingReturnedException();
				else if(isImage(tuple,base))
					tuple = new Tuple3<TypedNode, ValueNode, PropertyEdge>(e.getSource(), e.getTarget(), e.getType());
				else {
					if(isImage(tuple,e))
						continue;
					else 
						throw new NothingReturnedException();
				}
			}
		}
		
		return tuple;
	}

	static private boolean isImage(Tuple3<TypedNode, ValueNode, PropertyEdge> tuple, ValueEdge base) {
		return tuple.third==base.getType()
				&& tuple.first.getIndex().equals(base.getSource().getIndex())
				&& tuple.second.equals(base.getTarget());
	}

	private ValueEdge computeImage(ValueEdge baseEdge, TypedGraph baseGraph, TypedGraph imageGraph) {
		try {
			ValueEdge imageEdge = imageGraph.getElementByIndexObject(baseEdge.getIndex());
			if(imageEdge.getType()==baseEdge.getType()
					&& imageEdge.getSource().getIndex().equals(baseEdge.getSource().getIndex())
					&& imageEdge.getTarget().equals(baseEdge.getTarget())) 
				return baseEdge;
			else return imageEdge;
		
		} catch (Exception e) {
			return null;
		}
	}

	public void remove(ValueEdge baseEdge) {
		this.allValueEdges.removeIf(x->isEqual(x, baseEdge));
		this.clearIndex(baseEdge);
	}

	public void remove(TypedEdge baseEdge) {
		this.allTypedEdges.removeIf(x->isEqual(x, baseEdge));
		this.clearIndex(baseEdge);
		// compute pre-deleted elements when baseEdge is containment, or not?
	}

	private Tuple3<TypedNode, TypedNode, TypeEdge> computeEdge(TypedEdge base, TypedEdge[] typedEdgeImages) throws NothingReturnedException {
		Tuple3<TypedNode, TypedNode, TypeEdge> any = new Tuple3<TypedNode, TypedNode, TypeEdge>(base.getSource(), base.getTarget(), base.getType());
		Tuple3<TypedNode, TypedNode, TypeEdge> tuple = any;
		
		for(TypedEdge e : typedEdgeImages) {
			if(e==base) continue;
			else if(e==null) {
				if(tuple==null 
						|| isImage(tuple, base))
					tuple = null;
				else
					throw new NothingReturnedException(); // incompatible
			} else {
				if(tuple==null) 
					throw new NothingReturnedException();
				else if(isImage(tuple,base))
					tuple = new Tuple3<TypedNode, TypedNode, TypeEdge>(e.getSource(), e.getTarget(), e.getType());
				else {
					if(isImage(tuple,e))
						continue;
					else 
						throw new NothingReturnedException();
				}
			}
		}
		
		return tuple;
		
	}

	static private boolean isImage(Tuple3<TypedNode, TypedNode, TypeEdge> tuple, TypedEdge base) {
		return tuple.third==base.getType()
		&& tuple.first.getIndex().equals(base.getSource().getIndex())
		&& tuple.second.getIndex().equals(base.getTarget().getIndex());
	}

	private TypedEdge computeImage(TypedEdge baseEdge, TypedGraph baseGraph, TypedGraph imageGraph) {
		try {
			TypedEdge imageEdge = imageGraph.getElementByIndexObject(baseEdge.getIndex());
			if(imageEdge.getType()==baseEdge.getType()
					&& imageEdge.getSource().getIndex().equals(baseEdge.getSource().getIndex())
					&& imageEdge.getTarget().getIndex().equals(baseEdge.getTarget().getIndex())) 
				return baseEdge;
			else return imageEdge;
		
		} catch (Exception e) {
			return null;
		}
	}

	static private TypeNode computeType(TypeNode[] images, TypeGraph typeGraph) throws NothingReturnedException {
		TypeNode finalType = TypeNode.ANY_TYPE;
		
		for(TypeNode n : images) {
			if(n==TypeNode.ANY_TYPE) continue;
			else if(n==TypeNode.NULL_TYPE) {
				if(finalType==TypeNode.ANY_TYPE || finalType==TypeNode.NULL_TYPE)
					finalType = TypeNode.NULL_TYPE;
				else
					throw new NothingReturnedException(); // incompatible
			} else {
				if(finalType==TypeNode.NULL_TYPE) 
					throw new NothingReturnedException(); // incompatible
				else if(finalType==TypeNode.ANY_TYPE)
					finalType = n;
				else {
					finalType = typeGraph.computeSubtype(finalType,n);
					if(finalType==TypeNode.NULL_TYPE)
						throw new NothingReturnedException();
				}
					
			}
		}
		
		return finalType;
	}

	private static TypeNode computeImage(TypedNode baseNode, TypedGraph baseGraph, TypedGraph imageGraph) {
		try {
			TypedNode imageNode = imageGraph.getElementByIndexObject(baseNode.getIndex());
			
			if(imageNode.getType()!=baseNode.getType()) 
				return imageNode.getType();
			else {
				if(isTouched(imageNode, imageGraph, baseNode, baseGraph)) {
					return imageNode.getType();
				} else 
					return TypeNode.ANY_TYPE;
			}
			
		} catch (NothingReturnedException e) {
			return TypeNode.NULL_TYPE;
		}
	}

	private static boolean isTouched(TypedNode imageNode, TypedGraph imageGraph, TypedNode baseNode,
			TypedGraph baseGraph) {
		// may be omitted
		
		try {
			List<TypedEdge> imageEdges = imageGraph.getOutgoingEdges(imageNode);
			List<TypedEdge> baseEdges = baseGraph.getOutgoingEdges(baseNode);
			
			if(imageEdges.size()>baseEdges.size()) 
				return true;
			for(TypedEdge imageEdge : imageEdges) {
				if(baseEdges.stream().noneMatch(baseEdge-> {
					TypedNode imageTarget = imageEdge.getTarget();
					TypedNode baseTarget = baseEdge.getTarget();
					
					if(imageEdge.getType()==baseEdge.getType()) {
						if(!baseTarget.getIndex().equals(imageTarget.getIndex()))
							return false; // target inconsistent
						if(imageEdge.getType().isUnique()) {
							return baseEdge.getIndex().equals(imageEdge.getIndex()); // for a non-unique reference, the edge index determines the result
						} else
							return true; // for a unique reference, the edge index is determined by the source and target indices
					} else {
						return false; // type inconsistent
					}
				})) return true; // we found that imageEdge is a new edge
			} // end for
		} catch (Exception e) {
			return true;
		}
		
		try {
			List<ValueEdge> imageEdges = imageGraph.getValueEdges(imageNode);
			List<ValueEdge> baseEdges = baseGraph.getValueEdges(baseNode);
			
			if(imageEdges.size()>baseEdges.size()) 
				return true;
			
			for(ValueEdge imageEdge : imageEdges) {
				if(baseEdges.stream().noneMatch(baseEdge-> {
					ValueNode imageTarget = imageEdge.getTarget();
					ValueNode baseTarget = baseEdge.getTarget();
					
					if(imageEdge.getType()==baseEdge.getType()) {
						if(baseTarget!=imageTarget)
							return false; // target inconsistent
						if(imageEdge.getType().isUnique()) {
							return baseEdge.getIndex().equals(imageEdge.getIndex()); // for a non-unique reference, the edge index determines the result
						} else
							return true; // for a unique reference, the edge index is determined by the source and target indices
					} else {
						return false; // type inconsistent
					}
				})) return true; // we found that imageEdge is a new edge
			} // end for
		} catch (Exception e) {
			return true;
		}

		return false;
	}
	
	public void setConstraint(GraphConstraint c) {
		this.constraint = c;
	}
	
	public GraphConstraint getConstraint() {
		return this.constraint;
	}
	
	public void declare(String graphString) {
		// 1. split by ';'
		// 2. match by node/edge formats
		
		Map<String,TypedNode> map = new HashMap<>();
		
		String[] statements = graphString.split(";");
		String nodeDeclPattern = "\\s*(\\w+)\\s*:\\s*(\\w+)\\s*";
		String propDeclPattern = "\\s*(\\w+)\\s*\\.\\s*(\\w+)\\s*=\\s*(\\d+|true|false|\".*\")\\s*";
		String edgeDeclPattern = "\\s*(\\w+)\\s*\\-\\s*(\\w+)\\s*->\\s*(\\w+)\\s*";
		
		Pattern ndp = Pattern.compile(nodeDeclPattern);
		Pattern pdp = Pattern.compile(propDeclPattern);
		Pattern edp = Pattern.compile(edgeDeclPattern);
		
		Matcher matcher = null;
		
		for(String stat : statements) {
			if((matcher=ndp.matcher(stat)).matches()) {
				String nodeName = matcher.group(1);
				String typeName = matcher.group(2);
				
				TypeNode type = this.typeGraph.getTypeNode(typeName);
				
				TypedNode n = new TypedNode();
				n.setType(type);
				this.addTypedNode(n);
				map.put(nodeName, n);
			} else if((matcher=pdp.matcher(stat)).matches()) {
				String sourceName = matcher.group(1);
				String featureName = matcher.group(2);
				String targetValue = matcher.group(3);
				
				TypedNode sn = (TypedNode) map.get(sourceName);
				PropertyEdge feature = this.typeGraph.getPropertyEdge(sn.getType(), featureName);
				Object value = null;
				
				if(targetValue.equals("true")||targetValue.equals("false")) {
					value = Boolean.parseBoolean(targetValue);
				} else if(targetValue.startsWith("\"")) {
					value = targetValue.substring(1, targetValue.length()-1);
				} else 
					value = Integer.parseInt(targetValue);
				
				ValueNode n = ValueNode.createConstantNode(value, feature.getTarget());
				this.addValueNode(n);
				
				ValueEdge e = new ValueEdge();
				e.setSource(sn);
				e.setTarget(n);
				e.setType(feature);
				this.addValueEdge(e);
			} else if((matcher=edp.matcher(stat)).matches()) {
				String sourceName = matcher.group(1);
				String featureName = matcher.group(2);
				String targetName = matcher.group(3);
				
				TypedNode sn = (TypedNode) map.get(sourceName);
				TypedNode tn = (TypedNode) map.get(targetName);
				TypeEdge feature = this.typeGraph.getTypeEdge(sn.getType(), featureName);
				
				TypedEdge e = new TypedEdge();
				e.setSource(sn);
				e.setTarget(tn);
				e.setType(feature);
				
				this.addTypedEdge(e);
			}
		}
	}
	
	@SuppressWarnings("unchecked")
	public void enforceOrder() throws NothingReturnedException {
		List<? extends ITypedEdge> results = null;
		
		results = reorderEdges(this.allTypedEdges);
		this.allTypedEdges = (List<TypedEdge>) results;
		
		results = reorderEdges(this.allValueEdges);
		this.allValueEdges = (List<ValueEdge>) results;
	}

	private List<? extends ITypedEdge> reorderEdges(List<? extends ITypedEdge> edges) throws NothingReturnedException {
		List<Index> indices = edges.stream().map(e->((IndexableElement)e).getIndex()).collect(Collectors.toList());
		
		Index[] orderedIndices = this.order.planOrder(indices);
		
		List<? extends ITypedEdge> results = new ArrayList<>();
		
		for(Index i : orderedIndices) {
			results.add(this.getElementByIndexObject(i));
		}
		return results;
	}

}
