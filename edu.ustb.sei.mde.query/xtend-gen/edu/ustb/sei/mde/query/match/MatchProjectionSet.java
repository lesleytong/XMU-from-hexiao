package edu.ustb.sei.mde.query.match;

import edu.ustb.sei.mde.query.match.Match;
import edu.ustb.sei.mde.query.match.MatchNegSet;
import edu.ustb.sei.mde.query.match.MatchSet;
import edu.ustb.sei.mde.query.pattern.Variable;
import edu.ustb.sei.mde.query.structure.BiMap;
import edu.ustb.sei.mde.query.structure.TupleN;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.Functions.Function2;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure2;

@SuppressWarnings("all")
public class MatchProjectionSet extends MatchSet {
  private MatchSet originalMatch;
  
  private Variable[] projVars;
  
  private Variable[] originalVars;
  
  private BiMap<Variable, Variable> varMap;
  
  public static MatchProjectionSet make(final MatchSet originalMatch, final Variable[] projVars, final Variable[] originalVars) {
    final MatchProjectionSet r = new MatchProjectionSet();
    r.originalMatch = originalMatch;
    r.projVars = projVars;
    r.originalVars = originalVars;
    r.buildMap();
    return r;
  }
  
  private void buildMap() {
    final Procedure2<Variable, Integer> _function = (Variable v, Integer i) -> {
      this.varMap.forwardPut(v, this.originalVars[(i).intValue()]);
    };
    IterableExtensions.<Variable>forEach(((Iterable<Variable>)Conversions.doWrapArray(this.projVars)), _function);
  }
  
  @Override
  public boolean checkRelation(final TupleN tuple) {
    return this.originalMatch.checkRelation(tuple);
  }
  
  @Override
  public int count(final TupleN tuple) {
    int _xifexpression = (int) 0;
    boolean _checkRelation = this.originalMatch.checkRelation(tuple);
    if (_checkRelation) {
      _xifexpression = 1;
    } else {
      _xifexpression = 0;
    }
    return _xifexpression;
  }
  
  @Override
  public MatchSet neg() {
    final MatchNegSet neg = MatchNegSet.make(this);
    return neg;
  }
  
  @Override
  public boolean add(final Match e) {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
  
  @Override
  public boolean addAll(final Collection<? extends Match> c) {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
  
  @Override
  public void clear() {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
  
  @Override
  public boolean contains(final Object o) {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
  
  @Override
  public boolean containsAll(final Collection<?> c) {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
  
  @Override
  public boolean isEmpty() {
    return this.originalMatch.isEmpty();
  }
  
  @Override
  public Iterator<Match> iterator() {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
  
  @Override
  public boolean remove(final Object o) {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
  
  @Override
  public boolean removeAll(final Collection<?> c) {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
  
  @Override
  public boolean retainAll(final Collection<?> c) {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
  
  @Override
  public int size() {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
  
  @Override
  public Object[] toArray() {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
  
  @Override
  public <T extends Object> T[] toArray(final T[] a) {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
  
  @Override
  public String toString() {
    String _xblockexpression = null;
    {
      final StringBuilder builder = new StringBuilder();
      builder.append("PROJECT ");
      final Function1<Variable, String> _function = (Variable p) -> {
        return p.getName();
      };
      final Function2<String, String, String> _function_1 = (String p1, String p2) -> {
        return ((p1 + ",") + p2);
      };
      String _reduce = IterableExtensions.<String>reduce(ListExtensions.<Variable, String>map(((List<Variable>)Conversions.doWrapArray(this.projVars)), _function), _function_1);
      String _plus = ("(" + _reduce);
      String _plus_1 = (_plus + ")");
      builder.append(_plus_1);
      builder.append("->");
      final Function1<Variable, String> _function_2 = (Variable p) -> {
        return p.getName();
      };
      final Function2<String, String, String> _function_3 = (String p1, String p2) -> {
        return ((p1 + ",") + p2);
      };
      String _reduce_1 = IterableExtensions.<String>reduce(ListExtensions.<Variable, String>map(((List<Variable>)Conversions.doWrapArray(this.originalVars)), _function_2), _function_3);
      String _plus_2 = ("(" + _reduce_1);
      String _plus_3 = (_plus_2 + ")");
      builder.append(_plus_3);
      builder.append(this.originalMatch.toString());
      builder.append("\n");
      _xblockexpression = builder.toString();
    }
    return _xblockexpression;
  }
}
