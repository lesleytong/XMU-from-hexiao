package edu.ustb.sei.mde.query;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import edu.ustb.sei.mde.query.infra.ecore.EcoreQueryInfrastructure;
import edu.ustb.sei.mde.query.infra.ecore.EcoreTypeContext;
import edu.ustb.sei.mde.query.match.Match;
import edu.ustb.sei.mde.query.match.MatchSet;
import edu.ustb.sei.mde.query.match.QueryEngine;
import edu.ustb.sei.mde.query.pattern.ClosurePattern;
import edu.ustb.sei.mde.query.pattern.EdgePattern;
import edu.ustb.sei.mde.query.pattern.GraphPattern;
import edu.ustb.sei.mde.query.pattern.NegPattern;
import edu.ustb.sei.mde.query.pattern.NodePattern;
import edu.ustb.sei.mde.query.pattern.Pattern;
import edu.ustb.sei.mde.query.pattern.ProjectionPattern;
import edu.ustb.sei.mde.query.pattern.Variable;


class TestToString {
	
	GraphPattern<EClassifier, EStructuralFeature> pat1;
	GraphPattern<EClassifier, EStructuralFeature> negPat;
	GraphPattern<EClassifier, EStructuralFeature> closurePat;
	GraphPattern<EClassifier, EStructuralFeature> pairPat;
	
	

	@BeforeEach
	void setUp() throws Exception {
		buildMainPat();
		buildNegPat();
		buildPairPat();
		buildClosurePat();
	}
	
	protected void buildNegPat() {
		negPat = new GraphPattern<>("negPat");
		NodePattern<EClassifier>[] nodes = NodePattern.make(1);
		nodes[0].setName("x");
		nodes[0].setType(EcorePackage.Literals.ECLASS);
		
		ProjectionPattern proj = new ProjectionPattern(new Variable[] {nodes[0]}, pat1);
		NegPattern neg = new NegPattern(proj);
		
		negPat.setNodes(nodes);
		negPat.setRelations(new Pattern[] {neg});
		negPat.setPorts(new Variable[] {nodes[0]});
	}
	
	protected void buildClosurePat() {
		closurePat = new GraphPattern<>("closurePat");
		NodePattern<EClassifier>[] nodes = NodePattern.make(2);
		nodes[0].setName("u");
		nodes[0].setType(EcorePackage.Literals.ECLASS);
		nodes[1].setName("v");
		nodes[1].setType(EcorePackage.Literals.ECLASS);
		
		ProjectionPattern proj = new ProjectionPattern(nodes, pairPat);
		ClosurePattern closure = new ClosurePattern(proj, true);
		
		closurePat.setNodes(nodes);
		closurePat.setRelations(new Pattern[] {closure});
		closurePat.setPorts(nodes);
	}

	protected void buildMainPat() {
		pat1 = new GraphPattern<>("main");
		NodePattern<EClassifier>[] nodes = NodePattern.make(3);
		nodes[0].setName("c");
		nodes[0].setType(EcorePackage.Literals.ECLASS);
		nodes[1].setName("p");
		nodes[1].setType(EcorePackage.Literals.ECLASS);
		nodes[2].setName("a");
		nodes[2].setType(EcorePackage.Literals.EATTRIBUTE);
		
		EdgePattern<EStructuralFeature>[] edges = EdgePattern.make(2);
		edges[0].setSource(nodes[0]);
		edges[0].setTarget(nodes[1]);
		edges[0].setType(EcorePackage.Literals.ECLASS__ESUPER_TYPES);
		
		edges[1].setSource(nodes[0]);
		edges[1].setTarget(nodes[2]);
		edges[1].setType(EcorePackage.Literals.ECLASS__EATTRIBUTES);
		
		pat1.setNodes(nodes);
		pat1.setRelations(edges);
		pat1.setPorts(new Variable[] {nodes[0]});
	}
	
	protected void buildPairPat() {
		pairPat = new GraphPattern<>("pair");
		NodePattern<EClassifier>[] nodes = NodePattern.make(2);
		nodes[0].setName("c");
		nodes[0].setType(EcorePackage.Literals.ECLASS);
		nodes[1].setName("p");
		nodes[1].setType(EcorePackage.Literals.ECLASS);
		
		EdgePattern<EStructuralFeature>[] edges = EdgePattern.make(1);
		edges[0].setSource(nodes[0]);
		edges[0].setTarget(nodes[1]);
		edges[0].setType(EcorePackage.Literals.ECLASS__ESUPER_TYPES);
				
		pairPat.setNodes(nodes);
		pairPat.setRelations(edges);
		pairPat.setPorts(nodes);
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testSinglePattern() {
		System.out.println(pat1.toString());
		System.out.println(negPat.toString());
		System.out.println(pairPat.toString());
		System.out.println(closurePat.toString());
	}
	
	@Test
	void testInfra() throws Exception {
		EPackage ecorePackage = EcorePackage.eINSTANCE;
		ResourceSet res = new ResourceSetImpl();
		res.getPackageRegistry().put(ecorePackage.getNsURI(), ecorePackage);
		res.getResourceFactoryRegistry().getExtensionToFactoryMap().put(
			    Resource.Factory.Registry.DEFAULT_EXTENSION, new XMIResourceFactoryImpl());
		
		URI uri = URI.createFileURI("/Volumes/Macintosh HD Data/Eclipse Projects/xtext_new/edu.ustb.sei.mde.query/tests/edu/ustb/sei/mde/query/test.ecore");
		Resource model = res.getResource(uri, true);
		
		EcoreTypeContext typeContext = new EcoreTypeContext();
		typeContext.addPackage(ecorePackage);
		EcoreQueryInfrastructure infra = new EcoreQueryInfrastructure();
		infra.setContext(typeContext);
		infra.addModel(model);
		
//		System.out.println(typeContext.toString());
		
		
		QueryEngine<EPackage, Resource, EClassifier, EClass, EObject, EDataType, Object, EStructuralFeature, EReference, Setting, EAttribute, Setting> query = QueryEngine.make(infra, typeContext);
		
		long start = System.currentTimeMillis();
		MatchSet matchSet = query.match(pat1, new Match());
		long end = System.currentTimeMillis();
		
		
		matchSet.forEach(m->{
			System.out.println(m);
			System.out.println();
		});
		
		System.out.println("TOTAL TIME:"+(end-start));
	}
}
