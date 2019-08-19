package xmu.list2list;

import edu.ustb.sei.mde.bxcore.SourceType;
import edu.ustb.sei.mde.bxcore.ViewType;
import edu.ustb.sei.mde.bxcore.XmuCore;
import edu.ustb.sei.mde.bxcore.bigul.BidirectionalTransformation;
import edu.ustb.sei.mde.bxcore.exceptions.BidirectionalTransformationDefinitionException;
import edu.ustb.sei.mde.bxcore.exceptions.NothingReturnedException;
import edu.ustb.sei.mde.bxcore.structures.ContextGraph;
import edu.ustb.sei.mde.bxcore.structures.ContextType;
import edu.ustb.sei.mde.bxcore.util.XmuProgram;
import edu.ustb.sei.mde.graph.pattern.Pattern;
import edu.ustb.sei.mde.graph.type.TypeGraph;
import edu.ustb.sei.mde.graph.typedGraph.TypedEdge;
import edu.ustb.sei.mde.graph.typedGraph.TypedGraph;
import edu.ustb.sei.mde.graph.typedGraph.TypedNode;
import edu.ustb.sei.mde.graph.typedGraph.ValueEdge;
import edu.ustb.sei.mde.structure.Tuple2;
import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure2;

@SuppressWarnings("all")
public class List2List extends XmuProgram {
  private TypeGraph typeGraph_ecore;
  
  public TypeGraph getTypeGraph_Ecore() {
    if(typeGraph_ecore==null) {
    	typeGraph_ecore = new edu.ustb.sei.mde.graph.type.TypeGraph();
    	typeGraph_ecore.declare("@EModelElement");
    	typeGraph_ecore.declare("@ENamedElement,EModelElement");
    	typeGraph_ecore.declare("@ETypedElement,ENamedElement");
    	typeGraph_ecore.declare("@EStructuralFeature,ETypedElement");
    	typeGraph_ecore.declare("EAttribute,EStructuralFeature");
    	typeGraph_ecore.declare("@EClassifier,ENamedElement");
    	typeGraph_ecore.declare("EDataType,EClassifier");
    	typeGraph_ecore.declare("EAnnotation,EModelElement");
    	typeGraph_ecore.declare("EStringToStringMapEntry");
    	typeGraph_ecore.declare("EObject");
    	typeGraph_ecore.declare("EClass,EClassifier");
    	typeGraph_ecore.declare("EOperation,ETypedElement");
    	typeGraph_ecore.declare("EReference,EStructuralFeature");
    	typeGraph_ecore.declare("EGenericType");
    	typeGraph_ecore.declare("EPackage,ENamedElement");
    	typeGraph_ecore.declare("ETypeParameter,ENamedElement");
    	typeGraph_ecore.declare("EEnum,EDataType");
    	typeGraph_ecore.declare("EEnumLiteral,ENamedElement");
    	typeGraph_ecore.declare("EFactory,EModelElement");
    	typeGraph_ecore.declare("EParameter,ETypedElement");
    	typeGraph_ecore.declare("EBoolean:boolean");
    	typeGraph_ecore.declare("EString:java.lang.String");
    	typeGraph_ecore.declare("EJavaClass:java.lang.Class");
    	typeGraph_ecore.declare("EJavaObject:java.lang.Object");
    	typeGraph_ecore.declare("EInt:int");
    	typeGraph_ecore.declare("EEnumerator:org.eclipse.emf.common.util.Enumerator");
    	typeGraph_ecore.declare("EBigDecimal:java.math.BigDecimal");
    	typeGraph_ecore.declare("EBigInteger:java.math.BigInteger");
    	typeGraph_ecore.declare("EBooleanObject:java.lang.Boolean");
    	typeGraph_ecore.declare("EByte:byte");
    	typeGraph_ecore.declare("EByteArray:byte[]");
    	typeGraph_ecore.declare("EByteObject:java.lang.Byte");
    	typeGraph_ecore.declare("EChar:char");
    	typeGraph_ecore.declare("ECharacterObject:java.lang.Character");
    	typeGraph_ecore.declare("EDate:java.util.Date");
    	typeGraph_ecore.declare("EDiagnosticChain:org.eclipse.emf.common.util.DiagnosticChain");
    	typeGraph_ecore.declare("EDouble:double");
    	typeGraph_ecore.declare("EDoubleObject:java.lang.Double");
    	typeGraph_ecore.declare("EEList:org.eclipse.emf.common.util.EList");
    	typeGraph_ecore.declare("EFeatureMap:org.eclipse.emf.ecore.util.FeatureMap");
    	typeGraph_ecore.declare("EFeatureMapEntry:org.eclipse.emf.ecore.util.FeatureMap$Entry");
    	typeGraph_ecore.declare("EFloat:float");
    	typeGraph_ecore.declare("EFloatObject:java.lang.Float");
    	typeGraph_ecore.declare("EIntegerObject:java.lang.Integer");
    	typeGraph_ecore.declare("ELong:long");
    	typeGraph_ecore.declare("ELongObject:java.lang.Long");
    	typeGraph_ecore.declare("EMap:java.util.Map");
    	typeGraph_ecore.declare("EResource:org.eclipse.emf.ecore.resource.Resource");
    	typeGraph_ecore.declare("EResourceSet:org.eclipse.emf.ecore.resource.ResourceSet");
    	typeGraph_ecore.declare("EShort:short");
    	typeGraph_ecore.declare("EShortObject:java.lang.Short");
    	typeGraph_ecore.declare("ETreeIterator:org.eclipse.emf.common.util.TreeIterator");
    	typeGraph_ecore.declare("EInvocationTargetException:java.lang.reflect.InvocationTargetException");
    	typeGraph_ecore.declare("iD:EAttribute->EBoolean");
    	typeGraph_ecore.declare("source:EAnnotation->EString");
    	typeGraph_ecore.declare("abstract:EClass->EBoolean");
    	typeGraph_ecore.declare("interface:EClass->EBoolean");
    	typeGraph_ecore.declare("instanceClassName:EClassifier->EString");
    	typeGraph_ecore.declare("instanceClass:EClassifier->EJavaClass");
    	typeGraph_ecore.declare("defaultValue:EClassifier->EJavaObject");
    	typeGraph_ecore.declare("instanceTypeName:EClassifier->EString");
    	typeGraph_ecore.declare("serializable:EDataType->EBoolean");
    	typeGraph_ecore.declare("value:EEnumLiteral->EInt");
    	typeGraph_ecore.declare("instance:EEnumLiteral->EEnumerator");
    	typeGraph_ecore.declare("literal:EEnumLiteral->EString");
    	typeGraph_ecore.declare("name:ENamedElement->EString");
    	typeGraph_ecore.declare("nsURI:EPackage->EString");
    	typeGraph_ecore.declare("nsPrefix:EPackage->EString");
    	typeGraph_ecore.declare("containment:EReference->EBoolean");
    	typeGraph_ecore.declare("container:EReference->EBoolean");
    	typeGraph_ecore.declare("resolveProxies:EReference->EBoolean");
    	typeGraph_ecore.declare("changeable:EStructuralFeature->EBoolean");
    	typeGraph_ecore.declare("volatile:EStructuralFeature->EBoolean");
    	typeGraph_ecore.declare("transient:EStructuralFeature->EBoolean");
    	typeGraph_ecore.declare("defaultValueLiteral:EStructuralFeature->EString");
    	typeGraph_ecore.declare("defaultValue:EStructuralFeature->EJavaObject");
    	typeGraph_ecore.declare("unsettable:EStructuralFeature->EBoolean");
    	typeGraph_ecore.declare("derived:EStructuralFeature->EBoolean");
    	typeGraph_ecore.declare("ordered:ETypedElement->EBoolean");
    	typeGraph_ecore.declare("unique:ETypedElement->EBoolean");
    	typeGraph_ecore.declare("lowerBound:ETypedElement->EInt");
    	typeGraph_ecore.declare("upperBound:ETypedElement->EInt");
    	typeGraph_ecore.declare("many:ETypedElement->EBoolean");
    	typeGraph_ecore.declare("required:ETypedElement->EBoolean");
    	typeGraph_ecore.declare("key:EStringToStringMapEntry->EString");
    	typeGraph_ecore.declare("value:EStringToStringMapEntry->EString");
    	typeGraph_ecore.declare("eAttributeType:EAttribute->EDataType");
    	typeGraph_ecore.declare("@details:EAnnotation->EStringToStringMapEntry*");
    	typeGraph_ecore.declare("eModelElement:EAnnotation->EModelElement");
    	typeGraph_ecore.declare("@contents:EAnnotation->EObject*");
    	typeGraph_ecore.declare("references:EAnnotation->EObject*");
    	typeGraph_ecore.declare("eSuperTypes:EClass->EClass*");
    	typeGraph_ecore.declare("@eOperations:EClass->EOperation*");
    	typeGraph_ecore.declare("eAllAttributes:EClass->EAttribute*");
    	typeGraph_ecore.declare("eAllReferences:EClass->EReference*");
    	typeGraph_ecore.declare("eReferences:EClass->EReference*");
    	typeGraph_ecore.declare("eAttributes:EClass->EAttribute*");
    	typeGraph_ecore.declare("eAllContainments:EClass->EReference*");
    	typeGraph_ecore.declare("eAllOperations:EClass->EOperation*");
    	typeGraph_ecore.declare("eAllStructuralFeatures:EClass->EStructuralFeature*");
    	typeGraph_ecore.declare("eAllSuperTypes:EClass->EClass*");
    	typeGraph_ecore.declare("eIDAttribute:EClass->EAttribute");
    	typeGraph_ecore.declare("@eStructuralFeatures:EClass->EStructuralFeature*");
    	typeGraph_ecore.declare("@eGenericSuperTypes:EClass->EGenericType*");
    	typeGraph_ecore.declare("eAllGenericSuperTypes:EClass->EGenericType*");
    	typeGraph_ecore.declare("ePackage:EClassifier->EPackage");
    	typeGraph_ecore.declare("@eTypeParameters:EClassifier->ETypeParameter*");
    	typeGraph_ecore.declare("@eLiterals:EEnum->EEnumLiteral*");
    	typeGraph_ecore.declare("eEnum:EEnumLiteral->EEnum");
    	typeGraph_ecore.declare("ePackage:EFactory->EPackage");
    	typeGraph_ecore.declare("@eAnnotations:EModelElement->EAnnotation*");
    	typeGraph_ecore.declare("eContainingClass:EOperation->EClass");
    	typeGraph_ecore.declare("@eTypeParameters:EOperation->ETypeParameter*");
    	typeGraph_ecore.declare("@eParameters:EOperation->EParameter*");
    	typeGraph_ecore.declare("eExceptions:EOperation->EClassifier*");
    	typeGraph_ecore.declare("@eGenericExceptions:EOperation->EGenericType*");
    	typeGraph_ecore.declare("eFactoryInstance:EPackage->EFactory");
    	typeGraph_ecore.declare("@eClassifiers:EPackage->EClassifier*");
    	typeGraph_ecore.declare("@eSubpackages:EPackage->EPackage*");
    	typeGraph_ecore.declare("eSuperPackage:EPackage->EPackage");
    	typeGraph_ecore.declare("eOperation:EParameter->EOperation");
    	typeGraph_ecore.declare("eOpposite:EReference->EReference");
    	typeGraph_ecore.declare("eReferenceType:EReference->EClass");
    	typeGraph_ecore.declare("eKeys:EReference->EAttribute*");
    	typeGraph_ecore.declare("eContainingClass:EStructuralFeature->EClass");
    	typeGraph_ecore.declare("eType:ETypedElement->EClassifier");
    	typeGraph_ecore.declare("@eGenericType:ETypedElement->EGenericType");
    	typeGraph_ecore.declare("@eUpperBound:EGenericType->EGenericType");
    	typeGraph_ecore.declare("@eTypeArguments:EGenericType->EGenericType*");
    	typeGraph_ecore.declare("eRawType:EGenericType->EClassifier");
    	typeGraph_ecore.declare("@eLowerBound:EGenericType->EGenericType");
    	typeGraph_ecore.declare("eTypeParameter:EGenericType->ETypeParameter");
    	typeGraph_ecore.declare("eClassifier:EGenericType->EClassifier");
    	typeGraph_ecore.declare("@eBounds:ETypeParameter->EGenericType*");
    }
    return typeGraph_ecore;
  }
  
  public void registerEcorePackage(final URI metamodelUri) {
    registerPackage("ecore", metamodelUri);
  }
  
  public TypedGraph loadEcoreModel(final URI modelUri) {
    org.eclipse.emf.ecore.EPackage pack = getPackage("ecore");
    java.util.List<org.eclipse.emf.ecore.EObject> roots = edu.ustb.sei.mde.bxcore.util.EcoreModelUtil.load(modelUri);
    edu.ustb.sei.mde.graph.typedGraph.TypedGraph graph = edu.ustb.sei.mde.bxcore.util.EcoreModelUtil.load(roots, getTypeGraph_Ecore());
    return graph;
  }
  
  public void saveEcoreModel(final URI uri, final ContextGraph data, final TypedGraph originalGraph) throws NothingReturnedException, BidirectionalTransformationDefinitionException {
    edu.ustb.sei.mde.bxcore.util.EcoreModelUtil.save(uri, data.getGraph(), originalGraph, getPackage("ecore"));
  }
  
