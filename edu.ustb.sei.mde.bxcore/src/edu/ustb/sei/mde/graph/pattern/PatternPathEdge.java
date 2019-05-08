package edu.ustb.sei.mde.graph.pattern;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;

import edu.ustb.sei.mde.bxcore.exceptions.InitializationException;
import edu.ustb.sei.mde.bxcore.exceptions.NothingReturnedException;
import edu.ustb.sei.mde.bxcore.structures.Context;
import edu.ustb.sei.mde.bxcore.structures.Index;
import edu.ustb.sei.mde.graph.IEdge;
import edu.ustb.sei.mde.graph.INode;
import edu.ustb.sei.mde.graph.type.PathType;
import edu.ustb.sei.mde.graph.typedGraph.TypedGraph;

public class PatternPathEdge extends PatternElement<PathType> implements IEdge {
	private PatternNode source;
	private PatternElement<?> target;
	
	@Override
	public INode getSource() {
		return source;
	}
	
	public void setSource(PatternNode source) {
		this.source = source;
		if(source.isCollection()) this.setCollection(true);
	}
	
	public INode getTarget() {
		return (INode) target;
	}
	public void setTarget(INode target) {
		if((target instanceof PatternNode) || (target instanceof PatternValueNode)) {
			this.target = (PatternElement<?>) target;
			if(((PatternElement<?>) target).isCollection()) 
				this.setCollection(true);			
		} else 
			throw new InitializationException("Invalid target of PatternPathEdge");
		
	}

	@Override
	public boolean isMatchOf(Context match, TypedGraph graph) {
		try {
			PatternNode sn = (PatternNode) getSource();
			PatternElement<?> tn = (PatternElement<?>) getTarget();
			Object sv = match.getValue(sn.getName());
			Object tv = match.getValue(tn.getName());
			
			if(isCollection()) {
				List<Index[]> edgeIndices = match.getValue(getName());
				BiFunction<Object,Integer,Object> sid = ((PatternElement<?>)getSource()).isCollection() ? LIST : ELEMENT;
				BiFunction<Object,Integer,Object> tid = ((PatternElement<?>)getTarget()).isCollection() ? LIST : ELEMENT;
				
				for(int i=0;i<edgeIndices.size();i++) {
					Index[] idx = edgeIndices.get(i);
					IEdge[] path = Arrays.stream(idx).map(id->{
						try {
							return (IEdge) graph.getElementByIndexObject(id);
						} catch (NothingReturnedException e) {
							return null;
						}
					}).toArray(size->new IEdge[size]);
					
					if(getElementType().isInstance(path)){
						if(!(isINodeEqual(path[0].getSource(), sid.apply(sv, i)) 
								&& isINodeEqual(path[path.length-1].getTarget(), tid.apply(tv,i)))) 
							return false;
					} else return false;
				}
				return true;
			} else {
				Index[] pathIndices = match.getValue(getName());
				IEdge[] path = new IEdge[pathIndices.length];
				for(int i=0;i<path.length;i++) {
					path[i] = graph.getElementByIndexObject(pathIndices[i]);
				}
				if(this.getType().isInstance(path)) {
					if(!(isINodeEqual(path[0].getSource(),sv) 
							&& isINodeEqual(path[path.length-1].getTarget(), tv)))
						return false;
					else 
						return true;
				} else 
					return false;
			}
			
		} catch(Exception e) {
			return false;			
		}
	}

}
