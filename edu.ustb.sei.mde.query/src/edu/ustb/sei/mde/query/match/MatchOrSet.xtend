package edu.ustb.sei.mde.query.match

import edu.ustb.sei.mde.query.match.MatchSet
import java.util.Collection
import java.util.List
import edu.ustb.sei.mde.query.structure.TupleN
import edu.ustb.sei.mde.query.structure.CompositeIterator

class MatchOrSet extends MatchSet {
	
	static def MatchOrSet make(List<MatchSet> matches) {
		val s = new MatchOrSet
		s.matches = matches;
		return s;
	}
	
	List<MatchSet> matches;
	
	def List<MatchSet> getMatches() {
		matches
	}
	
	override checkRelation(TupleN tuple) {
		matches.exists[m|m.checkRelation(tuple)]
	}
	
	override count(TupleN tuple) {
		matches.map[m|m.count(tuple)].reduce[p1, p2|p1+p2]
	}
	
	override neg() {
		MatchNegSet.make(this)
	}
	
	override add(Match e) {
		throw new UnsupportedOperationException("MatchOrSet does not support this operation")
	}
	
	override addAll(Collection<? extends Match> c) {
		throw new UnsupportedOperationException("MatchOrSet does not support this operation")
	}
	
	override clear() {
		throw new UnsupportedOperationException("MatchOrSet does not support this operation")
	}
	
	override contains(Object o) {
		matches.exists[m|m.contains(o)]
	}
	
	override containsAll(Collection<?> c) {
		throw new UnsupportedOperationException("MatchOrSet does not support this operation")
	}
	
	override isEmpty() {
		matches.forall[m|m.isEmpty]
	}
	
	override iterator() {
		new CompositeIterator(matches.map[m|m.iterator])
	}
	
	override remove(Object o) {
		throw new UnsupportedOperationException("MatchOrSet does not support this operation")
	}
	
	override removeAll(Collection<?> c) {
		throw new UnsupportedOperationException("MatchOrSet does not support this operation")
	}
	
	override retainAll(Collection<?> c) {
		throw new UnsupportedOperationException("MatchOrSet does not support this operation")
	}
	
	override size() {
		matches.stream.map[m|m.size].reduce(0)[l,r|l+r]
	}
	
	override toArray() {
		throw new UnsupportedOperationException("MatchOrSet does not support this operation")
	}
	
	override <T> toArray(T[] a) {
		throw new UnsupportedOperationException("MatchOrSet does not support this operation")
	}
	
	override toString() {
		val builder = new StringBuilder
		matches.forEach[m,i|
			if(i>0) {
				builder.append("\n");
				builder.append("OR\n")
			}
			builder.append(m.toString)
		]
		builder.toString
	}
}