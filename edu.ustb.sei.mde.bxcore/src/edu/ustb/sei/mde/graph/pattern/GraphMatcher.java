package edu.ustb.sei.mde.graph.pattern;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import edu.ustb.sei.mde.bxcore.exceptions.NothingReturnedException;
import edu.ustb.sei.mde.bxcore.structures.Context;
import edu.ustb.sei.mde.bxcore.structures.Index;
import edu.ustb.sei.mde.graph.IEdge;
import edu.ustb.sei.mde.graph.INode;
import edu.ustb.sei.mde.graph.type.DataTypeNode;
import edu.ustb.sei.mde.graph.type.IStructuralFeatureEdge;
import edu.ustb.sei.mde.graph.type.ITypeNode;
import edu.ustb.sei.mde.graph.type.PropertyEdge;
import edu.ustb.sei.mde.graph.type.TypeEdge;
import edu.ustb.sei.mde.graph.type.TypeGraph;
import edu.ustb.sei.mde.graph.type.TypeNode;
import edu.ustb.sei.mde.graph.typedGraph.TypedEdge;
import edu.ustb.sei.mde.graph.typedGraph.TypedGraph;
import edu.ustb.sei.mde.graph.typedGraph.TypedNode;
import edu.ustb.sei.mde.graph.typedGraph.ValueNode;
import edu.ustb.sei.mde.structure.Tuple2;

public class GraphMatcher {
	public GraphMatcher(Pattern pattern) {
		super();
		this.pattern = pattern;
		this.type = pattern.getTypeGraph();
	}

	private Pattern pattern;
	
	@SuppressWarnings("unused")
	private TypeGraph type;
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private Object wrap(PatternElement<?> def, Object value, TypedGraph graph) throws NothingReturnedException {
		if(value==null){
			return ValueNode.createConstantNode(null, (DataTypeNode) def.getElementType());
		} else if(value instanceof Index) {
			return graph.getElementByIndexObject((Index)value);
		} else if(value instanceof List) {
			List result = new ArrayList<>();
			for(Object v : (List) value) {
				result.add(wrap(def, v, graph));
			}
			return result;
		} else if(value.getClass().isArray()) {
			IEdge[] paths = new IEdge[((Index[])value).length];
			for(int i=0;i<paths.length;i++)
				paths[i] = (IEdge) wrap(def, ((Index[])value)[i], graph);
			return paths;
		} else {
			return ValueNode.createConstantNode(value, (DataTypeNode) def.getElementType());
		}
	}

	private Map<String, Object> convertContext(Context con, TypedGraph graph) {
		// need unwrapping
		Map<String, Object> map = new HashMap<String, Object>();

		pattern.getNodes().forEach(n -> {
			try {
				String name = ((PatternElement<?>) n).getName();
				Object value = con.getValue(name);
				map.put(name, wrap(((PatternElement<?>) n), value, graph));
			} catch (Exception e) {
			}
		});

		pattern.getEdges().forEach(n -> {
			try {
				String name = ((PatternElement<?>) n).getName();
				Object value = con.getValue(name);
				map.put(name, wrap(((PatternElement<?>) n), value, graph));
			} catch (Exception e) {
			}
		});

		return map;
	}

	// here we assume that there is no isolated node 
	public List<Context> match(TypedGraph graph, Context base) {
		Map<String, Object> initPoint = convertContext(base, graph);
		Map<String, Object> startingPoint = new HashMap<String, Object>();
		
		// start searching from every pattern node
		List<PatternNode> search = pattern.getNodes().stream().filter(n->n instanceof PatternNode && ((PatternNode)n).isCollection()==false)
				.map(n->(PatternNode)n).collect(Collectors.toList());
		List<Map<String, Object>> matchResult = recursiveMatchNodes(search, startingPoint, initPoint, graph);
		
		// convert Map back to context and put missing default values
		List<Context> result = new ArrayList<>();
		matchResult.forEach(mr->{
			Context match = buildMatch(mr, base, graph);
			if(match!=null) {
				result.add(match);
			}
		});

		return null;
	}
	
