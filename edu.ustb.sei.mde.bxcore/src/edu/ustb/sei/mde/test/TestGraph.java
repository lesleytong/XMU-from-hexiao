package edu.ustb.sei.mde.test;


import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;

import javax.xml.transform.Source;

import org.junit.Assert;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import edu.ustb.sei.mde.bxcore.Align;
import edu.ustb.sei.mde.bxcore.ExpandSource;
import edu.ustb.sei.mde.bxcore.ExpandView;
import edu.ustb.sei.mde.bxcore.GraphReplace;
import edu.ustb.sei.mde.bxcore.IndexSignature;
import edu.ustb.sei.mde.bxcore.Indexing;
import edu.ustb.sei.mde.bxcore.MatchSource;
import edu.ustb.sei.mde.bxcore.MatchView;
import edu.ustb.sei.mde.bxcore.ParallelComposition;
import edu.ustb.sei.mde.bxcore.SourceType;
import edu.ustb.sei.mde.bxcore.Switch;
import edu.ustb.sei.mde.bxcore.TraceSystem;
import edu.ustb.sei.mde.bxcore.ViewType;
import edu.ustb.sei.mde.bxcore.XmuCore;
import edu.ustb.sei.mde.bxcore.bigul.BidirectionalTransformation;
import edu.ustb.sei.mde.bxcore.bigul.Replace;
import edu.ustb.sei.mde.bxcore.exceptions.BidirectionalTransformationDefinitionException;
import edu.ustb.sei.mde.bxcore.exceptions.NothingReturnedException;
import edu.ustb.sei.mde.bxcore.exceptions.UninitializedException;
import edu.ustb.sei.mde.bxcore.structures.Context;
import edu.ustb.sei.mde.bxcore.structures.ContextType;
import edu.ustb.sei.mde.bxcore.structures.FieldDef;
import edu.ustb.sei.mde.bxcore.structures.Index;
import edu.ustb.sei.mde.graph.pattern.Pattern;
import edu.ustb.sei.mde.graph.type.PropertyEdge;
import edu.ustb.sei.mde.graph.type.TypeEdge;
import edu.ustb.sei.mde.graph.type.TypeGraph;
import edu.ustb.sei.mde.graph.type.TypeGraphCreator;
import edu.ustb.sei.mde.graph.type.TypeNode;
import edu.ustb.sei.mde.graph.typedGraph.IndexSystem;
import edu.ustb.sei.mde.graph.typedGraph.IndexableElement;
import edu.ustb.sei.mde.graph.typedGraph.TypedGraph;
import edu.ustb.sei.mde.graph.typedGraph.TypedGraphCreator;
import edu.ustb.sei.mde.graph.typedGraph.TypedNode;
import edu.ustb.sei.mde.structure.Tuple2;
import edu.ustb.sei.mde.structure.Tuple3;

class TestGraph {
	
	static TypeGraph typeGraph;
	static TypeGraphCreator typeGraphCreator;
	
	static TypedGraph typedGraph;
	static TypedGraphCreator typedGraphCreator;
	
	static Pattern pattern;
	
	static Context context;
	
	static TypedNode namedElement;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		typeGraphCreator = new TypeGraphCreator(new TypeGraph());
		typeGraph = typeGraphCreator.graph;
		
		typedGraphCreator = new TypedGraphCreator(new TypedGraph(typeGraph));
		typedGraph = typedGraphCreator.graph;
		
		typeGraphCreator.createTypeNode("a", "A", true);
		typeGraphCreator.createTypeNode("b", "B", false);
		typeGraphCreator.createTypeNode("c", "C", false);
		typeGraphCreator.createTypeNode("d", "D", false);
		typeGraphCreator.createTypeNode("e", "E", false);
		typeGraphCreator.createTypeNode("f", "F", false);
		typeGraphCreator.createTypeNode("g", "G", false);
		
		typeGraphCreator.createDataTypeNode("x", "Int", Integer.class);
		typeGraphCreator.createDataTypeNode("y", "String", String.class);
		
		typeGraphCreator.createGeneralizationEdge("b", "a");
		typeGraphCreator.createGeneralizationEdge("c", "b");
		typeGraphCreator.createGeneralizationEdge("c", "d");
		typeGraphCreator.createGeneralizationEdge("d", "a");
		
		
		typeGraphCreator.createTypeEdge("a", "f", "a_f", true);
		typeGraphCreator.createTypeEdge("c", "g", "c_g", true);
		
		typeGraphCreator.createPropertyEdge("a", "x", "age", false);
		typeGraphCreator.createPropertyEdge("a", "y", "name", false);
		
		typeGraphCreator.createPropertyEdge("f", "y", "name", false);
		typeGraphCreator.createPropertyEdge("g", "y", "name", false);
		
