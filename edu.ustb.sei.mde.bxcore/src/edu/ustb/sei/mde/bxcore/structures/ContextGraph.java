package edu.ustb.sei.mde.bxcore.structures;

import java.util.HashMap;
import java.util.Map;

import edu.ustb.sei.mde.bxcore.SourceType;
import edu.ustb.sei.mde.bxcore.ViewType;
import edu.ustb.sei.mde.bxcore.exceptions.NothingReturnedException;
import edu.ustb.sei.mde.bxcore.exceptions.UninitializedException;
import edu.ustb.sei.mde.graph.pattern.Pattern;
import edu.ustb.sei.mde.graph.type.DataTypeNode;
import edu.ustb.sei.mde.graph.type.PropertyEdge;
import edu.ustb.sei.mde.graph.type.TypeEdge;
import edu.ustb.sei.mde.graph.type.TypeGraph;
import edu.ustb.sei.mde.graph.type.TypeNode;
import edu.ustb.sei.mde.graph.typedGraph.IndexableElement;
import edu.ustb.sei.mde.graph.typedGraph.TypedEdge;
import edu.ustb.sei.mde.graph.typedGraph.TypedGraph;
import edu.ustb.sei.mde.graph.typedGraph.TypedNode;
import edu.ustb.sei.mde.graph.typedGraph.ValueEdge;
import edu.ustb.sei.mde.graph.typedGraph.ValueNode;

public interface ContextGraph {
	default Context getContext() {
		if(this instanceof SourceType)
			return ((SourceType)this).second;
		else return 
				((ViewType)this).second;
	}
	default TypedGraph getGraph() {
		if(this instanceof SourceType)
			return ((SourceType)this).first;
		else return 
				((ViewType)this).first;
	}
	
	default GraphModification modification() {
		if(this instanceof SourceType) {
			SourceType updated = ((SourceType)this).replaceFirst(((SourceType)this).first.getCopy());
			GraphModification modify = new GraphModification(updated);
			return modify;
		} else {
			return null;
		}
	}
	
	default GraphModification enforce(Pattern pat) {
		if(this instanceof SourceType) {
			TypedGraph delta;
			try {
				delta = pat.construct(this.getGraph(), this.getContext());
				SourceType updated = ((SourceType)this).replaceFirst(((SourceType)this).first.additiveMerge(delta));
				GraphModification modify = new GraphModification(updated);
				return modify;
			} catch (UninitializedException | NothingReturnedException e) {
				return null;
			}
		} else {
			return null;
		}
	}
	
	
	@SuppressWarnings("unchecked")
	default <T extends IndexableElement> T get(String name) {
		Context con = getContext();
		TypedGraph graph = getGraph();
		try {
			Object value = con.getValue(name);
			if(value instanceof Index) {
				IndexableElement e = graph.getElementByIndexObject((Index)value);
				return (T) e;
			} else {
				return (T) value;
			}
		} catch (Exception e) {
			return null;
		}
	}
	
	default TypeNode getTypeNode(String name) {
		TypedGraph graph = this.getGraph();
		TypeGraph type = graph.getTypeGraph();
		return type.getTypeNode(name);
	}
	
	default DataTypeNode getDataTypeNode(String name) {
		TypedGraph graph = this.getGraph();
		TypeGraph type = graph.getTypeGraph();
		return type.getDataTypeNode(name);
	}

	default TypeEdge getTypeEdge(TypeNode node, String name) {
		TypedGraph graph = this.getGraph();
		TypeGraph type = graph.getTypeGraph();
		return type.getTypeEdge(node, name);
	}
	
	default PropertyEdge getPropertyEdge(TypeNode node, String name) {
		TypedGraph graph = this.getGraph();
		TypeGraph type = graph.getTypeGraph();
		return type.getPropertyEdge(node, name);
	}
	
	static public class GraphModification {
		public GraphModification(ContextGraph data) {
			super();
			this.data = data;
			this.varMap = new HashMap<String, Object>();
		}

