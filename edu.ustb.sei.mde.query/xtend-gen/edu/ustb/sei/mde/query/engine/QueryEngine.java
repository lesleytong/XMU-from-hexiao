package edu.ustb.sei.mde.query.engine;

import com.google.common.collect.Iterables;
import edu.ustb.sei.mde.query.engine.CandidateSet;
import edu.ustb.sei.mde.query.engine.GQLCandidateSet;
import edu.ustb.sei.mde.query.indexing.Profile;
import edu.ustb.sei.mde.query.infra.IQueryIntrastructure;
import edu.ustb.sei.mde.query.infra.TypeContext;
import edu.ustb.sei.mde.query.match.Match;
import edu.ustb.sei.mde.query.match.MatchListSet;
import edu.ustb.sei.mde.query.match.MatchOrSet;
import edu.ustb.sei.mde.query.match.MatchProjectionSet;
import edu.ustb.sei.mde.query.match.MatchSet;
import edu.ustb.sei.mde.query.pattern.ClosurePattern;
import edu.ustb.sei.mde.query.pattern.EdgePattern;
import edu.ustb.sei.mde.query.pattern.GraphPattern;
import edu.ustb.sei.mde.query.pattern.Graphlet;
import edu.ustb.sei.mde.query.pattern.NegPattern;
import edu.ustb.sei.mde.query.pattern.NodePattern;
import edu.ustb.sei.mde.query.pattern.OrPattern;
import edu.ustb.sei.mde.query.pattern.Pattern;
import edu.ustb.sei.mde.query.pattern.ProjectionPattern;
import edu.ustb.sei.mde.query.pattern.Variable;
import edu.ustb.sei.mde.query.structure.ContainerCreator;
import edu.ustb.sei.mde.query.structure.TupleN;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.Functions.Function2;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.MapExtensions;
import org.eclipse.xtext.xbase.lib.Pair;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure2;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

@SuppressWarnings("all")
public class QueryEngine<METAMODEL extends Object, MODEL extends Object, CLASSIFIER extends Object, CLASS extends CLASSIFIER, OBJECT extends Object, DATATYPE extends CLASSIFIER, SLOT extends Object, FEATURE extends Object, REFERENCE extends FEATURE, LINK extends Object, ATTRIBUTE extends FEATURE, SLOTLINK extends Object> {
  private IQueryIntrastructure<METAMODEL, MODEL, CLASSIFIER, CLASS, OBJECT, DATATYPE, SLOT, FEATURE, REFERENCE, LINK, ATTRIBUTE, SLOTLINK> infrastructure;
  
  private TypeContext<METAMODEL, CLASSIFIER, CLASS, DATATYPE, FEATURE, REFERENCE, ATTRIBUTE> typeContext;
  
  private Map<Pattern, MatchSet> matchSetMap;
  
  public static <METAMODEL extends Object, MODEL extends Object, CLASSIFIER extends Object, CLASS extends CLASSIFIER, OBJECT extends Object, DATATYPE extends CLASSIFIER, SLOT extends Object, FEATURE extends Object, REFERENCE extends FEATURE, LINK extends Object, ATTRIBUTE extends FEATURE, SLOTLINK extends Object> QueryEngine<METAMODEL, MODEL, CLASSIFIER, CLASS, OBJECT, DATATYPE, SLOT, FEATURE, REFERENCE, LINK, ATTRIBUTE, SLOTLINK> make(final IQueryIntrastructure<METAMODEL, MODEL, CLASSIFIER, CLASS, OBJECT, DATATYPE, SLOT, FEATURE, REFERENCE, LINK, ATTRIBUTE, SLOTLINK> infrastructure, final TypeContext<METAMODEL, CLASSIFIER, CLASS, DATATYPE, FEATURE, REFERENCE, ATTRIBUTE> typeContext) {
    final QueryEngine<METAMODEL, MODEL, CLASSIFIER, CLASS, OBJECT, DATATYPE, SLOT, FEATURE, REFERENCE, LINK, ATTRIBUTE, SLOTLINK> engine = new QueryEngine<METAMODEL, MODEL, CLASSIFIER, CLASS, OBJECT, DATATYPE, SLOT, FEATURE, REFERENCE, LINK, ATTRIBUTE, SLOTLINK>();
    engine.infrastructure = infrastructure;
    engine.typeContext = typeContext;
    engine.matchSetMap = ContainerCreator.<Pattern, MatchSet>autoMap();
    return engine;
  }
  
