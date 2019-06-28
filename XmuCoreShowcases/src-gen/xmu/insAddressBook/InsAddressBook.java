package xmu.insAddressBook;

import edu.ustb.sei.mde.bxcore.SourceType;
import edu.ustb.sei.mde.bxcore.ViewType;
import edu.ustb.sei.mde.bxcore.XmuCore;
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
import java.util.function.Function;
import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

@SuppressWarnings("all")
public class InsAddressBook extends XmuProgram {
  private TypeGraph typeGraph_sab;
  
  public TypeGraph getTypeGraph_Sab() {
    if(typeGraph_sab==null) {
    	typeGraph_sab = new edu.ustb.sei.mde.graph.type.TypeGraph();
    	typeGraph_sab.declare("AddressBook");
    	typeGraph_sab.declare("Person");
    	typeGraph_sab.declare("EString:java.lang.String");
    	typeGraph_sab.declare("name:Person->EString");
    	typeGraph_sab.declare("email:Person->EString*");
    	typeGraph_sab.declare("tel:Person->EString");
    	typeGraph_sab.declare("@persons:AddressBook->Person*");
    }
    return typeGraph_sab;
  }
  
  public void registerSabPackage(final URI metamodelUri) {
    registerPackage("sab", metamodelUri);
  }
  
  public TypedGraph loadSabModel(final URI modelUri) {
    org.eclipse.emf.ecore.EPackage pack = getPackage("sab");
    java.util.List<org.eclipse.emf.ecore.EObject> roots = edu.ustb.sei.mde.bxcore.util.EcoreModelUtil.load(modelUri);
    edu.ustb.sei.mde.graph.typedGraph.TypedGraph graph = edu.ustb.sei.mde.bxcore.util.EcoreModelUtil.load(roots, getTypeGraph_Sab());
    return graph;
  }
  
  public void saveSabModel(final URI uri, final ContextGraph data, final TypedGraph originalGraph) throws NothingReturnedException, BidirectionalTransformationDefinitionException {
    edu.ustb.sei.mde.bxcore.util.EcoreModelUtil.save(uri, data.getGraph(), originalGraph, getPackage("sab"));
  }
  
  public void saveSabModel(final URI uri, final ContextGraph data) throws NothingReturnedException, BidirectionalTransformationDefinitionException {
    edu.ustb.sei.mde.bxcore.util.EcoreModelUtil.save(uri, data.getGraph(), null, getPackage("sab"));
  }
  
  private TypeGraph typeGraph_nii;
  
  public TypeGraph getTypeGraph_Nii() {
    if(typeGraph_nii==null) {
    	typeGraph_nii = new edu.ustb.sei.mde.graph.type.TypeGraph();
    	typeGraph_nii.declare("NIIBook");
    	typeGraph_nii.declare("Employee");
    	typeGraph_nii.declare("EString:java.lang.String");
    	typeGraph_nii.declare("name:Employee->EString");
    	typeGraph_nii.declare("email:Employee->EString");
    	typeGraph_nii.declare("@employees:NIIBook->Employee*");
    }
    return typeGraph_nii;
  }
  
  public void registerNiiPackage(final URI metamodelUri) {
    registerPackage("nii", metamodelUri);
  }
  
  public TypedGraph loadNiiModel(final URI modelUri) {
    org.eclipse.emf.ecore.EPackage pack = getPackage("nii");
    java.util.List<org.eclipse.emf.ecore.EObject> roots = edu.ustb.sei.mde.bxcore.util.EcoreModelUtil.load(modelUri);
    edu.ustb.sei.mde.graph.typedGraph.TypedGraph graph = edu.ustb.sei.mde.bxcore.util.EcoreModelUtil.load(roots, getTypeGraph_Nii());
    return graph;
  }
  
  public void saveNiiModel(final URI uri, final ContextGraph data, final TypedGraph originalGraph) throws NothingReturnedException, BidirectionalTransformationDefinitionException {
    edu.ustb.sei.mde.bxcore.util.EcoreModelUtil.save(uri, data.getGraph(), originalGraph, getPackage("nii"));
  }
  
