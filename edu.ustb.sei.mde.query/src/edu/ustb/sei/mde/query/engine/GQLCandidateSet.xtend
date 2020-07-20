package edu.ustb.sei.mde.query.match

import edu.ustb.sei.mde.query.match.CandidateSet
import edu.ustb.sei.mde.query.pattern.Pattern
import java.util.Collection
import java.util.Map
import java.util.HashMap
import edu.ustb.sei.mde.query.pattern.NodePattern
import java.util.Collections

class GQLCandidateSet<CLASSIFIER> implements CandidateSet<CLASSIFIER> {
	Map<Pattern, Collection<?>> map = new HashMap;
	
	override get(NodePattern<CLASSIFIER> p) {
		map.getOrDefault(p,Collections.emptySet)
	}
	
	override init(NodePattern<CLASSIFIER> p, Collection<?> col) {
		map.put(p,col)
	}
}