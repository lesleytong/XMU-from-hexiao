package edu.ustb.sei.mde.bxcore.dsl.jvmmodel;

import edu.ustb.sei.mde.bxcore.SourceType;
import edu.ustb.sei.mde.bxcore.dsl.bXCore.ContextExpression;
import edu.ustb.sei.mde.bxcore.dsl.bXCore.ContextVarExpression;
import edu.ustb.sei.mde.bxcore.dsl.bXCore.DeleteElementExpression;
import edu.ustb.sei.mde.bxcore.dsl.bXCore.EnforcementExpression;
import edu.ustb.sei.mde.bxcore.dsl.bXCore.ModificationExpressionBlock;
import edu.ustb.sei.mde.bxcore.dsl.bXCore.NavigationExpression;
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
import java.util.function.Consumer;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.compiler.XbaseCompiler;
import org.eclipse.xtext.xbase.compiler.output.ITreeAppendable;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Pair;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure2;
import org.eclipse.xtext.xbase.lib.StringExtensions;

@SuppressWarnings("all")
public class XmuCoreCompiler extends XbaseCompiler {
  public String patternAccessor(final Pattern p) {
    String _xtrycatchfinallyexpression = null;
    try {
      String _xblockexpression = null;
      {
        final InferData data = InferManager.getInferredTypeModel(p.eResource());
        String _xifexpression = null;
        if ((p instanceof PatternTypeLiteral)) {
          _xifexpression = ("getPattern_" + data.getLiteralMap().get(data).second);
        } else {
          String _xifexpression_1 = null;
          if ((p instanceof PatternDefinitionReference)) {
            _xifexpression_1 = StringExtensions.toFirstUpper(((PatternDefinitionReference)p).getPattern().getName());
          } else {
            _xifexpression_1 = "/* ERROR */";
          }
          _xifexpression = _xifexpression_1;
        }
        _xblockexpression = _xifexpression;
      }
      _xtrycatchfinallyexpression = _xblockexpression;
    } catch (final Throwable _t) {
      if (_t instanceof Exception) {
        _xtrycatchfinallyexpression = "/* ERROR */";
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
      if ((e instanceof NavigationExpression)) {
        this.doInternalToJavaStatement(((NavigationExpression)e).getHost(), a, true);
        a.newLine();
        final JvmTypeReference expectedType_1 = this.getType(e);
        final Pair<EClassifier, Boolean> ecoreType = ModelInferrerUtils.navEcoreType(((ContextExpression)e));
        if (isReferenced) {
          final String name_1 = a.declareSyntheticVariable(e, "_navExp");
          ITreeAppendable _newLine_1 = a.newLine();
          StringConcatenation _builder_3 = new StringConcatenation();
          String _qualifiedName_3 = expectedType_1.getQualifiedName();
          _builder_3.append(_qualifiedName_3);
          _builder_3.append(" ");
          _builder_3.append(name_1);
          _builder_3.append(" = ");
          String _canonicalName_2 = ExceptionSafeInferface.class.getCanonicalName();
          _builder_3.append(_canonicalName_2);
          _builder_3.append(".navigate(");
          String _literal_2 = this.side(((ContextExpression)e)).getLiteral();
          _builder_3.append(_literal_2);
          _builder_3.append(", ");
          _newLine_1.append(_builder_3);
          this.internalToJavaExpression(((NavigationExpression)e).getHost(), a);
          StringConcatenation _builder_4 = new StringConcatenation();
          _builder_4.append(", \"");
          String _pathName = ((NavigationExpression)e).getPathName();
          _builder_4.append(_pathName);
          _builder_4.append("\", ");
          EClassifier _key = ecoreType.getKey();
          _builder_4.append((_key instanceof EClass));
          _builder_4.append(", ");
          Boolean _value = ecoreType.getValue();
          _builder_4.append(_value);
          _builder_4.append(");");
          a.append(_builder_4);
        } else {
          ITreeAppendable _newLine_2 = a.newLine();
          StringConcatenation _builder_5 = new StringConcatenation();
          String _canonicalName_3 = ExceptionSafeInferface.class.getCanonicalName();
          _builder_5.append(_canonicalName_3);
          _builder_5.append(".navigate(");
          String _literal_3 = this.side(((ContextExpression)e)).getLiteral();
          _builder_5.append(_literal_3);
          _builder_5.append(", ");
          _newLine_2.append(_builder_5);
          this.internalToJavaExpression(((NavigationExpression)e).getHost(), a);
          StringConcatenation _builder_6 = new StringConcatenation();
          _builder_6.append(", \"");
          String _pathName_1 = ((NavigationExpression)e).getPathName();
          _builder_6.append(_pathName_1);
          _builder_6.append("\", ");
          EClassifier _key_1 = ecoreType.getKey();
          _builder_6.append((_key_1 instanceof EClass));
          _builder_6.append(", ");
          Boolean _value_1 = ecoreType.getValue();
          _builder_6.append(_value_1);
          _builder_6.append(");");
          a.append(_builder_6);
        }
      } else {
        if ((e instanceof ModificationExpressionBlock)) {
          final Consumer<XExpression> _function = (XExpression me) -> {
            this.internalToJavaStatement(me, a, true);
          };
          ((ModificationExpressionBlock)e).getExpressions().forEach(_function);
          if (isReferenced) {
            final String v = a.declareSyntheticVariable(e, "_modRes");
            StringConcatenation _builder_7 = new StringConcatenation();
            String _canonicalName_4 = SourceType.class.getCanonicalName();
            _builder_7.append(_canonicalName_4);
            _builder_7.append(" ");
            _builder_7.append(v);
            _builder_7.append(" =");
            a.append(_builder_7);
            this.internalToJavaExpression(e, a);
            StringConcatenation _builder_8 = new StringConcatenation();
            _builder_8.append(";");
            a.append(_builder_8);
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
          if ((e instanceof EnforcementExpression)) {
            EObject _eContainer = ((EnforcementExpression)e).eContainer();
            final ModificationExpressionBlock block = ((ModificationExpressionBlock) _eContainer);
            final int idx = block.getExpressions().indexOf(e);
            final Consumer<ValueMapping> _function_1 = (ValueMapping it) -> {
              this.internalToJavaStatement(it.getExpression(), a, true);
            };
            ((EnforcementExpression)e).getValueMappings().forEach(_function_1);
            final String cur = a.declareSyntheticVariable(e, "_mod");
            String _xifexpression = null;
            if ((idx == 0)) {
              String _xblockexpression = null;
              {
                final String init = a.declareSyntheticVariable(e, "_mod");
                ITreeAppendable _newLine_3 = a.newLine();
                StringConcatenation _builder_11 = new StringConcatenation();
                String _canonicalName_5 = ContextGraph.GraphModification.class.getCanonicalName();
                _builder_11.append(_canonicalName_5);
                _builder_11.append(" ");
                _builder_11.append(init);
                _builder_11.append(" = source.modification();");
                _newLine_3.append(_builder_11);
                _xblockexpression = init;
              }
              _xifexpression = _xblockexpression;
            } else {
              _xifexpression = this.getVarName(block.getExpressions().get((idx - 1)), a);
            }
            final String prev = _xifexpression;
            ITreeAppendable _newLine_3 = a.newLine();
            StringConcatenation _builder_11 = new StringConcatenation();
            String _canonicalName_5 = ContextGraph.GraphModification.class.getCanonicalName();
            _builder_11.append(_canonicalName_5);
            _builder_11.append(" ");
            _builder_11.append(cur);
            _builder_11.append(" = ");
            _builder_11.append(prev);
            _builder_11.append(".enforce(");
            String _patternAccessor = this.patternAccessor(((EnforcementExpression)e).getPattern());
            _builder_11.append(_patternAccessor);
            _builder_11.append("(), new edu.ustb.sei.mde.structure.Tuple2[] {");
            _newLine_3.append(_builder_11);
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
          } else {
            if ((e instanceof DeleteElementExpression)) {
              EObject _eContainer_1 = ((DeleteElementExpression)e).eContainer();
              final ModificationExpressionBlock block_1 = ((ModificationExpressionBlock) _eContainer_1);
              final int idx_1 = block_1.getExpressions().indexOf(e);
              final String cur_1 = a.declareSyntheticVariable(e, "_mod");
              String _xifexpression_1 = null;
              if ((idx_1 == 0)) {
                String _xblockexpression_1 = null;
                {
                  final String init = a.declareSyntheticVariable(e, "_mod");
                  ITreeAppendable _newLine_4 = a.newLine();
                  StringConcatenation _builder_13 = new StringConcatenation();
                  String _canonicalName_6 = ContextGraph.GraphModification.class.getCanonicalName();
                  _builder_13.append(_canonicalName_6);
                  _builder_13.append(" ");
                  _builder_13.append(init);
                  _builder_13.append(" = source.modification();");
                  _newLine_4.append(_builder_13);
                  _xblockexpression_1 = init;
                }
                _xifexpression_1 = _xblockexpression_1;
              } else {
                _xifexpression_1 = this.getVarName(block_1.getExpressions().get((idx_1 - 1)), a);
              }
              final String prev_1 = _xifexpression_1;
              this.internalToJavaStatement(((DeleteElementExpression)e).getElement(), a, true);
              ITreeAppendable _newLine_4 = a.newLine();
              StringConcatenation _builder_13 = new StringConcatenation();
              String _canonicalName_6 = ContextGraph.GraphModification.class.getCanonicalName();
              _builder_13.append(_canonicalName_6);
              _builder_13.append(" ");
              _builder_13.append(cur_1);
              _builder_13.append(" = ");
              _builder_13.append(prev_1);
              _builder_13.append(".remove(");
              _newLine_4.append(_builder_13);
              this.internalToJavaExpression(((DeleteElementExpression)e).getElement(), a);
              StringConcatenation _builder_14 = new StringConcatenation();
              _builder_14.append(");");
              a.append(_builder_14).newLine();
            } else {
              super.doInternalToJavaStatement(e, a, isReferenced);
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
      if ((expression instanceof NavigationExpression)) {
        _xifexpression_1 = this.side(((NavigationExpression)expression).getHost());
      } else {
        _xifexpression_1 = null;
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
      if ((e instanceof NavigationExpression)) {
        a.append(this.getVarName(e, a));
      } else {
        if (((e instanceof EnforcementExpression) || (e instanceof DeleteElementExpression))) {
          a.append(this.getVarName(e, a));
        } else {
          if ((e instanceof ModificationExpressionBlock)) {
            final String lastResult = this.getVarName(IterableExtensions.<XExpression>last(((ModificationExpressionBlock)e).getExpressions()), a);
            StringConcatenation _builder = new StringConcatenation();
            _builder.append(lastResult);
            _builder.append(".get()");
            a.append(_builder);
          } else {
            super.internalToConvertedExpression(e, a);
          }
        }
      }
    }
  }
}