  public MatchSet match(final Pattern pattern) {
    final MatchSet matchSet = this.matchSetMap.get(pattern);
    if ((matchSet == null)) {
      MatchSet _switchResult = null;
      boolean _matched = false;
      if (pattern instanceof GraphPattern) {
        _matched=true;
        Match _match = new Match();
        _switchResult = this.match(pattern, _match);
      }
      if (!_matched) {
        if (pattern instanceof OrPattern) {
          _matched=true;
          final Function1<Pattern, MatchSet> _function = (Pattern s) -> {
            return this.match(s);
          };
          _switchResult = MatchOrSet.make(ListExtensions.<Pattern, MatchSet>map(((List<Pattern>)Conversions.doWrapArray(((OrPattern)pattern).getSubPatterns())), _function));
        }
      }
      if (!_matched) {
        if (pattern instanceof NegPattern) {
          _matched=true;
          _switchResult = this.match(((NegPattern)pattern).getSubPattern()).neg();
        }
      }
      if (!_matched) {
        if (pattern instanceof ProjectionPattern) {
          _matched=true;
          _switchResult = MatchProjectionSet.make(this.match(((ProjectionPattern)pattern).getSubPattern()), ((ProjectionPattern)pattern).getPorts(), ((ProjectionPattern)pattern).getSubPattern().getPorts());
        }
      }
      if (!_matched) {
        if (pattern instanceof ClosurePattern) {
          _matched=true;
          throw new NotImplementedException();
        }
      }
      final MatchSet _matchSet = _switchResult;
      this.matchSetMap.put(pattern, _matchSet);
      return _matchSet;
    } else {
      return matchSet;
    }
  }
  
  protected MatchSet _match(final ClosurePattern pattern, final Match base) {
    return null;
  }
  
  protected MatchSet _match(final OrPattern pattern, final Match base) {
    final Function1<Pattern, MatchSet> _function = (Pattern s) -> {
      return this.match(s, base);
    };
    return MatchOrSet.make(ListExtensions.<Pattern, MatchSet>map(((List<Pattern>)Conversions.doWrapArray(pattern.getSubPatterns())), _function));
  }
  
  protected MatchSet _match(final NegPattern pattern, final Match base) {
    MatchSet _xblockexpression = null;
    {
      final MatchSet match = this.match(pattern.getSubPattern(), base);
      _xblockexpression = match.neg();
    }
    return _xblockexpression;
  }
  
  protected MatchSet _match(final ProjectionPattern pattern, final Match base) {
    MatchProjectionSet _xblockexpression = null;
    {
      final Pattern host = pattern.getSubPattern();
      final Variable[] ports = pattern.getPorts();
      final Match newBase = new Match();
      final Procedure2<Variable, Integer> _function = (Variable p, Integer i) -> {
        newBase.put(host.getPorts()[(i).intValue()], base.<Object>get(p));
      };
      IterableExtensions.<Variable>forEach(((Iterable<Variable>)Conversions.doWrapArray(ports)), _function);
      final MatchSet original = this.match(host, newBase);
      _xblockexpression = MatchProjectionSet.make(original, ports, host.getPorts());
    }
    return _xblockexpression;
  }
  
