package edu.ustb.sei.mde.query;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import edu.ustb.sei.mde.query.pattern.GraphPattern;
import edu.ustb.sei.mde.query.pattern.Graphlet;
import edu.ustb.sei.mde.query.pattern.Pattern;
import edu.ustb.sei.mde.query.structure.Tuple2;

class GraphPatternTest {
	GraphPattern<Object, Object> graph;
	
	@BeforeEach
	void setUp() throws Exception {
//		graph = new GraphPattern<>("noname");
//		
//		NodePattern[] nodes = NodePattern.make(0, 7);
//		List<EdgePattern> list = new ArrayList<>();
//		
//		
//		graph.setNodes(nodes);
//		list.add(new EdgePattern<>(nodes[0], nodes[1]));
//		list.add(new EdgePattern<>(nodes[0], nodes[2]));
//		list.add(new EdgePattern<>(nodes[1], nodes[4]));
//		list.add(new EdgePattern<>(nodes[2], nodes[3]));
//		list.add(new EdgePattern<>(nodes[2], nodes[5]));
//		list.add(new EdgePattern<>(nodes[5], nodes[3]));
//		list.add(new EdgePattern<>(nodes[6], nodes[5]));
//		list.add(new EdgePattern<>(nodes[6], nodes[3]));
//		list.add(new EdgePattern<>(nodes[4], nodes[5]));
//		graph.setRelations(list.toArray(i->new EdgePattern[i]));
		
		
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void test() {
		Tuple2<List<Graphlet<Object, Object>>, List<Pattern>> tuple = graph.split();
		
		System.out.println(tuple.first.size()+" graphlets");
		for(Graphlet<Object, Object> g : tuple.first) {
			System.out.println("main: "+g.getMainNode());
			System.out.println("neighbors: "+g.getNeighborNodes().stream().map(n->n.toString()).reduce((l,r)->l+", "+r));
			System.out.println("neighbor edges: "+g.getNeighborEdges().stream().map(n->n.toString()).reduce((l,r)->l+", "+r));
			System.out.println("boundary edges: "+g.getBoundaryEdges().stream().map(n->n.toString()).reduce((l,r)->l+", "+r));
			System.out.println("self edges: "+g.getSelfEdges().stream().map(n->n.toString()).reduce((l,r)->l+", "+r));
		}
	}

}
