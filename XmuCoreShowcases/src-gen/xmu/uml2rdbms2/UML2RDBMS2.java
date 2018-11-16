package xmu.uml2rdbms2;

import edu.ustb.sei.mde.bxcore.IndexSignature;
import edu.ustb.sei.mde.bxcore.SourceType;
import edu.ustb.sei.mde.bxcore.ViewType;
import edu.ustb.sei.mde.bxcore.XmuCore;
import edu.ustb.sei.mde.bxcore.bigul.BidirectionalTransformation;
import edu.ustb.sei.mde.bxcore.dsl.structure.ExceptionSafeInferface;
import edu.ustb.sei.mde.bxcore.exceptions.BidirectionalTransformationDefinitionException;
import edu.ustb.sei.mde.bxcore.exceptions.NothingReturnedException;
import edu.ustb.sei.mde.bxcore.structures.Context;
import edu.ustb.sei.mde.bxcore.structures.ContextGraph;
import edu.ustb.sei.mde.bxcore.structures.ContextType;
import edu.ustb.sei.mde.bxcore.util.XmuProgram;
import edu.ustb.sei.mde.graph.pattern.Pattern;
import edu.ustb.sei.mde.graph.type.TypeGraph;
import edu.ustb.sei.mde.graph.typedGraph.TypedGraph;
import edu.ustb.sei.mde.graph.typedGraph.TypedNode;
import edu.ustb.sei.mde.structure.Tuple2;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

@SuppressWarnings("all")
public class UML2RDBMS2 extends XmuProgram {
  private TypeGraph typeGraph_uml;
  
  public TypeGraph getTypeGraph_Uml() {
    if(typeGraph_uml==null) {
    	typeGraph_uml = new edu.ustb.sei.mde.graph.type.TypeGraph();
    	typeGraph_uml.declare("@NamedElement");
    	typeGraph_uml.declare("ClassModel");
    	typeGraph_uml.declare("Package,NamedElement");
    	typeGraph_uml.declare("Class,NamedElement");
    	typeGraph_uml.declare("Association,NamedElement");
    	typeGraph_uml.declare("Attribute,NamedElement");
    	typeGraph_uml.declare("EString:java.lang.String");
    	typeGraph_uml.declare("EBoolean:boolean");
    	typeGraph_uml.declare("name:NamedElement->EString");
    	typeGraph_uml.declare("persistent:Class->EBoolean");
    	typeGraph_uml.declare("@packages:ClassModel->Package*");
    	typeGraph_uml.declare("@subPackages:Package->Package*");
    	typeGraph_uml.declare("@classes:Package->Class*");
    	typeGraph_uml.declare("@associations:Package->Association*");
    	typeGraph_uml.declare("@attributes:Class->Attribute*");
    	typeGraph_uml.declare("super:Class->Class*");
    	typeGraph_uml.declare("source:Association->Class");
    	typeGraph_uml.declare("target:Association->Class");
    }
    return typeGraph_uml;
  }
  
  public void registerUmlPackage(final URI metamodelUri) {
    registerPackage("uml", metamodelUri);
  }
  
  public TypedGraph loadUmlModel(final URI modelUri) {
    org.eclipse.emf.ecore.EPackage pack = getPackage("uml");
    java.util.List<org.eclipse.emf.ecore.EObject> roots = edu.ustb.sei.mde.bxcore.util.EcoreModelUtil.load(modelUri);
    edu.ustb.sei.mde.graph.typedGraph.TypedGraph graph = edu.ustb.sei.mde.bxcore.util.EcoreModelUtil.load(roots, getTypeGraph_Uml());
    return graph;
  }
  
  public void saveUmlModel(final URI uri, final ContextGraph data, final TypedGraph originalGraph) throws NothingReturnedException, BidirectionalTransformationDefinitionException {
    edu.ustb.sei.mde.bxcore.util.EcoreModelUtil.save(uri, data.getGraph(), originalGraph, getPackage("uml"));
  }
  
  public void saveUmlModel(final URI uri, final ContextGraph data) throws NothingReturnedException, BidirectionalTransformationDefinitionException {
    edu.ustb.sei.mde.bxcore.util.EcoreModelUtil.save(uri, data.getGraph(), null, getPackage("uml"));
  }
  
  private TypeGraph typeGraph_rdbms;
  
  public TypeGraph getTypeGraph_Rdbms() {
    if(typeGraph_rdbms==null) {
    	typeGraph_rdbms = new edu.ustb.sei.mde.graph.type.TypeGraph();
    	typeGraph_rdbms.declare("@NamedElement");
    	typeGraph_rdbms.declare("Schema,NamedElement");
    	typeGraph_rdbms.declare("Table,NamedElement");
    	typeGraph_rdbms.declare("Column,NamedElement");
    	typeGraph_rdbms.declare("ForeignKey,NamedElement");
    	typeGraph_rdbms.declare("Key,NamedElement");
    	typeGraph_rdbms.declare("RDBMSModel");
    	typeGraph_rdbms.declare("EString:java.lang.String");
    	typeGraph_rdbms.declare("name:NamedElement->EString");
    	typeGraph_rdbms.declare("@tables:Schema->Table*");
    	typeGraph_rdbms.declare("@columns:Table->Column*");
    	typeGraph_rdbms.declare("@foreignKeys:Table->ForeignKey*");
    	typeGraph_rdbms.declare("@key:Table->Key");
    	typeGraph_rdbms.declare("column:ForeignKey->Column");
    	typeGraph_rdbms.declare("referTo:ForeignKey->Key");
    	typeGraph_rdbms.declare("@schemas:RDBMSModel->Schema*");
    	typeGraph_rdbms.declare("column:Key->Column");
    }
    return typeGraph_rdbms;
  }
  
  public void registerRdbmsPackage(final URI metamodelUri) {
    registerPackage("rdbms", metamodelUri);
  }
  
  public TypedGraph loadRdbmsModel(final URI modelUri) {
    org.eclipse.emf.ecore.EPackage pack = getPackage("rdbms");
    java.util.List<org.eclipse.emf.ecore.EObject> roots = edu.ustb.sei.mde.bxcore.util.EcoreModelUtil.load(modelUri);
    edu.ustb.sei.mde.graph.typedGraph.TypedGraph graph = edu.ustb.sei.mde.bxcore.util.EcoreModelUtil.load(roots, getTypeGraph_Rdbms());
    return graph;
  }
  
  public void saveRdbmsModel(final URI uri, final ContextGraph data, final TypedGraph originalGraph) throws NothingReturnedException, BidirectionalTransformationDefinitionException {
    edu.ustb.sei.mde.bxcore.util.EcoreModelUtil.save(uri, data.getGraph(), originalGraph, getPackage("rdbms"));
  }
  