		System.out.println(typeGraph.printGraph());
		
		
		typedGraphCreator.createTypedNode("c1", typeGraph.getTypeNode("C"));
		typedGraphCreator.createTypedNode("c2", typeGraph.getTypeNode("C"));
		typedGraphCreator.createTypedNode("c3", typeGraph.getTypeNode("C"));
		typedGraphCreator.createTypedNode("b1", typeGraph.getTypeNode("B"));
		typedGraphCreator.createTypedNode("d1", typeGraph.getTypeNode("D"));
		typedGraphCreator.createTypedNode("e1", typeGraph.getTypeNode("E"));
		typedGraphCreator.createTypedNode("f1", typeGraph.getTypeNode("F"));
		typedGraphCreator.createTypedNode("f2", typeGraph.getTypeNode("F"));
		typedGraphCreator.createTypedNode("f3", typeGraph.getTypeNode("F"));
		typedGraphCreator.createTypedNode("g1", typeGraph.getTypeNode("G"));
		typedGraphCreator.createTypedNode("g2", typeGraph.getTypeNode("G"));
		typedGraphCreator.createTypedNode("g3", typeGraph.getTypeNode("G"));
		typedGraphCreator.createTypedNode("g4", typeGraph.getTypeNode("G"));
		typedGraphCreator.createValueNode("i1", 1,typeGraph.getDataTypeNode("Int"));
		typedGraphCreator.createValueNode("i2", 2,typeGraph.getDataTypeNode("Int"));
		typedGraphCreator.createValueNode("i3", 3,typeGraph.getDataTypeNode("Int"));
		typedGraphCreator.createValueNode("s1", "name1",typeGraph.getDataTypeNode("String"));
		typedGraphCreator.createValueNode("s2", "name2",typeGraph.getDataTypeNode("String"));
		typedGraphCreator.createValueNode("s3", "name3",typeGraph.getDataTypeNode("String"));
		
		typedGraphCreator.createTypedEdge("c1","f1",typeGraph.getTypeEdge(typeGraph.getTypeNode("C"),"a_f"));
		typedGraphCreator.createTypedEdge("c1","f2",typeGraph.getTypeEdge(typeGraph.getTypeNode("C"),"a_f"));
		typedGraphCreator.createTypedEdge("c2","f3",typeGraph.getTypeEdge(typeGraph.getTypeNode("C"),"a_f"));
		typedGraphCreator.createTypedEdge("c1","g1",typeGraph.getTypeEdge(typeGraph.getTypeNode("C"),"c_g"));
		typedGraphCreator.createTypedEdge("c3","g2",typeGraph.getTypeEdge(typeGraph.getTypeNode("C"),"c_g"));
		typedGraphCreator.createTypedEdge("c3","g3",typeGraph.getTypeEdge(typeGraph.getTypeNode("C"),"c_g"));
		typedGraphCreator.createTypedEdge("b1","f1",typeGraph.getTypeEdge(typeGraph.getTypeNode("B"),"a_f"));
		
		typedGraphCreator.createValueEdge("b1","i1",typeGraph.getPropertyEdge(typeGraph.getTypeNode("B"),"age"));
		typedGraphCreator.createValueEdge("d1","i2",typeGraph.getPropertyEdge(typeGraph.getTypeNode("D"),"age"));
		typedGraphCreator.createValueEdge("c2","i3",typeGraph.getPropertyEdge(typeGraph.getTypeNode("C"),"age"));
		typedGraphCreator.createValueEdge("c1","s1",typeGraph.getPropertyEdge(typeGraph.getTypeNode("C"),"name"));
		typedGraphCreator.createValueEdge("f1","s2",typeGraph.getPropertyEdge(typeGraph.getTypeNode("F"),"name"));
		typedGraphCreator.createValueEdge("g1","s3",typeGraph.getPropertyEdge(typeGraph.getTypeNode("G"),"name"));
		
		
		namedElement = (TypedNode) typedGraphCreator.getNode("f1");
		
		System.out.println(typedGraph.printGraph());
		
		
		pattern = new Pattern();
		pattern.setTypeGraph(typeGraph);
		
		pattern.appendPatternNode("$a", typeGraph.getTypeNode("C"), false);
		pattern.appendPatternNode("$b", typeGraph.getTypeNode("F"), false);
//		pattern.appendPatternNode("$c", typeGraph.getTypeNode("G"));
		pattern.appendPatternNode("$c", typeGraph.getDataTypeNode("String"), false);
		pattern.appendPatternEdge("$e1", "$a","$b", typeGraph.getTypeEdge(typeGraph.getTypeNode("A"),"a_f"));
//		pattern.appendPatternEdge("$e2", "$a","$c", typeGraph.getTypeEdge(typeGraph.getTypeNode("C"),"c_g"));
		pattern.appendPatternEdge("$e2", "$b","$c", typeGraph.getPropertyEdge(typeGraph.getTypeNode("F"),"name"));
		
		
		context = new Context(pattern.getType());
		Index firstIndex = ((IndexableElement)typedGraphCreator.getNode("c1")).getIndex();
		context.setValue("$a", firstIndex);
		context.setValue("$b", IndexSystem.generateUUID());
		context.setValue("$c", "Text");
		context.setValue("$e1", IndexSystem.generateUUID());
		context.setValue("$e2", IndexSystem.generateUUID());
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testGeneralization() {
		TypeNode a = typeGraph.getTypeNode("A");
		TypeNode b = typeGraph.getTypeNode("B");
		TypeNode c = typeGraph.getTypeNode("C");
		TypeNode d = typeGraph.getTypeNode("D");
		List<TypeNode> supers = typeGraph.getAllSuperTypes(c);
		Assert.assertTrue(supers.size()==3);
		Assert.assertTrue(supers.containsAll(Arrays.asList(a,b,d)));
	}
	
