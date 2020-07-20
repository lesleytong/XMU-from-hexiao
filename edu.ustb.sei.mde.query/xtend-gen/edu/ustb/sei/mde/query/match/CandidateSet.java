package edu.ustb.sei.mde.query.match;

import edu.ustb.sei.mde.query.pattern.NodePattern;
import java.util.Collection;

@SuppressWarnings("all")
public interface CandidateSet<CLASSIFIER extends Object> {
  public abstract Collection<?> get(final NodePattern<CLASSIFIER> p);
  
  public abstract void init(final NodePattern<CLASSIFIER> p, final Collection<?> col);
}