  public void saveEcoreModel(final URI uri, final ContextGraph data) throws NothingReturnedException, BidirectionalTransformationDefinitionException {
    edu.ustb.sei.mde.bxcore.util.EcoreModelUtil.save(uri, data.getGraph(), null, getPackage("ecore"));
  }
  
  private TypeGraph typeGraph_L1;
  
  public TypeGraph getTypeGraph_L1() {
    if(typeGraph_L1==null) {
    	typeGraph_L1 = new edu.ustb.sei.mde.graph.type.TypeGraph();
    	typeGraph_L1.declare("List");
    	typeGraph_L1.declare("Element");
    	typeGraph_L1.declare("EString:java.lang.String");
    	typeGraph_L1.declare("value:Element->EString");
    	typeGraph_L1.declare("@elements:List->Element*");
    }
    return typeGraph_L1;
  }
  
  public void registerL1Package(final URI metamodelUri) {
    registerPackage("L1", metamodelUri);
  }
  
  public TypedGraph loadL1Model(final URI modelUri) {
    org.eclipse.emf.ecore.EPackage pack = getPackage("L1");
    java.util.List<org.eclipse.emf.ecore.EObject> roots = edu.ustb.sei.mde.bxcore.util.EcoreModelUtil.load(modelUri);
    edu.ustb.sei.mde.graph.typedGraph.TypedGraph graph = edu.ustb.sei.mde.bxcore.util.EcoreModelUtil.load(roots, getTypeGraph_L1());
    return graph;
  }
  
  public void saveL1Model(final URI uri, final ContextGraph data, final TypedGraph originalGraph) throws NothingReturnedException, BidirectionalTransformationDefinitionException {
    edu.ustb.sei.mde.bxcore.util.EcoreModelUtil.save(uri, data.getGraph(), originalGraph, getPackage("L1"));
  }
  
  public void saveL1Model(final URI uri, final ContextGraph data) throws NothingReturnedException, BidirectionalTransformationDefinitionException {
    edu.ustb.sei.mde.bxcore.util.EcoreModelUtil.save(uri, data.getGraph(), null, getPackage("L1"));
  }
  
  private TypeGraph typeGraph_L2;
  
  public TypeGraph getTypeGraph_L2() {
    if(typeGraph_L2==null) {
    	typeGraph_L2 = new edu.ustb.sei.mde.graph.type.TypeGraph();
    	typeGraph_L2.declare("List");
    	typeGraph_L2.declare("Element");
    	typeGraph_L2.declare("EString:java.lang.String");
    	typeGraph_L2.declare("value:Element->EString");
    	typeGraph_L2.declare("@elements:List->Element*");
    	typeGraph_L2.declare("next:Element->Element");
    }
    return typeGraph_L2;
  }
  
  public void registerL2Package(final URI metamodelUri) {
    registerPackage("L2", metamodelUri);
  }
  
  public TypedGraph loadL2Model(final URI modelUri) {
    org.eclipse.emf.ecore.EPackage pack = getPackage("L2");
    java.util.List<org.eclipse.emf.ecore.EObject> roots = edu.ustb.sei.mde.bxcore.util.EcoreModelUtil.load(modelUri);
    edu.ustb.sei.mde.graph.typedGraph.TypedGraph graph = edu.ustb.sei.mde.bxcore.util.EcoreModelUtil.load(roots, getTypeGraph_L2());
    return graph;
  }
  
  public void saveL2Model(final URI uri, final ContextGraph data, final TypedGraph originalGraph) throws NothingReturnedException, BidirectionalTransformationDefinitionException {
    edu.ustb.sei.mde.bxcore.util.EcoreModelUtil.save(uri, data.getGraph(), originalGraph, getPackage("L2"));
  }
  
  public void saveL2Model(final URI uri, final ContextGraph data) throws NothingReturnedException, BidirectionalTransformationDefinitionException {
    edu.ustb.sei.mde.bxcore.util.EcoreModelUtil.save(uri, data.getGraph(), null, getPackage("L2"));
  }
  
  public ViewType execute(final XmuCore bx, final TypedGraph graph, final Tuple2<String, Object>[] inits) throws NothingReturnedException {
    edu.ustb.sei.mde.bxcore.structures.Context sourceContext = bx.getSourceDef().createInstance();
    for(edu.ustb.sei.mde.structure.Tuple2<java.lang.String, java.lang.Object> tuple : inits) {
    	sourceContext.setValue(tuple.first, tuple.second);
    }
    return bx.forward(edu.ustb.sei.mde.bxcore.SourceType.makeSource(graph, sourceContext, new edu.ustb.sei.mde.bxcore.TraceSystem()));
  }
  
  public SourceType execute(final XmuCore bx, final TypedGraph source, final Tuple2<String, Object>[] sourceInits, final TypedGraph view, final Tuple2<String, Object>[] viewInits) throws NothingReturnedException {
    edu.ustb.sei.mde.bxcore.structures.Context sourceContext = bx.getSourceDef().createInstance();
    for(edu.ustb.sei.mde.structure.Tuple2<java.lang.String, java.lang.Object> tuple : sourceInits) {
    	sourceContext.setValue(tuple.first, tuple.second);
    }
    edu.ustb.sei.mde.bxcore.structures.Context viewContext = bx.getViewDef().createInstance();
    for(edu.ustb.sei.mde.structure.Tuple2<java.lang.String, java.lang.Object> tuple : viewInits) {
    	viewContext.setValue(tuple.first, tuple.second);
    }
    
    return bx.backward(edu.ustb.sei.mde.bxcore.SourceType.makeSource(source, sourceContext, new edu.ustb.sei.mde.bxcore.TraceSystem()), edu.ustb.sei.mde.bxcore.ViewType.makeView(view, viewContext));
  }
  
  public class Condition0 implements BiFunction<SourceType, ViewType, Boolean> {
    public Boolean apply(final SourceType source, final ViewType view) {
      edu.ustb.sei.mde.graph.typedGraph.TypedEdge _contextValue = ((edu.ustb.sei.mde.graph.typedGraph.TypedEdge) edu.ustb.sei.mde.bxcore.dsl.structure.ExceptionSafeInferface.getValue(source,"afterE"));
      final TypedEdge afterE = _contextValue;
      if ((afterE == null)) {
        return Boolean.valueOf(false);
      }
      edu.ustb.sei.mde.graph.typedGraph.TypedNode _contextValue_1 = ((edu.ustb.sei.mde.graph.typedGraph.TypedNode) edu.ustb.sei.mde.bxcore.dsl.structure.ExceptionSafeInferface.getValue(source,"l"));
      
      java.util.List<edu.ustb.sei.mde.graph.typedGraph.TypedEdge> _navExp = edu.ustb.sei.mde.bxcore.dsl.structure.ExceptionSafeInferface.navigate(source, _contextValue_1, "elements", true, true, false);
      int _indexOf = _navExp.indexOf(afterE);
      final int nextSId = (_indexOf + 1);
      InputOutput.<String>println(("last one in " + Integer.valueOf(nextSId)));
      edu.ustb.sei.mde.graph.typedGraph.TypedNode _contextValue_2 = ((edu.ustb.sei.mde.graph.typedGraph.TypedNode) edu.ustb.sei.mde.bxcore.dsl.structure.ExceptionSafeInferface.getValue(source,"l"));
      
      java.util.List<edu.ustb.sei.mde.graph.typedGraph.TypedEdge> _navExp_1 = edu.ustb.sei.mde.bxcore.dsl.structure.ExceptionSafeInferface.navigate(source, _contextValue_2, "elements", true, true, false);
      int _size = _navExp_1.size();
      boolean _tripleNotEquals = (nextSId != _size);
      if (_tripleNotEquals) {
        return Boolean.valueOf(false);
      }
      try {
        edu.ustb.sei.mde.graph.typedGraph.TypedNode _contextValue_3 = ((edu.ustb.sei.mde.graph.typedGraph.TypedNode) edu.ustb.sei.mde.bxcore.dsl.structure.ExceptionSafeInferface.getValue(view,"l"));
        final TypedNode list2 = _contextValue_3;
        Object _value = view.getContext().<Object>getValue("afterE");
        boolean _tripleEquals = (_value == XmuProgram.BEGIN);
        if (_tripleEquals) {
          return Boolean.valueOf(false);
        }
        edu.ustb.sei.mde.graph.typedGraph.TypedNode _contextValue_4 = ((edu.ustb.sei.mde.graph.typedGraph.TypedNode) edu.ustb.sei.mde.bxcore.dsl.structure.ExceptionSafeInferface.getValue(view,"afterE"));
        edu.ustb.sei.mde.graph.typedGraph.TypedNode _expValue = _contextValue_4;
        
        edu.ustb.sei.mde.graph.typedGraph.TypedNode _navExp_2 = edu.ustb.sei.mde.bxcore.dsl.structure.ExceptionSafeInferface.navigate(view, _expValue, "next", true, false, true);
        final TypedNode nextVE = _navExp_2;
        if ((nextVE != null)) {
          return Boolean.valueOf(false);
        }
      } catch (final Throwable _t) {
        if (_t instanceof Exception) {
          InputOutput.<String>println("forward tested in case 1");
        } else {
          throw Exceptions.sneakyThrow(_t);
        }
      }
      InputOutput.<String>println("last one true");
      return Boolean.valueOf(true);
    }
  }
  
  public class Condition1 implements BiFunction<SourceType, ViewType, Boolean> {
    public Boolean apply(final SourceType source, final ViewType view) {
      InputOutput.<String>println("first one in");
      edu.ustb.sei.mde.graph.typedGraph.TypedNode _contextValue = ((edu.ustb.sei.mde.graph.typedGraph.TypedNode) edu.ustb.sei.mde.bxcore.dsl.structure.ExceptionSafeInferface.getValue(source,"l"));
      
      java.util.List<edu.ustb.sei.mde.graph.typedGraph.TypedEdge> _navExp = edu.ustb.sei.mde.bxcore.dsl.structure.ExceptionSafeInferface.navigate(source, _contextValue, "elements", true, true, false);
      final List<TypedEdge> srcElementsEdges = _navExp;
      edu.ustb.sei.mde.graph.typedGraph.TypedEdge _contextValue_1 = ((edu.ustb.sei.mde.graph.typedGraph.TypedEdge) edu.ustb.sei.mde.bxcore.dsl.structure.ExceptionSafeInferface.getValue(source,"afterE"));
      final TypedEdge afterE = _contextValue_1;
      int _xifexpression = (int) 0;
      if ((afterE == null)) {
        _xifexpression = 0;
      } else {
        int _indexOf = srcElementsEdges.indexOf(afterE);
        _xifexpression = (_indexOf + 1);
      }
      final int nextSId = _xifexpression;
      if (((nextSId != 0) || srcElementsEdges.isEmpty())) {
        return Boolean.valueOf(false);
      }
      final TypedNode nextSE = srcElementsEdges.get(nextSId).getTarget();
      try {
        TypedNode _xifexpression_1 = null;
        boolean _equals = XmuProgram.BEGIN.equals(view.getContext().<Object>getValue("afterE"));
        if (_equals) {
          edu.ustb.sei.mde.graph.typedGraph.TypedNode _contextValue_2 = ((edu.ustb.sei.mde.graph.typedGraph.TypedNode) edu.ustb.sei.mde.bxcore.dsl.structure.ExceptionSafeInferface.getValue(view,"l"));
          
          java.util.List<edu.ustb.sei.mde.graph.typedGraph.TypedNode> _navExp_1 = edu.ustb.sei.mde.bxcore.dsl.structure.ExceptionSafeInferface.navigate(view, _contextValue_2, "elements", true, true, true);
          final Function1<TypedNode, Boolean> _function = (TypedNode e) -> {
            edu.ustb.sei.mde.graph.typedGraph.TypedNode _contextValue_3 = ((edu.ustb.sei.mde.graph.typedGraph.TypedNode) edu.ustb.sei.mde.bxcore.dsl.structure.ExceptionSafeInferface.getValue(view,"l"));
            
            java.util.List<edu.ustb.sei.mde.graph.typedGraph.TypedNode> _navExp_2 = edu.ustb.sei.mde.bxcore.dsl.structure.ExceptionSafeInferface.navigate(view, _contextValue_3, "elements", true, true, true);
            final Function1<TypedNode, Boolean> _function_1 = (TypedNode it) -> {
              edu.ustb.sei.mde.graph.typedGraph.TypedNode _expValue = it;
              
              edu.ustb.sei.mde.graph.typedGraph.TypedNode _navExp_3 = edu.ustb.sei.mde.bxcore.dsl.structure.ExceptionSafeInferface.navigate(view, _expValue, "next", true, false, true);
              return Boolean.valueOf((_navExp_3 != e));
            };
            return Boolean.valueOf(IterableExtensions.<TypedNode>forall(_navExp_2, _function_1));
          };
          _xifexpression_1 = IterableExtensions.<TypedNode>findFirst(_navExp_1, _function);
        } else {
          _xifexpression_1 = null;
        }
        final TypedNode nextVE = _xifexpression_1;
        if ((nextVE == null)) {
          return Boolean.valueOf(false);
        }
        edu.ustb.sei.mde.graph.typedGraph.TypedNode _expValue = nextSE;
        
        java.lang.String _navExp_2 = edu.ustb.sei.mde.bxcore.dsl.structure.ExceptionSafeInferface.navigate(source, _expValue, "value", false, false, true);
        edu.ustb.sei.mde.graph.typedGraph.TypedNode _expValue_1 = nextVE;
        
        java.lang.String _navExp_3 = edu.ustb.sei.mde.bxcore.dsl.structure.ExceptionSafeInferface.navigate(view, _expValue_1, "value", false, false, true);
        return Boolean.valueOf(_navExp_2.equals(_navExp_3));
      } catch (final Throwable _t) {
        if (_t instanceof Exception) {
        } else {
          throw Exceptions.sneakyThrow(_t);
        }
      }
      InputOutput.<String>println("first one true");
      return Boolean.valueOf(true);
    }
  }
  
