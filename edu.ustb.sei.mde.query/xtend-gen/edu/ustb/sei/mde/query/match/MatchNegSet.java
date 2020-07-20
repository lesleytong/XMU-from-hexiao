package edu.ustb.sei.mde.query.match;

import edu.ustb.sei.mde.query.match.Match;
import edu.ustb.sei.mde.query.match.MatchSet;
import edu.ustb.sei.mde.query.structure.TupleN;
import java.util.Collection;
import java.util.Iterator;

@SuppressWarnings("all")
public class MatchNegSet extends MatchSet {
  public static MatchNegSet make(final MatchSet m) {
    final MatchNegSet n = new MatchNegSet();
    n.originalSet = m;
    return n;
  }
  
  private MatchSet originalSet;
  
  @Override
  public boolean checkRelation(final TupleN t) {
    boolean _checkRelation = this.originalSet.checkRelation(t);
    return (!_checkRelation);
  }
  
  @Override
  public int count(final TupleN t) {
    throw new UnsupportedOperationException("MatchNegSet does not support this operation");
  }
  
  @Override
  public boolean add(final Match e) {
    throw new UnsupportedOperationException("MatchNegSet does not support this operation");
  }
  
  @Override
  public boolean addAll(final Collection<? extends Match> c) {
    throw new UnsupportedOperationException("MatchNegSet does not support this operation");
  }
  
  @Override
  public void clear() {
    throw new UnsupportedOperationException("MatchNegSet does not support this operation");
  }
  
  @Override
  public boolean contains(final Object o) {
    throw new UnsupportedOperationException("MatchNegSet does not support this operation");
  }
  
  @Override
  public boolean containsAll(final Collection<?> c) {
    throw new UnsupportedOperationException("MatchNegSet does not support this operation");
  }
  
  @Override
  public boolean isEmpty() {
    throw new UnsupportedOperationException("MatchNegSet does not support this operation");
  }
  
  @Override
  public Iterator<Match> iterator() {
    throw new UnsupportedOperationException("MatchNegSet does not support this operation");
  }
  
  @Override
  public boolean remove(final Object o) {
    throw new UnsupportedOperationException("MatchNegSet does not support this operation");
  }
  
  @Override
  public boolean removeAll(final Collection<?> c) {
    throw new UnsupportedOperationException("MatchNegSet does not support this operation");
  }
  
  @Override
  public boolean retainAll(final Collection<?> c) {
    throw new UnsupportedOperationException("MatchNegSet does not support this operation");
  }
  
  @Override
  public int size() {
    throw new UnsupportedOperationException("MatchNegSet does not support this operation");
  }
  
  @Override
  public Object[] toArray() {
    throw new UnsupportedOperationException("MatchNegSet does not support this operation");
  }
  
  @Override
  public <T extends Object> T[] toArray(final T[] a) {
    throw new UnsupportedOperationException("MatchNegSet does not support this operation");
  }
  
  @Override
  public MatchSet neg() {
    return this.originalSet;
  }
  
  @Override
  public String toString() {
    String _xblockexpression = null;
    {
      final StringBuilder builder = new StringBuilder();
      builder.append("NEG\n");
      builder.append(this.originalSet.toString());
      _xblockexpression = builder.toString();
    }
    return _xblockexpression;
  }
}
