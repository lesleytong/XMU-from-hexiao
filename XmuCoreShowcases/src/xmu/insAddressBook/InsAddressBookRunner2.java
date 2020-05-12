package xmu.insAddressBook;

import org.eclipse.emf.common.util.URI;
import edu.ustb.sei.mde.bxcore.SourceType;
import edu.ustb.sei.mde.bxcore.ViewType;
import edu.ustb.sei.mde.bxcore.exceptions.BidirectionalTransformationDefinitionException;
import edu.ustb.sei.mde.bxcore.exceptions.NothingReturnedException;
import edu.ustb.sei.mde.bxcore.structures.ContextGraph;
import edu.ustb.sei.mde.bxcore.util.XmuProgram;
import edu.ustb.sei.mde.graph.type.DataTypeNode;
import edu.ustb.sei.mde.graph.type.PropertyEdge;
import edu.ustb.sei.mde.graph.type.TypeEdge;
import edu.ustb.sei.mde.graph.type.TypeGraph;
import edu.ustb.sei.mde.graph.type.TypeNode;
import edu.ustb.sei.mde.graph.typedGraph.BXMerge;
import edu.ustb.sei.mde.graph.typedGraph.GraphChangeTool;
import edu.ustb.sei.mde.graph.typedGraph.Profiler;
import edu.ustb.sei.mde.graph.typedGraph.TypedEdge;
import edu.ustb.sei.mde.graph.typedGraph.TypedGraph;
import edu.ustb.sei.mde.graph.typedGraph.TypedNode;
import edu.ustb.sei.mde.graph.typedGraph.ValueEdge;
import edu.ustb.sei.mde.graph.typedGraph.ValueNode;
import edu.ustb.sei.mde.structure.Tuple2;
import xmu.uml2rdbms.UML2RDBMS;

@SuppressWarnings("all")
public class InsAddressBookRunner2 extends XmuProgram {
	
	public static void main(String[] args) throws Exception {
		/* please change the basePath to the actual path of the workspace */
		final String basePath =  "E:/git/morel";
		
		final String MetamodelPath = basePath+"/XmuCoreShowcases/metamodel/SimpleAddressBook.ecore";
		
		final String baseModelPath = basePath+"/XmuCoreShowcases/src/xmu/insAddressBook/base.xmi";
		final String aModelPath = basePath+"/XmuCoreShowcases/src/xmu/insAddressBook/a.xmi";
		final String bModelPath = basePath+"/XmuCoreShowcases/src/xmu/insAddressBook/b.xmi";
		final String mergeModelPath = basePath+"/XmuCoreShowcases/src/xmu/insAddressBook/merge.xmi";

		InsAddressBookRunner2 runner2 = new InsAddressBookRunner2();
		runner2.test(MetamodelPath, baseModelPath, aModelPath, bModelPath, mergeModelPath);
	}
	
	
	public void test(String MetamodelPath, String baseModelPath,String aModelPath, 
			String bModelPath, String mergeModelPath) throws Exception {
		
		registerSabPackage(URI.createFileURI(MetamodelPath));
		
		TypedGraph baseModel = loadSabModel(URI.createFileURI(baseModelPath));
		
		TypedGraph aModel = baseModel.getCopy();
		TypedGraph bModel = baseModel.getCopy();
		
		aModelChange(aModel);
		bModelChange(bModel);
		
		saveSabModel(URI.createFileURI(aModelPath), aModel);
		saveSabModel(URI.createFileURI(bModelPath), bModel);
		
		Profiler.begin();
		TypedGraph mergeModel = BXMerge.merge(baseModel, aModel, bModel);
		System.out.println("串行：" + Profiler.end() + "ms");
		saveSabModel(URI.createFileURI(mergeModelPath), mergeModel);
		
	}
	
	 private TypeGraph typeGraph_sab;
	
	 public TypeGraph getTypeGraph_Sab() {
	    if(typeGraph_sab==null) {
	    	typeGraph_sab = new edu.ustb.sei.mde.graph.type.TypeGraph();
	    	// TypedNode
	    	typeGraph_sab.declare("AddressBook");
	    	typeGraph_sab.declare("Person");
	    	// ValueNode
	    	typeGraph_sab.declare("EString:java.lang.String");
	    	// ValueEdge
	    	typeGraph_sab.declare("name:Person->EString");
	    	typeGraph_sab.declare("email:Person->EString*");
	    	typeGraph_sab.declare("tel:Person->EString");
	    	// TypedEdge
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
	
	public void saveSabModel(final URI uri, final TypedGraph graph) throws NothingReturnedException, BidirectionalTransformationDefinitionException {
		edu.ustb.sei.mde.bxcore.util.EcoreModelUtil.save(uri, graph, null, getPackage("sab"));
	}
		
	
	private static void aModelChange(TypedGraph aModel) {
		// 删除TypedNode节点
		TypedNode n1 = aModel.getAllTypedNodes().get(1);
		aModel.remove(n1);
		
		System.out.println("*****************aModel: ");
		print(aModel);
		
	}
	
	private static void bModelChange(TypedGraph bModel) {
		// 新添TypedNode节点，类型为Person
		TypeNode typePerson = bModel.getTypeGraph().getTypeNode("Person");
		TypedNode n4 = new TypedNode();
		n4.setType(typePerson);
		bModel.addTypedNode(n4);
		
		// 新添TypedEdge边，类型为AddressBook-Person
		TypeEdge typeTypedEdge = bModel.getAllTypedEdges().get(0).getType();
		TypedNode n0 = bModel.getAllTypedNodes().get(0);
		TypedEdge e2 = new TypedEdge();
		e2.setType(typeTypedEdge);
		e2.setSource(n0);
		e2.setTarget(n4);
		bModel.addTypedEdge(e2);
		
		// 新添ValueNode节点
		ValueNode nv0 = bModel.getAllValueNodes().get(0);
		ValueNode nv6 = nv0.createConstantNode("Lisa", nv0.getType());
		bModel.addValueNode(nv6);
		
		// 新添ValueEdge边
		PropertyEdge typeValueEdge = bModel.getAllValueEdges().get(0).getType();
		ValueEdge v6 = new ValueEdge();
		v6.setType(typeValueEdge);
		v6.setSource(n4);
		v6.setTarget(nv6);
		bModel.addValueEdge(v6);
		
		System.out.println("*****************bModel: ");
		print(bModel);
		
	}
	
	private static void print(TypedGraph typedGraph) {
		
		System.out.println("TypedNodes: " + typedGraph.getAllTypedNodes().toString());
		System.out.println("TypedEdges: " + typedGraph.getAllTypedEdges().toString());
		System.out.println("ValueNodes: " + typedGraph.getAllValueNodes().toString());
		System.out.println("ValueEdges: " + typedGraph.getAllValueEdges().toString());
		System.out.println("*********************************************************************");
		System.out.println();
	}
	
}