	@Test
	void testAssociation() {
		TypeNode a = typeGraph.getTypeNode("A");
		
		List<TypeEdge> aOL = typeGraph.getAllOutgoingTypeEdges(a);
		
		Assert.assertTrue(aOL.size()==1);
		
		TypeNode c = typeGraph.getTypeNode("C");
		
		List<TypeEdge> cOL = typeGraph.getAllOutgoingTypeEdges(c);
		
		Assert.assertTrue(cOL.size()==2);
	}
	
	@Test
	void testProperty() {
		
		TypeNode c = typeGraph.getTypeNode("C");
		
		List<PropertyEdge> cPL = typeGraph.getAllPropertyEdges(c);
		
		Assert.assertTrue(cPL.size()==2);
	}
	
	@Test
	void testMatch() {
//		Matching base = new Matching();
////		base.setHostGraph(typedGraph);
//		base.setPattern(null);
//		base.setBase(null,null);
//		
//		List<Matching> matches = pattern.match(typedGraph, base, InjectiveMapping.create(new HashMap<>()));
//		
//		assert(matches.size()>0);
//		
//		System.out.println(matches.size());
		
		
		
		Context base = new Context(null);
	
		List<Context> matches = pattern.match(typedGraph, base);
	
	assert(matches.size()>0);
	
	System.out.println(matches.size());
	}
	
	@Test
	void testCheck() {
		assert(typeGraph.integrityCheck());
		assert(typedGraph.integrityCheck());
		assert(typedGraph.conformanceCheck());
	}
	
	@Test
	void testPattern() {
		
		TypedGraph graph;
		try {
			graph = pattern.construct(typedGraph, context);
			System.out.println(graph.printGraph());
		} catch (UninitializedException | NothingReturnedException e) {
			assert false;
		}
	}
	
	
	@SuppressWarnings("unchecked")
	@Test
	void testXmuCore() throws BidirectionalTransformationDefinitionException, NothingReturnedException {
		XmuCore bx = new MatchSource("matchS", ContextType.EMPTY_TYPE, pattern,
				new MatchView("matchView", ContextType.EMPTY_TYPE, pattern,
						new GraphReplace("replace", pattern, pattern, new Tuple3[] {
							new Tuple3<String[], String[], BidirectionalTransformation<Object[], Object[]>>(new String[] {"$c"}, new String[] {"$c"}, new Replace<Object[]>())
						})
						)
				);
		
		Context upstreamSource = new Context(ContextType.EMPTY_TYPE);
		
		SourceType sv = SourceType.makeSource(typedGraph, upstreamSource, new TraceSystem());
		
		ViewType vv = bx.forward(sv);
		
		System.out.println(vv.first.printGraph());
		
		TypedGraphCreator creator = new TypedGraphCreator(vv.first);
		
		creator.registerNode("n", vv.first.getAllValueEdges().get(0).getSource());
		
		creator.createValueNode("nn", "xiao", typeGraph.getDataTypeNode("String"));
		
		creator.createValueEdge("n", "nn", typeGraph.getPropertyEdge(typeGraph.getTypeNode("F"), "name"));
		
		System.out.println("changed view:");
		System.out.println(vv.first.printGraph());
		
		
		SourceType sp = bx.backward(SourceType.makeSource(typedGraph, new Context(ContextType.EMPTY_TYPE), new TraceSystem()), ViewType.makeView(vv.first, new Context(ContextType.EMPTY_TYPE)));
		
		System.out.println("updated source:");
		System.out.println(sp.first.printGraph());

		
//		Conversion bx = new Conversion(pattern, pattern);
//		
//		Tuple2<?, ?> [] managedElement = new Tuple2<?, ?> [] {
//			new Tuple2<String, ManageIndexableElement>("$a", new EnforceIndexableElement()),
//			new Tuple2<String, ManageIndexableElement>("$b", new EnforceIndexableElement()),
//			new Tuple2<String, ManageIndexableElement>("$e1", new EnforceIndexableElement()),
//			new Tuple2<String, ManageIndexableElement>("$e2", new EnforceIndexableElement())
//			};
//			
//		bx.setManageSource((Tuple2<String, ManageIndexableElement>[])managedElement);
//		
//		bx.setManageView((Tuple2<String, ManageIndexableElement>[])managedElement);
//		
//		
//		Tuple3<?,?,?>[] body = new Tuple3<?,?,?>[] {
//			new Tuple3<String[],String[],BidirectionalTransformation<Object[], Object[]>>(new String[]{"$c"},new String[]{"$c"},new Replace<Object[]>())
//		};
//		
//		bx.setConvertBody((Tuple3<String[],String[],BidirectionalTransformation<Object[], Object[]>>[])body);
//		
//		Context base = new Context();
//		
//		bx.setBase(base, base);
//		
//		TypedGraph view = bx.forward(typedGraph);
//		
//		
//		System.out.println("get:");
//		System.out.println(view.printGraph());
//		
//		
//		
//		TypedGraphCreator creator = new TypedGraphCreator(view);
//		
//		creator.registerNode("n", view.getAllValueEdges().get(0).getSource());
//		
//		creator.createValueNode("nn", "xiao", typeGraph.getDataTypeNode("String"));
//		
//		creator.createValueEdge("n", "nn", typeGraph.getPropertyEdge(typeGraph.getTypeNode("F"), "name"));
//		
//		System.out.println("changed view:");
//		System.out.println(view.printGraph());
//		
//		TypedGraph updatedSource = bx.backward(typedGraph, view);
//		System.out.println("updated source:");
//		System.out.println(updatedSource.printGraph());
	}
	
