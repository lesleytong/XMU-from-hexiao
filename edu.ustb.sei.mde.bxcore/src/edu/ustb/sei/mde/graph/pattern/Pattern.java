package edu.ustb.sei.mde.graph.pattern;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.stream.Collectors;

import org.chocosolver.solver.variables.Variable;

import edu.ustb.sei.mde.bxcore.XmuCoreUtils;
import edu.ustb.sei.mde.bxcore.exceptions.NothingReturnedException;
import edu.ustb.sei.mde.bxcore.exceptions.UninitializedException;
import edu.ustb.sei.mde.bxcore.structures.Context;
import edu.ustb.sei.mde.bxcore.structures.ContextGraph;
import edu.ustb.sei.mde.bxcore.structures.ContextType;
import edu.ustb.sei.mde.bxcore.structures.FieldDef;
import edu.ustb.sei.mde.bxcore.structures.Index;
import edu.ustb.sei.mde.graph.IEdge;
import edu.ustb.sei.mde.graph.IGraph;
import edu.ustb.sei.mde.graph.INamedElement;
import edu.ustb.sei.mde.graph.INode;
import edu.ustb.sei.mde.graph.type.DataTypeNode;
import edu.ustb.sei.mde.graph.type.ICollectionType;
import edu.ustb.sei.mde.graph.type.IStructuralFeatureEdge;
import edu.ustb.sei.mde.graph.type.ITypeNode;
import edu.ustb.sei.mde.graph.type.PathType;
import edu.ustb.sei.mde.graph.type.PropertyEdge;
import edu.ustb.sei.mde.graph.type.TypeEdge;
import edu.ustb.sei.mde.graph.type.TypeGraph;
import edu.ustb.sei.mde.graph.type.TypeNode;
import edu.ustb.sei.mde.graph.typedGraph.IndexableElement;
import edu.ustb.sei.mde.graph.typedGraph.TypedEdge;
import edu.ustb.sei.mde.graph.typedGraph.TypedGraph;
import edu.ustb.sei.mde.graph.typedGraph.TypedGraphCreator;
import edu.ustb.sei.mde.graph.typedGraph.TypedNode;
import edu.ustb.sei.mde.graph.typedGraph.ValueEdge;
import edu.ustb.sei.mde.graph.typedGraph.ValueNode;
import edu.ustb.sei.mde.modelsolver.EdgeSetVar;
import edu.ustb.sei.mde.modelsolver.GraphModel;
import edu.ustb.sei.mde.modelsolver.NodeSetVar;
import edu.ustb.sei.mde.modelsolver.NodeVar;
import edu.ustb.sei.mde.structure.Tuple2;

public class Pattern implements IGraph {
	private List<INode> nodes = new ArrayList<INode>();
	private List<IEdge> edges = new ArrayList<IEdge>();
	private TypeGraph typeGraph;
	private Function<ContextGraph, Boolean> filter;
	
	// it seems that the additional fields of a pattern should be associated with an initializer
	// we check whether they are context vars or dependent vars now // not implemented!!
	// maybe we should allow initializer in field def
	private List<Tuple2<FieldDef<?>, Function<ContextGraph, Object>>> additionalFields = new ArrayList<>(); 

	public void setFilter(Function<ContextGraph, Boolean> filter) {
		this.filter = filter;
	}

	private PatternElement<?> orderBy = null;
	
	
	public Pattern() {
	}
	
	public Pattern(TypeGraph typeGraph) {
		this.typeGraph = typeGraph;
	}
	
	public Pattern(TypeGraph typeGraph, ContextType type) {
		this.typeGraph = typeGraph;
		this.type = type;
	}
	
	public void setOrderBy(PatternElement<?> o) {
		this.orderBy = o;
	}

	public List<INode> getNodes() {
		return nodes;
	}

	public List<IEdge> getEdges() {
		return edges;
	}

	public void addNode(INode node) {
		this.nodes.add(node);
	}

	public void addEdge(IEdge edge) {
		boolean manyCons = 
				Boolean.logicalXor(((PatternElement<?>) edge).isCollection(), ((PatternElement<?>) edge.getSource()).isCollection() ||  ((PatternElement<?>) edge.getTarget()).isCollection())
				|| Boolean.logicalAnd(((PatternElement<?>) edge.getSource()).isCollection(), ((PatternElement<?>) edge.getTarget()).isCollection());
		if(manyCons) {
			throw new RuntimeException("Invalid pattern edge");
		}
		this.edges.add(edge);
	}
	