	private Context buildMatch(Map<String, Object> mr, Context base, TypedGraph graph) {
		// TODO Auto-generated method stub
		return null;
	}

	protected List<Map<String, Object>> recursiveMatchNodes(List<PatternNode> search, Map<String, Object> startingPoint, Map<String, Object> initPoint, TypedGraph graph) {
		if(search.isEmpty()) return Collections.singletonList(startingPoint);
		else {
			PatternNode searchNode = search.remove(search.size()-1);
			@SuppressWarnings("rawtypes")
			List candidates = Arrays.asList(graph.getTypedNodesOf((TypeNode) searchNode.getElementType()));
			
			@SuppressWarnings("unchecked")
			List<Map<String, Object>> internalResult = matchNode(searchNode, candidates, startingPoint, initPoint, graph, null);
			if(internalResult.isEmpty()) return Collections.emptyList();
			else {
				List<Map<String, Object>> result = new ArrayList<>(internalResult.size()*2);
				for(Map<String, Object> ms : internalResult) {
					result.addAll(recursiveMatchNodes(search, ms, initPoint, graph));
				}
				return result;
			}
			
		}
	}

	static boolean checkValue(PatternElement<?> element, List<?> candidates, Object value) {
		if (element.isCollection()) {
			return candidates.contains(value);
		} else {
			return candidates.equals((List<?>) value);
		}
	}

	protected List<Map<String, Object>> matchEdge(PatternElement<?> edgeInPattern, List<IEdge> expectedValue,
			Map<String, Object> startingPoint, Map<String, Object> initPoint, TypedGraph graph, PatternElement<?> fromNode) {
		if (expectedValue.size() == 0)
			return Collections.emptyList();
		else {
			boolean checked = false;
			Object existingValue = initPoint.get(edgeInPattern.getName());
			if (existingValue == null) {
				existingValue = startingPoint.get(edgeInPattern.getName());
				checked = existingValue != null;
			} else {
				checked = startingPoint.containsKey(edgeInPattern.getName());
			}

			if (checked) { // visited! just check the value
				if (checkValue(edgeInPattern, expectedValue, existingValue)) {
					return Collections.singletonList(startingPoint);
				} else {
					return Collections.emptyList();
				}
			} else { // unchecked
				List<Map<String, Object>> result = internalMatchEdge(edgeInPattern, existingValue, expectedValue,
						startingPoint, initPoint, graph, fromNode);
				return result;
			}
		}
	}

	@SuppressWarnings("unchecked")
	protected List<Map<String, Object>> internalMatchEdge(PatternElement<?> edgeInPattern, Object existingValue,
			List<IEdge> expectedValue, Map<String, Object> startingPoint, Map<String, Object> initPoint,
			TypedGraph graph, PatternElement<?> fromNode) {
		PatternElement<?> source = (PatternElement<?>) ((IEdge) edgeInPattern).getSource();
		PatternElement<?> target = (PatternElement<?>) ((IEdge) edgeInPattern).getTarget();

		List<Map<String, Object>> result = Collections.emptyList();
		if (existingValue != null) { // has a predefined value, startingPoint does not contain existingValue
			if (checkValue(edgeInPattern, expectedValue, existingValue)) {
				// existingValue becomes an expectedValue
				startingPoint = new HashMap<>(startingPoint);
				startingPoint.put(edgeInPattern.getName(), existingValue);
				if (edgeInPattern.isCollection()) { // collective edge
					result = internalMatchEdgeSet(edgeInPattern, (List<IEdge>) existingValue, startingPoint, initPoint, graph,
							fromNode, source, target);
				} else { // simple edge
					result = internalMatchSingleEdge(edgeInPattern, (IEdge) existingValue, startingPoint, initPoint, graph,
							fromNode, source, target);
				}
			}
			// else no match found
		} else { // no predefined value
			if (edgeInPattern.isCollection()) {
				startingPoint = new HashMap<>(startingPoint);
				startingPoint.put(edgeInPattern.getName(), expectedValue);
				result = internalMatchEdgeSet(edgeInPattern, expectedValue, startingPoint, initPoint, graph,
						fromNode, source, target);
			} else {
				List<Map<String, Object>> internalResult = new ArrayList<>();
				for (IEdge candidateEdge : expectedValue) {
					Map<String, Object> newStartingPoint = new HashMap<>(startingPoint);
					newStartingPoint.put(edgeInPattern.getName(), candidateEdge);
					internalResult.addAll(internalMatchSingleEdge(edgeInPattern, candidateEdge, newStartingPoint, initPoint, graph,
							fromNode, source, target));
				}
				result = internalResult;
			}
		}
		return result;
	}

