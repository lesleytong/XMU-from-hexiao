package edu.ustb.sei.mde.query.engine;

import edu.ustb.sei.mde.query.engine.CandidateSet;
import edu.ustb.sei.mde.query.pattern.NodePattern;
import edu.ustb.sei.mde.query.pattern.Pattern;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("all")
public class GQLCandidateSet<CLASSIFIER extends Object> implements CandidateSet<CLASSIFIER> {
  private Map<Pattern, Collection<?>> map = new HashMap<Pattern, Collection<?>>();
  
  @Override
  public Collection<?> get(final NodePattern<CLASSIFIER> p) {
    return this.map.getOrDefault(p, Collections.<Object>emptySet());
  }
  
  @Override
  public void init(final NodePattern<CLASSIFIER> p, final Collection<?> col) {
    this.map.put(p, col);
  }
}