	public void addAdditionalField(FieldDef<?> field) {
		this.additionalFields.add(Tuple2.make(field,null));
	}
	
	public void addAdditionalField(FieldDef<?> field, Function<ContextGraph, Object> function) {
		this.additionalFields.add(Tuple2.make(field,function));
	}

	public TypeGraph getTypeGraph() {
		return typeGraph;
	}

	public void setTypeGraph(TypeGraph typeGraph) {
		this.typeGraph = typeGraph;
	}

	public List<Context> match(TypedGraph typedGraph, Context base) {

		GraphModel model = getSolverModel(typedGraph, base);

		if (model == null)
			return Collections.emptyList();

		org.chocosolver.solver.Solver solver = model.getSolver();
		
		ContextGraph contextGraph = ContextGraph.makeContextGraph(typedGraph, base);

		List<Context> matches = new ArrayList<>();

		while (solver.solve()) {
			Context m = this.getType().createInstance();
			model.getNodeVars().forEach(nv -> {
				IndexableElement so = (IndexableElement) nv.getValue();
				Object idx = so.isIndexable() ? so.getIndex() : ((ValueNode) so).getValue(); // unboxing here
				m.setValue(nv.getName(), idx);
			});

			model.getEdgeVars().forEach(ev -> {
				IndexableElement so = (IndexableElement) ev.getValue();
				Object idx = so.isIndexable() ? so.getIndex() : so;
				m.setValue(ev.getName(), idx);
			});
			
			// special treatment for order-sensitive variables
			model.getEdgeSetVars().forEach(nv->{
				try {
					List<Index> edges = base.getValue(nv.getName());
					m.setValue(nv.getName(), edges);
					// rebuild the order of source/target collection nodes
					IEdge e = this.getEdge(nv.getName());
					
					if(((PatternElement<?>)e.getSource()).isCollection()) {
						List<?> srcValue = edges.stream().map(v->{
							IEdge edge;
							try {
								edge = typedGraph.getElementByIndexObject(v);
								return edge.getSource();
							} catch (NothingReturnedException e1) {
								e1.printStackTrace();
								return null;
							}
						}).collect(Collectors.toList());
						m.setValue(((PatternElement<?>)e.getSource()).getName(), srcValue);
					}
					
					if(((PatternElement<?>)e.getTarget()).isCollection()) {
						List<?> tarValue = edges.stream().map(v->{
							IEdge edge;
							try {
								edge = typedGraph.getElementByIndexObject(v);
								return edge.getTarget();
							} catch (NothingReturnedException e1) {
								e1.printStackTrace();
								return null;
							}
						}).collect(Collectors.toList());
						m.setValue(((PatternElement<?>)e.getTarget()).getName(), tarValue);
					}
				} catch (UninitializedException | NothingReturnedException e1) {
					List<?> edges = nv.getLBValueList();
					List<?> value = edges.stream().map(n->{
						IndexableElement so = (IndexableElement) n;
						return so.isIndexable() ? so.getIndex() : so;
					}).collect(Collectors.toList());
					m.setValue(nv.getName(), value);
					// rebuild the order of source/target collection nodes
					IEdge e = this.getEdge(nv.getName());
					
					if(((PatternElement<?>)e.getSource()).isCollection()) {
						List<?> srcValue = edges.stream().map(v->((IEdge)v).getSource()).collect(Collectors.toList());
						m.setValue(((PatternElement<?>)e.getSource()).getName(), srcValue);
					}
					
					if(((PatternElement<?>)e.getTarget()).isCollection()) {
						List<?> tarValue = edges.stream().map(v->((IEdge)v).getTarget()).collect(Collectors.toList());
						m.setValue(((PatternElement<?>)e.getTarget()).getName(), tarValue);
					}
				}
				
				
			});
			
//			model.getNodeSetVars().forEach(nv->{
//				List<?> value = nv.getLBValue().stream().map(n->{
//					IndexableElement so = (IndexableElement) n;
//					return so.isIndexable() ? so.getIndex() : ((ValueNode) so).getValue();
//				}).collect(Collectors.toList());
//				m.setValue(nv.getName(), value);
//			});
			
			contextGraph.replaceContext(m);
			
			boolean valueFilter = this.additionalFields.stream().allMatch(f->{
				try {
					Object bv = base.getValue(f.first);
					m.setValue(f.first, bv);
					if(f.second!=null) {
						Object cv = f.second.apply(contextGraph);
						return cv==bv || (cv!=null && cv.equals(bv));
					} else return true;
				} catch (UninitializedException e) {
					if(f.second!=null) {
						m.setValue(f.first, f.second.apply(contextGraph));
						return true;
					} else return false;
				} catch (Exception e) {
					return false;
				}
			});
			
			if(valueFilter && (this.filter==null || this.filter.apply(contextGraph)))
				matches.add(m);
		}
		
//		group(matches);
		
		if(this.orderBy!=null) {
			List<Index> set = new ArrayList<>();
			Map<Index, Context> map = new HashMap<>();
			FieldDef<?> field = this.getType().getField(this.orderBy.getName());
			for(Context m : matches) {
				try {
					Index idx = m.getIndexValue(field);
					set.add(idx);
					map.put(idx, m);
				} catch (UninitializedException | NothingReturnedException e) {
				}				
			}
			
			if(set.size()!=matches.size()) {
				XmuCoreUtils.failure("Matches were discarded due to invalid order");
				return Collections.emptyList();
			}
			
			try {
				Index[] ordered =  typedGraph.getOrder().planOrder(set);
				
				List<Context> result = new ArrayList<>(matches.size());
				for(Index i : ordered)
					result.add(map.get(i));
				
				return result;
			} catch (NothingReturnedException e) {
				XmuCoreUtils.failure("Matches were discarded due to invalid order");
				return Collections.emptyList();
			}
			
		} else 
			return matches;
	}
	