  public class Condition2 implements Function<ContextGraph, Boolean> {
    public Boolean apply(final ContextGraph context) {
      edu.ustb.sei.mde.graph.typedGraph.TypedNode _contextValue = ((edu.ustb.sei.mde.graph.typedGraph.TypedNode) edu.ustb.sei.mde.bxcore.dsl.structure.ExceptionSafeInferface.getValue(context,"l"));
      
      java.util.List<edu.ustb.sei.mde.graph.typedGraph.TypedNode> _navExp = edu.ustb.sei.mde.bxcore.dsl.structure.ExceptionSafeInferface.navigate(context, _contextValue, "elements", true, true, true);
      final Function1<TypedNode, Boolean> _function = (TypedNode it) -> {
        edu.ustb.sei.mde.graph.typedGraph.TypedNode _expValue = it;
        
        edu.ustb.sei.mde.graph.typedGraph.TypedNode _navExp_1 = edu.ustb.sei.mde.bxcore.dsl.structure.ExceptionSafeInferface.navigate(context, _expValue, "next", true, false, true);
        edu.ustb.sei.mde.graph.typedGraph.TypedNode _contextValue_1 = ((edu.ustb.sei.mde.graph.typedGraph.TypedNode) edu.ustb.sei.mde.bxcore.dsl.structure.ExceptionSafeInferface.getValue(context,"e"));
        return Boolean.valueOf((_navExp_1 != _contextValue_1));
      };
      final boolean flag = IterableExtensions.<TypedNode>forall(_navExp, _function);
      return Boolean.valueOf(flag);
    }
  }
  
  public class Condition3 implements BiFunction<SourceType, ViewType, Boolean> {
    public Boolean apply(final SourceType source, final ViewType view) {
      InputOutput.<String>println("middle one in");
      edu.ustb.sei.mde.graph.typedGraph.TypedNode _contextValue = ((edu.ustb.sei.mde.graph.typedGraph.TypedNode) edu.ustb.sei.mde.bxcore.dsl.structure.ExceptionSafeInferface.getValue(source,"l"));
      
      java.util.List<edu.ustb.sei.mde.graph.typedGraph.TypedEdge> _navExp = edu.ustb.sei.mde.bxcore.dsl.structure.ExceptionSafeInferface.navigate(source, _contextValue, "elements", true, true, false);
      final List<TypedEdge> srcElementsEdges = _navExp;
      edu.ustb.sei.mde.graph.typedGraph.TypedEdge _contextValue_1 = ((edu.ustb.sei.mde.graph.typedGraph.TypedEdge) edu.ustb.sei.mde.bxcore.dsl.structure.ExceptionSafeInferface.getValue(source,"afterE"));
      final TypedEdge afterE = _contextValue_1;
      if ((afterE == null)) {
        return Boolean.valueOf(false);
      }
      int _indexOf = srcElementsEdges.indexOf(afterE);
      final int nextSId = (_indexOf + 1);
      int _size = srcElementsEdges.size();
      boolean _tripleEquals = (nextSId == _size);
      if (_tripleEquals) {
        return Boolean.valueOf(false);
      }
      final TypedNode nextSE = srcElementsEdges.get(nextSId).getTarget();
      try {
        TypedNode _xifexpression = null;
        Object _value = view.getContext().<Object>getValue("afterE");
        boolean _tripleEquals_1 = (_value == XmuProgram.BEGIN);
        if (_tripleEquals_1) {
          _xifexpression = null;
        } else {
          edu.ustb.sei.mde.graph.typedGraph.TypedNode _contextValue_2 = ((edu.ustb.sei.mde.graph.typedGraph.TypedNode) edu.ustb.sei.mde.bxcore.dsl.structure.ExceptionSafeInferface.getValue(view,"afterE"));
          edu.ustb.sei.mde.graph.typedGraph.TypedNode _expValue = _contextValue_2;
          
          edu.ustb.sei.mde.graph.typedGraph.TypedNode _navExp_1 = edu.ustb.sei.mde.bxcore.dsl.structure.ExceptionSafeInferface.navigate(view, _expValue, "next", true, false, true);
          _xifexpression = _navExp_1;
        }
        final TypedNode nextVE = _xifexpression;
        if ((nextVE == null)) {
          return Boolean.valueOf(false);
        }
        edu.ustb.sei.mde.graph.typedGraph.TypedNode _expValue_1 = nextSE;
        
        java.lang.String _navExp_2 = edu.ustb.sei.mde.bxcore.dsl.structure.ExceptionSafeInferface.navigate(source, _expValue_1, "value", false, false, true);
        edu.ustb.sei.mde.graph.typedGraph.TypedNode _expValue_2 = nextVE;
        
        java.lang.String _navExp_3 = edu.ustb.sei.mde.bxcore.dsl.structure.ExceptionSafeInferface.navigate(view, _expValue_2, "value", false, false, true);
        return Boolean.valueOf(_navExp_2.equals(_navExp_3));
      } catch (final Throwable _t) {
        if (_t instanceof Exception) {
        } else {
          throw Exceptions.sneakyThrow(_t);
        }
      }
      InputOutput.<String>println("middle one true");
      return Boolean.valueOf(true);
    }
  }
  
  public class Condition4 implements BiFunction<SourceType, ViewType, Boolean> {
    public Boolean apply(final SourceType source, final ViewType view) {
      try {
        boolean _xifexpression = false;
        Object _value = view.getContext().<Object>getValue("afterE");
        boolean _tripleNotEquals = (_value != XmuProgram.BEGIN);
        if (_tripleNotEquals) {
          edu.ustb.sei.mde.graph.typedGraph.TypedNode _contextValue = ((edu.ustb.sei.mde.graph.typedGraph.TypedNode) edu.ustb.sei.mde.bxcore.dsl.structure.ExceptionSafeInferface.getValue(view,"afterE"));
          
          edu.ustb.sei.mde.graph.typedGraph.TypedNode _navExp = edu.ustb.sei.mde.bxcore.dsl.structure.ExceptionSafeInferface.navigate(view, _contextValue, "next", true, false, true);
          _xifexpression = (_navExp == null);
        } else {
          _xifexpression = false;
        }
        return Boolean.valueOf(_xifexpression);
      } catch (Throwable _e) {
        throw Exceptions.sneakyThrow(_e);
      }
    }
  }
  
  public class Condition5 implements BiFunction<SourceType, ViewType, Boolean> {
    public Boolean apply(final SourceType source, final ViewType view) {
      try {
        edu.ustb.sei.mde.graph.typedGraph.TypedNode _contextValue = ((edu.ustb.sei.mde.graph.typedGraph.TypedNode) edu.ustb.sei.mde.bxcore.dsl.structure.ExceptionSafeInferface.getValue(source,"l"));
        
        java.util.List<edu.ustb.sei.mde.graph.typedGraph.TypedEdge> _navExp = edu.ustb.sei.mde.bxcore.dsl.structure.ExceptionSafeInferface.navigate(source, _contextValue, "elements", true, true, false);
        final List<TypedEdge> elements = _navExp;
        int _xifexpression = (int) 0;
        edu.ustb.sei.mde.graph.typedGraph.TypedEdge _contextValue_1 = ((edu.ustb.sei.mde.graph.typedGraph.TypedEdge) edu.ustb.sei.mde.bxcore.dsl.structure.ExceptionSafeInferface.getValue(source,"afterE"));
        boolean _tripleEquals = (_contextValue_1 == null);
        if (_tripleEquals) {
          _xifexpression = 0;
        } else {
          edu.ustb.sei.mde.graph.typedGraph.TypedEdge _contextValue_2 = ((edu.ustb.sei.mde.graph.typedGraph.TypedEdge) edu.ustb.sei.mde.bxcore.dsl.structure.ExceptionSafeInferface.getValue(source,"afterE"));
          int _indexOf = elements.indexOf(_contextValue_2);
          _xifexpression = (_indexOf + 1);
        }
        final int nextSId = _xifexpression;
        int _size = elements.size();
        boolean _tripleEquals_1 = (nextSId == _size);
        if (_tripleEquals_1) {
          return Boolean.valueOf(false);
        }
        TypedNode _xifexpression_1 = null;
        Object _value = view.getContext().<Object>getValue("afterE");
        boolean _tripleEquals_2 = (_value == XmuProgram.BEGIN);
        if (_tripleEquals_2) {
          edu.ustb.sei.mde.graph.typedGraph.TypedNode _contextValue_3 = ((edu.ustb.sei.mde.graph.typedGraph.TypedNode) edu.ustb.sei.mde.bxcore.dsl.structure.ExceptionSafeInferface.getValue(view,"l"));
          
          java.util.List<edu.ustb.sei.mde.graph.typedGraph.TypedNode> _navExp_1 = edu.ustb.sei.mde.bxcore.dsl.structure.ExceptionSafeInferface.navigate(view, _contextValue_3, "elements", true, true, true);
          final Function1<TypedNode, Boolean> _function = (TypedNode e) -> {
            edu.ustb.sei.mde.graph.typedGraph.TypedNode _contextValue_4 = ((edu.ustb.sei.mde.graph.typedGraph.TypedNode) edu.ustb.sei.mde.bxcore.dsl.structure.ExceptionSafeInferface.getValue(view,"l"));
            
            java.util.List<edu.ustb.sei.mde.graph.typedGraph.TypedNode> _navExp_2 = edu.ustb.sei.mde.bxcore.dsl.structure.ExceptionSafeInferface.navigate(view, _contextValue_4, "elements", true, true, true);
            final Function1<TypedNode, Boolean> _function_1 = (TypedNode it) -> {
              edu.ustb.sei.mde.graph.typedGraph.TypedNode _expValue = it;
              
              edu.ustb.sei.mde.graph.typedGraph.TypedNode _navExp_3 = edu.ustb.sei.mde.bxcore.dsl.structure.ExceptionSafeInferface.navigate(view, _expValue, "next", true, false, true);
              return Boolean.valueOf((_navExp_3 != e));
            };
            return Boolean.valueOf(IterableExtensions.<TypedNode>forall(_navExp_2, _function_1));
          };
          _xifexpression_1 = IterableExtensions.<TypedNode>findFirst(_navExp_1, _function);
        } else {
          edu.ustb.sei.mde.graph.typedGraph.TypedNode _contextValue_4 = ((edu.ustb.sei.mde.graph.typedGraph.TypedNode) edu.ustb.sei.mde.bxcore.dsl.structure.ExceptionSafeInferface.getValue(view,"afterE"));
          edu.ustb.sei.mde.graph.typedGraph.TypedNode _expValue = _contextValue_4;
          
          edu.ustb.sei.mde.graph.typedGraph.TypedNode _navExp_2 = edu.ustb.sei.mde.bxcore.dsl.structure.ExceptionSafeInferface.navigate(view, _expValue, "next", true, false, true);
          _xifexpression_1 = _navExp_2;
        }
        final TypedNode nextVE = _xifexpression_1;
        final Function1<TypedEdge, Boolean> _function_1 = (TypedEdge e) -> {
          boolean _xifexpression_2 = false;
          int _indexOf_1 = elements.indexOf(e);
          boolean _greaterThan = (_indexOf_1 > nextSId);
          if (_greaterThan) {
            TypedNode _target = e.getTarget();
            edu.ustb.sei.mde.graph.typedGraph.TypedNode _expValue_1 = _target;
            
            java.lang.String _navExp_3 = edu.ustb.sei.mde.bxcore.dsl.structure.ExceptionSafeInferface.navigate(source, _expValue_1, "value", false, false, true);
            edu.ustb.sei.mde.graph.typedGraph.TypedNode _expValue_2 = nextVE;
            
            java.lang.String _navExp_4 = edu.ustb.sei.mde.bxcore.dsl.structure.ExceptionSafeInferface.navigate(view, _expValue_2, "value", false, false, true);
            _xifexpression_2 = (_navExp_3 == _navExp_4);
          } else {
            _xifexpression_2 = false;
          }
          return Boolean.valueOf(_xifexpression_2);
        };
        return Boolean.valueOf(IterableExtensions.<TypedEdge>exists(elements, _function_1));
      } catch (Throwable _e) {
        throw Exceptions.sneakyThrow(_e);
      }
    }
  }
  
