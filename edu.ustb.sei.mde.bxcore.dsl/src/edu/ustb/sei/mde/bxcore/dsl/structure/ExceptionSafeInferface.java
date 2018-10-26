package edu.ustb.sei.mde.bxcore.dsl.structure;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import edu.ustb.sei.mde.bxcore.structures.Context;
import edu.ustb.sei.mde.bxcore.structures.ContextGraph;
import edu.ustb.sei.mde.bxcore.structures.Index;
import edu.ustb.sei.mde.graph.type.IStructuralFeatureEdge;
import edu.ustb.sei.mde.graph.type.PropertyEdge;
import edu.ustb.sei.mde.graph.type.TypeEdge;
import edu.ustb.sei.mde.graph.type.TypeNode;
import edu.ustb.sei.mde.graph.typedGraph.TypedEdge;
import edu.ustb.sei.mde.graph.typedGraph.TypedGraph;
import edu.ustb.sei.mde.graph.typedGraph.TypedNode;
import edu.ustb.sei.mde.graph.typedGraph.ValueEdge;

public class ExceptionSafeInferface {
	public static <T> T getValue(Context context, String name) {
		try {
			return context.getValue(name);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public static <T> void setValue(Context context, String name, T value) {
		try {
			context.setValue(name, value);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	@SuppressWarnings("unchecked")
	public static <T> T getValue(ContextGraph context, String name) {
		try {
			Object value = context.getContext().getValue(name);
			if(value instanceof Index) {
				return context.getGraph().getElementByIndexObject((Index)value);
			} else 
				return (T) value;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public static <T> void setValue(ContextGraph context, String name, T value) {
		try {
			context.getContext().setValue(name, value);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public static <T> T navigate(ContextGraph context, Index start, String featureName, boolean reference, boolean many) {
		try {
			TypedGraph graph = context.getGraph();
			Object startNode = graph.getElementByIndexObject(start);
			if(startNode instanceof TypedNode) {
				return internalNavigate(context, (TypedNode)startNode, featureName, reference, many);
			} else {
				return defaultValue(many);
			}
		} catch (Exception e) {
			return defaultValue(many);
		}
	}
	
	public static <T> T navigate(ContextGraph context, TypedNode start, String featureName, boolean reference, boolean many) {
		try {
			return internalNavigate(context, start, featureName, reference, many);
		} catch (Exception e) {
			return defaultValue(many);
		}
	}

	protected static <T> T internalNavigate(ContextGraph context, TypedNode start, String featureName, boolean reference,
			boolean many) {
		TypeNode classNode = ((TypedNode) start).getType();
		IStructuralFeatureEdge edge = null;
		if(reference) {
			edge = context.getTypeEdge(classNode, featureName);
		} else 
			edge = context.getPropertyEdge(classNode, featureName);
		
		return internalNavigate(context, start, edge, reference, many);
	}

	@SuppressWarnings("unchecked")
	protected static <T> T internalNavigate(ContextGraph context, TypedNode start, IStructuralFeatureEdge edge, boolean reference, boolean many) {
		TypedGraph graph = context.getGraph();
		if(reference) {
			List<TypedEdge> results = graph.getOutgoingEdges(start, (TypeEdge)edge);
			if(many) return (T) results.stream().map(e->e.getTarget()).collect(Collectors.toList());
			else {
				if(results.isEmpty()) return null;
				else return (T) results.get(0).getTarget();
			}
		} else {
			List<ValueEdge> results = graph.getValueEdges(start, (PropertyEdge)edge);
			if(many) return (T) results.stream().map(e->e.getTarget().getValue()).collect(Collectors.toList());
			else {
				if(results.isEmpty()) return null;
				else return (T) results.get(0).getTarget().getValue();
			}
		}
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	protected static <T> T internalNavigate(ContextGraph context, List<TypedNode> starts, IStructuralFeatureEdge edge, boolean reference, boolean many) {
		List results = new ArrayList<>();
		TypedGraph graph = context.getGraph();
		for(TypedNode start : starts) {
			if(reference) {
				graph.getOutgoingEdges(start, (TypeEdge) edge).forEach(l->results.add(l.getTarget()));				
			} else {
				graph.getValueEdges(start, (PropertyEdge) edge).forEach(l->results.add(l.getTarget().getValue()));
			}
		}
		if(many) return (T) results;
		else if(results.isEmpty()) return null;
		else return (T) results.get(0);
	}
	
	public static <T> T navigate(ContextGraph context, List<TypedNode> starts, String featureName, boolean reference, boolean many) {
		if(starts.isEmpty()) return defaultValue(many);
		try {
			TypedNode first = starts.get(0);
			TypeNode classNode = ((TypedNode) first).getType();
			IStructuralFeatureEdge edge = null;
			if(reference) {
				edge = context.getTypeEdge(classNode, featureName);
			} else 
				edge = context.getPropertyEdge(classNode, featureName);
			return internalNavigate(context, starts, edge, reference, many);
		} catch (Exception e) {
			return defaultValue(many);
		}
	}

	@SuppressWarnings("unchecked")
	protected static <T> T defaultValue(boolean many) {
		if(many) return (T) Collections.emptyList();
		else return null;
	}

}
