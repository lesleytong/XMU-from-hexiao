package edu.ustb.sei.mde.bxcore.dsl.jvmmodel;

import edu.ustb.sei.mde.bxcore.SourceType;
import edu.ustb.sei.mde.bxcore.dsl.bXCore.AllInstanceExpression;
import edu.ustb.sei.mde.bxcore.dsl.bXCore.BXCorePackage;
import edu.ustb.sei.mde.bxcore.dsl.bXCore.ContextExpression;
import edu.ustb.sei.mde.bxcore.dsl.bXCore.ContextVarExpression;
import edu.ustb.sei.mde.bxcore.dsl.bXCore.DeleteElementExpression;
import edu.ustb.sei.mde.bxcore.dsl.bXCore.EnforcementExpression;
import edu.ustb.sei.mde.bxcore.dsl.bXCore.ExpressionConversion;
import edu.ustb.sei.mde.bxcore.dsl.bXCore.ModificationExpressionBlock;
import edu.ustb.sei.mde.bxcore.dsl.bXCore.NavigationExpression;
import edu.ustb.sei.mde.bxcore.dsl.bXCore.NewInstanceExpression;
import edu.ustb.sei.mde.bxcore.dsl.bXCore.SideEnum;
import edu.ustb.sei.mde.bxcore.dsl.bXCore.ValueMapping;
import edu.ustb.sei.mde.bxcore.dsl.jvmmodel.ModelInferrerUtils;
import edu.ustb.sei.mde.bxcore.dsl.structure.TupleType;
import edu.ustb.sei.mde.bxcore.structures.GraphModification;
import edu.ustb.sei.mde.bxcore.structures.Index;
import edu.ustb.sei.mde.graph.typedGraph.TypedEdge;
import edu.ustb.sei.mde.graph.typedGraph.TypedNode;
import edu.ustb.sei.mde.graph.typedGraph.ValueEdge;
import edu.ustb.sei.mde.structure.Tuple3;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.diagnostics.Severity;
import org.eclipse.xtext.validation.EObjectDiagnosticImpl;
import org.eclipse.xtext.xbase.XAbstractFeatureCall;
import org.eclipse.xtext.xbase.XAssignment;
import org.eclipse.xtext.xbase.XBasicForLoopExpression;
import org.eclipse.xtext.xbase.XBlockExpression;
import org.eclipse.xtext.xbase.XBooleanLiteral;
import org.eclipse.xtext.xbase.XCastedExpression;
import org.eclipse.xtext.xbase.XClosure;
import org.eclipse.xtext.xbase.XConstructorCall;
import org.eclipse.xtext.xbase.XDoWhileExpression;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XForLoopExpression;
import org.eclipse.xtext.xbase.XIfExpression;
import org.eclipse.xtext.xbase.XInstanceOfExpression;
import org.eclipse.xtext.xbase.XListLiteral;
import org.eclipse.xtext.xbase.XNullLiteral;
import org.eclipse.xtext.xbase.XNumberLiteral;
import org.eclipse.xtext.xbase.XReturnExpression;
import org.eclipse.xtext.xbase.XSetLiteral;
import org.eclipse.xtext.xbase.XStringLiteral;
import org.eclipse.xtext.xbase.XSwitchExpression;
import org.eclipse.xtext.xbase.XSynchronizedExpression;
import org.eclipse.xtext.xbase.XThrowExpression;
import org.eclipse.xtext.xbase.XTryCatchFinallyExpression;
import org.eclipse.xtext.xbase.XTypeLiteral;
import org.eclipse.xtext.xbase.XVariableDeclaration;
import org.eclipse.xtext.xbase.XWhileExpression;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Pair;
import org.eclipse.xtext.xbase.typesystem.computation.ITypeComputationResult;
import org.eclipse.xtext.xbase.typesystem.computation.ITypeComputationState;
import org.eclipse.xtext.xbase.typesystem.computation.XbaseTypeComputer;
import org.eclipse.xtext.xbase.typesystem.conformance.ConformanceFlags;
import org.eclipse.xtext.xbase.typesystem.references.ITypeReferenceOwner;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.ParameterizedTypeReference;
import org.eclipse.xtext.xbase.validation.IssueCodes;

