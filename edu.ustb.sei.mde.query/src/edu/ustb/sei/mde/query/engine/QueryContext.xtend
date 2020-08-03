package edu.ustb.sei.mde.query.engine

import java.util.Map
import edu.ustb.sei.mde.query.pattern.Pattern
import edu.ustb.sei.mde.query.match.MatchSet
import edu.ustb.sei.mde.query.structure.ContainerCreator

class QueryContext {
	Map<Pattern, MatchSet> matchSetMap = ContainerCreator.autoMap
	
	
	def onNodeInsertion() {}
}