	@Test
	void testDeclare() throws NothingReturnedException, BidirectionalTransformationDefinitionException {
		TypeGraph typeS = new TypeGraph();
		typeS.declare("@Person;"
				+ "Student,Person;"
				+ "Teacher,Person;"
				+ "String:java.lang.String;"
				+ "name:Person->String;"
				+ "ID:Student->String;"
				+ "students:Teacher->Student*;"
				+ "classmates:Student->Student*");
		
		TypeGraph typeV = new TypeGraph();
		typeV.declare("Person;"
				+ "String:java.lang.String;"
				+ "name:Person->String;"
				+ "friend1:Person->String;"
				+ "friend2:Person->String;");
		
		
		
		TypedGraph graphS = new TypedGraph(typeS);
		graphS.declare(
				  "t1:Teacher;"
				+ "t2:Teacher;"
				+ "s1:Student;"
				+ "s2:Student;"
				+ "s3:Student;"
				+ "t1.name=\"Tom\";"
				+ "t2.name=\"Tim\";"
				+ "s1.name=\"Sam\";"
				+ "s1.ID=\"0\";"
				+ "s2.name=\"Shawn\";"
				+ "s2.ID=\"1\";"
				+ "s3.name=\"Sara\";"
				+ "s3.ID=\"2\";"
				+ "t1-students->s1;"
				+ "t1-students->s2;"
				+ "t2-students->s3;"
				+ "s1-classmates->s2;");
		
		Pattern patS = new Pattern();
		patS.setTypeGraph(typeS);
		patS.declare(
				"p:Teacher;"
						+ "s1:Student;"
						+ "s2:Student;"
						+ "pn:String;"
						+ "sn1:String;"
						+ "sn2:String;"
						+ "p2pn:p-name->pn;"
						+ "s12sn1:s1-name->sn1;"
						+ "s22sn2:s2-name->sn2;"
						+ "p2s1:p-students->s1;"
						+ "p2s2:p-students->s2;"
						+ "s2s:s1-classmates->s2"
				);
		
		TypedGraph graphV = new TypedGraph(typeV);
		graphV.declare(
				  "p:Person;"
				  + "p.name=\"Turning\";"
				  + "p.friend1=\"Bob\";"
				  + "p.friend2=\"Alice\";"
				);
		
		Pattern patV = new Pattern();
		patV.setTypeGraph(typeV);
		patV.declare(
				  "p:Person;"
				+ "pn:String;"
				+ "sn1:String;"
				+ "sn2:String;"
				+ "p2pn:p-name->pn;"
				+ "p2sn1:p-friend1->sn1;"
				+ "p2sn2:p-friend2->sn2;"
				);
		
		System.out.println(patS.toString());
		System.out.println(patV.toString());
		
		
		
		XmuCore bx = new MatchSource("matchS", ContextType.EMPTY_TYPE, patS,
				new MatchView("matchV", ContextType.EMPTY_TYPE, patV,
						new GraphReplace("replace", patS, patV, new Tuple3[] {
							new Tuple3<String[], String[], BidirectionalTransformation<Object[], Object[]>>(new String[] {"pn","sn1","sn2"}, new String[] {"pn","sn1","sn2"}, new Replace<Object[]>())
						})
						)
				);
		
		ViewType v = bx.forward(SourceType.makeSource(graphS, new Context(ContextType.EMPTY_TYPE), new TraceSystem()));
		System.out.println(v.first.printGraph());
		
		SourceType sp = bx.backward(SourceType.makeSource(graphS, new Context(ContextType.EMPTY_TYPE), new TraceSystem()), ViewType.makeView(graphV, new Context(ContextType.EMPTY_TYPE)));
		System.out.println(sp.first.printGraph());
		
	}
	
