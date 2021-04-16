package xmu.bag2bag;

import com.google.common.collect.Iterables;
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
import java.util.List;
import java.util.function.BiFunction;
import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

@SuppressWarnings("all")
public class Bag2Bag extends XmuProgram {
  private TypeGraph typeGraph_bag1;
  
  public TypeGraph getTypeGraph_Bag1() {
    if(typeGraph_bag1==null) {
    	typeGraph_bag1 = new edu.ustb.sei.mde.graph.type.TypeGraph();
    	typeGraph_bag1.declare("Bag");
    	typeGraph_bag1.declare("Element");
    	typeGraph_bag1.declare("EString:java.lang.String");
    	typeGraph_bag1.declare("value:Element->EString");
    	typeGraph_bag1.declare("@elements:Bag->Element*");
    }
    return typeGraph_bag1;
  }
  
  public void registerBag1Package(final URI metamodelUri) {
    registerPackage("bag1", metamodelUri);
  }
  
  public TypedGraph loadBag1Model(final URI modelUri) {
    org.eclipse.emf.ecore.EPackage pack = getPackage("bag1");
    java.util.List<org.eclipse.emf.ecore.EObject> roots = edu.ustb.sei.mde.bxcore.util.EcoreModelUtil.load(modelUri);
    edu.ustb.sei.mde.graph.typedGraph.TypedGraph graph = edu.ustb.sei.mde.bxcore.util.EcoreModelUtil.load(roots, getTypeGraph_Bag1());
    return graph;
  }
  
  public void saveBag1Model(final URI uri, final ContextGraph data, final TypedGraph originalGraph) throws NothingReturnedException, BidirectionalTransformationDefinitionException {
    edu.ustb.sei.mde.bxcore.util.EcoreModelUtil.save(uri, data.getGraph(), originalGraph, getPackage("bag1"));
  }
  
  public void saveBag1Model(final URI uri, final ContextGraph data) throws NothingReturnedException, BidirectionalTransformationDefinitionException {
    edu.ustb.sei.mde.bxcore.util.EcoreModelUtil.save(uri, data.getGraph(), null, getPackage("bag1"));
  }
  
  private TypeGraph typeGraph_bag2;
  
  public TypeGraph getTypeGraph_Bag2() {
    if(typeGraph_bag2==null) {
    	typeGraph_bag2 = new edu.ustb.sei.mde.graph.type.TypeGraph();
    	typeGraph_bag2.declare("Bag");
    	typeGraph_bag2.declare("Element");
    	typeGraph_bag2.declare("EString:java.lang.String");
    	typeGraph_bag2.declare("EInt:int");
    	typeGraph_bag2.declare("value:Element->EString");
    	typeGraph_bag2.declare("count:Element->EInt");
    	typeGraph_bag2.declare("@elements:Bag->Element*");
    }
    return typeGraph_bag2;
  }
  
  public void registerBag2Package(final URI metamodelUri) {
    registerPackage("bag2", metamodelUri);
  }
  
  public TypedGraph loadBag2Model(final URI modelUri) {
    org.eclipse.emf.ecore.EPackage pack = getPackage("bag2");
    java.util.List<org.eclipse.emf.ecore.EObject> roots = edu.ustb.sei.mde.bxcore.util.EcoreModelUtil.load(modelUri);
    edu.ustb.sei.mde.graph.typedGraph.TypedGraph graph = edu.ustb.sei.mde.bxcore.util.EcoreModelUtil.load(roots, getTypeGraph_Bag2());
    return graph;
  }
  
  public void saveBag2Model(final URI uri, final ContextGraph data, final TypedGraph originalGraph) throws NothingReturnedException, BidirectionalTransformationDefinitionException {
    edu.ustb.sei.mde.bxcore.util.EcoreModelUtil.save(uri, data.getGraph(), originalGraph, getPackage("bag2"));
  }
  
