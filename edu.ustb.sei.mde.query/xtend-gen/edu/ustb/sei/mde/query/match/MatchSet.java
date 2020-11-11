package edu.ustb.sei.mde.query.match;

import edu.ustb.sei.mde.query.match.Match;
import edu.ustb.sei.mde.query.structure.TupleN;
import java.util.Collection;

@SuppressWarnings("all")
public abstract class MatchSet implements Collection<Match> {
  public boolean checkRelation(final Object... args) {
    TupleN _tupleN = new TupleN(args);
    return this.checkRelation(_tupleN);
  }
  
  public abstract boolean checkRelation(final TupleN tuple);
  
  public int count(final Object... args) {
    TupleN _tupleN = new TupleN(args);
    return this.count(_tupleN);
  }
  
  public abstract int count(final TupleN tuple);
  
  public abstract MatchSet neg();
}
