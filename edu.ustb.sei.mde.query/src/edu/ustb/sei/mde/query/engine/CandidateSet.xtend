package edu.ustb.sei.mde.query.engine

import java.util.Collection
import edu.ustb.sei.mde.query.pattern.NodePattern

interface CandidateSet<CLASSIFIER> {
	 def Collection<?> get(NodePattern<CLASSIFIER> p);
	 def void init(NodePattern<CLASSIFIER> p, Collection<?> col);
}