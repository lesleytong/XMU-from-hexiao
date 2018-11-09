package edu.ustb.sei.mde.bxcore.dsl.jvmmodel;

import edu.ustb.sei.mde.bxcore.dsl.bXCore.AllInstanceExpression;
import edu.ustb.sei.mde.bxcore.dsl.bXCore.ContextExpression;
import edu.ustb.sei.mde.bxcore.dsl.bXCore.ContextVarExpression;
import edu.ustb.sei.mde.bxcore.dsl.bXCore.DeleteElementExpression;
import edu.ustb.sei.mde.bxcore.dsl.bXCore.EnforcementExpression;
import edu.ustb.sei.mde.bxcore.dsl.bXCore.ExpressionConversion;
import edu.ustb.sei.mde.bxcore.dsl.bXCore.ModificationExpression;
import edu.ustb.sei.mde.bxcore.dsl.bXCore.ModificationExpressionBlock;
import edu.ustb.sei.mde.bxcore.dsl.bXCore.NavigationExpression;
import edu.ustb.sei.mde.bxcore.dsl.bXCore.NewInstanceExpression;
import edu.ustb.sei.mde.bxcore.dsl.bXCore.Pattern;
import edu.ustb.sei.mde.bxcore.dsl.bXCore.PatternDefinitionReference;
import edu.ustb.sei.mde.bxcore.dsl.bXCore.PatternTypeLiteral;
import edu.ustb.sei.mde.bxcore.dsl.bXCore.SideEnum;
import edu.ustb.sei.mde.bxcore.dsl.bXCore.ValueMapping;
import edu.ustb.sei.mde.bxcore.dsl.infer.InferData;
import edu.ustb.sei.mde.bxcore.dsl.infer.InferManager;
import edu.ustb.sei.mde.bxcore.dsl.jvmmodel.ModelInferrerUtils;
import edu.ustb.sei.mde.bxcore.dsl.structure.ExceptionSafeInferface;
import edu.ustb.sei.mde.bxcore.structures.ContextGraph;
import edu.ustb.sei.mde.graph.typedGraph.IndexableElement;
import edu.ustb.sei.mde.graph.typedGraph.TypedEdge;
import edu.ustb.sei.mde.graph.typedGraph.TypedNode;
import edu.ustb.sei.mde.graph.typedGraph.ValueEdge;
import java.util.function.Consumer;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.compiler.XbaseCompiler;
import org.eclipse.xtext.xbase.compiler.output.ITreeAppendable;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Pair;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure2;
import org.eclipse.xtext.xbase.lib.StringExtensions;

