package edu.ustb.sei.mde.query.match;

import edu.ustb.sei.mde.query.match.Match;
import edu.ustb.sei.mde.query.match.MatchNegSet;
import edu.ustb.sei.mde.query.match.MatchSet;
import edu.ustb.sei.mde.query.structure.CompositeIterator;
import edu.ustb.sei.mde.query.structure.TupleN;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.Functions.Function2;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure2;

@SuppressWarnings("all")
public class MatchOrSet extends MatchSet {
  public static MatchOrSet make(final List<MatchSet> matches) {
    final MatchOrSet s = new MatchOrSet();
    s.matches = matches;
    return s;
  }
  
  private List<MatchSet> matches;
  
  public List<MatchSet> getMatches() {
    return this.matches;
  }
  
  @Override
  public boolean checkRelation(final TupleN tuple) {
    final Function1<MatchSet, Boolean> _function = (MatchSet m) -> {
      return Boolean.valueOf(m.checkRelation(tuple));
    };
    return IterableExtensions.<MatchSet>exists(this.matches, _function);
  }
  
  @Override
  public int count(final TupleN tuple) {
    final Function1<MatchSet, Integer> _function = (MatchSet m) -> {
      return Integer.valueOf(m.count(tuple));
    };
    final Function2<Integer, Integer, Integer> _function_1 = (Integer p1, Integer p2) -> {
      return Integer.valueOf(((p1).intValue() + (p2).intValue()));
    };
    return (int) IterableExtensions.<Integer>reduce(ListExtensions.<MatchSet, Integer>map(this.matches, _function), _function_1);
  }
  
  @Override
  public MatchSet neg() {
    return MatchNegSet.make(this);
  }
  
  @Override
  public boolean add(final Match e) {
    throw new UnsupportedOperationException("MatchOrSet does not support this operation");
  }
  
  @Override
  public boolean addAll(final Collection<? extends Match> c) {
    throw new UnsupportedOperationException("MatchOrSet does not support this operation");
  }
  
  @Override
  public void clear() {
    throw new UnsupportedOperationException("MatchOrSet does not support this operation");
  }
  
  @Override
  public boolean contains(final Object o) {
    final Function1<MatchSet, Boolean> _function = (MatchSet m) -> {
      return Boolean.valueOf(m.contains(o));
    };
    return IterableExtensions.<MatchSet>exists(this.matches, _function);
  }
  
  @Override
  public boolean containsAll(final Collection<?> c) {
    throw new UnsupportedOperationException("MatchOrSet does not support this operation");
  }
  
  @Override
  public boolean isEmpty() {
    final Function1<MatchSet, Boolean> _function = (MatchSet m) -> {
      return Boolean.valueOf(m.isEmpty());
    };
    return IterableExtensions.<MatchSet>forall(this.matches, _function);
  }
  
  @Override
  public Iterator<Match> iterator() {
    final Function1<MatchSet, Iterator<Match>> _function = (MatchSet m) -> {
      return m.iterator();
    };
    List<Iterator<Match>> _map = ListExtensions.<MatchSet, Iterator<Match>>map(this.matches, _function);
    return new CompositeIterator<Match>(_map);
  }
  
  @Override
  public boolean remove(final Object o) {
    throw new UnsupportedOperationException("MatchOrSet does not support this operation");
  }
  
  @Override
  public boolean removeAll(final Collection<?> c) {
    throw new UnsupportedOperationException("MatchOrSet does not support this operation");
  }
  
  @Override
  public boolean retainAll(final Collection<?> c) {
    throw new UnsupportedOperationException("MatchOrSet does not support this operation");
  }
  
  @Override
  public int size() {
    final Function<MatchSet, Integer> _function = (MatchSet m) -> {
      return Integer.valueOf(m.size());
    };
    final BinaryOperator<Integer> _function_1 = (Integer l, Integer r) -> {
      return Integer.valueOf(((l).intValue() + (r).intValue()));
    };
    return (this.matches.stream().<Integer>map(_function).reduce(Integer.valueOf(0), _function_1)).intValue();
  }
  
  @Override
  public Object[] toArray() {
    throw new UnsupportedOperationException("MatchOrSet does not support this operation");
  }
  
  @Override
  public <T extends Object> T[] toArray(final T[] a) {
    throw new UnsupportedOperationException("MatchOrSet does not support this operation");
  }
  
  @Override
  public String toString() {
    String _xblockexpression = null;
    {
      final StringBuilder builder = new StringBuilder();
      final Procedure2<MatchSet, Integer> _function = (MatchSet m, Integer i) -> {
        if (((i).intValue() > 0)) {
          builder.append("\n");
          builder.append("OR\n");
        }
        builder.append(m.toString());
      };
      IterableExtensions.<MatchSet>forEach(this.matches, _function);
      _xblockexpression = builder.toString();
    }
    return _xblockexpression;
  }
}