  public void saveNiiModel(final URI uri, final ContextGraph data) throws NothingReturnedException, BidirectionalTransformationDefinitionException {
    edu.ustb.sei.mde.bxcore.util.EcoreModelUtil.save(uri, data.getGraph(), null, getPackage("nii"));
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
  
  public class Condition0 implements Function<ContextGraph, Boolean> {
    public Boolean apply(final ContextGraph context) {
      edu.ustb.sei.mde.graph.typedGraph.TypedNode _contextValue = ((edu.ustb.sei.mde.graph.typedGraph.TypedNode) edu.ustb.sei.mde.bxcore.dsl.structure.ExceptionSafeInferface.getValue(context,"p"));
      
      java.util.List<java.lang.String> _navExp = edu.ustb.sei.mde.bxcore.dsl.structure.ExceptionSafeInferface.navigate(context, _contextValue, "email", false, true, true);
      final Function1<String, Boolean> _function = (String e) -> {
        return Boolean.valueOf(e.endsWith("nii.ac.jp"));
      };
      boolean _exists = IterableExtensions.<String>exists(_navExp, _function);
      return Boolean.valueOf(_exists);
    }
  }
  
  public class Condition1 implements BiFunction<ContextGraph, ContextGraph, Boolean> {
    public Boolean apply(final ContextGraph source, final ContextGraph view) {
      java.lang.String _contextValue = ((java.lang.String) edu.ustb.sei.mde.bxcore.dsl.structure.ExceptionSafeInferface.getValue(source,"n"));
      java.lang.String _contextValue_1 = ((java.lang.String) edu.ustb.sei.mde.bxcore.dsl.structure.ExceptionSafeInferface.getValue(view,"n"));
      boolean _equals = _contextValue.equals(_contextValue_1);
      return Boolean.valueOf(_equals);
    }
  }
  
  public class Condition2 implements BiFunction<SourceType, ViewType, Boolean> {
    public Boolean apply(final SourceType source, final ViewType view) {
      edu.ustb.sei.mde.graph.typedGraph.TypedNode _contextValue = ((edu.ustb.sei.mde.graph.typedGraph.TypedNode) edu.ustb.sei.mde.bxcore.dsl.structure.ExceptionSafeInferface.getValue(source,"p"));
      
      java.util.List<java.lang.String> _navExp = edu.ustb.sei.mde.bxcore.dsl.structure.ExceptionSafeInferface.navigate(source, _contextValue, "email", false, true, true);
      final Function1<String, Boolean> _function = (String e) -> {
        return Boolean.valueOf(e.endsWith("nii.ac.jp"));
      };
      final String firstNiiEmail = IterableExtensions.<String>findFirst(_navExp, _function);
      java.lang.String _contextValue_1 = ((java.lang.String) edu.ustb.sei.mde.bxcore.dsl.structure.ExceptionSafeInferface.getValue(view,"em"));
      return Boolean.valueOf(Boolean.logicalAnd((firstNiiEmail != null), firstNiiEmail.equals(_contextValue_1)));
    }
  }
  
  public class Condition3 implements BiFunction<SourceType, ViewType, Boolean> {
    public Boolean apply(final SourceType source, final ViewType view) {
      return Boolean.valueOf(true);
    }
  }
  
  public class DerivationAction0 implements Function<SourceType, Object> {
    public Object apply(final SourceType source) {
      edu.ustb.sei.mde.graph.typedGraph.TypedNode _contextValue = ((edu.ustb.sei.mde.graph.typedGraph.TypedNode) edu.ustb.sei.mde.bxcore.dsl.structure.ExceptionSafeInferface.getValue(source,"p"));
      
      java.util.List<java.lang.String> _navExp = edu.ustb.sei.mde.bxcore.dsl.structure.ExceptionSafeInferface.navigate(source, _contextValue, "email", false, true, true);
      final Function1<String, Boolean> _function = (String e) -> {
        return Boolean.valueOf(e.endsWith("nii.ac.jp"));
      };
      String _findFirst = IterableExtensions.<String>findFirst(_navExp, _function);
      return _findFirst;
    }
  }
  
  public class UnidirectionalAction1 implements BiFunction<SourceType, ViewType, SourceType> {
    public SourceType apply(final SourceType source, final ViewType view) {
      SourceType _xblockexpression = null;
      {
        edu.ustb.sei.mde.graph.typedGraph.TypedNode _contextValue = ((edu.ustb.sei.mde.graph.typedGraph.TypedNode) edu.ustb.sei.mde.bxcore.dsl.structure.ExceptionSafeInferface.getValue(source,"p"));
        java.lang.String _contextValue_1 = ((java.lang.String) edu.ustb.sei.mde.bxcore.dsl.structure.ExceptionSafeInferface.getValue(view,"em"));
        edu.ustb.sei.mde.graph.typedGraph.ValueEdge newInstance = edu.ustb.sei.mde.bxcore.structures.ContextGraph.newValueEdge(source, "Person", "email",_contextValue,_contextValue_1);
        final ValueEdge nlv = newInstance;
        edu.ustb.sei.mde.bxcore.structures.GraphModification _modStart = source.modification();
        edu.ustb.sei.mde.bxcore.structures.GraphModification _mod = _modStart.insertValueEdgeFirst(nlv);_modStart = _mod;
        _xblockexpression = _modStart.get();
      }
      return _xblockexpression;
    }
  }
  
  public class UnidirectionalAction2 implements BiFunction<SourceType, ViewType, SourceType> {
    public SourceType apply(final SourceType source, final ViewType view) {
      SourceType _xblockexpression = null;
      {
        edu.ustb.sei.mde.graph.typedGraph.TypedNode _contextValue = ((edu.ustb.sei.mde.graph.typedGraph.TypedNode) edu.ustb.sei.mde.bxcore.dsl.structure.ExceptionSafeInferface.getValue(source,"p"));
        
        java.util.List<edu.ustb.sei.mde.graph.typedGraph.ValueEdge> _navExp = edu.ustb.sei.mde.bxcore.dsl.structure.ExceptionSafeInferface.navigate(source, _contextValue, "email", false, true, false);
        final Function1<ValueEdge, Boolean> _function = (ValueEdge e) -> {
          Object _value = e.getTarget().<Object>getValue();
          final String value = ((String) _value);
          return Boolean.valueOf(value.endsWith("nii.ac.jp"));
        };
        final List<ValueEdge> allDeleted = IterableExtensions.<ValueEdge>toList(IterableExtensions.<ValueEdge>filter(_navExp, _function));
        InputOutput.<Integer>println(Integer.valueOf(allDeleted.size()));
        edu.ustb.sei.mde.bxcore.structures.GraphModification _modStart = source.modification();
        edu.ustb.sei.mde.bxcore.structures.GraphModification _mod = _modStart.remove(allDeleted);
        _modStart = _mod;
        _xblockexpression = _modStart.get();
      }
      return _xblockexpression;
    }
  }
  
  public class UnidirectionalAction3 implements BiFunction<SourceType, ViewType, SourceType> {
    public SourceType apply(final SourceType source, final ViewType view) {
      SourceType _xblockexpression = null;
      {
        java.lang.String _contextValue = ((java.lang.String) edu.ustb.sei.mde.bxcore.dsl.structure.ExceptionSafeInferface.getValue(view,"em"));
        final String email = _contextValue;
        java.lang.String _contextValue_1 = ((java.lang.String) edu.ustb.sei.mde.bxcore.dsl.structure.ExceptionSafeInferface.getValue(view,"n"));
        final String name = _contextValue_1;
        edu.ustb.sei.mde.graph.typedGraph.TypedNode _contextValue_2 = ((edu.ustb.sei.mde.graph.typedGraph.TypedNode) edu.ustb.sei.mde.bxcore.dsl.structure.ExceptionSafeInferface.getValue(source,"b"));
        
        java.util.List<edu.ustb.sei.mde.graph.typedGraph.TypedEdge> _navExp = edu.ustb.sei.mde.bxcore.dsl.structure.ExceptionSafeInferface.navigate(source, _contextValue_2, "persons", false, true, false);
        final Function1<TypedEdge, Boolean> _function = (TypedEdge x) -> {
          TypedNode _target = x.getTarget();
          edu.ustb.sei.mde.graph.typedGraph.TypedNode _expValue = _target;
          
          java.lang.String _navExp_1 = edu.ustb.sei.mde.bxcore.dsl.structure.ExceptionSafeInferface.navigate(source, _expValue, "name", false, false, true);
          return Boolean.valueOf(_navExp_1.equals(name));
        };
        final TypedEdge lp = IterableExtensions.<TypedEdge>findFirst(_navExp, _function);
        TypedNode _xifexpression = null;
        if ((lp == null)) {
          edu.ustb.sei.mde.graph.typedGraph.TypedNode newInstance = edu.ustb.sei.mde.bxcore.structures.ContextGraph.newTypedNode(source, "Person");
          _xifexpression = newInstance;
        } else {
          _xifexpression = lp.getTarget();
        }
        final TypedNode n_p = _xifexpression;
        TypedEdge _xifexpression_1 = null;
        if ((lp == null)) {
          edu.ustb.sei.mde.graph.typedGraph.TypedNode _contextValue_3 = ((edu.ustb.sei.mde.graph.typedGraph.TypedNode) edu.ustb.sei.mde.bxcore.dsl.structure.ExceptionSafeInferface.getValue(source,"b"));
          edu.ustb.sei.mde.graph.typedGraph.TypedEdge newInstance_1 = edu.ustb.sei.mde.bxcore.structures.ContextGraph.newTypedEdge(source, "AddressBook", "persons",_contextValue_3,n_p);
          _xifexpression_1 = newInstance_1;
        } else {
          _xifexpression_1 = lp;
        }
        final TypedEdge n_lp = _xifexpression_1;
        ValueEdge _xifexpression_2 = null;
        if ((lp == null)) {
          edu.ustb.sei.mde.graph.typedGraph.ValueEdge newInstance_2 = edu.ustb.sei.mde.bxcore.structures.ContextGraph.newValueEdge(source, "Person", "name",n_p,name);
          _xifexpression_2 = newInstance_2;
        } else {
          edu.ustb.sei.mde.graph.typedGraph.TypedNode _expValue = n_p;
          
          edu.ustb.sei.mde.graph.typedGraph.ValueEdge _navExp_1 = edu.ustb.sei.mde.bxcore.dsl.structure.ExceptionSafeInferface.navigate(source, _expValue, "name", false, false, false);
          _xifexpression_2 = _navExp_1;
        }
        final ValueEdge n_ln = _xifexpression_2;
        edu.ustb.sei.mde.graph.typedGraph.ValueEdge newInstance_3 = edu.ustb.sei.mde.bxcore.structures.ContextGraph.newValueEdge(source, "Person", "email",n_p,email);
        final ValueEdge n_lv = newInstance_3;
        edu.ustb.sei.mde.bxcore.structures.GraphModification _modStart = source.modification();
        edu.ustb.sei.mde.bxcore.structures.GraphModification _mod = _modStart.enforce(getPattern_4(), new edu.ustb.sei.mde.structure.Tuple2[] {edu.ustb.sei.mde.structure.Tuple2.make("lp",n_lp),edu.ustb.sei.mde.structure.Tuple2.make("p",n_p),edu.ustb.sei.mde.structure.Tuple2.make("ln",n_ln),edu.ustb.sei.mde.structure.Tuple2.make("n",name)});
        _modStart = _mod;
        edu.ustb.sei.mde.bxcore.structures.GraphModification _mod_1 = _modStart.insertValueEdge(n_lv);_modStart = _mod_1;
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
    	edu.ustb.sei.mde.graph.type.TypeGraph typeGraph = getTypeGraph_Sab();
    	type_0 = new edu.ustb.sei.mde.bxcore.structures.ContextType();
    	edu.ustb.sei.mde.graph.type.IType b_type = typeGraph.getTypeNode("AddressBook")
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
    	edu.ustb.sei.mde.graph.type.TypeGraph typeGraph = getTypeGraph_Sab();
    	type_2 = new edu.ustb.sei.mde.bxcore.structures.ContextType();
    	edu.ustb.sei.mde.graph.type.IType b_type = typeGraph.getTypeNode("AddressBook")
    	;
    	type_2.addField("b", b_type, false);
    	edu.ustb.sei.mde.graph.type.IType ln_type = typeGraph.getPropertyEdge(typeGraph.getTypeNode("Person"),"name")
    	;
    	type_2.addField("ln", ln_type, false);
    	edu.ustb.sei.mde.graph.type.IType lp_type = typeGraph.getTypeEdge(typeGraph.getTypeNode("AddressBook"),"persons")
    	;
    	type_2.addField("lp", lp_type, false);
    	edu.ustb.sei.mde.graph.type.IType n_type = typeGraph.getDataTypeNode("EString")
    	;
    	type_2.addField("n", n_type, false);
    	edu.ustb.sei.mde.graph.type.IType p_type = typeGraph.getTypeNode("Person")
    	;
    	type_2.addField("p", p_type, false);
    }
    return type_2;
  }
  
  /**
   * id:3
   */
  private ContextType type_3;
  
  public ContextType getType_3() {
    if(type_3==null) {
    	edu.ustb.sei.mde.graph.type.TypeGraph typeGraph = getTypeGraph_Nii();
    	type_3 = new edu.ustb.sei.mde.bxcore.structures.ContextType();
    	edu.ustb.sei.mde.graph.type.IType b_type = typeGraph.getTypeNode("NIIBook")
    	;
    	type_3.addField("b", b_type, false);
    	edu.ustb.sei.mde.graph.type.IType e_type = typeGraph.getTypeNode("Employee")
    	;
    	type_3.addField("e", e_type, false);
    	edu.ustb.sei.mde.graph.type.IType em_type = typeGraph.getDataTypeNode("EString")
    	;
    	type_3.addField("em", em_type, false);
    	edu.ustb.sei.mde.graph.type.IType le_type = typeGraph.getTypeEdge(typeGraph.getTypeNode("NIIBook"),"employees")
    	;
    	type_3.addField("le", le_type, false);
    	edu.ustb.sei.mde.graph.type.IType lem_type = typeGraph.getPropertyEdge(typeGraph.getTypeNode("Employee"),"email")
    	;
    	type_3.addField("lem", lem_type, false);
    	edu.ustb.sei.mde.graph.type.IType ln_type = typeGraph.getPropertyEdge(typeGraph.getTypeNode("Employee"),"name")
    	;
    	type_3.addField("ln", ln_type, false);
    	edu.ustb.sei.mde.graph.type.IType n_type = typeGraph.getDataTypeNode("EString")
    	;
    	type_3.addField("n", n_type, false);
    }
    return type_3;
  }
  
  /**
   * id:4
   */
  private ContextType type_4;
  
  public ContextType getType_4() {
    if(type_4==null) {
    	edu.ustb.sei.mde.graph.type.TypeGraph typeGraph = getTypeGraph_Sab();
    	type_4 = new edu.ustb.sei.mde.bxcore.structures.ContextType();
    	edu.ustb.sei.mde.graph.type.IType em_type = typeGraph.getDataTypeNode("EString")
    	;
    	type_4.addField("em", em_type, false);
    }
    return type_4;
  }
  
  /**
   * id:1
   */
  private ContextType type_1;
  
  public ContextType getType_1() {
    if(type_1==null) {
    	edu.ustb.sei.mde.graph.type.TypeGraph typeGraph = getTypeGraph_Nii();
    	type_1 = new edu.ustb.sei.mde.bxcore.structures.ContextType();
    	edu.ustb.sei.mde.graph.type.IType b_type = typeGraph.getTypeNode("NIIBook")
    	;
    	type_1.addField("b", b_type, false);
    }
    return type_1;
  }
  
  /**
   * id:5
   */
  private ContextType type_5;
  
  public ContextType getType_5() {
    if(type_5==null) {
    	edu.ustb.sei.mde.graph.type.TypeGraph typeGraph = getTypeGraph_Sab();
    	type_5 = new edu.ustb.sei.mde.bxcore.structures.ContextType();
    	edu.ustb.sei.mde.graph.type.IType b_type = typeGraph.getTypeNode("AddressBook")
    	;
    	type_5.addField("b", b_type, false);
    	edu.ustb.sei.mde.graph.type.IType em_type = typeGraph.getDataTypeNode("EString")
    	;
    	type_5.addField("em", em_type, false);
    	edu.ustb.sei.mde.graph.type.IType ln_type = typeGraph.getPropertyEdge(typeGraph.getTypeNode("Person"),"name")
    	;
    	type_5.addField("ln", ln_type, false);
    	edu.ustb.sei.mde.graph.type.IType lp_type = typeGraph.getTypeEdge(typeGraph.getTypeNode("AddressBook"),"persons")
    	;
    	type_5.addField("lp", lp_type, false);
    	edu.ustb.sei.mde.graph.type.IType n_type = typeGraph.getDataTypeNode("EString")
    	;
    	type_5.addField("n", n_type, false);
    	edu.ustb.sei.mde.graph.type.IType p_type = typeGraph.getTypeNode("Person")
    	;
    	type_5.addField("p", p_type, false);
    }
    return type_5;
  }
  
  private Pattern pattern_0;
  
  public Pattern getPattern_0() {
    if(pattern_0==null) {
    	edu.ustb.sei.mde.graph.type.TypeGraph typeGraph = getTypeGraph_Sab();
    	pattern_0 = new edu.ustb.sei.mde.graph.pattern.Pattern(typeGraph);
    	edu.ustb.sei.mde.graph.type.ITypeNode b_type = typeGraph.getTypeNode("AddressBook")
    	;
    	pattern_0.appendPatternNode("b", b_type,false);
    	edu.ustb.sei.mde.graph.type.ITypeNode p_type = typeGraph.getTypeNode("Person")
    	;
    	pattern_0.appendPatternNode("p", p_type,false);
    	edu.ustb.sei.mde.graph.type.ITypeNode n_type = typeGraph.getDataTypeNode("EString")
    	;
    	pattern_0.appendPatternNode("n", n_type,false);
    	edu.ustb.sei.mde.graph.type.IStructuralFeatureEdge lp_type = typeGraph.getTypeEdge((edu.ustb.sei.mde.graph.type.TypeNode) b_type,"persons");
    	pattern_0.appendPatternEdge("lp", "b", "p", lp_type);
    	edu.ustb.sei.mde.graph.type.IStructuralFeatureEdge ln_type = typeGraph.getPropertyEdge((edu.ustb.sei.mde.graph.type.TypeNode) p_type,"name");
    	pattern_0.appendPatternEdge("ln", "p", "n", ln_type);
    	pattern_0.setType(getType_2());
    	pattern_0.setFilter(new Condition0());
    }
    return pattern_0;
  }
  
  private Pattern pattern_1;
  
  public Pattern getPattern_1() {
    if(pattern_1==null) {
    	edu.ustb.sei.mde.graph.type.TypeGraph typeGraph = getTypeGraph_Nii();
    	pattern_1 = new edu.ustb.sei.mde.graph.pattern.Pattern(typeGraph);
    	edu.ustb.sei.mde.graph.type.ITypeNode b_type = typeGraph.getTypeNode("NIIBook")
    	;
    	pattern_1.appendPatternNode("b", b_type,false);
    	edu.ustb.sei.mde.graph.type.ITypeNode e_type = typeGraph.getTypeNode("Employee")
    	;
    	pattern_1.appendPatternNode("e", e_type,false);
    	edu.ustb.sei.mde.graph.type.ITypeNode n_type = typeGraph.getDataTypeNode("EString")
    	;
    	pattern_1.appendPatternNode("n", n_type,false);
    	edu.ustb.sei.mde.graph.type.ITypeNode em_type = typeGraph.getDataTypeNode("EString")
    	;
    	pattern_1.appendPatternNode("em", em_type,false);
    	edu.ustb.sei.mde.graph.type.IStructuralFeatureEdge le_type = typeGraph.getTypeEdge((edu.ustb.sei.mde.graph.type.TypeNode) b_type,"employees");
    	pattern_1.appendPatternEdge("le", "b", "e", le_type);
    	edu.ustb.sei.mde.graph.type.IStructuralFeatureEdge ln_type = typeGraph.getPropertyEdge((edu.ustb.sei.mde.graph.type.TypeNode) e_type,"name");
    	pattern_1.appendPatternEdge("ln", "e", "n", ln_type);
    	edu.ustb.sei.mde.graph.type.IStructuralFeatureEdge lem_type = typeGraph.getPropertyEdge((edu.ustb.sei.mde.graph.type.TypeNode) e_type,"email");
    	pattern_1.appendPatternEdge("lem", "e", "em", lem_type);
    	pattern_1.setType(getType_3());
    }
    return pattern_1;
  }
  
  private Pattern pattern_2;
  
  public Pattern getPattern_2() {
    if(pattern_2==null) {
    	edu.ustb.sei.mde.graph.type.TypeGraph typeGraph = getTypeGraph_Sab();
    	pattern_2 = new edu.ustb.sei.mde.graph.pattern.Pattern(typeGraph);
    	edu.ustb.sei.mde.graph.type.ITypeNode b_type = typeGraph.getTypeNode("AddressBook")
    	;
    	pattern_2.appendPatternNode("b", b_type,false);
    	edu.ustb.sei.mde.graph.type.ITypeNode p_type = typeGraph.getTypeNode("Person")
    	;
    	pattern_2.appendPatternNode("p", p_type,false);
    	edu.ustb.sei.mde.graph.type.ITypeNode n_type = typeGraph.getDataTypeNode("EString")
    	;
    	pattern_2.appendPatternNode("n", n_type,false);
    	edu.ustb.sei.mde.graph.type.IStructuralFeatureEdge lp_type = typeGraph.getTypeEdge((edu.ustb.sei.mde.graph.type.TypeNode) b_type,"persons");
    	pattern_2.appendPatternEdge("lp", "b", "p", lp_type);
    	edu.ustb.sei.mde.graph.type.IStructuralFeatureEdge ln_type = typeGraph.getPropertyEdge((edu.ustb.sei.mde.graph.type.TypeNode) p_type,"name");
    	pattern_2.appendPatternEdge("ln", "p", "n", ln_type);
    	pattern_2.addAdditionalField(getType_5().getField("em"));
    	pattern_2.setType(getType_5());
    }
    return pattern_2;
  }
  
  private Pattern pattern_3;
  
  public Pattern getPattern_3() {
    if(pattern_3==null) {
    	edu.ustb.sei.mde.graph.type.TypeGraph typeGraph = getTypeGraph_Nii();
    	pattern_3 = new edu.ustb.sei.mde.graph.pattern.Pattern(typeGraph);
    	edu.ustb.sei.mde.graph.type.ITypeNode b_type = typeGraph.getTypeNode("NIIBook")
    	;
    	pattern_3.appendPatternNode("b", b_type,false);
    	edu.ustb.sei.mde.graph.type.ITypeNode e_type = typeGraph.getTypeNode("Employee")
    	;
    	pattern_3.appendPatternNode("e", e_type,false);
    	edu.ustb.sei.mde.graph.type.ITypeNode n_type = typeGraph.getDataTypeNode("EString")
    	;
    	pattern_3.appendPatternNode("n", n_type,false);
    	edu.ustb.sei.mde.graph.type.ITypeNode em_type = typeGraph.getDataTypeNode("EString")
    	;
    	pattern_3.appendPatternNode("em", em_type,false);
    	edu.ustb.sei.mde.graph.type.IStructuralFeatureEdge le_type = typeGraph.getTypeEdge((edu.ustb.sei.mde.graph.type.TypeNode) b_type,"employees");
    	pattern_3.appendPatternEdge("le", "b", "e", le_type);
    	edu.ustb.sei.mde.graph.type.IStructuralFeatureEdge ln_type = typeGraph.getPropertyEdge((edu.ustb.sei.mde.graph.type.TypeNode) e_type,"name");
    	pattern_3.appendPatternEdge("ln", "e", "n", ln_type);
    	edu.ustb.sei.mde.graph.type.IStructuralFeatureEdge lem_type = typeGraph.getPropertyEdge((edu.ustb.sei.mde.graph.type.TypeNode) e_type,"email");
    	pattern_3.appendPatternEdge("lem", "e", "em", lem_type);
    	pattern_3.setType(getType_3());
    }
    return pattern_3;
  }
  
  private Pattern pattern_4;
  
  public Pattern getPattern_4() {
    if(pattern_4==null) {
    	edu.ustb.sei.mde.graph.type.TypeGraph typeGraph = getTypeGraph_Sab();
    	pattern_4 = new edu.ustb.sei.mde.graph.pattern.Pattern(typeGraph);
    	edu.ustb.sei.mde.graph.type.ITypeNode b_type = typeGraph.getTypeNode("AddressBook")
    	;
    	pattern_4.appendPatternNode("b", b_type,false);
    	edu.ustb.sei.mde.graph.type.ITypeNode p_type = typeGraph.getTypeNode("Person")
    	;
    	pattern_4.appendPatternNode("p", p_type,false);
    	edu.ustb.sei.mde.graph.type.ITypeNode n_type = typeGraph.getDataTypeNode("EString")
    	;
    	pattern_4.appendPatternNode("n", n_type,false);
    	edu.ustb.sei.mde.graph.type.IStructuralFeatureEdge lp_type = typeGraph.getTypeEdge((edu.ustb.sei.mde.graph.type.TypeNode) b_type,"persons");
    	pattern_4.appendPatternEdge("lp", "b", "p", lp_type);
    	edu.ustb.sei.mde.graph.type.IStructuralFeatureEdge ln_type = typeGraph.getPropertyEdge((edu.ustb.sei.mde.graph.type.TypeNode) p_type,"name");
    	pattern_4.appendPatternEdge("ln", "p", "n", ln_type);
    	pattern_4.setType(getType_2());
    }
    return pattern_4;
  }
  
  private XmuCore xmu_SabBook2NiiBook;
  
  public XmuCore getXmu_SabBook2NiiBook() throws BidirectionalTransformationDefinitionException {
    if(xmu_SabBook2NiiBook==null) {
    xmu_SabBook2NiiBook = new edu.ustb.sei.mde.bxcore.Align("xmu0", getType_0(), getType_1(), getPattern_0(), getPattern_1(), new Condition1(), 
    new edu.ustb.sei.mde.bxcore.Switch("xmu1", getType_2(), getType_3(), 
      java.util.Arrays.asList(
        edu.ustb.sei.mde.structure.Tuple3.make(new Condition2(), 
          new edu.ustb.sei.mde.bxcore.Derive("xmu2", getType_2(), 
            new edu.ustb.sei.mde.bxcore.GraphReplace("xmu3", getPattern_2(), getPattern_3(), new edu.ustb.sei.mde.structure.Tuple3[]{edu.ustb.sei.mde.structure.Tuple3.make(new String[]{"n","em"}, new String[]{"n","em"}, new edu.ustb.sei.mde.bxcore.bigul.Replace<java.lang.Object[]>())})
              ,
              new edu.ustb.sei.mde.structure.Tuple2[]{edu.ustb.sei.mde.structure.Tuple2.make(getType_4().getField("em"),new DerivationAction0())}
              ), (java.util.function.Function<edu.ustb.sei.mde.bxcore.SourceType, java.lang.Boolean>) null)
            ),
          java.util.Arrays.asList(edu.ustb.sei.mde.structure.Tuple2.make(new Condition3(), 
        new UnidirectionalAction1())
          ))
        , new UnidirectionalAction2(), new UnidirectionalAction3());
      }
      return xmu_SabBook2NiiBook;
    }
  }
  