  public class Condition6 implements BiFunction<SourceType, ViewType, Boolean> {
    public Boolean apply(final SourceType source, final ViewType view) {
      try {
        TypedNode _xifexpression = null;
        Object _value = view.getContext().<Object>getValue("afterE");
        boolean _tripleEquals = (_value == XmuProgram.BEGIN);
        if (_tripleEquals) {
          edu.ustb.sei.mde.graph.typedGraph.TypedNode _contextValue = ((edu.ustb.sei.mde.graph.typedGraph.TypedNode) edu.ustb.sei.mde.bxcore.dsl.structure.ExceptionSafeInferface.getValue(view,"l"));
          
          java.util.List<edu.ustb.sei.mde.graph.typedGraph.TypedNode> _navExp = edu.ustb.sei.mde.bxcore.dsl.structure.ExceptionSafeInferface.navigate(view, _contextValue, "elements", true, true, true);
          final Function1<TypedNode, Boolean> _function = (TypedNode e) -> {
            edu.ustb.sei.mde.graph.typedGraph.TypedNode _contextValue_1 = ((edu.ustb.sei.mde.graph.typedGraph.TypedNode) edu.ustb.sei.mde.bxcore.dsl.structure.ExceptionSafeInferface.getValue(view,"l"));
            
            java.util.List<edu.ustb.sei.mde.graph.typedGraph.TypedNode> _navExp_1 = edu.ustb.sei.mde.bxcore.dsl.structure.ExceptionSafeInferface.navigate(view, _contextValue_1, "elements", true, true, true);
            final Function1<TypedNode, Boolean> _function_1 = (TypedNode it) -> {
              edu.ustb.sei.mde.graph.typedGraph.TypedNode _expValue = it;
              
              edu.ustb.sei.mde.graph.typedGraph.TypedNode _navExp_2 = edu.ustb.sei.mde.bxcore.dsl.structure.ExceptionSafeInferface.navigate(view, _expValue, "next", true, false, true);
              return Boolean.valueOf((_navExp_2 != e));
            };
            return Boolean.valueOf(IterableExtensions.<TypedNode>forall(_navExp_1, _function_1));
          };
          _xifexpression = IterableExtensions.<TypedNode>findFirst(_navExp, _function);
        } else {
          edu.ustb.sei.mde.graph.typedGraph.TypedNode _contextValue_1 = ((edu.ustb.sei.mde.graph.typedGraph.TypedNode) edu.ustb.sei.mde.bxcore.dsl.structure.ExceptionSafeInferface.getValue(view,"afterE"));
          edu.ustb.sei.mde.graph.typedGraph.TypedNode _expValue = _contextValue_1;
          
          edu.ustb.sei.mde.graph.typedGraph.TypedNode _navExp_1 = edu.ustb.sei.mde.bxcore.dsl.structure.ExceptionSafeInferface.navigate(view, _expValue, "next", true, false, true);
          _xifexpression = _navExp_1;
        }
        final TypedNode nextVE = _xifexpression;
        return Boolean.valueOf((nextVE != null));
      } catch (Throwable _e) {
        throw Exceptions.sneakyThrow(_e);
      }
    }
  }
  
  public class DerivationAction0 implements Function<ContextGraph, Object> {
    public Object apply(final ContextGraph context) {
      return XmuProgram.BEGIN;
    }
  }
  
  public class DerivationAction1 implements Function<ContextGraph, Object> {
    public Object apply(final ContextGraph context) {
      return XmuProgram.BEGIN;
    }
  }
  
  public class UnidirectionalAction2 implements BiFunction<SourceType, ViewType, SourceType> {
    public SourceType apply(final SourceType source, final ViewType view) {
      SourceType _xblockexpression = null;
      {
        InputOutput.<String>println("adaption 1 in");
        int _xifexpression = (int) 0;
        edu.ustb.sei.mde.graph.typedGraph.TypedEdge _contextValue = ((edu.ustb.sei.mde.graph.typedGraph.TypedEdge) edu.ustb.sei.mde.bxcore.dsl.structure.ExceptionSafeInferface.getValue(source,"afterE"));
        boolean _tripleEquals = (_contextValue == null);
        if (_tripleEquals) {
          _xifexpression = 0;
        } else {
          edu.ustb.sei.mde.graph.typedGraph.TypedNode _contextValue_1 = ((edu.ustb.sei.mde.graph.typedGraph.TypedNode) edu.ustb.sei.mde.bxcore.dsl.structure.ExceptionSafeInferface.getValue(source,"l"));
          
          java.util.List<edu.ustb.sei.mde.graph.typedGraph.TypedEdge> _navExp = edu.ustb.sei.mde.bxcore.dsl.structure.ExceptionSafeInferface.navigate(source, _contextValue_1, "elements", true, true, false);
          edu.ustb.sei.mde.graph.typedGraph.TypedEdge _contextValue_2 = ((edu.ustb.sei.mde.graph.typedGraph.TypedEdge) edu.ustb.sei.mde.bxcore.dsl.structure.ExceptionSafeInferface.getValue(source,"afterE"));
          int _indexOf = _navExp.indexOf(_contextValue_2);
          _xifexpression = (_indexOf + 1);
        }
        final int nextSId = _xifexpression;
        final ArrayList<TypedEdge> delEdge = CollectionLiterals.<TypedEdge>newArrayList();
        final ArrayList<TypedNode> delNode = CollectionLiterals.<TypedNode>newArrayList();
        edu.ustb.sei.mde.graph.typedGraph.TypedNode _contextValue_3 = ((edu.ustb.sei.mde.graph.typedGraph.TypedNode) edu.ustb.sei.mde.bxcore.dsl.structure.ExceptionSafeInferface.getValue(source,"l"));
        
        java.util.List<edu.ustb.sei.mde.graph.typedGraph.TypedEdge> _navExp_1 = edu.ustb.sei.mde.bxcore.dsl.structure.ExceptionSafeInferface.navigate(source, _contextValue_3, "elements", true, true, false);
        final Procedure2<TypedEdge, Integer> _function = (TypedEdge e, Integer i) -> {
          if (((i).intValue() >= nextSId)) {
            delEdge.add(e);
            TypedNode _target = e.getTarget();
            delNode.add(_target);
          }
        };
        IterableExtensions.<TypedEdge>forEach(_navExp_1, _function);
        edu.ustb.sei.mde.bxcore.structures.GraphModification _modStart = source.modification();
        edu.ustb.sei.mde.bxcore.structures.GraphModification _mod = _modStart.remove(delEdge);
        _modStart = _mod;
        edu.ustb.sei.mde.bxcore.structures.GraphModification _mod_1 = _modStart.remove(delNode);
        _modStart = _mod_1;
        _xblockexpression = _modStart.get();
      }
      return _xblockexpression;
    }
  }
  
  public class UnidirectionalAction3 implements BiFunction<SourceType, ViewType, SourceType> {
    public SourceType apply(final SourceType source, final ViewType view) {
      try {
        SourceType _xblockexpression = null;
        {
          InputOutput.<String>println("adaption 2 in");
          edu.ustb.sei.mde.graph.typedGraph.TypedNode _contextValue = ((edu.ustb.sei.mde.graph.typedGraph.TypedNode) edu.ustb.sei.mde.bxcore.dsl.structure.ExceptionSafeInferface.getValue(source,"l"));
          
          java.util.List<edu.ustb.sei.mde.graph.typedGraph.TypedEdge> _navExp = edu.ustb.sei.mde.bxcore.dsl.structure.ExceptionSafeInferface.navigate(source, _contextValue, "elements", true, true, false);
          final List<TypedEdge> elements = _navExp;
          edu.ustb.sei.mde.graph.typedGraph.TypedEdge _contextValue_1 = ((edu.ustb.sei.mde.graph.typedGraph.TypedEdge) edu.ustb.sei.mde.bxcore.dsl.structure.ExceptionSafeInferface.getValue(source,"afterE"));
          final TypedEdge prevLE = _contextValue_1;
          int _xifexpression = (int) 0;
          if ((prevLE == null)) {
            _xifexpression = 0;
          } else {
            _xifexpression = elements.indexOf(prevLE);
          }
          final int nextId = _xifexpression;
          TypedEdge _xifexpression_1 = null;
          int _size = elements.size();
          int _minus = (_size - 1);
          boolean _tripleEquals = (nextId == _minus);
          if (_tripleEquals) {
            _xifexpression_1 = null;
          } else {
            _xifexpression_1 = elements.get((nextId + 1));
          }
          final TypedEdge nextLE = _xifexpression_1;
          TypedNode _xifexpression_2 = null;
          Object _value = view.getContext().<Object>getValue("afterE");
          boolean _tripleEquals_1 = (_value == XmuProgram.BEGIN);
          if (_tripleEquals_1) {
            edu.ustb.sei.mde.graph.typedGraph.TypedNode _contextValue_2 = ((edu.ustb.sei.mde.graph.typedGraph.TypedNode) edu.ustb.sei.mde.bxcore.dsl.structure.ExceptionSafeInferface.getValue(view,"l"));
            
            java.util.List<edu.ustb.sei.mde.graph.typedGraph.TypedNode> _navExp_1 = edu.ustb.sei.mde.bxcore.dsl.structure.ExceptionSafeInferface.navigate(view, _contextValue_2, "elements", true, true, true);
            final Function1<TypedNode, Boolean> _function = (TypedNode e) -> {
              edu.ustb.sei.mde.graph.typedGraph.TypedNode _contextValue_3 = ((edu.ustb.sei.mde.graph.typedGraph.TypedNode) edu.ustb.sei.mde.bxcore.dsl.structure.ExceptionSafeInferface.getValue(view,"l"));
              
              java.util.List<edu.ustb.sei.mde.graph.typedGraph.TypedNode> _navExp_2 = edu.ustb.sei.mde.bxcore.dsl.structure.ExceptionSafeInferface.navigate(view, _contextValue_3, "elements", true, true, true);
              final Function1<TypedNode, Boolean> _function_1 = (TypedNode it) -> {
                edu.ustb.sei.mde.graph.typedGraph.TypedNode _expValue = it;
                
                edu.ustb.sei.mde.graph.typedGraph.TypedNode _navExp_3 = edu.ustb.sei.mde.bxcore.dsl.structure.ExceptionSafeInferface.navigate(view, _expValue, "next", true, false, true);
                return Boolean.valueOf((_navExp_3 != e));
              };
              return Boolean.valueOf(IterableExtensions.<TypedNode>forall(_navExp_2, _function_1));
            };
            _xifexpression_2 = IterableExtensions.<TypedNode>findFirst(_navExp_1, _function);
          } else {
            edu.ustb.sei.mde.graph.typedGraph.TypedNode _contextValue_3 = ((edu.ustb.sei.mde.graph.typedGraph.TypedNode) edu.ustb.sei.mde.bxcore.dsl.structure.ExceptionSafeInferface.getValue(view,"afterE"));
            edu.ustb.sei.mde.graph.typedGraph.TypedNode _expValue = _contextValue_3;
            
            edu.ustb.sei.mde.graph.typedGraph.TypedNode _navExp_2 = edu.ustb.sei.mde.bxcore.dsl.structure.ExceptionSafeInferface.navigate(view, _expValue, "next", true, false, true);
            _xifexpression_2 = _navExp_2;
          }
          final TypedNode nextVE = _xifexpression_2;
          final Function1<TypedEdge, Boolean> _function_1 = (TypedEdge e) -> {
            boolean _xifexpression_3 = false;
            int _indexOf = elements.indexOf(e);
            boolean _greaterThan = (_indexOf > nextId);
            if (_greaterThan) {
              TypedNode _target = e.getTarget();
              edu.ustb.sei.mde.graph.typedGraph.TypedNode _expValue_1 = _target;
              
              java.lang.String _navExp_3 = edu.ustb.sei.mde.bxcore.dsl.structure.ExceptionSafeInferface.navigate(source, _expValue_1, "value", false, false, true);
              edu.ustb.sei.mde.graph.typedGraph.TypedNode _expValue_2 = nextVE;
              
              java.lang.String _navExp_4 = edu.ustb.sei.mde.bxcore.dsl.structure.ExceptionSafeInferface.navigate(view, _expValue_2, "value", false, false, true);
              _xifexpression_3 = (_navExp_3 == _navExp_4);
            } else {
              _xifexpression_3 = false;
            }
            return Boolean.valueOf(_xifexpression_3);
          };
          final TypedEdge corLE = IterableExtensions.<TypedEdge>findFirst(elements, _function_1);
          final TypedNode corE = corLE.getTarget();
          edu.ustb.sei.mde.bxcore.structures.GraphModification _modStart = source.modification();
          edu.ustb.sei.mde.bxcore.structures.GraphModification _mod = _modStart.enforce(getPattern_11(), new edu.ustb.sei.mde.structure.Tuple2[] {edu.ustb.sei.mde.structure.Tuple2.make("lv",corLE),edu.ustb.sei.mde.structure.Tuple2.make("e",corE),edu.ustb.sei.mde.structure.Tuple2.make("afterE",prevLE)});
          _modStart = _mod;
          edu.ustb.sei.mde.bxcore.structures.GraphModification _mod_1 = _modStart.enforce(getPattern_12(), new edu.ustb.sei.mde.structure.Tuple2[] {edu.ustb.sei.mde.structure.Tuple2.make("lv",corLE),edu.ustb.sei.mde.structure.Tuple2.make("e",corE),edu.ustb.sei.mde.structure.Tuple2.make("beforeE",nextLE)});
          _modStart = _mod_1;
          _xblockexpression = _modStart.get();
        }
        return _xblockexpression;
      } catch (Throwable _e) {
        throw Exceptions.sneakyThrow(_e);
      }
    }
  }
  