	private List<Map<String, Object>> internalMatchSingleEdge(PatternElement<?> edgeInPattern, IEdge expectedValue,
			Map<String, Object> startingPoint, Map<String, Object> initPoint, TypedGraph graph,
			PatternElement<?> fromNode, PatternElement<?> source, PatternElement<?> target) {
		List<Map<String, Object>> result;
		INode sourceNode = expectedValue.getSource();
		INode targetNode = expectedValue.getTarget();

		if(fromNode==null) {
			List<Map<String, Object>> internalResult = new ArrayList<>();
			List<Map<String, Object>> matchesAfterSource = matchNode(source,
					Collections.singletonList(sourceNode), startingPoint, initPoint, graph, edgeInPattern);
			
			matchesAfterSource.forEach(ms -> {
				List<Map<String, Object>> matchesAfterTarget = matchNode(target,
						Collections.singletonList(targetNode), ms, initPoint, graph, edgeInPattern);
				internalResult.addAll(matchesAfterTarget);
			});						
			result = internalResult;
		} else {
			if(fromNode == source) {
				result  = matchNode(target, Collections.singletonList(targetNode), startingPoint, initPoint, graph, edgeInPattern);
			} else {
				result  = matchNode(source, Collections.singletonList(sourceNode), startingPoint, initPoint, graph, edgeInPattern);
			}
		}
		return result;
	}

	private List<Map<String, Object>> internalMatchEdgeSet(PatternElement<?> edgeInPattern, List<IEdge> expectedValue,
			Map<String, Object> startingPoint, Map<String, Object> initPoint, TypedGraph graph,
			PatternElement<?> fromNode, PatternElement<?> source, PatternElement<?> target) {
		List<Map<String, Object>> result;
		Collection<INode> sourceNodes = source.isCollection() ? new ArrayList<>() : new HashSet<>();
		Collection<INode> targetNodes = target.isCollection() ? new ArrayList<>() : new HashSet<>();

		expectedValue.forEach(edge -> {
			sourceNodes.add(edge.getSource());
			targetNodes.add(edge.getTarget());
		});

		if ((source.isCollection() && targetNodes.size() != 1)
				|| (target.isCollection() && sourceNodes.size() != 1)) {
			return Collections.emptyList();
		}

		List<Map<String, Object>> matchesAfterSource = null;
		if(fromNode==null) {
			List<Map<String, Object>> internalResult = new ArrayList<>();
			if (source.isCollection()) {
				matchesAfterSource = matchNode(source, (List<INode>) sourceNodes, startingPoint, initPoint,
						graph, edgeInPattern);
			} else {
				matchesAfterSource = matchNode(source, new ArrayList<>(sourceNodes), startingPoint, initPoint,
						graph, edgeInPattern);
			}
			if (target.isCollection()) {
				matchesAfterSource.forEach(ms -> {
					List<Map<String, Object>> matchesAfterTarget = matchNode(target, (List<INode>) targetNodes,
							ms, initPoint, graph, edgeInPattern);
					internalResult.addAll(matchesAfterTarget);
				});
			} else {
				matchesAfterSource.forEach(ms -> {
					List<Map<String, Object>> matchesAfterTarget = matchNode(target,
							new ArrayList<>(targetNodes), ms, initPoint, graph, edgeInPattern);
					internalResult.addAll(matchesAfterTarget);
				});
			}
			result = internalResult;
		} else {
			if(fromNode==source) {
				result = matchNode(target, new ArrayList<>(targetNodes), startingPoint, initPoint, graph, edgeInPattern);
			} else {
				result = matchNode(source, new ArrayList<>(sourceNodes), startingPoint, initPoint, graph, edgeInPattern);
			}
		}
		return result;
	}

