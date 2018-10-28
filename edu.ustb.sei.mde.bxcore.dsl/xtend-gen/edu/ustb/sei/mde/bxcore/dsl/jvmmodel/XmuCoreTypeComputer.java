package edu.ustb.sei.mde.bxcore.dsl.jvmmodel;

import edu.ustb.sei.mde.bxcore.SourceType;
import edu.ustb.sei.mde.bxcore.dsl.bXCore.AnnotatedVariableExpression;
import edu.ustb.sei.mde.bxcore.dsl.bXCore.BXCorePackage;
import edu.ustb.sei.mde.bxcore.dsl.bXCore.ContextExpression;
import edu.ustb.sei.mde.bxcore.dsl.bXCore.ContextVarExpression;
import edu.ustb.sei.mde.bxcore.dsl.bXCore.DeleteElementExpression;
import edu.ustb.sei.mde.bxcore.dsl.bXCore.EnforcementExpression;
import edu.ustb.sei.mde.bxcore.dsl.bXCore.ModificationExpressionBlock;
import edu.ustb.sei.mde.bxcore.dsl.bXCore.NavigationExpression;
import edu.ustb.sei.mde.bxcore.dsl.bXCore.SideEnum;
import edu.ustb.sei.mde.bxcore.dsl.bXCore.ValueMapping;
import edu.ustb.sei.mde.bxcore.dsl.jvmmodel.ModelInferrerUtils;
import edu.ustb.sei.mde.bxcore.dsl.structure.TupleType;
import edu.ustb.sei.mde.bxcore.structures.ContextGraph;
import edu.ustb.sei.mde.bxcore.structures.Index;
import edu.ustb.sei.mde.graph.typedGraph.TypedEdge;
import edu.ustb.sei.mde.graph.typedGraph.TypedNode;
import edu.ustb.sei.mde.graph.typedGraph.ValueEdge;
import edu.ustb.sei.mde.structure.Tuple2;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EReference;
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
  protected void _computeTypes(final AnnotatedVariableExpression cvar, final ITypeComputationState state) {
    final ITypeComputationResult valueTypeResult = state.withNonVoidExpectation().computeTypes(cvar.getValue());
    state.acceptActualType(valueTypeResult.getActualExpressionType());
  }
  
  protected void _computeTypes(final ContextVarExpression cvar, final ITypeComputationState state) {
    final SideEnum side = cvar.getSide();
    final String varName = cvar.getName();
    final TupleType tupleType = ModelInferrerUtils.context(cvar, side);
    if ((tupleType == null)) {
      state.acceptActualType(this.getRawTypeForName(Object.class, state));
    } else {
      final Function1<Tuple2<String, Object>, Boolean> _function = (Tuple2<String, Object> it) -> {
        return Boolean.valueOf(it.first.equals(varName));
      };
      final Tuple2<String, Object> typeDef = IterableExtensions.<Tuple2<String, Object>>findFirst(tupleType.tuples, _function);
      if ((typeDef == null)) {
        String _string = EcoreUtil.getURI(cvar).toString();
        EObjectDiagnosticImpl _eObjectDiagnosticImpl = new EObjectDiagnosticImpl(Severity.ERROR, 
          IssueCodes.INVALID_IDENTIFIER, ((varName + " is undefined in the ") + side), cvar, BXCorePackage.Literals.CONTEXT_VAR_EXPRESSION__NAME, (-1), new String[] { _string });
        state.addDiagnostic(_eObjectDiagnosticImpl);
      } else {
        final Object type = typeDef.second;
        final boolean contextOnly = ModelInferrerUtils.isContextOnly(cvar);
        if (contextOnly) {
          if ((type instanceof EClass)) {
            state.acceptActualType(this.getRawTypeForName(Index.class, state));
          } else {
            if ((type instanceof EEnum)) {
              state.acceptActualType(this.getRawTypeForName(String.class, state));
            } else {
              if ((type instanceof EDataType)) {
                state.acceptActualType(this.getRawTypeForName(((EDataType)type).getInstanceClass(), state));
              } else {
                if ((type instanceof EReference)) {
                  state.acceptActualType(this.getRawTypeForName(Index.class, state));
                } else {
                  if ((type instanceof EAttribute)) {
                    state.acceptActualType(
                      this.getRawTypeForName(Index.class, state));
                  } else {
                    state.acceptActualType(this.getRawTypeForName(Object.class, state));
                  }
                }
              }
            }
          }
        } else {
          if ((type instanceof EClass)) {
            state.acceptActualType(this.getRawTypeForName(TypedNode.class, state));
          } else {
            if ((type instanceof EEnum)) {
              state.acceptActualType(this.getRawTypeForName(String.class, state));
            } else {
              if ((type instanceof EDataType)) {
                state.acceptActualType(this.getRawTypeForName(((EDataType)type).getInstanceClass(), state));
              } else {
                if ((type instanceof EReference)) {
                  state.acceptActualType(this.getRawTypeForName(TypedEdge.class, state));
                } else {
                  if ((type instanceof EAttribute)) {
                    state.acceptActualType(
                      this.getRawTypeForName(ValueEdge.class, state));
                  } else {
                    state.acceptActualType(this.getRawTypeForName(Object.class, state));
                  }
                }
              }
            }
          }
        }
      }
    }
  }
  
  protected void _computeTypes(final NavigationExpression pathExp, final ITypeComputationState state) {
    final ContextExpression host = pathExp.getHost();
    final String path = pathExp.getPathName();
    final ITypeComputationResult hostType = state.withNonVoidExpectation().computeTypes(host);
    final Pair<EClassifier, Boolean> ecoreType = ModelInferrerUtils.navEcoreType(pathExp);
    if ((ecoreType == null)) {
      String _string = EcoreUtil.getURI(pathExp).toString();
      EObjectDiagnosticImpl _eObjectDiagnosticImpl = new EObjectDiagnosticImpl(Severity.ERROR, IssueCodes.INVALID_IDENTIFIER, ("cannot navigate to " + path), pathExp, BXCorePackage.Literals.NAVIGATION_EXPRESSION__PATH_NAME, (-1), 
        new String[] { _string });
      state.addDiagnostic(_eObjectDiagnosticImpl);
    } else {
      final ITypeReferenceOwner owner = state.getReferenceOwner();
      LightweightTypeReference _xifexpression = null;
      EClassifier _key = ecoreType.getKey();
      if ((_key instanceof EClass)) {
        _xifexpression = this.getRawTypeForName(TypedNode.class, state);
      } else {
        LightweightTypeReference _xifexpression_1 = null;
        EClassifier _key_1 = ecoreType.getKey();
        if ((_key_1 instanceof EEnum)) {
          _xifexpression_1 = this.getRawTypeForName(String.class, state);
        } else {
          LightweightTypeReference _xifexpression_2 = null;
          EClassifier _key_2 = ecoreType.getKey();
          if ((_key_2 instanceof EDataType)) {
            _xifexpression_2 = this.getRawTypeForName(ecoreType.getKey().getInstanceClass(), state);
          } else {
            _xifexpression_2 = this.getRawTypeForName(Object.class, state);
          }
          _xifexpression_1 = _xifexpression_2;
        }
        _xifexpression = _xifexpression_1;
      }
      final LightweightTypeReference componmentType = _xifexpression;
      LightweightTypeReference _xifexpression_3 = null;
      Boolean _value = ecoreType.getValue();
      if ((_value).booleanValue()) {
        ParameterizedTypeReference _xblockexpression = null;
        {
          final ParameterizedTypeReference array = owner.newParameterizedTypeReference(owner.newReferenceTo(List.class).getType());
          array.addTypeArgument(componmentType);
          _xblockexpression = array;
        }
        _xifexpression_3 = _xblockexpression;
      } else {
        _xifexpression_3 = componmentType;
      }
      final LightweightTypeReference type = _xifexpression_3;
      state.acceptActualType(type);
    }
  }
  
  protected void _computeTypes(final ModificationExpressionBlock modification, final ITypeComputationState state) {
    final LightweightTypeReference type = this.getRawTypeForName(ContextGraph.GraphModification.class, state);
    final Consumer<XExpression> _function = (XExpression e) -> {
      state.withExpectation(type).computeTypes(e);
    };
    modification.getExpressions().forEach(_function);
    state.acceptActualType(this.getRawTypeForName(SourceType.class, state), ConformanceFlags.NO_IMPLICIT_RETURN);
  }
  
  protected void _computeTypes(final EnforcementExpression modification, final ITypeComputationState state) {
    final Consumer<ValueMapping> _function = (ValueMapping e) -> {
      state.withNonVoidExpectation().computeTypes(e.getExpression());
    };
    modification.getValueMappings().forEach(_function);
    state.acceptActualType(this.getRawTypeForName(ContextGraph.GraphModification.class, state));
  }
  
  protected void _computeTypes(final DeleteElementExpression modification, final ITypeComputationState state) {
    state.withNonVoidExpectation().computeTypes(modification.getElement());
    state.acceptActualType(this.getRawTypeForName(ContextGraph.GraphModification.class, state));
  }
  
  public void computeTypes(final XExpression cvar, final ITypeComputationState state) {
    if (cvar instanceof AnnotatedVariableExpression) {
      _computeTypes((AnnotatedVariableExpression)cvar, state);
      return;
    } else if (cvar instanceof ContextVarExpression) {
      _computeTypes((ContextVarExpression)cvar, state);
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
    } else if (cvar instanceof DeleteElementExpression) {
      _computeTypes((DeleteElementExpression)cvar, state);
      return;
    } else if (cvar instanceof EnforcementExpression) {
      _computeTypes((EnforcementExpression)cvar, state);
      return;
    } else if (cvar instanceof ModificationExpressionBlock) {
      _computeTypes((ModificationExpressionBlock)cvar, state);
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