  public class UnidirectionalAction4 implements BiFunction<SourceType, ViewType, SourceType> {
    public SourceType apply(final SourceType source, final ViewType view) {
      try {
        SourceType _xblockexpression = null;
        {
          InputOutput.<String>println("adaption 3 in");
          edu.ustb.sei.mde.graph.typedGraph.TypedNode _contextValue = ((edu.ustb.sei.mde.graph.typedGraph.TypedNode) edu.ustb.sei.mde.bxcore.dsl.structure.ExceptionSafeInferface.getValue(source,"l"));
          
          java.util.List<edu.ustb.sei.mde.graph.typedGraph.TypedEdge> _navExp = edu.ustb.sei.mde.bxcore.dsl.structure.ExceptionSafeInferface.navigate(source, _contextValue, "elements", true, true, false);
          final List<TypedEdge> elements = _navExp;
          edu.ustb.sei.mde.graph.typedGraph.TypedEdge _contextValue_1 = ((edu.ustb.sei.mde.graph.typedGraph.TypedEdge) edu.ustb.sei.mde.bxcore.dsl.structure.ExceptionSafeInferface.getValue(source,"afterE"));
          final TypedEdge prevLE = _contextValue_1;
          TypedEdge _xifexpression = null;
          if ((prevLE == null)) {
            _xifexpression = elements.get(0);
          } else {
            TypedEdge _xifexpression_1 = null;
            int _indexOf = elements.indexOf(prevLE);
            int _size = elements.size();
            int _minus = (_size - 1);
            boolean _tripleEquals = (_indexOf == _minus);
            if (_tripleEquals) {
              _xifexpression_1 = null;
            } else {
              int _indexOf_1 = elements.indexOf(prevLE);
              int _plus = (_indexOf_1 + 1);
              _xifexpression_1 = elements.get(_plus);
            }
            _xifexpression = _xifexpression_1;
          }
          final TypedEdge nextLE = _xifexpression;
          TypedNode _xifexpression_2 = null;
          Object _value = view.getContext().<Object>getValue("afterE");
          boolean _tripleEquals_1 = (_value == XmuProgram.BEGIN);
          if (_tripleEquals_1) {
            edu.ustb.sei.mde.graph.typedGraph.TypedNode _contextValue_2 = ((edu.ustb.sei.mde.graph.typedGraph.TypedNode) edu.ustb.sei.mde.bxcore.dsl.structure.ExceptionSafeInferface.getValue(view,"l"));
            
            java.util.List<edu.ustb.sei.mde.graph.typedGraph.TypedNode> _navExp_1 = edu.ustb.sei.mde.bxcore.dsl.structure.ExceptionSafeInferface.navigate(view, _contextValue_2, "elements", true, true, true);
            final Function1<TypedNode, Boolean> _function = (TypedNode e) -> {
              edu.ustb.sei.mde.graph.typedGraph.TypedNode _contextValue_3 = ((edu.ustb.sei.mde.graph.typedGraph.TypedNode) edu.ustb.sei.mde.bxcore.dsl.structure.ExceptionSafeInferface.getValue(view,"l"));
              
              java.util.List<edu.ustb.sei.mde.graph.typedGraph.TypedNode> _navExp_2 = edu.ustb.sei.mde.bxcore.dsl.structure.ExceptionSafeInferface.navigate(view, _contextValue_3, "elements", true, true, true);
              final Function1<TypedNode, Boolean> _function_1 = (TypedNode it) -> {
                edu.ustb.sei.mde.graph.typedGraph.TypedNode _expValue = it;
                
                edu.ustb.sei.mde.graph.typedGraph.TypedNode _navExp_3 = edu.ustb.sei.mde.bxcore.dsl.structure.ExceptionSafeInferface.navigate(view, _expValue, "next", true, false, true);
                return Boolean.valueOf((_navExp_3 != e));
              };
              return Boolean.valueOf(IterableExtensions.<TypedNode>forall(_navExp_2, _function_1));
            };
            _xifexpression_2 = IterableExtensions.<TypedNode>findFirst(_navExp_1, _function);
          } else {
            edu.ustb.sei.mde.graph.typedGraph.TypedNode _contextValue_3 = ((edu.ustb.sei.mde.graph.typedGraph.TypedNode) edu.ustb.sei.mde.bxcore.dsl.structure.ExceptionSafeInferface.getValue(view,"afterE"));
            edu.ustb.sei.mde.graph.typedGraph.TypedNode _expValue = _contextValue_3;
            
            edu.ustb.sei.mde.graph.typedGraph.TypedNode _navExp_2 = edu.ustb.sei.mde.bxcore.dsl.structure.ExceptionSafeInferface.navigate(view, _expValue, "next", true, false, true);
            _xifexpression_2 = _navExp_2;
          }
          final TypedNode nextVE = _xifexpression_2;
          edu.ustb.sei.mde.graph.typedGraph.TypedNode _expValue_1 = nextVE;
          
          java.lang.String _navExp_3 = edu.ustb.sei.mde.bxcore.dsl.structure.ExceptionSafeInferface.navigate(view, _expValue_1, "value", false, false, true);
          final String v = _navExp_3;
          edu.ustb.sei.mde.graph.typedGraph.TypedNode newInstance = edu.ustb.sei.mde.bxcore.structures.ContextGraph.newTypedNode(source, "Element");
          final TypedNode corE = newInstance;
          edu.ustb.sei.mde.graph.typedGraph.TypedEdge newInstance_1 = edu.ustb.sei.mde.bxcore.structures.ContextGraph.newTypedEdge(source, "List", "elements");
          final TypedEdge corLE = newInstance_1;
          edu.ustb.sei.mde.graph.typedGraph.ValueEdge newInstance_2 = edu.ustb.sei.mde.bxcore.structures.ContextGraph.newValueEdge(source, "Element", "value");
          final ValueEdge corLV = newInstance_2;
          edu.ustb.sei.mde.bxcore.structures.GraphModification _modStart = source.modification();
          if ((prevLE == null)) {
            edu.ustb.sei.mde.bxcore.structures.GraphModification _mod = _modStart.enforce(getPattern_13(), new edu.ustb.sei.mde.structure.Tuple2[] {edu.ustb.sei.mde.structure.Tuple2.make("le",corLE),edu.ustb.sei.mde.structure.Tuple2.make("e",corE),edu.ustb.sei.mde.structure.Tuple2.make("lv",corLV),edu.ustb.sei.mde.structure.Tuple2.make("afterE",XmuProgram.BEGIN),edu.ustb.sei.mde.structure.Tuple2.make("v",v)});
            _modStart = _mod;
            if ((nextLE != null)) {
              edu.ustb.sei.mde.bxcore.structures.GraphModification _mod_1 = _modStart.enforce(getPattern_14(), new edu.ustb.sei.mde.structure.Tuple2[] {edu.ustb.sei.mde.structure.Tuple2.make("le",corLE),edu.ustb.sei.mde.structure.Tuple2.make("e",corE),edu.ustb.sei.mde.structure.Tuple2.make("lv",corLV),edu.ustb.sei.mde.structure.Tuple2.make("beforeE",nextLE),edu.ustb.sei.mde.structure.Tuple2.make("v",v)});
              _modStart = _mod_1;
            }
          } else {
            edu.ustb.sei.mde.bxcore.structures.GraphModification _mod_2 = _modStart.enforce(getPattern_15(), new edu.ustb.sei.mde.structure.Tuple2[] {edu.ustb.sei.mde.structure.Tuple2.make("le",corLE),edu.ustb.sei.mde.structure.Tuple2.make("e",corE),edu.ustb.sei.mde.structure.Tuple2.make("lv",corLV),edu.ustb.sei.mde.structure.Tuple2.make("afterE",prevLE),edu.ustb.sei.mde.structure.Tuple2.make("v",v)});
            _modStart = _mod_2;
            if ((nextLE != null)) {
              edu.ustb.sei.mde.bxcore.structures.GraphModification _mod_3 = _modStart.enforce(getPattern_16(), new edu.ustb.sei.mde.structure.Tuple2[] {edu.ustb.sei.mde.structure.Tuple2.make("le",corLE),edu.ustb.sei.mde.structure.Tuple2.make("e",corE),edu.ustb.sei.mde.structure.Tuple2.make("lv",corLV),edu.ustb.sei.mde.structure.Tuple2.make("beforeE",nextLE),edu.ustb.sei.mde.structure.Tuple2.make("v",v)});
              _modStart = _mod_3;
            }
          }
          _xblockexpression = _modStart.get();
        }
        return _xblockexpression;
      } catch (Throwable _e) {
        throw Exceptions.sneakyThrow(_e);
      }
    }
  }
  
  /**
   * id:5
   */
  private ContextType type_5;
  
  public ContextType getType_5() {
    if(type_5==null) {
    	edu.ustb.sei.mde.graph.type.TypeGraph typeGraph = getTypeGraph_L1();
    	type_5 = new edu.ustb.sei.mde.bxcore.structures.ContextType();
    	edu.ustb.sei.mde.graph.type.IType afterE_type = typeGraph.getTypeEdge(typeGraph.getTypeNode("List"),"elements")
    	;
    	type_5.addField("afterE", afterE_type, false);
    	edu.ustb.sei.mde.graph.type.IType l_type = typeGraph.getTypeNode("List")
    	;
    	type_5.addField("l", l_type, false);
    }
    return type_5;
  }
  
  /**
   * id:2
   */
  private ContextType type_2;
  
  public ContextType getType_2() {
    if(type_2==null) {
    	edu.ustb.sei.mde.graph.type.TypeGraph typeGraph = getTypeGraph_L1();
    	type_2 = new edu.ustb.sei.mde.bxcore.structures.ContextType();
    	edu.ustb.sei.mde.graph.type.IType firstE_type = typeGraph.getTypeEdge(typeGraph.getTypeNode("List"),"elements")
    	;
    	type_2.addField("firstE", firstE_type, false);
    	edu.ustb.sei.mde.graph.type.IType l_type = typeGraph.getTypeNode("List")
    	;
    	type_2.addField("l", l_type, false);
    }
    return type_2;
  }
  
  /**
   * id:9
   */
  private ContextType type_9;
  
  public ContextType getType_9() {
    if(type_9==null) {
    	edu.ustb.sei.mde.graph.type.TypeGraph typeGraph = getTypeGraph_L1();
    	type_9 = new edu.ustb.sei.mde.bxcore.structures.ContextType();
    	edu.ustb.sei.mde.graph.type.IType afterE_type = typeGraph.getTypeEdge(typeGraph.getTypeNode("List"),"elements")
    	;
    	type_9.addField("afterE", afterE_type, false);
    	edu.ustb.sei.mde.graph.type.IType e_type = typeGraph.getTypeNode("Element")
    	;
    	type_9.addField("e", e_type, false);
    	edu.ustb.sei.mde.graph.type.IType l_type = typeGraph.getTypeNode("List")
    	;
    	type_9.addField("l", l_type, false);
    	edu.ustb.sei.mde.graph.type.IType le_type = typeGraph.getTypeEdge(typeGraph.getTypeNode("List"),"elements")
    	;
    	type_9.addField("le", le_type, false);
    }
    return type_9;
  }
  
  /**
   * id:0
   */
  private ContextType type_0;
  
  public ContextType getType_0() {
    if(type_0==null) {
    	edu.ustb.sei.mde.graph.type.TypeGraph typeGraph = getTypeGraph_L1();
    	type_0 = new edu.ustb.sei.mde.bxcore.structures.ContextType();
    	edu.ustb.sei.mde.graph.type.IType l_type = typeGraph.getTypeNode("List")
    	;
    	type_0.addField("l", l_type, false);
    }
    return type_0;
  }
  
  /**
   * id:7
   */
  private ContextType type_7;
  
  public ContextType getType_7() {
    if(type_7==null) {
    	edu.ustb.sei.mde.graph.type.TypeGraph typeGraph = getTypeGraph_L2();
    	type_7 = new edu.ustb.sei.mde.bxcore.structures.ContextType();
    	edu.ustb.sei.mde.graph.type.IType afterE_type = typeGraph.getTypeNode("Element")
    	;
    	type_7.addField("afterE", afterE_type, false);
    	edu.ustb.sei.mde.graph.type.IType e_type = typeGraph.getTypeNode("Element")
    	;
    	type_7.addField("e", e_type, false);
    	edu.ustb.sei.mde.graph.type.IType l_type = typeGraph.getTypeNode("List")
    	;
    	type_7.addField("l", l_type, false);
    	edu.ustb.sei.mde.graph.type.IType le_type = typeGraph.getTypeEdge(typeGraph.getTypeNode("List"),"elements")
    	;
    	type_7.addField("le", le_type, false);
    	edu.ustb.sei.mde.graph.type.IType lv_type = typeGraph.getPropertyEdge(typeGraph.getTypeNode("Element"),"value")
    	;
    	type_7.addField("lv", lv_type, false);
    	edu.ustb.sei.mde.graph.type.IType v_type = typeGraph.getDataTypeNode("EString")
    	;
    	type_7.addField("v", v_type, false);
    }
    return type_7;
  }
  
  /**
   * id:6
   */
  private ContextType type_6;
  
  public ContextType getType_6() {
    if(type_6==null) {
    	edu.ustb.sei.mde.graph.type.TypeGraph typeGraph = getTypeGraph_L2();
    	type_6 = new edu.ustb.sei.mde.bxcore.structures.ContextType();
    	edu.ustb.sei.mde.graph.type.IType afterE_type = typeGraph.getTypeNode("Element")
    	;
    	type_6.addField("afterE", afterE_type, false);
    	edu.ustb.sei.mde.graph.type.IType l_type = typeGraph.getTypeNode("List")
    	;
    	type_6.addField("l", l_type, false);
    }
    return type_6;
  }
  
