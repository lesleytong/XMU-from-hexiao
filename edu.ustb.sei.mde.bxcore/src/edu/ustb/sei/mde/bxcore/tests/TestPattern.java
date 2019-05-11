package edu.ustb.sei.mde.bxcore.tests;

import static org.junit.Assert.*;
import static org.junit.Assume.assumeTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import edu.ustb.sei.mde.bxcore.structures.Context;
import edu.ustb.sei.mde.graph.pattern.Pattern;
import edu.ustb.sei.mde.graph.type.TypeGraph;
import edu.ustb.sei.mde.graph.typedGraph.TypedGraph;

class TestPattern {

	private TypeGraph typeGraph;
	private TypedGraph typedGraph;
	
	@BeforeEach
	void setUp() throws Exception {
		buildTypeGraph();
		buildTypedGraph();
	}

	public void buildTypedGraph() {
		typedGraph = new TypedGraph(typeGraph);
		
		// add nodes
		typedGraph.declare(
				"a1:A;"
				+"a2:A;"
				+"b1:B;"
				+"b2:B;"
				+"b3:B;"
				+"b4:B;"
				+"b5:B;"
				+"b6:B;"
				+"c1:C;"
				+"a1-a2b->b1;"
				+"a1-a2b->b2;"
				+"a1-a2b->b3;"
				+"a2-a2b->b4;"
				+"a2-a2b->b5;"
				+"a2-a2b->b6;"
				+"b1-b2c->c1;"
				+"b2-b2c->c1;"
				+"b3-b2c->c1;"
				+"b4-b2c->c1;"
				+"b5-b2c->c1;"
				+"b6-b2c->c1;"
				+"a1.a2S=\"str1\";"
				+"a1.a2S=\"str2\";"
				+"a1.a2S=\"str1\";");
	}

	public void buildTypeGraph() {
		typeGraph = new TypeGraph();
		
		// add type nodes
		typeGraph.declare("A");
		typeGraph.declare("B");
		typeGraph.declare("C");
		
		// add data type nodes
		typeGraph.declare("String:java.lang.String");
		
		// add type edges
		typeGraph.declare("a2b:A->B*");
		typeGraph.declare("b2c:B->C");
		
		// add property edges
		typeGraph.declare("a2S:A->String#");
	}

	@AfterEach
	void tearDown() throws Exception {
	}
	
	

	@Test
	void testPlainPatternConstruction() {
		Pattern plainPattern = new Pattern(typeGraph);
		plainPattern.declare("pa:A");
		plainPattern.declare("pb:B");
		plainPattern.declare("pc:C");
		plainPattern.declare("pa2b:pa-a2b->pb");
		plainPattern.declare("pb2c:pb-b2c->pc");
		
		System.out.println(plainPattern.toString());
	}
	
	@Test
	void testSetPatternConstruction() {
		Pattern setPattern = new Pattern(typeGraph);
		setPattern.declare("pa:A");
		setPattern.declare("pb:B*");
		setPattern.declare("pc:C");
		setPattern.declare("pa2b:pa-a2b->pb");
		setPattern.declare("pb2c:pb-b2c->pc");
		
		System.out.println(setPattern.toString());
	}
	
	@Test
	public void testPlainPatternMatching() throws Exception {
		Pattern plainPattern = new Pattern(typeGraph);
		plainPattern.declare("pa:A");
		plainPattern.declare("pb:B");
		plainPattern.declare("pc:C");
		plainPattern.declare("pa2b:pa-a2b->pb");
		plainPattern.declare("pb2c:pb-b2c->pc");
		
		Context base = Context.emptyContext();
		
		List<Context> matches = plainPattern.match(typedGraph, base);
		
		Assert.assertTrue(matches.size()+" matches are found", matches.size()==6);
		Assert.assertTrue(matches.stream().allMatch(match->plainPattern.isMatchOf(typedGraph, match)));
	}
	
	@Test
	public void testSetPatternMatching() throws Exception {
		Pattern setPattern = new Pattern(typeGraph);
		setPattern.declare("pa:A");
		setPattern.declare("pb:B*");
		setPattern.declare("pc:C");
		setPattern.declare("pa2b:pa-a2b->pb");
		setPattern.declare("pb2c:pb-b2c->pc");
		
		Context base = Context.emptyContext();
		
		List<Context> matches = setPattern.match(typedGraph, base);
		
		Assert.assertTrue(matches.size()+" matches are found", matches.size()==2);
		Assert.assertTrue(matches.stream().allMatch(match->setPattern.isMatchOf(typedGraph, match)));
	}

	@Test
	public void testName() throws Exception {
		Object[] left = new Object[] {1,2,3};
		Object[] right = new Object[] {1,2,3};
		
		
		Assert.assertTrue(Arrays.equals(left,right));
	}
}
