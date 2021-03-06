package edu.ustb.sei.mde.bxcore.dsl.jvmmodel;

import edu.ustb.sei.mde.bxcore.dsl.bXCore.BXCorePackage;
import edu.ustb.sei.mde.bxcore.dsl.bXCore.BXProgram;
import edu.ustb.sei.mde.bxcore.dsl.bXCore.ContextAwareCondition;
import edu.ustb.sei.mde.bxcore.dsl.bXCore.ContextAwareDerivationAction;
import edu.ustb.sei.mde.bxcore.dsl.bXCore.ContextAwareUnidirectionalAction;
import edu.ustb.sei.mde.bxcore.dsl.bXCore.ContextExpression;
import edu.ustb.sei.mde.bxcore.dsl.bXCore.ContextVarExpression;
import edu.ustb.sei.mde.bxcore.dsl.bXCore.ExpressionConversion;
import edu.ustb.sei.mde.bxcore.dsl.bXCore.NavigationExpression;
import edu.ustb.sei.mde.bxcore.dsl.bXCore.Pattern;
import edu.ustb.sei.mde.bxcore.dsl.bXCore.PatternDefinitionReference;
import edu.ustb.sei.mde.bxcore.dsl.bXCore.PatternTypeLiteral;
import edu.ustb.sei.mde.bxcore.dsl.bXCore.SideEnum;
import edu.ustb.sei.mde.bxcore.dsl.bXCore.TypeLiteral;
import edu.ustb.sei.mde.bxcore.dsl.bXCore.XmuCoreAlign;
import edu.ustb.sei.mde.bxcore.dsl.bXCore.XmuCoreDependencyView;
import edu.ustb.sei.mde.bxcore.dsl.bXCore.XmuCoreDeriveSource;
import edu.ustb.sei.mde.bxcore.dsl.bXCore.XmuCoreStatement;
import edu.ustb.sei.mde.bxcore.dsl.infer.InferData;
import edu.ustb.sei.mde.bxcore.dsl.infer.InferManager;
import edu.ustb.sei.mde.bxcore.dsl.infer.TypeInferenceException;
import edu.ustb.sei.mde.bxcore.dsl.infer.UnsolvedTupleType;
import edu.ustb.sei.mde.bxcore.dsl.structure.TupleType;
import edu.ustb.sei.mde.structure.Tuple2;
import edu.ustb.sei.mde.structure.Tuple3;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.MapExtensions;
import org.eclipse.xtext.xbase.lib.Pair;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure3;

@SuppressWarnings("all")
public class ModelInferrerUtils {
  public static HashMap<TypeLiteral, Tuple2<TupleType, Integer>> groupTypeLiterals(final BXProgram program) {
    final ArrayList<Pair<TypeLiteral, TupleType>> literals = new ArrayList<Pair<TypeLiteral, TupleType>>();
    final TreeIterator<EObject> itr = program.eAllContents();
    while (itr.hasNext()) {
      {
        final EObject e = itr.next();
        boolean _eIsProxy = e.eIsProxy();
        if (_eIsProxy) {
          throw new TypeInferenceException(e, null, null, null);
        } else {
          if ((e instanceof TypeLiteral)) {
            TupleType _make = TupleType.make(((TypeLiteral) e));
            Pair<TypeLiteral, TupleType> _mappedTo = Pair.<TypeLiteral, TupleType>of(((TypeLiteral) e), _make);
            literals.add(_mappedTo);
          }
        }
      }
    }
    final Function1<Pair<TypeLiteral, TupleType>, TupleType> _function = (Pair<TypeLiteral, TupleType> it) -> {
      return it.getValue();
    };
    final Map<TupleType, List<Pair<TypeLiteral, TupleType>>> groups = IterableExtensions.<TupleType, Pair<TypeLiteral, TupleType>>groupBy(literals, _function);
    final HashMap<TypeLiteral, Tuple2<TupleType, Integer>> result = new HashMap<TypeLiteral, Tuple2<TupleType, Integer>>();
    final Procedure3<TupleType, List<Pair<TypeLiteral, TupleType>>, Integer> _function_1 = (TupleType k, List<Pair<TypeLiteral, TupleType>> v, Integer id) -> {
      final Tuple2<TupleType, Integer> pair = Tuple2.<TupleType, Integer>make(k, id);
      final Consumer<Pair<TypeLiteral, TupleType>> _function_2 = (Pair<TypeLiteral, TupleType> p) -> {
        result.put(p.getKey(), pair);
      };
      v.forEach(_function_2);
    };
    MapExtensions.<TupleType, List<Pair<TypeLiteral, TupleType>>>forEach(groups, _function_1);
    return result;
  }
  