@SuppressWarnings("all")
public class XmuCoreTypeComputer extends XbaseTypeComputer {
  protected void _computeTypes(final ExpressionConversion cvar, final ITypeComputationState state) {
    final ITypeComputationResult valueTypeResult = state.withNonVoidExpectation().computeTypes(cvar.getExpression());
    state.acceptActualType(valueTypeResult.getActualExpressionType());
  }
  
  protected void _computeTypes(final ContextVarExpression cvar, final ITypeComputationState state) {
    final SideEnum side = cvar.getSide();
    final String varName = cvar.getName();
    final TupleType tupleType = ModelInferrerUtils.context(cvar, side);
    if ((tupleType == null)) {
      state.acceptActualType(this.getRawTypeForName(Object.class, state));
    } else {
      final Function1<Tuple3<String, Object, Boolean>, Boolean> _function = (Tuple3<String, Object, Boolean> it) -> {
        return Boolean.valueOf(it.first.equals(varName));
      };
      final Tuple3<String, Object, Boolean> typeDef = IterableExtensions.<Tuple3<String, Object, Boolean>>findFirst(tupleType.tuples, _function);
      if ((typeDef == null)) {
        String _string = EcoreUtil.getURI(cvar).toString();
        EObjectDiagnosticImpl _eObjectDiagnosticImpl = new EObjectDiagnosticImpl(Severity.ERROR, 
          IssueCodes.INVALID_IDENTIFIER, ((varName + " is undefined in the ") + side), cvar, BXCorePackage.Literals.CONTEXT_VAR_EXPRESSION__NAME, (-1), new String[] { _string });
        state.addDiagnostic(_eObjectDiagnosticImpl);
      } else {
        final Object type = typeDef.second;
        final boolean contextOnly = ModelInferrerUtils.isContextOnly(cvar);
        final Boolean isList = typeDef.third;
        state.acceptActualType(this.actualType(contextOnly, type, state, (isList).booleanValue()));
      }
    }
  }
  
  protected LightweightTypeReference actualType(final boolean contextOnly, final Object type, final ITypeComputationState state, final boolean isList) {
    LightweightTypeReference _xblockexpression = null;
    {
      LightweightTypeReference _xifexpression = null;
      if (contextOnly) {
        LightweightTypeReference _xifexpression_1 = null;
        if ((type instanceof EClass)) {
          _xifexpression_1 = this.getRawTypeForName(Index.class, state);
        } else {
          LightweightTypeReference _xifexpression_2 = null;
          if ((type instanceof EEnum)) {
            _xifexpression_2 = this.getRawTypeForName(String.class, state);
          } else {
            LightweightTypeReference _xifexpression_3 = null;
            if ((type instanceof EDataType)) {
              _xifexpression_3 = this.getRawTypeForName(((EDataType)type).getInstanceClass(), state);
            } else {
              LightweightTypeReference _xifexpression_4 = null;
              if ((type instanceof EReference)) {
                _xifexpression_4 = this.getRawTypeForName(Index.class, state);
              } else {
                LightweightTypeReference _xifexpression_5 = null;
                if ((type instanceof EAttribute)) {
                  _xifexpression_5 = this.getRawTypeForName(Index.class, state);
                } else {
                  _xifexpression_5 = this.getRawTypeForName(Object.class, state);
                }
                _xifexpression_4 = _xifexpression_5;
              }
              _xifexpression_3 = _xifexpression_4;
            }
            _xifexpression_2 = _xifexpression_3;
          }
          _xifexpression_1 = _xifexpression_2;
        }
        _xifexpression = _xifexpression_1;
      } else {
        LightweightTypeReference _xifexpression_6 = null;
        if ((type instanceof EClass)) {
          _xifexpression_6 = this.getRawTypeForName(TypedNode.class, state);
        } else {
          LightweightTypeReference _xifexpression_7 = null;
          if ((type instanceof EEnum)) {
            _xifexpression_7 = this.getRawTypeForName(String.class, state);
          } else {
            LightweightTypeReference _xifexpression_8 = null;
            if ((type instanceof EDataType)) {
              _xifexpression_8 = this.getRawTypeForName(((EDataType)type).getInstanceClass(), state);
            } else {
              LightweightTypeReference _xifexpression_9 = null;
              if ((type instanceof EReference)) {
                _xifexpression_9 = this.getRawTypeForName(TypedEdge.class, state);
              } else {
                LightweightTypeReference _xifexpression_10 = null;
                if ((type instanceof EAttribute)) {
                  _xifexpression_10 = this.getRawTypeForName(ValueEdge.class, state);
                } else {
                  _xifexpression_10 = this.getRawTypeForName(Object.class, state);
                }
                _xifexpression_9 = _xifexpression_10;
              }
              _xifexpression_8 = _xifexpression_9;
            }
            _xifexpression_7 = _xifexpression_8;
          }
          _xifexpression_6 = _xifexpression_7;
        }
        _xifexpression = _xifexpression_6;
      }
      final LightweightTypeReference elementType = _xifexpression;
      LightweightTypeReference _xifexpression_11 = null;
      if (isList) {
        ParameterizedTypeReference _xblockexpression_1 = null;
        {
          final ITypeReferenceOwner owner = state.getReferenceOwner();
          final ParameterizedTypeReference array = owner.newParameterizedTypeReference(owner.newReferenceTo(List.class).getType());
          array.addTypeArgument(elementType);
          _xblockexpression_1 = array;
        }
        _xifexpression_11 = _xblockexpression_1;
      } else {
        _xifexpression_11 = elementType;
      }
      _xblockexpression = _xifexpression_11;
    }
    return _xblockexpression;
  }
  