  /**
   * id:4
   */
  private ContextType type_4;
  
  public ContextType getType_4() {
    if(type_4==null) {
    	edu.ustb.sei.mde.graph.type.TypeGraph typeGraph = getTypeGraph_L1();
    	type_4 = new edu.ustb.sei.mde.bxcore.structures.ContextType();
    	edu.ustb.sei.mde.graph.type.IType afterE_type = typeGraph.getTypeEdge(typeGraph.getTypeNode("List"),"elements")
    	;
    	type_4.addField("afterE", afterE_type, false);
    	edu.ustb.sei.mde.graph.type.IType e_type = typeGraph.getTypeNode("Element")
    	;
    	type_4.addField("e", e_type, false);
    	edu.ustb.sei.mde.graph.type.IType l_type = typeGraph.getTypeNode("List")
    	;
    	type_4.addField("l", l_type, false);
    	edu.ustb.sei.mde.graph.type.IType le_type = typeGraph.getTypeEdge(typeGraph.getTypeNode("List"),"elements")
    	;
    	type_4.addField("le", le_type, false);
    	edu.ustb.sei.mde.graph.type.IType lv_type = typeGraph.getPropertyEdge(typeGraph.getTypeNode("Element"),"value")
    	;
    	type_4.addField("lv", lv_type, false);
    	edu.ustb.sei.mde.graph.type.IType v_type = typeGraph.getDataTypeNode("EString")
    	;
    	type_4.addField("v", v_type, false);
    }
    return type_4;
  }
  
  /**
   * id:8
   */
  private ContextType type_8;
  
  public ContextType getType_8() {
    if(type_8==null) {
    	edu.ustb.sei.mde.graph.type.TypeGraph typeGraph = getTypeGraph_L2();
    	type_8 = new edu.ustb.sei.mde.bxcore.structures.ContextType();
    	edu.ustb.sei.mde.graph.type.IType afterE_type = typeGraph.getTypeNode("Element")
    	;
    	type_8.addField("afterE", afterE_type, false);
    	edu.ustb.sei.mde.graph.type.IType e_type = typeGraph.getTypeNode("Element")
    	;
    	type_8.addField("e", e_type, false);
    	edu.ustb.sei.mde.graph.type.IType l_type = typeGraph.getTypeNode("List")
    	;
    	type_8.addField("l", l_type, false);
    	edu.ustb.sei.mde.graph.type.IType le_type = typeGraph.getTypeEdge(typeGraph.getTypeNode("List"),"elements")
    	;
    	type_8.addField("le", le_type, false);
    	edu.ustb.sei.mde.graph.type.IType le2_type = typeGraph.getTypeEdge(typeGraph.getTypeNode("List"),"elements")
    	;
    	type_8.addField("le2", le2_type, false);
    	edu.ustb.sei.mde.graph.type.IType ln_type = typeGraph.getTypeEdge(typeGraph.getTypeNode("Element"),"next")
    	;
    	type_8.addField("ln", ln_type, false);
    	edu.ustb.sei.mde.graph.type.IType lv_type = typeGraph.getPropertyEdge(typeGraph.getTypeNode("Element"),"value")
    	;
    	type_8.addField("lv", lv_type, false);
    	edu.ustb.sei.mde.graph.type.IType v_type = typeGraph.getDataTypeNode("EString")
    	;
    	type_8.addField("v", v_type, false);
    }
    return type_8;
  }
  
  /**
   * id:3
   */
  private ContextType type_3;
  
  public ContextType getType_3() {
    if(type_3==null) {
    	edu.ustb.sei.mde.graph.type.TypeGraph typeGraph = getTypeGraph_L2();
    	type_3 = new edu.ustb.sei.mde.bxcore.structures.ContextType();
    	edu.ustb.sei.mde.graph.type.IType firstE_type = typeGraph.getTypeNode("Element")
    	;
    	type_3.addField("firstE", firstE_type, false);
    	edu.ustb.sei.mde.graph.type.IType l_type = typeGraph.getTypeNode("List")
    	;
    	type_3.addField("l", l_type, false);
    }
    return type_3;
  }
  
  /**
   * id:1
   */
  private ContextType type_1;
  
  public ContextType getType_1() {
    if(type_1==null) {
    	edu.ustb.sei.mde.graph.type.TypeGraph typeGraph = getTypeGraph_L2();
    	type_1 = new edu.ustb.sei.mde.bxcore.structures.ContextType();
    	edu.ustb.sei.mde.graph.type.IType l_type = typeGraph.getTypeNode("List")
    	;
    	type_1.addField("l", l_type, false);
    }
    return type_1;
  }
  
  /**
   * id:10
   */
  private ContextType type_10;
  
  public ContextType getType_10() {
    if(type_10==null) {
    	edu.ustb.sei.mde.graph.type.TypeGraph typeGraph = getTypeGraph_L1();
    	type_10 = new edu.ustb.sei.mde.bxcore.structures.ContextType();
    	edu.ustb.sei.mde.graph.type.IType beforeE_type = typeGraph.getTypeEdge(typeGraph.getTypeNode("List"),"elements")
    	;
    	type_10.addField("beforeE", beforeE_type, false);
    	edu.ustb.sei.mde.graph.type.IType e_type = typeGraph.getTypeNode("Element")
    	;
    	type_10.addField("e", e_type, false);
    	edu.ustb.sei.mde.graph.type.IType l_type = typeGraph.getTypeNode("List")
    	;
    	type_10.addField("l", l_type, false);
    	edu.ustb.sei.mde.graph.type.IType le_type = typeGraph.getTypeEdge(typeGraph.getTypeNode("List"),"elements")
    	;
    	type_10.addField("le", le_type, false);
    }
    return type_10;
  }
  
  /**
   * id:11
   */
  private ContextType type_11;
  
  public ContextType getType_11() {
    if(type_11==null) {
    	edu.ustb.sei.mde.graph.type.TypeGraph typeGraph = getTypeGraph_L1();
    	type_11 = new edu.ustb.sei.mde.bxcore.structures.ContextType();
    	edu.ustb.sei.mde.graph.type.IType beforeE_type = typeGraph.getTypeEdge(typeGraph.getTypeNode("List"),"elements")
    	;
    	type_11.addField("beforeE", beforeE_type, false);
    	edu.ustb.sei.mde.graph.type.IType e_type = typeGraph.getTypeNode("Element")
    	;
    	type_11.addField("e", e_type, false);
    	edu.ustb.sei.mde.graph.type.IType l_type = typeGraph.getTypeNode("List")
    	;
    	type_11.addField("l", l_type, false);
    	edu.ustb.sei.mde.graph.type.IType le_type = typeGraph.getTypeEdge(typeGraph.getTypeNode("List"),"elements")
    	;
    	type_11.addField("le", le_type, false);
    	edu.ustb.sei.mde.graph.type.IType lv_type = typeGraph.getPropertyEdge(typeGraph.getTypeNode("Element"),"value")
    	;
    	type_11.addField("lv", lv_type, false);
    	edu.ustb.sei.mde.graph.type.IType v_type = typeGraph.getDataTypeNode("EString")
    	;
    	type_11.addField("v", v_type, false);
    }
    return type_11;
  }
  
  /**
   * id:-3
   */
  private ContextType type_u3;
  
  /**
   * XmuCoreFunctionCall(xmu16)
   */
  public ContextType getType_U3() {
    if(type_u3==null) {
    	edu.ustb.sei.mde.graph.type.TypeGraph typeGraph = getTypeGraph_L2();
    	type_u3 = new edu.ustb.sei.mde.bxcore.structures.ContextType();
    	edu.ustb.sei.mde.graph.type.IType e_type = typeGraph.getTypeNode("Element")
    	;
    	type_u3.addField("e", e_type, false);
    	edu.ustb.sei.mde.graph.type.IType l_type = typeGraph.getTypeNode("List")
    	;
    	type_u3.addField("l", l_type, false);
    }
    return type_u3;
  }
  
  /**
   * id:-1
   */
  private ContextType type_u1;
  
  /**
   * XmuCoreFunctionCall(xmu16)
   */
  public ContextType getType_U1() {
    if(type_u1==null) {
    	edu.ustb.sei.mde.graph.type.TypeGraph typeGraph = getTypeGraph_L1();
    	type_u1 = new edu.ustb.sei.mde.bxcore.structures.ContextType();
    	edu.ustb.sei.mde.graph.type.IType le_type = typeGraph.getTypeEdge(typeGraph.getTypeNode("List"),"elements")
    	;
    	type_u1.addField("le", le_type, false);
    	edu.ustb.sei.mde.graph.type.IType l_type = typeGraph.getTypeNode("List")
    	;
    	type_u1.addField("l", l_type, false);
    }
    return type_u1;
  }
  
  private Pattern pattern_0;
  
  public Pattern getPattern_0() {
    if(pattern_0==null) {
    	edu.ustb.sei.mde.graph.type.TypeGraph typeGraph = getTypeGraph_L1();
    	pattern_0 = new edu.ustb.sei.mde.graph.pattern.Pattern(typeGraph);
    	edu.ustb.sei.mde.graph.type.ITypeNode l_type = typeGraph.getTypeNode("List")
    	;
    	pattern_0.appendPatternNode("l", l_type,false);
    	pattern_0.addAdditionalField(getType_2().getField("firstE"), new DerivationAction0());
    	pattern_0.setType(getType_2());
    }
    return pattern_0;
  }
  
  private Pattern pattern_1;
  
  public Pattern getPattern_1() {
    if(pattern_1==null) {
    	edu.ustb.sei.mde.graph.type.TypeGraph typeGraph = getTypeGraph_L2();
    	pattern_1 = new edu.ustb.sei.mde.graph.pattern.Pattern(typeGraph);
    	edu.ustb.sei.mde.graph.type.ITypeNode l_type = typeGraph.getTypeNode("List")
    	;
    	pattern_1.appendPatternNode("l", l_type,false);
    	pattern_1.addAdditionalField(getType_3().getField("firstE"), new DerivationAction1());
    	pattern_1.setType(getType_3());
    }
    return pattern_1;
  }
  
  private Pattern pattern_2;
  
  public Pattern getPattern_2() {
    if(pattern_2==null) {
    	edu.ustb.sei.mde.graph.type.TypeGraph typeGraph = getTypeGraph_L1();
    	pattern_2 = new edu.ustb.sei.mde.graph.pattern.Pattern(typeGraph);
    	edu.ustb.sei.mde.graph.type.ITypeNode l_type = typeGraph.getTypeNode("List")
    	;
    	pattern_2.appendPatternNode("l", l_type,false);
    	pattern_2.addAdditionalField(getType_2().getField("firstE"));
    	pattern_2.setType(getType_2());
    }
    return pattern_2;
  }
  
  private Pattern pattern_3;
  
  public Pattern getPattern_3() {
    if(pattern_3==null) {
    	edu.ustb.sei.mde.graph.type.TypeGraph typeGraph = getTypeGraph_L2();
    	pattern_3 = new edu.ustb.sei.mde.graph.pattern.Pattern(typeGraph);
    	edu.ustb.sei.mde.graph.type.ITypeNode l_type = typeGraph.getTypeNode("List")
    	;
    	pattern_3.appendPatternNode("l", l_type,false);
    	pattern_3.addAdditionalField(getType_3().getField("firstE"));
    	pattern_3.setType(getType_3());
    }
    return pattern_3;
  }
  
  private Pattern pattern_4;
  
  public Pattern getPattern_4() {
    if(pattern_4==null) {
    	edu.ustb.sei.mde.graph.type.TypeGraph typeGraph = getTypeGraph_L1();
    	pattern_4 = new edu.ustb.sei.mde.graph.pattern.Pattern(typeGraph);
    	edu.ustb.sei.mde.graph.type.ITypeNode l_type = typeGraph.getTypeNode("List")
    	;
    	pattern_4.appendPatternNode("l", l_type,false);
    	edu.ustb.sei.mde.graph.type.ITypeNode e_type = typeGraph.getTypeNode("Element")
    	;
    	pattern_4.appendPatternNode("e", e_type,false);
    	edu.ustb.sei.mde.graph.type.ITypeNode v_type = typeGraph.getDataTypeNode("EString")
    	;
    	pattern_4.appendPatternNode("v", v_type,false);
    	edu.ustb.sei.mde.graph.type.IStructuralFeatureEdge le_type = typeGraph.getTypeEdge((edu.ustb.sei.mde.graph.type.TypeNode) l_type,"elements");
    	pattern_4.appendPatternEdge("le", "l", "e", le_type);
    	edu.ustb.sei.mde.graph.type.IStructuralFeatureEdge lv_type = typeGraph.getPropertyEdge((edu.ustb.sei.mde.graph.type.TypeNode) e_type,"value");
    	pattern_4.appendPatternEdge("lv", "e", "v", lv_type);
    	pattern_4.addAdditionalField(getType_4().getField("afterE"));
    	pattern_4.setType(getType_4());
    	pattern_4.setOrderBy((edu.ustb.sei.mde.graph.pattern.PatternElement) pattern_4.getPatternElement("le"));
    	pattern_4.setPivot(pattern_4.getAdditionalField("afterE").first, true);
    }
    return pattern_4;
  }
  
