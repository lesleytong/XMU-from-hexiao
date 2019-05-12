package edu.ustb.sei.mde.graph.pattern;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.regex.Matcher;

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
import edu.ustb.sei.mde.graph.type.IPathType;
import edu.ustb.sei.mde.graph.type.PropertyEdge;
import edu.ustb.sei.mde.graph.type.TypeEdge;
import edu.ustb.sei.mde.graph.type.TypeGraph;
import edu.ustb.sei.mde.graph.type.TypeNode;
import edu.ustb.sei.mde.graph.typedGraph.TypedEdge;
import edu.ustb.sei.mde.graph.typedGraph.TypedGraph;
import edu.ustb.sei.mde.graph.typedGraph.TypedGraphCreator;
import edu.ustb.sei.mde.graph.typedGraph.TypedNode;
import edu.ustb.sei.mde.graph.typedGraph.ValueEdge;
import edu.ustb.sei.mde.structure.Tuple2;

/**
 * A pattern is an extended graph structure.
 * It could be a plain graph, or a graph with collective nodes/edges, and path edges.
 * For any collective node, there must be at most one (collective) edge that connects to it.
 * The condition that involves collective nodes will not be used to filter elements in the collection.
 * @author hexiao
 *
 */
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
	
	public Function<ContextGraph, Boolean> getFilter() {
		return filter;
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

	// WE MUST ASSURE: for a collective node, there must be one collective edge that connects to the node
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
	
	public List<Tuple2<FieldDef<?>, Function<ContextGraph, Object>>> getAdditionalFields() {
		return additionalFields;
	}

	public TypeGraph getTypeGraph() {
		return typeGraph;
	}

	public void setTypeGraph(TypeGraph typeGraph) {
		this.typeGraph = typeGraph;
	}

	public List<Context> match(TypedGraph typedGraph, Context base) {
		GraphMatcher matcher = new GraphMatcher(this);

		List<Context> matches = matcher.match(typedGraph, base);
		
		return matches;
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
			edge.setType((TypeEdge) type);
			edge.setSource((PatternNode) getNode(source));
			edge.setTarget((PatternNode) getNode(target));
			this.addEdge(edge);
		} else if (type instanceof PropertyEdge) {
			PatternValueEdge edge = new PatternValueEdge();
			edge.setName(name);
			edge.setType((PropertyEdge) type);
			edge.setSource((PatternNode) getNode(source));
			edge.setTarget((PatternValueNode) getNode(target));
			this.addEdge(edge);
		} else if(type instanceof IPathType) {
			PatternPathEdge edge = new PatternPathEdge();
			edge.setName(name);
			edge.setType((IPathType) type);
			edge.setSource((PatternNode) getNode(source));
			edge.setTarget(getNode(target));
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
				// TODO: handle path edge
				
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
		} else if (n instanceof PatternValueEdge) {
			// TODO: First compute shortest path. 
			// TODO: If the shortest path has a length of 1, create the edge.
			// TODO: Otherwise, throw
			throw new UnsupportedOperationException();
		}
		// handle path edge
	}

	protected void createNode(int id, INode n, Object value, TypedGraphCreator creator, TypedGraph graph,
			TypedGraph referenceGraph) {
		String nodeName = id!=-1 ? ((PatternElement<?>) n).getName()+'-'+id : ((PatternElement<?>) n).getName();
		
		if (n instanceof PatternNode) {
			Index index = (Index) value;
			TypedNode node = null;
			
			try { // because there may be duplicated nodes, we must assure the idempotence 
				node = graph.getElementByIndexObject(index);
				if(((PatternNode) n).getElementType().isInstance(node)) {
					creator.registerNode(nodeName, node);
					return; // short-cut return
				} else {
					throw new NothingReturnedException();
				}
			} catch (Exception e1) {
				try {
					node = referenceGraph.getElementByIndexObject(index);
					
					if (((PatternNode) n).getElementType().isInstance(node)) {
						graph.addTypedNode(node);
						creator.registerNode(nodeName, node);
					} else {
						throw new NothingReturnedException();
					}
					
				} catch (NothingReturnedException | NullPointerException e2) {
					node = creator.createTypedNode(nodeName, ((PatternNode) n).getElementType(), index);
				}
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
				TypeNode st = (TypeNode) sourceNode.getElementType();

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