	static final Object[] EMPTY_ARR = new Object[0];
	@SuppressWarnings({ "unchecked" })
	protected GraphModel getSolverModel(TypedGraph typedGraph, Context base) {
		GraphModel model = new GraphModel("pattern");
		Map<INode, Variable> varMap = new HashMap<>();
		ContextType baseType = base.getType();
		
		for (INode n : this.getNodes()) {
			String name = ((PatternElement<?>) n).getName();
			ITypeNode nodeType = (ITypeNode) ((PatternElement<?>) n).getElementType();
			
			INode[] domain = null;
			boolean fixedValue = false;
			try {
				FieldDef<?> field = null;
				if ((field = baseType.getField(name)) == null) {
					if(n instanceof PatternNode) {
						domain = typedGraph.getTypedNodesOf((TypeNode) nodeType);
					} else if (n instanceof PatternValueNode) {
						domain = typedGraph.getValueNodesOf((DataTypeNode) nodeType);
					}
				} else {
					if(n instanceof PatternNode) {
						if(((PatternElement<?>) n).getType() instanceof ICollectionType) {
							List<Index> indices = base.getValue(field);
							domain = new INode[indices.size()];
							for(int i = 0; i< indices.size() ; i++)
								domain[i] = typedGraph.getElementByIndexObject(indices.get(i));
						} else {
							Index index = base.getIndexValue(field);
							TypedNode node = typedGraph.getElementByIndexObject(index);
							domain = new INode[1];
							domain[0] = node;
						}
					} else if (n instanceof PatternValueNode) {
						if(((PatternElement<?>) n).getType() instanceof ICollectionType) {
							List<Object> values = base.getValue(field);
							domain = new INode[values.size()];
							for(int i=0;i<values.size();i++) {
								domain[i] = ValueNode.createConstantNode(values.get(i), (DataTypeNode) nodeType);
							}
						} else {
							Object nodeValue = base.getPrimitiveValue(field);
							domain = new INode[1];
							domain[0] = ValueNode.createConstantNode(nodeValue, (DataTypeNode) nodeType);
						}
					}
					fixedValue = true;
				}
			} catch (Exception e) {
				domain  = (INode[]) EMPTY_ARR;
			}
			
			if(domain.length==0) {
				return null;
			} else {
				if(((PatternElement<?>) n).getType() instanceof ICollectionType) {
					NodeSetVar<INode> var = fixedValue 
							? model.fixedNodeSet(name, nodeType, domain) 
									: model.nodeSet(name, nodeType, domain);
					varMap.put(n, var);
				} else {
					NodeVar<INode> var = model.node(name, nodeType, domain);
					varMap.put(n, var);
				}
			}
		}
		
		for (IEdge n : this.getEdges()) {
			String name = ((PatternElement<?>) n).getName();
			IStructuralFeatureEdge edgeType = (IStructuralFeatureEdge) ((PatternElement<?>) n).getElementType();
			
			IEdge[] domain = (IEdge[]) EMPTY_ARR;
			boolean fixedValue = false;
			try {
				FieldDef<?> field = null;
				if ((field = baseType.getField(name)) == null) {
					if(n instanceof PatternEdge) {
						domain = typedGraph.getTypedEdgesOf((TypeEdge) edgeType);
					} else if(n instanceof PatternValueEdge) {
						domain = typedGraph.getValueEdgesOf((PropertyEdge) edgeType);
					}
				} else {
					if(n instanceof PatternEdge || n instanceof PatternValueEdge) {
						if(((PatternElement<?>) n).getType() instanceof ICollectionType) {
							List<Index> indices = base.getValue(field);
							domain = new IEdge[indices.size()];
							for(int i = 0; i< indices.size() ; i++)
								domain[i] = typedGraph.getElementByIndexObject(indices.get(i));
						} else {
							Index index = base.getIndexValue(field);
							IEdge node = typedGraph.getElementByIndexObject(index);
							domain = new IEdge[1];
							domain[0] = node;
						}
					} else if(n instanceof PatternPathEdge) {
						System.out.println("no support");
					}
					fixedValue = true;
				}
			} catch (Exception e) {
				domain  = (IEdge[]) EMPTY_ARR;
			}
			
			if(domain.length==0) {
				return null;
			} else {
				if(edgeType instanceof PathType) {
					// FIXME
				} else {					
					if(((PatternElement<?>) n).getType() instanceof ICollectionType) {
						EdgeSetVar<IEdge> var = fixedValue 
								? model.fixedEdgeSet(name, edgeType, domain) 
										: model.edgeSet(name, edgeType, domain);
								
								if(((PatternElement<?>)n.getSource()).getType() instanceof ICollectionType) {
									NodeSetVar<INode> sv = (NodeSetVar<INode>) varMap.get(n.getSource());
									edu.ustb.sei.mde.modelsolver.NodeVar<INode> tv = (edu.ustb.sei.mde.modelsolver.NodeVar<INode>) varMap.get(n.getTarget());
									model.connection(var, sv, tv).post();
								} else {
									NodeSetVar<INode> tv = (NodeSetVar<INode>) varMap.get(n.getTarget());
									edu.ustb.sei.mde.modelsolver.NodeVar<INode> sv = (edu.ustb.sei.mde.modelsolver.NodeVar<INode>) varMap.get(n.getSource());
									model.connection(var, sv, tv).post();
								}
					} else {
						edu.ustb.sei.mde.modelsolver.EdgeVar<IEdge> var = model.edge(name, edgeType, domain);
						edu.ustb.sei.mde.modelsolver.NodeVar<INode> sv = (edu.ustb.sei.mde.modelsolver.NodeVar<INode>) varMap.get(n.getSource());
						edu.ustb.sei.mde.modelsolver.NodeVar<INode> tv = (edu.ustb.sei.mde.modelsolver.NodeVar<INode>) varMap.get(n.getTarget());
						
						model.connection(var, sv, tv).post();
					}
				}
			}
		}
		return model;		
	}

