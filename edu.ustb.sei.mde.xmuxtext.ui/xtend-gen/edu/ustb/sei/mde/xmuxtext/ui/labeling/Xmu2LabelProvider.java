/**
 * generated by Xtext 2.10.0
 */
package edu.ustb.sei.mde.xmuxtext.ui.labeling;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import edu.ustb.sei.mde.xmu2.EntryPoint;
import edu.ustb.sei.mde.xmu2.ModelRule;
import edu.ustb.sei.mde.xmu2.TransformationModel;
import edu.ustb.sei.mde.xmu2.expression.BooleanAndExpression;
import edu.ustb.sei.mde.xmu2.expression.BooleanLiteralExpression;
import edu.ustb.sei.mde.xmu2.expression.BooleanOrExpression;
import edu.ustb.sei.mde.xmu2.expression.IntegerLiteralExpression;
import edu.ustb.sei.mde.xmu2.expression.LoopPath;
import edu.ustb.sei.mde.xmu2.expression.PositionPath;
import edu.ustb.sei.mde.xmu2.expression.RelationalExpression;
import edu.ustb.sei.mde.xmu2.expression.StringLiteralExpression;
import edu.ustb.sei.mde.xmu2.expression.UnaryExpression;
import edu.ustb.sei.mde.xmu2.expression.VariableExpression;
import edu.ustb.sei.mde.xmu2.statement.ActionType;
import edu.ustb.sei.mde.xmu2.statement.UpdateClause;
import edu.ustb.sei.mde.xmu2common.LoopOperator;
import edu.ustb.sei.mde.xmu2common.NamedElement;
import edu.ustb.sei.mde.xmu2common.PositionOperator;
import edu.ustb.sei.mde.xmu2common.RelationalOperator;
import edu.ustb.sei.mde.xmu2common.UnaryOperator;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.xtext.ui.label.DefaultEObjectLabelProvider;

/**
 * Provides labels for EObjects.
 * 
 * See https://www.eclipse.org/Xtext/documentation/304_ide_concepts.html#label-provider
 */
@SuppressWarnings("all")
public class Xmu2LabelProvider extends DefaultEObjectLabelProvider {
  @Inject
  public Xmu2LabelProvider(final AdapterFactoryLabelProvider delegate) {
    super(delegate);
  }
  
  public Object text(final EObject e) {
    Object _xifexpression = null;
    if ((e instanceof TransformationModel)) {
      String _name = ((TransformationModel) e).getName();
      return ("Transformation " + _name);
    } else {
      Object _xifexpression_1 = null;
      if ((e instanceof EntryPoint)) {
        ModelRule _rule = ((EntryPoint)e).getRule();
        String _name_1 = _rule.getName();
        return ("Entry point " + _name_1);
      } else {
        Object _xifexpression_2 = null;
        if ((e instanceof BooleanOrExpression)) {
          return "OR";
        } else {
          Object _xifexpression_3 = null;
          if ((e instanceof BooleanAndExpression)) {
            return "AND";
          } else {
            Object _xifexpression_4 = null;
            if ((e instanceof RelationalExpression)) {
              RelationalOperator _operator = ((RelationalExpression)e).getOperator();
              if (_operator != null) {
                switch (_operator) {
                  case EQUAL:
                    return "=";
                  case LESS:
                    return "<";
                  case LESS_EQUAL:
                    return "<=";
                  case GREATER:
                    return ">";
                  case GREATER_EQUAL:
                    return ">=";
                  default:
                    break;
                }
              }
            } else {
              Object _xifexpression_5 = null;
              if ((e instanceof UnaryExpression)) {
                UnaryOperator _operator_1 = ((UnaryExpression)e).getOperator();
                boolean _equals = Objects.equal(_operator_1, UnaryOperator.NOT);
                if (_equals) {
                  return "NOT";
                } else {
                  return "MINUS";
                }
              } else {
                Object _xifexpression_6 = null;
                if ((e instanceof LoopPath)) {
                  LoopOperator _operator_2 = ((LoopPath)e).getOperator();
                  return _operator_2.getLiteral();
                } else {
                  Object _xifexpression_7 = null;
                  if ((e instanceof PositionPath)) {
                    PositionOperator _type = ((PositionPath)e).getType();
                    return _type.getLiteral();
                  } else {
                    Object _xifexpression_8 = null;
                    if ((e instanceof UpdateClause)) {
                      ActionType _type_1 = ((UpdateClause)e).getType();
                      return _type_1.getLiteral();
                    } else {
                      Object _xifexpression_9 = null;
                      if ((e instanceof VariableExpression)) {
                        String _variable = ((VariableExpression)e).getVariable();
                        return ("var " + _variable);
                      } else {
                        Object _xifexpression_10 = null;
                        if ((e instanceof StringLiteralExpression)) {
                          String _value = ((StringLiteralExpression)e).getValue();
                          String _plus = ("\"" + _value);
                          _xifexpression_10 = (_plus + "\"");
                        } else {
                          Object _xifexpression_11 = null;
                          if ((e instanceof IntegerLiteralExpression)) {
                            _xifexpression_11 = Integer.valueOf(((IntegerLiteralExpression)e).getValue());
                          } else {
                            boolean _xifexpression_12 = false;
                            if ((e instanceof BooleanLiteralExpression)) {
                              _xifexpression_12 = ((BooleanLiteralExpression)e).isValue();
                            } else {
                              if ((e instanceof NamedElement)) {
                                EClass _eClass = ((NamedElement)e).eClass();
                                String _name_2 = _eClass.getName();
                                String _plus_1 = (_name_2 + " ");
                                String _name_3 = ((NamedElement)e).getName();
                                return (_plus_1 + _name_3);
                              } else {
                                EClass _eClass_1 = e.eClass();
                                return _eClass_1.getName();
                              }
                            }
                            _xifexpression_11 = Boolean.valueOf(_xifexpression_12);
                          }
                          _xifexpression_10 = ((Object)_xifexpression_11);
                        }
                        _xifexpression_9 = ((Object)_xifexpression_10);
                      }
                      _xifexpression_8 = ((Object)_xifexpression_9);
                    }
                    _xifexpression_7 = ((Object)_xifexpression_8);
                  }
                  _xifexpression_6 = ((Object)_xifexpression_7);
                }
                _xifexpression_5 = ((Object)_xifexpression_6);
              }
              _xifexpression_4 = ((Object)_xifexpression_5);
            }
            _xifexpression_3 = ((Object)_xifexpression_4);
          }
          _xifexpression_2 = ((Object)_xifexpression_3);
        }
        _xifexpression_1 = ((Object)_xifexpression_2);
      }
      _xifexpression = ((Object)_xifexpression_1);
    }
    return _xifexpression;
  }
}