		private ContextGraph data;
		private Map<String, Object> varMap;
		
		public GraphModification addTypedNodeAs(String id, String type) {
			TypedGraph graph = data.getGraph();
			TypeGraph typeGraph = graph.getTypeGraph();
			Context context = data.getContext();
			
			TypeNode tn = typeGraph.getTypeNode(type);
			TypedNode node = new TypedNode(tn);
			
			Index idx = null;
			
			try {
				idx = (Index) context.getValue(id);
			} catch (Exception e) {
			}
			
			if(idx!=null) node.appendIndex(idx);
			graph.addTypedNode(node);
			varMap.put(id, node);
			
			return this;
		}
		public GraphModification addTypedEdge(String sid, String tid, String edge) {
			return addTypedEdge(null, sid, tid, edge);
		}
		
		public GraphModification addTypedEdge(String eid, String sid, String tid, String edge) {
			TypedNode src = (TypedNode) varMap.get(sid);
			TypedNode tar = (TypedNode) varMap.get(tid);
			
			TypedGraph graph = data.getGraph();
			TypeGraph typeGraph = graph.getTypeGraph();
			
			TypeEdge te = typeGraph.getTypeEdge(src.getType(), edge);
			TypedEdge l = new TypedEdge(src, tar, te);

			Context context = data.getContext();
			Index ind = null;
			
			if(eid!=null) {
				try {
					ind = (Index) context.getValue(eid);
				} catch (Exception e) {
				}
			}
			
			if(ind!=null) l.appendIndex(ind);
			
			graph.addTypedEdge(l);
			
			return this;
		}
		
		public GraphModification addValueNodeAs(String id, Object value, String type) {
			TypedGraph graph = data.getGraph();
			TypeGraph typeGraph = graph.getTypeGraph();
			DataTypeNode tn = typeGraph.getDataTypeNode(type);
			ValueNode node = ValueNode.createConstantNode(value, tn);
			graph.addValueNode(node);
			varMap.put(id, node);
			return this;
		}
		
		public GraphModification addValueEdge(String sid, String tid, String edge) {
			return addValueEdge(sid, tid, edge);
		}
		
		public GraphModification addValueEdge(String eid, String sid, String tid, String edge) {
			TypedNode src = (TypedNode) varMap.get(sid);
			ValueNode tar = (ValueNode) varMap.get(tid);
			
			TypedGraph graph = data.getGraph();
			TypeGraph typeGraph = graph.getTypeGraph();
			
			PropertyEdge te = typeGraph.getPropertyEdge(src.getType(), edge);
			
			ValueEdge l = new ValueEdge(src, tar, te);
			
			Context context = data.getContext();
			Index ind = null;
			
			if(eid!=null) {
				try {
					ind = (Index) context.getValue(eid);
				} catch (Exception e) {
				}
			}
			
			if(ind!=null) l.appendIndex(ind);
			
			graph.addValueEdge(l);
			
			return this;
		}
		
		public GraphModification remove(String id) {
			TypedGraph graph = data.getGraph();
			Context context = data.getContext();
			Index ind = null;
			try {
				ind = (Index) context.getValue(id);
			} catch (Exception e) {
			}
			if (ind != null) {
				try {
					IndexableElement e = graph.getElementByIndexObject(ind);
					remove(e);
				} catch (NothingReturnedException e) {
				}
			}
			return this;
		}
		
		public GraphModification remove(IndexableElement e) {
			TypedGraph graph = data.getGraph();
			if(e instanceof TypedNode)
				graph.remove((TypedNode)e);
			else if(e instanceof TypedEdge)
				graph.remove((TypedEdge)e);
			else if(e instanceof ValueEdge)
				graph.remove((ValueEdge)e);
			
			return this;
		}
		
		@SuppressWarnings("unchecked")
		public <T extends ContextGraph> T get() {
			return (T) data;
		}
	}
}
