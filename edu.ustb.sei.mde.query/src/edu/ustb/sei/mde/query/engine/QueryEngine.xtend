package edu.ustb.sei.mde.query.engine

import edu.ustb.sei.mde.query.infra.IQueryIntrastructure
import edu.ustb.sei.mde.query.infra.TypeContext
import edu.ustb.sei.mde.query.pattern.GraphPattern
import edu.ustb.sei.mde.query.pattern.Graphlet
import java.util.ArrayList
import java.util.Collection
import java.util.HashSet
import java.util.List
import java.util.stream.Collectors
import edu.ustb.sei.mde.query.pattern.ProjectionPattern
import edu.ustb.sei.mde.query.pattern.ClosurePattern
import edu.ustb.sei.mde.query.pattern.OrPattern
import edu.ustb.sei.mde.query.pattern.NegPattern
import edu.ustb.sei.mde.query.match.MatchSet
import edu.ustb.sei.mde.query.match.Match
import edu.ustb.sei.mde.query.match.MatchProjectionSet
import edu.ustb.sei.mde.query.match.MatchListSet
import edu.ustb.sei.mde.query.match.MatchOrSet
import java.util.Map
import edu.ustb.sei.mde.query.pattern.Pattern
import edu.ustb.sei.mde.query.structure.ContainerCreator
import edu.ustb.sei.mde.query.pattern.EdgePattern
import sun.reflect.generics.reflectiveObjects.NotImplementedException
import edu.ustb.sei.mde.query.structure.TupleN

class QueryEngine<METAMODEL, MODEL, CLASSIFIER, CLASS extends CLASSIFIER, OBJECT, DATATYPE extends CLASSIFIER, SLOT, FEATURE, REFERENCE extends FEATURE, LINK, ATTRIBUTE extends FEATURE, SLOTLINK> {
	IQueryIntrastructure<METAMODEL, MODEL, CLASSIFIER, CLASS, OBJECT, DATATYPE, SLOT, FEATURE, REFERENCE, LINK, ATTRIBUTE, SLOTLINK> infrastructure;
	TypeContext<METAMODEL, CLASSIFIER, CLASS, DATATYPE, FEATURE, REFERENCE, ATTRIBUTE> typeContext;
	Map<Pattern, MatchSet> matchSetMap;
	
	static def <METAMODEL, MODEL, CLASSIFIER, CLASS extends CLASSIFIER, OBJECT, DATATYPE extends CLASSIFIER, SLOT, FEATURE, REFERENCE extends FEATURE, LINK, ATTRIBUTE extends FEATURE, SLOTLINK> make(IQueryIntrastructure<METAMODEL, MODEL, CLASSIFIER, CLASS, OBJECT, DATATYPE, SLOT, FEATURE, REFERENCE, LINK, ATTRIBUTE, SLOTLINK> infrastructure, TypeContext<METAMODEL, CLASSIFIER, CLASS, DATATYPE, FEATURE, REFERENCE, ATTRIBUTE> typeContext) {
		val engine = new QueryEngine<METAMODEL, MODEL, CLASSIFIER, CLASS, OBJECT, DATATYPE, SLOT, FEATURE, REFERENCE, LINK, ATTRIBUTE, SLOTLINK>
		engine.infrastructure = infrastructure;
		engine.typeContext = typeContext
		engine.matchSetMap =  ContainerCreator.autoMap
		return engine
	}
	
	def MatchSet match(Pattern pattern) {
		val matchSet = matchSetMap.get(pattern)
		if(matchSet===null) {
			val _matchSet = 
			switch(pattern)
			{
				GraphPattern<?,?>: match(pattern, new Match)
				OrPattern :	MatchOrSet.make(pattern.subPatterns.map[s|match(s)])
				NegPattern : match(pattern.getSubPattern).neg
				ProjectionPattern : MatchProjectionSet.make(match(pattern.subPattern), pattern.ports, pattern.subPattern.ports)
				ClosurePattern : {
					throw new NotImplementedException
				}
			}
			matchSetMap.put(pattern, _matchSet)
			return _matchSet
		} else return matchSet
	}
	
	dispatch def MatchSet match(ClosurePattern pattern, Match base) {
		// match pattern.subPattern
		// do floyd to compute all transitive closure
		// build match set
	}
	
	dispatch def MatchSet match(OrPattern pattern, Match base) {
		MatchOrSet.make(pattern.subPatterns.map[s|match(s, base)])
	}
	
	dispatch def MatchSet match(NegPattern pattern, Match base) {
		val match = match(pattern.getSubPattern, base)
		match.neg
	}
	
