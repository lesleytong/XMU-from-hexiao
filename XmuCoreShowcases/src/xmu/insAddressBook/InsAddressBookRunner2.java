package xmu.insAddressBook;

import org.eclipse.emf.common.util.URI;

import edu.ustb.sei.mde.bxcore.SourceType;
import edu.ustb.sei.mde.bxcore.ViewType;
import edu.ustb.sei.mde.graph.type.DataTypeNode;
import edu.ustb.sei.mde.graph.type.PropertyEdge;
import edu.ustb.sei.mde.graph.type.TypeEdge;
import edu.ustb.sei.mde.graph.type.TypeNode;
import edu.ustb.sei.mde.graph.typedGraph.BXMerge;
import edu.ustb.sei.mde.graph.typedGraph.TypedEdge;
import edu.ustb.sei.mde.graph.typedGraph.TypedGraph;
import edu.ustb.sei.mde.graph.typedGraph.TypedNode;
import edu.ustb.sei.mde.graph.typedGraph.ValueEdge;
import edu.ustb.sei.mde.graph.typedGraph.ValueNode;
import edu.ustb.sei.mde.structure.Tuple2;
import xmu.uml2rdbms.UML2RDBMS;

@SuppressWarnings("all")
public class InsAddressBookRunner2 {

	public static void main(String[] args) throws Exception {
		/* please change the basePath to the actual path of the workspace */
		final String basePath =  "E:/git/morel";
		
		final String MetamodelPath = basePath+"/XmuCoreShowcases/metamodel/SimpleAddressBook.ecore";
		
		final String baseModelPath = basePath+"/XmuCoreShowcases/src/xmu/insAddressBook/base.xmi";
		final String aModelPath = basePath+"/XmuCoreShowcases/src/xmu/insAddressBook/a.xmi";
		final String bModelPath = basePath+"/XmuCoreShowcases/src/xmu/insAddressBook/b.xmi";
		final String mergeModelPath = basePath+"/XmuCoreShowcases/src/xmu/insAddressBook/merge.xmi";

		init(MetamodelPath, baseModelPath, aModelPath, bModelPath);
		
		test(MetamodelPath, baseModelPath, aModelPath, bModelPath, mergeModelPath);
	}
	
	@SuppressWarnings("unchecked")
	static public void init(String MetamodelPath, String baseModelPath,String aModelPath, String bModelPath) throws Exception {
		InsAddressBook bx = new InsAddressBook();
		bx.registerSabPackage(URI.createFileURI(MetamodelPath));
		
		TypedGraph baseModel = bx.loadSabModel(URI.createFileURI(baseModelPath));
		System.out.println("*****************baseModel: ");
		print(baseModel);
		
	}
	
	@SuppressWarnings("unchecked")
	static public void test(String MetamodelPath, String baseModelPath,String aModelPath, String bModelPath, String mergeModelPath) throws Exception {
		InsAddressBook bx = new InsAddressBook();
		bx.registerSabPackage(URI.createFileURI(MetamodelPath));
		
		TypedGraph baseModel = bx.loadSabModel(URI.createFileURI(baseModelPath));
		
		TypedGraph aModel = baseModel.getCopy();
		TypedGraph bModel = baseModel.getCopy();
		
		aModelChange(aModel);
		bModelChange(bModel);
		
		bx.saveSabModel(URI.createFileURI(aModelPath), aModel);
		bx.saveSabModel(URI.createFileURI(bModelPath), bModel);
		
		TypedGraph mergeModel = BXMerge.merge(baseModel, aModel, bModel);
		bx.saveSabModel(URI.createFileURI(mergeModelPath), mergeModel);
		
	}
	
	private static void aModelChange(TypedGraph aModel) {
		
		// ɾ��TypedNode�ڵ�
		TypedNode n1 = aModel.getAllTypedNodes().get(1);
		aModel.remove(n1);
		
		System.out.println("*****************aModel: ");
		print(aModel);
		
	}
	
	private static void bModelChange(TypedGraph bModel) {
		
		// ����TypedNode�ڵ㣬����ΪPerson
		TypeNode typePerson = bModel.getTypeGraph().getTypeNode("Person");
		TypedNode n4 = new TypedNode();
		n4.setType(typePerson);
		bModel.addTypedNode(n4);
		
		// ����TypedEdge�ߣ�����ΪAddressBook-Person
		TypeEdge typeTypedEdge = bModel.getAllTypedEdges().get(0).getType();
		TypedNode n0 = bModel.getAllTypedNodes().get(0);
		TypedEdge e2 = new TypedEdge();
		e2.setType(typeTypedEdge);
		e2.setSource(n0);
		e2.setTarget(n4);
		bModel.addTypedEdge(e2);
		
		// ����ValueNode�ڵ�
		ValueNode nv0 = bModel.getAllValueNodes().get(0);
		ValueNode nv6 = nv0.createConstantNode("Lisa", nv0.getType());
		bModel.addValueNode(nv6);
		
		// ����ValueEdge��
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