  private Pattern pattern_5;
  
  public Pattern getPattern_5() {
    if(pattern_5==null) {
    	edu.ustb.sei.mde.graph.type.TypeGraph typeGraph = getTypeGraph_L1();
    	pattern_5 = new edu.ustb.sei.mde.graph.pattern.Pattern(typeGraph);
    	edu.ustb.sei.mde.graph.type.ITypeNode l_type = typeGraph.getTypeNode("List")
    	;
    	pattern_5.appendPatternNode("l", l_type,false);
    	pattern_5.addAdditionalField(getType_5().getField("afterE"));
    	pattern_5.setType(getType_5());
    }
    return pattern_5;
  }
  
  private Pattern pattern_6;
  
  public Pattern getPattern_6() {
    if(pattern_6==null) {
    	edu.ustb.sei.mde.graph.type.TypeGraph typeGraph = getTypeGraph_L2();
    	pattern_6 = new edu.ustb.sei.mde.graph.pattern.Pattern(typeGraph);
    	edu.ustb.sei.mde.graph.type.ITypeNode l_type = typeGraph.getTypeNode("List")
    	;
    	pattern_6.appendPatternNode("l", l_type,false);
    	pattern_6.addAdditionalField(getType_6().getField("afterE"));
    	pattern_6.setType(getType_6());
    }
    return pattern_6;
  }
  
  private Pattern pattern_7;
  
  public Pattern getPattern_7() {
    if(pattern_7==null) {
    	edu.ustb.sei.mde.graph.type.TypeGraph typeGraph = getTypeGraph_L2();
    	pattern_7 = new edu.ustb.sei.mde.graph.pattern.Pattern(typeGraph);
    	edu.ustb.sei.mde.graph.type.ITypeNode l_type = typeGraph.getTypeNode("List")
    	;
    	pattern_7.appendPatternNode("l", l_type,false);
    	edu.ustb.sei.mde.graph.type.ITypeNode e_type = typeGraph.getTypeNode("Element")
    	;
    	pattern_7.appendPatternNode("e", e_type,false);
    	edu.ustb.sei.mde.graph.type.ITypeNode v_type = typeGraph.getDataTypeNode("EString")
    	;
    	pattern_7.appendPatternNode("v", v_type,false);
    	edu.ustb.sei.mde.graph.type.IStructuralFeatureEdge le_type = typeGraph.getTypeEdge((edu.ustb.sei.mde.graph.type.TypeNode) l_type,"elements");
    	pattern_7.appendPatternEdge("le", "l", "e", le_type);
    	edu.ustb.sei.mde.graph.type.IStructuralFeatureEdge lv_type = typeGraph.getPropertyEdge((edu.ustb.sei.mde.graph.type.TypeNode) e_type,"value");
    	pattern_7.appendPatternEdge("lv", "e", "v", lv_type);
    	pattern_7.addAdditionalField(getType_7().getField("afterE"));
    	pattern_7.setType(getType_7());
    	pattern_7.setFilter(new Condition2());
    }
    return pattern_7;
  }
  
  private Pattern pattern_8;
  
  public Pattern getPattern_8() {
    if(pattern_8==null) {
    	edu.ustb.sei.mde.graph.type.TypeGraph typeGraph = getTypeGraph_L2();
    	pattern_8 = new edu.ustb.sei.mde.graph.pattern.Pattern(typeGraph);
    	edu.ustb.sei.mde.graph.type.ITypeNode l_type = typeGraph.getTypeNode("List")
    	;
    	pattern_8.appendPatternNode("l", l_type,false);
    	edu.ustb.sei.mde.graph.type.ITypeNode e_type = typeGraph.getTypeNode("Element")
    	;
    	pattern_8.appendPatternNode("e", e_type,false);
    	edu.ustb.sei.mde.graph.type.ITypeNode v_type = typeGraph.getDataTypeNode("EString")
    	;
    	pattern_8.appendPatternNode("v", v_type,false);
    	edu.ustb.sei.mde.graph.type.IStructuralFeatureEdge le_type = typeGraph.getTypeEdge((edu.ustb.sei.mde.graph.type.TypeNode) l_type,"elements");
    	pattern_8.appendPatternEdge("le", "l", "e", le_type);
    	edu.ustb.sei.mde.graph.type.IStructuralFeatureEdge lv_type = typeGraph.getPropertyEdge((edu.ustb.sei.mde.graph.type.TypeNode) e_type,"value");
    	pattern_8.appendPatternEdge("lv", "e", "v", lv_type);
    	pattern_8.addAdditionalField(getType_7().getField("afterE"));
    	pattern_8.setType(getType_7());
    }
    return pattern_8;
  }
  
  private Pattern pattern_9;
  
  public Pattern getPattern_9() {
    if(pattern_9==null) {
    	edu.ustb.sei.mde.graph.type.TypeGraph typeGraph = getTypeGraph_L2();
    	pattern_9 = new edu.ustb.sei.mde.graph.pattern.Pattern(typeGraph);
    	edu.ustb.sei.mde.graph.type.ITypeNode l_type = typeGraph.getTypeNode("List")
    	;
    	pattern_9.appendPatternNode("l", l_type,false);
    	edu.ustb.sei.mde.graph.type.ITypeNode e_type = typeGraph.getTypeNode("Element")
    	;
    	pattern_9.appendPatternNode("e", e_type,false);
    	edu.ustb.sei.mde.graph.type.ITypeNode v_type = typeGraph.getDataTypeNode("EString")
    	;
    	pattern_9.appendPatternNode("v", v_type,false);
    	edu.ustb.sei.mde.graph.type.ITypeNode afterE_type = typeGraph.getTypeNode("Element")
    	;
    	pattern_9.appendPatternNode("afterE", afterE_type,false);
    	edu.ustb.sei.mde.graph.type.IStructuralFeatureEdge le_type = typeGraph.getTypeEdge((edu.ustb.sei.mde.graph.type.TypeNode) l_type,"elements");
    	pattern_9.appendPatternEdge("le", "l", "e", le_type);
    	edu.ustb.sei.mde.graph.type.IStructuralFeatureEdge lv_type = typeGraph.getPropertyEdge((edu.ustb.sei.mde.graph.type.TypeNode) e_type,"value");
    	pattern_9.appendPatternEdge("lv", "e", "v", lv_type);
    	edu.ustb.sei.mde.graph.type.IStructuralFeatureEdge le2_type = typeGraph.getTypeEdge((edu.ustb.sei.mde.graph.type.TypeNode) l_type,"elements");
    	pattern_9.appendPatternEdge("le2", "l", "afterE", le2_type);
    	edu.ustb.sei.mde.graph.type.IStructuralFeatureEdge ln_type = typeGraph.getTypeEdge((edu.ustb.sei.mde.graph.type.TypeNode) afterE_type,"next");
    	pattern_9.appendPatternEdge("ln", "afterE", "e", ln_type);
    	pattern_9.setType(getType_8());
    }
    return pattern_9;
  }
  
  private Pattern pattern_10;
  
  public Pattern getPattern_10() {
    if(pattern_10==null) {
    	edu.ustb.sei.mde.graph.type.TypeGraph typeGraph = getTypeGraph_L2();
    	pattern_10 = new edu.ustb.sei.mde.graph.pattern.Pattern(typeGraph);
    	edu.ustb.sei.mde.graph.type.ITypeNode l_type = typeGraph.getTypeNode("List")
    	;
    	pattern_10.appendPatternNode("l", l_type,false);
    	edu.ustb.sei.mde.graph.type.ITypeNode e_type = typeGraph.getTypeNode("Element")
    	;
    	pattern_10.appendPatternNode("e", e_type,false);
    	edu.ustb.sei.mde.graph.type.ITypeNode v_type = typeGraph.getDataTypeNode("EString")
    	;
    	pattern_10.appendPatternNode("v", v_type,false);
    	edu.ustb.sei.mde.graph.type.ITypeNode afterE_type = typeGraph.getTypeNode("Element")
    	;
    	pattern_10.appendPatternNode("afterE", afterE_type,false);
    	edu.ustb.sei.mde.graph.type.IStructuralFeatureEdge le_type = typeGraph.getTypeEdge((edu.ustb.sei.mde.graph.type.TypeNode) l_type,"elements");
    	pattern_10.appendPatternEdge("le", "l", "e", le_type);
    	edu.ustb.sei.mde.graph.type.IStructuralFeatureEdge lv_type = typeGraph.getPropertyEdge((edu.ustb.sei.mde.graph.type.TypeNode) e_type,"value");
    	pattern_10.appendPatternEdge("lv", "e", "v", lv_type);
    	edu.ustb.sei.mde.graph.type.IStructuralFeatureEdge le2_type = typeGraph.getTypeEdge((edu.ustb.sei.mde.graph.type.TypeNode) l_type,"elements");
    	pattern_10.appendPatternEdge("le2", "l", "afterE", le2_type);
    	edu.ustb.sei.mde.graph.type.IStructuralFeatureEdge ln_type = typeGraph.getTypeEdge((edu.ustb.sei.mde.graph.type.TypeNode) afterE_type,"next");
    	pattern_10.appendPatternEdge("ln", "afterE", "e", ln_type);
    	pattern_10.setType(getType_8());
    }
    return pattern_10;
  }
  
  private Pattern pattern_11;
  
  public Pattern getPattern_11() {
    if(pattern_11==null) {
    	edu.ustb.sei.mde.graph.type.TypeGraph typeGraph = getTypeGraph_L1();
    	pattern_11 = new edu.ustb.sei.mde.graph.pattern.Pattern(typeGraph);
    	edu.ustb.sei.mde.graph.type.ITypeNode l_type = typeGraph.getTypeNode("List")
    	;
    	pattern_11.appendPatternNode("l", l_type,false);
    	edu.ustb.sei.mde.graph.type.ITypeNode e_type = typeGraph.getTypeNode("Element")
    	;
    	pattern_11.appendPatternNode("e", e_type,false);
    	edu.ustb.sei.mde.graph.type.IStructuralFeatureEdge le_type = typeGraph.getTypeEdge((edu.ustb.sei.mde.graph.type.TypeNode) l_type,"elements");
    	pattern_11.appendPatternEdge("le", "l", "e", le_type);
    	pattern_11.addAdditionalField(getType_9().getField("afterE"));
    	pattern_11.setType(getType_9());
    	pattern_11.setOrderBy((edu.ustb.sei.mde.graph.pattern.PatternElement) pattern_11.getPatternElement("le"));
    	pattern_11.setPivot(pattern_11.getAdditionalField("afterE").first, true);
    }
    return pattern_11;
  }
  
  private Pattern pattern_12;
  
  public Pattern getPattern_12() {
    if(pattern_12==null) {
    	edu.ustb.sei.mde.graph.type.TypeGraph typeGraph = getTypeGraph_L1();
    	pattern_12 = new edu.ustb.sei.mde.graph.pattern.Pattern(typeGraph);
    	edu.ustb.sei.mde.graph.type.ITypeNode l_type = typeGraph.getTypeNode("List")
    	;
    	pattern_12.appendPatternNode("l", l_type,false);
    	edu.ustb.sei.mde.graph.type.ITypeNode e_type = typeGraph.getTypeNode("Element")
    	;
    	pattern_12.appendPatternNode("e", e_type,false);
    	edu.ustb.sei.mde.graph.type.IStructuralFeatureEdge le_type = typeGraph.getTypeEdge((edu.ustb.sei.mde.graph.type.TypeNode) l_type,"elements");
    	pattern_12.appendPatternEdge("le", "l", "e", le_type);
    	pattern_12.addAdditionalField(getType_10().getField("beforeE"));
    	pattern_12.setType(getType_10());
    	pattern_12.setOrderBy((edu.ustb.sei.mde.graph.pattern.PatternElement) pattern_12.getPatternElement("le"));
    	pattern_12.setPivot(pattern_12.getAdditionalField("beforeE").first, false);
    }
    return pattern_12;
  }
  
  private Pattern pattern_13;
  
  public Pattern getPattern_13() {
    if(pattern_13==null) {
    	edu.ustb.sei.mde.graph.type.TypeGraph typeGraph = getTypeGraph_L1();
    	pattern_13 = new edu.ustb.sei.mde.graph.pattern.Pattern(typeGraph);
    	edu.ustb.sei.mde.graph.type.ITypeNode l_type = typeGraph.getTypeNode("List")
    	;
    	pattern_13.appendPatternNode("l", l_type,false);
    	edu.ustb.sei.mde.graph.type.ITypeNode e_type = typeGraph.getTypeNode("Element")
    	;
    	pattern_13.appendPatternNode("e", e_type,false);
    	edu.ustb.sei.mde.graph.type.ITypeNode v_type = typeGraph.getDataTypeNode("EString")
    	;
    	pattern_13.appendPatternNode("v", v_type,false);
    	edu.ustb.sei.mde.graph.type.IStructuralFeatureEdge le_type = typeGraph.getTypeEdge((edu.ustb.sei.mde.graph.type.TypeNode) l_type,"elements");
    	pattern_13.appendPatternEdge("le", "l", "e", le_type);
    	edu.ustb.sei.mde.graph.type.IStructuralFeatureEdge lv_type = typeGraph.getPropertyEdge((edu.ustb.sei.mde.graph.type.TypeNode) e_type,"value");
    	pattern_13.appendPatternEdge("lv", "e", "v", lv_type);
    	pattern_13.addAdditionalField(getType_4().getField("afterE"));
    	pattern_13.setType(getType_4());
    	pattern_13.setOrderBy((edu.ustb.sei.mde.graph.pattern.PatternElement) pattern_13.getPatternElement("le"));
    	pattern_13.setPivot(pattern_13.getAdditionalField("afterE").first, true);
    }
    return pattern_13;
  }
  
