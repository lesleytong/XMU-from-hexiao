package edu.ustb.sei.mde.query.match

import edu.ustb.sei.mde.query.match.MatchSet
import java.util.Collection
import edu.ustb.sei.mde.query.structure.TupleN

class MatchNegSet extends MatchSet {
	
	static def MatchNegSet make(MatchSet m) {
		val n = new MatchNegSet
		n.originalSet = m
		return n 
	}
	
	MatchSet originalSet;
	
	override checkRelation(TupleN t) {
		return !originalSet.checkRelation(t)
	}
	
	override count(TupleN t) {
		throw new UnsupportedOperationException("MatchNegSet does not support this operation")
	}
	
	override add(Match e) {
		throw new UnsupportedOperationException("MatchNegSet does not support this operation")
	}
	
	override addAll(Collection<? extends Match> c) {
		throw new UnsupportedOperationException("MatchNegSet does not support this operation")
	}
	
	override clear() {
		throw new UnsupportedOperationException("MatchNegSet does not support this operation")
	}
	
	override contains(Object o) {
		throw new UnsupportedOperationException("MatchNegSet does not support this operation")
	}
	
	override containsAll(Collection<?> c) {
		throw new UnsupportedOperationException("MatchNegSet does not support this operation")
	}
	
	override isEmpty() {
		throw new UnsupportedOperationException("MatchNegSet does not support this operation")
	}
	
	override iterator() {
		throw new UnsupportedOperationException("MatchNegSet does not support this operation")
	}
	
	override remove(Object o) {
		throw new UnsupportedOperationException("MatchNegSet does not support this operation")
	}
	
	override removeAll(Collection<?> c) {
		throw new UnsupportedOperationException("MatchNegSet does not support this operation")
	}
	
	override retainAll(Collection<?> c) {
		throw new UnsupportedOperationException("MatchNegSet does not support this operation")
	}
	
	override size() {
		throw new UnsupportedOperationException("MatchNegSet does not support this operation")
	}
	
	override toArray() {
		throw new UnsupportedOperationException("MatchNegSet does not support this operation")
	}
	
	override <T> toArray(T[] a) {
		throw new UnsupportedOperationException("MatchNegSet does not support this operation")
	}
	
	override neg() {
		originalSet
	}
	
	override toString() {
		val builder = new StringBuilder
		builder.append("NEG\n")
		builder.append(originalSet.toString)
		builder.toString
	}
}