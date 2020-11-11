package edu.ustb.sei.mde.query.pattern;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

import edu.ustb.sei.mde.query.indexing.BitProfile;
import edu.ustb.sei.mde.query.indexing.Profile;
import edu.ustb.sei.mde.query.infra.TypeContext;

public class Graphlet<CLASSIFIER, FEATURE> {
	protected GraphPattern<CLASSIFIER, FEATURE> pattern;
	
	protected NodePattern<CLASSIFIER> mainNode;
	protected Set<NodePattern<CLASSIFIER>> neighborNodes = new HashSet<>();
	protected List<EdgePattern<FEATURE>> selfEdges = new ArrayList<>(); // between main
	protected List<EdgePattern<FEATURE>> neighborEdges = new ArrayList<>(); // between main and neighbors
	protected List<EdgePattern<FEATURE>> boundaryEdges = new ArrayList<>(); // whose ports must be included in neighbors
	protected List<Pattern> otherRelations = new ArrayList<>(); // whose ports must be included in main+neighbors
	
	public NodePattern<CLASSIFIER> getMainNode() {
		return mainNode;
	}
	public Set<NodePattern<CLASSIFIER>> getNeighborNodes() {
		return neighborNodes;
	}
	public List<EdgePattern<FEATURE>> getSelfEdges() {
		return selfEdges;
	}
	public List<EdgePattern<FEATURE>> getNeighborEdges() {
		return neighborEdges;
	}
	
	public Stream<EdgePattern<FEATURE>> getOutgoingNeighborEdges() {
		return neighborEdges.stream().filter(e->e.getSource()==this.mainNode);
	}
	
	public Stream<EdgePattern<FEATURE>> getIncomingNeighborEdges() {
		return neighborEdges.stream().filter(e->e.getTarget()==this.mainNode);
	}
	
	public List<EdgePattern<FEATURE>> getBoundaryEdges() {
		return boundaryEdges;
	}
	public List<Pattern> getOtherRelations() {
		return otherRelations;
	}
	public GraphPattern<CLASSIFIER, FEATURE> getPattern() {
		return pattern;
	}
	
	private Profile<NodePattern<CLASSIFIER>> profile = null;
	
	
	/**
	 * When creating a profile of the main node, we ignore attribute features
	 * @param <CLS>
	 * @param typeContext
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public <CLS extends CLASSIFIER> Profile<NodePattern<CLASSIFIER>> getProfile(TypeContext<?, CLASSIFIER, CLS, ?, FEATURE, ?, ?> typeContext) {
		if(!typeContext.isClass(this.mainNode.type)) return null;
		if(profile==null) {
			BitProfile<NodePattern<CLASSIFIER>> r = new BitProfile<>(); 
			profile = r;
			profile.setReferredObject(this.getMainNode());
			r.setTypeMask(typeContext.getTypeId(this.mainNode.type));
			
			typeContext.getAllSubTypes((CLS)this.mainNode.type).forEach(sc->{
				r.setTypeMask(typeContext.getTypeId(sc));
			});
			
			this.getOutgoingNeighborEdges().filter(e->typeContext.isReference(e.type)).forEach(e->{
				r.setNeighborEdgeMask(typeContext.getFeatureId(e.type));
			});
			
			this.getIncomingNeighborEdges().filter(e->typeContext.isReference(e.type)).forEach(e->{
				FEATURE inv = typeContext.getInverseFeature(e.type);
				r.setNeighborEdgeMask(typeContext.getFeatureId(inv));
			});
		}
		return profile;
	}
}