  protected MatchSet _match(final GraphPattern<CLASSIFIER, FEATURE> pattern, final Match base) {
    final MatchListSet results = MatchListSet.make(pattern);
    final CandidateSet<CLASSIFIER> cs = this.computeCandidateSet(pattern);
    final List<Graphlet<CLASSIFIER, FEATURE>> order = this.planQueryOrder(pattern, cs);
    this.enumerate(pattern, cs, order, base, 0, results);
    return results;
  }
  
  public CandidateSet<CLASSIFIER> computeCandidateSet(final GraphPattern<CLASSIFIER, FEATURE> pattern) {
    return this.computeCandidateSetLDF(pattern);
  }
  
  /**
   * A LDF+GQL-like candidate computation method.
   * But we do not check semi-isomorphism
   */
  protected CandidateSet<CLASSIFIER> computeCandidateSetLDF(final GraphPattern<CLASSIFIER, FEATURE> pattern) {
    final GQLCandidateSet<CLASSIFIER> set = new GQLCandidateSet<CLASSIFIER>();
    final Consumer<Graphlet<CLASSIFIER, FEATURE>> _function = (Graphlet<CLASSIFIER, FEATURE> g) -> {
      final NodePattern<CLASSIFIER> n = g.getMainNode();
      boolean _isClass = this.typeContext.isClass(n.getType());
      if (_isClass) {
        CLASSIFIER _type = n.getType();
        final Collection<Profile<OBJECT>> col = this.infrastructure.getAllObjectProfilesOf(((CLASS) _type));
        final Function1<Profile<OBJECT>, Boolean> _function_1 = (Profile<OBJECT> p) -> {
          return Boolean.valueOf(p.isCandidate(g.<CLASS>getProfile(this.typeContext)));
        };
        final Function1<Profile<OBJECT>, OBJECT> _function_2 = (Profile<OBJECT> p) -> {
          return p.getReferredObject();
        };
        final Set<OBJECT> cand = IterableExtensions.<OBJECT>toSet(IterableExtensions.<Profile<OBJECT>, OBJECT>map(IterableExtensions.<Profile<OBJECT>>filter(col, _function_1), _function_2));
        set.init(g.getMainNode(), cand);
      }
    };
    pattern.split().first.forEach(_function);
    return set;
  }
  
  public List<Graphlet<CLASSIFIER, FEATURE>> planQueryOrder(final GraphPattern<CLASSIFIER, FEATURE> pattern, final CandidateSet<CLASSIFIER> candidate) {
    return this.planOueryOrderByRI(pattern);
  }
  