	@Test
	void testExpand() throws BidirectionalTransformationDefinitionException, NothingReturnedException {
		TypeGraph typeS = new TypeGraph();
		typeS.declare("Community;"
				+ "String:java.lang.String;"
				+ "host:Community->String;"
				+ "father:Community->String;"
				+ "friend: Community->String");
		
		TypeGraph typeV = new TypeGraph();
		typeV.declare("Person;"
				+ "String:java.lang.String;"
				+ "name:Person->String;"
				+ "father:Person->Person;"
				+ "friend: Person->Person");
		
		Pattern patS1 = new Pattern();
		patS1.setTypeGraph(typeS);
		patS1.declare(
				"c:Community;"
				+ "hn : String;"
				+ "fn : String;"
				+ "rn : String;"
				+ "c2h : c-host->hn;"
				+ "c2f : c-father->fn;"
				+ "c2r : c-friend->rn");
		
		Pattern patV1 = new Pattern();
		patV1.setTypeGraph(typeV);
		patV1.declare(
				"p1:Person;"
				+ "p2:Person;"
				+ "n1 : String;"
				+ "n2 : String;"
				+ "p2n1 : p1-name->n1;"
				+ "p2n2 : p2-name->n2;"
				+ "ph : p1-father->p2");
		
		Pattern patV2 = new Pattern();
		patV2.setTypeGraph(typeV);
		patV2.declare(
				"p1:Person;"
				+ "p2:Person;"
				+ "n1 : String;"
				+ "n2 : String;"
				+ "n0 : String;"
				+ "p2n1 : p1-name->n1;"
				+ "p2n2 : p2-name->n2;"
				+ "ph : p1-friend->p2");
		
		
		TypedGraph source = new TypedGraph(typeS);
		source.declare(
				"c : Community;"
				+ "c.host = \"Tom\";"
				+ "c.father = \"Bob\";"
				+ "c.friend = \"Tom\";");
		
		
		TypedGraph view = new TypedGraph(typeV);
		view.declare(
				"p1 : Person;"
				+ "p1.name = \"Tom-1\";"
				+ "p2 : Person;"
				+ "p2.name = \"Bob-1\";"
				+ "p1-father->p2;"
				+ "p3 : Person;"
				+ "p3.name = \"Alice-1\";"
				+ "p2-friend->p1;");
		
		
		ContextType indexSource = new ContextType();
		indexSource.addField("s_0", typeS.getDataTypeNode("String"));
		
		ContextType indexView = new ContextType();
		indexView.addField("v_0", typeV.getTypeNode("Person"));
		
		IndexSignature signature = new IndexSignature("indexing", indexSource, indexView);
		
		
		XmuCore bx = 
				new MatchSource("matchS_1", ContextType.EMPTY_TYPE, patS1,
						new MatchView("matchV_1", ContextType.EMPTY_TYPE, patV1,
								new Indexing(signature, new String[] {"hn"}, new String[] {"p1"},
										new ExpandView("expandV", patV1, 
												new MatchView("matchV_2",patV2.getType().part(new String[] {"p1","n1","n0"}), patV2, 
														new Indexing(signature, new String[] {"rn"}, new String[] {"p2"},
																new GraphReplace("replace", patS1, patV2,
																		new Tuple3[] {new Tuple3<String[],String[],BidirectionalTransformation<Object[], Object[]>>(new String[] {"hn","fn","rn"}, new String[] {"n0","n1","n2"}, new Replace<Object[]>())}
																		)
																)
														)
												, new Tuple2[] {new Tuple2<String,String>("p2","p1"), new Tuple2<String,String>("n1","n0"), new Tuple2<String,String>("n2","n1")}
												)
										)
								)
						);
		
		System.out.println(source.printGraph());
		System.out.println(view.printGraph());
		
		ViewType v = bx.forward(SourceType.makeSource(source, new Context(ContextType.EMPTY_TYPE), new TraceSystem()));		
		System.out.println(v.first.printGraph());
		
		SourceType sp = bx.backward(SourceType.makeSource(source, new Context(ContextType.EMPTY_TYPE), new TraceSystem()), ViewType.makeView(view, new Context(ContextType.EMPTY_TYPE)));
		System.out.println(sp.first.printGraph());
		
	}
	
