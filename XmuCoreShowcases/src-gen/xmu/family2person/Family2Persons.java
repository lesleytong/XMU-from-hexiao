package xmu.family2person;

import edu.ustb.sei.mde.bxcore.IndexSignature;
import edu.ustb.sei.mde.bxcore.SourceType;
import edu.ustb.sei.mde.bxcore.ViewType;
import edu.ustb.sei.mde.bxcore.XmuCore;
import edu.ustb.sei.mde.bxcore.bigul.BidirectionalTransformation;
import edu.ustb.sei.mde.bxcore.exceptions.BidirectionalTransformationDefinitionException;
import edu.ustb.sei.mde.bxcore.exceptions.NothingReturnedException;
import edu.ustb.sei.mde.bxcore.structures.ContextGraph;
import edu.ustb.sei.mde.bxcore.structures.ContextType;
import edu.ustb.sei.mde.bxcore.structures.GraphPath;
import edu.ustb.sei.mde.bxcore.structures.IndexPath;
import edu.ustb.sei.mde.bxcore.util.XmuProgram;
import edu.ustb.sei.mde.graph.IEdge;
import edu.ustb.sei.mde.graph.pattern.Pattern;
import edu.ustb.sei.mde.graph.type.IPathType;
import edu.ustb.sei.mde.graph.type.TypeGraph;
import edu.ustb.sei.mde.graph.typedGraph.IndexableElement;
import edu.ustb.sei.mde.graph.typedGraph.TypedEdge;
import edu.ustb.sei.mde.graph.typedGraph.TypedGraph;
import edu.ustb.sei.mde.graph.typedGraph.TypedNode;
import edu.ustb.sei.mde.structure.Tuple2;
import java.util.Collections;
import java.util.List;
import java.util.function.BiFunction;
import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

@SuppressWarnings("all")
public class Family2Persons extends XmuProgram {
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
  
  private TypeGraph typeGraph_FR;
  
  public TypeGraph getTypeGraph_FR() {
    if(typeGraph_FR==null) {
    	typeGraph_FR = new edu.ustb.sei.mde.graph.type.TypeGraph();
    	typeGraph_FR.declare("FamilyRegister");
    	typeGraph_FR.declare("Family");
    	typeGraph_FR.declare("Member");
    	typeGraph_FR.declare("EString:java.lang.String");
    	typeGraph_FR.declare("name:Family->EString");
    	typeGraph_FR.declare("name:Member->EString");
    	typeGraph_FR.declare("@families:FamilyRegister->Family*");
    	typeGraph_FR.declare("@mother:Family->Member");
    	typeGraph_FR.declare("@father:Family->Member");
    	typeGraph_FR.declare("@son:Family->Member*");
    	typeGraph_FR.declare("@daughter:Family->Member*");
    }
    return typeGraph_FR;
  }
  
  public void registerFRPackage(final URI metamodelUri) {
    registerPackage("FR", metamodelUri);
  }
  
  public TypedGraph loadFRModel(final URI modelUri) {
    org.eclipse.emf.ecore.EPackage pack = getPackage("FR");
    java.util.List<org.eclipse.emf.ecore.EObject> roots = edu.ustb.sei.mde.bxcore.util.EcoreModelUtil.load(modelUri);
    edu.ustb.sei.mde.graph.typedGraph.TypedGraph graph = edu.ustb.sei.mde.bxcore.util.EcoreModelUtil.load(roots, getTypeGraph_FR());
    return graph;
  }
  
  public void saveFRModel(final URI uri, final ContextGraph data, final TypedGraph originalGraph) throws NothingReturnedException, BidirectionalTransformationDefinitionException {
    edu.ustb.sei.mde.bxcore.util.EcoreModelUtil.save(uri, data.getGraph(), originalGraph, getPackage("FR"));
  }
  
  public void saveFRModel(final URI uri, final ContextGraph data) throws NothingReturnedException, BidirectionalTransformationDefinitionException {
    edu.ustb.sei.mde.bxcore.util.EcoreModelUtil.save(uri, data.getGraph(), null, getPackage("FR"));
  }
  
  private TypeGraph typeGraph_PR;
  
  public TypeGraph getTypeGraph_PR() {
    if(typeGraph_PR==null) {
    	typeGraph_PR = new edu.ustb.sei.mde.graph.type.TypeGraph();
    	typeGraph_PR.declare("PersonsRegister");
    	typeGraph_PR.declare("Person");
    	typeGraph_PR.declare("EString:java.lang.String");
    	typeGraph_PR.declare("lastName:Person->EString");
    	typeGraph_PR.declare("identity:Person->EString");
    	typeGraph_PR.declare("firstName:Person->EString");
    	typeGraph_PR.declare("@persons:PersonsRegister->Person*");
    }
    return typeGraph_PR;
  }
  
  public void registerPRPackage(final URI metamodelUri) {
    registerPackage("PR", metamodelUri);
  }
  
  public TypedGraph loadPRModel(final URI modelUri) {
    org.eclipse.emf.ecore.EPackage pack = getPackage("PR");
    java.util.List<org.eclipse.emf.ecore.EObject> roots = edu.ustb.sei.mde.bxcore.util.EcoreModelUtil.load(modelUri);
    edu.ustb.sei.mde.graph.typedGraph.TypedGraph graph = edu.ustb.sei.mde.bxcore.util.EcoreModelUtil.load(roots, getTypeGraph_PR());
    return graph;
  }
  