	public void appendPatternNode(String name, ITypeNode type, boolean many) {
		if (type instanceof TypeNode) {
			PatternNode node = new PatternNode();
			node.setName(name);
			node.setType((TypeNode) type);
			node.setCollection(many);
			this.addNode(node);
		} else if (type instanceof DataTypeNode) {
			PatternValueNode node = new PatternValueNode();
			node.setName(name);
			node.setType((DataTypeNode) type);
			node.setCollection(many);
			this.addNode(node);
		}
	}

	public void appendPatternEdge(String name, String source, String target, IStructuralFeatureEdge type) {
		if (type instanceof TypeEdge) {
			PatternEdge edge = new PatternEdge();
			edge.setName(name);
			edge.setSource((PatternNode) getNode(source));
			edge.setTarget((PatternNode) getNode(target));
			edge.setType((TypeEdge) type);
			this.addEdge(edge);
		} else if (type instanceof PropertyEdge) {
			PatternValueEdge edge = new PatternValueEdge();
			edge.setName(name);
			edge.setSource((PatternNode) getNode(source));
			edge.setTarget((PatternValueNode) getNode(target));
			edge.setType((PropertyEdge) type);
			this.addEdge(edge);
		}
		// TODO: handle path edge
	}

	public PatternElement<?> getPatternElement(String name) {
		try {
			return (PatternElement<?>) getNode(name);
		} catch (Exception e) {
			return (PatternElement<?>) getEdge(name);
		}
	}