	@Test
	void testFork() throws BidirectionalTransformationDefinitionException, NothingReturnedException {
		TypeGraph typeS = new TypeGraph();
		typeS.declare("Community;"
				+ "String:java.lang.String;"
				+ "host:Community->String;"
				+ "father:Community->String;"
				+ "friend: Community->String");
		
		TypeGraph typeV = new TypeGraph();
		typeV.declare("Person;"
				+ "String:java.lang.String;"
				+ "name:Person->String;"
				+ "father:Person->Person;"
				+ "friend: Person->Person");
		
		Pattern patS1 = new Pattern();
		patS1.setTypeGraph(typeS);
		patS1.declare(
				"c:Community;"
				+ "hn : String;"
				+ "fn : String;"
				+ "c2h : c-host->hn;"
				+ "c2f : c-father->fn;");

		Pattern patS2 = new Pattern();
		patS2.setTypeGraph(typeS);
		patS2.declare(
				"c:Community;"
				+ "fn : String;"
				+ "rn : String;"
				+ "c2f : c-father->fn;"
				+ "c2r : c-friend->rn;");
		
		Pattern patV1 = new Pattern();
		patV1.setTypeGraph(typeV);
		patV1.declare(
				"p1:Person;"
				+ "p2:Person;"
				+ "n1 : String;"
				+ "n2 : String;"
				+ "p2n1 : p1-name->n1;"
				+ "p2n2 : p2-name->n2;"
				+ "ph : p1-father->p2");
		
		Pattern patV2 = new Pattern();
		patV2.setTypeGraph(typeV);
		patV2.declare(
				"p1:Person;"
				+ "p2:Person;"
				+ "n1 : String;"
				+ "n2 : String;"
				+ "p2n1 : p1-name->n1;"
				+ "p2n2 : p2-name->n2;"
				+ "ph : p1-friend->p2");
		
		
		TypedGraph source = new TypedGraph(typeS);
		source.declare(
				"c : Community;"
				+ "c.host = \"Tom\";"
				+ "c.father = \"Bob\";"
				+ "c.friend = \"Alice\";");
		
		
		TypedGraph view = new TypedGraph(typeV);
		view.declare(
				"p1 : Person;"
				+ "p1.name = \"Tom-1\";"
				+ "p2 : Person;"
				+ "p2.name = \"Bob-1\";"
				+ "p1-father->p2;"
				+ "p3 : Person;"
				+ "p3.name = \"Alice-1\";"
				+ "p2-friend->p3;");
		
		
		ContextType indexSource = new ContextType();
		indexSource.addField("s_0", typeS.getDataTypeNode("String"));
		
		ContextType indexView = new ContextType();
		indexView.addField("v_0", typeV.getTypeNode("Person"));
		
		IndexSignature signature = new IndexSignature("indexing", indexSource, indexView);
		
		
		XmuCore bx = new ParallelComposition("parallel", ContextType.EMPTY_TYPE, ContextType.EMPTY_TYPE, new XmuCore[] {
				new MatchSource("matchS_1", ContextType.EMPTY_TYPE, patS1,
						new MatchView("matchV_1", ContextType.EMPTY_TYPE, patV1,
								new Indexing(signature, new String[] {"hn"}, new String[] {"p1"},
										new Indexing(signature, new String[] {"fn"}, new String[] {"p2"},
								new GraphReplace("replace_1", patS1, patV1, new Tuple3[] {new Tuple3<>(new String[] {"hn","fn"}, new String[] {"n1","n2"}, new Replace<>())})
								)
										)
								)
						),
				new MatchSource("matchS_2", ContextType.EMPTY_TYPE, patS2,
						new MatchView("matchV_2", ContextType.EMPTY_TYPE, patV2,
								new Indexing(signature, new String[] {"fn"}, new String[] {"p1"},
										new Indexing(signature, new String[] {"rn"}, new String[] {"p2"},
								new GraphReplace("replace_2", patS2, patV2, new Tuple3[] {new Tuple3<>(new String[] {"fn","rn"}, new String[] {"n1","n2"}, new Replace<>())})
								)
										)
								)
						)
		});
		
		System.out.println(source.printGraph());
		System.out.println(view.printGraph());

		ViewType v = bx.forward(SourceType.makeSource(source, new Context(ContextType.EMPTY_TYPE), new TraceSystem()));		
		System.out.println(v.first.printGraph());
		
		SourceType sp = bx.backward(SourceType.makeSource(source, new Context(ContextType.EMPTY_TYPE), new TraceSystem()), ViewType.makeView(view, new Context(ContextType.EMPTY_TYPE)));
		System.out.println(sp.first.printGraph());
		
	}
	