	protected List<Map<String, Object>> matchNode(PatternElement<?> nodeInPattern, List<INode> expectedValue,
			Map<String, Object> startingPoint, Map<String, Object> initPoint, TypedGraph graph, PatternElement<?> fromEdge) {
		// 1. list all candidates for nodeInPattern when upstreamCandidates is null
		// 2. select one candidate and go on
		// 3. foreach edge connecting to nodeInPattern
		// 4. calculate edge candidates and call matchEdge

		if (expectedValue.size() == 0)
			return Collections.emptyList();
		else {
			boolean checked = false;
			Object existingValue = initPoint.get(nodeInPattern.getName());
			if (existingValue == null) {
				existingValue = startingPoint.get(nodeInPattern.getName());
				checked = existingValue != null;
			} else {
				checked = startingPoint.containsKey(nodeInPattern.getName());
			}

			if (checked) { // visited! just check the value
				assert existingValue != null;
				if (checkValue(nodeInPattern, expectedValue, existingValue)) {
					return Collections.singletonList(startingPoint);
				} else {
					return Collections.emptyList();
				}
			} else {
				List<Map<String, Object>> result = internalMatchNode(nodeInPattern, existingValue, expectedValue,
						startingPoint, initPoint, graph, fromEdge);
				return result;
			}
		}
	}

	protected List<Map<String, Object>> internalMatchNode(PatternElement<?> nodeInPattern, Object existingValue,
			List<INode> expectedValue, Map<String, Object> startingPoint, Map<String, Object> initPoint,
			TypedGraph graph, PatternElement<?> fromEdge) {
		
		List<PatternElement<?>> relatedOutGoingPatternEdges = pattern.getEdges().stream()
				.filter(e -> e!=fromEdge && e.getSource() == nodeInPattern).map(e -> (PatternElement<?>) e)
				.collect(Collectors.toList());

		List<PatternElement<?>> relatedInComingPatternEdges = pattern.getEdges().stream()
				.filter(e -> !(e instanceof PatternValueEdge) && e!=fromEdge && e.getTarget() == nodeInPattern).map(e -> (PatternElement<?>) e)
				.collect(Collectors.toList());

		List<Map<String, Object>> result = Collections.emptyList();
		if (existingValue != null) { // has predefined value
			if (checkValue(nodeInPattern, expectedValue, existingValue)) {
				startingPoint = new HashMap<>(startingPoint);
				startingPoint.put(nodeInPattern.getName(), existingValue);

				if (nodeInPattern.isCollection()) { // matching cannot go on from a collective node
					return Collections.singletonList(startingPoint);
				} else {
					// match each pattern edge connecting to nodeInPattern
					result = recursiveMatchEdges(Tuple2.make(relatedOutGoingPatternEdges, relatedInComingPatternEdges),
							existingValue, startingPoint, initPoint, graph, nodeInPattern);
				}
			} else {
				return Collections.emptyList();
			}
		} else { // no predefined value
			result = new ArrayList<>();
			for (INode candidate : expectedValue) {
				Map<String, Object> newStartingPoint = new HashMap<>(startingPoint);
				newStartingPoint.put(nodeInPattern.getName(), candidate);
				result.addAll(recursiveMatchEdges(Tuple2.make(relatedOutGoingPatternEdges, relatedInComingPatternEdges),
						candidate, startingPoint, initPoint, graph, nodeInPattern));
			}
		}
		return result;
	}