	public INode getNode(String name) {
		return this.nodes.stream().filter(n -> name.equals(((INamedElement) n).getName())).findFirst().get();
	}

	public IEdge getEdge(String name) {
		return this.edges.stream().filter(n -> name.equals(((INamedElement) n).getName())).findFirst().get();
	}

	public String toString() {
		StringBuilder builder = new StringBuilder();
		this.getNodes().forEach(n -> {
			builder.append(n.toString());
			builder.append("\n");
		});

		this.getEdges().forEach(n -> {
			builder.append(n.toString());
			builder.append("\n");
		});

		return builder.toString();
	}

	@SuppressWarnings("unchecked")
	public TypedGraph construct(TypedGraph referenceGraph, Context context)
			throws UninitializedException, NothingReturnedException {
		TypedGraph graph = new TypedGraph(typeGraph);
		ContextType contextType = context.getType();

		TypedGraphCreator creator = new TypedGraphCreator(graph);

		for (INode n : this.nodes) {
			Object value = context.getValue(((PatternElement<?>) n).getName());
			if(((PatternElement<?>) n).isCollection()) {
				List<Object> values = (List<Object>) value;
				int id = 0;
				for(Object v : values) {
					createNode(id, n, v, creator, graph, referenceGraph);
					id++;
				}
			} else {
				createNode(-1, n, value, creator, graph, referenceGraph);				
			}
		}

		for (IEdge n : this.edges) {
			Object value = context.getValue(contextType.getField(((PatternElement<?>) n).getName()));
			
			if(((PatternElement<?>) n).isCollection()) {
				// TODO: handle path edge
				
				List<Index> values = (List<Index>) value;
				int id = 0;
				for(Index v : values) {
					createEdge(id, n, v, creator, graph, referenceGraph);
					id++;
				}
			} else {
				Index index = (Index) value;
				createEdge(-1, n, index, creator, graph, referenceGraph);				
			}
		}

		return graph;
	}

	protected void createEdge(int id, IEdge n, Index index, TypedGraphCreator creator, TypedGraph graph, TypedGraph referenceGraph) {
		String sourceNodeName = ((PatternElement<?>) n.getSource()).isCollection() ? ((PatternElement<?>) n.getSource()).getName()+'-'+id : ((PatternElement<?>) n.getSource()).getName();
		String targetNodeName = ((PatternElement<?>) n.getTarget()).isCollection() ? ((PatternElement<?>) n.getTarget()).getName()+'-'+id : ((PatternElement<?>) n.getTarget()).getName();
		
		if (n instanceof PatternEdge) {
			TypedEdge edge = null;
			try {
				edge = referenceGraph.getElementByIndexObject(index);
				if (((PatternEdge) n).getElementType().isInstance(edge)
						&& edge.getSource() == creator.getNode(sourceNodeName)
						&& edge.getTarget() == creator.getNode(targetNodeName))
					graph.addTypedEdge(edge);
				else {
					throw new NothingReturnedException();
				}
			} catch (NothingReturnedException | NullPointerException e) {
				edge = creator.createTypedEdge(sourceNodeName, targetNodeName, ((PatternEdge) n).getElementType(), index);
			}

		} else if (n instanceof PatternValueEdge) {
			ValueEdge edge = null;
			try {
				edge = referenceGraph.getElementByIndexObject(index);
				if (((PatternValueEdge) n).getElementType().isInstance(edge)
						&& edge.getSource() == creator.getNode(sourceNodeName)
						&& edge.getTarget() == creator.getNode(targetNodeName))
					graph.addValueEdge(edge);
				else {
					throw new NothingReturnedException();
				}
			} catch (NothingReturnedException | NullPointerException e) {
				edge = creator.createValueEdge(sourceNodeName, targetNodeName, ((PatternValueEdge) n).getElementType(), index);
			}
		}
		// handle path edge
	}

	protected void createNode(int id, INode n, Object value, TypedGraphCreator creator, TypedGraph graph,
			TypedGraph referenceGraph) {
		String nodeName = id!=-1 ? ((PatternElement<?>) n).getName()+'-'+id : ((PatternElement<?>) n).getName();
		
		if (n instanceof PatternNode) {
			Index index = (Index) value;
			TypedNode node = null;

			try {
				node = referenceGraph.getElementByIndexObject(index);

				if (((PatternNode) n).getElementType().isInstance(node)) {
					graph.addTypedNode(node);
					creator.registerNode(nodeName, node);
				} else {
					throw new NothingReturnedException();
				}

			} catch (NothingReturnedException | NullPointerException e) {
				node = creator.createTypedNode(nodeName, ((PatternNode) n).getElementType(), index);
			}
		} else if (n instanceof PatternValueNode) {
			creator.createValueNode(nodeName, value, ((PatternValueNode) n).getElementType() );
		}
	}