@SuppressWarnings("all")
public class XmuCoreCompiler extends XbaseCompiler {
  public CharSequence patternAccessor(final Pattern p) {
    CharSequence _xtrycatchfinallyexpression = null;
    try {
      String _xblockexpression = null;
      {
        final InferData data = InferManager.getInferredTypeModel(p.eResource());
        if ((data == null)) {
          InputOutput.<String>println("null");
        }
        String _xifexpression = null;
        if ((p instanceof PatternTypeLiteral)) {
          String _xblockexpression_1 = null;
          {
            final Function1<Pair<Integer, PatternTypeLiteral>, Boolean> _function = (Pair<Integer, PatternTypeLiteral> it) -> {
              PatternTypeLiteral _value = it.getValue();
              return Boolean.valueOf((_value == p));
            };
            final Pair<Integer, PatternTypeLiteral> lit = IterableExtensions.<Pair<Integer, PatternTypeLiteral>>findFirst(data.getPatternLiterals(), _function);
            if ((lit == null)) {
              InputOutput.<String>println("null");
            }
            Integer _key = lit.getKey();
            _xblockexpression_1 = ("getPattern_" + _key);
          }
          _xifexpression = _xblockexpression_1;
        } else {
          String _xifexpression_1 = null;
          if ((p instanceof PatternDefinitionReference)) {
            _xifexpression_1 = StringExtensions.toFirstUpper(((PatternDefinitionReference)p).getPattern().getName());
          } else {
            _xifexpression_1 = "/* ERROR: unknown pattern type */";
          }
          _xifexpression = _xifexpression_1;
        }
        _xblockexpression = _xifexpression;
      }
      _xtrycatchfinallyexpression = _xblockexpression;
    } catch (final Throwable _t) {
      if (_t instanceof Exception) {
        final Exception e = (Exception)_t;
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("/* ERROR: ");
        String _message = e.getMessage();
        _builder.append(_message);
        _builder.append("*/");
        _xtrycatchfinallyexpression = _builder;
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
    return _xtrycatchfinallyexpression;
  }
  
  @Override
  protected void doInternalToJavaStatement(final XExpression e, final ITreeAppendable a, final boolean isReferenced) {
    if ((e instanceof ContextVarExpression)) {
      final JvmTypeReference expectedType = this.getType(e);
      if (isReferenced) {
        final String name = a.declareSyntheticVariable(e, "_contextValue");
        ITreeAppendable _newLine = a.newLine();
        StringConcatenation _builder = new StringConcatenation();
        String _qualifiedName = expectedType.getQualifiedName();
        _builder.append(_qualifiedName);
        _builder.append(" ");
        _builder.append(name);
        _builder.append(" = ");
        _newLine.append(_builder);
        StringConcatenation _builder_1 = new StringConcatenation();
        _builder_1.append("((");
        String _qualifiedName_1 = expectedType.getQualifiedName();
        _builder_1.append(_qualifiedName_1);
        _builder_1.append(") ");
        String _canonicalName = ExceptionSafeInferface.class.getCanonicalName();
        _builder_1.append(_canonicalName);
        _builder_1.append(".getValue(");
        String _literal = ((ContextVarExpression)e).getSide().getLiteral();
        _builder_1.append(_literal);
        _builder_1.append(",\"");
        String _name = ((ContextVarExpression)e).getName();
        _builder_1.append(_name);
        _builder_1.append("\"))");
        a.append(_builder_1);
        a.append(";");
      } else {
        StringConcatenation _builder_2 = new StringConcatenation();
        _builder_2.append("((");
        String _qualifiedName_2 = expectedType.getQualifiedName();
        _builder_2.append(_qualifiedName_2);
        _builder_2.append(") ");
        String _canonicalName_1 = ExceptionSafeInferface.class.getCanonicalName();
        _builder_2.append(_canonicalName_1);
        _builder_2.append(".getValue(");
        String _literal_1 = ((ContextVarExpression)e).getSide().getLiteral();
        _builder_2.append(_literal_1);
        _builder_2.append(",\"");
        String _name_1 = ((ContextVarExpression)e).getName();
        _builder_2.append(_name_1);
        _builder_2.append("\"))");
        a.append(_builder_2);
        a.append(";");
      }
    } else {
      if ((e instanceof ExpressionConversion)) {
        final JvmTypeReference expectedType_1 = this.getType(e);
        this.doInternalToJavaStatement(((ExpressionConversion)e).getExpression(), a, true);
        if (isReferenced) {
          final String name_1 = a.declareSyntheticVariable(e, "_expValue");
          ITreeAppendable _newLine_1 = a.newLine();
          StringConcatenation _builder_3 = new StringConcatenation();
          String _qualifiedName_3 = expectedType_1.getQualifiedName();
          _builder_3.append(_qualifiedName_3);
          _builder_3.append(" ");
          _builder_3.append(name_1);
          _builder_3.append(" = ");
          _newLine_1.append(_builder_3);
          this.internalToJavaExpression(((ExpressionConversion)e).getExpression(), a);
          a.append(";");
        } else {
          this.internalToJavaExpression(((ExpressionConversion)e).getExpression(), a);
          a.append(";");
        }
      } else {
        if ((e instanceof NavigationExpression)) {
          this.doInternalToJavaStatement(((NavigationExpression)e).getHost(), a, true);
          a.newLine();
          final JvmTypeReference expectedType_2 = this.getType(e);
          final Pair<EClassifier, Boolean> ecoreType = ModelInferrerUtils.navEcoreType(((ContextExpression)e));
          if (isReferenced) {
            final String name_2 = a.declareSyntheticVariable(e, "_navExp");
            ITreeAppendable _newLine_2 = a.newLine();
            StringConcatenation _builder_4 = new StringConcatenation();
            String _qualifiedName_4 = expectedType_2.getQualifiedName();
            _builder_4.append(_qualifiedName_4);
            _builder_4.append(" ");
            _builder_4.append(name_2);
            _builder_4.append(" = ");
            String _canonicalName_2 = ExceptionSafeInferface.class.getCanonicalName();
            _builder_4.append(_canonicalName_2);
            _builder_4.append(".navigate(");
            String _literal_2 = this.side(((ContextExpression)e)).getLiteral();
            _builder_4.append(_literal_2);
            _builder_4.append(", ");
            _newLine_2.append(_builder_4);
            this.internalToJavaExpression(((NavigationExpression)e).getHost(), a);
            StringConcatenation _builder_5 = new StringConcatenation();
            _builder_5.append(", \"");
            String _pathName = ((NavigationExpression)e).getPathName();
            _builder_5.append(_pathName);
            _builder_5.append("\", ");
            EClassifier _key = ecoreType.getKey();
            _builder_5.append((_key instanceof EClass));
            _builder_5.append(", ");
            Boolean _value = ecoreType.getValue();
            _builder_5.append(_value);
            _builder_5.append(");");
            a.append(_builder_5);
          } else {
            ITreeAppendable _newLine_3 = a.newLine();
            StringConcatenation _builder_6 = new StringConcatenation();
            String _canonicalName_3 = ExceptionSafeInferface.class.getCanonicalName();
            _builder_6.append(_canonicalName_3);
            _builder_6.append(".navigate(");
            String _literal_3 = this.side(((ContextExpression)e)).getLiteral();
            _builder_6.append(_literal_3);
            _builder_6.append(", ");
            _newLine_3.append(_builder_6);
            this.internalToJavaExpression(((NavigationExpression)e).getHost(), a);
            StringConcatenation _builder_7 = new StringConcatenation();
            _builder_7.append(", \"");
            String _pathName_1 = ((NavigationExpression)e).getPathName();
            _builder_7.append(_pathName_1);
            _builder_7.append("\", ");
            EClassifier _key_1 = ecoreType.getKey();
            _builder_7.append((_key_1 instanceof EClass));
            _builder_7.append(", ");
            Boolean _value_1 = ecoreType.getValue();
            _builder_7.append(_value_1);
            _builder_7.append(");");
            a.append(_builder_7);
          }
        } else {
          if ((e instanceof ModificationExpressionBlock)) {
            a.newLine();
            final String mo = a.declareSyntheticVariable(e, "_modStart");
            StringConcatenation _builder_8 = new StringConcatenation();
            String _canonicalName_4 = ContextGraph.GraphModification.class.getCanonicalName();
            _builder_8.append(_canonicalName_4);
            _builder_8.append(" ");
            _builder_8.append(mo);
            _builder_8.append(" = source.modification();");
            a.append(_builder_8);
            final Consumer<XExpression> _function = (XExpression me) -> {
              this.internalToJavaStatement(me, a, true);
            };
            ((ModificationExpressionBlock)e).getExpressions().forEach(_function);
            if (isReferenced) {
            } else {
              StringConcatenation _builder_9 = new StringConcatenation();
              _builder_9.append("return ");
              a.append(_builder_9);
              this.internalToJavaExpression(e, a);
              StringConcatenation _builder_10 = new StringConcatenation();
              _builder_10.append(";");
              a.append(_builder_10);
            }
          } else {
            if ((e instanceof ModificationExpression)) {
              final ModificationExpressionBlock block = this.block(e);
              final String blockVar = this.getVarName(block, a);
              final String cur = a.declareSyntheticVariable(e, "_mod");
              if ((e instanceof EnforcementExpression)) {
                final Consumer<ValueMapping> _function_1 = (ValueMapping it) -> {
                  this.internalToJavaStatement(it.getExpression(), a, true);
                };
                ((EnforcementExpression)e).getValueMappings().forEach(_function_1);
                ITreeAppendable _newLine_4 = a.newLine();
                StringConcatenation _builder_11 = new StringConcatenation();
                String _canonicalName_5 = ContextGraph.GraphModification.class.getCanonicalName();
                _builder_11.append(_canonicalName_5);
                _builder_11.append(" ");
                _builder_11.append(cur);
                _builder_11.append(" = ");
                _builder_11.append(blockVar);
                _builder_11.append(".enforce(");
                CharSequence _patternAccessor = this.patternAccessor(((EnforcementExpression)e).getPattern());
                _builder_11.append(_patternAccessor);
                _builder_11.append("(), new edu.ustb.sei.mde.structure.Tuple2[] {");
                _newLine_4.append(_builder_11);
                final Procedure2<ValueMapping, Integer> _function_2 = (ValueMapping m, Integer id) -> {
                  if (((id).intValue() > 0)) {
                    a.append(",");
                  }
                  StringConcatenation _builder_12 = new StringConcatenation();
                  _builder_12.append("edu.ustb.sei.mde.structure.Tuple2.make(\"");
                  String _varName = m.getVarName();
                  _builder_12.append(_varName);
                  _builder_12.append("\",");
                  a.append(_builder_12);
                  this.internalToJavaExpression(m.getExpression(), a);
                  StringConcatenation _builder_13 = new StringConcatenation();
                  _builder_13.append(")");
                  a.append(_builder_13);
                };
                IterableExtensions.<ValueMapping>forEach(((EnforcementExpression)e).getValueMappings(), _function_2);
                StringConcatenation _builder_12 = new StringConcatenation();
                _builder_12.append("});");
                a.append(_builder_12).newLine();
                StringConcatenation _builder_13 = new StringConcatenation();
                _builder_13.append(blockVar);
                _builder_13.append(" = ");
                _builder_13.append(cur);
                _builder_13.append(";");
                a.append(_builder_13);
              } else {
                if ((e instanceof DeleteElementExpression)) {
                  this.internalToJavaStatement(((DeleteElementExpression)e).getElement(), a, true);
                  ITreeAppendable _newLine_5 = a.newLine();
                  StringConcatenation _builder_14 = new StringConcatenation();
                  String _canonicalName_6 = ContextGraph.GraphModification.class.getCanonicalName();
                  _builder_14.append(_canonicalName_6);
                  _builder_14.append(" ");
                  _builder_14.append(cur);
                  _builder_14.append(" = ");
                  _builder_14.append(blockVar);
                  _builder_14.append(".remove(");
                  _newLine_5.append(_builder_14);
                  this.internalToJavaExpression(((DeleteElementExpression)e).getElement(), a);
                  StringConcatenation _builder_15 = new StringConcatenation();
                  _builder_15.append(");");
                  a.append(_builder_15).newLine();
                }
              }
            } else {
              if ((e instanceof NewInstanceExpression)) {
                XExpression _size = ((NewInstanceExpression)e).getSize();
                boolean _tripleNotEquals = (_size != null);
                if (_tripleNotEquals) {
                  this.internalToJavaStatement(((NewInstanceExpression)e).getSize(), a, true);
                }
                Class<? extends IndexableElement> _xifexpression = null;
                EStructuralFeature _feature = ((NewInstanceExpression)e).getType().getFeature();
                boolean _tripleEquals = (_feature == null);
                if (_tripleEquals) {
                  _xifexpression = TypedNode.class;
                } else {
                  Class<? extends IndexableElement> _xifexpression_1 = null;
                  EStructuralFeature _feature_1 = ((NewInstanceExpression)e).getType().getFeature();
                  if ((_feature_1 instanceof EReference)) {
                    _xifexpression_1 = TypedEdge.class;
                  } else {
                    _xifexpression_1 = ValueEdge.class;
                  }
                  _xifexpression = _xifexpression_1;
                }
                final Class<? extends IndexableElement> componentType = _xifexpression;
                final String v = a.declareSyntheticVariable(e, "newInstance");
                XExpression _size_1 = ((NewInstanceExpression)e).getSize();
                boolean _tripleNotEquals_1 = (_size_1 != null);
                if (_tripleNotEquals_1) {
                  final String iv = a.declareUniqueNameVariable(e, "it");
                  ITreeAppendable _newLine_6 = a.newLine();
                  StringConcatenation _builder_16 = new StringConcatenation();
                  _builder_16.append("java.util.List<");
                  String _canonicalName_7 = componentType.getCanonicalName();
                  _builder_16.append(_canonicalName_7);
                  _builder_16.append("> ");
                  _builder_16.append(v);
                  _builder_16.append(" = new java.util.ArrayList<>();");
                  _newLine_6.append(_builder_16);
                  ITreeAppendable _newLine_7 = a.newLine();
                  StringConcatenation _builder_17 = new StringConcatenation();
                  _builder_17.append("for(int ");
                  _builder_17.append(iv);
                  _builder_17.append("=0;");
                  _builder_17.append(iv);
                  _builder_17.append("<");
                  _newLine_7.append(_builder_17);
                  this.internalToJavaExpression(((NewInstanceExpression)e).getSize(), a);
                  StringConcatenation _builder_18 = new StringConcatenation();
                  _builder_18.append(";");
                  _builder_18.append(iv);
                  _builder_18.append("++) ");
                  _builder_18.append(v);
                  _builder_18.append(".add(");
                  String _canonicalName_8 = ContextGraph.class.getCanonicalName();
                  _builder_18.append(_canonicalName_8);
                  _builder_18.append(".new");
                  String _simpleName = componentType.getSimpleName();
                  _builder_18.append(_simpleName);
                  _builder_18.append("());");
                  a.append(_builder_18);
                } else {
                  ITreeAppendable _newLine_8 = a.newLine();
                  StringConcatenation _builder_19 = new StringConcatenation();
                  String _canonicalName_9 = componentType.getCanonicalName();
                  _builder_19.append(_canonicalName_9);
                  _builder_19.append(" ");
                  _builder_19.append(v);
                  _builder_19.append(" = ");
                  String _canonicalName_10 = ContextGraph.class.getCanonicalName();
                  _builder_19.append(_canonicalName_10);
                  _builder_19.append(".new");
                  String _simpleName_1 = componentType.getSimpleName();
                  _builder_19.append(_simpleName_1);
                  _builder_19.append("();");
                  _newLine_8.append(_builder_19);
                }
              } else {
                if ((e instanceof AllInstanceExpression)) {
                  Class<? extends IndexableElement> _xifexpression_2 = null;
                  EStructuralFeature _feature_2 = ((AllInstanceExpression)e).getType().getFeature();
                  boolean _tripleEquals_1 = (_feature_2 == null);
                  if (_tripleEquals_1) {
                    _xifexpression_2 = TypedNode.class;
                  } else {
                    Class<? extends IndexableElement> _xifexpression_3 = null;
                    EStructuralFeature _feature_3 = ((AllInstanceExpression)e).getType().getFeature();
                    if ((_feature_3 instanceof EReference)) {
                      _xifexpression_3 = TypedEdge.class;
                    } else {
                      _xifexpression_3 = ValueEdge.class;
                    }
                    _xifexpression_2 = _xifexpression_3;
                  }
                  final Class<? extends IndexableElement> componentType_1 = _xifexpression_2;
                  if (isReferenced) {
                    final String v_1 = a.declareSyntheticVariable(e, "allInstances");
                    ITreeAppendable _newLine_9 = a.newLine();
                    StringConcatenation _builder_20 = new StringConcatenation();
                    _builder_20.append("java.util.List<");
                    String _canonicalName_11 = componentType_1.getCanonicalName();
                    _builder_20.append(_canonicalName_11);
                    _builder_20.append("> ");
                    _builder_20.append(v_1);
                    _builder_20.append(" = ");
                    String _literal_4 = ((AllInstanceExpression)e).getType().getSide().getLiteral();
                    _builder_20.append(_literal_4);
                    _builder_20.append(".all");
                    String _simpleName_2 = componentType_1.getSimpleName();
                    _builder_20.append(_simpleName_2);
                    _builder_20.append("s(\"");
                    String _name_2 = ((AllInstanceExpression)e).getType().getType().getName();
                    _builder_20.append(_name_2);
                    _builder_20.append("\"");
                    {
                      EStructuralFeature _feature_4 = ((AllInstanceExpression)e).getType().getFeature();
                      boolean _tripleNotEquals_2 = (_feature_4 != null);
                      if (_tripleNotEquals_2) {
                        _builder_20.append(",\"");
                        String _name_3 = ((AllInstanceExpression)e).getType().getFeature().getName();
                        _builder_20.append(_name_3);
                        _builder_20.append("\"");
                      }
                    }
                    _builder_20.append(");");
                    _newLine_9.append(_builder_20);
                  } else {
                    ITreeAppendable _newLine_10 = a.newLine();
                    StringConcatenation _builder_21 = new StringConcatenation();
                    String _literal_5 = ((AllInstanceExpression)e).getType().getSide().getLiteral();
                    _builder_21.append(_literal_5);
                    _builder_21.append(".all");
                    String _simpleName_3 = componentType_1.getSimpleName();
                    _builder_21.append(_simpleName_3);
                    _builder_21.append("s(\"");
                    String _name_4 = ((AllInstanceExpression)e).getType().getType().getName();
                    _builder_21.append(_name_4);
                    _builder_21.append("\"");
                    {
                      EStructuralFeature _feature_5 = ((AllInstanceExpression)e).getType().getFeature();
                      boolean _tripleNotEquals_3 = (_feature_5 != null);
                      if (_tripleNotEquals_3) {
                        _builder_21.append(",\"");
                        String _name_5 = ((AllInstanceExpression)e).getType().getFeature().getName();
                        _builder_21.append(_name_5);
                        _builder_21.append("\"");
                      }
                    }
                    _builder_21.append(");");
                    _newLine_10.append(_builder_21);
                  }
                } else {
                  super.doInternalToJavaStatement(e, a, isReferenced);
                }
              }
            }
          }
        }
      }
    }
  }
  
  public SideEnum side(final ContextExpression expression) {
    SideEnum _xifexpression = null;
    if ((expression instanceof ContextVarExpression)) {
      _xifexpression = ((ContextVarExpression)expression).getSide();
    } else {
      SideEnum _xifexpression_1 = null;
      if ((expression instanceof ExpressionConversion)) {
        _xifexpression_1 = ((ExpressionConversion)expression).getSide();
      } else {
        SideEnum _xifexpression_2 = null;
        if ((expression instanceof NavigationExpression)) {
          _xifexpression_2 = this.side(((NavigationExpression)expression).getHost());
        } else {
          _xifexpression_2 = null;
        }
        _xifexpression_1 = _xifexpression_2;
      }
      _xifexpression = _xifexpression_1;
    }
    return _xifexpression;
  }
  
  @Override
  protected void internalToConvertedExpression(final XExpression e, final ITreeAppendable a) {
    if ((e instanceof ContextVarExpression)) {
      a.append(this.getVarName(e, a));
    } else {
      if ((e instanceof ExpressionConversion)) {
        a.append(this.getVarName(e, a));
      } else {
        if ((e instanceof NavigationExpression)) {
          a.append(this.getVarName(e, a));
        } else {
          if ((e instanceof ModificationExpression)) {
            a.append(this.getVarName(e, a));
          } else {
            if ((e instanceof ModificationExpressionBlock)) {
              final String lastResult = this.getVarName(e, a);
              StringConcatenation _builder = new StringConcatenation();
              _builder.append(lastResult);
              _builder.append(".get()");
              a.append(_builder);
            } else {
              if ((e instanceof NewInstanceExpression)) {
                final String v = this.getVarName(e, a);
                a.append(v);
              } else {
                if ((e instanceof AllInstanceExpression)) {
                  final String v_1 = this.getVarName(e, a);
                  a.append(v_1);
                } else {
                  super.internalToConvertedExpression(e, a);
                }
              }
            }
          }
        }
      }
    }
  }
  
  public ModificationExpressionBlock block(final XExpression e) {
    ModificationExpressionBlock _xifexpression = null;
    if ((e == null)) {
      _xifexpression = null;
    } else {
      ModificationExpressionBlock _xifexpression_1 = null;
      if ((e instanceof ModificationExpressionBlock)) {
        _xifexpression_1 = ((ModificationExpressionBlock)e);
      } else {
        EObject _eContainer = e.eContainer();
        _xifexpression_1 = this.block(((XExpression) _eContainer));
      }
      _xifexpression = _xifexpression_1;
    }
    return _xifexpression;
  }
}
