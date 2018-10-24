package edu.ustb.sei.mde.graph.pattern;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.regex.Matcher;

import org.chocosolver.solver.Solver;

import edu.ustb.sei.mde.bxcore.XmuCoreUtils;
import edu.ustb.sei.mde.bxcore.exceptions.NothingReturnedException;
import edu.ustb.sei.mde.bxcore.exceptions.UninitializedException;
import edu.ustb.sei.mde.bxcore.structures.Context;
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

public class Pattern implements IGraph {
	private List<INode> nodes = new ArrayList<INode>();
	private List<IEdge> edges = new ArrayList<IEdge>();
	private TypeGraph typeGraph;
	private Function<Context, Boolean> filter;

	public void setFilter(Function<Context, Boolean> filter) {
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
		this.edges.add(edge);
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
			
			if(this.filter==null || this.filter.apply(m))
				matches.add(m);
		}
		
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

	public void appendPatternNode(String name, ITypeNode type) {
		if (type instanceof TypeNode) {
			PatternNode node = new PatternNode();
			node.setName(name);
			node.setType((TypeNode) type);
			this.addNode(node);
		} else if (type instanceof DataTypeNode) {
			PatternValueNode node = new PatternValueNode();
			node.setName(name);
			node.setType((DataTypeNode) type);
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

	public TypedGraph construct(TypedGraph referenceGraph, Context context)
			throws UninitializedException, NothingReturnedException {
		TypedGraph graph = new TypedGraph(typeGraph);
		ContextType contextType = context.getType();

		TypedGraphCreator creator = new TypedGraphCreator(graph);

		for (INode n : this.nodes) {
			if (n instanceof PatternNode) {
				Index index = context.getIndexValue(contextType.getField(((PatternNode) n).getName()));
				TypedNode node = null;

				try {
					node = referenceGraph.getElementByIndexObject(index);

					if (typeGraph.isSuperTypeOf(node.getType(), ((PatternNode) n).getType())) {
						graph.addTypedNode(node);
						creator.registerNode(((PatternNode) n).getName(), node);
					} else {
						throw new NothingReturnedException();
					}

				} catch (NothingReturnedException | NullPointerException e) {
					node = creator.createTypedNode(((PatternNode) n).getName(), ((PatternNode) n).getType(), index);
				}

			} else if (n instanceof PatternValueNode) {
				creator.createValueNode(((PatternValueNode) n).getName(),
						context.getPrimitiveValue(contextType.getField(((PatternValueNode) n).getName())),
						((PatternValueNode) n).getType());
			}
		}

		for (IEdge n : this.edges) {
			if (n instanceof PatternEdge) {
				Index index = context.getIndexValue(contextType.getField(((PatternEdge) n).getName()));
				TypedEdge edge = null;

				try {
					edge = referenceGraph.getElementByIndexObject(index);
					if (edge.getType() == ((PatternEdge) n).getType()
							&& edge.getSource() == creator.getNode(((PatternElement<?>) n.getSource()).getName())
							&& edge.getTarget() == creator.getNode(((PatternElement<?>) n.getTarget()).getName()))
						graph.addTypedEdge(edge);
					else {
						throw new NothingReturnedException();
					}
				} catch (NothingReturnedException | NullPointerException e) {
					edge = creator.createTypedEdge(((PatternElement<?>) n.getSource()).getName(),
							((PatternElement<?>) n.getTarget()).getName(), ((PatternEdge) n).getType(), index);
				}

			} else if (n instanceof PatternValueEdge) {
				Index index = context.getIndexValue(contextType.getField(((PatternValueEdge) n).getName()));
				ValueEdge edge = null;
				try {
					edge = referenceGraph.getElementByIndexObject(index);
					if (edge.getType() == ((PatternValueEdge) n).getType()
							&& edge.getSource() == creator.getNode(((PatternElement<?>) n.getSource()).getName())
							&& edge.getTarget() == creator.getNode(((PatternElement<?>) n.getTarget()).getName()))
						graph.addValueEdge(edge);
					else {
						throw new NothingReturnedException();
					}
				} catch (NothingReturnedException | NullPointerException e) {
					edge = creator.createValueEdge(((PatternElement<?>) n.getSource()).getName(),
							((PatternElement<?>) n.getTarget()).getName(), ((PatternValueEdge) n).getType(), index);
				}
			}
		}

		return graph;
	}

	public boolean isMatchOf(TypedGraph graph, Context match) {
		GraphModel model = getSolverModel(graph, match);
		if (model == null)
			return false;
		Solver solver = model.getSolver();
		boolean matched = solver.solve();
		return matched && (this.filter==null || this.filter.apply(match));
	}

	private ContextType type = null;

	public ContextType getType() {
		if (type == null) {
			type = new ContextType();
			this.getNodes().forEach(n -> {
				type.addField(((PatternElement<?>) n).getName(), ((PatternElement<?>) n).getType());
			});
			this.getEdges().forEach(e -> {
				type.addField(((PatternElement<?>) e).getName(), ((PatternElement<?>) e).getType());
			});
		}
		return type;
	}

	public void setType(ContextType t) {
		this.type = t;
	}

	public void declare(String patternShape) {
		String[] statements = patternShape.split(";");
		String nodeDecl = "\\s*(\\w+)\\s*:\\s*(\\w+)\\s*";
		String edgeDecl = "\\s*(\\w+)\\s*(!?)\\s*:\\s*(\\w+)\\s*\\-(\\w+)->\\s*(\\w+)\\s*";
		java.util.regex.Pattern nodePat = java.util.regex.Pattern.compile(nodeDecl);
		java.util.regex.Pattern edgePat = java.util.regex.Pattern.compile(edgeDecl);

		for (String stat : statements) {
			Matcher matcher = null;
			if ((matcher = nodePat.matcher(stat)).matches()) {
				String nodeName = matcher.group(1);
				String typeName = matcher.group(2);

				ITypeNode type = null;

				if ((type = this.typeGraph.getTypeNode(typeName)) == null) {
					type = this.typeGraph.getDataTypeNode(typeName);
				}

				this.appendPatternNode(nodeName, type);
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