  public void savePRModel(final URI uri, final ContextGraph data, final TypedGraph originalGraph) throws NothingReturnedException, BidirectionalTransformationDefinitionException {
    edu.ustb.sei.mde.bxcore.util.EcoreModelUtil.save(uri, data.getGraph(), originalGraph, getPackage("PR"));
  }
  
  public void savePRModel(final URI uri, final ContextGraph data) throws NothingReturnedException, BidirectionalTransformationDefinitionException {
    edu.ustb.sei.mde.bxcore.util.EcoreModelUtil.save(uri, data.getGraph(), null, getPackage("PR"));
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
  
  public class Condition0 implements BiFunction<ContextGraph, ContextGraph, Boolean> {
    public Boolean apply(final ContextGraph source, final ContextGraph view) {
      return Boolean.valueOf((((java.lang.String) edu.ustb.sei.mde.bxcore.dsl.structure.ExceptionSafeInferface.getValue(source,"nn")).equals(((java.lang.String) edu.ustb.sei.mde.bxcore.dsl.structure.ExceptionSafeInferface.getValue(view,"firstn"))) && ((java.lang.String) edu.ustb.sei.mde.bxcore.dsl.structure.ExceptionSafeInferface.getValue(source,"n")).equals(((java.lang.String) edu.ustb.sei.mde.bxcore.dsl.structure.ExceptionSafeInferface.getValue(view,"lastn")))));
    }
  }
  
  public class UnidirectionalAction0 implements BiFunction<SourceType, ViewType, SourceType> {
    public SourceType apply(final SourceType source, final ViewType view) {
      edu.ustb.sei.mde.bxcore.structures.GraphModification _modStart = source.modification();
      edu.ustb.sei.mde.bxcore.structures.GraphPath _contextValue = ((edu.ustb.sei.mde.bxcore.structures.GraphPath) edu.ustb.sei.mde.bxcore.dsl.structure.ExceptionSafeInferface.getValue(source,"lp"));
      IEdge _get = _contextValue.getPathEdges()[0];
      edu.ustb.sei.mde.bxcore.structures.GraphModification _mod = _modStart.remove(((IndexableElement) _get));
      _modStart = _mod;
      edu.ustb.sei.mde.graph.typedGraph.ValueEdge _contextValue_1 = ((edu.ustb.sei.mde.graph.typedGraph.ValueEdge) edu.ustb.sei.mde.bxcore.dsl.structure.ExceptionSafeInferface.getValue(source,"lnn"));
      edu.ustb.sei.mde.bxcore.structures.GraphModification _mod_1 = _modStart.remove(_contextValue_1);
      _modStart = _mod_1;
      edu.ustb.sei.mde.graph.typedGraph.TypedNode _contextValue_2 = ((edu.ustb.sei.mde.graph.typedGraph.TypedNode) edu.ustb.sei.mde.bxcore.dsl.structure.ExceptionSafeInferface.getValue(source,"m"));
      edu.ustb.sei.mde.bxcore.structures.GraphModification _mod_2 = _modStart.remove(_contextValue_2);
      _modStart = _mod_2;
      return _modStart.get();
    }
  }
  
  public class UnidirectionalAction1 implements BiFunction<SourceType, ViewType, SourceType> {
    public SourceType apply(final SourceType source, final ViewType view) {
      SourceType _xblockexpression = null;
      {
        final TypeGraph typeGraph = source.first.getTypeGraph();
        final IPathType pathType = typeGraph.resolvePathType("Family::(father|mother|son|daughter){1,1}");
        edu.ustb.sei.mde.graph.typedGraph.TypedNode _contextValue = ((edu.ustb.sei.mde.graph.typedGraph.TypedNode) edu.ustb.sei.mde.bxcore.dsl.structure.ExceptionSafeInferface.getValue(source,"x"));
        
        java.util.List<edu.ustb.sei.mde.graph.typedGraph.TypedNode> _navExp = edu.ustb.sei.mde.bxcore.dsl.structure.ExceptionSafeInferface.navigate(source, _contextValue, "families", true, true, true);
        final Function1<TypedNode, Boolean> _function = (TypedNode fm) -> {
          java.lang.String _contextValue_1 = ((java.lang.String) edu.ustb.sei.mde.bxcore.dsl.structure.ExceptionSafeInferface.getValue(view,"lastn"));
          edu.ustb.sei.mde.graph.typedGraph.TypedNode _expValue = fm;
          
          java.lang.String _navExp_1 = edu.ustb.sei.mde.bxcore.dsl.structure.ExceptionSafeInferface.navigate(source, _expValue, "name", false, false, true);
          return Boolean.valueOf(_contextValue_1.equals(_navExp_1));
        };
        final TypedNode family = IterableExtensions.<TypedNode>findFirst(_navExp, _function);
        TypedNode n_f = null;
        TypedNode n_m = null;
        List<TypedEdge> _xifexpression = null;
        if ((family == null)) {
          List<TypedEdge> _xblockexpression_1 = null;
          {
            edu.ustb.sei.mde.graph.typedGraph.TypedNode newInstance = edu.ustb.sei.mde.bxcore.structures.ContextGraph.newTypedNode(source, "Family");
            final TypedNode nf = newInstance;
            edu.ustb.sei.mde.graph.typedGraph.TypedNode newInstance_1 = edu.ustb.sei.mde.bxcore.structures.ContextGraph.newTypedNode(source, "Member");
            final TypedNode nm = newInstance_1;
            n_f = nf;
            n_m = nm;
            TypedEdge _xifexpression_1 = null;
            java.lang.String _contextValue_1 = ((java.lang.String) edu.ustb.sei.mde.bxcore.dsl.structure.ExceptionSafeInferface.getValue(view,"id"));
            boolean _equals = _contextValue_1.equals("father");
            if (_equals) {
              edu.ustb.sei.mde.graph.typedGraph.TypedEdge newInstance_2 = edu.ustb.sei.mde.bxcore.structures.ContextGraph.newTypedEdge(source, "Family", "father",nf,nm);
              _xifexpression_1 = newInstance_2;
            } else {
              TypedEdge _xifexpression_2 = null;
              java.lang.String _contextValue_2 = ((java.lang.String) edu.ustb.sei.mde.bxcore.dsl.structure.ExceptionSafeInferface.getValue(view,"id"));
              boolean _equals_1 = _contextValue_2.equals("mother");
              if (_equals_1) {
                edu.ustb.sei.mde.graph.typedGraph.TypedEdge newInstance_3 = edu.ustb.sei.mde.bxcore.structures.ContextGraph.newTypedEdge(source, "Family", "mother",nf,nm);
                _xifexpression_2 = newInstance_3;
              } else {
                TypedEdge _xifexpression_3 = null;
                java.lang.String _contextValue_3 = ((java.lang.String) edu.ustb.sei.mde.bxcore.dsl.structure.ExceptionSafeInferface.getValue(view,"id"));
                boolean _equals_2 = _contextValue_3.equals("son");
                if (_equals_2) {
                  edu.ustb.sei.mde.graph.typedGraph.TypedEdge newInstance_4 = edu.ustb.sei.mde.bxcore.structures.ContextGraph.newTypedEdge(source, "Family", "son",nf,nm);
                  _xifexpression_3 = newInstance_4;
                } else {
                  TypedEdge _xifexpression_4 = null;
                  java.lang.String _contextValue_4 = ((java.lang.String) edu.ustb.sei.mde.bxcore.dsl.structure.ExceptionSafeInferface.getValue(view,"id"));
                  boolean _equals_3 = _contextValue_4.equals("daughter");
                  if (_equals_3) {
                    edu.ustb.sei.mde.graph.typedGraph.TypedEdge newInstance_5 = edu.ustb.sei.mde.bxcore.structures.ContextGraph.newTypedEdge(source, "Family", "daughter",nf,nm);
                    _xifexpression_4 = newInstance_5;
                  }
                  _xifexpression_3 = _xifexpression_4;
                }
                _xifexpression_2 = _xifexpression_3;
              }
              _xifexpression_1 = _xifexpression_2;
            }
            final TypedEdge e = _xifexpression_1;
            _xblockexpression_1 = Collections.<TypedEdge>unmodifiableList(CollectionLiterals.<TypedEdge>newArrayList(e));
          }
          _xifexpression = _xblockexpression_1;
        } else {
          List<TypedEdge> _xblockexpression_2 = null;
          {
            edu.ustb.sei.mde.graph.typedGraph.TypedNode newInstance = edu.ustb.sei.mde.bxcore.structures.ContextGraph.newTypedNode(source, "Member");
            final TypedNode nm = newInstance;
            n_f = family;
            n_m = nm;
            TypedEdge _xifexpression_1 = null;
            java.lang.String _contextValue_1 = ((java.lang.String) edu.ustb.sei.mde.bxcore.dsl.structure.ExceptionSafeInferface.getValue(view,"id"));
            boolean _equals = _contextValue_1.equals("father");
            if (_equals) {
              edu.ustb.sei.mde.graph.typedGraph.TypedEdge newInstance_1 = edu.ustb.sei.mde.bxcore.structures.ContextGraph.newTypedEdge(source, "Family", "father",family,nm);
              _xifexpression_1 = newInstance_1;
            } else {
              TypedEdge _xifexpression_2 = null;
              java.lang.String _contextValue_2 = ((java.lang.String) edu.ustb.sei.mde.bxcore.dsl.structure.ExceptionSafeInferface.getValue(view,"id"));
              boolean _equals_1 = _contextValue_2.equals("mother");
              if (_equals_1) {
                edu.ustb.sei.mde.graph.typedGraph.TypedEdge newInstance_2 = edu.ustb.sei.mde.bxcore.structures.ContextGraph.newTypedEdge(source, "Family", "mother",family,nm);
                _xifexpression_2 = newInstance_2;
              } else {
                TypedEdge _xifexpression_3 = null;
                java.lang.String _contextValue_3 = ((java.lang.String) edu.ustb.sei.mde.bxcore.dsl.structure.ExceptionSafeInferface.getValue(view,"id"));
                boolean _equals_2 = _contextValue_3.equals("son");
                if (_equals_2) {
                  edu.ustb.sei.mde.graph.typedGraph.TypedEdge newInstance_3 = edu.ustb.sei.mde.bxcore.structures.ContextGraph.newTypedEdge(source, "Family", "son",family,nm);
                  _xifexpression_3 = newInstance_3;
                } else {
                  TypedEdge _xifexpression_4 = null;
                  java.lang.String _contextValue_4 = ((java.lang.String) edu.ustb.sei.mde.bxcore.dsl.structure.ExceptionSafeInferface.getValue(view,"id"));
                  boolean _equals_3 = _contextValue_4.equals("daughter");
                  if (_equals_3) {
                    edu.ustb.sei.mde.graph.typedGraph.TypedEdge newInstance_4 = edu.ustb.sei.mde.bxcore.structures.ContextGraph.newTypedEdge(source, "Family", "daughter",family,nm);
                    _xifexpression_4 = newInstance_4;
                  }
                  _xifexpression_3 = _xifexpression_4;
                }
                _xifexpression_2 = _xifexpression_3;
              }
              _xifexpression_1 = _xifexpression_2;
            }
            final TypedEdge e = _xifexpression_1;
            _xblockexpression_2 = Collections.<TypedEdge>unmodifiableList(CollectionLiterals.<TypedEdge>newArrayList(e));
          }
          _xifexpression = _xblockexpression_2;
        }
        final List<TypedEdge> edges = _xifexpression;
        final GraphPath path = new GraphPath(((IEdge[])Conversions.unwrapArray(edges, IEdge.class)), pathType);
        java.lang.String _contextValue_1 = ((java.lang.String) edu.ustb.sei.mde.bxcore.dsl.structure.ExceptionSafeInferface.getValue(view,"lastn"));
        n_f.appendIndexValue(_contextValue_1);
        edu.ustb.sei.mde.bxcore.structures.GraphModification _modStart = source.modification();
        edu.ustb.sei.mde.bxcore.structures.GraphModification _mod = _modStart.insertTypedNode(n_f);_modStart = _mod;
        edu.ustb.sei.mde.bxcore.structures.GraphModification _mod_1 = _modStart.insertTypedNode(n_m);_modStart = _mod_1;
        java.lang.String _contextValue_2 = ((java.lang.String) edu.ustb.sei.mde.bxcore.dsl.structure.ExceptionSafeInferface.getValue(view,"lastn"));
        java.lang.String _contextValue_3 = ((java.lang.String) edu.ustb.sei.mde.bxcore.dsl.structure.ExceptionSafeInferface.getValue(view,"firstn"));
        edu.ustb.sei.mde.bxcore.structures.GraphModification _mod_2 = _modStart.enforce(getPattern_4(), new edu.ustb.sei.mde.structure.Tuple2[] {edu.ustb.sei.mde.structure.Tuple2.make("n",_contextValue_2),edu.ustb.sei.mde.structure.Tuple2.make("nn",_contextValue_3),edu.ustb.sei.mde.structure.Tuple2.make("lp",path),edu.ustb.sei.mde.structure.Tuple2.make("f",n_f),edu.ustb.sei.mde.structure.Tuple2.make("m",n_m)});
        _modStart = _mod_2;
        _xblockexpression = _modStart.get();
      }
      return _xblockexpression;
    }
  }
  
  /**
   * id:5
   */
  private ContextType type_5;
  
  public ContextType getType_5() {
    if(type_5==null) {
    	edu.ustb.sei.mde.graph.type.TypeGraph typeGraph = getTypeGraph_PR();
    	type_5 = new edu.ustb.sei.mde.bxcore.structures.ContextType();
    	edu.ustb.sei.mde.graph.type.IType firstn_type = typeGraph.getDataTypeNode("EString")
    	;
    	type_5.addField("firstn", firstn_type, false);
    	edu.ustb.sei.mde.graph.type.IType id_type = typeGraph.getDataTypeNode("EString")
    	;
    	type_5.addField("id", id_type, false);
    	edu.ustb.sei.mde.graph.type.IType lastn_type = typeGraph.getDataTypeNode("EString")
    	;
    	type_5.addField("lastn", lastn_type, false);
    	edu.ustb.sei.mde.graph.type.IType lfn_type = typeGraph.getPropertyEdge(typeGraph.getTypeNode("Person"),"firstName")
    	;
    	type_5.addField("lfn", lfn_type, false);
    	edu.ustb.sei.mde.graph.type.IType li_type = typeGraph.getPropertyEdge(typeGraph.getTypeNode("Person"),"identity")
    	;
    	type_5.addField("li", li_type, false);
    	edu.ustb.sei.mde.graph.type.IType lln_type = typeGraph.getPropertyEdge(typeGraph.getTypeNode("Person"),"lastName")
    	;
    	type_5.addField("lln", lln_type, false);
    	edu.ustb.sei.mde.graph.type.IType lp_type = typeGraph.getTypeEdge(typeGraph.getTypeNode("PersonsRegister"),"persons")
    	;
    	type_5.addField("lp", lp_type, false);
    	edu.ustb.sei.mde.graph.type.IType p_type = typeGraph.getTypeNode("Person")
    	;
    	type_5.addField("p", p_type, false);
    	edu.ustb.sei.mde.graph.type.IType y_type = typeGraph.getTypeNode("PersonsRegister")
    	;
    	type_5.addField("y", y_type, false);
    }
    return type_5;
  }
  
  /**
   * id:4
   */
  private ContextType type_4;
  
  public ContextType getType_4() {
    if(type_4==null) {
    	edu.ustb.sei.mde.graph.type.TypeGraph typeGraph = getTypeGraph_FR();
    	type_4 = new edu.ustb.sei.mde.bxcore.structures.ContextType();
    	edu.ustb.sei.mde.graph.type.IType f_type = typeGraph.getTypeNode("Family")
    	;
    	type_4.addField("f", f_type, false);
    	edu.ustb.sei.mde.graph.type.IType lf_type = typeGraph.getTypeEdge(typeGraph.getTypeNode("FamilyRegister"),"families")
    	;
    	type_4.addField("lf", lf_type, false);
    	edu.ustb.sei.mde.graph.type.IType ln_type = typeGraph.getPropertyEdge(typeGraph.getTypeNode("Family"),"name")
    	;
    	type_4.addField("ln", ln_type, false);
    	edu.ustb.sei.mde.graph.type.IType lnn_type = typeGraph.getPropertyEdge(typeGraph.getTypeNode("Member"),"name")
    	;
    	type_4.addField("lnn", lnn_type, false);
    	edu.ustb.sei.mde.graph.type.IType lp_type = getPathType_0()
    	;
    	type_4.addField("lp", lp_type, false);
    	edu.ustb.sei.mde.graph.type.IType m_type = typeGraph.getTypeNode("Member")
    	;
    	type_4.addField("m", m_type, false);
    	edu.ustb.sei.mde.graph.type.IType n_type = typeGraph.getDataTypeNode("EString")
    	;
    	type_4.addField("n", n_type, false);
    	edu.ustb.sei.mde.graph.type.IType nn_type = typeGraph.getDataTypeNode("EString")
    	;
    	type_4.addField("nn", nn_type, false);
    	edu.ustb.sei.mde.graph.type.IType x_type = typeGraph.getTypeNode("FamilyRegister")
    	;
    	type_4.addField("x", x_type, false);
    }
    return type_4;
  }
  
  /**
   * id:0
   */
  private ContextType type_0;
  
  public ContextType getType_0() {
    if(type_0==null) {
    	edu.ustb.sei.mde.graph.type.TypeGraph typeGraph = getTypeGraph_FR();
    	type_0 = new edu.ustb.sei.mde.bxcore.structures.ContextType();
    	edu.ustb.sei.mde.graph.type.IType f_type = typeGraph.getTypeNode("Family")
    	;
    	type_0.addField("f", f_type, false);
    }
    return type_0;
  }
  
  /**
   * id:1
   */
  private ContextType type_1;
  
  public ContextType getType_1() {
    if(type_1==null) {
    	edu.ustb.sei.mde.graph.type.TypeGraph typeGraph = getTypeGraph_PR();
    	type_1 = new edu.ustb.sei.mde.bxcore.structures.ContextType();
    	edu.ustb.sei.mde.graph.type.IType s_type = typeGraph.getDataTypeNode("EString")
    	;
    	type_1.addField("s", s_type, false);
    }
    return type_1;
  }
  
  /**
   * id:2
   */
  private ContextType type_2;
  
  public ContextType getType_2() {
    if(type_2==null) {
    	edu.ustb.sei.mde.graph.type.TypeGraph typeGraph = getTypeGraph_FR();
    	type_2 = new edu.ustb.sei.mde.bxcore.structures.ContextType();
    	edu.ustb.sei.mde.graph.type.IType x_type = typeGraph.getTypeNode("FamilyRegister")
    	;
    	type_2.addField("x", x_type, false);
    }
    return type_2;
  }
  
  /**
   * id:3
   */
  private ContextType type_3;
  
  public ContextType getType_3() {
    if(type_3==null) {
    	edu.ustb.sei.mde.graph.type.TypeGraph typeGraph = getTypeGraph_PR();
    	type_3 = new edu.ustb.sei.mde.bxcore.structures.ContextType();
    	edu.ustb.sei.mde.graph.type.IType y_type = typeGraph.getTypeNode("PersonsRegister")
    	;
    	type_3.addField("y", y_type, false);
    }
    return type_3;
  }
  
  private Pattern pattern_0;
  
  public Pattern getPattern_0() {
    if(pattern_0==null) {
    	edu.ustb.sei.mde.graph.type.TypeGraph typeGraph = getTypeGraph_FR();
    	pattern_0 = new edu.ustb.sei.mde.graph.pattern.Pattern(typeGraph);
    	edu.ustb.sei.mde.graph.type.ITypeNode x_type = typeGraph.getTypeNode("FamilyRegister")
    	;
    	pattern_0.appendPatternNode("x", x_type,false);
    	edu.ustb.sei.mde.graph.type.ITypeNode f_type = typeGraph.getTypeNode("Family")
    	;
    	pattern_0.appendPatternNode("f", f_type,false);
    	edu.ustb.sei.mde.graph.type.ITypeNode n_type = typeGraph.getDataTypeNode("EString")
    	;
    	pattern_0.appendPatternNode("n", n_type,false);
    	edu.ustb.sei.mde.graph.type.ITypeNode m_type = typeGraph.getTypeNode("Member")
    	;
    	pattern_0.appendPatternNode("m", m_type,false);
    	edu.ustb.sei.mde.graph.type.ITypeNode nn_type = typeGraph.getDataTypeNode("EString")
    	;
    	pattern_0.appendPatternNode("nn", nn_type,false);
    	edu.ustb.sei.mde.graph.type.IStructuralFeatureEdge lf_type = typeGraph.getTypeEdge((edu.ustb.sei.mde.graph.type.TypeNode) x_type,"families");
    	pattern_0.appendPatternEdge("lf", "x", "f", lf_type);
    	edu.ustb.sei.mde.graph.type.IStructuralFeatureEdge ln_type = typeGraph.getPropertyEdge((edu.ustb.sei.mde.graph.type.TypeNode) f_type,"name");
    	pattern_0.appendPatternEdge("ln", "f", "n", ln_type);
    	edu.ustb.sei.mde.graph.type.IPathType lp_type = getPathType_0()
    	;
    	pattern_0.appendPatternEdge("lp", "f", "m", lp_type);
    	edu.ustb.sei.mde.graph.type.IStructuralFeatureEdge lnn_type = typeGraph.getPropertyEdge((edu.ustb.sei.mde.graph.type.TypeNode) m_type,"name");
    	pattern_0.appendPatternEdge("lnn", "m", "nn", lnn_type);
    	pattern_0.setType(getType_4());
    }
    return pattern_0;
  }
  
  private Pattern pattern_1;
  
  public Pattern getPattern_1() {
    if(pattern_1==null) {
    	edu.ustb.sei.mde.graph.type.TypeGraph typeGraph = getTypeGraph_PR();
    	pattern_1 = new edu.ustb.sei.mde.graph.pattern.Pattern(typeGraph);
    	edu.ustb.sei.mde.graph.type.ITypeNode y_type = typeGraph.getTypeNode("PersonsRegister")
    	;
    	pattern_1.appendPatternNode("y", y_type,false);
    	edu.ustb.sei.mde.graph.type.ITypeNode p_type = typeGraph.getTypeNode("Person")
    	;
    	pattern_1.appendPatternNode("p", p_type,false);
    	edu.ustb.sei.mde.graph.type.ITypeNode id_type = typeGraph.getDataTypeNode("EString")
    	;
    	pattern_1.appendPatternNode("id", id_type,false);
    	edu.ustb.sei.mde.graph.type.ITypeNode lastn_type = typeGraph.getDataTypeNode("EString")
    	;
    	pattern_1.appendPatternNode("lastn", lastn_type,false);
    	edu.ustb.sei.mde.graph.type.ITypeNode firstn_type = typeGraph.getDataTypeNode("EString")
    	;
    	pattern_1.appendPatternNode("firstn", firstn_type,false);
    	edu.ustb.sei.mde.graph.type.IStructuralFeatureEdge lp_type = typeGraph.getTypeEdge((edu.ustb.sei.mde.graph.type.TypeNode) y_type,"persons");
    	pattern_1.appendPatternEdge("lp", "y", "p", lp_type);
    	edu.ustb.sei.mde.graph.type.IStructuralFeatureEdge li_type = typeGraph.getPropertyEdge((edu.ustb.sei.mde.graph.type.TypeNode) p_type,"identity");
    	pattern_1.appendPatternEdge("li", "p", "id", li_type);
    	edu.ustb.sei.mde.graph.type.IStructuralFeatureEdge lln_type = typeGraph.getPropertyEdge((edu.ustb.sei.mde.graph.type.TypeNode) p_type,"lastName");
    	pattern_1.appendPatternEdge("lln", "p", "lastn", lln_type);
    	edu.ustb.sei.mde.graph.type.IStructuralFeatureEdge lfn_type = typeGraph.getPropertyEdge((edu.ustb.sei.mde.graph.type.TypeNode) p_type,"firstName");
    	pattern_1.appendPatternEdge("lfn", "p", "firstn", lfn_type);
    	pattern_1.setType(getType_5());
    }
    return pattern_1;
  }
  
  private Pattern pattern_2;
  
  public Pattern getPattern_2() {
    if(pattern_2==null) {
    	edu.ustb.sei.mde.graph.type.TypeGraph typeGraph = getTypeGraph_FR();
    	pattern_2 = new edu.ustb.sei.mde.graph.pattern.Pattern(typeGraph);
    	edu.ustb.sei.mde.graph.type.ITypeNode x_type = typeGraph.getTypeNode("FamilyRegister")
    	;
    	pattern_2.appendPatternNode("x", x_type,false);
    	edu.ustb.sei.mde.graph.type.ITypeNode f_type = typeGraph.getTypeNode("Family")
    	;
    	pattern_2.appendPatternNode("f", f_type,false);
    	edu.ustb.sei.mde.graph.type.ITypeNode n_type = typeGraph.getDataTypeNode("EString")
    	;
    	pattern_2.appendPatternNode("n", n_type,false);
    	edu.ustb.sei.mde.graph.type.ITypeNode m_type = typeGraph.getTypeNode("Member")
    	;
    	pattern_2.appendPatternNode("m", m_type,false);
    	edu.ustb.sei.mde.graph.type.ITypeNode nn_type = typeGraph.getDataTypeNode("EString")
    	;
    	pattern_2.appendPatternNode("nn", nn_type,false);
    	edu.ustb.sei.mde.graph.type.IStructuralFeatureEdge lf_type = typeGraph.getTypeEdge((edu.ustb.sei.mde.graph.type.TypeNode) x_type,"families");
    	pattern_2.appendPatternEdge("lf", "x", "f", lf_type);
    	edu.ustb.sei.mde.graph.type.IStructuralFeatureEdge ln_type = typeGraph.getPropertyEdge((edu.ustb.sei.mde.graph.type.TypeNode) f_type,"name");
    	pattern_2.appendPatternEdge("ln", "f", "n", ln_type);
    	edu.ustb.sei.mde.graph.type.IPathType lp_type = getPathType_1()
    	;
    	pattern_2.appendPatternEdge("lp", "f", "m", lp_type);
    	edu.ustb.sei.mde.graph.type.IStructuralFeatureEdge lnn_type = typeGraph.getPropertyEdge((edu.ustb.sei.mde.graph.type.TypeNode) m_type,"name");
    	pattern_2.appendPatternEdge("lnn", "m", "nn", lnn_type);
    	pattern_2.setType(getType_4());
    }
    return pattern_2;
  }
  
  private Pattern pattern_3;
  
  public Pattern getPattern_3() {
    if(pattern_3==null) {
    	edu.ustb.sei.mde.graph.type.TypeGraph typeGraph = getTypeGraph_PR();
    	pattern_3 = new edu.ustb.sei.mde.graph.pattern.Pattern(typeGraph);
    	edu.ustb.sei.mde.graph.type.ITypeNode y_type = typeGraph.getTypeNode("PersonsRegister")
    	;
    	pattern_3.appendPatternNode("y", y_type,false);
    	edu.ustb.sei.mde.graph.type.ITypeNode p_type = typeGraph.getTypeNode("Person")
    	;
    	pattern_3.appendPatternNode("p", p_type,false);
    	edu.ustb.sei.mde.graph.type.ITypeNode id_type = typeGraph.getDataTypeNode("EString")
    	;
    	pattern_3.appendPatternNode("id", id_type,false);
    	edu.ustb.sei.mde.graph.type.ITypeNode lastn_type = typeGraph.getDataTypeNode("EString")
    	;
    	pattern_3.appendPatternNode("lastn", lastn_type,false);
    	edu.ustb.sei.mde.graph.type.ITypeNode firstn_type = typeGraph.getDataTypeNode("EString")
    	;
    	pattern_3.appendPatternNode("firstn", firstn_type,false);
    	edu.ustb.sei.mde.graph.type.IStructuralFeatureEdge lp_type = typeGraph.getTypeEdge((edu.ustb.sei.mde.graph.type.TypeNode) y_type,"persons");
    	pattern_3.appendPatternEdge("lp", "y", "p", lp_type);
    	edu.ustb.sei.mde.graph.type.IStructuralFeatureEdge li_type = typeGraph.getPropertyEdge((edu.ustb.sei.mde.graph.type.TypeNode) p_type,"identity");
    	pattern_3.appendPatternEdge("li", "p", "id", li_type);
    	edu.ustb.sei.mde.graph.type.IStructuralFeatureEdge lln_type = typeGraph.getPropertyEdge((edu.ustb.sei.mde.graph.type.TypeNode) p_type,"lastName");
    	pattern_3.appendPatternEdge("lln", "p", "lastn", lln_type);
    	edu.ustb.sei.mde.graph.type.IStructuralFeatureEdge lfn_type = typeGraph.getPropertyEdge((edu.ustb.sei.mde.graph.type.TypeNode) p_type,"firstName");
    	pattern_3.appendPatternEdge("lfn", "p", "firstn", lfn_type);
    	pattern_3.setType(getType_5());
    }
    return pattern_3;
  }
  
  private Pattern pattern_4;
  
  public Pattern getPattern_4() {
    if(pattern_4==null) {
    	edu.ustb.sei.mde.graph.type.TypeGraph typeGraph = getTypeGraph_FR();
    	pattern_4 = new edu.ustb.sei.mde.graph.pattern.Pattern(typeGraph);
    	edu.ustb.sei.mde.graph.type.ITypeNode x_type = typeGraph.getTypeNode("FamilyRegister")
    	;
    	pattern_4.appendPatternNode("x", x_type,false);
    	edu.ustb.sei.mde.graph.type.ITypeNode f_type = typeGraph.getTypeNode("Family")
    	;
    	pattern_4.appendPatternNode("f", f_type,false);
    	edu.ustb.sei.mde.graph.type.ITypeNode n_type = typeGraph.getDataTypeNode("EString")
    	;
    	pattern_4.appendPatternNode("n", n_type,false);
    	edu.ustb.sei.mde.graph.type.ITypeNode m_type = typeGraph.getTypeNode("Member")
    	;
    	pattern_4.appendPatternNode("m", m_type,false);
    	edu.ustb.sei.mde.graph.type.ITypeNode nn_type = typeGraph.getDataTypeNode("EString")
    	;
    	pattern_4.appendPatternNode("nn", nn_type,false);
    	edu.ustb.sei.mde.graph.type.IStructuralFeatureEdge lf_type = typeGraph.getTypeEdge((edu.ustb.sei.mde.graph.type.TypeNode) x_type,"families");
    	pattern_4.appendPatternEdge("lf", "x", "f", lf_type);
    	edu.ustb.sei.mde.graph.type.IStructuralFeatureEdge ln_type = typeGraph.getPropertyEdge((edu.ustb.sei.mde.graph.type.TypeNode) f_type,"name");
    	pattern_4.appendPatternEdge("ln", "f", "n", ln_type);
    	edu.ustb.sei.mde.graph.type.IPathType lp_type = getPathType_2()
    	;
    	pattern_4.appendPatternEdge("lp", "f", "m", lp_type);
    	edu.ustb.sei.mde.graph.type.IStructuralFeatureEdge lnn_type = typeGraph.getPropertyEdge((edu.ustb.sei.mde.graph.type.TypeNode) m_type,"name");
    	pattern_4.appendPatternEdge("lnn", "m", "nn", lnn_type);
    	pattern_4.setType(getType_4());
    }
    return pattern_4;
  }
  
  private IPathType pathType_0;
  
  public IPathType getPathType_0() {
    if(pathType_0==null) {
    	edu.ustb.sei.mde.graph.type.TypeGraph typeGraph = getTypeGraph_FR();
    	pathType_0 = edu.ustb.sei.mde.graph.type.DashedPathType.create(edu.ustb.sei.mde.graph.type.DashedPathTypeSegment.createOne(typeGraph.getTypeEdge(typeGraph.getTypeNode("Family"),"mother"),
    	typeGraph.getTypeEdge(typeGraph.getTypeNode("Family"),"father"),
    	typeGraph.getTypeEdge(typeGraph.getTypeNode("Family"),"son"),
    	typeGraph.getTypeEdge(typeGraph.getTypeNode("Family"),"daughter")
    	)
    	)
    	;
    }
    return pathType_0;
  }
  
  public IPathType getPathType_1() {
    return getPathType_0();
  }
  
  public IPathType getPathType_2() {
    return getPathType_0();
  }
  
  private IndexSignature index_f2p;
  
  public IndexSignature getIndex_F2p() {
    if(index_f2p==null) {
    	index_f2p = new edu.ustb.sei.mde.bxcore.IndexSignature("f2p", getType_0(), getType_1());
    }
    return index_f2p;
  }
  
  public class BiGULIdentity extends BidirectionalTransformation<Object[], Object[]> {
    private IndexPath p;
    
    private String id;
    
    private void internalGet() {
      IEdge _get = this.p.toGraphPathWithRecovery(null).getPathEdges()[0];
      this.id = ((TypedEdge) _get).getType().getName();
    }
    
    private void internalPut() {
      try {
        IEdge _get = this.p.toGraphPathWithRecovery(null).getPathEdges()[0];
        final String nid = ((TypedEdge) _get).getType().getName();
        boolean _equals = nid.equals(this.id);
        boolean _not = (!_equals);
        if (_not) {
          this.<Object>nothing();
        }
      } catch (Throwable _e) {
        throw Exceptions.sneakyThrow(_e);
      }
    }
    
    public Object[] forward(final Object[] s) {
      p = (edu.ustb.sei.mde.bxcore.structures.IndexPath) s[0];
      internalGet();
      return new Object[]{id};
    }
    
    public Object[] backward(final Object[] s, final Object[] v) {
      p = (edu.ustb.sei.mde.bxcore.structures.IndexPath) s[0];
      id = (java.lang.String) v[0];
      internalPut();
      return new Object[]{p};
    }
  }
  
  private XmuCore xmu_Father2Person;
  
  public XmuCore getXmu_Father2Person() throws BidirectionalTransformationDefinitionException {
    if(xmu_Father2Person==null) {
    xmu_Father2Person = new edu.ustb.sei.mde.bxcore.Align("xmu0", getType_2(), getType_3(), getPattern_0(), getPattern_1(), new Condition0(), 
    new edu.ustb.sei.mde.bxcore.GraphReplace("xmu1", getPattern_2(), getPattern_3(), new edu.ustb.sei.mde.structure.Tuple3[]{edu.ustb.sei.mde.structure.Tuple3.make(new String[]{"n","nn"}, new String[]{"lastn","firstn"}, new edu.ustb.sei.mde.bxcore.bigul.Replace<java.lang.Object[]>()),edu.ustb.sei.mde.structure.Tuple3.make(new String[]{"lp"}, new String[]{"id"}, new BiGULIdentity())})
      , new UnidirectionalAction0(), new UnidirectionalAction1());
      }
      return xmu_Father2Person;
    }
  }
  