  protected void _computeTypes(final NavigationExpression pathExp, final ITypeComputationState state) {
    final ContextExpression host = pathExp.getHost();
    final String path = pathExp.getPathName();
    final ITypeComputationResult hostType = state.withNonVoidExpectation().computeTypes(host);
    final Pair<Object, Boolean> ecoreType = ModelInferrerUtils.navEcoreType(pathExp);
    if ((ecoreType == null)) {
      String _string = EcoreUtil.getURI(pathExp).toString();
      EObjectDiagnosticImpl _eObjectDiagnosticImpl = new EObjectDiagnosticImpl(Severity.ERROR, IssueCodes.INVALID_IDENTIFIER, ("cannot navigate to " + path), pathExp, BXCorePackage.Literals.NAVIGATION_EXPRESSION__PATH_NAME, (-1), 
        new String[] { _string });
      state.addDiagnostic(_eObjectDiagnosticImpl);
    } else {
      final ITypeReferenceOwner owner = state.getReferenceOwner();
      LightweightTypeReference _xifexpression = null;
      Object _key = ecoreType.getKey();
      if ((_key instanceof EClass)) {
        _xifexpression = this.getRawTypeForName(TypedNode.class, state);
      } else {
        LightweightTypeReference _xifexpression_1 = null;
        Object _key_1 = ecoreType.getKey();
        if ((_key_1 instanceof EEnum)) {
          _xifexpression_1 = this.getRawTypeForName(String.class, state);
        } else {
          LightweightTypeReference _xifexpression_2 = null;
          Object _key_2 = ecoreType.getKey();
          if ((_key_2 instanceof EDataType)) {
            Object _key_3 = ecoreType.getKey();
            _xifexpression_2 = this.getRawTypeForName(((EDataType) _key_3).getInstanceClass(), state);
          } else {
            LightweightTypeReference _xifexpression_3 = null;
            Object _key_4 = ecoreType.getKey();
            if ((_key_4 instanceof EAttribute)) {
              _xifexpression_3 = this.getRawTypeForName(ValueEdge.class, state);
            } else {
              LightweightTypeReference _xifexpression_4 = null;
              Object _key_5 = ecoreType.getKey();
              if ((_key_5 instanceof EReference)) {
                _xifexpression_4 = this.getRawTypeForName(TypedEdge.class, state);
              } else {
                _xifexpression_4 = this.getRawTypeForName(Object.class, state);
              }
              _xifexpression_3 = _xifexpression_4;
            }
            _xifexpression_2 = _xifexpression_3;
          }
          _xifexpression_1 = _xifexpression_2;
        }
        _xifexpression = _xifexpression_1;
      }
      final LightweightTypeReference componmentType = _xifexpression;
      LightweightTypeReference _xifexpression_5 = null;
      Boolean _value = ecoreType.getValue();
      if ((_value).booleanValue()) {
        ParameterizedTypeReference _xblockexpression = null;
        {
          final ParameterizedTypeReference array = owner.newParameterizedTypeReference(owner.newReferenceTo(List.class).getType());
          array.addTypeArgument(componmentType);
          _xblockexpression = array;
        }
        _xifexpression_5 = _xblockexpression;
      } else {
        _xifexpression_5 = componmentType;
      }
      final LightweightTypeReference type = _xifexpression_5;
      state.acceptActualType(type);
    }
  }
  