  protected ArrayList<Graphlet<CLASSIFIER, FEATURE>> planOueryOrderByRI(final GraphPattern<CLASSIFIER, FEATURE> pattern) {
    final ArrayList<Graphlet<CLASSIFIER, FEATURE>> order = new ArrayList<Graphlet<CLASSIFIER, FEATURE>>();
    final List<Graphlet<CLASSIFIER, FEATURE>> graphlets = pattern.split().first;
    final Function1<Graphlet<CLASSIFIER, FEATURE>, Boolean> _function = (Graphlet<CLASSIFIER, FEATURE> g) -> {
      return Boolean.valueOf(this.typeContext.isClass(g.getMainNode().getType()));
    };
    final Iterable<Graphlet<CLASSIFIER, FEATURE>> filter = IterableExtensions.<Graphlet<CLASSIFIER, FEATURE>>filter(graphlets, _function);
    boolean _isEmpty = IterableExtensions.isEmpty(filter);
    boolean _not = (!_isEmpty);
    if (_not) {
      final Comparator<Graphlet<CLASSIFIER, FEATURE>> _function_1 = (Graphlet<CLASSIFIER, FEATURE> g1, Graphlet<CLASSIFIER, FEATURE> g2) -> {
        int _size = g1.getNeighborEdges().size();
        int _size_1 = g2.getNeighborEdges().size();
        return (_size - _size_1);
      };
      final Graphlet<CLASSIFIER, FEATURE> first = IterableExtensions.<Graphlet<CLASSIFIER, FEATURE>>max(filter, _function_1);
      order.add(first);
      while ((order.size() != IterableExtensions.size(filter))) {
        {
          final Function1<Graphlet<CLASSIFIER, FEATURE>, Boolean> _function_2 = (Graphlet<CLASSIFIER, FEATURE> t) -> {
            boolean _contains = order.contains(t);
            return Boolean.valueOf((!_contains));
          };
          final Iterable<Graphlet<CLASSIFIER, FEATURE>> unselected = IterableExtensions.<Graphlet<CLASSIFIER, FEATURE>>filter(filter, _function_2);
          final Function1<Graphlet<CLASSIFIER, FEATURE>, Pair<Integer, Graphlet<CLASSIFIER, FEATURE>>> _function_3 = (Graphlet<CLASSIFIER, FEATURE> u) -> {
            final Function<EdgePattern<FEATURE>, Integer> _function_4 = (EdgePattern<FEATURE> e) -> {
              int _xifexpression = (int) 0;
              final Function1<Graphlet<CLASSIFIER, FEATURE>, Boolean> _function_5 = (Graphlet<CLASSIFIER, FEATURE> o) -> {
                NodePattern<CLASSIFIER> _mainNode = o.getMainNode();
                NodePattern<?> _target = e.getTarget();
                return Boolean.valueOf((_mainNode == _target));
              };
              boolean _exists = IterableExtensions.<Graphlet<CLASSIFIER, FEATURE>>exists(order, _function_5);
              if (_exists) {
                _xifexpression = 1;
              } else {
                _xifexpression = 0;
              }
              return Integer.valueOf(_xifexpression);
            };
            final BinaryOperator<Integer> _function_5 = (Integer p1, Integer p2) -> {
              return Integer.valueOf(((p1).intValue() + (p2).intValue()));
            };
            final Optional<Integer> outDeg = u.getOutgoingNeighborEdges().<Integer>map(_function_4).reduce(_function_5);
            final Function<EdgePattern<FEATURE>, Integer> _function_6 = (EdgePattern<FEATURE> e) -> {
              int _xifexpression = (int) 0;
              final Function1<Graphlet<CLASSIFIER, FEATURE>, Boolean> _function_7 = (Graphlet<CLASSIFIER, FEATURE> o) -> {
                NodePattern<CLASSIFIER> _mainNode = o.getMainNode();
                NodePattern<?> _source = e.getSource();
                return Boolean.valueOf((_mainNode == _source));
              };
              boolean _exists = IterableExtensions.<Graphlet<CLASSIFIER, FEATURE>>exists(order, _function_7);
              if (_exists) {
                _xifexpression = 1;
              } else {
                _xifexpression = 0;
              }
              return Integer.valueOf(_xifexpression);
            };
            final BinaryOperator<Integer> _function_7 = (Integer p1, Integer p2) -> {
              return Integer.valueOf(((p1).intValue() + (p2).intValue()));
            };
            final Optional<Integer> inDeg = u.getIncomingNeighborEdges().<Integer>map(_function_6).reduce(_function_7);
            Integer _xifexpression = null;
            boolean _isPresent = outDeg.isPresent();
            if (_isPresent) {
              _xifexpression = outDeg.get();
            } else {
              _xifexpression = Integer.valueOf(0);
            }
            Integer _xifexpression_1 = null;
            boolean _isPresent_1 = inDeg.isPresent();
            if (_isPresent_1) {
              _xifexpression_1 = inDeg.get();
            } else {
              _xifexpression_1 = Integer.valueOf(0);
            }
            final int deg = ((_xifexpression).intValue() + (_xifexpression_1).intValue());
            return Pair.<Integer, Graphlet<CLASSIFIER, FEATURE>>of(Integer.valueOf(deg), u);
          };
          final Comparator<Pair<Integer, Graphlet<CLASSIFIER, FEATURE>>> _function_4 = (Pair<Integer, Graphlet<CLASSIFIER, FEATURE>> p1, Pair<Integer, Graphlet<CLASSIFIER, FEATURE>> p2) -> {
            Integer _key = p1.getKey();
            Integer _key_1 = p2.getKey();
            return ((_key).intValue() - (_key_1).intValue());
          };
          final Graphlet<CLASSIFIER, FEATURE> next = IterableExtensions.<Pair<Integer, Graphlet<CLASSIFIER, FEATURE>>>max(IterableExtensions.<Graphlet<CLASSIFIER, FEATURE>, Pair<Integer, Graphlet<CLASSIFIER, FEATURE>>>map(unselected, _function_3), _function_4).getValue();
          order.add(next);
        }
      }
    }
    final Function1<Graphlet<CLASSIFIER, FEATURE>, Boolean> _function_2 = (Graphlet<CLASSIFIER, FEATURE> g) -> {
      boolean _contains = IterableExtensions.contains(filter, g);
      return Boolean.valueOf((!_contains));
    };
    Iterables.<Graphlet<CLASSIFIER, FEATURE>>addAll(order, IterableExtensions.<Graphlet<CLASSIFIER, FEATURE>>filter(graphlets, _function_2));
    return order;
  }
  
