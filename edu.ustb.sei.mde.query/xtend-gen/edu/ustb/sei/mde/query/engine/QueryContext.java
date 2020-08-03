package edu.ustb.sei.mde.query.engine;

import edu.ustb.sei.mde.query.match.MatchSet;
import edu.ustb.sei.mde.query.pattern.Pattern;
import edu.ustb.sei.mde.query.structure.ContainerCreator;
import java.util.Map;

@SuppressWarnings("all")
public class QueryContext {
  private Map<Pattern, MatchSet> matchSetMap = ContainerCreator.<Pattern, MatchSet>autoMap();
  
  public Object onNodeInsertion() {
    return null;
  }
}
