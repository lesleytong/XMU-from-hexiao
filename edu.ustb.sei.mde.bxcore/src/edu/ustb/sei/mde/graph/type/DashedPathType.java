package edu.ustb.sei.mde.graph.type;

import java.util.ArrayList;

import edu.ustb.sei.mde.bxcore.structures.GraphPath;
import edu.ustb.sei.mde.graph.IEdge;

/**
 * A dashed path type has a shape of (A|B|C)[min,max].(D|E)[min,max]...
 * It is a simplified version of the regular path type. 
 * @author hexiao
 *
 */
public class DashedPathType implements IPathType {
	public DashedPathType(DashedPathTypeSegment... segments) {
		super();
		this.segments = segments;
	}
	public DashedPathTypeSegment[] getSegments() {
		return segments;
	}
	private DashedPathTypeSegment[] segments;
	
	
	@Override
	public Class<?> getJavaType() {
		return GraphPath.class;
	}
	@Override
	public boolean isInstance(Object value) {
		if(!(value instanceof GraphPath)) return false;
		GraphPath path = (GraphPath) value;
		return checkSegmentFrom(path, 0, 0, new PathCheckCache());
	}
	
	private boolean checkSegmentFrom(GraphPath path, int segIndex, int edgeIndex, PathCheckCache cache) {
		/*
		 * 1. Check min
		 * 2. Check max. If max<0, then max = path.lengh - edgeIndex.
		 * 3. Shortcut by checking cache.check(seg, edgeIndex).
		 * 4. For each possibility between min and max, check next seg 
		 */
		IEdge[] pathEdges = path.getPathEdges();
		
		if(segIndex==segments.length) {
			return edgeIndex==pathEdges.length;
		}
		if(edgeIndex==pathEdges.length) {
			return getMinLengthFrom(segIndex)==0;
		}

		DashedPathTypeSegment curSegment = segments[segIndex];
		
		Boolean cachedResult = cache.check(curSegment, edgeIndex);
		if(cachedResult!=null) return cachedResult;
		
		int min = curSegment.getMin();
		int max = curSegment.getMax();
		if(max<0 || max>pathEdges.length-edgeIndex) max = pathEdges.length-edgeIndex;
		
		if(max<min) {
			cache.setCache(curSegment, edgeIndex, false);
			return false;
		}
		
		for(int cur = 0; cur < min; cur++) {
			if(!curSegment.isInstance(pathEdges[edgeIndex + cur])) {
				cache.setCache(curSegment, edgeIndex, false);
				return false;
			}
		}
		
		ArrayList<Integer> posArr = new ArrayList<>();
		posArr.add(min);
		for(int cur = min; cur < max; cur++) {
			int actualPos = edgeIndex + cur;
			posArr.add(actualPos + 1);
			if(curSegment.isInstance(pathEdges[actualPos])) continue;
			else break; // break the loop
		}
		
		for(Integer pos : posArr) {
			if(checkSegmentFrom(path, segIndex + 1, pos, cache)) {
				return true;
			}
		}
		
		cache.setCache(curSegment, edgeIndex, false);
		return false;
	}
	
	protected int getMinLengthFrom(int segIndex) {
		int min = 0;
		for(DashedPathTypeSegment s : segments) {
			min += s.getMin();
		}
		return min;
	}
	protected int getMaxLengthFrom(int segIndex) {
		int max = 0;
		for(DashedPathTypeSegment s : segments) {
			int sMax = s.getMax();
			if(sMax<0) return -1;
			max += sMax;
		}
		return max;
	}
	
	
	
	@Override
	public String getName() {
		return toString();
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		boolean first = true;
		for(DashedPathTypeSegment seg : segments) {
			if(!first) builder.append(".");
			first = false;
			builder.append(seg.toString());
		}
		return builder.toString();
	}
	
	
}

class DashedPathTypeSegment {
	public DashedPathTypeSegment(IStructuralFeatureEdge[] edgeTypes, int min, int max) {
		super();
		this.edgeTypes = edgeTypes;
		this.min = min;
		this.max = max;
	}
	
	private IStructuralFeatureEdge[] edgeTypes;
	private int min;
	private int max;
	
	public IStructuralFeatureEdge[] getEdgeTypes() {
		return edgeTypes;
	}
	public int getMin() {
		return min;
	}
	public int getMax() {
		return max;
	}
	
	public boolean isInstance(IEdge edge) {
		for(IStructuralFeatureEdge type : edgeTypes) {
			if(type.isInstance(edge)) return true;
		}
		return false;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("(");
		boolean flag = true;
		for(IStructuralFeatureEdge et : edgeTypes) {
			if(!flag) builder.append("|");
			flag = false;
			builder.append(et.getName());
		}
		builder.append(")[");
		builder.append(min);
		builder.append(",");
		builder.append(max);
		builder.append("]");
		return super.toString();
	}
}