  public void saveRdbmsModel(final URI uri, final ContextGraph data) throws NothingReturnedException, BidirectionalTransformationDefinitionException {
    edu.ustb.sei.mde.bxcore.util.EcoreModelUtil.save(uri, data.getGraph(), null, getPackage("rdbms"));
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
  
  public class Condition0 implements BiFunction<Context, Context, Boolean> {
    public Boolean apply(final Context source, final Context view) {
      return Boolean.valueOf(true);
    }
  }
  
  public class Condition1 implements BiFunction<Context, Context, Boolean> {
    public Boolean apply(final Context source, final Context view) {
      java.lang.String _contextValue = ((java.lang.String) edu.ustb.sei.mde.bxcore.dsl.structure.ExceptionSafeInferface.getValue(source,"n"));
      java.lang.String _contextValue_1 = ((java.lang.String) edu.ustb.sei.mde.bxcore.dsl.structure.ExceptionSafeInferface.getValue(view,"n"));
      return Boolean.valueOf(_contextValue.equals(_contextValue_1));
    }
  }
  
  public class Condition2 implements Function<Context, Boolean> {
    public Boolean apply(final Context context) {
      java.lang.String _contextValue = ((java.lang.String) edu.ustb.sei.mde.bxcore.dsl.structure.ExceptionSafeInferface.getValue(context,"n"));
      boolean _contains = _contextValue.contains("_");
      boolean _not = (!_contains);
      return Boolean.valueOf(_not);
    }
  }
  
  public class Condition3 implements Function<Context, Boolean> {
    public Boolean apply(final Context context) {
      java.lang.String _contextValue = ((java.lang.String) edu.ustb.sei.mde.bxcore.dsl.structure.ExceptionSafeInferface.getValue(context,"n"));
      boolean _contains = _contextValue.contains("_");
      boolean _not = (!_contains);
      return Boolean.valueOf(_not);
    }
  }
  
  public class Condition4 implements BiFunction<Context, Context, Boolean> {
    public Boolean apply(final Context source, final Context view) {
      java.lang.String _contextValue = ((java.lang.String) edu.ustb.sei.mde.bxcore.dsl.structure.ExceptionSafeInferface.getValue(source,"n"));
      java.lang.String _contextValue_1 = ((java.lang.String) edu.ustb.sei.mde.bxcore.dsl.structure.ExceptionSafeInferface.getValue(view,"n"));
      return Boolean.valueOf(_contextValue.equals(_contextValue_1));
    }
  }
  
  public class Condition5 implements BiFunction<Context, Context, Boolean> {
    public Boolean apply(final Context source, final Context view) {
      java.lang.String _contextValue = ((java.lang.String) edu.ustb.sei.mde.bxcore.dsl.structure.ExceptionSafeInferface.getValue(source,"n"));
      java.lang.String _contextValue_1 = ((java.lang.String) edu.ustb.sei.mde.bxcore.dsl.structure.ExceptionSafeInferface.getValue(view,"n"));
      boolean _equals = _contextValue.equals(_contextValue_1);
      return Boolean.valueOf(_equals);
    }
  }
  
  public class Condition6 implements BiFunction<Context, Context, Boolean> {
    public Boolean apply(final Context source, final Context view) {
      java.lang.String _contextValue = ((java.lang.String) edu.ustb.sei.mde.bxcore.dsl.structure.ExceptionSafeInferface.getValue(view,"n"));
      java.lang.String _contextValue_1 = ((java.lang.String) edu.ustb.sei.mde.bxcore.dsl.structure.ExceptionSafeInferface.getValue(source,"prefix"));
      String _plus = (_contextValue_1 + "-");
      java.lang.String _contextValue_2 = ((java.lang.String) edu.ustb.sei.mde.bxcore.dsl.structure.ExceptionSafeInferface.getValue(source,"n"));
      String _plus_1 = (_plus + _contextValue_2);
      return Boolean.valueOf(_contextValue.equals(_plus_1));
    }
  }
  
  public class UnidirectionalAction0 implements BiFunction<SourceType, ViewType, SourceType> {
    public SourceType apply(final SourceType source, final ViewType view) {
      edu.ustb.sei.mde.bxcore.structures.GraphModification _modStart = source.modification();
      edu.ustb.sei.mde.graph.typedGraph.TypedNode _contextValue = ((edu.ustb.sei.mde.graph.typedGraph.TypedNode) edu.ustb.sei.mde.bxcore.dsl.structure.ExceptionSafeInferface.getValue(source,"m"));
      edu.ustb.sei.mde.bxcore.structures.GraphModification _mod = _modStart.remove(_contextValue);
      
      return _modStart.get();
    }
  }
  
  public class UnidirectionalAction1 implements BiFunction<SourceType, ViewType, SourceType> {
    public SourceType apply(final SourceType source, final ViewType view) {
      edu.ustb.sei.mde.bxcore.structures.GraphModification _modStart = source.modification();
      edu.ustb.sei.mde.bxcore.structures.GraphModification _mod = _modStart.enforce(ClassModel(), new edu.ustb.sei.mde.structure.Tuple2[] {});
      _modStart = _mod;
      return _modStart.get();
    }
  }
  
  public class UnidirectionalAction2 implements BiFunction<SourceType, ViewType, SourceType> {
    public SourceType apply(final SourceType source, final ViewType view) {
      edu.ustb.sei.mde.bxcore.structures.GraphModification _modStart = source.modification();
      edu.ustb.sei.mde.graph.typedGraph.TypedEdge _contextValue = ((edu.ustb.sei.mde.graph.typedGraph.TypedEdge) edu.ustb.sei.mde.bxcore.dsl.structure.ExceptionSafeInferface.getValue(source,"lp"));
      edu.ustb.sei.mde.bxcore.structures.GraphModification _mod = _modStart.remove(_contextValue);
      
      edu.ustb.sei.mde.graph.typedGraph.ValueEdge _contextValue_1 = ((edu.ustb.sei.mde.graph.typedGraph.ValueEdge) edu.ustb.sei.mde.bxcore.dsl.structure.ExceptionSafeInferface.getValue(source,"ln"));
      edu.ustb.sei.mde.bxcore.structures.GraphModification _mod_1 = _modStart.remove(_contextValue_1);
      
      edu.ustb.sei.mde.graph.typedGraph.TypedNode _contextValue_2 = ((edu.ustb.sei.mde.graph.typedGraph.TypedNode) edu.ustb.sei.mde.bxcore.dsl.structure.ExceptionSafeInferface.getValue(source,"p"));
      edu.ustb.sei.mde.bxcore.structures.GraphModification _mod_2 = _modStart.remove(_contextValue_2);
      
      return _modStart.get();
    }
  }
  
  public class UnidirectionalAction3 implements BiFunction<SourceType, ViewType, SourceType> {
    public SourceType apply(final SourceType source, final ViewType view) {
      edu.ustb.sei.mde.bxcore.structures.GraphModification _modStart = source.modification();
      java.lang.String _contextValue = ((java.lang.String) edu.ustb.sei.mde.bxcore.dsl.structure.ExceptionSafeInferface.getValue(view,"n"));
      edu.ustb.sei.mde.bxcore.structures.GraphModification _mod = _modStart.enforce(Package(), new edu.ustb.sei.mde.structure.Tuple2[] {edu.ustb.sei.mde.structure.Tuple2.make("n",_contextValue)});
      _modStart = _mod;
      return _modStart.get();
    }
  }
  
  public class UnidirectionalAction4 implements BiFunction<SourceType, ViewType, SourceType> {
    public SourceType apply(final SourceType source, final ViewType view) {
      edu.ustb.sei.mde.bxcore.structures.GraphModification _modStart = source.modification();
      edu.ustb.sei.mde.graph.typedGraph.TypedEdge _contextValue = ((edu.ustb.sei.mde.graph.typedGraph.TypedEdge) edu.ustb.sei.mde.bxcore.dsl.structure.ExceptionSafeInferface.getValue(source,"lc"));
      edu.ustb.sei.mde.bxcore.structures.GraphModification _mod = _modStart.remove(_contextValue);
      
      edu.ustb.sei.mde.graph.typedGraph.ValueEdge _contextValue_1 = ((edu.ustb.sei.mde.graph.typedGraph.ValueEdge) edu.ustb.sei.mde.bxcore.dsl.structure.ExceptionSafeInferface.getValue(source,"ln"));
      edu.ustb.sei.mde.bxcore.structures.GraphModification _mod_1 = _modStart.remove(_contextValue_1);
      
      edu.ustb.sei.mde.graph.typedGraph.TypedNode _contextValue_2 = ((edu.ustb.sei.mde.graph.typedGraph.TypedNode) edu.ustb.sei.mde.bxcore.dsl.structure.ExceptionSafeInferface.getValue(source,"c"));
      edu.ustb.sei.mde.bxcore.structures.GraphModification _mod_2 = _modStart.remove(_contextValue_2);
      
      return _modStart.get();
    }
  }
  
  public class UnidirectionalAction5 implements BiFunction<SourceType, ViewType, SourceType> {
    public SourceType apply(final SourceType source, final ViewType view) {
      edu.ustb.sei.mde.bxcore.structures.GraphModification _modStart = source.modification();
      java.lang.String _contextValue = ((java.lang.String) edu.ustb.sei.mde.bxcore.dsl.structure.ExceptionSafeInferface.getValue(view,"n"));
      edu.ustb.sei.mde.bxcore.structures.GraphModification _mod = _modStart.enforce(Class(), new edu.ustb.sei.mde.structure.Tuple2[] {edu.ustb.sei.mde.structure.Tuple2.make("n",_contextValue)});
      _modStart = _mod;
      return _modStart.get();
    }
  }
  
  public class UnidirectionalAction6 implements BiFunction<SourceType, ViewType, SourceType> {
    public SourceType apply(final SourceType source, final ViewType view) {
      edu.ustb.sei.mde.bxcore.structures.GraphModification _modStart = source.modification();
      edu.ustb.sei.mde.graph.typedGraph.TypedEdge _contextValue = ((edu.ustb.sei.mde.graph.typedGraph.TypedEdge) edu.ustb.sei.mde.bxcore.dsl.structure.ExceptionSafeInferface.getValue(source,"la"));
      edu.ustb.sei.mde.bxcore.structures.GraphModification _mod = _modStart.remove(_contextValue);
      
      edu.ustb.sei.mde.graph.typedGraph.ValueEdge _contextValue_1 = ((edu.ustb.sei.mde.graph.typedGraph.ValueEdge) edu.ustb.sei.mde.bxcore.dsl.structure.ExceptionSafeInferface.getValue(source,"ln"));
      edu.ustb.sei.mde.bxcore.structures.GraphModification _mod_1 = _modStart.remove(_contextValue_1);
      
      edu.ustb.sei.mde.graph.typedGraph.TypedNode _contextValue_2 = ((edu.ustb.sei.mde.graph.typedGraph.TypedNode) edu.ustb.sei.mde.bxcore.dsl.structure.ExceptionSafeInferface.getValue(source,"a"));
      edu.ustb.sei.mde.bxcore.structures.GraphModification _mod_2 = _modStart.remove(_contextValue_2);
      
      return _modStart.get();
    }
  }
  
  public class UnidirectionalAction7 implements BiFunction<SourceType, ViewType, SourceType> {
    public SourceType apply(final SourceType source, final ViewType view) {
      SourceType _xifexpression = null;
      edu.ustb.sei.mde.graph.typedGraph.TypedNode _contextValue = ((edu.ustb.sei.mde.graph.typedGraph.TypedNode) edu.ustb.sei.mde.bxcore.dsl.structure.ExceptionSafeInferface.getValue(source,"c"));
      edu.ustb.sei.mde.graph.typedGraph.TypedNode _contextValue_1 = ((edu.ustb.sei.mde.graph.typedGraph.TypedNode) edu.ustb.sei.mde.bxcore.dsl.structure.ExceptionSafeInferface.getValue(view,"t"));
      edu.ustb.sei.mde.graph.typedGraph.TypedNode _contextValue_2 = ((edu.ustb.sei.mde.graph.typedGraph.TypedNode) edu.ustb.sei.mde.bxcore.dsl.structure.ExceptionSafeInferface.getValue(view,"c"));
      boolean _shouldDrop = UML2RDBMS2.this.shouldDrop(source, _contextValue, view, _contextValue_1, _contextValue_2, true);
      if (_shouldDrop) {
        _xifexpression = SourceType.drop();
      } else {
        edu.ustb.sei.mde.bxcore.structures.GraphModification _modStart = source.modification();
        java.lang.String _contextValue_3 = ((java.lang.String) edu.ustb.sei.mde.bxcore.dsl.structure.ExceptionSafeInferface.getValue(view,"n"));
        edu.ustb.sei.mde.bxcore.structures.GraphModification _mod = _modStart.enforce(Attribute(), new edu.ustb.sei.mde.structure.Tuple2[] {edu.ustb.sei.mde.structure.Tuple2.make("n",_contextValue_3)});
        _modStart = _mod;
        _xifexpression = _modStart.get();
      }
      return _xifexpression;
    }
  }
  
  public class DerivationAction8 implements Function<SourceType, Object> {
    public Object apply(final SourceType source) {
      edu.ustb.sei.mde.graph.typedGraph.TypedNode _contextValue = ((edu.ustb.sei.mde.graph.typedGraph.TypedNode) edu.ustb.sei.mde.bxcore.dsl.structure.ExceptionSafeInferface.getValue(source,"oc"));
      edu.ustb.sei.mde.graph.typedGraph.TypedNode _contextValue_1 = ((edu.ustb.sei.mde.graph.typedGraph.TypedNode) edu.ustb.sei.mde.bxcore.dsl.structure.ExceptionSafeInferface.getValue(source,"cc"));
      String _computePrefix = UML2RDBMS2.this.computePrefix(source, _contextValue, _contextValue_1);
      return _computePrefix;
    }
  }
  
  public class UnidirectionalAction9 implements BiFunction<SourceType, ViewType, SourceType> {
    public SourceType apply(final SourceType source, final ViewType view) {
      edu.ustb.sei.mde.bxcore.structures.GraphModification _modStart = source.modification();
      edu.ustb.sei.mde.graph.typedGraph.TypedEdge _contextValue = ((edu.ustb.sei.mde.graph.typedGraph.TypedEdge) edu.ustb.sei.mde.bxcore.dsl.structure.ExceptionSafeInferface.getValue(source,"la"));
      edu.ustb.sei.mde.bxcore.structures.GraphModification _mod = _modStart.remove(_contextValue);
      
      edu.ustb.sei.mde.graph.typedGraph.ValueEdge _contextValue_1 = ((edu.ustb.sei.mde.graph.typedGraph.ValueEdge) edu.ustb.sei.mde.bxcore.dsl.structure.ExceptionSafeInferface.getValue(source,"ln"));
      edu.ustb.sei.mde.bxcore.structures.GraphModification _mod_1 = _modStart.remove(_contextValue_1);
      
      edu.ustb.sei.mde.graph.typedGraph.TypedNode _contextValue_2 = ((edu.ustb.sei.mde.graph.typedGraph.TypedNode) edu.ustb.sei.mde.bxcore.dsl.structure.ExceptionSafeInferface.getValue(source,"a"));
      edu.ustb.sei.mde.bxcore.structures.GraphModification _mod_2 = _modStart.remove(_contextValue_2);
      
      return _modStart.get();
    }
  }
  
  public class UnidirectionalAction10 implements BiFunction<SourceType, ViewType, SourceType> {
    public SourceType apply(final SourceType source, final ViewType view) {
      return SourceType.drop();
    }
  }
  
  /**
   * id:9
   */
  private ContextType type_9;
  
  public ContextType getType_9() {
    if(type_9==null) {
    	edu.ustb.sei.mde.graph.type.TypeGraph typeGraph = getTypeGraph_Rdbms();
    	type_9 = new edu.ustb.sei.mde.bxcore.structures.ContextType();
    	Object c_type = typeGraph.getTypeNode("Column");
    	type_9.addField("c", c_type, false);
    	Object lc_type = typeGraph.getTypeEdge(typeGraph.getTypeNode("Table"),"columns");
    	type_9.addField("lc", lc_type, false);
    	Object ln_type = typeGraph.getPropertyEdge(typeGraph.getTypeNode("NamedElement"),"name");
    	type_9.addField("ln", ln_type, false);
    	Object n_type = typeGraph.getDataTypeNode("EString");
    	type_9.addField("n", n_type, false);
    	Object t_type = typeGraph.getTypeNode("Table");
    	type_9.addField("t", t_type, false);
    }
    return type_9;
  }
  
  /**
   * id:14
   */
  private ContextType type_14;
  
  public ContextType getType_14() {
    if(type_14==null) {
    	edu.ustb.sei.mde.graph.type.TypeGraph typeGraph = getTypeGraph_Uml();
    	type_14 = new edu.ustb.sei.mde.bxcore.structures.ContextType();
    	Object a_type = typeGraph.getTypeNode("Attribute");
    	type_14.addField("a", a_type, false);
    	Object cc_type = typeGraph.getTypeNode("Class");
    	type_14.addField("cc", cc_type, false);
    	Object la_type = typeGraph.getTypeEdge(typeGraph.getTypeNode("Class"),"attributes");
    	type_14.addField("la", la_type, false);
    	Object ln_type = typeGraph.getPropertyEdge(typeGraph.getTypeNode("NamedElement"),"name");
    	type_14.addField("ln", ln_type, false);
    	Object n_type = typeGraph.getDataTypeNode("EString");
    	type_14.addField("n", n_type, false);
    	Object oc_type = typeGraph.getTypeNode("Class");
    	type_14.addField("oc", oc_type, false);
    	Object prefix_type = typeGraph.getDataTypeNode("EString");
    	type_14.addField("prefix", prefix_type, false);
    }
    return type_14;
  }
  
  /**
   * id:2
   */
  private ContextType type_2;
  
  public ContextType getType_2() {
    if(type_2==null) {
    	edu.ustb.sei.mde.graph.type.TypeGraph typeGraph = getTypeGraph_Uml();
    	type_2 = new edu.ustb.sei.mde.bxcore.structures.ContextType();
    	Object ln_type = typeGraph.getPropertyEdge(typeGraph.getTypeNode("NamedElement"),"name");
    	type_2.addField("ln", ln_type, false);
    	Object lp_type = typeGraph.getTypeEdge(typeGraph.getTypeNode("ClassModel"),"packages");
    	type_2.addField("lp", lp_type, false);
    	Object m_type = typeGraph.getTypeNode("ClassModel");
    	type_2.addField("m", m_type, false);
    	Object n_type = typeGraph.getDataTypeNode("EString");
    	type_2.addField("n", n_type, false);
    	Object p_type = typeGraph.getTypeNode("Package");
    	type_2.addField("p", p_type, false);
    }
    return type_2;
  }
  
  /**
   * id:10
   */
  private ContextType type_10;
  
  public ContextType getType_10() {
    if(type_10==null) {
    	edu.ustb.sei.mde.graph.type.TypeGraph typeGraph = getTypeGraph_Uml();
    	type_10 = new edu.ustb.sei.mde.bxcore.structures.ContextType();
    	Object c_type = typeGraph.getTypeNode("Class");
    	type_10.addField("c", c_type, false);
    	Object ls_type = typeGraph.getTypeEdge(typeGraph.getTypeNode("Class"),"super");
    	type_10.addField("ls", ls_type, false);
    	Object sc_type = typeGraph.getTypeNode("Class");
    	type_10.addField("sc", sc_type, false);
    }
    return type_10;
  }
  
  /**
   * id:15
   */
  private ContextType type_15;
  
  public ContextType getType_15() {
    if(type_15==null) {
    	edu.ustb.sei.mde.graph.type.TypeGraph typeGraph = getTypeGraph_Uml();
    	type_15 = new edu.ustb.sei.mde.bxcore.structures.ContextType();
    	Object cc_type = typeGraph.getTypeNode("Class");
    	type_15.addField("cc", cc_type, false);
    	Object ls_type = typeGraph.getTypeEdge(typeGraph.getTypeNode("Class"),"super");
    	type_15.addField("ls", ls_type, false);
    	Object oc_type = typeGraph.getTypeNode("Class");
    	type_15.addField("oc", oc_type, false);
    	Object sc_type = typeGraph.getTypeNode("Class");
    	type_15.addField("sc", sc_type, false);
    }
    return type_15;
  }
  
  /**
   * id:13
   */
  private ContextType type_13;
  
  public ContextType getType_13() {
    if(type_13==null) {
    	edu.ustb.sei.mde.graph.type.TypeGraph typeGraph = getTypeGraph_Uml();
    	type_13 = new edu.ustb.sei.mde.bxcore.structures.ContextType();
    	Object prefix_type = typeGraph.getDataTypeNode("EString");
    	type_13.addField("prefix", prefix_type, false);
    }
    return type_13;
  }
  
  /**
   * id:8
   */
  private ContextType type_8;
  
  public ContextType getType_8() {
    if(type_8==null) {
    	edu.ustb.sei.mde.graph.type.TypeGraph typeGraph = getTypeGraph_Uml();
    	type_8 = new edu.ustb.sei.mde.bxcore.structures.ContextType();
    	Object a_type = typeGraph.getTypeNode("Attribute");
    	type_8.addField("a", a_type, false);
    	Object c_type = typeGraph.getTypeNode("Class");
    	type_8.addField("c", c_type, false);
    	Object la_type = typeGraph.getTypeEdge(typeGraph.getTypeNode("Class"),"attributes");
    	type_8.addField("la", la_type, false);
    	Object ln_type = typeGraph.getPropertyEdge(typeGraph.getTypeNode("NamedElement"),"name");
    	type_8.addField("ln", ln_type, false);
    	Object n_type = typeGraph.getDataTypeNode("EString");
    	type_8.addField("n", n_type, false);
    }
    return type_8;
  }
  
  /**
   * id:5
   */
  private ContextType type_5;
  
  public ContextType getType_5() {
    if(type_5==null) {
    	edu.ustb.sei.mde.graph.type.TypeGraph typeGraph = getTypeGraph_Rdbms();
    	type_5 = new edu.ustb.sei.mde.bxcore.structures.ContextType();
    	Object t_type = typeGraph.getTypeNode("Table");
    	type_5.addField("t", t_type, false);
    }
    return type_5;
  }
  
  /**
   * id:1
   */
  private ContextType type_1;
  
  public ContextType getType_1() {
    if(type_1==null) {
    	edu.ustb.sei.mde.graph.type.TypeGraph typeGraph = getTypeGraph_Rdbms();
    	type_1 = new edu.ustb.sei.mde.bxcore.structures.ContextType();
    	Object m_type = typeGraph.getTypeNode("RDBMSModel");
    	type_1.addField("m", m_type, false);
    }
    return type_1;
  }
  
  /**
   * id:3
   */
  private ContextType type_3;
  
  public ContextType getType_3() {
    if(type_3==null) {
    	edu.ustb.sei.mde.graph.type.TypeGraph typeGraph = getTypeGraph_Rdbms();
    	type_3 = new edu.ustb.sei.mde.bxcore.structures.ContextType();
    	Object ln_type = typeGraph.getPropertyEdge(typeGraph.getTypeNode("NamedElement"),"name");
    	type_3.addField("ln", ln_type, false);
    	Object ls_type = typeGraph.getTypeEdge(typeGraph.getTypeNode("RDBMSModel"),"schemas");
    	type_3.addField("ls", ls_type, false);
    	Object m_type = typeGraph.getTypeNode("RDBMSModel");
    	type_3.addField("m", m_type, false);
    	Object n_type = typeGraph.getDataTypeNode("EString");
    	type_3.addField("n", n_type, false);
    	Object s_type = typeGraph.getTypeNode("Schema");
    	type_3.addField("s", s_type, false);
    }
    return type_3;
  }
  
  /**
   * id:11
   */
  private ContextType type_11;
  
  public ContextType getType_11() {
    if(type_11==null) {
    	edu.ustb.sei.mde.graph.type.TypeGraph typeGraph = getTypeGraph_Uml();
    	type_11 = new edu.ustb.sei.mde.bxcore.structures.ContextType();
    	Object cc_type = typeGraph.getTypeNode("Class");
    	type_11.addField("cc", cc_type, false);
    	Object oc_type = typeGraph.getTypeNode("Class");
    	type_11.addField("oc", oc_type, false);
    }
    return type_11;
  }
  
  /**
   * id:0
   */
  private ContextType type_0;
  
  public ContextType getType_0() {
    if(type_0==null) {
    	edu.ustb.sei.mde.graph.type.TypeGraph typeGraph = getTypeGraph_Uml();
    	type_0 = new edu.ustb.sei.mde.bxcore.structures.ContextType();
    	Object m_type = typeGraph.getTypeNode("ClassModel");
    	type_0.addField("m", m_type, false);
    }
    return type_0;
  }
  
  /**
   * id:4
   */
  private ContextType type_4;
  
  public ContextType getType_4() {
    if(type_4==null) {
    	edu.ustb.sei.mde.graph.type.TypeGraph typeGraph = getTypeGraph_Uml();
    	type_4 = new edu.ustb.sei.mde.bxcore.structures.ContextType();
    	Object c_type = typeGraph.getTypeNode("Class");
    	type_4.addField("c", c_type, false);
    }
    return type_4;
  }
  
  /**
   * id:12
   */
  private ContextType type_12;
  
  public ContextType getType_12() {
    if(type_12==null) {
    	edu.ustb.sei.mde.graph.type.TypeGraph typeGraph = getTypeGraph_Rdbms();
    	type_12 = new edu.ustb.sei.mde.bxcore.structures.ContextType();
    	Object t_type = typeGraph.getTypeNode("Table");
    	type_12.addField("t", t_type, false);
    }
    return type_12;
  }
  
  /**
   * id:7
   */
  private ContextType type_7;
  
  public ContextType getType_7() {
    if(type_7==null) {
    	edu.ustb.sei.mde.graph.type.TypeGraph typeGraph = getTypeGraph_Rdbms();
    	type_7 = new edu.ustb.sei.mde.bxcore.structures.ContextType();
    	Object ln_type = typeGraph.getPropertyEdge(typeGraph.getTypeNode("NamedElement"),"name");
    	type_7.addField("ln", ln_type, false);
    	Object lt_type = typeGraph.getTypeEdge(typeGraph.getTypeNode("Schema"),"tables");
    	type_7.addField("lt", lt_type, false);
    	Object n_type = typeGraph.getDataTypeNode("EString");
    	type_7.addField("n", n_type, false);
    	Object s_type = typeGraph.getTypeNode("Schema");
    	type_7.addField("s", s_type, false);
    	Object t_type = typeGraph.getTypeNode("Table");
    	type_7.addField("t", t_type, false);
    }
    return type_7;
  }
  
  /**
   * id:6
   */
  private ContextType type_6;
  
  public ContextType getType_6() {
    if(type_6==null) {
    	edu.ustb.sei.mde.graph.type.TypeGraph typeGraph = getTypeGraph_Uml();
    	type_6 = new edu.ustb.sei.mde.bxcore.structures.ContextType();
    	Object c_type = typeGraph.getTypeNode("Class");
    	type_6.addField("c", c_type, false);
    	Object lc_type = typeGraph.getTypeEdge(typeGraph.getTypeNode("Package"),"classes");
    	type_6.addField("lc", lc_type, false);
    	Object ln_type = typeGraph.getPropertyEdge(typeGraph.getTypeNode("NamedElement"),"name");
    	type_6.addField("ln", ln_type, false);
    	Object n_type = typeGraph.getDataTypeNode("EString");
    	type_6.addField("n", n_type, false);
    	Object p_type = typeGraph.getTypeNode("Package");
    	type_6.addField("p", p_type, false);
    }
    return type_6;
  }
  
  /**
   * id:-9
   */
  private ContextType type_u9;
  
  /**
   * XmuCoreAlign(xmu21)
   */
  public ContextType getType_U9() {
    if(type_u9==null) {
    	edu.ustb.sei.mde.graph.type.TypeGraph typeGraph = getTypeGraph_Uml();
    	type_u9 = new edu.ustb.sei.mde.bxcore.structures.ContextType();
    	Object cc_type = typeGraph.getTypeNode("Class");
    	type_u9.addField("cc", cc_type, false);
    	Object prefix_type = typeGraph.getDataTypeNode("EString");
    	type_u9.addField("prefix", prefix_type, false);
    	Object oc_type = typeGraph.getTypeNode("Class");
    	type_u9.addField("oc", oc_type, false);
    }
    return type_u9;
  }
  
  /**
   * id:-6
   */
  private ContextType type_u6;
  
  /**
   * XmuCoreAlign(xmu8)
   */
  public ContextType getType_U6() {
    if(type_u6==null) {
    	edu.ustb.sei.mde.graph.type.TypeGraph typeGraph = getTypeGraph_Uml();
    	type_u6 = new edu.ustb.sei.mde.bxcore.structures.ContextType();
    	Object p_type = typeGraph.getTypeNode("Package");
    	type_u6.addField("p", p_type, false);
    }
    return type_u6;
  }
  
  /**
   * id:-10
   */
  private ContextType type_u10;
  
  /**
   * XmuCoreParallelComposition(xmu13)
   */
  public ContextType getType_U10() {
    if(type_u10==null) {
    	edu.ustb.sei.mde.graph.type.TypeGraph typeGraph = getTypeGraph_Rdbms();
    	type_u10 = new edu.ustb.sei.mde.bxcore.structures.ContextType();
    	Object t_type = typeGraph.getTypeNode("NamedElement");
    	type_u10.addField("t", t_type, false);
    }
    return type_u10;
  }
  
  /**
   * id:-2
   */
  private ContextType type_u2;
  
  /**
   * XmuCoreFunctionCall(xmu25)
   */
  public ContextType getType_U2() {
    if(type_u2==null) {
    	edu.ustb.sei.mde.graph.type.TypeGraph typeGraph = getTypeGraph_Uml();
    	type_u2 = new edu.ustb.sei.mde.bxcore.structures.ContextType();
    	Object sc_type = typeGraph.getTypeNode("Class");
    	type_u2.addField("sc", sc_type, false);
    	Object oc_type = typeGraph.getTypeNode("Class");
    	type_u2.addField("oc", oc_type, false);
    }
    return type_u2;
  }
  
  /**
   * id:-11
   */
  private ContextType type_u11;
  
  /**
   * XmuCoreAlign(xmu8)
   */
  public ContextType getType_U11() {
    if(type_u11==null) {
    	edu.ustb.sei.mde.graph.type.TypeGraph typeGraph = getTypeGraph_Rdbms();
    	type_u11 = new edu.ustb.sei.mde.bxcore.structures.ContextType();
    	Object s_type = typeGraph.getTypeNode("Schema");
    	type_u11.addField("s", s_type, false);
    }
    return type_u11;
  }
  
  /**
   * id:-4
   */
  private ContextType type_u4;
  
  /**
   * XmuCoreParallelComposition(xmu13)
   */
  public ContextType getType_U4() {
    if(type_u4==null) {
    	edu.ustb.sei.mde.graph.type.TypeGraph typeGraph = getTypeGraph_Uml();
    	type_u4 = new edu.ustb.sei.mde.bxcore.structures.ContextType();
    	Object c_type = typeGraph.getTypeNode("NamedElement");
    	type_u4.addField("c", c_type, false);
    }
    return type_u4;
  }
  
  /**
   * id:-1
   */
  private ContextType type_u1;
  
  /**
   * XmuCoreAlign(xmu14)
   */
  public ContextType getType_U1() {
    if(type_u1==null) {
    	edu.ustb.sei.mde.graph.type.TypeGraph typeGraph = getTypeGraph_Uml();
    	type_u1 = new edu.ustb.sei.mde.bxcore.structures.ContextType();
    	Object c_type = typeGraph.getTypeNode("Class");
    	type_u1.addField("c", c_type, false);
    }
    return type_u1;
  }
  
  /**
   * id:-3
   */
  private ContextType type_u3;
  
  /**
   * XmuCoreFunctionCall(xmu18)
   */
  public ContextType getType_U3() {
    if(type_u3==null) {
    	edu.ustb.sei.mde.graph.type.TypeGraph typeGraph = getTypeGraph_Uml();
    	type_u3 = new edu.ustb.sei.mde.bxcore.structures.ContextType();
    	Object c_type = typeGraph.getTypeNode("Class");
    	type_u3.addField("c", c_type, false);
    	Object sc_type = typeGraph.getTypeNode("Class");
    	type_u3.addField("sc", sc_type, false);
    }
    return type_u3;
  }
  
  private Pattern pattern_0;
  
  public Pattern getPattern_0() {
    if(pattern_0==null) {
    	edu.ustb.sei.mde.graph.type.TypeGraph typeGraph = getTypeGraph_Uml();
    	pattern_0 = new edu.ustb.sei.mde.graph.pattern.Pattern(typeGraph);
    	edu.ustb.sei.mde.graph.type.ITypeNode m_type = typeGraph.getTypeNode("ClassModel");
    	pattern_0.appendPatternNode("m", m_type,false);
    	pattern_0.setType(getType_0());
    }
    return pattern_0;
  }
  
  private Pattern pattern_1;
  
  public Pattern getPattern_1() {
    if(pattern_1==null) {
    	edu.ustb.sei.mde.graph.type.TypeGraph typeGraph = getTypeGraph_Rdbms();
    	pattern_1 = new edu.ustb.sei.mde.graph.pattern.Pattern(typeGraph);
    	edu.ustb.sei.mde.graph.type.ITypeNode m_type = typeGraph.getTypeNode("RDBMSModel");
    	pattern_1.appendPatternNode("m", m_type,false);
    	pattern_1.setType(getType_1());
    }
    return pattern_1;
  }
  
  private Pattern pattern_2;
  
  public Pattern getPattern_2() {
    if(pattern_2==null) {
    	edu.ustb.sei.mde.graph.type.TypeGraph typeGraph = getTypeGraph_Rdbms();
    	pattern_2 = new edu.ustb.sei.mde.graph.pattern.Pattern(typeGraph);
    	edu.ustb.sei.mde.graph.type.ITypeNode m_type = typeGraph.getTypeNode("RDBMSModel");
    	pattern_2.appendPatternNode("m", m_type,false);
    	pattern_2.setType(getType_1());
    }
    return pattern_2;
  }
  
  private Pattern pattern_3;
  
  public Pattern getPattern_3() {
    if(pattern_3==null) {
    	edu.ustb.sei.mde.graph.type.TypeGraph typeGraph = getTypeGraph_Uml();
    	pattern_3 = new edu.ustb.sei.mde.graph.pattern.Pattern(typeGraph);
    	edu.ustb.sei.mde.graph.type.ITypeNode m_type = typeGraph.getTypeNode("ClassModel");
    	pattern_3.appendPatternNode("m", m_type,false);
    	edu.ustb.sei.mde.graph.type.ITypeNode p_type = typeGraph.getTypeNode("Package");
    	pattern_3.appendPatternNode("p", p_type,false);
    	edu.ustb.sei.mde.graph.type.ITypeNode n_type = typeGraph.getDataTypeNode("EString");
    	pattern_3.appendPatternNode("n", n_type,false);
    	edu.ustb.sei.mde.graph.type.IStructuralFeatureEdge lp_type = typeGraph.getTypeEdge((edu.ustb.sei.mde.graph.type.TypeNode) m_type,"packages");
    	pattern_3.appendPatternEdge("lp", "m", "p", lp_type);
    	edu.ustb.sei.mde.graph.type.IStructuralFeatureEdge ln_type = typeGraph.getPropertyEdge((edu.ustb.sei.mde.graph.type.TypeNode) p_type,"name");
    	pattern_3.appendPatternEdge("ln", "p", "n", ln_type);
    	pattern_3.setType(getType_2());
    }
    return pattern_3;
  }
  
  private Pattern pattern_4;
  
  public Pattern getPattern_4() {
    if(pattern_4==null) {
    	edu.ustb.sei.mde.graph.type.TypeGraph typeGraph = getTypeGraph_Rdbms();
    	pattern_4 = new edu.ustb.sei.mde.graph.pattern.Pattern(typeGraph);
    	edu.ustb.sei.mde.graph.type.ITypeNode m_type = typeGraph.getTypeNode("RDBMSModel");
    	pattern_4.appendPatternNode("m", m_type,false);
    	edu.ustb.sei.mde.graph.type.ITypeNode s_type = typeGraph.getTypeNode("Schema");
    	pattern_4.appendPatternNode("s", s_type,false);
    	edu.ustb.sei.mde.graph.type.ITypeNode n_type = typeGraph.getDataTypeNode("EString");
    	pattern_4.appendPatternNode("n", n_type,false);
    	edu.ustb.sei.mde.graph.type.IStructuralFeatureEdge ls_type = typeGraph.getTypeEdge((edu.ustb.sei.mde.graph.type.TypeNode) m_type,"schemas");
    	pattern_4.appendPatternEdge("ls", "m", "s", ls_type);
    	edu.ustb.sei.mde.graph.type.IStructuralFeatureEdge ln_type = typeGraph.getPropertyEdge((edu.ustb.sei.mde.graph.type.TypeNode) s_type,"name");
    	pattern_4.appendPatternEdge("ln", "s", "n", ln_type);
    	pattern_4.setType(getType_3());
    }
    return pattern_4;
  }
  
  private Pattern pattern_5;
  
  public Pattern getPattern_5() {
    if(pattern_5==null) {
    	edu.ustb.sei.mde.graph.type.TypeGraph typeGraph = getTypeGraph_Rdbms();
    	pattern_5 = new edu.ustb.sei.mde.graph.pattern.Pattern(typeGraph);
    	edu.ustb.sei.mde.graph.type.ITypeNode m_type = typeGraph.getTypeNode("RDBMSModel");
    	pattern_5.appendPatternNode("m", m_type,false);
    	edu.ustb.sei.mde.graph.type.ITypeNode s_type = typeGraph.getTypeNode("Schema");
    	pattern_5.appendPatternNode("s", s_type,false);
    	edu.ustb.sei.mde.graph.type.ITypeNode n_type = typeGraph.getDataTypeNode("EString");
    	pattern_5.appendPatternNode("n", n_type,false);
    	edu.ustb.sei.mde.graph.type.IStructuralFeatureEdge ls_type = typeGraph.getTypeEdge((edu.ustb.sei.mde.graph.type.TypeNode) m_type,"schemas");
    	pattern_5.appendPatternEdge("ls", "m", "s", ls_type);
    	edu.ustb.sei.mde.graph.type.IStructuralFeatureEdge ln_type = typeGraph.getPropertyEdge((edu.ustb.sei.mde.graph.type.TypeNode) s_type,"name");
    	pattern_5.appendPatternEdge("ln", "s", "n", ln_type);
    	pattern_5.setType(getType_3());
    }
    return pattern_5;
  }
  
  private Pattern pattern_6;
  
  public Pattern getPattern_6() {
    if(pattern_6==null) {
    	edu.ustb.sei.mde.graph.type.TypeGraph typeGraph = getTypeGraph_Uml();
    	pattern_6 = new edu.ustb.sei.mde.graph.pattern.Pattern(typeGraph);
    	edu.ustb.sei.mde.graph.type.ITypeNode p_type = typeGraph.getTypeNode("Package");
    	pattern_6.appendPatternNode("p", p_type,false);
    	edu.ustb.sei.mde.graph.type.ITypeNode c_type = typeGraph.getTypeNode("Class");
    	pattern_6.appendPatternNode("c", c_type,false);
    	edu.ustb.sei.mde.graph.type.ITypeNode n_type = typeGraph.getDataTypeNode("EString");
    	pattern_6.appendPatternNode("n", n_type,false);
    	edu.ustb.sei.mde.graph.type.IStructuralFeatureEdge lc_type = typeGraph.getTypeEdge((edu.ustb.sei.mde.graph.type.TypeNode) p_type,"classes");
    	pattern_6.appendPatternEdge("lc", "p", "c", lc_type);
    	edu.ustb.sei.mde.graph.type.IStructuralFeatureEdge ln_type = typeGraph.getPropertyEdge((edu.ustb.sei.mde.graph.type.TypeNode) c_type,"name");
    	pattern_6.appendPatternEdge("ln", "c", "n", ln_type);
    	pattern_6.setType(getType_6());
    	pattern_6.setFilter(new Condition2());
    }
    return pattern_6;
  }
  
  private Pattern pattern_7;
  
  public Pattern getPattern_7() {
    if(pattern_7==null) {
    	edu.ustb.sei.mde.graph.type.TypeGraph typeGraph = getTypeGraph_Rdbms();
    	pattern_7 = new edu.ustb.sei.mde.graph.pattern.Pattern(typeGraph);
    	edu.ustb.sei.mde.graph.type.ITypeNode s_type = typeGraph.getTypeNode("Schema");
    	pattern_7.appendPatternNode("s", s_type,false);
    	edu.ustb.sei.mde.graph.type.ITypeNode t_type = typeGraph.getTypeNode("Table");
    	pattern_7.appendPatternNode("t", t_type,false);
    	edu.ustb.sei.mde.graph.type.ITypeNode n_type = typeGraph.getDataTypeNode("EString");
    	pattern_7.appendPatternNode("n", n_type,false);
    	edu.ustb.sei.mde.graph.type.IStructuralFeatureEdge lt_type = typeGraph.getTypeEdge((edu.ustb.sei.mde.graph.type.TypeNode) s_type,"tables");
    	pattern_7.appendPatternEdge("lt", "s", "t", lt_type);
    	edu.ustb.sei.mde.graph.type.IStructuralFeatureEdge ln_type = typeGraph.getPropertyEdge((edu.ustb.sei.mde.graph.type.TypeNode) t_type,"name");
    	pattern_7.appendPatternEdge("ln", "t", "n", ln_type);
    	pattern_7.setType(getType_7());
    	pattern_7.setFilter(new Condition3());
    }
    return pattern_7;
  }
  
  private Pattern pattern_8;
  
  public Pattern getPattern_8() {
    if(pattern_8==null) {
    	edu.ustb.sei.mde.graph.type.TypeGraph typeGraph = getTypeGraph_Rdbms();
    	pattern_8 = new edu.ustb.sei.mde.graph.pattern.Pattern(typeGraph);
    	edu.ustb.sei.mde.graph.type.ITypeNode s_type = typeGraph.getTypeNode("Schema");
    	pattern_8.appendPatternNode("s", s_type,false);
    	edu.ustb.sei.mde.graph.type.ITypeNode t_type = typeGraph.getTypeNode("Table");
    	pattern_8.appendPatternNode("t", t_type,false);
    	edu.ustb.sei.mde.graph.type.ITypeNode n_type = typeGraph.getDataTypeNode("EString");
    	pattern_8.appendPatternNode("n", n_type,false);
    	edu.ustb.sei.mde.graph.type.IStructuralFeatureEdge lt_type = typeGraph.getTypeEdge((edu.ustb.sei.mde.graph.type.TypeNode) s_type,"tables");
    	pattern_8.appendPatternEdge("lt", "s", "t", lt_type);
    	edu.ustb.sei.mde.graph.type.IStructuralFeatureEdge ln_type = typeGraph.getPropertyEdge((edu.ustb.sei.mde.graph.type.TypeNode) t_type,"name");
    	pattern_8.appendPatternEdge("ln", "t", "n", ln_type);
    	pattern_8.setType(getType_7());
    }
    return pattern_8;
  }
  
  private Pattern pattern_9;
  
  public Pattern getPattern_9() {
    if(pattern_9==null) {
    	edu.ustb.sei.mde.graph.type.TypeGraph typeGraph = getTypeGraph_Uml();
    	pattern_9 = new edu.ustb.sei.mde.graph.pattern.Pattern(typeGraph);
    	edu.ustb.sei.mde.graph.type.ITypeNode c_type = typeGraph.getTypeNode("Class");
    	pattern_9.appendPatternNode("c", c_type,false);
    	edu.ustb.sei.mde.graph.type.ITypeNode a_type = typeGraph.getTypeNode("Attribute");
    	pattern_9.appendPatternNode("a", a_type,false);
    	edu.ustb.sei.mde.graph.type.ITypeNode n_type = typeGraph.getDataTypeNode("EString");
    	pattern_9.appendPatternNode("n", n_type,false);
    	edu.ustb.sei.mde.graph.type.IStructuralFeatureEdge la_type = typeGraph.getTypeEdge((edu.ustb.sei.mde.graph.type.TypeNode) c_type,"attributes");
    	pattern_9.appendPatternEdge("la", "c", "a", la_type);
    	edu.ustb.sei.mde.graph.type.IStructuralFeatureEdge ln_type = typeGraph.getPropertyEdge((edu.ustb.sei.mde.graph.type.TypeNode) a_type,"name");
    	pattern_9.appendPatternEdge("ln", "a", "n", ln_type);
    	pattern_9.setType(getType_8());
    }
    return pattern_9;
  }
  
  private Pattern pattern_10;
  
  public Pattern getPattern_10() {
    if(pattern_10==null) {
    	edu.ustb.sei.mde.graph.type.TypeGraph typeGraph = getTypeGraph_Rdbms();
    	pattern_10 = new edu.ustb.sei.mde.graph.pattern.Pattern(typeGraph);
    	edu.ustb.sei.mde.graph.type.ITypeNode t_type = typeGraph.getTypeNode("Table");
    	pattern_10.appendPatternNode("t", t_type,false);
    	edu.ustb.sei.mde.graph.type.ITypeNode c_type = typeGraph.getTypeNode("Column");
    	pattern_10.appendPatternNode("c", c_type,false);
    	edu.ustb.sei.mde.graph.type.ITypeNode n_type = typeGraph.getDataTypeNode("EString");
    	pattern_10.appendPatternNode("n", n_type,false);
    	edu.ustb.sei.mde.graph.type.IStructuralFeatureEdge lc_type = typeGraph.getTypeEdge((edu.ustb.sei.mde.graph.type.TypeNode) t_type,"columns");
    	pattern_10.appendPatternEdge("lc", "t", "c", lc_type);
    	edu.ustb.sei.mde.graph.type.IStructuralFeatureEdge ln_type = typeGraph.getPropertyEdge((edu.ustb.sei.mde.graph.type.TypeNode) c_type,"name");
    	pattern_10.appendPatternEdge("ln", "c", "n", ln_type);
    	pattern_10.setType(getType_9());
    }
    return pattern_10;
  }
  
  private Pattern pattern_11;
  
  public Pattern getPattern_11() {
    if(pattern_11==null) {
    	edu.ustb.sei.mde.graph.type.TypeGraph typeGraph = getTypeGraph_Rdbms();
    	pattern_11 = new edu.ustb.sei.mde.graph.pattern.Pattern(typeGraph);
    	edu.ustb.sei.mde.graph.type.ITypeNode t_type = typeGraph.getTypeNode("Table");
    	pattern_11.appendPatternNode("t", t_type,false);
    	edu.ustb.sei.mde.graph.type.ITypeNode c_type = typeGraph.getTypeNode("Column");
    	pattern_11.appendPatternNode("c", c_type,false);
    	edu.ustb.sei.mde.graph.type.ITypeNode n_type = typeGraph.getDataTypeNode("EString");
    	pattern_11.appendPatternNode("n", n_type,false);
    	edu.ustb.sei.mde.graph.type.IStructuralFeatureEdge lc_type = typeGraph.getTypeEdge((edu.ustb.sei.mde.graph.type.TypeNode) t_type,"columns");
    	pattern_11.appendPatternEdge("lc", "t", "c", lc_type);
    	edu.ustb.sei.mde.graph.type.IStructuralFeatureEdge ln_type = typeGraph.getPropertyEdge((edu.ustb.sei.mde.graph.type.TypeNode) c_type,"name");
    	pattern_11.appendPatternEdge("ln", "c", "n", ln_type);
    	pattern_11.setType(getType_9());
    }
    return pattern_11;
  }
  
  private Pattern pattern_12;
  
  public Pattern getPattern_12() {
    if(pattern_12==null) {
    	edu.ustb.sei.mde.graph.type.TypeGraph typeGraph = getTypeGraph_Uml();
    	pattern_12 = new edu.ustb.sei.mde.graph.pattern.Pattern(typeGraph);
    	edu.ustb.sei.mde.graph.type.ITypeNode c_type = typeGraph.getTypeNode("Class");
    	pattern_12.appendPatternNode("c", c_type,false);
    	edu.ustb.sei.mde.graph.type.ITypeNode sc_type = typeGraph.getTypeNode("Class");
    	pattern_12.appendPatternNode("sc", sc_type,false);
    	edu.ustb.sei.mde.graph.type.IStructuralFeatureEdge ls_type = typeGraph.getTypeEdge((edu.ustb.sei.mde.graph.type.TypeNode) c_type,"super");
    	pattern_12.appendPatternEdge("ls", "c", "sc", ls_type);
    	pattern_12.setType(getType_10());
    }
    return pattern_12;
  }
  
  private Pattern pattern_13;
  
  public Pattern getPattern_13() {
    if(pattern_13==null) {
    	edu.ustb.sei.mde.graph.type.TypeGraph typeGraph = getTypeGraph_Uml();
    	pattern_13 = new edu.ustb.sei.mde.graph.pattern.Pattern(typeGraph);
    	edu.ustb.sei.mde.graph.type.ITypeNode c_type = typeGraph.getTypeNode("Class");
    	pattern_13.appendPatternNode("c", c_type,false);
    	edu.ustb.sei.mde.graph.type.ITypeNode sc_type = typeGraph.getTypeNode("Class");
    	pattern_13.appendPatternNode("sc", sc_type,false);
    	edu.ustb.sei.mde.graph.type.IStructuralFeatureEdge ls_type = typeGraph.getTypeEdge((edu.ustb.sei.mde.graph.type.TypeNode) c_type,"super");
    	pattern_13.appendPatternEdge("ls", "c", "sc", ls_type);
    	pattern_13.setType(getType_10());
    }
    return pattern_13;
  }
  
  private Pattern pattern_14;
  
  public Pattern getPattern_14() {
    if(pattern_14==null) {
    	edu.ustb.sei.mde.graph.type.TypeGraph typeGraph = getTypeGraph_Uml();
    	pattern_14 = new edu.ustb.sei.mde.graph.pattern.Pattern(typeGraph);
    	edu.ustb.sei.mde.graph.type.ITypeNode cc_type = typeGraph.getTypeNode("Class");
    	pattern_14.appendPatternNode("cc", cc_type,false);
    	edu.ustb.sei.mde.graph.type.ITypeNode a_type = typeGraph.getTypeNode("Attribute");
    	pattern_14.appendPatternNode("a", a_type,false);
    	edu.ustb.sei.mde.graph.type.ITypeNode n_type = typeGraph.getDataTypeNode("EString");
    	pattern_14.appendPatternNode("n", n_type,false);
    	edu.ustb.sei.mde.graph.type.IStructuralFeatureEdge la_type = typeGraph.getTypeEdge((edu.ustb.sei.mde.graph.type.TypeNode) cc_type,"attributes");
    	pattern_14.appendPatternEdge("la", "cc", "a", la_type);
    	edu.ustb.sei.mde.graph.type.IStructuralFeatureEdge ln_type = typeGraph.getPropertyEdge((edu.ustb.sei.mde.graph.type.TypeNode) a_type,"name");
    	pattern_14.appendPatternEdge("ln", "a", "n", ln_type);
    	pattern_14.addAdditionalField(getType_14().getField("oc"));
    	pattern_14.addAdditionalField(getType_14().getField("prefix"));
    	pattern_14.setType(getType_14());
    }
    return pattern_14;
  }
  
  private Pattern pattern_15;
  
  public Pattern getPattern_15() {
    if(pattern_15==null) {
    	edu.ustb.sei.mde.graph.type.TypeGraph typeGraph = getTypeGraph_Rdbms();
    	pattern_15 = new edu.ustb.sei.mde.graph.pattern.Pattern(typeGraph);
    	edu.ustb.sei.mde.graph.type.ITypeNode t_type = typeGraph.getTypeNode("Table");
    	pattern_15.appendPatternNode("t", t_type,false);
    	edu.ustb.sei.mde.graph.type.ITypeNode c_type = typeGraph.getTypeNode("Column");
    	pattern_15.appendPatternNode("c", c_type,false);
    	edu.ustb.sei.mde.graph.type.ITypeNode n_type = typeGraph.getDataTypeNode("EString");
    	pattern_15.appendPatternNode("n", n_type,false);
    	edu.ustb.sei.mde.graph.type.IStructuralFeatureEdge lc_type = typeGraph.getTypeEdge((edu.ustb.sei.mde.graph.type.TypeNode) t_type,"columns");
    	pattern_15.appendPatternEdge("lc", "t", "c", lc_type);
    	edu.ustb.sei.mde.graph.type.IStructuralFeatureEdge ln_type = typeGraph.getPropertyEdge((edu.ustb.sei.mde.graph.type.TypeNode) c_type,"name");
    	pattern_15.appendPatternEdge("ln", "c", "n", ln_type);
    	pattern_15.setType(getType_9());
    }
    return pattern_15;
  }
  
  private Pattern pattern_16;
  
  public Pattern getPattern_16() {
    if(pattern_16==null) {
    	edu.ustb.sei.mde.graph.type.TypeGraph typeGraph = getTypeGraph_Uml();
    	pattern_16 = new edu.ustb.sei.mde.graph.pattern.Pattern(typeGraph);
    	edu.ustb.sei.mde.graph.type.ITypeNode cc_type = typeGraph.getTypeNode("Class");
    	pattern_16.appendPatternNode("cc", cc_type,false);
    	edu.ustb.sei.mde.graph.type.ITypeNode a_type = typeGraph.getTypeNode("Attribute");
    	pattern_16.appendPatternNode("a", a_type,false);
    	edu.ustb.sei.mde.graph.type.ITypeNode n_type = typeGraph.getDataTypeNode("EString");
    	pattern_16.appendPatternNode("n", n_type,false);
    	edu.ustb.sei.mde.graph.type.IStructuralFeatureEdge la_type = typeGraph.getTypeEdge((edu.ustb.sei.mde.graph.type.TypeNode) cc_type,"attributes");
    	pattern_16.appendPatternEdge("la", "cc", "a", la_type);
    	edu.ustb.sei.mde.graph.type.IStructuralFeatureEdge ln_type = typeGraph.getPropertyEdge((edu.ustb.sei.mde.graph.type.TypeNode) a_type,"name");
    	pattern_16.appendPatternEdge("ln", "a", "n", ln_type);
    	pattern_16.addAdditionalField(getType_14().getField("oc"));
    	pattern_16.addAdditionalField(getType_14().getField("prefix"));
    	pattern_16.setType(getType_14());
    }
    return pattern_16;
  }
  
  private Pattern pattern_17;
  
  public Pattern getPattern_17() {
    if(pattern_17==null) {
    	edu.ustb.sei.mde.graph.type.TypeGraph typeGraph = getTypeGraph_Rdbms();
    	pattern_17 = new edu.ustb.sei.mde.graph.pattern.Pattern(typeGraph);
    	edu.ustb.sei.mde.graph.type.ITypeNode t_type = typeGraph.getTypeNode("Table");
    	pattern_17.appendPatternNode("t", t_type,false);
    	edu.ustb.sei.mde.graph.type.ITypeNode c_type = typeGraph.getTypeNode("Column");
    	pattern_17.appendPatternNode("c", c_type,false);
    	edu.ustb.sei.mde.graph.type.ITypeNode n_type = typeGraph.getDataTypeNode("EString");
    	pattern_17.appendPatternNode("n", n_type,false);
    	edu.ustb.sei.mde.graph.type.IStructuralFeatureEdge lc_type = typeGraph.getTypeEdge((edu.ustb.sei.mde.graph.type.TypeNode) t_type,"columns");
    	pattern_17.appendPatternEdge("lc", "t", "c", lc_type);
    	edu.ustb.sei.mde.graph.type.IStructuralFeatureEdge ln_type = typeGraph.getPropertyEdge((edu.ustb.sei.mde.graph.type.TypeNode) c_type,"name");
    	pattern_17.appendPatternEdge("ln", "c", "n", ln_type);
    	pattern_17.setType(getType_9());
    }
    return pattern_17;
  }
  
  private Pattern pattern_18;
  
  public Pattern getPattern_18() {
    if(pattern_18==null) {
    	edu.ustb.sei.mde.graph.type.TypeGraph typeGraph = getTypeGraph_Uml();
    	pattern_18 = new edu.ustb.sei.mde.graph.pattern.Pattern(typeGraph);
    	edu.ustb.sei.mde.graph.type.ITypeNode cc_type = typeGraph.getTypeNode("Class");
    	pattern_18.appendPatternNode("cc", cc_type,false);
    	edu.ustb.sei.mde.graph.type.ITypeNode sc_type = typeGraph.getTypeNode("Class");
    	pattern_18.appendPatternNode("sc", sc_type,false);
    	edu.ustb.sei.mde.graph.type.IStructuralFeatureEdge ls_type = typeGraph.getTypeEdge((edu.ustb.sei.mde.graph.type.TypeNode) cc_type,"super");
    	pattern_18.appendPatternEdge("ls", "cc", "sc", ls_type);
    	pattern_18.addAdditionalField(getType_15().getField("oc"));
    	pattern_18.setType(getType_15());
    }
    return pattern_18;
  }
  
  private Pattern pattern_19;
  
  public Pattern getPattern_19() {
    if(pattern_19==null) {
    	edu.ustb.sei.mde.graph.type.TypeGraph typeGraph = getTypeGraph_Uml();
    	pattern_19 = new edu.ustb.sei.mde.graph.pattern.Pattern(typeGraph);
    	edu.ustb.sei.mde.graph.type.ITypeNode cc_type = typeGraph.getTypeNode("Class");
    	pattern_19.appendPatternNode("cc", cc_type,false);
    	edu.ustb.sei.mde.graph.type.ITypeNode sc_type = typeGraph.getTypeNode("Class");
    	pattern_19.appendPatternNode("sc", sc_type,false);
    	edu.ustb.sei.mde.graph.type.IStructuralFeatureEdge ls_type = typeGraph.getTypeEdge((edu.ustb.sei.mde.graph.type.TypeNode) cc_type,"super");
    	pattern_19.appendPatternEdge("ls", "cc", "sc", ls_type);
    	pattern_19.addAdditionalField(getType_15().getField("oc"));
    	pattern_19.setType(getType_15());
    }
    return pattern_19;
  }
  
  public ContextType getType_ClassModel() {
    return getType_0();
  }
  
  public Pattern ClassModel() {
    return getPattern_0();
  }
  
  private XmuCore xmu_ClassModelToRdbmsModel;
  
  public XmuCore getXmu_ClassModelToRdbmsModel() throws BidirectionalTransformationDefinitionException {
    if(xmu_ClassModelToRdbmsModel==null) {
    xmu_ClassModelToRdbmsModel = new edu.ustb.sei.mde.bxcore.Align("xmu0", getType_0(), getType_1(), ClassModel(), getPattern_1(), new Condition0(), 
    new edu.ustb.sei.mde.bxcore.ParallelComposition("xmu1", getType_0(), getType_1(), new edu.ustb.sei.mde.bxcore.XmuCore[] {
      new edu.ustb.sei.mde.bxcore.GraphReplace("xmu2", ClassModel(), getPattern_2(), new edu.ustb.sei.mde.structure.Tuple3[]{})
        ,
        new edu.ustb.sei.mde.bxcore.Invocation("xmu3", getType_0(), getType_1(), new edu.ustb.sei.mde.structure.Tuple2[]{edu.ustb.sei.mde.structure.Tuple2.make("m","m")}, new edu.ustb.sei.mde.structure.Tuple2[]{edu.ustb.sei.mde.structure.Tuple2.make("m","m")},()->{try {
        					return getXmu_PackageToSchema();
        				} catch(Exception e){
        					e.printStackTrace();
        					return null;
        				}})
        }), new UnidirectionalAction0(), new UnidirectionalAction1());
      }
      return xmu_ClassModelToRdbmsModel;
    }
    
    public ContextType getType_Package() {
      return getType_2();
    }
    
    public Pattern Package() {
      return getPattern_3();
    }
    
    private XmuCore xmu_PackageToSchema;
    
    public XmuCore getXmu_PackageToSchema() throws BidirectionalTransformationDefinitionException {
      if(xmu_PackageToSchema==null) {
      xmu_PackageToSchema = new edu.ustb.sei.mde.bxcore.Align("xmu4", getType_0(), getType_1(), Package(), getPattern_4(), new Condition1(), 
      new edu.ustb.sei.mde.bxcore.ParallelComposition("xmu5", getType_2(), getType_3(), new edu.ustb.sei.mde.bxcore.XmuCore[] {
        new edu.ustb.sei.mde.bxcore.GraphReplace("xmu6", Package(), getPattern_5(), new edu.ustb.sei.mde.structure.Tuple3[]{edu.ustb.sei.mde.structure.Tuple3.make(new String[]{"n"}, new String[]{"n"}, new edu.ustb.sei.mde.bxcore.bigul.Replace<java.lang.Object[]>())})
          ,
          new edu.ustb.sei.mde.bxcore.Invocation("xmu7", getType_U6(), getType_U11(), new edu.ustb.sei.mde.structure.Tuple2[]{edu.ustb.sei.mde.structure.Tuple2.make("p","p")}, new edu.ustb.sei.mde.structure.Tuple2[]{edu.ustb.sei.mde.structure.Tuple2.make("s","s")},()->{try {
          					return getXmu_ClassToTable();
          				} catch(Exception e){
          					e.printStackTrace();
          					return null;
          				}})
          }), new UnidirectionalAction2(), new UnidirectionalAction3());
        }
        return xmu_PackageToSchema;
      }
      
      private IndexSignature index_c2t;
      
      public IndexSignature getIndex_C2t() {
        if(index_c2t==null) {
        	index_c2t = new edu.ustb.sei.mde.bxcore.IndexSignature("c2t", getType_4(), getType_5());
        }
        return index_c2t;
      }
      
      public ContextType getType_Class() {
        return getType_6();
      }
      
      public Pattern Class() {
        return getPattern_6();
      }
      
      private XmuCore xmu_ClassToTable;
      
      public XmuCore getXmu_ClassToTable() throws BidirectionalTransformationDefinitionException {
        if(xmu_ClassToTable==null) {
        xmu_ClassToTable = new edu.ustb.sei.mde.bxcore.Align("xmu8", getType_U6(), getType_U11(), Class(), getPattern_7(), new Condition4(), 
        new edu.ustb.sei.mde.bxcore.ParallelComposition("xmu9", getType_6(), getType_7(), new edu.ustb.sei.mde.bxcore.XmuCore[] {
          new edu.ustb.sei.mde.bxcore.Indexing(getIndex_C2t(), new String[]{"c"}, new String[]{"t"}, new edu.ustb.sei.mde.bxcore.GraphReplace("xmu11", Class(), getPattern_8(), new edu.ustb.sei.mde.structure.Tuple3[]{edu.ustb.sei.mde.structure.Tuple3.make(new String[]{"n"}, new String[]{"n"}, new edu.ustb.sei.mde.bxcore.bigul.Replace<java.lang.Object[]>())})
            ),
            new edu.ustb.sei.mde.bxcore.Invocation("xmu12", getType_U1(), getType_12(), new edu.ustb.sei.mde.structure.Tuple2[]{edu.ustb.sei.mde.structure.Tuple2.make("c","c")}, new edu.ustb.sei.mde.structure.Tuple2[]{edu.ustb.sei.mde.structure.Tuple2.make("t","t")},()->{try {
            					return getXmu_AttributeToColumn();
            				} catch(Exception e){
            					e.printStackTrace();
            					return null;
            				}})
            }), new UnidirectionalAction4(), new UnidirectionalAction5());
          }
          return xmu_ClassToTable;
        }
        
        public ContextType getType_Attribute() {
          return getType_8();
        }
        
        public Pattern Attribute() {
          return getPattern_9();
        }
        
        private XmuCore xmu_AttributeToColumn;
        
        public XmuCore getXmu_AttributeToColumn() throws BidirectionalTransformationDefinitionException {
          if(xmu_AttributeToColumn==null) {
          xmu_AttributeToColumn = new edu.ustb.sei.mde.bxcore.ParallelComposition("xmu13", getType_U4(), getType_U10(), new edu.ustb.sei.mde.bxcore.XmuCore[] {
          new edu.ustb.sei.mde.bxcore.Align("xmu14", getType_U1(), getType_12(), Attribute(), getPattern_10(), new Condition5(), 
            new edu.ustb.sei.mde.bxcore.GraphReplace("xmu15", Attribute(), getPattern_11(), new edu.ustb.sei.mde.structure.Tuple3[]{edu.ustb.sei.mde.structure.Tuple3.make(new String[]{"n"}, new String[]{"n"}, new edu.ustb.sei.mde.bxcore.bigul.Replace<java.lang.Object[]>())})
              , new UnidirectionalAction6(), new UnidirectionalAction7()),
              new edu.ustb.sei.mde.bxcore.ForEachMatchSource("xmu16", getType_U1(), getPattern_12(),
              new edu.ustb.sei.mde.bxcore.ExpandSource("xmu17", getPattern_13(), 
                new edu.ustb.sei.mde.bxcore.Invocation("xmu18", getType_U3(), getType_12(), new edu.ustb.sei.mde.structure.Tuple2[]{edu.ustb.sei.mde.structure.Tuple2.make("c","oc"),edu.ustb.sei.mde.structure.Tuple2.make("sc","cc")}, new edu.ustb.sei.mde.structure.Tuple2[]{edu.ustb.sei.mde.structure.Tuple2.make("t","t")},()->{try {
                  					return getXmu_SuperAttributeToColumn();
                  				} catch(Exception e){
                  					e.printStackTrace();
                  					return null;
                  				}}),
                  new edu.ustb.sei.mde.structure.Tuple2[] {edu.ustb.sei.mde.structure.Tuple2.make("c", "c"),edu.ustb.sei.mde.structure.Tuple2.make("sc", "sc")}
                  )
                )
              });
            }
            return xmu_AttributeToColumn;
          }
          
          public boolean shouldDrop(final ContextGraph source, final TypedNode c, final ContextGraph view, final TypedNode t, final TypedNode cl, final boolean firstIn) {
            Object _navigate = ExceptionSafeInferface.<Object>navigate(view, cl, "name", false, false, true);
            final String cln = ((String) _navigate);
            final int id = cln.indexOf("-");
            if ((id == (-1))) {
              return (!firstIn);
            }
            final String scn = cln.substring(0, id);
            final String scln = cln.substring((id + 1));
            Object _navigate_1 = ExceptionSafeInferface.<Object>navigate(source, c, "super", true, true, true);
            final Function1<TypedNode, Boolean> _function = (TypedNode sc) -> {
              Object _navigate_2 = ExceptionSafeInferface.<Object>navigate(source, sc, "name", false, false, true);
              final String name = ((String) _navigate_2);
              return Boolean.valueOf(name.equals(scn));
            };
            final TypedNode superClass = IterableExtensions.<TypedNode>findFirst(((List<TypedNode>) _navigate_1), _function);
            if ((superClass == null)) {
              return false;
            }
            final Function1<TypedNode, Boolean> _function_1 = (TypedNode st) -> {
              Object _navigate_2 = ExceptionSafeInferface.<Object>navigate(view, st, "name", false, false, true);
              final String name = ((String) _navigate_2);
              return Boolean.valueOf(name.equals(scn));
            };
            final TypedNode superTable = IterableExtensions.<TypedNode>findFirst(view.allTypedNodes("Table"), _function_1);
            if ((superTable == null)) {
              return false;
            }
            Object _navigate_2 = ExceptionSafeInferface.<Object>navigate(view, superTable, "columns", true, true, true);
            final Function1<TypedNode, Boolean> _function_2 = (TypedNode scl) -> {
              Object _navigate_3 = ExceptionSafeInferface.<Object>navigate(view, scl, "name", false, false, true);
              final String name = ((String) _navigate_3);
              return Boolean.valueOf(name.equals(scln));
            };
            final TypedNode superColumn = IterableExtensions.<TypedNode>findFirst(((List<TypedNode>) _navigate_2), _function_2);
            if ((superColumn == null)) {
              return false;
            }
            Object _navigate_3 = ExceptionSafeInferface.<Object>navigate(source, superClass, "attributes", true, true, true);
            final Function1<TypedNode, Boolean> _function_3 = (TypedNode sca) -> {
              Object _navigate_4 = ExceptionSafeInferface.<Object>navigate(source, sca, "name", false, false, true);
              final String name = ((String) _navigate_4);
              return Boolean.valueOf(name.equals(scln));
            };
            final TypedNode superAttribute = IterableExtensions.<TypedNode>findFirst(((List<TypedNode>) _navigate_3), _function_3);
            if ((superAttribute == null)) {
              return this.shouldDrop(source, superClass, view, superTable, superColumn, false);
            }
            return true;
          }
          
          public String computePrefix(final ContextGraph graph, final TypedNode child, final TypedNode parent) {
            String _xifexpression = null;
            if ((child == parent)) {
              _xifexpression = "";
            } else {
              Object _navigate = ExceptionSafeInferface.<Object>navigate(graph, child, "super", true, true, true);
              final List<TypedNode> superClasses = ((List<TypedNode>) _navigate);
              for (final TypedNode sc : superClasses) {
                {
                  final String nextPath = this.computePrefix(graph, sc, parent);
                  if ((nextPath != null)) {
                    Object _navigate_1 = ExceptionSafeInferface.<Object>navigate(graph, sc, "name", false, false, true);
                    final String scn = ((String) _navigate_1);
                    boolean _equals = nextPath.equals("");
                    if (_equals) {
                      return scn;
                    }
                    return ((scn + "-") + nextPath);
                  }
                }
              }
              return null;
            }
            return _xifexpression;
          }
          
          public class BiGULColumnKey extends BidirectionalTransformation<Object[], Object[]> {
            private String prefix;
            
            private String sn;
            
            private String vn;
            
            private void internalGet() {
              this.vn = ((this.prefix + "-") + this.sn);
            }
            
            private void internalPut() {
              try {
                boolean _equals = this.vn.equals(((this.prefix + "-") + this.sn));
                boolean _not = (!_equals);
                if (_not) {
                  this.<Object>nothing();
                }
              } catch (Throwable _e) {
                throw Exceptions.sneakyThrow(_e);
              }
            }
            
            public Object[] forward(final Object[] s) {
              prefix = (java.lang.String) s[0];
              sn = (java.lang.String) s[1];
              internalGet();
              return new Object[]{vn};
            }
            
            public Object[] backward(final Object[] s, final Object[] v) {
              prefix = (java.lang.String) s[0];
              sn = (java.lang.String) s[1];
              vn = (java.lang.String) v[0];
              internalPut();
              return new Object[]{prefix,sn};
            }
          }
          
          private XmuCore xmu_SuperAttributeToColumn;
          
          public XmuCore getXmu_SuperAttributeToColumn() throws BidirectionalTransformationDefinitionException {
            if(xmu_SuperAttributeToColumn==null) {
            xmu_SuperAttributeToColumn = new edu.ustb.sei.mde.bxcore.ParallelComposition("xmu19", getType_11(), getType_12(), new edu.ustb.sei.mde.bxcore.XmuCore[] {
            new edu.ustb.sei.mde.bxcore.Derive("xmu20", getType_11(), 
              new edu.ustb.sei.mde.bxcore.Align("xmu21", getType_U9(), getType_12(), getPattern_14(), getPattern_15(), new Condition6(), 
                new edu.ustb.sei.mde.bxcore.GraphReplace("xmu22", getPattern_16(), getPattern_17(), new edu.ustb.sei.mde.structure.Tuple3[]{edu.ustb.sei.mde.structure.Tuple3.make(new String[]{"prefix","n"}, new String[]{"n"}, new BiGULColumnKey())})
                  , new UnidirectionalAction9(), new UnidirectionalAction10()),
                  new edu.ustb.sei.mde.structure.Tuple2[]{edu.ustb.sei.mde.structure.Tuple2.make(getType_13().getField("prefix"),new DerivationAction8())}
                  ),
                new edu.ustb.sei.mde.bxcore.ForEachMatchSource("xmu23", getType_11(), getPattern_18(),
                new edu.ustb.sei.mde.bxcore.ExpandSource("xmu24", getPattern_19(), 
                  new edu.ustb.sei.mde.bxcore.Invocation("xmu25", getType_U2(), getType_12(), new edu.ustb.sei.mde.structure.Tuple2[]{edu.ustb.sei.mde.structure.Tuple2.make("oc","oc"),edu.ustb.sei.mde.structure.Tuple2.make("sc","cc")}, new edu.ustb.sei.mde.structure.Tuple2[]{edu.ustb.sei.mde.structure.Tuple2.make("t","t")},()->{try {
                    					return getXmu_SuperAttributeToColumn();
                    				} catch(Exception e){
                    					e.printStackTrace();
                    					return null;
                    				}}),
                    new edu.ustb.sei.mde.structure.Tuple2[] {edu.ustb.sei.mde.structure.Tuple2.make("oc", "oc"),edu.ustb.sei.mde.structure.Tuple2.make("sc", "sc")}
                    )
                  )
                });
              }
              return xmu_SuperAttributeToColumn;
            }
          }
          