	// startingNode must be a node
	@SuppressWarnings("unchecked")
	private List<Map<String, Object>> recursiveMatchEdges(
			Tuple2<List<PatternElement<?>>, List<PatternElement<?>>> relatedPatternEdges, Object startingNode,
			Map<String, Object> startingPoint, Map<String, Object> initPoint, TypedGraph graph, PatternElement<?> fromNode) {

		if (relatedPatternEdges.first.isEmpty() && relatedPatternEdges.second.isEmpty()) {
			return Collections.singletonList(startingPoint);
		}
		if (!relatedPatternEdges.first.isEmpty()) {
			PatternElement<?> edgeInPattern = relatedPatternEdges.first.remove(relatedPatternEdges.first.size() - 1);
			List<Map<String, Object>> result = new ArrayList<>();
			if (edgeInPattern instanceof PatternEdge) {
				@SuppressWarnings("rawtypes")
				List candidates = computeOutingEdgeCandidates(graph, (TypedNode) startingNode, 
						(TypeEdge) edgeInPattern.getElementType(), ((PatternEdge) edgeInPattern).getTarget().getElementType());
				List<Map<String, Object>> matchesAfterEdge = matchEdge(edgeInPattern, (List<IEdge>) candidates,
						startingPoint, initPoint, graph, fromNode);
				matchesAfterEdge.forEach(ms -> {
					List<Map<String, Object>> matchesRest = recursiveMatchEdges(relatedPatternEdges, startingNode, ms,
							initPoint, graph, fromNode);
					result.addAll(matchesRest);
				});
			} else if (edgeInPattern instanceof PatternValueEdge) {
				@SuppressWarnings("rawtypes")
				List candidates = computeOutingEdgeCandidates(graph, (TypedNode) startingNode, 
						(PropertyEdge) edgeInPattern.getElementType(), ((PatternEdge) edgeInPattern).getTarget().getElementType());
				List<Map<String, Object>> matchesAfterEdge = matchEdge(edgeInPattern, (List<IEdge>) candidates,
						startingPoint, initPoint, graph, fromNode);
				matchesAfterEdge.forEach(ms -> {
					List<Map<String, Object>> matchesRest = recursiveMatchEdges(relatedPatternEdges, startingNode, ms,
							initPoint, graph, fromNode);
					result.addAll(matchesRest);
				});
			} else if (edgeInPattern instanceof PatternPathEdge) {
				throw new UnsupportedOperationException();
			}
			return result;
		} else {
			PatternElement<?> edgeInPattern = relatedPatternEdges.second.remove(relatedPatternEdges.second.size() - 1);
			List<Map<String, Object>> result = new ArrayList<>();
			if (edgeInPattern instanceof PatternEdge) {
				@SuppressWarnings("rawtypes")
				List candidates = computeIncomingTypedEdgeCandidates(graph, (TypedNode) startingNode, 
						(TypeEdge) edgeInPattern.getElementType() , ((PatternEdge) edgeInPattern).getSource().getElementType());
				List<Map<String, Object>> matchesAfterEdge = matchEdge(edgeInPattern, (List<IEdge>) candidates,
						startingPoint, initPoint, graph, fromNode);
				matchesAfterEdge.forEach(ms -> {
					List<Map<String, Object>> matchesRest = recursiveMatchEdges(relatedPatternEdges, startingNode, ms,
							initPoint, graph, fromNode);
					result.addAll(matchesRest);
				});
			} else if (edgeInPattern instanceof PatternValueEdge) {
				// startingNode must be a data value node!
				throw new UnsupportedOperationException();
//				result.add(startingPoint); // we do not check incoming value edges. leave it to the other side
			} else if (edgeInPattern instanceof PatternPathEdge) {
				throw new UnsupportedOperationException();
			}
			return result;
		}
	}
	
	private List<? extends IEdge> computeOutingEdgeCandidates(TypedGraph graph, TypedNode source, IStructuralFeatureEdge edgeType, ITypeNode targetType) {
		if(edgeType instanceof TypeEdge) {
			return graph.getOutgoingEdges(source, (TypeEdge) edgeType, (TypeNode) targetType);
		} else {
			return graph.getValueEdges(source, (PropertyEdge) edgeType);
		}
	}
	
	private List<TypedEdge> computeIncomingTypedEdgeCandidates(TypedGraph graph, TypedNode target, TypeEdge edgeType, TypeNode sourceType) {
		return graph.getIncomingEdges(target, edgeType, sourceType);
	}
}
