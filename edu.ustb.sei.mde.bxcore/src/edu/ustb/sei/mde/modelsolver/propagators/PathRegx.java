package edu.ustb.sei.mde.modelsolver.propagators;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import edu.ustb.sei.mde.graph.type.IStructuralFeatureEdge;
import edu.ustb.sei.mde.graph.type.PropertyEdge;
import edu.ustb.sei.mde.graph.type.TypeEdge;
import edu.ustb.sei.mde.graph.typedGraph.ITypedNode;
import edu.ustb.sei.mde.graph.typedGraph.TypedGraph;
import edu.ustb.sei.mde.graph.typedGraph.TypedNode;

public interface PathRegx {
	Set<ITypedNode> collectReachableFrom(ITypedNode start, TypedGraph graph);

	static public PathRegx simple(IStructuralFeatureEdge type) {
		return new SimplePath(type);
	}
	
	default PathRegx repeat(boolean required) {
		if(this instanceof RepeatPath) {
			if(((RepeatPath) this).isRequired()==false) return this;
			else if(required) {
				return this;
			} else {
				((RepeatPath) this).setRequired(false);
				return this;
			}
		} else {
			return new RepeatPath(this, required);
		}
	}
	
	default PathRegx chain(PathRegx next) {
		if(this instanceof ChainPath) {
			((ChainPath)this).addNext(next);
			return this;
		} else {
			ChainPath r = new ChainPath();
			r.addNext(this);
			r.addNext(next);
			return r;
		}
	}
	
	default PathRegx alternative(PathRegx next) {
		if(this instanceof AlternativePath) {
			((AlternativePath)this).addAlternative(next);
			return this;
		} else {
			AlternativePath r = new AlternativePath();
			r.addAlternative(this);
			r.addAlternative(next);
			return r;
		}
	}
}


class SimplePath implements PathRegx {
	protected SimplePath(IStructuralFeatureEdge edgeType) {
		super();
		this.edgeType = edgeType;
	}

	private IStructuralFeatureEdge edgeType;

	@Override
	public Set<ITypedNode> collectReachableFrom(ITypedNode start, TypedGraph graph) {
		if(edgeType instanceof TypeEdge) {
			if(start instanceof TypedNode)
				return graph.getOutgoingEdges((TypedNode) start, (TypeEdge) edgeType).stream().map(e->e.getTarget()).collect(Collectors.toSet());
			else 
				return Collections.emptySet();
		} else if(edgeType instanceof PropertyEdge) {
			if(start instanceof TypedNode)
				return graph.getValueEdges((TypedNode) start, (PropertyEdge) edgeType).stream().map(e->e.getTarget()).collect(Collectors.toSet());
			else 
				return Collections.emptySet();
		} else
			return Collections.emptySet();
	}
}

class RepeatPath implements PathRegx {
	protected  RepeatPath(PathRegx body, boolean required) {
		super();
		this.body = body;
		this.required = required;
	}

	private PathRegx body;
	private boolean required;
	
	public boolean isRequired() {
		return required;
	}

	public void setRequired(boolean required) {
		this.required = required;
	}

	@Override
	public Set<ITypedNode> collectReachableFrom(ITypedNode start, TypedGraph graph) {
		Set<ITypedNode> result = new HashSet<>();
		Set<ITypedNode> seeds = new HashSet<>();
		seeds.add(start);
		
		Set<ITypedNode> visitedSeeds = new HashSet<>();;
		
		while(seeds.isEmpty()==false) {
			for(ITypedNode n : seeds) {
				visitedSeeds.add(n);
				Set<ITypedNode> pr = body.collectReachableFrom(n, graph);
				result.addAll(pr);
			}
			seeds.clear();
			seeds.addAll(result);
			seeds.removeAll(visitedSeeds);
		}
		
		if(this.required==false)
			result.add(start);
			
		
		return result;
	}
}

class AlternativePath implements PathRegx {
	private List<PathRegx> alternatives;
	
	protected  AlternativePath() {
		alternatives = new ArrayList<>();
	}

	@Override
	public Set<ITypedNode> collectReachableFrom(ITypedNode start, TypedGraph graph) {
		Set<ITypedNode> result = new HashSet<>();
		
		for(PathRegx p : alternatives) {
			result.addAll(p.collectReachableFrom(start, graph));
		}
		
		return result;
	}

	public void addAlternative(PathRegx next) {
		if(next instanceof AlternativePath) {
			alternatives.addAll(((AlternativePath)next).alternatives);
		} else 
			alternatives.add(next);
	}
}

class ChainPath implements PathRegx {
	private List<PathRegx> chain;
	
	protected  ChainPath() {
		chain = new ArrayList<>();
	}

	@Override
	public Set<ITypedNode> collectReachableFrom(ITypedNode start, TypedGraph graph) {
		Set<ITypedNode> result = new HashSet<>();
		Set<ITypedNode> seeds = new HashSet<>();
		seeds.add(start);
		
		for(PathRegx p : chain) {
			if(seeds.isEmpty()) break;
			result.clear();
			for(ITypedNode n : seeds) {
				result.addAll(p.collectReachableFrom(n, graph));
			}
			seeds.clear();
			seeds.addAll(result);
		}
		
		return result;
	}

	public void addNext(PathRegx next) {
		if(next instanceof ChainPath)
			chain.addAll(((ChainPath) next).chain);
		else
			chain.add(next);
	}
}