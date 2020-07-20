package edu.ustb.sei.mde.query.match

import edu.ustb.sei.mde.query.match.MatchSet
import edu.ustb.sei.mde.query.structure.TupleN
import java.util.Collection
import edu.ustb.sei.mde.query.pattern.Variable
import edu.ustb.sei.mde.query.structure.BiMap

class MatchProjectionSet extends MatchSet {
	
	MatchSet originalMatch
	Variable[] projVars;
	Variable[] originalVars;
	
	BiMap<Variable,Variable> varMap;
	
	static def make(MatchSet originalMatch, Variable[] projVars, Variable[] originalVars) {
		val MatchProjectionSet r = new MatchProjectionSet();
		r.originalMatch = originalMatch;
		r.projVars = projVars
		r.originalVars = originalVars
		r.buildMap
		return r;
	}
	
	private def buildMap() {
		projVars.forEach[v,i| varMap.forwardPut(v, originalVars.get(i))]
	}
	
	
	override checkRelation(TupleN tuple) {
		originalMatch.checkRelation(tuple)
	}
	
	override count(TupleN tuple) {
		if(originalMatch.checkRelation(tuple)) 1 else 0
	}
	
	override neg() {
		val neg = MatchNegSet.make(this)
		return neg
	}
	
	override add(Match e) {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}
	
	override addAll(Collection<? extends Match> c) {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}
	
	override clear() {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}
	
	override contains(Object o) {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}
	
	override containsAll(Collection<?> c) {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}
	
	override isEmpty() {
		originalMatch.isEmpty
	}
	
	override iterator() {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}
	
	override remove(Object o) {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}
	
	override removeAll(Collection<?> c) {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}
	
	override retainAll(Collection<?> c) {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}
	
	override size() {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}
	
	override toArray() {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}
	
	override <T> toArray(T[] a) {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}
	
	override toString() {
		val builder = new StringBuilder
		builder.append("PROJECT ");
		builder.append("("+projVars.map[p|p.name].reduce[p1, p2|p1+","+p2]+")")
		builder.append("->")
		builder.append("("+originalVars.map[p|p.name].reduce[p1, p2|p1+","+p2]+")")
		builder.append(originalMatch.toString)
		builder.append("\n")
		builder.toString
	}
	
}