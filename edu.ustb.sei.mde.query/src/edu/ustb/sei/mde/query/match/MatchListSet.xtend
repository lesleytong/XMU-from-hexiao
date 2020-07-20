package edu.ustb.sei.mde.query.match

import edu.ustb.sei.mde.query.pattern.Pattern
import java.util.List
import java.util.ArrayList
import edu.ustb.sei.mde.query.structure.TupleN
import edu.ustb.sei.mde.query.structure.MultiMap
import java.util.Collection

class MatchListSet extends MatchSet {
	static def make(Pattern p) {
		val m = new MatchListSet
		m.pattern = p;
		return m
	}
	
	Pattern pattern;
	List<Match> matches = new ArrayList
	MultiMap<TupleN, Match> supportMap = new MultiMap;
	
	override add(Match e) {
		val t = new TupleN(pattern.ports.stream.map[p|e.get(p)].toArray);
		supportMap.put(t, e);
		matches.add(e)
	}
	
	override boolean checkRelation(TupleN t) {
		return !supportMap.get(t).empty
	}
	
	override int count(TupleN t) {
		return supportMap.get(t).size
	}
	
	override addAll(Collection<? extends Match> c) {
		c.forEach[e|
			val t = new TupleN(pattern.ports.stream.map[p|e.get(p)].toArray);
			supportMap.put(t, e);
		]
		matches.addAll(c)
	}
	
	override clear() {
		matches.clear;
		supportMap.clear
	}
	
	override contains(Object o) {
		return matches.contains(o)
	}
	
	override containsAll(Collection<?> c) {
		return matches.containsAll(c)
	}
	
	override isEmpty() {
		matches.isEmpty
	}
	
	override iterator() {
		matches.iterator
	}
	
	override remove(Object o) {
		if(!(o instanceof Match)) return false;
		val e = o as Match
		val t = new TupleN(pattern.ports.stream.map[p|e.get(p)].toArray);
		supportMap.remove(t,e)
		matches.remove(o)
	}
	
	override removeAll(Collection<?> c) {
		c.forEach[o|
			if(!(o instanceof Match)) return;
			val e = o as Match
			val t = new TupleN(pattern.ports.stream.map[p|e.get(p)].toArray);
			supportMap.remove(t,e)
		]
		matches.removeAll(c)
	}
	
	override retainAll(Collection<?> c) {
		throw new UnsupportedOperationException
	}
	
	override size() {
		matches.size
	}
	
	override toArray() {
		matches.toArray
	}
	
	override <T> toArray(T[] a) {
		matches.toArray(a)
	}
	
	override neg() {
		MatchNegSet.make(this)
	}
	
	override toString() {
		val builder = new StringBuilder
		matches.forEach[m|
			builder.append(m);
			builder.append("\n")
		];
		builder.toString
	}
	
}