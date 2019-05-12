package edu.ustb.sei.mde.bxcore.structures;

import java.util.Arrays;

import edu.ustb.sei.mde.graph.IEdge;
import edu.ustb.sei.mde.graph.type.IPathType;
import edu.ustb.sei.mde.graph.typedGraph.TypedGraph;

public class IndexPath {
	protected Index[] indices;
	protected IPathType type;
	
	public IPathType getType() {
		return type;
	}

	public IndexPath(Index[] indices, IPathType type) {
		this.indices = indices;
		this.type = type;
	}
	
	public Index[] getPathIndices() {
		return indices;
	}
	
	public GraphPath toGraphPath(TypedGraph graph) {
		try { 
			IEdge[] edges = new IEdge[indices.length];
			for(int i=0;i<indices.length;i++)
				edges[i] = (IEdge) graph.getElementByIndexObject(indices[i]);
			return new GraphPath(edges, type);
		} catch (Exception e) {
			return null;
		}
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj==null) return false;
		if(!(obj instanceof IndexPath)) return false;
		if(this.type!=((IndexPath)obj).type) return false;
		return Arrays.equals(indices, ((IndexPath)obj).indices);
	}
}
