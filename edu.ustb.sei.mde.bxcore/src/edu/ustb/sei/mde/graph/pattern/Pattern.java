package edu.ustb.sei.mde.graph.pattern;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.regex.Matcher;

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
import edu.ustb.sei.mde.graph.type.IStructuralFeatureEdge;
import edu.ustb.sei.mde.graph.type.ITypeNode;
import edu.ustb.sei.mde.graph.type.PropertyEdge;
import edu.ustb.sei.mde.graph.type.TypeEdge;
import edu.ustb.sei.mde.graph.type.TypeGraph;
import edu.ustb.sei.mde.graph.type.TypeNode;
import edu.ustb.sei.mde.graph.typedGraph.ITypedEdge;
import edu.ustb.sei.mde.graph.typedGraph.IndexableElement;
import edu.ustb.sei.mde.graph.typedGraph.TypedEdge;
import edu.ustb.sei.mde.graph.typedGraph.TypedGraph;
import edu.ustb.sei.mde.graph.typedGraph.TypedGraphCreator;
import edu.ustb.sei.mde.graph.typedGraph.TypedNode;
import edu.ustb.sei.mde.graph.typedGraph.ValueEdge;
import edu.ustb.sei.mde.graph.typedGraph.ValueNode;
import edu.ustb.sei.mde.modelsolver.EdgeVar;
import edu.ustb.sei.mde.modelsolver.GraphModel;
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
				Boolean.logicalXor(((PatternElement<?>) edge).isMany(), ((PatternElement<?>) edge.getSource()).isMany() ||  ((PatternElement<?>) edge.getTarget()).isMany())
				|| Boolean.logicalAnd(((PatternElement<?>) edge.getSource()).isMany(), ((PatternElement<?>) edge.getTarget()).isMany());
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
				IndexableElement so = (IndexableElement) nv.getSemanticObject();
				Object idx = so.isIndexable() ? so.getIndex() : ((ValueNode) so).getValue(); // unboxing here
				m.setValue(nv.getName(), idx);
			});

			model.getEdgeVars().forEach(ev -> {
				IndexableElement so = (IndexableElement) ev.getSemanticObject();
				Object idx = so.isIndexable() ? so.getIndex() : so;
				m.setValue(ev.getName(), idx);
			});
			
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
		
		group(matches);
		
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

	private void group(List<Context> matches) {
		List<FieldDef<?>> singleValuedFields = getType().singleValuedFields();
		if(singleValuedFields.size()==getType().fields().size()) return;
		
		List<Context> results = new ArrayList<>();
		for(Context c : matches) {
			Optional<Context> equal = results.stream().filter(x->x.isEqualForSingleValuedFields(c)).findFirst();
			if(equal.isPresent()) {
				equal.get().mergeMultiValuedFields(c);
			} else {
				results.add(c);
			}
		}
		
		matches.clear();
		matches.addAll(results);
	}

	@SuppressWarnings("unchecked")
	protected GraphModel getSolverModel(TypedGraph typedGraph, Context base) {
		GraphModel model = new GraphModel();
		Map<INode, NodeVar> varMap = new HashMap<>();
		ContextType baseType = base.getType();

		for (INode n : this.getNodes()) {
			String name = ((PatternElement<?>) n).getName();
			ITypeNode type = (ITypeNode) ((PatternElement<?>) n).getType();

			@SuppressWarnings("rawtypes")
			List domain = null;

			try {
				FieldDef<?> field = null;
				if ((field = baseType.getField(name)) == null) {
					if (n instanceof PatternNode) {
						domain = typedGraph.getAllTypedNodes();
					} else if (n instanceof PatternValueNode) {
						domain = typedGraph.getAllValueNodes();
					}
				} else {
					if (n instanceof PatternNode) {
						Index index = base.getIndexValue(field);
						TypedNode node = typedGraph.getElementByIndexObject(index);
						domain = new ArrayList<>(1);
						domain.add(node);

					} else if (n instanceof PatternValueNode) {
						Object nodeValue = base.getPrimitiveValue(field);
						domain = new ArrayList<>(1);
						domain.add(ValueNode.createConstantNode(nodeValue, ((PatternValueNode) n).getType()));
					}
				}
			} catch (Exception ex) {
				domain = Collections.emptyList();
			}

			if (domain.isEmpty())
				return null;
			else {
				NodeVar v = model.nodeVar(name, domain);
				varMap.put(n, v);
				model.nodeType(v, type, typeGraph).post();
			}
		}

		for (IEdge e : this.getEdges()) {
			String name = ((PatternElement<?>) e).getName();
			IStructuralFeatureEdge type = (IStructuralFeatureEdge) ((PatternElement<?>) e).getType();
			List<ITypedEdge> domain = null;

			try {
				FieldDef<?> field = null;
				if ((field = baseType.getField(name)) == null) {
					if (e instanceof PatternEdge) {
						domain = new ArrayList<ITypedEdge>(typedGraph.getAllTypedEdges());
					} else if (e instanceof PatternValueEdge) {
						domain = new ArrayList<ITypedEdge>(typedGraph.getAllValueEdges());
					}
				} else {
					if (e instanceof PatternEdge) {
						Index index = base.getIndexValue(field);
						TypedEdge edge = typedGraph.getElementByIndexObject(index);
						domain = new ArrayList<>();
						domain.add(edge);
					} else if (e instanceof PatternValueEdge) {
						Index index = base.getIndexValue(field);
						ValueEdge edge = typedGraph.getElementByIndexObject(index);
						domain = new ArrayList<>();
						domain.add(edge);
					}
				}
			} catch (Exception ex) {
				domain = Collections.emptyList();
			}

			if (domain.isEmpty())
				return null;
			else {
				EdgeVar v = model.edgeVar(name, domain);
				model.edgeType(v, type, typeGraph).post();

				NodeVar s = varMap.get(e.getSource());
				NodeVar t = varMap.get(e.getTarget());
				model.connection(s, v, t).post();
			}
		}
		return model;
	}

	public void appendPatternNode(String name, ITypeNode type, boolean many) {
		if (type instanceof TypeNode) {
			PatternNode node = new PatternNode();
			node.setName(name);
			node.setType((TypeNode) type);
			node.setMany(many);
			this.addNode(node);
		} else if (type instanceof DataTypeNode) {
			PatternValueNode node = new PatternValueNode();
			node.setName(name);
			node.setType((DataTypeNode) type);
			node.setMany(many);
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
			if(((PatternElement<?>) n).isMany()) {
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
			
			if(((PatternElement<?>) n).isMany()) {
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
		String sourceNodeName = ((PatternElement<?>) n.getSource()).isMany() ? ((PatternElement<?>) n.getSource()).getName()+'-'+id : ((PatternElement<?>) n.getSource()).getName();
		String targetNodeName = ((PatternElement<?>) n.getTarget()).isMany() ? ((PatternElement<?>) n.getTarget()).getName()+'-'+id : ((PatternElement<?>) n.getTarget()).getName();
		
		if (n instanceof PatternEdge) {
			TypedEdge edge = null;
			try {
				edge = referenceGraph.getElementByIndexObject(index);
				if (edge.getType() == ((PatternEdge) n).getType()
						&& edge.getSource() == creator.getNode(sourceNodeName)
						&& edge.getTarget() == creator.getNode(targetNodeName))
					graph.addTypedEdge(edge);
				else {
					throw new NothingReturnedException();
				}
			} catch (NothingReturnedException | NullPointerException e) {
				edge = creator.createTypedEdge(sourceNodeName, targetNodeName, ((PatternEdge) n).getType(), index);
			}

		} else if (n instanceof PatternValueEdge) {
			ValueEdge edge = null;
			try {
				edge = referenceGraph.getElementByIndexObject(index);
				if (edge.getType() == ((PatternValueEdge) n).getType()
						&& edge.getSource() == creator.getNode(sourceNodeName)
						&& edge.getTarget() == creator.getNode(targetNodeName))
					graph.addValueEdge(edge);
				else {
					throw new NothingReturnedException();
				}
			} catch (NothingReturnedException | NullPointerException e) {
				edge = creator.createValueEdge(sourceNodeName, targetNodeName, ((PatternValueEdge) n).getType(), index);
			}
		}
	}

	protected void createNode(int id, INode n, Object value, TypedGraphCreator creator, TypedGraph graph,
			TypedGraph referenceGraph) {
		String nodeName = id!=-1 ? ((PatternElement<?>) n).getName()+'-'+id : ((PatternElement<?>) n).getName();
		
		if (n instanceof PatternNode) {
			Index index = (Index) value;
			TypedNode node = null;

			try {
				node = referenceGraph.getElementByIndexObject(index);

				if (typeGraph.isSuperTypeOf(node.getType(), ((PatternNode) n).getType())) {
					graph.addTypedNode(node);
					creator.registerNode(nodeName, node);
				} else {
					throw new NothingReturnedException();
				}

			} catch (NothingReturnedException | NullPointerException e) {
				node = creator.createTypedNode(nodeName, ((PatternNode) n).getType(), index);
			}
		} else if (n instanceof PatternValueNode) {
			creator.createValueNode(nodeName, value, ((PatternValueNode) n).getType());
		}
	}

	public boolean isMatchOf(TypedGraph graph, Context match) {		
		boolean nodeConsistent = this.nodes.stream().allMatch(n->{
			try {
				if(n instanceof PatternNode) {
					if(!((PatternNode)n).isMany()) {
						Index value = match.getValue(((PatternNode)n).getName());
						TypedNode e = graph.getElementByIndexObject(value);
						return graph.getTypeGraph().isSuperTypeOf(e.getType(), ((PatternNode)n).getType());
					} else {
						List<Index> values = match.getValue(((PatternNode)n).getName());
						return values.stream().allMatch(value->{
							try {
								TypedNode e = graph.getElementByIndexObject(value);
								return graph.getTypeGraph().isSuperTypeOf(e.getType(), ((PatternNode)n).getType());
							} catch (Exception e) {
								return false;
							}
						});
					}
				} else {
					match.getValue(((PatternValueNode)n).getName()); // we do not check value type
					return true;
				}
			} catch (Exception e) {
				return false;
			}
		});
		
		if(!nodeConsistent) return false;
		
		boolean edgeConsistent = this.edges.stream().allMatch(e->{
			try {
				if(e instanceof PatternEdge) {
					PatternNode sn = (PatternNode) e.getSource();
					PatternNode tn = (PatternNode) e.getTarget();
					Object sv = match.getValue(sn.getName());
					Object vv = match.getValue(tn.getName());
					
					if(((PatternEdge) e).isMany()) {
						BiFunction<Object, Integer, Object> sid = sn.isMany() ? LIST : ELEMENT;
						BiFunction<Object, Integer, Object> tid = tn.isMany() ? LIST : ELEMENT;
						List<Index> edgeIndices = match.getValue(((PatternEdge) e).getName());
						for(int i=0;i<edgeIndices.size();i++) {
							Index idx = edgeIndices.get(i);
							TypedEdge edge = graph.getElementByIndexObject(idx);
							if(edge.getType()==((PatternEdge) e).getType()) {
								if(!(isNodeEqual(edge.getSource(),(Index) sid.apply(sv,i)) 
										&& isNodeEqual(edge.getTarget(), (Index) tid.apply(vv,i))))
									return false;
							} else return false;
						}
						return true;
					} else {
						Index edgeIndex = match.getValue(((PatternEdge) e).getName());
						TypedEdge edge = graph.getElementByIndexObject(edgeIndex);
						if(edge.getType()==((PatternEdge) e).getType()) {
							return isNodeEqual(edge.getSource(),(Index)sv) 
									&& isNodeEqual(edge.getTarget(), (Index)vv);
						} else return false;
					}
				} else {
					PatternNode sn = (PatternNode) e.getSource();
					PatternValueNode tn = (PatternValueNode) e.getTarget();
					Object sv = match.getValue(sn.getName());
					Object vv = match.getValue(tn.getName());
					
					if(((PatternValueEdge)e).isMany()) {
						BiFunction<Object, Integer, Object> sid = sn.isMany() ? LIST : ELEMENT;
						BiFunction<Object, Integer, Object> tid = tn.isMany() ? LIST : ELEMENT;
						List<Index> edgeIndices = match.getValue(((PatternValueEdge) e).getName());
						for(int i=0;i<edgeIndices.size();i++) {
							Index idx = edgeIndices.get(i);
							ValueEdge edge = graph.getElementByIndexObject(idx);
							if(edge.getType()==((PatternValueEdge) e).getType()) {
								if(!(isNodeEqual(edge.getSource(),(Index) sid.apply(sv,i)) 
										&& isValueEqual(edge.getTarget(), tid.apply(vv,i))))
									return false;
							} else return false;
						}
						return true;
					} else {
						Index edgeIndex = match.getValue(((PatternValueEdge) e).getName());
						ValueEdge edge = graph.getElementByIndexObject(edgeIndex);
						if(edge.getType()==((PatternValueEdge) e).getType()) {
							return isNodeEqual(edge.getSource(),(Index) sv) 
									&& isValueEqual(edge.getTarget(), vv);
						} else return false;
					}
				}
			} catch (Exception x) {
				return false;
			}
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

	protected boolean isValueEqual(ValueNode valueNode, Object value) {
		if(valueNode.getValue()==null) return value==null;
		else return valueNode.getValue().equals(value);
	}
	
	protected boolean isNodeEqual(TypedNode node, Index index) {
		return node.getIndex().equals(index);
	}
	
	@SuppressWarnings("unchecked")
	static BiFunction<Object,Integer,Object> LIST = (v,i)->((List<Object>)v).get(i);
	static BiFunction<Object,Integer,Object> ELEMENT = (v,i)->v;

//	private boolean checkTypeMatch(Object value, FieldDef<?> f, TypedGraph graph) {
//		try {
//			if(f.isElementType()) {
//				IndexableElement e = graph.getElementByIndexObject((Index)value);
//				if(e instanceof TypedNode && f.getType() instanceof TypeNode) {
//					return graph.getTypeGraph().isSuperTypeOf(((TypedNode) e).getType(), (TypeNode)f.getType());
//				} else if(e instanceof ITypedEdge && f.getType() instanceof IStructuralFeatureEdge) {
//					return ((ITypedEdge) e).getType()==f.getType();
//				} else return false;
//			} else {
//				return value.getClass() == ((DataTypeNode)f.getType()).getDataType(); // or simply ignore?
//			}
//		} catch(Exception e) {
//			return false;
//		}
//	}

	private ContextType type = null;

	public ContextType getType() {
		if (type == null) {
			type = new ContextType();
			this.getNodes().forEach(n -> {
				type.addField(((PatternElement<?>) n).getName(), ((PatternElement<?>) n).getType(), ((PatternElement<?>) n).isMany());
			});
			this.getEdges().forEach(e -> {
				type.addField(((PatternElement<?>) e).getName(), ((PatternElement<?>) e).getType(), ((PatternElement<?>) e).isMany());
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