	@Test
	void testSwitch() throws BidirectionalTransformationDefinitionException, NothingReturnedException {
		TypeGraph typeS = new TypeGraph();
		typeS.declare(
				"S;"
				+ "S1,S;"
				+ "S2,S;"
				+ "String:java.lang.String;"
				+ "name:S->String");
		
		TypeGraph typeV = new TypeGraph();
		typeV.declare(
				"V;"
				+ "V1,V;"
				+ "V2,V;"
				+ "String:java.lang.String;"
				+ "name:V->String");
		
		TypedGraph source = new TypedGraph(typeS);
		source.declare(
				"s : S2;"
				+ "s.name = \"Tom\";");
		
		TypedGraph view = new TypedGraph(typeV);
		view.declare(
				"v : V1;"
				+ "v.name = \"Jerry\";");
		
		Pattern patS = new Pattern();
		patS.setTypeGraph(typeS);
		patS.declare(
				"s:S;"
				+ "n : String;"
				+ "s2n : s-name->n;");
		
		Pattern patS1 = new Pattern();
		patS1.setTypeGraph(typeS);
		patS1.declare(
				"s:S1;"
				+ "n : String;"
				+ "s2n : s-name->n;");
		
		Pattern patS2 = new Pattern();
		patS2.setTypeGraph(typeS);
		patS2.declare(
				"s:S2;"
				+ "n : String;"
				+ "s2n : s-name->n;");
		
		Pattern patV = new Pattern();
		patV.setTypeGraph(typeV);
		patV.declare(
				"v:V;"
				+ "n : String;"
				+ "v2n : v-name->n;");
		
		Pattern patV1 = new Pattern();
		patV1.setTypeGraph(typeV);
		patV1.declare(
				"v:V1;"
				+ "n : String;"
				+ "v2n : v-name->n;");
		
		Pattern patV2 = new Pattern();
		patV2.setTypeGraph(typeV);
		patV2.declare(
				"v:V2;"
				+ "n : String;"
				+ "v2n : v-name->n;");
		
		XmuCore bx =
				new MatchSource("matchS", ContextType.EMPTY_TYPE, patS,
						new MatchView("matchV", ContextType.EMPTY_TYPE, patV,
								new Switch("switch", patS.getType(), patV.getType(), 
										new Tuple3[] {
												Tuple3.<BiFunction<SourceType,ViewType,Boolean>,XmuCore,Function<SourceType,Boolean>>make((s,v)->{
													try {
														TypedNode so = s.first.getElementByIndexObject(s.second.getValue("s"));
														TypedNode vo = v.first.getElementByIndexObject(v.second.getValue("v"));														
														return so.getType().getName().equals("S1") && vo.getType().getName().equals("V1");
													} catch (NothingReturnedException | UninitializedException e) {
														return false;
													}
												}, new GraphReplace("replace1", patS1, patV1, new Tuple3[] {Tuple3.make(new String[] {"n"}, new String[] {"n"},  new Replace<Object[]>())}), null),
												Tuple3.<BiFunction<SourceType,ViewType,Boolean>,XmuCore,Function<SourceType,Boolean>>make((s,v)->{
													try {
														TypedNode so = s.first.getElementByIndexObject(s.second.getValue("s"));
														TypedNode vo = v.first.getElementByIndexObject(v.second.getValue("v"));														
														return so.getType().getName().equals("S2") && vo.getType().getName().equals("V2");
													} catch (NothingReturnedException | UninitializedException e) {
														return false;
													}
												}, new GraphReplace("replace2", patS2, patV2, new Tuple3[] {Tuple3.make(new String[] {"n"}, new String[] {"n"},  new Replace<Object[]>())}), null)
										}, 
										new Tuple2[] {
												Tuple2.<BiFunction<SourceType,ViewType,Boolean>, BiFunction<SourceType,ViewType,SourceType>>make(
														(s,v)->{
															try {
																TypedNode so = s.first.getElementByIndexObject(s.second.getValue("s"));
																TypedNode vo = v.first.getElementByIndexObject(v.second.getValue("v"));	
																return so.getType().getName().equals("S1") && vo.getType().getName().equals("V2") || so.getType().getName().equals("S2") && vo.getType().getName().equals("V1");
															} catch(Exception e) {
																return false;
															}
														}, 
														(s,v) -> {
															try {
																TypedNode so = s.first.getElementByIndexObject(s.second.getValue("s"));
																TypedNode vo = v.first.getElementByIndexObject(v.second.getValue("v"));	
																TypedNode ns = null;
																if(vo.getType().getName().equals("V1")) {
																	ns = new TypedNode(s.first.getTypeGraph().getTypeNode("S1"));
																} else {
																	ns = new TypedNode(s.first.getTypeGraph().getTypeNode("S2"));
																}
																ns.mergeIndex(so);
																TypedGraph additive = new TypedGraph(s.first.getTypeGraph());
																additive.addTypedNode(ns);
																
																TypedGraph g = s.first.additiveMerge(additive);
																
																return SourceType.makeSource(g, s.second, s.third);
																
															} catch(Exception e) {
																return s;
															}
														}
														)
										})
								)
						);
		
		ViewType v = bx.forward(SourceType.makeSource(source, ContextType.EMPTY_TYPE.createInstance(), new TraceSystem()));
		System.out.println(v.first.printGraph());
		
		SourceType sp = bx.backward(SourceType.makeSource(source, ContextType.EMPTY_TYPE.createInstance(), new TraceSystem()), 
				ViewType.makeView(view, ContextType.EMPTY_TYPE.createInstance()));
		
		System.out.println(sp.first.printGraph());
	}
	
	@Test
	void testOrder() throws NothingReturnedException {
		TypeGraph type = new TypeGraph();
		type.declare("A;"
				+ "B;"
				+ "String:java.lang.String;"
				+ "bSet:A->B*;"
				+ "name:B->String;");
		
		TypedGraph graph = new TypedGraph(type);
		graph.declare("root : A;"
				+ "b1 : B;"
				+ "b2 : B;"
				+ "b3 : B;"
				+ "b4 : B;"
				+ "root-bSet->b1;"
				+ "root-bSet->b2;"
				+ "root-bSet->b3;"
				+ "root-bSet->b4;"
				+ "b1.name=\"b1\";"
				+ "b2.name=\"b2\";"
				+ "b3.name=\"b3\";"
				+ "b4.name=\"b4\";");
		
		graph.getOrder().add(graph.getAllTypedEdges().get(1).getIndex(), graph.getAllTypedEdges().get(0).getIndex());
		graph.getOrder().add(graph.getAllTypedEdges().get(2).getIndex(), graph.getAllTypedEdges().get(1).getIndex());
		
		Pattern p = new Pattern();
		p.setTypeGraph(type);
		p.declare("r : A;"
				+ "b : B;"
				+ "n : String;"
				+ "r2b : r-bSet->b;"
				+ "b2n : b-name->n;");
		
		p.setOrderBy(p.getPatternElement("r2b"));
		
		
		List<Context> matches = p.match(graph, ContextType.EMPTY_TYPE.createInstance());
		
		graph.enforceOrder();

		System.out.println(matches);
		
		System.out.println(graph.printGraph());
		
	}
	