	public boolean isMatchOf(TypedGraph graph, Context match) {		
		boolean nodeConsistent = this.nodes.stream().allMatch(n->{
			return ((PatternElement<?>)n).isMatchOf(match, graph);
		});
		
		if(!nodeConsistent) return false;
		
		boolean edgeConsistent = this.edges.stream().allMatch(e->{
			return ((PatternElement<?>)e).isMatchOf(match, graph);
		});
		
		if(!edgeConsistent) return false;
		
		ContextGraph contextGraph = ContextGraph.makeContextGraph(graph, match);
		
		boolean additionalValueConsistent = this.additionalFields.stream().allMatch(f->{
			if(f.second!=null) {
				try {
					Object mv = match.getValue(f.first.getName());
					Object dv = f.second.apply(contextGraph);
					return mv==dv || (dv!=null && dv.equals(mv));
				} catch (UninitializedException e) {
					match.setValue(f.first, f.second.apply(contextGraph));
					return true;
				} catch (Exception e) {
					return false;
				}
			} else {
				try {
					match.getValue(f.first.getName());
					return true;
				} catch (Exception e) {
					return false;
				}
			}
		});
		
		if(!additionalValueConsistent) return false;
		
		return filter==null || filter.apply(contextGraph);
	}

	private ContextType type = null;

	public ContextType getType() {
		if (type == null) {
			type = new ContextType();
			this.getNodes().forEach(n -> {
				type.addField(((PatternElement<?>) n).getName(), ((PatternElement<?>) n).getType(), ((PatternElement<?>) n).isCollection());
			});
			this.getEdges().forEach(e -> {
				type.addField(((PatternElement<?>) e).getName(), ((PatternElement<?>) e).getType(), ((PatternElement<?>) e).isCollection());
			});
			this.additionalFields.forEach(f->{
				type.addField(f.first);
			});
		}
		return type;
	}

	public void setType(ContextType t) {
		this.type = t;
	}

	public void declare(String patternShape) {
		String[] statements = patternShape.split(";");
		String nodeDecl = "\\s*(\\w+)\\s*:\\s*(\\w+)\\s*(\\*)?\\s*";
		String edgeDecl = "\\s*(\\w+)\\s*(!?)\\s*:\\s*(\\w+)\\s*\\-(\\w+)->\\s*(\\w+)\\s*";
		java.util.regex.Pattern nodePat = java.util.regex.Pattern.compile(nodeDecl);
		java.util.regex.Pattern edgePat = java.util.regex.Pattern.compile(edgeDecl);

		for (String stat : statements) {
			Matcher matcher = null;
			if ((matcher = nodePat.matcher(stat)).matches()) {
				String nodeName = matcher.group(1);
				String typeName = matcher.group(2);
				String many = matcher.group(3);
				
				ITypeNode type = null;

				if ((type = this.typeGraph.getTypeNode(typeName)) == null) {
					type = this.typeGraph.getDataTypeNode(typeName);
				}

				this.appendPatternNode(nodeName, type, many!=null && many.length()!=0);
			} else if ((matcher = edgePat.matcher(stat)).matches()) {
				String edgeName = matcher.group(1);
				String orderBy = matcher.group(2);
				String sourceName = matcher.group(3);
				String targetName = matcher.group(5);
				String typeName = matcher.group(4);

				PatternElement<?> sourceNode = this.getPatternElement(sourceName);
				TypeNode st = (TypeNode) sourceNode.getType();

				IStructuralFeatureEdge type = null;
				if ((type = this.typeGraph.getTypeEdge(st, typeName)) == null) {
					type = this.typeGraph.getPropertyEdge(st, typeName);
				}

				this.appendPatternEdge(edgeName, sourceName, targetName, type);
				
				if(orderBy.equals("!")) {
					PatternElement<?> pe = this.getPatternElement(edgeName);
					this.setOrderBy(pe);
				}
			}

		}

	}

	public PatternElement<?> getOrderBy() {
		return this.orderBy;
	}
}