  protected void _computeTypes(final ModificationExpressionBlock modification, final ITypeComputationState state) {
    final Consumer<XExpression> _function = (XExpression e) -> {
      state.withoutExpectation().computeTypes(e);
    };
    modification.getExpressions().forEach(_function);
    state.acceptActualType(this.getRawTypeForName(SourceType.class, state), ConformanceFlags.NO_IMPLICIT_RETURN);
  }
  
  protected void _computeTypes(final EnforcementExpression modification, final ITypeComputationState state) {
    final Consumer<ValueMapping> _function = (ValueMapping e) -> {
      state.withNonVoidExpectation().computeTypes(e.getExpression());
    };
    modification.getValueMappings().forEach(_function);
    state.acceptActualType(this.getRawTypeForName(GraphModification.class, state));
  }
  
  protected void _computeTypes(final DeleteElementExpression modification, final ITypeComputationState state) {
    state.withNonVoidExpectation().computeTypes(modification.getElement());
    state.acceptActualType(this.getRawTypeForName(GraphModification.class, state));
  }
  
  protected void _computeTypes(final NewInstanceExpression instance, final ITypeComputationState state) {
    XExpression _size = instance.getSize();
    boolean _tripleNotEquals = (_size != null);
    if (_tripleNotEquals) {
      state.withExpectation(this.getRawTypeForName(int.class, state)).computeTypes(instance.getSize());
    }
    LightweightTypeReference _xifexpression = null;
    EStructuralFeature _feature = instance.getType().getFeature();
    boolean _tripleEquals = (_feature == null);
    if (_tripleEquals) {
      _xifexpression = this.getRawTypeForName(TypedNode.class, state);
    } else {
      LightweightTypeReference _xifexpression_1 = null;
      EStructuralFeature _feature_1 = instance.getType().getFeature();
      if ((_feature_1 instanceof EAttribute)) {
        _xifexpression_1 = this.getRawTypeForName(ValueEdge.class, state);
      } else {
        _xifexpression_1 = this.getRawTypeForName(TypedEdge.class, state);
      }
      _xifexpression = _xifexpression_1;
    }
    final LightweightTypeReference elementType = _xifexpression;
    XExpression _size_1 = instance.getSize();
    boolean _tripleNotEquals_1 = (_size_1 != null);
    if (_tripleNotEquals_1) {
      final ITypeReferenceOwner owner = state.getReferenceOwner();
      final ParameterizedTypeReference array = owner.newParameterizedTypeReference(owner.newReferenceTo(List.class).getType());
      array.addTypeArgument(elementType);
      state.acceptActualType(array);
    } else {
      state.acceptActualType(elementType);
    }
  }
  
  protected void _computeTypes(final AllInstanceExpression instance, final ITypeComputationState state) {
    LightweightTypeReference _xifexpression = null;
    EStructuralFeature _feature = instance.getType().getFeature();
    boolean _tripleEquals = (_feature == null);
    if (_tripleEquals) {
      _xifexpression = this.getRawTypeForName(TypedNode.class, state);
    } else {
      LightweightTypeReference _xifexpression_1 = null;
      EStructuralFeature _feature_1 = instance.getType().getFeature();
      if ((_feature_1 instanceof EAttribute)) {
        _xifexpression_1 = this.getRawTypeForName(ValueEdge.class, state);
      } else {
        _xifexpression_1 = this.getRawTypeForName(TypedEdge.class, state);
      }
      _xifexpression = _xifexpression_1;
    }
    final LightweightTypeReference elementType = _xifexpression;
    final ITypeReferenceOwner owner = state.getReferenceOwner();
    final ParameterizedTypeReference array = owner.newParameterizedTypeReference(owner.newReferenceTo(List.class).getType());
    array.addTypeArgument(elementType);
    state.acceptActualType(array);
  }
  