	dispatch def MatchSet match(ProjectionPattern pattern, Match base) {
		val host = pattern.getSubPattern
		val ports = pattern.ports
		
		val newBase = new Match;
		ports.forEach[p,i|newBase.put(host.ports.get(i), base.get(p))]
		
		val original = match(host,newBase)
		
		MatchProjectionSet.make(original, ports, host.ports)
	}
	
	dispatch def MatchSet match(GraphPattern<CLASSIFIER,FEATURE> pattern, Match base) {
		val results = MatchListSet.make(pattern)
		val cs = computeCandidateSet(pattern);
		val order = planQueryOrder(pattern, cs); 
		enumerate(pattern, cs, order, base, 0, results);
		return results
	}
	
	
	def CandidateSet<CLASSIFIER> computeCandidateSet(GraphPattern<CLASSIFIER,FEATURE> pattern) {
		computeCandidateSetLDF(pattern)
	}
	
	/**
	 * A LDF+GQL-like candidate computation method.
	 * But we do not check semi-isomorphism
	 */
	protected def CandidateSet<CLASSIFIER> computeCandidateSetLDF(GraphPattern<CLASSIFIER,FEATURE> pattern) {
		val GQLCandidateSet<CLASSIFIER> set = new GQLCandidateSet;
		
		pattern.split.first.forEach[g|
			val n = g.mainNode
			if(typeContext.isClass(n.type)) {
				val col = infrastructure.getAllObjectProfilesOf(n.type as CLASS)
				val cand = col.filter[p|p.isCandidate(g.getProfile(typeContext))].map[p|p.referredObject].toSet
				set.init(g.mainNode, cand)
			}
		]
		
		return set
	}
	
	def List<Graphlet<CLASSIFIER, FEATURE>> planQueryOrder(GraphPattern<CLASSIFIER,FEATURE> pattern, CandidateSet<CLASSIFIER> candidate) {
		planOueryOrderByRI(pattern)
	}
	
	protected def ArrayList<Graphlet<CLASSIFIER, FEATURE>> planOueryOrderByRI(GraphPattern<CLASSIFIER, FEATURE> pattern) {
		val order = new ArrayList<Graphlet<CLASSIFIER, FEATURE>>
		val graphlets = pattern.split.first;
		val filter = graphlets.filter[g|typeContext.isClass(g.mainNode.type)]
		
		if(!filter.empty) {
			val first = (filter).max[g1,g2| g1.neighborEdges.size - g2.neighborEdges.size]
			
			order.add(first)
			
			while(order.size!=filter.size) {
				// TODO: add available data pattern nodes
				
				// add next node pattern
				val unselected = filter.filter[t|!order.contains(t)]
				val next = unselected.map[u| 
					val outDeg = u.outgoingNeighborEdges.map[e| if(order.exists[o|o.mainNode===e.target]) 1 else 0].reduce[p1,p2|p1+p2]
					val inDeg = u.incomingNeighborEdges.map[e| if(order.exists[o|o.mainNode===e.source]) 1 else 0].reduce[p1,p2|p1+p2]
					val deg = (outDeg.present?outDeg.get:0) + (inDeg.present?inDeg.get:0)
					return deg->u
				].max[p1,p2|p1.key-p2.key].value
				order.add(next);
			}
		}
		
		// add all data pattern nodes
		order.addAll(graphlets.filter[g|!filter.contains(g)])
		
		return order
	}
	
	def void enumerate(GraphPattern<CLASSIFIER,FEATURE> pattern, CandidateSet<CLASSIFIER> globalCandidateSet, List<Graphlet<CLASSIFIER, FEATURE>> order, Match base, int position, Collection<Match> matches) {
		if(position==order.size()) {
			if(verifyOtherConstraints(pattern, base))
				matches.add(base.clone)
		} else {
			val next = selectNext(order, base, position)
			val lc = computeLocalCandidateSet(next, globalCandidateSet, order, base, position)
			for(v : lc) {
				if(!base.contains(v)) {
					base.put(next.mainNode,v)
					enumerate(pattern, globalCandidateSet, order, base, position+1, matches)
					base.remove(next.mainNode);
				}
			}
		}
	}
	
	/**
	 * Other constraints include closure edge, or pattern, negative pattern, and projection pattern
	 */
	def boolean verifyOtherConstraints(GraphPattern<CLASSIFIER,FEATURE> pattern, Match match) {
		for(cons : pattern.relations) {
			if(!(cons instanceof EdgePattern)) {
				val matchSet = match(cons)
				val tuple = new TupleN(cons.ports.map[p|match.get(p)].toArray);
				if(!matchSet.checkRelation(tuple)) return false 
			}
		}
		return true
	}
	
	def Graphlet<CLASSIFIER, FEATURE> selectNext(List<Graphlet<CLASSIFIER, FEATURE>> order, Match base, int position) {
		return order.get(position)
	}
	
