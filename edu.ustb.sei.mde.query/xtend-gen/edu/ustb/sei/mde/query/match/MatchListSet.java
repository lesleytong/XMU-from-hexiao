package edu.ustb.sei.mde.query.match;

import edu.ustb.sei.mde.query.match.Match;
import edu.ustb.sei.mde.query.match.MatchNegSet;
import edu.ustb.sei.mde.query.match.MatchSet;
import edu.ustb.sei.mde.query.pattern.Pattern;
import edu.ustb.sei.mde.query.pattern.Variable;
import edu.ustb.sei.mde.query.structure.MultiMap;
import edu.ustb.sei.mde.query.structure.TupleN;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import org.eclipse.xtext.xbase.lib.Conversions;

@SuppressWarnings("all")
public class MatchListSet extends MatchSet {
  public static MatchListSet make(final Pattern p) {
    final MatchListSet m = new MatchListSet();
    m.pattern = p;
    return m;
  }
  
  private Pattern pattern;
  
  private List<Match> matches = new ArrayList<Match>();
  
  private MultiMap<TupleN, Match> supportMap = new MultiMap<TupleN, Match>();
  
  @Override
  public boolean add(final Match e) {
    boolean _xblockexpression = false;
    {
      final Function<Variable, Object> _function = (Variable p) -> {
        return e.<Object>get(p);
      };
      Object[] _array = ((List<Variable>)Conversions.doWrapArray(this.pattern.getPorts())).stream().<Object>map(_function).toArray();
      final TupleN t = new TupleN(_array);
      this.supportMap.put(t, e);
      _xblockexpression = this.matches.add(e);
    }
    return _xblockexpression;
  }
  
  @Override
  public boolean checkRelation(final TupleN t) {
    boolean _isEmpty = this.supportMap.get(t).isEmpty();
    return (!_isEmpty);
  }
  
  @Override
  public int count(final TupleN t) {
    return this.supportMap.get(t).size();
  }
  
  @Override
  public boolean addAll(final Collection<? extends Match> c) {
    boolean _xblockexpression = false;
    {
      final Consumer<Match> _function = (Match e) -> {
        final Function<Variable, Object> _function_1 = (Variable p) -> {
          return e.<Object>get(p);
        };
        Object[] _array = ((List<Variable>)Conversions.doWrapArray(this.pattern.getPorts())).stream().<Object>map(_function_1).toArray();
        final TupleN t = new TupleN(_array);
        this.supportMap.put(t, e);
      };
      c.forEach(_function);
      _xblockexpression = this.matches.addAll(c);
    }
    return _xblockexpression;
  }
  
  @Override
  public void clear() {
    this.matches.clear();
    this.supportMap.clear();
  }
  
  @Override
  public boolean contains(final Object o) {
    return this.matches.contains(o);
  }
  
  @Override
  public boolean containsAll(final Collection<?> c) {
    return this.matches.containsAll(c);
  }
  
  @Override
  public boolean isEmpty() {
    return this.matches.isEmpty();
  }
  
  @Override
  public Iterator<Match> iterator() {
    return this.matches.iterator();
  }
  
  @Override
  public boolean remove(final Object o) {
    boolean _xblockexpression = false;
    {
      if ((!(o instanceof Match))) {
        return false;
      }
      final Match e = ((Match) o);
      final Function<Variable, Object> _function = (Variable p) -> {
        return e.<Object>get(p);
      };
      Object[] _array = ((List<Variable>)Conversions.doWrapArray(this.pattern.getPorts())).stream().<Object>map(_function).toArray();
      final TupleN t = new TupleN(_array);
      this.supportMap.remove(t, e);
      _xblockexpression = this.matches.remove(o);
    }
    return _xblockexpression;
  }
  
  @Override
  public boolean removeAll(final Collection<?> c) {
    boolean _xblockexpression = false;
    {
      final Consumer<Object> _function = (Object o) -> {
        if ((!(o instanceof Match))) {
          return;
        }
        final Match e = ((Match) o);
        final Function<Variable, Object> _function_1 = (Variable p) -> {
          return e.<Object>get(p);
        };
        Object[] _array = ((List<Variable>)Conversions.doWrapArray(this.pattern.getPorts())).stream().<Object>map(_function_1).toArray();
        final TupleN t = new TupleN(_array);
        this.supportMap.remove(t, e);
      };
      c.forEach(_function);
      _xblockexpression = this.matches.removeAll(c);
    }
    return _xblockexpression;
  }
  
  @Override
  public boolean retainAll(final Collection<?> c) {
    throw new UnsupportedOperationException();
  }
  
  @Override
  public int size() {
    return this.matches.size();
  }
  
  @Override
  public Object[] toArray() {
    return this.matches.toArray();
  }
  
  @Override
  public <T extends Object> T[] toArray(final T[] a) {
    return this.matches.<T>toArray(a);
  }
  
  @Override
  public MatchSet neg() {
    return MatchNegSet.make(this);
  }
  
  @Override
  public String toString() {
    String _xblockexpression = null;
    {
      final StringBuilder builder = new StringBuilder();
      final Consumer<Match> _function = (Match m) -> {
        builder.append(m);
        builder.append("\n");
      };
      this.matches.forEach(_function);
      _xblockexpression = builder.toString();
    }
    return _xblockexpression;
  }
}