  public void computeTypes(final XExpression cvar, final ITypeComputationState state) {
    if (cvar instanceof ContextVarExpression) {
      _computeTypes((ContextVarExpression)cvar, state);
      return;
    } else if (cvar instanceof ExpressionConversion) {
      _computeTypes((ExpressionConversion)cvar, state);
      return;
    } else if (cvar instanceof DeleteElementExpression) {
      _computeTypes((DeleteElementExpression)cvar, state);
      return;
    } else if (cvar instanceof EnforcementExpression) {
      _computeTypes((EnforcementExpression)cvar, state);
      return;
    } else if (cvar instanceof NavigationExpression) {
      _computeTypes((NavigationExpression)cvar, state);
      return;
    } else if (cvar instanceof XAssignment) {
      _computeTypes((XAssignment)cvar, state);
      return;
    } else if (cvar instanceof XDoWhileExpression) {
      _computeTypes((XDoWhileExpression)cvar, state);
      return;
    } else if (cvar instanceof XListLiteral) {
      _computeTypes((XListLiteral)cvar, state);
      return;
    } else if (cvar instanceof XSetLiteral) {
      _computeTypes((XSetLiteral)cvar, state);
      return;
    } else if (cvar instanceof XWhileExpression) {
      _computeTypes((XWhileExpression)cvar, state);
      return;
    } else if (cvar instanceof AllInstanceExpression) {
      _computeTypes((AllInstanceExpression)cvar, state);
      return;
    } else if (cvar instanceof ModificationExpressionBlock) {
      _computeTypes((ModificationExpressionBlock)cvar, state);
      return;
    } else if (cvar instanceof NewInstanceExpression) {
      _computeTypes((NewInstanceExpression)cvar, state);
      return;
    } else if (cvar instanceof XAbstractFeatureCall) {
      _computeTypes((XAbstractFeatureCall)cvar, state);
      return;
    } else if (cvar instanceof XBasicForLoopExpression) {
      _computeTypes((XBasicForLoopExpression)cvar, state);
      return;
    } else if (cvar instanceof XBlockExpression) {
      _computeTypes((XBlockExpression)cvar, state);
      return;
    } else if (cvar instanceof XBooleanLiteral) {
      _computeTypes((XBooleanLiteral)cvar, state);
      return;
    } else if (cvar instanceof XCastedExpression) {
      _computeTypes((XCastedExpression)cvar, state);
      return;
    } else if (cvar instanceof XClosure) {
      _computeTypes((XClosure)cvar, state);
      return;
    } else if (cvar instanceof XConstructorCall) {
      _computeTypes((XConstructorCall)cvar, state);
      return;
    } else if (cvar instanceof XForLoopExpression) {
      _computeTypes((XForLoopExpression)cvar, state);
      return;
    } else if (cvar instanceof XIfExpression) {
      _computeTypes((XIfExpression)cvar, state);
      return;
    } else if (cvar instanceof XInstanceOfExpression) {
      _computeTypes((XInstanceOfExpression)cvar, state);
      return;
    } else if (cvar instanceof XNullLiteral) {
      _computeTypes((XNullLiteral)cvar, state);
      return;
    } else if (cvar instanceof XNumberLiteral) {
      _computeTypes((XNumberLiteral)cvar, state);
      return;
    } else if (cvar instanceof XReturnExpression) {
      _computeTypes((XReturnExpression)cvar, state);
      return;
    } else if (cvar instanceof XStringLiteral) {
      _computeTypes((XStringLiteral)cvar, state);
      return;
    } else if (cvar instanceof XSwitchExpression) {
      _computeTypes((XSwitchExpression)cvar, state);
      return;
    } else if (cvar instanceof XSynchronizedExpression) {
      _computeTypes((XSynchronizedExpression)cvar, state);
      return;
    } else if (cvar instanceof XThrowExpression) {
      _computeTypes((XThrowExpression)cvar, state);
      return;
    } else if (cvar instanceof XTryCatchFinallyExpression) {
      _computeTypes((XTryCatchFinallyExpression)cvar, state);
      return;
    } else if (cvar instanceof XTypeLiteral) {
      _computeTypes((XTypeLiteral)cvar, state);
      return;
    } else if (cvar instanceof XVariableDeclaration) {
      _computeTypes((XVariableDeclaration)cvar, state);
      return;
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(cvar, state).toString());
    }
  }
}