	@Test
	void testAlign() throws BidirectionalTransformationDefinitionException, NothingReturnedException {
		TypeGraph typeS = new TypeGraph();
		typeS.declare("A;"
				+ "B;"
				+ "String:java.lang.String;"
				+ "bSet:A->B*;"
				+ "name:B->String;");
		TypedGraph graphS = new TypedGraph(typeS);
		graphS.declare("root : A;"
				+ "b1 : B;"
				+ "b2 : B;"
				+ "b3 : B;"
				+ "b4 : B;"
				+ "root-bSet->b1;"
				+ "root-bSet->b2;"
				+ "root-bSet->b3;"
				+ "root-bSet->b4;"
				+ "b1.name=\"b1\";"
				+ "b2.name=\"b2\";"
				+ "b3.name=\"b3\";"
				+ "b4.name=\"b4\";");
		
		Pattern patS0 = new Pattern();
		patS0.setTypeGraph(typeS);
		patS0.declare("r : A;");
		Pattern patS = new Pattern();
		patS.setTypeGraph(typeS);
		patS.declare("r : A;"
				+ "b : B;"
				+ "n : String;"
				+ "r2b : r-bSet->b;"
				+ "b2n : b-name->n;");
		patS.setOrderBy(patS.getPatternElement("r2b"));
		
		
		TypeGraph typeV = new TypeGraph();
		typeV.declare("X;"
				+ "String:java.lang.String;"
				+ "keys:X->String*;");
		TypedGraph graphV = new TypedGraph(typeV);
		graphV.declare("root : X;"
				+ "root.keys=\"b5\";"
				+ "root.keys=\"b6\";"
				+ "root.keys=\"b3\";"
				+ "root.keys=\"b4\";");
		Pattern patV0 = new Pattern();
		patV0.setTypeGraph(typeV);
		patV0.declare("r : X;");
		Pattern patV = new Pattern();
		patV.setTypeGraph(typeV);
		patV.declare("r : X;"
				+ "n : String;"
				+ "r2n : r-keys->n;");
		patV.setOrderBy(patV.getPatternElement("r2n"));
		
		
		XmuCore bx = new MatchSource("matchS", ContextType.EMPTY_TYPE, patS0,
				new MatchView("matchV", ContextType.EMPTY_TYPE, patV0,
						new Align("align", patS0.getType(), patV0.getType(), patS, patV, 
								(s,v)->{
									try {
										return s.getValue("n").equals(v.getValue("n"));
									} catch (UninitializedException | NothingReturnedException e) {
										return false;
									}
								},
								new GraphReplace("replace", patS, patV, new Tuple3[] {Tuple3.make(new String[] {"n"}, new String[] {"n"}, new Replace<Object[]>())}), 
								(s,v)-> {
									TypedGraph r = s.first.getCopy();
									try {
										Index id = s.second.getIndexValue(patS.getType().getField("b"));
										r.remove((TypedNode)r.getElementByIndexObject(id));
									} catch (UninitializedException | NothingReturnedException e) {
									}
									return SourceType.makeSource(r, s.second, s.third);
								}, 
								(s,v)-> {
									Context context = patS.getType().createInstance();
									for(FieldDef<?> k : patS0.getType().fields()) {
										try {
											context.setValue(k.getName(), s.second.getValue(k));
										} catch (NullPointerException|UninitializedException|NothingReturnedException e) {
										}
									}
									patS.getType().initializeSource(context, s.second, v.second, s.third);
									TypedGraph r = s.first;
									try {
										context.setValue("n", v.second.getValue("n"));
										TypedGraph add = patS.construct(s.first, context);
										r = s.first.additiveMerge(add);
									} catch (UninitializedException | NothingReturnedException e) {
									}
									
									return SourceType.makeSource(r, context, s.third);
								} 
						)
				));
		
		ViewType v = bx.forward(SourceType.makeSource(graphS, ContextType.EMPTY_TYPE.createInstance(), new TraceSystem()));
		
		System.out.println(v.first.printGraph());
		
		
		SourceType sp = bx.backward(SourceType.makeSource(graphS, ContextType.EMPTY_TYPE.createInstance(), new TraceSystem()), ViewType.makeView(graphV, ContextType.EMPTY_TYPE.createInstance()));
		
		System.out.println(sp.first.printGraph());
		
	}

}