	def Collection<? extends Object> computeLocalCandidateSet(Graphlet<CLASSIFIER, FEATURE> pattern, CandidateSet<CLASSIFIER> globalCandidateSet, List<Graphlet<CLASSIFIER, FEATURE>> order, Match base, int position) {
		computeLocalCandidateSetDP(pattern, globalCandidateSet, order, base, position)
	}
	
	/**
	 * A DP-iso-like local candidate computation method.
	 * DP-iso requires an auxiliary structure to track edges among global candidates.
	 * This method uses the cache of the graph/model instead. 
	 */
	protected def Collection<?> computeLocalCandidateSetDP(Graphlet<CLASSIFIER, FEATURE> pattern, CandidateSet<CLASSIFIER> globalCandidateSet, List<Graphlet<CLASSIFIER, FEATURE>> order, Match base, int position) {
		if(typeContext.isClass(pattern.mainNode.type)) {
			val globalCandidate  = globalCandidateSet.get(pattern.mainNode);
			if(position===0) globalCandidate
			else {
				val prevNodes = order.subList(0, position).map[g|g.mainNode]
				val result = new HashSet<Object>(globalCandidate)
				
				val neighbor = new HashSet<Object>;
				
				val incomings = pattern.incomingNeighborEdges.filter[e|prevNodes.contains(e.source)].collect(Collectors.toList)
				val outgoings = pattern.outgoingNeighborEdges.filter[e|prevNodes.contains(e.target)].collect(Collectors.toList)
				
				// outgoing edges may contain references and attributes
				if(!result.isEmpty) {
					outgoings.groupBy[e|e.type].forEach[type, refsOfSameType|
						if(result.isEmpty) return;
						refsOfSameType.groupBy[r|r.target].forEach[tarNode,refsOfSameTarget|
							if(result.isEmpty) return;
							if(typeContext.isClass(tarNode.type as CLASSIFIER)) {
								neighbor.clear
								val target = base.get(tarNode) as OBJECT
								if(refsOfSameTarget.size===1) {
									neighbor.addAll(infrastructure.getSources(target, type as REFERENCE));
								} else {
									val sources = infrastructure.getSourceList(target, type as REFERENCE).groupBy[o|o].filter[o, sameO| sameO.size>=refsOfSameTarget.size].keySet;
									neighbor.addAll(sources)						
								}
								result.retainAll(neighbor)
							} else {
								val target = base.get(tarNode)
								val iter = result.iterator
								while(iter.hasNext) {
									val source = iter.next as OBJECT
									if(infrastructure.getSlots(source, type as ATTRIBUTE).contains(target)) {
										iter.remove
									}
								}
							}
						]
					]
				}
				
				// incoming edges contain references only because target is of class type
				if(!result.isEmpty) {
					incomings.groupBy[e|e.type].forEach[type, refsOfSameType|
						if(result.isEmpty) return;
						refsOfSameType.groupBy[r|r.source].forEach[srcNode, refsOfSameSource|
							if(result.isEmpty) return;
							neighbor.clear
							val source = base.get(srcNode) as OBJECT
							if(refsOfSameSource.size===1) {
								neighbor.addAll(infrastructure.getTargets(source, type as REFERENCE));
							} else {
								val targets = infrastructure.getTargets(source, type as REFERENCE).groupBy[o|o].filter[o, sameO| sameO.size>=refsOfSameSource.size].keySet;
								neighbor.addAll(targets)
							}
							result.retainAll(neighbor)
						]
					]
				}
				
				// selfEdges cannot be attribute
				pattern.selfEdges.groupBy[e|e.type].forEach[type, list| 
					val count = list.size
					val it = result.iterator
					while(it.hasNext) {
						val r = it.next
						val tars = infrastructure.getTargets(r as OBJECT, type as REFERENCE)
						val flag = if(count===1) tars.contains(r) else if(tars instanceof List) tars.stream.filter[t|t===r].limit(count).count>=count else false
						if(!flag) it.remove
					}
				]
				
				return result;
			}
		} else {
			if(position===0) {
				throw new RuntimeException("Query engine did not index value nodes")
			} else {
				val prevNodes = order.subList(0, position).map[g|g.mainNode]
				val result = new HashSet
				
				// outgoing edges must be empty
				val incomings = pattern.incomingNeighborEdges.filter[e|prevNodes.contains(e.source)].collect(Collectors.toList)
				incomings.forEach[e,i|
					val source = base.get(e.source) as OBJECT
					val values = infrastructure.getSlots(source, e.type as ATTRIBUTE)
					if(i===0) result.addAll(values)
					else result.retainAll(values)
				]
				
				return result
			}
		}
	}
}