  public void saveBag2Model(final URI uri, final ContextGraph data) throws NothingReturnedException, BidirectionalTransformationDefinitionException {
    edu.ustb.sei.mde.bxcore.util.EcoreModelUtil.save(uri, data.getGraph(), null, getPackage("bag2"));
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
      java.lang.String _contextValue = ((java.lang.String) edu.ustb.sei.mde.bxcore.dsl.structure.ExceptionSafeInferface.getValue(source,"v"));
      java.lang.String _contextValue_1 = ((java.lang.String) edu.ustb.sei.mde.bxcore.dsl.structure.ExceptionSafeInferface.getValue(view,"v"));
      boolean _equals = _contextValue.equals(_contextValue_1);
      return Boolean.valueOf(_equals);
    }
  }
  
  public class Condition1 implements BiFunction<SourceType, ViewType, Boolean> {
    public Boolean apply(final SourceType source, final ViewType view) {
      java.util.List<edu.ustb.sei.mde.graph.typedGraph.TypedNode> _contextValue = ((java.util.List<edu.ustb.sei.mde.graph.typedGraph.TypedNode>) edu.ustb.sei.mde.bxcore.dsl.structure.ExceptionSafeInferface.getValue(source,"e"));
      int _size = _contextValue.size();
      int _contextValue_1 = ((int) edu.ustb.sei.mde.bxcore.dsl.structure.ExceptionSafeInferface.getValue(view,"c"));
      boolean _tripleEquals = (_size == _contextValue_1);
      return Boolean.valueOf(_tripleEquals);
    }
  }
  
  public class Condition2 implements BiFunction<SourceType, ViewType, Boolean> {
    public Boolean apply(final SourceType source, final ViewType view) {
      java.util.List<edu.ustb.sei.mde.graph.typedGraph.TypedNode> _contextValue = ((java.util.List<edu.ustb.sei.mde.graph.typedGraph.TypedNode>) edu.ustb.sei.mde.bxcore.dsl.structure.ExceptionSafeInferface.getValue(source,"e"));
      int _size = _contextValue.size();
      int _contextValue_1 = ((int) edu.ustb.sei.mde.bxcore.dsl.structure.ExceptionSafeInferface.getValue(view,"c"));
      boolean _lessThan = (_size < _contextValue_1);
      return Boolean.valueOf(_lessThan);
    }
  }
  
  public class Condition3 implements BiFunction<SourceType, ViewType, Boolean> {
    public Boolean apply(final SourceType source, final ViewType view) {
      java.util.List<edu.ustb.sei.mde.graph.typedGraph.TypedNode> _contextValue = ((java.util.List<edu.ustb.sei.mde.graph.typedGraph.TypedNode>) edu.ustb.sei.mde.bxcore.dsl.structure.ExceptionSafeInferface.getValue(source,"e"));
      int _size = _contextValue.size();
      int _contextValue_1 = ((int) edu.ustb.sei.mde.bxcore.dsl.structure.ExceptionSafeInferface.getValue(view,"c"));
      boolean _greaterThan = (_size > _contextValue_1);
      return Boolean.valueOf(_greaterThan);
    }
  }
  
  public class UnidirectionalAction0 implements BiFunction<SourceType, ViewType, SourceType> {
    public SourceType apply(final SourceType source, final ViewType view) {
      SourceType _xblockexpression = null;
      {
        int _contextValue = ((int) edu.ustb.sei.mde.bxcore.dsl.structure.ExceptionSafeInferface.getValue(view,"c"));
        final int occ = _contextValue;
        java.util.List<edu.ustb.sei.mde.graph.typedGraph.TypedNode> _contextValue_1 = ((java.util.List<edu.ustb.sei.mde.graph.typedGraph.TypedNode>) edu.ustb.sei.mde.bxcore.dsl.structure.ExceptionSafeInferface.getValue(source,"e"));
        final int size = _contextValue_1.size();
        java.util.List<edu.ustb.sei.mde.graph.typedGraph.TypedNode> newInstance = new java.util.ArrayList<>();
        for(int it=0;it<(occ - size);it++) newInstance.add(edu.ustb.sei.mde.bxcore.structures.ContextGraph.newTypedNode(source, "Element"));
        final List<TypedNode> add_e = newInstance;
        java.util.List<edu.ustb.sei.mde.graph.typedGraph.TypedEdge> newInstance_1 = new java.util.ArrayList<>();
        for(int it_1=0;it_1<(occ - size);it_1++) newInstance_1.add(edu.ustb.sei.mde.bxcore.structures.ContextGraph.newTypedEdge(source, "Bag", "elements"));
        final List<TypedEdge> add_le = newInstance_1;
        java.util.List<edu.ustb.sei.mde.graph.typedGraph.ValueEdge> newInstance_2 = new java.util.ArrayList<>();
        for(int it_2=0;it_2<(occ - size);it_2++) newInstance_2.add(edu.ustb.sei.mde.bxcore.structures.ContextGraph.newValueEdge(source, "Element", "value"));
        final List<ValueEdge> add_lv = newInstance_2;
        java.util.List<edu.ustb.sei.mde.graph.typedGraph.TypedNode> _contextValue_2 = ((java.util.List<edu.ustb.sei.mde.graph.typedGraph.TypedNode>) edu.ustb.sei.mde.bxcore.dsl.structure.ExceptionSafeInferface.getValue(source,"e"));
        final List<TypedNode> merged_e = IterableExtensions.<TypedNode>toList(Iterables.<TypedNode>concat(_contextValue_2, add_e));
        java.util.List<edu.ustb.sei.mde.graph.typedGraph.TypedEdge> _contextValue_3 = ((java.util.List<edu.ustb.sei.mde.graph.typedGraph.TypedEdge>) edu.ustb.sei.mde.bxcore.dsl.structure.ExceptionSafeInferface.getValue(source,"le"));
        final List<TypedEdge> merged_le = IterableExtensions.<TypedEdge>toList(Iterables.<TypedEdge>concat(_contextValue_3, add_le));
        java.util.List<edu.ustb.sei.mde.graph.typedGraph.ValueEdge> _contextValue_4 = ((java.util.List<edu.ustb.sei.mde.graph.typedGraph.ValueEdge>) edu.ustb.sei.mde.bxcore.dsl.structure.ExceptionSafeInferface.getValue(source,"lv"));
        final List<ValueEdge> merged_lv = IterableExtensions.<ValueEdge>toList(Iterables.<ValueEdge>concat(_contextValue_4, add_lv));
        edu.ustb.sei.mde.bxcore.structures.GraphModification _modStart = source.modification();
        java.lang.String _contextValue_5 = ((java.lang.String) edu.ustb.sei.mde.bxcore.dsl.structure.ExceptionSafeInferface.getValue(view,"v"));
        edu.ustb.sei.mde.bxcore.structures.GraphModification _mod = _modStart.enforce(getPattern_4(), new edu.ustb.sei.mde.structure.Tuple2[] {edu.ustb.sei.mde.structure.Tuple2.make("le",merged_le),edu.ustb.sei.mde.structure.Tuple2.make("e",merged_e),edu.ustb.sei.mde.structure.Tuple2.make("lv",merged_lv),edu.ustb.sei.mde.structure.Tuple2.make("v",_contextValue_5)});
        _modStart = _mod;
        _xblockexpression = _modStart.get();
      }
      return _xblockexpression;
    }
  }
  
  public class UnidirectionalAction1 implements BiFunction<SourceType, ViewType, SourceType> {
    public SourceType apply(final SourceType source, final ViewType view) {
      SourceType _xblockexpression = null;
      {
        int _contextValue = ((int) edu.ustb.sei.mde.bxcore.dsl.structure.ExceptionSafeInferface.getValue(view,"c"));
        final int occ = _contextValue;
        java.util.List<edu.ustb.sei.mde.graph.typedGraph.TypedNode> _contextValue_1 = ((java.util.List<edu.ustb.sei.mde.graph.typedGraph.TypedNode>) edu.ustb.sei.mde.bxcore.dsl.structure.ExceptionSafeInferface.getValue(source,"e"));
        final int size = _contextValue_1.size();
        java.util.List<edu.ustb.sei.mde.graph.typedGraph.TypedNode> _contextValue_2 = ((java.util.List<edu.ustb.sei.mde.graph.typedGraph.TypedNode>) edu.ustb.sei.mde.bxcore.dsl.structure.ExceptionSafeInferface.getValue(source,"e"));
        final List<TypedNode> all_e = _contextValue_2;
        java.util.List<edu.ustb.sei.mde.graph.typedGraph.TypedEdge> _contextValue_3 = ((java.util.List<edu.ustb.sei.mde.graph.typedGraph.TypedEdge>) edu.ustb.sei.mde.bxcore.dsl.structure.ExceptionSafeInferface.getValue(source,"le"));
        final List<TypedEdge> all_le = _contextValue_3;
        java.util.List<edu.ustb.sei.mde.graph.typedGraph.ValueEdge> _contextValue_4 = ((java.util.List<edu.ustb.sei.mde.graph.typedGraph.ValueEdge>) edu.ustb.sei.mde.bxcore.dsl.structure.ExceptionSafeInferface.getValue(source,"lv"));
        final List<ValueEdge> all_lv = _contextValue_4;
        final List<TypedNode> deleted_e = all_e.subList(occ, size);
        final List<TypedEdge> deleted_le = all_le.subList(occ, size);
        final List<ValueEdge> deleted_lv = all_lv.subList(occ, size);
        edu.ustb.sei.mde.bxcore.structures.GraphModification _modStart = source.modification();
        edu.ustb.sei.mde.bxcore.structures.GraphModification _mod = _modStart.remove(deleted_e);
        _modStart = _mod;
        edu.ustb.sei.mde.bxcore.structures.GraphModification _mod_1 = _modStart.remove(deleted_le);
        _modStart = _mod_1;
        edu.ustb.sei.mde.bxcore.structures.GraphModification _mod_2 = _modStart.remove(deleted_lv);
        _modStart = _mod_2;
        deleted_e.clear();
        deleted_le.clear();
        deleted_lv.clear();
        java.lang.String _contextValue_5 = ((java.lang.String) edu.ustb.sei.mde.bxcore.dsl.structure.ExceptionSafeInferface.getValue(view,"v"));
        edu.ustb.sei.mde.bxcore.structures.GraphModification _mod_3 = _modStart.enforce(getPattern_5(), new edu.ustb.sei.mde.structure.Tuple2[] {edu.ustb.sei.mde.structure.Tuple2.make("le",all_le),edu.ustb.sei.mde.structure.Tuple2.make("e",all_e),edu.ustb.sei.mde.structure.Tuple2.make("lv",all_lv),edu.ustb.sei.mde.structure.Tuple2.make("v",_contextValue_5)});
        _modStart = _mod_3;
        _xblockexpression = _modStart.get();
      }
      return _xblockexpression;
    }
  }
  
  public class UnidirectionalAction2 implements BiFunction<SourceType, ViewType, SourceType> {
    public SourceType apply(final SourceType source, final ViewType view) {
      edu.ustb.sei.mde.bxcore.structures.GraphModification _modStart = source.modification();
      java.util.List<edu.ustb.sei.mde.graph.typedGraph.TypedEdge> _contextValue = ((java.util.List<edu.ustb.sei.mde.graph.typedGraph.TypedEdge>) edu.ustb.sei.mde.bxcore.dsl.structure.ExceptionSafeInferface.getValue(source,"le"));
      edu.ustb.sei.mde.bxcore.structures.GraphModification _mod = _modStart.remove(_contextValue);
      _modStart = _mod;
      java.util.List<edu.ustb.sei.mde.graph.typedGraph.ValueEdge> _contextValue_1 = ((java.util.List<edu.ustb.sei.mde.graph.typedGraph.ValueEdge>) edu.ustb.sei.mde.bxcore.dsl.structure.ExceptionSafeInferface.getValue(source,"lv"));
      edu.ustb.sei.mde.bxcore.structures.GraphModification _mod_1 = _modStart.remove(_contextValue_1);
      _modStart = _mod_1;
      java.util.List<edu.ustb.sei.mde.graph.typedGraph.TypedNode> _contextValue_2 = ((java.util.List<edu.ustb.sei.mde.graph.typedGraph.TypedNode>) edu.ustb.sei.mde.bxcore.dsl.structure.ExceptionSafeInferface.getValue(source,"e"));
      edu.ustb.sei.mde.bxcore.structures.GraphModification _mod_2 = _modStart.remove(_contextValue_2);
      _modStart = _mod_2;
      return _modStart.get();
    }
  }
  
  public class UnidirectionalAction3 implements BiFunction<SourceType, ViewType, SourceType> {
    public SourceType apply(final SourceType source, final ViewType view) {
      SourceType _xblockexpression = null;
      {
        int _contextValue = ((int) edu.ustb.sei.mde.bxcore.dsl.structure.ExceptionSafeInferface.getValue(view,"c"));
        final int occ = _contextValue;
        java.util.List<edu.ustb.sei.mde.graph.typedGraph.TypedNode> newInstance = new java.util.ArrayList<>();
        for(int it=0;it<occ;it++) newInstance.add(edu.ustb.sei.mde.bxcore.structures.ContextGraph.newTypedNode(source, "Element"));
        final List<TypedNode> add_e = newInstance;
        java.util.List<edu.ustb.sei.mde.graph.typedGraph.TypedEdge> newInstance_1 = new java.util.ArrayList<>();
        for(int it_1=0;it_1<occ;it_1++) newInstance_1.add(edu.ustb.sei.mde.bxcore.structures.ContextGraph.newTypedEdge(source, "Bag", "elements"));
        final List<TypedEdge> add_le = newInstance_1;
        java.util.List<edu.ustb.sei.mde.graph.typedGraph.ValueEdge> newInstance_2 = new java.util.ArrayList<>();
        for(int it_2=0;it_2<occ;it_2++) newInstance_2.add(edu.ustb.sei.mde.bxcore.structures.ContextGraph.newValueEdge(source, "Element", "value"));
        final List<ValueEdge> add_lv = newInstance_2;
        edu.ustb.sei.mde.bxcore.structures.GraphModification _modStart = source.modification();
        java.lang.String _contextValue_1 = ((java.lang.String) edu.ustb.sei.mde.bxcore.dsl.structure.ExceptionSafeInferface.getValue(view,"v"));
        edu.ustb.sei.mde.bxcore.structures.GraphModification _mod = _modStart.enforce(getPattern_6(), new edu.ustb.sei.mde.structure.Tuple2[] {edu.ustb.sei.mde.structure.Tuple2.make("le",add_le),edu.ustb.sei.mde.structure.Tuple2.make("e",add_e),edu.ustb.sei.mde.structure.Tuple2.make("lv",add_lv),edu.ustb.sei.mde.structure.Tuple2.make("v",_contextValue_1)});
        _modStart = _mod;
        _xblockexpression = _modStart.get();
      }
      return _xblockexpression;
    }
  }
  
  /**
   * id:0
   */
  private ContextType type_0;
  
  public ContextType getType_0() {
    if(type_0==null) {
    	edu.ustb.sei.mde.graph.type.TypeGraph typeGraph = getTypeGraph_Bag1();
    	type_0 = new edu.ustb.sei.mde.bxcore.structures.ContextType();
    	edu.ustb.sei.mde.graph.type.IType b_type = typeGraph.getTypeNode("Bag")
    	;
    	type_0.addField("b", b_type, false);
    }
    return type_0;
  }
  
  /**
   * id:2
   */
  private ContextType type_2;
  
  public ContextType getType_2() {
    if(type_2==null) {
    	edu.ustb.sei.mde.graph.type.TypeGraph typeGraph = getTypeGraph_Bag1();
    	type_2 = new edu.ustb.sei.mde.bxcore.structures.ContextType();
    	edu.ustb.sei.mde.graph.type.IType b_type = typeGraph.getTypeNode("Bag")
    	;
    	type_2.addField("b", b_type, false);
    	edu.ustb.sei.mde.graph.type.IType e_type = typeGraph.getTypeNode("Element")
    	;
    	type_2.addField("e", e_type, true);
    	edu.ustb.sei.mde.graph.type.IType le_type = typeGraph.getTypeEdge(typeGraph.getTypeNode("Bag"),"elements")
    	;
    	type_2.addField("le", le_type, true);
    	edu.ustb.sei.mde.graph.type.IType lv_type = typeGraph.getPropertyEdge(typeGraph.getTypeNode("Element"),"value")
    	;
    	type_2.addField("lv", lv_type, true);
    	edu.ustb.sei.mde.graph.type.IType v_type = typeGraph.getDataTypeNode("EString")
    	;
    	type_2.addField("v", v_type, false);
    }
    return type_2;
  }
  
  /**
   * id:3
   */
  private ContextType type_3;
  
  public ContextType getType_3() {
    if(type_3==null) {
    	edu.ustb.sei.mde.graph.type.TypeGraph typeGraph = getTypeGraph_Bag2();
    	type_3 = new edu.ustb.sei.mde.bxcore.structures.ContextType();
    	edu.ustb.sei.mde.graph.type.IType b_type = typeGraph.getTypeNode("Bag")
    	;
    	type_3.addField("b", b_type, false);
    	edu.ustb.sei.mde.graph.type.IType c_type = typeGraph.getDataTypeNode("EInt")
    	;
    	type_3.addField("c", c_type, false);
    	edu.ustb.sei.mde.graph.type.IType e_type = typeGraph.getTypeNode("Element")
    	;
    	type_3.addField("e", e_type, false);
    	edu.ustb.sei.mde.graph.type.IType lc_type = typeGraph.getPropertyEdge(typeGraph.getTypeNode("Element"),"count")
    	;
    	type_3.addField("lc", lc_type, false);
    	edu.ustb.sei.mde.graph.type.IType le_type = typeGraph.getTypeEdge(typeGraph.getTypeNode("Bag"),"elements")
    	;
    	type_3.addField("le", le_type, false);
    	edu.ustb.sei.mde.graph.type.IType lv_type = typeGraph.getPropertyEdge(typeGraph.getTypeNode("Element"),"value")
    	;
    	type_3.addField("lv", lv_type, false);
    	edu.ustb.sei.mde.graph.type.IType v_type = typeGraph.getDataTypeNode("EString")
    	;
    	type_3.addField("v", v_type, false);
    }
    return type_3;
  }
  
  /**
   * id:1
   */
  private ContextType type_1;
  
  public ContextType getType_1() {
    if(type_1==null) {
    	edu.ustb.sei.mde.graph.type.TypeGraph typeGraph = getTypeGraph_Bag2();
    	type_1 = new edu.ustb.sei.mde.bxcore.structures.ContextType();
    	edu.ustb.sei.mde.graph.type.IType b_type = typeGraph.getTypeNode("Bag")
    	;
    	type_1.addField("b", b_type, false);
    }
    return type_1;
  }
  
  private Pattern pattern_0;
  
  public Pattern getPattern_0() {
    if(pattern_0==null) {
    	edu.ustb.sei.mde.graph.type.TypeGraph typeGraph = getTypeGraph_Bag1();
    	pattern_0 = new edu.ustb.sei.mde.graph.pattern.Pattern(typeGraph);
    	edu.ustb.sei.mde.graph.type.ITypeNode b_type = typeGraph.getTypeNode("Bag")
    	;
    	pattern_0.appendPatternNode("b", b_type,false);
    	edu.ustb.sei.mde.graph.type.ITypeNode e_type = typeGraph.getTypeNode("Element")
    	;
    	pattern_0.appendPatternNode("e", e_type,true);
    	edu.ustb.sei.mde.graph.type.ITypeNode v_type = typeGraph.getDataTypeNode("EString")
    	;
    	pattern_0.appendPatternNode("v", v_type,false);
    	edu.ustb.sei.mde.graph.type.IStructuralFeatureEdge le_type = typeGraph.getTypeEdge((edu.ustb.sei.mde.graph.type.TypeNode) b_type,"elements");
    	pattern_0.appendPatternEdge("le", "b", "e", le_type);
    	edu.ustb.sei.mde.graph.type.IStructuralFeatureEdge lv_type = typeGraph.getPropertyEdge((edu.ustb.sei.mde.graph.type.TypeNode) e_type,"value");
    	pattern_0.appendPatternEdge("lv", "e", "v", lv_type);
    	pattern_0.setType(getType_2());
    }
    return pattern_0;
  }
  
  private Pattern pattern_1;
  
  public Pattern getPattern_1() {
    if(pattern_1==null) {
    	edu.ustb.sei.mde.graph.type.TypeGraph typeGraph = getTypeGraph_Bag2();
    	pattern_1 = new edu.ustb.sei.mde.graph.pattern.Pattern(typeGraph);
    	edu.ustb.sei.mde.graph.type.ITypeNode b_type = typeGraph.getTypeNode("Bag")
    	;
    	pattern_1.appendPatternNode("b", b_type,false);
    	edu.ustb.sei.mde.graph.type.ITypeNode e_type = typeGraph.getTypeNode("Element")
    	;
    	pattern_1.appendPatternNode("e", e_type,false);
    	edu.ustb.sei.mde.graph.type.ITypeNode v_type = typeGraph.getDataTypeNode("EString")
    	;
    	pattern_1.appendPatternNode("v", v_type,false);
    	edu.ustb.sei.mde.graph.type.ITypeNode c_type = typeGraph.getDataTypeNode("EInt")
    	;
    	pattern_1.appendPatternNode("c", c_type,false);
    	edu.ustb.sei.mde.graph.type.IStructuralFeatureEdge le_type = typeGraph.getTypeEdge((edu.ustb.sei.mde.graph.type.TypeNode) b_type,"elements");
    	pattern_1.appendPatternEdge("le", "b", "e", le_type);
    	edu.ustb.sei.mde.graph.type.IStructuralFeatureEdge lv_type = typeGraph.getPropertyEdge((edu.ustb.sei.mde.graph.type.TypeNode) e_type,"value");
    	pattern_1.appendPatternEdge("lv", "e", "v", lv_type);
    	edu.ustb.sei.mde.graph.type.IStructuralFeatureEdge lc_type = typeGraph.getPropertyEdge((edu.ustb.sei.mde.graph.type.TypeNode) e_type,"count");
    	pattern_1.appendPatternEdge("lc", "e", "c", lc_type);
    	pattern_1.setType(getType_3());
    }
    return pattern_1;
  }
  
  private Pattern pattern_2;
  
  public Pattern getPattern_2() {
    if(pattern_2==null) {
    	edu.ustb.sei.mde.graph.type.TypeGraph typeGraph = getTypeGraph_Bag1();
    	pattern_2 = new edu.ustb.sei.mde.graph.pattern.Pattern(typeGraph);
    	edu.ustb.sei.mde.graph.type.ITypeNode b_type = typeGraph.getTypeNode("Bag")
    	;
    	pattern_2.appendPatternNode("b", b_type,false);
    	edu.ustb.sei.mde.graph.type.ITypeNode e_type = typeGraph.getTypeNode("Element")
    	;
    	pattern_2.appendPatternNode("e", e_type,true);
    	edu.ustb.sei.mde.graph.type.ITypeNode v_type = typeGraph.getDataTypeNode("EString")
    	;
    	pattern_2.appendPatternNode("v", v_type,false);
    	edu.ustb.sei.mde.graph.type.IStructuralFeatureEdge le_type = typeGraph.getTypeEdge((edu.ustb.sei.mde.graph.type.TypeNode) b_type,"elements");
    	pattern_2.appendPatternEdge("le", "b", "e", le_type);
    	edu.ustb.sei.mde.graph.type.IStructuralFeatureEdge lv_type = typeGraph.getPropertyEdge((edu.ustb.sei.mde.graph.type.TypeNode) e_type,"value");
    	pattern_2.appendPatternEdge("lv", "e", "v", lv_type);
    	pattern_2.setType(getType_2());
    }
    return pattern_2;
  }
  
  private Pattern pattern_3;
  
  public Pattern getPattern_3() {
    if(pattern_3==null) {
    	edu.ustb.sei.mde.graph.type.TypeGraph typeGraph = getTypeGraph_Bag2();
    	pattern_3 = new edu.ustb.sei.mde.graph.pattern.Pattern(typeGraph);
    	edu.ustb.sei.mde.graph.type.ITypeNode b_type = typeGraph.getTypeNode("Bag")
    	;
    	pattern_3.appendPatternNode("b", b_type,false);
    	edu.ustb.sei.mde.graph.type.ITypeNode e_type = typeGraph.getTypeNode("Element")
    	;
    	pattern_3.appendPatternNode("e", e_type,false);
    	edu.ustb.sei.mde.graph.type.ITypeNode v_type = typeGraph.getDataTypeNode("EString")
    	;
    	pattern_3.appendPatternNode("v", v_type,false);
    	edu.ustb.sei.mde.graph.type.ITypeNode c_type = typeGraph.getDataTypeNode("EInt")
    	;
    	pattern_3.appendPatternNode("c", c_type,false);
    	edu.ustb.sei.mde.graph.type.IStructuralFeatureEdge le_type = typeGraph.getTypeEdge((edu.ustb.sei.mde.graph.type.TypeNode) b_type,"elements");
    	pattern_3.appendPatternEdge("le", "b", "e", le_type);
    	edu.ustb.sei.mde.graph.type.IStructuralFeatureEdge lv_type = typeGraph.getPropertyEdge((edu.ustb.sei.mde.graph.type.TypeNode) e_type,"value");
    	pattern_3.appendPatternEdge("lv", "e", "v", lv_type);
    	edu.ustb.sei.mde.graph.type.IStructuralFeatureEdge lc_type = typeGraph.getPropertyEdge((edu.ustb.sei.mde.graph.type.TypeNode) e_type,"count");
    	pattern_3.appendPatternEdge("lc", "e", "c", lc_type);
    	pattern_3.setType(getType_3());
    }
    return pattern_3;
  }
  
  private Pattern pattern_4;
  
  public Pattern getPattern_4() {
    if(pattern_4==null) {
    	edu.ustb.sei.mde.graph.type.TypeGraph typeGraph = getTypeGraph_Bag1();
    	pattern_4 = new edu.ustb.sei.mde.graph.pattern.Pattern(typeGraph);
    	edu.ustb.sei.mde.graph.type.ITypeNode b_type = typeGraph.getTypeNode("Bag")
    	;
    	pattern_4.appendPatternNode("b", b_type,false);
    	edu.ustb.sei.mde.graph.type.ITypeNode e_type = typeGraph.getTypeNode("Element")
    	;
    	pattern_4.appendPatternNode("e", e_type,true);
    	edu.ustb.sei.mde.graph.type.ITypeNode v_type = typeGraph.getDataTypeNode("EString")
    	;
    	pattern_4.appendPatternNode("v", v_type,false);
    	edu.ustb.sei.mde.graph.type.IStructuralFeatureEdge le_type = typeGraph.getTypeEdge((edu.ustb.sei.mde.graph.type.TypeNode) b_type,"elements");
    	pattern_4.appendPatternEdge("le", "b", "e", le_type);
    	edu.ustb.sei.mde.graph.type.IStructuralFeatureEdge lv_type = typeGraph.getPropertyEdge((edu.ustb.sei.mde.graph.type.TypeNode) e_type,"value");
    	pattern_4.appendPatternEdge("lv", "e", "v", lv_type);
    	pattern_4.setType(getType_2());
    }
    return pattern_4;
  }
  
  private Pattern pattern_5;
  
  public Pattern getPattern_5() {
    if(pattern_5==null) {
    	edu.ustb.sei.mde.graph.type.TypeGraph typeGraph = getTypeGraph_Bag1();
    	pattern_5 = new edu.ustb.sei.mde.graph.pattern.Pattern(typeGraph);
    	edu.ustb.sei.mde.graph.type.ITypeNode b_type = typeGraph.getTypeNode("Bag")
    	;
    	pattern_5.appendPatternNode("b", b_type,false);
    	edu.ustb.sei.mde.graph.type.ITypeNode e_type = typeGraph.getTypeNode("Element")
    	;
    	pattern_5.appendPatternNode("e", e_type,true);
    	edu.ustb.sei.mde.graph.type.ITypeNode v_type = typeGraph.getDataTypeNode("EString")
    	;
    	pattern_5.appendPatternNode("v", v_type,false);
    	edu.ustb.sei.mde.graph.type.IStructuralFeatureEdge le_type = typeGraph.getTypeEdge((edu.ustb.sei.mde.graph.type.TypeNode) b_type,"elements");
    	pattern_5.appendPatternEdge("le", "b", "e", le_type);
    	edu.ustb.sei.mde.graph.type.IStructuralFeatureEdge lv_type = typeGraph.getPropertyEdge((edu.ustb.sei.mde.graph.type.TypeNode) e_type,"value");
    	pattern_5.appendPatternEdge("lv", "e", "v", lv_type);
    	pattern_5.setType(getType_2());
    }
    return pattern_5;
  }
  
  private Pattern pattern_6;
  
  public Pattern getPattern_6() {
    if(pattern_6==null) {
    	edu.ustb.sei.mde.graph.type.TypeGraph typeGraph = getTypeGraph_Bag1();
    	pattern_6 = new edu.ustb.sei.mde.graph.pattern.Pattern(typeGraph);
    	edu.ustb.sei.mde.graph.type.ITypeNode b_type = typeGraph.getTypeNode("Bag")
    	;
    	pattern_6.appendPatternNode("b", b_type,false);
    	edu.ustb.sei.mde.graph.type.ITypeNode e_type = typeGraph.getTypeNode("Element")
    	;
    	pattern_6.appendPatternNode("e", e_type,true);
    	edu.ustb.sei.mde.graph.type.ITypeNode v_type = typeGraph.getDataTypeNode("EString")
    	;
    	pattern_6.appendPatternNode("v", v_type,false);
    	edu.ustb.sei.mde.graph.type.IStructuralFeatureEdge le_type = typeGraph.getTypeEdge((edu.ustb.sei.mde.graph.type.TypeNode) b_type,"elements");
    	pattern_6.appendPatternEdge("le", "b", "e", le_type);
    	edu.ustb.sei.mde.graph.type.IStructuralFeatureEdge lv_type = typeGraph.getPropertyEdge((edu.ustb.sei.mde.graph.type.TypeNode) e_type,"value");
    	pattern_6.appendPatternEdge("lv", "e", "v", lv_type);
    	pattern_6.setType(getType_2());
    }
    return pattern_6;
  }
  
  private XmuCore xmu_Bag2Bag;
  
  public XmuCore getXmu_Bag2Bag() throws BidirectionalTransformationDefinitionException {
    if(xmu_Bag2Bag==null) {
    xmu_Bag2Bag = new edu.ustb.sei.mde.bxcore.Align("xmu0", getType_0(), getType_1(), getPattern_0(), getPattern_1(), new Condition0(), 
    new edu.ustb.sei.mde.bxcore.Switch("xmu1", getType_2(), getType_3(), 
      java.util.Arrays.asList(
        edu.ustb.sei.mde.structure.Tuple3.make(new Condition1(), 
          new edu.ustb.sei.mde.bxcore.GraphReplace("xmu2", getPattern_2(), getPattern_3(), new edu.ustb.sei.mde.structure.Tuple3[]{edu.ustb.sei.mde.structure.Tuple3.make(new String[]{"v"}, new String[]{"v"}, new edu.ustb.sei.mde.bxcore.bigul.Skip<java.lang.Object[]>()),edu.ustb.sei.mde.structure.Tuple3.make(new String[]{"e"}, new String[]{"c"}, new BiGULCount())})
            , (java.util.function.Function<edu.ustb.sei.mde.bxcore.SourceType, java.lang.Boolean>) null)
            ),
          java.util.Arrays.asList(edu.ustb.sei.mde.structure.Tuple2.make(new Condition2(), 
        new UnidirectionalAction0())
          , edu.ustb.sei.mde.structure.Tuple2.make(new Condition3(), 
        new UnidirectionalAction1())
          ))
        , new UnidirectionalAction2(), new UnidirectionalAction3());
      }
      return xmu_Bag2Bag;
    }
    
    public class BiGULCount extends BidirectionalTransformation<Object[], Object[]> {
      private List<TypedNode> c;
      
      private int count;
      
      private void internalGet() {
        this.count = this.c.size();
      }
      
      private void internalPut() {
        try {
          int _size = this.c.size();
          boolean _tripleNotEquals = (_size != this.count);
          if (_tripleNotEquals) {
            this.<Object>nothing();
          }
        } catch (Throwable _e) {
          throw Exceptions.sneakyThrow(_e);
        }
      }
      
      public Object[] forward(final Object[] s) {
        c = (java.util.List<edu.ustb.sei.mde.graph.typedGraph.TypedNode>) s[0];
        internalGet();
        return new Object[]{count};
      }
      
      public Object[] backward(final Object[] s, final Object[] v) {
        c = (java.util.List<edu.ustb.sei.mde.graph.typedGraph.TypedNode>) s[0];
        count = (int) v[0];
        internalPut();
        return new Object[]{c};
      }
    }
  }
  