  private Pattern pattern_14;
  
  public Pattern getPattern_14() {
    if(pattern_14==null) {
    	edu.ustb.sei.mde.graph.type.TypeGraph typeGraph = getTypeGraph_L1();
    	pattern_14 = new edu.ustb.sei.mde.graph.pattern.Pattern(typeGraph);
    	edu.ustb.sei.mde.graph.type.ITypeNode l_type = typeGraph.getTypeNode("List")
    	;
    	pattern_14.appendPatternNode("l", l_type,false);
    	edu.ustb.sei.mde.graph.type.ITypeNode e_type = typeGraph.getTypeNode("Element")
    	;
    	pattern_14.appendPatternNode("e", e_type,false);
    	edu.ustb.sei.mde.graph.type.ITypeNode v_type = typeGraph.getDataTypeNode("EString")
    	;
    	pattern_14.appendPatternNode("v", v_type,false);
    	edu.ustb.sei.mde.graph.type.IStructuralFeatureEdge le_type = typeGraph.getTypeEdge((edu.ustb.sei.mde.graph.type.TypeNode) l_type,"elements");
    	pattern_14.appendPatternEdge("le", "l", "e", le_type);
    	edu.ustb.sei.mde.graph.type.IStructuralFeatureEdge lv_type = typeGraph.getPropertyEdge((edu.ustb.sei.mde.graph.type.TypeNode) e_type,"value");
    	pattern_14.appendPatternEdge("lv", "e", "v", lv_type);
    	pattern_14.addAdditionalField(getType_11().getField("beforeE"));
    	pattern_14.setType(getType_11());
    	pattern_14.setOrderBy((edu.ustb.sei.mde.graph.pattern.PatternElement) pattern_14.getPatternElement("le"));
    	pattern_14.setPivot(pattern_14.getAdditionalField("beforeE").first, false);
    }
    return pattern_14;
  }
  
  private Pattern pattern_15;
  
  public Pattern getPattern_15() {
    if(pattern_15==null) {
    	edu.ustb.sei.mde.graph.type.TypeGraph typeGraph = getTypeGraph_L1();
    	pattern_15 = new edu.ustb.sei.mde.graph.pattern.Pattern(typeGraph);
    	edu.ustb.sei.mde.graph.type.ITypeNode l_type = typeGraph.getTypeNode("List")
    	;
    	pattern_15.appendPatternNode("l", l_type,false);
    	edu.ustb.sei.mde.graph.type.ITypeNode e_type = typeGraph.getTypeNode("Element")
    	;
    	pattern_15.appendPatternNode("e", e_type,false);
    	edu.ustb.sei.mde.graph.type.ITypeNode v_type = typeGraph.getDataTypeNode("EString")
    	;
    	pattern_15.appendPatternNode("v", v_type,false);
    	edu.ustb.sei.mde.graph.type.IStructuralFeatureEdge le_type = typeGraph.getTypeEdge((edu.ustb.sei.mde.graph.type.TypeNode) l_type,"elements");
    	pattern_15.appendPatternEdge("le", "l", "e", le_type);
    	edu.ustb.sei.mde.graph.type.IStructuralFeatureEdge lv_type = typeGraph.getPropertyEdge((edu.ustb.sei.mde.graph.type.TypeNode) e_type,"value");
    	pattern_15.appendPatternEdge("lv", "e", "v", lv_type);
    	pattern_15.addAdditionalField(getType_4().getField("afterE"));
    	pattern_15.setType(getType_4());
    	pattern_15.setOrderBy((edu.ustb.sei.mde.graph.pattern.PatternElement) pattern_15.getPatternElement("le"));
    	pattern_15.setPivot(pattern_15.getAdditionalField("afterE").first, true);
    }
    return pattern_15;
  }
  
  private Pattern pattern_16;
  
  public Pattern getPattern_16() {
    if(pattern_16==null) {
    	edu.ustb.sei.mde.graph.type.TypeGraph typeGraph = getTypeGraph_L1();
    	pattern_16 = new edu.ustb.sei.mde.graph.pattern.Pattern(typeGraph);
    	edu.ustb.sei.mde.graph.type.ITypeNode l_type = typeGraph.getTypeNode("List")
    	;
    	pattern_16.appendPatternNode("l", l_type,false);
    	edu.ustb.sei.mde.graph.type.ITypeNode e_type = typeGraph.getTypeNode("Element")
    	;
    	pattern_16.appendPatternNode("e", e_type,false);
    	edu.ustb.sei.mde.graph.type.ITypeNode v_type = typeGraph.getDataTypeNode("EString")
    	;
    	pattern_16.appendPatternNode("v", v_type,false);
    	edu.ustb.sei.mde.graph.type.IStructuralFeatureEdge le_type = typeGraph.getTypeEdge((edu.ustb.sei.mde.graph.type.TypeNode) l_type,"elements");
    	pattern_16.appendPatternEdge("le", "l", "e", le_type);
    	edu.ustb.sei.mde.graph.type.IStructuralFeatureEdge lv_type = typeGraph.getPropertyEdge((edu.ustb.sei.mde.graph.type.TypeNode) e_type,"value");
    	pattern_16.appendPatternEdge("lv", "e", "v", lv_type);
    	pattern_16.addAdditionalField(getType_11().getField("beforeE"));
    	pattern_16.setType(getType_11());
    	pattern_16.setOrderBy((edu.ustb.sei.mde.graph.pattern.PatternElement) pattern_16.getPatternElement("le"));
    	pattern_16.setPivot(pattern_16.getAdditionalField("beforeE").first, false);
    }
    return pattern_16;
  }
  
  private XmuCore xmu_List2List;
  
  public XmuCore getXmu_List2List() throws BidirectionalTransformationDefinitionException {
    if(xmu_List2List==null) {
    xmu_List2List = new edu.ustb.sei.mde.bxcore.MatchSource("xmu0", getType_0(), getPattern_0(),
    new edu.ustb.sei.mde.bxcore.MatchView("xmu1", getType_1(), getPattern_1(),
      new edu.ustb.sei.mde.bxcore.ParallelComposition("xmu2", getType_2(), getType_3(), new edu.ustb.sei.mde.bxcore.XmuCore[] {
        new edu.ustb.sei.mde.bxcore.GraphReplace("xmu3", getPattern_2(), getPattern_3(), new edu.ustb.sei.mde.structure.Tuple3[]{edu.ustb.sei.mde.structure.Tuple3.make(new String[]{"firstE"}, new String[]{"firstE"}, new BiGULForceBegin())})
          ,
          new edu.ustb.sei.mde.bxcore.Invocation("xmu4", getType_2(), getType_3(), new edu.ustb.sei.mde.structure.Tuple2[]{edu.ustb.sei.mde.structure.Tuple2.make("l","l"),edu.ustb.sei.mde.structure.Tuple2.make("firstE","afterE")}, new edu.ustb.sei.mde.structure.Tuple2[]{edu.ustb.sei.mde.structure.Tuple2.make("l","l"),edu.ustb.sei.mde.structure.Tuple2.make("firstE","afterE")},()->{try {
          					return getXmu_Element2Element();
          				} catch(Exception e){
          					e.printStackTrace();
          					return null;
          				}})
          })
        )
      );
    }
    return xmu_List2List;
  }
  
  public ContextType getType_SrcListElement() {
    return getType_4();
  }
  
  public Pattern srcListElement() {
    return getPattern_4();
  }
  
  public class BiGULForceBegin extends BidirectionalTransformation<Object[], Object[]> {
    private Object s_val;
    
    private Object v_val;
    
    private void internalGet() {
      this.v_val = XmuProgram.BEGIN;
    }
    
    private void internalPut() {
      try {
        if ((this.v_val != XmuProgram.BEGIN)) {
          this.<Object>nothing();
        }
      } catch (Throwable _e) {
        throw Exceptions.sneakyThrow(_e);
      }
    }
    
    public Object[] forward(final Object[] s) {
      s_val = (java.lang.Object) s[0];
      internalGet();
      return new Object[]{v_val};
    }
    
    public Object[] backward(final Object[] s, final Object[] v) {
      s_val = (java.lang.Object) s[0];
      v_val = (java.lang.Object) v[0];
      internalPut();
      return new Object[]{s_val};
    }
  }
  
  private XmuCore xmu_Element2Element;
  
  public XmuCore getXmu_Element2Element() throws BidirectionalTransformationDefinitionException {
    if(xmu_Element2Element==null) {
    xmu_Element2Element = new edu.ustb.sei.mde.bxcore.Switch("xmu5", getType_5(), getType_6(), 
    java.util.Arrays.asList(
      edu.ustb.sei.mde.structure.Tuple3.make(new Condition0(), 
        new edu.ustb.sei.mde.bxcore.GraphReplace("xmu6", getPattern_5(), getPattern_6(), new edu.ustb.sei.mde.structure.Tuple3[]{})
          , (java.util.function.Function<edu.ustb.sei.mde.bxcore.SourceType, java.lang.Boolean>) null)
          , edu.ustb.sei.mde.structure.Tuple3.make(new Condition1(), 
        new edu.ustb.sei.mde.bxcore.MatchSource("xmu7", getType_5(), srcListElement(),
          new edu.ustb.sei.mde.bxcore.MatchView("xmu8", getType_6(), getPattern_7(),
            new edu.ustb.sei.mde.bxcore.ParallelComposition("xmu9", getType_4(), getType_7(), new edu.ustb.sei.mde.bxcore.XmuCore[] {
              new edu.ustb.sei.mde.bxcore.GraphReplace("xmu10", srcListElement(), getPattern_8(), new edu.ustb.sei.mde.structure.Tuple3[]{edu.ustb.sei.mde.structure.Tuple3.make(new String[]{"v"}, new String[]{"v"}, new edu.ustb.sei.mde.bxcore.bigul.Replace<java.lang.Object[]>()),edu.ustb.sei.mde.structure.Tuple3.make(new String[]{"afterE"}, new String[]{"afterE"}, new BiGULForceBegin())})
                ,
                new edu.ustb.sei.mde.bxcore.Invocation("xmu11", getType_U1(), getType_U3(), new edu.ustb.sei.mde.structure.Tuple2[]{edu.ustb.sei.mde.structure.Tuple2.make("l","l"),edu.ustb.sei.mde.structure.Tuple2.make("le","afterE")}, new edu.ustb.sei.mde.structure.Tuple2[]{edu.ustb.sei.mde.structure.Tuple2.make("l","l"),edu.ustb.sei.mde.structure.Tuple2.make("e","afterE")},()->{try {
                					return getXmu_Element2Element();
                				} catch(Exception e){
                					e.printStackTrace();
                					return null;
                				}})
                })
              )
            ), (java.util.function.Function<edu.ustb.sei.mde.bxcore.SourceType, java.lang.Boolean>) null)
          , edu.ustb.sei.mde.structure.Tuple3.make(new Condition3(), 
        new edu.ustb.sei.mde.bxcore.MatchSource("xmu12", getType_5(), srcListElement(),
          new edu.ustb.sei.mde.bxcore.MatchView("xmu13", getType_6(), getPattern_9(),
            new edu.ustb.sei.mde.bxcore.ParallelComposition("xmu14", getType_4(), getType_8(), new edu.ustb.sei.mde.bxcore.XmuCore[] {
              new edu.ustb.sei.mde.bxcore.GraphReplace("xmu15", srcListElement(), getPattern_10(), new edu.ustb.sei.mde.structure.Tuple3[]{edu.ustb.sei.mde.structure.Tuple3.make(new String[]{"v"}, new String[]{"v"}, new edu.ustb.sei.mde.bxcore.bigul.Replace<java.lang.Object[]>())})
                ,
                new edu.ustb.sei.mde.bxcore.Invocation("xmu16", getType_U1(), getType_U3(), new edu.ustb.sei.mde.structure.Tuple2[]{edu.ustb.sei.mde.structure.Tuple2.make("l","l"),edu.ustb.sei.mde.structure.Tuple2.make("le","afterE")}, new edu.ustb.sei.mde.structure.Tuple2[]{edu.ustb.sei.mde.structure.Tuple2.make("l","l"),edu.ustb.sei.mde.structure.Tuple2.make("e","afterE")},()->{try {
                					return getXmu_Element2Element();
                				} catch(Exception e){
                					e.printStackTrace();
                					return null;
                				}})
                })
              )
            ), (java.util.function.Function<edu.ustb.sei.mde.bxcore.SourceType, java.lang.Boolean>) null)
          ),
        java.util.Arrays.asList(edu.ustb.sei.mde.structure.Tuple2.make(new Condition4(), 
      new UnidirectionalAction2())
        , edu.ustb.sei.mde.structure.Tuple2.make(new Condition5(), 
      new UnidirectionalAction3())
        , edu.ustb.sei.mde.structure.Tuple2.make(new Condition6(), 
      new UnidirectionalAction4())
        ))
      ;
    }
    return xmu_Element2Element;
  }
}