  public void enumerate(final GraphPattern<CLASSIFIER, FEATURE> pattern, final CandidateSet<CLASSIFIER> globalCandidateSet, final List<Graphlet<CLASSIFIER, FEATURE>> order, final Match base, final int position, final Collection<Match> matches) {
    try {
      int _size = order.size();
      boolean _equals = (position == _size);
      if (_equals) {
        boolean _verifyOtherConstraints = this.verifyOtherConstraints(pattern, base);
        if (_verifyOtherConstraints) {
          matches.add(base.clone());
        }
      } else {
        final Graphlet<CLASSIFIER, FEATURE> next = this.selectNext(order, base, position);
        final Collection<?> lc = this.computeLocalCandidateSet(next, globalCandidateSet, order, base, position);
        for (final Object v : lc) {
          boolean _contains = base.contains(v);
          boolean _not = (!_contains);
          if (_not) {
            base.put(next.getMainNode(), v);
            this.enumerate(pattern, globalCandidateSet, order, base, (position + 1), matches);
            base.remove(next.getMainNode());
          }
        }
      }
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  /**
   * Other constraints include closure edge, or pattern, negative pattern, and projection pattern
   */
  public boolean verifyOtherConstraints(final GraphPattern<CLASSIFIER, FEATURE> pattern, final Match match) {
    Pattern[] _relations = pattern.getRelations();
    for (final Pattern cons : _relations) {
      if ((!(cons instanceof EdgePattern))) {
        final MatchSet matchSet = this.match(cons);
        final Function1<Variable, Object> _function = (Variable p) -> {
          return match.<Object>get(p);
        };
        Object[] _array = ListExtensions.<Variable, Object>map(((List<Variable>)Conversions.doWrapArray(cons.getPorts())), _function).toArray();
        final TupleN tuple = new TupleN(_array);
        boolean _checkRelation = matchSet.checkRelation(tuple);
        boolean _not = (!_checkRelation);
        if (_not) {
          return false;
        }
      }
    }
    return true;
  }
  
  public Graphlet<CLASSIFIER, FEATURE> selectNext(final List<Graphlet<CLASSIFIER, FEATURE>> order, final Match base, final int position) {
    return order.get(position);
  }
  
  public Collection<?> computeLocalCandidateSet(final Graphlet<CLASSIFIER, FEATURE> pattern, final CandidateSet<CLASSIFIER> globalCandidateSet, final List<Graphlet<CLASSIFIER, FEATURE>> order, final Match base, final int position) {
    return this.computeLocalCandidateSetDP(pattern, globalCandidateSet, order, base, position);
  }
  
  /**
   * A DP-iso-like local candidate computation method.
   * DP-iso requires an auxiliary structure to track edges among global candidates.
   * This method uses the cache of the graph/model instead.
   */
  protected Collection<?> computeLocalCandidateSetDP(final Graphlet<CLASSIFIER, FEATURE> pattern, final CandidateSet<CLASSIFIER> globalCandidateSet, final List<Graphlet<CLASSIFIER, FEATURE>> order, final Match base, final int position) {
    Collection<?> _xifexpression = null;
    boolean _isClass = this.typeContext.isClass(pattern.getMainNode().getType());
    if (_isClass) {
      Collection<?> _xblockexpression = null;
      {
        final Collection<?> globalCandidate = globalCandidateSet.get(pattern.getMainNode());
        Collection<?> _xifexpression_1 = null;
        if ((position == 0)) {
          _xifexpression_1 = globalCandidate;
        } else {
          final Function1<Graphlet<CLASSIFIER, FEATURE>, NodePattern<CLASSIFIER>> _function = (Graphlet<CLASSIFIER, FEATURE> g) -> {
            return g.getMainNode();
          };
          final List<NodePattern<CLASSIFIER>> prevNodes = ListExtensions.<Graphlet<CLASSIFIER, FEATURE>, NodePattern<CLASSIFIER>>map(order.subList(0, position), _function);
          final HashSet<Object> result = new HashSet<Object>(globalCandidate);
          final HashSet<Object> neighbor = new HashSet<Object>();
          final Predicate<EdgePattern<FEATURE>> _function_1 = (EdgePattern<FEATURE> e) -> {
            return prevNodes.contains(e.getSource());
          };
          final List<EdgePattern<FEATURE>> incomings = pattern.getIncomingNeighborEdges().filter(_function_1).collect(Collectors.<EdgePattern<FEATURE>>toList());
          final Predicate<EdgePattern<FEATURE>> _function_2 = (EdgePattern<FEATURE> e) -> {
            return prevNodes.contains(e.getTarget());
          };
          final List<EdgePattern<FEATURE>> outgoings = pattern.getOutgoingNeighborEdges().filter(_function_2).collect(Collectors.<EdgePattern<FEATURE>>toList());
          boolean _isEmpty = result.isEmpty();
          boolean _not = (!_isEmpty);
          if (_not) {
            final Function1<EdgePattern<FEATURE>, FEATURE> _function_3 = (EdgePattern<FEATURE> e) -> {
              return e.getType();
            };
            final BiConsumer<FEATURE, List<EdgePattern<FEATURE>>> _function_4 = (FEATURE type, List<EdgePattern<FEATURE>> refsOfSameType) -> {
              boolean _isEmpty_1 = result.isEmpty();
              if (_isEmpty_1) {
                return;
              }
              final Function1<EdgePattern<FEATURE>, NodePattern<?>> _function_5 = (EdgePattern<FEATURE> r) -> {
                return r.getTarget();
              };
              final BiConsumer<NodePattern<?>, List<EdgePattern<FEATURE>>> _function_6 = (NodePattern<?> tarNode, List<EdgePattern<FEATURE>> refsOfSameTarget) -> {
                boolean _isEmpty_2 = result.isEmpty();
                if (_isEmpty_2) {
                  return;
                }
                Object _type = tarNode.getType();
                boolean _isClass_1 = this.typeContext.isClass(((CLASSIFIER) _type));
                if (_isClass_1) {
                  neighbor.clear();
                  Object _get = base.<Object>get(tarNode);
                  final OBJECT target = ((OBJECT) _get);
                  int _size = refsOfSameTarget.size();
                  boolean _tripleEquals = (_size == 1);
                  if (_tripleEquals) {
                    neighbor.addAll(this.infrastructure.getSources(target, ((REFERENCE) type)));
                  } else {
                    final Function1<OBJECT, OBJECT> _function_7 = (OBJECT o) -> {
                      return o;
                    };
                    final Function2<OBJECT, List<OBJECT>, Boolean> _function_8 = (OBJECT o, List<OBJECT> sameO) -> {
                      int _size_1 = sameO.size();
                      int _size_2 = refsOfSameTarget.size();
                      return Boolean.valueOf((_size_1 >= _size_2));
                    };
                    final Set<OBJECT> sources = MapExtensions.<OBJECT, List<OBJECT>>filter(IterableExtensions.<OBJECT, OBJECT>groupBy(this.infrastructure.getSourceList(target, ((REFERENCE) type)), _function_7), _function_8).keySet();
                    neighbor.addAll(sources);
                  }
                  result.retainAll(neighbor);
                } else {
                  final Object target_1 = base.<Object>get(tarNode);
                  final Iterator<Object> iter = result.iterator();
                  while (iter.hasNext()) {
                    {
                      Object _next = iter.next();
                      final OBJECT source = ((OBJECT) _next);
                      boolean _contains = this.infrastructure.getSlots(source, ((ATTRIBUTE) type)).contains(target_1);
                      if (_contains) {
                        iter.remove();
                      }
                    }
                  }
                }
              };
              IterableExtensions.<NodePattern<?>, EdgePattern<FEATURE>>groupBy(refsOfSameType, _function_5).forEach(_function_6);
            };
            IterableExtensions.<FEATURE, EdgePattern<FEATURE>>groupBy(outgoings, _function_3).forEach(_function_4);
          }
          boolean _isEmpty_1 = result.isEmpty();
          boolean _not_1 = (!_isEmpty_1);
          if (_not_1) {
            final Function1<EdgePattern<FEATURE>, FEATURE> _function_5 = (EdgePattern<FEATURE> e) -> {
              return e.getType();
            };
            final BiConsumer<FEATURE, List<EdgePattern<FEATURE>>> _function_6 = (FEATURE type, List<EdgePattern<FEATURE>> refsOfSameType) -> {
              boolean _isEmpty_2 = result.isEmpty();
              if (_isEmpty_2) {
                return;
              }
              final Function1<EdgePattern<FEATURE>, NodePattern<?>> _function_7 = (EdgePattern<FEATURE> r) -> {
                return r.getSource();
              };
              final BiConsumer<NodePattern<?>, List<EdgePattern<FEATURE>>> _function_8 = (NodePattern<?> srcNode, List<EdgePattern<FEATURE>> refsOfSameSource) -> {
                boolean _isEmpty_3 = result.isEmpty();
                if (_isEmpty_3) {
                  return;
                }
                neighbor.clear();
                Object _get = base.<Object>get(srcNode);
                final OBJECT source = ((OBJECT) _get);
                int _size = refsOfSameSource.size();
                boolean _tripleEquals = (_size == 1);
                if (_tripleEquals) {
                  neighbor.addAll(this.infrastructure.getTargets(source, ((REFERENCE) type)));
                } else {
                  final Function1<OBJECT, OBJECT> _function_9 = (OBJECT o) -> {
                    return o;
                  };
                  final Function2<OBJECT, List<OBJECT>, Boolean> _function_10 = (OBJECT o, List<OBJECT> sameO) -> {
                    int _size_1 = sameO.size();
                    int _size_2 = refsOfSameSource.size();
                    return Boolean.valueOf((_size_1 >= _size_2));
                  };
                  final Set<OBJECT> targets = MapExtensions.<OBJECT, List<OBJECT>>filter(IterableExtensions.<OBJECT, OBJECT>groupBy(this.infrastructure.getTargets(source, ((REFERENCE) type)), _function_9), _function_10).keySet();
                  neighbor.addAll(targets);
                }
                result.retainAll(neighbor);
              };
              IterableExtensions.<NodePattern<?>, EdgePattern<FEATURE>>groupBy(refsOfSameType, _function_7).forEach(_function_8);
            };
            IterableExtensions.<FEATURE, EdgePattern<FEATURE>>groupBy(incomings, _function_5).forEach(_function_6);
          }
          final Function1<EdgePattern<FEATURE>, FEATURE> _function_7 = (EdgePattern<FEATURE> e) -> {
            return e.getType();
          };
          final BiConsumer<FEATURE, List<EdgePattern<FEATURE>>> _function_8 = (FEATURE type, List<EdgePattern<FEATURE>> list) -> {
            final int count = list.size();
            final Iterator<Object> it = result.iterator();
            while (it.hasNext()) {
              {
                final Object r = it.next();
                final Collection<OBJECT> tars = this.infrastructure.getTargets(((OBJECT) r), ((REFERENCE) type));
                boolean _xifexpression_2 = false;
                if ((count == 1)) {
                  _xifexpression_2 = tars.contains(r);
                } else {
                  boolean _xifexpression_3 = false;
                  if ((tars instanceof List)) {
                    final Predicate<Object> _function_9 = (Object t) -> {
                      return (t == r);
                    };
                    long _count = ((List)tars).stream().filter(_function_9).limit(count).count();
                    _xifexpression_3 = (_count >= count);
                  } else {
                    _xifexpression_3 = false;
                  }
                  _xifexpression_2 = _xifexpression_3;
                }
                final boolean flag = _xifexpression_2;
                if ((!flag)) {
                  it.remove();
                }
              }
            }
          };
          IterableExtensions.<FEATURE, EdgePattern<FEATURE>>groupBy(pattern.getSelfEdges(), _function_7).forEach(_function_8);
          return result;
        }
        _xblockexpression = _xifexpression_1;
      }
      _xifexpression = _xblockexpression;
    } else {
      if ((position == 0)) {
        throw new RuntimeException("Query engine did not index value nodes");
      } else {
        final Function1<Graphlet<CLASSIFIER, FEATURE>, NodePattern<CLASSIFIER>> _function = (Graphlet<CLASSIFIER, FEATURE> g) -> {
          return g.getMainNode();
        };
        final List<NodePattern<CLASSIFIER>> prevNodes = ListExtensions.<Graphlet<CLASSIFIER, FEATURE>, NodePattern<CLASSIFIER>>map(order.subList(0, position), _function);
        final HashSet<SLOT> result = new HashSet<SLOT>();
        final Predicate<EdgePattern<FEATURE>> _function_1 = (EdgePattern<FEATURE> e) -> {
          return prevNodes.contains(e.getSource());
        };
        final List<EdgePattern<FEATURE>> incomings = pattern.getIncomingNeighborEdges().filter(_function_1).collect(Collectors.<EdgePattern<FEATURE>>toList());
        final Procedure2<EdgePattern<FEATURE>, Integer> _function_2 = (EdgePattern<FEATURE> e, Integer i) -> {
          Object _get = base.<Object>get(e.getSource());
          final OBJECT source = ((OBJECT) _get);
          FEATURE _type = e.getType();
          final Collection<SLOT> values = this.infrastructure.getSlots(source, ((ATTRIBUTE) _type));
          if (((i).intValue() == 0)) {
            result.addAll(values);
          } else {
            result.retainAll(values);
          }
        };
        IterableExtensions.<EdgePattern<FEATURE>>forEach(incomings, _function_2);
        return result;
      }
    }
    return _xifexpression;
  }
  
  public MatchSet match(final Pattern pattern, final Match base) {
    if (pattern instanceof ClosurePattern) {
      return _match((ClosurePattern)pattern, base);
    } else if (pattern instanceof GraphPattern) {
      return _match((GraphPattern<CLASSIFIER, FEATURE>)pattern, base);
    } else if (pattern instanceof NegPattern) {
      return _match((NegPattern)pattern, base);
    } else if (pattern instanceof OrPattern) {
      return _match((OrPattern)pattern, base);
    } else if (pattern instanceof ProjectionPattern) {
      return _match((ProjectionPattern)pattern, base);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(pattern, base).toString());
    }
  }
}
