package edu.ustb.sei.mde.query.match

import java.util.Collection
import edu.ustb.sei.mde.query.structure.TupleN

abstract class MatchSet implements Collection<Match> {
	def boolean checkRelation(Object... args) {
		checkRelation(new TupleN(args))
	}
	
	def boolean checkRelation(TupleN tuple)
	
	def int count(Object... args) {
		count(new TupleN(args))
	}
	def int count(TupleN tuple)
	def MatchSet neg()
}