  public static TupleType context(final EObject e, final SideEnum side) {
    TupleType _xtrycatchfinallyexpression = null;
    try {
      TupleType _xifexpression = null;
      if ((e == null)) {
        _xifexpression = null;
      } else {
        TupleType _xifexpression_1 = null;
        if ((e instanceof Pattern)) {
          TupleType _xblockexpression = null;
          {
            final InferData inferData = InferManager.getInferredTypeModel(((Pattern)e).eResource());
            TupleType _xifexpression_2 = null;
            if ((e instanceof PatternDefinitionReference)) {
              _xifexpression_2 = inferData.getLiteralMap().get(((PatternDefinitionReference)e).getPattern().getLiteral()).first;
            } else {
              TupleType _xifexpression_3 = null;
              if ((e instanceof PatternTypeLiteral)) {
                _xifexpression_3 = inferData.getLiteralMap().get(e).first;
              } else {
                _xifexpression_3 = null;
              }
              _xifexpression_2 = _xifexpression_3;
            }
            _xblockexpression = _xifexpression_2;
          }
          _xifexpression_1 = _xblockexpression;
        } else {
          TupleType _xifexpression_2 = null;
          if ((e instanceof ContextAwareCondition)) {
            TupleType _xifexpression_3 = null;
            EStructuralFeature _eContainingFeature = ((ContextAwareCondition)e).eContainingFeature();
            boolean _tripleEquals = (_eContainingFeature == BXCorePackage.Literals.XMU_CORE_ALIGN__ALIGNMENT);
            if (_tripleEquals) {
              TupleType _xifexpression_4 = null;
              if ((side == SideEnum.SOURCE)) {
                EObject _eContainer = ((ContextAwareCondition)e).eContainer();
                _xifexpression_4 = ModelInferrerUtils.context(((XmuCoreAlign) _eContainer).getSourcePattern(), SideEnum.SOURCE);
              } else {
                TupleType _xifexpression_5 = null;
                if ((side == SideEnum.VIEW)) {
                  EObject _eContainer_1 = ((ContextAwareCondition)e).eContainer();
                  _xifexpression_5 = ModelInferrerUtils.context(((XmuCoreAlign) _eContainer_1).getViewPattern(), SideEnum.VIEW);
                } else {
                  _xifexpression_5 = null;
                }
                _xifexpression_4 = _xifexpression_5;
              }
              _xifexpression_3 = _xifexpression_4;
            } else {
              TupleType _xifexpression_6 = null;
              EStructuralFeature _eContainingFeature_1 = ((ContextAwareCondition)e).eContainingFeature();
              boolean _tripleEquals_1 = (_eContainingFeature_1 == BXCorePackage.Literals.PATTERN_TYPE_LITERAL__FILTER);
              if (_tripleEquals_1) {
                TupleType _xifexpression_7 = null;
                if ((side == SideEnum.CONTEXT)) {
                  _xifexpression_7 = ModelInferrerUtils.context(((ContextAwareCondition)e).eContainer(), SideEnum.CONTEXT);
                } else {
                  _xifexpression_7 = null;
                }
                _xifexpression_6 = _xifexpression_7;
              } else {
                _xifexpression_6 = ModelInferrerUtils.context(((ContextAwareCondition)e).eContainer(), side);
              }
              _xifexpression_3 = _xifexpression_6;
            }
            _xifexpression_2 = _xifexpression_3;
          } else {
            TupleType _xifexpression_8 = null;
            if ((e instanceof ContextAwareUnidirectionalAction)) {
              TupleType _xifexpression_9 = null;
              EStructuralFeature _eContainingFeature_2 = ((ContextAwareUnidirectionalAction)e).eContainingFeature();
              boolean _tripleEquals_2 = (_eContainingFeature_2 == BXCorePackage.Literals.XMU_CORE_ALIGN__UNMATCH_S);
              if (_tripleEquals_2) {
                TupleType _xifexpression_10 = null;
                if ((side == SideEnum.SOURCE)) {
                  EObject _eContainer_2 = ((ContextAwareUnidirectionalAction)e).eContainer();
                  _xifexpression_10 = ModelInferrerUtils.context(((XmuCoreAlign) _eContainer_2).getSourcePattern(), SideEnum.SOURCE);
                } else {
                  TupleType _xifexpression_11 = null;
                  if ((side == SideEnum.VIEW)) {
                    EObject _eContainer_3 = ((ContextAwareUnidirectionalAction)e).eContainer();
                    _xifexpression_11 = ModelInferrerUtils.context(((XmuCoreAlign) _eContainer_3), SideEnum.VIEW);
                  } else {
                    _xifexpression_11 = null;
                  }
                  _xifexpression_10 = _xifexpression_11;
                }
                _xifexpression_9 = _xifexpression_10;
              } else {
                TupleType _xifexpression_12 = null;
                EStructuralFeature _eContainingFeature_3 = ((ContextAwareUnidirectionalAction)e).eContainingFeature();
                boolean _tripleEquals_3 = (_eContainingFeature_3 == BXCorePackage.Literals.XMU_CORE_ALIGN__UNMATCH_V);
                if (_tripleEquals_3) {
                  TupleType _xifexpression_13 = null;
                  if ((side == SideEnum.SOURCE)) {
                    EObject _eContainer_4 = ((ContextAwareUnidirectionalAction)e).eContainer();
                    _xifexpression_13 = ModelInferrerUtils.context(((XmuCoreAlign) _eContainer_4), SideEnum.SOURCE);
                  } else {
                    TupleType _xifexpression_14 = null;
                    if ((side == SideEnum.VIEW)) {
                      EObject _eContainer_5 = ((ContextAwareUnidirectionalAction)e).eContainer();
                      _xifexpression_14 = ModelInferrerUtils.context(((XmuCoreAlign) _eContainer_5).getViewPattern(), SideEnum.VIEW);
                    } else {
                      _xifexpression_14 = null;
                    }
                    _xifexpression_13 = _xifexpression_14;
                  }
                  _xifexpression_12 = _xifexpression_13;
                } else {
                  _xifexpression_12 = ModelInferrerUtils.context(((ContextAwareUnidirectionalAction)e).eContainer(), side);
                }
                _xifexpression_9 = _xifexpression_12;
              }
              _xifexpression_8 = _xifexpression_9;
            } else {
              TupleType _xifexpression_15 = null;
              if ((e instanceof ContextAwareDerivationAction)) {
                TupleType _xblockexpression_1 = null;
                {
                  final EObject stmt = ModelInferrerUtils.containingStatementOrPattern(e);
                  TupleType _xifexpression_16 = null;
                  if ((side == SideEnum.SOURCE)) {
                    TupleType _xifexpression_17 = null;
                    if ((stmt instanceof XmuCoreDeriveSource)) {
                      _xifexpression_17 = ModelInferrerUtils.context(stmt, side);
                    } else {
                      _xifexpression_17 = null;
                    }
                    _xifexpression_16 = _xifexpression_17;
                  } else {
                    TupleType _xifexpression_18 = null;
                    if ((side == SideEnum.VIEW)) {
                      TupleType _xifexpression_19 = null;
                      if ((stmt instanceof XmuCoreDependencyView)) {
                        _xifexpression_19 = ModelInferrerUtils.context(stmt, side);
                      } else {
                        _xifexpression_19 = null;
                      }
                      _xifexpression_18 = _xifexpression_19;
                    } else {
                      TupleType _xifexpression_20 = null;
                      if ((stmt instanceof PatternTypeLiteral)) {
                        _xifexpression_20 = ModelInferrerUtils.context(stmt, side);
                      } else {
                        _xifexpression_20 = null;
                      }
                      _xifexpression_18 = _xifexpression_20;
                    }
                    _xifexpression_16 = _xifexpression_18;
                  }
                  _xblockexpression_1 = _xifexpression_16;
                }
                _xifexpression_15 = _xblockexpression_1;
              } else {
                TupleType _xifexpression_16 = null;
                if ((e instanceof XmuCoreStatement)) {
                  UnsolvedTupleType _xblockexpression_2 = null;
                  {
                    final InferData inferData = InferManager.getInferredTypeModel(((XmuCoreStatement)e).eResource());
                    UnsolvedTupleType _xifexpression_17 = null;
                    if ((side == SideEnum.SOURCE)) {
                      _xifexpression_17 = inferData.getSourceInfer().unsolvedTupleTypeMap.get(e);
                    } else {
                      UnsolvedTupleType _xifexpression_18 = null;
                      if ((side == SideEnum.VIEW)) {
                        _xifexpression_18 = inferData.getViewInfer().unsolvedTupleTypeMap.get(e);
                      } else {
                        _xifexpression_18 = null;
                      }
                      _xifexpression_17 = _xifexpression_18;
                    }
                    _xblockexpression_2 = _xifexpression_17;
                  }
                  _xifexpression_16 = _xblockexpression_2;
                } else {
                  _xifexpression_16 = ModelInferrerUtils.context(e.eContainer(), side);
                }
                _xifexpression_15 = _xifexpression_16;
              }
              _xifexpression_8 = _xifexpression_15;
            }
            _xifexpression_2 = _xifexpression_8;
          }
          _xifexpression_1 = _xifexpression_2;
        }
        _xifexpression = _xifexpression_1;
      }
      _xtrycatchfinallyexpression = _xifexpression;
    } catch (final Throwable _t) {
      if (_t instanceof Exception) {
        return null;
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
    return _xtrycatchfinallyexpression;
  }
  
  public static EObject containingStatementOrPattern(final EObject e) {
    EObject _xifexpression = null;
    if ((((e == null) || (e instanceof XmuCoreStatement)) || (e instanceof Pattern))) {
      _xifexpression = e;
    } else {
      _xifexpression = ModelInferrerUtils.containingStatementOrPattern(e.eContainer());
    }
    return _xifexpression;
  }
  
  public static boolean isContextOnly(final EObject e) {
    return false;
  }
  
  public static Pair<Object, Boolean> navEcoreType(final ContextExpression e) {
    Pair<Object, Boolean> _xifexpression = null;
    if ((e instanceof ContextVarExpression)) {
      Pair<Object, Boolean> _xblockexpression = null;
      {
        final SideEnum side = ((ContextVarExpression)e).getSide();
        final String varName = ((ContextVarExpression)e).getName();
        Pair<Object, Boolean> _xtrycatchfinallyexpression = null;
        try {
          Pair<Object, Boolean> _xblockexpression_1 = null;
          {
            final TupleType tupleType = ModelInferrerUtils.context(e, side);
            Pair<Object, Boolean> _xifexpression_1 = null;
            if ((tupleType == null)) {
              _xifexpression_1 = null;
            } else {
              Pair<Object, Boolean> _xblockexpression_2 = null;
              {
                final Function1<Tuple3<String, Object, Boolean>, Boolean> _function = (Tuple3<String, Object, Boolean> it) -> {
                  return Boolean.valueOf(it.first.equals(varName));
                };
                final Tuple3<String, Object, Boolean> typeDef = IterableExtensions.<Tuple3<String, Object, Boolean>>findFirst(tupleType.tuples, _function);
                Pair<Object, Boolean> _xifexpression_2 = null;
                if ((typeDef == null)) {
                  _xifexpression_2 = null;
                } else {
                  _xifexpression_2 = Pair.<Object, Boolean>of(typeDef.second, typeDef.third);
                }
                _xblockexpression_2 = _xifexpression_2;
              }
              _xifexpression_1 = _xblockexpression_2;
            }
            _xblockexpression_1 = _xifexpression_1;
          }
          _xtrycatchfinallyexpression = _xblockexpression_1;
        } catch (final Throwable _t) {
          if (_t instanceof Exception) {
            _xtrycatchfinallyexpression = null;
          } else {
            throw Exceptions.sneakyThrow(_t);
          }
        }
        _xblockexpression = _xtrycatchfinallyexpression;
      }
      _xifexpression = _xblockexpression;
    } else {
      Pair<Object, Boolean> _xifexpression_1 = null;
      if ((e instanceof NavigationExpression)) {
        Pair<Object, Boolean> _xblockexpression_1 = null;
        {
          final Pair<Object, Boolean> hostType = ModelInferrerUtils.navEcoreType(((NavigationExpression)e).getHost());
          final String path = ((NavigationExpression)e).getPathName();
          final boolean isNode = ((NavigationExpression)e).getNavOp().equals("@");
          Pair<Object, Boolean> _xifexpression_2 = null;
          if ((hostType == null)) {
            _xifexpression_2 = null;
          } else {
            Pair<Object, Boolean> _xifexpression_3 = null;
            Object _key = hostType.getKey();
            if ((_key instanceof EClass)) {
              Pair<Object, Boolean> _xblockexpression_2 = null;
              {
                Object _key_1 = hostType.getKey();
                final EStructuralFeature pathType = ((EClass) _key_1).getEStructuralFeature(path);
                Pair<Object, Boolean> _xifexpression_4 = null;
                if ((pathType == null)) {
                  _xifexpression_4 = null;
                } else {
                  Pair<Object, Boolean> _xifexpression_5 = null;
                  if (isNode) {
                    EClassifier _eType = pathType.getEType();
                    _xifexpression_5 = Pair.<Object, Boolean>of(_eType, Boolean.valueOf(((hostType.getValue()).booleanValue() || pathType.isMany())));
                  } else {
                    _xifexpression_5 = Pair.<Object, Boolean>of(pathType, Boolean.valueOf(((hostType.getValue()).booleanValue() || pathType.isMany())));
                  }
                  _xifexpression_4 = _xifexpression_5;
                }
                _xblockexpression_2 = _xifexpression_4;
              }
              _xifexpression_3 = _xblockexpression_2;
            } else {
              _xifexpression_3 = null;
            }
            _xifexpression_2 = _xifexpression_3;
          }
          _xblockexpression_1 = _xifexpression_2;
        }
        _xifexpression_1 = _xblockexpression_1;
      } else {
        if ((e instanceof ExpressionConversion)) {
          final EClass type = ((ExpressionConversion)e).getType();
          boolean _isMany = ((ExpressionConversion)e).isMany();
          return Pair.<Object, Boolean>of(type, Boolean.valueOf(_isMany));
        }
      }
      _xifexpression = _xifexpression_1;
    }
    return _xifexpression;
  }
}
